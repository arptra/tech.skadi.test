package flyme.support.v7.widget;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class OverScrollLayout extends FrameLayout implements NestedScrollingParent {
    private static final float DEFAULT_CONFICT_RATIO = 1.0f;
    private static final int DEFAULT_EDGE_DISTANCE_START_OVERSCROLL = 50;
    private static final int FINGER_MOVE_DOWN = 1;
    private static final int FINGER_MOVE_LEFT = 0;
    private static final int FINGER_MOVE_RIGHT = 1;
    private static final int FINGER_MOVE_UP = 0;
    private static final float MAXOVERSCROLLRATE = 0.5f;
    private static final String TAG = "OverScrollLayout";
    static final Interpolator sQuinticInterpolator = new Interpolator() {
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    private boolean canScrollDownAtActionDown;
    private boolean canScrollLeftAtActionDown;
    private boolean canScrollRightAtActionDown;
    private boolean canScrollUpAtActionDown;
    private int mAntiShakeValue;
    private float mConfictRatio;
    private int mDownX;
    private int mDownY;
    /* access modifiers changed from: private */
    public int mFingerDir;
    /* access modifiers changed from: private */
    public OverFlingRunnable mFlingRun;
    private boolean mForbidOverScrollInMutiChoiceState;
    HorizonalFlingRunnable mHorizonalFlingRunnable;
    /* access modifiers changed from: private */
    public RecyclerView.OnScrollListener mListener;
    int mMotionX;
    int mMotionY;
    private NestedScrollingParentHelper mNestedScrollingParent;
    /* access modifiers changed from: private */
    public int mOrientation;
    private TimeInterpolator mOverScrollInterpolator;
    /* access modifiers changed from: private */
    public OverScroller mOverScroller;
    int mOverscrollDistance;
    /* access modifiers changed from: private */
    public MzRecyclerView mRecyclerView;
    private VelocityTracker mVelocityTracker;
    VerticalFlingRunnable mVerticalFlingRunnable;

    public class HorizonalFlingRunnable implements Runnable {
        private final flyme.support.v7.util.OverScroller mScroller;

        public HorizonalFlingRunnable() {
            this.mScroller = new flyme.support.v7.util.OverScroller(OverScrollLayout.this.getContext());
        }

        public void endFling() {
            OverScrollLayout.this.removeCallbacks(this);
            this.mScroller.abortAnimation();
        }

        public void run() {
            flyme.support.v7.util.OverScroller overScroller = this.mScroller;
            if (overScroller.computeScrollOffset()) {
                int scrollX = OverScrollLayout.this.getScrollX();
                int currX = overScroller.getCurrX();
                OverScrollLayout overScrollLayout = OverScrollLayout.this;
                if (!overScrollLayout.overScrollBy(currX - scrollX, 0, scrollX, 0, 0, 0, overScrollLayout.mOverscrollDistance, 0, false)) {
                    OverScrollLayout.this.invalidate();
                    OverScrollLayout.this.postOnAnimation(this);
                } else if ((scrollX > 0 || currX <= 0) && (scrollX < 0 || currX >= 0)) {
                    startSpringback();
                } else {
                    overScroller.abortAnimation();
                }
            } else {
                endFling();
            }
        }

        public void startSpringback() {
            if (this.mScroller.springBack(OverScrollLayout.this.getScrollX(), 0, 0, 0, 0, 0)) {
                OverScrollLayout.this.invalidate();
                OverScrollLayout.this.postOnAnimation(this);
            }
        }
    }

    public class OverFlingRunnable implements Runnable {
        private int mLastoffsize;
        private final flyme.support.v7.util.OverScroller mScroller;
        private int mVelocity;

        public OverFlingRunnable() {
            this.mScroller = new flyme.support.v7.util.OverScroller(OverScrollLayout.this.getContext(), OverScrollLayout.sQuinticInterpolator);
        }

        public void endFling() {
            OverScrollLayout.this.removeCallbacks(this);
            this.mScroller.abortAnimation();
        }

        public void fling(int i, int i2) {
            this.mVelocity = i2;
            flyme.support.v7.util.OverScroller overScroller = this.mScroller;
            int i3 = OverScrollLayout.this.mOverscrollDistance;
            overScroller.fling(0, 0, i, i2, 0, 0, 0, 0, i3, i3);
            this.mLastoffsize = 0;
            OverScrollLayout.this.postOnAnimation(this);
        }

        public void run() {
            flyme.support.v7.util.OverScroller overScroller = this.mScroller;
            if (!overScroller.computeScrollOffset()) {
                endFling();
                OverScrollLayout.this.startViewSpringback();
            } else if (OverScrollLayout.this.mOrientation == 1) {
                int scrollY = OverScrollLayout.this.getScrollY();
                int currY = overScroller.getCurrY();
                OverScrollLayout overScrollLayout = OverScrollLayout.this;
                if (!overScrollLayout.overScrollBy(0, currY - this.mLastoffsize, 0, overScrollLayout.getScrollY(), 0, 0, 0, OverScrollLayout.this.mOverscrollDistance, false)) {
                    OverScrollLayout.this.invalidate();
                    OverScrollLayout.this.postOnAnimation(this);
                } else if ((scrollY > 0 || currY <= 0) && (scrollY < 0 || currY >= 0)) {
                    startSpringback();
                } else {
                    overScroller.abortAnimation();
                }
                this.mLastoffsize = currY;
            } else {
                int scrollX = OverScrollLayout.this.getScrollX();
                int currX = overScroller.getCurrX();
                OverScrollLayout overScrollLayout2 = OverScrollLayout.this;
                if (!overScrollLayout2.overScrollBy(currX - this.mLastoffsize, 0, overScrollLayout2.getScrollX(), 0, 0, 0, OverScrollLayout.this.mOverscrollDistance, 0, false)) {
                    OverScrollLayout.this.invalidate();
                    OverScrollLayout.this.postOnAnimation(this);
                } else if ((scrollX > 0 || currX <= 0) && (scrollX < 0 || currX >= 0)) {
                    startSpringback();
                } else {
                    overScroller.abortAnimation();
                }
                this.mLastoffsize = currX;
            }
        }

        public void startSpringback() {
            if (this.mScroller.springBack(0, OverScrollLayout.this.getScrollY(), 0, 0, 0, 0)) {
                OverScrollLayout.this.invalidate();
                OverScrollLayout.this.postOnAnimation(this);
            }
        }
    }

    public class VerticalFlingRunnable implements Runnable {
        private final flyme.support.v7.util.OverScroller mScroller;

        public VerticalFlingRunnable() {
            this.mScroller = new flyme.support.v7.util.OverScroller(OverScrollLayout.this.getContext());
        }

        public void endFling() {
            OverScrollLayout.this.removeCallbacks(this);
            this.mScroller.abortAnimation();
        }

        public void run() {
            flyme.support.v7.util.OverScroller overScroller = this.mScroller;
            if (overScroller.computeScrollOffset()) {
                int scrollY = OverScrollLayout.this.getScrollY();
                int currY = overScroller.getCurrY();
                OverScrollLayout overScrollLayout = OverScrollLayout.this;
                if (!overScrollLayout.overScrollBy(0, currY - scrollY, 0, scrollY, 0, 0, 0, overScrollLayout.mOverscrollDistance, false)) {
                    OverScrollLayout.this.invalidate();
                    OverScrollLayout.this.postOnAnimation(this);
                } else if ((scrollY > 0 || currY <= 0) && (scrollY < 0 || currY >= 0)) {
                    startSpringback();
                } else {
                    overScroller.abortAnimation();
                }
            } else {
                endFling();
            }
        }

        public void startSpringback() {
            if (this.mScroller.springBack(0, OverScrollLayout.this.getScrollY(), 0, 0, 0, 0)) {
                OverScrollLayout.this.invalidate();
                OverScrollLayout.this.postOnAnimation(this);
            }
        }
    }

    public OverScrollLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    private boolean canScrollHorizontallyForActionDown(int i) {
        int computeHorizontalScrollOffset = this.mRecyclerView.computeHorizontalScrollOffset();
        int computeHorizontalScrollRange = this.mRecyclerView.computeHorizontalScrollRange() - this.mRecyclerView.computeHorizontalScrollExtent();
        if (computeHorizontalScrollRange == 0) {
            return false;
        }
        return i < 0 ? computeHorizontalScrollOffset > 50 : computeHorizontalScrollOffset < computeHorizontalScrollRange - 50;
    }

    private boolean canScrollVerticallyForActionDown(int i) {
        int computeVerticalScrollOffset = this.mRecyclerView.computeVerticalScrollOffset();
        int computeVerticalScrollRange = this.mRecyclerView.computeVerticalScrollRange() - this.mRecyclerView.computeVerticalScrollExtent();
        if (computeVerticalScrollRange == 0) {
            return false;
        }
        return i < 0 ? computeVerticalScrollOffset > 50 : computeVerticalScrollOffset < computeVerticalScrollRange - 50;
    }

    private boolean findRecyclerView(View view) {
        if (view instanceof RecyclerView) {
            this.mRecyclerView = (MzRecyclerView) view;
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (findRecyclerView(viewGroup.getChildAt(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public int getNewOverflingDistance() {
        return (int) (((float) getHeight()) * 0.5f);
    }

    /* access modifiers changed from: private */
    public boolean needScroll() {
        if (!this.mOverScroller.isFinished()) {
            if (this.mOrientation == 0) {
                if (this.mFingerDir == 0 && !this.mRecyclerView.canScrollHorizontally(1)) {
                    return true;
                }
                if (this.mFingerDir == 1 && !this.mRecyclerView.canScrollHorizontally(-1)) {
                    return true;
                }
            }
            if (this.mOrientation == 1) {
                if (this.mFingerDir != 0 || this.mRecyclerView.canScrollVertically(1)) {
                    return this.mFingerDir == 1 && !this.mRecyclerView.canScrollVertically(-1);
                }
                return true;
            }
        }
    }

    /* access modifiers changed from: private */
    public void startViewSpringback() {
        if (getScrollY() != 0) {
            if (this.mVerticalFlingRunnable == null) {
                this.mVerticalFlingRunnable = new VerticalFlingRunnable();
            }
            this.mVerticalFlingRunnable.startSpringback();
        } else if (getScrollX() != 0) {
            if (this.mHorizonalFlingRunnable == null) {
                this.mHorizonalFlingRunnable = new HorizonalFlingRunnable();
            }
            this.mHorizonalFlingRunnable.startSpringback();
        }
    }

    private int updateIncrementalDelta(int i, int i2) {
        int i3 = this.mOverscrollDistance;
        if (i2 == 0 || i3 == 0) {
            return i;
        }
        if (i2 * i >= 0) {
            return i / 2;
        }
        float interpolation = 1.0f - this.mOverScrollInterpolator.getInterpolation((((float) Math.abs(i2)) * 1.0f) / ((float) i3));
        if (interpolation < 0.0f) {
            interpolation = 0.0f;
        }
        int i4 = (int) (((float) i) * interpolation);
        if (i > 0) {
            if (i4 == 0) {
                i4 = 1;
            }
        } else if (i4 == 0) {
            i4 = -1;
        }
        if (Math.abs(i2) >= i3) {
            i4 = 0;
        }
        return i4;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01da, code lost:
        if (r7 != 3) goto L_0x0342;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003f, code lost:
        if (r7 != 3) goto L_0x0342;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(android.view.MotionEvent r24) {
        /*
            r23 = this;
            r10 = r23
            android.view.VelocityTracker r0 = r10.mVelocityTracker
            if (r0 != 0) goto L_0x000c
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r10.mVelocityTracker = r0
        L_0x000c:
            android.view.VelocityTracker r0 = r10.mVelocityTracker
            r11 = r24
            r0.addMovement(r11)
            int r0 = r10.mOrientation
            r1 = 0
            r2 = 1000(0x3e8, float:1.401E-42)
            r3 = 3
            r4 = 2
            r5 = -1
            r12 = 0
            r13 = 1
            if (r0 != r13) goto L_0x01b8
            flyme.support.v7.widget.MzRecyclerView r0 = r10.mRecyclerView
            boolean r0 = r0.canScrollVertically(r13)
            flyme.support.v7.widget.MzRecyclerView r6 = r10.mRecyclerView
            boolean r6 = r6.canScrollVertically(r5)
            int r7 = r24.getAction()
            float r8 = r24.getY()
            int r14 = (int) r8
            float r8 = r24.getX()
            int r8 = (int) r8
            if (r7 == 0) goto L_0x0190
            if (r7 == r13) goto L_0x015c
            if (r7 == r4) goto L_0x0043
            if (r7 == r3) goto L_0x015c
            goto L_0x0342
        L_0x0043:
            boolean r1 = r10.canScrollVerticallyForActionDown(r13)
            r10.canScrollDownAtActionDown = r1
            boolean r1 = r10.canScrollVerticallyForActionDown(r5)
            r10.canScrollUpAtActionDown = r1
            int r1 = r23.getScrollY()
            if (r1 != 0) goto L_0x00f2
            boolean r1 = r10.mForbidOverScrollInMutiChoiceState
            if (r1 == 0) goto L_0x0067
            flyme.support.v7.widget.MzRecyclerView r1 = r10.mRecyclerView
            java.lang.Boolean r1 = r1.isInMutiChoiceState()
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0067
            goto L_0x0158
        L_0x0067:
            int r1 = r10.mAntiShakeValue
            if (r1 <= 0) goto L_0x0079
            int r1 = r10.mDownY
            int r1 = r14 - r1
            int r1 = java.lang.Math.abs(r1)
            int r2 = r10.mAntiShakeValue
            if (r1 >= r2) goto L_0x0079
            goto L_0x0158
        L_0x0079:
            int r1 = r10.mDownY
            int r1 = r14 - r1
            int r1 = java.lang.Math.abs(r1)
            float r1 = (float) r1
            float r2 = r10.mConfictRatio
            float r1 = r1 * r2
            int r2 = r10.mDownX
            int r8 = r8 - r2
            int r2 = java.lang.Math.abs(r8)
            float r2 = (float) r2
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x0093
            goto L_0x0158
        L_0x0093:
            int r1 = r10.mDownY
            int r2 = r14 - r1
            r3 = 5
            if (r2 <= r3) goto L_0x00a4
            int r2 = r10.mMotionY
            if (r14 <= r2) goto L_0x00a4
            if (r6 != 0) goto L_0x00a4
            boolean r2 = r10.canScrollUpAtActionDown
            if (r2 == 0) goto L_0x00b1
        L_0x00a4:
            int r1 = r1 - r14
            if (r1 <= r3) goto L_0x0158
            int r1 = r10.mMotionY
            if (r14 >= r1) goto L_0x0158
            if (r0 != 0) goto L_0x0158
            boolean r0 = r10.canScrollDownAtActionDown
            if (r0 != 0) goto L_0x0158
        L_0x00b1:
            int r0 = r10.mMotionY
            int r0 = r14 - r0
            int r1 = r23.getScrollY()
            int r0 = r10.updateIncrementalDelta(r0, r1)
            int r2 = -r0
            int r4 = r23.getScrollY()
            int r8 = r10.mOverscrollDistance
            r9 = 1
            r1 = 0
            r3 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r0 = r23
            r0.overScrollBy(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            long r15 = android.os.SystemClock.uptimeMillis()
            long r17 = r24.getEventTime()
            float r20 = r24.getX()
            float r21 = r24.getY()
            int r22 = r24.getMetaState()
            r19 = 3
            android.view.MotionEvent r0 = android.view.MotionEvent.obtain(r15, r17, r19, r20, r21, r22)
            super.dispatchTouchEvent(r0)
            r0.recycle()
            r10.mMotionY = r14
            return r13
        L_0x00f2:
            int r0 = r10.mMotionY
            if (r14 == r0) goto L_0x0158
            int r0 = r14 - r0
            int r1 = r23.getScrollY()
            int r0 = r10.updateIncrementalDelta(r0, r1)
            int r1 = r23.getScrollY()
            int r2 = r1 - r0
            int r3 = -r0
            if (r2 > 0) goto L_0x010b
            if (r1 > 0) goto L_0x010f
        L_0x010b:
            if (r2 < 0) goto L_0x0113
            if (r1 >= 0) goto L_0x0113
        L_0x010f:
            int r1 = -r1
            r15 = r0
            r2 = r1
            goto L_0x0115
        L_0x0113:
            r2 = r3
            r15 = r12
        L_0x0115:
            if (r2 == 0) goto L_0x0128
            int r4 = r23.getScrollY()
            int r8 = r10.mOverscrollDistance
            r9 = 1
            r1 = 0
            r3 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r0 = r23
            r0.overScrollBy(r1, r2, r3, r4, r5, r6, r7, r8, r9)
        L_0x0128:
            if (r15 == 0) goto L_0x0155
            int r0 = r23.getScrollY()
            if (r0 == 0) goto L_0x0136
            r10.setScrollY(r12)
            r23.invalidateParentIfNeeded()
        L_0x0136:
            long r1 = android.os.SystemClock.uptimeMillis()
            long r3 = r24.getEventTime()
            float r6 = r24.getX()
            float r7 = r24.getY()
            int r8 = r24.getMetaState()
            r5 = 0
            android.view.MotionEvent r0 = android.view.MotionEvent.obtain(r1, r3, r5, r6, r7, r8)
            super.dispatchTouchEvent(r0)
            r0.recycle()
        L_0x0155:
            r10.mMotionY = r14
            return r13
        L_0x0158:
            r10.mMotionY = r14
            goto L_0x0342
        L_0x015c:
            r10.canScrollDownAtActionDown = r13
            r10.canScrollUpAtActionDown = r13
            android.view.VelocityTracker r0 = r10.mVelocityTracker
            r0.computeCurrentVelocity(r2)
            android.view.VelocityTracker r0 = r10.mVelocityTracker
            float r0 = r0.getYVelocity()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0170
            r12 = r13
        L_0x0170:
            r10.mFingerDir = r12
            int r0 = r23.getScrollY()
            if (r0 == 0) goto L_0x0189
            flyme.support.v7.widget.OverScrollLayout$VerticalFlingRunnable r0 = r10.mVerticalFlingRunnable
            if (r0 != 0) goto L_0x0183
            flyme.support.v7.widget.OverScrollLayout$VerticalFlingRunnable r0 = new flyme.support.v7.widget.OverScrollLayout$VerticalFlingRunnable
            r0.<init>()
            r10.mVerticalFlingRunnable = r0
        L_0x0183:
            flyme.support.v7.widget.OverScrollLayout$VerticalFlingRunnable r0 = r10.mVerticalFlingRunnable
            r0.startSpringback()
            return r13
        L_0x0189:
            android.view.VelocityTracker r0 = r10.mVelocityTracker
            r0.clear()
            goto L_0x0342
        L_0x0190:
            r10.mMotionY = r14
            r10.mDownY = r14
            r10.mDownX = r8
            int r0 = r23.getNewOverflingDistance()
            r10.mOverscrollDistance = r0
            flyme.support.v7.widget.OverScrollLayout$VerticalFlingRunnable r0 = r10.mVerticalFlingRunnable
            if (r0 == 0) goto L_0x01a3
            r0.endFling()
        L_0x01a3:
            flyme.support.v7.widget.OverScrollLayout$OverFlingRunnable r0 = r10.mFlingRun
            if (r0 == 0) goto L_0x01aa
            r0.endFling()
        L_0x01aa:
            android.widget.OverScroller r0 = r10.mOverScroller
            if (r0 == 0) goto L_0x01b1
            r0.abortAnimation()
        L_0x01b1:
            int r0 = r23.getScrollY()
            if (r0 == 0) goto L_0x0342
            return r13
        L_0x01b8:
            if (r0 != 0) goto L_0x0342
            flyme.support.v7.widget.MzRecyclerView r0 = r10.mRecyclerView
            boolean r0 = r0.canScrollHorizontally(r13)
            flyme.support.v7.widget.MzRecyclerView r6 = r10.mRecyclerView
            boolean r6 = r6.canScrollHorizontally(r5)
            int r7 = r24.getAction()
            float r8 = r24.getX()
            int r14 = (int) r8
            float r8 = r24.getY()
            int r8 = (int) r8
            if (r7 == 0) goto L_0x031a
            if (r7 == r13) goto L_0x02e7
            if (r7 == r4) goto L_0x01de
            if (r7 == r3) goto L_0x02e7
            goto L_0x0342
        L_0x01de:
            boolean r1 = r10.canScrollHorizontallyForActionDown(r13)
            r10.canScrollRightAtActionDown = r1
            boolean r1 = r10.canScrollHorizontallyForActionDown(r5)
            r10.canScrollLeftAtActionDown = r1
            int r1 = r23.getScrollX()
            if (r1 != 0) goto L_0x027f
            boolean r1 = r10.mForbidOverScrollInMutiChoiceState
            if (r1 == 0) goto L_0x0202
            flyme.support.v7.widget.MzRecyclerView r1 = r10.mRecyclerView
            java.lang.Boolean r1 = r1.isInMutiChoiceState()
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0202
            goto L_0x02e4
        L_0x0202:
            int r1 = r10.mAntiShakeValue
            if (r1 <= 0) goto L_0x0214
            int r1 = r10.mDownX
            int r1 = r14 - r1
            int r1 = java.lang.Math.abs(r1)
            int r2 = r10.mAntiShakeValue
            if (r1 >= r2) goto L_0x0214
            goto L_0x02e4
        L_0x0214:
            int r1 = r10.mDownX
            int r1 = r14 - r1
            int r1 = java.lang.Math.abs(r1)
            float r1 = (float) r1
            float r2 = r10.mConfictRatio
            float r1 = r1 * r2
            int r2 = r10.mDownY
            int r8 = r8 - r2
            int r2 = java.lang.Math.abs(r8)
            float r2 = (float) r2
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x022e
            goto L_0x02e4
        L_0x022e:
            int r1 = r10.mMotionX
            if (r14 <= r1) goto L_0x0238
            if (r6 != 0) goto L_0x0238
            boolean r2 = r10.canScrollLeftAtActionDown
            if (r2 == 0) goto L_0x0240
        L_0x0238:
            if (r14 >= r1) goto L_0x02e4
            if (r0 != 0) goto L_0x02e4
            boolean r0 = r10.canScrollRightAtActionDown
            if (r0 != 0) goto L_0x02e4
        L_0x0240:
            int r0 = r14 - r1
            int r1 = r23.getScrollX()
            int r0 = r10.updateIncrementalDelta(r0, r1)
            int r1 = -r0
            int r3 = r23.getScrollX()
            int r7 = r10.mOverscrollDistance
            r8 = 0
            r9 = 1
            r2 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r0 = r23
            r0.overScrollBy(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            long r15 = android.os.SystemClock.uptimeMillis()
            long r17 = r24.getEventTime()
            float r20 = r24.getX()
            float r21 = r24.getY()
            int r22 = r24.getMetaState()
            r19 = 3
            android.view.MotionEvent r0 = android.view.MotionEvent.obtain(r15, r17, r19, r20, r21, r22)
            super.dispatchTouchEvent(r0)
            r0.recycle()
            r10.mMotionX = r14
            return r13
        L_0x027f:
            int r0 = r10.mMotionX
            if (r14 == r0) goto L_0x02e4
            int r0 = r14 - r0
            int r1 = r23.getScrollX()
            int r0 = r10.updateIncrementalDelta(r0, r1)
            int r1 = r23.getScrollX()
            int r2 = r1 - r0
            int r3 = -r0
            if (r2 > 0) goto L_0x0298
            if (r1 > 0) goto L_0x029c
        L_0x0298:
            if (r2 < 0) goto L_0x029f
            if (r1 >= 0) goto L_0x029f
        L_0x029c:
            int r1 = -r1
            r15 = r0
            goto L_0x02a1
        L_0x029f:
            r1 = r3
            r15 = r12
        L_0x02a1:
            if (r1 == 0) goto L_0x02b4
            int r3 = r23.getScrollX()
            int r7 = r10.mOverscrollDistance
            r8 = 0
            r9 = 1
            r2 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r0 = r23
            r0.overScrollBy(r1, r2, r3, r4, r5, r6, r7, r8, r9)
        L_0x02b4:
            if (r15 == 0) goto L_0x02e1
            int r0 = r23.getScrollX()
            if (r0 == 0) goto L_0x02c2
            r10.setScrollX(r12)
            r23.invalidateParentIfNeeded()
        L_0x02c2:
            long r1 = android.os.SystemClock.uptimeMillis()
            long r3 = r24.getEventTime()
            float r6 = r24.getX()
            float r7 = r24.getY()
            int r8 = r24.getMetaState()
            r5 = 0
            android.view.MotionEvent r0 = android.view.MotionEvent.obtain(r1, r3, r5, r6, r7, r8)
            super.dispatchTouchEvent(r0)
            r0.recycle()
        L_0x02e1:
            r10.mMotionX = r14
            return r13
        L_0x02e4:
            r10.mMotionX = r14
            goto L_0x0342
        L_0x02e7:
            r10.canScrollRightAtActionDown = r13
            r10.canScrollLeftAtActionDown = r13
            android.view.VelocityTracker r0 = r10.mVelocityTracker
            r0.computeCurrentVelocity(r2)
            android.view.VelocityTracker r0 = r10.mVelocityTracker
            float r0 = r0.getXVelocity()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x02fb
            r12 = r13
        L_0x02fb:
            r10.mFingerDir = r12
            int r0 = r23.getScrollX()
            if (r0 == 0) goto L_0x0314
            flyme.support.v7.widget.OverScrollLayout$HorizonalFlingRunnable r0 = r10.mHorizonalFlingRunnable
            if (r0 != 0) goto L_0x030e
            flyme.support.v7.widget.OverScrollLayout$HorizonalFlingRunnable r0 = new flyme.support.v7.widget.OverScrollLayout$HorizonalFlingRunnable
            r0.<init>()
            r10.mHorizonalFlingRunnable = r0
        L_0x030e:
            flyme.support.v7.widget.OverScrollLayout$HorizonalFlingRunnable r0 = r10.mHorizonalFlingRunnable
            r0.startSpringback()
            return r13
        L_0x0314:
            android.view.VelocityTracker r0 = r10.mVelocityTracker
            r0.clear()
            goto L_0x0342
        L_0x031a:
            r10.mMotionX = r14
            r10.mDownY = r8
            r10.mDownX = r14
            int r0 = r23.getNewOverflingDistance()
            r10.mOverscrollDistance = r0
            flyme.support.v7.widget.OverScrollLayout$HorizonalFlingRunnable r0 = r10.mHorizonalFlingRunnable
            if (r0 == 0) goto L_0x032d
            r0.endFling()
        L_0x032d:
            flyme.support.v7.widget.OverScrollLayout$OverFlingRunnable r0 = r10.mFlingRun
            if (r0 == 0) goto L_0x0334
            r0.endFling()
        L_0x0334:
            android.widget.OverScroller r0 = r10.mOverScroller
            if (r0 == 0) goto L_0x033b
            r0.abortAnimation()
        L_0x033b:
            int r0 = r23.getScrollX()
            if (r0 == 0) goto L_0x0342
            return r13
        L_0x0342:
            boolean r0 = super.dispatchTouchEvent(r24)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: flyme.support.v7.widget.OverScrollLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public void invalidateParentIfNeeded() {
        if (isHardwareAccelerated() && (getParent() instanceof View)) {
            ((View) getParent()).invalidate();
        }
    }

    public void isForbidOverScrollInMutiChoiceState(boolean z) {
        this.mForbidOverScrollInMutiChoiceState = z;
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() != 1) {
            throw new IllegalStateException("OverScrollLayout only can host 1 elements");
        } else if (findRecyclerView(getChildAt(0))) {
            this.mConfictRatio = 1.0f;
        } else {
            throw new IllegalStateException("OverScrollLayout only contain recyclerview");
        }
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        int i = this.mFingerDir;
        if ((i == 1 && f2 < 0.0f) || ((i == 0 && f2 > 0.0f) || ((i == 1 && f < 0.0f) || (i == 0 && f > 0.0f)))) {
            this.mRecyclerView.addOnScrollListener(this.mListener);
            OverScroller overScroller = new OverScroller(view.getContext(), sQuinticInterpolator);
            this.mOverScroller = overScroller;
            overScroller.fling(0, 0, (int) f, (int) f2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        return false;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.mNestedScrollingParent.b(view, view2, i);
    }

    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        int i3 = this.mOrientation;
        if (i3 == 1) {
            if (getScrollY() != i2) {
                onScrollChanged(i, i2, getScrollX(), getScrollY());
                setScrollY(i2);
                invalidateParentIfNeeded();
                awakenScrollBars();
            }
        } else if (i3 == 0 && getScrollX() != i) {
            onScrollChanged(i, i2, getScrollX(), getScrollY());
            setScrollX(i);
            invalidateParentIfNeeded();
            awakenScrollBars();
        }
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        if (this.mRecyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            this.mOrientation = ((LinearLayoutManager) this.mRecyclerView.getLayoutManager()).getOrientation();
        }
        int i5 = this.mOrientation;
        if (i5 == 1) {
            this.mOverscrollDistance = (int) (((float) i2) * 0.5f);
        } else if (i5 == 0) {
            this.mOverscrollDistance = (int) (((float) i) * 0.5f);
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return true;
    }

    public void onStopNestedScroll(View view) {
        this.mNestedScrollingParent.d(view);
    }

    public void setAntiShakeValue(int i) {
        this.mAntiShakeValue = i;
    }

    public void setConfictRatio(float f) {
        this.mConfictRatio = f;
    }

    public OverScrollLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OverScrollLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mOrientation = -1;
        this.mAntiShakeValue = 0;
        this.mDownY = 0;
        this.mDownX = 0;
        this.canScrollDownAtActionDown = true;
        this.canScrollUpAtActionDown = true;
        this.canScrollLeftAtActionDown = true;
        this.canScrollRightAtActionDown = true;
        this.mConfictRatio = 0.0f;
        this.mFingerDir = 0;
        this.mOverScrollInterpolator = PathInterpolatorCompat.a(0.12f, 0.0f, 0.33f, 1.0f);
        this.mListener = new RecyclerView.OnScrollListener() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i == 0) {
                    OverScrollLayout.this.mRecyclerView.removeOnScrollListener(OverScrollLayout.this.mListener);
                    OverScrollLayout.this.mOverScroller.computeScrollOffset();
                    if (OverScrollLayout.this.needScroll()) {
                        if (OverScrollLayout.this.mFlingRun == null) {
                            OverScrollLayout overScrollLayout = OverScrollLayout.this;
                            OverFlingRunnable unused = overScrollLayout.mFlingRun = new OverFlingRunnable();
                        }
                        int currVelocity = (int) OverScrollLayout.this.mOverScroller.getCurrVelocity();
                        if (OverScrollLayout.this.mFingerDir == 0 || OverScrollLayout.this.mFingerDir == 0 ? currVelocity <= 0 : currVelocity > 0) {
                            currVelocity = -currVelocity;
                        }
                        OverScrollLayout overScrollLayout2 = OverScrollLayout.this;
                        overScrollLayout2.mOverscrollDistance = overScrollLayout2.getNewOverflingDistance();
                        if (OverScrollLayout.this.mOrientation == 1) {
                            OverScrollLayout.this.mFlingRun.fling(0, currVelocity);
                        } else if (OverScrollLayout.this.mOrientation == 0) {
                            OverScrollLayout.this.mFlingRun.fling(currVelocity, 0);
                        }
                    }
                } else if (i == 1) {
                    OverScrollLayout.this.mRecyclerView.removeOnScrollListener(OverScrollLayout.this.mListener);
                }
            }

            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            }
        };
        setOverScrollMode(0);
        this.mForbidOverScrollInMutiChoiceState = true;
        this.mNestedScrollingParent = new NestedScrollingParentHelper(this);
    }
}
