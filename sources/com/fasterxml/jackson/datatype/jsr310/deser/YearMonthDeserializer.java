package com.fasterxml.jackson.datatype.jsr310.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class YearMonthDeserializer extends JSR310DateTimeDeserializerBase<YearMonth> {
    public static final YearMonthDeserializer INSTANCE = new YearMonthDeserializer();
    private static final long serialVersionUID = 1;

    private YearMonthDeserializer() {
        this(DateTimeFormatter.ofPattern("uuuu-MM"));
    }

    public JsonDeserializer<YearMonth> withDateFormat(DateTimeFormatter dateTimeFormatter) {
        return new YearMonthDeserializer(dateTimeFormatter);
    }

    public YearMonthDeserializer(DateTimeFormatter dateTimeFormatter) {
        super(YearMonth.class, dateTimeFormatter);
    }

    public YearMonth deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken jsonToken = JsonToken.VALUE_STRING;
        if (jsonParser.hasToken(jsonToken)) {
            String trim = jsonParser.getText().trim();
            if (trim.length() == 0) {
                return null;
            }
            try {
                return YearMonth.parse(trim, this._formatter);
            } catch (DateTimeException e) {
                return (YearMonth) _handleDateTimeException(deserializationContext, e, trim);
            }
        } else if (jsonParser.isExpectedStartArrayToken()) {
            JsonToken nextToken = jsonParser.nextToken();
            JsonToken jsonToken2 = JsonToken.END_ARRAY;
            if (nextToken == jsonToken2) {
                return null;
            }
            if ((nextToken == jsonToken || nextToken == JsonToken.VALUE_EMBEDDED_OBJECT) && deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                YearMonth deserialize = deserialize(jsonParser, deserializationContext);
                if (jsonParser.nextToken() != jsonToken2) {
                    handleMissingEndArrayForSingle(jsonParser, deserializationContext);
                }
                return deserialize;
            }
            JsonToken jsonToken3 = JsonToken.VALUE_NUMBER_INT;
            if (nextToken != jsonToken3) {
                _reportWrongToken(deserializationContext, jsonToken3, "years");
            }
            int intValue = jsonParser.getIntValue();
            int nextIntValue = jsonParser.nextIntValue(-1);
            if (nextIntValue == -1) {
                if (!jsonParser.hasToken(jsonToken3)) {
                    _reportWrongToken(deserializationContext, jsonToken3, "months");
                }
                nextIntValue = jsonParser.getIntValue();
            }
            if (jsonParser.nextToken() == jsonToken2) {
                return YearMonth.of(intValue, nextIntValue);
            }
            throw deserializationContext.wrongTokenException(jsonParser, handledType(), jsonToken2, "Expected array to end");
        } else if (jsonParser.hasToken(JsonToken.VALUE_EMBEDDED_OBJECT)) {
            return (YearMonth) jsonParser.getEmbeddedObject();
        } else {
            return (YearMonth) _handleUnexpectedToken(deserializationContext, jsonParser, jsonToken, JsonToken.START_ARRAY);
        }
    }
}
