package androidx.emoji2.text.flatbuffer;

import kotlin.UShort;

public class FlexBuffers {

    /* renamed from: a  reason: collision with root package name */
    public static final ReadBuf f1224a = new ArrayReadWriteBuf(new byte[]{0}, 1);

    public static class Blob extends Sized {
        public static final Blob e = new Blob(FlexBuffers.f1224a, 1, 1);

        public Blob(ReadBuf readBuf, int i, int i2) {
            super(readBuf, i, i2);
        }

        public static Blob c() {
            return e;
        }

        public StringBuilder a(StringBuilder sb) {
            sb.append('\"');
            sb.append(this.f1226a.a(this.b, b()));
            sb.append('\"');
            return sb;
        }

        public /* bridge */ /* synthetic */ int b() {
            return super.b();
        }

        public String toString() {
            return this.f1226a.a(this.b, b());
        }
    }

    public static class FlexBufferException extends RuntimeException {
        public FlexBufferException(String str) {
            super(str);
        }
    }

    public static class Key extends Object {
        public static final Key d = new Key(FlexBuffers.f1224a, 0, 0);

        public Key(ReadBuf readBuf, int i, int i2) {
            super(readBuf, i, i2);
        }

        public static Key c() {
            return d;
        }

        public StringBuilder a(StringBuilder sb) {
            sb.append(toString());
            return sb;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            return key.b == this.b && key.c == this.c;
        }

        public int hashCode() {
            return this.c ^ this.b;
        }

        public String toString() {
            int i = this.b;
            while (this.f1226a.get(i) != 0) {
                i++;
            }
            int i2 = this.b;
            return this.f1226a.a(i2, i - i2);
        }
    }

    public static class KeyVector {

        /* renamed from: a  reason: collision with root package name */
        public final TypedVector f1225a;

        public KeyVector(TypedVector typedVector) {
            this.f1225a = typedVector;
        }

        public Key a(int i) {
            if (i >= b()) {
                return Key.d;
            }
            TypedVector typedVector = this.f1225a;
            TypedVector typedVector2 = this.f1225a;
            ReadBuf readBuf = typedVector2.f1226a;
            return new Key(readBuf, FlexBuffers.g(readBuf, typedVector.b + (i * typedVector.c), typedVector2.c), 1);
        }

