package com.here.sdk.mapview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;

public final class MapLayerBuilder extends NativeBase {

    public enum InstantiationErrorCode {
        MISSING_MANDATORY_PARAMETER(1),
        UNSUPPORTED_CONTENT_TYPE(2);
        
        public final int value;

        private InstantiationErrorCode(int i) {
            this.value = i;
        }
    }

    public static final class InstantiationErrorDetails {
        @NonNull
        public InstantiationErrorCode errorCode;
        @Nullable
        public String errorDescription;

        public InstantiationErrorDetails(@NonNull InstantiationErrorCode instantiationErrorCode, @Nullable String str) {
            this.errorCode = instantiationErrorCode;
            this.errorDescription = str;
        }
    }

    public static final class InstantiationException extends Exception {
        public final InstantiationErrorDetails error;

        public InstantiationException(InstantiationErrorDetails instantiationErrorDetails) {
            super(instantiationErrorDetails.toString());
            this.error = instantiationErrorDetails;
        }
    }

    public MapLayerBuilder() {
        this(create(), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    private static native long create();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public native MapLayer build() throws InstantiationException;

    @NonNull
    public native MapLayerBuilder forMap(@NonNull HereMap hereMap);

    @NonNull
    public native MapLayerBuilder withDataSource(@NonNull String str, @NonNull MapContentType mapContentType);

    @NonNull
    public native MapLayerBuilder withLoadPriority(double d);

    @NonNull
    public native MapLayerBuilder withName(@NonNull String str);

    @NonNull
    public native MapLayerBuilder withPriority(@NonNull MapLayerPriority mapLayerPriority);

    @NonNull
    public native MapLayerBuilder withStyle(@NonNull Style style);

    @NonNull
    public native MapLayerBuilder withVisibilityRange(@NonNull MapLayerVisibilityRange mapLayerVisibilityRange);

    public MapLayerBuilder(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                MapLayerBuilder.disposeNativeHandle(j);
            }
        });
    }
}
