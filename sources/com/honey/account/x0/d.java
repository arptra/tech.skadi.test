package com.honey.account.x0;

import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.function.Function;

public final /* synthetic */ class d implements Function {
    public final Object apply(Object obj) {
        return ZonedDateTime.ofInstant(Instant.ofEpochMilli(((InstantDeserializer.FromIntegerArguments) obj).value), ((InstantDeserializer.FromIntegerArguments) obj).zoneId);
    }
}
