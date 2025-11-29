package com.fasterxml.jackson.datatype.jsr310.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class JSR310StringParsableDeserializer extends JSR310DeserializerBase<Object> {
    public static final JsonDeserializer<Period> PERIOD = createDeserializer(Period.class, 1);
    protected static final int TYPE_PERIOD = 1;
    protected static final int TYPE_ZONE_ID = 2;
    protected static final int TYPE_ZONE_OFFSET = 3;
    public static final JsonDeserializer<ZoneId> ZONE_ID = createDeserializer(ZoneId.class, 2);
    public static final JsonDeserializer<ZoneOffset> ZONE_OFFSET = createDeserializer(ZoneOffset.class, 3);
    private static final long serialVersionUID = 1;
    protected final int _valueType;

    public JSR310StringParsableDeserializer(Class<?> cls, int i) {
        super(cls);
        this._valueType = i;
    }

    public static <T> JsonDeserializer<T> createDeserializer(Class<T> cls, int i) {
        return new JSR310StringParsableDeserializer(cls, i);
    }

    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken jsonToken = JsonToken.VALUE_STRING;
        if (jsonParser.hasToken(jsonToken)) {
            String trim = jsonParser.getText().trim();
            if (trim.length() == 0) {
                return null;
            }
            try {
                int i = this._valueType;
                if (i == 1) {
                    return Period.parse(trim);
                }
                if (i == 2) {
                    return ZoneId.of(trim);
                }
                if (i == 3) {
                    return ZoneOffset.of(trim);
                }
            } catch (DateTimeException e) {
                return _handleDateTimeException(deserializationContext, e, trim);
            }
        }
        if (jsonParser.hasToken(JsonToken.VALUE_EMBEDDED_OBJECT)) {
            return jsonParser.getEmbeddedObject();
        }
        if (jsonParser.hasToken(JsonToken.START_ARRAY)) {
            return _deserializeFromArray(jsonParser, deserializationContext);
        }
        throw deserializationContext.wrongTokenException(jsonParser, handledType(), jsonToken, (String) null);
    }

    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) throws IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        return (currentToken == null || !currentToken.isScalarValue()) ? typeDeserializer.deserializeTypedFromAny(jsonParser, deserializationContext) : deserialize(jsonParser, deserializationContext);
    }
}
