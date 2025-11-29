package com.honey.account.y0;

import java.time.Instant;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;

public final /* synthetic */ class a implements TemporalQuery {
    public final Object queryFrom(TemporalAccessor temporalAccessor) {
        return Instant.from(temporalAccessor);
    }
}
