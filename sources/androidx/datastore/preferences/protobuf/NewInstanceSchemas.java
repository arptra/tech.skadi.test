package androidx.datastore.preferences.protobuf;

final class NewInstanceSchemas {

    /* renamed from: a  reason: collision with root package name */
    public static final NewInstanceSchema f1124a = c();
    public static final NewInstanceSchema b = new NewInstanceSchemaLite();

    public static NewInstanceSchema a() {
        return f1124a;
    }

    public static NewInstanceSchema b() {
        return b;
    }

    public static NewInstanceSchema c() {
        try {
            return (NewInstanceSchema) Class.forName("androidx.datastore.preferences.protobuf.NewInstanceSchemaFull").getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
        } catch (Exception unused) {
            return null;
        }
    }
}
