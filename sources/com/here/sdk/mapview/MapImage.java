package com.here.sdk.mapview;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.core.errors.InstantiationErrorException;

public final class MapImage extends NativeBase {

    public enum InstantiationErrorCode {
        UNKNOWN(1),
        UNSUPPORTED_IMAGE_FORMAT(2),
        INVALID_IMAGE_DIMENSIONS(3),
        EMPTY_FILE_PATH(4),
        EMPTY_IMAGE_DATA(5);
        
        final int value;

        private InstantiationErrorCode(int i) {
            this.value = i;
        }
    }

    public static final class InstantiationException extends Exception {
        final InstantiationErrorCode error;

        public InstantiationException(InstantiationErrorCode instantiationErrorCode) {
            super(instantiationErrorCode.toString());
            this.error = instantiationErrorCode;
        }
    }

    public MapImage(@NonNull byte[] bArr, @NonNull ImageFormat imageFormat) {
        this(make(bArr, imageFormat), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    private static native long make(@NonNull String str, int i, int i2) throws InstantiationException;

    private static native long make(@NonNull String str, long j, long j2) throws InstantiationErrorException;

    private static native long make(@NonNull byte[] bArr) throws InstantiationException;

    private static native long make(@NonNull byte[] bArr, int i, int i2) throws InstantiationException;

    private static native long make(@NonNull byte[] bArr, @NonNull ImageFormat imageFormat);

    private static native long make(@NonNull byte[] bArr, @NonNull ImageFormat imageFormat, long j, long j2);

    public MapImage(@NonNull byte[] bArr, @NonNull ImageFormat imageFormat, long j, long j2) {
        this(make(bArr, imageFormat, j, j2), (Object) null);
        cacheThisInstance();
    }

    public MapImage(@NonNull byte[] bArr) throws InstantiationException {
        this(make(bArr), (Object) null);
        cacheThisInstance();
    }

    public MapImage(@NonNull byte[] bArr, int i, int i2) throws InstantiationException {
        this(make(bArr, i, i2), (Object) null);
        cacheThisInstance();
    }

    public MapImage(@NonNull String str, long j, long j2) throws InstantiationErrorException {
        this(make(str, j, j2), (Object) null);
        cacheThisInstance();
    }

    public MapImage(@NonNull String str, int i, int i2) throws InstantiationException {
        this(make(str, i, i2), (Object) null);
        cacheThisInstance();
    }

    public MapImage(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                MapImage.disposeNativeHandle(j);
            }
        });
    }
}
