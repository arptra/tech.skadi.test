package com.meizu.flyme.sdk;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

public class ReflectionCache {
    public static HashMap<String, ClassInfo> classInfoMap;
    public static HashMap<String, Field> noCacheClassFieldMap;
    public static HashMap<String, Method> noCacheClassMethodMap;
    private final String TAG;

    public static class SingletonHolder {
        /* access modifiers changed from: private */
        public static final ReflectionCache INSTANCE = new ReflectionCache();

        private SingletonHolder() {
        }
    }

    public static ReflectionCache build() {
        return SingletonHolder.INSTANCE;
    }

    private ClassInfo getClassInfoFromCache(String str) {
        return classInfoMap.get(str);
    }

    private void putClassInfoToCache(String str, ClassInfo classInfo) {
        classInfoMap.put(str, classInfo);
    }

    public Class<?> forName(String str) throws ClassNotFoundException {
        return forName(str, Boolean.TRUE);
    }

    public synchronized Field getDeclaredField(Class<?> cls, String str) throws NoSuchFieldException {
        ClassInfo classInfoFromCache = getClassInfoFromCache(cls.getName());
        if (classInfoFromCache != null) {
            Field cachedField = classInfoFromCache.getCachedField(str);
            if (cachedField != null) {
                return cachedField;
            }
            Field declaredField = cls.getDeclaredField(str);
            classInfoFromCache.addCachedField(str, declaredField);
            return declaredField;
        }
        Field field = noCacheClassFieldMap.get(str);
        if (field != null) {
            return field;
        }
        Field declaredField2 = cls.getDeclaredField(str);
        noCacheClassFieldMap.put(str, declaredField2);
        return declaredField2;
    }

    public synchronized Field getField(Class<?> cls, String str) throws NoSuchFieldException {
        ClassInfo classInfoFromCache = getClassInfoFromCache(cls.getName());
        if (classInfoFromCache != null) {
            Field cachedField = classInfoFromCache.getCachedField(str);
            if (cachedField != null) {
                return cachedField;
            }
            Field field = cls.getField(str);
            classInfoFromCache.addCachedField(str, field);
            return field;
        }
        Field field2 = noCacheClassFieldMap.get(str);
        if (field2 != null) {
            return field2;
        }
        Field field3 = cls.getField(str);
        noCacheClassFieldMap.put(str, field3);
        return field3;
    }

    public synchronized Method getMethod(Class<?> cls, String str, Class... clsArr) throws NoSuchMethodException {
        try {
            ClassInfo classInfoFromCache = getClassInfoFromCache(cls.getName());
            boolean z = classInfoFromCache != null;
            String str2 = str;
            for (Class cls2 : clsArr) {
                str2 = str2 + cls2.toString();
            }
            if (z) {
                Method cachedMethod = classInfoFromCache.getCachedMethod(str2);
                if (cachedMethod != null) {
                    return cachedMethod;
                }
                Method method = cls.getMethod(str, clsArr);
                classInfoFromCache.addCachedMethod(str2, method);
                return method;
            }
            Method method2 = noCacheClassMethodMap.get(str2);
            if (method2 != null) {
                return method2;
            }
            Method method3 = cls.getMethod(str, clsArr);
            noCacheClassMethodMap.put(str2, method3);
            return method3;
        } catch (Throwable th) {
            throw th;
        }
    }

    private ReflectionCache() {
        this.TAG = "ReflectionCache";
        classInfoMap = new HashMap<>();
        noCacheClassMethodMap = new HashMap<>();
        noCacheClassFieldMap = new HashMap<>();
    }

    public synchronized Class<?> forName(String str, Boolean bool) throws ClassNotFoundException {
        if (bool.booleanValue()) {
            ClassInfo classInfoFromCache = getClassInfoFromCache(str);
            if (classInfoFromCache != null) {
                return classInfoFromCache.mClass;
            }
            Class<?> cls = Class.forName(str);
            putClassInfoToCache(str, new ClassInfo(cls, str));
            return cls;
        }
        return Class.forName(str);
    }
}
