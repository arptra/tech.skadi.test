package com.here.sdk.search;

import androidx.annotation.Nullable;
import com.here.NativeBase;

class PlaceIdSearchCallbackExtendedImpl extends NativeBase implements PlaceIdSearchCallbackExtended {
    public PlaceIdSearchCallbackExtendedImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                PlaceIdSearchCallbackExtendedImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onPlaceIdSearchExtendedCompleted(@Nullable SearchError searchError, @Nullable Place place, @Nullable ResponseDetails responseDetails);
}
