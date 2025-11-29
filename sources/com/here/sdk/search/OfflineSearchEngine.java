package com.here.sdk.search;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.core.GeoCoordinates;
import com.here.sdk.core.LanguageCode;
import com.here.sdk.core.PickedPlace;
import com.here.sdk.core.engine.SDKNativeEngine;
import com.here.sdk.core.errors.InstantiationErrorException;
import com.here.sdk.core.threading.OnTaskCompleted;
import com.here.sdk.core.threading.TaskHandle;
import com.here.sdk.search.OfflineSearchIndex;

public final class OfflineSearchEngine extends NativeBase {
    public OfflineSearchEngine() throws InstantiationErrorException {
        this(make(), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    private static native long make() throws InstantiationErrorException;

    private static native long make(@NonNull SDKNativeEngine sDKNativeEngine) throws InstantiationErrorException;

    @Nullable
    public static native OfflineSearchIndex.Error setIndexOptions(@NonNull SDKNativeEngine sDKNativeEngine, @NonNull OfflineSearchIndex.Options options, @NonNull OfflineSearchIndexListener offlineSearchIndexListener);

    @NonNull
    public native TaskHandle attach(@NonNull MyPlaces myPlaces, @NonNull OnTaskCompleted onTaskCompleted);

    @NonNull
    public native TaskHandle search(@NonNull GeoCoordinates geoCoordinates, @NonNull SearchOptions searchOptions, @NonNull SearchCallback searchCallback);

    @NonNull
    public native TaskHandle search(@NonNull AddressQuery addressQuery, @NonNull SearchOptions searchOptions, @NonNull SearchCallback searchCallback);

    @NonNull
    public native TaskHandle search(@NonNull CategoryQuery categoryQuery, @NonNull SearchOptions searchOptions, @NonNull SearchCallback searchCallback);

    @NonNull
    public native TaskHandle search(@NonNull PlaceIdQuery placeIdQuery, @Nullable LanguageCode languageCode, @NonNull PlaceIdSearchCallback placeIdSearchCallback);

    @NonNull
    public native TaskHandle search(@NonNull TextQuery textQuery, @NonNull SearchOptions searchOptions, @NonNull SearchCallback searchCallback);

    @NonNull
    public native TaskHandle searchPickedPlace(@NonNull PickedPlace pickedPlace, @Nullable LanguageCode languageCode, @NonNull PlaceIdSearchCallback placeIdSearchCallback);

    @NonNull
    public native TaskHandle suggest(@NonNull TextQuery textQuery, @NonNull SearchOptions searchOptions, @NonNull SuggestCallback suggestCallback);

    public OfflineSearchEngine(@NonNull SDKNativeEngine sDKNativeEngine) throws InstantiationErrorException {
        this(make(sDKNativeEngine), (Object) null);
        cacheThisInstance();
    }

    public OfflineSearchEngine(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                OfflineSearchEngine.disposeNativeHandle(j);
            }
        });
    }
}
