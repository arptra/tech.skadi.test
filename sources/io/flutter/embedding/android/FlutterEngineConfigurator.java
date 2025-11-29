package io.flutter.embedding.android;

import androidx.annotation.NonNull;
import io.flutter.embedding.engine.FlutterEngine;

public interface FlutterEngineConfigurator {
    void cleanUpFlutterEngine(@NonNull FlutterEngine flutterEngine);

    void configureFlutterEngine(@NonNull FlutterEngine flutterEngine);
}
