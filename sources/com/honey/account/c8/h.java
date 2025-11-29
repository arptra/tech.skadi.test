package com.honey.account.c8;

import android.view.View;
import android.widget.ImageView;
import android.widget.VideoView;
import com.upuphone.xr.sapp.adapter.MediaPreviewAdapter;

public final /* synthetic */ class h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImageView f4213a;
    public final /* synthetic */ ImageView b;
    public final /* synthetic */ VideoView c;
    public final /* synthetic */ MediaPreviewAdapter d;

    public /* synthetic */ h(ImageView imageView, ImageView imageView2, VideoView videoView, MediaPreviewAdapter mediaPreviewAdapter) {
        this.f4213a = imageView;
        this.b = imageView2;
        this.c = videoView;
        this.d = mediaPreviewAdapter;
    }

    public final void onClick(View view) {
        MediaPreviewAdapter.d(this.f4213a, this.b, this.c, this.d, view);
    }
}
