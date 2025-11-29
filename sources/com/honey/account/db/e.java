package com.honey.account.db;

import android.content.Intent;
import io.flutter.plugins.imagepicker.ImagePickerDelegate;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImagePickerDelegate f7226a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Intent c;

    public /* synthetic */ e(ImagePickerDelegate imagePickerDelegate, int i, Intent intent) {
        this.f7226a = imagePickerDelegate;
        this.b = i;
        this.c = intent;
    }

    public final void run() {
        this.f7226a.lambda$onActivityResult$4(this.b, this.c);
    }
}
