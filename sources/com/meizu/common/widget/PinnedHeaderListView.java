package com.meizu.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;

public class PinnedHeaderListView extends AutoScrollListView implements AbsListView.OnScrollListener, AdapterView.OnItemSelectedListener {
    private static final int BOTTOM = 1;
    private static final int DEFAULT_ANIMATION_DURATION = 20;
    private static final int FADING = 2;
    private static final int MAX_ALPHA = 255;
    private static final int TOP = 0;
    private PinnedHeaderAdapter mAdapter;
    private boolean mAnimating;
    private int mAnimationDuration;
    private long mAnimationTargetTime;
    private RectF mBounds;
    private Rect mClipRect;
    private Drawable mHeaderBackground;
    private int mHeaderPaddingLeft;
    private int mHeaderPaddingTop;
    private int mHeaderWidth;
    private PinnedHeader[] mHeaders;
    private AdapterView.OnItemSelectedListener mOnItemSelectedListener;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mScrollState;
    private int mSize;

    public static final class PinnedHeader {
        int alpha;
        boolean animating;
        int height;
        int sourceY;
        int state;
        long targetTime;
        boolean targetVisible;
        int targetY;
        View view;
        boolean visible;
        int y;

        private PinnedHeader() {
        }
    }

    public interface PinnedHeaderAdapter {
        void configurePinnedHeaders(PinnedHeaderListView pinnedHeaderListView);

        int getPinnedHeaderCount();

        View getPinnedHeaderView(int i, View view, ViewGroup viewGroup);

        int getScrollPositionForHeader(int i);
    }

    public PinnedHeaderListView(Context context) {
        this(context, (AttributeSet) null, 16842868);
    }

