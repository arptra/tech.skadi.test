package com.here.sdk.routing;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public final class TransitSectionDetails {
    @NonNull
    public Agency agency;
    @NonNull
    public List<Attribution> attributions = new ArrayList();
    @NonNull
    public List<Fare> fares = new ArrayList();
    @NonNull
    public List<TransitIncident> incidents = new ArrayList();
    @NonNull
    public List<TransitStop> intermediateStops = new ArrayList();
    @Nullable
    public TransitTransport transport = null;

    public TransitSectionDetails(@NonNull Agency agency2) {
        this.agency = agency2;
    }
}
