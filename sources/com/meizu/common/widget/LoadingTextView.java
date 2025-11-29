package com.meizu.common.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import com.meizu.common.R;
import com.meizu.common.interpolator.PathInterpolatorCompat;
import com.xjsd.ai.assistant.protocol.CmdCode;

public class LoadingTextView extends TextView {
    public static final int ARROW_BITMAP = 1;
    private static float CHANGE_PER_TIME = (255.0f / ((float) 83));
    private static int DEFAULT_DOT_NUM = 3;
    private static int DURATION = 83;
    private static final int ERROR_STATUS = 1;
    private static int GAP = 160;
    private static final int LOADING_STATUS = 0;
    private static int MAINTAIN = 917;
    public static final int NULL_BITMAP = 0;
    public static final int REFRESH_BITMAP = 2;
    private final int ALPHA_DURATION;
    private final int WIDTH_DURATION;
    private int[] dotAlphas;
    private int dotNum;
    private int mAnimatorDuration;
    private Drawable mArrowDrawable;
    private int mBackgroundAlpha;
    private ValueAnimator mBackgroundAlphaAnimIn;
    private ValueAnimator mBackgroundAlphaAnimOut;
    private AnimatorSet mBackgroundAnimationSet;
    /* access modifiers changed from: private */
    public final Paint mBackgroundPaint;
    /* access modifiers changed from: private */
    public Rect mBackgroundRect;
    private ValueAnimator mBackgroundWidthAnimation;
    private int mCurrentStatus;
    private int mDistance;
    private AnimatorSet mDotAnimationSet;
    private int mDotColor;
    private ValueAnimator mDotMoveAnimation;
    private final Paint mDotPaint;
    /* access modifiers changed from: private */
    public ValueAnimator mDotalphaAnim;
    /* access modifiers changed from: private */
    public float mDottransX;
    private int mErrorBitmapType;
    private CharSequence mErrorMsgText;
    private CharSequence mLoadText;
    private int mLoadingTextColor;
    private float mMarginIcon;
    private int mRadius;
    private Drawable mRefreshDrawable;
    private final Paint mTextPaint;

    public LoadingTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    public void calculateDotAlpha(float f) {
        for (int i = 0; i < this.dotAlphas.length; i++) {
            float max = Math.max(0.0f, Math.min(Math.min(255.0f, Math.max(0.0f, f - ((float) (GAP * i))) * CHANGE_PER_TIME), 255.0f - (CHANGE_PER_TIME * (f - ((float) ((GAP * i) + (DURATION + MAINTAIN)))))));
            int[] iArr = this.dotAlphas;
            iArr[(iArr.length - 1) - i] = (int) max;
        }
    }

    private void drawErrorText(Canvas canvas) {
        float height = ((float) (canvas.getHeight() / 2)) - ((this.mTextPaint.descent() / 2.0f) + (this.mTextPaint.ascent() / 2.0f));
        if (this.mErrorMsgText == null) {
            this.mErrorMsgText = "";
        }
        float measureText = this.mTextPaint.measureText(this.mErrorMsgText.toString());
        canvas.drawText(this.mErrorMsgText.toString(), (((float) getMeasuredWidth()) - measureText) / 2.0f, height, this.mTextPaint);
        float height2 = (float) ((canvas.getHeight() / 2) - (((BitmapDrawable) this.mArrowDrawable).getBitmap().getHeight() / 2));
        int i = this.mErrorBitmapType;
        if (i == 1) {
            canvas.drawBitmap(((BitmapDrawable) this.mArrowDrawable).getBitmap(), ((((float) getMeasuredWidth()) + measureText) / 2.0f) + this.mMarginIcon, height2, (Paint) null);
        } else if (i == 2) {
            canvas.drawBitmap(((BitmapDrawable) this.mRefreshDrawable).getBitmap(), ((((float) getMeasuredWidth()) + measureText) / 2.0f) + this.mMarginIcon, height2, (Paint) null);
        }
        canvas.drawRect(this.mBackgroundRect, this.mBackgroundPaint);
    }

