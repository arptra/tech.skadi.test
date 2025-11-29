package com.fasterxml.jackson.datatype.jsr310.ser;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

public class LocalTimeSerializer extends JSR310FormattedSerializerBase<LocalTime> {
    public static final LocalTimeSerializer INSTANCE = new LocalTimeSerializer();
    private static final long serialVersionUID = 1;

    public LocalTimeSerializer() {
        this((DateTimeFormatter) null);
    }

    private final void _serializeAsArrayContents(LocalTime localTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeNumber(localTime.getHour());
        jsonGenerator.writeNumber(localTime.getMinute());
        int second = localTime.getSecond();
        int nano = localTime.getNano();
        if (second > 0 || nano > 0) {
            jsonGenerator.writeNumber(second);
            if (nano <= 0) {
                return;
            }
            if (useNanoseconds(serializerProvider)) {
                jsonGenerator.writeNumber(nano);
            } else {
                jsonGenerator.writeNumber(localTime.get(ChronoField.MILLI_OF_SECOND));
            }
        }
    }

    public DateTimeFormatter _defaultFormatter() {
        return DateTimeFormatter.ISO_LOCAL_TIME;
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
        return useTimestamp(serializerProvider) ? JsonToken.START_ARRAY : JsonToken.VALUE_STRING;
    }

    public JSR310FormattedSerializerBase<?> withFeatures(Boolean bool, Boolean bool2) {
        return new LocalTimeSerializer(this, this._useTimestamp, bool2, this._formatter);
    }

    public JSR310FormattedSerializerBase<LocalTime> withFormat(Boolean bool, DateTimeFormatter dateTimeFormatter, JsonFormat.Shape shape) {
        return new LocalTimeSerializer(this, bool, dateTimeFormatter);
    }

    public LocalTimeSerializer(DateTimeFormatter dateTimeFormatter) {
        super(LocalTime.class, dateTimeFormatter);
    }

    public void serialize(LocalTime localTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (useTimestamp(serializerProvider)) {
            jsonGenerator.writeStartArray();
            _serializeAsArrayContents(localTime, jsonGenerator, serializerProvider);
            jsonGenerator.writeEndArray();
            return;
        }
        DateTimeFormatter dateTimeFormatter = this._formatter;
        if (dateTimeFormatter == null) {
            dateTimeFormatter = _defaultFormatter();
        }
        jsonGenerator.writeString(localTime.format(dateTimeFormatter));
    }

    public void serializeWithType(LocalTime localTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        WritableTypeId writeTypePrefix = typeSerializer.writeTypePrefix(jsonGenerator, typeSerializer.typeId(localTime, serializationShape(serializerProvider)));
        if (writeTypePrefix.valueShape == JsonToken.START_ARRAY) {
            _serializeAsArrayContents(localTime, jsonGenerator, serializerProvider);
        } else {
            DateTimeFormatter dateTimeFormatter = this._formatter;
            if (dateTimeFormatter == null) {
                dateTimeFormatter = _defaultFormatter();
            }
            jsonGenerator.writeString(localTime.format(dateTimeFormatter));
        }
        typeSerializer.writeTypeSuffix(jsonGenerator, writeTypePrefix);
    }

    public LocalTimeSerializer(LocalTimeSerializer localTimeSerializer, Boolean bool, DateTimeFormatter dateTimeFormatter) {
        this(localTimeSerializer, bool, (Boolean) null, dateTimeFormatter);
    }

    public LocalTimeSerializer(LocalTimeSerializer localTimeSerializer, Boolean bool, Boolean bool2, DateTimeFormatter dateTimeFormatter) {
        super(localTimeSerializer, bool, bool2, dateTimeFormatter, (JsonFormat.Shape) null);
    }
}
