package flyme.support.v7.util;

import android.content.Context;
import android.provider.Settings;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import java.lang.reflect.Method;

public class OverScroller {
    private static final int DEFAULT_DURATION = 250;
    private static final int FLING_MODE = 1;
    public static final float OVER_SCROLLER_RATIO = 0.5f;
    private static final int SCROLL_MODE = 0;
    private final boolean mFlywheel;
    private Interpolator mInterpolator;
    private Method mMethod;
    private int mMode;
    private Class mScrollOptimizerClass;
    private final SplineOverScroller mScrollerX;
    private final SplineOverScroller mScrollerY;

    public static class FlymeScrollerOptimizer {
        private static final float DEFAULT_BALLISTIC_STIFFNESS = 102.0f;
        private static final float DEFAULT_CUBIC_STIFFNESS = 163.0f;
        private static final float DEFAULT_FRICTION = -4.2f;
        private static final float MIN_VISIBLE_CHANGE_PIXELS = 1.0f;
        private static final float THRESHOLD_MULTIPLIER = 0.75f;
        private static final float VELOCITY_THRESHOLD_MULTIPLIER = 62.5f;
        private final float mBallisticStiffness;
        private Context mContext;
        private final float mCubicStiffness;
        private final boolean mEnableVerboseLog;
        private float mFriction;
        private final int mMaxOverVelocity;
        private float mMinVisibleChange;
        private double mNaturalFreq;
        private final boolean mUseOptimizer;
        private float mVelocityThreshold;
        private final boolean mVertical;

        public static class MassState {
            /* access modifiers changed from: private */
            public final float mValue;
            /* access modifiers changed from: private */
            public final float mVelocity;

            private MassState(float f, float f2) {
                this.mValue = f;
                this.mVelocity = f2;
            }
        }

        /* access modifiers changed from: private */
        public int adjustDuration(int i, int i2, int i3, int i4) {
            float abs = (float) Math.abs(i);
            return getSplineFlingDuration(abs, (((float) Math.abs(i4 - i2)) * this.mFriction) + abs);
        }

        /* access modifiers changed from: private */
        public void debug(String str) {
            if (this.mVertical) {
                Log.d("OverScroller-Y", str);
            } else {
                Log.d("OverScroller-X", str);
            }
        }

        /* access modifiers changed from: private */
        public double getBallisticDuration() {
            return 1000.0d / this.mNaturalFreq;
        }

        /* access modifiers changed from: private */
        public double getCubicDuration(double d, double d2, double d3) {
            double d4 = d - d3;
            return Math.max(Math.log((Math.abs(d4) * 2.0d) / ((double) this.mMinVisibleChange)) / this.mNaturalFreq, (Math.log((Math.abs(d2 + (this.mNaturalFreq * d4)) * 4.0d) / ((this.mNaturalFreq * 2.718281828459045d) * ((double) this.mMinVisibleChange))) * 2.0d) / this.mNaturalFreq) * 1000.0d;
        }

        /* access modifiers changed from: private */
        public float getCurrVelocity(int i, long j) {
            return (float) (((double) i) * Math.exp((double) ((((float) j) / 1000.0f) * this.mFriction)));
        }

        /* access modifiers changed from: private */
        public float getCurrentDistance(int i, long j) {
            float currVelocity = getCurrVelocity(i, j);
            float f = this.mFriction;
            return (currVelocity / f) - (((float) i) / f);
        }

        /* access modifiers changed from: private */
        public double getNaturalFreqByDistance(double d, double d2) {
            return Math.abs(d2) / (d * 2.718281828459045d);
        }

        /* access modifiers changed from: private */
        public double getSplineFlingDistance(int i) {
            return (double) ((this.mVelocityThreshold / this.mFriction) - (((float) Math.abs(i)) / this.mFriction));
        }

        /* access modifiers changed from: private */
        public int getSplineFlingDuration(int i) {
            return getSplineFlingDuration((float) Math.abs(i), this.mVelocityThreshold);
        }

        private float getValueThreshold() {
            return this.mMinVisibleChange * THRESHOLD_MULTIPLIER;
        }

        /* access modifiers changed from: private */
        public void resetBallisticNaturalFreq() {
            setStiffness(this.mBallisticStiffness);
        }

