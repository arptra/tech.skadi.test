package com.meizu.common.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.core.content.ContextCompat;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.meizu.common.R;
import com.meizu.common.util.CommonUtils;
import com.meizu.common.util.ScreenUtil;

public class Switch extends CompoundButton {
    private static final int[] CHECKED_STATE_SET = {16842912};
    private static final float DAMPING_CHECK_OFF_DEFAULT = 0.69f;
    private static final float DAMPING_CHECK_ON_DEFAULT = 0.81f;
    public static final int FLYME_SLIDE_HORIZONTAL = 31022;
    private static final float STIFFNESS_DEFAULT = 570.0f;
    public static final String TAG = "MzSwitch";
    private static final FloatPropertyCompat<Switch> THUMB_POSITION = new FloatPropertyCompat<Switch>("thumbPos") {
        public float getValue(Switch switchR) {
            return switchR.mThumbPosition;
        }

        public void setValue(Switch switchR, float f) {
            switchR.setThumbPosition(f);
        }
    };
    private static final float THUMB_STATUS_CHANGE = 1.0f;
    private static final int TOUCH_MODE_DOWN = 1;
    private static final int TOUCH_MODE_DRAGGING = 2;
    private static final int TOUCH_MODE_IDLE = 0;
    private static int[] sSwitchStyleableId;
    private boolean isChanged;
    private AttributeSet mAttributeSet;
    private float mCheckOffDamping;
    private float mCheckOnDamping;
    private ColorStateList mCustomDarkTrackOffColorState;
    private ColorStateList mCustomDarkTrackOnColorState;
    private ColorStateList mCustomTrackOffColorState;
    private ColorStateList mCustomTrackOnColorState;
    private boolean mIgnoreSystemNightMode;
    private boolean mIsHighContrastModeOn;
    private int mMinFlingVelocity;
    private MorphingParams mParams;
    private boolean mSplitTrack;
    private int mSwitchBottom;
    private int mSwitchHeight;
    private int mSwitchLeft;
    private int mSwitchMinWidth;
    private int mSwitchPadding;
    private int mSwitchRight;
    private int mSwitchTop;
    private TransformationMethod2 mSwitchTransformationMethod;
    private int mSwitchWidth;
    private final Rect mTempRect;
    private TextPaint mTextPaint;
    private StrokeGradientDrawable mThumbDrawable;
    private ColorStateList mThumbOffColor;
    private ColorStateList mThumbOnColor;
    /* access modifiers changed from: private */
    public float mThumbPosition;
    private SpringAnimation mThumbSpringAnim;
    private int mThumbWidth;
    private int mTouchMode;
    private int mTouchSlop;
    private float mTouchX;
    private float mTouchY;
    private Drawable mTrackDrawable;
    private ColorStateList mTrackOffColorState;
    private ColorStateList mTrackOnColorState;
    private int mUiNightMode;
    private VelocityTracker mVelocityTracker;
    public CharSequence switchOff;
    public CharSequence switchOn;

    public Switch(Context context) {
        this(context, (AttributeSet) null);
    }

    private void animateThumbToCheckedState(boolean z) {
        float f = z ? 1.0f : 0.0f;
        cancelThumbSpringAnimator();
        if (this.mThumbSpringAnim == null) {
            this.mThumbSpringAnim = new SpringAnimation(this, THUMB_POSITION);
        }
        SpringForce springForce = new SpringForce();
        springForce.f(STIFFNESS_DEFAULT).d(z ? this.mCheckOnDamping : this.mCheckOffDamping).e(f);
        this.mThumbSpringAnim.l(0.00390625f);
        this.mThumbSpringAnim.y(springForce);
        this.mThumbSpringAnim.q();
    }

    private void cancelSuperTouch(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        super.onTouchEvent(obtain);
        obtain.recycle();
    }

