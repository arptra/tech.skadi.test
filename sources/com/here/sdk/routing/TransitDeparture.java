package com.here.sdk.routing;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Date;

public final class TransitDeparture {
    @Nullable
    public Integer delay;
    @NonNull
    public RoutePlace place;
    @Nullable
    public TransitDepartureStatus status;
    @Nullable
    public Date time;

    public TransitDeparture(@NonNull RoutePlace routePlace, @Nullable Date date, @Nullable Integer num, @Nullable TransitDepartureStatus transitDepartureStatus) {
        this.place = routePlace;
        this.time = date;
        this.delay = num;
        this.status = transitDepartureStatus;
    }
}
