package com.meizu.common.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.PathInterpolator;
import android.widget.CheckBox;
import com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordHistoryDetailActivity;

@SuppressLint({"AppCompatCustomView"})
public class AnimCheckBox extends CheckBox {
    private CheckBoxAnimHelper checkBoxHelper;
    private boolean mActivated;
    int mInitVisible;
    /* access modifiers changed from: private */
    public UpdateListener mUpdateListener;

    public static class CheckBoxAnimHelper {
        private boolean DEBUG = false;
        private ObjectAnimator mAnimator1;
        /* access modifiers changed from: private */
        public ObjectAnimator mAnimator2;
        private ValueAnimator mAnimator3;
        private AnimatorSet mAnimatorSet;
        private boolean mHasInit = false;
        private TimeInterpolator mInterpolator1;
        private TimeInterpolator mInterpolator2;
        private TimeInterpolator mInterpolator3;
        private TimeInterpolator mInterpolator4;
        private boolean mIsAnimation = true;
        /* access modifiers changed from: private */
        public AnimCheckBox mTarget;
        /* access modifiers changed from: private */
        public boolean mTargetActivatedState;
        /* access modifiers changed from: private */
        public boolean mTargetChecekedState;

        public CheckBoxAnimHelper(AnimCheckBox animCheckBox) {
            this.mTarget = animCheckBox;
            init();
            this.mHasInit = true;
        }

