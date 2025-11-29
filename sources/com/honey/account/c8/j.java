package com.honey.account.c8;

import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.VideoView;
import com.upuphone.xr.sapp.adapter.MediaPreviewAdapter;

public final /* synthetic */ class j implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VideoView f4215a;
    public final /* synthetic */ Uri b;
    public final /* synthetic */ ImageView c;
    public final /* synthetic */ ImageView d;

    public /* synthetic */ j(VideoView videoView, Uri uri, ImageView imageView, ImageView imageView2) {
        this.f4215a = videoView;
        this.b = uri;
        this.c = imageView;
        this.d = imageView2;
    }

    public final void onClick(View view) {
        MediaPreviewAdapter.f(this.f4215a, this.b, this.c, this.d, view);
    }
}
