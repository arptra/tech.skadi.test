package com.honey.account.x0;

import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;
import java.time.Instant;
import java.util.function.Function;

public final /* synthetic */ class i implements Function {
    public final Object apply(Object obj) {
        return Instant.ofEpochMilli(((InstantDeserializer.FromIntegerArguments) obj).value);
    }
}
