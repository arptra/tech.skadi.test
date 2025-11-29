package com.here.sdk.mapview;

import androidx.annotation.NonNull;
import com.here.NativeBase;

public class MapItemRepresentation extends NativeBase {

    public static final class Impl extends NativeBase {
        public Impl(long j, Object obj) {
            super(j, new NativeBase.Disposer() {
                public void disposeNative(long j) {
                    Impl.disposeNativeHandle(j);
                }
            });
        }

        /* access modifiers changed from: private */
        public static native void disposeNativeHandle(long j);
    }

    public MapItemRepresentation(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                MapItemRepresentation.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public native Impl getImpl();
}