        /* access modifiers changed from: private */
        public void resetCubicNaturalFreq() {
            setStiffness(this.mCubicStiffness);
        }

        private void setMinimumVisibleChange(float f) {
            this.mMinVisibleChange = f;
            setValueThreshold(f * THRESHOLD_MULTIPLIER);
        }

        /* access modifiers changed from: private */
        public void setNaturalFreq(double d) {
            this.mNaturalFreq = d;
        }

        private void setStiffness(float f) {
            if (f > 0.0f) {
                this.mNaturalFreq = Math.sqrt((double) f);
                return;
            }
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }

        private void setValueThreshold(float f) {
            this.mVelocityThreshold = f * VELOCITY_THRESHOLD_MULTIPLIER;
        }

        /* access modifiers changed from: private */
        public MassState updateBallisticValue(double d, double d2, double d3, double d4) {
            double d5 = d3 / 1000.0d;
            double d6 = d - d4;
            double d7 = this.mNaturalFreq;
            double d8 = d2 + (d7 * d6);
            double d9 = d6 + (d8 * d5);
            double pow = Math.pow(2.718281828459045d, (-d7) * d5) * d9;
            double pow2 = d9 * Math.pow(2.718281828459045d, (-this.mNaturalFreq) * d5);
            double d10 = this.mNaturalFreq;
            return new MassState((float) (pow + d4), (float) ((pow2 * (-d10)) + (d8 * Math.pow(2.718281828459045d, (-d10) * d5))));
        }

        /* access modifiers changed from: private */
        public boolean useOptimizer() {
            return this.mUseOptimizer;
        }

        /* access modifiers changed from: private */
        public void verbose(String str) {
            if (this.mEnableVerboseLog) {
                if (this.mVertical) {
                    Log.v("OverScroller-Y", str);
                } else {
                    Log.v("OverScroller-X", str);
                }
            }
        }

        public int getMaxOverVelocity() {
            return this.mMaxOverVelocity;
        }

        public void setFriction(float f) {
            this.mFriction = f * DEFAULT_FRICTION;
        }

        private FlymeScrollerOptimizer(Context context, boolean z) {
            this.mMinVisibleChange = 1.0f;
            this.mFriction = DEFAULT_FRICTION;
            this.mNaturalFreq = Math.sqrt(102.0d);
            this.mContext = context;
            this.mVertical = z;
            setValueThreshold(getValueThreshold());
            boolean z2 = true;
            this.mUseOptimizer = Settings.Global.getInt(context.getContentResolver(), "over_scroller_optimizer_enable", 1) == 1;
            this.mEnableVerboseLog = Settings.Global.getInt(context.getContentResolver(), "over_scroller_verbose_enable", 0) != 1 ? false : z2;
            setMinimumVisibleChange(Settings.Global.getFloat(context.getContentResolver(), "over_scroller_min_change", 0.5f));
            setFriction(Settings.Global.getFloat(context.getContentResolver(), "over_scroller_friction", 2.0f) / 4.2f);
            this.mBallisticStiffness = Settings.Global.getFloat(context.getContentResolver(), "over_scroller_ballistic_stiffness", DEFAULT_BALLISTIC_STIFFNESS);
            this.mCubicStiffness = Settings.Global.getFloat(context.getContentResolver(), "over_scroller_cubic_stiffness", DEFAULT_CUBIC_STIFFNESS);
            this.mMaxOverVelocity = Settings.Global.getInt(this.mContext.getContentResolver(), "over_scroller_max_velocity", 7000);
        }

        private int getSplineFlingDuration(float f, float f2) {
            return (int) ((Math.log((double) (f2 / f)) * 1000.0d) / ((double) this.mFriction));
        }
    }

