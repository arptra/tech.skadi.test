package com.fasterxml.jackson.datatype.jsr310.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import kotlin.time.DurationKt;

public class LocalDateTimeDeserializer extends JSR310DateTimeDeserializerBase<LocalDateTime> {
    private static final DateTimeFormatter DEFAULT_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    public static final LocalDateTimeDeserializer INSTANCE = new LocalDateTimeDeserializer();
    private static final long serialVersionUID = 1;

    private LocalDateTimeDeserializer() {
        this(DEFAULT_FORMATTER);
    }

    public JsonDeserializer<LocalDateTime> withDateFormat(DateTimeFormatter dateTimeFormatter) {
        return new LocalDateTimeDeserializer(dateTimeFormatter);
    }

    public LocalDateTimeDeserializer(DateTimeFormatter dateTimeFormatter) {
        super(LocalDateTime.class, dateTimeFormatter);
    }

    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (jsonParser.hasTokenId(6)) {
            String trim = jsonParser.getText().trim();
            if (trim.length() == 0) {
                return null;
            }
            try {
                DateTimeFormatter dateTimeFormatter = this._formatter;
                DateTimeFormatter dateTimeFormatter2 = DEFAULT_FORMATTER;
                if (dateTimeFormatter != dateTimeFormatter2 || trim.length() <= 10 || trim.charAt(10) != 'T') {
                    return LocalDateTime.parse(trim, this._formatter);
                }
                if (trim.endsWith("Z")) {
                    return LocalDateTime.ofInstant(Instant.parse(trim), ZoneOffset.UTC);
                }
                return LocalDateTime.parse(trim, dateTimeFormatter2);
            } catch (DateTimeException e) {
                return (LocalDateTime) _handleDateTimeException(deserializationContext, e, trim);
            }
        } else {
            if (jsonParser.isExpectedStartArrayToken()) {
                JsonToken nextToken = jsonParser.nextToken();
                JsonToken jsonToken = JsonToken.END_ARRAY;
                if (nextToken == jsonToken) {
                    return null;
                }
                if ((nextToken == JsonToken.VALUE_STRING || nextToken == JsonToken.VALUE_EMBEDDED_OBJECT) && deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                    LocalDateTime deserialize = deserialize(jsonParser, deserializationContext);
                    if (jsonParser.nextToken() != jsonToken) {
                        handleMissingEndArrayForSingle(jsonParser, deserializationContext);
                    }
                    return deserialize;
                } else if (nextToken == JsonToken.VALUE_NUMBER_INT) {
                    int intValue = jsonParser.getIntValue();
                    int nextIntValue = jsonParser.nextIntValue(-1);
                    int nextIntValue2 = jsonParser.nextIntValue(-1);
                    int nextIntValue3 = jsonParser.nextIntValue(-1);
                    int nextIntValue4 = jsonParser.nextIntValue(-1);
                    if (jsonParser.nextToken() == jsonToken) {
                        return LocalDateTime.of(intValue, nextIntValue, nextIntValue2, nextIntValue3, nextIntValue4);
                    }
                    int intValue2 = jsonParser.getIntValue();
                    if (jsonParser.nextToken() == jsonToken) {
                        return LocalDateTime.of(intValue, nextIntValue, nextIntValue2, nextIntValue3, nextIntValue4, intValue2);
                    }
                    int intValue3 = jsonParser.getIntValue();
                    if (intValue3 < 1000 && !deserializationContext.isEnabled(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS)) {
                        intValue3 *= DurationKt.NANOS_IN_MILLIS;
                    }
                    int i = intValue3;
                    if (jsonParser.nextToken() == jsonToken) {
                        return LocalDateTime.of(intValue, nextIntValue, nextIntValue2, nextIntValue3, nextIntValue4, intValue2, i);
                    }
                    throw deserializationContext.wrongTokenException(jsonParser, handledType(), jsonToken, "Expected array to end");
                } else {
                    deserializationContext.reportInputMismatch(handledType(), "Unexpected token (%s) within Array, expected VALUE_NUMBER_INT", nextToken);
                }
            }
            if (jsonParser.hasToken(JsonToken.VALUE_EMBEDDED_OBJECT)) {
                return (LocalDateTime) jsonParser.getEmbeddedObject();
            }
            if (jsonParser.hasToken(JsonToken.VALUE_NUMBER_INT)) {
                _throwNoNumericTimestampNeedTimeZone(jsonParser, deserializationContext);
            }
            return (LocalDateTime) _handleUnexpectedToken(deserializationContext, jsonParser, "Expected array or string.", new Object[0]);
        }
    }
}
