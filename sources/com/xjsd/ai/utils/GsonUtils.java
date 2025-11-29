package com.xjsd.ai.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtils {
    public static Object a(String str, Class cls) {
        return b().fromJson(str, cls);
    }

    public static Gson b() {
        return new GsonBuilder().enableComplexMapKeySerialization().setPrettyPrinting().create();
    }

    public static String c(Object obj) {
        return b().toJson(obj);
    }
}
