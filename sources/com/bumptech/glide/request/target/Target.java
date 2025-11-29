package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.transition.Transition;

public interface Target<R> extends LifecycleListener {
    void a(SizeReadyCallback sizeReadyCallback);

    Request c();

    void d(Drawable drawable);

    void e(Object obj, Transition transition);

    void g(Drawable drawable);

    void h(Request request);

    void i(Drawable drawable);

    void j(SizeReadyCallback sizeReadyCallback);
}