    private void cancelThumbSpringAnimator() {
        SpringAnimation springAnimation = this.mThumbSpringAnim;
        if (springAnimation != null && springAnimation.h()) {
            this.mThumbSpringAnim.d();
        }
    }

    private StrokeGradientDrawable createDrawable(int i, int i2) {
        StrokeGradientDrawable strokeGradientDrawable = new StrokeGradientDrawable(new GradientDrawable());
        strokeGradientDrawable.getGradientDrawable().setShape(0);
        strokeGradientDrawable.setPaddingLeft(i);
        strokeGradientDrawable.setPaddingRight(i2);
        return strokeGradientDrawable;
    }

    private int getColorFromState(ColorStateList colorStateList) {
        return isEnabled() ? getNormalColor(colorStateList) : getDisabledColor(colorStateList);
    }

    private int getDisabledColor(ColorStateList colorStateList) {
        return colorStateList.getColorForState(new int[]{-16842910}, 0);
    }

    private int getNormalColor(ColorStateList colorStateList) {
        return colorStateList.getColorForState(new int[]{16842910}, 0);
    }

    private boolean getTargetCheckedState() {
        return this.mThumbPosition > 0.5f;
    }

    private int getThumbAlphaValue(float f, float f2, boolean z) {
        return z ? (int) (f * 255.0f) : (int) (f2 * 255.0f);
    }

    private int getThumbColorValue(int i, int i2, float f) {
        return ArgbEvaluatorCompat.getInstance().evaluate(f, Integer.valueOf(i), Integer.valueOf(i2)).intValue();
    }

