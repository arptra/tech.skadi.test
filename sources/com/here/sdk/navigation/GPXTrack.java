package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.core.Location;
import java.util.List;

public final class GPXTrack extends NativeBase {
    public GPXTrack(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                GPXTrack.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public native String getDescription();

    @NonNull
    public native List<Location> getLocations();

    @NonNull
    public native String getName();

    public native void setDescription(@NonNull String str);

    public native void setName(@NonNull String str);
}
