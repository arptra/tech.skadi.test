package io.flutter.plugin.platform;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.view.AccessibilityBridge;

public interface PlatformViewsAccessibilityDelegate {
    void attachAccessibilityBridge(@NonNull AccessibilityBridge accessibilityBridge);

    void detachAccessibilityBridge();

    @Nullable
    View getPlatformViewById(int i);

    boolean usesVirtualDisplay(int i);
}
