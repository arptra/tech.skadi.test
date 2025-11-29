package com.fasterxml.jackson.datatype.jsr310.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.IOException;
import java.time.DateTimeException;
import java.util.Arrays;

abstract class JSR310DeserializerBase<T> extends StdScalarDeserializer<T> {
    private static final long serialVersionUID = 1;

    public JSR310DeserializerBase(Class<T> cls) {
        super((Class<?>) cls);
    }

    public <R> R _handleDateTimeException(DeserializationContext deserializationContext, DateTimeException dateTimeException, String str) throws JsonMappingException {
        try {
            return deserializationContext.handleWeirdStringValue(handledType(), str, "Failed to deserialize %s: (%s) %s", handledType().getName(), dateTimeException.getClass().getName(), dateTimeException.getMessage());
        } catch (JsonMappingException e) {
            e.initCause(dateTimeException);
            throw e;
        } catch (IOException e2) {
            if (e2.getCause() == null) {
                e2.initCause(dateTimeException);
            }
            throw JsonMappingException.fromUnexpectedIOE(e2);
        }
    }

    public <R> R _handleUnexpectedToken(DeserializationContext deserializationContext, JsonParser jsonParser, String str, Object... objArr) throws JsonMappingException {
        try {
            return deserializationContext.handleUnexpectedToken(handledType(), jsonParser.getCurrentToken(), jsonParser, str, objArr);
        } catch (JsonMappingException e) {
            throw e;
        } catch (IOException e2) {
            throw JsonMappingException.fromUnexpectedIOE(e2);
        }
    }

    public DateTimeException _peelDTE(DateTimeException dateTimeException) {
        while (true) {
            Throwable cause = dateTimeException.getCause();
            if (cause == null || !(cause instanceof DateTimeException)) {
                return dateTimeException;
            }
            dateTimeException = (DateTimeException) cause;
        }
        return dateTimeException;
    }

    public <BOGUS> BOGUS _reportWrongToken(DeserializationContext deserializationContext, JsonToken jsonToken, String str) throws IOException {
        deserializationContext.reportWrongTokenException((JsonDeserializer<?>) this, jsonToken, "Expected %s for '%s' of %s value", jsonToken.name(), str, handledType().getName());
        return null;
    }

    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) throws IOException {
        return typeDeserializer.deserializeTypedFromAny(jsonParser, deserializationContext);
    }

    public <BOGUS> BOGUS _reportWrongToken(JsonParser jsonParser, DeserializationContext deserializationContext, JsonToken... jsonTokenArr) throws IOException {
        return deserializationContext.reportInputMismatch(handledType(), "Unexpected token (%s), expected one of %s for %s value", jsonParser.getCurrentToken(), Arrays.asList(jsonTokenArr).toString(), handledType().getName());
    }

    public <R> R _handleUnexpectedToken(DeserializationContext deserializationContext, JsonParser jsonParser, JsonToken... jsonTokenArr) throws JsonMappingException {
        return _handleUnexpectedToken(deserializationContext, jsonParser, "Unexpected token (%s), expected one of %s for %s value", jsonParser.currentToken(), Arrays.asList(jsonTokenArr), handledType().getName());
    }
}
