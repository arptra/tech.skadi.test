package com.xingin.xhssharesdk.r;

import com.alibaba.fastjson.asm.Opcodes;
import com.upuphone.runasone.uupcast.VirtualDeviceEventCode;
import com.xingin.xhssharesdk.a.f;
import com.xingin.xhssharesdk.a.g;
import com.xingin.xhssharesdk.a.i;
import com.xingin.xhssharesdk.a.k;
import com.xingin.xhssharesdk.a.m;
import com.xingin.xhssharesdk.a.s;
import java.io.IOException;

public final class b extends k<b, a> implements s {
    public static final b C;
    public static volatile k.b D;
    public String A = "";
    public int B;
    public int d;
    public String e = "";
    public String f = "";
    public String g = "";
    public String h = "";
    public String i = "";
    public String j = "";
    public String k = "";
    public String l = "";
    public String m = "";
    public String n = "";
    public String o = "";
    public String p = "";
    public int q;
    public String r = "";
    public String s = "";
    public String t = "";
    public String u = "";
    public String v = "";
    public String w = "";
    public String x = "";
    public String y = "";
    public String z = "";

    public static final class a extends k.a<b, a> implements s {
        public a() {
            super(b.C);
        }
    }

    static {
        b bVar = new b();
        C = bVar;
        bVar.i();
    }

    public final int b() {
        int i2;
        int i3 = this.c;
        if (i3 != -1) {
            return i3;
        }
        int i4 = this.d;
        if (i4 != 0) {
            i2 = g.b(i4) + g.n(1);
        } else {
            i2 = 0;
        }
        if (!this.e.isEmpty()) {
            i2 += g.c(2, this.e);
        }
        if (!this.f.isEmpty()) {
            i2 += g.c(3, this.f);
        }
        if (!this.g.isEmpty()) {
            i2 += g.c(4, this.g);
        }
        if (!this.h.isEmpty()) {
            i2 += g.c(5, this.h);
        }
        if (!this.i.isEmpty()) {
            i2 += g.c(6, this.i);
        }
        if (!this.j.isEmpty()) {
            i2 += g.c(7, this.j);
        }
        if (!this.k.isEmpty()) {
            i2 += g.c(8, this.k);
        }
        if (!this.l.isEmpty()) {
            i2 += g.c(9, this.l);
        }
        if (!this.m.isEmpty()) {
            i2 += g.c(10, this.m);
        }
        if (!this.n.isEmpty()) {
            i2 += g.c(11, this.n);
        }
        if (!this.o.isEmpty()) {
            i2 += g.c(12, this.o);
        }
        if (!this.p.isEmpty()) {
            i2 += g.c(13, this.p);
        }
        int i5 = this.q;
        if (i5 != 0) {
            i2 += g.b(i5) + g.n(14);
        }
        if (!this.r.isEmpty()) {
            i2 += g.c(15, this.r);
        }
        if (!this.s.isEmpty()) {
            i2 += g.c(16, this.s);
        }
        if (!this.t.isEmpty()) {
            i2 += g.c(17, this.t);
        }
        if (!this.u.isEmpty()) {
            i2 += g.c(18, this.u);
        }
        if (!this.v.isEmpty()) {
            i2 += g.c(19, this.v);
        }
        if (!this.w.isEmpty()) {
            i2 += g.c(20, this.w);
        }
        if (!this.x.isEmpty()) {
            i2 += g.c(21, this.x);
        }
        if (!this.y.isEmpty()) {
            i2 += g.c(22, this.y);
        }
        if (!this.z.isEmpty()) {
            i2 += g.c(23, this.z);
        }
        if (!this.A.isEmpty()) {
            i2 += g.c(24, this.A);
        }
        int i6 = this.B;
        if (i6 != 0) {
            i2 += g.b(i6) + g.n(25);
        }
        this.c = i2;
        return i2;
    }

