package com.fasterxml.jackson.datatype.jsr310.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import kotlin.time.DurationKt;

public class OffsetTimeDeserializer extends JSR310DateTimeDeserializerBase<OffsetTime> {
    public static final OffsetTimeDeserializer INSTANCE = new OffsetTimeDeserializer();
    private static final long serialVersionUID = 1;

    private OffsetTimeDeserializer() {
        this(DateTimeFormatter.ISO_OFFSET_TIME);
    }

    public JsonDeserializer<OffsetTime> withDateFormat(DateTimeFormatter dateTimeFormatter) {
        return new OffsetTimeDeserializer(dateTimeFormatter);
    }

    public OffsetTimeDeserializer(DateTimeFormatter dateTimeFormatter) {
        super(OffsetTime.class, dateTimeFormatter);
    }

    public OffsetTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        int i;
        JsonToken jsonToken = JsonToken.VALUE_STRING;
        if (jsonParser.hasToken(jsonToken)) {
            String trim = jsonParser.getText().trim();
            if (trim.length() == 0) {
                return null;
            }
            try {
                return OffsetTime.parse(trim, this._formatter);
            } catch (DateTimeException e) {
                return (OffsetTime) _handleDateTimeException(deserializationContext, e, trim);
            }
        } else if (jsonParser.isExpectedStartArrayToken()) {
            JsonToken nextToken = jsonParser.nextToken();
            JsonToken jsonToken2 = JsonToken.VALUE_NUMBER_INT;
            if (nextToken != jsonToken2) {
                JsonToken jsonToken3 = JsonToken.END_ARRAY;
                if (nextToken == jsonToken3) {
                    return null;
                }
                if ((nextToken == jsonToken || nextToken == JsonToken.VALUE_EMBEDDED_OBJECT) && deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                    OffsetTime deserialize = deserialize(jsonParser, deserializationContext);
                    if (jsonParser.nextToken() != jsonToken3) {
                        handleMissingEndArrayForSingle(jsonParser, deserializationContext);
                    }
                    return deserialize;
                }
                deserializationContext.reportInputMismatch(handledType(), "Unexpected token (%s) within Array, expected VALUE_NUMBER_INT", nextToken);
            }
            int intValue = jsonParser.getIntValue();
            int nextIntValue = jsonParser.nextIntValue(-1);
            if (nextIntValue == -1) {
                JsonToken currentToken = jsonParser.getCurrentToken();
                if (currentToken == JsonToken.END_ARRAY) {
                    return null;
                }
                if (currentToken != jsonToken2) {
                    _reportWrongToken(deserializationContext, jsonToken2, "minutes");
                }
                nextIntValue = jsonParser.getIntValue();
            }
            int i2 = 0;
            if (jsonParser.nextToken() == jsonToken2) {
                int intValue2 = jsonParser.getIntValue();
                if (jsonParser.nextToken() == jsonToken2) {
                    int intValue3 = jsonParser.getIntValue();
                    if (intValue3 < 1000 && !deserializationContext.isEnabled(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS)) {
                        intValue3 *= DurationKt.NANOS_IN_MILLIS;
                    }
                    i2 = intValue3;
                    jsonParser.nextToken();
                }
                int i3 = i2;
                i2 = intValue2;
                i = i3;
            } else {
                i = 0;
            }
            if (jsonParser.getCurrentToken() == jsonToken) {
                OffsetTime of = OffsetTime.of(intValue, nextIntValue, i2, i, ZoneOffset.of(jsonParser.getText()));
                JsonToken nextToken2 = jsonParser.nextToken();
                JsonToken jsonToken4 = JsonToken.END_ARRAY;
                if (nextToken2 != jsonToken4) {
                    _reportWrongToken(deserializationContext, jsonToken4, "timezone");
                }
                return of;
            }
            throw deserializationContext.wrongTokenException(jsonParser, handledType(), jsonToken, "Expected string for TimeZone after numeric values");
        } else if (jsonParser.hasToken(JsonToken.VALUE_EMBEDDED_OBJECT)) {
            return (OffsetTime) jsonParser.getEmbeddedObject();
        } else {
            if (jsonParser.hasToken(JsonToken.VALUE_NUMBER_INT)) {
                _throwNoNumericTimestampNeedTimeZone(jsonParser, deserializationContext);
            }
            throw deserializationContext.wrongTokenException(jsonParser, handledType(), JsonToken.START_ARRAY, "Expected array or string.");
        }
    }
}
