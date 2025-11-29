package com.here.sdk.search;

import androidx.annotation.NonNull;
import java.util.Objects;

public final class PlaceChain {
    @NonNull
    public String id;

    public PlaceChain(@NonNull String str) {
        this.id = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PlaceChain)) {
            return false;
        }
        return Objects.equals(this.id, ((PlaceChain) obj).id);
    }

    public int hashCode() {
        String str = this.id;
        return 217 + (str != null ? str.hashCode() : 0);
    }
}