    private void drawHeader(Canvas canvas, PinnedHeader pinnedHeader, long j) {
        if (pinnedHeader.animating) {
            int i = (int) (pinnedHeader.targetTime - j);
            if (i <= 0) {
                pinnedHeader.y = pinnedHeader.targetY;
                pinnedHeader.visible = pinnedHeader.targetVisible;
                pinnedHeader.animating = false;
            } else {
                int i2 = pinnedHeader.targetY;
                pinnedHeader.y = i2 + (((pinnedHeader.sourceY - i2) * i) / this.mAnimationDuration);
            }
        }
        if (pinnedHeader.visible) {
            View view = pinnedHeader.view;
            int save = canvas.save();
            int i3 = pinnedHeader.state;
            if (i3 == 0 || i3 == 2) {
                canvas.translate((float) this.mHeaderPaddingLeft, (float) (pinnedHeader.y + this.mHeaderPaddingTop));
            } else {
                canvas.translate((float) this.mHeaderPaddingLeft, (float) pinnedHeader.y);
            }
            if (pinnedHeader.state == 2) {
                this.mBounds.set(0.0f, 0.0f, (float) this.mHeaderWidth, (float) view.getHeight());
                canvas.saveLayerAlpha(this.mBounds, pinnedHeader.alpha, 31);
            }
            view.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002d, code lost:
        r3 = r3.height;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void ensurePinnedHeaderLayout(int r6) {
        /*
            r5 = this;
            com.meizu.common.widget.PinnedHeaderListView$PinnedHeader[] r0 = r5.mHeaders
            r0 = r0[r6]
            android.view.View r0 = r0.view
            if (r0 != 0) goto L_0x0009
            return
        L_0x0009:
            boolean r1 = r0.isLayoutRequested()
            if (r1 == 0) goto L_0x004c
            int r1 = r5.mHeaderWidth
            if (r1 != 0) goto L_0x001e
            int r1 = r5.getRight()
            int r2 = r5.getLeft()
            int r1 = r1 - r2
            r5.mHeaderWidth = r1
        L_0x001e:
            int r1 = r5.mHeaderWidth
            r2 = 1073741824(0x40000000, float:2.0)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r2)
            android.view.ViewGroup$LayoutParams r3 = r0.getLayoutParams()
            r4 = 0
            if (r3 == 0) goto L_0x0036
            int r3 = r3.height
            if (r3 <= 0) goto L_0x0036
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r2)
            goto L_0x003a
        L_0x0036:
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r4)
        L_0x003a:
            r0.measure(r1, r2)
            int r1 = r0.getMeasuredHeight()
            com.meizu.common.widget.PinnedHeaderListView$PinnedHeader[] r2 = r5.mHeaders
            r6 = r2[r6]
            r6.height = r1
            int r5 = r5.mHeaderWidth
            r0.layout(r4, r4, r5, r1)
        L_0x004c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.PinnedHeaderListView.ensurePinnedHeaderLayout(int):void");
    }

    private void invalidateIfAnimating() {
        this.mAnimating = false;
        for (int i = 0; i < this.mSize; i++) {
            if (this.mHeaders[i].animating) {
                this.mAnimating = true;
                invalidate();
                return;
            }
        }
    }

    private boolean smoothScrollToPartition(int i) {
        int scrollPositionForHeader = this.mAdapter.getScrollPositionForHeader(i);
        if (scrollPositionForHeader == -1) {
            return false;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            PinnedHeader pinnedHeader = this.mHeaders[i3];
            if (pinnedHeader.visible) {
                i2 += pinnedHeader.height;
            }
        }
        smoothScrollToPositionFromTop(scrollPositionForHeader + getHeaderViewsCount(), i2);
        return true;
    }

    public void dispatchDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        long currentTimeMillis = this.mAnimating ? System.currentTimeMillis() : 0;
        int bottom = getBottom();
        boolean z = false;
        int i4 = 0;
        for (int i5 = 0; i5 < this.mSize; i5++) {
            PinnedHeader pinnedHeader = this.mHeaders[i5];
            if (pinnedHeader.visible) {
                int i6 = pinnedHeader.state;
                if (i6 != 1 || (i3 = pinnedHeader.y) >= bottom) {
                    if ((i6 == 0 || i6 == 2) && (i2 = pinnedHeader.y + pinnedHeader.height) > i4) {
                        i4 = i2;
                    }
                    z = true;
                } else {
                    z = true;
                    bottom = i3;
                }
            }
        }
        if (z) {
            canvas.save();
            this.mClipRect.set(0, 0, getWidth(), bottom);
            canvas.clipRect(this.mClipRect);
        }
        super.dispatchDraw(canvas);
        if (z) {
            canvas.restore();
            int i7 = this.mSize;
            while (true) {
                i7--;
                if (i7 < 0) {
                    break;
                }
                PinnedHeader pinnedHeader2 = this.mHeaders[i7];
                if (pinnedHeader2.visible && ((i = pinnedHeader2.state) == 0 || i == 2)) {
                    drawHeader(canvas, pinnedHeader2, currentTimeMillis);
                }
            }
            for (int i8 = 0; i8 < this.mSize; i8++) {
                PinnedHeader pinnedHeader3 = this.mHeaders[i8];
                if (pinnedHeader3.visible && pinnedHeader3.state == 1) {
                    drawHeader(canvas, pinnedHeader3, currentTimeMillis);
                }
            }
        }
        invalidateIfAnimating();
    }

    public int getCurrentOverScrollDistance() {
        if (getFirstVisiblePosition() != 0 || getChildCount() <= 0) {
            return 0;
        }
        return getPaddingTop() - getChildAt(0).getTop();
    }

    public int getHeaderPaddingTop() {
        return this.mHeaderPaddingTop;
    }

    public int getPinnedHeaderHeight(int i) {
        ensurePinnedHeaderLayout(i);
        View view = this.mHeaders[i].view;
        if (view == null) {
            return 0;
        }
        return view.getHeight();
    }

    public int getPositionAt(int i) {
        int childCount = getChildCount();
        if (childCount > 0) {
            if (isStackFromBottom()) {
                for (int i2 = childCount - 1; i2 >= 0; i2--) {
                    if (i >= getChildAt(i2).getTop()) {
                        return getFirstVisiblePosition() + i2;
                    }
                }
            } else {
                for (int i3 = 0; i3 < childCount; i3++) {
                    if (i <= getChildAt(i3).getBottom()) {
                        return getFirstVisiblePosition() + i3;
                    }
                }
            }
        }
        return 0;
    }

    public float getTopFadingEdgeStrength() {
        if (this.mSize > 0) {
            return 0.0f;
        }
        return super.getTopFadingEdgeStrength();
    }

    public int getTotalTopPinnedHeaderHeight() {
        int i = this.mSize;
        while (true) {
            i--;
            if (i < 0) {
                return 0;
            }
            PinnedHeader pinnedHeader = this.mHeaders[i];
            if (pinnedHeader.visible && pinnedHeader.state == 0) {
                return pinnedHeader.y + pinnedHeader.height;
            }
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(PinnedHeaderListView.class.getName());
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        int height = getHeight();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= this.mSize) {
                break;
            }
            PinnedHeader pinnedHeader = this.mHeaders[i2];
            if (pinnedHeader.visible) {
                int i4 = pinnedHeader.state;
                if (i4 == 0) {
                    i3 = pinnedHeader.y + pinnedHeader.height;
                } else if (i4 == 1) {
                    height = pinnedHeader.y;
                    break;
                }
            }
            i2++;
        }
        View selectedView = getSelectedView();
        if (selectedView != null) {
            if (selectedView.getTop() < i3) {
                setSelectionFromTop(i, i3);
            } else if (selectedView.getBottom() > height) {
                setSelectionFromTop(i, height - selectedView.getHeight());
            }
        }
        AdapterView.OnItemSelectedListener onItemSelectedListener = this.mOnItemSelectedListener;
        if (onItemSelectedListener != null) {
            onItemSelectedListener.onItemSelected(adapterView, view, i, j);
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mHeaderPaddingLeft = 0;
        this.mHeaderWidth = i3 - i;
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
        AdapterView.OnItemSelectedListener onItemSelectedListener = this.mOnItemSelectedListener;
        if (onItemSelectedListener != null) {
            onItemSelectedListener.onNothingSelected(adapterView);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        View view;
        PinnedHeaderAdapter pinnedHeaderAdapter = this.mAdapter;
        if (pinnedHeaderAdapter != null) {
            int pinnedHeaderCount = pinnedHeaderAdapter.getPinnedHeaderCount();
            if (pinnedHeaderCount != this.mSize) {
                this.mSize = pinnedHeaderCount;
                PinnedHeader[] pinnedHeaderArr = this.mHeaders;
                if (pinnedHeaderArr == null) {
                    this.mHeaders = new PinnedHeader[pinnedHeaderCount];
                } else if (pinnedHeaderArr.length < pinnedHeaderCount) {
                    PinnedHeader[] pinnedHeaderArr2 = new PinnedHeader[pinnedHeaderCount];
                    this.mHeaders = pinnedHeaderArr2;
                    System.arraycopy(pinnedHeaderArr, 0, pinnedHeaderArr2, 0, pinnedHeaderArr.length);
                }
            }
            for (int i4 = 0; i4 < this.mSize; i4++) {
                PinnedHeader[] pinnedHeaderArr3 = this.mHeaders;
                if (pinnedHeaderArr3[i4] == null) {
                    pinnedHeaderArr3[i4] = new PinnedHeader();
                }
                PinnedHeader pinnedHeader = this.mHeaders[i4];
                pinnedHeader.view = this.mAdapter.getPinnedHeaderView(i4, pinnedHeader.view, this);
                Drawable drawable = this.mHeaderBackground;
                if (!(drawable == null || (view = this.mHeaders[i4].view) == null)) {
                    view.setBackground(drawable);
                }
            }
            this.mAnimationTargetTime = System.currentTimeMillis() + ((long) this.mAnimationDuration);
            this.mAdapter.configurePinnedHeaders(this);
            invalidateIfAnimating();
        }
        AbsListView.OnScrollListener onScrollListener = this.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScroll(this, i, i2, i3);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        this.mScrollState = i;
        AbsListView.OnScrollListener onScrollListener = this.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(this, i);
        }
    }

    public void setFadingHeader(int i, int i2, boolean z) {
        ensurePinnedHeaderLayout(i);
        if (getChildAt(i2 - getFirstVisiblePosition()) != null) {
            PinnedHeader pinnedHeader = this.mHeaders[i];
            pinnedHeader.visible = true;
            pinnedHeader.state = 2;
            pinnedHeader.alpha = 255;
            pinnedHeader.animating = false;
            pinnedHeader.y = getTotalTopPinnedHeaderHeight();
        }
    }

    public void setHeaderBackground(Drawable drawable) {
        Drawable drawable2;
        if (drawable != null && drawable != (drawable2 = this.mHeaderBackground)) {
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
                unscheduleDrawable(this.mHeaderBackground);
            }
            this.mHeaderBackground = drawable;
            drawable.setCallback(this);
            requestLayout();
            invalidate();
        }
    }

    public void setHeaderInvisible(int i, boolean z) {
        PinnedHeader pinnedHeader = this.mHeaders[i];
        if (!pinnedHeader.visible || ((!z && !pinnedHeader.animating) || pinnedHeader.state != 1)) {
            pinnedHeader.visible = false;
            return;
        }
        pinnedHeader.sourceY = pinnedHeader.y;
        if (!pinnedHeader.animating) {
            pinnedHeader.visible = true;
            pinnedHeader.targetY = getBottom() + pinnedHeader.height;
        }
        pinnedHeader.animating = true;
        pinnedHeader.targetTime = this.mAnimationTargetTime;
        pinnedHeader.targetVisible = false;
    }

    public void setHeaderPaddingTop(int i) {
        if (i >= 0) {
            this.mHeaderPaddingTop = i;
        }
    }

    public void setHeaderPinnedAtBottom(int i, int i2, boolean z) {
        int i3;
        ensurePinnedHeaderLayout(i);
        PinnedHeader pinnedHeader = this.mHeaders[i];
        pinnedHeader.state = 1;
        if (pinnedHeader.animating) {
            pinnedHeader.targetTime = this.mAnimationTargetTime;
            pinnedHeader.sourceY = pinnedHeader.y;
            pinnedHeader.targetY = i2;
        } else if (!z || ((i3 = pinnedHeader.y) == i2 && pinnedHeader.visible)) {
            pinnedHeader.visible = true;
            pinnedHeader.y = i2;
        } else {
            if (pinnedHeader.visible) {
                pinnedHeader.sourceY = i3;
            } else {
                pinnedHeader.visible = true;
                pinnedHeader.sourceY = pinnedHeader.height + i2;
            }
            pinnedHeader.animating = true;
            pinnedHeader.targetVisible = true;
            pinnedHeader.targetTime = this.mAnimationTargetTime;
            pinnedHeader.targetY = i2;
        }
    }

    public void setHeaderPinnedAtTop(int i, int i2, boolean z) {
        ensurePinnedHeaderLayout(i);
        PinnedHeader pinnedHeader = this.mHeaders[i];
        pinnedHeader.visible = true;
        pinnedHeader.y = i2;
        pinnedHeader.state = 0;
        pinnedHeader.animating = false;
    }

    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.mOnItemSelectedListener = onItemSelectedListener;
        super.setOnItemSelectedListener(this);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.mOnScrollListener = onScrollListener;
        super.setOnScrollListener(this);
    }

    public void setPinnedHeaderAnimationDuration(int i) {
        this.mAnimationDuration = i;
    }

    public void setSelection(int i) {
        PinnedHeaderAdapter pinnedHeaderAdapter = this.mAdapter;
        if (pinnedHeaderAdapter instanceof PinnedHeaderIndexerListAdapter) {
            PinnedHeaderIndexerListAdapter pinnedHeaderIndexerListAdapter = (PinnedHeaderIndexerListAdapter) pinnedHeaderAdapter;
            if (!pinnedHeaderIndexerListAdapter.getItemPlacementInSection(i - getHeaderViewsCount()).firstInSection && pinnedHeaderIndexerListAdapter.isSectionHeaderDisplayEnabled() && this.mSize > 0) {
                if (pinnedHeaderIndexerListAdapter.getPinnedPartitionHeadersEnabled()) {
                    super.setSelectionFromTop(i, getPinnedHeaderHeight(1));
                    return;
                } else {
                    super.setSelectionFromTop(i, 0);
                    return;
                }
            }
        }
        super.setSelection(i);
    }

    public void setTranslateHeader(int i, int i2) {
        ensurePinnedHeaderLayout(i);
        PinnedHeader pinnedHeader = this.mHeaders[i];
        pinnedHeader.visible = true;
        pinnedHeader.state = 2;
        pinnedHeader.alpha = 255;
        pinnedHeader.animating = false;
        pinnedHeader.y = getTotalTopPinnedHeaderHeight() + i2;
    }

    public PinnedHeaderListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public void setAdapter(ListAdapter listAdapter) {
        this.mAdapter = (PinnedHeaderAdapter) listAdapter;
        super.setAdapter(listAdapter);
    }

    public PinnedHeaderListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBounds = new RectF();
        this.mClipRect = new Rect();
        this.mAnimationDuration = 20;
        this.mHeaderBackground = null;
        super.setOnScrollListener(this);
        super.setOnItemSelectedListener(this);
    }
}
