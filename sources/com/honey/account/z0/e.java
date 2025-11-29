package com.honey.account.z0;

import java.time.OffsetDateTime;
import java.util.function.ToLongFunction;

public final /* synthetic */ class e implements ToLongFunction {
    public final long applyAsLong(Object obj) {
        return ((OffsetDateTime) obj).toEpochSecond();
    }
}
