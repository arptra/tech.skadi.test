package com.honey.account.u3;

import android.media.MediaPlayer;
import com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordHistoryDetailActivity;

public final /* synthetic */ class p implements MediaPlayer.OnCompletionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FastRecordHistoryDetailActivity f5196a;

    public /* synthetic */ p(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity) {
        this.f5196a = fastRecordHistoryDetailActivity;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        FastRecordHistoryDetailActivity.startMediaPlayer$lambda$47(this.f5196a, mediaPlayer);
    }
}
