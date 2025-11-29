package com.fasterxml.jackson.datatype.jsr310.deser.key;

import com.fasterxml.jackson.databind.DeserializationContext;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.Duration;

public class DurationKeyDeserializer extends Jsr310KeyDeserializer {
    public static final DurationKeyDeserializer INSTANCE = new DurationKeyDeserializer();

    private DurationKeyDeserializer() {
    }

    public Duration deserialize(String str, DeserializationContext deserializationContext) throws IOException {
        try {
            return Duration.parse(str);
        } catch (DateTimeException e) {
            return (Duration) _handleDateTimeException(deserializationContext, Duration.class, e, str);
        }
    }
}
