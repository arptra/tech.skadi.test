package com.here.sdk.mapview;

import com.here.NativeBase;

class RenderTargetUpdatedListenerImpl extends NativeBase implements RenderTargetUpdatedListener {
    public RenderTargetUpdatedListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                RenderTargetUpdatedListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onRenderTargetAttached();

    public native void onRenderTargetUpdated();
}
