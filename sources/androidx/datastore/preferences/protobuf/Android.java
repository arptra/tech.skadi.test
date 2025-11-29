package androidx.datastore.preferences.protobuf;

final class Android {

    /* renamed from: a  reason: collision with root package name */
    public static final Class f1048a = a("libcore.io.Memory");
    public static final boolean b = (a("org.robolectric.Robolectric") != null);

    public static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Class b() {
        return f1048a;
    }

    public static boolean c() {
        return f1048a != null && !b;
    }
}
