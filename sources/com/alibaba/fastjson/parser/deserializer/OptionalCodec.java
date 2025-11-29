package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public class OptionalCodec implements ObjectSerializer, ObjectDeserializer {
    public static OptionalCodec instance = new OptionalCodec();

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        if (type == OptionalInt.class) {
            Integer castToInt = TypeUtils.castToInt(defaultJSONParser.parseObject(Integer.class));
            return castToInt == null ? OptionalInt.empty() : OptionalInt.of(castToInt.intValue());
        } else if (type == OptionalLong.class) {
            Long castToLong = TypeUtils.castToLong(defaultJSONParser.parseObject(Long.class));
            return castToLong == null ? OptionalLong.empty() : OptionalLong.of(castToLong.longValue());
        } else if (type == OptionalDouble.class) {
            Double castToDouble = TypeUtils.castToDouble(defaultJSONParser.parseObject(Double.class));
            return castToDouble == null ? OptionalDouble.empty() : OptionalDouble.of(castToDouble.doubleValue());
        } else {
            Object parseObject = defaultJSONParser.parseObject(TypeUtils.unwrapOptional(type));
            return parseObject == null ? Optional.empty() : Optional.of(parseObject);
        }
    }

    public int getFastMatchToken() {
        return 12;
    }

    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        if (obj == null) {
            jSONSerializer.writeNull();
        } else if (obj instanceof Optional) {
            Optional optional = (Optional) obj;
            jSONSerializer.write(optional.isPresent() ? optional.get() : null);
        } else if (obj instanceof OptionalDouble) {
            OptionalDouble optionalDouble = (OptionalDouble) obj;
            if (optionalDouble.isPresent()) {
                jSONSerializer.write((Object) Double.valueOf(optionalDouble.getAsDouble()));
            } else {
                jSONSerializer.writeNull();
            }
        } else if (obj instanceof OptionalInt) {
            OptionalInt optionalInt = (OptionalInt) obj;
            if (optionalInt.isPresent()) {
                jSONSerializer.out.writeInt(optionalInt.getAsInt());
            } else {
                jSONSerializer.writeNull();
            }
        } else if (obj instanceof OptionalLong) {
            OptionalLong optionalLong = (OptionalLong) obj;
            if (optionalLong.isPresent()) {
                jSONSerializer.out.writeLong(optionalLong.getAsLong());
            } else {
                jSONSerializer.writeNull();
            }
        } else {
            throw new JSONException("not support optional : " + obj.getClass());
        }
    }
}
