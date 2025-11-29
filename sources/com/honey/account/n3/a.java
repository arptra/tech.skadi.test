package com.honey.account.n3;

import android.media.MediaPlayer;
import com.upuphone.ai.ttsengine.base.player.Mp3Player;

public final /* synthetic */ class a implements MediaPlayer.OnPreparedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Mp3Player f4951a;

    public /* synthetic */ a(Mp3Player mp3Player) {
        this.f4951a = mp3Player;
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        Mp3Player.t(this.f4951a, mediaPlayer);
    }
}
