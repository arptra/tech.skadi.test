package flyme.support.v7.widget;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatValueHolder;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import flyme.support.v7.app.LitePopup;
import flyme.support.v7.appcompat.R;
import no.nordicsemi.android.dfu.DfuBaseService;

public class PopupNestedScrollingLayout extends ViewGroup implements NestedScrollingParent3 {
    public static float DAMP1 = 0.88f;
    public static float DAMP2 = 0.93f;
    public static float DAMP3 = 0.98f;
    public static final int POSITION_STATE_BOTTOM = 2;
    public static final int POSITION_STATE_INVALID = -1;
    public static final int POSITION_STATE_MIDDLE = 1;
    public static final int POSITION_STATE_TOP = 0;
    private static final Interpolator SCROLLER_INTERPOLATOR = PathInterpolatorCompat.a(0.2f, 0.03f, 0.0f, 1.0f);
    public static float STIFFNESS1 = 340.0f;
    public static float STIFFNESS2 = 400.0f;
    public static float STIFFNESS3 = 300.0f;
    private int cancelBtnOffset;
    private boolean isScrollPopupFirstOnTop;
    private float mAbandonVelocity;
    private boolean mBeDragging;
    private int mCollapsibleHeight;
    private boolean mContentScrolled;
    private int mCurrentScrollY;
    private Drawable mDimBackground;
    private int mDismissTriggeredDistance;
    private boolean mDismissedOnTouchOutside;
    private float mDownY;
    private boolean mDragCanceled;
    private boolean mDragTriggerNotified;
    private boolean mDragTriggerNotifiedPosted;
    private int mExpectUncollapsibleHeight;
    private float mFlingDownVelocity;
    private int mFlingPositionState;
    private View mHitView;
    private boolean mIsHitView;
    private float mLastY;
    private boolean mLimitOnlyMiddleHeight;
    private int mMaxHeight;
    private final float mMinFlingVelocity;
    private Runnable mNotifyDismissedListener;
    private LitePopup.OnDismissedListener mOnDismissedListener;
    private OnScrollListener mOnScrollListener;
    private int mOverScrollDistance;
    private TimeInterpolator mOverScrollInterpolator;
    private int mPositionState;
    private int mScrollDownThreshold;
    private int mScrollSlop;
    private boolean mScrollToDismissEnabled;
    private final OverScroller mScroller;
    private SpringAnimation mSpringAnimation;
    private int mStyle;
    private int mTopPadding;
    private int mUncollapsibleHeight;
    private final VelocityTracker mVelocityTracker;

    public interface OnScrollListener {
        void onScroll(int i);
    }

    public PopupNestedScrollingLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    private void dismissTriggerIfNeed() {
        if (this.mOnDismissedListener != null && !this.mScrollToDismissEnabled && isDismissTriggered()) {
            postNotifyDragTriggered();
        }
    }

    private void endTouch() {
    }

    private View findChildUnder(float f, float f2) {
        return findChildUnder(this, f, f2);
    }

    private int getNextPositionState(int i, float f) {
        boolean z = this.mScrollToDismissEnabled;
        if ((!z && this.mStyle != 0) || this.mContentScrolled) {
            return i;
        }
        int i2 = this.mCurrentScrollY;
        if (i2 < (-this.mUncollapsibleHeight) || i2 >= 0) {
            int i3 = this.mStyle;
            return i3 == 2 ? f > 0.0f ? 2 : 0 : (f >= 0.0f || i3 != 0) ? 1 : 0;
        } else if (this.mStyle == 1) {
            return f > 0.0f ? 2 : 1;
        } else {
            if (f < 0.0f || !z) {
                return (f >= (-this.mAbandonVelocity) || i != 0) ? 1 : 0;
            }
            return 2;
        }
    }

    private static boolean isChildUnder(View view, float f, float f2) {
        float x = view.getX();
        float y = view.getY();
        return f >= x && f2 >= y && f < ((float) view.getWidth()) + x && f2 < ((float) view.getHeight()) + y;
    }

