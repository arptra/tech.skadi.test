package com.upuphone.xr.sapp.view;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.luck.picture.lib.engine.ImageEngine;
import com.luck.picture.lib.utils.ActivityCompatHelper;

public class GlideEngine implements ImageEngine {
    public void a(Context context, String str, ImageView imageView) {
        if (ActivityCompatHelper.a(context)) {
            Glide.t(context).s(str).z0(imageView);
        }
    }

    public void b(Context context) {
        Glide.t(context).v();
    }

    public void c(Context context, ImageView imageView, String str, int i, int i2) {
        if (ActivityCompatHelper.a(context)) {
            ((RequestBuilder) ((RequestBuilder) ((RequestBuilder) Glide.t(context).f().D0(str).U(i, i2)).e0(0.5f)).l0(new CenterCrop(), new RoundedCorners(8))).z0(imageView);
        }
    }

    public void d(Context context) {
        Glide.t(context).w();
    }

    public void e(Context context, String str, ImageView imageView) {
        if (ActivityCompatHelper.a(context)) {
            ((RequestBuilder) ((RequestBuilder) ((RequestBuilder) Glide.t(context).f().D0(str).U(180, 180)).e0(0.5f)).l0(new CenterCrop(), new RoundedCorners(8))).z0(imageView);
        }
    }

    public void f(Context context, String str, ImageView imageView) {
        if (ActivityCompatHelper.a(context)) {
            ((RequestBuilder) ((RequestBuilder) Glide.t(context).s(str).U(200, 200)).d()).z0(imageView);
        }
    }
}
