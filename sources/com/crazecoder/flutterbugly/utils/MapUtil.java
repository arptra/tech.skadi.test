package com.crazecoder.flutterbugly.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class MapUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final Set f2806a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Class[]{Object.class, String.class, Boolean.class, Character.class, Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class})));

    public static Map a(Object obj) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            c(obj, linkedHashMap, (String) null);
            return linkedHashMap;
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static boolean b(Object obj) {
        return obj == null || (obj instanceof Enum) || f2806a.contains(obj.getClass());
    }

    public static void c(Object obj, Map map, String str) {
        String str2;
        if (obj != null) {
            for (Field field : obj.getClass().getDeclaredFields()) {
                if (!field.isSynthetic() && !Modifier.isStatic(field.getModifiers())) {
                    field.setAccessible(true);
                    Object obj2 = field.get(obj);
                    if (str == null) {
                        str2 = field.getName();
                    } else {
                        str2 = str + "." + field.getName();
                    }
                    if (b(obj2)) {
                        map.put(str2, obj2);
                    } else {
                        c(obj2, map, str2);
                    }
                }
            }
        }
    }
}