    public static class SplineOverScroller {
        private static final int BALLISTIC = 2;
        private static final int CUBIC = 1;
        private static float DECELERATION_RATE = ((float) (Math.log(0.78d) / Math.log(0.9d)));
        private static final float END_TENSION = 1.0f;
        private static final float GRAVITY = 2000.0f;
        private static final float INFLEXION = 0.35f;
        private static final int NB_SAMPLES = 100;
        private static final float P1 = 0.175f;
        private static final float P2 = 0.35000002f;
        private static final int SPLINE = 0;
        private static final float[] SPLINE_POSITION = new float[101];
        private static final float[] SPLINE_TIME = new float[101];
        private static final float START_TENSION = 0.5f;
        private Context mContext;
        private int mCubicEnd;
        /* access modifiers changed from: private */
        public float mCurrVelocity;
        /* access modifiers changed from: private */
        public int mCurrentPosition;
        private float mDeceleration;
        /* access modifiers changed from: private */
        public int mDuration;
        /* access modifiers changed from: private */
        public int mFinal;
        /* access modifiers changed from: private */
        public boolean mFinished;
        private float mFlingFriction = ViewConfiguration.getScrollFriction();
        /* access modifiers changed from: private */
        public final FlymeScrollerOptimizer mOptimizer;
        private int mOver;
        private float mPhysicalCoeff;
        private int mSplineDistance;
        private int mSplineDuration;
        /* access modifiers changed from: private */
        public int mStart;
        /* access modifiers changed from: private */
        public long mStartTime;
        /* access modifiers changed from: private */
        public int mState = 0;
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

        public SplineOverScroller(Context context, boolean z) {
            this.mContext = context;
            this.mFinished = true;
            this.mPhysicalCoeff = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
            this.mOptimizer = new FlymeScrollerOptimizer(context, z);
        }

        private void adjustDuration(int i, int i2, int i3) {
            if (this.mOptimizer.useOptimizer()) {
                this.mDuration = this.mOptimizer.adjustDuration(this.mVelocity, i, i2, i3);
                return;
            }
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
            if (this.mOptimizer.useOptimizer()) {
                this.mStart = i;
                this.mCurrentPosition = i;
                this.mVelocity = i3;
                this.mCubicEnd = i2;
                return;
            }
            float f = this.mDeceleration;
            float f2 = ((float) (-i3)) / f;
            float f3 = (float) i3;
            float sqrt = (float) Math.sqrt((((double) ((((f3 * f3) / 2.0f) / Math.abs(f)) + ((float) Math.abs(i2 - i)))) * 2.0d) / ((double) Math.abs(this.mDeceleration)));
            this.mStartTime -= (long) ((int) ((sqrt - f2) * 1000.0f));
            this.mStart = i2;
            this.mCurrentPosition = i2;
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
            if (this.mOptimizer.useOptimizer()) {
                return this.mOptimizer.getSplineFlingDistance(i);
            }
            double splineDeceleration = getSplineDeceleration(i);
            float f = DECELERATION_RATE;
            return ((double) (this.mFlingFriction * this.mPhysicalCoeff)) * Math.exp((((double) f) / (((double) f) - 1.0d)) * splineDeceleration);
        }

        private int getSplineFlingDuration(int i) {
            return this.mOptimizer.useOptimizer() ? this.mOptimizer.getSplineFlingDuration(i) : (int) (Math.exp(getSplineDeceleration(i) / (((double) DECELERATION_RATE) - 1.0d)) * 1000.0d);
        }

