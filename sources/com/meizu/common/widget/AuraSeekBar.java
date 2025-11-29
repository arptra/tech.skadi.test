package com.meizu.common.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.meizu.common.R;

public class AuraSeekBar extends SkipPosSeekBar {
    private static final float AURA_SCALE_BASELINE = 1.0f;
    private static final float AURA_SCALE_TARGET = 0.5f;
    private static final String TAG = "AuraSeekBar";
    private static final int THUMB_HIDE_ANIM_TIME = 200;
    private static final float THUMB_SCALE_BASELINE = 1.0f;
    private static final float THUMB_SCALE_TARGET = 0.7f;
    private static final int THUMB_SHOW_ANIM_TIME = 180;
    private static final int mMaxHeight = 78;
    private static final int mMinHeight = 20;
    private boolean isAuraShow;
    /* access modifiers changed from: private */
    public boolean isDrag;
    /* access modifiers changed from: private */
    public int mAuraBorderDistance;
    private Drawable mAuraDrawble;
    /* access modifiers changed from: private */
    public int mAuraHeight;
    private ValueAnimator mAuraHideAnimator;
    private Interpolator mAuraHideInterpolator;
    /* access modifiers changed from: private */
    public int mAuraRadius;
    private ValueAnimator mAuraShowAnimator;
    private Interpolator mAuraShowInterpolator;
    private int mAuraWidth;
    private float mInitialTouchX;
    private int mScaledTouchSlop;
    private ThumbDrawableWrapper mThumbDrawableWrapper;
    private ValueAnimator mThumbRecoverAnimator;
    private Interpolator mThumbRecoverInterpolator;
    /* access modifiers changed from: private */
    public float mThumbScaleValue;
    private ValueAnimator mThumbShrinkAnimator;
    private Interpolator mThumbShrinkInterpolator;

    public static class ThumbDrawableWrapper extends DrawableWrapper {
        private float scale = 1.0f;

        public ThumbDrawableWrapper(@Nullable Drawable drawable) {
            super(drawable);
        }

        public void draw(@NonNull Canvas canvas) {
            canvas.save();
            float f = this.scale;
            canvas.scale(f, f, (float) getBounds().centerX(), (float) getBounds().centerY());
            super.draw(canvas);
            canvas.restore();
        }

        public void scale(float f) {
            this.scale = f;
        }
    }

    public AuraSeekBar(Context context) {
        this(context, (AttributeSet) null);
    }

    private void init() {
        this.mAuraShowInterpolator = new PathInterpolator(0.2f, 0.43f, 0.2f, 1.0f);
        this.mAuraHideInterpolator = new PathInterpolator(0.17f, 0.0f, 0.2f, 1.0f);
        this.mThumbShrinkInterpolator = new PathInterpolator(0.2f, 0.43f, 0.2f, 1.0f);
        this.mThumbRecoverInterpolator = new PathInterpolator(0.17f, 0.0f, 0.2f, 1.0f);
    }

    private void onProgressChanged() {
        this.isDrag = true;
    }

    private void onStopTrackTouch() {
        this.isAuraShow = false;
    }

