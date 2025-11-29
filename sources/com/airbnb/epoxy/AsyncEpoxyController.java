package com.airbnb.epoxy;

import android.os.Handler;

public abstract class AsyncEpoxyController extends EpoxyController {
    public AsyncEpoxyController() {
        this(true);
    }

    private static Handler getHandler(boolean z) {
        return z ? EpoxyAsyncUtil.c() : EpoxyAsyncUtil.f2282a;
    }

    public AsyncEpoxyController(boolean z) {
        this(z, z);
    }

    public AsyncEpoxyController(boolean z, boolean z2) {
        super(getHandler(z), getHandler(z2));
    }
}
