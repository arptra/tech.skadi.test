package com.honey.account.x0;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.function.BiFunction;

public final /* synthetic */ class n implements BiFunction {
    public final Object apply(Object obj, Object obj2) {
        return ((OffsetDateTime) obj).withOffsetSameInstant(((ZoneId) obj2).getRules().getOffset(((OffsetDateTime) obj).toLocalDateTime()));
    }
}
