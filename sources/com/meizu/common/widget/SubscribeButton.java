package com.meizu.common.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.Button;
import com.meizu.common.R;
import com.meizu.common.app.SlideNotice;

public class SubscribeButton extends Button {
    private static final int DEFAULT_TEXT_SIZE = 15;
    private static float MAX_ALPHASIGN = 1.0f;
    private static float MIN_ALPHASIGN = 0.0f;
    private static final int[] PRESSED_STATE_SET = {16842919};
    private static final String Tag = "SubButton";
    /* access modifiers changed from: private */
    public boolean isAnimating;
    private boolean isPressed;
    private ValueAnimator mAlphaAnim;
    /* access modifiers changed from: private */
    public Interpolator mAlphaInterpolator;
    private int mAnimDuration;
    /* access modifiers changed from: private */
    public Rect mAnimateRect;
    private Rect mBackgroundBound;
    private int mBaseline;
    /* access modifiers changed from: private */
    public float mBeAddedAlpha;
    private Drawable mBeAddedDrawble;
    private TextPaint mBeAddedTextPaint;
    private String mBtnBeAddedText;
    private int mBtnBeAddedTextColor;
    private String mBtnNormalText;
    private int mBtnNormalTextColor;
    private float mBtnSubTextSize;
    /* access modifiers changed from: private */
    public int mDecreasingWidth;
    /* access modifiers changed from: private */
    public int mIncreasingWidth;
    boolean mIsSelected;
    private Rect mMinRect;
    /* access modifiers changed from: private */
    public float mNormalAlpha;
    private Drawable mNormalDrawble;
    private TextPaint mNormalTextPaint;
    /* access modifiers changed from: private */
    public int mTotalHeight;
    /* access modifiers changed from: private */
    public int mTotalWidth;
    /* access modifiers changed from: private */
    public int mTotalWidthDelta;
    /* access modifiers changed from: private */
    public Interpolator mWidthInterpolator;

    public SubscribeButton(Context context) {
        this(context, (AttributeSet) null);
    }

    private float getNormalAlpha() {
        return this.mNormalAlpha;
    }

    private void init() {
        Paint paint = new Paint();
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setTextSize(this.mBtnSubTextSize);
        paint.setTypeface(Typeface.create("sans-serif-medium", 0));
        TextPaint textPaint = new TextPaint(paint);
        this.mNormalTextPaint = textPaint;
        textPaint.setColor(this.mBtnNormalTextColor);
        TextPaint textPaint2 = new TextPaint(paint);
        this.mBeAddedTextPaint = textPaint2;
        textPaint2.setColor(this.mBtnBeAddedTextColor);
        this.mBackgroundBound = new Rect();
        this.mAnimateRect = new Rect();
        this.mMinRect = new Rect();
        this.mAlphaInterpolator = new PathInterpolator(0.18f, 0.7f, 0.05f, 1.0f);
        this.mWidthInterpolator = new PathInterpolator(0.2f, 0.46f, 0.08f, 1.0f);
    }

    private void setNormalAlpha(float f) {
        this.mNormalAlpha = f;
    }

