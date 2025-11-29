package com.fasterxml.jackson.datatype.jsr310.ser;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.honey.account.z0.a;
import com.honey.account.z0.b;
import com.honey.account.z0.c;
import java.time.Instant;
import java.time.format.DateTimeFormatter;

public class InstantSerializer extends InstantSerializerBase<Instant> {
    public static final InstantSerializer INSTANCE = new InstantSerializer();
    private static final long serialVersionUID = 1;

    public InstantSerializer() {
        super(Instant.class, new a(), new b(), new c(), (DateTimeFormatter) null);
    }

    public JSR310FormattedSerializerBase<?> withFeatures(Boolean bool, Boolean bool2) {
        return new InstantSerializer(this, this._useTimestamp, bool2, this._formatter);
    }

    public JSR310FormattedSerializerBase<Instant> withFormat(Boolean bool, DateTimeFormatter dateTimeFormatter, JsonFormat.Shape shape) {
        return new InstantSerializer(this, bool, dateTimeFormatter);
    }

    public InstantSerializer(InstantSerializer instantSerializer, Boolean bool, DateTimeFormatter dateTimeFormatter) {
        this(instantSerializer, bool, (Boolean) null, dateTimeFormatter);
    }

    public InstantSerializer(InstantSerializer instantSerializer, Boolean bool, Boolean bool2, DateTimeFormatter dateTimeFormatter) {
        super(instantSerializer, bool, bool2, dateTimeFormatter);
    }
}
