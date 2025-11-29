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
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.Year;
import java.time.format.DateTimeFormatter;

public class YearSerializer extends JSR310FormattedSerializerBase<Year> {
    public static final YearSerializer INSTANCE = new YearSerializer();
    private static final long serialVersionUID = 1;

    public YearSerializer() {
        this((DateTimeFormatter) null);
    }

    public void _acceptTimestampVisitor(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType) throws JsonMappingException {
        JsonIntegerFormatVisitor expectIntegerFormat = jsonFormatVisitorWrapper.expectIntegerFormat(javaType);
        if (expectIntegerFormat != null) {
            expectIntegerFormat.numberType(JsonParser.NumberType.LONG);
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
        return useTimestamp(serializerProvider) ? JsonToken.VALUE_NUMBER_INT : JsonToken.VALUE_STRING;
    }

    public YearSerializer(DateTimeFormatter dateTimeFormatter) {
        super(Year.class, dateTimeFormatter);
    }

    public void serialize(Year year, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (useTimestamp(serializerProvider)) {
            jsonGenerator.writeNumber(year.getValue());
            return;
        }
        DateTimeFormatter dateTimeFormatter = this._formatter;
        jsonGenerator.writeString(dateTimeFormatter == null ? year.toString() : year.format(dateTimeFormatter));
    }

    public YearSerializer withFormat(Boolean bool, DateTimeFormatter dateTimeFormatter, JsonFormat.Shape shape) {
        return new YearSerializer(this, bool, dateTimeFormatter);
    }

    public YearSerializer(YearSerializer yearSerializer, Boolean bool, DateTimeFormatter dateTimeFormatter) {
        super(yearSerializer, bool, dateTimeFormatter, (JsonFormat.Shape) null);
    }
}
