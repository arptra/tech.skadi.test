package com.here.sdk.search;

import androidx.annotation.Nullable;
import com.here.NativeBase;

class PlaceIdSearchCallbackImpl extends NativeBase implements PlaceIdSearchCallback {
    public PlaceIdSearchCallbackImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                PlaceIdSearchCallbackImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onPlaceIdSearchCompleted(@Nullable SearchError searchError, @Nullable Place place);
}
