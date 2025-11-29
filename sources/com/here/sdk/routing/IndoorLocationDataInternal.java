package com.here.sdk.routing;

import androidx.annotation.NonNull;
import java.util.Objects;

final class IndoorLocationDataInternal {
    public int levelZIndex;
    @NonNull
    public String venueId;

    public IndoorLocationDataInternal(@NonNull String str, int i) {
        this.venueId = str;
        this.levelZIndex = i;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IndoorLocationDataInternal)) {
            return false;
        }
        IndoorLocationDataInternal indoorLocationDataInternal = (IndoorLocationDataInternal) obj;
        return Objects.equals(this.venueId, indoorLocationDataInternal.venueId) && this.levelZIndex == indoorLocationDataInternal.levelZIndex;
    }

    public int hashCode() {
        String str = this.venueId;
        return ((217 + (str != null ? str.hashCode() : 0)) * 31) + this.levelZIndex;
    }
}
