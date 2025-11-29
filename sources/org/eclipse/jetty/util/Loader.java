package org.eclipse.jetty.util;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import org.eclipse.jetty.util.resource.Resource;

public class Loader {
    public static String getClassPath(ClassLoader classLoader) throws Exception {
        StringBuilder sb = new StringBuilder();
        while (classLoader != null && (classLoader instanceof URLClassLoader)) {
            URL[] uRLs = ((URLClassLoader) classLoader).getURLs();
            if (uRLs != null) {
                for (URL newResource : uRLs) {
                    File file = Resource.newResource(newResource).getFile();
                    if (file != null && file.exists()) {
                        if (sb.length() > 0) {
                            sb.append(File.pathSeparatorChar);
                        }
                        sb.append(file.getAbsolutePath());
                    }
                }
            }
            classLoader = classLoader.getParent();
        }
        return sb.toString();
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0036 A[ADDED_TO_REGION, EDGE_INSN: B:24:0x0036->B:17:0x0036 ?: BREAK  , SYNTHETIC] */
    public static java.net.URL getResource(java.lang.Class<?> r3, java.lang.String r4, boolean r5) {
        /*
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            java.lang.ClassLoader r0 = r0.getContextClassLoader()
            r1 = 0
            r2 = r1
        L_0x000a:
            if (r2 != 0) goto L_0x001d
            if (r0 == 0) goto L_0x001d
            java.net.URL r2 = r0.getResource(r4)
            if (r2 != 0) goto L_0x001b
            if (r5 == 0) goto L_0x001b
            java.lang.ClassLoader r0 = r0.getParent()
            goto L_0x000a
        L_0x001b:
            r0 = r1
            goto L_0x000a
        L_0x001d:
            if (r3 != 0) goto L_0x0021
        L_0x001f:
            r3 = r1
            goto L_0x0025
        L_0x0021:
            java.lang.ClassLoader r3 = r3.getClassLoader()
        L_0x0025:
            if (r2 != 0) goto L_0x0036
            if (r3 == 0) goto L_0x0036
            java.net.URL r2 = r3.getResource(r4)
            if (r2 != 0) goto L_0x001f
            if (r5 == 0) goto L_0x001f
            java.lang.ClassLoader r3 = r3.getParent()
            goto L_0x0025
        L_0x0036:
            if (r2 != 0) goto L_0x003c
            java.net.URL r2 = java.lang.ClassLoader.getSystemResource(r4)
        L_0x003c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.Loader.getResource(java.lang.Class, java.lang.String, boolean):java.net.URL");
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x006e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x006f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ResourceBundle getResourceBundle(java.lang.Class<?> r6, java.lang.String r7, boolean r8, java.util.Locale r9) throws java.util.MissingResourceException {
        /*
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            java.lang.ClassLoader r0 = r0.getContextClassLoader()
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            r2 = 0
            r3 = r2
            r4 = r3
        L_0x0010:
            if (r3 != 0) goto L_0x002e
            if (r0 == 0) goto L_0x002e
            boolean r5 = r1.add(r0)
            if (r5 == 0) goto L_0x002e
            java.util.ResourceBundle r3 = java.util.ResourceBundle.getBundle(r7, r9, r0)     // Catch:{ MissingResourceException -> 0x001f }
            goto L_0x0023
        L_0x001f:
            r5 = move-exception
            if (r4 != 0) goto L_0x0023
            r4 = r5
        L_0x0023:
            if (r3 != 0) goto L_0x002c
            if (r8 == 0) goto L_0x002c
            java.lang.ClassLoader r0 = r0.getParent()
            goto L_0x0010
        L_0x002c:
            r0 = r2
            goto L_0x0010
        L_0x002e:
            if (r6 != 0) goto L_0x0032
        L_0x0030:
            r6 = r2
            goto L_0x0036
        L_0x0032:
            java.lang.ClassLoader r6 = r6.getClassLoader()
        L_0x0036:
            if (r3 != 0) goto L_0x0053
            if (r6 == 0) goto L_0x0053
            boolean r0 = r1.add(r6)
            if (r0 == 0) goto L_0x0053
            java.util.ResourceBundle r0 = java.util.ResourceBundle.getBundle(r7, r9, r6)     // Catch:{ MissingResourceException -> 0x0046 }
            r3 = r0
            goto L_0x004a
        L_0x0046:
            r0 = move-exception
            if (r4 != 0) goto L_0x004a
            r4 = r0
        L_0x004a:
            if (r3 != 0) goto L_0x0030
            if (r8 == 0) goto L_0x0030
            java.lang.ClassLoader r6 = r6.getParent()
            goto L_0x0036
        L_0x0053:
            java.lang.Class<org.eclipse.jetty.util.Loader> r6 = org.eclipse.jetty.util.Loader.class
            java.lang.ClassLoader r6 = r6.getClassLoader()
            if (r3 != 0) goto L_0x006c
            if (r6 == 0) goto L_0x006c
            boolean r6 = r1.add(r6)
            if (r6 == 0) goto L_0x006c
            java.util.ResourceBundle r3 = java.util.ResourceBundle.getBundle(r7, r9)     // Catch:{ MissingResourceException -> 0x0068 }
            goto L_0x006c
        L_0x0068:
            r6 = move-exception
            if (r4 != 0) goto L_0x006c
            r4 = r6
        L_0x006c:
            if (r3 == 0) goto L_0x006f
            return r3
        L_0x006f:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.Loader.getResourceBundle(java.lang.Class, java.lang.String, boolean, java.util.Locale):java.util.ResourceBundle");
    }

    public static Class loadClass(Class cls, String str) throws ClassNotFoundException {
        return loadClass(cls, str, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x006e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x006f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Class loadClass(java.lang.Class r6, java.lang.String r7, boolean r8) throws java.lang.ClassNotFoundException {
        /*
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            java.lang.ClassLoader r0 = r0.getContextClassLoader()
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            r2 = 0
            r3 = r2
            r4 = r3
        L_0x0010:
            if (r3 != 0) goto L_0x002e
            if (r0 == 0) goto L_0x002e
            boolean r5 = r1.add(r0)
            if (r5 == 0) goto L_0x002e
            java.lang.Class r3 = r0.loadClass(r7)     // Catch:{ ClassNotFoundException -> 0x001f }
            goto L_0x0023
        L_0x001f:
            r5 = move-exception
            if (r4 != 0) goto L_0x0023
            r4 = r5
        L_0x0023:
            if (r3 != 0) goto L_0x002c
            if (r8 == 0) goto L_0x002c
            java.lang.ClassLoader r0 = r0.getParent()
            goto L_0x0010
        L_0x002c:
            r0 = r2
            goto L_0x0010
        L_0x002e:
            if (r6 != 0) goto L_0x0032
        L_0x0030:
            r6 = r2
            goto L_0x0036
        L_0x0032:
            java.lang.ClassLoader r6 = r6.getClassLoader()
        L_0x0036:
            if (r3 != 0) goto L_0x0053
            if (r6 == 0) goto L_0x0053
            boolean r0 = r1.add(r6)
            if (r0 == 0) goto L_0x0053
            java.lang.Class r0 = r6.loadClass(r7)     // Catch:{ ClassNotFoundException -> 0x0046 }
            r3 = r0
            goto L_0x004a
        L_0x0046:
            r0 = move-exception
            if (r4 != 0) goto L_0x004a
            r4 = r0
        L_0x004a:
            if (r3 != 0) goto L_0x0030
            if (r8 == 0) goto L_0x0030
            java.lang.ClassLoader r6 = r6.getParent()
            goto L_0x0036
        L_0x0053:
            java.lang.Class<org.eclipse.jetty.util.Loader> r6 = org.eclipse.jetty.util.Loader.class
            java.lang.ClassLoader r6 = r6.getClassLoader()
            if (r3 != 0) goto L_0x006c
            if (r6 == 0) goto L_0x006c
            boolean r6 = r1.add(r6)
            if (r6 == 0) goto L_0x006c
            java.lang.Class r3 = java.lang.Class.forName(r7)     // Catch:{ ClassNotFoundException -> 0x0068 }
            goto L_0x006c
        L_0x0068:
            r6 = move-exception
            if (r4 != 0) goto L_0x006c
            r4 = r6
        L_0x006c:
            if (r3 == 0) goto L_0x006f
            return r3
        L_0x006f:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.Loader.loadClass(java.lang.Class, java.lang.String, boolean):java.lang.Class");
    }
}
