package androidx.datastore.preferences.protobuf;

final class MapFieldSchemas {

    /* renamed from: a  reason: collision with root package name */
    public static final MapFieldSchema f1118a = c();
    public static final MapFieldSchema b = new MapFieldSchemaLite();

    public static MapFieldSchema a() {
        return f1118a;
    }

    public static MapFieldSchema b() {
        return b;
    }

    public static MapFieldSchema c() {
        try {
            return (MapFieldSchema) Class.forName("androidx.datastore.preferences.protobuf.MapFieldSchemaFull").getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
        } catch (Exception unused) {
            return null;
        }
    }
}
