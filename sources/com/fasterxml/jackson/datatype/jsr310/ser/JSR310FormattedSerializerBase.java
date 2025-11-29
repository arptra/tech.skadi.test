package com.fasterxml.jackson.datatype.jsr310.ser;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonStringFormatVisitor;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import java.lang.reflect.Type;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

abstract class JSR310FormattedSerializerBase<T> extends JSR310SerializerBase<T> implements ContextualSerializer {
    private static final long serialVersionUID = 1;
    protected final DateTimeFormatter _formatter;
    protected final JsonFormat.Shape _shape;
    protected final Boolean _useNanoseconds;
    protected final Boolean _useTimestamp;

    public JSR310FormattedSerializerBase(Class<T> cls) {
        this(cls, (DateTimeFormatter) null);
    }

    public void _acceptTimestampVisitor(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType) throws JsonMappingException {
        JsonArrayFormatVisitor expectArrayFormat = jsonFormatVisitorWrapper.expectArrayFormat(javaType);
        if (expectArrayFormat != null) {
            expectArrayFormat.itemsFormat(JsonFormatTypes.INTEGER);
        }
    }

    public boolean _useTimestampExplicitOnly(SerializerProvider serializerProvider) {
        Boolean bool = this._useTimestamp;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType) throws JsonMappingException {
        SerializerProvider provider = jsonFormatVisitorWrapper.getProvider();
        if (provider == null || !useTimestamp(provider)) {
            JsonStringFormatVisitor expectStringFormat = jsonFormatVisitorWrapper.expectStringFormat(javaType);
            if (expectStringFormat != null) {
                expectStringFormat.format(JsonValueFormat.DATE_TIME);
                return;
            }
            return;
        }
        _acceptTimestampVisitor(jsonFormatVisitorWrapper, javaType);
    }

    public JsonSerializer<?> createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        JsonFormat.Value findFormatOverrides = findFormatOverrides(serializerProvider, beanProperty, handledType());
        if (findFormatOverrides == null) {
            return this;
        }
        JsonFormat.Shape shape = findFormatOverrides.getShape();
        Boolean bool = (shape == JsonFormat.Shape.ARRAY || shape.isNumeric()) ? Boolean.TRUE : shape == JsonFormat.Shape.STRING ? Boolean.FALSE : null;
        DateTimeFormatter dateTimeFormatter = this._formatter;
        if (findFormatOverrides.hasPattern()) {
            String pattern = findFormatOverrides.getPattern();
            Locale locale = findFormatOverrides.hasLocale() ? findFormatOverrides.getLocale() : serializerProvider.getLocale();
            dateTimeFormatter = locale == null ? DateTimeFormatter.ofPattern(pattern) : DateTimeFormatter.ofPattern(pattern, locale);
            if (findFormatOverrides.hasTimeZone()) {
                dateTimeFormatter = dateTimeFormatter.withZone(findFormatOverrides.getTimeZone().toZoneId());
            }
        }
        if (!(shape == this._shape && bool == this._useTimestamp && dateTimeFormatter == this._formatter)) {
            this = withFormat(bool, dateTimeFormatter, shape);
        }
        Boolean feature = findFormatOverrides.getFeature(JsonFormat.Feature.WRITE_DATES_WITH_ZONE_ID);
        Boolean feature2 = findFormatOverrides.getFeature(JsonFormat.Feature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS);
        return (feature == null && feature2 == null) ? this : this.withFeatures(feature, feature2);
    }

    public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
        return createSchemaNode(serializerProvider.isEnabled(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS) ? "array" : "string", true);
    }

    public boolean useNanoseconds(SerializerProvider serializerProvider) {
        Boolean bool = this._useNanoseconds;
        if (bool != null) {
            return bool.booleanValue();
        }
        JsonFormat.Shape shape = this._shape;
        if (shape != null) {
            if (shape == JsonFormat.Shape.NUMBER_INT) {
                return false;
            }
            if (shape == JsonFormat.Shape.NUMBER_FLOAT) {
                return true;
            }
        }
        return serializerProvider.isEnabled(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS);
    }

    public boolean useTimestamp(SerializerProvider serializerProvider) {
        Boolean bool = this._useTimestamp;
        if (bool != null) {
            return bool.booleanValue();
        }
        JsonFormat.Shape shape = this._shape;
        if (shape != null) {
            if (shape == JsonFormat.Shape.STRING) {
                return false;
            }
            if (shape == JsonFormat.Shape.NUMBER_INT) {
                return true;
            }
        }
        return this._formatter == null && serializerProvider.isEnabled(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    @Deprecated
    public JSR310FormattedSerializerBase<?> withFeatures(Boolean bool) {
        return this;
    }

    public abstract JSR310FormattedSerializerBase<?> withFormat(Boolean bool, DateTimeFormatter dateTimeFormatter, JsonFormat.Shape shape);

    public JSR310FormattedSerializerBase(Class<T> cls, DateTimeFormatter dateTimeFormatter) {
        super(cls);
        this._useTimestamp = null;
        this._useNanoseconds = null;
        this._shape = null;
        this._formatter = dateTimeFormatter;
    }

    public JSR310FormattedSerializerBase<?> withFeatures(Boolean bool, Boolean bool2) {
        return this;
    }

    public JSR310FormattedSerializerBase(JSR310FormattedSerializerBase<?> jSR310FormattedSerializerBase, Boolean bool, DateTimeFormatter dateTimeFormatter, JsonFormat.Shape shape) {
        this(jSR310FormattedSerializerBase, bool, (Boolean) null, dateTimeFormatter, shape);
    }

    public JSR310FormattedSerializerBase(JSR310FormattedSerializerBase<?> jSR310FormattedSerializerBase, Boolean bool, Boolean bool2, DateTimeFormatter dateTimeFormatter, JsonFormat.Shape shape) {
        super(jSR310FormattedSerializerBase.handledType());
        this._useTimestamp = bool;
        this._useNanoseconds = bool2;
        this._formatter = dateTimeFormatter;
        this._shape = shape;
    }
}
