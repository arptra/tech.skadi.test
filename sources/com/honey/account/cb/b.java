package com.honey.account.cb;

import android.view.View;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel;
import io.flutter.plugin.platform.PlatformViewsController;

public final /* synthetic */ class b implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlatformViewsController f7214a;
    public final /* synthetic */ PlatformViewsChannel.PlatformViewCreationRequest b;

    public /* synthetic */ b(PlatformViewsController platformViewsController, PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest) {
        this.f7214a = platformViewsController;
        this.b = platformViewCreationRequest;
    }

    public final void onFocusChange(View view, boolean z) {
        this.f7214a.lambda$configureForTextureLayerComposition$1(this.b, view, z);
    }
}
