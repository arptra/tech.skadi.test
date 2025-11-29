package com.honey.account.db;

import io.flutter.plugins.imagepicker.ImagePickerDelegate;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImagePickerDelegate f7224a;
    public final /* synthetic */ int b;

    public /* synthetic */ c(ImagePickerDelegate imagePickerDelegate, int i) {
        this.f7224a = imagePickerDelegate;
        this.b = i;
    }

    public final void run() {
        this.f7224a.lambda$onActivityResult$2(this.b);
    }
}
