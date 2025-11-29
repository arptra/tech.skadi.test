package com.here.sdk.venue.data;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import java.util.Set;

final class SpaceGroupInfo extends NativeBase {
    public SpaceGroupInfo(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                SpaceGroupInfo.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public native Set<String> getRelatedSpaces(@NonNull String str);
}
