package com.upuphone.xr.sapp.adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.VideoView;
import androidx.viewpager.widget.PagerAdapter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.honey.account.c8.h;
import com.honey.account.c8.i;
import com.honey.account.c8.j;
import com.upuphone.xr.sapp.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0017¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0014\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006("}, d2 = {"Lcom/upuphone/xr/sapp/adapter/MediaPreviewAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "Landroid/content/Context;", "context", "", "Landroid/net/Uri;", "mData", "<init>", "(Landroid/content/Context;Ljava/util/List;)V", "Landroid/view/ViewGroup;", "container", "", "position", "", "instantiateItem", "(Landroid/view/ViewGroup;I)Ljava/lang/Object;", "getCount", "()I", "object", "", "destroyItem", "(Landroid/view/ViewGroup;ILjava/lang/Object;)V", "Landroid/view/View;", "view", "o", "", "isViewFromObject", "(Landroid/view/View;Ljava/lang/Object;)Z", "a", "Landroid/content/Context;", "b", "Ljava/util/List;", "Landroid/widget/VideoView;", "c", "Landroid/widget/VideoView;", "mVideoPlayer", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "mPlayImg", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class MediaPreviewAdapter extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final Context f6613a;
    public final List b;
    public VideoView c;
    public ImageView d;

    public MediaPreviewAdapter(Context context, List list) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "mData");
        this.f6613a = context;
        this.b = list;
    }

    public static final void d(ImageView imageView, ImageView imageView2, VideoView videoView, MediaPreviewAdapter mediaPreviewAdapter, View view) {
        Intrinsics.checkNotNullParameter(imageView, "$largeImg");
        Intrinsics.checkNotNullParameter(imageView2, "$playImg");
        Intrinsics.checkNotNullParameter(videoView, "$videoPlayer");
        Intrinsics.checkNotNullParameter(mediaPreviewAdapter, "this$0");
        imageView.setVisibility(8);
        imageView2.setVisibility(8);
        videoView.setVisibility(0);
        videoView.start();
        mediaPreviewAdapter.c = videoView;
        mediaPreviewAdapter.d = imageView2;
    }

    public static final void e(ImageView imageView, ImageView imageView2, VideoView videoView, MediaPlayer mediaPlayer) {
        Intrinsics.checkNotNullParameter(imageView, "$largeImg");
        Intrinsics.checkNotNullParameter(imageView2, "$playImg");
        Intrinsics.checkNotNullParameter(videoView, "$videoPlayer");
        imageView.setVisibility(0);
        imageView2.setVisibility(0);
        videoView.setVisibility(8);
    }

    public static final void f(VideoView videoView, Uri uri, ImageView imageView, ImageView imageView2, View view) {
        Intrinsics.checkNotNullParameter(videoView, "$videoPlayer");
        Intrinsics.checkNotNullParameter(uri, "$media");
        Intrinsics.checkNotNullParameter(imageView, "$playImg");
        Intrinsics.checkNotNullParameter(imageView2, "$largeImg");
        videoView.stopPlayback();
        videoView.setVideoURI(Uri.parse(uri.getPath()));
        imageView.setVisibility(0);
        imageView2.setVisibility(0);
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        Intrinsics.checkNotNullParameter(obj, "object");
        viewGroup.removeView((View) obj);
    }

    public int getCount() {
        return this.b.size();
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = LayoutInflater.from(this.f6613a).inflate(R.layout.item_media_show, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        View findViewById = inflate.findViewById(R.id.video_player);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.VideoView");
        VideoView videoView = (VideoView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.large_img);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView imageView = (ImageView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.play_img);
        Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView imageView2 = (ImageView) findViewById3;
        Uri uri = (Uri) this.b.get(i);
        String type = this.f6613a.getContentResolver().getType(uri);
        if (type == null) {
            type = "";
        }
        if (StringsKt.startsWith$default(type, "video/", false, 2, (Object) null)) {
            imageView2.setVisibility(0);
            videoView.setVideoURI(uri);
            videoView.stopPlayback();
        } else {
            imageView2.setVisibility(8);
        }
        Context context = this.f6613a;
        MediaPreviewAdapter$instantiateItem$1$1 mediaPreviewAdapter$instantiateItem$1$1 = (MediaPreviewAdapter$instantiateItem$1$1) ((RequestBuilder) ((RequestBuilder) ((RequestBuilder) Glide.t(context).f().B0(uri).V(R.color.default_img)).j()).U(context.getResources().getDisplayMetrics().widthPixels, context.getResources().getDisplayMetrics().heightPixels)).w0(new MediaPreviewAdapter$instantiateItem$1$1(imageView));
        imageView2.setOnClickListener(new h(imageView, imageView2, videoView, this));
        videoView.setOnCompletionListener(new i(imageView, imageView2, videoView));
        videoView.setOnClickListener(new j(videoView, uri, imageView2, imageView));
        viewGroup.addView(inflate);
        return inflate;
    }

    public boolean isViewFromObject(View view, Object obj) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(obj, "o");
        return view == obj;
    }
}
