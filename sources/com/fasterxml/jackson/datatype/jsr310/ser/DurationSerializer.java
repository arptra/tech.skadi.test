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
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat;
import com.fasterxml.jackson.datatype.jsr310.DecimalUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.Duration;
import java.time.format.DateTimeFormatter;

public class DurationSerializer extends JSR310FormattedSerializerBase<Duration> {
    public static final DurationSerializer INSTANCE = new DurationSerializer();
    private static final long serialVersionUID = 1;

    private DurationSerializer() {
        super(Duration.class);
    }

    public void _acceptTimestampVisitor(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType) throws JsonMappingException {
        JsonIntegerFormatVisitor expectIntegerFormat = jsonFormatVisitorWrapper.expectIntegerFormat(javaType);
        if (expectIntegerFormat != null) {
            expectIntegerFormat.numberType(JsonParser.NumberType.LONG);
            SerializerProvider provider = jsonFormatVisitorWrapper.getProvider();
            if (provider == null || !useNanoseconds(provider)) {
                expectIntegerFormat.format(JsonValueFormat.UTC_MILLISEC);
            }
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

    public JSR310FormattedSerializerBase<?> withFeatures(Boolean bool, Boolean bool2) {
        return new DurationSerializer(this, this._useTimestamp, bool2, this._formatter);
    }

    public DurationSerializer(DurationSerializer durationSerializer, Boolean bool, DateTimeFormatter dateTimeFormatter) {
        super(durationSerializer, bool, dateTimeFormatter, (JsonFormat.Shape) null);
    }

    public void serialize(Duration duration, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (!useTimestamp(serializerProvider)) {
            jsonGenerator.writeString(duration.toString());
        } else if (useNanoseconds(serializerProvider)) {
            jsonGenerator.writeNumber(DecimalUtils.toBigDecimal(duration.getSeconds(), duration.getNano()));
        } else {
            jsonGenerator.writeNumber(duration.toMillis());
        }
    }

    public DurationSerializer withFormat(Boolean bool, DateTimeFormatter dateTimeFormatter, JsonFormat.Shape shape) {
        return new DurationSerializer(this, bool, dateTimeFormatter);
    }

    public DurationSerializer(DurationSerializer durationSerializer, Boolean bool, Boolean bool2, DateTimeFormatter dateTimeFormatter) {
        super(durationSerializer, bool, bool2, dateTimeFormatter, (JsonFormat.Shape) null);
    }
}
