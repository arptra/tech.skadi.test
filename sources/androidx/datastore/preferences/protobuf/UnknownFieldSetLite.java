package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Writer;
import java.util.Arrays;

public final class UnknownFieldSetLite {
    public static final UnknownFieldSetLite f = new UnknownFieldSetLite(0, new int[0], new Object[0], false);

    /* renamed from: a  reason: collision with root package name */
    public int f1154a;
    public int[] b;
    public Object[] c;
    public int d;
    public boolean e;

    public UnknownFieldSetLite() {
        this(0, new int[8], new Object[8], true);
    }

    public static boolean c(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public static boolean d(Object[] objArr, Object[] objArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (!objArr[i2].equals(objArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    public static UnknownFieldSetLite e() {
        return f;
    }

    public static int h(int[] iArr, int i) {
        int i2 = 17;
        for (int i3 = 0; i3 < i; i3++) {
            i2 = (i2 * 31) + iArr[i3];
        }
        return i2;
    }

    public static int i(Object[] objArr, int i) {
        int i2 = 17;
        for (int i3 = 0; i3 < i; i3++) {
            i2 = (i2 * 31) + objArr[i3].hashCode();
        }
        return i2;
    }

    public static UnknownFieldSetLite k(UnknownFieldSetLite unknownFieldSetLite, UnknownFieldSetLite unknownFieldSetLite2) {
        int i = unknownFieldSetLite.f1154a + unknownFieldSetLite2.f1154a;
        int[] copyOf = Arrays.copyOf(unknownFieldSetLite.b, i);
        System.arraycopy(unknownFieldSetLite2.b, 0, copyOf, unknownFieldSetLite.f1154a, unknownFieldSetLite2.f1154a);
        Object[] copyOf2 = Arrays.copyOf(unknownFieldSetLite.c, i);
        System.arraycopy(unknownFieldSetLite2.c, 0, copyOf2, unknownFieldSetLite.f1154a, unknownFieldSetLite2.f1154a);
        return new UnknownFieldSetLite(i, copyOf, copyOf2, true);
    }

    public static UnknownFieldSetLite l() {
        return new UnknownFieldSetLite();
    }

    public static void p(int i, Object obj, Writer writer) {
        int a2 = WireFormat.a(i);
        int b2 = WireFormat.b(i);
        if (b2 == 0) {
            writer.writeInt64(a2, ((Long) obj).longValue());
        } else if (b2 == 1) {
            writer.writeFixed64(a2, ((Long) obj).longValue());
        } else if (b2 == 2) {
            writer.a(a2, (ByteString) obj);
        } else if (b2 != 3) {
            if (b2 == 5) {
                writer.writeFixed32(a2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(InvalidProtocolBufferException.invalidWireType());
        } else if (writer.fieldOrder() == Writer.FieldOrder.ASCENDING) {
            writer.writeStartGroup(a2);
            ((UnknownFieldSetLite) obj).q(writer);
            writer.writeEndGroup(a2);
        } else {
            writer.writeEndGroup(a2);
            ((UnknownFieldSetLite) obj).q(writer);
            writer.writeStartGroup(a2);
        }
    }

    public void a() {
        if (!this.e) {
            throw new UnsupportedOperationException();
        }
    }

    public final void b() {
        int i = this.f1154a;
        int[] iArr = this.b;
        if (i == iArr.length) {
            int i2 = i + (i < 4 ? 8 : i >> 1);
            this.b = Arrays.copyOf(iArr, i2);
            this.c = Arrays.copyOf(this.c, i2);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UnknownFieldSetLite)) {
            return false;
        }
        UnknownFieldSetLite unknownFieldSetLite = (UnknownFieldSetLite) obj;
        int i = this.f1154a;
        return i == unknownFieldSetLite.f1154a && c(this.b, unknownFieldSetLite.b, i) && d(this.c, unknownFieldSetLite.c, this.f1154a);
    }

    public int f() {
        int g0;
        int i = this.d;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f1154a; i3++) {
            int i4 = this.b[i3];
            int a2 = WireFormat.a(i4);
            int b2 = WireFormat.b(i4);
            if (b2 == 0) {
                g0 = CodedOutputStream.g0(a2, ((Long) this.c[i3]).longValue());
            } else if (b2 == 1) {
                g0 = CodedOutputStream.w(a2, ((Long) this.c[i3]).longValue());
            } else if (b2 == 2) {
                g0 = CodedOutputStream.o(a2, (ByteString) this.c[i3]);
            } else if (b2 == 3) {
                g0 = (CodedOutputStream.d0(a2) * 2) + ((UnknownFieldSetLite) this.c[i3]).f();
            } else if (b2 == 5) {
                g0 = CodedOutputStream.u(a2, ((Integer) this.c[i3]).intValue());
            } else {
                throw new IllegalStateException(InvalidProtocolBufferException.invalidWireType());
            }
            i2 += g0;
        }
        this.d = i2;
        return i2;
    }

    public int g() {
        int i = this.d;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f1154a; i3++) {
            i2 += CodedOutputStream.R(WireFormat.a(this.b[i3]), (ByteString) this.c[i3]);
        }
        this.d = i2;
        return i2;
    }

    public int hashCode() {
        int i = this.f1154a;
        return ((((527 + i) * 31) + h(this.b, i)) * 31) + i(this.c, this.f1154a);
    }

    public void j() {
        this.e = false;
    }

    public final void m(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.f1154a; i2++) {
            MessageLiteToString.c(sb, i, String.valueOf(WireFormat.a(this.b[i2])), this.c[i2]);
        }
    }

    public void n(int i, Object obj) {
        a();
        b();
        int[] iArr = this.b;
        int i2 = this.f1154a;
        iArr[i2] = i;
        this.c[i2] = obj;
        this.f1154a = i2 + 1;
    }

    public void o(Writer writer) {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            for (int i = this.f1154a - 1; i >= 0; i--) {
                writer.writeMessageSetItem(WireFormat.a(this.b[i]), this.c[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.f1154a; i2++) {
            writer.writeMessageSetItem(WireFormat.a(this.b[i2]), this.c[i2]);
        }
    }

    public void q(Writer writer) {
        if (this.f1154a != 0) {
            if (writer.fieldOrder() == Writer.FieldOrder.ASCENDING) {
                for (int i = 0; i < this.f1154a; i++) {
                    p(this.b[i], this.c[i], writer);
                }
                return;
            }
            for (int i2 = this.f1154a - 1; i2 >= 0; i2--) {
                p(this.b[i2], this.c[i2], writer);
            }
        }
    }

    public UnknownFieldSetLite(int i, int[] iArr, Object[] objArr, boolean z) {
        this.d = -1;
        this.f1154a = i;
        this.b = iArr;
        this.c = objArr;
        this.e = z;
    }
}
