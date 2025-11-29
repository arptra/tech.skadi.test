package flyme.support.v7.drawable;

import android.animation.ValueAnimator;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import com.meizu.common.app.SlideNotice;
import flyme.support.v7.appcompat.R;
import java.lang.ref.WeakReference;

public class RippleDrawableComp extends Drawable {
    private static final Interpolator RIPPLE_IN_INTERPOLATOR = createInInterpolator();
    private static final Interpolator RIPPLE_OUT_INTERPOLATOR = createOutInterpolator();
    /* access modifiers changed from: private */
    public int mAlpha;
    private int mAlphaBg;
    private ValueAnimator mAnimation;
    private int mColor;
    private int mColorBg;
    private Drawable mDrawable;
    private int mHeight;
    private int mInDuration;
    /* access modifiers changed from: private */
    public boolean mIsDown;
    private boolean mIsHaveBg;
    /* access modifiers changed from: private */
    public boolean mIsRipple;
    /* access modifiers changed from: private */
    public boolean mIsRippleFade;
    /* access modifiers changed from: private */
    public boolean mIsShrink;
    /* access modifiers changed from: private */
    public boolean mIsUseFadeOut;
    /* access modifiers changed from: private */
    public int mMaxRadius;
    private int mOutDuration;
    /* access modifiers changed from: private */
    public Paint mPaint;
    /* access modifiers changed from: private */
    public Paint mPaintBg;
    /* access modifiers changed from: private */
    public int mRadius;
    /* access modifiers changed from: private */
    public int mStartRadius;
    private WeakReference<View> mView;
    private int mWidth;

    public RippleDrawableComp(View view) {
        this(view, R.attr.mzRippleDefaultStyle);
    }

    private void cancelAnimation() {
        ValueAnimator valueAnimator = this.mAnimation;
        if (valueAnimator == null) {
            return;
        }
        if (valueAnimator.isStarted() || this.mAnimation.isRunning()) {
            this.mAnimation.cancel();
        }
    }

    private void compatVivo() {
        if (Build.MODEL.equals("vivo X3t")) {
            int i = this.mMaxRadius;
            int i2 = this.mWidth;
            int i3 = this.mHeight;
            setBounds(-((i2 / 2) + i), -((i3 / 2) + i), (i2 / 2) + i, i + (i3 / 2));
        }
    }

    private static Interpolator createInInterpolator() {
        return new PathInterpolator(0.0f, 0.0f, 0.1f, 1.0f);
    }

    private static Interpolator createOutInterpolator() {
        return new PathInterpolator(0.66f, 0.0f, 0.67f, 1.0f);
    }

    /* access modifiers changed from: private */
    public void initValue() {
        View view = this.mView.get();
        if (view != null) {
            this.mWidth = view.getWidth();
            this.mHeight = view.getHeight();
            setBounds(new Rect(0, 0, this.mWidth, this.mHeight));
            if (this.mMaxRadius <= 0) {
                this.mMaxRadius = ((int) Math.hypot((double) this.mWidth, (double) this.mHeight)) / 2;
            }
            if (this.mStartRadius < 0) {
                this.mStartRadius = (int) (((float) this.mMaxRadius) * 0.825f);
            }
        }
    }

    public void draw(Canvas canvas) {
        compatVivo();
        Drawable drawable = this.mDrawable;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        if (this.mIsRipple || this.mIsDown) {
            if (this.mIsHaveBg) {
                canvas.drawCircle((float) (this.mWidth / 2), (float) (this.mHeight / 2), (float) this.mMaxRadius, this.mPaintBg);
            }
            canvas.drawCircle((float) (this.mWidth / 2), (float) (this.mHeight / 2), (float) this.mRadius, this.mPaint);
        }
    }

    public int getOpacity() {
        return this.mAlpha;
    }

