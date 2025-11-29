package com.honey.account.sc;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;
import rxhttp.wrapper.utils.GsonUtil;

public final /* synthetic */ class d implements JsonDeserializer {
    public final Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        return GsonUtil.l(jsonElement, type, jsonDeserializationContext);
    }
}
