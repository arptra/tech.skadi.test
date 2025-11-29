package com.here.sdk.routing;

import androidx.annotation.NonNull;
import java.util.Objects;

public final class RouteHandle {
    @NonNull
    public String handle;

    public RouteHandle(@NonNull String str) {
        this.handle = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RouteHandle)) {
            return false;
        }
        return Objects.equals(this.handle, ((RouteHandle) obj).handle);
    }

    public int hashCode() {
        String str = this.handle;
        return 217 + (str != null ? str.hashCode() : 0);
    }
}
