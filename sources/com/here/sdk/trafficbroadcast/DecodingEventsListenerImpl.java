package com.here.sdk.trafficbroadcast;

import com.here.NativeBase;

class DecodingEventsListenerImpl extends NativeBase implements DecodingEventsListener {
    public DecodingEventsListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                DecodingEventsListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onDecodingFailed();

    public native void onDecodingSucceeded();
}
