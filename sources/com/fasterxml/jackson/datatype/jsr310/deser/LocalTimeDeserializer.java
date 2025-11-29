package com.fasterxml.jackson.datatype.jsr310.deser;

import androidx.exifinterface.media.ExifInterface;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import kotlin.time.DurationKt;

public class LocalTimeDeserializer extends JSR310DateTimeDeserializerBase<LocalTime> {
    private static final DateTimeFormatter DEFAULT_FORMATTER = DateTimeFormatter.ISO_LOCAL_TIME;
    public static final LocalTimeDeserializer INSTANCE = new LocalTimeDeserializer();
    private static final long serialVersionUID = 1;

    private LocalTimeDeserializer() {
        this(DEFAULT_FORMATTER);
    }

    public JsonDeserializer<LocalTime> withDateFormat(DateTimeFormatter dateTimeFormatter) {
        return new LocalTimeDeserializer(dateTimeFormatter);
    }

    public LocalTimeDeserializer(DateTimeFormatter dateTimeFormatter) {
        super(LocalTime.class, dateTimeFormatter);
    }

    public LocalTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken jsonToken = JsonToken.VALUE_STRING;
        if (jsonParser.hasToken(jsonToken)) {
            String trim = jsonParser.getText().trim();
            if (trim.length() == 0) {
                return null;
            }
            DateTimeFormatter dateTimeFormatter = this._formatter;
            try {
                if (dateTimeFormatter != DEFAULT_FORMATTER || !trim.contains(ExifInterface.GPS_DIRECTION_TRUE)) {
                    return LocalTime.parse(trim, dateTimeFormatter);
                }
                return LocalTime.parse(trim, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            } catch (DateTimeException e) {
                return (LocalTime) _handleDateTimeException(deserializationContext, e, trim);
            }
        } else {
            if (jsonParser.isExpectedStartArrayToken()) {
                JsonToken nextToken = jsonParser.nextToken();
                JsonToken jsonToken2 = JsonToken.END_ARRAY;
                if (nextToken == jsonToken2) {
                    return null;
                }
                if (deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS) && (nextToken == jsonToken || nextToken == JsonToken.VALUE_EMBEDDED_OBJECT)) {
                    LocalTime deserialize = deserialize(jsonParser, deserializationContext);
                    if (jsonParser.nextToken() != jsonToken2) {
                        handleMissingEndArrayForSingle(jsonParser, deserializationContext);
                    }
                    return deserialize;
                } else if (nextToken == JsonToken.VALUE_NUMBER_INT) {
                    int intValue = jsonParser.getIntValue();
                    jsonParser.nextToken();
                    int intValue2 = jsonParser.getIntValue();
                    if (jsonParser.nextToken() == jsonToken2) {
                        return LocalTime.of(intValue, intValue2);
                    }
                    int intValue3 = jsonParser.getIntValue();
                    if (jsonParser.nextToken() == jsonToken2) {
                        return LocalTime.of(intValue, intValue2, intValue3);
                    }
                    int intValue4 = jsonParser.getIntValue();
                    if (intValue4 < 1000 && !deserializationContext.isEnabled(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS)) {
                        intValue4 *= DurationKt.NANOS_IN_MILLIS;
                    }
                    if (jsonParser.nextToken() == jsonToken2) {
                        return LocalTime.of(intValue, intValue2, intValue3, intValue4);
                    }
                    throw deserializationContext.wrongTokenException(jsonParser, handledType(), jsonToken2, "Expected array to end");
                } else {
                    deserializationContext.reportInputMismatch(handledType(), "Unexpected token (%s) within Array, expected VALUE_NUMBER_INT", nextToken);
                }
            }
            if (jsonParser.hasToken(JsonToken.VALUE_EMBEDDED_OBJECT)) {
                return (LocalTime) jsonParser.getEmbeddedObject();
            }
            if (jsonParser.hasToken(JsonToken.VALUE_NUMBER_INT)) {
                _throwNoNumericTimestampNeedTimeZone(jsonParser, deserializationContext);
            }
            return (LocalTime) _handleUnexpectedToken(deserializationContext, jsonParser, "Expected array or string.", new Object[0]);
        }
    }
}
