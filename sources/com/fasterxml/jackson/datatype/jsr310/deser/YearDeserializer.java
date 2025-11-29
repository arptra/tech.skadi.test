package com.fasterxml.jackson.datatype.jsr310.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.Year;
import java.time.format.DateTimeFormatter;

public class YearDeserializer extends JSR310DateTimeDeserializerBase<Year> {
    public static final YearDeserializer INSTANCE = new YearDeserializer();
    private static final long serialVersionUID = 1;

    private YearDeserializer() {
        this((DateTimeFormatter) null);
    }

    public JsonDeserializer<Year> withDateFormat(DateTimeFormatter dateTimeFormatter) {
        return new YearDeserializer(dateTimeFormatter);
    }

    public YearDeserializer(DateTimeFormatter dateTimeFormatter) {
        super(Year.class, dateTimeFormatter);
    }

    public Year deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        JsonToken jsonToken = JsonToken.VALUE_STRING;
        if (currentToken == jsonToken) {
            String trim = jsonParser.getValueAsString().trim();
            try {
                DateTimeFormatter dateTimeFormatter = this._formatter;
                if (dateTimeFormatter == null) {
                    return Year.parse(trim);
                }
                return Year.parse(trim, dateTimeFormatter);
            } catch (DateTimeException e) {
                return (Year) _handleDateTimeException(deserializationContext, e, trim);
            }
        } else {
            JsonToken jsonToken2 = JsonToken.VALUE_NUMBER_INT;
            if (currentToken == jsonToken2) {
                return Year.of(jsonParser.getIntValue());
            }
            if (currentToken == JsonToken.VALUE_EMBEDDED_OBJECT) {
                return (Year) jsonParser.getEmbeddedObject();
            }
            if (jsonParser.hasToken(JsonToken.START_ARRAY)) {
                return (Year) _deserializeFromArray(jsonParser, deserializationContext);
            }
            return (Year) _handleUnexpectedToken(deserializationContext, jsonParser, jsonToken, jsonToken2);
        }
    }
}
