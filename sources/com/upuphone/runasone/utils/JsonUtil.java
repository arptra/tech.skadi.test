package com.upuphone.runasone.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonUtil {
    public static <T> T json2object(String str, TypeToken<T> typeToken) {
        try {
            return new Gson().fromJson(str, typeToken.getType());
        } catch (Exception unused) {
            return null;
        }
    }

    public static String object2json(Object obj) {
        return new Gson().toJson(obj);
    }
}
