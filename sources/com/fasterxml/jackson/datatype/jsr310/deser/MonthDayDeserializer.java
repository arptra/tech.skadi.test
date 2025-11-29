package com.fasterxml.jackson.datatype.jsr310.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;

public class MonthDayDeserializer extends JSR310DateTimeDeserializerBase<MonthDay> {
    public static final MonthDayDeserializer INSTANCE = new MonthDayDeserializer((DateTimeFormatter) null);
    private static final long serialVersionUID = 1;

    public MonthDayDeserializer(DateTimeFormatter dateTimeFormatter) {
        super(MonthDay.class, dateTimeFormatter);
    }

    public JsonDeserializer<MonthDay> withDateFormat(DateTimeFormatter dateTimeFormatter) {
        return new MonthDayDeserializer(dateTimeFormatter);
    }

    public MonthDay deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken jsonToken = JsonToken.VALUE_STRING;
        if (jsonParser.hasToken(jsonToken)) {
            String trim = jsonParser.getValueAsString().trim();
            try {
                DateTimeFormatter dateTimeFormatter = this._formatter;
                if (dateTimeFormatter == null) {
                    return MonthDay.parse(trim);
                }
                return MonthDay.parse(trim, dateTimeFormatter);
            } catch (DateTimeException e) {
                return (MonthDay) _handleDateTimeException(deserializationContext, e, trim);
            }
        } else if (jsonParser.hasToken(JsonToken.VALUE_EMBEDDED_OBJECT)) {
            return (MonthDay) jsonParser.getEmbeddedObject();
        } else {
            if (jsonParser.hasToken(JsonToken.START_ARRAY)) {
                return (MonthDay) _deserializeFromArray(jsonParser, deserializationContext);
            }
            return (MonthDay) _handleUnexpectedToken(deserializationContext, jsonParser, jsonToken, JsonToken.VALUE_NUMBER_INT);
        }
    }
}
