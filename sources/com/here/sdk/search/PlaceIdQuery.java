package com.here.sdk.search;

import androidx.annotation.NonNull;
import java.util.Objects;

public final class PlaceIdQuery {
    @NonNull
    public final String id;

    public PlaceIdQuery(@NonNull String str) {
        this.id = make(str).id;
    }

    private static native PlaceIdQuery make(@NonNull String str);

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PlaceIdQuery)) {
            return false;
        }
        return Objects.equals(this.id, ((PlaceIdQuery) obj).id);
    }

    public int hashCode() {
        String str = this.id;
        return 217 + (str != null ? str.hashCode() : 0);
    }
}
