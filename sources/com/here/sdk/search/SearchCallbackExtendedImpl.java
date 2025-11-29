package com.here.sdk.search;

import androidx.annotation.Nullable;
import com.here.NativeBase;
import java.util.List;

class SearchCallbackExtendedImpl extends NativeBase implements SearchCallbackExtended {
    public SearchCallbackExtendedImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                SearchCallbackExtendedImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onSearchExtendedCompleted(@Nullable SearchError searchError, @Nullable List<Place> list, @Nullable ResponseDetails responseDetails);
}
