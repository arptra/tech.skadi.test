package com.fasterxml.jackson.datatype.jsr310.deser.key;

import com.fasterxml.jackson.databind.DeserializationContext;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeKeyDeserializer extends Jsr310KeyDeserializer {
    public static final LocalDateTimeKeyDeserializer INSTANCE = new LocalDateTimeKeyDeserializer();

    private LocalDateTimeKeyDeserializer() {
    }

    public LocalDateTime deserialize(String str, DeserializationContext deserializationContext) throws IOException {
        try {
            return LocalDateTime.parse(str, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        } catch (DateTimeException e) {
            return (LocalDateTime) _handleDateTimeException(deserializationContext, LocalDateTime.class, e, str);
        }
    }
}
