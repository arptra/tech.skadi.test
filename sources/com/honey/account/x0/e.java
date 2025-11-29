package com.honey.account.x0;

import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.function.Function;

public final /* synthetic */ class e implements Function {
    public final Object apply(Object obj) {
        return ZonedDateTime.ofInstant(Instant.ofEpochSecond(((InstantDeserializer.FromDecimalArguments) obj).integer, (long) ((InstantDeserializer.FromDecimalArguments) obj).fraction), ((InstantDeserializer.FromDecimalArguments) obj).zoneId);
    }
}
