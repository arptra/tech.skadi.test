package com.here.sdk.search;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.core.threading.OnTaskCompleted;
import com.here.sdk.core.threading.TaskHandle;
import java.util.List;

public final class MyPlaces extends NativeBase {
    public MyPlaces() {
        this(make(), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    private static native long make();

    @NonNull
    public native TaskHandle addPlace(@NonNull GeoPlace geoPlace, @NonNull OnTaskCompleted onTaskCompleted);

    @NonNull
    public native TaskHandle addPlaces(@NonNull List<GeoPlace> list, @NonNull OnTaskCompleted onTaskCompleted);

    @NonNull
    public native List<GeoPlace> getPlaces();

    @NonNull
    public native TaskHandle removeAll(@NonNull OnTaskCompleted onTaskCompleted);

    @NonNull
    public native TaskHandle removePlace(@NonNull String str, @NonNull OnTaskCompleted onTaskCompleted);

    @NonNull
    public native TaskHandle removePlaces(@NonNull List<String> list, @NonNull OnTaskCompleted onTaskCompleted);

    public MyPlaces(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                MyPlaces.disposeNativeHandle(j);
            }
        });
    }
}
