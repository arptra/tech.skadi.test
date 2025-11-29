package com.fasterxml.jackson.datatype.jsr310.deser.key;

import com.fasterxml.jackson.databind.DeserializationContext;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalTimeKeyDeserializer extends Jsr310KeyDeserializer {
    public static final LocalTimeKeyDeserializer INSTANCE = new LocalTimeKeyDeserializer();

    private LocalTimeKeyDeserializer() {
    }

    public LocalTime deserialize(String str, DeserializationContext deserializationContext) throws IOException {
        try {
            return LocalTime.parse(str, DateTimeFormatter.ISO_LOCAL_TIME);
        } catch (DateTimeException e) {
            return (LocalTime) _handleDateTimeException(deserializationContext, LocalTime.class, e, str);
        }
    }
}
