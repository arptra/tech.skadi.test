package com.honey.account.n3;

import android.media.MediaPlayer;
import com.upuphone.ai.ttsengine.base.player.Mp3Player;

public final /* synthetic */ class c implements MediaPlayer.OnErrorListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Mp3Player f4953a;

    public /* synthetic */ c(Mp3Player mp3Player) {
        this.f4953a = mp3Player;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        return Mp3Player.v(this.f4953a, mediaPlayer, i, i2);
    }
}
