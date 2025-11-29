package org.apache.tika.utils;

import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

public class CharsetUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f3337a = Pattern.compile("[ \\\"]*([^ >,;\\\"]+).*");
    public static final Pattern b = Pattern.compile(".*8859-(\\d+)");
    public static final Pattern c = Pattern.compile("cp-(\\d+)");
    public static final Pattern d = Pattern.compile("win-?(\\d+)");
    public static final Map e;
    public static Method f;
    public static Method g;

    static {
        Class<String> cls = String.class;
        HashMap hashMap = new HashMap();
        e = hashMap;
        Class<?> cls2 = null;
        f = null;
        g = null;
        c("Big5", "EUC-JP", "EUC-KR", "x-EUC-TW", "GB18030", "IBM855", "IBM866", "ISO-2022-CN", "ISO-2022-JP", "ISO-2022-KR", "ISO-8859-1", "ISO-8859-2", "ISO-8859-3", "ISO-8859-4", "ISO-8859-5", "ISO-8859-6", "ISO-8859-7", "ISO-8859-8", "ISO-8859-9", "ISO-8859-11", "ISO-8859-13", "ISO-8859-15", "KOI8-R", "x-MacCyrillic", "SHIFT_JIS", "UTF-8", "UTF-16BE", "UTF-16LE", "windows-1251", "windows-1252", "windows-1253", "windows-1255");
        hashMap.put("iso-8851-1", (Charset) hashMap.get("iso-8859-1"));
        hashMap.put("windows", (Charset) hashMap.get("windows-1252"));
        hashMap.put("koi8r", (Charset) hashMap.get("koi8-r"));
        try {
            cls2 = CharsetUtils.class.getClassLoader().loadClass("com.ibm.icu.charset.CharsetICU");
        } catch (ClassNotFoundException unused) {
        }
        if (cls2 != null) {
            try {
                f = cls2.getMethod("forNameICU", new Class[]{cls});
                try {
                    g = cls2.getMethod("isSupported", new Class[]{cls});
                } catch (Throwable unused2) {
                }
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }
    }

    public static String a(String str) {
        try {
            return b(str).name();
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.nio.charset.Charset} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: java.nio.charset.Charset} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: java.nio.charset.Charset} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.nio.charset.Charset b(java.lang.String r7) {
        /*
            if (r7 == 0) goto L_0x00d4
            java.util.regex.Pattern r0 = f3337a
            java.util.regex.Matcher r0 = r0.matcher(r7)
            boolean r1 = r0.matches()
            if (r1 == 0) goto L_0x00ce
            r7 = 1
            java.lang.String r0 = r0.group(r7)
            java.util.Locale r1 = java.util.Locale.ENGLISH
            java.lang.String r1 = r0.toLowerCase(r1)
            java.util.Map r2 = e
            java.lang.Object r3 = r2.get(r1)
            java.nio.charset.Charset r3 = (java.nio.charset.Charset) r3
            if (r3 == 0) goto L_0x0024
            return r3
        L_0x0024:
            java.lang.String r4 = "none"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x00c8
            java.lang.String r4 = "no"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x00c8
            java.util.regex.Pattern r4 = b
            java.util.regex.Matcher r4 = r4.matcher(r1)
            java.util.regex.Pattern r5 = c
            java.util.regex.Matcher r5 = r5.matcher(r1)
            java.util.regex.Pattern r6 = d
            java.util.regex.Matcher r1 = r6.matcher(r1)
            boolean r6 = r4.matches()
            if (r6 == 0) goto L_0x0069
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "iso-8859-"
            r0.append(r1)
            java.lang.String r7 = r4.group(r7)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            java.lang.Object r7 = r2.get(r0)
            r3 = r7
            java.nio.charset.Charset r3 = (java.nio.charset.Charset) r3
            goto L_0x00ae
        L_0x0069:
            boolean r4 = r5.matches()
            if (r4 == 0) goto L_0x008c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "cp"
            r0.append(r1)
            java.lang.String r7 = r5.group(r7)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            java.lang.Object r7 = r2.get(r0)
            r3 = r7
            java.nio.charset.Charset r3 = (java.nio.charset.Charset) r3
            goto L_0x00ae
        L_0x008c:
            boolean r4 = r1.matches()
            if (r4 == 0) goto L_0x00ae
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "windows-"
            r0.append(r3)
            java.lang.String r7 = r1.group(r7)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            java.lang.Object r7 = r2.get(r0)
            r3 = r7
            java.nio.charset.Charset r3 = (java.nio.charset.Charset) r3
        L_0x00ae:
            if (r3 == 0) goto L_0x00b1
            return r3
        L_0x00b1:
            java.lang.reflect.Method r7 = f
            if (r7 == 0) goto L_0x00c3
            java.lang.Object[] r1 = new java.lang.Object[]{r0}     // Catch:{ IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x00c3 }
            r2 = 0
            java.lang.Object r7 = r7.invoke(r2, r1)     // Catch:{ IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x00c3 }
            java.nio.charset.Charset r7 = (java.nio.charset.Charset) r7     // Catch:{ IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x00c3 }
            if (r7 == 0) goto L_0x00c3
            return r7
        L_0x00c3:
            java.nio.charset.Charset r7 = java.nio.charset.Charset.forName(r0)
            return r7
        L_0x00c8:
            java.nio.charset.IllegalCharsetNameException r7 = new java.nio.charset.IllegalCharsetNameException
            r7.<init>(r0)
            throw r7
        L_0x00ce:
            java.nio.charset.IllegalCharsetNameException r0 = new java.nio.charset.IllegalCharsetNameException
            r0.<init>(r7)
            throw r0
        L_0x00d4:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            r7.<init>()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.utils.CharsetUtils.b(java.lang.String):java.nio.charset.Charset");
    }

    public static Map c(String... strArr) {
        HashMap hashMap = new HashMap();
        for (String str : strArr) {
            try {
                Charset forName = Charset.forName(str);
                e.put(str.toLowerCase(Locale.ENGLISH), forName);
                for (String lowerCase : forName.aliases()) {
                    e.put(lowerCase.toLowerCase(Locale.ENGLISH), forName);
                }
            } catch (IllegalArgumentException unused) {
            }
        }
        return hashMap;
    }
}
