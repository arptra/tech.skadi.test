package com.fasterxml.jackson.datatype.jsr310.deser.key;

import com.fasterxml.jackson.databind.DeserializationContext;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ZonedDateTimeKeyDeserializer extends Jsr310KeyDeserializer {
    public static final ZonedDateTimeKeyDeserializer INSTANCE = new ZonedDateTimeKeyDeserializer();

    private ZonedDateTimeKeyDeserializer() {
    }

    public ZonedDateTime deserialize(String str, DeserializationContext deserializationContext) throws IOException {
        try {
            return ZonedDateTime.parse(str, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        } catch (DateTimeException e) {
            return (ZonedDateTime) _handleDateTimeException(deserializationContext, ZonedDateTime.class, e, str);
        }
    }
}
