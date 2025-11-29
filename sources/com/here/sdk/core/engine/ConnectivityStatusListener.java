package com.here.sdk.core.engine;

import androidx.annotation.NonNull;

interface ConnectivityStatusListener {
    void onConnectivityStatusChange(@NonNull ConnectivityStatus connectivityStatus);
}
