package com.xingin.xhssharesdk.r;

import com.xingin.xhssharesdk.a.f;
import com.xingin.xhssharesdk.a.g;
import com.xingin.xhssharesdk.a.i;
import com.xingin.xhssharesdk.a.k;
import com.xingin.xhssharesdk.a.m;
import com.xingin.xhssharesdk.a.s;
import com.xingin.xhssharesdk.a.u;
import com.xingin.xhssharesdk.r.b;
import com.xingin.xhssharesdk.r.d;
import java.io.IOException;

public final class c extends k<c, a> implements s {
    public static final c f;
    public static volatile k.b g;
    public b d;
    public d e;

    public static final class a extends k.a<c, a> implements s {
        public a() {
            super(c.f);
        }
    }

    static {
        c cVar = new c();
        f = cVar;
        cVar.i();
    }

    public final int b() {
        int i;
        int i2 = this.c;
        if (i2 != -1) {
            return i2;
        }
        b bVar = this.d;
        if (bVar != null) {
            int n = g.n(1);
            int b = bVar.b();
            i = g.v(b) + b + n;
        } else {
            i = 0;
        }
        d dVar = this.e;
        if (dVar != null) {
            int n2 = g.n(2);
            int b2 = dVar.b();
            i += g.v(b2) + b2 + n2;
        }
        this.c = i;
        return i;
    }

    public final Object e(k.h hVar, Object obj, Object obj2) {
        switch (hVar.ordinal()) {
            case 0:
                return f;
            case 1:
                k.i iVar = (k.i) obj;
                c cVar = (c) obj2;
                this.d = (b) iVar.c(this.d, cVar.d);
                this.e = (d) iVar.c(this.e, cVar.e);
                return this;
            case 2:
                f fVar = (f) obj;
                i iVar2 = (i) obj2;
                boolean z = false;
                while (!z) {
                    try {
                        int k = fVar.k();
                        if (k != 0) {
                            if (k == 10) {
                                b bVar = this.d;
                                b.a aVar = bVar != null ? (b.a) bVar.d() : null;
                                u uVar = (u) b.C.c(k.h.h);
                                int e2 = fVar.e();
                                if (fVar.h < 100) {
                                    int c = fVar.c(e2);
                                    fVar.h++;
                                    k a2 = uVar.a(fVar, iVar2);
                                    fVar.b(0);
                                    fVar.h--;
                                    fVar.g = c;
                                    fVar.m();
                                    b bVar2 = (b) a2;
                                    this.d = bVar2;
                                    if (aVar != null) {
                                        aVar.c(bVar2);
                                        if (!aVar.c) {
                                            aVar.b.i();
                                            aVar.c = true;
                                        }
                                        this.d = (b) aVar.b;
                                    }
                                } else {
                                    throw m.a();
                                }
                            } else if (k == 18) {
                                d dVar = this.e;
                                d.b bVar3 = dVar != null ? (d.b) dVar.d() : null;
                                u uVar2 = (u) d.o.c(k.h.h);
                                int e3 = fVar.e();
                                if (fVar.h < 100) {
                                    int c2 = fVar.c(e3);
                                    fVar.h++;
                                    k a3 = uVar2.a(fVar, iVar2);
                                    fVar.b(0);
                                    fVar.h--;
                                    fVar.g = c2;
                                    fVar.m();
                                    d dVar2 = (d) a3;
                                    this.e = dVar2;
                                    if (bVar3 != null) {
                                        bVar3.c(dVar2);
                                        if (!bVar3.c) {
                                            bVar3.b.i();
                                            bVar3.c = true;
                                        }
                                        this.e = (d) bVar3.b;
                                    }
                                } else {
                                    throw m.a();
                                }
                            } else if (!fVar.h(k)) {
                            }
                        }
                        z = true;
                    } catch (m e4) {
                        throw new RuntimeException(e4);
                    } catch (IOException e5) {
                        throw new RuntimeException(new m(e5.getMessage()));
                    } finally {
                    }
                }
                break;
            case 3:
                return null;
            case 4:
                return new c();
            case 5:
                return new a();
            case 6:
                break;
            case 7:
                if (g == null) {
                    synchronized (c.class) {
                        try {
                            if (g == null) {
                                g = new k.b(f);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
                return g;
            default:
                throw new UnsupportedOperationException();
        }
        return f;
    }

    public final void b(g gVar) {
        b bVar = this.d;
        if (bVar != null) {
            gVar.k(1, bVar);
        }
        d dVar = this.e;
        if (dVar != null) {
            gVar.k(2, dVar);
        }
    }
}
