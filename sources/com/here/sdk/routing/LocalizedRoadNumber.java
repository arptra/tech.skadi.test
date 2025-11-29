package com.here.sdk.routing;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.sdk.core.CardinalDirection;
import com.here.sdk.core.LocalizedText;
import com.here.sdk.core.RouteType;
import java.util.Objects;

public final class LocalizedRoadNumber {
    @Nullable
    public CardinalDirection direction = null;
    @NonNull
    public LocalizedText localizedNumber;
    @NonNull
    public RouteType routeType;

    public LocalizedRoadNumber(@NonNull LocalizedText localizedText, @NonNull RouteType routeType2) {
        this.localizedNumber = localizedText;
        this.routeType = routeType2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocalizedRoadNumber)) {
            return false;
        }
        LocalizedRoadNumber localizedRoadNumber = (LocalizedRoadNumber) obj;
        return Objects.equals(this.localizedNumber, localizedRoadNumber.localizedNumber) && Objects.equals(this.direction, localizedRoadNumber.direction) && Objects.equals(this.routeType, localizedRoadNumber.routeType);
    }

    @NonNull
    public native String getTextWithDirection();

    public int hashCode() {
        LocalizedText localizedText = this.localizedNumber;
        int i = 0;
        int hashCode = (217 + (localizedText != null ? localizedText.hashCode() : 0)) * 31;
        CardinalDirection cardinalDirection = this.direction;
        int hashCode2 = (hashCode + (cardinalDirection != null ? cardinalDirection.hashCode() : 0)) * 31;
        RouteType routeType2 = this.routeType;
        if (routeType2 != null) {
            i = routeType2.hashCode();
        }
        return hashCode2 + i;
    }
}
