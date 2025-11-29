package com.here.sdk.core.engine;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.core.ParameterConfiguration;
import com.here.sdk.core.SDKLibraryLoader;
import com.here.sdk.core.errors.InstantiationErrorException;
import java.util.List;
import java.util.Set;

public final class SDKNativeEngine extends NativeBase {
    static final SDKLibraryLoader LIBRARY_LOADER = new SDKLibraryLoader("SDK");

    public SDKNativeEngine(@NonNull Context context, @NonNull SDKOptions sDKOptions) throws InstantiationErrorException {
        this(make(context, sDKOptions), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public static native ParameterConfiguration getParameterConfig();

    @Nullable
    public static native SDKNativeEngine getSharedInstance();

    private static native long make(@NonNull Context context, @NonNull SDKOptions sDKOptions) throws InstantiationErrorException;

    public static native void makeSharedInstance(@NonNull Context context, @NonNull SDKOptions sDKOptions) throws InstantiationErrorException;

    public static native void setParameterConfig(@NonNull ParameterConfiguration parameterConfiguration);

    public static native void setSharedInstance(@Nullable SDKNativeEngine sDKNativeEngine);

    public native void clearPersistentUsageStats();

    public native void clearUsageStatsCache();

    public native void dispose();

    public native void enableUsageStats(boolean z);

    @NonNull
    public native SDKOptions getOptions();

    @Nullable
    public native Set<PassThroughFeature> getPassThroughFeatures();

    @Nullable
    public native ProxySettings getProxySettings();

    @NonNull
    public native List<UsageStats> getSdkUsageStats();

    public native boolean isOfflineMode();

    public native void setAccessKeySecret(@NonNull String str);

    public native void setAccessScope(@NonNull String str);

    public native void setAndroidContext(@NonNull Context context);

    public native void setOfflineMode(boolean z);

    public native void setPassThroughFeatures(@Nullable Set<PassThroughFeature> set);

    public native void setProxySettings(@Nullable ProxySettings proxySettings);

    public SDKNativeEngine(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                SDKNativeEngine.disposeNativeHandle(j);
            }
        });
    }
}
