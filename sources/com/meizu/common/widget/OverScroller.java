package com.meizu.common.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class OverScroller {
    private static final int DEFAULT_DURATION = 250;
    private static final int FLING_MODE = 1;
    private static final int SCROLL_MODE = 0;
    private final boolean mFlywheel;
    private Interpolator mInterpolator;
    private int mMode;
    private final SplineOverScroller mScrollerX;
    private final SplineOverScroller mScrollerY;

    public static class SplineOverScroller {
        private static final int BALLISTIC = 2;
        private static final int CUBIC = 1;
        private static final int DECELERATIONSPEED_FAST = 50;
        private static final int DECELERATIONSPEED_SLOW = 25;
        private static float DECELERATION_RATE = ((float) (Math.log(0.78d) / Math.log(0.9d)));
        private static final float END_TENSION = 1.0f;
        private static final float GRAVITY = 2000.0f;
        private static final float INFLEXION = 0.35f;
        private static final int MAXFLINGTESTCOUNT = 4;
        private static final int MAXUPDATECOUNT = 5;
        private static final int NB_SAMPLES = 100;
        private static final int OVERSCROLL_SPRINGBACK_DURATION = 618;
        private static final float P1 = 0.175f;
        private static final float P2 = 0.35000002f;
        private static final int SPLINE = 0;
        private static final float[] SPLINE_POSITION = new float[101];
        private static final float[] SPLINE_TIME = new float[101];
        private static final float START_TENSION = 0.5f;
        private static final String tag = "OverScroller";
        private long mAverageTime = 0;
        private float mCoeffDeceleration = 0.0f;
        /* access modifiers changed from: private */
        public float mCurrVelocity;
        /* access modifiers changed from: private */
        public int mCurrentPosition;
        private float mDeceleration;
        private int mDecelerationSpeed = 50;
        private float mDelta = 0.0f;
        /* access modifiers changed from: private */
        public int mDuration;
        private boolean mEnableOverScrollForMz = false;
        /* access modifiers changed from: private */
        public int mFinal;
        /* access modifiers changed from: private */
        public boolean mFinished = true;
        private float mFlingFriction = ViewConfiguration.getScrollFriction();
        private int mFlingTestCount = 1;
        private int mIterateCount = 0;
        private float mLastDistance = 0.0f;
        private int mOver;
        private float mPhysicalCoeff;
        private boolean mSmoothFling = false;
        private int mSplineDistance;
        private int mSplineDuration;
        private int mSpringDistance = 0;
        private int mSpringbackEnd = 0;
        /* access modifiers changed from: private */
        public int mStart;
        /* access modifiers changed from: private */
        public long mStartTime;
        /* access modifiers changed from: private */
        public int mState = 0;
        private int mUpdateCount = 0;
        private int mVelocity;

        static {
            float f;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            float f10;
            float f11 = 0.0f;
            float f12 = 0.0f;
            for (int i = 0; i < 100; i++) {
                float f13 = ((float) i) / 100.0f;
                float f14 = 1.0f;
                while (true) {
                    f = 2.0f;
                    f2 = ((f14 - f11) / 2.0f) + f11;
                    f3 = 3.0f;
                    f4 = 1.0f - f2;
                    f5 = f2 * 3.0f * f4;
                    f6 = f2 * f2 * f2;
                    float f15 = (((f4 * P1) + (f2 * P2)) * f5) + f6;
                    float f16 = f15;
                    if (((double) Math.abs(f15 - f13)) < 1.0E-5d) {
                        break;
                    } else if (f16 > f13) {
                        f14 = f2;
                    } else {
                        f11 = f2;
                    }
                }
                SPLINE_POSITION[i] = (f5 * ((f4 * 0.5f) + f2)) + f6;
                float f17 = 1.0f;
                while (true) {
                    f7 = ((f17 - f12) / f) + f12;
                    f8 = 1.0f - f7;
                    f9 = f7 * f3 * f8;
                    f10 = f7 * f7 * f7;
                    float f18 = (((f8 * 0.5f) + f7) * f9) + f10;
                    if (((double) Math.abs(f18 - f13)) < 1.0E-5d) {
                        break;
                    }
                    if (f18 > f13) {
                        f17 = f7;
                    } else {
                        f12 = f7;
                    }
                    f = 2.0f;
                    f3 = 3.0f;
                }
                SPLINE_TIME[i] = (f9 * ((f8 * P1) + (f7 * P2))) + f10;
            }
            float[] fArr = SPLINE_POSITION;
            SPLINE_TIME[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        public SplineOverScroller(Context context) {
            this.mPhysicalCoeff = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
            this.mFlingTestCount = 0;
            this.mAverageTime = 0;
            this.mSmoothFling = false;
        }

        private void adjustDuration(int i, int i2, int i3) {
            float abs = Math.abs(((float) (i3 - i)) / ((float) (i2 - i)));
            int i4 = (int) (abs * 100.0f);
            if (i4 < 100) {
                float f = ((float) i4) / 100.0f;
                int i5 = i4 + 1;
                float[] fArr = SPLINE_TIME;
                float f2 = fArr[i4];
                this.mDuration = (int) (((float) this.mDuration) * (f2 + (((abs - f) / ((((float) i5) / 100.0f) - f)) * (fArr[i5] - f2))));
            }
        }

        private void fitOnBounceCurve(int i, int i2, int i3) {
            float f = this.mDeceleration;
            float sqrt = (float) Math.sqrt((((double) (((((float) (i3 * i3)) / 2.0f) / Math.abs(f)) + ((float) Math.abs(i2 - i)))) * 2.0d) / ((double) Math.abs(this.mDeceleration)));
            this.mStartTime -= (long) ((int) ((sqrt - (((float) (-i3)) / f)) * 1000.0f));
            this.mStart = i2;
            this.mVelocity = (int) ((-this.mDeceleration) * sqrt);
        }

        private static float getDeceleration(int i) {
            if (i > 0) {
                return -2000.0f;
            }
            return GRAVITY;
        }

        private double getSplineDeceleration(int i) {
            return Math.log((double) ((((float) Math.abs(i)) * INFLEXION) / (this.mFlingFriction * this.mPhysicalCoeff)));
        }

        private double getSplineFlingDistance(int i) {
            double splineDeceleration = getSplineDeceleration(i);
            float f = DECELERATION_RATE;
            return ((double) (this.mFlingFriction * this.mPhysicalCoeff)) * Math.exp((((double) f) / (((double) f) - 1.0d)) * splineDeceleration);
        }

        private int getSplineFlingDuration(int i) {
            return (int) (Math.exp(getSplineDeceleration(i) / (((double) DECELERATION_RATE) - 1.0d)) * 1000.0d);
        }

        private void onEdgeReached() {
            double d;
            int i = this.mVelocity;
            float abs = ((float) (i * i)) / (Math.abs(this.mDeceleration) * 2.0f);
            if (!this.mEnableOverScrollForMz) {
                float signum = Math.signum((float) this.mVelocity);
                int i2 = this.mOver;
                if (abs > ((float) i2)) {
                    float f = -signum;
                    int i3 = this.mVelocity;
                    this.mDeceleration = ((f * ((float) i3)) * ((float) i3)) / (((float) i2) * 2.0f);
                    abs = (float) i2;
                }
                int i4 = this.mStart;
                int i5 = this.mVelocity;
                this.mFinal = i4 + ((int) (i5 > 0 ? abs : -abs));
                this.mDuration = -((int) ((((float) i5) * 1000.0f) / this.mDeceleration));
            } else {
                this.mCoeffDeceleration = 0.5f;
                this.mLastDistance = 0.0f;
                int i6 = 0;
                this.mFinished = false;
                this.mDuration = Integer.MAX_VALUE;
                this.mDelta = this.mCurrVelocity / 150.0f;
                while (true) {
                    d = (double) i6;
                    if (((int) (((double) this.mDelta) * Math.pow((double) this.mCoeffDeceleration, d))) == 0) {
                        break;
                    }
                    i6++;
                }
                this.mIterateCount = i6;
                abs = (float) ((((double) this.mDelta) * (1.0d - Math.pow((double) this.mCoeffDeceleration, d))) / ((double) (1.0f - this.mCoeffDeceleration)));
                this.mFinal = (int) (((float) this.mStart) + abs);
            }
            this.mOver = (int) abs;
            this.mState = 2;
        }

        private int quintic(long j, int i, int i2, long j2) {
            return (int) Math.round(((double) i2) * (Math.pow((double) (((((float) j) * 1.0f) / ((float) j2)) - 1.0f), 5.0d) + 1.0d));
        }

        private void startAfterEdge(int i, int i2, int i3, int i4) {
            boolean z = true;
            if (i <= i2 || i >= i3) {
                if (i <= i3) {
                    z = false;
                }
                int i5 = z ? i3 : i2;
                int i6 = i - i5;
                if (i6 * i4 >= 0) {
                    startBounceAfterEdge(i, i5, i4);
                } else if (getSplineFlingDistance(i4) > ((double) Math.abs(i6))) {
                    fling(i, i4, z ? i2 : i, z ? i : i3, this.mOver);
                } else {
                    startSpringback(i, i5, i4);
                }
            } else {
                Log.e(tag, "startAfterEdge called from a valid position");
                this.mFinished = true;
            }
        }

        private void startBounceAfterEdge(int i, int i2, int i3) {
            this.mDeceleration = getDeceleration(i3 == 0 ? i - i2 : i3);
            fitOnBounceCurve(i, i2, i3);
            onEdgeReached();
        }

        private void startSpringback(int i, int i2, int i3) {
            this.mFinished = false;
            this.mState = 1;
            this.mStart = i;
            this.mFinal = i2;
            int i4 = i - i2;
            this.mDeceleration = getDeceleration(i4);
            this.mVelocity = -i4;
            this.mOver = Math.abs(i4);
            if (this.mEnableOverScrollForMz) {
                this.mDuration = OVERSCROLL_SPRINGBACK_DURATION;
            } else {
                this.mDuration = (int) (Math.sqrt((((double) i4) * -2.0d) / ((double) this.mDeceleration)) * 1000.0d);
            }
        }

        public boolean continueWhenFinished() {
            int i = this.mState;
            if (i != 0) {
                if (i == 1) {
                    return false;
                }
                if (i == 2) {
                    if (this.mEnableOverScrollForMz) {
                        this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                    } else {
                        this.mStartTime += (long) this.mDuration;
                    }
                    startSpringback(this.mFinal, this.mStart, 0);
                }
            } else if (this.mDuration >= this.mSplineDuration) {
                return false;
            } else {
                this.mStart = this.mFinal;
                int i2 = (int) this.mCurrVelocity;
                this.mVelocity = i2;
                this.mDeceleration = getDeceleration(i2);
                this.mStartTime += (long) this.mDuration;
                onEdgeReached();
            }
            update();
            return true;
        }

        public void extendDuration(int i) {
            this.mDuration = ((int) (AnimationUtils.currentAnimationTimeMillis() - this.mStartTime)) + i;
            this.mFinished = false;
        }

        public void finish() {
            this.mCurrentPosition = this.mFinal;
            this.mFinished = true;
        }

        public void fling(int i, int i2, int i3, int i4, int i5) {
            double d;
            double d2;
            this.mOver = i5;
            this.mFinished = false;
            this.mVelocity = i2;
            float f = (float) i2;
            this.mCurrVelocity = f;
            this.mSplineDuration = 0;
            this.mDuration = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.mCurrentPosition = i;
            if (i > i4 || i < i3) {
                startAfterEdge(i, i3, i4, i2);
                return;
            }
            this.mState = 0;
            if (i2 != 0) {
                int splineFlingDuration = getSplineFlingDuration(i2);
                this.mSplineDuration = splineFlingDuration;
                this.mDuration = splineFlingDuration;
                d = getSplineFlingDistance(i2);
            } else {
                d = 0.0d;
            }
            if (this.mEnableOverScrollForMz && this.mFlingTestCount >= 4 && this.mAverageTime > 40) {
                this.mSmoothFling = false;
            }
            this.mFlingTestCount++;
            this.mUpdateCount = 0;
            if (this.mSmoothFling) {
                long j = this.mAverageTime;
                if (j < 20) {
                    this.mDecelerationSpeed = 50;
                } else if (j < 40) {
                    this.mDecelerationSpeed = 25;
                }
                int abs = Math.abs(this.mVelocity);
                this.mIterateCount = 0;
                this.mLastDistance = 0.0f;
                this.mCoeffDeceleration = 0.97f;
                this.mDelta = (((float) this.mVelocity) * 1.0f) / ((float) this.mDecelerationSpeed);
                int i6 = 0;
                while (true) {
                    d2 = (double) i6;
                    if (((int) (((double) this.mDelta) * Math.pow((double) this.mCoeffDeceleration, d2))) == 0) {
                        break;
                    }
                    i6++;
                }
                this.mIterateCount = i6;
                double pow = (((double) this.mDelta) * (1.0d - Math.pow((double) this.mCoeffDeceleration, d2))) / ((double) (1.0f - this.mCoeffDeceleration));
                if (abs > 2000) {
                    this.mDuration = 5000;
                } else if (abs < 200) {
                    this.mDuration = 0;
                } else {
                    this.mDuration = 3000;
                }
                this.mFinal = this.mStart + ((int) pow);
                return;
            }
            int signum = (int) (d * ((double) Math.signum(f)));
            this.mSplineDistance = signum;
            int i7 = i + signum;
            this.mFinal = i7;
            if (i7 < i3) {
                adjustDuration(this.mStart, i7, i3);
                this.mFinal = i3;
            }
            int i8 = this.mFinal;
            if (i8 > i4) {
                adjustDuration(this.mStart, i8, i4);
                this.mFinal = i4;
            }
        }

        public void notifyEdgeReached(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.mOver = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                startAfterEdge(i, i2, i2, (int) this.mCurrVelocity);
            }
        }

        public void setEnableMZOverScroll(boolean z, boolean z2) {
            this.mEnableOverScrollForMz = z;
            this.mSmoothFling = z2;
        }

        public void setFinalPosition(int i) {
            this.mFinal = i;
            this.mFinished = false;
        }

        public void setFriction(float f) {
            this.mFlingFriction = f;
        }

        public boolean springback(int i, int i2, int i3) {
            this.mFinished = true;
            this.mFinal = i;
            this.mStart = i;
            this.mVelocity = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = 0;
            if (i < i2) {
                startSpringback(i, i2, 0);
            } else if (i > i3) {
                startSpringback(i, i3, 0);
            }
            return !this.mFinished;
        }

        public void startScroll(int i, int i2, int i3) {
            this.mFinished = false;
            this.mStart = i;
            this.mFinal = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.mDeceleration = 0.0f;
            this.mVelocity = 0;
        }

        /* JADX WARNING: Removed duplicated region for block: B:48:0x010f  */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x012e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean update() {
            /*
                r12 = this;
                long r0 = android.view.animation.AnimationUtils.currentAnimationTimeMillis()
                long r2 = r12.mStartTime
                long r5 = r0 - r2
                int r0 = r12.mDuration
                long r1 = (long) r0
                int r1 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
                r2 = 0
                r3 = 1
                if (r1 <= 0) goto L_0x0032
                boolean r1 = r12.mEnableOverScrollForMz
                if (r1 == 0) goto L_0x0031
                boolean r1 = r12.mSmoothFling
                if (r1 == 0) goto L_0x0022
                int r0 = r12.mIterateCount
                if (r0 == 0) goto L_0x002f
                int r0 = r12.mCurrentPosition
                r12.mFinal = r0
                goto L_0x002f
            L_0x0022:
                int r1 = r12.mSplineDuration
                if (r0 >= r1) goto L_0x002f
                int r0 = r12.mFinal
                int r1 = r12.mCurrentPosition
                if (r0 == r1) goto L_0x002f
                r12.mCurrentPosition = r0
                return r3
            L_0x002f:
                r12.mFinished = r3
            L_0x0031:
                return r2
            L_0x0032:
                int r1 = r12.mState
                r4 = 1148846080(0x447a0000, float:1000.0)
                if (r1 == 0) goto L_0x00aa
                r7 = 1073741824(0x40000000, float:2.0)
                if (r1 == r3) goto L_0x0072
                r0 = 2
                if (r1 == r0) goto L_0x0043
                r0 = 0
                goto L_0x010b
            L_0x0043:
                boolean r0 = r12.mEnableOverScrollForMz
                if (r0 != 0) goto L_0x005c
                float r0 = (float) r5
                float r0 = r0 / r4
                int r1 = r12.mVelocity
                float r4 = (float) r1
                float r5 = r12.mDeceleration
                float r6 = r5 * r0
                float r4 = r4 + r6
                r12.mCurrVelocity = r4
                float r1 = (float) r1
                float r1 = r1 * r0
                float r5 = r5 * r0
                float r5 = r5 * r0
                float r5 = r5 / r7
                float r1 = r1 + r5
                double r0 = (double) r1
                goto L_0x010b
            L_0x005c:
                float r0 = r12.mCurrVelocity
                float r1 = r12.mCoeffDeceleration
                float r0 = r0 * r1
                r12.mCurrVelocity = r0
                float r0 = r12.mLastDistance
                float r4 = r12.mDelta
                float r0 = r0 + r4
                double r5 = (double) r0
                float r4 = r4 * r1
                r12.mDelta = r4
                float r0 = (float) r5
                r12.mLastDistance = r0
            L_0x006f:
                r0 = r5
                goto L_0x010b
            L_0x0072:
                float r1 = (float) r5
                float r0 = (float) r0
                float r1 = r1 / r0
                float r0 = r1 * r1
                int r4 = r12.mVelocity
                float r4 = (float) r4
                float r11 = java.lang.Math.signum(r4)
                boolean r4 = r12.mEnableOverScrollForMz
                if (r4 == 0) goto L_0x0093
                int r7 = r12.mStart
                int r8 = r12.mOver
                int r0 = r12.mDuration
                long r9 = (long) r0
                r4 = r12
                int r0 = r4.quintic(r5, r7, r8, r9)
                float r0 = (float) r0
                float r11 = r11 * r0
                double r0 = (double) r11
                goto L_0x010b
            L_0x0093:
                int r4 = r12.mOver
                float r5 = (float) r4
                float r5 = r5 * r11
                r6 = 1077936128(0x40400000, float:3.0)
                float r6 = r6 * r0
                float r7 = r7 * r1
                float r7 = r7 * r0
                float r6 = r6 - r7
                float r5 = r5 * r6
                double r5 = (double) r5
                float r4 = (float) r4
                float r11 = r11 * r4
                r4 = 1086324736(0x40c00000, float:6.0)
                float r11 = r11 * r4
                float r1 = -r1
                float r1 = r1 + r0
                float r11 = r11 * r1
                r12.mCurrVelocity = r11
                goto L_0x006f
            L_0x00aa:
                boolean r0 = r12.mSmoothFling
                if (r0 != 0) goto L_0x00e0
                float r0 = (float) r5
                int r1 = r12.mSplineDuration
                float r5 = (float) r1
                float r0 = r0 / r5
                r5 = 1120403456(0x42c80000, float:100.0)
                float r6 = r0 * r5
                int r6 = (int) r6
                r7 = 100
                if (r6 >= r7) goto L_0x00cf
                float r7 = (float) r6
                float r7 = r7 / r5
                int r8 = r6 + 1
                float r9 = (float) r8
                float r9 = r9 / r5
                float[] r5 = SPLINE_POSITION
                r6 = r5[r6]
                r5 = r5[r8]
                float r5 = r5 - r6
                float r9 = r9 - r7
                float r5 = r5 / r9
                float r0 = r0 - r7
                float r0 = r0 * r5
                float r6 = r6 + r0
                goto L_0x00d2
            L_0x00cf:
                r6 = 1065353216(0x3f800000, float:1.0)
                r5 = 0
            L_0x00d2:
                int r0 = r12.mSplineDistance
                float r7 = (float) r0
                float r6 = r6 * r7
                double r6 = (double) r6
                float r0 = (float) r0
                float r5 = r5 * r0
                float r0 = (float) r1
                float r5 = r5 / r0
                float r5 = r5 * r4
                r12.mCurrVelocity = r5
                r0 = r6
                goto L_0x010b
            L_0x00e0:
                int r0 = r12.mUpdateCount
                int r0 = r0 + r3
                r12.mUpdateCount = r0
                boolean r1 = r12.mEnableOverScrollForMz
                if (r1 == 0) goto L_0x00f6
                r1 = 5
                if (r0 != r1) goto L_0x00f6
                long r7 = r12.mAverageTime
                long r0 = (long) r0
                long r5 = r5 / r0
                long r7 = r7 + r5
                r0 = 2
                long r7 = r7 / r0
                r12.mAverageTime = r7
            L_0x00f6:
                float r0 = r12.mCurrVelocity
                float r1 = r12.mCoeffDeceleration
                float r0 = r0 * r1
                r12.mCurrVelocity = r0
                float r0 = r12.mLastDistance
                float r4 = r12.mDelta
                float r0 = r0 + r4
                double r5 = (double) r0
                float r4 = r4 * r1
                r12.mDelta = r4
                float r0 = (float) r5
                r12.mLastDistance = r0
                goto L_0x006f
            L_0x010b:
                boolean r4 = r12.mEnableOverScrollForMz
                if (r4 == 0) goto L_0x012e
                int r4 = r12.mState
                if (r4 != 0) goto L_0x0122
                boolean r4 = r12.mSmoothFling
                if (r4 != 0) goto L_0x0122
                int r2 = r12.mStart
                long r0 = java.lang.Math.round(r0)
                int r0 = (int) r0
                int r2 = r2 + r0
                r12.mCurrentPosition = r2
                return r3
            L_0x0122:
                int r4 = r12.mStart
                int r0 = (int) r0
                int r4 = r4 + r0
                r12.mCurrentPosition = r4
                int r12 = r12.mFinal
                if (r4 == r12) goto L_0x012d
                r2 = r3
            L_0x012d:
                return r2
            L_0x012e:
                int r2 = r12.mStart
                long r0 = java.lang.Math.round(r0)
                int r0 = (int) r0
                int r2 = r2 + r0
                r12.mCurrentPosition = r2
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.OverScroller.SplineOverScroller.update():boolean");
        }

        public void updateScroll(float f) {
            int i = this.mStart;
            this.mCurrentPosition = i + Math.round(f * ((float) (this.mFinal - i)));
        }
    }

    public OverScroller(Context context) {
        this(context, (Interpolator) null);
    }

    public void abortAnimation() {
        this.mScrollerX.finish();
        this.mScrollerY.finish();
    }

    public boolean computeScrollOffset() {
        if (isFinished()) {
            return false;
        }
        int i = this.mMode;
        if (i == 0) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.mScrollerX.mStartTime;
            int access$500 = this.mScrollerX.mDuration;
            if (currentAnimationTimeMillis < ((long) access$500)) {
                float f = ((float) currentAnimationTimeMillis) / ((float) access$500);
                Interpolator interpolator = this.mInterpolator;
                float viscousFluid = interpolator == null ? Scroller.viscousFluid(f) : interpolator.getInterpolation(f);
                this.mScrollerX.updateScroll(viscousFluid);
                this.mScrollerY.updateScroll(viscousFluid);
            } else {
                abortAnimation();
            }
        } else if (i == 1) {
            if (!this.mScrollerX.mFinished && !this.mScrollerX.update() && !this.mScrollerX.continueWhenFinished()) {
                this.mScrollerX.finish();
            }
            if (!this.mScrollerY.mFinished && !this.mScrollerY.update() && !this.mScrollerY.continueWhenFinished()) {
                this.mScrollerY.finish();
            }
        }
        return true;
    }

    @Deprecated
    public void extendDuration(int i) {
        this.mScrollerX.extendDuration(i);
        this.mScrollerY.extendDuration(i);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public final void forceFinished(boolean z) {
        boolean unused = this.mScrollerX.mFinished = this.mScrollerY.mFinished = z;
    }

    public float getCurrVelocity() {
        return (float) Math.sqrt((double) ((this.mScrollerX.mCurrVelocity * this.mScrollerX.mCurrVelocity) + (this.mScrollerY.mCurrVelocity * this.mScrollerY.mCurrVelocity)));
    }

    public final int getCurrX() {
        return this.mScrollerX.mCurrentPosition;
    }

    public final int getCurrY() {
        return this.mScrollerY.mCurrentPosition;
    }

    @Deprecated
    public final int getDuration() {
        return Math.max(this.mScrollerX.mDuration, this.mScrollerY.mDuration);
    }

    public final int getFinalX() {
        return this.mScrollerX.mFinal;
    }

    public final int getFinalY() {
        return this.mScrollerY.mFinal;
    }

    public final int getStartX() {
        return this.mScrollerX.mStart;
    }

    public final int getStartY() {
        return this.mScrollerY.mStart;
    }

    public final boolean isFinished() {
        return this.mScrollerX.mFinished && this.mScrollerY.mFinished;
    }

    public boolean isOverScrolled() {
        return (!this.mScrollerX.mFinished && this.mScrollerX.mState != 0) || (!this.mScrollerY.mFinished && this.mScrollerY.mState != 0);
    }

    public boolean isScrollingInDirection(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.mScrollerX.mFinal - this.mScrollerX.mStart)) && Math.signum(f2) == Math.signum((float) (this.mScrollerY.mFinal - this.mScrollerY.mStart));
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.mScrollerX.notifyEdgeReached(i, i2, i3);
    }

    public void notifyVerticalEdgeReached(int i, int i2, int i3) {
        this.mScrollerY.notifyEdgeReached(i, i2, i3);
    }

    public void setEnableMZOverScroll(boolean z, boolean z2) {
        this.mScrollerX.setEnableMZOverScroll(z, z2);
        this.mScrollerY.setEnableMZOverScroll(z, z2);
    }

    @Deprecated
    public void setFinalX(int i) {
        this.mScrollerX.setFinalPosition(i);
    }

    @Deprecated
    public void setFinalY(int i) {
        this.mScrollerY.setFinalPosition(i);
    }

    public final void setFriction(float f) {
        this.mScrollerX.setFriction(f);
        this.mScrollerY.setFriction(f);
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.mScrollerX.springback(i, i3, i4) || this.mScrollerY.springback(i2, i5, i6);
    }

    public void startScroll(int i, int i2, int i3, int i4) {
        startScroll(i, i2, i3, i4, 250);
    }

    public int timePassed() {
        return (int) (AnimationUtils.currentAnimationTimeMillis() - Math.min(this.mScrollerX.mStartTime, this.mScrollerY.mStartTime));
    }

    public OverScroller(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        int i12;
        int i13;
        int i14;
        if (!this.mFlywheel || isFinished()) {
            i14 = i3;
        } else {
            float access$200 = this.mScrollerX.mCurrVelocity;
            float access$2002 = this.mScrollerY.mCurrVelocity;
            i14 = i3;
            float f = (float) i14;
            if (Math.signum(f) == Math.signum(access$200)) {
                i13 = i4;
                float f2 = (float) i13;
                if (Math.signum(f2) == Math.signum(access$2002)) {
                    i12 = (int) (f2 + access$2002);
                    i11 = (int) (f + access$200);
                    this.mMode = 1;
                    this.mScrollerX.fling(i, i11, i5, i6, i9);
                    this.mScrollerY.fling(i2, i12, i7, i8, i10);
                }
                i12 = i13;
                i11 = i14;
                this.mMode = 1;
                this.mScrollerX.fling(i, i11, i5, i6, i9);
                this.mScrollerY.fling(i2, i12, i7, i8, i10);
            }
        }
        i13 = i4;
        i12 = i13;
        i11 = i14;
        this.mMode = 1;
        this.mScrollerX.fling(i, i11, i5, i6, i9);
        this.mScrollerY.fling(i2, i12, i7, i8, i10);
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.mScrollerX.startScroll(i, i3, i5);
        this.mScrollerY.startScroll(i2, i4, i5);
    }

    public OverScroller(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.mFlywheel = z;
        this.mScrollerX = new SplineOverScroller(context);
        this.mScrollerY = new SplineOverScroller(context);
    }

    public OverScroller(Context context, Interpolator interpolator, float f, float f2) {
        this(context, interpolator, true);
    }

    public OverScroller(Context context, Interpolator interpolator, float f, float f2, boolean z) {
        this(context, interpolator, z);
    }
}
