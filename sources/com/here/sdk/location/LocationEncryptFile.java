package com.here.sdk.location;

import androidx.annotation.NonNull;
import com.here.NativeBase;

final class LocationEncryptFile extends NativeBase {
    public LocationEncryptFile(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                LocationEncryptFile.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public static native String readLocation(@NonNull String str);

    public static native void writeLocation(@NonNull String str, @NonNull String str2);
}
