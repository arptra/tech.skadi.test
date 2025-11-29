package com.here.sdk.location;

import com.here.sdk.core.engine.SDKNativeEngine;
import com.here.sdk.location.LocationEngineFactory;

public final /* synthetic */ class j implements LocationEngineFactory.Factory {
    public final LocationEngineBase apply(SDKNativeEngine sDKNativeEngine) {
        return LocationInitializer.lambda$initialize$0(sDKNativeEngine);
    }
}
