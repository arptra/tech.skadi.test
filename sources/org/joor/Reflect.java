package org.joor;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

public class Reflect {
    public static final Constructor c;

    /* renamed from: a  reason: collision with root package name */
    public final Class f3410a;
    public final Object b;

    /* renamed from: org.joor.Reflect$1  reason: invalid class name */
    class AnonymousClass1 implements InvocationHandler {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f3411a;
        public final /* synthetic */ Class b;
        public final /* synthetic */ Reflect c;

        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            try {
                return Reflect.o(this.c.f3410a, this.c.b).g(name, objArr).k();
            } catch (ReflectException e) {
                if (this.f3411a) {
                    Map map = (Map) this.c.b;
                    int length = objArr == null ? 0 : objArr.length;
                    if (length == 0 && name.startsWith("get")) {
                        return map.get(Reflect.s(name.substring(3)));
                    }
                    if (length == 0 && name.startsWith("is")) {
                        return map.get(Reflect.s(name.substring(2)));
                    }
                    if (length == 1 && name.startsWith("set")) {
                        map.put(Reflect.s(name.substring(3)), objArr[0]);
                        return null;
                    }
                }
                if (method.isDefault()) {
                    Constructor constructor = Reflect.c;
                    return (constructor == null ? (MethodHandles.Lookup) Reflect.r(MethodHandles.class).g("privateLookupIn", this.b, MethodHandles.lookup()).g("in", this.b).k() : (MethodHandles.Lookup) constructor.newInstance(new Object[]{this.b})).unreflectSpecial(method, this.b).bindTo(obj).invokeWithArguments(objArr);
                }
                throw e;
            }
        }
    }

    public static class NULL {
    }

    static {
        Constructor<MethodHandles.Lookup> constructor = null;
        try {
            Optional.class.getMethod("stream", (Class[]) null);
        } catch (NoSuchMethodException unused) {
            Constructor<MethodHandles.Lookup> declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(new Class[]{Class.class});
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            constructor = declaredConstructor;
        } catch (Throwable unused2) {
        }
        c = constructor;
    }

    public Reflect(Class cls) {
        this(cls, cls);
    }

    public static AccessibleObject e(AccessibleObject accessibleObject) {
        if (accessibleObject == null) {
            return null;
        }
        if (accessibleObject instanceof Member) {
            Member member = (Member) accessibleObject;
            if (Modifier.isPublic(member.getModifiers()) && Modifier.isPublic(member.getDeclaringClass().getModifiers())) {
                return accessibleObject;
            }
        }
        if (!accessibleObject.isAccessible()) {
            accessibleObject.setAccessible(true);
        }
        return accessibleObject;
    }

    public static Reflect o(Class cls, Object obj) {
        return new Reflect(cls, obj);
    }

    public static Reflect p(Object obj) {
        return new Reflect(obj == null ? Object.class : obj.getClass(), obj);
    }

    public static Reflect q(Method method, Object obj, Object... objArr) {
        try {
            e(method);
            if (method.getReturnType() != Void.TYPE) {
                return p(method.invoke(obj, objArr));
            }
            method.invoke(obj, objArr);
            return p(obj);
        } catch (Exception e) {
            throw new ReflectException((Throwable) e);
        }
    }

    public static Reflect r(Class cls) {
        return new Reflect(cls);
    }

    public static String s(String str) {
        int length = str.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            return str.toLowerCase();
        }
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }

    public static Class[] v(Object... objArr) {
        if (objArr == null) {
            return new Class[0];
        }
        Class[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            clsArr[i] = obj == null ? NULL.class : obj.getClass();
        }
        return clsArr;
    }

    public static Class w(Class cls) {
        if (cls == null) {
            return null;
        }
        return cls.isPrimitive() ? Boolean.TYPE == cls ? Boolean.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : Byte.TYPE == cls ? Byte.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Character.TYPE == cls ? Character.class : Void.TYPE == cls ? Void.class : cls : cls;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Reflect) {
            return this.b.equals(((Reflect) obj).k());
        }
        return false;
    }

    public Reflect f(String str) {
        return g(str, new Object[0]);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:4|5|6) */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0019, code lost:
        return q(t(r4, r0), r3.b, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001a, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0020, code lost:
        throw new org.joor.ReflectException((java.lang.Throwable) r3);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x000f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.joor.Reflect g(java.lang.String r4, java.lang.Object... r5) {
        /*
            r3 = this;
            java.lang.Class[] r0 = v(r5)
            java.lang.reflect.Method r1 = r3.h(r4, r0)     // Catch:{ NoSuchMethodException -> 0x000f }
            java.lang.Object r2 = r3.b     // Catch:{ NoSuchMethodException -> 0x000f }
            org.joor.Reflect r3 = q(r1, r2, r5)     // Catch:{ NoSuchMethodException -> 0x000f }
            return r3
        L_0x000f:
            java.lang.reflect.Method r4 = r3.t(r4, r0)     // Catch:{ NoSuchMethodException -> 0x001a }
            java.lang.Object r3 = r3.b     // Catch:{ NoSuchMethodException -> 0x001a }
            org.joor.Reflect r3 = q(r4, r3, r5)     // Catch:{ NoSuchMethodException -> 0x001a }
            return r3
        L_0x001a:
            r3 = move-exception
            org.joor.ReflectException r4 = new org.joor.ReflectException
            r4.<init>((java.lang.Throwable) r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joor.Reflect.g(java.lang.String, java.lang.Object[]):org.joor.Reflect");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:4|5|6) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001a, code lost:
        throw new java.lang.NoSuchMethodException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000d, code lost:
        return r0.getDeclaredMethod(r1, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000e, code lost:
        r0 = r0.getSuperclass();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        if (r0 != null) goto L_0x0009;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0009 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.reflect.Method h(java.lang.String r1, java.lang.Class[] r2) {
        /*
            r0 = this;
            java.lang.Class r0 = r0.u()
            java.lang.reflect.Method r0 = r0.getMethod(r1, r2)     // Catch:{ NoSuchMethodException -> 0x0009 }
            return r0
        L_0x0009:
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r1, r2)     // Catch:{ NoSuchMethodException -> 0x000e }
            return r0
        L_0x000e:
            java.lang.Class r0 = r0.getSuperclass()
            if (r0 == 0) goto L_0x0015
            goto L_0x0009
        L_0x0015:
            java.lang.NoSuchMethodException r0 = new java.lang.NoSuchMethodException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joor.Reflect.h(java.lang.String, java.lang.Class[]):java.lang.reflect.Method");
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public Reflect i(String str) {
        try {
            Field j = j(str);
            return o(j.getType(), j.get(this.b));
        } catch (Exception e) {
            throw new ReflectException((Throwable) e);
        }
    }

    public final Field j(String str) {
        Class u = u();
        try {
            return (Field) e(u.getField(str));
        } catch (NoSuchFieldException e) {
            do {
                try {
                    return (Field) e(u.getDeclaredField(str));
                } catch (NoSuchFieldException unused) {
                    u = u.getSuperclass();
                    if (u != null) {
                        throw new ReflectException((Throwable) e);
                    }
                }
            } while (u != null);
            throw new ReflectException((Throwable) e);
        }
    }

    public Object k() {
        return this.b;
    }

    public Object l(String str) {
        return i(str).k();
    }

    public final boolean m(Method method, String str, Class[] clsArr) {
        return method.getName().equals(str) && n(method.getParameterTypes(), clsArr);
    }

    public final boolean n(Class[] clsArr, Class[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i = 0; i < clsArr2.length; i++) {
            if (clsArr2[i] != NULL.class && !w(clsArr[i]).isAssignableFrom(w(clsArr2[i]))) {
                return false;
            }
        }
        return true;
    }

    public final Method t(String str, Class[] clsArr) {
        Class u = u();
        for (Method method : u.getMethods()) {
            if (m(method, str, clsArr)) {
                return method;
            }
        }
        do {
            for (Method method2 : u.getDeclaredMethods()) {
                if (m(method2, str, clsArr)) {
                    return method2;
                }
            }
            u = u.getSuperclass();
        } while (u != null);
        throw new NoSuchMethodException("No similar method " + str + " with params " + Arrays.toString(clsArr) + " could be found on type " + u() + ".");
    }

    public String toString() {
        return String.valueOf(this.b);
    }

    public Class u() {
        return this.f3410a;
    }

    public Reflect(Class cls, Object obj) {
        this.f3410a = cls;
        this.b = obj;
    }
}
