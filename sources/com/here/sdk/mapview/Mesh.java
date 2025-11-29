package com.here.sdk.mapview;

import com.here.NativeBase;

public final class Mesh extends NativeBase {
    public Mesh(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                Mesh.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);
}
