package com.honey.account.view.helper;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.honey.account.R;

public class SwimmingAnimationView extends View {
    private static final int ANIMATION_DOWN_DURATION = 450;
    private static final int ANIMATION_UP_DURATION = 520;
    private static final String TAG = "SwimmingAnimationView";
    /* access modifiers changed from: private */
    public Animator mAnimator;
    private Animator.AnimatorListener mAnimatorListener;
    private Paint mCirclePaint;
    private Context mContext;
    private int mDistance;
    private PathInterpolatorCompat mDownInterpolator;
    /* access modifiers changed from: private */
    public float mFirstPosition;
    private int mGap;
    private volatile boolean mIsAnimRun;
    private onPositionChange mOnChangeListener;
    private int mRadius;
    /* access modifiers changed from: private */
    public float mSecondPosition;
    /* access modifiers changed from: private */
    public float mThirdPosition;
    private PathInterpolatorCompat mUpInterpolator;

    public static class PositionUpdater implements ValueAnimator.AnimatorUpdateListener {
        private long firstDelay;
        private float firstDistance;
        private Interpolator firstDownInterpolator;
        private long firstDownTime;
        private Interpolator firstUpInterpolator;
        private long firstUpTime;
        private onPositionChange mOnChangeListener;
        private long secondDelay;
        private float secondDistance;
        private Interpolator secondDownInterpolator;
        private long secondDownTime;
        private Interpolator secondUpInterpolator;
        private long secondUpTime;
        private long thirdDelay;
        private float thirdDistance;
        private Interpolator thirdDownInterpolator;
        private long thirdDownTime;
        private Interpolator thirdUpInterpolator;
        private long thirdUpTime;

        private float calcPosition(float f, long j, long j2, long j3, float f2, Interpolator interpolator, Interpolator interpolator2) {
            float f3 = f - ((float) j);
            if (f3 < 0.0f) {
                f3 += (float) (j2 + j3);
            }
            float f4 = (float) j2;
            return f3 < f4 ? getNewPosition(0.0f, f2, interpolator, f3 / f4) : getNewPosition(f2, 0.0f, interpolator2, (f3 - f4) / ((float) j3));
        }

        private float getNewPosition(float f, float f2, Interpolator interpolator, float f3) {
            return f + ((f2 - f) * interpolator.getInterpolation(f3));
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (this.mOnChangeListener != null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.mOnChangeListener.onChange(calcPosition(floatValue, this.firstDelay, this.firstDownTime, this.firstUpTime, this.firstDistance, this.firstDownInterpolator, this.firstUpInterpolator), calcPosition(floatValue, this.secondDelay, this.secondDownTime, this.secondUpTime, this.secondDistance, this.secondDownInterpolator, this.secondUpInterpolator), calcPosition(floatValue, this.thirdDelay, this.thirdDownTime, this.thirdUpTime, this.thirdDistance, this.thirdDownInterpolator, this.thirdUpInterpolator));
            }
        }

        public void setFirstPosition(float f, long j, Interpolator interpolator, long j2, Interpolator interpolator2, long j3) {
            this.firstDistance = f;
            this.firstDownTime = j;
            this.firstDownInterpolator = interpolator;
            this.firstUpTime = j2;
            this.firstUpInterpolator = interpolator2;
            this.firstDelay = j3;
        }

        public void setOnChangeListener(onPositionChange onpositionchange) {
            this.mOnChangeListener = onpositionchange;
        }

        public void setSecondPosition(float f, long j, Interpolator interpolator, long j2, Interpolator interpolator2, long j3) {
            this.secondDistance = f;
            this.secondDownTime = j;
            this.secondDownInterpolator = interpolator;
            this.secondUpTime = j2;
            this.secondUpInterpolator = interpolator2;
            this.secondDelay = j3;
        }

        public void setThirdPosition(float f, long j, Interpolator interpolator, long j2, Interpolator interpolator2, long j3) {
            this.thirdDistance = f;
            this.thirdDownTime = j;
            this.thirdDownInterpolator = interpolator;
            this.thirdUpTime = j2;
            this.thirdUpInterpolator = interpolator2;
            this.thirdDelay = j3;
        }
    }

    public interface onPositionChange {
        void onChange(float f, float f2, float f3);
    }

