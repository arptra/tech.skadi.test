package com.meizu.common.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.meizu.common.R;
import io.netty.handler.codec.http2.Http2CodecUtil;

public class OperatingGuideView extends View {
    private static final Interpolator CLICK_ANIMATION_INTERPOLATOR = PathInterpolatorCompat.a(0.3f, 0.0f, 0.67f, 1.0f);
    private static final float DISMISS_SCALE_MULTI = 1.2f;
    public static final int OPERATION_TYPE_CLICK = 0;
    public static final int OPERATION_TYPE_SCALE_DOWN = 5;
    public static final int OPERATION_TYPE_SCALE_UP = 6;
    public static final int OPERATION_TYPE_SCROLL_BOTTOM = 4;
    public static final int OPERATION_TYPE_SCROLL_LEFT = 1;
    public static final int OPERATION_TYPE_SCROLL_RIGHT = 2;
    public static final int OPERATION_TYPE_SCROLL_TOP = 3;
    private static final Interpolator SCROLL_ANIMATION_INTERPOLATOR = PathInterpolatorCompat.a(0.44f, 0.0f, 0.34f, 1.0f);
    /* access modifiers changed from: private */
    public AnimatorSet mAnimator;
    /* access modifiers changed from: private */
    public float mCirclePositionX;
    /* access modifiers changed from: private */
    public float mCirclePositionY;
    private int mGesturePoints;
    private float mHeight;
    private float mInnerCircleAlpha;
    /* access modifiers changed from: private */
    public float mInnerCircleAlphaCur;
    private int mInnerCircleColor;
    private float mInnerCircleRadius;
    /* access modifiers changed from: private */
    public float mInnerCircleRadiusCur;
    private boolean mIsDrag;
    private LinearGradient mMoveGradient;
    private float mMultiCircleDistance;
    private int mOperationType;
    private float mOuterCircleAlpha;
    /* access modifiers changed from: private */
    public float mOuterCircleAlphaCur;
    private int mOuterCircleColor;
    private float mOuterCircleGradientAlpha;
    /* access modifiers changed from: private */
    public float mOuterCircleGradientAlphaEnd;
    /* access modifiers changed from: private */
    public float mOuterCircleGradientAlphaStart;
    private float mOuterCircleRadius;
    /* access modifiers changed from: private */
    public float mOuterCircleRadiusCur;
    private Path mOuterPath;
    /* access modifiers changed from: private */
    public float mOuterPathLength;
    private Paint mPaint;
    private float mScrollDistance;
    /* access modifiers changed from: private */
    public boolean mStop;
    private float mStretchLength;
    private float mWidth;

    public OperatingGuideView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void computeSize() {
        switch (this.mOperationType) {
            case 0:
                float f = this.mOuterCircleRadius * 2.0f * DISMISS_SCALE_MULTI;
                this.mWidth = f;
                this.mHeight = f;
                break;
            case 1:
            case 2:
                float f2 = this.mScrollDistance;
                float f3 = this.mOuterCircleRadius;
                this.mWidth = f2 + f3 + (f3 * DISMISS_SCALE_MULTI);
                this.mHeight = (f3 * 2.0f * DISMISS_SCALE_MULTI) + (((float) (this.mGesturePoints - 1)) * this.mMultiCircleDistance);
                break;
            case 3:
            case 4:
                float f4 = this.mScrollDistance;
                float f5 = this.mOuterCircleRadius;
                this.mHeight = f4 + f5 + (f5 * DISMISS_SCALE_MULTI);
                this.mWidth = (f5 * 2.0f * DISMISS_SCALE_MULTI) + (((float) (this.mGesturePoints - 1)) * this.mMultiCircleDistance);
                break;
            case 5:
                float sin = ((float) (Math.sin(0.7853981633974483d) * ((double) ((this.mScrollDistance * 2.0f) + this.mMultiCircleDistance)))) + (this.mOuterCircleRadius * 2.0f);
                this.mWidth = sin;
                this.mHeight = sin;
                break;
            case 6:
                float sin2 = ((float) (Math.sin(0.7853981633974483d) * ((double) ((this.mScrollDistance * 2.0f) + this.mMultiCircleDistance)))) + (this.mOuterCircleRadius * 2.0f * DISMISS_SCALE_MULTI);
                this.mWidth = sin2;
                this.mHeight = sin2;
                break;
            default:
                throw new IllegalArgumentException("incorrect operation type!");
        }
        this.mOuterPathLength = 0.0f;
        float f6 = this.mOuterCircleGradientAlpha;
        this.mOuterCircleGradientAlphaStart = f6;
        this.mOuterCircleGradientAlphaEnd = f6;
    }

