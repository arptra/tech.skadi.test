package com.honey.account.db;

import android.content.Intent;
import io.flutter.plugins.imagepicker.ImagePickerDelegate;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImagePickerDelegate f7223a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Intent c;

    public /* synthetic */ b(ImagePickerDelegate imagePickerDelegate, int i, Intent intent) {
        this.f7223a = imagePickerDelegate;
        this.b = i;
        this.c = intent;
    }

    public final void run() {
        this.f7223a.lambda$onActivityResult$1(this.b, this.c);
    }
}