    private void startAnimator(float f, float f2, int i) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f, f2});
        this.mAlphaAnim = ofFloat;
        ofFloat.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
                boolean unused = SubscribeButton.this.isAnimating = false;
            }

            public void onAnimationEnd(Animator animator) {
                boolean unused = SubscribeButton.this.isAnimating = false;
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                boolean unused = SubscribeButton.this.isAnimating = true;
            }
        });
        this.mAlphaAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                SubscribeButton subscribeButton = SubscribeButton.this;
                if (subscribeButton.mIsSelected) {
                    float unused = subscribeButton.mBeAddedAlpha = subscribeButton.mAlphaInterpolator.getInterpolation(floatValue);
                    SubscribeButton subscribeButton2 = SubscribeButton.this;
                    float unused2 = subscribeButton2.mNormalAlpha = 1.0f - subscribeButton2.mBeAddedAlpha;
                    if (SubscribeButton.this.mTotalWidthDelta < 0) {
                        SubscribeButton subscribeButton3 = SubscribeButton.this;
                        int unused3 = subscribeButton3.mDecreasingWidth = (int) (subscribeButton3.mWidthInterpolator.getInterpolation(floatValue) * ((float) Math.abs(SubscribeButton.this.mTotalWidthDelta)));
                        SubscribeButton.this.mAnimateRect.set(SubscribeButton.this.mDecreasingWidth, 0, SubscribeButton.this.mTotalWidth - 1, SubscribeButton.this.mTotalHeight - 1);
                    } else {
                        SubscribeButton subscribeButton4 = SubscribeButton.this;
                        int unused4 = subscribeButton4.mIncreasingWidth = (int) (subscribeButton4.mWidthInterpolator.getInterpolation(floatValue) * ((float) SubscribeButton.this.mTotalWidthDelta));
                        SubscribeButton.this.mAnimateRect.set(SubscribeButton.this.mTotalWidthDelta - SubscribeButton.this.mIncreasingWidth, 0, SubscribeButton.this.mTotalWidth - 1, SubscribeButton.this.mTotalHeight - 1);
                    }
                } else {
                    float unused5 = subscribeButton.mNormalAlpha = subscribeButton.mAlphaInterpolator.getInterpolation(floatValue);
                    SubscribeButton subscribeButton5 = SubscribeButton.this;
                    float unused6 = subscribeButton5.mBeAddedAlpha = 1.0f - subscribeButton5.mNormalAlpha;
                    if (SubscribeButton.this.mTotalWidthDelta < 0) {
                        SubscribeButton subscribeButton6 = SubscribeButton.this;
                        int unused7 = subscribeButton6.mIncreasingWidth = (int) (subscribeButton6.mWidthInterpolator.getInterpolation(floatValue) * ((float) Math.abs(SubscribeButton.this.mTotalWidthDelta)));
                        SubscribeButton.this.mAnimateRect.set(Math.abs(SubscribeButton.this.mTotalWidthDelta) - SubscribeButton.this.mIncreasingWidth, 0, SubscribeButton.this.mTotalWidth - 1, SubscribeButton.this.mTotalHeight - 1);
                    } else {
                        SubscribeButton subscribeButton7 = SubscribeButton.this;
                        int unused8 = subscribeButton7.mDecreasingWidth = (int) (subscribeButton7.mWidthInterpolator.getInterpolation(floatValue) * ((float) SubscribeButton.this.mTotalWidthDelta));
                        SubscribeButton.this.mAnimateRect.set(SubscribeButton.this.mDecreasingWidth, 0, SubscribeButton.this.mTotalWidth - 1, SubscribeButton.this.mTotalHeight - 1);
                    }
                }
                SubscribeButton.this.invalidate();
            }
        });
        this.mAlphaAnim.setDuration((long) i);
        this.mAlphaAnim.start();
    }

    private void updateRectInfo() {
        this.mMinRect.set(Math.abs(this.mTotalWidthDelta), 0, this.mTotalWidth - 1, this.mTotalHeight - 1);
        if (this.mIsSelected) {
            int i = this.mTotalWidthDelta;
            if (i > 0) {
                this.mAnimateRect.set(0, 0, this.mTotalWidth - 1, getHeight() - 1);
            } else {
                this.mAnimateRect.set(Math.abs(i), 0, this.mTotalWidth - 1, this.mTotalHeight - 1);
            }
            this.mNormalAlpha = 0.0f;
            this.mBeAddedAlpha = 1.0f;
            return;
        }
        int i2 = this.mTotalWidthDelta;
        if (i2 < 0) {
            this.mAnimateRect.set(0, 0, this.mTotalWidth - 1, this.mTotalHeight - 1);
        } else {
            this.mAnimateRect.set(Math.abs(i2), 0, this.mTotalWidth - 1, this.mTotalHeight - 1);
        }
        this.mNormalAlpha = 1.0f;
        this.mBeAddedAlpha = 0.0f;
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.mNormalDrawble;
        if (drawable != null) {
            drawable.setState(drawableState);
        }
        Drawable drawable2 = this.mBeAddedDrawble;
        if (drawable2 != null) {
            drawable2.setState(drawableState);
        }
        invalidate();
    }

    public Drawable getBeAddedDrawble() {
        return this.mBeAddedDrawble;
    }

    public String getBtnBeAddedText() {
        return this.mBtnBeAddedText;
    }

    public int getBtnBeAddedTextColor() {
        return this.mBeAddedTextPaint.getColor();
    }

    public String getBtnNormalText() {
        return this.mBtnNormalText;
    }

    public int getBtnNormalTextColor() {
        return this.mNormalTextPaint.getColor();
    }

    public Drawable getNormalDrawble() {
        return this.mNormalDrawble;
    }

    public boolean getSelectedState() {
        return this.mIsSelected;
    }

    public int getTextWidth(Paint paint, String str) {
        TransformationMethod transformationMethod = getTransformationMethod();
        if (transformationMethod != null) {
            str = transformationMethod.getTransformation(str, this).toString();
        }
        return (int) paint.measureText(str);
    }

    public boolean isAnimating() {
        return this.isAnimating;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.mNormalDrawble;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.mBeAddedDrawble;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
    }

    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.isPressed) {
            View.mergeDrawableStates(onCreateDrawableState, PRESSED_STATE_SET);
        }
        return onCreateDrawableState;
    }

    public void onDraw(Canvas canvas) {
        this.mNormalTextPaint.setAlpha((int) (this.mNormalAlpha * 255.0f));
        this.mBeAddedTextPaint.setAlpha((int) (this.mBeAddedAlpha * 255.0f));
        this.mNormalDrawble.setAlpha((int) (this.mNormalAlpha * 255.0f));
        this.mNormalDrawble.setBounds(this.mAnimateRect);
        this.mNormalDrawble.draw(canvas);
        this.mBeAddedDrawble.setAlpha((int) (this.mBeAddedAlpha * 255.0f));
        this.mBeAddedDrawble.setBounds(this.mAnimateRect);
        this.mBeAddedDrawble.draw(canvas);
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        String str = (String) TextUtils.ellipsize(this.mBtnNormalText, this.mNormalTextPaint, (float) ((getWidth() - getPaddingRight()) - getPaddingLeft()), truncateAt);
        String str2 = (String) TextUtils.ellipsize(this.mBtnBeAddedText, this.mBeAddedTextPaint, (float) ((getWidth() - getPaddingRight()) - getPaddingLeft()), truncateAt);
        if (this.mBackgroundBound != null) {
            canvas.save();
            canvas.clipRect(this.mAnimateRect);
            if (this.mTotalWidthDelta > 0) {
                canvas.drawText(str, (float) this.mMinRect.centerX(), (float) this.mBaseline, this.mNormalTextPaint);
                canvas.drawText(str2, (float) this.mBackgroundBound.centerX(), (float) this.mBaseline, this.mBeAddedTextPaint);
            } else {
                canvas.drawText(str, (float) this.mBackgroundBound.centerX(), (float) this.mBaseline, this.mNormalTextPaint);
                canvas.drawText(str2, (float) this.mMinRect.centerX(), (float) this.mBaseline, this.mBeAddedTextPaint);
            }
            canvas.restore();
        }
        super.onDraw(canvas);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(SubscribeButton.class.getName());
    }

    public void onMeasure(int i, int i2) {
        Paint.FontMetrics fontMetrics = this.mNormalTextPaint.getFontMetrics();
        int paddingBottom = (int) ((fontMetrics.bottom - fontMetrics.top) + ((float) getPaddingBottom()) + ((float) getPaddingTop()));
        int max = Math.max(getTextWidth(this.mNormalTextPaint, this.mBtnNormalText), (getMinWidth() - getPaddingLeft()) - getPaddingRight());
        int max2 = Math.max(getTextWidth(this.mBeAddedTextPaint, this.mBtnBeAddedText), (getMinWidth() - getPaddingLeft()) - getPaddingRight());
        int max3 = Math.max(max, max2) + getPaddingLeft() + getPaddingRight();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != Integer.MIN_VALUE) {
            max3 = size;
        }
        if (mode2 != Integer.MIN_VALUE) {
            paddingBottom = (mode2 == 1073741824 || mode == 0) ? size2 : 0;
        }
        setMeasuredDimension(max3, paddingBottom);
        this.mTotalWidthDelta = max2 - max;
        updateRectInfo();
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mBackgroundBound.set(0, 0, i, i2);
        Paint.FontMetricsInt fontMetricsInt = this.mNormalTextPaint.getFontMetricsInt();
        int centerY = this.mBackgroundBound.centerY();
        int i5 = fontMetricsInt.bottom;
        int i6 = fontMetricsInt.top;
        this.mBaseline = (centerY - ((i5 - i6) / 2)) - i6;
        this.mBeAddedDrawble.setBounds(this.mBackgroundBound);
        this.mNormalDrawble.setBounds(this.mBackgroundBound);
        this.mTotalWidth = i;
        this.mTotalHeight = i2;
        updateRectInfo();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            ValueAnimator valueAnimator = this.mAlphaAnim;
            if (valueAnimator != null) {
                valueAnimator.end();
            }
            this.isPressed = true;
        } else if (actionMasked == 1 || actionMasked == 2 || actionMasked == 3) {
            this.isPressed = false;
        } else if (actionMasked != 11) {
            this.isPressed = false;
        } else {
            this.isPressed = true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean performClick() {
        if (!this.isAnimating) {
            this.mIsSelected = !this.mIsSelected;
            startAnimator(0.0f, 1.0f, this.mAnimDuration);
        }
        return super.performClick();
    }

    public void setAnimDuration(int i) {
        this.mAnimDuration = i;
    }

    public void setAnimating(boolean z) {
        this.isAnimating = z;
    }

    public void setBeAddedDrawble(Drawable drawable) {
        if (drawable != null) {
            this.mBeAddedDrawble = drawable;
            invalidate();
        }
    }

    public void setBtnBeAddedText(String str) {
        String str2 = this.mBtnBeAddedText;
        this.mBtnBeAddedText = str;
        if (this.mBeAddedTextPaint.measureText(str2) != this.mBeAddedTextPaint.measureText(this.mBtnBeAddedText)) {
            requestLayout();
        }
        invalidate();
    }

    public void setBtnBeAddedTextColor(int i) {
        this.mBeAddedTextPaint.setColor(i);
        invalidate();
    }

    public void setBtnNormalText(String str) {
        String str2 = this.mBtnNormalText;
        this.mBtnNormalText = str;
        if (this.mNormalTextPaint.measureText(str2) != this.mNormalTextPaint.measureText(this.mBtnNormalText)) {
            requestLayout();
        }
        invalidate();
    }

    public void setBtnNormalTextColor(int i) {
        this.mNormalTextPaint.setColor(i);
        invalidate();
    }

    public void setBtnSubTextSize(int i) {
        float f = (float) i;
        this.mNormalTextPaint.setTextSize(f);
        this.mBeAddedTextPaint.setTextSize(f);
        if (this.mBackgroundBound != null) {
            Paint.FontMetricsInt fontMetricsInt = this.mNormalTextPaint.getFontMetricsInt();
            int centerY = this.mBackgroundBound.centerY();
            int i2 = fontMetricsInt.bottom;
            int i3 = fontMetricsInt.top;
            this.mBaseline = (centerY - ((i2 - i3) / 2)) - i3;
        }
        invalidate();
    }

    public void setNormalDrawble(int i) {
        if (i != 0) {
            this.mNormalDrawble = getResources().getDrawable(i);
            invalidate();
        }
    }

    public void setSelectedable(boolean z) {
        if (this.mIsSelected != z) {
            this.mIsSelected = z;
            updateRectInfo();
            invalidate();
        }
    }

    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.mNormalDrawble || drawable == this.mBeAddedDrawble;
    }

    public SubscribeButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.MeizuCommon_SubscribeButtonStyle);
    }

    public SubscribeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsSelected = false;
        this.mNormalAlpha = 0.0f;
        this.mBeAddedAlpha = 0.0f;
        this.mTotalWidth = 0;
        this.mTotalHeight = 0;
        this.mTotalWidthDelta = 0;
        this.mDecreasingWidth = 0;
        this.mIncreasingWidth = 0;
        this.mAlphaAnim = null;
        this.mBtnSubTextSize = 15.0f;
        this.isAnimating = false;
        this.isPressed = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SubscribeButton, i, 0);
        this.mNormalDrawble = obtainStyledAttributes.getDrawable(R.styleable.SubscribeButton_mcBtnNormalBg);
        this.mBeAddedDrawble = obtainStyledAttributes.getDrawable(R.styleable.SubscribeButton_mcBtnBeAddedBg);
        this.mBtnSubTextSize = obtainStyledAttributes.getDimension(R.styleable.SubscribeButton_mcBtnSubTextSize, 15.0f);
        this.mBtnBeAddedText = obtainStyledAttributes.getString(R.styleable.SubscribeButton_mcBtnBeAddedText);
        this.mBtnNormalText = obtainStyledAttributes.getString(R.styleable.SubscribeButton_mcBtnNormalText);
        this.mBtnBeAddedTextColor = obtainStyledAttributes.getColor(R.styleable.SubscribeButton_mcBtnBeAddedTextColor, -16777216);
        this.mBtnNormalTextColor = obtainStyledAttributes.getColor(R.styleable.SubscribeButton_mcBtnNormalTextColor, -1);
        this.mAnimDuration = obtainStyledAttributes.getInteger(R.styleable.SubscribeButton_mcBtnAnimDuration, SlideNotice.SHOW_ANIMATION_DURATION);
        if (this.mNormalDrawble == null) {
            this.mNormalDrawble = getResources().getDrawable(R.drawable.mc_btn_list_default_alpha_normal);
        }
        Drawable drawable = this.mNormalDrawble;
        if (drawable != null) {
            drawable.setCallback(this);
            this.mNormalDrawble.setState(new int[]{16842910, 16842919});
        }
        if (this.mBeAddedDrawble == null) {
            this.mBeAddedDrawble = getResources().getDrawable(R.drawable.mc_btn_list_default_pressed);
        }
        Drawable drawable2 = this.mBeAddedDrawble;
        if (drawable2 != null) {
            drawable2.setCallback(this);
            this.mBeAddedDrawble.setState(new int[]{16842910, 16842919});
        }
        obtainStyledAttributes.recycle();
        init();
    }

    public void setBeAddedDrawble(int i) {
        if (i != 0) {
            this.mBeAddedDrawble = getResources().getDrawable(i);
            invalidate();
        }
    }

    public void setNormalDrawble(Drawable drawable) {
        if (drawable != null) {
            this.mNormalDrawble = drawable;
            invalidate();
        }
    }
}
