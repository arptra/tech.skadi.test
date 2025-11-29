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
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;

public class MonthDaySerializer extends JSR310FormattedSerializerBase<MonthDay> {
    public static final MonthDaySerializer INSTANCE = new MonthDaySerializer();
    private static final long serialVersionUID = 1;

    private MonthDaySerializer() {
        this((DateTimeFormatter) null);
    }

    public void _serializeAsArrayContents(MonthDay monthDay, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeNumber(monthDay.getMonthValue());
        jsonGenerator.writeNumber(monthDay.getDayOfMonth());
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
        return _useTimestampExplicitOnly(serializerProvider) ? JsonToken.START_ARRAY : JsonToken.VALUE_STRING;
    }

    public MonthDaySerializer(DateTimeFormatter dateTimeFormatter) {
        super(MonthDay.class, dateTimeFormatter);
    }

    public void serialize(MonthDay monthDay, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (_useTimestampExplicitOnly(serializerProvider)) {
            jsonGenerator.writeStartArray();
            _serializeAsArrayContents(monthDay, jsonGenerator, serializerProvider);
            jsonGenerator.writeEndArray();
            return;
        }
        DateTimeFormatter dateTimeFormatter = this._formatter;
        jsonGenerator.writeString(dateTimeFormatter == null ? monthDay.toString() : monthDay.format(dateTimeFormatter));
    }

    public void serializeWithType(MonthDay monthDay, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        WritableTypeId writeTypePrefix = typeSerializer.writeTypePrefix(jsonGenerator, typeSerializer.typeId(monthDay, serializationShape(serializerProvider)));
        if (writeTypePrefix.valueShape == JsonToken.START_ARRAY) {
            _serializeAsArrayContents(monthDay, jsonGenerator, serializerProvider);
        } else {
            DateTimeFormatter dateTimeFormatter = this._formatter;
            jsonGenerator.writeString(dateTimeFormatter == null ? monthDay.toString() : monthDay.format(dateTimeFormatter));
        }
        typeSerializer.writeTypeSuffix(jsonGenerator, writeTypePrefix);
    }

    public MonthDaySerializer withFormat(Boolean bool, DateTimeFormatter dateTimeFormatter, JsonFormat.Shape shape) {
        return new MonthDaySerializer(this, bool, dateTimeFormatter);
    }

    private MonthDaySerializer(MonthDaySerializer monthDaySerializer, Boolean bool, DateTimeFormatter dateTimeFormatter) {
        super(monthDaySerializer, bool, dateTimeFormatter, (JsonFormat.Shape) null);
    }
}
