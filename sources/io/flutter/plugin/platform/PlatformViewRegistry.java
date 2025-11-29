package io.flutter.plugin.platform;

import androidx.annotation.NonNull;

public interface PlatformViewRegistry {
    boolean registerViewFactory(@NonNull String str, @NonNull PlatformViewFactory platformViewFactory);
}
