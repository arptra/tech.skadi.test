package com.xingin.xhssharesdk.r;

import com.xingin.xhssharesdk.a.c0;
import com.xingin.xhssharesdk.a.f;
import com.xingin.xhssharesdk.a.g;
import com.xingin.xhssharesdk.a.i;
import com.xingin.xhssharesdk.a.j;
import com.xingin.xhssharesdk.a.k;
import com.xingin.xhssharesdk.a.m;
import com.xingin.xhssharesdk.a.p;
import com.xingin.xhssharesdk.a.q;
import com.xingin.xhssharesdk.a.s;
import java.io.IOException;
import java.util.Map;

public final class d extends k<d, b> implements s {
    public static final d o;
    public static volatile k.b p;
    public int d;
    public String e = "";
    public String f = "";
    public String g = "";
    public int h;
    public String i = "";
    public int j;
    public long k;
    public String l = "";
    public String m = "";
    public q n = q.a();

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final p f8202a;

        static {
            c0.a.C0027a aVar = c0.a.c;
            f8202a = new p(aVar, aVar);
        }
    }

    public static final class b extends k.a<d, b> implements s {
        public b() {
            super(d.o);
        }
    }

    static {
        d dVar = new d();
        o = dVar;
        dVar.i();
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
        int i5 = this.h;
        if (i5 != 0) {
            i2 += g.b(i5) + g.n(5);
        }
        if (!this.i.isEmpty()) {
            i2 += g.c(6, this.i);
        }
        int i6 = this.j;
        if (i6 != 0) {
            i2 += g.b(i6) + g.n(7);
        }
        long j2 = this.k;
        if (j2 != 0) {
            i2 += g.d(j2) + g.n(8);
        }
        if (!this.l.isEmpty()) {
            i2 += g.c(9, this.l);
        }
        if (!this.m.isEmpty()) {
            i2 += g.c(10, this.m);
        }
        for (Map.Entry entry : this.n.entrySet()) {
            p pVar = a.f8202a;
            pVar.getClass();
            int n2 = g.n(11);
            p.a aVar = pVar.f8144a;
            int a2 = j.a(aVar.c, 2, (String) entry.getValue()) + j.a(aVar.f8145a, 1, (String) entry.getKey());
            i2 += g.v(a2) + a2 + n2;
        }
        this.c = i2;
        return i2;
    }

    public final Object e(k.h hVar, Object obj, Object obj2) {
        boolean z = false;
        switch (hVar.ordinal()) {
            case 0:
                return o;
            case 1:
                k.i iVar = (k.i) obj;
                d dVar = (d) obj2;
                int i2 = this.d;
                boolean z2 = i2 != 0;
                int i3 = dVar.d;
                this.d = iVar.g(z2, i2, i3 != 0, i3);
                this.e = iVar.d(!this.e.isEmpty(), this.e, !dVar.e.isEmpty(), dVar.e);
                this.f = iVar.d(!this.f.isEmpty(), this.f, !dVar.f.isEmpty(), dVar.f);
                this.g = iVar.d(!this.g.isEmpty(), this.g, !dVar.g.isEmpty(), dVar.g);
                int i4 = this.h;
                boolean z3 = i4 != 0;
                int i5 = dVar.h;
                this.h = iVar.g(z3, i4, i5 != 0, i5);
                this.i = iVar.d(!this.i.isEmpty(), this.i, !dVar.i.isEmpty(), dVar.i);
                int i6 = this.j;
                boolean z4 = i6 != 0;
                int i7 = dVar.j;
                this.j = iVar.g(z4, i6, i7 != 0, i7);
                long j2 = this.k;
                boolean z5 = j2 != 0;
                long j3 = dVar.k;
                this.k = iVar.f(z5, j2, j3 != 0, j3);
                this.l = iVar.d(!this.l.isEmpty(), this.l, !dVar.l.isEmpty(), dVar.l);
                this.m = iVar.d(!this.m.isEmpty(), this.m, true ^ dVar.m.isEmpty(), dVar.m);
                this.n = iVar.e(this.n, dVar.n);
                return this;
            case 2:
                f fVar = (f) obj;
                i iVar2 = (i) obj2;
                while (!z) {
                    try {
                        int k2 = fVar.k();
                        switch (k2) {
                            case 0:
                                z = true;
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
                            case 40:
                                this.h = fVar.e();
                                break;
                            case 50:
                                this.i = fVar.i();
                                break;
                            case 56:
                                this.j = fVar.e();
                                break;
                            case 64:
                                this.k = fVar.g();
                                break;
                            case 74:
                                this.l = fVar.i();
                                break;
                            case 82:
                                this.m = fVar.i();
                                break;
                            case ORIENTATION_90_VALUE:
                                q qVar = this.n;
                                if (!qVar.f8146a) {
                                    this.n = qVar.isEmpty() ? new q() : new q(qVar);
                                }
                                a.f8202a.b(this.n, fVar, iVar2);
                                break;
                            default:
                                if (fVar.h(k2)) {
                                    break;
                                } else {
                                    z = true;
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
                this.n.f8146a = false;
                return null;
            case 4:
                return new d();
            case 5:
                return new b();
            case 6:
                break;
            case 7:
                if (p == null) {
                    synchronized (d.class) {
                        try {
                            if (p == null) {
                                p = new k.b(o);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
                return p;
            default:
                throw new UnsupportedOperationException();
        }
        return o;
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
        int i3 = this.h;
        if (i3 != 0) {
            gVar.j(5, i3);
        }
        if (!this.i.isEmpty()) {
            gVar.p(6, this.i);
        }
        int i4 = this.j;
        if (i4 != 0) {
            gVar.j(7, i4);
        }
        long j2 = this.k;
        if (j2 != 0) {
            gVar.w(j2);
        }
        if (!this.l.isEmpty()) {
            gVar.p(9, this.l);
        }
        if (!this.m.isEmpty()) {
            gVar.p(10, this.m);
        }
        for (Map.Entry entry : this.n.entrySet()) {
            p pVar = a.f8202a;
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            pVar.getClass();
            gVar.o(11, 2);
            p.a aVar = pVar.f8144a;
            gVar.A(j.a(aVar.c, 2, str2) + j.a(aVar.f8145a, 1, str));
            p.a aVar2 = pVar.f8144a;
            j.e(gVar, aVar2.f8145a, 1, str);
            j.e(gVar, aVar2.c, 2, str2);
        }
    }
}
