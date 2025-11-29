package com.meizu.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityNodeInfo;
import com.meizu.common.R;

public class VerticalSeekBar extends AbsSeekBar {
    private OnVerSeekBarChangeListener mOnSeekBarChangeListener;

    public interface OnVerSeekBarChangeListener {
        void onProgressChanged(VerticalSeekBar verticalSeekBar, int i, boolean z);

        void onStartTrackingTouch(VerticalSeekBar verticalSeekBar);

        void onStopTrackingTouch(VerticalSeekBar verticalSeekBar);
    }

    public VerticalSeekBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(VerticalSeekBar.class.getName());
    }

    public void onProgressRefresh(float f, boolean z) {
        super.onProgressRefresh(f, z);
        OnVerSeekBarChangeListener onVerSeekBarChangeListener = this.mOnSeekBarChangeListener;
        if (onVerSeekBarChangeListener != null) {
            onVerSeekBarChangeListener.onProgressChanged(this, getProgress(), z);
        }
    }

    public void onStartTrackingTouch() {
        super.onStartTrackingTouch();
        OnVerSeekBarChangeListener onVerSeekBarChangeListener = this.mOnSeekBarChangeListener;
        if (onVerSeekBarChangeListener != null) {
            onVerSeekBarChangeListener.onStartTrackingTouch(this);
        }
    }

    public void onStopTrackingTouch() {
        super.onStopTrackingTouch();
        OnVerSeekBarChangeListener onVerSeekBarChangeListener = this.mOnSeekBarChangeListener;
        if (onVerSeekBarChangeListener != null) {
            onVerSeekBarChangeListener.onStopTrackingTouch(this);
        }
    }

    public void setOnSeekBarChangeListener(OnVerSeekBarChangeListener onVerSeekBarChangeListener) {
        this.mOnSeekBarChangeListener = onVerSeekBarChangeListener;
    }

    public VerticalSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.MeizuCommon_VerticalSeekBarStyle);
    }

    public VerticalSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SeekBar, i, 0);
        setBreakPoint(obtainStyledAttributes.getInt(R.styleable.SeekBar_mcBreakPoint, 0));
        obtainStyledAttributes.recycle();
        setIsVertical(true);
        setTouchMode(1);
    }
}
