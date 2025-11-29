package com.here.sdk.search;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.search.OfflineSearchIndex;

class OfflineSearchIndexListenerImpl extends NativeBase implements OfflineSearchIndexListener {
    public OfflineSearchIndexListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                OfflineSearchIndexListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onComplete(@Nullable OfflineSearchIndex.Error error);

    public native void onProgress(int i);

    public native void onStarted(@NonNull OfflineSearchIndex.Operation operation);
}
