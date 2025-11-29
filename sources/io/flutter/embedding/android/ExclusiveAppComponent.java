package io.flutter.embedding.android;

import androidx.annotation.NonNull;

public interface ExclusiveAppComponent<T> {
    void detachFromFlutterEngine();

    @NonNull
    T getAppComponent();
}
