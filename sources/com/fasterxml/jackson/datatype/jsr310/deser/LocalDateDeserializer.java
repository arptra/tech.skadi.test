package com.fasterxml.jackson.datatype.jsr310.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class LocalDateDeserializer extends JSR310DateTimeDeserializerBase<LocalDate> {
    private static final DateTimeFormatter DEFAULT_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;
    public static final LocalDateDeserializer INSTANCE = new LocalDateDeserializer();
    private static final long serialVersionUID = 1;

    private LocalDateDeserializer() {
        this(DEFAULT_FORMATTER);
    }

    public JsonDeserializer<LocalDate> withDateFormat(DateTimeFormatter dateTimeFormatter) {
        return new LocalDateDeserializer(dateTimeFormatter);
    }

    public LocalDateDeserializer(DateTimeFormatter dateTimeFormatter) {
        super(LocalDate.class, dateTimeFormatter);
    }

    public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken jsonToken = JsonToken.VALUE_STRING;
        if (jsonParser.hasToken(jsonToken)) {
            String trim = jsonParser.getText().trim();
            if (trim.length() == 0) {
                return null;
            }
            DateTimeFormatter dateTimeFormatter = this._formatter;
            try {
                if (dateTimeFormatter != DEFAULT_FORMATTER || trim.length() <= 10 || trim.charAt(10) != 'T') {
                    return LocalDate.parse(trim, dateTimeFormatter);
                }
                if (trim.endsWith("Z")) {
                    return LocalDateTime.ofInstant(Instant.parse(trim), ZoneOffset.UTC).toLocalDate();
                }
                return LocalDate.parse(trim, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            } catch (DateTimeException e) {
                return (LocalDate) _handleDateTimeException(deserializationContext, e, trim);
            }
        } else {
            if (jsonParser.isExpectedStartArrayToken()) {
                JsonToken nextToken = jsonParser.nextToken();
                JsonToken jsonToken2 = JsonToken.END_ARRAY;
                if (nextToken == jsonToken2) {
                    return null;
                }
                if (deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS) && (nextToken == jsonToken || nextToken == JsonToken.VALUE_EMBEDDED_OBJECT)) {
                    LocalDate deserialize = deserialize(jsonParser, deserializationContext);
                    if (jsonParser.nextToken() != jsonToken2) {
                        handleMissingEndArrayForSingle(jsonParser, deserializationContext);
                    }
                    return deserialize;
                } else if (nextToken == JsonToken.VALUE_NUMBER_INT) {
                    int intValue = jsonParser.getIntValue();
                    int nextIntValue = jsonParser.nextIntValue(-1);
                    int nextIntValue2 = jsonParser.nextIntValue(-1);
                    if (jsonParser.nextToken() == jsonToken2) {
                        return LocalDate.of(intValue, nextIntValue, nextIntValue2);
                    }
                    throw deserializationContext.wrongTokenException(jsonParser, handledType(), jsonToken2, "Expected array to end");
                } else {
                    deserializationContext.reportInputMismatch(handledType(), "Unexpected token (%s) within Array, expected VALUE_NUMBER_INT", nextToken);
                }
            }
            if (jsonParser.hasToken(JsonToken.VALUE_EMBEDDED_OBJECT)) {
                return (LocalDate) jsonParser.getEmbeddedObject();
            }
            if (jsonParser.hasToken(JsonToken.VALUE_NUMBER_INT)) {
                return LocalDate.ofEpochDay(jsonParser.getLongValue());
            }
            return (LocalDate) _handleUnexpectedToken(deserializationContext, jsonParser, "Expected array or string.", new Object[0]);
        }
    }
}
