package com.here.sdk.mapview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.core.LanguageCode;
import com.here.sdk.core.threading.Runnable;
import java.util.List;

final class MapContextProvider extends NativeBase {

    public static final class LanguageOptions {
        @Nullable
        public LanguageCode primary = null;
        @Nullable
        public LanguageCode secondary = null;
    }

    public MapContextProvider(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                MapContextProvider.disposeNativeHandle(j);
            }
        });
    }

    public static native void destroy();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public static native LanguageOptions getLanguageOptions();

    @Nullable
    public static native ShadowQuality getShadowQuality();

    public static native void pause();

    public static native void postToCallbackQueue(@NonNull Runnable runnable);

    public static native void processCallbackQueue(int i);

    public static native void resume();

    public static native void setInitEnableUserControlledRenderLoop(boolean z);

    public static native void setInitGraphicsContext(long j);

    public static native void setInitRenderDeviceHandle(long j);

    public static native void setInitResourcePaths(@NonNull List<String> list);

    public static native void setInitWindowRenderTarget(long j);

    public static native void setLanguageOptions(@NonNull LanguageOptions languageOptions);

    public static native void setShadowQuality(@Nullable ShadowQuality shadowQuality);
}
