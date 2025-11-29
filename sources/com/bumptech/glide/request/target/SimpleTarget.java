package com.bumptech.glide.request.target;

import com.bumptech.glide.util.Util;

@Deprecated
public abstract class SimpleTarget<Z> extends BaseTarget<Z> {
    public final int b;
    public final int c;

    public void a(SizeReadyCallback sizeReadyCallback) {
    }

    public final void j(SizeReadyCallback sizeReadyCallback) {
        if (Util.v(this.b, this.c)) {
            sizeReadyCallback.d(this.b, this.c);
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.b + " and height: " + this.c + ", either provide dimensions in the constructor or call override()");
    }
}