    public void init() {
        WeakReference<View> weakReference = this.mView;
        if (weakReference != null) {
            weakReference.get().setClickable(true);
            this.mView.get().addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    RippleDrawableComp.this.initValue();
                }
            });
            this.mView.get().post(new Runnable() {
                public void run() {
                    RippleDrawableComp.this.initValue();
                }
            });
        }
    }

    public boolean isStateful() {
        return true;
    }

    public boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        boolean z = false;
        boolean z2 = false;
        for (int i : iArr) {
            if (i == 16842910) {
                z = true;
            }
            if (i == 16842919) {
                z2 = true;
            }
        }
        if (z && z2) {
            this.mIsDown = true;
            ripple();
        } else if (this.mIsDown) {
            this.mIsDown = false;
            invalidateSelf();
            if (!this.mIsRipple && this.mIsRippleFade) {
                rippleFade();
            }
        }
        return onStateChange;
    }

    public void ripple() {
        cancelAnimation();
        this.mPaint.setAlpha(this.mAlpha);
        this.mPaintBg.setAlpha(this.mAlpha / 2);
        this.mIsRipple = true;
        int i = this.mStartRadius;
        this.mRadius = i;
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, this.mMaxRadius});
        this.mAnimation = ofInt;
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                int unused = RippleDrawableComp.this.mRadius = intValue;
                if (RippleDrawableComp.this.mMaxRadius <= intValue) {
                    boolean unused2 = RippleDrawableComp.this.mIsRipple = false;
                    if (!RippleDrawableComp.this.mIsDown && RippleDrawableComp.this.mIsRippleFade) {
                        RippleDrawableComp.this.rippleFade();
                    }
                }
                RippleDrawableComp.this.invalidateSelf();
            }
        });
        this.mAnimation.setDuration((long) this.mInDuration);
        this.mAnimation.setInterpolator(RIPPLE_IN_INTERPOLATOR);
        this.mAnimation.start();
    }

    public void rippleFade() {
        cancelAnimation();
        this.mPaint.setAlpha(this.mAlpha);
        this.mIsRipple = true;
        int i = this.mMaxRadius;
        this.mRadius = i;
        int i2 = this.mStartRadius;
        final float f = ((float) i2) / ((float) i);
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
        this.mAnimation = ofInt;
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (RippleDrawableComp.this.mIsShrink) {
                    int unused = RippleDrawableComp.this.mRadius = intValue;
                }
                if (RippleDrawableComp.this.mStartRadius >= intValue) {
                    boolean unused2 = RippleDrawableComp.this.mIsRipple = false;
                }
                if (RippleDrawableComp.this.mIsUseFadeOut) {
                    float access$200 = ((float) intValue) / ((float) RippleDrawableComp.this.mMaxRadius);
                    float f = f;
                    int access$900 = (int) (((float) RippleDrawableComp.this.mAlpha) * ((access$200 - f) / (1.0f - f)));
                    RippleDrawableComp.this.mPaint.setAlpha(access$900);
                    RippleDrawableComp.this.mPaintBg.setAlpha(access$900 / 2);
                }
                RippleDrawableComp.this.invalidateSelf();
            }
        });
        this.mAnimation.setDuration((long) this.mOutDuration);
        this.mAnimation.setInterpolator(RIPPLE_OUT_INTERPOLATOR);
        this.mAnimation.start();
    }

    public void setAlpha(int i) {
        this.mAlpha = i;
        this.mPaint.setAlpha(i);
    }

    public void setAlphaBg(int i) {
        this.mAlphaBg = i;
        this.mPaintBg.setAlpha(i);
    }

    public void setBounds(Rect rect) {
        Drawable drawable = this.mDrawable;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    public void setColor(int i) {
        this.mColor = i;
        this.mPaint.setColor(i);
    }

    public void setColorBg(int i) {
        this.mColorBg = i;
        this.mPaintBg.setColor(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    public void setDrawable(Drawable drawable) {
        this.mDrawable = drawable;
    }

    public void setInDuration(int i) {
        this.mInDuration = i;
    }

    public void setIsHaveBg(boolean z) {
        this.mIsHaveBg = z;
    }

    public void setIsRippleFade(boolean z) {
        this.mIsRippleFade = z;
    }

    public void setIsShrink(boolean z) {
        this.mIsShrink = z;
    }

    public void setIsUseFadeOut(boolean z) {
        this.mIsUseFadeOut = z;
    }

    public void setMaxRadius(int i) {
        this.mMaxRadius = i;
    }

    public void setOutDuration(int i) {
        this.mOutDuration = i;
    }

    public void setStartRadius(int i) {
        this.mStartRadius = i;
    }

    public RippleDrawableComp(View view, int i) {
        this.mColorBg = -16777216;
        this.mAlphaBg = 75;
        this.mColor = -16777216;
        this.mMaxRadius = 0;
        this.mInDuration = 0;
        this.mOutDuration = 0;
        this.mIsDown = false;
        if (view != null) {
            TypedArray obtainStyledAttributes = view.getContext().obtainStyledAttributes((AttributeSet) null, R.styleable.MzRippleDrawableComp, i, 0);
            int color = obtainStyledAttributes.getColor(R.styleable.MzRippleDrawableComp_mzRippleColor, -16777216);
            this.mColor = color;
            this.mAlpha = Color.alpha(color);
            this.mStartRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MzRippleDrawableComp_mzStartRadius, -1);
            this.mMaxRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MzRippleDrawableComp_mzMaxRadius, 0);
            this.mIsUseFadeOut = obtainStyledAttributes.getBoolean(R.styleable.MzRippleDrawableComp_mzUseFadeOut, false);
            this.mIsHaveBg = obtainStyledAttributes.getBoolean(R.styleable.MzRippleDrawableComp_mzAutoLightBackground, true);
            this.mIsRippleFade = obtainStyledAttributes.getBoolean(R.styleable.MzRippleDrawableComp_mzRippleFade, true);
            this.mInDuration = obtainStyledAttributes.getInt(R.styleable.MzRippleDrawableComp_mzInDuration, 160);
            this.mOutDuration = obtainStyledAttributes.getInt(R.styleable.MzRippleDrawableComp_mzOutDuration, SlideNotice.SHOW_ANIMATION_DURATION);
            this.mIsShrink = obtainStyledAttributes.getBoolean(R.styleable.MzRippleDrawableComp_mzShrink, true);
            obtainStyledAttributes.recycle();
            Paint paint = new Paint();
            this.mPaint = paint;
            paint.setColor(this.mColor);
            this.mPaint.setAlpha(this.mAlpha);
            this.mPaint.setAntiAlias(true);
            Paint paint2 = new Paint();
            this.mPaintBg = paint2;
            paint2.setColor(this.mColor);
            this.mPaintBg.setAlpha(this.mAlpha / 2);
            this.mPaintBg.setAntiAlias(true);
            this.mView = new WeakReference<>(view);
            this.mRadius = this.mStartRadius;
            init();
            return;
        }
        throw new IllegalArgumentException("you must use a view to create a RippleDrawableComp");
    }
}