        private void onEdgeReached() {
            FlymeScrollerOptimizer flymeScrollerOptimizer = this.mOptimizer;
            flymeScrollerOptimizer.debug("onEdgeReached, mVelocity=" + this.mVelocity + ", over=" + this.mOver);
            if (this.mOptimizer.useOptimizer()) {
                if (Math.abs(this.mVelocity) > this.mOptimizer.getMaxOverVelocity()) {
                    FlymeScrollerOptimizer flymeScrollerOptimizer2 = this.mOptimizer;
                    flymeScrollerOptimizer2.debug("onEdgeReached, limitedVelocity=" + this.mOptimizer.getMaxOverVelocity());
                    this.mVelocity = (int) (Math.signum((float) this.mVelocity) * ((float) this.mOptimizer.getMaxOverVelocity()));
                }
                this.mOptimizer.resetBallisticNaturalFreq();
                if (this.mOver <= 0) {
                    this.mOver = 0;
                    this.mState = 2;
                    this.mFinal = this.mStart;
                    this.mDuration = 0;
                } else {
                    double access$1700 = this.mOptimizer.getBallisticDuration();
                    FlymeScrollerOptimizer.MassState access$1800 = this.mOptimizer.updateBallisticValue(0.0d, (double) this.mVelocity, access$1700, 0.0d);
                    float abs = Math.abs(access$1800.mValue);
                    int i = this.mOver;
                    if (abs > ((float) i)) {
                        double access$2000 = this.mOptimizer.getNaturalFreqByDistance((double) i, (double) this.mVelocity);
                        FlymeScrollerOptimizer flymeScrollerOptimizer3 = this.mOptimizer;
                        flymeScrollerOptimizer3.debug("onEdgeReached, wantOver=" + access$1800.mValue + ", resetNaturalFreq=" + access$2000);
                        this.mOptimizer.setNaturalFreq(access$2000);
                        access$1700 = this.mOptimizer.getBallisticDuration();
                        access$1800 = this.mOptimizer.updateBallisticValue(0.0d, (double) this.mVelocity, access$1700, 0.0d);
                    }
                    this.mOver = (int) access$1800.mValue;
                    this.mState = 2;
                    this.mFinal = (int) (((float) this.mStart) + access$1800.mValue);
                    this.mDuration = (int) access$1700;
                }
                FlymeScrollerOptimizer flymeScrollerOptimizer4 = this.mOptimizer;
                flymeScrollerOptimizer4.debug("onEdgeReached, over=" + this.mOver + ", final=" + this.mFinal + ", duration=" + this.mDuration);
                return;
            }
            int i2 = this.mVelocity;
            float f = ((float) i2) * ((float) i2);
            float abs2 = f / (Math.abs(this.mDeceleration) * 2.0f);
            float signum = Math.signum((float) this.mVelocity);
            int i3 = this.mOver;
            if (abs2 > ((float) i3)) {
                this.mDeceleration = ((-signum) * f) / (((float) i3) * 2.0f);
                abs2 = (float) i3;
            }
            this.mOver = (int) abs2;
            this.mState = 2;
            int i4 = this.mStart;
            int i5 = this.mVelocity;
            if (i5 <= 0) {
                abs2 = -abs2;
            }
            this.mFinal = i4 + ((int) abs2);
            this.mDuration = -((int) ((((float) i5) * 1000.0f) / this.mDeceleration));
        }

        private int quintic(long j) {
            return (int) Math.round(((double) this.mOver) * (Math.pow((double) (((((float) j) * 1.0f) / ((float) this.mDuration)) - 1.0f), 5.0d) + 1.0d));
        }

        private void startAfterEdge(int i, int i2, int i3, int i4) {
            FlymeScrollerOptimizer flymeScrollerOptimizer = this.mOptimizer;
            flymeScrollerOptimizer.debug("startAfterEdge, start=" + i + ", min=" + i2 + ", max=" + i3 + ", velocity=" + i4);
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
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.mFinished = true;
            }
        }

        private void startBounceAfterEdge(int i, int i2, int i3) {
            FlymeScrollerOptimizer flymeScrollerOptimizer = this.mOptimizer;
            flymeScrollerOptimizer.debug("startBounceAfterEdge, start=" + i + ", end=" + i2 + ", velocity=" + i3);
            this.mDeceleration = getDeceleration(i3 == 0 ? i - i2 : i3);
            fitOnBounceCurve(i, i2, i3);
            onEdgeReached();
        }

        private void startSpringback(int i, int i2, int i3) {
            FlymeScrollerOptimizer flymeScrollerOptimizer = this.mOptimizer;
            flymeScrollerOptimizer.debug("startSpringBack, start=" + i + ", end=" + i2 + ", velocity=" + i3);
            if (this.mOptimizer.useOptimizer()) {
                this.mFinished = false;
                this.mState = 1;
                this.mStart = i;
                this.mCurrentPosition = i;
                this.mFinal = i2;
                int i4 = i - i2;
                this.mDeceleration = getDeceleration(i4);
                this.mVelocity = -i4;
                this.mOver = Math.abs(i4);
                this.mOptimizer.resetCubicNaturalFreq();
                this.mDuration = (int) this.mOptimizer.getCubicDuration((double) i, 0.0d, (double) i2);
                return;
            }
            this.mFinished = false;
            this.mState = 1;
            this.mStart = i;
            this.mCurrentPosition = i;
            this.mFinal = i2;
            int i5 = i - i2;
            this.mDeceleration = getDeceleration(i5);
            this.mVelocity = -i5;
            this.mOver = Math.abs(i5);
            this.mDuration = (int) (Math.sqrt((((double) i5) * -2.0d) / ((double) this.mDeceleration)) * 1000.0d);
        }

