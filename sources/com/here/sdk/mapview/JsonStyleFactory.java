package com.here.sdk.mapview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;

public final class JsonStyleFactory extends NativeBase {

    public enum InstantiationErrorCode {
        MALFORMED_JSON_CONTENT(1),
        INVALID_JSON_STYLE_SYNTAX(2);
        
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

    public JsonStyleFactory(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                JsonStyleFactory.disposeNativeHandle(j);
            }
        });
    }

    @NonNull
    public static native Style createFromString(@NonNull String str) throws InstantiationException;

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);
}
