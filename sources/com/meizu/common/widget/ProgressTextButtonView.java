package com.meizu.common.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.TextView;

public class ProgressTextButtonView extends FrameLayout {
    private ValueAnimator mAlphaAnimator;
    /* access modifiers changed from: private */
    public CircularProgressButton mButton;
    private boolean mIsShowText = false;
    /* access modifiers changed from: private */
    public TextView mText;

    public ProgressTextButtonView(Context context) {
        super(context);
    }

    public void cancelAllAnimation() {
        ValueAnimator valueAnimator = this.mAlphaAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.mAlphaAnimator.removeAllUpdateListeners();
        }
        CircularProgressButton circularProgressButton = this.mButton;
        if (circularProgressButton != null) {
            circularProgressButton.cancelAllAnimation();
        }
    }

    public CircularProgressButton getButton() {
        return this.mButton;
    }

    public TextView getTextView() {
        return this.mText;
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() == 2) {
            for (int i = 0; i < getChildCount(); i++) {
                if (getChildAt(i) instanceof CircularProgressButton) {
                    this.mButton = (CircularProgressButton) getChildAt(i);
                } else if (getChildAt(i) instanceof TextView) {
                    this.mText = (TextView) getChildAt(i);
                }
            }
            showText(this.mIsShowText, false);
            return;
        }
        throw new IllegalStateException("ProgressTextButtonView must has two children");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ProgressTextButtonView.class.getName());
    }

    public void showText(final boolean z, boolean z2) {
        if (!z2) {
            if (z) {
                this.mText.setAlpha(1.0f);
                this.mButton.setVisibility(8);
                this.mText.setVisibility(0);
                return;
            }
            this.mButton.setAlpha(1.0f);
            this.mButton.setVisibility(0);
            this.mText.setVisibility(8);
        } else if (z && this.mText.getVisibility() == 0) {
        } else {
            if (z || this.mButton.getVisibility() != 0) {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
                this.mAlphaAnimator = ofFloat;
                ofFloat.setDuration(100);
                this.mAlphaAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        if (z) {
                            ProgressTextButtonView.this.mButton.setAlpha(1.0f - floatValue);
                            ProgressTextButtonView.this.mText.setAlpha(floatValue);
                            return;
                        }
                        ProgressTextButtonView.this.mButton.setAlpha(floatValue);
                        ProgressTextButtonView.this.mText.setAlpha(1.0f - floatValue);
                    }
                });
                this.mAlphaAnimator.addListener(new Animator.AnimatorListener() {
                    public void onAnimationCancel(Animator animator) {
                    }

                    public void onAnimationEnd(Animator animator) {
                        if (z) {
                            ProgressTextButtonView.this.mText.setVisibility(0);
                            ProgressTextButtonView.this.mButton.setVisibility(8);
                            return;
                        }
                        ProgressTextButtonView.this.mText.setVisibility(8);
                        ProgressTextButtonView.this.mButton.setVisibility(0);
                    }

                    public void onAnimationRepeat(Animator animator) {
                    }

                    public void onAnimationStart(Animator animator) {
                    }
                });
                this.mAlphaAnimator.start();
            }
        }
    }

    public ProgressTextButtonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