        public boolean continueWhenFinished() {
            int i = this.mState;
            if (i != 0) {
                if (i == 1) {
                    return false;
                }
                if (i == 2) {
                    this.mStartTime += (long) this.mDuration;
                    startSpringback(this.mFinal, this.mCubicEnd, 0);
                }
            } else if (this.mDuration >= this.mSplineDuration) {
                return false;
            } else {
                int i2 = this.mFinal;
                this.mStart = i2;
                this.mCurrentPosition = i2;
                this.mCubicEnd = i2;
                int i3 = (int) this.mCurrVelocity;
                this.mVelocity = i3;
                this.mDeceleration = getDeceleration(i3);
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
            this.mOptimizer.debug("finish, ");
            this.mCurrentPosition = this.mFinal;
            this.mFinished = true;
        }

        public void fling(int i, int i2, int i3, int i4, int i5) {
            double d;
            FlymeScrollerOptimizer flymeScrollerOptimizer = this.mOptimizer;
            flymeScrollerOptimizer.debug("fling, start=" + i + ", velocity=" + i2 + ", min=" + i3 + ", max=" + i4 + ", over=" + i5);
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
            int signum = (int) (d * ((double) Math.signum(f)));
            this.mSplineDistance = signum;
            int i6 = i + signum;
            this.mFinal = i6;
            if (i6 < i3) {
                adjustDuration(this.mStart, i6, i3);
                this.mFinal = i3;
            }
            int i7 = this.mFinal;
            if (i7 > i4) {
                adjustDuration(this.mStart, i7, i4);
                this.mFinal = i4;
            }
        }

        public void notifyEdgeReached(int i, int i2, int i3) {
            if (this.mState == 0) {
                FlymeScrollerOptimizer flymeScrollerOptimizer = this.mOptimizer;
                flymeScrollerOptimizer.debug("notifyEdgeReached, start=" + i + ", end=" + i2 + ", over=" + i3);
                this.mOver = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                startAfterEdge(i, i2, i2, (int) this.mCurrVelocity);
            }
        }

        public void setFinalPosition(int i) {
            this.mFinal = i;
            this.mFinished = false;
        }

        public void setFriction(float f) {
            this.mFlingFriction = f;
            if (this.mOptimizer.useOptimizer()) {
                this.mOptimizer.setFriction(f);
            }
        }

        public boolean springback(int i, int i2, int i3) {
            this.mFinished = true;
            this.mFinal = i;
            this.mStart = i;
            this.mCurrentPosition = i;
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
            this.mCurrentPosition = i;
            this.mFinal = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.mDeceleration = 0.0f;
            this.mVelocity = 0;
        }

        public boolean update() {
            float f;
            float f2;
            float access$2300;
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
            if (currentAnimationTimeMillis == 0) {
                return this.mDuration > 0;
            }
            if (currentAnimationTimeMillis > ((long) this.mDuration)) {
                return false;
            }
            double d = 0.0d;
            if (this.mOptimizer.useOptimizer()) {
                int i = this.mState;
                if (i != 0) {
                    if (i == 1) {
                        FlymeScrollerOptimizer.MassState access$1800 = this.mOptimizer.updateBallisticValue(0.0d, 0.0d, (double) currentAnimationTimeMillis, (double) (this.mFinal - this.mStart));
                        d = (double) access$1800.mValue;
                        this.mCurrVelocity = access$1800.mVelocity;
                    } else if (i == 2) {
                        FlymeScrollerOptimizer.MassState access$18002 = this.mOptimizer.updateBallisticValue(0.0d, (double) this.mVelocity, (double) currentAnimationTimeMillis, 0.0d);
                        this.mCurrVelocity = access$18002.mVelocity;
                        access$2300 = access$18002.mValue;
                    }
                    this.mCurrentPosition = this.mStart + ((int) Math.round(d));
                    FlymeScrollerOptimizer flymeScrollerOptimizer = this.mOptimizer;
                    flymeScrollerOptimizer.verbose("CurrentPosition=" + this.mCurrentPosition);
                    FlymeScrollerOptimizer flymeScrollerOptimizer2 = this.mOptimizer;
                    flymeScrollerOptimizer2.verbose("CurrVelocity=" + this.mCurrVelocity);
                    return true;
                }
                this.mCurrVelocity = this.mOptimizer.getCurrVelocity(this.mVelocity, currentAnimationTimeMillis);
                access$2300 = this.mOptimizer.getCurrentDistance(this.mVelocity, currentAnimationTimeMillis);
                d = (double) access$2300;
                this.mCurrentPosition = this.mStart + ((int) Math.round(d));
                FlymeScrollerOptimizer flymeScrollerOptimizer3 = this.mOptimizer;
                flymeScrollerOptimizer3.verbose("CurrentPosition=" + this.mCurrentPosition);
                FlymeScrollerOptimizer flymeScrollerOptimizer22 = this.mOptimizer;
                flymeScrollerOptimizer22.verbose("CurrVelocity=" + this.mCurrVelocity);
                return true;
            }
            int i2 = this.mState;
            if (i2 == 0) {
                int i3 = this.mSplineDuration;
                float f3 = ((float) currentAnimationTimeMillis) / ((float) i3);
                int i4 = (int) (f3 * 100.0f);
                if (i4 < 100) {
                    float f4 = ((float) i4) / 100.0f;
                    int i5 = i4 + 1;
                    float[] fArr = SPLINE_POSITION;
                    float f5 = fArr[i4];
                    f2 = (fArr[i5] - f5) / ((((float) i5) / 100.0f) - f4);
                    f = f5 + ((f3 - f4) * f2);
                } else {
                    f = 1.0f;
                    f2 = 0.0f;
                }
                int i6 = this.mSplineDistance;
                d = (double) (f * ((float) i6));
                this.mCurrVelocity = ((f2 * ((float) i6)) / ((float) i3)) * 1000.0f;
            } else if (i2 == 1) {
                float f6 = ((float) currentAnimationTimeMillis) / ((float) this.mDuration);
                float signum = Math.signum((float) this.mVelocity);
                this.mCurrVelocity = signum * ((float) this.mOver) * 6.0f * ((-f6) + (f6 * f6));
                d = (double) (((float) quintic(currentAnimationTimeMillis)) * signum);
            } else if (i2 == 2) {
                float f7 = ((float) currentAnimationTimeMillis) / 1000.0f;
                int i7 = this.mVelocity;
                float f8 = this.mDeceleration;
                this.mCurrVelocity = ((float) i7) + (f8 * f7);
                d = (double) ((((float) i7) * f7) + (((f8 * f7) * f7) / 2.0f));
            }
            this.mCurrentPosition = this.mStart + ((int) Math.round(d));
            return true;
        }

        public void updateScroll(float f) {
            int i = this.mStart;
            this.mCurrentPosition = i + Math.round(f * ((float) (this.mFinal - i)));
        }
    }

