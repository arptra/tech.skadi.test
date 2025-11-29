package com.tencent.bugly.proguard;

import com.here.posclient.UpdateOptions;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public ByteBuffer f9584a;
    protected String b;

    public l(int i) {
        this.b = "GBK";
        this.f9584a = ByteBuffer.allocate(i);
    }

    private void a(int i) {
        if (this.f9584a.remaining() < i) {
            ByteBuffer allocate = ByteBuffer.allocate((this.f9584a.capacity() + i) * 2);
            allocate.put(this.f9584a.array(), 0, this.f9584a.position());
            this.f9584a = allocate;
        }
    }

    private void b(byte b2, int i) {
        if (i < 15) {
            this.f9584a.put((byte) (b2 | (i << 4)));
        } else if (i < 256) {
            this.f9584a.put((byte) (b2 | 240));
            this.f9584a.put((byte) i);
        } else {
            throw new j("tag is too large: ".concat(String.valueOf(i)));
        }
    }

    public l() {
        this(128);
    }

    public final void a(boolean z, int i) {
        a(z ? (byte) 1 : 0, i);
    }

    public final void a(byte b2, int i) {
        a(3);
        if (b2 == 0) {
            b((byte) 12, i);
            return;
        }
        b((byte) 0, i);
        this.f9584a.put(b2);
    }

    public final void a(short s, int i) {
        a(4);
        if (s < -128 || s > 127) {
            b((byte) 1, i);
            this.f9584a.putShort(s);
            return;
        }
        a((byte) s, i);
    }

    public final void a(int i, int i2) {
        a(6);
        if (i < -32768 || i > 32767) {
            b((byte) 2, i2);
            this.f9584a.putInt(i);
            return;
        }
        a((short) i, i2);
    }

    public final void a(long j, int i) {
        a(10);
        if (j < -2147483648L || j > UpdateOptions.SOURCE_ANY) {
            b((byte) 3, i);
            this.f9584a.putLong(j);
            return;
        }
        a((int) j, i);
    }

    private void a(float f, int i) {
        a(6);
        b((byte) 4, i);
        this.f9584a.putFloat(f);
    }

    private void a(double d, int i) {
        a(10);
        b((byte) 5, i);
        this.f9584a.putDouble(d);
    }

    public final void a(String str, int i) {
        byte[] bArr;
        try {
            bArr = str.getBytes(this.b);
        } catch (UnsupportedEncodingException unused) {
            bArr = str.getBytes();
        }
        a(bArr.length + 10);
        if (bArr.length > 255) {
            b((byte) 7, i);
            this.f9584a.putInt(bArr.length);
            this.f9584a.put(bArr);
            return;
        }
        b((byte) 6, i);
        this.f9584a.put((byte) bArr.length);
        this.f9584a.put(bArr);
    }

    public final <K, V> void a(Map<K, V> map, int i) {
        int i2;
        a(8);
        b((byte) 8, i);
        if (map == null) {
            i2 = 0;
        } else {
            i2 = map.size();
        }
        a(i2, 0);
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                a(next.getKey(), 0);
                a(next.getValue(), 1);
            }
        }
    }

    private void a(boolean[] zArr, int i) {
        a(8);
        b((byte) 9, i);
        a(zArr.length, 0);
        for (boolean a2 : zArr) {
            a(a2, 0);
        }
    }

    public final void a(byte[] bArr, int i) {
        a(bArr.length + 8);
        b((byte) 13, i);
        b((byte) 0, 0);
        a(bArr.length, 0);
        this.f9584a.put(bArr);
    }

    private void a(short[] sArr, int i) {
        a(8);
        b((byte) 9, i);
        a(sArr.length, 0);
        for (short a2 : sArr) {
            a(a2, 0);
        }
    }

    private void a(int[] iArr, int i) {
        a(8);
        b((byte) 9, i);
        a(iArr.length, 0);
        for (int a2 : iArr) {
            a(a2, 0);
        }
    }

    private void a(long[] jArr, int i) {
        a(8);
        b((byte) 9, i);
        a(jArr.length, 0);
        for (long a2 : jArr) {
            a(a2, 0);
        }
    }

    private void a(float[] fArr, int i) {
        a(8);
        b((byte) 9, i);
        a(fArr.length, 0);
        for (float a2 : fArr) {
            a(a2, 0);
        }
    }

    private void a(double[] dArr, int i) {
        a(8);
        b((byte) 9, i);
        a(dArr.length, 0);
        for (double a2 : dArr) {
            a(a2, 0);
        }
    }

    private void a(Object[] objArr, int i) {
        a(8);
        b((byte) 9, i);
        a(objArr.length, 0);
        for (Object a2 : objArr) {
            a(a2, 0);
        }
    }

    public final <T> void a(Collection<T> collection, int i) {
        int i2;
        a(8);
        b((byte) 9, i);
        if (collection == null) {
            i2 = 0;
        } else {
            i2 = collection.size();
        }
        a(i2, 0);
        if (collection != null) {
            for (T a2 : collection) {
                a((Object) a2, 0);
            }
        }
    }

    public final void a(m mVar, int i) {
        a(2);
        b((byte) 10, i);
        mVar.a(this);
        a(2);
        b((byte) 11, 0);
    }

    public final void a(Object obj, int i) {
        if (obj instanceof Byte) {
            a(((Byte) obj).byteValue(), i);
        } else if (obj instanceof Boolean) {
            a(((Boolean) obj).booleanValue(), i);
        } else if (obj instanceof Short) {
            a(((Short) obj).shortValue(), i);
        } else if (obj instanceof Integer) {
            a(((Integer) obj).intValue(), i);
        } else if (obj instanceof Long) {
            a(((Long) obj).longValue(), i);
        } else if (obj instanceof Float) {
            a(((Float) obj).floatValue(), i);
        } else if (obj instanceof Double) {
            a(((Double) obj).doubleValue(), i);
        } else if (obj instanceof String) {
            a((String) obj, i);
        } else if (obj instanceof Map) {
            a((Map) obj, i);
        } else if (obj instanceof List) {
            a((List) obj, i);
        } else if (obj instanceof m) {
            a((m) obj, i);
        } else if (obj instanceof byte[]) {
            a((byte[]) obj, i);
        } else if (obj instanceof boolean[]) {
            a((boolean[]) obj, i);
        } else if (obj instanceof short[]) {
            a((short[]) obj, i);
        } else if (obj instanceof int[]) {
            a((int[]) obj, i);
        } else if (obj instanceof long[]) {
            a((long[]) obj, i);
        } else if (obj instanceof float[]) {
            a((float[]) obj, i);
        } else if (obj instanceof double[]) {
            a((double[]) obj, i);
        } else if (obj.getClass().isArray()) {
            a((Object[]) obj, i);
        } else if (obj instanceof Collection) {
            a((Collection) obj, i);
        } else {
            throw new j("write object error: unsupport type. " + obj.getClass());
        }
    }

    public final int a(String str) {
        this.b = str;
        return 0;
    }
}
