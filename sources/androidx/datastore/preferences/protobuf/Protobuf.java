package androidx.datastore.preferences.protobuf;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class Protobuf {
    public static final Protobuf c = new Protobuf();

    /* renamed from: a  reason: collision with root package name */
    public final SchemaFactory f1129a = new ManifestSchemaFactory();
    public final ConcurrentMap b = new ConcurrentHashMap();

    public static Protobuf a() {
        return c;
    }

    public void b(Object obj, Reader reader, ExtensionRegistryLite extensionRegistryLite) {
        e(obj).b(obj, reader, extensionRegistryLite);
    }

    public Schema c(Class cls, Schema schema) {
        Internal.b(cls, "messageType");
        Internal.b(schema, "schema");
        return (Schema) this.b.putIfAbsent(cls, schema);
    }

    public Schema d(Class cls) {
        Internal.b(cls, "messageType");
        Schema schema = (Schema) this.b.get(cls);
        if (schema != null) {
            return schema;
        }
        Schema createSchema = this.f1129a.createSchema(cls);
        Schema c2 = c(cls, createSchema);
        return c2 != null ? c2 : createSchema;
    }

    public Schema e(Object obj) {
        return d(obj.getClass());
    }

    public void f(Object obj, Writer writer) {
        e(obj).a(obj, writer);
    }
}
