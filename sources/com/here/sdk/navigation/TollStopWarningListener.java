package com.here.sdk.navigation;

import androidx.annotation.NonNull;

public interface TollStopWarningListener {
    void onTollStopWarning(@NonNull TollStop tollStop);
}
