package com.here.sdk.search;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.core.GeoCircle;
import com.here.sdk.core.GeoCoordinates;
import com.here.sdk.core.LanguageCode;
import com.here.sdk.core.PickedPlace;
import com.here.sdk.core.engine.SDKNativeEngine;
import com.here.sdk.core.errors.InstantiationErrorException;
import com.here.sdk.core.threading.TaskHandle;

public final class SearchEngine extends NativeBase {
    public SearchEngine() throws InstantiationErrorException {
        this(make(), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    private static native long make() throws InstantiationErrorException;

    private static native long make(@NonNull SDKNativeEngine sDKNativeEngine) throws InstantiationErrorException;

    @NonNull
    public native TaskHandle search(@NonNull GeoCircle geoCircle, @NonNull SearchOptions searchOptions, @NonNull SearchCallback searchCallback);

    @NonNull
    public native TaskHandle search(@NonNull GeoCircle geoCircle, @NonNull SearchOptions searchOptions, @NonNull SearchCallbackExtended searchCallbackExtended);

    @NonNull
    public native TaskHandle search(@NonNull GeoCoordinates geoCoordinates, @NonNull SearchOptions searchOptions, @NonNull SearchCallback searchCallback);

    @NonNull
    public native TaskHandle search(@NonNull GeoCoordinates geoCoordinates, @NonNull SearchOptions searchOptions, @NonNull SearchCallbackExtended searchCallbackExtended);

    @NonNull
    public native TaskHandle search(@NonNull AddressQuery addressQuery, @NonNull SearchOptions searchOptions, @NonNull SearchCallback searchCallback);

    @NonNull
    public native TaskHandle search(@NonNull AddressQuery addressQuery, @NonNull SearchOptions searchOptions, @NonNull SearchCallbackExtended searchCallbackExtended);

    @NonNull
    public native TaskHandle search(@NonNull CategoryQuery categoryQuery, @NonNull SearchOptions searchOptions, @NonNull SearchCallback searchCallback);

    @NonNull
    public native TaskHandle search(@NonNull CategoryQuery categoryQuery, @NonNull SearchOptions searchOptions, @NonNull SearchCallbackExtended searchCallbackExtended);

    @NonNull
    public native TaskHandle search(@NonNull PlaceIdQuery placeIdQuery, @Nullable LanguageCode languageCode, @NonNull PlaceIdSearchCallback placeIdSearchCallback);

    @NonNull
    public native TaskHandle search(@NonNull PlaceIdQuery placeIdQuery, @Nullable LanguageCode languageCode, @NonNull PlaceIdSearchCallbackExtended placeIdSearchCallbackExtended);

    @NonNull
    public native TaskHandle search(@NonNull TextQuery textQuery, @NonNull SearchOptions searchOptions, @NonNull SearchCallback searchCallback);

    @NonNull
    public native TaskHandle search(@NonNull TextQuery textQuery, @NonNull SearchOptions searchOptions, @NonNull SearchCallbackExtended searchCallbackExtended);

    @NonNull
    public native TaskHandle searchPickedPlace(@NonNull PickedPlace pickedPlace, @Nullable LanguageCode languageCode, @NonNull PlaceIdSearchCallback placeIdSearchCallback);

    @NonNull
    public native TaskHandle sendRequest(@NonNull String str, @NonNull SearchCallback searchCallback);

    @NonNull
    public native TaskHandle sendRequest(@NonNull String str, @NonNull SearchCallbackExtended searchCallbackExtended);

    @Nullable
    public native SearchError setCustomOption(@NonNull String str, @NonNull String str2);

    @NonNull
    public native TaskHandle suggest(@NonNull TextQuery textQuery, @NonNull SearchOptions searchOptions, @NonNull SuggestCallback suggestCallback);

    @NonNull
    public native TaskHandle suggest(@NonNull TextQuery textQuery, @NonNull SearchOptions searchOptions, @NonNull SuggestCallbackExtended suggestCallbackExtended);

    public SearchEngine(@NonNull SDKNativeEngine sDKNativeEngine) throws InstantiationErrorException {
        this(make(sDKNativeEngine), (Object) null);
        cacheThisInstance();
    }

    public SearchEngine(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                SearchEngine.disposeNativeHandle(j);
            }
        });
    }
}
