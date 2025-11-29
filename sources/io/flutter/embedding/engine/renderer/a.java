package io.flutter.embedding.engine.renderer;

import android.media.ImageReader;
import io.flutter.embedding.engine.renderer.FlutterRenderer;

public final /* synthetic */ class a implements ImageReader.OnImageAvailableListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FlutterRenderer.ImageReaderSurfaceProducer.PerImageReader f8802a;

    public /* synthetic */ a(FlutterRenderer.ImageReaderSurfaceProducer.PerImageReader perImageReader) {
        this.f8802a = perImageReader;
    }

    public final void onImageAvailable(ImageReader imageReader) {
        this.f8802a.lambda$new$0(imageReader);
    }
}
