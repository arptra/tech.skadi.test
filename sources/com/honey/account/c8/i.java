package com.honey.account.c8;

import android.media.MediaPlayer;
import android.widget.ImageView;
import android.widget.VideoView;
import com.upuphone.xr.sapp.adapter.MediaPreviewAdapter;

public final /* synthetic */ class i implements MediaPlayer.OnCompletionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImageView f4214a;
    public final /* synthetic */ ImageView b;
    public final /* synthetic */ VideoView c;

    public /* synthetic */ i(ImageView imageView, ImageView imageView2, VideoView videoView) {
        this.f4214a = imageView;
        this.b = imageView2;
        this.c = videoView;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        MediaPreviewAdapter.e(this.f4214a, this.b, this.c, mediaPlayer);
    }
}
