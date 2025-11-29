package io.flutter.embedding.engine.systemchannels;

import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class a implements PlatformViewsChannel.PlatformViewBufferResized {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f8805a;

    public /* synthetic */ a(MethodChannel.Result result) {
        this.f8805a = result;
    }

    public final void run(PlatformViewsChannel.PlatformViewBufferSize platformViewBufferSize) {
        PlatformViewsChannel.AnonymousClass1.lambda$resize$0(this.f8805a, platformViewBufferSize);
    }
}
