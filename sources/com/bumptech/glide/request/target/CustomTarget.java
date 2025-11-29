package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Util;

public abstract class CustomTarget<T> implements Target<T> {

    /* renamed from: a  reason: collision with root package name */
    public final int f2713a;
    public final int b;
    public Request c;

    public CustomTarget() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public final void a(SizeReadyCallback sizeReadyCallback) {
    }

    public final Request c() {
        return this.c;
    }

    public void g(Drawable drawable) {
    }

    public final void h(Request request) {
        this.c = request;
    }

    public void i(Drawable drawable) {
    }

    public final void j(SizeReadyCallback sizeReadyCallback) {
        sizeReadyCallback.d(this.f2713a, this.b);
    }

    public void onDestroy() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public CustomTarget(int i, int i2) {
        if (Util.v(i, i2)) {
            this.f2713a = i;
            this.b = i2;
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + i + " and height: " + i2);
    }
}