    private boolean isDismissTriggered() {
        int i = this.mStyle;
        return (i == 1 || this.mPositionState == 1) ? this.mCurrentScrollY <= (-(this.mDismissTriggeredDistance - this.mScrollSlop)) && !this.mDragTriggerNotified : i == 2 && Math.abs(this.mCurrentScrollY - this.mCollapsibleHeight) >= this.mDismissTriggeredDistance - this.mScrollSlop && !this.mDragTriggerNotified;
    }

    private int limitedScrollBy(int i, boolean z) {
        int i2 = this.mCurrentScrollY;
        int i3 = i2 + i;
        int i4 = this.mCollapsibleHeight;
        if (i3 > i4) {
            i = i4 - i2;
        }
        if (!this.mScrollToDismissEnabled) {
            int i5 = this.mStyle;
            if (i5 == 1 && (i < 0 || !z)) {
                i = updateIncrementalDelta(i, i2);
            } else if (i5 == 2 && (i < 0 || !z)) {
                i = updateIncrementalDelta(i, i2 - i4);
            } else if (this.mPositionState == 1 && i < 0) {
                i = updateIncrementalDelta(i, i2);
            }
        } else if (this.mContentScrolled && i < 0 && i2 <= 0) {
            i = updateIncrementalDelta(i, i2);
        } else if (this.mStyle == 1 && i > 0 && !z) {
            i = updateIncrementalDelta(i, i2);
        }
        this.mSpringAnimation.d();
        performScrollBy(i);
        return i;
    }

    /* access modifiers changed from: private */
    public void notifyDragTriggered() {
        LitePopup.OnDismissedListener onDismissedListener = this.mOnDismissedListener;
        if (onDismissedListener != null) {
            onDismissedListener.onDragTriggered();
        }
        this.mDragTriggerNotified = true;
    }

