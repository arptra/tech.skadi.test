package com.xingin.xhssharesdk.b;

import com.xingin.xhssharesdk.d.f;
import com.xingin.xhssharesdk.e.a;
import com.xingin.xhssharesdk.f.c;
import com.xingin.xhssharesdk.f.d;
import com.xingin.xhssharesdk.f.e;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class s {
    public static final DecimalFormat e = new DecimalFormat("0.00");

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f8166a;
    public c b;
    public final q c;
    public final r d;

    public s(r rVar, q qVar) {
        d();
        this.c = qVar;
        this.d = rVar;
        this.f8166a = Executors.newSingleThreadExecutor(new com.honey.account.h9.c(rVar));
        f();
    }

    public static Thread c(r rVar, Runnable runnable) {
        return new Thread(runnable, "TrackerUpload-" + rVar.f8165a);
    }

    public final void d() {
        d dVar;
        try {
            dVar = new d(new a());
        } catch (Throwable unused) {
            dVar = null;
        }
        this.b = dVar;
        if (dVar == null) {
            this.b = new e(new a());
            o.a("use OriginalHTTPTransport ", new Object[0]);
            return;
        }
        o.a("use OKHTTPTransport ", new Object[0]);
    }

    public final void e(f fVar) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.add(fVar.c);
        arrayList2.add(fVar);
        com.xingin.xhssharesdk.f.f a2 = this.b.a(arrayList);
        long length = (long) fVar.c.length;
        o.a("uploadData() count=%s length=%s \nresult=%s", 1, e.format(((double) length) / 1024.0d) + "KB", a2);
    }

    public final void f() {
        q qVar = this.c;
        long a2 = qVar.f8164a.a();
        qVar.f8164a.getClass();
        qVar.f8164a.getClass();
        long j = (a2 + 99) / 100;
        for (long j2 = 0; j2 < j; j2++) {
            i();
        }
    }

    public final void g(f fVar) {
        this.f8166a.execute(new com.honey.account.h9.d(this, fVar));
    }

    public final void h() {
        ArrayList<f> f = this.c.f8164a.f();
        if (f != null && !f.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            long j = 0;
            for (f fVar : f) {
                byte[] bArr = fVar.c;
                if (((long) bArr.length) >= 1048576) {
                    ArrayList arrayList3 = new ArrayList();
                    ArrayList arrayList4 = new ArrayList();
                    arrayList3.add(fVar.c);
                    arrayList4.add(fVar);
                    com.xingin.xhssharesdk.f.f a2 = this.b.a(arrayList3);
                    r rVar = this.d;
                    long length = (long) fVar.c.length;
                    o.a("%s, uploadData() count=%s length=%s \nresult=%s", rVar, 1, e.format(((double) length) / 1024.0d) + "KB", a2);
                    if (a2.f8179a) {
                        this.c.f8164a.c(arrayList4);
                    }
                } else {
                    if (((long) bArr.length) + j > 1048576) {
                        com.xingin.xhssharesdk.f.f a3 = this.b.a(arrayList);
                        r rVar2 = this.d;
                        Integer valueOf = Integer.valueOf(arrayList2.size());
                        o.a("%s, uploadData() count=%s length=%s \nresult=%s", rVar2, valueOf, e.format(((double) j) / 1024.0d) + "KB", a3);
                        if (a3.f8179a) {
                            this.c.f8164a.c(arrayList2);
                        }
                        arrayList = new ArrayList();
                        arrayList2 = new ArrayList();
                        j = 0;
                    }
                    byte[] bArr2 = fVar.c;
                    j += (long) bArr2.length;
                    arrayList.add(bArr2);
                    arrayList2.add(fVar);
                }
            }
            if (j > 0) {
                com.xingin.xhssharesdk.f.f a4 = this.b.a(arrayList);
                r rVar3 = this.d;
                Integer valueOf2 = Integer.valueOf(arrayList2.size());
                o.a("%s, uploadData() count=%s length=%s \nresult=%s", rVar3, valueOf2, e.format(((double) j) / 1024.0d) + "KB", a4);
                if (a4.f8179a) {
                    this.c.f8164a.c(arrayList2);
                }
            }
        }
    }

    public final void i() {
        this.f8166a.execute(new com.honey.account.h9.e(this));
    }
}
