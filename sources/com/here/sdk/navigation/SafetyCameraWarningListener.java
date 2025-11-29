package com.here.sdk.navigation;

import androidx.annotation.NonNull;

public interface SafetyCameraWarningListener {
    void onSafetyCameraWarningUpdated(@NonNull SafetyCameraWarning safetyCameraWarning);
}
