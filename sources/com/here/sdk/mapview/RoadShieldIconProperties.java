package com.here.sdk.mapview;

import androidx.annotation.NonNull;
import com.here.sdk.core.RouteType;

public final class RoadShieldIconProperties {
    @NonNull
    public String countryCode;
    @NonNull
    public String routeNumberName;
    @NonNull
    public RouteType routeType;
    @NonNull
    public String shieldText;
    @NonNull
    public String stateCode;

    public RoadShieldIconProperties(@NonNull RouteType routeType2, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4) {
        this.routeType = routeType2;
        this.countryCode = str;
        this.stateCode = str2;
        this.routeNumberName = str3;
        this.shieldText = str4;
    }
}
