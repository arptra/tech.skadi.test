package androidx.datastore.preferences.protobuf;

import com.meizu.common.widget.MzContactsContract;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

final class UnsafeUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f1158a = Logger.getLogger(UnsafeUtil.class.getName());
    public static final Unsafe b = G();
    public static final Class c = Android.b();
    public static final boolean d = p(Long.TYPE);
    public static final boolean e = p(Integer.TYPE);
    public static final MemoryAccessor f = E();
    public static final boolean g = X();
    public static final boolean h = W();
    public static final long i;
    public static final long j;
    public static final long k;
    public static final long l;
    public static final long m;
    public static final long n;
    public static final long o;
    public static final long p;
    public static final long q;
    public static final long r;
    public static final long s;
    public static final long t;
    public static final long u;
    public static final long v = r(m());
    public static final int w;
    public static final boolean x = (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN);

    public static final class Android32MemoryAccessor extends MemoryAccessor {
        public Android32MemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        public void c(long j, byte[] bArr, long j2, long j3) {
            throw new UnsupportedOperationException();
        }

        public void d(byte[] bArr, long j, long j2, long j3) {
            throw new UnsupportedOperationException();
        }

        public boolean e(Object obj, long j) {
            return UnsafeUtil.x ? UnsafeUtil.t(obj, j) : UnsafeUtil.u(obj, j);
        }

        public byte f(long j) {
            throw new UnsupportedOperationException();
        }

        public byte g(Object obj, long j) {
            return UnsafeUtil.x ? UnsafeUtil.x(obj, j) : UnsafeUtil.y(obj, j);
        }

        public double h(Object obj, long j) {
            return Double.longBitsToDouble(l(obj, j));
        }

        public float i(Object obj, long j) {
            return Float.intBitsToFloat(j(obj, j));
        }

        public long k(long j) {
            throw new UnsupportedOperationException();
        }

        public void o(Object obj, long j, boolean z) {
            if (UnsafeUtil.x) {
                UnsafeUtil.L(obj, j, z);
            } else {
                UnsafeUtil.M(obj, j, z);
            }
        }

        public void p(long j, byte b) {
            throw new UnsupportedOperationException();
        }

        public void q(Object obj, long j, byte b) {
            if (UnsafeUtil.x) {
                UnsafeUtil.P(obj, j, b);
            } else {
                UnsafeUtil.Q(obj, j, b);
            }
        }

        public void r(Object obj, long j, double d) {
            u(obj, j, Double.doubleToLongBits(d));
        }

        public void s(Object obj, long j, float f) {
            t(obj, j, Float.floatToIntBits(f));
        }
    }

    public static final class Android64MemoryAccessor extends MemoryAccessor {
        public Android64MemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        public void c(long j, byte[] bArr, long j2, long j3) {
            throw new UnsupportedOperationException();
        }

        public void d(byte[] bArr, long j, long j2, long j3) {
            throw new UnsupportedOperationException();
        }

        public boolean e(Object obj, long j) {
            return UnsafeUtil.x ? UnsafeUtil.t(obj, j) : UnsafeUtil.u(obj, j);
        }

        public byte f(long j) {
            throw new UnsupportedOperationException();
        }

        public byte g(Object obj, long j) {
            return UnsafeUtil.x ? UnsafeUtil.x(obj, j) : UnsafeUtil.y(obj, j);
        }

        public double h(Object obj, long j) {
            return Double.longBitsToDouble(l(obj, j));
        }

        public float i(Object obj, long j) {
            return Float.intBitsToFloat(j(obj, j));
        }

        public long k(long j) {
            throw new UnsupportedOperationException();
        }

        public void o(Object obj, long j, boolean z) {
            if (UnsafeUtil.x) {
                UnsafeUtil.L(obj, j, z);
            } else {
                UnsafeUtil.M(obj, j, z);
            }
        }

        public void p(long j, byte b) {
            throw new UnsupportedOperationException();
        }

        public void q(Object obj, long j, byte b) {
            if (UnsafeUtil.x) {
                UnsafeUtil.P(obj, j, b);
            } else {
                UnsafeUtil.Q(obj, j, b);
            }
        }

        public void r(Object obj, long j, double d) {
            u(obj, j, Double.doubleToLongBits(d));
        }

        public void s(Object obj, long j, float f) {
            t(obj, j, Float.floatToIntBits(f));
        }
    }

    public static final class JvmMemoryAccessor extends MemoryAccessor {
        public JvmMemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        public void c(long j, byte[] bArr, long j2, long j3) {
            this.f1159a.copyMemory((Object) null, j, bArr, UnsafeUtil.i + j2, j3);
        }

        public void d(byte[] bArr, long j, long j2, long j3) {
            this.f1159a.copyMemory(bArr, UnsafeUtil.i + j, (Object) null, j2, j3);
        }

        public boolean e(Object obj, long j) {
            return this.f1159a.getBoolean(obj, j);
        }

        public byte f(long j) {
            return this.f1159a.getByte(j);
        }

        public byte g(Object obj, long j) {
            return this.f1159a.getByte(obj, j);
        }

        public double h(Object obj, long j) {
            return this.f1159a.getDouble(obj, j);
        }

        public float i(Object obj, long j) {
            return this.f1159a.getFloat(obj, j);
        }

        public long k(long j) {
            return this.f1159a.getLong(j);
        }

        public void o(Object obj, long j, boolean z) {
            this.f1159a.putBoolean(obj, j, z);
        }

        public void p(long j, byte b) {
            this.f1159a.putByte(j, b);
        }

        public void q(Object obj, long j, byte b) {
            this.f1159a.putByte(obj, j, b);
        }

        public void r(Object obj, long j, double d) {
            this.f1159a.putDouble(obj, j, d);
        }

        public void s(Object obj, long j, float f) {
            this.f1159a.putFloat(obj, j, f);
        }
    }

    public static abstract class MemoryAccessor {

        /* renamed from: a  reason: collision with root package name */
        public Unsafe f1159a;

        public MemoryAccessor(Unsafe unsafe) {
            this.f1159a = unsafe;
        }

        public final int a(Class cls) {
            return this.f1159a.arrayBaseOffset(cls);
        }

        public final int b(Class cls) {
            return this.f1159a.arrayIndexScale(cls);
        }

        public abstract void c(long j, byte[] bArr, long j2, long j3);

        public abstract void d(byte[] bArr, long j, long j2, long j3);

        public abstract boolean e(Object obj, long j);

        public abstract byte f(long j);

        public abstract byte g(Object obj, long j);

        public abstract double h(Object obj, long j);

        public abstract float i(Object obj, long j);

        public final int j(Object obj, long j) {
            return this.f1159a.getInt(obj, j);
        }

        public abstract long k(long j);

        public final long l(Object obj, long j) {
            return this.f1159a.getLong(obj, j);
        }

        public final Object m(Object obj, long j) {
            return this.f1159a.getObject(obj, j);
        }

        public final long n(Field field) {
            return this.f1159a.objectFieldOffset(field);
        }

        public abstract void o(Object obj, long j, boolean z);

        public abstract void p(long j, byte b);

        public abstract void q(Object obj, long j, byte b);

        public abstract void r(Object obj, long j, double d);

        public abstract void s(Object obj, long j, float f);

        public final void t(Object obj, long j, int i) {
            this.f1159a.putInt(obj, j, i);
        }

        public final void u(Object obj, long j, long j2) {
            this.f1159a.putLong(obj, j, j2);
        }

        public final void v(Object obj, long j, Object obj2) {
            this.f1159a.putObject(obj, j, obj2);
        }
    }

    static {
        long k2 = (long) k(byte[].class);
        i = k2;
        Class<boolean[]> cls = boolean[].class;
        j = (long) k(cls);
        k = (long) l(cls);
        Class<int[]> cls2 = int[].class;
        l = (long) k(cls2);
        m = (long) l(cls2);
        Class<long[]> cls3 = long[].class;
        n = (long) k(cls3);
        o = (long) l(cls3);
        Class<float[]> cls4 = float[].class;
        p = (long) k(cls4);
        q = (long) l(cls4);
        Class<double[]> cls5 = double[].class;
        r = (long) k(cls5);
        s = (long) l(cls5);
        Class<Object[]> cls6 = Object[].class;
        t = (long) k(cls6);
        u = (long) l(cls6);
        w = (int) (k2 & 7);
    }

    public static float A(Object obj, long j2) {
        return f.i(obj, j2);
    }

    public static int B(Object obj, long j2) {
        return f.j(obj, j2);
    }

    public static long C(long j2) {
        return f.k(j2);
    }

    public static long D(Object obj, long j2) {
        return f.l(obj, j2);
    }

    public static MemoryAccessor E() {
        Unsafe unsafe = b;
        if (unsafe == null) {
            return null;
        }
        if (!Android.c()) {
            return new JvmMemoryAccessor(unsafe);
        }
        if (d) {
            return new Android64MemoryAccessor(unsafe);
        }
        if (e) {
            return new Android32MemoryAccessor(unsafe);
        }
        return null;
    }

    public static Object F(Object obj, long j2) {
        return f.m(obj, j2);
    }

    public static Unsafe G() {
        try {
            return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() {
                /* renamed from: a */
                public Unsafe run() {
                    Class<Unsafe> cls = Unsafe.class;
                    for (Field field : cls.getDeclaredFields()) {
                        field.setAccessible(true);
                        Object obj = field.get((Object) null);
                        if (cls.isInstance(obj)) {
                            return cls.cast(obj);
                        }
                    }
                    return null;
                }
            });
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean H() {
        return h;
    }

    public static boolean I() {
        return g;
    }

    public static long J(Field field) {
        return f.n(field);
    }

    public static void K(Object obj, long j2, boolean z) {
        f.o(obj, j2, z);
    }

    public static void L(Object obj, long j2, boolean z) {
        P(obj, j2, z ? (byte) 1 : 0);
    }

    public static void M(Object obj, long j2, boolean z) {
        Q(obj, j2, z ? (byte) 1 : 0);
    }

    public static void N(long j2, byte b2) {
        f.p(j2, b2);
    }

    public static void O(byte[] bArr, long j2, byte b2) {
        f.q(bArr, i + j2, b2);
    }

    public static void P(Object obj, long j2, byte b2) {
        long j3 = -4 & j2;
        int B = B(obj, j3);
        int i2 = ((~((int) j2)) & 3) << 3;
        T(obj, j3, ((255 & b2) << i2) | (B & (~(255 << i2))));
    }

    public static void Q(Object obj, long j2, byte b2) {
        long j3 = -4 & j2;
        int i2 = (((int) j2) & 3) << 3;
        T(obj, j3, ((255 & b2) << i2) | (B(obj, j3) & (~(255 << i2))));
    }

    public static void R(Object obj, long j2, double d2) {
        f.r(obj, j2, d2);
    }

    public static void S(Object obj, long j2, float f2) {
        f.s(obj, j2, f2);
    }

    public static void T(Object obj, long j2, int i2) {
        f.t(obj, j2, i2);
    }

    public static void U(Object obj, long j2, long j3) {
        f.u(obj, j2, j3);
    }

    public static void V(Object obj, long j2, Object obj2) {
        f.v(obj, j2, obj2);
    }

    public static boolean W() {
        Class<Class> cls = Class.class;
        Class<Object> cls2 = Object.class;
        Unsafe unsafe = b;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls3 = unsafe.getClass();
            cls3.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls3.getMethod("arrayBaseOffset", new Class[]{cls});
            cls3.getMethod("arrayIndexScale", new Class[]{cls});
            Class cls4 = Long.TYPE;
            cls3.getMethod("getInt", new Class[]{cls2, cls4});
            cls3.getMethod("putInt", new Class[]{cls2, cls4, Integer.TYPE});
            cls3.getMethod("getLong", new Class[]{cls2, cls4});
            cls3.getMethod("putLong", new Class[]{cls2, cls4, cls4});
            cls3.getMethod("getObject", new Class[]{cls2, cls4});
            cls3.getMethod("putObject", new Class[]{cls2, cls4, cls2});
            if (Android.c()) {
                return true;
            }
            cls3.getMethod("getByte", new Class[]{cls2, cls4});
            cls3.getMethod("putByte", new Class[]{cls2, cls4, Byte.TYPE});
            cls3.getMethod("getBoolean", new Class[]{cls2, cls4});
            cls3.getMethod("putBoolean", new Class[]{cls2, cls4, Boolean.TYPE});
            cls3.getMethod("getFloat", new Class[]{cls2, cls4});
            cls3.getMethod("putFloat", new Class[]{cls2, cls4, Float.TYPE});
            cls3.getMethod("getDouble", new Class[]{cls2, cls4});
            cls3.getMethod("putDouble", new Class[]{cls2, cls4, Double.TYPE});
            return true;
        } catch (Throwable th) {
            Logger logger = f1158a;
            Level level = Level.WARNING;
            logger.log(level, "platform method missing - proto runtime falling back to safer methods: " + th);
            return false;
        }
    }

    public static boolean X() {
        Class<Object> cls = Object.class;
        Unsafe unsafe = b;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls2 = unsafe.getClass();
            cls2.getMethod("objectFieldOffset", new Class[]{Field.class});
            Class cls3 = Long.TYPE;
            cls2.getMethod("getLong", new Class[]{cls, cls3});
            if (m() == null) {
                return false;
            }
            if (Android.c()) {
                return true;
            }
            cls2.getMethod("getByte", new Class[]{cls3});
            cls2.getMethod("putByte", new Class[]{cls3, Byte.TYPE});
            cls2.getMethod("getInt", new Class[]{cls3});
            cls2.getMethod("putInt", new Class[]{cls3, Integer.TYPE});
            cls2.getMethod("getLong", new Class[]{cls3});
            cls2.getMethod("putLong", new Class[]{cls3, cls3});
            cls2.getMethod("copyMemory", new Class[]{cls3, cls3, cls3});
            cls2.getMethod("copyMemory", new Class[]{cls, cls3, cls, cls3, cls3});
            return true;
        } catch (Throwable th) {
            Logger logger = f1158a;
            Level level = Level.WARNING;
            logger.log(level, "platform method missing - proto runtime falling back to safer methods: " + th);
            return false;
        }
    }

    public static long i(ByteBuffer byteBuffer) {
        return f.l(byteBuffer, v);
    }

    public static Object j(Class cls) {
        try {
            return b.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static int k(Class cls) {
        if (h) {
            return f.a(cls);
        }
        return -1;
    }

    public static int l(Class cls) {
        if (h) {
            return f.b(cls);
        }
        return -1;
    }

    public static Field m() {
        Field q2;
        Class<Buffer> cls = Buffer.class;
        if (Android.c() && (q2 = q(cls, "effectiveDirectAddress")) != null) {
            return q2;
        }
        Field q3 = q(cls, MzContactsContract.MzContactColumns.ADDRESS);
        if (q3 == null || q3.getType() != Long.TYPE) {
            return null;
        }
        return q3;
    }

    public static void n(long j2, byte[] bArr, long j3, long j4) {
        f.c(j2, bArr, j3, j4);
    }

    public static void o(byte[] bArr, long j2, long j3, long j4) {
        f.d(bArr, j2, j3, j4);
    }

    public static boolean p(Class cls) {
        Class<byte[]> cls2 = byte[].class;
        if (!Android.c()) {
            return false;
        }
        try {
            Class cls3 = c;
            Class cls4 = Boolean.TYPE;
            cls3.getMethod("peekLong", new Class[]{cls, cls4});
            cls3.getMethod("pokeLong", new Class[]{cls, Long.TYPE, cls4});
            Class cls5 = Integer.TYPE;
            cls3.getMethod("pokeInt", new Class[]{cls, cls5, cls4});
            cls3.getMethod("peekInt", new Class[]{cls, cls4});
            cls3.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls3.getMethod("peekByte", new Class[]{cls});
            cls3.getMethod("pokeByteArray", new Class[]{cls, cls2, cls5, cls5});
            cls3.getMethod("peekByteArray", new Class[]{cls, cls2, cls5, cls5});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static Field q(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static long r(Field field) {
        MemoryAccessor memoryAccessor;
        if (field == null || (memoryAccessor = f) == null) {
            return -1;
        }
        return memoryAccessor.n(field);
    }

    public static boolean s(Object obj, long j2) {
        return f.e(obj, j2);
    }

    public static boolean t(Object obj, long j2) {
        return x(obj, j2) != 0;
    }

    public static boolean u(Object obj, long j2) {
        return y(obj, j2) != 0;
    }

    public static byte v(long j2) {
        return f.f(j2);
    }

    public static byte w(byte[] bArr, long j2) {
        return f.g(bArr, i + j2);
    }

    public static byte x(Object obj, long j2) {
        return (byte) ((B(obj, -4 & j2) >>> ((int) (((~j2) & 3) << 3))) & 255);
    }

    public static byte y(Object obj, long j2) {
        return (byte) ((B(obj, -4 & j2) >>> ((int) ((j2 & 3) << 3))) & 255);
    }

    public static double z(Object obj, long j2) {
        return f.h(obj, j2);
    }
}
