package com.honey.account.xa;

import android.graphics.ImageDecoder;
import io.flutter.embedding.engine.FlutterJNI;

public final /* synthetic */ class a implements ImageDecoder.OnHeaderDecodedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f7683a;

    public /* synthetic */ a(long j) {
        this.f7683a = j;
    }

    public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        FlutterJNI.lambda$decodeImage$0(this.f7683a, imageDecoder, imageInfo, source);
    }
}
