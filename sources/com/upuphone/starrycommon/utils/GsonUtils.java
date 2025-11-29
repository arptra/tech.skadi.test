package com.upuphone.starrycommon.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

public final class GsonUtils {

    /* renamed from: a  reason: collision with root package name */
    public static volatile Gson f6495a;

    public static Gson a() {
        if (f6495a == null) {
            synchronized (GsonUtils.class) {
                try {
                    if (f6495a == null) {
                        f6495a = new GsonBuilder().create();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f6495a;
    }

    public static List b(String str, Class cls) {
        return (List) a().fromJson(str, TypeToken.getParameterized(ArrayList.class, cls).getType());
    }

    public static String c(Object obj) {
        return a().toJson(obj);
    }
}
