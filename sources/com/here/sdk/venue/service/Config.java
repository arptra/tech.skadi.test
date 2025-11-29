package com.here.sdk.venue.service;

import androidx.annotation.NonNull;

interface Config {
    @NonNull
    String getPrivateDir();

    @NonNull
    String getPublicDir();

    void initialiseRenderer();
}
