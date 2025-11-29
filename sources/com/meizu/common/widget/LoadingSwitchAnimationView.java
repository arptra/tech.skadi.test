package com.meizu.common.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.meizu.common.R;

public class LoadingSwitchAnimationView extends View {
    public static int LEFTSITION = 1;
    public static int MIDDLEPOSITION = 3;
    public static int RIGHTPOSITION = 2;
    private int DEFALTDURATION;
    private int DEFALTITEMCOUNT;
    int animateDuration;
    AnimationEndListener animationEndListener;
    int backgroundCurrentPosition;
    Path backgroundPath;
    float distanceToMiddle;
    float distanceX;
    float distanceY;
    float[] index1;
    float[] index2;
    float indexStart;
    float indexoffset;
    boolean isAnimating;
    boolean isBackgroundOnleft;
    int itemCount;
    Paint lateralSlidingBackgroundPaint;
    float leftIconChangeLength;
    float leftIconChangePosition;
    float[] leftIconPosition;
    RectF leftIconRect;
    Bitmap leftIconSelected;
    Paint leftIconSelectedPaint;
    Bitmap leftIconUnselected;
    Paint leftIconUnselectedPaint;
    float middleIconChangeLength;
    float middleIconChangePositionToLeft;
    float middleIconChangePositionToRight;
    float[] middleIconPosition;
    RectF middleIconRect;
    float offsetX;
    boolean offsetYValid;
    float originalHeight;
    float originalWidth;
    RectF ovalBackgroundRect;
    float picRadius;
    Paint pullLeftIconPaint;
    Paint pullRefreshOnAndBackgroundPaint;
    Paint pullRightIconPaint;
    float rightIconChangeLength;
    float rightIconChangePosition;
    float[] rightIconPosition;
    RectF rightIconRect;
    Bitmap rightIconSelected;
    Paint rightIconSelectedPaint;
    Bitmap rightIconUnselected;
    Paint rightIconUnselectedPaint;
    float rotationangle;
    float scaleHeight;
    float scaleWidth;
    float viewHeight;
    float viewWidth;

    public interface AnimationEndListener {
        void AnimationEnd();
    }

    public LoadingSwitchAnimationView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void drawWhenLateralSliding(Canvas canvas) {
        Canvas canvas2 = canvas;
        float[] fArr = this.index1;
        float f = this.indexStart;
        float f2 = this.distanceX;
        float f3 = this.indexoffset;
        fArr[0] = f + f2 + f3;
        RectF rectF = this.ovalBackgroundRect;
        fArr[1] = rectF.top;
        float[] fArr2 = this.index2;
        fArr2[0] = f + f2 + f3;
        fArr2[1] = rectF.bottom;
        canvas2.drawOval(rectF, this.lateralSlidingBackgroundPaint);
        this.backgroundPath.reset();
        Path path = this.backgroundPath;
        RectF rectF2 = this.ovalBackgroundRect;
        path.moveTo(rectF2.left + (rectF2.width() / 2.0f), this.ovalBackgroundRect.top);
        Path path2 = this.backgroundPath;
        float[] fArr3 = this.index1;
        float f4 = fArr3[0];
        float f5 = fArr3[1];
        float[] fArr4 = this.index2;
        float f6 = fArr4[0];
        float f7 = fArr4[1];
        RectF rectF3 = this.ovalBackgroundRect;
        path2.cubicTo(f4, f5, f6, f7, rectF3.left + (rectF3.width() / 2.0f), this.ovalBackgroundRect.bottom);
        this.backgroundPath.close();
        canvas2.drawPath(this.backgroundPath, this.lateralSlidingBackgroundPaint);
        canvas2.drawBitmap(this.leftIconUnselected, (Rect) null, this.leftIconRect, this.leftIconUnselectedPaint);
        canvas2.drawBitmap(this.leftIconSelected, (Rect) null, this.leftIconRect, this.leftIconSelectedPaint);
        canvas2.drawBitmap(this.rightIconUnselected, (Rect) null, this.rightIconRect, this.rightIconUnselectedPaint);
        canvas2.drawBitmap(this.rightIconSelected, (Rect) null, this.rightIconRect, this.rightIconSelectedPaint);
    }

