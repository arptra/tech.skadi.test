package com.honey.account.db;

import io.flutter.plugins.imagepicker.ImagePickerDelegate;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImagePickerDelegate f7227a;
    public final /* synthetic */ int b;

    public /* synthetic */ f(ImagePickerDelegate imagePickerDelegate, int i) {
        this.f7227a = imagePickerDelegate;
        this.b = i;
    }

    public final void run() {
        this.f7227a.lambda$onActivityResult$5(this.b);
    }
}
