package com.fasterxml.jackson.datatype.jsr310.deser.key;

import com.fasterxml.jackson.databind.DeserializationContext;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.SignStyle;
import java.time.temporal.ChronoField;
import org.apache.commons.codec.language.Soundex;

public class YearMothKeyDeserializer extends Jsr310KeyDeserializer {
    private static final DateTimeFormatter FORMATTER = new DateTimeFormatterBuilder().appendValue(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD).appendLiteral(Soundex.SILENT_MARKER).appendValue(ChronoField.MONTH_OF_YEAR, 2).toFormatter();
    public static final YearMothKeyDeserializer INSTANCE = new YearMothKeyDeserializer();

    private YearMothKeyDeserializer() {
    }

    public YearMonth deserialize(String str, DeserializationContext deserializationContext) throws IOException {
        try {
            return YearMonth.parse(str, FORMATTER);
        } catch (DateTimeException e) {
            return (YearMonth) _handleDateTimeException(deserializationContext, YearMonth.class, e, str);
        }
    }
}
