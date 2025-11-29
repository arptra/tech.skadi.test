package com.here.sdk.venue.data;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import java.util.List;
import java.util.Map;

final class EntityInfo extends NativeBase {
    public EntityInfo(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                EntityInfo.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public native String getIdentifier();

    @NonNull
    public native Map<String, Property> getProperties();

    @NonNull
    public native List<String> getSpaces();
}
