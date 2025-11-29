package com.upuphone.datatrack.base.utils.gson;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.util.Map;

public final class JsonUtil {
    public static Object a(String str, Class cls) {
        return new GsonBuilder().registerTypeAdapter(String.class, new StringTypeAdapter()).create().fromJson(str, cls);
    }

    public static String b(Map map) {
        return new GsonBuilder().registerTypeAdapter(String.class, new StringTypeAdapter()).create().toJson((Object) map, new TypeToken<Map<String, String>>() {
        }.getType());
    }
}
