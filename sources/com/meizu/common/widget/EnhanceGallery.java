package com.meizu.common.widget;

import android.content.ClipData;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.LongSparseArray;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.DragEvent;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.widget.Checkable;
import android.widget.SpinnerAdapter;
import com.meizu.common.R;
import com.meizu.common.widget.AdapterView;

public class EnhanceGallery extends AbsSpinner implements GestureDetector.OnGestureListener {
    private static final int CHECK_POSITION_SEARCH_DISTANCE = 20;
    public static final int CHOICE_MODE_MULTIPLE = 2;
    public static final int CHOICE_MODE_NONE = 0;
    public static final int CHOICE_MODE_SINGLE = 1;
    private static final int MIN_FLING_VELOCITY = 1500;
    private static final int SCROLL_TO_FLING_UNCERTAINTY_TIMEOUT = 250;
    static final int TOUCH_MODE_DOWN = 0;
    static final int TOUCH_MODE_FLING = 2;
    static final int TOUCH_MODE_OVERFLING = 4;
    static final int TOUCH_MODE_OVERSCROLL = 3;
    static final int TOUCH_MODE_REST = -1;
    static final int TOUCH_MODE_SCROLL = 1;
    private boolean mAccDelegateStates;
    private SpinnerItemAccessibilityDelegate mAccessibilityDelegate;
    /* access modifiers changed from: private */
    public int mAnimationDuration;
    /* access modifiers changed from: private */
    public boolean mChangeChildAlphaWhenDragView;
    private SparseBooleanArray mCheckStates;
    LongSparseArray<Integer> mCheckedIdStates;
    private int mCheckedItemCount;
    private int mChildWidth;
    /* access modifiers changed from: private */
    public ActionMode mChoiceActionMode;
    /* access modifiers changed from: private */
    public int mChoiceMode;
    private AdapterContextMenuInfo mContextMenuInfo;
    /* access modifiers changed from: private */
    public int mCurrentOverScrollDistance;
    private int mDefaultMaxOverScrollDistance;
    private int mDeltaLength;
    private Runnable mDisableSuppressSelectionChangedRunnable;
    private int mDownFirstPosition;
    private int mDownLastPosition;
    private int mDownTouchPosition;
    private View mDownTouchView;
    protected int mDragAndDropPosition;
    private boolean mDragEnable;
    /* access modifiers changed from: private */
    public int mDragOffsetX;
    /* access modifiers changed from: private */
    public int mDragOffsetY;
    /* access modifiers changed from: private */
    public int mDragScrollY;
    /* access modifiers changed from: private */
    public int mDragViewBackground;
    /* access modifiers changed from: private */
    public int mDragViewBackgroundDelete;
    /* access modifiers changed from: private */
    public int mDragViewBackgroundFilter;
    /* access modifiers changed from: private */
    public FlingRunnable mFlingRunnable;
    private GestureDetector mGestureDetector;
    private int mGravity;
    private boolean mIsFirstScroll;
    /* access modifiers changed from: private */
    public boolean mIsRtl;
    /* access modifiers changed from: private */
    public int mLastScrollState;
    private int mMaxOverScrollDistance;
    int mMotionX;
    int mMotionY;
    MultiChoiceModeWrapper mMultiChoiceModeCallback;
    private OnScrollListener mOnScrollListener;
    private PerformClick mPerformClick;
    private boolean mScrollEnableWhenLessContent;
    private View mSelectedChild;
    private ListViewDragShadowBuilder mShadowBuilder;
    private boolean mShouldCallbackDuringFling;
    private boolean mShouldCallbackOnUnselectedItemClick;
    /* access modifiers changed from: private */
    public boolean mShouldStopFling;
    private int mSpacing;
    /* access modifiers changed from: private */
    public boolean mSuppressSelectionChanged;
    private Rect mTouchFrame;
    /* access modifiers changed from: private */
    public int mTouchMode;

    public static class AdapterContextMenuInfo implements ContextMenu.ContextMenuInfo {
        public long id;
        public int position;
        public View targetView;

        public AdapterContextMenuInfo(View view, int i, long j) {
            this.targetView = view;
            this.position = i;
            this.id = j;
        }
    }

    public interface DragShadowItem {
        View getDragView();

        Point getDragViewShowPosition();

        boolean needBackground();
    }

    public class FlingRunnable implements Runnable {
        private int mLastDelta;
        private int mLastFlingX;
        private int mLastOverFlingX = 0;
        private OverScroller mScroller;

        public FlingRunnable() {
            OverScroller overScroller = new OverScroller(EnhanceGallery.this.getContext());
            this.mScroller = overScroller;
            overScroller.setEnableMZOverScroll(true, true);
        }

        private void endFling(boolean z) {
            this.mScroller.forceFinished(true);
            if (z) {
                EnhanceGallery.this.scrollIntoSlots();
            } else {
                EnhanceGallery.this.reportScrollStateChange(0);
            }
        }

        private void startCommon() {
            EnhanceGallery.this.removeCallbacks(this);
        }

        public void run() {
            EnhanceGallery enhanceGallery = EnhanceGallery.this;
            if (enhanceGallery.mItemCount == 0) {
                endFling(true);
                return;
            }
            OverScroller overScroller = this.mScroller;
            int access$200 = enhanceGallery.mTouchMode;
            if (access$200 == 1 || access$200 == 2) {
                boolean unused = EnhanceGallery.this.mShouldStopFling = false;
                boolean computeScrollOffset = overScroller.computeScrollOffset();
                int currX = overScroller.getCurrX();
                int i = this.mLastFlingX - currX;
                boolean trackMotionScroll = EnhanceGallery.this.trackMotionScroll(i);
                if (computeScrollOffset && !EnhanceGallery.this.mShouldStopFling && !trackMotionScroll) {
                    this.mLastFlingX = currX;
                    this.mLastDelta = i;
                    EnhanceGallery.this.post(this);
                } else if (!computeScrollOffset || EnhanceGallery.this.mShouldStopFling || !trackMotionScroll) {
                    endFling(true);
                } else {
                    endFling(false);
                    if (EnhanceGallery.this.mTouchMode == 2) {
                        int unused2 = EnhanceGallery.this.mTouchMode = 4;
                    } else {
                        int unused3 = EnhanceGallery.this.mTouchMode = 3;
                    }
                    if (EnhanceGallery.this.mLastScrollState != 2) {
                        EnhanceGallery.this.reportScrollStateChange(2);
                    }
                    startSpringback();
                }
            } else if (access$200 != 3 && access$200 != 4) {
                int unused4 = EnhanceGallery.this.mTouchMode = -1;
                if (EnhanceGallery.this.mLastScrollState != 0) {
                    EnhanceGallery.this.reportScrollStateChange(0);
                }
            } else if (overScroller.computeScrollOffset()) {
                int currX2 = overScroller.getCurrX();
                int i2 = currX2 - this.mLastOverFlingX;
                this.mLastOverFlingX = currX2;
                if (i2 != 0) {
                    EnhanceGallery.this.trackMotionScroll(-i2);
                }
                EnhanceGallery.this.invalidate();
                EnhanceGallery.this.postOnAnimation(this);
            } else {
                endFling(false);
                int unused5 = EnhanceGallery.this.mTouchMode = -1;
            }
        }

        public void startSpringback() {
            if (this.mScroller.springBack(EnhanceGallery.this.mCurrentOverScrollDistance, 0, 0, 0, 0, 0)) {
                int unused = EnhanceGallery.this.mTouchMode = 4;
                this.mLastOverFlingX = EnhanceGallery.this.mCurrentOverScrollDistance;
                EnhanceGallery.this.invalidate();
                EnhanceGallery.this.postOnAnimation(this);
                return;
            }
            int unused2 = EnhanceGallery.this.mTouchMode = -1;
        }

        public void startUsingDistance(int i) {
            if (i != 0) {
                int unused = EnhanceGallery.this.mTouchMode = 2;
                startCommon();
                this.mLastFlingX = 0;
                this.mScroller.setInterpolator(new DecelerateInterpolator());
                this.mScroller.startScroll(0, 0, -i, 0, EnhanceGallery.this.mAnimationDuration);
                EnhanceGallery.this.postOnAnimation(this);
            }
        }

