package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.Request;

@Deprecated
public abstract class BaseTarget<Z> implements Target<Z> {

    /* renamed from: a  reason: collision with root package name */
    public Request f2712a;

    public Request c() {
        return this.f2712a;
    }

    public void d(Drawable drawable) {
    }

    public void g(Drawable drawable) {
    }

    public void h(Request request) {
        this.f2712a = request;
    }

    public void i(Drawable drawable) {
    }

    public void onDestroy() {
    }

    public void onStart() {
    }

    public void onStop() {
    }
}
