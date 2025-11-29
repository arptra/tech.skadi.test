package com.tencent.bugly.proguard;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    private StringBuilder f9581a;
    private int b;

    public i(StringBuilder sb, int i) {
        this.f9581a = sb;
        this.b = i;
    }

    private void a(String str) {
        for (int i = 0; i < this.b; i++) {
            this.f9581a.append(9);
        }
        if (str != null) {
            StringBuilder sb = this.f9581a;
            sb.append(str);
            sb.append(": ");
        }
    }

    public final i a(boolean z, String str) {
        a(str);
        StringBuilder sb = this.f9581a;
        sb.append(z ? 'T' : 'F');
        sb.append(10);
        return this;
    }

    public final i a(byte b2, String str) {
        a(str);
        StringBuilder sb = this.f9581a;
        sb.append(b2);
        sb.append(10);
        return this;
    }

    private i a(char c, String str) {
        a(str);
        StringBuilder sb = this.f9581a;
        sb.append(c);
        sb.append(10);
        return this;
    }

    public final i a(short s, String str) {
        a(str);
        StringBuilder sb = this.f9581a;
        sb.append(s);
        sb.append(10);
        return this;
    }

    public final i a(int i, String str) {
        a(str);
        StringBuilder sb = this.f9581a;
        sb.append(i);
        sb.append(10);
        return this;
    }

    public final i a(long j, String str) {
        a(str);
        StringBuilder sb = this.f9581a;
        sb.append(j);
        sb.append(10);
        return this;
    }

    private i a(float f, String str) {
        a(str);
        StringBuilder sb = this.f9581a;
        sb.append(f);
        sb.append(10);
        return this;
    }

    private i a(double d, String str) {
        a(str);
        StringBuilder sb = this.f9581a;
        sb.append(d);
        sb.append(10);
        return this;
    }

    public final i a(String str, String str2) {
        a(str2);
        if (str == null) {
            this.f9581a.append("null\n");
        } else {
            StringBuilder sb = this.f9581a;
            sb.append(str);
            sb.append(10);
        }
        return this;
    }

    public final i a(byte[] bArr, String str) {
        a(str);
        if (bArr == null) {
            this.f9581a.append("null\n");
            return this;
        } else if (bArr.length == 0) {
            StringBuilder sb = this.f9581a;
            sb.append(bArr.length);
            sb.append(", []\n");
            return this;
        } else {
            StringBuilder sb2 = this.f9581a;
            sb2.append(bArr.length);
            sb2.append(", [\n");
            i iVar = new i(this.f9581a, this.b + 1);
            for (byte a2 : bArr) {
                iVar.a(a2, (String) null);
            }
            a(']', (String) null);
            return this;
        }
    }

    private i a(short[] sArr, String str) {
        a(str);
        if (sArr == null) {
            this.f9581a.append("null\n");
            return this;
        } else if (sArr.length == 0) {
            StringBuilder sb = this.f9581a;
            sb.append(sArr.length);
            sb.append(", []\n");
            return this;
        } else {
            StringBuilder sb2 = this.f9581a;
            sb2.append(sArr.length);
            sb2.append(", [\n");
            i iVar = new i(this.f9581a, this.b + 1);
            for (short a2 : sArr) {
                iVar.a(a2, (String) null);
            }
            a(']', (String) null);
            return this;
        }
    }

    private i a(int[] iArr, String str) {
        a(str);
        if (iArr == null) {
            this.f9581a.append("null\n");
            return this;
        } else if (iArr.length == 0) {
            StringBuilder sb = this.f9581a;
            sb.append(iArr.length);
            sb.append(", []\n");
            return this;
        } else {
            StringBuilder sb2 = this.f9581a;
            sb2.append(iArr.length);
            sb2.append(", [\n");
            i iVar = new i(this.f9581a, this.b + 1);
            for (int a2 : iArr) {
                iVar.a(a2, (String) null);
            }
            a(']', (String) null);
            return this;
        }
    }

    private i a(long[] jArr, String str) {
        a(str);
        if (jArr == null) {
            this.f9581a.append("null\n");
            return this;
        } else if (jArr.length == 0) {
            StringBuilder sb = this.f9581a;
            sb.append(jArr.length);
            sb.append(", []\n");
            return this;
        } else {
            StringBuilder sb2 = this.f9581a;
            sb2.append(jArr.length);
            sb2.append(", [\n");
            i iVar = new i(this.f9581a, this.b + 1);
            for (long a2 : jArr) {
                iVar.a(a2, (String) null);
            }
            a(']', (String) null);
            return this;
        }
    }

    private i a(float[] fArr, String str) {
        a(str);
        if (fArr == null) {
            this.f9581a.append("null\n");
            return this;
        } else if (fArr.length == 0) {
            StringBuilder sb = this.f9581a;
            sb.append(fArr.length);
            sb.append(", []\n");
            return this;
        } else {
            StringBuilder sb2 = this.f9581a;
            sb2.append(fArr.length);
            sb2.append(", [\n");
            i iVar = new i(this.f9581a, this.b + 1);
            for (float a2 : fArr) {
                iVar.a(a2, (String) null);
            }
            a(']', (String) null);
            return this;
        }
    }

    private i a(double[] dArr, String str) {
        a(str);
        if (dArr == null) {
            this.f9581a.append("null\n");
            return this;
        } else if (dArr.length == 0) {
            StringBuilder sb = this.f9581a;
            sb.append(dArr.length);
            sb.append(", []\n");
            return this;
        } else {
            StringBuilder sb2 = this.f9581a;
            sb2.append(dArr.length);
            sb2.append(", [\n");
            i iVar = new i(this.f9581a, this.b + 1);
            for (double a2 : dArr) {
                iVar.a(a2, (String) null);
            }
            a(']', (String) null);
            return this;
        }
    }

    public final <K, V> i a(Map<K, V> map, String str) {
        a(str);
        if (map == null) {
            this.f9581a.append("null\n");
            return this;
        } else if (map.isEmpty()) {
            StringBuilder sb = this.f9581a;
            sb.append(map.size());
            sb.append(", {}\n");
            return this;
        } else {
            StringBuilder sb2 = this.f9581a;
            sb2.append(map.size());
            sb2.append(", {\n");
            i iVar = new i(this.f9581a, this.b + 1);
            i iVar2 = new i(this.f9581a, this.b + 2);
            for (Map.Entry next : map.entrySet()) {
                iVar.a('(', (String) null);
                iVar2.a(next.getKey(), (String) null);
                iVar2.a(next.getValue(), (String) null);
                iVar.a(')', (String) null);
            }
            a('}', (String) null);
            return this;
        }
    }

    private <T> i a(T[] tArr, String str) {
        a(str);
        if (tArr == null) {
            this.f9581a.append("null\n");
            return this;
        } else if (tArr.length == 0) {
            StringBuilder sb = this.f9581a;
            sb.append(tArr.length);
            sb.append(", []\n");
            return this;
        } else {
            StringBuilder sb2 = this.f9581a;
            sb2.append(tArr.length);
            sb2.append(", [\n");
            i iVar = new i(this.f9581a, this.b + 1);
            for (T a2 : tArr) {
                iVar.a(a2, (String) null);
            }
            a(']', (String) null);
            return this;
        }
    }

    private <T> i a(Collection<T> collection, String str) {
        if (collection != null) {
            return a((T[]) collection.toArray(), str);
        }
        a(str);
        this.f9581a.append("null\t");
        return this;
    }

    private <T> i a(T t, String str) {
        if (t == null) {
            this.f9581a.append("null\n");
        } else if (t instanceof Byte) {
            a(((Byte) t).byteValue(), str);
        } else if (t instanceof Boolean) {
            a(((Boolean) t).booleanValue(), str);
        } else if (t instanceof Short) {
            a(((Short) t).shortValue(), str);
        } else if (t instanceof Integer) {
            a(((Integer) t).intValue(), str);
        } else if (t instanceof Long) {
            a(((Long) t).longValue(), str);
        } else if (t instanceof Float) {
            a(((Float) t).floatValue(), str);
        } else if (t instanceof Double) {
            a(((Double) t).doubleValue(), str);
        } else if (t instanceof String) {
            a((String) t, str);
        } else if (t instanceof Map) {
            a((Map) t, str);
        } else if (t instanceof List) {
            a((List) t, str);
        } else if (t instanceof m) {
            a((m) t, str);
        } else if (t instanceof byte[]) {
            a((byte[]) t, str);
        } else if (t instanceof boolean[]) {
            a((boolean[]) t, str);
        } else if (t instanceof short[]) {
            a((short[]) t, str);
        } else if (t instanceof int[]) {
            a((int[]) t, str);
        } else if (t instanceof long[]) {
            a((long[]) t, str);
        } else if (t instanceof float[]) {
            a((float[]) t, str);
        } else if (t instanceof double[]) {
            a((double[]) t, str);
        } else if (t.getClass().isArray()) {
            a((T[]) (Object[]) t, str);
        } else {
            throw new j("write object error: unsupport type.");
        }
        return this;
    }

    public final i a(m mVar, String str) {
        a('{', str);
        if (mVar == null) {
            StringBuilder sb = this.f9581a;
            sb.append(9);
            sb.append("null");
        } else {
            mVar.a(this.f9581a, this.b + 1);
        }
        a('}', (String) null);
        return this;
    }
}
