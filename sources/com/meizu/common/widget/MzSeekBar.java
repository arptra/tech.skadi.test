package com.meizu.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.SeekBar;
import com.meizu.common.util.CommonUtils;

public class MzSeekBar extends SeekBar {
    public static final int STRENGTH_FEEDBACK_ID = 31011;
    public static final int WEAK_FEEDBACK_ID = 31014;
    private boolean hasContrastValue = true;
    /* access modifiers changed from: private */
    public boolean hasDowned;
    private boolean isEnableEngine = true;
    /* access modifiers changed from: private */
    public boolean isUpFirst;

    public MzSeekBar(Context context) {
        super(context);
        init();
    }

    /* access modifiers changed from: private */
    public void executeHapticFeedback(int i) {
        if (!this.isEnableEngine) {
            return;
        }
        if (this.hasContrastValue) {
            if (i == getMin()) {
                CommonUtils.shakeForFlymeFeature(this, WEAK_FEEDBACK_ID);
            } else if (i == getMax()) {
                CommonUtils.shakeForFlymeFeature(this, STRENGTH_FEEDBACK_ID);
            }
        } else if (i == getMin() || i == getMax()) {
            CommonUtils.shakeForFlymeFeature(this, STRENGTH_FEEDBACK_ID);
        }
    }

    private SeekBar.OnSeekBarChangeListener getProxyListener(final SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        return new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = onSeekBarChangeListener;
                if (onSeekBarChangeListener != null) {
                    onSeekBarChangeListener.onProgressChanged(seekBar, i, z);
                }
                if (!MzSeekBar.this.isUpFirst && MzSeekBar.this.hasDowned) {
                    MzSeekBar.this.executeHapticFeedback(i);
                }
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = onSeekBarChangeListener;
                if (onSeekBarChangeListener != null) {
                    onSeekBarChangeListener.onStartTrackingTouch(seekBar);
                }
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = onSeekBarChangeListener;
                if (onSeekBarChangeListener != null) {
                    onSeekBarChangeListener.onStopTrackingTouch(seekBar);
                }
            }
        };
    }

    private void init() {
        setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener) null);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.isUpFirst = false;
            this.hasDowned = true;
        } else if (action == 1) {
            this.isUpFirst = true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setEnableEngine(boolean z) {
        this.isEnableEngine = z;
    }

    public void setHasContrastValue(boolean z) {
        this.hasContrastValue = z;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        super.setOnSeekBarChangeListener(getProxyListener(onSeekBarChangeListener));
    }

    public MzSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MzSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
