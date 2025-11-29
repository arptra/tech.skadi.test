package com.meizu.textinputlayout;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.core.content.ContextCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.meizu.common.R;
import com.meizu.textinputlayout.ValueAnimatorCompat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Locale;

public class TextInputLayout extends LinearLayout {
    private static Field mCursorDrawableArray;
    private static Field mCursorDrawableRes;
    private static Field mTextViewEditor;
    private static Method mUpdateCursorPosition;
    private boolean mAlignEditContent;
    private int mAnimationDuration;
    private ValueAnimatorCompat mAnimator;
    /* access modifiers changed from: private */
    public final CollapsingTextHelper mCollapsingTextHelper;
    private int mDefaultCursorDrawableRes;
    private ColorStateList mDefaultTextColor;
    /* access modifiers changed from: private */
    public EditText mEditText;
    private Drawable mErrorBackground;
    private boolean mErrorEnabled;
    private int mErrorPaddingHorizontal;
    private int mErrorPaddingTop;
    private int mErrorTextAppearance;
    /* access modifiers changed from: private */
    public TextView mErrorView;
    private ColorStateList mFocusedTextColor;
    private CharSequence mHint;
    private boolean mHintAnimationEnabled;
    private boolean mLabelEnable;
    private int mLabelPaddingHorizontal;
    private int mLabelTextHeight;
    private Drawable mOriginBackground;
    private Paint mTmpPaint;

    public static class AnimInterpolator implements Interpolator {
        private AnimInterpolator() {
        }

        public float getInterpolation(float f) {
            return (float) (1.0d - Math.pow((double) (1.0f - f), 2.0d));
        }
    }

    public class TextInputAccessibilityDelegate extends AccessibilityDelegateCompat {
        private TextInputAccessibilityDelegate() {
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(TextInputLayout.class.getSimpleName());
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.h0(TextInputLayout.class.getSimpleName());
            CharSequence text = TextInputLayout.this.mCollapsingTextHelper.getText();
            if (!TextUtils.isEmpty(text)) {
                accessibilityNodeInfoCompat.L0(text);
            }
            if (TextInputLayout.this.mEditText != null) {
                accessibilityNodeInfoCompat.u0(TextInputLayout.this.mEditText);
            }
            CharSequence text2 = TextInputLayout.this.mErrorView != null ? TextInputLayout.this.mErrorView.getText() : null;
            if (!TextUtils.isEmpty(text2)) {
                accessibilityNodeInfoCompat.m0(true);
                accessibilityNodeInfoCompat.p0(text2);
            }
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            CharSequence text = TextInputLayout.this.mCollapsingTextHelper.getText();
            if (!TextUtils.isEmpty(text)) {
                accessibilityEvent.getText().add(text);
            }
        }
    }

