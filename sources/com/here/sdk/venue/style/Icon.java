package com.here.sdk.venue.style;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import java.util.List;

final class Icon extends NativeBase {
    public Icon(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                Icon.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public native List<IconGeometry> getGeometry();

    public native float getHeight();

    @NonNull
    public native String getSvg();

    @NonNull
    public native String getSvgPath();

    public native float getWidth();
}
