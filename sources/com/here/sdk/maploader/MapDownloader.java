package com.here.sdk.maploader;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.core.LanguageCode;
import com.here.sdk.core.engine.SDKNativeEngine;
import com.here.sdk.core.threading.TaskHandle;
import java.util.List;

public final class MapDownloader extends NativeBase {
    public MapDownloader() {
        this(make(), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public static native void fromEngineAsync(@NonNull SDKNativeEngine sDKNativeEngine, @NonNull MapDownloaderConstructionCallback mapDownloaderConstructionCallback);

    private static native long make();

    public native void clearPersistentMapStorage(@NonNull SDKCacheCallback sDKCacheCallback);

    public native void deleteRegions(@NonNull List<RegionId> list, @NonNull DeletedRegionsCallback deletedRegionsCallback);

    @NonNull
    public native MapDownloaderTask downloadRegions(@NonNull List<RegionId> list, @NonNull DownloadRegionsStatusListener downloadRegionsStatusListener);

    @NonNull
    public native TaskHandle getDownloadableRegions(@NonNull LanguageCode languageCode, @NonNull DownloadableRegionsCallback downloadableRegionsCallback);

    @NonNull
    public native TaskHandle getDownloadableRegions(@NonNull DownloadableRegionsCallback downloadableRegionsCallback);

    @NonNull
    public native PersistentMapStatus getInitialPersistentMapStatus();

    @NonNull
    public native List<InstalledRegion> getInstalledRegions() throws MapLoaderException;

    public native long getOfflineMapsStorageSizeInBytes() throws MapLoaderException;

    public native long getTaskCount();

    public native void repairPersistentMap(@NonNull RepairPersistentMapCallback repairPersistentMapCallback);

    public native void setTaskCount(long j);

    public MapDownloader(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                MapDownloader.disposeNativeHandle(j);
            }
        });
    }
}
