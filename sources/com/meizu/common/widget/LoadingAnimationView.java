package com.meizu.common.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.meizu.common.R;
import com.meizu.common.interpolator.PathInterpolatorCompat;

public class LoadingAnimationView extends View {
    private static final String TAG = "LoadingAnimationView";
    private final String[] alphaProperty;
    private int bAlpha;
    private boolean bDraw;
    private float baseX;
    private float baseY;
    private float cbPosition;
    private float cbRadius;
    private float cgPosition;
    private float cgRadius;
    private float crPosition;
    private float crRadius;
    private int gAlpha;
    private boolean gDraw;
    private float halfMaxRadius;
    private float mAnimScale;
    /* access modifiers changed from: private */
    public AnimatorSet mAnimator;
    private Animator.AnimatorListener mAnimatorListener;
    private Paint mBluePaint;
    private Paint mGreenPaint;
    private volatile boolean mIsAnimRun;
    private Paint mRedPaint;
    private float maxRadius;
    private float po1;
    private float po2;
    private float po3;
    private float po4;
    private float po5;
    private final String[] positionProperty;
    private int rAlpha;
    private boolean rDraw;
    private final String[] radiusProperty;

    public LoadingAnimationView(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    private Animator createAlphaAnimator(int i) {
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this, this.alphaProperty[i], new int[]{255, 255});
        ofInt.setDuration(704);
        ObjectAnimator ofInt2 = ObjectAnimator.ofInt(this, this.alphaProperty[i], new int[]{255, 255});
        ofInt2.setDuration(704);
        ObjectAnimator ofInt3 = ObjectAnimator.ofInt(this, this.alphaProperty[i], new int[]{255, 255});
        ofInt3.setDuration(224);
        ObjectAnimator ofInt4 = ObjectAnimator.ofInt(this, this.alphaProperty[i], new int[]{0, 0});
        ofInt4.setDuration(160);
        ObjectAnimator ofInt5 = ObjectAnimator.ofInt(this, this.alphaProperty[i], new int[]{255, 255});
        ObjectAnimator[] objectAnimatorArr = {ofInt, ofInt2, ofInt3, ofInt4, ofInt5};
        ofInt5.setDuration(320);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(new Animator[]{objectAnimatorArr[i % 5], objectAnimatorArr[(i + 1) % 5], objectAnimatorArr[(i + 2) % 5], objectAnimatorArr[(i + 3) % 5], objectAnimatorArr[(i + 4) % 5]});
        return animatorSet;
    }

    private AnimatorSet createAnimatorSet() {
        Animator createPositionAnimator = createPositionAnimator(0);
        Animator createPositionAnimator2 = createPositionAnimator(1);
        Animator createPositionAnimator3 = createPositionAnimator(2);
        Animator createRadiusAnimator = createRadiusAnimator(0);
        Animator createRadiusAnimator2 = createRadiusAnimator(1);
        Animator createRadiusAnimator3 = createRadiusAnimator(2);
        Animator createAlphaAnimator = createAlphaAnimator(0);
        Animator createAlphaAnimator2 = createAlphaAnimator(1);
        Animator createAlphaAnimator3 = createAlphaAnimator(2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{createPositionAnimator, createPositionAnimator2, createPositionAnimator3, createRadiusAnimator, createRadiusAnimator2, createRadiusAnimator3, createAlphaAnimator, createAlphaAnimator2, createAlphaAnimator3});
        return animatorSet;
    }