    private void startAuraHideAnim() {
        if (this.mAuraHideAnimator == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.5f});
            this.mAuraHideAnimator = ofFloat;
            ofFloat.setDuration(200);
            this.mAuraHideAnimator.setInterpolator(this.mAuraHideInterpolator);
            this.mAuraHideAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    AuraSeekBar auraSeekBar = AuraSeekBar.this;
                    int unused = auraSeekBar.mAuraRadius = (int) (((float) (auraSeekBar.mAuraHeight / 2)) * floatValue);
                    AuraSeekBar auraSeekBar2 = AuraSeekBar.this;
                    int unused2 = auraSeekBar2.mAuraBorderDistance = (int) ((((float) auraSeekBar2.mAuraHeight) / 2.0f) * (1.0f - floatValue));
                    Log.d(AuraSeekBar.TAG, "hide mAuraRadius:" + AuraSeekBar.this.mAuraRadius);
                    AuraSeekBar.this.invalidate();
                }
            });
            this.mAuraHideAnimator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    boolean unused = AuraSeekBar.this.isDrag = false;
                }
            });
        }
        this.mAuraHideAnimator.start();
        if (this.mThumbRecoverAnimator == null) {
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{THUMB_SCALE_TARGET, 1.0f});
            this.mThumbRecoverAnimator = ofFloat2;
            ofFloat2.setDuration(200);
            this.mThumbRecoverAnimator.setInterpolator(this.mThumbRecoverInterpolator);
            this.mThumbRecoverAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float unused = AuraSeekBar.this.mThumbScaleValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    AuraSeekBar.this.invalidate();
                }
            });
            this.mThumbRecoverAnimator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                }
            });
        }
        this.mThumbRecoverAnimator.start();
    }

    private void startAuraShowAnim() {
        this.isAuraShow = true;
        if (this.mAuraShowAnimator == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.5f, 1.0f});
            this.mAuraShowAnimator = ofFloat;
            ofFloat.setDuration(180);
            this.mAuraShowAnimator.setInterpolator(this.mAuraShowInterpolator);
            this.mAuraShowAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    AuraSeekBar auraSeekBar = AuraSeekBar.this;
                    int unused = auraSeekBar.mAuraRadius = (int) (((float) (auraSeekBar.mAuraHeight / 2)) * floatValue);
                    AuraSeekBar auraSeekBar2 = AuraSeekBar.this;
                    int unused2 = auraSeekBar2.mAuraBorderDistance = (int) ((((float) auraSeekBar2.mAuraHeight) / 2.0f) * (1.0f - floatValue));
                    Log.d(AuraSeekBar.TAG, "show mAuraBorderDistance:" + AuraSeekBar.this.mAuraBorderDistance);
                    Log.d(AuraSeekBar.TAG, "show mAuraRadius:" + AuraSeekBar.this.mAuraRadius);
                    AuraSeekBar.this.invalidate();
                }
            });
        }
        this.mAuraShowAnimator.start();
        if (this.mThumbShrinkAnimator == null) {
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{1.0f, THUMB_SCALE_TARGET});
            this.mThumbShrinkAnimator = ofFloat2;
            ofFloat2.setDuration(180);
            this.mThumbShrinkAnimator.setInterpolator(this.mThumbShrinkInterpolator);
            this.mThumbShrinkAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float unused = AuraSeekBar.this.mThumbScaleValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    AuraSeekBar.this.invalidate();
                }
            });
        }
        this.mThumbShrinkAnimator.start();
    }

    private void stopAuraHideAnim() {
        ValueAnimator valueAnimator = this.mAuraHideAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mAuraHideAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.mThumbRecoverAnimator;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.mThumbRecoverAnimator.cancel();
        }
    }

    private void stopAuraShowAnim() {
        ValueAnimator valueAnimator = this.mAuraShowAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mAuraShowAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.mThumbShrinkAnimator;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.mThumbShrinkAnimator.cancel();
        }
    }

    @TargetApi(16)
    public synchronized void onDraw(Canvas canvas) {
        try {
            if (this.isDrag && getThumb() != null) {
                Drawable thumb = getThumb();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                Rect bounds = thumb.getBounds();
                int i = this.mAuraHeight;
                int i2 = height > i ? ((height - i) / 2) - bounds.top : 0;
                canvas.save();
                canvas.translate((float) (getPaddingLeft() - (getThumb().getIntrinsicWidth() / 2)), (float) (getPaddingTop() + i2));
                canvas.restore();
            }
            this.mThumbDrawableWrapper.scale(this.mThumbScaleValue);
            super.onDraw(canvas);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(AuraSeekBar.class.getName());
    }

    public synchronized void onMeasure(int i, int i2) {
        int i3;
        int i4;
        try {
            Drawable progressDrawable = getProgressDrawable();
            Drawable drawable = this.mAuraDrawble;
            if (drawable != null) {
                this.mAuraHeight = drawable.getIntrinsicHeight();
                this.mAuraWidth = this.mAuraDrawble.getIntrinsicWidth();
            } else {
                this.mAuraHeight = 0;
                this.mAuraWidth = 0;
            }
            if (progressDrawable != null) {
                i3 = View.MeasureSpec.getSize(i);
                i4 = Math.max(this.mAuraHeight, Math.max(20, Math.min(78, progressDrawable.getIntrinsicHeight())));
            } else {
                i4 = 0;
                i3 = 0;
            }
            setMeasuredDimension(View.resolveSizeAndState(i3 + getPaddingLeft() + getPaddingRight(), i, 0), View.resolveSizeAndState(i4 + getPaddingTop() + getPaddingBottom(), i2, 0));
        } catch (Throwable th) {
            throw th;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        if (!isEnabled()) {
            return false;
        }
        float x = motionEvent.getX();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mInitialTouchX = x;
            this.isDrag = false;
        } else if (action != 1) {
            if (action != 2) {
                if (action == 3 && this.isDrag) {
                    onStopTrackTouch();
                }
            } else if (Math.abs(motionEvent.getX() - this.mInitialTouchX) > ((float) this.mScaledTouchSlop)) {
                this.isDrag = true;
                onProgressChanged();
            }
        } else if (this.isDrag) {
            onStopTrackTouch();
        }
        return true;
    }

    public void setThumb(Drawable drawable) {
        ThumbDrawableWrapper thumbDrawableWrapper = new ThumbDrawableWrapper(drawable);
        this.mThumbDrawableWrapper = thumbDrawableWrapper;
        super.setThumb(thumbDrawableWrapper);
    }

    public AuraSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.MeizuCommon_AuraSeekBarStyle);
    }

    public AuraSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isDrag = false;
        this.mAuraBorderDistance = 0;
        this.isAuraShow = false;
        this.mThumbScaleValue = 1.0f;
        this.mScaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AuraSeekBar, i, 0);
        this.mAuraDrawble = obtainStyledAttributes.getDrawable(R.styleable.AuraSeekBar_mcAuraThumbDrawble);
        obtainStyledAttributes.recycle();
    }
}