    public SwimmingAnimationView(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    private Animator createAnimator() {
        PositionUpdater positionUpdater = new PositionUpdater();
        positionUpdater.setOnChangeListener(this.mOnChangeListener);
        positionUpdater.setFirstPosition((float) this.mDistance, 450, this.mDownInterpolator, 520, this.mUpInterpolator, 0);
        positionUpdater.setSecondPosition((float) this.mDistance, 450, this.mDownInterpolator, 520, this.mUpInterpolator, 83);
        positionUpdater.setThirdPosition((float) this.mDistance, 450, this.mDownInterpolator, 520, this.mUpInterpolator, 166);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, (float) 970});
        ofFloat.setDuration(970);
        ofFloat.addUpdateListener(positionUpdater);
        ofFloat.setInterpolator(new LinearInterpolator());
        return ofFloat;
    }

    private void updateAnimatorState(int i) {
        if (i != 0 || !isShown()) {
            stopAnimator();
        } else {
            startAnimator();
        }
    }

    public void clearData() {
        this.mFirstPosition = 0.0f;
        this.mSecondPosition = 0.0f;
        this.mThirdPosition = 0.0f;
    }

    public void onDraw(Canvas canvas) {
        int i = this.mRadius;
        canvas.drawCircle((float) i, ((float) i) + this.mFirstPosition, (float) i, this.mCirclePaint);
        int i2 = this.mRadius;
        canvas.drawCircle((float) ((i2 * 3) + this.mGap), ((float) i2) + this.mSecondPosition, (float) i2, this.mCirclePaint);
        int i3 = this.mRadius;
        canvas.drawCircle((float) ((i3 * 5) + (this.mGap * 2)), ((float) i3) + this.mThirdPosition, (float) i3, this.mCirclePaint);
    }

    public void onMeasure(int i, int i2) {
        int i3 = this.mRadius;
        int i4 = (i3 * 6) + (this.mGap * 2);
        int i5 = (i3 * 2) + this.mDistance;
        setMeasuredDimension(View.resolveSizeAndState(i4 + getPaddingLeft() + getPaddingRight(), i, 0), View.resolveSizeAndState(i5 + getPaddingTop() + getPaddingBottom(), i2, 0));
    }

    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        Log.d(TAG, "onVisibilityChanged=" + i + ", isShown=" + isShown() + ", getVisibility=" + getVisibility());
        updateAnimatorState(i);
    }

    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        Log.d(TAG, "onWindowVisibilityChanged:" + i + ", isShown=" + isShown());
        updateAnimatorState(i);
    }

    public void startAnimator() {
        if (!this.mIsAnimRun) {
            this.mIsAnimRun = true;
            this.mAnimator.addListener(this.mAnimatorListener);
            this.mAnimator.start();
            Log.d(TAG, "startAnimator");
        }
    }

    public void stopAnimator() {
        if (this.mIsAnimRun) {
            this.mIsAnimRun = false;
            this.mAnimator.removeAllListeners();
            this.mAnimator.cancel();
            clearData();
            Log.d(TAG, "stopAnimator");
        }
    }

    public SwimmingAnimationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwimmingAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsAnimRun = false;
        this.mDownInterpolator = new PathInterpolatorCompat(0.66f, 0.0f, 0.67f, 1.0f);
        this.mUpInterpolator = new PathInterpolatorCompat(0.33f, 0.0f, 0.27f, 1.0f);
        this.mOnChangeListener = new onPositionChange() {
            public void onChange(float f, float f2, float f3) {
                float unused = SwimmingAnimationView.this.mFirstPosition = f;
                float unused2 = SwimmingAnimationView.this.mSecondPosition = f2;
                float unused3 = SwimmingAnimationView.this.mThirdPosition = f3;
                SwimmingAnimationView.this.invalidate();
            }
        };
        this.mAnimatorListener = new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (Settings.Global.getFloat(SwimmingAnimationView.this.getContext().getContentResolver(), "animator_duration_scale", 1.0f) != 0.0f) {
                    SwimmingAnimationView.this.post(new Runnable() {
                        @TargetApi(17)
                        public void run() {
                            SwimmingAnimationView.this.mAnimator.start();
                        }
                    });
                    return;
                }
                Log.d(SwimmingAnimationView.TAG, "onAnimationEnd, animatorDurationScale == 0, stopAnimator");
                SwimmingAnimationView.this.stopAnimator();
            }
        };
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ha_swimming_animation_view);
        int color = obtainStyledAttributes.getColor(R.styleable.ha_swimming_animation_view_ha_circle_color, -12807940);
        this.mRadius = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ha_swimming_animation_view_ha_circle_radius, getResources().getDimensionPixelOffset(R.dimen.ha_swimming_circle_radius));
        this.mGap = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ha_swimming_animation_view_ha_circle_gap, getResources().getDimensionPixelOffset(R.dimen.ha_swimming_circle_gap));
        this.mDistance = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ha_swimming_animation_view_ha_circle_distance, getResources().getDimensionPixelOffset(R.dimen.ha_swimming_circle_distance));
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.mCirclePaint = paint;
        paint.setAntiAlias(true);
        this.mCirclePaint.setStyle(Paint.Style.FILL);
        this.mCirclePaint.setColor(color);
        this.mAnimator = createAnimator();
    }
}
