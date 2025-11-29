package com.here.sdk.consent;

import android.util.Log;
import androidx.annotation.NonNull;
import com.here.sdk.core.engine.SDKNativeEngine;
import com.here.sdk.core.errors.InstantiationErrorException;

class ConsentInitializer {
    private static final String LOG_TAG = "ConsentInitializer";

    public static void initialize(@NonNull SDKNativeEngine sDKNativeEngine) throws InstantiationErrorException {
        try {
            ConsentInternal.fromSdkNativeEngine(sDKNativeEngine);
        } catch (InstantiationErrorException e) {
            Log.e(LOG_TAG, "Failed to initialise ConsentInternal", e);
            throw e;
        }
    }
}
