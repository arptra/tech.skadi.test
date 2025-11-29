package com.fasterxml.jackson.datatype.jsr310.ser.key;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

public class Jsr310NullKeySerializer extends JsonSerializer<Object> {
    public static final String NULL_KEY = "";

    public void serialize(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (obj == null) {
            jsonGenerator.writeFieldName("");
            return;
        }
        throw JsonMappingException.from(jsonGenerator, "Jsr310NullKeySerializer is only for serializing null values.");
    }
}