    private Paint createCommonPaint() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        return paint;
    }

    private Animator createPositionAnimator(int i) {
        ObjectAnimator[] objectAnimatorArr = new ObjectAnimator[5];
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, this.positionProperty[i], new float[]{0.0f, this.po2});
        objectAnimatorArr[0] = ofFloat;
        ofFloat.setDuration(704);
        objectAnimatorArr[0].setInterpolator(new PathInterpolatorCompat(0.21f, 0.0f, 0.35f, 0.471f));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, this.positionProperty[i], new float[]{this.po2, this.po3});
        objectAnimatorArr[1] = ofFloat2;
        ofFloat2.setDuration(704);
        objectAnimatorArr[1].setInterpolator(new PathInterpolatorCompat(0.24f, 0.341f, 0.41f, 1.0f));
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this, this.positionProperty[i], new float[]{this.po3, this.po4});
        objectAnimatorArr[2] = ofFloat3;
        ofFloat3.setDuration(224);
        objectAnimatorArr[2].setInterpolator(new PathInterpolatorCompat(0.25f, 0.0f, 0.61f, 0.48f));
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this, this.positionProperty[i], new float[]{this.po4, this.po5});
        objectAnimatorArr[3] = ofFloat4;
        ofFloat4.setDuration(160);
        objectAnimatorArr[3].setInterpolator(new PathInterpolatorCompat(0.4f, 0.07f, 0.66f, 0.965f));
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this, this.positionProperty[i], new float[]{this.po5, this.po1});
        objectAnimatorArr[4] = ofFloat5;
        ofFloat5.setDuration(320);
        objectAnimatorArr[4].setInterpolator(new PathInterpolatorCompat(0.31f, 0.62f, 0.66f, 1.0f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(new Animator[]{objectAnimatorArr[i % 5], objectAnimatorArr[(i + 1) % 5], objectAnimatorArr[(i + 2) % 5], objectAnimatorArr[(i + 3) % 5], objectAnimatorArr[(i + 4) % 5]});
        return animatorSet;
    }

    private Animator createRadiusAnimator(int i) {
        ObjectAnimator[] objectAnimatorArr = new ObjectAnimator[5];
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, this.radiusProperty[i], new float[]{this.halfMaxRadius, this.maxRadius});
        objectAnimatorArr[0] = ofFloat;
        ofFloat.setInterpolator(new PathInterpolatorCompat(0.24f, 0.209f, 0.25f, 1.0f));
        objectAnimatorArr[0].setDuration(704);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, this.radiusProperty[i], new float[]{this.maxRadius, this.halfMaxRadius});
        objectAnimatorArr[1] = ofFloat2;
        ofFloat2.setInterpolator(new PathInterpolatorCompat(0.29f, 0.0f, 0.32f, 0.631f));
        objectAnimatorArr[1].setDuration(704);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this, this.radiusProperty[i], new float[]{this.halfMaxRadius, this.maxRadius * 0.3f});
        objectAnimatorArr[2] = ofFloat3;
        ofFloat3.setInterpolator(new PathInterpolatorCompat(0.36f, 0.27f, 0.5f, 0.675f));
        objectAnimatorArr[2].setDuration(224);
        String str = this.radiusProperty[i];
        float f = this.maxRadius;
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this, str, new float[]{0.25f * f, f * 0.34f});
        objectAnimatorArr[3] = ofFloat4;
        ofFloat4.setInterpolator(new PathInterpolatorCompat(0.18f, 0.45f, 0.66f, 0.3f));
        objectAnimatorArr[3].setDuration(160);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this, this.radiusProperty[i], new float[]{this.maxRadius * 0.34f, this.halfMaxRadius});
        objectAnimatorArr[4] = ofFloat5;
        ofFloat5.setInterpolator(new PathInterpolatorCompat(0.26f, 0.265f, 0.59f, 0.61f));
        objectAnimatorArr[4].setDuration(320);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(new Animator[]{objectAnimatorArr[i % 5], objectAnimatorArr[(i + 1) % 5], objectAnimatorArr[(i + 2) % 5], objectAnimatorArr[(i + 3) % 5], objectAnimatorArr[(i + 4) % 5]});
        return animatorSet;
    }

    private void init(Context context) {
        initData(context);
        Paint createCommonPaint = createCommonPaint();
        this.mRedPaint = createCommonPaint;
        createCommonPaint.setColor(-11687857);
        Paint createCommonPaint2 = createCommonPaint();
        this.mBluePaint = createCommonPaint2;
        createCommonPaint2.setColor(-11699757);
        Paint createCommonPaint3 = createCommonPaint();
        this.mGreenPaint = createCommonPaint3;
        createCommonPaint3.setColor(14576188);
    }

    private void initData(Context context) {
        float density = getDensity(context) * this.mAnimScale;
        float f = 7.0f * density;
        this.maxRadius = f;
        this.halfMaxRadius = f * 0.5f;
        this.po1 = 0.0f;
        this.po2 = 15.0f * density;
        this.po3 = 30.0f * density;
        this.po4 = 27.6f * density;
        this.po5 = density * 2.6f;
        this.baseX = getX() + this.halfMaxRadius + (this.mAnimScale * 2.0f);
        this.baseY = getY();
    }

    private void setBAlpha(int i) {
        int round = Math.round((float) i);
        this.bAlpha = round;
        this.mBluePaint.setAlpha(round);
    }

    private void setCbPosition(float f) {
        this.cbPosition = f;
    }

    private void setCbRadius(float f) {
        this.cbRadius = f;
    }

    private void setCgPosition(float f) {
        this.cgPosition = f;
        invalidate();
    }

    private void setCgRadius(float f) {
        this.cgRadius = f;
    }

    private void setCrPosition(float f) {
        this.crPosition = f;
    }

    private void setCrRadius(float f) {
        this.crRadius = f;
    }

    private void setGAlpha(int i) {
        int round = Math.round((float) i);
        this.gAlpha = round;
        this.mGreenPaint.setAlpha(round);
    }

    private void setRAlpha(int i) {
        int round = Math.round((float) i);
        this.rAlpha = round;
        this.mRedPaint.setAlpha(round);
    }

    private void updateAnimatorState(int i) {
        if (i != 0 || !isShown()) {
            stopAnimator();
        } else {
            startAnimator();
        }
    }

    public void clearData() {
        this.crPosition = 0.0f;
        this.cgPosition = 0.0f;
        this.cbPosition = 0.0f;
        this.crRadius = 0.0f;
        this.cbRadius = 0.0f;
        this.cgRadius = 0.0f;
        this.rAlpha = 255;
        this.bAlpha = 255;
        this.gAlpha = 255;
    }

    public float getDensity(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public void onDraw(Canvas canvas) {
        float f = this.crRadius;
        if (f < this.halfMaxRadius) {
            canvas.drawCircle(this.baseX + this.crPosition, this.baseY + this.maxRadius, f, this.mRedPaint);
            this.rDraw = true;
        }
        float f2 = this.cbRadius;
        if (f2 < this.halfMaxRadius) {
            canvas.drawCircle(this.baseX + this.cbPosition, this.baseY + this.maxRadius, f2, this.mBluePaint);
            this.bDraw = true;
        }
        float f3 = this.cgRadius;
        if (f3 < this.halfMaxRadius) {
            canvas.drawCircle(this.baseX + this.cgPosition, this.baseY + this.maxRadius, f3, this.mGreenPaint);
            this.gDraw = true;
        }
        if (!this.rDraw) {
            canvas.drawCircle(this.baseX + this.crPosition, this.baseY + this.maxRadius, this.crRadius, this.mRedPaint);
        }
        if (!this.bDraw) {
            canvas.drawCircle(this.baseX + this.cbPosition, this.baseY + this.maxRadius, this.cbRadius, this.mBluePaint);
        }
        if (!this.gDraw) {
            canvas.drawCircle(this.baseX + this.cgPosition, this.baseY + this.maxRadius, this.cgRadius, this.mGreenPaint);
        }
        this.rDraw = false;
        this.bDraw = false;
        this.gDraw = false;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ApplyingAnimationView.class.getName());
    }

    public void onMeasure(int i, int i2) {
        int round = Math.round((this.po3 - this.po1) + this.maxRadius + (this.mAnimScale * 4.0f) + 0.5f);
        int round2 = Math.round((this.maxRadius * 2.0f) + 0.5f);
        setMeasuredDimension(View.resolveSizeAndState(round + getPaddingLeft() + getPaddingRight(), i, 0), View.resolveSizeAndState(round2 + getPaddingTop() + getPaddingBottom(), i2, 0));
    }

    public void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        Log.d(TAG, "onVisibilityChanged=" + i + ", isShown=" + isShown() + ", getVisibility=" + getVisibility());
        updateAnimatorState(i);
    }

    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        Log.d(TAG, "onWindowVisibilityChanged:" + i + ", isShown=" + isShown());
        updateAnimatorState(i);
    }

    @UiThread
    public void startAnimator() {
        if (!this.mIsAnimRun) {
            this.mIsAnimRun = true;
            this.mAnimator.addListener(this.mAnimatorListener);
            this.mAnimator.start();
            Log.d(TAG, "startAnimator");
        }
    }

    @UiThread
    public void stopAnimator() {
        if (this.mIsAnimRun) {
            this.mIsAnimRun = false;
            this.mAnimator.removeAllListeners();
            this.mAnimator.cancel();
            clearData();
            Log.d(TAG, "stopAnimator");
        }
    }

    public LoadingAnimationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadingAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.rAlpha = 255;
        this.bAlpha = 255;
        this.gAlpha = 255;
        this.positionProperty = new String[]{"crPosition", "cbPosition", "cgPosition"};
        this.alphaProperty = new String[]{"rAlpha", "bAlpha", "gAlpha"};
        this.radiusProperty = new String[]{"crRadius", "cbRadius", "cgRadius"};
        this.rDraw = false;
        this.bDraw = false;
        this.gDraw = false;
        this.mIsAnimRun = false;
        this.mAnimScale = 1.0f;
        this.mAnimatorListener = new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (Settings.Global.getFloat(LoadingAnimationView.this.getContext().getContentResolver(), "animator_duration_scale", 1.0f) != 0.0f) {
                    LoadingAnimationView.this.post(new Runnable() {
                        @TargetApi(17)
                        public void run() {
                            LoadingAnimationView.this.mAnimator.start();
                        }
                    });
                    return;
                }
                Log.d(LoadingAnimationView.TAG, "onAnimationEnd, animatorDurationScale == 0, stopAnimator");
                LoadingAnimationView.this.stopAnimator();
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ApplyingAnimationView);
        this.mAnimScale = obtainStyledAttributes.getFloat(R.styleable.ApplyingAnimationView_mcApplyingAnimationScale, this.mAnimScale);
        obtainStyledAttributes.recycle();
        init(context);
        this.mAnimator = createAnimatorSet();
    }
}
