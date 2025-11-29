package io.netty.util.internal;

public final class ClassInitializerUtil {
    private ClassInitializerUtil() {
    }

    private static void tryLoadClass(ClassLoader classLoader, String str) {
        try {
            Class.forName(str, true, classLoader);
        } catch (ClassNotFoundException | SecurityException unused) {
        }
    }

    public static void tryLoadClasses(Class<?> cls, Class<?>... clsArr) {
        ClassLoader classLoader = PlatformDependent.getClassLoader(cls);
        for (Class<?> name : clsArr) {
            tryLoadClass(classLoader, name.getName());
        }
    }
}
