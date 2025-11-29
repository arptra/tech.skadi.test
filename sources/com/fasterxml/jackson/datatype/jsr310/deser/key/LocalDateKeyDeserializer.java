package com.fasterxml.jackson.datatype.jsr310.deser.key;

import com.fasterxml.jackson.databind.DeserializationContext;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateKeyDeserializer extends Jsr310KeyDeserializer {
    public static final LocalDateKeyDeserializer INSTANCE = new LocalDateKeyDeserializer();

    private LocalDateKeyDeserializer() {
    }

    public LocalDate deserialize(String str, DeserializationContext deserializationContext) throws IOException {
        try {
            return LocalDate.parse(str, DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (DateTimeException e) {
            return (LocalDate) _handleDateTimeException(deserializationContext, LocalDate.class, e, str);
        }
    }
}
