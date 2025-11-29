package com.honey.account.x0;

import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;
import java.time.ZoneId;
import java.time.temporal.Temporal;
import java.util.function.BiFunction;

public final /* synthetic */ class b implements BiFunction {
    public final Object apply(Object obj, Object obj2) {
        return InstantDeserializer.lambda$new$7((Temporal) obj, (ZoneId) obj2);
    }
}
