package com.here.sdk.core.engine;

import android.content.Context;
import android.net.ConnectivityManager;
import androidx.annotation.NonNull;

class AndroidCAresInitialiserBridge implements CAresInitialiserBridge {
    private static final String TAG = AndroidOptionalModulesInitializer.class.getSimpleName();

    private static native void initCAresWithConnectivityManager(@NonNull ConnectivityManager connectivityManager);

    public void extractConnectivityManager(@NonNull Context context) {
        initCAresWithConnectivityManager((ConnectivityManager) context.getSystemService("connectivity"));
    }
}
