package com.honey.account.z8;

import android.media.AudioManager;
import com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel;

public final /* synthetic */ class n implements AudioManager.OnAudioFocusChangeListener {
    public final void onAudioFocusChange(int i) {
        WakeupRecordingViewmodel.L(i);
    }
}
