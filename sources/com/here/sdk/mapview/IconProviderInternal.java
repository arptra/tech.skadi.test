package com.here.sdk.mapview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;

final class IconProviderInternal extends NativeBase {

    @FunctionalInterface
    public interface CreateIconCallback {
        void onCreateIconReply(@Nullable byte[] bArr, @Nullable String str, @Nullable IconProviderError iconProviderError);
    }

    public static class CreateIconCallbackImpl extends NativeBase implements CreateIconCallback {
        public CreateIconCallbackImpl(long j, Object obj) {
            super(j, new NativeBase.Disposer() {
                public void disposeNative(long j) {
                    CreateIconCallbackImpl.disposeNativeHandle(j);
                }
            });
        }

        /* access modifiers changed from: private */
        public static native void disposeNativeHandle(long j);

        public native void onCreateIconReply(@Nullable byte[] bArr, @Nullable String str, @Nullable IconProviderError iconProviderError);
    }

    public IconProviderInternal(@NonNull MapContext mapContext) {
        this(create(mapContext), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    private static native long create(@NonNull MapContext mapContext);

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void createRoadShieldIcon(@NonNull RoadShieldIconProperties roadShieldIconProperties, @NonNull MapScheme mapScheme, long j, long j2, @NonNull CreateIconCallback createIconCallback);

    public IconProviderInternal(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                IconProviderInternal.disposeNativeHandle(j);
            }
        });
    }
}
