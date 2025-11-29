package com.here.sdk.search;

import androidx.annotation.Nullable;
import com.here.NativeBase;
import java.util.List;

class SearchCallbackImpl extends NativeBase implements SearchCallback {
    public SearchCallbackImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                SearchCallbackImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onSearchCompleted(@Nullable SearchError searchError, @Nullable List<Place> list);
}
