package com.honey.account.z0;

import java.time.Instant;
import java.util.function.ToLongFunction;

public final /* synthetic */ class b implements ToLongFunction {
    public final long applyAsLong(Object obj) {
        return ((Instant) obj).getEpochSecond();
    }
}
