package com.meizu.common.widget;

import android.content.Context;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class Scroller {
    private static float DECELERATION_RATE = ((float) (Math.log(0.78d) / Math.log(0.9d)));
    private static final int DEFAULT_DURATION = 250;
    private static final float END_TENSION = 1.0f;
    private static final int FLING_MODE = 1;
    private static final float INFLEXION = 0.35f;
    private static final int NB_SAMPLES = 100;
    private static final float P1 = 0.175f;
    private static final float P2 = 0.35000002f;
    private static final int SCROLL_MODE = 0;
    private static final float[] SPLINE_POSITION = new float[101];
    private static final float[] SPLINE_TIME = new float[101];
    private static final float START_TENSION = 0.5f;
    private static float sViscousFluidNormalize;
    private static float sViscousFluidScale = 8.0f;
    private float mCurrVelocity;
    private int mCurrX;
    private int mCurrY;
    private float mDeceleration;
    private float mDeltaX;
    private float mDeltaY;
    private int mDistance;
    private int mDuration;
    private float mDurationReciprocal;
    private int mFinalX;
    private int mFinalY;
    private boolean mFinished;
    private float mFlingFriction;
    private boolean mFlywheel;
    private Interpolator mInterpolator;
    private int mMaxX;
    private int mMaxY;
    private int mMinX;
    private int mMinY;
    private int mMode;
    private float mPhysicalCoeff;
    private final float mPpi;
    private long mStartTime;
    private int mStartX;
    private int mStartY;
    private float mVelocity;

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
        sViscousFluidNormalize = 1.0f;
        sViscousFluidNormalize = 1.0f / viscousFluid(1.0f);
    }

    public Scroller(Context context) {
        this(context, (Interpolator) null);
    }

    private float computeDeceleration(float f) {
        return this.mPpi * 386.0878f * f;
    }

    private double getSplineDeceleration(float f) {
        return Math.log((double) ((Math.abs(f) * INFLEXION) / (this.mFlingFriction * this.mPhysicalCoeff)));
    }

    private double getSplineFlingDistance(float f) {
        double splineDeceleration = getSplineDeceleration(f);
        float f2 = DECELERATION_RATE;
        return ((double) (this.mFlingFriction * this.mPhysicalCoeff)) * Math.exp((((double) f2) / (((double) f2) - 1.0d)) * splineDeceleration);
    }

    private int getSplineFlingDuration(float f) {
        return (int) (Math.exp(getSplineDeceleration(f) / (((double) DECELERATION_RATE) - 1.0d)) * 1000.0d);
    }

    public static float viscousFluid(float f) {
        float f2 = f * sViscousFluidScale;
        return (f2 < 1.0f ? f2 - (1.0f - ((float) Math.exp((double) (-f2)))) : 0.36787945f + ((1.0f - ((float) Math.exp((double) (1.0f - f2)))) * 0.63212055f)) * sViscousFluidNormalize;
    }

    public void abortAnimation() {
        this.mCurrX = this.mFinalX;
        this.mCurrY = this.mFinalY;
        this.mFinished = true;
    }

    public boolean computeScrollOffset() {
        float f;
        float f2;
        if (this.mFinished) {
            return false;
        }
        int currentAnimationTimeMillis = (int) (AnimationUtils.currentAnimationTimeMillis() - this.mStartTime);
        int i = this.mDuration;
        if (currentAnimationTimeMillis < i) {
            int i2 = this.mMode;
            if (i2 == 0) {
                float f3 = ((float) currentAnimationTimeMillis) * this.mDurationReciprocal;
                Interpolator interpolator = this.mInterpolator;
                float viscousFluid = interpolator == null ? viscousFluid(f3) : interpolator.getInterpolation(f3);
                this.mCurrX = this.mStartX + Math.round(this.mDeltaX * viscousFluid);
                this.mCurrY = this.mStartY + Math.round(viscousFluid * this.mDeltaY);
            } else if (i2 == 1) {
                float f4 = ((float) currentAnimationTimeMillis) / ((float) i);
                int i3 = (int) (f4 * 100.0f);
                if (i3 < 100) {
                    float f5 = ((float) i3) / 100.0f;
                    int i4 = i3 + 1;
                    float[] fArr = SPLINE_POSITION;
                    float f6 = fArr[i3];
                    f2 = (fArr[i4] - f6) / ((((float) i4) / 100.0f) - f5);
                    f = f6 + ((f4 - f5) * f2);
                } else {
                    f = 1.0f;
                    f2 = 0.0f;
                }
                this.mCurrVelocity = ((f2 * ((float) this.mDistance)) / ((float) i)) * 1000.0f;
                int i5 = this.mStartX;
                int round = i5 + Math.round(((float) (this.mFinalX - i5)) * f);
                this.mCurrX = round;
                int min = Math.min(round, this.mMaxX);
                this.mCurrX = min;
                this.mCurrX = Math.max(min, this.mMinX);
                int i6 = this.mStartY;
                int round2 = i6 + Math.round(f * ((float) (this.mFinalY - i6)));
                this.mCurrY = round2;
                int min2 = Math.min(round2, this.mMaxY);
                this.mCurrY = min2;
                int max = Math.max(min2, this.mMinY);
                this.mCurrY = max;
                if (this.mCurrX == this.mFinalX && max == this.mFinalY) {
                    this.mFinished = true;
                }
            }
        } else {
            this.mCurrX = this.mFinalX;
            this.mCurrY = this.mFinalY;
            this.mFinished = true;
        }
        return true;
    }

    public void extendDuration(int i) {
        int timePassed = timePassed() + i;
        this.mDuration = timePassed;
        this.mDurationReciprocal = 1.0f / ((float) timePassed);
        this.mFinished = false;
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (this.mFlywheel && !this.mFinished) {
            float currVelocity = getCurrVelocity();
            float f = (float) (this.mFinalX - this.mStartX);
            float f2 = (float) (this.mFinalY - this.mStartY);
            float sqrt = (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
            float f3 = (f / sqrt) * currVelocity;
            float f4 = (f2 / sqrt) * currVelocity;
            float f5 = (float) i3;
            if (Math.signum(f5) == Math.signum(f3)) {
                float f6 = (float) i4;
                if (Math.signum(f6) == Math.signum(f4)) {
                    i3 = (int) (f5 + f3);
                    i4 = (int) (f6 + f4);
                }
            }
        }
        this.mMode = 1;
        this.mFinished = false;
        float sqrt2 = (float) Math.sqrt((double) ((i3 * i3) + (i4 * i4)));
        this.mVelocity = sqrt2;
        this.mDuration = getSplineFlingDuration(sqrt2);
        this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
        this.mStartX = i;
        this.mStartY = i2;
        int i9 = (sqrt2 > 0.0f ? 1 : (sqrt2 == 0.0f ? 0 : -1));
        float f7 = 1.0f;
        float f8 = i9 == 0 ? 1.0f : ((float) i3) / sqrt2;
        if (i9 != 0) {
            f7 = ((float) i4) / sqrt2;
        }
        double splineFlingDistance = getSplineFlingDistance(sqrt2);
        this.mDistance = (int) (((double) Math.signum(sqrt2)) * splineFlingDistance);
        this.mMinX = i5;
        this.mMaxX = i6;
        this.mMinY = i7;
        this.mMaxY = i8;
        int round = i + ((int) Math.round(((double) f8) * splineFlingDistance));
        this.mFinalX = round;
        int min = Math.min(round, this.mMaxX);
        this.mFinalX = min;
        this.mFinalX = Math.max(min, this.mMinX);
        int round2 = i2 + ((int) Math.round(splineFlingDistance * ((double) f7)));
        this.mFinalY = round2;
        int min2 = Math.min(round2, this.mMaxY);
        this.mFinalY = min2;
        this.mFinalY = Math.max(min2, this.mMinY);
    }

    public final void forceFinished(boolean z) {
        this.mFinished = z;
    }

    public float getCurrVelocity() {
        return this.mMode == 1 ? this.mCurrVelocity : this.mVelocity - ((this.mDeceleration * ((float) timePassed())) / 2000.0f);
    }

    public final int getCurrX() {
        return this.mCurrX;
    }

    public final int getCurrY() {
        return this.mCurrY;
    }

    public final int getDuration() {
        return this.mDuration;
    }

    public final int getFinalX() {
        return this.mFinalX;
    }

    public final int getFinalY() {
        return this.mFinalY;
    }

    public final int getStartX() {
        return this.mStartX;
    }

    public final int getStartY() {
        return this.mStartY;
    }

    public final boolean isFinished() {
        return this.mFinished;
    }

    public boolean isScrollingInDirection(float f, float f2) {
        return !this.mFinished && Math.signum(f) == Math.signum((float) (this.mFinalX - this.mStartX)) && Math.signum(f2) == Math.signum((float) (this.mFinalY - this.mStartY));
    }

    public void setFinalX(int i) {
        this.mFinalX = i;
        this.mDeltaX = (float) (i - this.mStartX);
        this.mFinished = false;
    }

    public void setFinalY(int i) {
        this.mFinalY = i;
        this.mDeltaY = (float) (i - this.mStartY);
        this.mFinished = false;
    }

    public final void setFriction(float f) {
        this.mDeceleration = computeDeceleration(f);
        this.mFlingFriction = f;
    }

    public void startScroll(int i, int i2, int i3, int i4) {
        startScroll(i, i2, i3, i4, 250);
    }

    public int timePassed() {
        return (int) (AnimationUtils.currentAnimationTimeMillis() - this.mStartTime);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Scroller(Context context, Interpolator interpolator) {
        this(context, interpolator, context.getApplicationInfo().targetSdkVersion >= 11);
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.mFinished = false;
        this.mDuration = i5;
        this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
        this.mStartX = i;
        this.mStartY = i2;
        this.mFinalX = i + i3;
        this.mFinalY = i2 + i4;
        this.mDeltaX = (float) i3;
        this.mDeltaY = (float) i4;
        this.mDurationReciprocal = 1.0f / ((float) this.mDuration);
    }

    public Scroller(Context context, Interpolator interpolator, boolean z) {
        this.mFlingFriction = ViewConfiguration.getScrollFriction();
        this.mFinished = true;
        this.mInterpolator = interpolator;
        this.mPpi = context.getResources().getDisplayMetrics().density * 160.0f;
        this.mDeceleration = computeDeceleration(ViewConfiguration.getScrollFriction());
        this.mFlywheel = z;
        this.mPhysicalCoeff = computeDeceleration(0.84f);
    }
}
