package com.honey.account.z0;

import java.time.ZonedDateTime;
import java.util.function.ToLongFunction;

public final /* synthetic */ class h implements ToLongFunction {
    public final long applyAsLong(Object obj) {
        return ((ZonedDateTime) obj).toEpochSecond();
    }
}