    public TextInputLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    private void animateToExpansionFraction(float f) {
        if (this.mCollapsingTextHelper.getExpansionFraction() != f) {
            if (this.mAnimator == null) {
                ValueAnimatorCompat createAnimator = ViewUtils.createAnimator();
                this.mAnimator = createAnimator;
                createAnimator.setInterpolator(getInterpolator());
                this.mAnimator.setDuration(this.mAnimationDuration);
                this.mAnimator.setUpdateListener(new ValueAnimatorCompat.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimatorCompat valueAnimatorCompat) {
                        TextInputLayout.this.mCollapsingTextHelper.setExpansionFraction(valueAnimatorCompat.getAnimatedFloatValue());
                    }
                });
            }
            this.mAnimator.setFloatValues(this.mCollapsingTextHelper.getExpansionFraction(), f);
            this.mAnimator.start();
        }
    }

    private static boolean arrayContains(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private void collapseHint(boolean z) {
        ValueAnimatorCompat valueAnimatorCompat = this.mAnimator;
        if (valueAnimatorCompat != null && valueAnimatorCompat.isRunning()) {
            this.mAnimator.cancel();
        }
        if (!z || !this.mHintAnimationEnabled) {
            this.mCollapsingTextHelper.setExpansionFraction(1.0f);
        } else {
            animateToExpansionFraction(1.0f);
        }
    }

    private void expandHint(boolean z) {
        ValueAnimatorCompat valueAnimatorCompat = this.mAnimator;
        if (valueAnimatorCompat != null && valueAnimatorCompat.isRunning()) {
            this.mAnimator.cancel();
        }
        if (!z || !this.mHintAnimationEnabled) {
            this.mCollapsingTextHelper.setExpansionFraction(0.0f);
        } else {
            animateToExpansionFraction(0.0f);
        }
    }

    private Interpolator getInterpolator() {
        return new PathInterpolator(0.1f, 0.0f, 0.1f, 1.0f);
    }

    private int getThemeAttrColor(int i) {
        TypedValue typedValue = new TypedValue();
        if (getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            return typedValue.data;
        }
        return -65281;
    }

    private void setCursorDrawable(EditText editText, int i) {
        if (i >= 0) {
            try {
                Class<TextView> cls = TextView.class;
                if (mCursorDrawableRes == null) {
                    Field declaredField = cls.getDeclaredField("mCursorDrawableRes");
                    mCursorDrawableRes = declaredField;
                    declaredField.setAccessible(true);
                    this.mDefaultCursorDrawableRes = mCursorDrawableRes.getInt(editText);
                }
                mCursorDrawableRes.setInt(editText, 0);
                if (mTextViewEditor == null) {
                    Field declaredField2 = cls.getDeclaredField("mEditor");
                    mTextViewEditor = declaredField2;
                    declaredField2.setAccessible(true);
                }
                Object obj = mTextViewEditor.get(editText);
                Class<?> cls2 = Class.forName("android.widget.Editor");
                if (mUpdateCursorPosition == null) {
                    Method declaredMethod = cls2.getDeclaredMethod("updateCursorPosition", (Class[]) null);
                    mUpdateCursorPosition = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                mUpdateCursorPosition.invoke(obj, (Object[]) null);
                mCursorDrawableRes.setInt(editText, i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private LinearLayout.LayoutParams updateEditTextMargin(ViewGroup.LayoutParams layoutParams) {
        LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams);
        if (this.mTmpPaint == null) {
            this.mTmpPaint = new Paint();
        }
        this.mTmpPaint.setTypeface(this.mCollapsingTextHelper.getTypeface());
        this.mTmpPaint.setTextSize(this.mCollapsingTextHelper.getCollapsedTextSize());
        layoutParams2.topMargin = 0;
        this.mLabelTextHeight = 0;
        return layoutParams2;
    }

    /* access modifiers changed from: private */
    public void updateLabelVisibility(boolean z) {
        EditText editText = this.mEditText;
        boolean z2 = editText != null && !TextUtils.isEmpty(editText.getText());
        boolean arrayContains = arrayContains(getDrawableState(), 16842908);
        ColorStateList colorStateList = this.mDefaultTextColor;
        if (!(colorStateList == null || this.mFocusedTextColor == null)) {
            this.mCollapsingTextHelper.setExpandedTextColor(colorStateList.getDefaultColor());
            this.mCollapsingTextHelper.setCollapsedTextColor(arrayContains ? this.mFocusedTextColor.getDefaultColor() : this.mDefaultTextColor.getDefaultColor());
        }
        if (z2 || arrayContains) {
            collapseHint(z);
        } else {
            expandHint(z);
        }
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            setEditText((EditText) view);
            super.addView(view, 0, updateEditTextMargin(layoutParams));
            return;
        }
        super.addView(view, i, layoutParams);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.mLabelEnable) {
            this.mCollapsingTextHelper.draw(canvas);
        }
    }

    @Nullable
    public EditText getEditText() {
        return this.mEditText;
    }

    @Nullable
    public CharSequence getError() {
        TextView textView;
        if (!this.mErrorEnabled || (textView = this.mErrorView) == null || textView.getVisibility() != 0) {
            return null;
        }
        return this.mErrorView.getText();
    }

    public boolean getErrorEnabled() {
        return this.mErrorEnabled;
    }

    public TextView getErrorView() {
        return this.mErrorView;
    }

    @Nullable
    public CharSequence getHint() {
        return this.mHint;
    }

    public boolean getLabelEnable() {
        return this.mLabelEnable;
    }

    public int getLabelTextHeight() {
        return this.mLabelTextHeight;
    }

    public boolean isErrorEnabled() {
        return this.mErrorEnabled;
    }

    public boolean isErrorShow() {
        TextView textView = this.mErrorView;
        return textView != null && textView.getVisibility() == 0;
    }

    public boolean isHintAnimationEnabled() {
        return this.mHintAnimationEnabled;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(TextInputLayout.class.getName());
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        super.onLayout(z, i, i2, i3, i4);
        EditText editText = this.mEditText;
        if (editText != null) {
            int left = editText.getLeft() + this.mEditText.getCompoundPaddingLeft();
            int right = this.mEditText.getRight() - this.mEditText.getCompoundPaddingRight();
            if (this.mAlignEditContent) {
                i5 = this.mEditText.getLeft() + this.mEditText.getCompoundPaddingLeft();
                i6 = this.mEditText.getRight() - this.mEditText.getCompoundPaddingRight();
            } else {
                i5 = this.mEditText.getLeft();
                i6 = this.mEditText.getRight();
            }
            int i7 = this.mLabelPaddingHorizontal;
            this.mCollapsingTextHelper.setExpandedBounds(left, this.mEditText.getTop() + this.mEditText.getCompoundPaddingTop(), right, this.mEditText.getBottom() - this.mEditText.getCompoundPaddingBottom());
            this.mCollapsingTextHelper.setCollapsedBounds(i5 + i7, getPaddingTop(), i6 + i7, (i4 - i2) - getPaddingBottom());
            this.mCollapsingTextHelper.recalculate();
        }
    }

    public void refreshDrawableState() {
        super.refreshDrawableState();
        updateLabelVisibility(ViewCompat.W(this));
    }

    public void setAlignEditContent(boolean z) {
        this.mAlignEditContent = z;
    }

    public void setAnimationDuration(int i) {
        this.mAnimationDuration = i;
    }

    public void setCollapsedTextColor(int i) {
        this.mFocusedTextColor = ColorStateList.valueOf(i);
    }

    public void setEditText(EditText editText) {
        if (this.mEditText == null) {
            this.mEditText = editText;
            if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
                this.mEditText.setTextDirection(4);
            }
            this.mCollapsingTextHelper.setTypeface(this.mEditText.getTypeface());
            this.mCollapsingTextHelper.setExpandedTextSize(this.mEditText.getTextSize());
            this.mCollapsingTextHelper.setExpandedTextGravity(this.mEditText.getGravity());
            this.mEditText.addTextChangedListener(new TextWatcher() {
                public void afterTextChanged(Editable editable) {
                    TextInputLayout.this.updateLabelVisibility(true);
                }

                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (TextInputLayout.this.mEditText != null && TextInputLayout.this.mEditText.getText().length() == 0) {
                        TextInputLayout.this.setErrorEnabled(false);
                        TextInputLayout.this.mEditText.setBackgroundTintList((ColorStateList) null);
                    }
                }
            });
            if (this.mDefaultTextColor == null) {
                this.mDefaultTextColor = this.mEditText.getHintTextColors();
            }
            if (TextUtils.isEmpty(this.mHint)) {
                setHint(this.mEditText.getHint());
                this.mEditText.setHint((CharSequence) null);
            }
            TextView textView = this.mErrorView;
            if (textView != null) {
                if (this.mAlignEditContent) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mEditText.getLayoutParams();
                    ViewCompat.N0(this.mErrorView, ViewCompat.F(this.mEditText) + this.mErrorPaddingHorizontal, this.mErrorPaddingTop, ViewCompat.E(this.mEditText) + this.mErrorPaddingHorizontal, 0);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mErrorView.getLayoutParams();
                    layoutParams2.leftMargin = layoutParams.leftMargin;
                    layoutParams2.rightMargin = layoutParams.rightMargin;
                    this.mErrorView.setLayoutParams(layoutParams2);
                } else {
                    int i = this.mErrorPaddingHorizontal;
                    ViewCompat.N0(textView, i, this.mErrorPaddingTop, i, 0);
                }
            }
            updateLabelVisibility(false);
            return;
        }
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    public void setError(@Nullable CharSequence charSequence) {
        boolean z;
        if (this.mErrorEnabled) {
            z = false;
        } else if (!TextUtils.isEmpty(charSequence)) {
            z = true;
            setErrorEnabled(true);
        } else {
            return;
        }
        if (!TextUtils.isEmpty(charSequence)) {
            ViewCompat.y0(this.mErrorView, 0.0f);
            this.mErrorView.setText(charSequence);
            ViewCompat.e(this.mErrorView).b(1.0f).i((long) this.mAnimationDuration).j(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR).k(new ViewPropertyAnimatorListenerAdapter() {
                public void onAnimationStart(View view) {
                    view.setVisibility(0);
                }
            }).o();
            if (z) {
                if (this.mErrorBackground != null) {
                    this.mOriginBackground = this.mEditText.getBackground();
                    this.mEditText.setBackground(this.mErrorBackground);
                } else {
                    ViewCompat.A0(this.mEditText, new ColorStateList(new int[][]{new int[]{16842910, 16842908}, new int[0]}, new int[]{this.mErrorView.getCurrentTextColor(), getContext().getResources().getColor(R.color.mz_text_input_normal_color)}));
                    setCursorDrawable(this.mEditText, R.drawable.mz_text_cursor_error_color);
                }
            }
        } else if (this.mErrorView.getVisibility() == 0) {
            ViewCompat.e(this.mErrorView).b(0.0f).i((long) this.mAnimationDuration).j(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR).k(new ViewPropertyAnimatorListenerAdapter() {
                public void onAnimationEnd(View view) {
                    view.setVisibility(4);
                }
            }).o();
            getContext().getResources();
            Drawable drawable = this.mOriginBackground;
            if (drawable != null) {
                this.mEditText.setBackground(drawable);
            } else {
                ViewCompat.A0(this.mEditText, (ColorStateList) null);
            }
            setCursorDrawable(this.mEditText, this.mDefaultCursorDrawableRes);
        }
        sendAccessibilityEvent(2048);
    }

    public void setErrorBackground(Drawable drawable) {
        EditText editText;
        this.mErrorBackground = drawable;
        if (isErrorShow() && (editText = this.mEditText) != null) {
            editText.setBackground(this.mErrorBackground);
        }
    }

    public void setErrorBackgroundResource(@DrawableRes int i) {
        EditText editText;
        if (i != 0) {
            this.mErrorBackground = ContextCompat.getDrawable(getContext(), i);
            if (isErrorShow() && (editText = this.mEditText) != null) {
                editText.setBackground(this.mErrorBackground);
            }
        }
    }

    public void setErrorEnabled(boolean z) {
        if (this.mErrorEnabled != z) {
            TextView textView = this.mErrorView;
            if (textView != null) {
                ViewCompat.e(textView).c();
            }
            if (z) {
                TextView textView2 = new TextView(getContext());
                this.mErrorView = textView2;
                textView2.setTextAppearance(getContext(), this.mErrorTextAppearance);
                this.mErrorView.setVisibility(4);
                if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
                    this.mErrorView.setGravity(8388613);
                }
                addView(this.mErrorView);
                EditText editText = this.mEditText;
                if (editText != null) {
                    if (this.mAlignEditContent) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) editText.getLayoutParams();
                        ViewCompat.N0(this.mErrorView, ViewCompat.F(this.mEditText) + this.mErrorPaddingHorizontal, this.mErrorPaddingTop, ViewCompat.E(this.mEditText) + this.mErrorPaddingHorizontal, 0);
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mErrorView.getLayoutParams();
                        layoutParams2.leftMargin = layoutParams.leftMargin;
                        layoutParams2.rightMargin = layoutParams.rightMargin;
                        this.mErrorView.setLayoutParams(layoutParams2);
                    } else {
                        TextView textView3 = this.mErrorView;
                        int i = this.mErrorPaddingHorizontal;
                        ViewCompat.N0(textView3, i, this.mErrorPaddingTop, i, 0);
                    }
                }
            } else {
                getContext().getResources();
                Drawable drawable = this.mOriginBackground;
                if (drawable != null) {
                    this.mEditText.setBackground(drawable);
                } else {
                    ViewCompat.A0(this.mEditText, (ColorStateList) null);
                }
                setCursorDrawable(this.mEditText, this.mDefaultCursorDrawableRes);
                removeView(this.mErrorView);
                this.mErrorView = null;
            }
            this.mErrorEnabled = z;
        }
    }

    public void setErrorPaddingHorizontal(int i) {
        this.mErrorPaddingHorizontal = i;
    }

    public void setErrorPaddingTop(int i) {
        this.mErrorPaddingTop = i;
        invalidate();
    }

    public void setHint(@Nullable CharSequence charSequence) {
        this.mHint = charSequence;
        this.mCollapsingTextHelper.setText(charSequence);
        sendAccessibilityEvent(2048);
    }

    public void setHintAnimationEnabled(boolean z) {
        this.mHintAnimationEnabled = z;
    }

    public void setHintTextAppearance(@StyleRes int i) {
        this.mCollapsingTextHelper.setCollapsedTextAppearance(i);
        this.mFocusedTextColor = ColorStateList.valueOf(this.mCollapsingTextHelper.getCollapsedTextColor());
        if (this.mEditText != null) {
            updateLabelVisibility(false);
            this.mEditText.setLayoutParams(updateEditTextMargin(this.mEditText.getLayoutParams()));
            this.mEditText.requestLayout();
        }
    }

    public void setLabelEnable(boolean z) {
        this.mLabelEnable = z;
    }

    public void setLabelPaddingHorizontal(int i) {
        this.mLabelPaddingHorizontal = i;
    }

    public void setOriginBackground(Drawable drawable) {
        EditText editText;
        this.mOriginBackground = drawable;
        if (!isErrorShow() && (editText = this.mEditText) != null) {
            editText.setBackground(this.mOriginBackground);
        }
    }

    public void setOriginBackgroundResource(@DrawableRes int i) {
        EditText editText;
        if (i != 0) {
            this.mOriginBackground = ContextCompat.getDrawable(getContext(), i);
            if (!isErrorShow() && (editText = this.mEditText) != null) {
                editText.setBackground(this.mOriginBackground);
            }
        }
    }

    public void setTypeface(@Nullable Typeface typeface) {
        this.mCollapsingTextHelper.setTypeface(typeface);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mAnimationDuration = 300;
        CollapsingTextHelper collapsingTextHelper = new CollapsingTextHelper(this);
        this.mCollapsingTextHelper = collapsingTextHelper;
        this.mErrorPaddingTop = 6;
        this.mLabelTextHeight = 0;
        this.mLabelEnable = true;
        this.mDefaultCursorDrawableRes = -1;
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        collapsingTextHelper.setTextSizeInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        collapsingTextHelper.setPositionInterpolator(new AccelerateInterpolator());
        collapsingTextHelper.setCollapsedTextGravity(8388659);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MzTextInputLayout, i, R.style.MzTextInputLayoutTextAppearance);
        this.mHint = obtainStyledAttributes.getText(R.styleable.MzTextInputLayout_android_hint);
        this.mHintAnimationEnabled = obtainStyledAttributes.getBoolean(R.styleable.MzTextInputLayout_hintAnimationEnabled, true);
        if (obtainStyledAttributes.hasValue(R.styleable.MzTextInputLayout_android_textColorHint)) {
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(R.styleable.MzTextInputLayout_android_textColorHint);
            this.mFocusedTextColor = colorStateList;
            this.mDefaultTextColor = colorStateList;
        }
        if (obtainStyledAttributes.getResourceId(R.styleable.MzTextInputLayout_hintTextAppearance, -1) != -1) {
            setHintTextAppearance(obtainStyledAttributes.getResourceId(R.styleable.MzTextInputLayout_hintTextAppearance, 0));
        }
        this.mErrorTextAppearance = obtainStyledAttributes.getResourceId(R.styleable.MzTextInputLayout_errorTextAppearance, 0);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.MzTextInputLayout_errorEnabled, false);
        this.mErrorBackground = obtainStyledAttributes.getDrawable(R.styleable.MzTextInputLayout_errorBackground);
        this.mAlignEditContent = obtainStyledAttributes.getBoolean(R.styleable.MzTextInputLayout_alignEditContent, true);
        this.mLabelPaddingHorizontal = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MzTextInputLayout_labelPaddingHorizontal, 0);
        this.mErrorPaddingHorizontal = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MzTextInputLayout_errorPaddingHorizontal, 0);
        obtainStyledAttributes.recycle();
        this.mErrorPaddingTop = context.getResources().getDimensionPixelSize(R.dimen.mz_text_input_layout_default_margin_top);
        setErrorEnabled(z);
        if (ViewCompat.x(this) == 0) {
            ViewCompat.G0(this, 1);
        }
        ViewCompat.u0(this, new TextInputAccessibilityDelegate());
    }
}
