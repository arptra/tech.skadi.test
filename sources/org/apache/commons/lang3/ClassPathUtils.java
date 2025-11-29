package org.apache.commons.lang3;

public class ClassPathUtils {
    public static String toFullyQualifiedName(Class<?> cls, String str) {
        Validate.notNull(cls, "context", new Object[0]);
        Validate.notNull(str, "resourceName", new Object[0]);
        return toFullyQualifiedName(cls.getPackage(), str);
    }

    public static String toFullyQualifiedPath(Class<?> cls, String str) {
        Validate.notNull(cls, "context", new Object[0]);
        Validate.notNull(str, "resourceName", new Object[0]);
        return toFullyQualifiedPath(cls.getPackage(), str);
    }

    public static String toFullyQualifiedName(Package packageR, String str) {
        Validate.notNull(packageR, "context", new Object[0]);
        Validate.notNull(str, "resourceName", new Object[0]);
        return packageR.getName() + "." + str;
    }

    public static String toFullyQualifiedPath(Package packageR, String str) {
        Validate.notNull(packageR, "context", new Object[0]);
        Validate.notNull(str, "resourceName", new Object[0]);
        return packageR.getName().replace('.', '/') + "/" + str;
    }
}
