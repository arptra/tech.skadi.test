package com.honey.account.z0;

import java.time.ZonedDateTime;
import java.util.function.ToIntFunction;

public final /* synthetic */ class i implements ToIntFunction {
    public final int applyAsInt(Object obj) {
        return ((ZonedDateTime) obj).getNano();
    }
}
