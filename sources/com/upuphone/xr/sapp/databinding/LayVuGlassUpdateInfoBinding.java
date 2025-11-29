package com.upuphone.xr.sapp.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.meizu.common.widget.MzButton;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.view.DownloadProgressView;
import com.upuphone.xr.sapp.view.InstallingProgressView;

public final class LayVuGlassUpdateInfoBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f6862a;
    public final MzButton b;
    public final ImageView c;
    public final LinearLayout d;
    public final FrameLayout e;
    public final DownloadProgressView f;
    public final InstallingProgressView g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final TextView k;

    public LayVuGlassUpdateInfoBinding(LinearLayout linearLayout, MzButton mzButton, ImageView imageView, LinearLayout linearLayout2, FrameLayout frameLayout, DownloadProgressView downloadProgressView, InstallingProgressView installingProgressView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.f6862a = linearLayout;
        this.b = mzButton;
        this.c = imageView;
        this.d = linearLayout2;
        this.e = frameLayout;
        this.f = downloadProgressView;
        this.g = installingProgressView;
        this.h = textView;
        this.i = textView2;
        this.j = textView3;
        this.k = textView4;
    }

    public static LayVuGlassUpdateInfoBinding a(View view) {
        int i2 = R.id.btn_upgrade;
        MzButton mzButton = (MzButton) ViewBindings.a(view, i2);
        if (mzButton != null) {
            i2 = R.id.iv_glass_update;
            ImageView imageView = (ImageView) ViewBindings.a(view, i2);
            if (imageView != null) {
                i2 = R.id.lay_update_log;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.a(view, i2);
                if (linearLayout != null) {
                    i2 = R.id.lay_update_progress;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.a(view, i2);
                    if (frameLayout != null) {
                        i2 = R.id.pb_download;
                        DownloadProgressView downloadProgressView = (DownloadProgressView) ViewBindings.a(view, i2);
                        if (downloadProgressView != null) {
                            i2 = R.id.pb_update;
                            InstallingProgressView installingProgressView = (InstallingProgressView) ViewBindings.a(view, i2);
                            if (installingProgressView != null) {
                                i2 = R.id.tv_latest_version;
                                TextView textView = (TextView) ViewBindings.a(view, i2);
                                if (textView != null) {
                                    i2 = R.id.tv_update_status;
                                    TextView textView2 = (TextView) ViewBindings.a(view, i2);
                                    if (textView2 != null) {
                                        i2 = R.id.tv_update_status_desc;
                                        TextView textView3 = (TextView) ViewBindings.a(view, i2);
                                        if (textView3 != null) {
                                            i2 = R.id.tv_version_desc;
                                            TextView textView4 = (TextView) ViewBindings.a(view, i2);
                                            if (textView4 != null) {
                                                return new LayVuGlassUpdateInfoBinding((LinearLayout) view, mzButton, imageView, linearLayout, frameLayout, downloadProgressView, installingProgressView, textView, textView2, textView3, textView4);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f6862a;
    }
}
