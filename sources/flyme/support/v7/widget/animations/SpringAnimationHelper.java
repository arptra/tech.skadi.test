package flyme.support.v7.widget.animations;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import flyme.support.v7.util.DimensionUtil;
import java.util.ArrayList;
import java.util.List;

public class SpringAnimationHelper {
    private static final boolean DEBUG = false;
    private static final float DEFAULT_EDGE_VELOCITY_FACTOR = 1.0f;
    private static final float DEFAULT_SPRING_DAMPING = 0.99f;
    private static final float DEFAULT_SPRING_STIFFNESS = 228.0f;
    private static final double HUMAN_FACTOR_ANGLE = 15.0d;
    public static final int OVERSCROLL_STATE_DRAGGING = 1;
    public static final int OVERSCROLL_STATE_IDLE = 0;
    public static final int OVERSCROLL_STATE_SETTLING = 2;
    public static final int SCROLL_HORIZONTALLY = 0;
    private static final int SCROLL_INVALID = -1;
    public static final int SCROLL_VERTICALLY = 1;
    private static final String TAG = "SpringAnimationHelper";
    private boolean mBtmOverScrollEnable;
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    public float mCurrentDistance;
    private float mDamping;
    private boolean mEndOverScrollEnable;
    private boolean mHasNestedScrollStart;
    private int mLastTouchX;
    private int mLastTouchY;
    /* access modifiers changed from: private */
    public float mLastTranslation;
    private int mMaxTranslation;
    private int mMinFlingVelocity;
    private boolean mOverScrollEnable;
    private List<GlobalOverScrollListener> mOverScrollListeners;
    /* access modifiers changed from: private */
    public int mOverScrollState;
    /* access modifiers changed from: private */
    public OverScroller mOverScroller;
    private int mPointerIndex;
    private final int[] mScreenOffset;
    private final int[] mScrollConsumed;
    private int mScrollDirection;
    private NestedScrollingChildHelper mScrollingChildHelper;
    private float mSettlingFinalTranslation;
    private boolean mShouldActionUpRollback;
    private boolean mShouldInterceptTouch;
    private SpringAnimation mSpringAnimation;
    private boolean mStartOverScrollEnable;
    private float mStiffness;
    /* access modifiers changed from: private */
    public final View mTarget;
    private boolean mTopOverScrollEnable;
    private float mTotalPullDistance;
    private float mVelocityFactor;
    private final ViewFlinger mViewFlinger;
    private int mViewPortRange;

    public class ViewFlinger implements Runnable {
        private int mVelocityX;
        private int mVelocityY;

        public ViewFlinger() {
            OverScroller unused = SpringAnimationHelper.this.mOverScroller = new OverScroller(SpringAnimationHelper.this.mContext);
        }

        public void abortAnimation() {
            if (!SpringAnimationHelper.this.mOverScroller.isFinished()) {
                SpringAnimationHelper.this.mOverScroller.abortAnimation();
            }
        }

        public void fling(int i, int i2) {
            this.mVelocityX = i;
            this.mVelocityY = i2;
            SpringAnimationHelper.this.mOverScroller.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            postOnAnimation();
        }

        public void postOnAnimation() {
            SpringAnimationHelper.this.mTarget.removeCallbacks(this);
            SpringAnimationHelper.this.mTarget.postOnAnimation(this);
        }

