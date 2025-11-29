package com.honey.account.z0;

import java.time.ZonedDateTime;
import java.util.function.ToLongFunction;

public final /* synthetic */ class j implements ToLongFunction {
    public final long applyAsLong(Object obj) {
        return ((ZonedDateTime) obj).toInstant().toEpochMilli();
    }
}
