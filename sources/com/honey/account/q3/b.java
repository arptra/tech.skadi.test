package com.honey.account.q3;

import android.media.MediaPlayer;
import com.upuphone.ai.ttsengine.engines.wav.internal.WavTtsAgent;

public final /* synthetic */ class b implements MediaPlayer.OnErrorListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WavTtsAgent f5107a;

    public /* synthetic */ b(WavTtsAgent wavTtsAgent) {
        this.f5107a = wavTtsAgent;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        return WavTtsAgent.init$lambda$1(this.f5107a, mediaPlayer, i, i2);
    }
}