    private void drawWhenPull(Canvas canvas) {
        canvas.drawOval(this.ovalBackgroundRect, this.pullRefreshOnAndBackgroundPaint);
        canvas.drawBitmap(this.rightIconUnselected, (Rect) null, this.rightIconRect, this.pullRightIconPaint);
        float f = this.distanceY;
        if (f < 265.0f) {
            this.rotationangle = ((264.0f - f) * 180.0f) / 264.0f;
            canvas.save();
            canvas.rotate(this.rotationangle, this.leftIconRect.centerX(), this.leftIconRect.centerY());
            canvas.drawBitmap(this.leftIconUnselected, (Rect) null, this.leftIconRect, this.pullLeftIconPaint);
            canvas.restore();
            return;
        }
        canvas.drawBitmap(this.leftIconSelected, (Rect) null, this.leftIconRect, this.pullRefreshOnAndBackgroundPaint);
    }

    private void startAnimate(final boolean z) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{z ? this.leftIconRect.left : this.rightIconRect.right, z ? this.rightIconRect.left : this.leftIconRect.right});
        ofFloat.setDuration((long) this.animateDuration);
        final float f = this.distanceX;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            float currentFraction = 0.0f;

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.currentFraction = valueAnimator.getAnimatedFraction();
                if (z) {
                    LoadingSwitchAnimationView.this.ovalBackgroundRect.left = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    LoadingSwitchAnimationView loadingSwitchAnimationView = LoadingSwitchAnimationView.this;
                    RectF rectF = loadingSwitchAnimationView.ovalBackgroundRect;
                    float f = loadingSwitchAnimationView.leftIconRect.left;
                    float f2 = loadingSwitchAnimationView.scaleWidth;
                    float f3 = f + f2 + (this.currentFraction * (loadingSwitchAnimationView.rightIconRect.right - (f + f2)));
                    rectF.right = f3;
                    loadingSwitchAnimationView.indexStart = f3;
                } else {
                    LoadingSwitchAnimationView.this.ovalBackgroundRect.right = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    LoadingSwitchAnimationView loadingSwitchAnimationView2 = LoadingSwitchAnimationView.this;
                    RectF rectF2 = loadingSwitchAnimationView2.ovalBackgroundRect;
                    float f4 = loadingSwitchAnimationView2.rightIconRect.right;
                    float f5 = loadingSwitchAnimationView2.scaleWidth;
                    float f6 = (f4 - f5) - (this.currentFraction * ((f4 - f5) - loadingSwitchAnimationView2.leftIconRect.left));
                    rectF2.left = f6;
                    loadingSwitchAnimationView2.indexStart = f6;
                }
                LoadingSwitchAnimationView loadingSwitchAnimationView3 = LoadingSwitchAnimationView.this;
                float f7 = f;
                float f8 = this.currentFraction;
                loadingSwitchAnimationView3.distanceX = f7 - (f7 * f8);
                if (((double) f8) > 0.5d) {
                    RectF rectF3 = loadingSwitchAnimationView3.ovalBackgroundRect;
                    RectF rectF4 = loadingSwitchAnimationView3.leftIconRect;
                    float f9 = rectF4.top;
                    float f10 = loadingSwitchAnimationView3.originalHeight;
                    float f11 = loadingSwitchAnimationView3.scaleHeight;
                    rectF3.top = f9 + (((1.0f - ((f8 - 0.5f) * 2.0f)) * (f10 - f11)) / 2.0f);
                    rectF3.bottom = rectF4.bottom - (((1.0f - ((f8 - 0.5f) * 2.0f)) * (f10 - f11)) / 2.0f);
                }
                float f12 = loadingSwitchAnimationView3.ovalBackgroundRect.left;
                if (f12 < loadingSwitchAnimationView3.leftIconChangePosition) {
                    loadingSwitchAnimationView3.leftIconSelectedPaint.setAlpha((int) (255.0f - (((f12 - loadingSwitchAnimationView3.leftIconRect.left) * 255.0f) / loadingSwitchAnimationView3.leftIconChangeLength)));
                    LoadingSwitchAnimationView loadingSwitchAnimationView4 = LoadingSwitchAnimationView.this;
                    loadingSwitchAnimationView4.leftIconUnselectedPaint.setAlpha((int) (((loadingSwitchAnimationView4.ovalBackgroundRect.left - loadingSwitchAnimationView4.leftIconRect.left) * 255.0f) / loadingSwitchAnimationView4.leftIconChangeLength));
                }
                LoadingSwitchAnimationView loadingSwitchAnimationView5 = LoadingSwitchAnimationView.this;
                float f13 = loadingSwitchAnimationView5.ovalBackgroundRect.right;
                if (f13 > loadingSwitchAnimationView5.rightIconChangePosition) {
                    loadingSwitchAnimationView5.rightIconSelectedPaint.setAlpha((int) (255.0f - (((loadingSwitchAnimationView5.rightIconRect.right - f13) * 255.0f) / loadingSwitchAnimationView5.rightIconChangeLength)));
                    LoadingSwitchAnimationView loadingSwitchAnimationView6 = LoadingSwitchAnimationView.this;
                    loadingSwitchAnimationView6.rightIconUnselectedPaint.setAlpha((int) (((loadingSwitchAnimationView6.rightIconRect.right - loadingSwitchAnimationView6.ovalBackgroundRect.right) * 255.0f) / loadingSwitchAnimationView6.rightIconChangeLength));
                }
                LoadingSwitchAnimationView.this.invalidate();
            }
        });
        ofFloat.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
                if (z) {
                    LoadingSwitchAnimationView loadingSwitchAnimationView = LoadingSwitchAnimationView.this;
                    loadingSwitchAnimationView.indexStart = loadingSwitchAnimationView.ovalBackgroundRect.right;
                } else {
                    LoadingSwitchAnimationView loadingSwitchAnimationView2 = LoadingSwitchAnimationView.this;
                    loadingSwitchAnimationView2.indexStart = loadingSwitchAnimationView2.ovalBackgroundRect.left;
                }
                LoadingSwitchAnimationView loadingSwitchAnimationView3 = LoadingSwitchAnimationView.this;
                loadingSwitchAnimationView3.indexoffset *= -1.0f;
                loadingSwitchAnimationView3.isAnimating = false;
            }

            public void onAnimationEnd(Animator animator) {
                if (z) {
                    LoadingSwitchAnimationView loadingSwitchAnimationView = LoadingSwitchAnimationView.this;
                    loadingSwitchAnimationView.indexStart = loadingSwitchAnimationView.ovalBackgroundRect.left;
                } else {
                    LoadingSwitchAnimationView loadingSwitchAnimationView2 = LoadingSwitchAnimationView.this;
                    loadingSwitchAnimationView2.indexStart = loadingSwitchAnimationView2.ovalBackgroundRect.right;
                }
                LoadingSwitchAnimationView loadingSwitchAnimationView3 = LoadingSwitchAnimationView.this;
                loadingSwitchAnimationView3.indexoffset *= -1.0f;
                loadingSwitchAnimationView3.isAnimating = false;
                AnimationEndListener animationEndListener = loadingSwitchAnimationView3.animationEndListener;
                if (animationEndListener != null) {
                    animationEndListener.AnimationEnd();
                }
                LoadingSwitchAnimationView.this.offsetX = 0.0f;
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                LoadingSwitchAnimationView.this.isAnimating = true;
            }
        });
        ofFloat.start();
    }

    public int getCurrentSelection() {
        return this.ovalBackgroundRect.centerX() > this.viewWidth / 2.0f ? RIGHTPOSITION : LEFTSITION;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.offsetYValid) {
            drawWhenPull(canvas);
        } else {
            drawWhenLateralSliding(canvas);
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.viewWidth = (float) getWidth();
        this.viewHeight = (float) getHeight();
        float[] fArr = this.middleIconPosition;
        float f = this.viewWidth;
        fArr[0] = f / 2.0f;
        fArr[1] = 135.0f;
        int i5 = this.itemCount;
        if (i5 == 2) {
            this.distanceToMiddle = 144.0f;
            this.backgroundCurrentPosition = LEFTSITION;
        } else if (i5 == 3) {
            this.distanceToMiddle = 240.0f;
            this.backgroundCurrentPosition = MIDDLEPOSITION;
        }
        float[] fArr2 = this.leftIconPosition;
        float f2 = this.distanceToMiddle;
        fArr2[0] = (f / 2.0f) - f2;
        fArr2[1] = 135.0f;
        float[] fArr3 = this.rightIconPosition;
        float f3 = (f / 2.0f) + f2;
        fArr3[0] = f3;
        fArr3[1] = 135.0f;
        RectF rectF = this.middleIconRect;
        float f4 = fArr[0];
        float f5 = this.picRadius;
        rectF.left = f4 - f5;
        float f6 = fArr[1];
        rectF.top = f6 - f5;
        rectF.right = f4 + f5;
        rectF.bottom = f6 + f5;
        RectF rectF2 = this.leftIconRect;
        float f7 = fArr2[0];
        rectF2.left = f7 - f5;
        float f8 = fArr2[1];
        rectF2.top = f8 - f5;
        rectF2.right = f7 + f5;
        rectF2.bottom = f8 + f5;
        RectF rectF3 = this.rightIconRect;
        rectF3.left = f3 - f5;
        rectF3.top = 135.0f - f5;
        rectF3.right = f3 + f5;
        rectF3.bottom = 135.0f + f5;
        RectF rectF4 = this.ovalBackgroundRect;
        rectF4.left = rectF2.left;
        rectF4.top = rectF2.top;
        rectF4.right = rectF2.right;
        rectF4.bottom = rectF2.bottom;
        this.originalWidth = rectF4.width();
        this.originalHeight = this.ovalBackgroundRect.height();
        this.indexStart = this.ovalBackgroundRect.right;
        RectF rectF5 = this.leftIconRect;
        float f9 = rectF5.right;
        this.leftIconChangePosition = f9;
        this.leftIconChangeLength = f9 - rectF5.left;
        RectF rectF6 = this.rightIconRect;
        float f10 = rectF6.left;
        this.rightIconChangePosition = f10;
        float f11 = rectF6.right;
        this.rightIconChangePosition = f10;
        this.rightIconChangeLength = f11 - f10;
        RectF rectF7 = this.middleIconRect;
        float f12 = rectF7.left;
        this.middleIconChangePositionToLeft = f12;
        float f13 = rectF7.right;
        this.middleIconChangePositionToRight = f13;
        this.middleIconChangeLength = f13 - f12;
    }

    public void onPositionChange(float f, float f2) {
        if (this.offsetYValid) {
            if (f2 > 0.0f) {
                if (f2 <= 300.0f) {
                    this.distanceY = f2;
                    float f3 = f2 * 255.0f;
                    float f4 = f3 / 200.0f;
                    int i = 255;
                    this.pullLeftIconPaint.setAlpha(f4 > 255.0f ? 255 : (int) f4);
                    float f5 = f3 / 280.0f;
                    this.pullRightIconPaint.setAlpha(f5 > 255.0f ? 255 : (int) f5);
                    if (f2 > 240.0f) {
                        RectF rectF = this.ovalBackgroundRect;
                        float[] fArr = this.leftIconPosition;
                        float f6 = fArr[0];
                        float f7 = f2 - 240.0f;
                        float f8 = 1.125f * f7;
                        rectF.left = f6 - f8;
                        rectF.right = f6 + f8;
                        float f9 = fArr[1];
                        rectF.top = f9 - f8;
                        rectF.bottom = f9 + f8;
                        float f10 = (f7 * 255.0f) / 60.0f;
                        if (f10 <= 255.0f) {
                            i = (int) f10;
                        }
                        this.pullRefreshOnAndBackgroundPaint.setAlpha(i);
                    }
                } else {
                    RectF rectF2 = this.ovalBackgroundRect;
                    RectF rectF3 = this.leftIconRect;
                    rectF2.left = rectF3.left;
                    float f11 = rectF3.right;
                    rectF2.right = f11;
                    rectF2.top = rectF3.top;
                    rectF2.bottom = rectF3.bottom;
                    this.indexStart = f11;
                    this.offsetX = f;
                    this.offsetYValid = false;
                }
            }
            invalidate();
            return;
        }
        int i2 = this.itemCount;
        if (i2 == 2) {
            float f12 = this.offsetX;
            if (f - f12 > 0.0f) {
                RectF rectF4 = this.ovalBackgroundRect;
                float f13 = rectF4.left;
                RectF rectF5 = this.leftIconRect;
                if (f13 == rectF5.left) {
                    this.isBackgroundOnleft = true;
                    if (this.isAnimating) {
                        return;
                    }
                    if (f - f12 < 85.0f) {
                        this.distanceX = f - f12;
                        if (f - f12 > 20.0f) {
                            float f14 = (float) (((double) (f13 + this.originalWidth)) + (((double) ((f - f12) - 20.0f)) * 0.2d));
                            rectF4.right = f14;
                            rectF4.top = (float) (((double) rectF5.top) + (((double) ((f - f12) - 20.0f)) * 0.2d));
                            rectF4.bottom = (float) (((double) rectF5.bottom) - (((double) ((f - f12) - 20.0f)) * 0.2d));
                            this.indexStart = f14;
                        }
                        invalidate();
                        return;
                    }
                    this.scaleWidth = rectF4.width();
                    this.scaleHeight = this.ovalBackgroundRect.height();
                    startAnimate(true);
                    return;
                }
            }
            if (f < 0.0f) {
                RectF rectF6 = this.ovalBackgroundRect;
                float f15 = rectF6.right;
                RectF rectF7 = this.rightIconRect;
                if (f15 == rectF7.right) {
                    this.isBackgroundOnleft = false;
                    if (this.isAnimating) {
                        return;
                    }
                    if (f > -85.0f) {
                        this.distanceX = f;
                        if (f < -20.0f) {
                            double d = ((double) (f + 20.0f)) * 0.2d;
                            float f16 = (float) (((double) (f15 - this.originalWidth)) + d);
                            rectF6.left = f16;
                            rectF6.top = (float) (((double) rectF7.top) - d);
                            rectF6.bottom = (float) (((double) rectF7.bottom) + d);
                            this.indexStart = f16;
                        }
                        invalidate();
                        return;
                    }
                    this.scaleWidth = rectF6.width();
                    this.scaleHeight = this.ovalBackgroundRect.height();
                    startAnimate(false);
                }
            }
        } else if (i2 == 3) {
            float f17 = this.offsetX;
            if (f - f17 > 0.0f) {
                RectF rectF8 = this.ovalBackgroundRect;
                float f18 = rectF8.left;
                RectF rectF9 = this.middleIconRect;
                if (f18 == rectF9.left) {
                    if (this.isAnimating) {
                        return;
                    }
                    if (f - f17 < 85.0f) {
                        this.distanceX = f - f17;
                        if (f - f17 > 20.0f) {
                            float f19 = (float) (((double) (f18 + this.originalWidth)) + (((double) ((f - f17) - 20.0f)) * 0.2d));
                            rectF8.right = f19;
                            rectF8.top = (float) (((double) rectF9.top) + (((double) ((f - f17) - 20.0f)) * 0.2d));
                            rectF8.bottom = (float) (((double) rectF9.bottom) - (((double) ((f - f17) - 20.0f)) * 0.2d));
                            this.indexStart = f19;
                        }
                        invalidate();
                        return;
                    }
                    this.scaleWidth = rectF8.width();
                    this.scaleHeight = this.ovalBackgroundRect.height();
                    startAnimate(true);
                    return;
                }
            }
            if (f - f17 >= 0.0f || this.ovalBackgroundRect.right != this.middleIconRect.right) {
                if (f - f17 > 0.0f) {
                    RectF rectF10 = this.ovalBackgroundRect;
                    float f20 = rectF10.left;
                    RectF rectF11 = this.leftIconRect;
                    if (f20 == rectF11.left) {
                        this.isBackgroundOnleft = true;
                        if (this.isAnimating) {
                            return;
                        }
                        if (f - f17 < 85.0f) {
                            this.distanceX = f - f17;
                            if (f - f17 > 20.0f) {
                                float f21 = (float) (((double) (f20 + this.originalWidth)) + (((double) ((f - f17) - 20.0f)) * 0.2d));
                                rectF10.right = f21;
                                rectF10.top = (float) (((double) rectF11.top) + (((double) ((f - f17) - 20.0f)) * 0.2d));
                                rectF10.bottom = (float) (((double) rectF11.bottom) - (((double) ((f - f17) - 20.0f)) * 0.2d));
                                this.indexStart = f21;
                            }
                            invalidate();
                            return;
                        }
                        this.scaleWidth = rectF10.width();
                        this.scaleHeight = this.ovalBackgroundRect.height();
                        startAnimate(true);
                        return;
                    }
                }
                if (f < 0.0f) {
                    RectF rectF12 = this.ovalBackgroundRect;
                    float f22 = rectF12.right;
                    RectF rectF13 = this.rightIconRect;
                    if (f22 == rectF13.right) {
                        this.isBackgroundOnleft = false;
                        if (this.isAnimating) {
                            return;
                        }
                        if (f > -85.0f) {
                            this.distanceX = f;
                            if (f < -20.0f) {
                                double d2 = ((double) (f + 20.0f)) * 0.2d;
                                float f23 = (float) (((double) (f22 - this.originalWidth)) + d2);
                                rectF12.left = f23;
                                rectF12.top = (float) (((double) rectF13.top) - d2);
                                rectF12.bottom = (float) (((double) rectF13.bottom) + d2);
                                this.indexStart = f23;
                            }
                            invalidate();
                            return;
                        }
                        this.scaleWidth = rectF12.width();
                        this.scaleHeight = this.ovalBackgroundRect.height();
                        startAnimate(false);
                    }
                }
            }
        }
    }

    public void reset() {
        this.rightIconUnselectedPaint.setAlpha(255);
        this.rightIconSelectedPaint.setAlpha(0);
        this.leftIconUnselectedPaint.setAlpha(0);
        this.leftIconSelectedPaint.setAlpha(255);
        this.pullRefreshOnAndBackgroundPaint.setAlpha(0);
        this.pullLeftIconPaint.setAlpha(0);
        this.pullRightIconPaint.setAlpha(0);
        RectF rectF = this.ovalBackgroundRect;
        RectF rectF2 = this.leftIconRect;
        rectF.left = rectF2.left;
        float f = rectF2.right;
        rectF.right = f;
        rectF.top = rectF2.top;
        rectF.bottom = rectF2.bottom;
        this.indexStart = f;
        this.distanceX = 0.0f;
        this.distanceY = 0.0f;
        this.offsetYValid = true;
        invalidate();
    }

    public void setAnimateDuration(int i) {
        this.animateDuration = i;
    }

    public void setAnimationEndListener(AnimationEndListener animationEndListener2) {
        this.animationEndListener = animationEndListener2;
    }

    public void setLeftIconSelected(Bitmap bitmap) {
        this.leftIconSelected = bitmap;
    }

    public void setLeftIconUnSelected(Bitmap bitmap) {
        this.leftIconUnselected = bitmap;
    }

    public void setRightIconSelected(Bitmap bitmap) {
        this.rightIconSelected = bitmap;
    }

    public void setRightIconUnSelected(Bitmap bitmap) {
        this.rightIconUnselected = bitmap;
    }

    public void setSelectedIconBackGroundColor(int i) {
        this.lateralSlidingBackgroundPaint.setColor(i);
        this.pullRefreshOnAndBackgroundPaint.setColor(i);
        this.pullRefreshOnAndBackgroundPaint.setAlpha(0);
    }

    public void touchDown() {
        this.offsetYValid = true;
    }

    public LoadingSwitchAnimationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadingSwitchAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.DEFALTDURATION = 300;
        this.DEFALTITEMCOUNT = 2;
        this.distanceX = 0.0f;
        this.distanceY = 0.0f;
        this.isAnimating = false;
        this.isBackgroundOnleft = true;
        this.offsetYValid = true;
        this.offsetX = 0.0f;
        this.rotationangle = 180.0f;
        this.indexoffset = 10.0f;
        this.picRadius = 67.5f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LoadingSwitchAnimationView);
        this.animateDuration = obtainStyledAttributes.getInteger(R.styleable.LoadingSwitchAnimationView_animateDuration, this.DEFALTDURATION);
        this.itemCount = obtainStyledAttributes.getInteger(R.styleable.LoadingSwitchAnimationView_itemCount, this.DEFALTITEMCOUNT);
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.lateralSlidingBackgroundPaint = paint;
        paint.setColor(getResources().getColor(R.color.background_color));
        this.lateralSlidingBackgroundPaint.setAntiAlias(true);
        Paint paint2 = this.lateralSlidingBackgroundPaint;
        Paint.Style style = Paint.Style.FILL;
        paint2.setStyle(style);
        this.leftIconSelected = BitmapFactory.decodeResource(getResources(), R.drawable.reflesh_on);
        this.leftIconUnselected = BitmapFactory.decodeResource(getResources(), R.drawable.reflesh_off);
        this.rightIconSelected = BitmapFactory.decodeResource(getResources(), R.drawable.back_home_on);
        this.rightIconUnselected = BitmapFactory.decodeResource(getResources(), R.drawable.back_home_off);
        this.backgroundPath = new Path();
        this.ovalBackgroundRect = new RectF();
        this.leftIconRect = new RectF();
        this.rightIconRect = new RectF();
        this.middleIconRect = new RectF();
        this.index1 = new float[2];
        this.index2 = new float[2];
        this.leftIconPosition = new float[2];
        this.rightIconPosition = new float[2];
        this.middleIconPosition = new float[2];
        Paint paint3 = new Paint();
        this.rightIconUnselectedPaint = paint3;
        paint3.setAlpha(255);
        Paint paint4 = new Paint();
        this.rightIconSelectedPaint = paint4;
        paint4.setAlpha(0);
        Paint paint5 = new Paint();
        this.leftIconUnselectedPaint = paint5;
        paint5.setAlpha(0);
        Paint paint6 = new Paint();
        this.leftIconSelectedPaint = paint6;
        paint6.setAlpha(255);
        Paint paint7 = new Paint();
        this.pullRefreshOnAndBackgroundPaint = paint7;
        paint7.setColor(getResources().getColor(R.color.background_color));
        this.pullRefreshOnAndBackgroundPaint.setAntiAlias(true);
        this.pullRefreshOnAndBackgroundPaint.setStyle(style);
        this.pullRefreshOnAndBackgroundPaint.setAlpha(0);
        Paint paint8 = new Paint();
        this.pullLeftIconPaint = paint8;
        paint8.setAlpha(0);
        Paint paint9 = new Paint();
        this.pullRightIconPaint = paint9;
        paint9.setAlpha(0);
    }
}