        public void run() {
            if (SpringAnimationHelper.this.mOverScroller.computeScrollOffset() && !SpringAnimationHelper.this.mOverScroller.isFinished()) {
                boolean access$800 = SpringAnimationHelper.this.canScrollDown();
                boolean access$900 = SpringAnimationHelper.this.canScrollUp();
                SpringAnimationHelper.this.mOverScroller.getCurrVelocity();
                int i = this.mVelocityY;
                boolean z = false;
                boolean z2 = true;
                if ((i < 0 && !access$800) || (i > 0 && !access$900)) {
                    if (SpringAnimationHelper.this.mOverScroller.getStartY() > SpringAnimationHelper.this.mOverScroller.getCurrY()) {
                        z = true;
                    }
                    float currVelocity = SpringAnimationHelper.this.mOverScroller.getCurrVelocity();
                    SpringAnimationHelper springAnimationHelper = SpringAnimationHelper.this;
                    if (!z) {
                        currVelocity = -currVelocity;
                    }
                    springAnimationHelper.notifyOverScroll(currVelocity, true);
                    abortAnimation();
                } else if ((this.mVelocityX >= 0 || SpringAnimationHelper.this.canScrollRight()) && (this.mVelocityX <= 0 || SpringAnimationHelper.this.canScrollLeft())) {
                    postOnAnimation();
                } else {
                    if (SpringAnimationHelper.this.mOverScroller.getStartX() <= SpringAnimationHelper.this.mOverScroller.getCurrX()) {
                        z2 = false;
                    }
                    float currVelocity2 = SpringAnimationHelper.this.mOverScroller.getCurrVelocity();
                    SpringAnimationHelper springAnimationHelper2 = SpringAnimationHelper.this;
                    if (!z2) {
                        currVelocity2 = -currVelocity2;
                    }
                    springAnimationHelper2.notifyOverScroll(currVelocity2, false);
                    abortAnimation();
                }
            }
        }
    }

    public SpringAnimationHelper(Context context, View view) {
        this(context, view, (OverScroller) null);
    }

    private void abortSpringAnimation() {
        SpringAnimation springAnimation = this.mSpringAnimation;
        if (springAnimation != null && springAnimation.h()) {
            this.mSpringAnimation.d();
        }
    }

    /* access modifiers changed from: private */
    public boolean canScrollDown() {
        if (getTranslationY() != 0.0f) {
            return false;
        }
        int[] iArr = this.mScreenOffset;
        iArr[1] = 0;
        int[] iArr2 = this.mScrollConsumed;
        iArr2[1] = 0;
        dispatchNestedScroll(-1, iArr, iArr2);
        int[] iArr3 = this.mScrollConsumed;
        boolean z = iArr3[1] != 0;
        if (z) {
            int[] iArr4 = this.mScreenOffset;
            iArr4[1] = 0;
            iArr3[1] = 0;
            dispatchNestedPreScroll(1, iArr3, iArr4);
        }
        return this.mTarget.canScrollVertically(-1) || z;
    }

    /* access modifiers changed from: private */
    public boolean canScrollLeft() {
        return this.mTarget.canScrollHorizontally(1);
    }

    /* access modifiers changed from: private */
    public boolean canScrollRight() {
        return this.mTarget.canScrollHorizontally(-1);
    }

    /* access modifiers changed from: private */
    public boolean canScrollUp() {
        int[] iArr = this.mScreenOffset;
        iArr[1] = 0;
        int[] iArr2 = this.mScrollConsumed;
        iArr2[1] = 0;
        dispatchNestedPreScroll(1, iArr2, iArr);
        int[] iArr3 = this.mScrollConsumed;
        boolean z = iArr3[1] != 0;
        if (z) {
            int[] iArr4 = this.mScreenOffset;
            iArr4[1] = 0;
            iArr3[1] = 0;
            dispatchNestedScroll(-1, iArr4, iArr3);
        }
        return this.mTarget.canScrollVertically(1) || z;
    }

    private boolean dispatchNestedPreScroll(int i, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().d(0, i, iArr, iArr2, 0);
    }

    private void dispatchNestedScroll(int i, int[] iArr, @NonNull int[] iArr2) {
        getScrollingChildHelper().e(0, 0, 0, i, iArr, 0, iArr2);
    }

