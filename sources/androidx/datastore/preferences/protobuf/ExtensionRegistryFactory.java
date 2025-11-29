package androidx.datastore.preferences.protobuf;

final class ExtensionRegistryFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final Class f1076a = c();

    public static ExtensionRegistryLite a() {
        if (f1076a != null) {
            try {
                return b("getEmptyRegistry");
            } catch (Exception unused) {
            }
        }
        return ExtensionRegistryLite.e;
    }

    public static final ExtensionRegistryLite b(String str) {
        return (ExtensionRegistryLite) f1076a.getDeclaredMethod(str, (Class[]) null).invoke((Object) null, (Object[]) null);
    }

    public static Class c() {
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
