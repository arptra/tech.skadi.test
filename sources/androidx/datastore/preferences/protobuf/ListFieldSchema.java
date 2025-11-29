package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;
import java.util.Collections;
import java.util.List;

abstract class ListFieldSchema {

    /* renamed from: a  reason: collision with root package name */
    public static final ListFieldSchema f1111a = new ListFieldSchemaFull();
    public static final ListFieldSchema b = new ListFieldSchemaLite();

    public static final class ListFieldSchemaFull extends ListFieldSchema {
        public static final Class c = Collections.unmodifiableList(Collections.emptyList()).getClass();

        public ListFieldSchemaFull() {
            super();
        }

        public static List f(Object obj, long j) {
            return (List) UnsafeUtil.F(obj, j);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: androidx.datastore.preferences.protobuf.LazyStringArrayList} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.util.ArrayList} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: androidx.datastore.preferences.protobuf.LazyStringArrayList} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: androidx.datastore.preferences.protobuf.LazyStringArrayList} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static java.util.List g(java.lang.Object r3, long r4, int r6) {
            /*
                java.util.List r0 = f(r3, r4)
                boolean r1 = r0.isEmpty()
                if (r1 == 0) goto L_0x002d
                boolean r1 = r0 instanceof androidx.datastore.preferences.protobuf.LazyStringList
                if (r1 == 0) goto L_0x0014
                androidx.datastore.preferences.protobuf.LazyStringArrayList r0 = new androidx.datastore.preferences.protobuf.LazyStringArrayList
                r0.<init>((int) r6)
                goto L_0x0029
            L_0x0014:
                boolean r1 = r0 instanceof androidx.datastore.preferences.protobuf.PrimitiveNonBoxingCollection
                if (r1 == 0) goto L_0x0024
                boolean r1 = r0 instanceof androidx.datastore.preferences.protobuf.Internal.ProtobufList
                if (r1 == 0) goto L_0x0024
                androidx.datastore.preferences.protobuf.Internal$ProtobufList r0 = (androidx.datastore.preferences.protobuf.Internal.ProtobufList) r0
                androidx.datastore.preferences.protobuf.Internal$ProtobufList r6 = r0.mutableCopyWithCapacity(r6)
                r0 = r6
                goto L_0x0029
            L_0x0024:
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>(r6)
            L_0x0029:
                androidx.datastore.preferences.protobuf.UnsafeUtil.V(r3, r4, r0)
                goto L_0x007f
            L_0x002d:
                java.lang.Class r1 = c
                java.lang.Class r2 = r0.getClass()
                boolean r1 = r1.isAssignableFrom(r2)
                if (r1 == 0) goto L_0x004b
                java.util.ArrayList r1 = new java.util.ArrayList
                int r2 = r0.size()
                int r2 = r2 + r6
                r1.<init>(r2)
                r1.addAll(r0)
                androidx.datastore.preferences.protobuf.UnsafeUtil.V(r3, r4, r1)
            L_0x0049:
                r0 = r1
                goto L_0x007f
            L_0x004b:
                boolean r1 = r0 instanceof androidx.datastore.preferences.protobuf.UnmodifiableLazyStringList
                if (r1 == 0) goto L_0x0062
                androidx.datastore.preferences.protobuf.LazyStringArrayList r1 = new androidx.datastore.preferences.protobuf.LazyStringArrayList
                int r2 = r0.size()
                int r2 = r2 + r6
                r1.<init>((int) r2)
                androidx.datastore.preferences.protobuf.UnmodifiableLazyStringList r0 = (androidx.datastore.preferences.protobuf.UnmodifiableLazyStringList) r0
                r1.addAll(r0)
                androidx.datastore.preferences.protobuf.UnsafeUtil.V(r3, r4, r1)
                goto L_0x0049
            L_0x0062:
                boolean r1 = r0 instanceof androidx.datastore.preferences.protobuf.PrimitiveNonBoxingCollection
                if (r1 == 0) goto L_0x007f
                boolean r1 = r0 instanceof androidx.datastore.preferences.protobuf.Internal.ProtobufList
                if (r1 == 0) goto L_0x007f
                r1 = r0
                androidx.datastore.preferences.protobuf.Internal$ProtobufList r1 = (androidx.datastore.preferences.protobuf.Internal.ProtobufList) r1
                boolean r2 = r1.isModifiable()
                if (r2 != 0) goto L_0x007f
                int r0 = r0.size()
                int r0 = r0 + r6
                androidx.datastore.preferences.protobuf.Internal$ProtobufList r0 = r1.mutableCopyWithCapacity(r0)
                androidx.datastore.preferences.protobuf.UnsafeUtil.V(r3, r4, r0)
            L_0x007f:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.ListFieldSchema.ListFieldSchemaFull.g(java.lang.Object, long, int):java.util.List");
        }

        public void c(Object obj, long j) {
            Object obj2;
            List list = (List) UnsafeUtil.F(obj, j);
            if (list instanceof LazyStringList) {
                obj2 = ((LazyStringList) list).getUnmodifiableView();
            } else if (!c.isAssignableFrom(list.getClass())) {
                if (!(list instanceof PrimitiveNonBoxingCollection) || !(list instanceof Internal.ProtobufList)) {
                    obj2 = Collections.unmodifiableList(list);
                } else {
                    Internal.ProtobufList protobufList = (Internal.ProtobufList) list;
                    if (protobufList.isModifiable()) {
                        protobufList.makeImmutable();
                        return;
                    }
                    return;
                }
            } else {
                return;
            }
            UnsafeUtil.V(obj, j, obj2);
        }

        public void d(Object obj, Object obj2, long j) {
            List f = f(obj2, j);
            List g = g(obj, j, f.size());
            int size = g.size();
            int size2 = f.size();
            if (size > 0 && size2 > 0) {
                g.addAll(f);
            }
            if (size > 0) {
                f = g;
            }
            UnsafeUtil.V(obj, j, f);
        }

        public List e(Object obj, long j) {
            return g(obj, j, 10);
        }
    }

    public static final class ListFieldSchemaLite extends ListFieldSchema {
        public ListFieldSchemaLite() {
            super();
        }

        public static Internal.ProtobufList f(Object obj, long j) {
            return (Internal.ProtobufList) UnsafeUtil.F(obj, j);
        }

        public void c(Object obj, long j) {
            f(obj, j).makeImmutable();
        }

        public void d(Object obj, Object obj2, long j) {
            Internal.ProtobufList f = f(obj, j);
            Internal.ProtobufList f2 = f(obj2, j);
            int size = f.size();
            int size2 = f2.size();
            if (size > 0 && size2 > 0) {
                if (!f.isModifiable()) {
                    f = f.mutableCopyWithCapacity(size2 + size);
                }
                f.addAll(f2);
            }
            if (size > 0) {
                f2 = f;
            }
            UnsafeUtil.V(obj, j, f2);
        }

        public List e(Object obj, long j) {
            Internal.ProtobufList f = f(obj, j);
            if (f.isModifiable()) {
                return f;
            }
            int size = f.size();
            Internal.ProtobufList mutableCopyWithCapacity = f.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
            UnsafeUtil.V(obj, j, mutableCopyWithCapacity);
            return mutableCopyWithCapacity;
        }
    }

    public static ListFieldSchema a() {
        return f1111a;
    }

    public static ListFieldSchema b() {
        return b;
    }

    public abstract void c(Object obj, long j);

    public abstract void d(Object obj, Object obj2, long j);

    public abstract List e(Object obj, long j);

    public ListFieldSchema() {
    }
}
