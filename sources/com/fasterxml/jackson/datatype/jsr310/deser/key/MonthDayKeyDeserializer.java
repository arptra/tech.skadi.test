package com.fasterxml.jackson.datatype.jsr310.deser.key;

import com.fasterxml.jackson.databind.DeserializationContext;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import org.apache.commons.codec.language.Soundex;

public class MonthDayKeyDeserializer extends Jsr310KeyDeserializer {
    public static final MonthDayKeyDeserializer INSTANCE = new MonthDayKeyDeserializer();
    private static final DateTimeFormatter PARSER = new DateTimeFormatterBuilder().appendLiteral("--").appendValue(ChronoField.MONTH_OF_YEAR, 2).appendLiteral(Soundex.SILENT_MARKER).appendValue(ChronoField.DAY_OF_MONTH, 2).toFormatter();

    private MonthDayKeyDeserializer() {
    }

    public MonthDay deserialize(String str, DeserializationContext deserializationContext) throws IOException {
        try {
            return MonthDay.parse(str, PARSER);
        } catch (DateTimeException e) {
            return (MonthDay) _handleDateTimeException(deserializationContext, MonthDay.class, e, str);
        }
    }
}
