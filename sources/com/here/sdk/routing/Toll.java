package com.here.sdk.routing;

import androidx.annotation.NonNull;
import java.util.List;
import java.util.Objects;

public final class Toll {
    @NonNull
    public String countryCode;
    @NonNull
    public List<TollFare> fares;
    @NonNull
    public String tollSystem;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Toll)) {
            return false;
        }
        Toll toll = (Toll) obj;
        return Objects.equals(this.countryCode, toll.countryCode) && Objects.equals(this.tollSystem, toll.tollSystem) && Objects.equals(this.fares, toll.fares);
    }

    public int hashCode() {
        String str = this.countryCode;
        int i = 0;
        int hashCode = (217 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.tollSystem;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<TollFare> list = this.fares;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode2 + i;
    }
}
