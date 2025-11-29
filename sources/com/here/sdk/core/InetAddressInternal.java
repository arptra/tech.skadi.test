package com.here.sdk.core;

import androidx.annotation.NonNull;

final class InetAddressInternal {
    @NonNull
    public String address;

    public InetAddressInternal(@NonNull String str) {
        this.address = str;
    }
}
