package androidx.datastore.preferences.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;

public final class Internal {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f1098a = Charset.forName("UTF-8");
    public static final Charset b = Charset.forName("ISO-8859-1");
    public static final byte[] c;
    public static final ByteBuffer d;
    public static final CodedInputStream e;

    public interface BooleanList extends ProtobufList<Boolean> {
    }

    public interface DoubleList extends ProtobufList<Double> {
    }

    public interface EnumLite {
        int getNumber();
    }

    public interface EnumLiteMap<T extends EnumLite> {
        EnumLite findValueByNumber(int i);
    }

    public interface EnumVerifier {
        boolean isInRange(int i);
    }

    public interface FloatList extends ProtobufList<Float> {
    }

    public interface IntList extends ProtobufList<Integer> {
    }

    public static class ListAdapter<F, T> extends AbstractList<T> {

        /* renamed from: a  reason: collision with root package name */
        public final List f1099a;
        public final Converter b;

        public interface Converter<F, T> {
            Object convert(Object obj);
        }

        public Object get(int i) {
            return this.b.convert(this.f1099a.get(i));
        }

        public int size() {
            return this.f1099a.size();
        }
    }

    public interface LongList extends ProtobufList<Long> {
    }

    public static class MapAdapter<K, V, RealValue> extends AbstractMap<K, V> {

        /* renamed from: a  reason: collision with root package name */
        public final Map f1100a;
        public final Converter b;

        /* renamed from: androidx.datastore.preferences.protobuf.Internal$MapAdapter$1  reason: invalid class name */
        final class AnonymousClass1 implements Converter<Integer, EnumLite> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ EnumLiteMap f1101a;
            public final /* synthetic */ EnumLite b;

            /* renamed from: a */
            public Integer doBackward(EnumLite enumLite) {
                return Integer.valueOf(enumLite.getNumber());
            }

            /* renamed from: b */
            public EnumLite doForward(Integer num) {
                EnumLite findValueByNumber = this.f1101a.findValueByNumber(num.intValue());
                return findValueByNumber == null ? this.b : findValueByNumber;
            }
        }

        public interface Converter<A, B> {
            Object doBackward(Object obj);

            Object doForward(Object obj);
        }

        public class EntryAdapter implements Map.Entry<K, V> {

            /* renamed from: a  reason: collision with root package name */
            public final Map.Entry f1102a;

            public EntryAdapter(Map.Entry entry) {
                this.f1102a = entry;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                return getKey().equals(((Map.Entry) obj).getKey()) && getValue().equals(getValue());
            }

            public Object getKey() {
                return this.f1102a.getKey();
            }

            public Object getValue() {
                return MapAdapter.this.b.doForward(this.f1102a.getValue());
            }

            public int hashCode() {
                return this.f1102a.hashCode();
            }

            public Object setValue(Object obj) {
                Object value = this.f1102a.setValue(MapAdapter.this.b.doBackward(obj));
                if (value == null) {
                    return null;
                }
                return MapAdapter.this.b.doForward(value);
            }
        }

        public class IteratorAdapter implements Iterator<Map.Entry<K, V>> {

            /* renamed from: a  reason: collision with root package name */
            public final Iterator f1103a;

            public IteratorAdapter(Iterator it) {
                this.f1103a = it;
            }

            /* renamed from: a */
            public Map.Entry next() {
                return new EntryAdapter((Map.Entry) this.f1103a.next());
            }

            public boolean hasNext() {
                return this.f1103a.hasNext();
            }

            public void remove() {
                this.f1103a.remove();
            }
        }

        public class SetAdapter extends AbstractSet<Map.Entry<K, V>> {

            /* renamed from: a  reason: collision with root package name */
            public final Set f1104a;

            public SetAdapter(Set set) {
                this.f1104a = set;
            }

            public Iterator iterator() {
                return new IteratorAdapter(this.f1104a.iterator());
            }

            public int size() {
                return this.f1104a.size();
            }
        }

        public Set entrySet() {
            return new SetAdapter(this.f1100a.entrySet());
        }

        public Object get(Object obj) {
            Object obj2 = this.f1100a.get(obj);
            if (obj2 == null) {
                return null;
            }
            return this.b.doForward(obj2);
        }

        public Object put(Object obj, Object obj2) {
            Object put = this.f1100a.put(obj, this.b.doBackward(obj2));
            if (put == null) {
                return null;
            }
            return this.b.doForward(put);
        }
    }

    public interface ProtobufList<E> extends List<E>, RandomAccess {
        boolean isModifiable();

        void makeImmutable();

        ProtobufList mutableCopyWithCapacity(int i);
    }

    static {
        byte[] bArr = new byte[0];
        c = bArr;
        d = ByteBuffer.wrap(bArr);
        e = CodedInputStream.i(bArr);
    }

    public static Object a(Object obj) {
        obj.getClass();
        return obj;
    }

    public static Object b(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    public static int c(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int d(byte[] bArr) {
        return e(bArr, 0, bArr.length);
    }

    public static int e(byte[] bArr, int i, int i2) {
        int i3 = i(i2, bArr, i, i2);
        if (i3 == 0) {
            return 1;
        }
        return i3;
    }

    public static int f(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static boolean g(byte[] bArr) {
        return Utf8.t(bArr);
    }

    public static Object h(Object obj, Object obj2) {
        return ((MessageLite) obj).toBuilder().a((MessageLite) obj2).buildPartial();
    }

    public static int i(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    public static byte[] j(String str) {
        return str.getBytes(f1098a);
    }

    public static String k(byte[] bArr) {
        return new String(bArr, f1098a);
    }
}
