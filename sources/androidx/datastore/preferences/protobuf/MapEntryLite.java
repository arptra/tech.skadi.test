package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.WireFormat;

public class MapEntryLite<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public final Metadata f1115a;
    public final Object b;
    public final Object c;

    /* renamed from: androidx.datastore.preferences.protobuf.MapEntryLite$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f1116a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                androidx.datastore.preferences.protobuf.WireFormat$FieldType[] r0 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1116a = r0
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f1116a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f1116a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.GROUP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MapEntryLite.AnonymousClass1.<clinit>():void");
        }
    }

    public static class Metadata<K, V> {

        /* renamed from: a  reason: collision with root package name */
        public final WireFormat.FieldType f1117a;
        public final Object b;
        public final WireFormat.FieldType c;
        public final Object d;

        public Metadata(WireFormat.FieldType fieldType, Object obj, WireFormat.FieldType fieldType2, Object obj2) {
            this.f1117a = fieldType;
            this.b = obj;
            this.c = fieldType2;
            this.d = obj2;
        }
    }

    public MapEntryLite(WireFormat.FieldType fieldType, Object obj, WireFormat.FieldType fieldType2, Object obj2) {
        this.f1115a = new Metadata(fieldType, obj, fieldType2, obj2);
        this.b = obj;
        this.c = obj2;
    }

    public static int b(Metadata metadata, Object obj, Object obj2) {
        return FieldSet.d(metadata.f1117a, 1, obj) + FieldSet.d(metadata.c, 2, obj2);
    }

    public static MapEntryLite d(WireFormat.FieldType fieldType, Object obj, WireFormat.FieldType fieldType2, Object obj2) {
        return new MapEntryLite(fieldType, obj, fieldType2, obj2);
    }

    public static void e(CodedOutputStream codedOutputStream, Metadata metadata, Object obj, Object obj2) {
        FieldSet.y(codedOutputStream, metadata.f1117a, 1, obj);
        FieldSet.y(codedOutputStream, metadata.c, 2, obj2);
    }

    public int a(int i, Object obj, Object obj2) {
        return CodedOutputStream.d0(i) + CodedOutputStream.K(b(this.f1115a, obj, obj2));
    }

    public Metadata c() {
        return this.f1115a;
    }
}
