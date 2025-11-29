package com.honey.account.x0;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.function.BiFunction;

public final /* synthetic */ class h implements BiFunction {
    public final Object apply(Object obj, Object obj2) {
        return ((ZonedDateTime) obj).withZoneSameInstant((ZoneId) obj2);
    }
}
