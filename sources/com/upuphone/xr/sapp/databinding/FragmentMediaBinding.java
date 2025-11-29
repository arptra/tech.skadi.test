package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;

public final class FragmentMediaBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RelativeLayout f6801a;
    public final ImageView b;
    public final TextView c;
    public final ImageView d;
    public final ImageView e;
    public final ImageView f;
    public final RelativeLayout g;
    public final VideoView h;

    public FragmentMediaBinding(RelativeLayout relativeLayout, ImageView imageView, TextView textView, ImageView imageView2, ImageView imageView3, ImageView imageView4, RelativeLayout relativeLayout2, VideoView videoView) {
        this.f6801a = relativeLayout;
        this.b = imageView;
        this.c = textView;
        this.d = imageView2;
        this.e = imageView3;
        this.f = imageView4;
        this.g = relativeLayout2;
        this.h = videoView;
    }

    public static FragmentMediaBinding a(View view) {
        int i = R.id.back_img;
        ImageView imageView = (ImageView) ViewBindings.a(view, i);
        if (imageView != null) {
            i = R.id.feedback_back_select;
            TextView textView = (TextView) ViewBindings.a(view, i);
            if (textView != null) {
                i = R.id.large_img;
                ImageView imageView2 = (ImageView) ViewBindings.a(view, i);
                if (imageView2 != null) {
                    i = R.id.play_img;
                    ImageView imageView3 = (ImageView) ViewBindings.a(view, i);
                    if (imageView3 != null) {
                        i = R.id.select_img;
                        ImageView imageView4 = (ImageView) ViewBindings.a(view, i);
                        if (imageView4 != null) {
                            i = R.id.titlebar_layout;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.a(view, i);
                            if (relativeLayout != null) {
                                i = R.id.video_player;
                                VideoView videoView = (VideoView) ViewBindings.a(view, i);
                                if (videoView != null) {
                                    return new FragmentMediaBinding((RelativeLayout) view, imageView, textView, imageView2, imageView3, imageView4, relativeLayout, videoView);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentMediaBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_media, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f6801a;
    }
}
