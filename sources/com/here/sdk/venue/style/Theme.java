package com.here.sdk.venue.style;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import java.util.List;
import java.util.Map;

final class Theme extends NativeBase {
    public Theme(@NonNull Map<String, VenueGeometryStyle> map, @NonNull Map<String, IconInfo> map2, @NonNull Map<String, VenueLabelStyle> map3) {
        this(make(map, map2, map3), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    private static native long make(@NonNull Map<String, VenueGeometryStyle> map, @NonNull Map<String, IconInfo> map2, @NonNull Map<String, VenueLabelStyle> map3);

    @NonNull
    public native IconInfo getIcon(@NonNull String str);

    @NonNull
    public native List<String> getIconNames();

    @NonNull
    public native VenueLabelStyle getLabelStyle(@NonNull String str);

    @NonNull
    public native List<String> getLabelStyleNames();

    @NonNull
    public native VenueGeometryStyle getStyle(@NonNull String str);

    @NonNull
    public native List<String> getStyleNames();

    public Theme(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                Theme.disposeNativeHandle(j);
            }
        });
    }
}
