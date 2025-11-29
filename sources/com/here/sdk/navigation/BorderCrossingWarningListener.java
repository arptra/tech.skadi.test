package com.here.sdk.navigation;

import androidx.annotation.NonNull;

public interface BorderCrossingWarningListener {
    void onBorderCrossingWarningUpdated(@NonNull BorderCrossingWarning borderCrossingWarning);
}
