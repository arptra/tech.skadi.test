package com.honey.account.utils.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReflectUtils {
    private static IReflect sReflect = new CacheReflect();

    public static class CacheReflect implements IReflect {
        private Map<ClassLoader, Map<String, IReflectClass>> mCacheClass;

        public IReflectClass from(Object obj) throws ClassNotFoundException {
            return from(obj.getClass());
        }

        private CacheReflect() {
            this.mCacheClass = new HashMap();
        }

        public IReflectClass from(Class<?> cls) throws ClassNotFoundException {
            return from(cls.getClassLoader(), cls.getName());
        }

        public IReflectClass from(ClassLoader classLoader, String str) throws ClassNotFoundException {
            Map map = this.mCacheClass.get(classLoader);
            if (map == null) {
                map = new HashMap();
                this.mCacheClass.put(classLoader, map);
            }
            IReflectClass iReflectClass = (IReflectClass) map.get(str);
            if (iReflectClass != null) {
                return iReflectClass;
            }
            DefaultReflectClass defaultReflectClass = new DefaultReflectClass(classLoader.loadClass(str));
            map.put(str, defaultReflectClass);
            return defaultReflectClass;
        }

        public IReflectClass from(String str) throws ClassNotFoundException {
            return from(getClass().getClassLoader(), str);
        }
    }

    public static class DefaultReflectClass implements IReflectClass {
        private Class<?> mClass;
        private Map<String, IReflectConstructor> mConstructors = new HashMap();
        private Map<String, IReflectField> mFields = new HashMap();
        private Map<String, IReflectMethod> mMethods = new HashMap();

        public DefaultReflectClass(Class<?> cls) {
            this.mClass = cls;
        }

        public Class<?> clazz() {
            return this.mClass;
        }

        public IReflectConstructor constructor(Class... clsArr) throws NoSuchMethodException {
            StringBuilder sb = new StringBuilder();
            if (clsArr != null && clsArr.length > 0) {
                for (Class name : clsArr) {
                    sb.append(name.getName());
                }
            }
            String sb2 = sb.toString();
            IReflectConstructor iReflectConstructor = this.mConstructors.get(sb2);
            if (iReflectConstructor != null) {
                return iReflectConstructor;
            }
            DefaultReflectConstructor defaultReflectConstructor = new DefaultReflectConstructor(this.mClass.getConstructor(clsArr));
            this.mConstructors.put(sb2, defaultReflectConstructor);
            return defaultReflectConstructor;
        }

        public IReflectField field(String str) throws NoSuchFieldException {
            Field field;
            IReflectField iReflectField = this.mFields.get(str);
            if (iReflectField != null) {
                return iReflectField;
            }
            Class cls = this.mClass;
            while (true) {
                if (cls == null) {
                    field = null;
                    break;
                }
                try {
                    field = cls.getDeclaredField(str);
                    break;
                } catch (Exception unused) {
                    cls = cls.getSuperclass();
                }
            }
            if (field != null) {
                DefaultReflectField defaultReflectField = new DefaultReflectField(field);
                this.mFields.put(str, defaultReflectField);
                return defaultReflectField;
            }
            throw new NoSuchFieldException(str);
        }

        public IReflectMethod method(String str, Class... clsArr) throws NoSuchMethodException {
            Method method;
            StringBuilder sb = new StringBuilder(str);
            if (clsArr != null && clsArr.length > 0) {
                for (Class name : clsArr) {
                    sb.append(name.getName());
                }
            }
            String sb2 = sb.toString();
            IReflectMethod iReflectMethod = this.mMethods.get(sb2);
            if (iReflectMethod != null) {
                return iReflectMethod;
            }
            Class cls = this.mClass;
            while (true) {
                if (cls == null) {
                    method = null;
                    break;
                }
                try {
                    method = cls.getDeclaredMethod(str, clsArr);
                    break;
                } catch (Exception unused) {
                    cls = cls.getSuperclass();
                }
            }
            if (method != null) {
                DefaultReflectMethod defaultReflectMethod = new DefaultReflectMethod(method);
                this.mMethods.put(sb2, defaultReflectMethod);
                return defaultReflectMethod;
            }
            throw new NoSuchMethodException(str + " " + Arrays.toString(clsArr));
        }
    }

    public static class DefaultReflectConstructor implements IReflectConstructor {
        private Constructor<?> mConstructor;

        public DefaultReflectConstructor(Constructor<?> constructor) {
            this.mConstructor = constructor;
            constructor.setAccessible(true);
        }

        public Constructor constructor() {
            return this.mConstructor;
        }

        public Object newInstance(Object... objArr) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException {
            return this.mConstructor.newInstance(objArr);
        }
    }

    public static class DefaultReflectField implements IReflectField {
        private Field mField;

        public DefaultReflectField(Field field) {
            this.mField = field;
            field.setAccessible(true);
        }

        public Field field() {
            return this.mField;
        }

        public Object get(Object obj) throws IllegalAccessException, IllegalArgumentException {
            return this.mField.get(obj);
        }

        public boolean getBoolean(Object obj) throws IllegalAccessException, IllegalArgumentException {
            return this.mField.getBoolean(obj);
        }

        public byte getByte(Object obj) throws IllegalAccessException, IllegalArgumentException {
            return this.mField.getByte(obj);
        }

        public char getChar(Object obj) throws IllegalAccessException, IllegalArgumentException {
            return this.mField.getChar(obj);
        }

        public double getDouble(Object obj) throws IllegalAccessException, IllegalArgumentException {
            return this.mField.getDouble(obj);
        }

        public float getFloat(Object obj) throws IllegalAccessException, IllegalArgumentException {
            return this.mField.getFloat(obj);
        }

        public int getInt(Object obj) throws IllegalAccessException, IllegalArgumentException {
            return this.mField.getInt(obj);
        }

        public long getLong(Object obj) throws IllegalAccessException, IllegalArgumentException {
            return this.mField.getLong(obj);
        }

        public short getShort(Object obj) throws IllegalAccessException, IllegalArgumentException {
            return this.mField.getShort(obj);
        }

        public void set(Object obj, Object obj2) throws IllegalAccessException, IllegalArgumentException {
            this.mField.set(obj, obj2);
        }

        public void setBoolean(Object obj, boolean z) throws IllegalAccessException, IllegalArgumentException {
            this.mField.setBoolean(obj, z);
        }

        public void setByte(Object obj, byte b) throws IllegalAccessException, IllegalArgumentException {
            this.mField.setByte(obj, b);
        }

        public void setChar(Object obj, char c) throws IllegalAccessException, IllegalArgumentException {
            this.mField.setChar(obj, c);
        }

        public void setDouble(Object obj, double d) throws IllegalAccessException, IllegalArgumentException {
            this.mField.setDouble(obj, d);
        }

        public void setFloat(Object obj, float f) throws IllegalAccessException, IllegalArgumentException {
            this.mField.setFloat(obj, f);
        }

        public void setInt(Object obj, int i) throws IllegalAccessException, IllegalArgumentException {
            this.mField.setInt(obj, i);
        }

        public void setLong(Object obj, long j) throws IllegalAccessException, IllegalArgumentException {
            this.mField.setLong(obj, j);
        }

        public void setShort(Object obj, short s) throws IllegalAccessException, IllegalArgumentException {
            this.mField.setShort(obj, s);
        }
    }

    public static class DefaultReflectMethod implements IReflectMethod {
        private Method mMethod;

        public DefaultReflectMethod(Method method) {
            this.mMethod = method;
            method.setAccessible(true);
        }

        public Object invoke(Object obj, Object... objArr) throws InvocationTargetException, IllegalArgumentException, IllegalAccessException {
            return this.mMethod.invoke(obj, objArr);
        }

        public Method method() {
            return this.mMethod;
        }
    }

    public interface IReflect {
        IReflectClass from(Class<?> cls) throws ClassNotFoundException;

        IReflectClass from(ClassLoader classLoader, String str) throws ClassNotFoundException;

        IReflectClass from(Object obj) throws ClassNotFoundException;

        IReflectClass from(String str) throws ClassNotFoundException;
    }

    public interface IReflectClass {
        Class<?> clazz();

        IReflectConstructor constructor(Class... clsArr) throws NoSuchMethodException;

        IReflectField field(String str) throws NoSuchFieldException;

        IReflectMethod method(String str, Class... clsArr) throws NoSuchMethodException;
    }

    public interface IReflectConstructor {
        Constructor constructor();

        Object newInstance(Object... objArr) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException;
    }

    public interface IReflectField {
        Field field();

        Object get(Object obj) throws IllegalAccessException, IllegalArgumentException;

        boolean getBoolean(Object obj) throws IllegalAccessException, IllegalArgumentException;

        byte getByte(Object obj) throws IllegalAccessException, IllegalArgumentException;

        char getChar(Object obj) throws IllegalAccessException, IllegalArgumentException;

        double getDouble(Object obj) throws IllegalAccessException, IllegalArgumentException;

        float getFloat(Object obj) throws IllegalAccessException, IllegalArgumentException;

        int getInt(Object obj) throws IllegalAccessException, IllegalArgumentException;

        long getLong(Object obj) throws IllegalAccessException, IllegalArgumentException;

        short getShort(Object obj) throws IllegalAccessException, IllegalArgumentException;

        void set(Object obj, Object obj2) throws IllegalAccessException, IllegalArgumentException;

        void setBoolean(Object obj, boolean z) throws IllegalAccessException, IllegalArgumentException;

        void setByte(Object obj, byte b) throws IllegalAccessException, IllegalArgumentException;

        void setChar(Object obj, char c) throws IllegalAccessException, IllegalArgumentException;

        void setDouble(Object obj, double d) throws IllegalAccessException, IllegalArgumentException;

        void setFloat(Object obj, float f) throws IllegalAccessException, IllegalArgumentException;

        void setInt(Object obj, int i) throws IllegalAccessException, IllegalArgumentException;

        void setLong(Object obj, long j) throws IllegalAccessException, IllegalArgumentException;

        void setShort(Object obj, short s) throws IllegalAccessException, IllegalArgumentException;
    }

    public interface IReflectMethod {
        Object invoke(Object obj, Object... objArr) throws InvocationTargetException, IllegalArgumentException, IllegalAccessException;

        Method method();
    }

    public static IReflectClass from(Object obj) throws ClassNotFoundException {
        return sReflect.from(obj);
    }

    public static IReflectClass from(Class<?> cls) throws ClassNotFoundException {
        return sReflect.from(cls);
    }

    public static IReflectClass from(ClassLoader classLoader, String str) throws ClassNotFoundException {
        return sReflect.from(classLoader, str);
    }

    public static IReflectClass from(String str) throws ClassNotFoundException {
        return sReflect.from(str);
    }
}