    private void drawTextAbove(Canvas canvas) {
        float height = ((float) (canvas.getHeight() / 2)) - ((this.mTextPaint.descent() / 2.0f) + (this.mTextPaint.ascent() / 2.0f));
        if (this.mLoadText == null) {
            this.mLoadText = "";
        }
        float measureText = this.mTextPaint.measureText(this.mLoadText.toString());
        canvas.drawText(this.mLoadText.toString(), (((float) getMeasuredWidth()) - measureText) / 2.0f, height, this.mTextPaint);
        this.mTextPaint.setShader((Shader) null);
        for (int i = 0; i < this.dotNum; i++) {
            this.mDotPaint.setAlpha(this.dotAlphas[i]);
            canvas.drawCircle(((((float) getMeasuredWidth()) + measureText) / 2.0f) + (((float) i) * getResources().getDimension(R.dimen.down_dot_gap)) + this.mDottransX, height, (float) this.mRadius, this.mDotPaint);
        }
    }

    private void drawing(Canvas canvas) {
        drawTextAbove(canvas);
    }

    private TypedArray getTypedArray(Context context, AttributeSet attributeSet, int[] iArr) {
        return context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    private void init() {
        setGravity(17);
        setTextSize(0, getResources().getDimension(R.dimen.down_load_text_size));
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setTypeface(Typeface.create("sans-serif-medium", 0));
        this.mTextPaint.setColor(this.mLoadingTextColor);
        this.mDotPaint.setAntiAlias(true);
        this.mDotPaint.setColor(this.mDotColor);
        this.dotAlphas = new int[this.dotNum];
        resetDotAlpha();
        this.mDistance = (int) getResources().getDimension(R.dimen.down_dot_translate);
        this.mArrowDrawable = getResources().getDrawable(R.drawable.mz_loading_textview_icon_next_arrow);
        this.mRefreshDrawable = getResources().getDrawable(R.drawable.mz_loading_textview_icon_refresh);
        this.mMarginIcon = getResources().getDimension(R.dimen.error_icon_margin);
        this.mBackgroundPaint.setAntiAlias(true);
        this.mBackgroundPaint.setColor(getResources().getColor(R.color.list_hovered_background));
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LoadingTextView, R.attr.MeizuCommon_LoadingTextStyle, 0);
        try {
            this.mLoadText = obtainStyledAttributes.getString(R.styleable.LoadingTextView_mcLoadingText);
            this.mErrorMsgText = obtainStyledAttributes.getString(R.styleable.LoadingTextView_mcErrorText);
            this.mRadius = obtainStyledAttributes.getInt(R.styleable.LoadingTextView_mcDotRadius, (int) getResources().getDimension(R.dimen.down_dot_radius));
            this.mLoadingTextColor = obtainStyledAttributes.getColor(R.styleable.LoadingTextView_mcLoadingTextColor, getResources().getColor(R.color.fd_sys_color_on_surface_variant_default));
            this.mDotColor = obtainStyledAttributes.getColor(R.styleable.LoadingTextView_mcDotColor, getResources().getColor(R.color.down_load_dot_color));
            this.dotNum = obtainStyledAttributes.getInt(R.styleable.LoadingTextView_mcDotNum, DEFAULT_DOT_NUM);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: private */
    public void resetDotAlpha() {
        int i = 0;
        while (true) {
            int[] iArr = this.dotAlphas;
            if (i < iArr.length) {
                iArr[i] = 0;
                i++;
            } else {
                return;
            }
        }
    }

    private void setupAnimations() {
        this.mDotMoveAnimation = ValueAnimator.ofFloat(new float[]{0.0f, (float) this.mDistance});
        this.mDotMoveAnimation.setInterpolator(new PathInterpolatorCompat(0.11f, 0.0f, 0.12f, 1.0f));
        this.mDotMoveAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = LoadingTextView.this.mDottransX = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                LoadingTextView.this.invalidate();
            }
        });
        this.mDotMoveAnimation.setDuration((long) this.mAnimatorDuration);
        this.mDotMoveAnimation.setRepeatMode(1);
        this.mDotMoveAnimation.setRepeatCount(-1);
        int i = GAP * (this.dotNum - 1);
        int i2 = DURATION;
        int i3 = i + i2 + MAINTAIN + i2;
        this.mAnimatorDuration = i3;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, (float) i3});
        this.mDotalphaAnim = ofFloat;
        ofFloat.setDuration((long) this.mAnimatorDuration);
        this.mDotalphaAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                LoadingTextView.this.calculateDotAlpha(((Float) LoadingTextView.this.mDotalphaAnim.getAnimatedValue()).floatValue());
            }
        });
        this.mDotalphaAnim.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                LoadingTextView.this.resetDotAlpha();
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                LoadingTextView.this.resetDotAlpha();
            }
        });
        this.mDotalphaAnim.setRepeatMode(1);
        this.mDotalphaAnim.setRepeatCount(-1);
        AnimatorSet animatorSet = new AnimatorSet();
        this.mDotAnimationSet = animatorSet;
        animatorSet.play(this.mDotMoveAnimation).with(this.mDotalphaAnim);
    }

    private void setupBackgroundAnimations() {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, getWidth()});
        this.mBackgroundWidthAnimation = ofInt;
        ofInt.setInterpolator(new PathInterpolatorCompat(0.1f, 0.57f, 0.2f, 1.0f));
        this.mBackgroundWidthAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                LoadingTextView.this.mBackgroundRect.right = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                LoadingTextView.this.invalidate();
            }
        });
        this.mBackgroundWidthAnimation.setDuration(400);
        ValueAnimator ofInt2 = ValueAnimator.ofInt(new int[]{this.mBackgroundAlpha, 0});
        this.mBackgroundAlphaAnimOut = ofInt2;
        ofInt2.setDuration(200);
        this.mBackgroundAlphaAnimOut.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                LoadingTextView.this.mBackgroundPaint.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ValueAnimator ofInt3 = ValueAnimator.ofInt(new int[]{this.mBackgroundAlpha, 0});
        this.mBackgroundAlphaAnimIn = ofInt3;
        ofInt3.setDuration(400);
        this.mBackgroundWidthAnimation.setInterpolator(new PathInterpolatorCompat(0.33f, 0.0f, 0.67f, 1.0f));
        this.mBackgroundAlphaAnimIn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                LoadingTextView.this.mBackgroundPaint.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        this.mBackgroundAnimationSet = animatorSet;
        animatorSet.play(this.mBackgroundWidthAnimation).with(this.mBackgroundAlphaAnimIn);
    }

    private void startBackgroundAnimation() {
        AnimatorSet animatorSet = this.mBackgroundAnimationSet;
        if (animatorSet == null || !animatorSet.isRunning()) {
            setupBackgroundAnimations();
            this.mBackgroundAnimationSet.start();
        }
    }

    private void startLoadingAnimation() {
        AnimatorSet animatorSet = this.mDotAnimationSet;
        if (animatorSet == null || !animatorSet.isRunning()) {
            setupAnimations();
            this.mDotAnimationSet.start();
        }
    }

    public String getLoadText() {
        return (String) this.mLoadText;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mCurrentStatus == 1) {
            drawErrorText(canvas);
        } else {
            drawing(canvas);
        }
    }

    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0) {
            if (this.mCurrentStatus == 1) {
                stopBackgroundAnimator();
            } else {
                stopAnimator();
            }
        } else if (!isShown()) {
        } else {
            if (this.mCurrentStatus == 1) {
                startBackgroundAnimation();
            } else {
                startLoadingAnimation();
            }
        }
    }

    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i != 0) {
            if (this.mCurrentStatus == 1) {
                stopBackgroundAnimator();
            } else {
                stopAnimator();
            }
        } else if (!isShown()) {
        } else {
            if (this.mCurrentStatus == 1) {
                startBackgroundAnimation();
            } else {
                startLoadingAnimation();
            }
        }
    }

    public void setBackgroundAlpha(int i) {
        this.mBackgroundAlpha = i;
    }

    public void setDotColor(int i) {
        this.mDotPaint.setColor(i);
    }

    public void setErrorBitmapType(int i) {
        this.mErrorBitmapType = i;
        invalidate();
    }

    public void setErrorStatus(String str) {
        if (str != null && !TextUtils.isEmpty(str)) {
            this.mErrorMsgText = str;
        }
        if (this.mBackgroundRect == null) {
            this.mBackgroundRect = new Rect();
        }
        this.mBackgroundRect.set(0, 0, 0, getHeight());
        this.mCurrentStatus = 1;
        stopAnimator();
        startBackgroundAnimation();
        invalidate();
    }

    public void setLoadText(String str) {
        this.mLoadText = str;
    }

    public void setLoadingStatus() {
        this.mCurrentStatus = 0;
        stopBackgroundAnimator();
        startLoadingAnimation();
        invalidate();
    }

    public void setLoadingTextColor(int i) {
        this.mTextPaint.setColor(i);
    }

    public void setTextSize(int i, float f) {
        super.setTextSize(i, f);
        float applyDimension = TypedValue.applyDimension(i, f, getContext().getResources().getDisplayMetrics());
        this.mTextPaint.setTextSize(applyDimension);
        this.mDotPaint.setTextSize(applyDimension);
        this.mBackgroundPaint.setTextSize(applyDimension);
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            if (this.mCurrentStatus == 1) {
                startBackgroundAnimation();
            } else {
                startLoadingAnimation();
            }
        } else if (i != 4 && i != 8) {
        } else {
            if (this.mCurrentStatus == 1) {
                stopBackgroundAnimator();
            } else {
                stopAnimator();
            }
        }
    }

    public void startAnim() {
        startLoadingAnimation();
    }

    public void stopAnimator() {
        AnimatorSet animatorSet = this.mDotAnimationSet;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.mDotAnimationSet.removeAllListeners();
            this.mDotAnimationSet = null;
        }
        ValueAnimator valueAnimator = this.mDotalphaAnim;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.mDotalphaAnim.removeAllUpdateListeners();
            this.mDotalphaAnim = null;
        }
        ValueAnimator valueAnimator2 = this.mDotMoveAnimation;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
            this.mDotMoveAnimation.removeAllUpdateListeners();
            this.mDotMoveAnimation = null;
        }
    }

    public void stopBackgroundAnimator() {
        ValueAnimator valueAnimator = this.mBackgroundWidthAnimation;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.mBackgroundWidthAnimation.removeAllListeners();
            this.mBackgroundWidthAnimation = null;
        }
        ValueAnimator valueAnimator2 = this.mBackgroundAlphaAnimIn;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
            this.mBackgroundAlphaAnimIn.removeAllUpdateListeners();
            this.mBackgroundAlphaAnimIn = null;
        }
        ValueAnimator valueAnimator3 = this.mBackgroundAlphaAnimOut;
        if (valueAnimator3 != null) {
            valueAnimator3.cancel();
            this.mBackgroundAlphaAnimOut.removeAllUpdateListeners();
            this.mBackgroundAlphaAnimOut = null;
        }
        ValueAnimator valueAnimator4 = this.mBackgroundWidthAnimation;
        if (valueAnimator4 != null) {
            valueAnimator4.cancel();
            this.mBackgroundWidthAnimation.removeAllUpdateListeners();
            this.mBackgroundWidthAnimation = null;
        }
    }

    public LoadingTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTextPaint = new Paint();
        this.mDotPaint = new Paint();
        this.mDotAnimationSet = null;
        this.mDotalphaAnim = null;
        this.mDotMoveAnimation = null;
        this.mCurrentStatus = 0;
        this.mErrorBitmapType = 1;
        this.WIDTH_DURATION = CmdCode.CODE_WAKEUP_RECORDING;
        this.ALPHA_DURATION = 200;
        this.mBackgroundAlpha = 51;
        this.mBackgroundPaint = new Paint();
        this.mBackgroundRect = new Rect();
        this.mBackgroundAnimationSet = null;
        this.mBackgroundAlphaAnimIn = null;
        this.mBackgroundAlphaAnimOut = null;
        this.mBackgroundWidthAnimation = null;
        initAttrs(context, attributeSet);
        init();
        setupAnimations();
    }
}
