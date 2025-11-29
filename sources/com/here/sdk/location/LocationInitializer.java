package com.here.sdk.location;

import android.util.Log;
import androidx.annotation.NonNull;
import com.here.sdk.core.engine.SDKNativeEngine;
import com.here.sdk.core.errors.InstantiationErrorException;

class LocationInitializer {
    private static final String LOG_TAG = LocationEngine.class.getSimpleName();

    public static void initialize(@NonNull SDKNativeEngine sDKNativeEngine) throws InstantiationErrorException {
        HerePositioningClient.fromSdkNativeEngine(sDKNativeEngine);
        LocationEngineFactory.setup(new j());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ LocationEngineBase lambda$initialize$0(SDKNativeEngine sDKNativeEngine) {
        try {
            return new LocationEngine(sDKNativeEngine);
        } catch (InstantiationErrorException e) {
            String str = LOG_TAG;
            Log.e(str, "Failed to create LocationEngine: " + e.getMessage());
            return null;
        }
    }
}
