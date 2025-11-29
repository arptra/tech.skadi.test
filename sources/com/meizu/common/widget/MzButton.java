package com.meizu.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.R;
import androidx.appcompat.widget.AppCompatButton;
import com.meizu.common.animator.MzPressAnimationBuilder;

public class MzButton extends AppCompatButton {
    private boolean mAlphaAnimEnabled;
    private MzPressAnimationBuilder mMzPressAnimationBuilder;
    private boolean mPressAnimationEnabled;

    public MzButton(Context context) {
        this(context, (AttributeSet) null);
    }

    private void setupPressAnim() {
        if (this.mPressAnimationEnabled) {
            MzPressAnimationBuilder mzPressAnimationBuilder = new MzPressAnimationBuilder(this);
            this.mMzPressAnimationBuilder = mzPressAnimationBuilder;
            mzPressAnimationBuilder.pressAnimationInit();
            if (!this.mAlphaAnimEnabled) {
                this.mMzPressAnimationBuilder.setToAlpha(1.0f);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled() && this.mPressAnimationEnabled) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.mMzPressAnimationBuilder.pressAnimationStart();
            } else if (action == 1 || action == 3) {
                this.mMzPressAnimationBuilder.pressAnimationReverse();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setPressAnimationEnabled(boolean z) {
        if (this.mPressAnimationEnabled != z) {
            this.mPressAnimationEnabled = z;
            setupPressAnim();
        }
    }

    public MzButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.buttonStyle);
    }

    public MzButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAlphaAnimEnabled = false;
        this.mPressAnimationEnabled = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.meizu.common.R.styleable.MzButton, i, 0);
        this.mAlphaAnimEnabled = obtainStyledAttributes.getBoolean(com.meizu.common.R.styleable.MzButton_mzPressAnimationAlphaEnabled, this.mAlphaAnimEnabled);
        this.mPressAnimationEnabled = obtainStyledAttributes.getBoolean(com.meizu.common.R.styleable.MzButton_pressAnimationEnabled, this.mPressAnimationEnabled);
        obtainStyledAttributes.recycle();
        setupPressAnim();
    }
}
