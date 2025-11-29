package com.upuphone.ar.navi.lite.util;

import com.google.gson.Gson;

public final class JsonUtil {
    public static String a(Object obj) {
        return new Gson().toJson(obj);
    }

    public static Object b(String str, Class cls) {
        return new Gson().fromJson(str, cls);
    }
}
