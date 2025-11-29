package com.meizu.flyme.sdk;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

public class ClassInfo {
    final HashMap<String, Field> fields = new HashMap<>();
    final Class<?> mClass;
    final HashMap<String, Method> methods = new HashMap<>();

    public ClassInfo(Class<?> cls, String str) {
        this.mClass = cls;
    }

    public void addCachedField(String str, Field field) {
        this.fields.put(str, field);
    }

    public void addCachedMethod(String str, Method method) {
        this.methods.put(str, method);
    }

    public Field getCachedField(String str) {
        return this.fields.get(str);
    }

    public Method getCachedMethod(String str) {
        return this.methods.get(str);
    }
}
