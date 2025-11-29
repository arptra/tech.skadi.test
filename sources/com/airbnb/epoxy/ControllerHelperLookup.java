package com.airbnb.epoxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

class ControllerHelperLookup {

    /* renamed from: a  reason: collision with root package name */
    public static final Map f2276a = new LinkedHashMap();
    public static final NoOpControllerHelper b = new NoOpControllerHelper();

    public static Constructor a(Class cls) {
        Constructor<?> constructor;
        Map map = f2276a;
        Constructor constructor2 = (Constructor) map.get(cls);
        if (constructor2 != null || map.containsKey(cls)) {
            return constructor2;
        }
        String name = cls.getName();
        if (name.startsWith("android.") || name.startsWith("java.")) {
            return null;
        }
        try {
            constructor = Class.forName(name + "_EpoxyHelper").getConstructor(new Class[]{cls});
        } catch (ClassNotFoundException unused) {
            constructor = a(cls.getSuperclass());
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Unable to find Epoxy Helper constructor for " + name, e);
        }
        f2276a.put(cls, constructor);
        return constructor;
    }

    public static ControllerHelper b(EpoxyController epoxyController) {
        Constructor a2 = a(epoxyController.getClass());
        if (a2 == null) {
            return b;
        }
        try {
            return (ControllerHelper) a2.newInstance(new Object[]{epoxyController});
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Unable to invoke " + a2, e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("Unable to invoke " + a2, e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unable to get Epoxy helper class.", cause);
            }
        }
    }
}
