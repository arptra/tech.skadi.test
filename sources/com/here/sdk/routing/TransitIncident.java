package com.here.sdk.routing;

import androidx.annotation.Nullable;
import java.util.Date;

public final class TransitIncident {
    @Nullable
    public String description;
    @Nullable
    public TransitIncidentEffect effect;
    @Nullable
    public String summary;
    @Nullable
    public TransitIncidentType type;
    @Nullable
    public String url;
    @Nullable
    public Date validFrom;
    @Nullable
    public Date validUntil;

    public TransitIncident(@Nullable String str, @Nullable String str2, @Nullable TransitIncidentType transitIncidentType, @Nullable TransitIncidentEffect transitIncidentEffect, @Nullable Date date, @Nullable Date date2, @Nullable String str3) {
        this.summary = str;
        this.description = str2;
        this.type = transitIncidentType;
        this.effect = transitIncidentEffect;
        this.validFrom = date;
        this.validUntil = date2;
        this.url = str3;
    }
}
