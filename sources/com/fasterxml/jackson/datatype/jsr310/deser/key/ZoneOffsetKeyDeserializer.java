package com.fasterxml.jackson.datatype.jsr310.deser.key;

import com.fasterxml.jackson.databind.DeserializationContext;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.ZoneOffset;

public class ZoneOffsetKeyDeserializer extends Jsr310KeyDeserializer {
    public static final ZoneOffsetKeyDeserializer INSTANCE = new ZoneOffsetKeyDeserializer();

    private ZoneOffsetKeyDeserializer() {
    }

    public ZoneOffset deserialize(String str, DeserializationContext deserializationContext) throws IOException {
        try {
            return ZoneOffset.of(str);
        } catch (DateTimeException e) {
            return (ZoneOffset) _handleDateTimeException(deserializationContext, ZoneOffset.class, e, str);
        }
    }
}