        public int b() {
            return this.f1225a.b();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (int i = 0; i < this.f1225a.b(); i++) {
                this.f1225a.d(i).q(sb);
                if (i != this.f1225a.b() - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }

    public static class Map extends Vector {
        public static final Map f = new Map(FlexBuffers.f1224a, 1, 1);

        public Map(ReadBuf readBuf, int i, int i2) {
            super(readBuf, i, i2);
        }

        public static Map e() {
            return f;
        }

        public StringBuilder a(StringBuilder sb) {
            sb.append("{ ");
            KeyVector f2 = f();
            int b = b();
            Vector g = g();
            for (int i = 0; i < b; i++) {
                sb.append('\"');
                sb.append(f2.a(i).toString());
                sb.append("\" : ");
                sb.append(g.d(i).toString());
                if (i != b - 1) {
                    sb.append(", ");
                }
            }
            sb.append(" }");
            return sb;
        }

        public KeyVector f() {
            int i = this.b - (this.c * 3);
            ReadBuf readBuf = this.f1226a;
            int c = FlexBuffers.g(readBuf, i, this.c);
            ReadBuf readBuf2 = this.f1226a;
            int i2 = this.c;
            return new KeyVector(new TypedVector(readBuf, c, FlexBuffers.j(readBuf2, i + i2, i2), 4));
        }

        public Vector g() {
            return new Vector(this.f1226a, this.b, this.c);
        }
    }

    public static abstract class Object {

        /* renamed from: a  reason: collision with root package name */
        public ReadBuf f1226a;
        public int b;
        public int c;

        public Object(ReadBuf readBuf, int i, int i2) {
            this.f1226a = readBuf;
            this.b = i;
            this.c = i2;
        }

        public abstract StringBuilder a(StringBuilder sb);

        public String toString() {
            return a(new StringBuilder(128)).toString();
        }
    }

    public static class Reference {
        public static final Reference f = new Reference(FlexBuffers.f1224a, 0, 1, 0);

        /* renamed from: a  reason: collision with root package name */
        public ReadBuf f1227a;
        public int b;
        public int c;
        public int d;
        public int e;

        public Reference(ReadBuf readBuf, int i, int i2, int i3) {
            this(readBuf, i, i2, 1 << (i3 & 3), i3 >> 2);
        }

        public Blob b() {
            if (!k() && !o()) {
                return Blob.c();
            }
            ReadBuf readBuf = this.f1227a;
            return new Blob(readBuf, FlexBuffers.g(readBuf, this.b, this.c), this.d);
        }

        public boolean c() {
            return l() ? this.f1227a.get(this.b) != 0 : i() != 0;
        }

        public double d() {
            int i = this.e;
            if (i == 3) {
                return FlexBuffers.i(this.f1227a, this.b, this.c);
            }
            if (i == 1) {
                return (double) FlexBuffers.j(this.f1227a, this.b, this.c);
            }
            if (i != 2) {
                if (i == 5) {
                    return Double.parseDouble(h());
                }
                if (i == 6) {
                    ReadBuf readBuf = this.f1227a;
                    return (double) FlexBuffers.j(readBuf, FlexBuffers.g(readBuf, this.b, this.c), this.d);
                } else if (i == 7) {
                    ReadBuf readBuf2 = this.f1227a;
                    return (double) FlexBuffers.l(readBuf2, FlexBuffers.g(readBuf2, this.b, this.c), this.d);
                } else if (i == 8) {
                    ReadBuf readBuf3 = this.f1227a;
                    return FlexBuffers.i(readBuf3, FlexBuffers.g(readBuf3, this.b, this.c), this.d);
                } else if (i == 10) {
                    return (double) j().b();
                } else {
                    if (i != 26) {
                        return 0.0d;
                    }
                }
            }
            return (double) FlexBuffers.l(this.f1227a, this.b, this.c);
        }

        public Key e() {
            if (!m()) {
                return Key.c();
            }
            ReadBuf readBuf = this.f1227a;
            return new Key(readBuf, FlexBuffers.g(readBuf, this.b, this.c), this.d);
        }

        public long f() {
            int i = this.e;
            if (i == 1) {
                return FlexBuffers.k(this.f1227a, this.b, this.c);
            }
            if (i == 2) {
                return FlexBuffers.l(this.f1227a, this.b, this.c);
            }
            if (i == 3) {
                return (long) FlexBuffers.i(this.f1227a, this.b, this.c);
            }
            if (i == 5) {
                try {
                    return Long.parseLong(h());
                } catch (NumberFormatException unused) {
                    return 0;
                }
            } else if (i == 6) {
                ReadBuf readBuf = this.f1227a;
                return FlexBuffers.k(readBuf, FlexBuffers.g(readBuf, this.b, this.c), this.d);
            } else if (i == 7) {
                ReadBuf readBuf2 = this.f1227a;
                return FlexBuffers.l(readBuf2, FlexBuffers.g(readBuf2, this.b, this.c), this.c);
            } else if (i == 8) {
                ReadBuf readBuf3 = this.f1227a;
                return (long) FlexBuffers.i(readBuf3, FlexBuffers.g(readBuf3, this.b, this.c), this.d);
            } else if (i == 10) {
                return (long) j().b();
            } else {
                if (i != 26) {
                    return 0;
                }
                return (long) FlexBuffers.j(this.f1227a, this.b, this.c);
            }
        }

        public Map g() {
            if (!n()) {
                return Map.e();
            }
            ReadBuf readBuf = this.f1227a;
            return new Map(readBuf, FlexBuffers.g(readBuf, this.b, this.c), this.d);
        }

        public String h() {
            if (o()) {
                int c2 = FlexBuffers.g(this.f1227a, this.b, this.c);
                ReadBuf readBuf = this.f1227a;
                int i = this.d;
                return this.f1227a.a(c2, (int) FlexBuffers.l(readBuf, c2 - i, i));
            } else if (!m()) {
                return "";
            } else {
                int c3 = FlexBuffers.g(this.f1227a, this.b, this.d);
                int i2 = c3;
                while (this.f1227a.get(i2) != 0) {
                    i2++;
                }
                return this.f1227a.a(c3, i2 - c3);
            }
        }

        public long i() {
            int i = this.e;
            if (i == 2) {
                return FlexBuffers.l(this.f1227a, this.b, this.c);
            }
            if (i == 1) {
                return FlexBuffers.k(this.f1227a, this.b, this.c);
            }
            if (i == 3) {
                return (long) FlexBuffers.i(this.f1227a, this.b, this.c);
            }
            if (i == 10) {
                return (long) j().b();
            }
            if (i == 26) {
                return (long) FlexBuffers.j(this.f1227a, this.b, this.c);
            }
            if (i == 5) {
                return Long.parseLong(h());
            }
            if (i == 6) {
                ReadBuf readBuf = this.f1227a;
                return FlexBuffers.k(readBuf, FlexBuffers.g(readBuf, this.b, this.c), this.d);
            } else if (i == 7) {
                ReadBuf readBuf2 = this.f1227a;
                return FlexBuffers.l(readBuf2, FlexBuffers.g(readBuf2, this.b, this.c), this.d);
            } else if (i != 8) {
                return 0;
            } else {
                ReadBuf readBuf3 = this.f1227a;
                return (long) FlexBuffers.i(readBuf3, FlexBuffers.g(readBuf3, this.b, this.c), this.c);
            }
        }

        public Vector j() {
            if (p()) {
                ReadBuf readBuf = this.f1227a;
                return new Vector(readBuf, FlexBuffers.g(readBuf, this.b, this.c), this.d);
            }
            int i = this.e;
            if (i == 15) {
                ReadBuf readBuf2 = this.f1227a;
                return new TypedVector(readBuf2, FlexBuffers.g(readBuf2, this.b, this.c), this.d, 4);
            } else if (!FlexBuffers.h(i)) {
                return Vector.c();
            } else {
                ReadBuf readBuf3 = this.f1227a;
                return new TypedVector(readBuf3, FlexBuffers.g(readBuf3, this.b, this.c), this.d, FlexBuffers.m(this.e));
            }
        }

        public boolean k() {
            return this.e == 25;
        }

        public boolean l() {
            return this.e == 26;
        }

        public boolean m() {
            return this.e == 4;
        }

        public boolean n() {
            return this.e == 9;
        }

        public boolean o() {
            return this.e == 5;
        }

        public boolean p() {
            int i = this.e;
            return i == 10 || i == 9;
        }

        public StringBuilder q(StringBuilder sb) {
            int i = this.e;
            if (i != 36) {
                switch (i) {
                    case 0:
                        sb.append("null");
                        return sb;
                    case 1:
                    case 6:
                        sb.append(f());
                        return sb;
                    case 2:
                    case 7:
                        sb.append(i());
                        return sb;
                    case 3:
                    case 8:
                        sb.append(d());
                        return sb;
                    case 4:
                        Key e2 = e();
                        sb.append('\"');
                        StringBuilder a2 = e2.a(sb);
                        a2.append('\"');
                        return a2;
                    case 5:
                        sb.append('\"');
                        sb.append(h());
                        sb.append('\"');
                        return sb;
                    case 9:
                        return g().a(sb);
                    case 10:
                        return j().a(sb);
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        break;
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                        throw new FlexBufferException("not_implemented:" + this.e);
                    case 25:
                        return b().a(sb);
                    case 26:
                        sb.append(c());
                        return sb;
                    default:
                        return sb;
                }
            }
            sb.append(j());
            return sb;
        }

        public String toString() {
            return q(new StringBuilder(128)).toString();
        }

        public Reference(ReadBuf readBuf, int i, int i2, int i3, int i4) {
            this.f1227a = readBuf;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
        }
    }

    public static abstract class Sized extends Object {
        public final int d;

        public Sized(ReadBuf readBuf, int i, int i2) {
            super(readBuf, i, i2);
            this.d = FlexBuffers.j(this.f1226a, i - i2, i2);
        }

        public int b() {
            return this.d;
        }
    }

    public static class TypedVector extends Vector {
        public static final TypedVector g = new TypedVector(FlexBuffers.f1224a, 1, 1, 1);
        public final int f;

        public TypedVector(ReadBuf readBuf, int i, int i2, int i3) {
            super(readBuf, i, i2);
            this.f = i3;
        }

        public Reference d(int i) {
            if (i >= b()) {
                return Reference.f;
            }
            return new Reference(this.f1226a, this.b + (i * this.c), this.c, 1, this.f);
        }
    }

    public static class Unsigned {
        public static int a(byte b) {
            return b & 255;
        }

        public static long b(int i) {
            return ((long) i) & 4294967295L;
        }

        public static int c(short s) {
            return s & UShort.MAX_VALUE;
        }
    }

    public static class Vector extends Sized {
        public static final Vector e = new Vector(FlexBuffers.f1224a, 1, 1);

        public Vector(ReadBuf readBuf, int i, int i2) {
            super(readBuf, i, i2);
        }

        public static Vector c() {
            return e;
        }

        public StringBuilder a(StringBuilder sb) {
            sb.append("[ ");
            int b = b();
            for (int i = 0; i < b; i++) {
                d(i).q(sb);
                if (i != b - 1) {
                    sb.append(", ");
                }
            }
            sb.append(" ]");
            return sb;
        }

        public /* bridge */ /* synthetic */ int b() {
            return super.b();
        }

        public Reference d(int i) {
            long b = (long) b();
            long j = (long) i;
            if (j >= b) {
                return Reference.f;
            }
            int a2 = Unsigned.a(this.f1226a.get((int) (((long) this.b) + (b * ((long) this.c)) + j)));
            return new Reference(this.f1226a, this.b + (i * this.c), this.c, a2);
        }

        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }
    }

    public static int g(ReadBuf readBuf, int i, int i2) {
        return (int) (((long) i) - l(readBuf, i, i2));
    }

    public static boolean h(int i) {
        return (i >= 11 && i <= 15) || i == 36;
    }

    public static double i(ReadBuf readBuf, int i, int i2) {
        if (i2 == 4) {
            return (double) readBuf.getFloat(i);
        }
        if (i2 != 8) {
            return -1.0d;
        }
        return readBuf.getDouble(i);
    }

    public static int j(ReadBuf readBuf, int i, int i2) {
        return (int) k(readBuf, i, i2);
    }

    public static long k(ReadBuf readBuf, int i, int i2) {
        int i3;
        if (i2 == 1) {
            i3 = readBuf.get(i);
        } else if (i2 == 2) {
            i3 = readBuf.getShort(i);
        } else if (i2 == 4) {
            i3 = readBuf.getInt(i);
        } else if (i2 != 8) {
            return -1;
        } else {
            return readBuf.getLong(i);
        }
        return (long) i3;
    }

    public static long l(ReadBuf readBuf, int i, int i2) {
        if (i2 == 1) {
            return (long) Unsigned.a(readBuf.get(i));
        }
        if (i2 == 2) {
            return (long) Unsigned.c(readBuf.getShort(i));
        }
        if (i2 == 4) {
            return Unsigned.b(readBuf.getInt(i));
        }
        if (i2 != 8) {
            return -1;
        }
        return readBuf.getLong(i);
    }

    public static int m(int i) {
        return i - 10;
    }
}
