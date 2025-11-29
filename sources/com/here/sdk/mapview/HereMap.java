package com.here.sdk.mapview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;

public final class HereMap extends NativeBase {

    public interface RenderListener {
        void onFramePrepared();

        void onRenderTargetReleased();
    }

    public static class RenderListenerImpl extends NativeBase implements RenderListener {
        public RenderListenerImpl(long j, Object obj) {
            super(j, new NativeBase.Disposer() {
                public void disposeNative(long j) {
                    RenderListenerImpl.disposeNativeHandle(j);
                }
            });
        }

        /* access modifiers changed from: private */
        public static native void disposeNativeHandle(long j);

        public native void onFramePrepared();

        public native void onRenderTargetReleased();
    }

    public HereMap(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                HereMap.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void addMapIdleListener(@NonNull MapIdleListener mapIdleListener);

    public native void removeMapIdleListener(@NonNull MapIdleListener mapIdleListener);

    public native void setRenderListener(@Nullable RenderListener renderListener);
}
