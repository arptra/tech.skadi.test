package com.here.sdk.venue.style;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.venue.data.Property;
import java.util.Map;

final class NavProperties extends NativeBase {
    public NavProperties(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                NavProperties.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public native NavCost getCost(@NonNull Map<String, Property> map);

    @NonNull
    public native NavName getName(@NonNull Map<String, Property> map);
}
