package com.meizu.common.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.StateSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.Button;
import android.widget.TextView;
import com.meizu.common.R;
import com.meizu.common.animator.MzPressAnimationHelper;
import com.meizu.common.drawble.CircularAnimatedDrawable;
import com.meizu.common.drawble.CircularProgressDrawable;
import com.meizu.common.drawble.StrokeGradientDrawable;
import com.meizu.common.util.ResourceUtils;

public class CircularProgressButton extends Button {
    private static final int CRITICAL_WIDTH = 80;
    public static final int ERROR_STATE_PROGRESS = -1;
    public static final int IDLE_STATE_PROGRESS = 0;
    private static final float MAX_PADDING = 12.0f;
    private static final int MAX_WIDTH = 100;
    private static final float MIN_PADDING = 8.0f;
    private static final int MIN_WIDTH = 48;
    private static final float PADDING_AUTO_FIT_BASELINE = 90.0f;
    private static int PROGRESS_ANIMATION_DURATION = 800;
    /* access modifiers changed from: private */
    public int mAnimCurrentProgress;
    private CircularAnimatedDrawable mAnimatedDrawable;
    private boolean mAutoFitPadding;
    private StrokeGradientDrawable mBackground;
    private int mColorIndicator;
    private int mColorIndicatorBackground;
    private int mColorProgress;
    private ColorStateList mCompleteColorState;
    private StateListDrawable mCompleteStateDrawable;
    private OnAnimationEndListener mCompleteStateListener;
    /* access modifiers changed from: private */
    public String mCompleteText;
    private boolean mConfigurationChanged;
    private float mCornerRadius;
    private StateListDrawable mCurrentStateDrawable;
    private ColorStateList mErrorColorState;
    private StateListDrawable mErrorStateDrawable;
    private OnAnimationEndListener mErrorStateListener;
    /* access modifiers changed from: private */
    public String mErrorText;
    /* access modifiers changed from: private */
    public int mIconComplete;
    /* access modifiers changed from: private */
    public int mIconError;
    private ColorStateList mIdleColorState;
    private StateListDrawable mIdleStateDrawable;
    private OnAnimationEndListener mIdleStateListener;
    /* access modifiers changed from: private */
    public String mIdleText;
    private boolean mIndeterminateProgressMode;
    /* access modifiers changed from: private */
    public boolean mIsCycle;
    /* access modifiers changed from: private */
    public boolean mIsFirstTime;
    private boolean mIsUseTransitionAnim;
    private int mMaxProgress;
    private MorphingAnimation mMorphingAnimation;
    /* access modifiers changed from: private */
    public boolean mMorphingInProgress;
    private boolean mNeedInvalidateCenterIcon;
    private int mOrginWidth;
    private int mPaddingProgress;
    private int mProgress;
    private ValueAnimator mProgressAnimation;
    private Drawable mProgressCenterIcon;
    private CircularProgressDrawable mProgressDrawable;
    private StateListDrawable mProgressStateDrawable;
    private OnAnimationEndListener mProgressStateListener;
    private int mProgressStrokeWidth;
    private String mProgressText;
    private int mProgressWidth;
    private boolean mShouldShowCenterIcon;
    private boolean mShouldUpdateBounds;
    private State mState;
    private ColorStateList mStrokeColorComplete;
    private ColorStateList mStrokeColorError;
    private ColorStateList mStrokeColorIdle;
    private int mStrokeWidth;
    /* access modifiers changed from: private */
    public ColorStateList mTextColorComplete;
    /* access modifiers changed from: private */
    public ColorStateList mTextColorError;
    /* access modifiers changed from: private */
    public ColorStateList mTextColorIdle;

