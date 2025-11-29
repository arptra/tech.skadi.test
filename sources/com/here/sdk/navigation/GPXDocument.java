package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.core.errors.InstantiationErrorException;
import java.util.List;

public final class GPXDocument extends NativeBase {
    public GPXDocument(@NonNull String str, @NonNull GPXOptions gPXOptions) throws InstantiationErrorException {
        this(make(str, gPXOptions), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public static native GPXDocument fromString(@NonNull String str, @NonNull GPXOptions gPXOptions) throws InstantiationErrorException;

    private static native long make(@NonNull String str, @NonNull GPXOptions gPXOptions) throws InstantiationErrorException;

    private static native long make(@NonNull List<GPXTrack> list);

    public native void addTrack(@NonNull GPXTrack gPXTrack);

    @NonNull
    public native List<GPXTrack> getTracks();

    public native boolean save(@NonNull String str);

    public GPXDocument(@NonNull List<GPXTrack> list) {
        this(make(list), (Object) null);
        cacheThisInstance();
    }

    public GPXDocument(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                GPXDocument.disposeNativeHandle(j);
            }
        });
    }
}
