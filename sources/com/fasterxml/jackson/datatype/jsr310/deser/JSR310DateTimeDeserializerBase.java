package com.fasterxml.jackson.datatype.jsr310.deser;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public abstract class JSR310DateTimeDeserializerBase<T> extends JSR310DeserializerBase<T> implements ContextualDeserializer {
    protected final DateTimeFormatter _formatter;

    public JSR310DateTimeDeserializerBase(Class<T> cls, DateTimeFormatter dateTimeFormatter) {
        super(cls);
        this._formatter = dateTimeFormatter;
    }

    public void _throwNoNumericTimestampNeedTimeZone(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        deserializationContext.reportInputMismatch(handledType(), "raw timestamp (%d) not allowed for `%s`: need additional information such as an offset or time-zone (see class Javadocs)", jsonParser.getNumberValue(), handledType().getName());
    }

    public JsonDeserializer<?> createContextual(DeserializationContext deserializationContext, BeanProperty beanProperty) throws JsonMappingException {
        JsonFormat.Value findFormatOverrides = findFormatOverrides(deserializationContext, beanProperty, handledType());
        if (findFormatOverrides == null || !findFormatOverrides.hasPattern()) {
            return this;
        }
        String pattern = findFormatOverrides.getPattern();
        Locale locale = findFormatOverrides.hasLocale() ? findFormatOverrides.getLocale() : deserializationContext.getLocale();
        DateTimeFormatter ofPattern = locale == null ? DateTimeFormatter.ofPattern(pattern) : DateTimeFormatter.ofPattern(pattern, locale);
        if (findFormatOverrides.hasTimeZone()) {
            ofPattern = ofPattern.withZone(findFormatOverrides.getTimeZone().toZoneId());
        }
        return withDateFormat(ofPattern);
    }

    public /* bridge */ /* synthetic */ Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) throws IOException {
        return super.deserializeWithType(jsonParser, deserializationContext, typeDeserializer);
    }

    public abstract JsonDeserializer<T> withDateFormat(DateTimeFormatter dateTimeFormatter);
}
