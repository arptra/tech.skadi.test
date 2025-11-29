package com.here.sdk.core.engine;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import java.util.Objects;

final class ApplicationUtils extends NativeBase {

    public static final class ApplicationInformation {
        @NonNull
        public String applicationVersion;

        public ApplicationInformation(@NonNull String str) {
            this.applicationVersion = str;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ApplicationInformation)) {
                return false;
            }
            return Objects.equals(this.applicationVersion, ((ApplicationInformation) obj).applicationVersion);
        }

        public int hashCode() {
            String str = this.applicationVersion;
            return 217 + (str != null ? str.hashCode() : 0);
        }
    }

    public ApplicationUtils(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                ApplicationUtils.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public static native ApplicationInformation getApplicationInformation();

    public static native void setApplicationInformation(@NonNull ApplicationInformation applicationInformation);
}