    private int getThumbOffset() {
        return (int) ((getThumbValue() * ((float) getThumbScrollRange())) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.mTrackDrawable;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.mTempRect;
        drawable.getPadding(rect);
        Insets of = this.mThumbDrawable.getGradientDrawable() != null ? Insets.of(this.mThumbDrawable.getPaddingLeft(), 0, this.mThumbDrawable.getPaddingRight(), 0) : Insets.NONE;
        return ((((this.mSwitchWidth - this.mThumbWidth) - rect.left) - rect.right) - of.left) - of.right;
    }

    private float getThumbValue() {
        return this.mThumbPosition;
    }

    private boolean hitThumb(float f, float f2) {
        return f > ((float) this.mSwitchLeft) && f < ((float) this.mSwitchRight) && f2 > ((float) this.mSwitchTop) && f2 < ((float) this.mSwitchBottom);
    }

    private boolean isThumbOff() {
        return this.mThumbPosition == 0.0f;
    }

    private boolean isThumbOn() {
        return this.mThumbPosition == 1.0f;
    }

    private Layout makeLayout(CharSequence charSequence) {
        TransformationMethod2 transformationMethod2 = this.mSwitchTransformationMethod;
        if (transformationMethod2 != null) {
            charSequence = transformationMethod2.getTransformation(charSequence, this);
        }
        CharSequence charSequence2 = charSequence;
        TextPaint textPaint = new TextPaint(1);
        this.mTextPaint = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        TextPaint textPaint2 = this.mTextPaint;
        return new StaticLayout(charSequence2, textPaint2, (int) Math.ceil((double) Layout.getDesiredWidth(charSequence2, textPaint2)), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    private void refreshAndGetTrackRes() {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(this.mAttributeSet, R.styleable.Switch, R.attr.MeizuCommon_Switch, R.style.Widget_MeizuCommon_Switch);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.Switch_mcTrack);
        this.mTrackDrawable = drawable;
        if (drawable == null) {
            this.mTrackDrawable = getResources().getDrawable(R.drawable.mc_switch_anim_track);
        }
        ColorStateList colorStateList = this.mCustomTrackOnColorState;
        if (colorStateList != null) {
            this.mTrackOnColorState = colorStateList;
        } else {
            ColorStateList colorStateList2 = obtainStyledAttributes.getColorStateList(R.styleable.Switch_mcTrackOnColor);
            this.mTrackOnColorState = colorStateList2;
            if (colorStateList2 == null) {
                this.mTrackOnColorState = getResources().getColorStateList(R.color.mz_btn_color_state);
            }
        }
        ColorStateList colorStateList3 = this.mCustomTrackOffColorState;
        if (colorStateList3 != null) {
            this.mTrackOffColorState = colorStateList3;
        } else {
            ColorStateList colorStateList4 = obtainStyledAttributes.getColorStateList(R.styleable.Switch_mcTrackOffColor);
            this.mTrackOffColorState = colorStateList4;
            if (colorStateList4 == null) {
                this.mTrackOffColorState = getResources().getColorStateList(R.color.mz_switch_track_off_color);
            }
        }
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            drawable2.setCallback(this);
        }
        MorphingParams morphingParams = this.mParams;
        if (morphingParams != null) {
            morphingParams.color(this.mThumbOffColor, this.mThumbOnColor);
            setThumbPosition(this.mThumbPosition);
        }
        obtainStyledAttributes.recycle();
        refreshDrawableState();
    }

    private void setCheckOffDamping(float f) {
        this.mCheckOffDamping = f;
    }

    private void setCheckOnDamping(float f) {
        this.mCheckOnDamping = f;
    }

    /* access modifiers changed from: private */
    public void setThumbPosition(float f) {
        this.mThumbPosition = f;
        float max = f < 0.0f ? Math.max(f, 0.0f) : Math.min(f, 1.0f);
        MorphingParams morphingParams = this.mParams;
        if (morphingParams != null) {
            this.mThumbDrawable.setWidth(morphingParams.width);
            this.mThumbDrawable.setHeight(this.mParams.height);
            this.mThumbDrawable.setCornerRadius(this.mParams.cornerRadius);
            int thumbColorValue = getThumbColorValue(getColorFromState(this.mParams.fromColor), getColorFromState(this.mParams.toColor), max);
            StrokeGradientDrawable strokeGradientDrawable = this.mThumbDrawable;
            MorphingParams morphingParams2 = this.mParams;
            strokeGradientDrawable.setAlpha(getThumbAlphaValue(morphingParams2.fromAlpha, morphingParams2.toAlpha, isEnabled()));
            this.mThumbDrawable.setColor(thumbColorValue);
            int thumbColorValue2 = getThumbColorValue(getColorFromState(this.mTrackOffColorState), getColorFromState(this.mTrackOnColorState), max);
            if (!this.mIsHighContrastModeOn || !isChecked()) {
                this.mTrackDrawable.setColorFilter(thumbColorValue2, PorterDuff.Mode.SRC_IN);
            } else if (ScreenUtil.haveSaturation(thumbColorValue2)) {
                this.mTrackDrawable.setColorFilter(thumbColorValue2, PorterDuff.Mode.SRC_IN);
            }
        }
        invalidate();
    }

    private void stopDrag(MotionEvent motionEvent) {
        this.mTouchMode = 0;
        boolean z = true;
        if (motionEvent.getAction() != 1 || !isEnabled()) {
            z = isChecked();
        } else {
            this.mVelocityTracker.computeCurrentVelocity(1000);
            float xVelocity = this.mVelocityTracker.getXVelocity();
            if (Math.abs(xVelocity) <= ((float) this.mMinFlingVelocity)) {
                z = getTargetCheckedState();
            } else if (!isLayoutRtl() ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
                z = false;
            }
        }
        setCheckedWithHapticFeedback(z, false);
        cancelSuperTouch(motionEvent);
    }

    public void draw(Canvas canvas) {
        int paddingLeft;
        int width;
        int height;
        int height2;
        int i;
        int i2;
        Rect rect = this.mTempRect;
        int i3 = this.mSwitchLeft;
        int i4 = this.mSwitchTop;
        int i5 = this.mSwitchRight;
        int i6 = this.mSwitchBottom;
        int thumbOffset = getThumbOffset() + i3;
        Insets insets = this.mThumbDrawable != null ? Insets.NONE : Insets.NONE;
        Drawable drawable = this.mTrackDrawable;
        if (drawable != null) {
            drawable.getPadding(rect);
            int i7 = rect.left;
            thumbOffset += i7;
            if (insets != Insets.NONE) {
                int i8 = insets.left;
                if (i8 > i7) {
                    i3 += i8 - i7;
                }
                int i9 = insets.f9496top;
                int i10 = rect.top;
                i2 = i9 > i10 ? (i9 - i10) + i4 : i4;
                int i11 = insets.right;
                int i12 = rect.right;
                i = i11 > i12 ? i5 - (i11 - i12) : i5;
                int i13 = insets.bottom;
                int i14 = rect.bottom;
                if (i13 > i14) {
                    i6 -= i13 - i14;
                }
            } else {
                i2 = i4;
                i = i5;
            }
            this.mTrackDrawable.setBounds(i3, i2, i, i6);
        }
        StrokeGradientDrawable strokeGradientDrawable = this.mThumbDrawable;
        if (strokeGradientDrawable != null) {
            strokeGradientDrawable.getGradientDrawable().getPadding(rect);
            if (isLayoutRtl()) {
                width = (i5 - getThumbOffset()) - this.mThumbDrawable.getPaddingLeft();
                paddingLeft = width - this.mThumbDrawable.getWidth();
                height = i4 + ((this.mSwitchHeight - this.mThumbDrawable.getHeight()) / 2);
                height2 = this.mThumbDrawable.getHeight();
            } else {
                paddingLeft = this.mThumbDrawable.getPaddingLeft() + thumbOffset;
                width = paddingLeft + this.mThumbDrawable.getWidth();
                height = i4 + ((this.mSwitchHeight - this.mThumbDrawable.getHeight()) / 2);
                height2 = this.mThumbDrawable.getHeight();
            }
            this.mThumbDrawable.getGradientDrawable().setBounds(paddingLeft, height, width, height2 + height);
        }
        ColorStateList colorStateList = this.mCustomTrackOffColorState;
        if (colorStateList != null) {
            this.mTrackOffColorState = colorStateList;
        }
        ColorStateList colorStateList2 = this.mCustomTrackOnColorState;
        if (colorStateList2 != null) {
            this.mTrackOnColorState = colorStateList2;
        }
        super.draw(canvas);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        StrokeGradientDrawable strokeGradientDrawable = this.mThumbDrawable;
        if (!(strokeGradientDrawable == null || strokeGradientDrawable.getGradientDrawable() == null)) {
            this.mThumbDrawable.getGradientDrawable().setState(drawableState);
        }
        Drawable drawable = this.mTrackDrawable;
        if (drawable != null) {
            drawable.setState(drawableState);
        }
        setThumbPosition(this.mThumbPosition);
        invalidate();
    }

    public int getCompoundPaddingLeft() {
        if (!isLayoutRtl()) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.mSwitchWidth;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.mSwitchPadding : compoundPaddingLeft;
    }

    public int getCompoundPaddingRight() {
        if (isLayoutRtl()) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.mSwitchWidth;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.mSwitchPadding : compoundPaddingRight;
    }

    public int getSwitchMinWidth() {
        return this.mSwitchMinWidth;
    }

    public int getSwitchPadding() {
        return this.mSwitchPadding;
    }

    public Drawable getTrackDrawable() {
        return this.mTrackDrawable;
    }

    public boolean isLaidOut() {
        return getWidth() > 0 && getHeight() > 0;
    }

    public boolean isLayoutRtl() {
        return getLayoutDirection() == 1;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        StrokeGradientDrawable strokeGradientDrawable = this.mThumbDrawable;
        if (!(strokeGradientDrawable == null || strokeGradientDrawable.getGradientDrawable() == null)) {
            this.mThumbDrawable.getGradientDrawable().jumpToCurrentState();
        }
        Drawable drawable = this.mTrackDrawable;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        SpringAnimation springAnimation = this.mThumbSpringAnim;
        if (springAnimation != null && springAnimation.h() && this.mThumbSpringAnim.u()) {
            this.mThumbSpringAnim.z();
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        refreshAndGetTrackRes();
        this.mThumbDrawable.getGradientDrawable().setCallback(this);
        invalidate();
    }

    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, CHECKED_STATE_SET);
        }
        return onCreateDrawableState;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect rect = this.mTempRect;
        Drawable drawable = this.mTrackDrawable;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        GradientDrawable gradientDrawable = this.mThumbDrawable.getGradientDrawable();
        if (drawable != null) {
            if (!this.mSplitTrack || gradientDrawable == null) {
                drawable.draw(canvas);
            } else {
                Insets insets = Insets.NONE;
                gradientDrawable.copyBounds(rect);
                rect.left += insets.left;
                rect.right -= insets.right;
                int save = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        int save2 = canvas.save();
        if (gradientDrawable != null) {
            gradientDrawable.draw(canvas);
        }
        canvas.restoreToCount(save2);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Switch.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Switch.class.getName());
        CharSequence charSequence = isChecked() ? this.switchOn : this.switchOff;
        if (!TextUtils.isEmpty(charSequence)) {
            CharSequence text = accessibilityNodeInfo.getText();
            if (TextUtils.isEmpty(text)) {
                accessibilityNodeInfo.setText(charSequence);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(text);
            sb.append(' ');
            sb.append(charSequence);
            accessibilityNodeInfo.setText(sb);
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        super.onLayout(z, i, i2, i3, i4);
        int i11 = 0;
        if (this.mThumbDrawable != null) {
            Rect rect = this.mTempRect;
            Drawable drawable = this.mTrackDrawable;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Insets insets = Insets.NONE;
            i5 = Math.max(0, insets.left - rect.left);
            i11 = Math.max(0, insets.right - rect.right);
        } else {
            i5 = 0;
        }
        if (isLayoutRtl()) {
            i7 = getPaddingLeft() + i5;
            i6 = ((this.mSwitchWidth + i7) - i5) - i11;
        } else {
            i6 = (getWidth() - getPaddingRight()) - i11;
            i7 = (i6 - this.mSwitchWidth) + i5 + i11;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            i10 = this.mSwitchHeight;
            i9 = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (i10 / 2);
        } else if (gravity != 80) {
            i9 = getPaddingTop();
            i10 = this.mSwitchHeight;
        } else {
            i8 = getHeight() - getPaddingBottom();
            i9 = i8 - this.mSwitchHeight;
            this.mSwitchLeft = i7;
            this.mSwitchTop = i9;
            this.mSwitchBottom = i8;
            this.mSwitchRight = i6;
        }
        i8 = i10 + i9;
        this.mSwitchLeft = i7;
        this.mSwitchTop = i9;
        this.mSwitchBottom = i8;
        this.mSwitchRight = i6;
    }

    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        Rect rect = this.mTempRect;
        StrokeGradientDrawable strokeGradientDrawable = this.mThumbDrawable;
        if (strokeGradientDrawable != null) {
            strokeGradientDrawable.getGradientDrawable().getPadding(rect);
            i4 = Math.max((this.mThumbDrawable.getGradientDrawable().getIntrinsicWidth() - rect.left) - rect.right, this.mParams.width);
            i3 = this.mThumbDrawable.getGradientDrawable().getIntrinsicHeight();
        } else {
            i4 = 0;
            i3 = 0;
        }
        this.mThumbWidth = i4;
        Drawable drawable = this.mTrackDrawable;
        if (drawable != null) {
            drawable.getPadding(rect);
            i5 = this.mTrackDrawable.getIntrinsicHeight();
        } else {
            rect.setEmpty();
            i5 = 0;
        }
        int i6 = rect.left;
        int i7 = rect.right;
        Insets insets = Insets.NONE;
        if (this.mThumbDrawable != null) {
            i6 = Math.max(i6, 0);
            i7 = Math.max(i7, 0);
            insets = Insets.of(this.mThumbDrawable.getPaddingLeft(), 0, this.mThumbDrawable.getPaddingRight(), 0);
        }
        int max = Math.max(this.mSwitchMinWidth, (this.mThumbWidth * 2) + i6 + i7 + insets.left + insets.right);
        int max2 = Math.max(i5, i3);
        this.mSwitchWidth = max;
        this.mSwitchHeight = max2;
        super.onMeasure(i, i2);
        if (getMeasuredHeight() < max2) {
            setMeasuredDimension(getMeasuredWidthAndState(), max2);
        }
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        if (r0 != 3) goto L_0x00b7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            android.view.VelocityTracker r0 = r6.mVelocityTracker
            r0.addMovement(r7)
            int r0 = r7.getActionMasked()
            r1 = 1
            if (r0 == 0) goto L_0x009d
            r2 = 2
            if (r0 == r1) goto L_0x0089
            if (r0 == r2) goto L_0x0016
            r3 = 3
            if (r0 == r3) goto L_0x0089
            goto L_0x00b7
        L_0x0016:
            int r0 = r6.mTouchMode
            if (r0 == r1) goto L_0x0055
            if (r0 == r2) goto L_0x001e
            goto L_0x00b7
        L_0x001e:
            float r7 = r7.getX()
            int r0 = r6.getThumbScrollRange()
            float r2 = r6.mTouchX
            float r2 = r7 - r2
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            if (r0 == 0) goto L_0x0032
            float r0 = (float) r0
            float r2 = r2 / r0
            goto L_0x003b
        L_0x0032:
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0038
            r2 = r3
            goto L_0x003b
        L_0x0038:
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r2 = r0
        L_0x003b:
            boolean r0 = r6.isLayoutRtl()
            if (r0 == 0) goto L_0x0042
            float r2 = -r2
        L_0x0042:
            float r0 = r6.mThumbPosition
            float r0 = r0 + r2
            float r0 = com.meizu.common.widget.MathUtils.constrain(r0, r4, r3)
            float r2 = r6.mThumbPosition
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x0054
            r6.mTouchX = r7
            r6.setThumbPosition(r0)
        L_0x0054:
            return r1
        L_0x0055:
            float r0 = r7.getX()
            float r3 = r7.getY()
            float r4 = r6.mTouchX
            float r4 = r0 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.mTouchSlop
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L_0x007b
            float r4 = r6.mTouchY
            float r4 = r3 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.mTouchSlop
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x00b7
        L_0x007b:
            r6.mTouchMode = r2
            android.view.ViewParent r7 = r6.getParent()
            r7.requestDisallowInterceptTouchEvent(r1)
            r6.mTouchX = r0
            r6.mTouchY = r3
            return r1
        L_0x0089:
            int r0 = r6.mTouchMode
            if (r0 != r2) goto L_0x0094
            r6.stopDrag(r7)
            super.onTouchEvent(r7)
            return r1
        L_0x0094:
            r0 = 0
            r6.mTouchMode = r0
            android.view.VelocityTracker r0 = r6.mVelocityTracker
            r0.clear()
            goto L_0x00b7
        L_0x009d:
            float r0 = r7.getX()
            float r2 = r7.getY()
            boolean r3 = r6.isEnabled()
            if (r3 == 0) goto L_0x00b7
            boolean r3 = r6.hitThumb(r0, r2)
            if (r3 == 0) goto L_0x00b7
            r6.mTouchMode = r1
            r6.mTouchX = r0
            r6.mTouchY = r2
        L_0x00b7:
            boolean r6 = super.onTouchEvent(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.Switch.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.mIsHighContrastModeOn = ScreenUtil.isFlymeHighContrastOn(getContext());
        }
    }

    public void performHapticFeedback() {
        try {
            if (CommonUtils.hasFlymeFeature()) {
                performHapticFeedback(FLYME_SLIDE_HORIZONTAL);
                return;
            }
            Vibrator vibrator = (Vibrator) getContext().getSystemService("vibrator");
            if (ContextCompat.checkSelfPermission(getContext(), "android.permission.VIBRATE") != 0) {
                Log.d(TAG, "permission not declared");
            } else if ("m2421".equalsIgnoreCase(CommonUtils.getDeviceName())) {
                vibrator.vibrate(VibrationEffect.createOneShot(45, -1));
                Log.d(TAG, " m2421  VibrationEffect");
            } else {
                vibrator.vibrate(VibrationEffect.createOneShot(5, -1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setChecked(boolean z) {
        setChecked(z, true);
    }

    public void setCheckedWithHapticFeedback(boolean z, boolean z2) {
        if (isChecked() != z) {
            performHapticFeedback();
        }
        setChecked(z, z2);
    }

    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        super.setCompoundDrawablesWithIntrinsicBounds(i, i2, i3, i4);
    }

    public void setDarkTrackOffColor(ColorStateList colorStateList) {
        this.mCustomDarkTrackOffColorState = colorStateList;
        invalidate();
    }

    public void setDarkTrackOnColor(ColorStateList colorStateList) {
        this.mCustomDarkTrackOnColorState = colorStateList;
        invalidate();
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
    }

    public void setSwitchMinWidth(int i) {
        this.mSwitchMinWidth = i;
        requestLayout();
    }

    public void setSwitchPadding(int i) {
        this.mSwitchPadding = i;
        requestLayout();
    }

    public void setThumbOffColor(ColorStateList colorStateList) {
        this.mThumbOffColor = colorStateList;
        MorphingParams morphingParams = this.mParams;
        if (morphingParams != null) {
            morphingParams.color(colorStateList, this.mThumbOnColor);
            setThumbPosition(this.mThumbPosition);
        }
        invalidate();
    }

    public void setThumbOnColor(ColorStateList colorStateList) {
        this.mThumbOnColor = colorStateList;
        MorphingParams morphingParams = this.mParams;
        if (morphingParams != null) {
            morphingParams.color(this.mThumbOffColor, colorStateList);
            setThumbPosition(this.mThumbPosition);
        }
        invalidate();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.mTrackDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            drawableStateChanged();
        }
        requestLayout();
    }

    public void setTrackOffColor(ColorStateList colorStateList) {
        this.mCustomTrackOffColorState = colorStateList;
        invalidate();
    }

    public void setTrackOnColor(ColorStateList colorStateList) {
        this.mCustomTrackOnColorState = colorStateList;
        invalidate();
    }

    public void setTrackResource(int i) {
        setTrackDrawable(getContext().getResources().getDrawable(i));
    }

    public void toggle() {
        setCheckedWithHapticFeedback(!isChecked());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r1.mThumbDrawable;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean verifyDrawable(android.graphics.drawable.Drawable r2) {
        /*
            r1 = this;
            boolean r0 = super.verifyDrawable(r2)
            if (r0 != 0) goto L_0x0017
            com.meizu.common.widget.StrokeGradientDrawable r0 = r1.mThumbDrawable
            if (r0 == 0) goto L_0x0010
            android.graphics.drawable.GradientDrawable r0 = r0.getGradientDrawable()
            if (r2 == r0) goto L_0x0017
        L_0x0010:
            android.graphics.drawable.Drawable r1 = r1.mTrackDrawable
            if (r2 != r1) goto L_0x0015
            goto L_0x0017
        L_0x0015:
            r1 = 0
            goto L_0x0018
        L_0x0017:
            r1 = 1
        L_0x0018:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.Switch.verifyDrawable(android.graphics.drawable.Drawable):boolean");
    }

    public Switch(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.MeizuCommon_Switch);
    }

    public void setChecked(boolean z, boolean z2) {
        float f = 0.0f;
        if (isChecked() == z) {
            SpringAnimation springAnimation = this.mThumbSpringAnim;
            if (springAnimation == null || !springAnimation.h()) {
                if (z) {
                    f = 1.0f;
                }
                setThumbPosition(f);
                return;
            }
            return;
        }
        super.setChecked(z);
        boolean isChecked = isChecked();
        if (!z2 || !isAttachedToWindow() || !isLaidOut()) {
            cancelThumbSpringAnimator();
            if (isChecked) {
                f = 1.0f;
            }
            setThumbPosition(f);
            return;
        }
        animateThumbToCheckedState(isChecked);
    }

    public Switch(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isChanged = false;
        this.mVelocityTracker = VelocityTracker.obtain();
        this.mTempRect = new Rect();
        this.mIgnoreSystemNightMode = false;
        this.mCheckOnDamping = DAMPING_CHECK_ON_DEFAULT;
        this.mCheckOffDamping = DAMPING_CHECK_OFF_DEFAULT;
        CommonUtils.disableDarkMode(this);
        this.mAttributeSet = attributeSet;
        this.mTextPaint = new TextPaint(1);
        Resources resources = getResources();
        this.mTextPaint.density = resources.getDisplayMetrics().density;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Switch, i, R.style.Widget_MeizuCommon_Switch);
        this.mIgnoreSystemNightMode = obtainStyledAttributes.getBoolean(R.styleable.Switch_mcIgnoreSysNightMode, false);
        this.mTrackDrawable = obtainStyledAttributes.getDrawable(R.styleable.Switch_mcTrack);
        this.mThumbDrawable = createDrawable(getResources().getDimensionPixelOffset(R.dimen.mz_switch_thumb_padding_left), getResources().getDimensionPixelOffset(R.dimen.mz_switch_thumb_padding_right));
        refreshAndGetTrackRes();
        Drawable drawable = this.mTrackDrawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        this.mSwitchMinWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Switch_mcSwitchMinWidth, 0);
        this.mSwitchPadding = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Switch_mcSwitchPadding, 48);
        this.mSplitTrack = false;
        this.mThumbOnColor = obtainStyledAttributes.getColorStateList(R.styleable.Switch_mcThumbOnColor);
        this.mThumbOffColor = obtainStyledAttributes.getColorStateList(R.styleable.Switch_mcThumbOffColor);
        obtainStyledAttributes.recycle();
        int[] iArr = {16843044, 16843045};
        sSwitchStyleableId = iArr;
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr, 16843839, 0);
        this.switchOn = obtainStyledAttributes2.getText(0);
        this.switchOff = obtainStyledAttributes2.getText(1);
        obtainStyledAttributes2.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        MorphingParams create = MorphingParams.create(this.mThumbDrawable);
        this.mParams = create;
        create.color(this.mThumbOffColor, this.mThumbOnColor).height(getResources().getDimensionPixelOffset(R.dimen.mz_switch_thumb_to_height)).width(getResources().getDimensionPixelOffset(R.dimen.mz_switch_thumb_to_width)).cornerRadius(getResources().getDimensionPixelOffset(R.dimen.mz_switch_thumb_to_corner_radius)).alpha(1.0f, 1.0f);
        this.mThumbDrawable.getGradientDrawable().setCallback(this);
        refreshDrawableState();
        setChecked(isChecked());
        setForceDarkAllowed(false);
    }

    public void setTrackOffColor(int i) {
        setTrackOffColor(getContext().getResources().getColorStateList(i));
        setDarkTrackOffColor(getContext().getResources().getColorStateList(i));
    }

    public void setTrackOnColor(int i) {
        setTrackOnColor(getContext().getResources().getColorStateList(i));
        setDarkTrackOnColor(getContext().getResources().getColorStateList(i));
    }

    public void setCheckedWithHapticFeedback(boolean z) {
        setCheckedWithHapticFeedback(z, true);
    }
}