    public final Object e(k.h hVar, Object obj, Object obj2) {
        boolean z2 = false;
        switch (hVar.ordinal()) {
            case 0:
                return C;
            case 1:
                k.i iVar = (k.i) obj;
                b bVar = (b) obj2;
                int i2 = this.d;
                boolean z3 = i2 != 0;
                int i3 = bVar.d;
                this.d = iVar.g(z3, i2, i3 != 0, i3);
                this.e = iVar.d(!this.e.isEmpty(), this.e, !bVar.e.isEmpty(), bVar.e);
                this.f = iVar.d(!this.f.isEmpty(), this.f, !bVar.f.isEmpty(), bVar.f);
                this.g = iVar.d(!this.g.isEmpty(), this.g, !bVar.g.isEmpty(), bVar.g);
                this.h = iVar.d(!this.h.isEmpty(), this.h, !bVar.h.isEmpty(), bVar.h);
                this.i = iVar.d(!this.i.isEmpty(), this.i, !bVar.i.isEmpty(), bVar.i);
                this.j = iVar.d(!this.j.isEmpty(), this.j, !bVar.j.isEmpty(), bVar.j);
                this.k = iVar.d(!this.k.isEmpty(), this.k, !bVar.k.isEmpty(), bVar.k);
                this.l = iVar.d(!this.l.isEmpty(), this.l, !bVar.l.isEmpty(), bVar.l);
                this.m = iVar.d(!this.m.isEmpty(), this.m, !bVar.m.isEmpty(), bVar.m);
                this.n = iVar.d(!this.n.isEmpty(), this.n, !bVar.n.isEmpty(), bVar.n);
                this.o = iVar.d(!this.o.isEmpty(), this.o, !bVar.o.isEmpty(), bVar.o);
                this.p = iVar.d(!this.p.isEmpty(), this.p, !bVar.p.isEmpty(), bVar.p);
                int i4 = this.q;
                boolean z4 = i4 != 0;
                int i5 = bVar.q;
                this.q = iVar.g(z4, i4, i5 != 0, i5);
                this.r = iVar.d(!this.r.isEmpty(), this.r, !bVar.r.isEmpty(), bVar.r);
                this.s = iVar.d(!this.s.isEmpty(), this.s, !bVar.s.isEmpty(), bVar.s);
                this.t = iVar.d(!this.t.isEmpty(), this.t, !bVar.t.isEmpty(), bVar.t);
                this.u = iVar.d(!this.u.isEmpty(), this.u, !bVar.u.isEmpty(), bVar.u);
                this.v = iVar.d(!this.v.isEmpty(), this.v, !bVar.v.isEmpty(), bVar.v);
                this.w = iVar.d(!this.w.isEmpty(), this.w, !bVar.w.isEmpty(), bVar.w);
                this.x = iVar.d(!this.x.isEmpty(), this.x, !bVar.x.isEmpty(), bVar.x);
                this.y = iVar.d(!this.y.isEmpty(), this.y, !bVar.y.isEmpty(), bVar.y);
                this.z = iVar.d(!this.z.isEmpty(), this.z, !bVar.z.isEmpty(), bVar.z);
                this.A = iVar.d(!this.A.isEmpty(), this.A, !bVar.A.isEmpty(), bVar.A);
                int i6 = this.B;
                boolean z5 = i6 != 0;
                int i7 = bVar.B;
                if (i7 != 0) {
                    z2 = true;
                }
                this.B = iVar.g(z5, i6, z2, i7);
                return this;
            case 2:
                f fVar = (f) obj;
                i iVar2 = (i) obj2;
                while (!z2) {
                    try {
                        int k2 = fVar.k();
                        switch (k2) {
                            case 0:
                                z2 = true;
                                break;
                            case 8:
                                this.d = fVar.e();
                                break;
                            case 18:
                                this.e = fVar.i();
                                break;
                            case 26:
                                this.f = fVar.i();
                                break;
                            case 34:
                                this.g = fVar.i();
                                break;
                            case 42:
                                this.h = fVar.i();
                                break;
                            case 50:
                                this.i = fVar.i();
                                break;
                            case 58:
                                this.j = fVar.i();
                                break;
                            case 66:
                                this.k = fVar.i();
                                break;
                            case 74:
                                this.l = fVar.i();
                                break;
                            case 82:
                                this.m = fVar.i();
                                break;
                            case ORIENTATION_90_VALUE:
                                this.n = fVar.i();
                                break;
                            case VirtualDeviceEventCode.EVENT_CAMERA_DEVICE:
                                this.o = fVar.i();
                                break;
                            case 106:
                                this.p = fVar.i();
                                break;
                            case 112:
                                this.q = fVar.e();
                                break;
                            case 122:
                                this.r = fVar.i();
                                break;
                            case 130:
                                this.s = fVar.i();
                                break;
                            case 138:
                                this.t = fVar.i();
                                break;
                            case 146:
                                this.u = fVar.i();
                                break;
                            case Opcodes.IFNE:
                                this.v = fVar.i();
                                break;
                            case Opcodes.IF_ICMPGE:
                                this.w = fVar.i();
                                break;
                            case 170:
                                this.x = fVar.i();
                                break;
                            case Opcodes.GETSTATIC:
                                this.y = fVar.i();
                                break;
                            case 186:
                                this.z = fVar.i();
                                break;
                            case 194:
                                this.A = fVar.i();
                                break;
                            case 200:
                                this.B = fVar.e();
                                break;
                            default:
                                if (fVar.h(k2)) {
                                    break;
                                } else {
                                    z2 = true;
                                    break;
                                }
                        }
                    } catch (m e2) {
                        throw new RuntimeException(e2);
                    } catch (IOException e3) {
                        throw new RuntimeException(new m(e3.getMessage()));
                    } finally {
                    }
                }
                break;
            case 3:
                return null;
            case 4:
                return new b();
            case 5:
                return new a();
            case 6:
                break;
            case 7:
                if (D == null) {
                    synchronized (b.class) {
                        try {
                            if (D == null) {
                                D = new k.b(C);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
                return D;
            default:
                throw new UnsupportedOperationException();
        }
        return C;
    }

    public final void b(g gVar) {
        int i2 = this.d;
        if (i2 != 0) {
            gVar.j(1, i2);
        }
        if (!this.e.isEmpty()) {
            gVar.p(2, this.e);
        }
        if (!this.f.isEmpty()) {
            gVar.p(3, this.f);
        }
        if (!this.g.isEmpty()) {
            gVar.p(4, this.g);
        }
        if (!this.h.isEmpty()) {
            gVar.p(5, this.h);
        }
        if (!this.i.isEmpty()) {
            gVar.p(6, this.i);
        }
        if (!this.j.isEmpty()) {
            gVar.p(7, this.j);
        }
        if (!this.k.isEmpty()) {
            gVar.p(8, this.k);
        }
        if (!this.l.isEmpty()) {
            gVar.p(9, this.l);
        }
        if (!this.m.isEmpty()) {
            gVar.p(10, this.m);
        }
        if (!this.n.isEmpty()) {
            gVar.p(11, this.n);
        }
        if (!this.o.isEmpty()) {
            gVar.p(12, this.o);
        }
        if (!this.p.isEmpty()) {
            gVar.p(13, this.p);
        }
        int i3 = this.q;
        if (i3 != 0) {
            gVar.j(14, i3);
        }
        if (!this.r.isEmpty()) {
            gVar.p(15, this.r);
        }
        if (!this.s.isEmpty()) {
            gVar.p(16, this.s);
        }
        if (!this.t.isEmpty()) {
            gVar.p(17, this.t);
        }
        if (!this.u.isEmpty()) {
            gVar.p(18, this.u);
        }
        if (!this.v.isEmpty()) {
            gVar.p(19, this.v);
        }
        if (!this.w.isEmpty()) {
            gVar.p(20, this.w);
        }
        if (!this.x.isEmpty()) {
            gVar.p(21, this.x);
        }
        if (!this.y.isEmpty()) {
            gVar.p(22, this.y);
        }
        if (!this.z.isEmpty()) {
            gVar.p(23, this.z);
        }
        if (!this.A.isEmpty()) {
            gVar.p(24, this.A);
        }
        int i4 = this.B;
        if (i4 != 0) {
            gVar.j(25, i4);
        }
    }
}
