package com.here.sdk.mapdata;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.core.engine.SDKNativeEngine;
import com.here.sdk.core.errors.InstantiationErrorException;
import com.here.sdk.routing.SegmentReference;

public final class SegmentReferenceConverter extends NativeBase {
    public SegmentReferenceConverter(@NonNull SDKNativeEngine sDKNativeEngine) throws InstantiationErrorException {
        this(make(sDKNativeEngine), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    private static native long make(@NonNull SDKNativeEngine sDKNativeEngine) throws InstantiationErrorException;

    @Nullable
    public native DirectedOCMSegmentId getOCMSegmentId(@NonNull SegmentReference segmentReference);

    public SegmentReferenceConverter(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                SegmentReferenceConverter.disposeNativeHandle(j);
            }
        });
    }
}
