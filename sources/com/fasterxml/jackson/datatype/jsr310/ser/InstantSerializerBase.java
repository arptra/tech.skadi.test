package com.fasterxml.jackson.datatype.jsr310.ser;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonIntegerFormatVisitor;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonNumberFormatVisitor;
import com.fasterxml.jackson.datatype.jsr310.DecimalUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public abstract class InstantSerializerBase<T extends Temporal> extends JSR310FormattedSerializerBase<T> {
    private final DateTimeFormatter defaultFormat;
    private final ToLongFunction<T> getEpochMillis;
    private final ToLongFunction<T> getEpochSeconds;
    private final ToIntFunction<T> getNanoseconds;

    public InstantSerializerBase(Class<T> cls, ToLongFunction<T> toLongFunction, ToLongFunction<T> toLongFunction2, ToIntFunction<T> toIntFunction, DateTimeFormatter dateTimeFormatter) {
        super(cls, (DateTimeFormatter) null);
        this.defaultFormat = dateTimeFormatter;
        this.getEpochMillis = toLongFunction;
        this.getEpochSeconds = toLongFunction2;
        this.getNanoseconds = toIntFunction;
    }

    public void _acceptTimestampVisitor(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType) throws JsonMappingException {
        SerializerProvider provider = jsonFormatVisitorWrapper.getProvider();
        if (provider == null || !useNanoseconds(provider)) {
            JsonIntegerFormatVisitor expectIntegerFormat = jsonFormatVisitorWrapper.expectIntegerFormat(javaType);
            if (expectIntegerFormat != null) {
                expectIntegerFormat.numberType(JsonParser.NumberType.LONG);
                return;
            }
            return;
        }
        JsonNumberFormatVisitor expectNumberFormat = jsonFormatVisitorWrapper.expectNumberFormat(javaType);
        if (expectNumberFormat != null) {
            expectNumberFormat.numberType(JsonParser.NumberType.BIG_DECIMAL);
        }
    }

    public /* bridge */ /* synthetic */ void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType) throws JsonMappingException {
        super.acceptJsonFormatVisitor(jsonFormatVisitorWrapper, javaType);
    }

    public /* bridge */ /* synthetic */ JsonSerializer createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        return super.createContextual(serializerProvider, beanProperty);
    }

    public /* bridge */ /* synthetic */ JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
        return super.getSchema(serializerProvider, type);
    }

    public JsonToken serializationShape(SerializerProvider serializerProvider) {
        return useTimestamp(serializerProvider) ? useNanoseconds(serializerProvider) ? JsonToken.VALUE_NUMBER_FLOAT : JsonToken.VALUE_NUMBER_INT : JsonToken.VALUE_STRING;
    }

    public abstract JSR310FormattedSerializerBase<?> withFormat(Boolean bool, DateTimeFormatter dateTimeFormatter, JsonFormat.Shape shape);

    public void serialize(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        String str;
        if (!useTimestamp(serializerProvider)) {
            DateTimeFormatter dateTimeFormatter = this._formatter;
            if (dateTimeFormatter != null) {
                str = dateTimeFormatter.format(t);
            } else {
                DateTimeFormatter dateTimeFormatter2 = this.defaultFormat;
                if (dateTimeFormatter2 != null) {
                    str = dateTimeFormatter2.format(t);
                } else {
                    str = t.toString();
                }
            }
            jsonGenerator.writeString(str);
        } else if (useNanoseconds(serializerProvider)) {
            jsonGenerator.writeNumber(DecimalUtils.toBigDecimal(this.getEpochSeconds.applyAsLong(t), this.getNanoseconds.applyAsInt(t)));
        } else {
            jsonGenerator.writeNumber(this.getEpochMillis.applyAsLong(t));
        }
    }

    public InstantSerializerBase(InstantSerializerBase<T> instantSerializerBase, Boolean bool, DateTimeFormatter dateTimeFormatter) {
        this(instantSerializerBase, bool, (Boolean) null, dateTimeFormatter);
    }

    public InstantSerializerBase(InstantSerializerBase<T> instantSerializerBase, Boolean bool, Boolean bool2, DateTimeFormatter dateTimeFormatter) {
        super(instantSerializerBase, bool, bool2, dateTimeFormatter, (JsonFormat.Shape) null);
        this.defaultFormat = instantSerializerBase.defaultFormat;
        this.getEpochMillis = instantSerializerBase.getEpochMillis;
        this.getEpochSeconds = instantSerializerBase.getEpochSeconds;
        this.getNanoseconds = instantSerializerBase.getNanoseconds;
    }
}
