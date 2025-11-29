package com.here.sdk.routing;

import androidx.annotation.NonNull;
import com.here.sdk.core.LocalizedTexts;
import java.util.Objects;

public final class RoadTexts {
    @NonNull
    public LocalizedTexts names = new LocalizedTexts();
    @NonNull
    public LocalizedRoadNumbers numbersWithDirection = new LocalizedRoadNumbers();

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RoadTexts)) {
            return false;
        }
        RoadTexts roadTexts = (RoadTexts) obj;
        return Objects.equals(this.names, roadTexts.names) && Objects.equals(this.numbersWithDirection, roadTexts.numbersWithDirection);
    }

    public int hashCode() {
        LocalizedTexts localizedTexts = this.names;
        int i = 0;
        int hashCode = (217 + (localizedTexts != null ? localizedTexts.hashCode() : 0)) * 31;
        LocalizedRoadNumbers localizedRoadNumbers = this.numbersWithDirection;
        if (localizedRoadNumbers != null) {
            i = localizedRoadNumbers.hashCode();
        }
        return hashCode + i;
    }
}
