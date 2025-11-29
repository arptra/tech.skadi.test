package com.fasterxml.jackson.datatype.jsr310.deser.key;

import com.fasterxml.jackson.databind.DeserializationContext;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.Period;

public class PeriodKeyDeserializer extends Jsr310KeyDeserializer {
    public static final PeriodKeyDeserializer INSTANCE = new PeriodKeyDeserializer();

    private PeriodKeyDeserializer() {
    }

    public Period deserialize(String str, DeserializationContext deserializationContext) throws IOException {
        try {
            return Period.parse(str);
        } catch (DateTimeException e) {
            return (Period) _handleDateTimeException(deserializationContext, Period.class, e, str);
        }
    }
}
