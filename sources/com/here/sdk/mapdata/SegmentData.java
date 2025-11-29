package com.here.sdk.mapdata;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.core.GeoPolyline;
import com.here.sdk.routing.SegmentReference;
import java.util.List;

public final class SegmentData extends NativeBase {
    private GeoPolyline cache_getPolyline;
    private boolean is_cached_getPolyline = false;

    public SegmentData(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                SegmentData.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    private native GeoPolyline getPolyline_private();

    public native int getLengthInMeters();

    @NonNull
    public native OCMSegmentId getOcmSegmentId();

    @NonNull
    public GeoPolyline getPolyline() {
        if (!this.is_cached_getPolyline) {
            this.cache_getPolyline = getPolyline_private();
            this.is_cached_getPolyline = true;
        }
        return this.cache_getPolyline;
    }

    @NonNull
    public native SegmentReference getSegmentReference();

    @NonNull
    public native List<SegmentSpanData> getSpans();
}
