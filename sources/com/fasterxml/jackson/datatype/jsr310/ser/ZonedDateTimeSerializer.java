package com.fasterxml.jackson.datatype.jsr310.ser;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.honey.account.z0.g;
import com.honey.account.z0.h;
import com.honey.account.z0.i;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ZonedDateTimeSerializer extends InstantSerializerBase<ZonedDateTime> {
    public static final ZonedDateTimeSerializer INSTANCE = new ZonedDateTimeSerializer();
    private static final long serialVersionUID = 1;
    protected final Boolean _writeZoneId;

    public ZonedDateTimeSerializer() {
        this(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }

    public JsonToken serializationShape(SerializerProvider serializerProvider) {
        return (useTimestamp(serializerProvider) || !shouldWriteWithZoneId(serializerProvider)) ? super.serializationShape(serializerProvider) : JsonToken.VALUE_STRING;
    }

    public boolean shouldWriteWithZoneId(SerializerProvider serializerProvider) {
        Boolean bool = this._writeZoneId;
        return bool != null ? bool.booleanValue() : serializerProvider.isEnabled(SerializationFeature.WRITE_DATES_WITH_ZONE_ID);
    }

    @Deprecated
    public JSR310FormattedSerializerBase<?> withFeatures(Boolean bool) {
        return new ZonedDateTimeSerializer(this, this._useTimestamp, this._formatter, bool);
    }

    public JSR310FormattedSerializerBase<?> withFormat(Boolean bool, DateTimeFormatter dateTimeFormatter, JsonFormat.Shape shape) {
        return new ZonedDateTimeSerializer(this, bool, dateTimeFormatter, this._writeZoneId);
    }

    public ZonedDateTimeSerializer(DateTimeFormatter dateTimeFormatter) {
        super(ZonedDateTime.class, new g(), new h(), new i(), dateTimeFormatter);
        this._writeZoneId = null;
    }

    public JSR310FormattedSerializerBase<?> withFeatures(Boolean bool, Boolean bool2) {
        return new ZonedDateTimeSerializer(this, this._useTimestamp, bool2, this._formatter, bool);
    }

    public void serialize(ZonedDateTime zonedDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (useTimestamp(serializerProvider) || !shouldWriteWithZoneId(serializerProvider)) {
            super.serialize(zonedDateTime, jsonGenerator, serializerProvider);
        } else {
            jsonGenerator.writeString(DateTimeFormatter.ISO_ZONED_DATE_TIME.format(zonedDateTime));
        }
    }

    public ZonedDateTimeSerializer(ZonedDateTimeSerializer zonedDateTimeSerializer, Boolean bool, DateTimeFormatter dateTimeFormatter, Boolean bool2) {
        this(zonedDateTimeSerializer, bool, (Boolean) null, dateTimeFormatter, bool2);
    }

    public ZonedDateTimeSerializer(ZonedDateTimeSerializer zonedDateTimeSerializer, Boolean bool, Boolean bool2, DateTimeFormatter dateTimeFormatter, Boolean bool3) {
        super(zonedDateTimeSerializer, bool, bool2, dateTimeFormatter);
        this._writeZoneId = bool3;
    }
}
