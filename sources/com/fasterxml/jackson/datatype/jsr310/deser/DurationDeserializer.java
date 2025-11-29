package com.fasterxml.jackson.datatype.jsr310.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.DecimalUtils;
import com.honey.account.x0.a;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.Duration;

public class DurationDeserializer extends JSR310DeserializerBase<Duration> {
    public static final DurationDeserializer INSTANCE = new DurationDeserializer();
    private static final long serialVersionUID = 1;

    private DurationDeserializer() {
        super(Duration.class);
    }

    public /* bridge */ /* synthetic */ Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) throws IOException {
        return super.deserializeWithType(jsonParser, deserializationContext, typeDeserializer);
    }

    public Duration deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        int currentTokenId = jsonParser.getCurrentTokenId();
        if (currentTokenId == 3) {
            return (Duration) _deserializeFromArray(jsonParser, deserializationContext);
        }
        if (currentTokenId == 12) {
            return (Duration) jsonParser.getEmbeddedObject();
        }
        if (currentTokenId == 6) {
            String trim = jsonParser.getText().trim();
            if (trim.length() == 0) {
                return null;
            }
            try {
                return Duration.parse(trim);
            } catch (DateTimeException e) {
                return (Duration) _handleDateTimeException(deserializationContext, e, trim);
            }
        } else if (currentTokenId != 7) {
            if (currentTokenId != 8) {
                return (Duration) _handleUnexpectedToken(deserializationContext, jsonParser, JsonToken.VALUE_STRING, JsonToken.VALUE_NUMBER_INT, JsonToken.VALUE_NUMBER_FLOAT);
            }
            return (Duration) DecimalUtils.extractSecondsAndNanos(jsonParser.getDecimalValue(), new a());
        } else if (deserializationContext.isEnabled(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS)) {
            return Duration.ofSeconds(jsonParser.getLongValue());
        } else {
            return Duration.ofMillis(jsonParser.getLongValue());
        }
    }
}
