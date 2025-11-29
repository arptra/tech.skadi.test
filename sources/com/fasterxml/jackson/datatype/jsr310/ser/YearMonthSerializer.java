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
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonStringFormatVisitor;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class YearMonthSerializer extends JSR310FormattedSerializerBase<YearMonth> {
    public static final YearMonthSerializer INSTANCE = new YearMonthSerializer();
    private static final long serialVersionUID = 1;

    private YearMonthSerializer() {
        this((DateTimeFormatter) null);
    }

    public void _acceptTimestampVisitor(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType) throws JsonMappingException {
        SerializerProvider provider = jsonFormatVisitorWrapper.getProvider();
        if (provider == null || !useTimestamp(provider)) {
            JsonStringFormatVisitor expectStringFormat = jsonFormatVisitorWrapper.expectStringFormat(javaType);
            if (expectStringFormat != null) {
                expectStringFormat.format(JsonValueFormat.DATE_TIME);
                return;
            }
            return;
        }
        super._acceptTimestampVisitor(jsonFormatVisitorWrapper, javaType);
    }

    public void _serializeAsArrayContents(YearMonth yearMonth, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeNumber(yearMonth.getYear());
        jsonGenerator.writeNumber(yearMonth.getMonthValue());
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

    public YearMonthSerializer(DateTimeFormatter dateTimeFormatter) {
        super(YearMonth.class, dateTimeFormatter);
    }

    public void serialize(YearMonth yearMonth, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (useTimestamp(serializerProvider)) {
            jsonGenerator.writeStartArray();
            _serializeAsArrayContents(yearMonth, jsonGenerator, serializerProvider);
            jsonGenerator.writeEndArray();
            return;
        }
        DateTimeFormatter dateTimeFormatter = this._formatter;
        jsonGenerator.writeString(dateTimeFormatter == null ? yearMonth.toString() : yearMonth.format(dateTimeFormatter));
    }

    public void serializeWithType(YearMonth yearMonth, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        WritableTypeId writeTypePrefix = typeSerializer.writeTypePrefix(jsonGenerator, typeSerializer.typeId(yearMonth, serializationShape(serializerProvider)));
        if (writeTypePrefix.valueShape == JsonToken.START_ARRAY) {
            _serializeAsArrayContents(yearMonth, jsonGenerator, serializerProvider);
        } else {
            DateTimeFormatter dateTimeFormatter = this._formatter;
            jsonGenerator.writeString(dateTimeFormatter == null ? yearMonth.toString() : yearMonth.format(dateTimeFormatter));
        }
        typeSerializer.writeTypeSuffix(jsonGenerator, writeTypePrefix);
    }

    public YearMonthSerializer withFormat(Boolean bool, DateTimeFormatter dateTimeFormatter, JsonFormat.Shape shape) {
        return new YearMonthSerializer(this, bool, dateTimeFormatter);
    }

    private YearMonthSerializer(YearMonthSerializer yearMonthSerializer, Boolean bool, DateTimeFormatter dateTimeFormatter) {
        super(yearMonthSerializer, bool, dateTimeFormatter, (JsonFormat.Shape) null);
    }
}