        private void init() {
            this.mInterpolator1 = new PathInterpolator(0.051f, 0.012f, 0.1f, 1.0f);
            this.mInterpolator2 = new PathInterpolator(0.051f, 0.012f, 0.1f, 1.0f);
            this.mInterpolator3 = new PathInterpolator(0.2f, 0.0601f, 0.1f, 1.0f);
            this.mInterpolator4 = new PathInterpolator(0.0f, 0.0f, 0.1f, 1.0f);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.mTarget, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("alpha", new float[]{1.0f, 0.0f})});
            this.mAnimator1 = ofPropertyValuesHolder;
            ofPropertyValuesHolder.setInterpolator(this.mInterpolator1);
            this.mAnimator1.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    CheckBoxAnimHelper.this.mTarget.superSetCheck(CheckBoxAnimHelper.this.mTargetChecekedState);
                    CheckBoxAnimHelper.this.mTarget.superSetActivate(CheckBoxAnimHelper.this.mTargetActivatedState);
                    if (CheckBoxAnimHelper.this.mTarget.mInitVisible != 0) {
                        if (CheckBoxAnimHelper.this.mTargetChecekedState) {
                            CheckBoxAnimHelper.this.mTarget.setVisibility(0);
                        } else {
                            CheckBoxAnimHelper.this.mTarget.setVisibility(CheckBoxAnimHelper.this.mTarget.mInitVisible);
                        }
                    }
                    CheckBoxAnimHelper.this.mAnimator2.start();
                }
            });
            PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("scaleY", new float[]{0.6f, 1.0f});
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.mTarget, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("scaleX", new float[]{0.6f, 1.0f}), ofFloat, PropertyValuesHolder.ofFloat("alpha", new float[]{0.6f, 1.0f})});
            this.mAnimator2 = ofPropertyValuesHolder2;
            ofPropertyValuesHolder2.setInterpolator(this.mInterpolator2);
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.mAnimator3 = ofFloat2;
            ofFloat2.setInterpolator(this.mInterpolator3);
            this.mAnimator3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (CheckBoxAnimHelper.this.mTarget.mUpdateListener != null) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        if (!CheckBoxAnimHelper.this.mTargetChecekedState) {
                            floatValue = 1.0f - floatValue;
                        }
                        CheckBoxAnimHelper.this.mTarget.mUpdateListener.getUpdateTransition(floatValue);
                    }
                }
            });
            this.mAnimator3.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    if (CheckBoxAnimHelper.this.mAnimator2.isRunning()) {
                        CheckBoxAnimHelper.this.mAnimator2.end();
                    }
                }
            });
            AnimatorSet animatorSet = new AnimatorSet();
            this.mAnimatorSet = animatorSet;
            animatorSet.playTogether(new Animator[]{this.mAnimator1, this.mAnimator3});
        }

        public void onDetached() {
            ObjectAnimator objectAnimator = this.mAnimator1;
            if (objectAnimator != null) {
                objectAnimator.removeAllListeners();
                this.mAnimator1.removeAllUpdateListeners();
            }
            ObjectAnimator objectAnimator2 = this.mAnimator2;
            if (objectAnimator2 != null) {
                objectAnimator2.removeAllListeners();
                this.mAnimator2.removeAllUpdateListeners();
            }
            ValueAnimator valueAnimator = this.mAnimator3;
            if (valueAnimator != null) {
                valueAnimator.removeAllListeners();
                this.mAnimator3.removeAllUpdateListeners();
            }
        }

        public void setActivated(boolean z) {
            this.mTargetActivatedState = z;
            if (!this.mHasInit || !this.mIsAnimation) {
                this.mTarget.superSetActivate(z);
                return;
            }
            if (this.DEBUG) {
                Log.i("xx", "setActivated activated = " + z + " " + this.mTarget.isActivated() + " " + this.mTargetActivatedState + " mTargetChecekedState = " + this.mTargetChecekedState + " " + this.mTarget.isChecked() + " " + this.mAnimatorSet.isRunning() + " " + this.mAnimator2.isRunning());
            }
            if (z == this.mTarget.isActivated()) {
                return;
            }
            if (!z && !this.mTargetChecekedState && this.mTarget.isChecked()) {
                return;
            }
            if (this.mTarget.isChecked() && this.mTargetChecekedState) {
                this.mTarget.superSetActivate(z);
                if (!this.mAnimatorSet.isRunning() && !this.mAnimator2.isRunning()) {
                    ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.mTarget, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{0.0f, 1.0f}), PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{0.0f, 1.0f})});
                    ofPropertyValuesHolder.setDuration(40).setInterpolator(this.mInterpolator4);
                    ofPropertyValuesHolder.start();
                }
            } else if (!z) {
                this.mAnimatorSet.end();
                this.mAnimator2.end();
                this.mTarget.superSetActivate(z);
            }
        }

        public void setChecked(boolean z) {
            if (!this.mHasInit || !this.mIsAnimation) {
                this.mTarget.superSetCheck(z);
                this.mTargetChecekedState = z;
                return;
            }
            if (this.DEBUG) {
                Log.i("xx", "setChecked checked = " + z + " mTargetChecekedState = " + this.mTargetChecekedState + FastRecordHistoryDetailActivity.TAG_SPLIT + this.mAnimatorSet.isRunning() + " " + this.mAnimator2.isRunning());
            }
            if (z != this.mTargetChecekedState) {
                this.mTargetChecekedState = z;
                if (z) {
                    if (this.mAnimatorSet.isRunning() || this.mAnimator2.isRunning()) {
                        this.mTargetChecekedState = false;
                        this.mAnimatorSet.end();
                        this.mAnimator2.end();
                        setChecked(z);
                        return;
                    }
                    this.mAnimator1.setDuration(150);
                    this.mAnimator2.setDuration(230);
                    this.mAnimator3.setDuration(380);
                    this.mAnimatorSet.start();
                } else if (this.mAnimatorSet.isRunning() || this.mAnimator2.isRunning()) {
                    this.mTarget.superSetCheck(z);
                    this.mAnimatorSet.end();
                    this.mAnimator2.end();
                } else {
                    this.mAnimator1.setDuration(0);
                    this.mAnimator2.setDuration(0);
                    this.mAnimator3.setDuration(476);
                    this.mAnimatorSet.start();
                }
            }
        }

        public void setIsAnimation(boolean z) {
            this.mIsAnimation = z;
        }
    }

    public interface UpdateListener {
        void getUpdateTransition(float f);
    }

    public AnimCheckBox(Context context) {
        this(context, (AttributeSet) null);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setChecked(this.mActivated);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setChecked(this.mActivated);
    }

    public void setActivated(boolean z) {
        if (this.mActivated != z) {
            this.mActivated = z;
            sendAccessibilityEvent(32768);
        }
        CheckBoxAnimHelper checkBoxAnimHelper = this.checkBoxHelper;
        if (checkBoxAnimHelper == null) {
            super.setActivated(z);
        } else {
            checkBoxAnimHelper.setActivated(z);
        }
    }

    public void setChecked(boolean z) {
        CheckBoxAnimHelper checkBoxAnimHelper = this.checkBoxHelper;
        if (checkBoxAnimHelper == null) {
            super.setChecked(z);
        } else {
            checkBoxAnimHelper.setChecked(z);
        }
    }

    public void setInitVisible(int i) {
        if (i == 0 || i == 4 || i == 8) {
            this.mInitVisible = i;
        }
    }

    public void setIsAnimation(boolean z) {
        if (this.checkBoxHelper == null) {
            this.checkBoxHelper = new CheckBoxAnimHelper(this);
        }
        this.checkBoxHelper.setIsAnimation(z);
    }

    public void setUpdateListener(UpdateListener updateListener) {
        this.mUpdateListener = updateListener;
    }

    public void superSetActivate(boolean z) {
        super.setActivated(z);
    }

    public void superSetCheck(boolean z) {
        super.setChecked(z);
    }

    public AnimCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AnimCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mInitVisible = getVisibility();
        if (this.checkBoxHelper == null) {
            this.checkBoxHelper = new CheckBoxAnimHelper(this);
        }
        this.checkBoxHelper.setIsAnimation(true);
    }

    public AnimCheckBox(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mInitVisible = getVisibility();
        if (this.checkBoxHelper == null) {
            this.checkBoxHelper = new CheckBoxAnimHelper(this);
        }
        this.checkBoxHelper.setIsAnimation(true);
    }
}
