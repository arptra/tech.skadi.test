package com.fasterxml.jackson.datatype.jsr310.deser.key;

import com.fasterxml.jackson.databind.DeserializationContext;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.ZoneId;

public class ZoneIdKeyDeserializer extends Jsr310KeyDeserializer {
    public static final ZoneIdKeyDeserializer INSTANCE = new ZoneIdKeyDeserializer();

    private ZoneIdKeyDeserializer() {
    }

    public Object deserialize(String str, DeserializationContext deserializationContext) throws IOException {
        try {
            return ZoneId.of(str);
        } catch (DateTimeException e) {
            return _handleDateTimeException(deserializationContext, ZoneId.class, e, str);
        }
    }
}
