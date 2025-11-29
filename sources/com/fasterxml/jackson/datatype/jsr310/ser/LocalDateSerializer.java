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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateSerializer extends JSR310FormattedSerializerBase<LocalDate> {
    public static final LocalDateSerializer INSTANCE = new LocalDateSerializer();
    private static final long serialVersionUID = 1;

    /* renamed from: com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$fasterxml$jackson$core$JsonToken;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.fasterxml.jackson.core.JsonToken[] r0 = com.fasterxml.jackson.core.JsonToken.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$fasterxml$jackson$core$JsonToken = r0
                com.fasterxml.jackson.core.JsonToken r1 = com.fasterxml.jackson.core.JsonToken.START_ARRAY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$fasterxml$jackson$core$JsonToken     // Catch:{ NoSuchFieldError -> 0x001d }
                com.fasterxml.jackson.core.JsonToken r1 = com.fasterxml.jackson.core.JsonToken.VALUE_NUMBER_INT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer.AnonymousClass1.<clinit>():void");
        }
    }

    public LocalDateSerializer() {
        super(LocalDate.class);
    }

    public void _serializeAsArrayContents(LocalDate localDate, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeNumber(localDate.getYear());
        jsonGenerator.writeNumber(localDate.getMonthValue());
        jsonGenerator.writeNumber(localDate.getDayOfMonth());
    }

    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType) throws JsonMappingException {
        SerializerProvider provider = jsonFormatVisitorWrapper.getProvider();
        if (provider == null || !useTimestamp(provider)) {
            JsonStringFormatVisitor expectStringFormat = jsonFormatVisitorWrapper.expectStringFormat(javaType);
            if (expectStringFormat != null) {
                expectStringFormat.format(JsonValueFormat.DATE);
                return;
            }
            return;
        }
        _acceptTimestampVisitor(jsonFormatVisitorWrapper, javaType);
    }

    public /* bridge */ /* synthetic */ JsonSerializer createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        return super.createContextual(serializerProvider, beanProperty);
    }

    public /* bridge */ /* synthetic */ JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
        return super.getSchema(serializerProvider, type);
    }

    public JsonToken serializationShape(SerializerProvider serializerProvider) {
        return useTimestamp(serializerProvider) ? this._shape == JsonFormat.Shape.NUMBER_INT ? JsonToken.VALUE_NUMBER_INT : JsonToken.START_ARRAY : JsonToken.VALUE_STRING;
    }

    public LocalDateSerializer(LocalDateSerializer localDateSerializer, Boolean bool, DateTimeFormatter dateTimeFormatter, JsonFormat.Shape shape) {
        super(localDateSerializer, bool, dateTimeFormatter, shape);
    }

    public void serialize(LocalDate localDate, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (!useTimestamp(serializerProvider)) {
            DateTimeFormatter dateTimeFormatter = this._formatter;
            jsonGenerator.writeString(dateTimeFormatter == null ? localDate.toString() : localDate.format(dateTimeFormatter));
        } else if (this._shape == JsonFormat.Shape.NUMBER_INT) {
            jsonGenerator.writeNumber(localDate.toEpochDay());
        } else {
            jsonGenerator.writeStartArray();
            _serializeAsArrayContents(localDate, jsonGenerator, serializerProvider);
            jsonGenerator.writeEndArray();
        }
    }

    public void serializeWithType(LocalDate localDate, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        WritableTypeId writeTypePrefix = typeSerializer.writeTypePrefix(jsonGenerator, typeSerializer.typeId(localDate, serializationShape(serializerProvider)));
        int i = AnonymousClass1.$SwitchMap$com$fasterxml$jackson$core$JsonToken[writeTypePrefix.valueShape.ordinal()];
        if (i == 1) {
            _serializeAsArrayContents(localDate, jsonGenerator, serializerProvider);
        } else if (i != 2) {
            DateTimeFormatter dateTimeFormatter = this._formatter;
            jsonGenerator.writeString(dateTimeFormatter == null ? localDate.toString() : localDate.format(dateTimeFormatter));
        } else {
            jsonGenerator.writeNumber(localDate.toEpochDay());
        }
        typeSerializer.writeTypeSuffix(jsonGenerator, writeTypePrefix);
    }

    public LocalDateSerializer withFormat(Boolean bool, DateTimeFormatter dateTimeFormatter, JsonFormat.Shape shape) {
        return new LocalDateSerializer(this, bool, dateTimeFormatter, shape);
    }

    public LocalDateSerializer(DateTimeFormatter dateTimeFormatter) {
        super(LocalDate.class, dateTimeFormatter);
    }
}
