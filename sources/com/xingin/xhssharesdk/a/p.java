package com.xingin.xhssharesdk.a;

import com.xingin.xhssharesdk.a.c0;
import com.xingin.xhssharesdk.a.e;
import com.xingin.xhssharesdk.a.k;
import java.io.IOException;

public final class p<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public final a f8144a;
    public final Object b = "";
    public final Object c = "";

    public static class a<K, V> {

        /* renamed from: a  reason: collision with root package name */
        public final c0.a f8145a;
        public final Object b = "";
        public final c0.a c;
        public final Object d;

        public a(c0.a.C0027a aVar, c0.a.C0027a aVar2) {
            this.f8145a = aVar;
            this.c = aVar2;
            this.d = "";
        }
    }

    public p(c0.a.C0027a aVar, c0.a.C0027a aVar2) {
        this.f8144a = new a(aVar, aVar2);
    }

    public static Object a(f fVar, i iVar, c0.a aVar, Object obj) {
        boolean z = true;
        int ordinal = aVar.ordinal();
        if (ordinal == 9) {
            throw new RuntimeException("Groups are not allowed in maps.");
        } else if (ordinal == 10) {
            k.a d = ((r) obj).d();
            int e = fVar.e();
            if (fVar.h < 100) {
                int c2 = fVar.c(e);
                fVar.h++;
                d.f();
                try {
                    d.b.e(k.h.c, fVar, iVar);
                    if (fVar.e == 0) {
                        fVar.h--;
                        fVar.g = c2;
                        fVar.m();
                        if (!d.c) {
                            d.b.i();
                            d.c = true;
                        }
                        return d.b;
                    }
                    throw new m("Protocol message end-group tag did not match expected tag.");
                } catch (RuntimeException e2) {
                    if (e2.getCause() instanceof IOException) {
                        throw ((IOException) e2.getCause());
                    }
                    throw e2;
                }
            } else {
                throw new m("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
            }
        } else if (ordinal == 13) {
            return Integer.valueOf(fVar.e());
        } else {
            int i = j.d;
            c0.c.b bVar = c0.c.f8126a;
            switch (aVar.ordinal()) {
                case 0:
                    return Double.valueOf(Double.longBitsToDouble(fVar.d()));
                case 1:
                    return Float.valueOf(Float.intBitsToFloat(fVar.a()));
                case 2:
                    return Long.valueOf(fVar.g());
                case 3:
                    return Long.valueOf(fVar.g());
                case 4:
                    return Integer.valueOf(fVar.e());
                case 5:
                    return Long.valueOf(fVar.d());
                case 6:
                    return Integer.valueOf(fVar.a());
                case 7:
                    if (fVar.g() == 0) {
                        z = false;
                    }
                    return Boolean.valueOf(z);
                case 8:
                    return bVar.a(fVar);
                case 9:
                    throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
                case 10:
                    throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
                case 11:
                    int e3 = fVar.e();
                    int i2 = fVar.b;
                    int i3 = fVar.d;
                    if (e3 <= i2 - i3 && e3 > 0) {
                        byte[] bArr = fVar.f8129a;
                        e.d dVar = e.b;
                        e.d dVar2 = new e.d(e.c.a(bArr, i3, e3));
                        fVar.d += e3;
                        return dVar2;
                    } else if (e3 == 0) {
                        return e.b;
                    } else {
                        byte[] f = fVar.f(e3);
                        e.d dVar3 = e.b;
                        return new e.d(f);
                    }
                case 12:
                    return Integer.valueOf(fVar.e());
                case 13:
                    throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
                case 14:
                    return Integer.valueOf(fVar.a());
                case 15:
                    return Long.valueOf(fVar.d());
                case 16:
                    int e4 = fVar.e();
                    return Integer.valueOf((-(e4 & 1)) ^ (e4 >>> 1));
                case 17:
                    long g = fVar.g();
                    return Long.valueOf((-(g & 1)) ^ (g >>> 1));
                default:
                    throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
            }
        }
    }

    public final void b(q qVar, f fVar, i iVar) {
        int c2 = fVar.c(fVar.e());
        a aVar = this.f8144a;
        Object obj = aVar.b;
        Object obj2 = aVar.d;
        while (true) {
            int k = fVar.k();
            if (k == 0) {
                break;
            } else if (k == c0.a(1, this.f8144a.f8145a.b)) {
                obj = a(fVar, iVar, this.f8144a.f8145a, obj);
            } else if (k == c0.a(2, this.f8144a.c.b)) {
                obj2 = a(fVar, iVar, this.f8144a.c, obj2);
            } else if (!fVar.h(k)) {
                break;
            }
        }
        if (fVar.e == 0) {
            fVar.g = c2;
            fVar.m();
            qVar.put(obj, obj2);
            return;
        }
        throw new m("Protocol message end-group tag did not match expected tag.");
    }
}
