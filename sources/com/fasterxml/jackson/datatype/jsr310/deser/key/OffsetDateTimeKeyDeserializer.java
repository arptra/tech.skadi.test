package com.fasterxml.jackson.datatype.jsr310.deser.key;

import com.fasterxml.jackson.databind.DeserializationContext;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class OffsetDateTimeKeyDeserializer extends Jsr310KeyDeserializer {
    public static final OffsetDateTimeKeyDeserializer INSTANCE = new OffsetDateTimeKeyDeserializer();

    private OffsetDateTimeKeyDeserializer() {
    }

    public OffsetDateTime deserialize(String str, DeserializationContext deserializationContext) throws IOException {
        try {
            return OffsetDateTime.parse(str, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        } catch (DateTimeException e) {
            return (OffsetDateTime) _handleDateTimeException(deserializationContext, OffsetDateTime.class, e, str);
        }
    }
}
