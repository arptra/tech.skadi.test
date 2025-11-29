package com.honey.account.cb;

import android.view.View;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel;
import io.flutter.plugin.platform.PlatformViewsController;

public final /* synthetic */ class c implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlatformViewsController f7215a;
    public final /* synthetic */ PlatformViewsChannel.PlatformViewCreationRequest b;

    public /* synthetic */ c(PlatformViewsController platformViewsController, PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest) {
        this.f7215a = platformViewsController;
        this.b = platformViewCreationRequest;
    }

    public final void onFocusChange(View view, boolean z) {
        this.f7215a.lambda$configureForVirtualDisplay$0(this.b, view, z);
    }
}
