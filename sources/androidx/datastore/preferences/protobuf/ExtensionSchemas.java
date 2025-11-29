package androidx.datastore.preferences.protobuf;

final class ExtensionSchemas {

    /* renamed from: a  reason: collision with root package name */
    public static final ExtensionSchema f1080a = new ExtensionSchemaLite();
    public static final ExtensionSchema b = c();

    public static ExtensionSchema a() {
        ExtensionSchema extensionSchema = b;
        if (extensionSchema != null) {
            return extensionSchema;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    public static ExtensionSchema b() {
        return f1080a;
    }

    public static ExtensionSchema c() {
        try {
            return (ExtensionSchema) Class.forName("androidx.datastore.preferences.protobuf.ExtensionSchemaFull").getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
        } catch (Exception unused) {
            return null;
        }
    }
}
