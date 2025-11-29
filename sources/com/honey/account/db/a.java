package com.honey.account.db;

import android.content.Intent;
import io.flutter.plugins.imagepicker.ImagePickerDelegate;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImagePickerDelegate f7222a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Intent c;

    public /* synthetic */ a(ImagePickerDelegate imagePickerDelegate, int i, Intent intent) {
        this.f7222a = imagePickerDelegate;
        this.b = i;
        this.c = intent;
    }

    public final void run() {
        this.f7222a.lambda$onActivityResult$0(this.b, this.c);
    }
}
