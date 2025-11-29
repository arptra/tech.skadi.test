package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;
import java.lang.reflect.Field;

final class FieldInfo implements Comparable<FieldInfo> {

    /* renamed from: a  reason: collision with root package name */
    public final Field f1084a;
    public final FieldType b;
    public final Class c;
    public final int d;
    public final Field e;
    public final int f;
    public final boolean g;
    public final boolean h;
    public final OneofInfo i;
    public final Field j;
    public final Class k;
    public final Object l;
    public final Internal.EnumVerifier m;

    /* renamed from: androidx.datastore.preferences.protobuf.FieldInfo$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f1085a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                androidx.datastore.preferences.protobuf.FieldType[] r0 = androidx.datastore.preferences.protobuf.FieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1085a = r0
                androidx.datastore.preferences.protobuf.FieldType r1 = androidx.datastore.preferences.protobuf.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f1085a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.FieldType r1 = androidx.datastore.preferences.protobuf.FieldType.GROUP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f1085a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.FieldType r1 = androidx.datastore.preferences.protobuf.FieldType.MESSAGE_LIST     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f1085a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.FieldType r1 = androidx.datastore.preferences.protobuf.FieldType.GROUP_LIST     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.FieldInfo.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Builder {
    }

    /* renamed from: a */
    public int compareTo(FieldInfo fieldInfo) {
        return this.d - fieldInfo.d;
    }

    public Field d() {
        return this.j;
    }

    public Internal.EnumVerifier f() {
        return this.m;
    }

    public Field g() {
        return this.f1084a;
    }

    public int h() {
        return this.d;
    }

    public Object i() {
        return this.l;
    }

    public Class j() {
        int i2 = AnonymousClass1.f1085a[this.b.ordinal()];
        if (i2 == 1 || i2 == 2) {
            Field field = this.f1084a;
            return field != null ? field.getType() : this.k;
        } else if (i2 == 3 || i2 == 4) {
            return this.c;
        } else {
            return null;
        }
    }

    public OneofInfo k() {
        return this.i;
    }

    public Field l() {
        return this.e;
    }

    public int m() {
        return this.f;
    }

    public FieldType n() {
        return this.b;
    }

    public boolean o() {
        return this.h;
    }

    public boolean p() {
        return this.g;
    }
}
