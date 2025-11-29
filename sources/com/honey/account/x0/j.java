package com.honey.account.x0;

import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;
import java.time.Instant;
import java.util.function.Function;

public final /* synthetic */ class j implements Function {
    public final Object apply(Object obj) {
        return Instant.ofEpochSecond(((InstantDeserializer.FromDecimalArguments) obj).integer, (long) ((InstantDeserializer.FromDecimalArguments) obj).fraction);
    }
}
