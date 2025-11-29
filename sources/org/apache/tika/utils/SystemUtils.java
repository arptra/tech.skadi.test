package org.apache.tika.utils;

public class SystemUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3346a = d("os.name");
    public static final String b = d("os.version");
    public static final boolean c;
    public static final boolean d;
    public static final boolean e;
    public static final boolean f;
    public static final boolean g = c("Mac");
    public static final boolean h;
    public static final boolean i = c("OS/2");
    public static final boolean j;
    public static final boolean k;
    public static final boolean l;
    public static final boolean m = c("Windows");
    public static final boolean n = b("WSL");

    static {
        boolean c2 = c("AIX");
        c = c2;
        boolean c3 = c("HP-UX");
        d = c3;
        boolean c4 = c("Irix");
        e = c4;
        boolean z = true;
        boolean z2 = c("Linux") || c("LINUX");
        f = z2;
        boolean c5 = c("Mac OS X");
        h = c5;
        boolean c6 = c("Solaris");
        j = c6;
        boolean c7 = c("SunOS");
        k = c7;
        if (!c2 && !c3 && !c4 && !z2 && !c5 && !c6 && !c7) {
            z = false;
        }
        l = z;
    }

    public static boolean a(String str, String str2) {
        return str != null && str.contains(str2);
    }

    public static boolean b(String str) {
        return a(b, str);
    }

    public static boolean c(String str) {
        return e(f3346a, str);
    }

    public static String d(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }

    public static boolean e(String str, String str2) {
        return str != null && str.startsWith(str2);
    }
}
