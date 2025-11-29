package io.flutter.plugin.platform;

import io.flutter.plugin.platform.PlatformPlugin;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlatformPlugin.AnonymousClass2 f8807a;
    public final /* synthetic */ int b;

    public /* synthetic */ a(PlatformPlugin.AnonymousClass2 r1, int i) {
        this.f8807a = r1;
        this.b = i;
    }

    public final void run() {
        this.f8807a.lambda$onSystemUiVisibilityChange$0(this.b);
    }
}
