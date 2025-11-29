package com.here.sdk.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;

public final class Metadata extends NativeBase {
    public Metadata() {
        this(make(), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    private static native long make();

    @Nullable
    public native CustomMetadataValue getCustomValue(@NonNull String str);

    @Nullable
    public native Double getDouble(@NonNull String str);

    @Nullable
    public native GeoCoordinates getGeoCoordinates(@NonNull String str);

    @Nullable
    public native Integer getInteger(@NonNull String str);

    @Nullable
    public native String getString(@NonNull String str);

    @Nullable
    public native MetadataType getType(@NonNull String str);

    public native void removeValue(@NonNull String str);

    public native void setCustomValue(@NonNull String str, @NonNull CustomMetadataValue customMetadataValue);

    public native void setDouble(@NonNull String str, double d);

    public native void setGeoCoordinates(@NonNull String str, @NonNull GeoCoordinates geoCoordinates);

    public native void setInteger(@NonNull String str, int i);

    public native void setString(@NonNull String str, @NonNull String str2);

    public Metadata(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                Metadata.disposeNativeHandle(j);
            }
        });
    }
}
