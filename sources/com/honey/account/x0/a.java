package com.honey.account.x0;

import java.time.Duration;
import java.util.function.BiFunction;

public final /* synthetic */ class a implements BiFunction {
    public final Object apply(Object obj, Object obj2) {
        return Duration.ofSeconds(((Long) obj).longValue(), (long) ((Integer) obj2).intValue());
    }
}
