package com.here.sdk.maploader;

import com.here.NativeBase;

public final class MapDownloaderTask extends NativeBase {
    public MapDownloaderTask(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                MapDownloaderTask.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void cancel();

    public native void pause();

    public native void pause(boolean z);

    public native void resume();
}
