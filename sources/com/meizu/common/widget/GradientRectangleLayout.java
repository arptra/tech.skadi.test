package com.meizu.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.meizu.common.R;

public class GradientRectangleLayout extends LinearLayout implements View.OnTouchListener {
    private final int TRANSITION_DURATION;
    private TransitionDrawable mDoubleOneDownDrawable;
    private int[] mDoubleOneGradientColor;
    private int[] mDoubleOneGradientPressedColor;
    private StateListDrawable mDoubleOneStateListDrawable;
    private TransitionDrawable mDoubleTwoDownDrawable;
    private int[] mDoubleTwoGradientColor;
    private int[] mDoubleTwoGradientPressedColor;
    private StateListDrawable mDoubleTwoStateListDrawable;
    private TransitionDrawable mSingleDownDrawable;
    private int[] mSingleGradientColor;
    private int[] mSingleGradientPressedColor;
    private StateListDrawable mSingleStateListDrawable;

    public GradientRectangleLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    private void init() {
        setOrientation(0);
        setGravity(17);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(R.styleable.MZTheme);
        int i = obtainStyledAttributes.getInt(R.styleable.MZTheme_mzThemeColorLevel4, CircleProgressBar.BAR_COLOR_DEF);
        int i2 = obtainStyledAttributes.getInt(R.styleable.MZTheme_mzThemeColorLevel5, CircleProgressBar.BAR_COLOR_DEF);
        int i3 = obtainStyledAttributes.getInt(R.styleable.MZTheme_mzThemeColorLevel6, CircleProgressBar.BAR_COLOR_DEF);
        int i4 = obtainStyledAttributes.getInt(R.styleable.MZTheme_mzThemeColorLevel7, CircleProgressBar.BAR_COLOR_DEF);
        int i5 = obtainStyledAttributes.getInt(R.styleable.MZTheme_mzThemeColorLevel8, CircleProgressBar.BAR_COLOR_DEF);
        obtainStyledAttributes.recycle();
        this.mSingleGradientColor = new int[]{i2, i4};
        this.mSingleGradientPressedColor = new int[]{i3, i5};
        this.mDoubleOneGradientColor = new int[]{i, i2};
        this.mDoubleOneGradientPressedColor = new int[]{i2, i3};
        this.mDoubleTwoGradientColor = new int[]{i3, i4};
        this.mDoubleTwoGradientPressedColor = new int[]{i4, i5};
        initTransitionDrawable();
    }

    private void initTransitionDrawable() {
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.LEFT_RIGHT;
        this.mSingleDownDrawable = new TransitionDrawable(new Drawable[]{new GradientDrawable(orientation, this.mSingleGradientColor), new GradientDrawable(orientation, this.mSingleGradientPressedColor)});
        this.mDoubleOneDownDrawable = new TransitionDrawable(new Drawable[]{new GradientDrawable(orientation, this.mDoubleOneGradientColor), new GradientDrawable(orientation, this.mDoubleOneGradientPressedColor)});
        this.mDoubleTwoDownDrawable = new TransitionDrawable(new Drawable[]{new GradientDrawable(orientation, this.mDoubleTwoGradientColor), new GradientDrawable(orientation, this.mDoubleTwoGradientPressedColor)});
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#19000000"));
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.mSingleStateListDrawable = stateListDrawable;
        stateListDrawable.addState(new int[]{-16842910}, colorDrawable);
        this.mSingleStateListDrawable.addState(new int[]{16842910}, this.mSingleDownDrawable);
        StateListDrawable stateListDrawable2 = new StateListDrawable();
        this.mDoubleOneStateListDrawable = stateListDrawable2;
        stateListDrawable2.addState(new int[]{-16842910}, colorDrawable);
        this.mDoubleOneStateListDrawable.addState(new int[]{16842910}, this.mDoubleOneDownDrawable);
        StateListDrawable stateListDrawable3 = new StateListDrawable();
        this.mDoubleTwoStateListDrawable = stateListDrawable3;
        stateListDrawable3.addState(new int[]{-16842910}, colorDrawable);
        this.mDoubleTwoStateListDrawable.addState(new int[]{16842910}, this.mDoubleTwoDownDrawable);
    }

    private void setTransition(View view, boolean z) {
        if (view == null || view.getBackground() == null || !(view.getBackground() instanceof StateListDrawable) || !(view.getBackground().getCurrent() instanceof TransitionDrawable)) {
            return;
        }
        if (z) {
            ((TransitionDrawable) view.getBackground().getCurrent()).startTransition(128);
        } else {
            ((TransitionDrawable) view.getBackground().getCurrent()).reverseTransition(128);
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        init();
        int childCount = getChildCount();
        if (childCount == 1) {
            getChildAt(0).setBackground(this.mSingleStateListDrawable);
        } else if (childCount != 2) {
            for (int i = 0; i < getChildCount(); i++) {
                getChildAt(i).setBackground(this.mSingleStateListDrawable);
            }
        } else {
            getChildAt(0).setBackground(this.mDoubleOneStateListDrawable);
            getChildAt(1).setBackground(this.mDoubleTwoStateListDrawable);
        }
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if (getChildAt(i2) instanceof TextView) {
                ((TextView) getChildAt(i2)).setTextColor(-1);
                ((TextView) getChildAt(i2)).setGravity(17);
            }
            getChildAt(i2).setClickable(true);
            getChildAt(i2).setOnTouchListener(this);
            getChildAt(i2).setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0f));
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            setTransition(view, true);
        } else if (action == 1) {
            setTransition(view, false);
        }
        return false;
    }

    public GradientRectangleLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GradientRectangleLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TRANSITION_DURATION = 128;
    }
}