        public void stop(boolean z) {
            EnhanceGallery.this.removeCallbacks(this);
            endFling(z);
        }
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public class ListViewDragShadowBuilder extends View.DragShadowBuilder {
        private static final int STATE_ENTER_NORMAL = 0;
        private static final int STATE_ENTER_WARNING = 1;
        private static final int STATE_IDLE = -1;
        private Drawable mBackground;
        private Rect mBackgroundPadding;
        private int mHeight;
        private Drawable mHightLightNormal;
        private Drawable mHightLightWarning;
        private boolean mNeedBackground;
        private Point mShowPoint;
        private int mState;
        private int mWidth;

        public ListViewDragShadowBuilder(EnhanceGallery enhanceGallery, View view) {
            this(view, true, (Point) null);
        }

        public int getDragingState() {
            return this.mState;
        }

        public void onDrawShadow(Canvas canvas) {
            if (this.mNeedBackground) {
                int i = this.mState;
                if (i == 0) {
                    this.mHightLightNormal.draw(canvas);
                } else if (i == 1) {
                    this.mHightLightWarning.draw(canvas);
                } else {
                    this.mBackground.draw(canvas);
                }
                canvas.save();
                Rect rect = this.mBackgroundPadding;
                canvas.translate((float) rect.left, (float) (rect.top - EnhanceGallery.this.mDragScrollY));
                super.onDrawShadow(canvas);
                canvas.restore();
            } else if (EnhanceGallery.this.mDragScrollY != 0) {
                canvas.save();
                canvas.translate(0.0f, (float) (-EnhanceGallery.this.mDragScrollY));
                super.onDrawShadow(canvas);
                canvas.restore();
            } else {
                super.onDrawShadow(canvas);
            }
        }

        public void onProvideShadowMetrics(Point point, Point point2) {
            super.onProvideShadowMetrics(point, point2);
            point.set(this.mWidth, this.mHeight);
            if (this.mNeedBackground) {
                point2.set(EnhanceGallery.this.mDragOffsetX + this.mBackgroundPadding.left, (EnhanceGallery.this.mDragOffsetY + this.mBackgroundPadding.top) - EnhanceGallery.this.mDragScrollY);
            } else {
                point2.set(EnhanceGallery.this.mDragOffsetX, EnhanceGallery.this.mDragOffsetY - EnhanceGallery.this.mDragScrollY);
            }
        }

        public void setDragingState(int i) {
            this.mState = i;
        }

        public ListViewDragShadowBuilder(View view, boolean z, Point point) {
            super(view);
            this.mState = -1;
            this.mNeedBackground = z;
            this.mShowPoint = point;
            if (view != null) {
                if (z) {
                    this.mBackground = EnhanceGallery.this.getResources().getDrawable(EnhanceGallery.this.mDragViewBackground);
                    Rect rect = new Rect();
                    this.mBackgroundPadding = rect;
                    this.mBackground.getPadding(rect);
                    Rect rect2 = this.mBackgroundPadding;
                    int width = view.getWidth();
                    int height = view.getHeight();
                    int i = width + rect2.left + rect2.right;
                    this.mWidth = i;
                    int i2 = height + rect2.top + rect2.bottom;
                    this.mHeight = i2;
                    this.mBackground.setBounds(0, 0, i, i2);
                    Drawable drawable = EnhanceGallery.this.getResources().getDrawable(EnhanceGallery.this.mDragViewBackgroundFilter);
                    this.mHightLightNormal = drawable;
                    drawable.setBounds(0, 0, this.mWidth, this.mHeight);
                    Drawable drawable2 = EnhanceGallery.this.getResources().getDrawable(EnhanceGallery.this.mDragViewBackgroundDelete);
                    this.mHightLightWarning = drawable2;
                    drawable2.setBounds(0, 0, this.mWidth, this.mHeight);
                } else {
                    this.mWidth = view.getWidth();
                    this.mHeight = view.getHeight();
                }
                int unused = EnhanceGallery.this.mDragScrollY = 0;
                if (this.mHeight > EnhanceGallery.this.getHeight()) {
                    int[] iArr = new int[2];
                    EnhanceGallery.this.getLocationOnScreen(iArr);
                    int[] iArr2 = new int[2];
                    view.getLocationOnScreen(iArr2);
                    int i3 = iArr2[1];
                    int i4 = iArr[1];
                    if (i3 < i4) {
                        int unused2 = EnhanceGallery.this.mDragScrollY = i4 - i3;
                        int unused3 = EnhanceGallery.this.mDragScrollY = Math.min(this.mHeight - EnhanceGallery.this.getHeight(), EnhanceGallery.this.mDragScrollY);
                    }
                    this.mHeight = EnhanceGallery.this.getHeight();
                }
            }
        }
    }

    public interface MultiChoiceModeListener extends ActionMode.Callback {
        void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z);
    }

    public class MultiChoiceModeWrapper implements MultiChoiceModeListener {
        private MultiChoiceModeListener mWrapped;

        public MultiChoiceModeWrapper() {
        }

