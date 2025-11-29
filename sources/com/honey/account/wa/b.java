package com.honey.account.wa;

import android.window.OnBackInvokedCallback;
import io.flutter.embedding.android.FlutterActivity;

public final /* synthetic */ class b implements OnBackInvokedCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FlutterActivity f7649a;

    public /* synthetic */ b(FlutterActivity flutterActivity) {
        this.f7649a = flutterActivity;
    }

    public final void onBackInvoked() {
        this.f7649a.onBackPressed();
    }
}
