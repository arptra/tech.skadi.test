package com.fasterxml.jackson.datatype.jsr310.deser.key;

import com.fasterxml.jackson.databind.DeserializationContext;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.SignStyle;
import java.time.temporal.ChronoField;

public class YearKeyDeserializer extends Jsr310KeyDeserializer {
    private static final DateTimeFormatter FORMATTER = new DateTimeFormatterBuilder().appendValue(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD).toFormatter();
    public static final YearKeyDeserializer INSTANCE = new YearKeyDeserializer();

    private YearKeyDeserializer() {
    }

    public Year deserialize(String str, DeserializationContext deserializationContext) throws IOException {
        try {
            return Year.parse(str, FORMATTER);
        } catch (DateTimeException e) {
            return (Year) _handleDateTimeException(deserializationContext, Year.class, e, str);
        }
    }
}
