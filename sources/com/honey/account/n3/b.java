package com.honey.account.n3;

import android.media.MediaPlayer;
import com.upuphone.ai.ttsengine.base.player.Mp3Player;

public final /* synthetic */ class b implements MediaPlayer.OnCompletionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Mp3Player f4952a;

    public /* synthetic */ b(Mp3Player mp3Player) {
        this.f4952a = mp3Player;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        Mp3Player.u(this.f4952a, mediaPlayer);
    }
}
