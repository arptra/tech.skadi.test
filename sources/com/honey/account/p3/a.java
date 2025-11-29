package com.honey.account.p3;

import android.media.AudioManager;
import com.upuphone.ai.ttsengine.base.utils.AudioFocusManager;

public final /* synthetic */ class a implements AudioManager.OnAudioFocusChangeListener {
    public final void onAudioFocusChange(int i) {
        AudioFocusManager.k(i);
    }
}
