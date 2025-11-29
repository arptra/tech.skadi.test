package com.meizu.common.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.meizu.common.R;

public class SelectionButton extends LinearLayout {
    private static final int FRAME_COUNT = 12;
    /* access modifiers changed from: private */
    public static final float[] interpolationsEnter = {0.0f, 0.215313f, 0.513045f, 0.675783f, 0.777778f, 0.848013f, 0.898385f, 0.934953f, 0.96126f, 0.979572f, 0.991439f, 0.997972f, 1.0f, 1.0f};
    /* access modifiers changed from: private */
    public static final float[] interpolationsOut = {0.0f, 0.002028f, 0.008561f, 0.020428f, 0.03874f, 0.065047f, 0.101615f, 0.151987f, 0.222222f, 0.324217f, 0.486955f, 0.784687f, 1.0f, 1.0f};
    private ObjectAnimator mAnimator;
    Context mContext;
    private int mCurrentCount;
    Drawable mDrawable;
    private boolean mIsAllSelected;
    private boolean mIsAnimation;
    private ColorStateList mSelectTextColor;
    private TextView mText;
    private int mTotalCount;
    /* access modifiers changed from: private */
    public int targetVisibility;

    public SelectionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDrawable = null;
        this.mIsAnimation = false;
        this.mTotalCount = 0;
        this.mCurrentCount = 0;
        this.mIsAllSelected = false;
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SelectionButton, i, 0);
        this.mDrawable = obtainStyledAttributes.getDrawable(R.styleable.SelectionButton_mcBackground);
        this.mSelectTextColor = obtainStyledAttributes.getColorStateList(R.styleable.SelectionButton_mcSelectTextColor);
        obtainStyledAttributes.recycle();
        initView();
        initAnimation();
    }

    private void initAnimation() {
        if (this.mAnimator == null && this.mText != null) {
            this.mIsAnimation = true;
            this.targetVisibility = getVisibility();
            setupAnimation();
        }
    }

    private void initView() {
        if (LayoutInflater.from(this.mContext).inflate(R.layout.mc_selection_button, this) == null) {
            Log.w("SelectionButton", "can not inflate the view");
            return;
        }
        setClickable(true);
        setGravity(17);
        setMinimumWidth(getContext().getResources().getDimensionPixelSize(R.dimen.mz_action_button_min_width));
        this.mText = (TextView) findViewById(16908308);
        update();
        this.mText.setActivated(false);
        Drawable drawable = this.mDrawable;
        if (drawable != null) {
            this.mText.setBackgroundDrawable(drawable);
        }
        ColorStateList colorStateList = this.mSelectTextColor;
        if (colorStateList != null) {
            this.mText.setTextColor(colorStateList);
        }
    }

    private void setupAnimation() {
        ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(this.mText, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("scaleX", new float[]{0.0f, 1.0f}), PropertyValuesHolder.ofFloat("scaleY", new float[]{0.0f, 1.0f})}).setDuration(200);
        this.mAnimator = duration;
        duration.setInterpolator(new TimeInterpolator() {
            public float getInterpolation(float f) {
                return (SelectionButton.this.targetVisibility == 0 ? SelectionButton.interpolationsEnter : SelectionButton.interpolationsOut)[Math.round(f * 12.0f)];
            }
        });
        this.mAnimator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                View view = (View) ((ObjectAnimator) animator).getTarget();
                view.setScaleX(1.0f);
                view.setScaleY(1.0f);
                SelectionButton selectionButton = SelectionButton.this;
                selectionButton.setVisibility(selectionButton.targetVisibility, false);
                SelectionButton.this.setClickable(true);
            }

            public void onAnimationStart(Animator animator) {
                SelectionButton.this.setClickable(false);
            }
        });
    }

    private void update() {
        int i = this.mCurrentCount;
        int i2 = this.mTotalCount;
        if (i > i2) {
            this.mCurrentCount = i2;
        }
        if (i2 <= 0 || this.mCurrentCount != i2) {
            this.mText.setText(String.valueOf(this.mCurrentCount));
            this.mIsAllSelected = false;
            this.mText.setActivated(false);
            return;
        }
        this.mIsAllSelected = true;
        this.mText.setText(getContext().getResources().getString(R.string.mc_selectionbutton_all));
        this.mText.setActivated(true);
    }

    public int getCurrentCount() {
        return this.mCurrentCount;
    }

    public int getTotalCount() {
        return this.mTotalCount;
    }

    public boolean isAllSelected() {
        return this.mIsAllSelected;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(SelectionButton.class.getName());
    }

    public void setAllSelected(boolean z) {
        if (z) {
            this.mCurrentCount = this.mTotalCount;
        } else {
            this.mCurrentCount = 0;
        }
        update();
    }

    public void setCurrentCount(int i) {
        if (this.mCurrentCount != i) {
            if (i < 0) {
                i = 0;
            }
            this.mCurrentCount = i;
            update();
        }
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        TextView textView = this.mText;
        if (textView != null) {
            textView.setEnabled(z);
        }
    }

    public void setIsAnimation(boolean z) {
        this.mIsAnimation = z;
    }

    public void setSelectBackground(Drawable drawable) {
        if (drawable != null) {
            this.mDrawable = drawable;
            this.mText.setBackgroundDrawable(drawable);
        }
    }

    public void setSelectTextColor(int i) {
        this.mText.setTextColor(i);
    }

    public void setTotalCount(int i) {
        if (this.mTotalCount != i) {
            if (i < 0) {
                i = 0;
            }
            this.mTotalCount = i;
            update();
        }
    }

    public void setVisibility(int i) {
        if (!this.mIsAnimation) {
            super.setVisibility(i);
        } else if (this.targetVisibility != i) {
            this.targetVisibility = i;
            if (i == 0) {
                super.setVisibility(i);
                this.mAnimator.start();
                return;
            }
            this.mAnimator.reverse();
        }
    }

    public void setVisibility(int i, boolean z) {
        if (z) {
            setVisibility(i);
            return;
        }
        super.setVisibility(i);
        this.targetVisibility = getVisibility();
    }

    public SelectionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.MeizuCommon_SelectionButtonStyle);
    }

    public SelectionButton(Context context) {
        this(context, (AttributeSet) null);
    }
}
