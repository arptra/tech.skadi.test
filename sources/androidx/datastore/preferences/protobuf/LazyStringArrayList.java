package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public class LazyStringArrayList extends AbstractProtobufList<String> implements LazyStringList, RandomAccess {
    public static final LazyStringArrayList c;
    public static final LazyStringList d;
    public final List b;

    public static class ByteArrayListView extends AbstractList<byte[]> implements RandomAccess {

        /* renamed from: a  reason: collision with root package name */
        public final LazyStringArrayList f1109a;

        /* renamed from: a */
        public void add(int i, byte[] bArr) {
            this.f1109a.k(i, bArr);
            this.modCount++;
        }

        /* renamed from: b */
        public byte[] get(int i) {
            return this.f1109a.getByteArray(i);
        }

        /* renamed from: c */
        public byte[] remove(int i) {
            String r = this.f1109a.remove(i);
            this.modCount++;
            return LazyStringArrayList.l(r);
        }

        /* renamed from: d */
        public byte[] set(int i, byte[] bArr) {
            Object b = this.f1109a.u(i, bArr);
            this.modCount++;
            return LazyStringArrayList.l(b);
        }

        public int size() {
            return this.f1109a.size();
        }
    }

    public static class ByteStringListView extends AbstractList<ByteString> implements RandomAccess {

        /* renamed from: a  reason: collision with root package name */
        public final LazyStringArrayList f1110a;

        /* renamed from: a */
        public void add(int i, ByteString byteString) {
            this.f1110a.i(i, byteString);
            this.modCount++;
        }

        /* renamed from: b */
        public ByteString get(int i) {
            return this.f1110a.p(i);
        }

        /* renamed from: c */
        public ByteString remove(int i) {
            String r = this.f1110a.remove(i);
            this.modCount++;
            return LazyStringArrayList.m(r);
        }

        /* renamed from: d */
        public ByteString set(int i, ByteString byteString) {
            Object e = this.f1110a.t(i, byteString);
            this.modCount++;
            return LazyStringArrayList.m(e);
        }

        public int size() {
            return this.f1110a.size();
        }
    }

    static {
        LazyStringArrayList lazyStringArrayList = new LazyStringArrayList();
        c = lazyStringArrayList;
        lazyStringArrayList.makeImmutable();
        d = lazyStringArrayList;
    }

    public LazyStringArrayList() {
        this(10);
    }

    public static byte[] l(Object obj) {
        return obj instanceof byte[] ? (byte[]) obj : obj instanceof String ? Internal.j((String) obj) : ((ByteString) obj).toByteArray();
    }

    public static ByteString m(Object obj) {
        return obj instanceof ByteString ? (ByteString) obj : obj instanceof String ? ByteString.copyFromUtf8((String) obj) : ByteString.copyFrom((byte[]) obj);
    }

    public static String n(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof ByteString ? ((ByteString) obj).toStringUtf8() : Internal.k((byte[]) obj);
    }

    public boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }

    public void clear() {
        a();
        this.b.clear();
        this.modCount++;
    }

    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public void g(ByteString byteString) {
        a();
        this.b.add(byteString);
        this.modCount++;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: byte[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] getByteArray(int r3) {
        /*
            r2 = this;
            java.util.List r0 = r2.b
            java.lang.Object r0 = r0.get(r3)
            byte[] r1 = l(r0)
            if (r1 == r0) goto L_0x0011
            java.util.List r2 = r2.b
            r2.set(r3, r1)
        L_0x0011:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.LazyStringArrayList.getByteArray(int):byte[]");
    }

    public Object getRaw(int i) {
        return this.b.get(i);
    }

    public List getUnderlyingElements() {
        return Collections.unmodifiableList(this.b);
    }

    public LazyStringList getUnmodifiableView() {
        return isModifiable() ? new UnmodifiableLazyStringList(this) : this;
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public final void i(int i, ByteString byteString) {
        a();
        this.b.add(i, byteString);
        this.modCount++;
    }

    public /* bridge */ /* synthetic */ boolean isModifiable() {
        return super.isModifiable();
    }

    /* renamed from: j */
    public void add(int i, String str) {
        a();
        this.b.add(i, str);
        this.modCount++;
    }

    public final void k(int i, byte[] bArr) {
        a();
        this.b.add(i, bArr);
        this.modCount++;
    }

    /* renamed from: o */
    public String get(int i) {
        Object obj = this.b.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.b.set(i, stringUtf8);
            }
            return stringUtf8;
        }
        byte[] bArr = (byte[]) obj;
        String k = Internal.k(bArr);
        if (Internal.g(bArr)) {
            this.b.set(i, k);
        }
        return k;
    }

    public ByteString p(int i) {
        Object obj = this.b.get(i);
        ByteString m = m(obj);
        if (m != obj) {
            this.b.set(i, m);
        }
        return m;
    }

    /* renamed from: q */
    public LazyStringArrayList mutableCopyWithCapacity(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.b);
            return new LazyStringArrayList(arrayList);
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: r */
    public String remove(int i) {
        a();
        Object remove = this.b.remove(i);
        this.modCount++;
        return n(remove);
    }

    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    /* renamed from: s */
    public String set(int i, String str) {
        a();
        return n(this.b.set(i, str));
    }

    public int size() {
        return this.b.size();
    }

    public final Object t(int i, ByteString byteString) {
        a();
        return this.b.set(i, byteString);
    }

    public final Object u(int i, byte[] bArr) {
        a();
        return this.b.set(i, bArr);
    }

    public LazyStringArrayList(int i) {
        this(new ArrayList(i));
    }

    public boolean addAll(int i, Collection collection) {
        a();
        if (collection instanceof LazyStringList) {
            collection = ((LazyStringList) collection).getUnderlyingElements();
        }
        boolean addAll = this.b.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    public LazyStringArrayList(ArrayList arrayList) {
        this.b = arrayList;
    }
}
