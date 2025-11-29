package com.luck.picture.lib.photoview;

import android.view.View;

class Compat {
    public static void a(View view, Runnable runnable) {
        b(view, runnable);
    }

    public static void b(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }
}