    private AnimatorSet createClickAnimation() {
        initProperties();
        AnimatorSet createTapOutAnimator = createTapOutAnimator();
        AnimatorSet createDismissAnimator = createDismissAnimator();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.mOuterCircleAlpha, 0.0f});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = OperatingGuideView.this.mOuterCircleAlphaCur = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        ofFloat.setInterpolator(CLICK_ANIMATION_INTERPOLATOR);
        ofFloat.setDuration(150);
        createDismissAnimator.playTogether(new Animator[]{ofFloat});
        createDismissAnimator.setStartDelay(500);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{createTapOutAnimator, createDismissAnimator});
        return animatorSet;
    }

    private AnimatorSet createDismissAnimator() {
        AnimatorSet animatorSet = new AnimatorSet();
        float f = this.mInnerCircleRadius;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f, ((f * 2.0f) * DISMISS_SCALE_MULTI) / 2.0f});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = OperatingGuideView.this.mInnerCircleRadiusCur = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                OperatingGuideView.this.invalidate();
            }
        });
        ofFloat.setDuration(200);
        Interpolator interpolator = CLICK_ANIMATION_INTERPOLATOR;
        ofFloat.setInterpolator(interpolator);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{this.mInnerCircleAlpha, 0.0f});
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = OperatingGuideView.this.mInnerCircleAlphaCur = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        ofFloat2.setInterpolator(interpolator);
        ofFloat2.setDuration(200);
        float f2 = this.mOuterCircleRadius;
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(new float[]{f2, ((f2 * 2.0f) * DISMISS_SCALE_MULTI) / 2.0f});
        ofFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = OperatingGuideView.this.mOuterCircleRadiusCur = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        ofFloat3.setInterpolator(interpolator);
        ofFloat3.setDuration(200);
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3});
        return animatorSet;
    }

    private AnimatorSet createScrollAnimation() {
        initProperties();
        AnimatorSet createTapOutAnimator = createTapOutAnimator();
        AnimatorSet createScrollAnimator = createScrollAnimator();
        AnimatorSet createDismissAnimator = createDismissAnimator();
        if (this.mIsDrag) {
            createScrollAnimator.setStartDelay(500);
            createDismissAnimator.setStartDelay(1000);
        } else {
            createScrollAnimator.setStartDelay(100);
            createDismissAnimator.setStartDelay(600);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{createTapOutAnimator, createScrollAnimator, createDismissAnimator});
        return animatorSet;
    }

    private AnimatorSet createScrollAnimator() {
        AnimatorSet animatorSet = new AnimatorSet();
        float f = this.mOuterCircleRadius * DISMISS_SCALE_MULTI;
        float f2 = this.mCirclePositionX;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f2, this.mScrollDistance + f2});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = OperatingGuideView.this.mCirclePositionX = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                OperatingGuideView.this.invalidate();
            }
        });
        ofFloat.setDuration(800);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{f, f});
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = OperatingGuideView.this.mCirclePositionY = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                OperatingGuideView.this.invalidate();
            }
        });
        ofFloat2.setDuration(800);
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(new float[]{0.0f, this.mStretchLength});
        ofFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = OperatingGuideView.this.mOuterPathLength = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                OperatingGuideView.this.invalidate();
            }
        });
        ofFloat3.setDuration(500);
        ofFloat3.setStartDelay(100);
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(new float[]{this.mStretchLength, 0.0f});
        ofFloat4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = OperatingGuideView.this.mOuterPathLength = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                OperatingGuideView.this.invalidate();
            }
        });
        ofFloat4.setDuration(200);
        ofFloat4.setStartDelay(500);
        ValueAnimator ofFloat5 = ValueAnimator.ofFloat(new float[]{this.mOuterCircleGradientAlpha, 0.0f});
        ofFloat5.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = OperatingGuideView.this.mOuterCircleGradientAlphaStart = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                OperatingGuideView.this.invalidate();
            }
        });
        ofFloat5.setDuration(800);
        Interpolator interpolator = CLICK_ANIMATION_INTERPOLATOR;
        ofFloat5.setInterpolator(interpolator);
        ValueAnimator ofFloat6 = ValueAnimator.ofFloat(new float[]{this.mOuterCircleGradientAlpha, 0.0f});
        ofFloat6.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = OperatingGuideView.this.mOuterCircleGradientAlphaEnd = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                OperatingGuideView.this.invalidate();
            }
        });
        ofFloat6.setDuration(150);
        ofFloat6.setStartDelay(800);
        ofFloat6.setInterpolator(interpolator);
        animatorSet.setInterpolator(SCROLL_ANIMATION_INTERPOLATOR);
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat3, ofFloat5, ofFloat4, ofFloat6});
        return animatorSet;
    }

    private AnimatorSet createTapOutAnimator() {
        AnimatorSet animatorSet = new AnimatorSet();
        float f = this.mInnerCircleRadius;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{((f * 2.0f) * DISMISS_SCALE_MULTI) / 2.0f, f});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = OperatingGuideView.this.mInnerCircleRadiusCur = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                OperatingGuideView.this.invalidate();
            }
        });
        ofFloat.setDuration(200);
        Interpolator interpolator = CLICK_ANIMATION_INTERPOLATOR;
        ofFloat.setInterpolator(interpolator);
        AnimatorSet.Builder play = animatorSet.play(ofFloat);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{0.0f, this.mInnerCircleAlpha});
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = OperatingGuideView.this.mInnerCircleAlphaCur = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        ofFloat2.setInterpolator(interpolator);
        ofFloat2.setDuration(200);
        play.with(ofFloat2);
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(new float[]{0.0f, this.mOuterCircleRadius});
        ofFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = OperatingGuideView.this.mOuterCircleRadiusCur = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        ofFloat3.setInterpolator(interpolator);
        ofFloat3.setDuration(200);
        play.with(ofFloat3);
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(new float[]{0.0f, this.mOuterCircleAlpha});
        ofFloat4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = OperatingGuideView.this.mOuterCircleAlphaCur = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        ofFloat4.setInterpolator(interpolator);
        ofFloat4.setDuration(200);
        play.with(ofFloat4);
        return animatorSet;
    }

    private void drawGesture(Canvas canvas) {
        float f;
        float f2;
        float f3;
        float f4;
        int i;
        int i2;
        Canvas canvas2 = canvas;
        int save = canvas.save();
        int i3 = this.mOperationType;
        if (i3 == 1) {
            canvas2.translate(this.mWidth - ((this.mOuterCircleRadius * 2.0f) * DISMISS_SCALE_MULTI), 0.0f);
            float f5 = this.mOuterCircleRadius;
            canvas2.rotate(180.0f, f5 * DISMISS_SCALE_MULTI, f5 * DISMISS_SCALE_MULTI);
        } else if (i3 == 4) {
            float f6 = this.mOuterCircleRadius;
            canvas2.rotate(90.0f, f6 * DISMISS_SCALE_MULTI, f6 * DISMISS_SCALE_MULTI);
        } else if (i3 == 3) {
            float f7 = this.mOuterCircleRadius;
            canvas2.rotate(270.0f, f7 * DISMISS_SCALE_MULTI, f7 * DISMISS_SCALE_MULTI);
            canvas2.translate(-(this.mHeight - ((this.mOuterCircleRadius * 2.0f) * DISMISS_SCALE_MULTI)), 0.0f);
        } else if (i3 == 5) {
            canvas2.translate(this.mWidth - ((this.mOuterCircleRadius * 2.0f) * DISMISS_SCALE_MULTI), 0.0f);
            float f8 = this.mOuterCircleRadius;
            canvas2.rotate(135.0f, f8 * DISMISS_SCALE_MULTI, f8 * DISMISS_SCALE_MULTI);
        } else if (i3 == 6) {
            float sin = (float) (Math.sin(0.7853981633974483d) * ((double) this.mScrollDistance));
            float f9 = this.mWidth;
            float f10 = this.mOuterCircleRadius;
            canvas2.translate(((f9 - (f10 * 2.0f)) - sin) - (f10 * 0.2f), sin);
            float f11 = this.mOuterCircleRadius;
            canvas2.rotate(-45.0f, f11, f11);
        }
        this.mPaint.setColor(this.mInnerCircleColor);
        this.mPaint.setAlpha((int) (this.mInnerCircleAlphaCur * 255.0f));
        this.mPaint.setStyle(Paint.Style.FILL);
        canvas2.drawCircle(this.mCirclePositionX, this.mCirclePositionY, this.mInnerCircleRadiusCur, this.mPaint);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.mOuterCircleRadiusCur * 2.0f);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        if (this.mOperationType != 0) {
            f4 = this.mCirclePositionX;
            f3 = this.mCirclePositionY;
            float f12 = this.mOuterPathLength;
            float f13 = f4 - f12;
            if (f12 == 0.0f) {
                i2 = (((int) ((((this.mOuterCircleGradientAlpha / this.mOuterCircleAlpha) * this.mOuterCircleAlphaCur) * 255.0f) + 0.5f)) << 24) | this.mOuterCircleColor;
                i = i2;
            } else {
                int i4 = this.mOuterCircleColor;
                i = (((int) ((this.mOuterCircleGradientAlphaStart * 255.0f) + 0.5f)) << 24) | i4;
                i2 = (((int) ((this.mOuterCircleGradientAlphaEnd * 255.0f) + 0.5f)) << 24) | i4;
            }
            LinearGradient linearGradient = new LinearGradient(Math.max(0.0f, this.mOuterCircleRadiusCur + f4), f3, f13 - this.mOuterCircleRadiusCur, f3, i2, i, Shader.TileMode.CLAMP);
            this.mMoveGradient = linearGradient;
            this.mPaint.setShader(linearGradient);
            f2 = f3;
            f = f13;
        } else {
            f4 = this.mCirclePositionX;
            f3 = this.mCirclePositionY;
            this.mPaint.setColor(this.mOuterCircleColor);
            this.mPaint.setAlpha((int) (this.mOuterCircleAlphaCur * 255.0f));
            f = f4;
            f2 = f3;
        }
        this.mOuterPath.reset();
        this.mOuterPath.moveTo(f4, f3);
        this.mOuterPath.lineTo(f, f2);
        canvas2.drawPath(this.mOuterPath, this.mPaint);
        this.mPaint.setShader((Shader) null);
        canvas2.restoreToCount(save);
    }

    /* access modifiers changed from: private */
    public void initProperties() {
        if (this.mOperationType != 0) {
            float f = this.mOuterCircleRadius;
            this.mCirclePositionX = f;
            this.mCirclePositionY = f * DISMISS_SCALE_MULTI;
        } else {
            float f2 = this.mOuterCircleRadius;
            this.mCirclePositionX = f2 * DISMISS_SCALE_MULTI;
            this.mCirclePositionY = f2 * DISMISS_SCALE_MULTI;
        }
        this.mOuterPathLength = 0.0f;
        float f3 = this.mOuterCircleGradientAlpha;
        this.mOuterCircleGradientAlphaStart = f3;
        this.mOuterCircleGradientAlphaEnd = f3;
        this.mOuterCircleRadiusCur = 0.0f;
        this.mInnerCircleRadiusCur = 0.0f;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawGesture(canvas);
        int i = this.mOperationType;
        if (i == 5 || i == 6) {
            int save = canvas.save();
            canvas.rotate(180.0f, this.mWidth / 2.0f, this.mHeight / 2.0f);
            drawGesture(canvas);
            canvas.restoreToCount(save);
            return;
        }
        int i2 = 1;
        if (this.mGesturePoints <= 1) {
            return;
        }
        if (i == 1 || i == 2) {
            while (i2 < this.mGesturePoints) {
                int save2 = canvas.save();
                canvas.translate(0.0f, this.mMultiCircleDistance * ((float) i2));
                drawGesture(canvas);
                canvas.restoreToCount(save2);
                i2++;
            }
        } else if (i == 3 || i == 4) {
            while (i2 < this.mGesturePoints) {
                int save3 = canvas.save();
                canvas.translate(this.mMultiCircleDistance * ((float) i2), 0.0f);
                drawGesture(canvas);
                canvas.restoreToCount(save3);
                i2++;
            }
        }
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        computeSize();
        setMeasuredDimension((int) this.mWidth, (int) this.mHeight);
    }

    public void setDrag(boolean z) {
        this.mIsDrag = z;
    }

    public void setGesturePoints(int i) {
        this.mGesturePoints = i;
    }

    public void setOperationType(int i) {
        if (this.mOperationType == -1) {
            this.mOperationType = i;
            return;
        }
        throw new IllegalStateException("can't change the operation type");
    }

    public void startAnimation() {
        if (this.mAnimator == null) {
            switch (this.mOperationType) {
                case 0:
                    this.mAnimator = createClickAnimation();
                    break;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    this.mAnimator = createScrollAnimation();
                    break;
                default:
                    throw new IllegalArgumentException("incorrect operation type!");
            }
        }
        this.mAnimator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (!OperatingGuideView.this.mStop) {
                    OperatingGuideView.this.postDelayed(new Runnable() {
                        public void run() {
                            if (!OperatingGuideView.this.mStop) {
                                OperatingGuideView.this.mAnimator.start();
                            }
                        }
                    }, 100);
                }
            }

            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                OperatingGuideView.this.initProperties();
            }
        });
        this.mStop = false;
        this.mAnimator.start();
    }

    public void stopAnimation() {
        this.mStop = true;
        AnimatorSet animatorSet = this.mAnimator;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.mAnimator.end();
        }
    }

    public OperatingGuideView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInnerCircleColor = Http2CodecUtil.MAX_FRAME_SIZE_UPPER_BOUND;
        this.mOuterCircleColor = Http2CodecUtil.MAX_FRAME_SIZE_UPPER_BOUND;
        this.mInnerCircleAlpha = 0.7f;
        this.mInnerCircleAlphaCur = 0.7f;
        this.mOuterCircleAlpha = 0.18f;
        this.mOuterCircleGradientAlpha = 0.6f;
        this.mOuterCircleGradientAlphaStart = 0.6f;
        this.mOuterCircleGradientAlphaEnd = 0.6f;
        this.mOperationType = -1;
        this.mGesturePoints = 1;
        Resources resources = context.getResources();
        this.mInnerCircleRadius = (float) resources.getDimensionPixelSize(R.dimen.mz_operating_guide_inner_circle_radius);
        this.mOuterCircleRadius = (float) resources.getDimensionPixelSize(R.dimen.mz_operating_guide_outer_circle_radius);
        this.mScrollDistance = (float) resources.getDimensionPixelSize(R.dimen.mz_operating_guide_scroll_distance);
        float f = this.mOuterCircleRadius;
        this.mStretchLength = ((float) resources.getDimensionPixelSize(R.dimen.mz_operating_guide_stretch_length)) - (2.0f * f);
        this.mMultiCircleDistance = f * 3.0f;
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mOuterPath = new Path();
    }
}
