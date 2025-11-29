package com.bun.miitmdid.interfaces;

import androidx.annotation.Keep;

@Keep
public interface IdSupplier {
    @Keep
    String getAAID();

    @Keep
    String getOAID();

    @Keep
    String getVAID();

    @Keep
    boolean isSupported();
}
