package com.here.sdk.maploader;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.core.engine.SDKNativeEngine;
import com.here.sdk.core.threading.TaskHandle;

public final class MapUpdater extends NativeBase {

    public enum MapUpdateVersionCommitPolicy {
        ON_FIRST_REGION(0),
        ON_COMPLETE(1);
        
        public final int value;

        private MapUpdateVersionCommitPolicy(int i) {
            this.value = i;
        }
    }

    public MapUpdater() {
        this(make(), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public static native void fromEngineAsync(@NonNull SDKNativeEngine sDKNativeEngine, @NonNull MapUpdaterConstructionCallback mapUpdaterConstructionCallback);

    private static native long make();

    @NonNull
    public native MapVersionHandle getCurrentMapVersion() throws MapLoaderException;

    public native long getTaskCount();

    @NonNull
    public native UpdateStatistics getUpdateStatistics();

    @NonNull
    public native MapUpdateTask performFeatureUpdate(@NonNull MapUpdateProgressListener mapUpdateProgressListener);

    @NonNull
    public native TaskHandle retrieveCatalogsUpdateInfo(@NonNull CatalogsUpdateInfoCallback catalogsUpdateInfoCallback);

    public native void setTaskCount(long j);

    public native void setVersionCommitPolicy(@NonNull MapUpdateVersionCommitPolicy mapUpdateVersionCommitPolicy);

    @NonNull
    public native CatalogUpdateTask updateCatalog(@NonNull CatalogUpdateInfo catalogUpdateInfo, @NonNull CatalogUpdateProgressListener catalogUpdateProgressListener);

    public MapUpdater(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                MapUpdater.disposeNativeHandle(j);
            }
        });
    }
}
