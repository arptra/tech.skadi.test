package com.honey.account.z0;

import java.time.Instant;
import java.util.function.ToIntFunction;

public final /* synthetic */ class c implements ToIntFunction {
    public final int applyAsInt(Object obj) {
        return ((Instant) obj).getNano();
    }
}
