package com.honey.account.q3;

import android.media.MediaPlayer;
import com.upuphone.ai.ttsengine.engines.wav.internal.WavTtsAgent;

public final /* synthetic */ class a implements MediaPlayer.OnCompletionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WavTtsAgent f5106a;

    public /* synthetic */ a(WavTtsAgent wavTtsAgent) {
        this.f5106a = wavTtsAgent;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        WavTtsAgent.init$lambda$0(this.f5106a, mediaPlayer);
    }
}