    /* access modifiers changed from: private */
    public void dispatchOverScrollStateChanged() {
        List<GlobalOverScrollListener> list = this.mOverScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOverScrollListeners.get(size).onOverScrollStateChanged(this.mTarget, this.mOverScrollState);
            }
        }
    }

    private Pair<Integer, Integer> getScreenSize(@NonNull Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return new Pair<>(Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
    }

    private NestedScrollingChildHelper getScrollingChildHelper() {
        if (this.mScrollingChildHelper == null) {
            NestedScrollingChildHelper nestedScrollingChildHelper = new NestedScrollingChildHelper(this.mTarget);
            this.mScrollingChildHelper = nestedScrollingChildHelper;
            nestedScrollingChildHelper.n(true);
        }
        return this.mScrollingChildHelper;
    }

    /* access modifiers changed from: private */
    public float getTranslationX() {
        return this.mTarget.getTranslationX();
    }

    /* access modifiers changed from: private */
    public float getTranslationY() {
        return this.mTarget.getTranslationY();
    }

    private int getViewPortRange() {
        View view;
        if (this.mViewPortRange == 0 && (view = this.mTarget) != null) {
            this.mViewPortRange = (int) DimensionUtil.px2dip(this.mContext, (float) (this.mScrollDirection == 1 ? view.getHeight() : view.getWidth()));
        }
        return this.mViewPortRange;
    }

    private int getX(MotionEvent motionEvent, int i) {
        return (int) motionEvent.getRawX(i);
    }

    private int getY(MotionEvent motionEvent, int i) {
        return (int) motionEvent.getRawY(i);
    }

    private void handleOverScrollHorizontally(int i) {
        boolean z = i < 0 ? true : true;
        boolean canScrollRight = canScrollRight();
        boolean canScrollLeft = canScrollLeft();
        float translationX = getTranslationX();
        boolean z2 = (z && translationX > 0.0f) || (z && translationX < 0.0f);
        float onPullDistance = onPullDistance((float) i, z2);
        if (z2) {
            setTranslationXAndDispatch(z ? Math.max(0.0f, onPullDistance) : Math.min(0.0f, onPullDistance));
        } else if (z && !canScrollRight && this.mStartOverScrollEnable) {
            setTranslationXAndDispatch(onPullDistance);
        } else if (!z || canScrollLeft || !this.mEndOverScrollEnable) {
            resetPullDistance();
        } else {
            setTranslationXAndDispatch(onPullDistance);
        }
    }

    private void handleOverScrollVertically(int i) {
        if (i != 0) {
            boolean z = false;
            boolean z2 = i < 0;
            if (z2 && !this.mTopOverScrollEnable) {
                return;
            }
            if (z2 || this.mBtmOverScrollEnable) {
                float translationY = getTranslationY();
                if ((z2 && translationY < 0.0f) || (!z2 && translationY > 0.0f)) {
                    z = true;
                }
                float onPullDistance = onPullDistance((float) i, z);
                if (z2) {
                    boolean canScrollDown = canScrollDown();
                    if (canScrollDown && !z) {
                        resetPullDistance();
                    }
                    if (canScrollDown || z) {
                        onPullDistance = Math.min(0.0f, onPullDistance);
                    }
                } else {
                    boolean canScrollUp = canScrollUp();
                    if (canScrollUp && !z) {
                        resetPullDistance();
                    }
                    if (canScrollUp || z) {
                        onPullDistance = Math.max(0.0f, onPullDistance);
                    }
                }
                setTranslationYAndDispatch(onPullDistance);
            }
        }
    }

    private SpringAnimation handleSpringAnimation(final boolean z, float f) {
        SpringAnimation y = new SpringAnimation(this.mTarget, z ? DynamicAnimation.n : DynamicAnimation.m).y(new SpringForce(f).d(this.mDamping).f(this.mStiffness));
        this.mSpringAnimation = y;
        y.c(new DynamicAnimation.OnAnimationUpdateListener() {
            public void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f2) {
                SpringAnimationHelper springAnimationHelper = SpringAnimationHelper.this;
                springAnimationHelper.dispatchOverScroll(springAnimationHelper.getTranslationX(), SpringAnimationHelper.this.getTranslationY());
                SpringAnimationHelper springAnimationHelper2 = SpringAnimationHelper.this;
                float unused = springAnimationHelper2.mCurrentDistance = z ? springAnimationHelper2.getTranslationY() : springAnimationHelper2.getTranslationX();
            }
        });
        this.mSpringAnimation.b(new DynamicAnimation.OnAnimationEndListener() {
            public void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z, float f, float f2) {
                float unused = SpringAnimationHelper.this.mLastTranslation = 0.0f;
                if (!z) {
                    int unused2 = SpringAnimationHelper.this.mOverScrollState = 0;
                    SpringAnimationHelper.this.dispatchOverScrollStateChanged();
                }
            }
        });
        this.mOverScrollState = 2;
        dispatchOverScrollStateChanged();
        return this.mSpringAnimation;
    }

    private void initMaxTranslation() {
        if (this.mMaxTranslation == 0) {
            Pair<Integer, Integer> screenSize = getScreenSize(this.mContext);
            int i = this.mScrollDirection;
            if (i == 1) {
                this.mMaxTranslation = ((Integer) screenSize.second).intValue();
            } else if (i == 0) {
                this.mMaxTranslation = ((Integer) screenSize.first).intValue();
            }
        }
    }

    private void initVelocity(Context context) {
        this.mMinFlingVelocity = ViewConfiguration.get(context).getScaledMinimumFlingVelocity();
    }

    /* access modifiers changed from: private */
    public void notifyOverScroll(float f, boolean z) {
        if (this.mOverScrollEnable) {
            if (Math.abs(f) < ((float) this.mMinFlingVelocity)) {
                Log.w(TAG, "velocity minus minVelocity:" + this.mMinFlingVelocity);
                return;
            }
            ((SpringAnimation) handleSpringAnimation(z, 0.0f).o(f * this.mVelocityFactor)).q();
        }
    }

    private void onActionDown() {
        ViewFlinger viewFlinger = this.mViewFlinger;
        if (viewFlinger != null) {
            viewFlinger.abortAnimation();
        }
        abortSpringAnimation();
        startNestedScroll(this.mScrollDirection == 1 ? 2 : 1);
        this.mHasNestedScrollStart = true;
    }

    private void onActionMove(MotionEvent motionEvent) {
        if (this.mOverScrollEnable) {
            abortSpringAnimation();
            ViewFlinger viewFlinger = this.mViewFlinger;
            if (viewFlinger != null) {
                viewFlinger.abortAnimation();
            }
            int findPointerIndex = motionEvent.findPointerIndex(this.mPointerIndex);
            if (findPointerIndex < 0) {
                Log.w(TAG, "Error processing scroll, pointer index for id " + this.mPointerIndex + " not found. Did any MotionEvent get skipped?");
                findPointerIndex = 0;
                this.mPointerIndex = motionEvent.getPointerId(0);
                this.mLastTouchY = (int) motionEvent.getRawY();
                this.mLastTouchX = (int) motionEvent.getRawX();
            }
            initMaxTranslation();
            if (!this.mHasNestedScrollStart) {
                startNestedScroll(this.mScrollDirection == 1 ? 2 : 1);
            }
            int y = this.mLastTouchY - getY(motionEvent, findPointerIndex);
            int x = this.mLastTouchX - getX(motionEvent, findPointerIndex);
            int i = this.mScrollDirection;
            if (i == 1) {
                handleOverScrollVertically(y);
            } else if (i == 0) {
                handleOverScrollHorizontally(x);
            }
            resetTouchPoint(motionEvent, findPointerIndex);
        }
    }

    private void onActionUp() {
        stopNestedScroll();
        this.mHasNestedScrollStart = false;
        this.mShouldInterceptTouch = false;
        if (!this.mShouldActionUpRollback) {
            this.mLastTouchY = 0;
            this.mLastTouchX = 0;
            dispatchOverScroll(getTranslationX(), getTranslationY());
            return;
        }
        if (getTranslationY() != 0.0f) {
            handleSpringAnimation(true, this.mSettlingFinalTranslation).q();
        } else if (getTranslationX() != 0.0f) {
            handleSpringAnimation(false, this.mSettlingFinalTranslation).q();
        } else if (getTranslationY() == 0.0f || getTranslationX() == 0.0f) {
            this.mOverScrollState = 0;
        }
        this.mLastTouchX = 0;
        this.mLastTouchY = 0;
    }

    private void onPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mPointerIndex) {
            int i = actionIndex == 0 ? 1 : 0;
            this.mPointerIndex = motionEvent.getPointerId(i);
            this.mLastTouchX = getX(motionEvent, i);
            this.mLastTouchY = getY(motionEvent, i);
        }
    }

    private float onPullDistance(float f, boolean z) {
        float px2dip = DimensionUtil.px2dip(this.mContext, f);
        if (z || this.mOverScrollState != 1) {
            this.mTotalPullDistance = InfinityStretch.distance(Math.abs(DimensionUtil.px2dip(this.mContext, this.mCurrentDistance)), (float) getViewPortRange()) * Math.signum(-this.mCurrentDistance);
        }
        float f2 = this.mTotalPullDistance + px2dip;
        this.mTotalPullDistance = f2;
        float dp2Px = DimensionUtil.dp2Px(this.mContext, (-InfinityStretch.offset(Math.abs(f2), (float) getViewPortRange())) * Math.signum(f2));
        this.mCurrentDistance = dp2Px;
        return dp2Px;
    }

    private void resetPullDistance() {
        this.mCurrentDistance = 0.0f;
        this.mTotalPullDistance = 0.0f;
    }

    private void resetTouchPoint(MotionEvent motionEvent, int i) {
        this.mLastTouchX = getX(motionEvent, i);
        this.mLastTouchY = getY(motionEvent, i);
    }

    private void setTranslationX(float f) {
        this.mTarget.setTranslationX(f);
    }

    private void setTranslationXAndDispatch(float f) {
        setTranslationX(f);
        int i = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
        if (i != 0 && this.mLastTranslation == 0.0f) {
            this.mOverScrollState = 1;
            dispatchOverScrollStateChanged();
        }
        if (!(i == 0 && this.mLastTranslation == 0.0f)) {
            dispatchOverScroll(f, getTranslationY());
        }
        this.mLastTranslation = f;
    }

    private void setTranslationY(float f) {
        this.mTarget.setTranslationY(f);
    }

    private void setTranslationYAndDispatch(float f) {
        setTranslationY(f);
        if (Float.compare(f, 0.0f) != 0 && Float.compare(this.mLastTranslation, 0.0f) == 0) {
            this.mOverScrollState = 1;
            dispatchOverScrollStateChanged();
        }
        if (!(Float.compare(f, 0.0f) == 0 && Float.compare(this.mLastTranslation, 0.0f) == 0)) {
            dispatchOverScroll(getTranslationX(), f);
        }
        this.mLastTranslation = f;
    }

    private boolean shouldIntercept(int i, int i2) {
        boolean z = false;
        if (getTranslationX() != 0.0f || getTranslationY() != 0.0f) {
            return false;
        }
        if (this.mShouldInterceptTouch) {
            return true;
        }
        int i3 = this.mScrollDirection;
        if (i3 == 1) {
            if (Math.tan(Math.toRadians(HUMAN_FACTOR_ANGLE)) > ((double) (((float) Math.abs(i)) / ((float) Math.abs(i2))))) {
                z = true;
            }
            this.mShouldInterceptTouch = z;
        } else if (i3 == 0) {
            if (Math.tan(Math.toRadians(HUMAN_FACTOR_ANGLE)) > ((double) (((float) Math.abs(i2)) / ((float) Math.abs(i))))) {
                z = true;
            }
            this.mShouldInterceptTouch = z;
        }
        return this.mShouldInterceptTouch;
    }

    private boolean startNestedScroll(int i) {
        return getScrollingChildHelper().q(i, 0);
    }

    private void stopNestedScroll() {
        getScrollingChildHelper().s(0);
    }

    public void addOnOverScrollListener(@NonNull GlobalOverScrollListener globalOverScrollListener) {
        if (this.mOverScrollListeners == null) {
            this.mOverScrollListeners = new ArrayList();
        }
        this.mOverScrollListeners.add(globalOverScrollListener);
    }

    public void animateTo() {
        animateTo(this.mSettlingFinalTranslation);
    }

    public void clearOnOverScrollListener() {
        List<GlobalOverScrollListener> list = this.mOverScrollListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void dispatchOverScroll(float f, float f2) {
        List<GlobalOverScrollListener> list = this.mOverScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOverScrollListeners.get(size).onOverScroll(this.mTarget, f, f2);
            }
        }
    }

    public void fling(int i, int i2) {
        if (this.mOverScrollEnable) {
            if (Math.abs(i) < this.mMinFlingVelocity && Math.abs(i2) < this.mMinFlingVelocity) {
                return;
            }
            if (i2 < 0 && !this.mTopOverScrollEnable) {
                return;
            }
            if (i2 > 0 && !this.mBtmOverScrollEnable) {
                return;
            }
            if (i < 0 && !this.mStartOverScrollEnable) {
                return;
            }
            if (i <= 0 || this.mEndOverScrollEnable) {
                SpringAnimation springAnimation = this.mSpringAnimation;
                if (springAnimation == null || !springAnimation.h()) {
                    ViewFlinger viewFlinger = this.mViewFlinger;
                    if (viewFlinger != null) {
                        viewFlinger.fling(i, i2);
                        return;
                    }
                    return;
                }
                Log.w(TAG, "animation already running....");
            }
        }
    }

    public boolean isBottomOverScrollEnable() {
        return this.mBtmOverScrollEnable;
    }

    public boolean isEndOverScrollEnable() {
        return this.mEndOverScrollEnable;
    }

    public boolean isOverScrollDynamic() {
        int i = this.mOverScrollState;
        return i == 1 || i == 2;
    }

    public boolean isOverScrollEnable() {
        return this.mOverScrollEnable;
    }

    public boolean isStartOverScrollEnable() {
        return this.mStartOverScrollEnable;
    }

    public boolean isTopOverScrollEnable() {
        return this.mTopOverScrollEnable;
    }

    public void onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null && this.mOverScrollEnable) {
            int actionMasked = motionEvent.getActionMasked();
            motionEvent.getActionIndex();
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked != 2) {
                        if (actionMasked != 3) {
                            return;
                        }
                    }
                }
                onActionUp();
                return;
            }
            this.mPointerIndex = motionEvent.getPointerId(0);
            onActionDown();
            resetTouchPoint(motionEvent, 0);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null && this.mOverScrollEnable) {
            int actionMasked = motionEvent.getActionMasked();
            int actionIndex = motionEvent.getActionIndex();
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked != 2) {
                        if (actionMasked != 3) {
                            if (actionMasked == 5) {
                                this.mPointerIndex = motionEvent.getPointerId(actionIndex);
                                onActionDown();
                                resetTouchPoint(motionEvent, actionIndex);
                            } else if (actionMasked == 6) {
                                onPointerUp(motionEvent);
                            }
                        }
                    } else if (this.mLastTouchX == 0 && this.mLastTouchY == 0) {
                        resetTouchPoint(motionEvent, actionIndex);
                        return false;
                    } else {
                        onActionMove(motionEvent);
                        if (!(getTranslationX() == 0.0f && getTranslationY() == 0.0f)) {
                            return true;
                        }
                    }
                }
                onActionUp();
            } else {
                this.mPointerIndex = motionEvent.getPointerId(0);
                onActionDown();
                resetTouchPoint(motionEvent, 0);
            }
        }
        return false;
    }

    public void removeOverScrollListener(@NonNull GlobalOverScrollListener globalOverScrollListener) {
        List<GlobalOverScrollListener> list = this.mOverScrollListeners;
        if (list != null) {
            list.remove(globalOverScrollListener);
        }
    }

    public void setBottomOverScrollEnable(boolean z) {
        this.mBtmOverScrollEnable = z;
    }

    public void setDamping(@FloatRange float f) {
        this.mDamping = f;
    }

    public void setEdgeVelocityFactor(@FloatRange float f) {
        this.mVelocityFactor = f;
    }

    public void setEndOverScrollEnable(boolean z) {
        this.mEndOverScrollEnable = z;
    }

    public void setInterpolator(@Nullable Interpolator interpolator) {
    }

    public void setLayoutDirection(int i) {
        this.mScrollDirection = i;
    }

    public void setOverScrollEnable(boolean z) {
        this.mOverScrollEnable = z;
    }

    public void setSettlingPosition(float f) {
        this.mSettlingFinalTranslation = f;
    }

    public void setShouldActionUpRollback(boolean z) {
        this.mShouldActionUpRollback = z;
    }

    public void setStartOverScrollEnable(boolean z) {
        this.mStartOverScrollEnable = z;
    }

    public void setStiffness(@FloatRange float f) {
        this.mStiffness = f;
    }

    public void setTopOverScrollEnable(boolean z) {
        this.mTopOverScrollEnable = z;
    }

    public SpringAnimationHelper(@NonNull Context context, @NonNull View view, @Nullable OverScroller overScroller) {
        this(context, view, overScroller, -1);
    }

    public void animateTo(float f) {
        animateTo(f, true);
    }

    public SpringAnimationHelper(@NonNull Context context, @NonNull View view, @Nullable OverScroller overScroller, int i) {
        this.mVelocityFactor = 1.0f;
        this.mOverScrollEnable = true;
        this.mTopOverScrollEnable = true;
        this.mBtmOverScrollEnable = true;
        this.mStartOverScrollEnable = true;
        this.mEndOverScrollEnable = true;
        this.mDamping = DEFAULT_SPRING_DAMPING;
        this.mStiffness = DEFAULT_SPRING_STIFFNESS;
        this.mShouldActionUpRollback = true;
        this.mSettlingFinalTranslation = 0.0f;
        this.mOverScrollState = 0;
        this.mScreenOffset = new int[2];
        this.mScrollConsumed = new int[2];
        this.mHasNestedScrollStart = false;
        this.mTotalPullDistance = 0.0f;
        this.mCurrentDistance = 0.0f;
        this.mViewPortRange = 0;
        this.mContext = context;
        this.mTarget = view;
        this.mScrollDirection = i;
        if (overScroller == null) {
            this.mOverScroller = new OverScroller(context);
        } else {
            this.mOverScroller = overScroller;
        }
        this.mViewFlinger = new ViewFlinger();
        initVelocity(context);
    }

    public void animateTo(float f, boolean z) {
        boolean z2 = true;
        if (z) {
            abortSpringAnimation();
            if (this.mScrollDirection != 1) {
                z2 = false;
            }
            handleSpringAnimation(z2, f).q();
            return;
        }
        if (this.mScrollDirection == 1) {
            this.mTarget.setTranslationY(f);
        } else {
            this.mTarget.setTranslationX(f);
        }
        dispatchOverScroll(this.mTarget.getTranslationX(), this.mTarget.getTranslationY());
    }
}
