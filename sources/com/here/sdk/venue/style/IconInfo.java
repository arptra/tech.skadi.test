package com.here.sdk.venue.style;

import androidx.annotation.NonNull;
import com.here.NativeBase;

final class IconInfo extends NativeBase {
    public IconInfo(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                IconInfo.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public native Icon getIcon();

    @NonNull
    public native String getName();

    @NonNull
    public native String getUrl();
}
