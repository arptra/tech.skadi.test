package io.flutter.plugin.platform;

import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel;
import io.flutter.plugin.platform.PlatformViewsController;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlatformViewsController.AnonymousClass1 f8808a;
    public final /* synthetic */ VirtualDisplayController b;
    public final /* synthetic */ float c;
    public final /* synthetic */ PlatformViewsChannel.PlatformViewBufferResized d;

    public /* synthetic */ b(PlatformViewsController.AnonymousClass1 r1, VirtualDisplayController virtualDisplayController, float f, PlatformViewsChannel.PlatformViewBufferResized platformViewBufferResized) {
        this.f8808a = r1;
        this.b = virtualDisplayController;
        this.c = f;
        this.d = platformViewBufferResized;
    }

    public final void run() {
        this.f8808a.lambda$resize$0(this.b, this.c, this.d);
    }
}
