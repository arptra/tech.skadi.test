package com.bumptech.glide.request.transition;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;

public class DrawableCrossFadeFactory implements TransitionFactory<Drawable> {

    /* renamed from: a  reason: collision with root package name */
    public final int f2725a;
    public final boolean b;
    public DrawableCrossFadeTransition c;

    public static class Builder {
    }

    public Transition a(DataSource dataSource, boolean z) {
        return dataSource == DataSource.MEMORY_CACHE ? NoTransition.b() : b();
    }

    public final Transition b() {
        if (this.c == null) {
            this.c = new DrawableCrossFadeTransition(this.f2725a, this.b);
        }
        return this.c;
    }
}
