package com.here.sdk.mapview;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.core.Color;

public final class MapMarker3DModel extends NativeBase {

    public enum InstantiationErrorCode {
        MISSING_TEXTURE_COORDINATES(0);
        
        public final int value;

        private InstantiationErrorCode(int i) {
            this.value = i;
        }
    }

    public static final class InstantiationException extends Exception {
        public final InstantiationErrorCode error;

        public InstantiationException(InstantiationErrorCode instantiationErrorCode) {
            super(instantiationErrorCode.toString());
            this.error = instantiationErrorCode;
        }
    }

    public MapMarker3DModel(@NonNull String str, @NonNull String str2, @NonNull Color color) {
        this(make(str, str2, color), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    private static native long make(@NonNull Mesh mesh);

    private static native long make(@NonNull Mesh mesh, @NonNull String str) throws InstantiationException;

    private static native long make(@NonNull Mesh mesh, @NonNull String str, @NonNull Color color) throws InstantiationException;

    private static native long make(@NonNull String str);

    private static native long make(@NonNull String str, @NonNull String str2);

    private static native long make(@NonNull String str, @NonNull String str2, @NonNull Color color);

    public MapMarker3DModel(@NonNull Mesh mesh, @NonNull String str, @NonNull Color color) throws InstantiationException {
        this(make(mesh, str, color), (Object) null);
        cacheThisInstance();
    }

    public MapMarker3DModel(@NonNull String str, @NonNull String str2) {
        this(make(str, str2), (Object) null);
        cacheThisInstance();
    }

    public MapMarker3DModel(@NonNull Mesh mesh, @NonNull String str) throws InstantiationException {
        this(make(mesh, str), (Object) null);
        cacheThisInstance();
    }

    public MapMarker3DModel(@NonNull String str) {
        this(make(str), (Object) null);
        cacheThisInstance();
    }

    public MapMarker3DModel(@NonNull Mesh mesh) {
        this(make(mesh), (Object) null);
        cacheThisInstance();
    }

    public MapMarker3DModel(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                MapMarker3DModel.disposeNativeHandle(j);
            }
        });
    }
}
