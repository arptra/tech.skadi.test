package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class SchemaUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final Class f1135a = B();
    public static final UnknownFieldSchema b = C(false);
    public static final UnknownFieldSchema c = C(true);
    public static final UnknownFieldSchema d = new UnknownFieldSetLiteSchema();

    public static Object A(int i, List list, Internal.EnumVerifier enumVerifier, Object obj, UnknownFieldSchema unknownFieldSchema) {
        if (enumVerifier == null) {
            return obj;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                Integer num = (Integer) list.get(i3);
                int intValue = num.intValue();
                if (enumVerifier.isInRange(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, num);
                    }
                    i2++;
                } else {
                    obj = L(i, intValue, obj, unknownFieldSchema);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = ((Integer) it.next()).intValue();
                if (!enumVerifier.isInRange(intValue2)) {
                    obj = L(i, intValue2, obj, unknownFieldSchema);
                    it.remove();
                }
            }
        }
        return obj;
    }

    public static Class B() {
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static UnknownFieldSchema C(boolean z) {
        try {
            Class D = D();
            if (D == null) {
                return null;
            }
            return (UnknownFieldSchema) D.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Class D() {
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void E(ExtensionSchema extensionSchema, Object obj, Object obj2) {
        FieldSet c2 = extensionSchema.c(obj2);
        if (!c2.m()) {
            extensionSchema.d(obj).t(c2);
        }
    }

    public static void F(MapFieldSchema mapFieldSchema, Object obj, Object obj2, long j) {
        UnsafeUtil.V(obj, j, mapFieldSchema.mergeFrom(UnsafeUtil.F(obj, j), UnsafeUtil.F(obj2, j)));
    }

    public static void G(UnknownFieldSchema unknownFieldSchema, Object obj, Object obj2) {
        unknownFieldSchema.p(obj, unknownFieldSchema.k(unknownFieldSchema.g(obj), unknownFieldSchema.g(obj2)));
    }

    public static UnknownFieldSchema H() {
        return b;
    }

    public static UnknownFieldSchema I() {
        return c;
    }

    public static void J(Class cls) {
        Class cls2;
        if (!GeneratedMessageLite.class.isAssignableFrom(cls) && (cls2 = f1135a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static boolean K(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static Object L(int i, int i2, Object obj, UnknownFieldSchema unknownFieldSchema) {
        if (obj == null) {
            obj = unknownFieldSchema.n();
        }
        unknownFieldSchema.e(obj, i, (long) i2);
        return obj;
    }

    public static UnknownFieldSchema M() {
        return d;
    }

    public static void N(int i, List list, Writer writer, boolean z) {
        if (list != null && !list.isEmpty()) {
            writer.writeBoolList(i, list, z);
        }
    }

    public static void O(int i, List list, Writer writer) {
        if (list != null && !list.isEmpty()) {
            writer.writeBytesList(i, list);
        }
    }

    public static void P(int i, List list, Writer writer, boolean z) {
        if (list != null && !list.isEmpty()) {
            writer.writeDoubleList(i, list, z);
        }
    }

    public static void Q(int i, List list, Writer writer, boolean z) {
        if (list != null && !list.isEmpty()) {
            writer.writeEnumList(i, list, z);
        }
    }

    public static void R(int i, List list, Writer writer, boolean z) {
        if (list != null && !list.isEmpty()) {
            writer.writeFixed32List(i, list, z);
        }
    }

    public static void S(int i, List list, Writer writer, boolean z) {
        if (list != null && !list.isEmpty()) {
            writer.writeFixed64List(i, list, z);
        }
    }

    public static void T(int i, List list, Writer writer, boolean z) {
        if (list != null && !list.isEmpty()) {
            writer.writeFloatList(i, list, z);
        }
    }

    public static void U(int i, List list, Writer writer, Schema schema) {
        if (list != null && !list.isEmpty()) {
            writer.d(i, list, schema);
        }
    }

    public static void V(int i, List list, Writer writer, boolean z) {
        if (list != null && !list.isEmpty()) {
            writer.writeInt32List(i, list, z);
        }
    }

    public static void W(int i, List list, Writer writer, boolean z) {
        if (list != null && !list.isEmpty()) {
            writer.writeInt64List(i, list, z);
        }
    }

    public static void X(int i, List list, Writer writer, Schema schema) {
        if (list != null && !list.isEmpty()) {
            writer.f(i, list, schema);
        }
    }

    public static void Y(int i, List list, Writer writer, boolean z) {
        if (list != null && !list.isEmpty()) {
            writer.writeSFixed32List(i, list, z);
        }
    }

    public static void Z(int i, List list, Writer writer, boolean z) {
        if (list != null && !list.isEmpty()) {
            writer.writeSFixed64List(i, list, z);
        }
    }

    public static int a(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z ? CodedOutputStream.d0(i) + CodedOutputStream.K(size) : size * CodedOutputStream.l(i, true);
    }

    public static void a0(int i, List list, Writer writer, boolean z) {
        if (list != null && !list.isEmpty()) {
            writer.writeSInt32List(i, list, z);
        }
    }

    public static int b(List list) {
        return list.size();
    }

    public static void b0(int i, List list, Writer writer, boolean z) {
        if (list != null && !list.isEmpty()) {
            writer.writeSInt64List(i, list, z);
        }
    }

    public static int c(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int d0 = size * CodedOutputStream.d0(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            d0 += CodedOutputStream.p((ByteString) list.get(i2));
        }
        return d0;
    }

    public static void c0(int i, List list, Writer writer) {
        if (list != null && !list.isEmpty()) {
            writer.writeStringList(i, list);
        }
    }

    public static int d(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int e = e(list);
        return z ? CodedOutputStream.d0(i) + CodedOutputStream.K(e) : e + (size * CodedOutputStream.d0(i));
    }

    public static void d0(int i, List list, Writer writer, boolean z) {
        if (list != null && !list.isEmpty()) {
            writer.writeUInt32List(i, list, z);
        }
    }

    public static int e(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            i = 0;
            while (i2 < size) {
                i += CodedOutputStream.t(intArrayList.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + CodedOutputStream.t(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    public static void e0(int i, List list, Writer writer, boolean z) {
        if (list != null && !list.isEmpty()) {
            writer.writeUInt64List(i, list, z);
        }
    }

    public static int f(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z ? CodedOutputStream.d0(i) + CodedOutputStream.K(size * 4) : size * CodedOutputStream.u(i, 0);
    }

    public static int g(List list) {
        return list.size() * 4;
    }

    public static int h(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z ? CodedOutputStream.d0(i) + CodedOutputStream.K(size * 8) : size * CodedOutputStream.w(i, 0);
    }

    public static int i(List list) {
        return list.size() * 8;
    }

    public static int j(int i, List list, Schema schema) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += CodedOutputStream.A(i, (MessageLite) list.get(i3), schema);
        }
        return i2;
    }

    public static int k(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int l = l(list);
        return z ? CodedOutputStream.d0(i) + CodedOutputStream.K(l) : l + (size * CodedOutputStream.d0(i));
    }

    public static int l(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            i = 0;
            while (i2 < size) {
                i += CodedOutputStream.E(intArrayList.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + CodedOutputStream.E(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int m(int i, List list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        int n = n(list);
        return z ? CodedOutputStream.d0(i) + CodedOutputStream.K(n) : n + (list.size() * CodedOutputStream.d0(i));
    }

    public static int n(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            i = 0;
            while (i2 < size) {
                i += CodedOutputStream.G(longArrayList.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + CodedOutputStream.G(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    public static int o(int i, Object obj, Schema schema) {
        return obj instanceof LazyFieldLite ? CodedOutputStream.I(i, (LazyFieldLite) obj) : CodedOutputStream.N(i, (MessageLite) obj, schema);
    }

    public static int p(int i, List list, Schema schema) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int d0 = CodedOutputStream.d0(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            d0 += obj instanceof LazyFieldLite ? CodedOutputStream.J((LazyFieldLite) obj) : CodedOutputStream.P((MessageLite) obj, schema);
        }
        return d0;
    }

    public static int q(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int r = r(list);
        return z ? CodedOutputStream.d0(i) + CodedOutputStream.K(r) : r + (size * CodedOutputStream.d0(i));
    }

    public static int r(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            i = 0;
            while (i2 < size) {
                i += CodedOutputStream.Y(intArrayList.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + CodedOutputStream.Y(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int s(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int t = t(list);
        return z ? CodedOutputStream.d0(i) + CodedOutputStream.K(t) : t + (size * CodedOutputStream.d0(i));
    }

    public static int t(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            i = 0;
            while (i2 < size) {
                i += CodedOutputStream.a0(longArrayList.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + CodedOutputStream.a0(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    public static int u(int i, List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int d0 = CodedOutputStream.d0(i) * size;
        if (list instanceof LazyStringList) {
            LazyStringList lazyStringList = (LazyStringList) list;
            while (i2 < size) {
                Object raw = lazyStringList.getRaw(i2);
                d0 += raw instanceof ByteString ? CodedOutputStream.p((ByteString) raw) : CodedOutputStream.c0((String) raw);
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                d0 += obj instanceof ByteString ? CodedOutputStream.p((ByteString) obj) : CodedOutputStream.c0((String) obj);
                i2++;
            }
        }
        return d0;
    }

    public static int v(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int w = w(list);
        return z ? CodedOutputStream.d0(i) + CodedOutputStream.K(w) : w + (size * CodedOutputStream.d0(i));
    }

    public static int w(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            i = 0;
            while (i2 < size) {
                i += CodedOutputStream.f0(intArrayList.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + CodedOutputStream.f0(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int x(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int y = y(list);
        return z ? CodedOutputStream.d0(i) + CodedOutputStream.K(y) : y + (size * CodedOutputStream.d0(i));
    }

    public static int y(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            i = 0;
            while (i2 < size) {
                i += CodedOutputStream.h0(longArrayList.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + CodedOutputStream.h0(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    public static Object z(int i, List list, Internal.EnumLiteMap enumLiteMap, Object obj, UnknownFieldSchema unknownFieldSchema) {
        if (enumLiteMap == null) {
            return obj;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                Integer num = (Integer) list.get(i3);
                int intValue = num.intValue();
                if (enumLiteMap.findValueByNumber(intValue) != null) {
                    if (i3 != i2) {
                        list.set(i2, num);
                    }
                    i2++;
                } else {
                    obj = L(i, intValue, obj, unknownFieldSchema);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = ((Integer) it.next()).intValue();
                if (enumLiteMap.findValueByNumber(intValue2) == null) {
                    obj = L(i, intValue2, obj, unknownFieldSchema);
                    it.remove();
                }
            }
        }
        return obj;
    }
}
