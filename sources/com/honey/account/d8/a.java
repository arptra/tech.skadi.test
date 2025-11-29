package com.honey.account.d8;

import android.media.AudioManager;
import com.upuphone.xr.sapp.audio.ArAudioFocusManager;

public final /* synthetic */ class a implements AudioManager.OnAudioFocusChangeListener {
    public final void onAudioFocusChange(int i) {
        ArAudioFocusManager.e(i);
    }
}