    private void performScrollBy(int i) {
        scrollBy(-i);
        int i2 = this.mCurrentScrollY + i;
        this.mCurrentScrollY = i2;
        OnScrollListener onScrollListener = this.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScroll(i2);
        }
        int i3 = this.mCurrentScrollY;
        if (i3 < 0 && this.mOnDismissedListener != null) {
            this.mOnDismissedListener.onDismissProgress(((float) Math.abs(i3)) / ((float) this.mUncollapsibleHeight));
        }
    }

    private void postNotifyDragTriggered() {
        if (!this.mDragTriggerNotifiedPosted && post(this.mNotifyDismissedListener)) {
            this.mDragTriggerNotifiedPosted = true;
        }
        if (!this.mDragTriggerNotifiedPosted) {
            notifyDragTriggered();
        }
    }

    private void resetTouch() {
        this.mBeDragging = false;
        this.mDragTriggerNotified = false;
        this.mDragCanceled = false;
        this.mDragTriggerNotifiedPosted = false;
        this.mContentScrolled = false;
        this.mFlingPositionState = -1;
    }

    private void scrollBy(int i) {
        int i2 = this.mCurrentScrollY;
        int i3 = (-i) + i2 >= 0 ? -this.cancelBtnOffset : (i2 <= 0 || i <= 0) ? i : i - i2;
        this.cancelBtnOffset += i3;
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (((LayoutParams) childAt.getLayoutParams()).alignParentBottom) {
                childAt.offsetTopAndBottom(i3);
            } else {
                childAt.offsetTopAndBottom(i);
            }
        }
    }

    private void scrollToPosition(int i) {
        this.mPositionState = i;
        if (i == 0) {
            performScrollTo(this.mCollapsibleHeight);
        } else if (i == 1) {
            performScrollTo(0);
        } else if (i == 2) {
            performScrollTo(-this.mUncollapsibleHeight);
        }
    }

    private void setSpringForce(int i) {
        if (this.mPositionState == i) {
            this.mSpringAnimation.y(new SpringForce().d(DAMP3).f(STIFFNESS3));
        } else if (i == 0 || i == 1) {
            this.mSpringAnimation.y(new SpringForce().d(DAMP1).f(STIFFNESS1));
        } else if (i == 2) {
            this.mSpringAnimation.y(new SpringForce().d(DAMP2).f(STIFFNESS2));
        }
    }

    private boolean shouldFling(float f) {
        return Math.abs(f) > this.mMinFlingVelocity;
    }

    private void springScrollTo(int i) {
        if (this.mCurrentScrollY != i) {
            this.mSpringAnimation.d();
            this.mSpringAnimation.n((float) this.mCurrentScrollY);
            this.mSpringAnimation.v().e((float) i);
            this.mSpringAnimation.q();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0031, code lost:
        if (r5 == 0) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int updateIncrementalDelta(int r6, int r7) {
        /*
            r5 = this;
            int r0 = r5.mOverScrollDistance
            if (r7 == 0) goto L_0x0045
            if (r0 == 0) goto L_0x0045
            int r1 = r5.mPositionState
            r2 = 1
            if (r1 != r2) goto L_0x000f
            int r3 = r7 * r6
            if (r3 > 0) goto L_0x0015
        L_0x000f:
            if (r1 != 0) goto L_0x0043
            int r1 = r7 * r6
            if (r1 <= 0) goto L_0x0043
        L_0x0015:
            int r1 = java.lang.Math.abs(r7)
            float r1 = (float) r1
            r3 = 1065353216(0x3f800000, float:1.0)
            float r1 = r1 * r3
            float r4 = (float) r0
            float r1 = r1 / r4
            android.animation.TimeInterpolator r5 = r5.mOverScrollInterpolator
            float r5 = r5.getInterpolation(r1)
            float r3 = r3 - r5
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto L_0x002c
            r3 = r5
        L_0x002c:
            float r5 = (float) r6
            float r5 = r5 * r3
            int r5 = (int) r5
            if (r6 <= 0) goto L_0x0034
            if (r5 != 0) goto L_0x0037
            goto L_0x0038
        L_0x0034:
            if (r5 != 0) goto L_0x0037
            r5 = -1
        L_0x0037:
            r2 = r5
        L_0x0038:
            int r5 = java.lang.Math.abs(r7)
            if (r5 < r0) goto L_0x0041
            r5 = 0
            r6 = r5
            goto L_0x0045
        L_0x0041:
            r6 = r2
            goto L_0x0045
        L_0x0043:
            int r6 = r6 / 2
        L_0x0045:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: flyme.support.v7.widget.PopupNestedScrollingLayout.updateIncrementalDelta(int, int):int");
    }

    public boolean canScroll(View view, boolean z) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            view.getScrollX();
            view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                if (canScroll(viewGroup.getChildAt(childCount), true)) {
                    return true;
                }
            }
        }
        return z && (view.canScrollVertically(-1) || view.canScrollVertically(1));
    }

    public void cancelDrag() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        obtain.setSource(DfuBaseService.ERROR_FILE_ERROR);
        ((ViewGroup) getParent()).dispatchTouchEvent(obtain);
        obtain.recycle();
        this.mDragCanceled = true;
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public int getCurrentScrollY() {
        return this.mCurrentScrollY;
    }

    public int getPositionState() {
        return this.mPositionState;
    }

    public int getUncollapsibleHeight() {
        return this.mUncollapsibleHeight;
    }

    public boolean isScrollPopupFirstOnTop() {
        return this.isScrollPopupFirstOnTop;
    }

    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        Configuration configuration = getResources().getConfiguration();
        int systemWindowInsetTop = windowInsets.getSystemWindowInsetTop();
        setPadding(getPaddingLeft(), configuration.orientation == 1 ? this.mTopPadding + systemWindowInsetTop : systemWindowInsetTop, getPaddingRight(), getPaddingBottom());
        return windowInsets.inset(0, systemWindowInsetTop, 0, 0);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        requestLayout();
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.mz_lite_popup_padding_horizontal);
        setPadding(dimensionPixelOffset, getPaddingTop(), dimensionPixelOffset, getPaddingBottom());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        if (r0 != 3) goto L_0x0060;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            int r0 = r5.getActionMasked()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x003e
            if (r0 == r2) goto L_0x003a
            r3 = 2
            if (r0 == r3) goto L_0x0011
            r5 = 3
            if (r0 == r5) goto L_0x003a
            goto L_0x0060
        L_0x0011:
            float r0 = r5.getY()
            float r3 = r4.mDownY
            float r0 = r0 - r3
            boolean r3 = r4.mBeDragging
            if (r3 != 0) goto L_0x0033
            android.view.View r3 = r4.mHitView
            if (r3 == 0) goto L_0x0033
            boolean r3 = r4.canScroll(r3, r2)
            if (r3 != 0) goto L_0x0033
            float r0 = java.lang.Math.abs(r0)
            int r3 = r4.mScrollSlop
            float r3 = (float) r3
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x0033
            r4.mBeDragging = r2
        L_0x0033:
            float r5 = r5.getY()
            r4.mLastY = r5
            goto L_0x0060
        L_0x003a:
            r4.endTouch()
            goto L_0x0060
        L_0x003e:
            r4.resetTouch()
            float r0 = r5.getY()
            r4.mDownY = r0
            float r0 = r5.getY()
            r4.mLastY = r0
            float r5 = r5.getX()
            float r0 = r4.mDownY
            android.view.View r5 = findChildUnder(r4, r5, r0)
            r4.mHitView = r5
            if (r5 == 0) goto L_0x005d
            r5 = r2
            goto L_0x005e
        L_0x005d:
            r5 = r1
        L_0x005e:
            r4.mIsHitView = r5
        L_0x0060:
            boolean r5 = r4.mBeDragging
            if (r5 == 0) goto L_0x0069
            boolean r4 = r4.mDragCanceled
            if (r4 != 0) goto L_0x0069
            r1 = r2
        L_0x0069:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: flyme.support.v7.widget.PopupNestedScrollingLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth();
        int measuredHeight = (getMeasuredHeight() - this.mUncollapsibleHeight) - this.mCurrentScrollY;
        int paddingLeft = getPaddingLeft();
        int paddingRight = width - getPaddingRight();
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() != 8 && !layoutParams.alignParentBottom) {
                int i6 = measuredHeight + layoutParams.topMargin;
                int measuredHeight2 = childAt.getMeasuredHeight() + i6;
                int measuredWidth = childAt.getMeasuredWidth();
                int i7 = (((paddingRight - paddingLeft) - measuredWidth) / 2) + paddingLeft;
                childAt.layout(i7, i6, measuredWidth + i7, measuredHeight2);
                measuredHeight = measuredHeight2 + layoutParams.bottomMargin;
            }
        }
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt2 = getChildAt(i8);
            LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
            if (childAt2.getVisibility() != 8 && layoutParams2.alignParentBottom) {
                int height = (((getHeight() - childAt2.getMeasuredHeight()) - (layoutParams2.ignoreParentPadding ? 0 : getPaddingBottom())) - layoutParams2.bottomMargin) + this.cancelBtnOffset;
                int measuredWidth2 = childAt2.getMeasuredWidth();
                int i9 = (((paddingRight - paddingLeft) - measuredWidth2) / 2) + paddingLeft;
                childAt2.layout(i9, height, measuredWidth2 + i9, childAt2.getMeasuredHeight() + height);
            }
        }
        if (this.mStyle == 2 && this.mPositionState != 2 && z) {
            scrollToPosition(0);
        }
    }

    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (this.mMaxHeight < size2) {
            this.mMaxHeight = size2;
        }
        int min = Math.min(size2, this.mMaxHeight);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        int i3 = paddingTop;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() != 8 && !layoutParams.listView) {
                LayoutParams layoutParams2 = layoutParams;
                measureChildWithMargins(childAt, makeMeasureSpec, 0, makeMeasureSpec2, i3);
                if (!layoutParams2.ignoreParentPadding) {
                    i3 += childAt.getMeasuredHeight();
                }
            }
        }
        int i5 = min - i3;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt2 = getChildAt(i6);
            LayoutParams layoutParams3 = (LayoutParams) childAt2.getLayoutParams();
            if (childAt2.getVisibility() != 8 && layoutParams3.listView) {
                if ((childAt2 instanceof LitePopupContentFrameLayout) && this.mStyle == 1) {
                    LitePopupContentFrameLayout litePopupContentFrameLayout = (LitePopupContentFrameLayout) childAt2;
                    if (this.mLimitOnlyMiddleHeight) {
                        litePopupContentFrameLayout.setLimitHeight((this.mUncollapsibleHeight - i3) + getPaddingTop());
                    }
                }
                childAt2.measure(ViewGroup.getChildMeasureSpec(makeMeasureSpec, getPaddingLeft() + getPaddingRight() + layoutParams3.leftMargin + layoutParams3.rightMargin, layoutParams3.width), ViewGroup.getChildMeasureSpec(makeMeasureSpec2, getPaddingTop() + getPaddingBottom() + layoutParams3.topMargin + layoutParams3.bottomMargin + i3, i5));
                i3 += childAt2.getMeasuredHeight();
            }
        }
        this.mUncollapsibleHeight = Math.min(this.mExpectUncollapsibleHeight, (i3 - getPaddingTop()) - getPaddingBottom());
        this.mCollapsibleHeight = Math.max(0, ((i3 - getPaddingBottom()) - getPaddingTop()) - this.mUncollapsibleHeight);
        setMeasuredDimension(size, size2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onNestedPreFling(@androidx.annotation.NonNull android.view.View r5, float r6, float r7) {
        /*
            r4 = this;
            int r6 = r4.mCurrentScrollY
            int r0 = r4.mCollapsibleHeight
            r1 = 1
            r2 = 0
            if (r6 <= r0) goto L_0x0011
            boolean r6 = r4.isDismissTriggered()
            if (r6 == 0) goto L_0x000f
            goto L_0x0011
        L_0x000f:
            r6 = r2
            goto L_0x0012
        L_0x0011:
            r6 = r1
        L_0x0012:
            if (r6 == 0) goto L_0x004c
            r0 = -1
            boolean r0 = r5.canScrollVertically(r0)
            r3 = 0
            int r3 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x0025
            if (r0 == 0) goto L_0x0025
            int r3 = r4.mPositionState
            if (r3 != 0) goto L_0x0025
            return r2
        L_0x0025:
            boolean r3 = r4.shouldFling(r7)
            if (r3 == 0) goto L_0x0041
            int r3 = r4.mPositionState
            float r7 = -r7
            int r7 = r4.getNextPositionState(r3, r7)
            r4.mFlingPositionState = r7
            int r3 = r4.mPositionState
            if (r3 == r7) goto L_0x003c
            r4.smoothScrollToPositionState(r7)
            goto L_0x0041
        L_0x003c:
            if (r0 != 0) goto L_0x003f
            goto L_0x0042
        L_0x003f:
            r1 = r2
            goto L_0x0042
        L_0x0041:
            r1 = r6
        L_0x0042:
            boolean r4 = r5 instanceof flyme.support.v7.widget.MzRecyclerView
            if (r4 == 0) goto L_0x004b
            flyme.support.v7.widget.MzRecyclerView r5 = (flyme.support.v7.widget.MzRecyclerView) r5
            r5.setOverScrollEnable(r2)
        L_0x004b:
            r6 = r1
        L_0x004c:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: flyme.support.v7.widget.PopupNestedScrollingLayout.onNestedPreFling(android.view.View, float, float):boolean");
    }

    public void onNestedPreScroll(@NonNull View view, int i, int i2, @NonNull int[] iArr) {
        onNestedPreScroll(view, i, i2, iArr, 0);
    }

    public void onNestedScroll(@NonNull View view, int i, int i2, int i3, int i4, int i5) {
    }

    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i, int i2) {
    }

    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i) {
        return onStartNestedScroll(view, view2, i, 0);
    }

    public void onStopNestedScroll(@NonNull View view) {
        onStopNestedScroll(view, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0011, code lost:
        if (r0 != 3) goto L_0x0079;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            android.view.VelocityTracker r0 = r4.mVelocityTracker
            r0.addMovement(r5)
            int r0 = r5.getAction()
            r1 = 0
            r2 = 2
            r3 = 1
            if (r0 == r3) goto L_0x002b
            if (r0 == r2) goto L_0x0014
            r5 = 3
            if (r0 == r5) goto L_0x002b
            goto L_0x0079
        L_0x0014:
            boolean r0 = r4.mIsHitView
            if (r0 == 0) goto L_0x0079
            float r0 = r5.getY()
            float r2 = r4.mLastY
            float r0 = r0 - r2
            float r5 = r5.getY()
            r4.mLastY = r5
            float r5 = -r0
            int r5 = (int) r5
            r4.limitedScrollBy(r5, r1)
            goto L_0x0079
        L_0x002b:
            boolean r5 = r4.mIsHitView
            if (r5 == 0) goto L_0x0056
            android.view.VelocityTracker r5 = r4.mVelocityTracker
            r0 = 1000(0x3e8, float:1.401E-42)
            r5.computeCurrentVelocity(r0)
            android.view.VelocityTracker r5 = r4.mVelocityTracker
            float r5 = r5.getYVelocity()
            boolean r0 = r4.shouldFling(r5)
            if (r0 == 0) goto L_0x004c
            int r0 = r4.mPositionState
            int r5 = r4.getNextPositionState(r0, r5)
            r4.smoothScrollToPositionState(r5)
            goto L_0x0074
        L_0x004c:
            int r5 = r4.mPositionState
            int r5 = r4.getNextPositionState(r5)
            r4.smoothScrollToPositionState(r5)
            goto L_0x0074
        L_0x0056:
            boolean r5 = r4.mDismissedOnTouchOutside
            if (r5 == 0) goto L_0x006b
            android.content.res.Resources r5 = r4.getResources()
            android.content.res.Configuration r5 = r5.getConfiguration()
            int r5 = r5.orientation
            if (r5 == r2) goto L_0x006a
            int r5 = r4.mPositionState
            if (r5 != r3) goto L_0x006b
        L_0x006a:
            r1 = r3
        L_0x006b:
            flyme.support.v7.app.LitePopup$OnDismissedListener r5 = r4.mOnDismissedListener
            if (r5 == 0) goto L_0x0074
            if (r1 == 0) goto L_0x0074
            r5.onDismissed(r3)
        L_0x0074:
            android.view.VelocityTracker r4 = r4.mVelocityTracker
            r4.clear()
        L_0x0079:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: flyme.support.v7.widget.PopupNestedScrollingLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void performScrollTo(int i) {
        performScrollBy(i - this.mCurrentScrollY);
    }

    public void setDismissedOnTouchOutside(boolean z) {
        this.mDismissedOnTouchOutside = z;
    }

    public void setMaxHeight(int i) {
        this.mMaxHeight = i;
    }

    public void setOnDismissedListener(LitePopup.OnDismissedListener onDismissedListener) {
        this.mOnDismissedListener = onDismissedListener;
    }

    public void setScrollListener(OnScrollListener onScrollListener) {
        this.mOnScrollListener = onScrollListener;
    }

    public void setScrollPopupFirstOnTop(boolean z) {
        this.isScrollPopupFirstOnTop = z;
    }

    public void setScrollToDismissEnabled(boolean z) {
        this.mScrollToDismissEnabled = z;
    }

    public void setStyle(int i) {
        this.mStyle = i;
    }

    public void setUncollapsibleHeight(int i) {
        this.mExpectUncollapsibleHeight = i;
        requestLayout();
    }

    public void smoothScrollToPositionState(int i) {
        setSpringForce(i);
        this.mPositionState = i;
        if (i == 0) {
            springScrollTo(this.mCollapsibleHeight);
        } else if (i == 1) {
            springScrollTo(0);
        } else if (i == 2) {
            this.mSpringAnimation.d();
            LitePopup.OnDismissedListener onDismissedListener = this.mOnDismissedListener;
            if (onDismissedListener != null) {
                onDismissedListener.onDismissed(false);
            }
        }
    }

    public void unLimitMiddleOnlyHeight() {
        this.mLimitOnlyMiddleHeight = false;
    }

    public PopupNestedScrollingLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private static View findChildUnder(ViewGroup viewGroup, float f, float f2) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (isChildUnder(childAt, f, f2)) {
                return childAt;
            }
        }
        return null;
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public void onNestedPreScroll(@NonNull View view, int i, int i2, @NonNull int[] iArr, int i3) {
        boolean z = false;
        boolean z2 = i2 > 0 && (((!this.isScrollPopupFirstOnTop ? this.mCurrentScrollY < this.mCollapsibleHeight : this.mCurrentScrollY <= this.mCollapsibleHeight) && this.mStyle != 1) || (this.mCurrentScrollY < 0 && this.mStyle == 1));
        if (i2 < 0 && !view.canScrollVertically(-1)) {
            z = true;
        }
        if (z2 || (z && !this.mContentScrolled)) {
            iArr[1] = limitedScrollBy(i2, true);
        } else if (i2 != 0) {
            this.mContentScrolled = true;
        }
    }

    public void onNestedScroll(@NonNull View view, int i, int i2, int i3, int i4, int i5, @NonNull int[] iArr) {
        if (i4 < 0 && !view.canScrollVertically(-1) && !this.mContentScrolled) {
            iArr[1] = limitedScrollBy(i4, true);
        }
    }

    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i, int i2) {
        if (view2 instanceof MzRecyclerView) {
            ((MzRecyclerView) view2).setOverScrollEnable(true);
        }
        this.mFlingPositionState = -1;
        if ((i & 2) != 0) {
            return true;
        }
        return false;
    }

    public void onStopNestedScroll(@NonNull View view, int i) {
        if (!this.mSpringAnimation.h()) {
            int nextPositionState = getNextPositionState(this.mPositionState);
            int i2 = this.mFlingPositionState;
            if (!(i2 == -1 || i2 == 2)) {
                nextPositionState = i2;
            }
            smoothScrollToPositionState(nextPositionState);
            dismissTriggerIfNeed();
        }
    }

    public PopupNestedScrollingLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDragTriggerNotified = false;
        this.mLimitOnlyMiddleHeight = true;
        this.mPositionState = 1;
        this.mCurrentScrollY = 0;
        this.mScrollToDismissEnabled = true;
        this.mStyle = 0;
        this.mDismissedOnTouchOutside = true;
        this.isScrollPopupFirstOnTop = false;
        this.mOverScrollInterpolator = PathInterpolatorCompat.a(0.12f, 0.0f, 0.33f, 1.0f);
        this.mNotifyDismissedListener = new Runnable() {
            public void run() {
                PopupNestedScrollingLayout.this.notifyDragTriggered();
            }
        };
        this.mDragTriggerNotifiedPosted = false;
        this.cancelBtnOffset = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PopupNestedScrollingLayout, i, 0);
        this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.PopupNestedScrollingLayout_mzLayoutMaxHeight, -1);
        this.mTopPadding = obtainStyledAttributes.getDimensionPixelSize(R.styleable.PopupNestedScrollingLayout_mzTopPadding, getResources().getDimensionPixelSize(R.dimen.mz_lite_popup_padding_top));
        obtainStyledAttributes.recycle();
        this.mScroller = new OverScroller(context, SCROLLER_INTERPOLATOR);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mMinFlingVelocity = (float) viewConfiguration.getScaledMinimumFlingVelocity();
        this.mAbandonVelocity = (float) getResources().getDimensionPixelSize(R.dimen.mz_config_popup_nested_scroll_abandon_velocity);
        this.mFlingDownVelocity = (float) getResources().getDimensionPixelSize(R.dimen.mz_config_popup_nested_fling_down_velocity);
        this.mVelocityTracker = VelocityTracker.obtain();
        setClipToPadding(false);
        this.mScrollSlop = viewConfiguration.getScaledTouchSlop();
        this.mOverScrollDistance = context.getResources().getDimensionPixelSize(R.dimen.mz_lite_popup_over_scroll_distance);
        this.mDismissTriggeredDistance = context.getResources().getDimensionPixelSize(R.dimen.mz_lite_popup_dismiss_triggered_distance);
        this.mScrollDownThreshold = context.getResources().getDimensionPixelSize(R.dimen.mz_lite_popup_scroll_down_threshold);
        this.mExpectUncollapsibleHeight = context.getResources().getDimensionPixelSize(R.dimen.mz_lite_popup_middle_state_height);
        SpringAnimation springAnimation = new SpringAnimation(new FloatValueHolder());
        this.mSpringAnimation = springAnimation;
        springAnimation.c(new DynamicAnimation.OnAnimationUpdateListener() {
            public void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f2) {
                PopupNestedScrollingLayout.this.performScrollTo((int) f);
            }
        });
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        boolean alignParentBottom;
        boolean ignoreParentPadding;
        boolean listView;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PopupNestedScrollingLayout_LayoutParams);
            this.alignParentBottom = obtainStyledAttributes.getBoolean(R.styleable.PopupNestedScrollingLayout_LayoutParams_layout_nested_alignParentBottom, false);
            this.ignoreParentPadding = obtainStyledAttributes.getBoolean(R.styleable.PopupNestedScrollingLayout_LayoutParams_layout_nested_ignoreParentPadding, false);
            this.listView = obtainStyledAttributes.getBoolean(R.styleable.PopupNestedScrollingLayout_LayoutParams_layout_nested_scrollview, false);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.alignParentBottom = layoutParams.alignParentBottom;
            this.ignoreParentPadding = layoutParams.ignoreParentPadding;
            this.listView = layoutParams.listView;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    private int getNextPositionState(int i) {
        if (!this.mScrollToDismissEnabled && this.mStyle != 0) {
            return i;
        }
        int i2 = this.mCurrentScrollY - (i == 0 ? this.mCollapsibleHeight : i == 1 ? 0 : -this.mUncollapsibleHeight);
        int abs = Math.abs(i2);
        if (i2 > 0) {
            if (i == 2) {
                int i3 = this.mUncollapsibleHeight;
                int i4 = this.mScrollDownThreshold;
                if (abs > i3 + i4) {
                    return 0;
                }
                if (abs > i4) {
                    return 1;
                }
                return 2;
            } else if (i == 1) {
                return (abs <= this.mScrollDownThreshold || this.mStyle != 0) ? 1 : 0;
            } else {
                return 0;
            }
        } else if (i == 0) {
            if (this.mStyle != 2) {
                int i5 = this.mCollapsibleHeight;
                int i6 = this.mScrollDownThreshold;
                if (abs <= i5 + i6 || !this.mScrollToDismissEnabled || this.mContentScrolled) {
                    return abs > i6 ? 1 : 0;
                }
                return 2;
            } else if (abs <= this.mScrollDownThreshold || !this.mScrollToDismissEnabled) {
                return 0;
            } else {
                return 2;
            }
        } else if (i != 1) {
            return 2;
        } else {
            if (abs <= this.mScrollDownThreshold || !this.mScrollToDismissEnabled || this.mContentScrolled) {
                return 1;
            }
            return 2;
        }
    }
}
