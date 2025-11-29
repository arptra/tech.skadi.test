package com.meizu.common.animator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatValueHolder;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RoundedCornerTreatment;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.honey.account.r2.c;
import com.meizu.common.R;
import com.meizu.common.util.ReflectUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class MzPressAnimationDrawable extends StateListDrawable {
    private static final float DAMPING = 0.9f;
    private static final long DEFAULT_ALPHA_ANIM_NO_SCALE_DURATION = 200;
    private static final long DEFAULT_ALPHA_ANIM_TO_NORMAL_DURATION = 300;
    private static final long DEFAULT_ALPHA_ANIM_TO_PRESS_DURATION = 100;
    private static final float DEFAULT_ALPHA_FROM = 0.0f;
    private static final float DEFAULT_ALPHA_TO = 0.03f;
    private static final float DEFAULT_BOUND_SCALE_FROM = 1.0f;
    private static final float DEFAULT_BOUND_SCALE_TO = 1.0f;
    private static final int DEFAULT_CORNER_SIZE = 0;
    private static final int DEFAULT_DRAW_OFFSET = 0;
    private static final boolean DEFAULT_NOT_FULL_STYLE_USE_SQUARE = false;
    private static final boolean DEFAULT_USE_FULL_STYLE = true;
    private static final int DIVIDER_HEIGHT_RANGE = 2;
    private static final int DIVIDER_WIDTH_RANGE = 2;
    private static final long FADE_IN_DURATION = 350;
    private static final long FADE_OUT_DURATION = 500;
    private static final int OPAQUE = 255;
    private static final float SPRING_ANIMATION_FLOAT_TO_INT_PROP = 100.0f;
    private static final long STAY_DURATION = 350;
    private static final float STIFFNESS = 250.0f;
    private static final String TAG = "MzPressDrawable";

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f9492a = 0;
    private static final Interpolator sAlphaCubic = PathInterpolatorCompat.a(0.4f, DEFAULT_ALPHA_FROM, 0.58f, 1.0f);
    private static final Interpolator sFadeInterpolator = PathInterpolatorCompat.a(0.33f, DEFAULT_ALPHA_FROM, 0.67f, 1.0f);
    private ValueAnimator mAlphaAnimToNormal;
    private ValueAnimator mAlphaAnimToPress;
    private float mAlphaFrom = DEFAULT_ALPHA_FROM;
    /* access modifiers changed from: private */
    public int mAlphaProgress;
    private float mAlphaTo = DEFAULT_ALPHA_TO;
    private int mBottomPadding;
    private float mBoundScaleFrom = 1.0f;
    private float mBoundScaleTo = 1.0f;
    private boolean mCanReflect = true;
    private int mDrawOffsetX = 0;
    private int mDrawOffsetY = 0;
    private int mEndPadding;
    private AnimatorSet mFadeAnimSet;
    /* access modifiers changed from: private */
    public boolean mHandleQuickClick;
    private boolean mInit;
    private boolean mNotFullStyleUseSquare = false;
    private int mRadius = 0;
    /* access modifiers changed from: private */
    public float mScaleProgress;
    private SpringAnimation mScaleSpringAnimation;
    private MaterialShapeDrawable mShapeDrawable;
    private Rect mShapeDrawableBound = new Rect();
    protected int mShapeDrawableHeight;
    protected int mShapeDrawableWidth;
    private int mStartPadding;
    private int mStickyHeight;
    private int mStickyWidth;
    private int mTint = -16777216;
    private int mTopPadding;
    private boolean mUseFullStyle = true;

    public class FadeAnimUpdateListener implements ValueAnimator.AnimatorUpdateListener {
        private FadeAnimUpdateListener() {
        }

        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue instanceof Float) {
                int unused = MzPressAnimationDrawable.this.mAlphaProgress = (int) (((Float) animatedValue).floatValue() * 255.0f);
                MzPressAnimationDrawable.this.invalidateSelf();
            }
        }
    }

    public static class FadeListener implements Animator.AnimatorListener {
        public void onAnimationCancel(@NonNull Animator animator) {
        }

        public void onAnimationEnd(@NonNull Animator animator) {
        }

        public void onAnimationRepeat(@NonNull Animator animator) {
        }

        public void onAnimationStart(@NonNull Animator animator) {
        }
    }

    public static class TmpStateDrawable extends Drawable {
        public void draw(@NonNull Canvas canvas) {
        }

        public int getOpacity() {
            return -1;
        }

        public void inflate(@NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws IOException, XmlPullParserException {
            super.inflate(resources, xmlPullParser, attributeSet, theme);
        }

        public void setAlpha(int i) {
        }

        public void setColorFilter(@Nullable ColorFilter colorFilter) {
        }
    }

    public MzPressAnimationDrawable() {
        addState(new int[]{16842919}, new TmpStateDrawable());
        addState(new int[0], new TmpStateDrawable());
        try {
            Canvas canvas = new Canvas();
            ReflectUtils.from((Object) canvas).method("setNightModeUseOf", Integer.TYPE).invoke(canvas, 2);
        } catch (Exception e) {
            Log.e(TAG, "setNightModeUseOf error " + e);
            this.mCanReflect = false;
        }
    }

    private void init() {
        initShapeDrawable();
        initScaleSpringAnimation();
        initToPressAnim();
        initToNormalAnim();
        this.mInit = true;
    }

    private void initScaleSpringAnimation() {
        SpringAnimation y = new SpringAnimation(new FloatValueHolder()).y(new SpringForce().d(DAMPING).f(STIFFNESS));
        this.mScaleSpringAnimation = y;
        y.n(this.mBoundScaleFrom * SPRING_ANIMATION_FLOAT_TO_INT_PROP);
        this.mScaleProgress = this.mBoundScaleFrom;
        this.mScaleSpringAnimation.v().e(this.mBoundScaleTo * SPRING_ANIMATION_FLOAT_TO_INT_PROP);
        this.mScaleSpringAnimation.c(new DynamicAnimation.OnAnimationUpdateListener() {
            public void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f2) {
                float unused = MzPressAnimationDrawable.this.mScaleProgress = f / MzPressAnimationDrawable.SPRING_ANIMATION_FLOAT_TO_INT_PROP;
                MzPressAnimationDrawable.this.invalidateSelf();
            }
        });
    }

    private void initShapeDrawable() {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(ShapeAppearanceModel.builder().setAllCorners(new RoundedCornerTreatment()).setAllCornerSizes((float) DEFAULT_ALPHA_FROM).build());
        this.mShapeDrawable = materialShapeDrawable;
        materialShapeDrawable.setTint(this.mTint);
        this.mShapeDrawable.setCornerSize((float) this.mRadius);
        this.mShapeDrawable.setAlpha((int) (this.mAlphaFrom * 255.0f));
    }

    private void initToNormalAnim() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.mAlphaTo, this.mAlphaFrom});
        this.mAlphaAnimToNormal = ofFloat;
        ofFloat.setInterpolator(sAlphaCubic);
        this.mAlphaAnimToNormal.setDuration(isBoundScale() ? DEFAULT_ALPHA_ANIM_TO_NORMAL_DURATION : 200);
        this.mAlphaAnimToNormal.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                int unused = MzPressAnimationDrawable.this.mAlphaProgress = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
                MzPressAnimationDrawable.this.invalidateSelf();
            }
        });
    }

    private void initToPressAnim() {
        float f = isBoundScale() ? SPRING_ANIMATION_FLOAT_TO_INT_PROP : 200.0f;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.mAlphaFrom, this.mAlphaTo});
        this.mAlphaAnimToPress = ofFloat;
        ofFloat.setInterpolator(sAlphaCubic);
        this.mAlphaAnimToPress.setDuration((long) f);
        this.mAlphaAnimToPress.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                int unused = MzPressAnimationDrawable.this.mAlphaProgress = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
                MzPressAnimationDrawable.this.invalidateSelf();
            }
        });
        this.mAlphaAnimToPress.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (MzPressAnimationDrawable.this.mHandleQuickClick) {
                    boolean unused = MzPressAnimationDrawable.this.mHandleQuickClick = false;
                    MzPressAnimationDrawable.this.toNormal();
                }
            }
        });
    }

    private boolean isBoundScale() {
        return Float.compare(this.mBoundScaleTo, 1.0f) != 0;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$startAnimationOnMainThread$0(SpringAnimation springAnimation) {
        if (springAnimation != null) {
            springAnimation.q();
        }
    }

    private void setBoundScaleFrom(@FloatRange float f) {
        this.mBoundScaleFrom = f;
    }

    private void startAnimationOnMainThread(SpringAnimation springAnimation) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            Log.w(TAG, "Your looper is not on MainLooper, force run on MainLooper now, and trace:" + Log.getStackTraceString(new Throwable()));
            new Handler(Looper.getMainLooper()).post(new c(springAnimation));
            return;
        }
        springAnimation.q();
    }

    /* access modifiers changed from: private */
    public void toNormal() {
        this.mAlphaAnimToNormal.setFloatValues(new float[]{((float) this.mAlphaProgress) / 255.0f, this.mAlphaFrom});
        if (!this.mAlphaAnimToPress.isRunning()) {
            this.mAlphaAnimToNormal.start();
        } else {
            this.mHandleQuickClick = true;
        }
        this.mScaleSpringAnimation.n(this.mScaleProgress * SPRING_ANIMATION_FLOAT_TO_INT_PROP);
        this.mScaleSpringAnimation.v().e(this.mBoundScaleFrom * SPRING_ANIMATION_FLOAT_TO_INT_PROP);
        startAnimationOnMainThread(this.mScaleSpringAnimation);
    }

    private void toPress() {
        this.mAlphaAnimToPress.setFloatValues(new float[]{((float) this.mAlphaProgress) / 255.0f, this.mAlphaTo});
        this.mAlphaAnimToPress.start();
        if (this.mAlphaAnimToNormal.isRunning()) {
            this.mAlphaAnimToNormal.cancel();
        }
        this.mScaleSpringAnimation.n(this.mScaleProgress * SPRING_ANIMATION_FLOAT_TO_INT_PROP);
        this.mScaleSpringAnimation.v().e(this.mBoundScaleTo * SPRING_ANIMATION_FLOAT_TO_INT_PROP);
        startAnimationOnMainThread(this.mScaleSpringAnimation);
    }

    public void draw(@NonNull Canvas canvas) {
        if (this.mCanReflect) {
            try {
                ReflectUtils.from((Object) canvas).method("setNightModeUseOf", Integer.TYPE).invoke(canvas, 2);
            } catch (Exception unused) {
            }
        }
        if (!isImmersiveStyle()) {
            this.mShapeDrawableBound.set((int) (((float) getBounds().centerX()) - (((float) (this.mShapeDrawableWidth / 2)) * this.mScaleProgress)), (int) (((float) getBounds().centerY()) - (((float) (this.mShapeDrawableHeight / 2)) * this.mScaleProgress)), (int) (((float) getBounds().centerX()) + (((float) (this.mShapeDrawableWidth / 2)) * this.mScaleProgress)), (int) (((float) getBounds().centerY()) + (((float) (this.mShapeDrawableHeight / 2)) * this.mScaleProgress)));
        } else {
            this.mShapeDrawableBound.set(getBounds().centerX() - (this.mShapeDrawableWidth / 2), getBounds().centerY() - (this.mShapeDrawableHeight / 2), getBounds().centerX() + (this.mShapeDrawableWidth / 2), this.mShapeDrawableHeight);
        }
        this.mShapeDrawable.setAlpha(this.mAlphaProgress);
        this.mShapeDrawable.setBounds(this.mShapeDrawableBound);
        this.mShapeDrawable.draw(canvas);
    }

    public int getOpacity() {
        return -1;
    }

    public MaterialShapeDrawable getPressDrawable() {
        return this.mShapeDrawable;
    }

    public int getRadius() {
        return this.mRadius;
    }

    @SuppressLint({"LongLogTag"})
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R.styleable.MzPressAnimationDrawable);
        if (obtainAttributes.hasValue(R.styleable.MzPressAnimationDrawable_radius)) {
            this.mRadius = obtainAttributes.getDimensionPixelSize(R.styleable.MzPressAnimationDrawable_radius, 0);
        }
        if (obtainAttributes.hasValue(R.styleable.MzPressAnimationDrawable_pressScaleTo)) {
            this.mBoundScaleTo = obtainAttributes.getFloat(R.styleable.MzPressAnimationDrawable_pressScaleTo, 1.0f);
        }
        if (obtainAttributes.hasValue(R.styleable.MzPressAnimationDrawable_pressScaleFrom)) {
            this.mBoundScaleFrom = obtainAttributes.getFloat(R.styleable.MzPressAnimationDrawable_pressScaleFrom, 1.0f);
        }
        if (obtainAttributes.hasValue(R.styleable.MzPressAnimationDrawable_drawOffsetX)) {
            this.mDrawOffsetX = obtainAttributes.getDimensionPixelSize(R.styleable.MzPressAnimationDrawable_drawOffsetX, 0);
        }
        if (obtainAttributes.hasValue(R.styleable.MzPressAnimationDrawable_drawOffsetY)) {
            this.mDrawOffsetY = obtainAttributes.getDimensionPixelSize(R.styleable.MzPressAnimationDrawable_drawOffsetY, 0);
        }
        if (obtainAttributes.hasValue(R.styleable.MzPressAnimationDrawable_tint)) {
            this.mTint = obtainAttributes.getColor(R.styleable.MzPressAnimationDrawable_tint, -16777216);
        }
        if (obtainAttributes.hasValue(R.styleable.MzPressAnimationDrawable_pressAlphaFrom)) {
            this.mAlphaFrom = obtainAttributes.getFloat(R.styleable.MzPressAnimationDrawable_pressAlphaFrom, DEFAULT_ALPHA_FROM);
        }
        if (obtainAttributes.hasValue(R.styleable.MzPressAnimationDrawable_pressAlphaTo)) {
            this.mAlphaTo = obtainAttributes.getFloat(R.styleable.MzPressAnimationDrawable_pressAlphaTo, DEFAULT_ALPHA_TO);
        }
        if (obtainAttributes.hasValue(R.styleable.MzPressAnimationDrawable_useFullStyle)) {
            this.mUseFullStyle = obtainAttributes.getBoolean(R.styleable.MzPressAnimationDrawable_useFullStyle, true);
        }
        if (obtainAttributes.hasValue(R.styleable.MzPressAnimationDrawable_notFullStyleUseSquare)) {
            this.mNotFullStyleUseSquare = obtainAttributes.getBoolean(R.styleable.MzPressAnimationDrawable_notFullStyleUseSquare, false);
        }
        if (obtainAttributes.hasValue(R.styleable.MzPressAnimationDrawable_startPadding)) {
            this.mStartPadding = obtainAttributes.getDimensionPixelSize(R.styleable.MzPressAnimationDrawable_startPadding, 0);
        }
        if (obtainAttributes.hasValue(R.styleable.MzPressAnimationDrawable_endPadding)) {
            this.mEndPadding = obtainAttributes.getDimensionPixelSize(R.styleable.MzPressAnimationDrawable_endPadding, 0);
        }
        if (obtainAttributes.hasValue(R.styleable.MzPressAnimationDrawable_topPadding)) {
            this.mTopPadding = obtainAttributes.getDimensionPixelSize(R.styleable.MzPressAnimationDrawable_topPadding, 0);
        }
        if (obtainAttributes.hasValue(R.styleable.MzPressAnimationDrawable_bottomPadding)) {
            this.mBottomPadding = obtainAttributes.getDimensionPixelSize(R.styleable.MzPressAnimationDrawable_bottomPadding, 0);
        }
        obtainAttributes.recycle();
        if (!this.mInit) {
            init();
        }
    }

    public boolean isImmersiveStyle() {
        return false;
    }

    public boolean isProjected() {
        return true;
    }

    public void onBoundsChange(Rect rect) {
        int i;
        super.onBoundsChange(rect);
        getBounds().offset(this.mDrawOffsetX, this.mDrawOffsetY);
        if (this.mUseFullStyle) {
            this.mShapeDrawableWidth = (getBounds().width() - this.mStartPadding) - this.mEndPadding;
            this.mShapeDrawableHeight = (getBounds().height() - this.mTopPadding) - this.mBottomPadding;
        } else if (this.mNotFullStyleUseSquare) {
            int min = Math.min(getBounds().width(), getBounds().height());
            this.mShapeDrawableWidth = min;
            this.mShapeDrawableHeight = min;
            int i2 = this.mStickyWidth;
            if (i2 > 0 && (i = this.mStickyHeight) > 0) {
                this.mShapeDrawableWidth = i2;
                this.mShapeDrawableHeight = i;
            }
        } else {
            int i3 = this.mRadius;
            this.mShapeDrawableWidth = i3 * 2;
            this.mShapeDrawableHeight = i3 * 2;
        }
    }

    public boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        if (iArr == null || iArr.length == 0) {
            return false;
        }
        if (!this.mInit) {
            init();
        }
        boolean z = false;
        boolean z2 = false;
        for (int i : iArr) {
            if (i == 16842910) {
                z = true;
            } else if (i == 16842919) {
                z2 = true;
            }
        }
        if (!z || !z2) {
            toNormal();
        } else {
            toPress();
        }
        return onStateChange;
    }

    public void setAlpha(int i) {
        this.mShapeDrawable.setAlpha(i);
        invalidateSelf();
    }

    public void setAlphaFrom(@FloatRange float f) {
        this.mAlphaFrom = f;
    }

    public void setAlphaTo(@FloatRange float f) {
        this.mAlphaTo = f;
    }

    public void setBoundScaleTo(@FloatRange float f) {
        this.mBoundScaleTo = f;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mShapeDrawable.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setRadius(int i) {
        this.mRadius = i;
    }

    public void setStickyBounds(int i, int i2) {
        this.mStickyWidth = i;
        this.mStickyHeight = i2;
    }

    public void setTint(int i) {
        this.mTint = i;
    }

    public void setUseFullStyle(boolean z) {
        this.mUseFullStyle = z;
    }

    public void startFadeAnimation(final FadeListener fadeListener) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{DEFAULT_ALPHA_FROM, DEFAULT_ALPHA_TO});
        Interpolator interpolator = sFadeInterpolator;
        ofFloat.setInterpolator(interpolator);
        ofFloat.setDuration(350);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{DEFAULT_ALPHA_TO, DEFAULT_ALPHA_FROM});
        ofFloat2.setInterpolator(interpolator);
        ofFloat2.setDuration(500);
        ofFloat2.setStartDelay(700);
        ofFloat.addUpdateListener(new FadeAnimUpdateListener());
        ofFloat2.addUpdateListener(new FadeAnimUpdateListener());
        AnimatorSet animatorSet = new AnimatorSet();
        this.mFadeAnimSet = animatorSet;
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        this.mFadeAnimSet.addListener(new FadeListener() {
            public void onAnimationEnd(@NonNull Animator animator) {
                FadeListener fadeListener = fadeListener;
                if (fadeListener != null) {
                    fadeListener.onAnimationEnd(animator);
                }
            }
        });
        this.mFadeAnimSet.start();
    }

    public void stopFadeAnimation() {
        AnimatorSet animatorSet = this.mFadeAnimSet;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.mFadeAnimSet.pause();
        }
    }
}
