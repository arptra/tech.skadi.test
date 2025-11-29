package org.apache.tika.config;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.tika.exception.TikaConfigException;

public class ParamField {
    public static final Map f = new HashMap<Class<?>, Class<?>>() {
        {
            put(Integer.TYPE, Integer.class);
            put(Short.TYPE, Short.class);
            put(Boolean.TYPE, Boolean.class);
            put(Long.TYPE, Long.class);
            put(Float.TYPE, Float.class);
            put(Double.TYPE, Double.class);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f4135a;
    public final Class b;
    public final boolean c;
    public Field d;
    public Method e;

    public ParamField(AccessibleObject accessibleObject) {
        if (accessibleObject instanceof Field) {
            this.d = (Field) accessibleObject;
        } else {
            this.e = (Method) accessibleObject;
        }
        Field field = (Field) accessibleObject.getAnnotation(Field.class);
        this.c = field.required();
        this.f4135a = e(field);
        this.b = f();
    }

    public void a(Object obj, Object obj2) {
        Field field = this.d;
        if (field != null) {
            field.set(obj, obj2);
        } else {
            this.e.invoke(obj, new Object[]{obj2});
        }
    }

    public String b() {
        return this.f4135a;
    }

    public Class c() {
        return this.b;
    }

    public boolean d() {
        return this.c;
    }

    public final String e(Field field) {
        if (!field.name().equals("#default")) {
            return field.name();
        }
        Field field2 = this.d;
        if (field2 != null) {
            return field2.getName();
        }
        String name = this.e.getName();
        if (!name.startsWith("set") || name.length() <= 3) {
            return this.e.getName();
        }
        return name.substring(3, 4).toLowerCase(Locale.ROOT) + name.substring(4);
    }

    public final Class f() {
        Class<?> cls;
        Field field = this.d;
        if (field != null) {
            cls = field.getType();
        } else {
            Class<?>[] parameterTypes = this.e.getParameterTypes();
            if (parameterTypes.length != 1) {
                String str = "Invalid setter method. Must have one and only one parameter. ";
                if (this.e.getName().startsWith("get")) {
                    str = str + "Perhaps the annotation is misplaced on " + this.e.getName() + " while a set'X' is expected?";
                }
                throw new TikaConfigException(str);
            }
            cls = parameterTypes[0];
        }
        if (!cls.isPrimitive()) {
            return cls;
        }
        Map map = f;
        return map.containsKey(cls) ? (Class) map.get(cls) : cls;
    }

    public String toString() {
        return "ParamField{name='" + this.f4135a + '\'' + ", type=" + this.b + ", required=" + this.c + '}';
    }
}