    public static class ViscousFluidInterpolator implements Interpolator {
        private static final float VISCOUS_FLUID_NORMALIZE;
        private static final float VISCOUS_FLUID_OFFSET;
        private static final float VISCOUS_FLUID_SCALE = 8.0f;

        static {
            float viscousFluid = 1.0f / viscousFluid(1.0f);
            VISCOUS_FLUID_NORMALIZE = viscousFluid;
            VISCOUS_FLUID_OFFSET = 1.0f - (viscousFluid * viscousFluid(1.0f));
        }

        private static float viscousFluid(float f) {
            float f2 = f * VISCOUS_FLUID_SCALE;
            return f2 < 1.0f ? f2 - (1.0f - ((float) Math.exp((double) (-f2)))) : 0.36787945f + ((1.0f - ((float) Math.exp((double) (1.0f - f2)))) * 0.63212055f);
        }

        public float getInterpolation(float f) {
            float viscousFluid = VISCOUS_FLUID_NORMALIZE * viscousFluid(f);
            return viscousFluid > 0.0f ? viscousFluid + VISCOUS_FLUID_OFFSET : viscousFluid;
        }
    }

    public OverScroller(Context context) {
        this(context, (Interpolator) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x002d A[Catch:{ NoSuchMethodException -> 0x0011, IllegalAccessException -> 0x000f, InvocationTargetException -> 0x000d, IllegalArgumentException -> 0x000b, ClassNotFoundException -> 0x0009 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void ScrollOptimizerSetFlingFlag(int r4) {
        /*
            r3 = this;
            java.lang.Class r0 = r3.mScrollOptimizerClass     // Catch:{ NoSuchMethodException -> 0x0011, IllegalAccessException -> 0x000f, InvocationTargetException -> 0x000d, IllegalArgumentException -> 0x000b, ClassNotFoundException -> 0x0009 }
            if (r0 == 0) goto L_0x0013
            java.lang.reflect.Method r0 = r3.mMethod     // Catch:{ NoSuchMethodException -> 0x0011, IllegalAccessException -> 0x000f, InvocationTargetException -> 0x000d, IllegalArgumentException -> 0x000b, ClassNotFoundException -> 0x0009 }
            if (r0 != 0) goto L_0x0029
            goto L_0x0013
        L_0x0009:
            r3 = move-exception
            goto L_0x0040
        L_0x000b:
            r3 = move-exception
            goto L_0x0044
        L_0x000d:
            r3 = move-exception
            goto L_0x0048
        L_0x000f:
            r3 = move-exception
            goto L_0x0056
        L_0x0011:
            r3 = move-exception
            goto L_0x005a
        L_0x0013:
            java.lang.String r0 = "android.util.BoostFramework$ScrollOptimizer"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ NoSuchMethodException -> 0x0011, IllegalAccessException -> 0x000f, InvocationTargetException -> 0x000d, IllegalArgumentException -> 0x000b, ClassNotFoundException -> 0x0009 }
            r3.mScrollOptimizerClass = r0     // Catch:{ NoSuchMethodException -> 0x0011, IllegalAccessException -> 0x000f, InvocationTargetException -> 0x000d, IllegalArgumentException -> 0x000b, ClassNotFoundException -> 0x0009 }
            java.lang.String r1 = "setFlingFlag"
            java.lang.Class r2 = java.lang.Integer.TYPE     // Catch:{ NoSuchMethodException -> 0x0011, IllegalAccessException -> 0x000f, InvocationTargetException -> 0x000d, IllegalArgumentException -> 0x000b, ClassNotFoundException -> 0x0009 }
            java.lang.Class[] r2 = new java.lang.Class[]{r2}     // Catch:{ NoSuchMethodException -> 0x0011, IllegalAccessException -> 0x000f, InvocationTargetException -> 0x000d, IllegalArgumentException -> 0x000b, ClassNotFoundException -> 0x0009 }
            java.lang.reflect.Method r0 = r0.getMethod(r1, r2)     // Catch:{ NoSuchMethodException -> 0x0011, IllegalAccessException -> 0x000f, InvocationTargetException -> 0x000d, IllegalArgumentException -> 0x000b, ClassNotFoundException -> 0x0009 }
            r3.mMethod = r0     // Catch:{ NoSuchMethodException -> 0x0011, IllegalAccessException -> 0x000f, InvocationTargetException -> 0x000d, IllegalArgumentException -> 0x000b, ClassNotFoundException -> 0x0009 }
        L_0x0029:
            java.lang.reflect.Method r0 = r3.mMethod     // Catch:{ NoSuchMethodException -> 0x0011, IllegalAccessException -> 0x000f, InvocationTargetException -> 0x000d, IllegalArgumentException -> 0x000b, ClassNotFoundException -> 0x0009 }
            if (r0 == 0) goto L_0x005d
            r1 = 1
            r0.setAccessible(r1)     // Catch:{ NoSuchMethodException -> 0x0011, IllegalAccessException -> 0x000f, InvocationTargetException -> 0x000d, IllegalArgumentException -> 0x000b, ClassNotFoundException -> 0x0009 }
            java.lang.reflect.Method r3 = r3.mMethod     // Catch:{ NoSuchMethodException -> 0x0011, IllegalAccessException -> 0x000f, InvocationTargetException -> 0x000d, IllegalArgumentException -> 0x000b, ClassNotFoundException -> 0x0009 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ NoSuchMethodException -> 0x0011, IllegalAccessException -> 0x000f, InvocationTargetException -> 0x000d, IllegalArgumentException -> 0x000b, ClassNotFoundException -> 0x0009 }
            java.lang.Object[] r4 = new java.lang.Object[]{r4}     // Catch:{ NoSuchMethodException -> 0x0011, IllegalAccessException -> 0x000f, InvocationTargetException -> 0x000d, IllegalArgumentException -> 0x000b, ClassNotFoundException -> 0x0009 }
            r0 = 0
            r3.invoke(r0, r4)     // Catch:{ NoSuchMethodException -> 0x0011, IllegalAccessException -> 0x000f, InvocationTargetException -> 0x000d, IllegalArgumentException -> 0x000b, ClassNotFoundException -> 0x0009 }
            goto L_0x005d
        L_0x0040:
            r3.printStackTrace()
            goto L_0x005d
        L_0x0044:
            r3.printStackTrace()
            goto L_0x005d
        L_0x0048:
            java.lang.Throwable r4 = r3.getTargetException()
            if (r4 == 0) goto L_0x005d
            java.lang.Throwable r3 = r3.getTargetException()
            r3.printStackTrace()
            goto L_0x005d
        L_0x0056:
            r3.printStackTrace()
            goto L_0x005d
        L_0x005a:
            r3.printStackTrace()
        L_0x005d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: flyme.support.v7.util.OverScroller.ScrollOptimizerSetFlingFlag(int):void");
    }

    public void abortAnimation() {
        ScrollOptimizerSetFlingFlag(0);
        this.mScrollerX.finish();
        this.mScrollerY.finish();
    }

    public boolean computeScrollOffset() {
        if (isFinished()) {
            ScrollOptimizerSetFlingFlag(0);
            return false;
        }
        int i = this.mMode;
        if (i == 0) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.mScrollerX.mStartTime;
            int access$500 = this.mScrollerX.mDuration;
            if (currentAnimationTimeMillis < ((long) access$500)) {
                float interpolation = this.mInterpolator.getInterpolation(((float) currentAnimationTimeMillis) / ((float) access$500));
                this.mScrollerX.updateScroll(interpolation);
                this.mScrollerY.updateScroll(interpolation);
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
        if (isFinished()) {
            ScrollOptimizerSetFlingFlag(0);
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
        if (z) {
            ScrollOptimizerSetFlingFlag(0);
        }
    }

    public float getCurrVelocity() {
        return (float) Math.hypot((double) this.mScrollerX.mCurrVelocity, (double) this.mScrollerY.mCurrVelocity);
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
        if (interpolator == null) {
            this.mInterpolator = new ViscousFluidInterpolator();
        } else {
            this.mInterpolator = interpolator;
        }
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

    public boolean useFlymeOptimizer() {
        return this.mScrollerX.mOptimizer.useOptimizer() || this.mScrollerY.mOptimizer.useOptimizer();
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
                    ScrollOptimizerSetFlingFlag(1);
                    this.mMode = 1;
                    this.mScrollerX.fling(i, i11, i5, i6, i9);
                    this.mScrollerY.fling(i2, i12, i7, i8, i10);
                }
                i12 = i13;
                i11 = i14;
                ScrollOptimizerSetFlingFlag(1);
                this.mMode = 1;
                this.mScrollerX.fling(i, i11, i5, i6, i9);
                this.mScrollerY.fling(i2, i12, i7, i8, i10);
            }
        }
        i13 = i4;
        i12 = i13;
        i11 = i14;
        ScrollOptimizerSetFlingFlag(1);
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
        if (interpolator == null) {
            this.mInterpolator = new ViscousFluidInterpolator();
        } else {
            this.mInterpolator = interpolator;
        }
        this.mFlywheel = z;
        this.mScrollerX = new SplineOverScroller(context, false);
        this.mScrollerY = new SplineOverScroller(context, true);
    }

    @Deprecated
    public OverScroller(Context context, Interpolator interpolator, float f, float f2) {
        this(context, interpolator, true);
    }

    @Deprecated
    public OverScroller(Context context, Interpolator interpolator, float f, float f2, boolean z) {
        this(context, interpolator, z);
    }
}
