package com.meizu.common.animator;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;

public class ClipFrameLayout extends FrameLayout {
    private static final long ANIMATION_DURATION = 420;
    private static final String TAG = "ClipFrameLayout";
    private static final Interpolator sInterpolator = PathInterpolatorCompat.a(0.12f, 0.0f, 0.2f, 1.0f);
    private RectF mClipBtmRectF;
    private boolean mClipEnable;
    private RectF mClipEndRectF;
    private RectF mClipStartRectF;
    private AnimatorSet mEnterAnim;
    private Paint mPaint;

    public ClipFrameLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    public RectF createEnterClipRectF(float f, boolean z, int i, int i2, float f2) {
        float f3;
        float f4;
        if (z) {
            f3 = ((1.0f - f) * ((float) (i - i2))) / 2.0f;
            f4 = 0.0f;
        } else {
            f4 = ((f * ((float) (i - i2))) / 2.0f) + (((float) (i2 + i)) / 2.0f);
            f3 = (float) i;
        }
        return new RectF(f4, 0.0f, f3, f2);
    }

    /* access modifiers changed from: private */
    public RectF createExitClipRectF(float f, boolean z, int i, int i2, float f2) {
        return z ? new RectF(0.0f, 0.0f, (f * ((float) (i - i2))) / 2.0f, f2) : new RectF((((1.0f - f) * ((float) (i - i2))) / 2.0f) + (((float) (i2 + i)) / 2.0f), 0.0f, (float) i, f2);
    }

    private void initPaint() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(0);
        this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.mPaint.setAntiAlias(true);
    }

    /* access modifiers changed from: private */
    public void setClipRoundRect(RectF rectF, RectF rectF2, RectF rectF3) {
        this.mClipBtmRectF = rectF;
        this.mClipStartRectF = rectF2;
        this.mClipEndRectF = rectF3;
        this.mClipEnable = true;
        invalidate();
    }

    private void stopEnterAnim() {
        AnimatorSet animatorSet = this.mEnterAnim;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.mEnterAnim.cancel();
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.mClipEnable) {
            RectF rectF = this.mClipBtmRectF;
            if (rectF != null) {
                canvas.drawRect(rectF, this.mPaint);
            }
            RectF rectF2 = this.mClipStartRectF;
            if (rectF2 != null && this.mClipEndRectF != null) {
                canvas.drawRect(rectF2, this.mPaint);
                canvas.drawRect(this.mClipEndRectF, this.mPaint);
            }
        }
    }

    public void startExposeEnterAnimator(final int i) {
        final int measuredHeight = getMeasuredHeight();
        final int measuredWidth = getMeasuredWidth();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, View.ALPHA, new float[]{0.0f, 1.0f});
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{0.0f, (float) measuredHeight});
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                RectF rectF;
                RectF rectF2;
                Object animatedValue = valueAnimator.getAnimatedValue();
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (animatedValue instanceof Float) {
                    float floatValue = ((Float) animatedValue).floatValue();
                    int i = measuredWidth;
                    float f = (float) i;
                    float f2 = (float) measuredHeight;
                    int i2 = i;
                    if (i <= i2 || i2 == 0) {
                        rectF2 = null;
                        rectF = null;
                    } else {
                        float f3 = animatedFraction;
                        float f4 = f2;
                        rectF2 = ClipFrameLayout.this.createEnterClipRectF(f3, true, i, i2, f4);
                        rectF = ClipFrameLayout.this.createEnterClipRectF(f3, false, measuredWidth, i, f4);
                    }
                    ClipFrameLayout.this.setClipRoundRect(new RectF(0.0f, floatValue, f, f2), rectF2, rectF);
                }
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        this.mEnterAnim = animatorSet;
        animatorSet.setDuration(ANIMATION_DURATION);
        this.mEnterAnim.setInterpolator(sInterpolator);
        this.mEnterAnim.playTogether(new Animator[]{ofFloat, ofFloat2});
        this.mEnterAnim.start();
    }

    public void startExposeExitAnimator(final int i) {
        stopEnterAnim();
        final int measuredHeight = getMeasuredHeight();
        final int measuredWidth = getMeasuredWidth();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, View.ALPHA, new float[]{1.0f, 0.0f});
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{(float) measuredHeight, 0.0f});
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                Object animatedValue = valueAnimator.getAnimatedValue();
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (animatedValue instanceof Float) {
                    float floatValue = ((Float) animatedValue).floatValue();
                    int i = measuredWidth;
                    float f = (float) measuredHeight;
                    float f2 = animatedFraction;
                    float f3 = f;
                    RectF access$200 = ClipFrameLayout.this.createExitClipRectF(f2, true, i, i, f3);
                    RectF access$2002 = ClipFrameLayout.this.createExitClipRectF(f2, false, measuredWidth, i, f3);
                    ClipFrameLayout.this.setClipRoundRect(new RectF(0.0f, floatValue, (float) i, f), access$200, access$2002);
                }
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(sInterpolator);
        animatorSet.setDuration(ANIMATION_DURATION);
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.start();
    }

    public ClipFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ClipFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setWillNotDraw(false);
        initPaint();
    }
}
