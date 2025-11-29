package com.honey.account.cb;

import android.view.View;
import io.flutter.plugin.platform.PlatformViewsController;

public final /* synthetic */ class a implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlatformViewsController f7213a;
    public final /* synthetic */ int b;

    public /* synthetic */ a(PlatformViewsController platformViewsController, int i) {
        this.f7213a = platformViewsController;
        this.b = i;
    }

    public final void onFocusChange(View view, boolean z) {
        this.f7213a.lambda$initializePlatformViewIfNeeded$2(this.b, view, z);
    }
}
