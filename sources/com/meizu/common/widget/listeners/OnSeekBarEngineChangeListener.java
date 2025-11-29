package com.meizu.common.widget.listeners;

import android.widget.SeekBar;
import com.meizu.common.util.CommonUtils;

public abstract class OnSeekBarEngineChangeListener implements SeekBar.OnSeekBarChangeListener {
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (!z) {
            return;
        }
        if (i <= 0 || i >= seekBar.getMax()) {
            CommonUtils.shakeForFlymeFeature(seekBar);
        }
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}