        public boolean hasWrappedCallback() {
            return this.mWrapped != null;
        }

        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.mWrapped.onActionItemClicked(actionMode, menuItem);
        }

        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            if (!this.mWrapped.onCreateActionMode(actionMode, menu)) {
                return false;
            }
            if (EnhanceGallery.this.mChoiceMode == 2) {
                EnhanceGallery.this.setLongClickable(true);
            } else {
                EnhanceGallery.this.setLongClickable(false);
            }
            return true;
        }

        public void onDestroyActionMode(ActionMode actionMode) {
            this.mWrapped.onDestroyActionMode(actionMode);
            ActionMode unused = EnhanceGallery.this.mChoiceActionMode = null;
            EnhanceGallery.this.clearChoices();
            EnhanceGallery.this.invalidateViews();
            EnhanceGallery.this.setLongClickable(true);
        }

        public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
            this.mWrapped.onItemCheckedStateChanged(actionMode, i, j, z);
            if (EnhanceGallery.this.getCheckedItemCount() == 0) {
                actionMode.finish();
            }
        }

        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return this.mWrapped.onPrepareActionMode(actionMode, menu);
        }

        public void setWrapped(MultiChoiceModeListener multiChoiceModeListener) {
            this.mWrapped = multiChoiceModeListener;
        }
    }

    public interface OnScrollListener {
        public static final int SCROLL_STATE_FLING = 2;
        public static final int SCROLL_STATE_IDLE = 0;
        public static final int SCROLL_STATE_TOUCH_SCROLL = 1;

        void onScroll(EnhanceGallery enhanceGallery, int i, int i2, int i3);

        void onScrollStateChanged(EnhanceGallery enhanceGallery, int i);
    }

    public class PerformClick extends WindowRunnnable implements Runnable {
        int mClickMotionPosition;

        private PerformClick() {
            super();
        }

        public void run() {
            EnhanceGallery enhanceGallery = EnhanceGallery.this;
            if (!enhanceGallery.mDataChanged) {
                SpinnerAdapter adapter = enhanceGallery.getAdapter();
                int i = this.mClickMotionPosition;
                if (adapter != null && EnhanceGallery.this.mItemCount > 0 && i != -1 && i < adapter.getCount() && sameWindow()) {
                    EnhanceGallery enhanceGallery2 = EnhanceGallery.this;
                    View childAt = enhanceGallery2.getChildAt(i - enhanceGallery2.mFirstPosition);
                    if (childAt != null) {
                        EnhanceGallery.this.performItemClicks(childAt, i, adapter.getItemId(i));
                    }
                }
            }
        }
    }

    public class SpinnerItemAccessibilityDelegate extends View.AccessibilityDelegate {
        public SpinnerItemAccessibilityDelegate() {
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            EnhanceGallery.this.onInitializeAccessibilityNodeInfoForItem(view, EnhanceGallery.this.getPositionForView(view), accessibilityNodeInfo);
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return super.performAccessibilityAction(view, i, bundle);
        }
    }

    public class WindowRunnnable {
        private int mOriginalAttachCount;

        private WindowRunnnable() {
        }

        public void rememberWindowAttachCount() {
            this.mOriginalAttachCount = EnhanceGallery.this.getWindowAttachCount();
        }

        public boolean sameWindow() {
            return EnhanceGallery.this.hasWindowFocus() && EnhanceGallery.this.getWindowAttachCount() == this.mOriginalAttachCount;
        }
    }

    public EnhanceGallery(Context context) {
        this(context, (AttributeSet) null);
    }

    private int calculateTop(View view, boolean z) {
        int measuredHeight = z ? getMeasuredHeight() : getHeight();
        int measuredHeight2 = z ? view.getMeasuredHeight() : view.getHeight();
        int i = this.mGravity;
        if (i == 16) {
            Rect rect = this.mSpinnerPadding;
            int i2 = rect.top;
            return i2 + ((((measuredHeight - rect.bottom) - i2) - measuredHeight2) / 2);
        } else if (i == 48) {
            return this.mSpinnerPadding.top;
        } else {
            if (i != 80) {
                return 0;
            }
            return (measuredHeight - this.mSpinnerPadding.bottom) - measuredHeight2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004e, code lost:
        if (r11.mIsRtl == false) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x009f, code lost:
        if (r11.mIsRtl != false) goto L_0x00a3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void detachOffScreenChildren(boolean r12) {
        /*
            r11 = this;
            int r0 = r11.getChildCount()
            int r1 = r11.mFirstPosition
            r2 = 1
            r3 = 0
            if (r12 == 0) goto L_0x0051
            boolean r4 = r11.mIsRtl
            if (r4 == 0) goto L_0x0013
            int r4 = r11.getPaddingLeft()
            goto L_0x001a
        L_0x0013:
            int r4 = r11.getPaddingLeft()
            int r5 = r11.mSpacing
            int r4 = r4 + r5
        L_0x001a:
            r5 = r3
            r6 = r5
            r7 = r6
        L_0x001d:
            int r8 = r0 + -1
            if (r5 >= r8) goto L_0x004c
            boolean r9 = r11.mIsRtl
            if (r9 == 0) goto L_0x0027
            int r8 = r8 - r5
            goto L_0x0028
        L_0x0027:
            r8 = r5
        L_0x0028:
            if (r9 == 0) goto L_0x0031
            int r9 = r8 + -1
        L_0x002c:
            android.view.View r9 = r11.getChildAt(r9)
            goto L_0x0034
        L_0x0031:
            int r9 = r8 + 1
            goto L_0x002c
        L_0x0034:
            int r9 = r9.getLeft()
            if (r9 <= r4) goto L_0x003b
            goto L_0x004c
        L_0x003b:
            int r6 = r6 + 1
            android.view.View r7 = r11.getChildAt(r8)
            com.meizu.common.widget.AbsSpinner$RecycleBin r9 = r11.mRecycler
            int r10 = r1 + r8
            r9.put(r10, r7)
            int r5 = r5 + 1
            r7 = r8
            goto L_0x001d
        L_0x004c:
            boolean r0 = r11.mIsRtl
            if (r0 != 0) goto L_0x00a2
            goto L_0x00a3
        L_0x0051:
            boolean r4 = r11.mIsRtl
            if (r4 == 0) goto L_0x0062
            int r4 = r11.getWidth()
            int r5 = r11.getPaddingRight()
            int r4 = r4 - r5
            int r5 = r11.mSpacing
        L_0x0060:
            int r4 = r4 - r5
            goto L_0x006b
        L_0x0062:
            int r4 = r11.getWidth()
            int r5 = r11.getPaddingRight()
            goto L_0x0060
        L_0x006b:
            int r0 = r0 - r2
            r5 = r0
            r6 = r3
            r7 = r6
        L_0x006f:
            if (r5 < r2) goto L_0x009d
            boolean r8 = r11.mIsRtl
            if (r8 == 0) goto L_0x0078
            int r9 = r0 - r5
            goto L_0x0079
        L_0x0078:
            r9 = r5
        L_0x0079:
            if (r8 == 0) goto L_0x0082
            int r8 = r9 + 1
        L_0x007d:
            android.view.View r8 = r11.getChildAt(r8)
            goto L_0x0085
        L_0x0082:
            int r8 = r9 + -1
            goto L_0x007d
        L_0x0085:
            int r8 = r8.getRight()
            if (r8 >= r4) goto L_0x008c
            goto L_0x009d
        L_0x008c:
            int r6 = r6 + 1
            android.view.View r7 = r11.getChildAt(r9)
            com.meizu.common.widget.AbsSpinner$RecycleBin r8 = r11.mRecycler
            int r10 = r1 + r9
            r8.put(r10, r7)
            int r5 = r5 + -1
            r7 = r9
            goto L_0x006f
        L_0x009d:
            boolean r0 = r11.mIsRtl
            if (r0 == 0) goto L_0x00a2
            goto L_0x00a3
        L_0x00a2:
            r3 = r7
        L_0x00a3:
            r11.detachViewsFromParent(r3, r6)
            boolean r0 = r11.mIsRtl
            if (r12 == r0) goto L_0x00af
            int r12 = r11.mFirstPosition
            int r12 = r12 + r6
            r11.mFirstPosition = r12
        L_0x00af:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.EnhanceGallery.detachOffScreenChildren(boolean):void");
    }

    private boolean dispatchLongPress(View view, int i, long j) {
        boolean z;
        AdapterView.OnItemLongClickListener onItemLongClickListener = this.mOnItemLongClickListener;
        if (onItemLongClickListener != null) {
            z = onItemLongClickListener.onItemLongClick(this, this.mDownTouchView, this.mDownTouchPosition, j);
        } else {
            z = false;
        }
        if (!z) {
            this.mContextMenuInfo = new AdapterContextMenuInfo(view, i, j);
            z = super.showContextMenuForChild(this);
        }
        if (z) {
            performHapticFeedback(0);
        }
        return z;
    }

    private void dispatchPress(View view) {
        if (view != null) {
            view.setPressed(true);
        }
        setPressed(true);
    }

    private void dispatchUnpress() {
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (childCount >= 0) {
                getChildAt(childCount).setPressed(false);
            } else {
                setPressed(false);
                return;
            }
        }
    }

    private void fillToGalleryLeft() {
        if (this.mIsRtl) {
            fillToGalleryLeftRtl();
        } else {
            fillToGalleryLeftLtr();
        }
    }

    private void fillToGalleryLeftLtr() {
        int i;
        int i2;
        int i3 = this.mSpacing;
        int paddingLeft = getPaddingLeft();
        View childAt = getChildAt(0);
        if (childAt != null) {
            i = this.mFirstPosition - 1;
            i2 = childAt.getLeft() - i3;
        } else {
            i2 = (getRight() - getLeft()) - getPaddingRight();
            this.mShouldStopFling = true;
            i = 0;
        }
        while (i2 > paddingLeft && i >= 0) {
            View makeAndAddView = makeAndAddView(i, i - this.mSelectedPosition, i2, false);
            this.mFirstPosition = i;
            i2 = makeAndAddView.getLeft() - i3;
            i--;
        }
    }

    private void fillToGalleryLeftRtl() {
        int i;
        int i2;
        int i3 = this.mSpacing;
        int paddingLeft = getPaddingLeft();
        int childCount = getChildCount();
        View childAt = getChildAt(childCount - 1);
        if (childAt != null) {
            i = this.mFirstPosition + childCount;
            i2 = childAt.getLeft() - i3;
        } else {
            i = this.mItemCount - 1;
            this.mFirstPosition = i;
            i2 = (getRight() - getLeft()) - getPaddingRight();
            this.mShouldStopFling = true;
        }
        while (i2 > paddingLeft && i < this.mItemCount) {
            i2 = makeAndAddView(i, i - this.mSelectedPosition, i2, false).getLeft() - i3;
            i++;
        }
    }

    private void fillToGalleryRight() {
        if (this.mIsRtl) {
            fillToGalleryRightRtl();
        } else {
            fillToGalleryRightLtr();
        }
    }

    private void fillToGalleryRightLtr() {
        int i;
        int i2;
        int i3 = this.mSpacing;
        int right = (getRight() - getLeft()) - getPaddingRight();
        int childCount = getChildCount();
        int i4 = this.mItemCount;
        View childAt = getChildAt(childCount - 1);
        if (childAt != null) {
            i = this.mFirstPosition + childCount;
            i2 = childAt.getRight() + i3;
        } else {
            i = this.mItemCount - 1;
            this.mFirstPosition = i;
            i2 = getPaddingLeft();
            this.mShouldStopFling = true;
        }
        while (i2 < right && i < i4) {
            i2 = makeAndAddView(i, i - this.mSelectedPosition, i2, true).getRight() + i3;
            i++;
        }
    }

    private void fillToGalleryRightRtl() {
        int i;
        int i2 = this.mSpacing;
        int right = (getRight() - getLeft()) - getPaddingRight();
        int i3 = 0;
        View childAt = getChildAt(0);
        if (childAt != null) {
            i3 = this.mFirstPosition - 1;
            i = childAt.getRight() + i2;
        } else {
            i = getPaddingLeft();
            this.mShouldStopFling = true;
        }
        while (i < right && i3 >= 0) {
            View makeAndAddView = makeAndAddView(i3, i3 - this.mSelectedPosition, i, true);
            this.mFirstPosition = i3;
            i = makeAndAddView.getRight() + i2;
            i3--;
        }
    }

    private int getCenterOfEnhanceGallery() {
        return (((getWidth() - getPaddingLeft()) - getPaddingRight()) / 2) + getPaddingLeft();
    }

    private static int getCenterOfView(View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }

    private void layoutChildren() {
        int i = this.mSpacing;
        int paddingLeft = getPaddingLeft();
        int right = (getRight() - getLeft()) - getPaddingRight();
        int i2 = this.mItemCount;
        if (this.mIsRtl) {
            int i3 = this.mFirstPosition;
            int i4 = right - this.mSpacing;
            while (i4 > paddingLeft && i3 < i2) {
                i4 = makeAndAddView(i3, i3 - this.mSelectedPosition, i4, false).getLeft() - i;
                i3++;
            }
            return;
        }
        int i5 = this.mFirstPosition;
        int i6 = paddingLeft + i;
        while (i6 < right && i5 < i2) {
            i6 = makeAndAddView(i5, i5 - this.mSelectedPosition, i6, true).getRight() + i;
            i5++;
        }
    }

    private View makeAndAddView(int i, int i2, int i3, boolean z) {
        View view;
        if (this.mDataChanged || (view = this.mRecycler.get(i)) == null) {
            View view2 = this.mAdapter.getView(i, (View) null, this);
            if (view2.getImportantForAccessibility() == 0) {
                view2.setImportantForAccessibility(1);
            }
            if (((AccessibilityManager) getContext().getSystemService("accessibility")).isEnabled()) {
                if (this.mAccessibilityDelegate == null) {
                    this.mAccessibilityDelegate = new SpinnerItemAccessibilityDelegate();
                }
                if (view2.getAccessibilityNodeProvider() == null) {
                    view2.setAccessibilityDelegate(this.mAccessibilityDelegate);
                }
            }
            setUpChild(view2, i, i2, i3, z);
            return view2;
        }
        if (!this.mAccDelegateStates) {
            if (view.getImportantForAccessibility() == 0) {
                view.setImportantForAccessibility(1);
            }
            if (((AccessibilityManager) getContext().getSystemService("accessibility")).isEnabled()) {
                if (this.mAccessibilityDelegate == null) {
                    this.mAccessibilityDelegate = new SpinnerItemAccessibilityDelegate();
                }
                if (view.getAccessibilityNodeProvider() == null) {
                    view.setAccessibilityDelegate(this.mAccessibilityDelegate);
                }
            }
            this.mAccDelegateStates = true;
        }
        setUpChild(view, i, i2, i3, z);
        return view;
    }

    private void offsetChildrenLeftAndRight(int i) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            getChildAt(childCount).offsetLeftAndRight(i);
        }
    }

    private void onFinishedMovement() {
        if (this.mSuppressSelectionChanged) {
            this.mSuppressSelectionChanged = false;
            super.selectionChanged();
        }
        invalidate();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00df  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void scrollIntoSlots() {
        /*
            r10 = this;
            int r0 = r10.getChildCount()
            r1 = 0
            if (r0 == 0) goto L_0x00ed
            android.view.View r2 = r10.mSelectedChild
            if (r2 != 0) goto L_0x000d
            goto L_0x00ed
        L_0x000d:
            android.view.View r2 = r10.getChildAt(r1)
            int r3 = r0 + -1
            android.view.View r3 = r10.getChildAt(r3)
            boolean r4 = r10.mIsRtl
            r5 = 1
            r6 = 2
            if (r4 == 0) goto L_0x0076
            int r4 = r10.getWidth()
            int r7 = r10.getPaddingRight()
            int r4 = r4 - r7
            int r7 = r10.mSpacing
            int r4 = r4 - r7
            int r7 = r10.getPaddingLeft()
            int r8 = r10.mTouchMode
            if (r8 != r6) goto L_0x0042
            int r8 = r10.mFirstPosition
            int r8 = r8 + r0
            int r9 = r10.mItemCount
            if (r8 != r9) goto L_0x0042
            int r0 = r10.mSpacing
            int r7 = r7 + r0
            int r0 = r3.getLeft()
        L_0x003f:
            int r7 = r7 - r0
            goto L_0x00d0
        L_0x0042:
            int r8 = r2.getRight()
            if (r8 == r4) goto L_0x00cf
            int r8 = getCenterOfView(r2)
            if (r8 < r4) goto L_0x0058
            android.view.View r2 = r10.getChildAt(r5)
            int r2 = r2.getRight()
        L_0x0056:
            int r4 = r4 - r2
            goto L_0x005d
        L_0x0058:
            int r2 = r2.getRight()
            goto L_0x0056
        L_0x005d:
            int r2 = r10.mFirstPosition
            int r2 = r2 + r0
            int r0 = r10.mItemCount
            if (r2 != r0) goto L_0x0074
            int r0 = r3.getLeft()
            int r0 = r0 + r4
            if (r0 <= r7) goto L_0x0074
            int r0 = r3.getLeft()
            int r7 = r7 - r0
            int r0 = r10.mSpacing
            int r7 = r7 + r0
            goto L_0x00d0
        L_0x0074:
            r7 = r4
            goto L_0x00d0
        L_0x0076:
            int r4 = r10.getPaddingLeft()
            int r7 = r10.mSpacing
            int r4 = r4 + r7
            int r7 = r10.getWidth()
            int r8 = r10.getPaddingRight()
            int r7 = r7 - r8
            int r8 = r10.mTouchMode
            if (r8 != r6) goto L_0x0099
            int r8 = r10.mFirstPosition
            int r8 = r8 + r0
            int r9 = r10.mItemCount
            if (r8 != r9) goto L_0x0099
            int r0 = r3.getRight()
            int r7 = r7 - r0
            int r0 = r10.mSpacing
            goto L_0x003f
        L_0x0099:
            int r8 = r2.getLeft()
            if (r8 == r4) goto L_0x00cf
            int r8 = getCenterOfView(r2)
            if (r8 >= r4) goto L_0x00af
            android.view.View r2 = r10.getChildAt(r5)
            int r2 = r2.getLeft()
        L_0x00ad:
            int r4 = r4 - r2
            goto L_0x00b4
        L_0x00af:
            int r2 = r2.getLeft()
            goto L_0x00ad
        L_0x00b4:
            int r2 = r10.mFirstPosition
            int r2 = r2 + r0
            int r0 = r10.mItemCount
            if (r2 != r0) goto L_0x0074
            int r0 = r3.getRight()
            int r0 = r0 + r4
            int r2 = r10.mSpacing
            int r2 = r7 - r2
            if (r0 == r2) goto L_0x0074
            int r0 = r3.getRight()
            int r7 = r7 - r0
            int r0 = r10.mSpacing
            goto L_0x003f
        L_0x00cf:
            r7 = r1
        L_0x00d0:
            if (r7 == 0) goto L_0x00df
            int r0 = r10.mLastScrollState
            if (r0 == r6) goto L_0x00d9
            r10.reportScrollStateChange(r6)
        L_0x00d9:
            com.meizu.common.widget.EnhanceGallery$FlingRunnable r10 = r10.mFlingRunnable
            r10.startUsingDistance(r7)
            goto L_0x00ec
        L_0x00df:
            int r0 = r10.mLastScrollState
            if (r0 == 0) goto L_0x00e6
            r10.reportScrollStateChange(r1)
        L_0x00e6:
            r10.onFinishedMovement()
            r0 = -1
            r10.mTouchMode = r0
        L_0x00ec:
            return
        L_0x00ed:
            int r0 = r10.mLastScrollState
            if (r0 == 0) goto L_0x00f4
            r10.reportScrollStateChange(r1)
        L_0x00f4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.EnhanceGallery.scrollIntoSlots():void");
    }

    private void setSelectionView() {
        int i;
        if (this.mSelectedChild != null && (i = this.mFirstPosition) != this.mSelectedPosition) {
            setSelectedPositionInt(i);
            setNextSelectedPositionInt(i);
            checkSelectionChanged();
        }
    }

    private void setUpChild(View view, int i, int i2, int i3, boolean z) {
        int i4;
        SparseBooleanArray sparseBooleanArray;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        LayoutParams layoutParams2 = layoutParams == null ? (LayoutParams) generateDefaultLayoutParams() : layoutParams instanceof LayoutParams ? (LayoutParams) layoutParams : (LayoutParams) generateLayoutParams(layoutParams);
        boolean z2 = false;
        addViewInLayout(view, z != this.mIsRtl ? -1 : 0, layoutParams2);
        if (this.mChoiceMode == 1) {
            if (i2 == 0) {
                z2 = true;
            }
            view.setSelected(z2);
        }
        int i5 = this.mHeightMeasureSpec;
        Rect rect = this.mSpinnerPadding;
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i5, rect.top + rect.bottom, layoutParams2.height);
        int i6 = this.mWidthMeasureSpec;
        Rect rect2 = this.mSpinnerPadding;
        view.measure(ViewGroup.getChildMeasureSpec(i6, rect2.left + rect2.right, layoutParams2.width), childMeasureSpec);
        int calculateTop = calculateTop(view, true);
        int measuredHeight = view.getMeasuredHeight() + calculateTop;
        int measuredWidth = view.getMeasuredWidth();
        if (z) {
            i4 = measuredWidth + i3;
        } else {
            int i7 = i3 - measuredWidth;
            i4 = i3;
            i3 = i7;
        }
        view.layout(i3, calculateTop, i4, measuredHeight);
        if (!(this.mChoiceMode == 0 || (sparseBooleanArray = this.mCheckStates) == null)) {
            if (view instanceof Checkable) {
                ((Checkable) view).setChecked(sparseBooleanArray.get(i));
            } else if (getContext().getApplicationInfo().targetSdkVersion >= 11) {
                view.setActivated(this.mCheckStates.get(i));
            }
        }
        if (this.mChoiceMode == 2 && this.mDragEnable) {
            view.setOnDragListener(new View.OnDragListener() {
                public boolean onDrag(View view, DragEvent dragEvent) {
                    int action;
                    if (EnhanceGallery.this.mDragAndDropPosition == -1 || (action = dragEvent.getAction()) == 3) {
                        return false;
                    }
                    if (action == 4) {
                        EnhanceGallery enhanceGallery = EnhanceGallery.this;
                        View childAt = enhanceGallery.getChildAt(enhanceGallery.mDragAndDropPosition - enhanceGallery.mFirstPosition);
                        if (childAt != null) {
                            if (childAt instanceof DragShadowItem) {
                                View dragView = ((DragShadowItem) childAt).getDragView();
                                if (dragView != null) {
                                    dragView.setAlpha(1.0f);
                                }
                                if (EnhanceGallery.this.mChangeChildAlphaWhenDragView) {
                                    childAt.setAlpha(1.0f);
                                }
                            } else {
                                childAt.setAlpha(1.0f);
                            }
                        }
                        if (!dragEvent.getResult()) {
                            EnhanceGallery enhanceGallery2 = EnhanceGallery.this;
                            enhanceGallery2.setItemChecked(enhanceGallery2.mDragAndDropPosition, true);
                        } else if (childAt != null) {
                            View findViewById = childAt.findViewById(16908289);
                            if (findViewById != null && (findViewById instanceof Checkable)) {
                                ((Checkable) findViewById).setChecked(false);
                            }
                            EnhanceGallery.this.invalidateViews();
                        }
                        EnhanceGallery enhanceGallery3 = EnhanceGallery.this;
                        enhanceGallery3.mDragAndDropPosition = -1;
                        if (enhanceGallery3.getCheckedItemCount() <= 0 && EnhanceGallery.this.mChoiceActionMode != null) {
                            EnhanceGallery.this.mChoiceActionMode.finish();
                        }
                    } else if (action == 100) {
                        EnhanceGallery enhanceGallery4 = EnhanceGallery.this;
                        View childAt2 = enhanceGallery4.getChildAt(enhanceGallery4.mDragAndDropPosition - enhanceGallery4.mFirstPosition);
                        if (childAt2 != null) {
                            if (childAt2 instanceof DragShadowItem) {
                                View dragView2 = ((DragShadowItem) childAt2).getDragView();
                                if (dragView2 != null) {
                                    dragView2.setAlpha(1.0f);
                                }
                                if (EnhanceGallery.this.mChangeChildAlphaWhenDragView) {
                                    childAt2.setAlpha(1.0f);
                                }
                            } else {
                                childAt2.setAlpha(1.0f);
                            }
                            View findViewById2 = childAt2.findViewById(16908289);
                            if (findViewById2 != null && (findViewById2 instanceof Checkable)) {
                                ((Checkable) findViewById2).setChecked(false);
                            }
                        }
                        EnhanceGallery.this.requestLayout();
                        if (EnhanceGallery.this.getCheckedItemCount() <= 0 && EnhanceGallery.this.mChoiceActionMode != null) {
                            EnhanceGallery.this.mChoiceActionMode.finish();
                        }
                        EnhanceGallery.this.mDragAndDropPosition = -1;
                    }
                    return true;
                }
            });
        }
    }

    private void updateOnScreenCheckedViews() {
        int i = this.mFirstPosition;
        int childCount = getChildCount();
        boolean z = getContext().getApplicationInfo().targetSdkVersion >= 11;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int i3 = i + i2;
            if (childAt instanceof Checkable) {
                ((Checkable) childAt).setChecked(this.mCheckStates.get(i3));
            } else if (z) {
                childAt.setActivated(this.mCheckStates.get(i3));
            }
        }
    }

    private void updateSelectedItemMetadata() {
        View view = this.mSelectedChild;
        View childAt = getChildAt(this.mSelectedPosition - this.mFirstPosition);
        this.mSelectedChild = childAt;
        if (childAt != null && this.mChoiceMode == 1) {
            childAt.setSelected(true);
            childAt.setFocusable(true);
            if (hasFocus()) {
                childAt.requestFocus();
            }
            if (view != null && view != childAt) {
                view.setSelected(false);
                view.setFocusable(false);
            }
        }
    }

    public void changeChildAlphaWhenDragView(boolean z) {
        this.mChangeChildAlphaWhenDragView = z;
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void clearChoices() {
        SparseBooleanArray sparseBooleanArray = this.mCheckStates;
        if (sparseBooleanArray != null) {
            sparseBooleanArray.clear();
        }
        LongSparseArray<Integer> longSparseArray = this.mCheckedIdStates;
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
        this.mCheckedItemCount = 0;
    }

    public int computeHorizontalScrollExtent() {
        return 1;
    }

    public int computeHorizontalScrollOffset() {
        return this.mSelectedPosition;
    }

    public int computeHorizontalScrollRange() {
        return this.mItemCount;
    }

    public void confirmCheckedPositionsById() {
        ActionMode actionMode;
        MultiChoiceModeWrapper multiChoiceModeWrapper;
        this.mCheckStates.clear();
        int i = 0;
        boolean z = false;
        while (i < this.mCheckedIdStates.size()) {
            long keyAt = this.mCheckedIdStates.keyAt(i);
            int intValue = this.mCheckedIdStates.valueAt(i).intValue();
            long itemId = intValue < this.mItemCount ? this.mAdapter.getItemId(intValue) : -1;
            if (intValue >= this.mItemCount || keyAt != itemId) {
                int max = Math.max(0, intValue - 20);
                int min = Math.min(intValue + 20, this.mItemCount);
                while (true) {
                    if (max >= min) {
                        this.mCheckedIdStates.delete(keyAt);
                        i--;
                        this.mCheckedItemCount--;
                        ActionMode actionMode2 = this.mChoiceActionMode;
                        if (!(actionMode2 == null || (multiChoiceModeWrapper = this.mMultiChoiceModeCallback) == null)) {
                            multiChoiceModeWrapper.onItemCheckedStateChanged(actionMode2, intValue, keyAt, false);
                        }
                        z = true;
                    } else if (keyAt == this.mAdapter.getItemId(max)) {
                        this.mCheckStates.put(max, true);
                        this.mCheckedIdStates.setValueAt(i, Integer.valueOf(max));
                        break;
                    } else {
                        max++;
                    }
                }
            } else {
                this.mCheckStates.put(intValue, true);
            }
            i++;
        }
        if (z && (actionMode = this.mChoiceActionMode) != null) {
            actionMode.invalidate();
        }
    }

    public ContextMenu.ContextMenuInfo createContextMenuInfo(View view, int i, long j) {
        return new AdapterContextMenuInfo(view, i, j);
    }

    public void dispatchSetPressed(boolean z) {
        View view = this.mSelectedChild;
        if (view != null) {
            view.setPressed(z);
        }
    }

    public void dispatchSetSelected(boolean z) {
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public int getCheckedItemCount() {
        return this.mCheckedItemCount;
    }

    public long[] getCheckedItemIds() {
        LongSparseArray<Integer> longSparseArray;
        if (this.mChoiceMode == 0 || (longSparseArray = this.mCheckedIdStates) == null || this.mAdapter == null) {
            return new long[0];
        }
        int size = longSparseArray.size();
        long[] jArr = new long[size];
        for (int i = 0; i < size; i++) {
            jArr[i] = longSparseArray.keyAt(i);
        }
        return jArr;
    }

    public SparseBooleanArray getCheckedItemPositions() {
        if (this.mChoiceMode != 0) {
            return this.mCheckStates;
        }
        return null;
    }

    public int getChildHeight(View view) {
        return view.getMeasuredHeight();
    }

    public ContextMenu.ContextMenuInfo getContextMenuInfo() {
        return this.mContextMenuInfo;
    }

    public void invalidateViews() {
        this.mDataChanged = true;
        this.mItemCount = this.mAdapter.getCount();
        requestLayout();
        invalidate();
    }

    public void invokeOnItemScrollListener() {
        OnScrollListener onScrollListener = this.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScroll(this, this.mFirstPosition, getChildCount(), this.mItemCount);
        }
    }

    public boolean isItemChecked(int i) {
        SparseBooleanArray sparseBooleanArray;
        if (this.mChoiceMode == 0 || (sparseBooleanArray = this.mCheckStates) == null) {
            return false;
        }
        return sparseBooleanArray.get(i);
    }

    public void layout(int i, boolean z) {
        int i2;
        SpinnerAdapter spinnerAdapter;
        this.mIsRtl = getLayoutDirection() == 1;
        if (this.mDataChanged) {
            handleDataChanged();
        }
        if (this.mDataChanged && this.mChoiceMode == 2 && (spinnerAdapter = this.mAdapter) != null && spinnerAdapter.hasStableIds()) {
            confirmCheckedPositionsById();
        }
        if (this.mItemCount == 0) {
            invokeOnItemScrollListener();
            resetList();
            return;
        }
        int i3 = this.mNextSelectedPosition;
        if (i3 >= 0) {
            setSelectedPositionInt(i3);
        }
        recycleAllViews();
        detachAllViewsFromParent();
        this.mFirstPosition = this.mSelectedPosition;
        layoutChildren();
        this.mRecycler.clear();
        invalidate();
        checkSelectionChanged();
        this.mDataChanged = false;
        this.mNeedSync = false;
        setNextSelectedPositionInt(this.mSelectedPosition);
        updateSelectedItemMetadata();
        this.mDeltaLength = 0;
        View childAt = getChildAt(0);
        if (childAt != null) {
            this.mChildWidth = childAt.getWidth();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int i4 = this.mItemCount;
            int i5 = this.mChildWidth;
            int i6 = this.mSpacing;
            int i7 = width - ((i5 + i6) * i4);
            this.mDeltaLength = i7;
            if (i7 <= 0 || this.mScrollEnableWhenLessContent) {
                if (i7 <= 0) {
                    int childCount = getChildCount();
                    if (this.mIsRtl) {
                        int paddingLeft = getPaddingLeft() + this.mSpacing;
                        if (this.mFirstPosition + childCount == this.mItemCount) {
                            int i8 = childCount - 1;
                            if (!(getChildAt(i8).getLeft() == paddingLeft || this.mNextSelectedPosition == 0)) {
                                trackMotionScroll(paddingLeft - getChildAt(i8).getLeft());
                                scrollIntoSlots();
                            }
                        }
                    } else {
                        int width2 = (getWidth() - getPaddingRight()) - this.mSpacing;
                        if (this.mFirstPosition + childCount == this.mItemCount) {
                            int i9 = childCount - 1;
                            if (!(getChildAt(i9).getRight() == width2 || this.mNextSelectedPosition == 0)) {
                                trackMotionScroll(width2 - getChildAt(i9).getRight());
                                scrollIntoSlots();
                            }
                        }
                    }
                }
            } else if (this.mFirstPosition != 0 && (i2 = this.mSelectedPosition) < i4) {
                if (this.mIsRtl) {
                    i2 = -i2;
                }
                trackMotionScroll(i2 * (i5 + i6));
                scrollIntoSlots();
            }
        }
        invokeOnItemScrollListener();
    }

    public void onCancel() {
        onUp();
    }

    public boolean onDown(MotionEvent motionEvent) {
        int i = this.mTouchMode;
        if (i == 2 || i == 4) {
            this.mTouchMode = 1;
            reportScrollStateChange(1);
        } else {
            this.mTouchMode = 0;
        }
        this.mFlingRunnable.stop(false);
        int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        this.mDownTouchPosition = pointToPosition;
        if (pointToPosition >= 0) {
            View childAt = getChildAt(pointToPosition - this.mFirstPosition);
            this.mDownTouchView = childAt;
            childAt.setPressed(true);
        }
        this.mMotionX = (int) motionEvent.getX();
        this.mMotionY = (int) motionEvent.getY();
        int i2 = this.mFirstPosition;
        this.mDownFirstPosition = i2;
        this.mDownLastPosition = (i2 + getChildCount()) - 1;
        this.mIsFirstScroll = true;
        return true;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i;
        int i2;
        int i3;
        if (this.mDeltaLength > 0 && !this.mScrollEnableWhenLessContent) {
            return false;
        }
        if (!this.mShouldCallbackDuringFling) {
            removeCallbacks(this.mDisableSuppressSelectionChangedRunnable);
            if (!this.mSuppressSelectionChanged) {
                this.mSuppressSelectionChanged = true;
            }
        }
        int childCount = getChildCount();
        int i4 = this.mTouchMode;
        if (i4 != 1) {
            if (i4 == 3) {
                this.mTouchMode = 4;
            }
        } else if (Math.abs(f) < 1500.0f) {
            return false;
        } else {
            this.mTouchMode = 2;
            int floor = ((int) Math.floor((double) (((getWidth() - getPaddingLeft()) - getPaddingRight()) / (this.mChildWidth + this.mSpacing)))) * (this.mChildWidth + this.mSpacing);
            if (f <= 0.0f) {
                if (this.mIsRtl) {
                    View childAt = getChildAt(this.mDownFirstPosition - this.mFirstPosition);
                    i = -(floor - (((getWidth() - getPaddingRight()) - this.mSpacing) - (childAt != null ? childAt.getRight() : getChildAt(0).getRight())));
                } else {
                    View childAt2 = getChildAt(this.mDownLastPosition - this.mFirstPosition);
                    if (childAt2 != null) {
                        i = (getPaddingLeft() + this.mSpacing) - childAt2.getLeft();
                    } else {
                        i2 = getPaddingLeft() + this.mSpacing;
                        i3 = getChildAt(childCount - 1).getLeft();
                    }
                }
                reportScrollStateChange(2);
                this.mFlingRunnable.startUsingDistance(i);
            } else if (this.mIsRtl) {
                View childAt3 = getChildAt(this.mDownLastPosition - this.mFirstPosition);
                i2 = (getWidth() - getPaddingRight()) - this.mSpacing;
                i3 = childAt3 != null ? childAt3.getRight() : getChildAt(getChildCount() - 1).getRight();
            } else {
                View childAt4 = getChildAt(this.mDownFirstPosition - this.mFirstPosition);
                i = childAt4 != null ? floor - ((childAt4.getLeft() - getPaddingLeft()) - this.mSpacing) : ((getPaddingLeft() + this.mSpacing) - getChildAt(0).getLeft()) + floor;
                reportScrollStateChange(2);
                this.mFlingRunnable.startUsingDistance(i);
            }
            i = i2 - i3;
            reportScrollStateChange(2);
            this.mFlingRunnable.startUsingDistance(i);
        }
        return true;
    }

    public void onFocusChanged(boolean z, int i, Rect rect) {
        View view;
        super.onFocusChanged(z, i, rect);
        if (z && (view = this.mSelectedChild) != null && this.mChoiceMode == 1) {
            view.requestFocus(i);
            this.mSelectedChild.setSelected(true);
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(1, getCount(), false, 1));
        accessibilityNodeInfo.setClassName(EnhanceGallery.class.getName());
    }

    public void onInitializeAccessibilityNodeInfoForItem(View view, int i, AccessibilityNodeInfo accessibilityNodeInfo) {
        SpinnerAdapter adapter = getAdapter();
        if (i != -1 && adapter != null) {
            if (i == getSelectedItemPosition()) {
                accessibilityNodeInfo.setSelected(true);
                accessibilityNodeInfo.addAction(8);
            } else {
                accessibilityNodeInfo.addAction(4);
            }
            if (isFocusable()) {
                accessibilityNodeInfo.addAction(1);
                accessibilityNodeInfo.setFocusable(true);
            }
            if (isClickable()) {
                accessibilityNodeInfo.addAction(16);
                accessibilityNodeInfo.setClickable(true);
            }
            if (isLongClickable()) {
                accessibilityNodeInfo.addAction(32);
                accessibilityNodeInfo.setLongClickable(true);
            }
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mInLayout = true;
        layout(0, false);
        this.mInLayout = false;
    }

    public void onLongPress(MotionEvent motionEvent) {
        View childAt;
        int i = this.mDownTouchPosition;
        if (i >= 0) {
            if (this.mChoiceMode == 2 && (childAt = getChildAt(i - this.mFirstPosition)) != null) {
                int i2 = this.mDownTouchPosition;
                if (!this.mDataChanged ? performLongPress(childAt, i2, this.mAdapter.getItemId(i2)) : false) {
                    this.mTouchMode = -1;
                    setPressed(false);
                    childAt.setPressed(false);
                }
            }
            performHapticFeedback(0);
            dispatchLongPress(this.mDownTouchView, this.mDownTouchPosition, getItemIdAtPosition(this.mDownTouchPosition));
        }
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.mDeltaLength > 0 && !this.mScrollEnableWhenLessContent) {
            return false;
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        if (!this.mShouldCallbackDuringFling) {
            if (this.mIsFirstScroll) {
                if (!this.mSuppressSelectionChanged) {
                    this.mSuppressSelectionChanged = true;
                }
                postDelayed(this.mDisableSuppressSelectionChangedRunnable, 250);
            }
        } else if (this.mSuppressSelectionChanged) {
            this.mSuppressSelectionChanged = false;
        }
        if (this.mIsFirstScroll) {
            reportScrollStateChange(1);
        }
        this.mTouchMode = 1;
        getChildCount();
        int i = (int) f;
        if (this.mMaxOverScrollDistance > getWidth()) {
            this.mMaxOverScrollDistance = this.mDefaultMaxOverScrollDistance;
        }
        int i2 = this.mCurrentOverScrollDistance;
        if (!(i2 == 0 || this.mMaxOverScrollDistance == 0)) {
            this.mTouchMode = 3;
            if (Math.abs(i2) >= this.mMaxOverScrollDistance) {
                i = 0;
            } else {
                i = (int) (((float) i) * (1.0f - ((((float) Math.abs(this.mCurrentOverScrollDistance)) * 1.0f) / ((float) this.mMaxOverScrollDistance))));
            }
        }
        if (i != 0) {
            trackMotionScroll(i * -1);
        }
        this.mIsFirstScroll = false;
        return true;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        int i = this.mDownTouchPosition;
        if (i < 0 || this.mChoiceMode == 0) {
            if (this.mShouldCallbackOnUnselectedItemClick || i == this.mSelectedPosition) {
                performItemClick(this.mDownTouchView, i, this.mAdapter.getItemId(i));
            }
            return true;
        }
        if (this.mPerformClick == null) {
            this.mPerformClick = new PerformClick();
        }
        PerformClick performClick = this.mPerformClick;
        performClick.mClickMotionPosition = this.mDownTouchPosition;
        performClick.rememberWindowAttachCount();
        post(performClick);
        return true;
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        postDelayed(new Runnable() {
            public void run() {
                int i;
                int width;
                int right;
                EnhanceGallery enhanceGallery = EnhanceGallery.this;
                View childAt = enhanceGallery.getChildAt(enhanceGallery.getChildCount() - 1);
                if (EnhanceGallery.this.mIsRtl) {
                    if (childAt != null && childAt.getLeft() > EnhanceGallery.this.getPaddingLeft()) {
                        width = EnhanceGallery.this.getPaddingLeft();
                        right = childAt.getLeft();
                    }
                    i = 0;
                    int unused = EnhanceGallery.this.mTouchMode = -1;
                    if (!(EnhanceGallery.this.mLastScrollState == 2 || i == 0)) {
                        EnhanceGallery.this.reportScrollStateChange(2);
                    }
                    EnhanceGallery.this.mFlingRunnable.startUsingDistance(i);
                }
                if (childAt != null && childAt.getRight() < EnhanceGallery.this.getWidth() - EnhanceGallery.this.getPaddingRight()) {
                    width = EnhanceGallery.this.getWidth() - EnhanceGallery.this.getPaddingRight();
                    right = childAt.getRight();
                }
                i = 0;
                int unused2 = EnhanceGallery.this.mTouchMode = -1;
                EnhanceGallery.this.reportScrollStateChange(2);
                EnhanceGallery.this.mFlingRunnable.startUsingDistance(i);
                i = width - right;
                int unused3 = EnhanceGallery.this.mTouchMode = -1;
                EnhanceGallery.this.reportScrollStateChange(2);
                EnhanceGallery.this.mFlingRunnable.startUsingDistance(i);
            }
        }, 200);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.mGestureDetector.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 1) {
            onUp();
        } else if (action == 3) {
            onCancel();
        }
        return onTouchEvent;
    }

    public void onUp() {
        int i = this.mTouchMode;
        if (i == 0) {
            scrollIntoSlots();
        } else if (i == 1) {
            scrollIntoSlots();
        } else if ((i == 3 || i == 4) && this.mCurrentOverScrollDistance != 0) {
            if (this.mLastScrollState != 2) {
                reportScrollStateChange(2);
            }
            this.mFlingRunnable.startSpringback();
        }
        dispatchUnpress();
    }

    public boolean performItemClicks(View view, int i, long j) {
        boolean z;
        boolean z2;
        MultiChoiceModeWrapper multiChoiceModeWrapper;
        int i2 = this.mChoiceMode;
        if (i2 != 0) {
            if (i2 == 2 && this.mChoiceActionMode != null) {
                boolean z3 = !this.mCheckStates.get(i, false);
                this.mCheckStates.put(i, z3);
                if (this.mCheckedIdStates != null && this.mAdapter.hasStableIds()) {
                    if (z3) {
                        this.mCheckedIdStates.put(this.mAdapter.getItemId(i), Integer.valueOf(i));
                    } else {
                        this.mCheckedIdStates.delete(this.mAdapter.getItemId(i));
                    }
                }
                if (z3) {
                    this.mCheckedItemCount++;
                } else {
                    this.mCheckedItemCount--;
                }
                ActionMode actionMode = this.mChoiceActionMode;
                if (actionMode == null || (multiChoiceModeWrapper = this.mMultiChoiceModeCallback) == null) {
                    z = true;
                } else {
                    multiChoiceModeWrapper.onItemCheckedStateChanged(actionMode, i, j, z3);
                    z = false;
                }
                z2 = true;
            } else if (i2 == 1) {
                if (!this.mCheckStates.get(i, false)) {
                    this.mCheckStates.clear();
                    this.mCheckStates.put(i, true);
                    if (this.mCheckedIdStates != null && this.mAdapter.hasStableIds()) {
                        this.mCheckedIdStates.clear();
                        this.mCheckedIdStates.put(this.mAdapter.getItemId(i), Integer.valueOf(i));
                    }
                    this.mCheckedItemCount = 1;
                } else if (this.mCheckStates.size() == 0 || !this.mCheckStates.valueAt(0)) {
                    this.mCheckedItemCount = 0;
                }
                z = true;
                z2 = true;
            } else {
                z2 = false;
                z = true;
            }
            if (z2) {
                updateOnScreenCheckedViews();
            }
        } else {
            z = true;
        }
        if (!z || this.mOnItemClickListener == null) {
            return false;
        }
        if (view != null) {
            view.sendAccessibilityEvent(1);
        }
        this.mOnItemClickListener.onItemClick(this, view, i, j);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0015, code lost:
        if (r12 != null) goto L_0x0017;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean performLongPress(android.view.View r10, int r11, long r12) {
        /*
            r9 = this;
            int r0 = r9.mChoiceMode
            r1 = 2
            r2 = 0
            if (r0 != r1) goto L_0x00d2
            android.view.ActionMode r12 = r9.mChoiceActionMode
            r13 = 1
            if (r12 != 0) goto L_0x0017
            if (r12 != 0) goto L_0x00d1
            com.meizu.common.widget.EnhanceGallery$MultiChoiceModeWrapper r12 = r9.mMultiChoiceModeCallback
            android.view.ActionMode r12 = r9.startActionMode(r12)
            r9.mChoiceActionMode = r12
            if (r12 == 0) goto L_0x00d1
        L_0x0017:
            r9.mDragAndDropPosition = r11
            r12 = 16908289(0x1020001, float:2.3877232E-38)
            android.view.View r12 = r10.findViewById(r12)
            if (r12 == 0) goto L_0x002c
            boolean r0 = r12 instanceof android.widget.Checkable
            if (r0 == 0) goto L_0x002c
            r0 = r12
            android.widget.Checkable r0 = (android.widget.Checkable) r0
            r0.setChecked(r13)
        L_0x002c:
            android.graphics.Rect r0 = r9.mTouchFrame
            if (r0 != 0) goto L_0x0037
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r9.mTouchFrame = r0
        L_0x0037:
            r10.getHitRect(r0)
            int r1 = r9.mMotionX
            int r3 = r0.left
            int r1 = r1 - r3
            int r1 = java.lang.Math.max(r2, r1)
            r9.mDragOffsetX = r1
            int r1 = r9.mMotionY
            int r0 = r0.top
            int r1 = r1 - r0
            int r0 = java.lang.Math.max(r2, r1)
            r9.mDragOffsetY = r0
            r10.setActivated(r2)
            r10.jumpDrawablesToCurrentState()
            boolean r0 = r9.mDragEnable
            if (r0 == 0) goto L_0x00cc
            boolean r0 = r10 instanceof com.meizu.common.widget.EnhanceGallery.DragShadowItem
            if (r0 == 0) goto L_0x0075
            r1 = r10
            com.meizu.common.widget.EnhanceGallery$DragShadowItem r1 = (com.meizu.common.widget.EnhanceGallery.DragShadowItem) r1
            com.meizu.common.widget.EnhanceGallery$ListViewDragShadowBuilder r3 = new com.meizu.common.widget.EnhanceGallery$ListViewDragShadowBuilder
            android.view.View r4 = r1.getDragView()
            boolean r5 = r1.needBackground()
            android.graphics.Point r1 = r1.getDragViewShowPosition()
            r3.<init>(r4, r5, r1)
            r9.mShadowBuilder = r3
            goto L_0x007c
        L_0x0075:
            com.meizu.common.widget.EnhanceGallery$ListViewDragShadowBuilder r1 = new com.meizu.common.widget.EnhanceGallery$ListViewDragShadowBuilder
            r1.<init>(r9, r10)
            r9.mShadowBuilder = r1
        L_0x007c:
            com.meizu.common.widget.EnhanceGallery$ListViewDragShadowBuilder r1 = r9.mShadowBuilder
            r3 = 0
            boolean r1 = r9.startDragNow(r3, r1, r9, r2)
            if (r1 != 0) goto L_0x00ae
            if (r12 == 0) goto L_0x0090
            boolean r10 = r12 instanceof android.widget.Checkable
            if (r10 == 0) goto L_0x0090
            android.widget.Checkable r12 = (android.widget.Checkable) r12
            r12.setChecked(r2)
        L_0x0090:
            android.view.ActionMode r10 = r9.mChoiceActionMode
            r10.finish()
            r10 = -1
            r9.mDragAndDropPosition = r10
            com.meizu.common.widget.EnhanceGallery$PerformClick r10 = r9.mPerformClick
            if (r10 != 0) goto L_0x00a3
            com.meizu.common.widget.EnhanceGallery$PerformClick r10 = new com.meizu.common.widget.EnhanceGallery$PerformClick
            r10.<init>()
            r9.mPerformClick = r10
        L_0x00a3:
            com.meizu.common.widget.EnhanceGallery$PerformClick r10 = r9.mPerformClick
            r10.mClickMotionPosition = r11
            r10.rememberWindowAttachCount()
            r9.post(r10)
            return r13
        L_0x00ae:
            r9.performHapticFeedback(r2)
            r11 = 0
            if (r0 == 0) goto L_0x00c8
            r12 = r10
            com.meizu.common.widget.EnhanceGallery$DragShadowItem r12 = (com.meizu.common.widget.EnhanceGallery.DragShadowItem) r12
            android.view.View r12 = r12.getDragView()
            if (r12 == 0) goto L_0x00c0
            r12.setAlpha(r11)
        L_0x00c0:
            boolean r9 = r9.mChangeChildAlphaWhenDragView
            if (r9 == 0) goto L_0x00d1
            r10.setAlpha(r11)
            goto L_0x00d1
        L_0x00c8:
            r10.setAlpha(r11)
            goto L_0x00d1
        L_0x00cc:
            int r10 = r9.mDragAndDropPosition
            r9.setItemChecked(r10, r13)
        L_0x00d1:
            return r13
        L_0x00d2:
            com.meizu.common.widget.AdapterView$OnItemLongClickListener r3 = r9.mOnItemLongClickListener
            if (r3 == 0) goto L_0x00df
            r4 = r9
            r5 = r10
            r6 = r11
            r7 = r12
            boolean r0 = r3.onItemLongClick(r4, r5, r6, r7)
            goto L_0x00e0
        L_0x00df:
            r0 = r2
        L_0x00e0:
            if (r0 != 0) goto L_0x00ee
            android.view.ContextMenu$ContextMenuInfo r10 = r9.createContextMenuInfo(r10, r11, r12)
            com.meizu.common.widget.EnhanceGallery$AdapterContextMenuInfo r10 = (com.meizu.common.widget.EnhanceGallery.AdapterContextMenuInfo) r10
            r9.mContextMenuInfo = r10
            boolean r0 = super.showContextMenuForChild(r9)
        L_0x00ee:
            if (r0 == 0) goto L_0x00f3
            r9.performHapticFeedback(r2)
        L_0x00f3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.EnhanceGallery.performLongPress(android.view.View, int, long):boolean");
    }

    public void reportScrollStateChange(int i) {
        if (i != this.mLastScrollState) {
            this.mLastScrollState = i;
            OnScrollListener onScrollListener = this.mOnScrollListener;
            if (onScrollListener != null) {
                onScrollListener.onScrollStateChanged(this, i);
            }
        }
    }

    public void selectionChanged() {
        if (!this.mSuppressSelectionChanged) {
            super.selectionChanged();
        }
    }

    public void setAnimationDuration(int i) {
        this.mAnimationDuration = i;
    }

    public void setCallbackDuringFling(boolean z) {
        this.mShouldCallbackDuringFling = z;
    }

    public void setCallbackOnUnselectedItemClick(boolean z) {
        this.mShouldCallbackOnUnselectedItemClick = z;
    }

    public void setChoiceMode(int i) {
        SpinnerAdapter spinnerAdapter;
        this.mChoiceMode = i;
        ActionMode actionMode = this.mChoiceActionMode;
        if (actionMode != null) {
            actionMode.finish();
            this.mChoiceActionMode = null;
        }
        if (this.mChoiceMode != 0) {
            if (this.mCheckStates == null) {
                this.mCheckStates = new SparseBooleanArray();
            }
            if (this.mCheckedIdStates == null && (spinnerAdapter = this.mAdapter) != null && spinnerAdapter.hasStableIds()) {
                this.mCheckedIdStates = new LongSparseArray<>();
            }
            if (this.mChoiceMode == 2) {
                clearChoices();
                setLongClickable(true);
            }
        }
    }

    public void setDragEnable(boolean z) {
        this.mDragEnable = z;
    }

    public void setDragItemBackgroundResources(int[] iArr) {
        if (iArr != null) {
            if (iArr.length > 0) {
                this.mDragViewBackground = iArr[0];
            }
            if (iArr.length > 1) {
                this.mDragViewBackgroundFilter = iArr[1];
            }
            if (iArr.length > 2) {
                this.mDragViewBackgroundDelete = iArr[2];
            }
        }
    }

    public void setGravity(int i) {
        if (this.mGravity != i) {
            this.mGravity = i;
            requestLayout();
        }
    }

    public void setItemChecked(int i, boolean z) {
        int i2 = this.mChoiceMode;
        if (i2 != 0) {
            if (z && this.mChoiceActionMode == null && i2 == 2) {
                MultiChoiceModeWrapper multiChoiceModeWrapper = this.mMultiChoiceModeCallback;
                if (multiChoiceModeWrapper == null || !multiChoiceModeWrapper.hasWrappedCallback()) {
                    throw new IllegalStateException("StaggeredGridView: attempted to start selection mode for CHOICE_MODE_MULTIPLE_MODAL but no choice mode callback was supplied. Call setMultiChoiceModeListener to set a callback.");
                }
                this.mChoiceActionMode = startActionMode(this.mMultiChoiceModeCallback);
            }
            if (this.mChoiceMode == 2) {
                boolean z2 = this.mCheckStates.get(i);
                this.mCheckStates.put(i, z);
                if (this.mCheckedIdStates != null && this.mAdapter.hasStableIds()) {
                    if (z) {
                        this.mCheckedIdStates.put(this.mAdapter.getItemId(i), Integer.valueOf(i));
                    } else {
                        this.mCheckedIdStates.delete(this.mAdapter.getItemId(i));
                    }
                }
                if (z2 != z) {
                    if (z) {
                        this.mCheckedItemCount++;
                    } else {
                        this.mCheckedItemCount--;
                    }
                }
                if (this.mChoiceActionMode != null) {
                    this.mMultiChoiceModeCallback.onItemCheckedStateChanged(this.mChoiceActionMode, i, this.mAdapter.getItemId(i), z);
                }
            } else {
                boolean z3 = this.mCheckedIdStates != null && this.mAdapter.hasStableIds();
                if (z || isItemChecked(i)) {
                    this.mCheckStates.clear();
                    if (z3) {
                        this.mCheckedIdStates.clear();
                    }
                }
                if (z) {
                    this.mCheckStates.put(i, true);
                    if (z3) {
                        this.mCheckedIdStates.put(this.mAdapter.getItemId(i), Integer.valueOf(i));
                    }
                    this.mCheckedItemCount = 1;
                } else if (this.mCheckStates.size() == 0 || !this.mCheckStates.valueAt(0)) {
                    this.mCheckedItemCount = 0;
                }
            }
            if (!this.mInLayout) {
                invalidateViews();
            }
        }
    }

    public void setMaxOverScrollDistance(int i) {
        if (i < 0) {
            this.mMaxOverScrollDistance = this.mDefaultMaxOverScrollDistance;
        } else {
            this.mMaxOverScrollDistance = i;
        }
    }

    public void setMultiChoiceModeListener(MultiChoiceModeListener multiChoiceModeListener) {
        if (this.mMultiChoiceModeCallback == null) {
            this.mMultiChoiceModeCallback = new MultiChoiceModeWrapper();
        }
        this.mMultiChoiceModeCallback.setWrapped(multiChoiceModeListener);
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.mOnScrollListener = onScrollListener;
        invokeOnItemScrollListener();
    }

    public void setScrollEnableWhenLessContent(boolean z) {
        this.mScrollEnableWhenLessContent = z;
    }

    public void setSelectedPositionInt(int i) {
        super.setSelectedPositionInt(i);
        updateSelectedItemMetadata();
    }

    public void setSpacing(int i) {
        this.mSpacing = i;
    }

    public boolean showContextMenu() {
        int i;
        if (!isPressed() || (i = this.mSelectedPosition) < 0) {
            return false;
        }
        return dispatchLongPress(getChildAt(i - this.mFirstPosition), this.mSelectedPosition, this.mSelectedRowId);
    }

    public boolean showContextMenuForChild(View view) {
        int positionForView = getPositionForView(view);
        if (positionForView < 0) {
            return false;
        }
        return dispatchLongPress(view, positionForView, this.mAdapter.getItemId(positionForView));
    }

    public boolean startDragNow(ClipData clipData, View.DragShadowBuilder dragShadowBuilder, Object obj, int i) {
        return false;
    }

    public boolean trackMotionScroll(int i) {
        boolean z;
        boolean z2;
        int childCount = getChildCount();
        if (childCount == 0 || i == 0) {
            return false;
        }
        boolean z3 = true;
        boolean z4 = i < 0;
        if (this.mIsRtl) {
            z = this.mFirstPosition == 0 && getChildAt(0).getRight() >= (getWidth() - getPaddingRight()) - this.mSpacing && i <= 0;
            z2 = this.mFirstPosition + childCount == this.mItemCount && getChildAt(childCount - 1).getLeft() >= getPaddingLeft() && i >= 0;
        } else {
            boolean z5 = this.mFirstPosition == 0 && getChildAt(0).getLeft() >= getPaddingLeft() + this.mSpacing && i >= 0;
            z = this.mFirstPosition + childCount == this.mItemCount && getChildAt(childCount - 1).getRight() <= getWidth() - getPaddingRight() && i <= 0;
            z2 = z5;
        }
        boolean z6 = z2 || z;
        offsetChildrenLeftAndRight(i);
        if (!z6) {
            detachOffScreenChildren(z4);
            if (z4) {
                fillToGalleryRight();
            } else {
                fillToGalleryLeft();
            }
            this.mRecycler.clear();
            setSelectionView();
        }
        this.mCurrentOverScrollDistance = 0;
        int childCount2 = getChildCount();
        if (this.mIsRtl) {
            int right = getChildAt(0).getRight();
            int left = getChildAt(childCount2 - 1).getLeft();
            int width = (getWidth() - getPaddingRight()) - this.mSpacing;
            int i2 = this.mFirstPosition;
            if (i2 == 0 && right < width) {
                this.mCurrentOverScrollDistance = width - right;
                invokeOnItemScrollListener();
                onScrollChanged(0, 0, 0, 0);
                invalidate();
                return z3;
            } else if (i2 + childCount2 == this.mItemCount && left > getPaddingLeft()) {
                this.mCurrentOverScrollDistance = (getPaddingLeft() + this.mSpacing) - left;
                invokeOnItemScrollListener();
                onScrollChanged(0, 0, 0, 0);
                invalidate();
                return z3;
            }
        } else {
            int left2 = getChildAt(0).getLeft();
            int right2 = getChildAt(childCount2 - 1).getRight();
            int paddingLeft = getPaddingLeft() + this.mSpacing;
            int width2 = getWidth() - getPaddingRight();
            int i3 = this.mFirstPosition;
            if (i3 == 0 && left2 > paddingLeft) {
                this.mCurrentOverScrollDistance = paddingLeft - left2;
                invokeOnItemScrollListener();
                onScrollChanged(0, 0, 0, 0);
                invalidate();
                return z3;
            } else if (i3 + childCount2 == this.mItemCount && right2 < width2) {
                this.mCurrentOverScrollDistance = (width2 - right2) - this.mSpacing;
                invokeOnItemScrollListener();
                onScrollChanged(0, 0, 0, 0);
                invalidate();
                return z3;
            }
        }
        z3 = false;
        invokeOnItemScrollListener();
        onScrollChanged(0, 0, 0, 0);
        invalidate();
        return z3;
    }

    public EnhanceGallery(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.MeizuCommon_EnhanceGalleryStyle);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        super.setAdapter(spinnerAdapter);
        if (spinnerAdapter != null && this.mChoiceMode != 0) {
            if (this.mCheckStates == null) {
                this.mCheckStates = new SparseBooleanArray();
            }
            if (spinnerAdapter.hasStableIds() && this.mCheckedIdStates == null) {
                this.mCheckedIdStates = new LongSparseArray<>();
            }
            clearChoices();
        }
    }

    public EnhanceGallery(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTouchMode = -1;
        this.mSpacing = 0;
        this.mAnimationDuration = 250;
        this.mFlingRunnable = new FlingRunnable();
        this.mDisableSuppressSelectionChangedRunnable = new Runnable() {
            public void run() {
                boolean unused = EnhanceGallery.this.mSuppressSelectionChanged = false;
                EnhanceGallery.this.selectionChanged();
            }
        };
        this.mShouldCallbackDuringFling = true;
        this.mShouldCallbackOnUnselectedItemClick = true;
        this.mDragEnable = false;
        this.mIsRtl = false;
        this.mScrollEnableWhenLessContent = false;
        this.mChoiceMode = 0;
        this.mChangeChildAlphaWhenDragView = false;
        this.mDragViewBackground = R.drawable.mz_list_selector_background_long_pressed;
        this.mDragViewBackgroundFilter = R.drawable.mz_list_selector_background_filter;
        this.mDragViewBackgroundDelete = R.drawable.mz_list_selector_background_delete;
        this.mDragScrollY = 0;
        this.mDragAndDropPosition = -1;
        this.mDragOffsetX = 0;
        this.mDragOffsetY = 0;
        this.mAccDelegateStates = false;
        this.mLastScrollState = 0;
        GestureDetector gestureDetector = new GestureDetector(context, this);
        this.mGestureDetector = gestureDetector;
        gestureDetector.setIsLongpressEnabled(true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.EnhanceGallery, i, 0);
        setSpacing(obtainStyledAttributes.getDimensionPixelSize(R.styleable.EnhanceGallery_mcSpacing, 10));
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.mc_enhancegallery_max_overscroll_distance);
        this.mDefaultMaxOverScrollDistance = dimensionPixelSize;
        this.mMaxOverScrollDistance = obtainStyledAttributes.getDimensionPixelSize(R.styleable.EnhanceGallery_mcMaxOverScrollDistance, dimensionPixelSize);
        this.mScrollEnableWhenLessContent = obtainStyledAttributes.getBoolean(R.styleable.EnhanceGallery_mcScrollEnableWhenLessContent, false);
        obtainStyledAttributes.recycle();
    }
}
