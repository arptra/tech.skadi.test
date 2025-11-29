package com.bumptech.glide.request.transition;

import android.graphics.drawable.Drawable;
import android.view.View;

public interface Transition<R> {

    public interface ViewAdapter {
        Drawable b();

        void f(Drawable drawable);

        View getView();
    }

    boolean a(Object obj, ViewAdapter viewAdapter);
}
