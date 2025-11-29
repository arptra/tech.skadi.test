package org.apache.tika.utils;

import com.honey.account.oc.a;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.InvocationTargetException;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.tika.config.Field;
import org.apache.tika.config.Param;
import org.apache.tika.config.ParamField;
import org.apache.tika.config.TikaConfig;
import org.apache.tika.exception.TikaConfigException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AnnotationUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f3336a = LoggerFactory.k(AnnotationUtils.class);
    public static final Map b = new HashMap();

    public static void b(Object obj, Map map) {
        Class<?> cls = obj.getClass();
        Map map2 = b;
        if (!map2.containsKey(cls)) {
            synchronized (TikaConfig.class) {
                try {
                    if (!map2.containsKey(cls)) {
                        List<AccessibleObject> c = c(cls, Field.class);
                        ArrayList arrayList = new ArrayList(c.size());
                        for (AccessibleObject paramField : c) {
                            arrayList.add(new ParamField(paramField));
                        }
                        b.put(cls, arrayList);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        for (ParamField paramField2 : (List) b.get(cls)) {
            Param param = (Param) map.get(paramField2.b());
            if (param != null) {
                if (paramField2.c().isAssignableFrom(param.getType())) {
                    try {
                        paramField2.a(obj, param.getValue());
                    } catch (InvocationTargetException e) {
                        f3336a.error("Error assigning value '{}' to '{}'", param.getValue(), param.getName());
                        Throwable cause = e.getCause();
                        Throwable th2 = e;
                        if (cause != null) {
                            th2 = e.getCause();
                        }
                        throw new TikaConfigException(th2.getMessage(), th2);
                    } catch (IllegalAccessException e2) {
                        f3336a.error("Error assigning value '{}' to '{}'", param.getValue(), param.getName());
                        throw new TikaConfigException(e2.getMessage(), e2);
                    }
                } else {
                    throw new TikaConfigException(String.format(Locale.ROOT, "Value '%s' of type '%s' can't be assigned to field '%s' of defined type '%s'", new Object[]{param.getValue(), param.getValue().getClass(), paramField2.b(), paramField2.c()}));
                }
            } else if (!paramField2.d()) {
                f3336a.debug("Param not supplied, field is not mandatory");
            } else {
                throw new TikaConfigException(String.format(Locale.ROOT, "Param %s is required for %s, but it is not given in config.", new Object[]{paramField2.b(), obj.getClass().getName()}));
            }
        }
    }

    public static List c(Class<? super Object> cls, Class cls2) {
        ArrayList<AccessibleObject> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        while (cls != null && cls != Object.class) {
            arrayList.addAll(Arrays.asList(cls.getDeclaredFields()));
            arrayList.addAll(Arrays.asList(cls.getDeclaredMethods()));
            cls = cls.getSuperclass();
        }
        for (AccessibleObject accessibleObject : arrayList) {
            if (accessibleObject.isAnnotationPresent(cls2)) {
                AccessController.doPrivileged(new a(accessibleObject));
                arrayList2.add(accessibleObject);
            }
        }
        return arrayList2;
    }
}
