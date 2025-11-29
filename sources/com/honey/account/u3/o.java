package com.honey.account.u3;

import android.media.MediaPlayer;
import com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordHistoryDetailActivity;

public final /* synthetic */ class o implements MediaPlayer.OnPreparedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FastRecordHistoryDetailActivity f5194a;

    public /* synthetic */ o(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity) {
        this.f5194a = fastRecordHistoryDetailActivity;
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        FastRecordHistoryDetailActivity.startMediaPlayer$lambda$46(this.f5194a, mediaPlayer);
    }
}
