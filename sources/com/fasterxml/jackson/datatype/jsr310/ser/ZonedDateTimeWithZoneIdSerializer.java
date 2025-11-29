package com.fasterxml.jackson.datatype.jsr310.ser;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.honey.account.z0.h;
import com.honey.account.z0.i;
import com.honey.account.z0.j;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Deprecated
public class ZonedDateTimeWithZoneIdSerializer extends InstantSerializerBase<ZonedDateTime> {
    public static final ZonedDateTimeWithZoneIdSerializer INSTANCE = new ZonedDateTimeWithZoneIdSerializer();
    private static final long serialVersionUID = 1;

    public ZonedDateTimeWithZoneIdSerializer() {
        super(ZonedDateTime.class, new j(), new h(), new i(), (DateTimeFormatter) null);
    }

    public JSR310FormattedSerializerBase<?> withFeatures(Boolean bool, Boolean bool2) {
        return new ZonedDateTimeWithZoneIdSerializer(this, this._useTimestamp, bool2, this._formatter);
    }

    public JSR310FormattedSerializerBase<?> withFormat(Boolean bool, DateTimeFormatter dateTimeFormatter, JsonFormat.Shape shape) {
        return new ZonedDateTimeWithZoneIdSerializer(this, bool, dateTimeFormatter);
    }

    public ZonedDateTimeWithZoneIdSerializer(ZonedDateTimeWithZoneIdSerializer zonedDateTimeWithZoneIdSerializer, Boolean bool, DateTimeFormatter dateTimeFormatter) {
        this(zonedDateTimeWithZoneIdSerializer, bool, (Boolean) null, dateTimeFormatter);
    }

    public ZonedDateTimeWithZoneIdSerializer(ZonedDateTimeWithZoneIdSerializer zonedDateTimeWithZoneIdSerializer, Boolean bool, Boolean bool2, DateTimeFormatter dateTimeFormatter) {
        super(zonedDateTimeWithZoneIdSerializer, bool, bool2, dateTimeFormatter);
    }
}
