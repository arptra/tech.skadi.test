package io.flutter.embedding.engine.renderer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface RenderSurface {
    void attachToRenderer(@NonNull FlutterRenderer flutterRenderer);

    void detachFromRenderer();

    @Nullable
    FlutterRenderer getAttachedRenderer();

    void pause();

    void resume();
}
