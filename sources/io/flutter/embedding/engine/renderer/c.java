package io.flutter.embedding.engine.renderer;

import android.graphics.SurfaceTexture;
import io.flutter.embedding.engine.renderer.FlutterRenderer;

public final /* synthetic */ class c implements SurfaceTexture.OnFrameAvailableListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FlutterRenderer.SurfaceTextureRegistryEntry f8804a;

    public /* synthetic */ c(FlutterRenderer.SurfaceTextureRegistryEntry surfaceTextureRegistryEntry) {
        this.f8804a = surfaceTextureRegistryEntry;
    }

    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f8804a.lambda$new$1(surfaceTexture);
    }
}
