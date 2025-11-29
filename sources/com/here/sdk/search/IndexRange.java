package com.here.sdk.search;

import com.here.NativeBase;

public final class IndexRange extends NativeBase {
    public IndexRange(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                IndexRange.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native int getEnd();

    public native int getStart();
}
