package com.fasterxml.jackson.datatype.jsr310.ser;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.honey.account.z0.d;
import com.honey.account.z0.e;
import com.honey.account.z0.f;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class OffsetDateTimeSerializer extends InstantSerializerBase<OffsetDateTime> {
    public static final OffsetDateTimeSerializer INSTANCE = new OffsetDateTimeSerializer();
    private static final long serialVersionUID = 1;

    public OffsetDateTimeSerializer() {
        super(OffsetDateTime.class, new d(), new e(), new f(), DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }

    public JSR310FormattedSerializerBase<?> withFeatures(Boolean bool, Boolean bool2) {
        return new OffsetDateTimeSerializer(this, this._useTimestamp, bool2, this._formatter);
    }

    public JSR310FormattedSerializerBase<?> withFormat(Boolean bool, DateTimeFormatter dateTimeFormatter, JsonFormat.Shape shape) {
        return new OffsetDateTimeSerializer(this, bool, dateTimeFormatter);
    }

    public OffsetDateTimeSerializer(OffsetDateTimeSerializer offsetDateTimeSerializer, Boolean bool, DateTimeFormatter dateTimeFormatter) {
        this(offsetDateTimeSerializer, bool, (Boolean) null, dateTimeFormatter);
    }

    public OffsetDateTimeSerializer(OffsetDateTimeSerializer offsetDateTimeSerializer, Boolean bool, Boolean bool2, DateTimeFormatter dateTimeFormatter) {
        super(offsetDateTimeSerializer, bool, bool2, dateTimeFormatter);
    }
}
