package com.here.sdk.mapdata;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.core.GeoCoordinates;
import com.here.sdk.core.engine.SDKNativeEngine;
import com.here.sdk.core.errors.InstantiationErrorException;
import java.util.List;

public final class SegmentDataLoader extends NativeBase {
    public SegmentDataLoader() throws InstantiationErrorException {
        this(make(), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    private static native long make() throws InstantiationErrorException;

    private static native long make(@NonNull SDKNativeEngine sDKNativeEngine) throws InstantiationErrorException;

    @NonNull
    public native List<OCMSegmentId> getSegmentsAroundCoordinates(@NonNull GeoCoordinates geoCoordinates, double d) throws SegmentDataLoaderException;

    @NonNull
    public native SegmentData loadData(@NonNull OCMSegmentId oCMSegmentId, @NonNull SegmentDataLoaderOptions segmentDataLoaderOptions) throws SegmentDataLoaderException;

    public SegmentDataLoader(@NonNull SDKNativeEngine sDKNativeEngine) throws InstantiationErrorException {
        this(make(sDKNativeEngine), (Object) null);
        cacheThisInstance();
    }

    public SegmentDataLoader(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                SegmentDataLoader.disposeNativeHandle(j);
            }
        });
    }
}
