package com.honey.account.z0;

import java.time.OffsetDateTime;
import java.util.function.ToIntFunction;

public final /* synthetic */ class f implements ToIntFunction {
    public final int applyAsInt(Object obj) {
        return ((OffsetDateTime) obj).getNano();
    }
}
