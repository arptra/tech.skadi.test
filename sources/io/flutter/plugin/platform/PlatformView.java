package io.flutter.plugin.platform;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface PlatformView {
    void dispose();

    @Nullable
    View getView();

    @SuppressLint({"NewApi"})
    void onFlutterViewAttached(@NonNull View view) {
    }

    @SuppressLint({"NewApi"})
    void onFlutterViewDetached() {
    }

    @SuppressLint({"NewApi"})
    void onInputConnectionLocked() {
    }

    @SuppressLint({"NewApi"})
    void onInputConnectionUnlocked() {
    }
}
