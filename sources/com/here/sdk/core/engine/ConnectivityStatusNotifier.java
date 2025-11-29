package com.here.sdk.core.engine;

import androidx.annotation.NonNull;

interface ConnectivityStatusNotifier {

    public enum NetworkState {
        NOT_CONNECTED(0),
        WIFI(1),
        CELLULAR(2);
        
        public final int value;

        private NetworkState(int i) {
            this.value = i;
        }
    }

    @NonNull
    NetworkState getNetworkState();

    void start();

    void subscribe(@NonNull ConnectivityStatusListener connectivityStatusListener);
}
