package com.honey.account.db;

import android.content.Intent;
import io.flutter.plugins.imagepicker.ImagePickerDelegate;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImagePickerDelegate f7225a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Intent c;

    public /* synthetic */ d(ImagePickerDelegate imagePickerDelegate, int i, Intent intent) {
        this.f7225a = imagePickerDelegate;
        this.b = i;
        this.c = intent;
    }

    public final void run() {
        this.f7225a.lambda$onActivityResult$3(this.b, this.c);
    }
}
