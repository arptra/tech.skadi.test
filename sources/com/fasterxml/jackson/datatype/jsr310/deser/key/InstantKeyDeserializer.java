package com.fasterxml.jackson.datatype.jsr310.deser.key;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.honey.account.y0.a;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.Instant;
import java.time.format.DateTimeFormatter;

public class InstantKeyDeserializer extends Jsr310KeyDeserializer {
    public static final InstantKeyDeserializer INSTANCE = new InstantKeyDeserializer();

    private InstantKeyDeserializer() {
    }

    public Instant deserialize(String str, DeserializationContext deserializationContext) throws IOException {
        try {
            return (Instant) DateTimeFormatter.ISO_INSTANT.parse(str, new a());
        } catch (DateTimeException e) {
            return (Instant) _handleDateTimeException(deserializationContext, Instant.class, e, str);
        }
    }
}