    /* renamed from: com.meizu.common.widget.CircularProgressButton$9  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass9 {
        static final /* synthetic */ int[] $SwitchMap$com$meizu$common$widget$CircularProgressButton$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.meizu.common.widget.CircularProgressButton$State[] r0 = com.meizu.common.widget.CircularProgressButton.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$meizu$common$widget$CircularProgressButton$State = r0
                com.meizu.common.widget.CircularProgressButton$State r1 = com.meizu.common.widget.CircularProgressButton.State.COMPLETE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$meizu$common$widget$CircularProgressButton$State     // Catch:{ NoSuchFieldError -> 0x001d }
                com.meizu.common.widget.CircularProgressButton$State r1 = com.meizu.common.widget.CircularProgressButton.State.ERROR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$meizu$common$widget$CircularProgressButton$State     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.meizu.common.widget.CircularProgressButton$State r1 = com.meizu.common.widget.CircularProgressButton.State.PROGRESS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$meizu$common$widget$CircularProgressButton$State     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.meizu.common.widget.CircularProgressButton$State r1 = com.meizu.common.widget.CircularProgressButton.State.IDLE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.CircularProgressButton.AnonymousClass9.<clinit>():void");
        }
    }

    public class MorphingAnimation {
        public static final int DURATION_INSTANT = 1;
        public static final int DURATION_NORMAL = 240;
        private AnimatorSet mAnimSet;
        private StrokeGradientDrawable mDrawable;
        private int mDuration;
        private int mFromColor;
        private float mFromCornerRadius;
        private int mFromStrokeColor;
        private int mFromStrokeWidth;
        /* access modifiers changed from: private */
        public int mFromWidth;
        /* access modifiers changed from: private */
        public OnAnimationEndListener mListener;
        /* access modifiers changed from: private */
        public float mPadding;
        private int mToColor;
        private float mToCornerRadius;
        private int mToStrokeColor;
        private int mToStrokeWidth;
        /* access modifiers changed from: private */
        public int mToWidth;
        /* access modifiers changed from: private */
        public TextView mView;

        public MorphingAnimation(TextView textView, StrokeGradientDrawable strokeGradientDrawable) {
            this.mView = textView;
            this.mDrawable = strokeGradientDrawable;
        }

        public void cancelAllAnim() {
            this.mAnimSet.end();
            this.mAnimSet.removeAllListeners();
        }

        public void colorMorphingStart() {
            ObjectAnimator ofInt = ObjectAnimator.ofInt(this.mDrawable.getGradientDrawable(), "color", new int[]{this.mFromColor, this.mToColor});
            ofInt.setEvaluator(new ArgbEvaluator());
            ObjectAnimator ofInt2 = ObjectAnimator.ofInt(this.mDrawable, "strokeColor", new int[]{this.mFromStrokeColor, this.mToStrokeColor});
            ofInt2.setEvaluator(new ArgbEvaluator());
            AnimatorSet animatorSet = new AnimatorSet();
            this.mAnimSet = animatorSet;
            animatorSet.setInterpolator(CircularProgressButton.this.getInterpolator());
            this.mAnimSet.setDuration((long) this.mDuration);
            this.mAnimSet.playTogether(new Animator[]{ofInt, ofInt2});
            this.mAnimSet.addListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    if (MorphingAnimation.this.mListener != null) {
                        MorphingAnimation.this.mListener.onAnimationEnd();
                    }
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }
            });
            this.mAnimSet.start();
        }

        public void setDuration(int i) {
            this.mDuration = i;
        }

        public void setFromColor(int i) {
            this.mFromColor = i;
        }

        public void setFromCornerRadius(float f) {
            this.mFromCornerRadius = f;
        }

        public void setFromStrokeColor(int i) {
            this.mFromStrokeColor = i;
        }

        public void setFromStrokeWidth(int i) {
            this.mFromStrokeWidth = i;
        }

        public void setFromWidth(int i) {
            this.mFromWidth = i;
        }

        public void setListener(OnAnimationEndListener onAnimationEndListener) {
            this.mListener = onAnimationEndListener;
        }

        public void setPadding(float f) {
            this.mPadding = f;
        }

        public void setToColor(int i) {
            this.mToColor = i;
        }

        public void setToCornerRadius(float f) {
            this.mToCornerRadius = f;
        }

        public void setToStrokeColor(int i) {
            this.mToStrokeColor = i;
        }

        public void setToStrokeWidth(int i) {
            this.mToStrokeWidth = i;
        }

        public void setToWidth(int i) {
            this.mToWidth = i;
        }

        public void start() {
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.mFromWidth, this.mToWidth});
            final GradientDrawable gradientDrawable = this.mDrawable.getGradientDrawable();
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int access$1800;
                    int access$18002;
                    float access$1900;
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    if (MorphingAnimation.this.mFromWidth > MorphingAnimation.this.mToWidth) {
                        access$1800 = (MorphingAnimation.this.mFromWidth - num.intValue()) / 2;
                        access$18002 = MorphingAnimation.this.mFromWidth - access$1800;
                        access$1900 = MorphingAnimation.this.mPadding * valueAnimator.getAnimatedFraction();
                    } else {
                        access$1800 = (MorphingAnimation.this.mToWidth - num.intValue()) / 2;
                        access$18002 = MorphingAnimation.this.mToWidth - access$1800;
                        access$1900 = MorphingAnimation.this.mPadding - (MorphingAnimation.this.mPadding * valueAnimator.getAnimatedFraction());
                    }
                    int i = (int) access$1900;
                    gradientDrawable.setBounds(access$1800 + i, i, (access$18002 - i) - 1, (MorphingAnimation.this.mView.getHeight() - i) - 1);
                    CircularProgressButton.this.invalidate();
                }
            });
            ObjectAnimator ofInt2 = ObjectAnimator.ofInt(gradientDrawable, "color", new int[]{this.mFromColor, this.mToColor});
            ofInt2.setEvaluator(new ArgbEvaluator());
            ObjectAnimator ofInt3 = ObjectAnimator.ofInt(this.mDrawable, "strokeColor", new int[]{this.mFromStrokeColor, this.mToStrokeColor});
            ofInt3.setEvaluator(new ArgbEvaluator());
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(gradientDrawable, "cornerRadius", new float[]{this.mFromCornerRadius, this.mToCornerRadius});
            ObjectAnimator ofInt4 = ObjectAnimator.ofInt(this.mDrawable, "strokeWidth", new int[]{this.mFromStrokeWidth, this.mToStrokeWidth});
            AnimatorSet animatorSet = new AnimatorSet();
            this.mAnimSet = animatorSet;
            animatorSet.setInterpolator(CircularProgressButton.this.getInterpolator());
            this.mAnimSet.setDuration((long) this.mDuration);
            this.mAnimSet.playTogether(new Animator[]{ofInt, ofInt2, ofInt3, ofFloat, ofInt4});
            this.mAnimSet.addListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    if (MorphingAnimation.this.mListener != null) {
                        MorphingAnimation.this.mListener.onAnimationEnd();
                    }
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }
            });
            this.mAnimSet.start();
        }
    }

    public interface OnAnimationEndListener {
        void onAnimationEnd();
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        /* access modifiers changed from: private */
        public boolean mConfigurationChanged;
        /* access modifiers changed from: private */
        public boolean mIndeterminateProgressMode;
        /* access modifiers changed from: private */
        public int mProgress;

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.mProgress);
            parcel.writeInt(this.mIndeterminateProgressMode ? 1 : 0);
            parcel.writeInt(this.mConfigurationChanged ? 1 : 0);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mProgress = parcel.readInt();
            boolean z = false;
            this.mIndeterminateProgressMode = parcel.readInt() == 1;
            this.mConfigurationChanged = parcel.readInt() == 1 ? true : z;
        }
    }

    public enum State {
        PROGRESS,
        IDLE,
        COMPLETE,
        ERROR
    }

    public class StateManager {
        private boolean mIsEnabled;
        private int mProgress;

        public StateManager(CircularProgressButton circularProgressButton) {
            this.mIsEnabled = circularProgressButton.isEnabled();
            this.mProgress = circularProgressButton.getProgress();
        }

        public void checkState(CircularProgressButton circularProgressButton) {
            if (circularProgressButton.getProgress() != getProgress()) {
                circularProgressButton.setProgress(circularProgressButton.getProgress());
            } else if (circularProgressButton.isEnabled() != isEnabled()) {
                circularProgressButton.setEnabled(circularProgressButton.isEnabled());
            }
        }

        public int getProgress() {
            return this.mProgress;
        }

        public boolean isEnabled() {
            return this.mIsEnabled;
        }

        public void saveProgress(CircularProgressButton circularProgressButton) {
            this.mProgress = circularProgressButton.getProgress();
        }
    }

    public CircularProgressButton(Context context) {
        this(context, (AttributeSet) null);
    }

    private void cancelProgressAnimation() {
        ValueAnimator valueAnimator = this.mProgressAnimation;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.mProgressAnimation.removeAllUpdateListeners();
            this.mProgressAnimation.removeAllListeners();
        }
    }

    private void changeBackground(State state, boolean z) {
        String str;
        int i;
        if (z || state != this.mState) {
            cancelAllAnimation();
            int normalColor = getNormalColor(this.mIdleColorState);
            int normalColor2 = getNormalColor(this.mIdleColorState);
            ColorStateList textColors = getTextColors();
            int i2 = AnonymousClass9.$SwitchMap$com$meizu$common$widget$CircularProgressButton$State[state.ordinal()];
            if (i2 == 1) {
                normalColor = getNormalColor(this.mCompleteColorState);
                normalColor2 = getNormalColor(this.mStrokeColorComplete);
                str = this.mCompleteText;
                setState(State.COMPLETE);
                textColors = this.mTextColorComplete;
                this.mCurrentStateDrawable = this.mCompleteStateDrawable;
            } else if (i2 != 2) {
                str = "";
                if (i2 == 3) {
                    normalColor = this.mColorProgress;
                    normalColor2 = this.mColorIndicatorBackground;
                    setState(State.PROGRESS);
                    this.mCurrentStateDrawable = this.mProgressStateDrawable;
                } else if (i2 == 4) {
                    normalColor = getNormalColor(this.mIdleColorState);
                    normalColor2 = getNormalColor(this.mStrokeColorIdle);
                    str = this.mIdleText;
                    setState(State.IDLE);
                    textColors = this.mTextColorIdle;
                    this.mCurrentStateDrawable = this.mIdleStateDrawable;
                }
            } else {
                normalColor = getNormalColor(this.mErrorColorState);
                normalColor2 = getNormalColor(this.mStrokeColorError);
                str = this.mErrorText;
                setState(State.ERROR);
                textColors = this.mTextColorError;
                this.mCurrentStateDrawable = this.mErrorStateDrawable;
            }
            GradientDrawable gradientDrawable = this.mBackground.getGradientDrawable();
            if (state == State.PROGRESS) {
                int abs = (Math.abs(getWidth() - getHeight()) / 2) + this.mPaddingProgress;
                int i3 = this.mPaddingProgress;
                gradientDrawable.setBounds(abs, i3, (getWidth() - abs) - i3, getHeight() - this.mPaddingProgress);
                i = this.mProgressStrokeWidth;
            } else {
                i = this.mStrokeWidth;
                gradientDrawable.setBounds(0, 0, getRight() - getLeft(), getBottom() - getTop());
            }
            gradientDrawable.setColor(normalColor);
            this.mBackground.setStrokeWidth(i);
            this.mBackground.setStrokeColor(normalColor2);
            setText(str);
            setTextColor(textColors);
            post(new Runnable() {
                public void run() {
                    CircularProgressButton.this.invalidate();
                }
            });
        }
    }

    private StrokeGradientDrawable createDrawable(int i, int i2) {
        GradientDrawable gradientDrawable = (GradientDrawable) getResources().getDrawable(R.drawable.mc_cir_pro_btn_background).mutate();
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadius(this.mCornerRadius);
        StrokeGradientDrawable strokeGradientDrawable = new StrokeGradientDrawable(gradientDrawable);
        strokeGradientDrawable.setStrokeColor(i2);
        return strokeGradientDrawable;
    }

    private MorphingAnimation createMorphing() {
        this.mMorphingInProgress = true;
        setClickable(false);
        MorphingAnimation morphingAnimation = new MorphingAnimation(this, this.mBackground);
        this.mMorphingAnimation = morphingAnimation;
        morphingAnimation.setFromCornerRadius(this.mCornerRadius);
        this.mMorphingAnimation.setToCornerRadius(this.mCornerRadius);
        this.mMorphingAnimation.setFromWidth(getWidth());
        this.mMorphingAnimation.setToWidth(getWidth());
        if (this.mConfigurationChanged || !this.mIsUseTransitionAnim) {
            this.mMorphingAnimation.setDuration(1);
        } else {
            this.mMorphingAnimation.setDuration(MorphingAnimation.DURATION_NORMAL);
        }
        this.mConfigurationChanged = false;
        return this.mMorphingAnimation;
    }

    private MorphingAnimation createProgressMorphing(float f, float f2, int i, int i2) {
        this.mMorphingInProgress = true;
        setClickable(false);
        MorphingAnimation morphingAnimation = new MorphingAnimation(this, this.mBackground);
        this.mMorphingAnimation = morphingAnimation;
        morphingAnimation.setFromCornerRadius(f);
        this.mMorphingAnimation.setToCornerRadius(f2);
        this.mMorphingAnimation.setPadding((float) this.mPaddingProgress);
        this.mMorphingAnimation.setFromWidth(i);
        this.mMorphingAnimation.setToWidth(i2);
        if (this.mConfigurationChanged || !this.mIsUseTransitionAnim) {
            this.mMorphingAnimation.setDuration(1);
        } else {
            this.mMorphingAnimation.setDuration(MorphingAnimation.DURATION_NORMAL);
        }
        this.mConfigurationChanged = false;
        return this.mMorphingAnimation;
    }

    private void directprogressToError() {
        MorphingAnimation morphingAnimation = new MorphingAnimation(this, this.mBackground);
        this.mMorphingAnimation = morphingAnimation;
        morphingAnimation.setFromColor(this.mColorProgress);
        this.mMorphingAnimation.setToColor(getNormalColor(this.mErrorColorState));
        this.mMorphingAnimation.setFromStrokeColor(this.mColorIndicator);
        this.mMorphingAnimation.setToStrokeColor(getNormalColor(this.mStrokeColorError));
        this.mMorphingAnimation.setListener(new OnAnimationEndListener() {
            public void onAnimationEnd() {
                if (CircularProgressButton.this.mIconError != 0) {
                    CircularProgressButton.this.setText((CharSequence) null);
                    CircularProgressButton circularProgressButton = CircularProgressButton.this;
                    circularProgressButton.setIcon(circularProgressButton.mIconError);
                    return;
                }
                CircularProgressButton circularProgressButton2 = CircularProgressButton.this;
                circularProgressButton2.setWidth(circularProgressButton2.getTextWidth(circularProgressButton2.getPaint(), CircularProgressButton.this.mErrorText) + CircularProgressButton.this.getCompoundPaddingRight() + CircularProgressButton.this.getCompoundPaddingLeft());
                CircularProgressButton circularProgressButton3 = CircularProgressButton.this;
                circularProgressButton3.setText(circularProgressButton3.mErrorText);
                boolean unused = CircularProgressButton.this.mIsFirstTime = false;
                boolean unused2 = CircularProgressButton.this.mIsCycle = true;
            }
        });
        setState(State.ERROR);
        this.mCurrentStateDrawable = this.mErrorStateDrawable;
        this.mMorphingAnimation.colorMorphingStart();
    }

    private void drawIndeterminateProgress(Canvas canvas) {
        CircularAnimatedDrawable circularAnimatedDrawable = this.mAnimatedDrawable;
        if (circularAnimatedDrawable == null) {
            int width = (getWidth() - getHeight()) / 2;
            this.mAnimatedDrawable = new CircularAnimatedDrawable(this.mColorIndicator, (float) this.mProgressStrokeWidth);
            int i = this.mPaddingProgress + width;
            int width2 = (getWidth() - width) - this.mPaddingProgress;
            int height = getHeight();
            int i2 = this.mPaddingProgress;
            this.mAnimatedDrawable.setBounds(i, i2, width2, height - i2);
            this.mAnimatedDrawable.setCallback(this);
            this.mAnimatedDrawable.start();
            return;
        }
        circularAnimatedDrawable.setAllowLoading(true);
        this.mAnimatedDrawable.draw(canvas);
    }

    private void drawProgress(Canvas canvas) {
        if (this.mProgressDrawable == null) {
            this.mProgressDrawable = new CircularProgressDrawable(getHeight() - (this.mPaddingProgress * 2), this.mProgressStrokeWidth, this.mColorIndicator);
            int width = ((getWidth() - getHeight()) / 2) + this.mPaddingProgress;
            int i = this.mPaddingProgress;
            this.mProgressDrawable.setOffset((((float) (getWidth() - getHeight())) / 2.0f) + ((float) i), (float) i);
            CircularProgressDrawable circularProgressDrawable = this.mProgressDrawable;
            int i2 = this.mPaddingProgress;
            circularProgressDrawable.setBounds(width, i2, width, i2);
        }
        if (this.mNeedInvalidateCenterIcon) {
            this.mNeedInvalidateCenterIcon = false;
            this.mProgressDrawable.setCenterIcon(this.mProgressCenterIcon);
            if (this.mProgressCenterIcon == null) {
                this.mProgressDrawable.setShowCenterIcon(this.mShouldShowCenterIcon);
            }
        }
        float f = (360.0f / ((float) this.mMaxProgress)) * ((float) this.mAnimCurrentProgress);
        this.mProgressDrawable.setStartAngle(-90.0f);
        this.mProgressDrawable.setSweepAngle(f);
        this.mProgressDrawable.draw(canvas);
    }

    private void drawStateDrawable(Drawable drawable, Canvas canvas) {
        if (drawable != null) {
            drawable.draw(canvas);
        }
    }

    private void ensureBackgroundBounds() {
        setBackgroundBound(State.IDLE, this.mIdleStateDrawable);
        setBackgroundBound(State.COMPLETE, this.mCompleteStateDrawable);
        setBackgroundBound(State.ERROR, this.mErrorStateDrawable);
        setBackgroundBound(this.mState, this.mBackground.getGradientDrawable());
    }

    private int getDisabledColor(ColorStateList colorStateList) {
        return colorStateList.getColorForState(new int[]{-16842910}, 0);
    }

    private int getFocusedColor(ColorStateList colorStateList) {
        return colorStateList.getColorForState(new int[]{16842908}, 0);
    }

    /* access modifiers changed from: private */
    public Interpolator getInterpolator() {
        return new PathInterpolator(0.2f, 0.38f, 0.1f, 1.0f);
    }

    private int getNormalColor(ColorStateList colorStateList) {
        return colorStateList.getColorForState(new int[]{16842910}, 0);
    }

    private int getPressedColor(ColorStateList colorStateList) {
        return colorStateList.getColorForState(new int[]{16842919}, 0);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        initAttributes(context, attributeSet, i);
        this.mMaxProgress = 100;
        this.mState = State.IDLE;
        setText(this.mIdleText);
        setPaddingAutoFit();
        initIdleStateDrawable();
        initCompleteStateDrawable();
        initProgressStateDrawable();
        initErrorStateDrawable();
        this.mCurrentStateDrawable = this.mIdleStateDrawable;
        setBackgroundCompat((Drawable) null);
        new MzPressAnimationHelper().addTargetView(this, false);
    }

    private void initAttributes(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArray = getTypedArray(context, attributeSet, R.styleable.CircularProgressButton, i);
        if (typedArray != null) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(R.styleable.CircularProgressButton_mcCirButtonStrokeWidth, (int) getContext().getResources().getDimension(R.dimen.mc_cir_progress_button_stroke_width));
            this.mStrokeWidth = dimensionPixelSize;
            this.mProgressStrokeWidth = dimensionPixelSize;
            this.mIdleText = typedArray.getString(R.styleable.CircularProgressButton_mcCirButtonTextIdle);
            this.mCompleteText = typedArray.getString(R.styleable.CircularProgressButton_mcCirButtonTextComplete);
            this.mErrorText = typedArray.getString(R.styleable.CircularProgressButton_mcCirButtonTextError);
            this.mProgressText = typedArray.getString(R.styleable.CircularProgressButton_mcCirButtonTextProgress);
            this.mIconComplete = typedArray.getResourceId(R.styleable.CircularProgressButton_mcCirButtonIconComplete, 0);
            this.mIconError = typedArray.getResourceId(R.styleable.CircularProgressButton_mcCirButtonIconError, 0);
            this.mCornerRadius = typedArray.getDimension(R.styleable.CircularProgressButton_mcCirButtonCornerRadius, 0.0f);
            this.mPaddingProgress = typedArray.getDimensionPixelSize(R.styleable.CircularProgressButton_mcCirButtonPaddingProgress, 0);
            int resourceId = typedArray.getResourceId(R.styleable.CircularProgressButton_mcCirButtonSelectorIdle, R.color.mc_cir_progress_button_red);
            this.mIdleColorState = getResources().getColorStateList(resourceId);
            this.mStrokeColorIdle = getResources().getColorStateList(typedArray.getResourceId(R.styleable.CircularProgressButton_mcCirButtonStrokeColorIdle, resourceId));
            int resourceId2 = typedArray.getResourceId(R.styleable.CircularProgressButton_mcCirButtonSelectorComplete, R.color.mc_cir_progress_button_green);
            this.mCompleteColorState = getResources().getColorStateList(resourceId2);
            this.mStrokeColorComplete = getResources().getColorStateList(typedArray.getResourceId(R.styleable.CircularProgressButton_mcCirButtonStrokeColorComplete, resourceId2));
            int resourceId3 = typedArray.getResourceId(R.styleable.CircularProgressButton_mcCirButtonSelectorError, R.color.mc_cir_progress_button_red);
            this.mErrorColorState = getResources().getColorStateList(resourceId3);
            this.mStrokeColorError = getResources().getColorStateList(typedArray.getResourceId(R.styleable.CircularProgressButton_mcCirButtonStrokeColorError, resourceId3));
            this.mColorProgress = typedArray.getColor(R.styleable.CircularProgressButton_mcCirButtonColorProgress, getColor(R.color.mc_cir_progress_button_white));
            this.mColorIndicator = typedArray.getColor(R.styleable.CircularProgressButton_mcCirButtonColorIndicator, getColor(R.color.mc_cir_progress_button_red));
            this.mColorIndicatorBackground = typedArray.getColor(R.styleable.CircularProgressButton_mcCirButtonColorIndicatorBackground, getColor(R.color.mc_cir_progress_button_blank));
            ColorStateList colorStateList = typedArray.getColorStateList(R.styleable.CircularProgressButton_mcCirButtonTextColorError);
            this.mTextColorError = colorStateList;
            if (colorStateList == null) {
                this.mTextColorError = getTextColors();
            }
            ColorStateList colorStateList2 = typedArray.getColorStateList(R.styleable.CircularProgressButton_mcCirButtonTextColorIdle);
            this.mTextColorIdle = colorStateList2;
            if (colorStateList2 == null) {
                this.mTextColorIdle = getTextColors();
            }
            ColorStateList colorStateList3 = typedArray.getColorStateList(R.styleable.CircularProgressButton_mcCirButtonTextColorComplete);
            this.mTextColorComplete = colorStateList3;
            if (colorStateList3 == null) {
                this.mTextColorComplete = getTextColors();
            }
            this.mAutoFitPadding = typedArray.getBoolean(R.styleable.CircularProgressButton_mcCirButtonAutoFitPadding, true);
            typedArray.recycle();
        }
    }

    private void initCompleteStateDrawable() {
        StrokeGradientDrawable createDrawable = createDrawable(getPressedColor(this.mCompleteColorState), getPressedColor(this.mStrokeColorComplete));
        if (this.mCompleteStateDrawable == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.mCompleteStateDrawable = stateListDrawable;
            stateListDrawable.setCallback(this);
        }
        this.mCompleteStateDrawable.addState(new int[]{16842919}, createDrawable.getGradientDrawable());
        this.mCompleteStateDrawable.addState(StateSet.WILD_CARD, this.mBackground.getGradientDrawable());
        this.mCompleteStateDrawable.setBounds(0, 0, getRight() - getLeft(), getBottom() - getTop());
    }

    private void initErrorStateDrawable() {
        StrokeGradientDrawable createDrawable = createDrawable(getPressedColor(this.mErrorColorState), getPressedColor(this.mStrokeColorError));
        if (this.mErrorStateDrawable == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.mErrorStateDrawable = stateListDrawable;
            stateListDrawable.setCallback(this);
        }
        this.mErrorStateDrawable.addState(new int[]{16842919}, createDrawable.getGradientDrawable());
        this.mErrorStateDrawable.addState(StateSet.WILD_CARD, this.mBackground.getGradientDrawable());
        this.mErrorStateDrawable.setBounds(0, 0, getRight() - getLeft(), getBottom() - getTop());
    }

    private void initIdleStateDrawable() {
        int normalColor = getNormalColor(this.mIdleColorState);
        int pressedColor = getPressedColor(this.mIdleColorState);
        int focusedColor = getFocusedColor(this.mIdleColorState);
        int disabledColor = getDisabledColor(this.mIdleColorState);
        int normalColor2 = getNormalColor(this.mStrokeColorIdle);
        int pressedColor2 = getPressedColor(this.mStrokeColorIdle);
        int focusedColor2 = getFocusedColor(this.mStrokeColorIdle);
        int disabledColor2 = getDisabledColor(this.mStrokeColorIdle);
        if (this.mBackground == null) {
            this.mBackground = createDrawable(normalColor, normalColor2);
        }
        StrokeGradientDrawable createDrawable = createDrawable(disabledColor, disabledColor2);
        StrokeGradientDrawable createDrawable2 = createDrawable(focusedColor, focusedColor2);
        StrokeGradientDrawable createDrawable3 = createDrawable(pressedColor, pressedColor2);
        if (this.mIdleStateDrawable == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.mIdleStateDrawable = stateListDrawable;
            stateListDrawable.setCallback(this);
        }
        this.mIdleStateDrawable.addState(new int[]{16842919}, createDrawable3.getGradientDrawable());
        this.mIdleStateDrawable.addState(new int[]{16842908}, createDrawable2.getGradientDrawable());
        this.mIdleStateDrawable.addState(new int[]{-16842910}, createDrawable.getGradientDrawable());
        this.mIdleStateDrawable.addState(StateSet.WILD_CARD, this.mBackground.getGradientDrawable());
        this.mIdleStateDrawable.setBounds(0, 0, getRight() - getLeft(), getBottom() - getTop());
    }

    private void initProgressStateDrawable() {
        if (this.mProgressStateDrawable == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.mProgressStateDrawable = stateListDrawable;
            stateListDrawable.setCallback(this);
        }
        this.mProgressStateDrawable.addState(StateSet.WILD_CARD, this.mBackground.getGradientDrawable());
        int abs = (Math.abs(getWidth() - getHeight()) / 2) + this.mPaddingProgress;
        int i = this.mPaddingProgress;
        this.mProgressStateDrawable.setBounds(abs, i, (getWidth() - abs) - i, getHeight() - this.mPaddingProgress);
    }

    private void morphCompleteToIdle() {
        MorphingAnimation createMorphing = createMorphing();
        createMorphing.setFromColor(getNormalColor(this.mCompleteColorState));
        createMorphing.setToColor(getNormalColor(this.mIdleColorState));
        createMorphing.setFromStrokeColor(getNormalColor(this.mStrokeColorComplete));
        createMorphing.setToStrokeColor(getNormalColor(this.mStrokeColorIdle));
        createMorphing.setListener(this.mIdleStateListener);
        setState(State.IDLE);
        this.mCurrentStateDrawable = this.mIdleStateDrawable;
        createMorphing.start();
    }

    private void morphErrorToIdle() {
        MorphingAnimation createMorphing = createMorphing();
        createMorphing.setFromColor(getNormalColor(this.mErrorColorState));
        createMorphing.setToColor(getNormalColor(this.mIdleColorState));
        createMorphing.setFromStrokeColor(getNormalColor(this.mStrokeColorError));
        createMorphing.setToStrokeColor(getNormalColor(this.mStrokeColorIdle));
        createMorphing.setListener(this.mIdleStateListener);
        setState(State.IDLE);
        this.mCurrentStateDrawable = this.mIdleStateDrawable;
        createMorphing.start();
    }

    private void morphIdleToComplete() {
        MorphingAnimation createMorphing = createMorphing();
        createMorphing.setFromColor(getNormalColor(this.mIdleColorState));
        createMorphing.setFromStrokeColor(getNormalColor(this.mStrokeColorIdle));
        createMorphing.setToColor(getNormalColor(this.mCompleteColorState));
        createMorphing.setToStrokeColor(getNormalColor(this.mStrokeColorComplete));
        createMorphing.setListener(this.mCompleteStateListener);
        setState(State.COMPLETE);
        this.mCurrentStateDrawable = this.mCompleteStateDrawable;
        createMorphing.start();
    }

    private void morphIdleToError() {
        MorphingAnimation createMorphing = createMorphing();
        createMorphing.setFromColor(getNormalColor(this.mIdleColorState));
        createMorphing.setToColor(getNormalColor(this.mErrorColorState));
        createMorphing.setFromStrokeColor(getNormalColor(this.mStrokeColorIdle));
        createMorphing.setToStrokeColor(getNormalColor(this.mStrokeColorError));
        createMorphing.setListener(this.mErrorStateListener);
        setState(State.ERROR);
        this.mCurrentStateDrawable = this.mErrorStateDrawable;
        createMorphing.start();
    }

    private void morphProgressToComplete() {
        MorphingAnimation createProgressMorphing = createProgressMorphing((float) getHeight(), this.mCornerRadius, getHeight(), getWidth());
        createProgressMorphing.setFromColor(this.mColorProgress);
        createProgressMorphing.setFromStrokeColor(this.mColorIndicator);
        createProgressMorphing.setToStrokeColor(getNormalColor(this.mStrokeColorComplete));
        createProgressMorphing.setToColor(getNormalColor(this.mCompleteColorState));
        createProgressMorphing.setFromStrokeWidth(this.mProgressStrokeWidth);
        createProgressMorphing.setToStrokeWidth(this.mStrokeWidth);
        createProgressMorphing.setListener(this.mCompleteStateListener);
        setState(State.COMPLETE);
        this.mCurrentStateDrawable = this.mCompleteStateDrawable;
        createProgressMorphing.start();
    }

    private void morphProgressToError() {
        MorphingAnimation createProgressMorphing = createProgressMorphing((float) getHeight(), this.mCornerRadius, getHeight(), getWidth());
        createProgressMorphing.setFromColor(this.mColorProgress);
        createProgressMorphing.setToColor(getNormalColor(this.mErrorColorState));
        createProgressMorphing.setFromStrokeColor(this.mColorIndicator);
        createProgressMorphing.setToStrokeColor(getNormalColor(this.mStrokeColorError));
        createProgressMorphing.setFromStrokeWidth(this.mProgressStrokeWidth);
        createProgressMorphing.setToStrokeWidth(this.mStrokeWidth);
        createProgressMorphing.setListener(this.mErrorStateListener);
        setState(State.ERROR);
        this.mCurrentStateDrawable = this.mErrorStateDrawable;
        createProgressMorphing.start();
    }

    private void morphProgressToIdle() {
        MorphingAnimation createProgressMorphing = createProgressMorphing((float) getHeight(), this.mCornerRadius, getHeight(), getWidth());
        createProgressMorphing.setFromColor(this.mColorProgress);
        createProgressMorphing.setToColor(getNormalColor(this.mIdleColorState));
        createProgressMorphing.setFromStrokeColor(this.mColorIndicator);
        createProgressMorphing.setToStrokeColor(getNormalColor(this.mStrokeColorIdle));
        createProgressMorphing.setFromStrokeWidth(this.mProgressStrokeWidth);
        createProgressMorphing.setToStrokeWidth(this.mStrokeWidth);
        createProgressMorphing.setListener(new OnAnimationEndListener() {
            public void onAnimationEnd() {
                CircularProgressButton.this.removeIcon();
                CircularProgressButton circularProgressButton = CircularProgressButton.this;
                circularProgressButton.setText(circularProgressButton.mIdleText);
                float unused = CircularProgressButton.this.setPaddingAutoFit();
                boolean unused2 = CircularProgressButton.this.mMorphingInProgress = false;
                CircularProgressButton.this.setClickable(true);
            }
        });
        setState(State.IDLE);
        this.mCurrentStateDrawable = this.mIdleStateDrawable;
        createProgressMorphing.start();
    }

    private void morphToProgress() {
        if (this.mOrginWidth == 0) {
            this.mOrginWidth = getWidth();
        }
        if (!this.mIsFirstTime || this.mIsCycle) {
            this.mProgressWidth = getTextWidth(getPaint(), this.mErrorText) + getCompoundPaddingLeft() + getCompoundPaddingRight();
        } else {
            this.mProgressWidth = getWidth();
        }
        setWidth(this.mProgressWidth);
        setText(this.mProgressText);
        setPaddingAutoFit();
        MorphingAnimation createProgressMorphing = createProgressMorphing(this.mCornerRadius, (float) getHeight(), this.mProgressWidth, getHeight());
        createProgressMorphing.setFromColor(getNormalColor(this.mIdleColorState));
        createProgressMorphing.setToColor(this.mColorProgress);
        createProgressMorphing.setFromStrokeColor(getNormalColor(this.mStrokeColorIdle));
        createProgressMorphing.setToStrokeColor(this.mColorIndicatorBackground);
        createProgressMorphing.setFromStrokeWidth(this.mStrokeWidth);
        createProgressMorphing.setToStrokeWidth(this.mProgressStrokeWidth);
        createProgressMorphing.setListener(this.mProgressStateListener);
        setState(State.PROGRESS);
        this.mCurrentStateDrawable = this.mProgressStateDrawable;
        createProgressMorphing.start();
    }

    private Rect recordBackgroundBoundIfNeed() {
        if (!this.mMorphingInProgress) {
            return null;
        }
        Rect rect = new Rect();
        rect.set(this.mBackground.getGradientDrawable().getBounds());
        return rect;
    }

    private void restoreBackgroundBoundIfNeed(Rect rect) {
        if (this.mMorphingInProgress && rect != null) {
            this.mBackground.getGradientDrawable().setBounds(rect);
        }
    }

    private void setBackgroundBound(State state, Drawable drawable) {
        if (drawable != null) {
            if (state == State.PROGRESS) {
                int abs = (Math.abs(getWidth() - getHeight()) / 2) + this.mPaddingProgress;
                int i = this.mPaddingProgress;
                drawable.setBounds(abs, i, (getWidth() - abs) - i, getHeight() - this.mPaddingProgress);
                return;
            }
            drawable.setBounds(0, 0, getRight() - getLeft(), getBottom() - getTop());
        }
    }

    private void setBackgroundFromState(State state) {
        int i = AnonymousClass9.$SwitchMap$com$meizu$common$widget$CircularProgressButton$State[state.ordinal()];
        if (i == 1) {
            this.mCurrentStateDrawable = this.mCompleteStateDrawable;
        } else if (i == 2) {
            this.mCurrentStateDrawable = this.mErrorStateDrawable;
        } else if (i == 3) {
            this.mCurrentStateDrawable = this.mProgressStateDrawable;
        } else if (i == 4) {
            this.mCurrentStateDrawable = this.mIdleStateDrawable;
        }
    }

    private void setBackgroundState(Drawable drawable, int[] iArr) {
        if (drawable != null) {
            drawable.setState(iArr);
        }
    }

    /* access modifiers changed from: private */
    public void setIcon(int i) {
        Drawable drawable = getResources().getDrawable(i);
        if (drawable != null) {
            setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
            setPadding((getWidth() / 2) - (drawable.getIntrinsicWidth() / 2), 0, 0, 0);
        }
    }

    /* access modifiers changed from: private */
    public float setPaddingAutoFit() {
        setEllipsize(TextUtils.TruncateAt.END);
        setMaxLines(1);
        if (!this.mAutoFitPadding || getText() == null) {
            return 0.0f;
        }
        float textWidth = (float) getTextWidth(getPaint(), getText().toString());
        int dp2px = (int) ResourceUtils.dp2px(MAX_PADDING, getContext());
        if (((float) (dp2px * 2)) + textWidth < ((float) ((int) ResourceUtils.dp2px(PADDING_AUTO_FIT_BASELINE, getContext())))) {
            setPadding(dp2px, 0, dp2px, 0);
            return textWidth;
        }
        int dp2px2 = (int) ResourceUtils.dp2px(MIN_PADDING, getContext());
        setPadding(dp2px2, 0, dp2px2, 0);
        return textWidth;
    }

    private void setTextForState(State state) {
        int i = AnonymousClass9.$SwitchMap$com$meizu$common$widget$CircularProgressButton$State[state.ordinal()];
        if (i == 1) {
            setText(this.mCompleteText);
            setPaddingAutoFit();
        } else if (i == 2) {
            setText(this.mErrorText);
            setPaddingAutoFit();
        } else if (i == 4) {
            setText(this.mIdleText);
            setPaddingAutoFit();
        }
    }

    private void startProgressAnimation() {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.mAnimCurrentProgress, this.mProgress});
        this.mProgressAnimation = ofInt;
        ofInt.setDuration((long) PROGRESS_ANIMATION_DURATION);
        this.mProgressAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        this.mProgressAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int unused = CircularProgressButton.this.mAnimCurrentProgress = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                CircularProgressButton.this.invalidate();
            }
        });
        this.mProgressAnimation.start();
    }

    public void cancelAllAnimation() {
        MorphingAnimation morphingAnimation = this.mMorphingAnimation;
        if (morphingAnimation != null) {
            morphingAnimation.cancelAllAnim();
        }
    }

    public void draw(Canvas canvas) {
        if (this.mShouldUpdateBounds || !this.mMorphingInProgress) {
            this.mShouldUpdateBounds = false;
            ensureBackgroundBounds();
        }
        if (!this.mMorphingInProgress || !isPressed()) {
            if (this.mCurrentStateDrawable != null) {
                if ((getScrollX() | getScrollY()) == 0) {
                    int i = AnonymousClass9.$SwitchMap$com$meizu$common$widget$CircularProgressButton$State[this.mState.ordinal()];
                    if (i == 1) {
                        drawStateDrawable(this.mCompleteStateDrawable, canvas);
                    } else if (i == 2) {
                        drawStateDrawable(this.mErrorStateDrawable, canvas);
                    } else if (i == 3) {
                        drawStateDrawable(this.mProgressStateDrawable, canvas);
                    } else if (i == 4) {
                        drawStateDrawable(this.mIdleStateDrawable, canvas);
                    }
                } else {
                    canvas.translate((float) getScrollX(), (float) getScrollY());
                    this.mCurrentStateDrawable.draw(canvas);
                    canvas.translate((float) (-getScrollX()), (float) (-getScrollY()));
                }
            }
            super.draw(canvas);
            return;
        }
        super.draw(canvas);
    }

    public void drawableStateChanged() {
        Rect recordBackgroundBoundIfNeed = recordBackgroundBoundIfNeed();
        setBackgroundState(this.mIdleStateDrawable, getDrawableState());
        setBackgroundState(this.mCompleteStateDrawable, getDrawableState());
        setBackgroundState(this.mErrorStateDrawable, getDrawableState());
        setBackgroundState(this.mProgressStateDrawable, getDrawableState());
        restoreBackgroundBoundIfNeed(recordBackgroundBoundIfNeed);
        super.drawableStateChanged();
    }

    public int getColor(int i) {
        return getResources().getColor(i);
    }

    public String getCompleteText() {
        return this.mCompleteText;
    }

    public String getErrorText() {
        return this.mErrorText;
    }

    public String getIdleText() {
        return this.mIdleText;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public State getState() {
        return this.mState;
    }

    public int getTextWidth(Paint paint, String str) {
        TransformationMethod transformationMethod = getTransformationMethod();
        if (transformationMethod != null) {
            str = transformationMethod.getTransformation(str, this).toString();
        }
        return (int) paint.measureText(str);
    }

    public TypedArray getTypedArray(Context context, AttributeSet attributeSet, int[] iArr, int i) {
        return context.obtainStyledAttributes(attributeSet, iArr, i, 0);
    }

    public boolean isIndeterminateProgressMode() {
        return this.mIndeterminateProgressMode;
    }

    public boolean isMorphing() {
        return this.mMorphingInProgress;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cancelAllAnimation();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mState != State.PROGRESS || this.mMorphingInProgress) {
            CircularAnimatedDrawable circularAnimatedDrawable = this.mAnimatedDrawable;
            if (circularAnimatedDrawable != null) {
                circularAnimatedDrawable.setAllowLoading(false);
            }
        } else if (this.mIndeterminateProgressMode) {
            drawIndeterminateProgress(canvas);
        } else {
            drawProgress(canvas);
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(CircularProgressButton.class.getName());
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            setState(this.mState, false, false);
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.mProgress = savedState.mProgress;
            this.mIndeterminateProgressMode = savedState.mIndeterminateProgressMode;
            this.mConfigurationChanged = savedState.mConfigurationChanged;
            super.onRestoreInstanceState(savedState.getSuperState());
            setProgress(this.mProgress);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int unused = savedState.mProgress = this.mProgress;
        boolean unused2 = savedState.mIndeterminateProgressMode = this.mIndeterminateProgressMode;
        boolean unused3 = savedState.mConfigurationChanged = true;
        return savedState;
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mAnimatedDrawable = null;
        this.mProgressDrawable = null;
        this.mNeedInvalidateCenterIcon = true;
        this.mShouldUpdateBounds = true;
    }

    public void removeIcon() {
        setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        setPadding(0, 0, 0, 0);
    }

    public void setBackgroundColor(int i) {
        this.mBackground.getGradientDrawable().setColor(i);
    }

    @SuppressLint({"NewApi"})
    public void setBackgroundCompat(Drawable drawable) {
        setBackground(drawable);
    }

    public void setCompleteText(String str) {
        this.mCompleteText = str;
    }

    public void setErrorText(String str) {
        this.mErrorText = str;
    }

    public void setIdleText(String str) {
        this.mIdleText = str;
    }

    public void setIndeterminateProgressMode(boolean z) {
        this.mIndeterminateProgressMode = z;
    }

    public void setIndicatorBackgroundColor(int i) {
        if (this.mColorIndicatorBackground != i) {
            this.mColorIndicatorBackground = i;
        }
    }

    public void setPressed(boolean z) {
        if (!z || !this.mMorphingInProgress) {
            super.setPressed(z);
        }
    }

    public void setProgress(int i, boolean z) {
        this.mProgress = i;
        this.mIsUseTransitionAnim = z;
        if (!this.mMorphingInProgress && getWidth() != 0) {
            int i2 = this.mProgress;
            if (i2 >= this.mMaxProgress) {
                State state = this.mState;
                if (state == State.PROGRESS) {
                    morphProgressToComplete();
                } else if (state == State.IDLE) {
                    morphIdleToComplete();
                }
            } else if (i2 > 0) {
                State state2 = this.mState;
                if (state2 == State.IDLE || state2 == State.ERROR) {
                    morphToProgress();
                } else if (state2 == State.PROGRESS) {
                    cancelProgressAnimation();
                    if (z) {
                        startProgressAnimation();
                        return;
                    }
                    this.mAnimCurrentProgress = this.mProgress;
                    invalidate();
                }
            } else if (i2 == -1) {
                State state3 = this.mState;
                if (state3 == State.PROGRESS) {
                    morphProgressToError();
                } else if (state3 == State.IDLE) {
                    morphIdleToError();
                }
            } else if (i2 == 0) {
                State state4 = this.mState;
                if (state4 == State.COMPLETE) {
                    morphCompleteToIdle();
                } else if (state4 == State.PROGRESS) {
                    morphProgressToIdle();
                } else if (state4 == State.ERROR) {
                    morphErrorToIdle();
                }
            }
        }
    }

    public void setProgressCenterIcon(Drawable drawable) {
        this.mProgressCenterIcon = drawable;
        this.mNeedInvalidateCenterIcon = true;
    }

    public void setProgressForState(int i, boolean z) {
        if (this.mState == State.PROGRESS) {
            this.mProgress = i;
            cancelProgressAnimation();
            if (z) {
                startProgressAnimation();
                return;
            }
            this.mAnimCurrentProgress = this.mProgress;
            invalidate();
        }
    }

    public void setProgressIndicatorColor(int i) {
        this.mColorIndicator = i;
        this.mAnimatedDrawable = null;
        this.mProgressDrawable = null;
    }

    public void setProgressStrokeWidth(int i) {
        initProgressStateDrawable();
        if (i > 0 && this.mProgressStrokeWidth != i) {
            this.mProgressStrokeWidth = i;
            CircularAnimatedDrawable circularAnimatedDrawable = this.mAnimatedDrawable;
            if (circularAnimatedDrawable != null) {
                circularAnimatedDrawable.setStrokeWidth(i);
            }
            CircularProgressDrawable circularProgressDrawable = this.mProgressDrawable;
            if (circularProgressDrawable != null) {
                circularProgressDrawable.setStrokeWidth(i);
            }
        }
    }

    public void setShowCenterIcon(boolean z) {
        this.mShouldShowCenterIcon = z;
        this.mNeedInvalidateCenterIcon = true;
    }

    public void setState(State state, boolean z, boolean z2) {
        if (state != this.mState) {
            this.mIsUseTransitionAnim = z;
            if (!z) {
                changeBackground(state, false);
            } else if (!this.mMorphingInProgress && getWidth() != 0) {
                int[] iArr = AnonymousClass9.$SwitchMap$com$meizu$common$widget$CircularProgressButton$State;
                int i = iArr[state.ordinal()];
                if (i == 1) {
                    int i2 = iArr[this.mState.ordinal()];
                    if (i2 == 3) {
                        morphProgressToComplete();
                    } else if (i2 == 4) {
                        morphIdleToComplete();
                    }
                } else if (i == 2) {
                    int i3 = iArr[this.mState.ordinal()];
                    if (i3 != 3) {
                        if (i3 == 4) {
                            morphIdleToError();
                        }
                    } else if (getTextWidth(getPaint(), this.mErrorText) + getCompoundPaddingRight() + getCompoundPaddingLeft() <= this.mOrginWidth || this.mErrorText == null) {
                        morphProgressToError();
                    } else {
                        directprogressToError();
                    }
                } else if (i != 3) {
                    if (i == 4) {
                        int i4 = iArr[this.mState.ordinal()];
                        if (i4 == 1) {
                            morphCompleteToIdle();
                        } else if (i4 == 2) {
                            morphErrorToIdle();
                        } else if (i4 == 3) {
                            morphProgressToIdle();
                        }
                    }
                } else if (this.mState != State.PROGRESS) {
                    morphToProgress();
                }
            }
        }
    }

    public void setStateColorSelector(State state, ColorStateList colorStateList, ColorStateList colorStateList2) {
        if (colorStateList != null && colorStateList2 != null) {
            int i = AnonymousClass9.$SwitchMap$com$meizu$common$widget$CircularProgressButton$State[state.ordinal()];
            if (i == 1) {
                this.mCompleteColorState = colorStateList;
                this.mStrokeColorComplete = colorStateList2;
            } else if (i == 2) {
                this.mErrorColorState = colorStateList;
                this.mStrokeColorError = colorStateList2;
            } else if (i == 4) {
                this.mIdleColorState = colorStateList;
                this.mStrokeColorIdle = colorStateList2;
            }
            this.mBackground = null;
            this.mIdleStateDrawable = null;
            this.mProgressStateDrawable = null;
            this.mCompleteStateDrawable = null;
            this.mErrorStateDrawable = null;
            initIdleStateDrawable();
            initProgressStateDrawable();
            initErrorStateDrawable();
            initCompleteStateDrawable();
            if (this.mState == state) {
                setBackgroundFromState(state);
            }
            changeBackground(this.mState, true);
            drawableStateChanged();
        }
    }

    public void setStateText(State state, String str) {
        int i = AnonymousClass9.$SwitchMap$com$meizu$common$widget$CircularProgressButton$State[state.ordinal()];
        if (i == 1) {
            this.mCompleteText = str;
        } else if (i == 2) {
            this.mErrorText = str;
        } else if (i == 4) {
            this.mIdleText = str;
        }
        if (this.mState == state && !this.mMorphingInProgress) {
            setTextForState(state);
        }
    }

    public void setStateTextColor(State state, ColorStateList colorStateList) {
        int i = AnonymousClass9.$SwitchMap$com$meizu$common$widget$CircularProgressButton$State[state.ordinal()];
        if (i == 1) {
            this.mTextColorComplete = colorStateList;
        } else if (i == 2) {
            this.mTextColorError = colorStateList;
        } else if (i == 4) {
            this.mTextColorIdle = colorStateList;
        }
        if (this.mState == state) {
            invalidate();
        }
    }

    public void setStrokeColor(int i) {
        this.mBackground.setStrokeColor(i);
    }

    public boolean verifyDrawable(Drawable drawable) {
        return drawable == this.mAnimatedDrawable || drawable == this.mProgressStateDrawable || drawable == this.mIdleStateDrawable || drawable == this.mErrorStateDrawable || drawable == this.mCompleteStateDrawable || super.verifyDrawable(drawable);
    }

    public CircularProgressButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.MeizuCommon_CircularProgressButton);
    }

    public CircularProgressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsUseTransitionAnim = true;
        this.mShouldShowCenterIcon = false;
        this.mShouldUpdateBounds = false;
        this.mAutoFitPadding = true;
        this.mOrginWidth = 0;
        this.mIsFirstTime = true;
        this.mProgress = 0;
        this.mProgressStateListener = new OnAnimationEndListener() {
            public void onAnimationEnd() {
                boolean unused = CircularProgressButton.this.mMorphingInProgress = false;
                CircularProgressButton.this.setClickable(true);
                CircularProgressButton.this.setText((CharSequence) null);
                CircularProgressButton.this.requestLayout();
            }
        };
        this.mCompleteStateListener = new OnAnimationEndListener() {
            public void onAnimationEnd() {
                if (CircularProgressButton.this.mIconComplete != 0) {
                    CircularProgressButton.this.setText((CharSequence) null);
                    CircularProgressButton circularProgressButton = CircularProgressButton.this;
                    circularProgressButton.setIcon(circularProgressButton.mIconComplete);
                } else {
                    CircularProgressButton circularProgressButton2 = CircularProgressButton.this;
                    circularProgressButton2.setText(circularProgressButton2.mCompleteText);
                }
                float unused = CircularProgressButton.this.setPaddingAutoFit();
                boolean unused2 = CircularProgressButton.this.mMorphingInProgress = false;
                CircularProgressButton.this.setClickable(true);
                CircularProgressButton circularProgressButton3 = CircularProgressButton.this;
                circularProgressButton3.setTextColor(circularProgressButton3.mTextColorComplete);
            }
        };
        this.mIdleStateListener = new OnAnimationEndListener() {
            public void onAnimationEnd() {
                CircularProgressButton.this.removeIcon();
                CircularProgressButton circularProgressButton = CircularProgressButton.this;
                circularProgressButton.setText(circularProgressButton.mIdleText);
                float unused = CircularProgressButton.this.setPaddingAutoFit();
                boolean unused2 = CircularProgressButton.this.mMorphingInProgress = false;
                CircularProgressButton.this.setClickable(true);
                CircularProgressButton circularProgressButton2 = CircularProgressButton.this;
                circularProgressButton2.setTextColor(circularProgressButton2.mTextColorIdle);
            }
        };
        this.mErrorStateListener = new OnAnimationEndListener() {
            public void onAnimationEnd() {
                if (CircularProgressButton.this.mIconError != 0) {
                    CircularProgressButton.this.setText((CharSequence) null);
                    CircularProgressButton circularProgressButton = CircularProgressButton.this;
                    circularProgressButton.setIcon(circularProgressButton.mIconError);
                } else {
                    CircularProgressButton circularProgressButton2 = CircularProgressButton.this;
                    circularProgressButton2.setText(circularProgressButton2.mErrorText);
                }
                boolean unused = CircularProgressButton.this.mMorphingInProgress = false;
                CircularProgressButton.this.setClickable(true);
                CircularProgressButton circularProgressButton3 = CircularProgressButton.this;
                circularProgressButton3.setTextColor(circularProgressButton3.mTextColorError);
            }
        };
        init(context, attributeSet, i);
    }

    public void setProgressForState(int i) {
        setProgressForState(i, false);
    }

    private void setState(State state) {
        if (this.mState != state) {
            this.mState = state;
        }
    }

    @Deprecated
    public void setProgress(int i) {
        setProgress(i, true);
    }
}
