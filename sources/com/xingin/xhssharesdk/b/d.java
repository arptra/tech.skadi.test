package com.xingin.xhssharesdk.b;

import com.honey.account.h9.a;
import com.honey.account.h9.b;
import com.xingin.xhssharesdk.a.g;
import com.xingin.xhssharesdk.a.q;
import com.xingin.xhssharesdk.b.i;
import com.xingin.xhssharesdk.c.c;
import com.xingin.xhssharesdk.d.f;
import com.xingin.xhssharesdk.r.b;
import com.xingin.xhssharesdk.r.c;
import com.xingin.xhssharesdk.r.d;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;

public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f8153a = new AtomicBoolean(false);
    public final ExecutorService b;
    public final ArrayList c = new ArrayList();
    public final r d;
    public q e;
    public s f;

    public d() {
        r rVar = r.BIZ;
        this.d = rVar;
        this.b = Executors.newSingleThreadExecutor(new a(rVar));
    }

    public static Thread b(r rVar, Runnable runnable) {
        return new Thread(runnable, "TrackerEncoder-" + rVar.f8165a);
    }

    public final void c() {
        o.a("%s ,handleCache() cache size=%s", this.d, Integer.valueOf(this.c.size()));
        synchronized (this.c) {
            try {
                Iterator it = this.c.iterator();
                while (it.hasNext()) {
                    e((i) it.next());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized void d(i.a aVar) {
        aVar.f8158a = 1;
        i iVar = new i();
        iVar.c = aVar.f8158a;
        iVar.e = aVar.b;
        iVar.f = aVar.c;
        iVar.g = aVar.d;
        e(iVar);
    }

    public final void e(i iVar) {
        if (!this.f8153a.get()) {
            o.a("%s ,addToCache() TrackerEventDetail=%s", this.d, iVar);
            synchronized (this.c) {
                this.c.add(iVar);
            }
            return;
        }
        this.b.execute(new b(this, iVar, l.b()));
    }

    public final void f(i iVar, l lVar) {
        c cVar;
        g gVar = new g(iVar, lVar);
        o.a("%s ,track() TrackerEvent=%s", this.d, gVar);
        h hVar = gVar.b;
        b.a aVar = (b.a) com.xingin.xhssharesdk.r.b.C.d();
        int i = gVar.b.b;
        aVar.f();
        ((com.xingin.xhssharesdk.r.b) aVar.b).d = i;
        String str = gVar.b.c;
        aVar.f();
        com.xingin.xhssharesdk.r.b bVar = (com.xingin.xhssharesdk.r.b) aVar.b;
        bVar.getClass();
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        bVar.e = str;
        String valueOf = String.valueOf(gVar.b.d);
        aVar.f();
        com.xingin.xhssharesdk.r.b bVar2 = (com.xingin.xhssharesdk.r.b) aVar.b;
        bVar2.getClass();
        if (valueOf == null) {
            valueOf = str2;
        }
        bVar2.f = valueOf;
        gVar.b.getClass();
        aVar.f();
        com.xingin.xhssharesdk.r.b bVar3 = (com.xingin.xhssharesdk.r.b) aVar.b;
        bVar3.getClass();
        bVar3.g = str2;
        gVar.b.getClass();
        aVar.f();
        com.xingin.xhssharesdk.r.b bVar4 = (com.xingin.xhssharesdk.r.b) aVar.b;
        bVar4.getClass();
        bVar4.h = str2;
        String a2 = j.a(gVar.f.c);
        aVar.f();
        com.xingin.xhssharesdk.r.b bVar5 = (com.xingin.xhssharesdk.r.b) aVar.b;
        bVar5.getClass();
        bVar5.k = a2;
        String str3 = gVar.f8155a.f8159a;
        aVar.f();
        com.xingin.xhssharesdk.r.b bVar6 = (com.xingin.xhssharesdk.r.b) aVar.b;
        bVar6.getClass();
        if (str3 == null) {
            str3 = str2;
        }
        bVar6.l = str3;
        gVar.f8155a.getClass();
        aVar.f();
        com.xingin.xhssharesdk.r.b bVar7 = (com.xingin.xhssharesdk.r.b) aVar.b;
        bVar7.getClass();
        bVar7.m = "Android";
        String str4 = gVar.f8155a.b;
        aVar.f();
        com.xingin.xhssharesdk.r.b bVar8 = (com.xingin.xhssharesdk.r.b) aVar.b;
        bVar8.getClass();
        if (str4 == null) {
            str4 = str2;
        }
        bVar8.n = str4;
        String valueOf2 = String.valueOf(gVar.f8155a.c);
        aVar.f();
        com.xingin.xhssharesdk.r.b bVar9 = (com.xingin.xhssharesdk.r.b) aVar.b;
        bVar9.getClass();
        if (valueOf2 == null) {
            valueOf2 = str2;
        }
        bVar9.o = valueOf2;
        gVar.f8155a.getClass();
        aVar.f();
        com.xingin.xhssharesdk.r.b bVar10 = (com.xingin.xhssharesdk.r.b) aVar.b;
        bVar10.getClass();
        bVar10.p = str2;
        gVar.f8155a.getClass();
        aVar.f();
        ((com.xingin.xhssharesdk.r.b) aVar.b).q = 0;
        String str5 = gVar.f8155a.d;
        aVar.f();
        com.xingin.xhssharesdk.r.b bVar11 = (com.xingin.xhssharesdk.r.b) aVar.b;
        bVar11.getClass();
        if (str5 == null) {
            str5 = str2;
        }
        bVar11.r = str5;
        String str6 = gVar.f8155a.e;
        aVar.f();
        com.xingin.xhssharesdk.r.b bVar12 = (com.xingin.xhssharesdk.r.b) aVar.b;
        bVar12.getClass();
        if (str6 == null) {
            str6 = str2;
        }
        bVar12.s = str6;
        gVar.f8155a.getClass();
        aVar.f();
        ((com.xingin.xhssharesdk.r.b) aVar.b).q = 0;
        String str7 = gVar.c.f8162a;
        aVar.f();
        com.xingin.xhssharesdk.r.b bVar13 = (com.xingin.xhssharesdk.r.b) aVar.b;
        bVar13.getClass();
        if (str7 == null) {
            str7 = str2;
        }
        bVar13.u = str7;
        String str8 = gVar.c.b;
        aVar.f();
        com.xingin.xhssharesdk.r.b bVar14 = (com.xingin.xhssharesdk.r.b) aVar.b;
        bVar14.getClass();
        if (str8 == null) {
            str8 = str2;
        }
        bVar14.v = str8;
        String str9 = gVar.e.f8161a;
        aVar.f();
        com.xingin.xhssharesdk.r.b bVar15 = (com.xingin.xhssharesdk.r.b) aVar.b;
        bVar15.getClass();
        if (str9 == null) {
            str9 = str2;
        }
        bVar15.w = str9;
        String str10 = gVar.e.b;
        aVar.f();
        com.xingin.xhssharesdk.r.b bVar16 = (com.xingin.xhssharesdk.r.b) aVar.b;
        bVar16.getClass();
        if (str10 == null) {
            str10 = str2;
        }
        bVar16.x = str10;
        String str11 = gVar.b.f8156a;
        aVar.f();
        com.xingin.xhssharesdk.r.b bVar17 = (com.xingin.xhssharesdk.r.b) aVar.b;
        bVar17.getClass();
        if (str11 == null) {
            str11 = str2;
        }
        bVar17.y = str11;
        String str12 = gVar.d.f8160a;
        aVar.f();
        com.xingin.xhssharesdk.r.b bVar18 = (com.xingin.xhssharesdk.r.b) aVar.b;
        bVar18.getClass();
        if (str12 == null) {
            str12 = str2;
        }
        bVar18.z = str12;
        String str13 = gVar.d.b;
        aVar.f();
        com.xingin.xhssharesdk.r.b bVar19 = (com.xingin.xhssharesdk.r.b) aVar.b;
        bVar19.getClass();
        if (str13 == null) {
            str13 = str2;
        }
        bVar19.A = str13;
        int a3 = b.a(gVar.d.c);
        aVar.f();
        ((com.xingin.xhssharesdk.r.b) aVar.b).B = a3;
        com.xingin.xhssharesdk.r.b bVar20 = (com.xingin.xhssharesdk.r.b) aVar.e();
        d.b bVar21 = (d.b) com.xingin.xhssharesdk.r.d.o.d();
        int i2 = gVar.f.e;
        bVar21.f();
        ((com.xingin.xhssharesdk.r.d) bVar21.b).d = i2;
        gVar.f.getClass();
        gVar.f.getClass();
        gVar.f.getClass();
        int i3 = gVar.f.f;
        if (i3 != 0) {
            bVar21.f();
            com.xingin.xhssharesdk.r.d dVar = (com.xingin.xhssharesdk.r.d) bVar21.b;
            dVar.getClass();
            dVar.h = com.xingin.xhssharesdk.r.a.a(i3);
        }
        String str14 = gVar.f.f8157a;
        bVar21.f();
        com.xingin.xhssharesdk.r.d dVar2 = (com.xingin.xhssharesdk.r.d) bVar21.b;
        dVar2.getClass();
        if (str14 != null) {
            str2 = str14;
        }
        dVar2.i = str2;
        int i4 = gVar.f.d;
        bVar21.f();
        ((com.xingin.xhssharesdk.r.d) bVar21.b).j = i4;
        long j = gVar.f.b;
        bVar21.f();
        ((com.xingin.xhssharesdk.r.d) bVar21.b).k = j;
        HashMap hashMap = gVar.f.g;
        bVar21.f();
        com.xingin.xhssharesdk.r.d dVar3 = (com.xingin.xhssharesdk.r.d) bVar21.b;
        q qVar = dVar3.n;
        if (!qVar.f8146a) {
            dVar3.n = qVar.isEmpty() ? new q() : new q(qVar);
        }
        dVar3.n.putAll(hashMap);
        c.a aVar2 = (c.a) com.xingin.xhssharesdk.r.c.f.d();
        aVar2.f();
        com.xingin.xhssharesdk.r.c cVar2 = (com.xingin.xhssharesdk.r.c) aVar2.b;
        cVar2.getClass();
        cVar2.e = (com.xingin.xhssharesdk.r.d) bVar21.e();
        aVar2.f();
        com.xingin.xhssharesdk.r.c cVar3 = (com.xingin.xhssharesdk.r.c) aVar2.b;
        cVar3.getClass();
        cVar3.d = bVar20;
        com.xingin.xhssharesdk.r.c cVar4 = (com.xingin.xhssharesdk.r.c) aVar2.e();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            Logger logger = g.f8130a;
            cVar = new com.xingin.xhssharesdk.c.c(new g.d(byteArrayOutputStream));
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            cVar = null;
        }
        if (cVar != null) {
            try {
                cVar.a(cVar4);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (hVar != null && iVar != null) {
            String str15 = iVar.f8157a;
            j.a(iVar.c);
            if (g(str15, byteArray)) {
                this.f.i();
                return;
            }
            String str16 = iVar.f8157a;
            c.a(iVar.c);
            this.f.g(new f(-1, str16, byteArray, (String) null));
        }
    }

    public final boolean g(String str, byte[] bArr) {
        q qVar = this.e;
        int i = (qVar.f8164a.b(new f(-1, str, bArr, (String) null)) > 0 ? 1 : (qVar.f8164a.b(new f(-1, str, bArr, (String) null)) == 0 ? 0 : -1));
        Object[] objArr = {qVar.b, str};
        if (i >= 0) {
            o.a("%s, store() success eventId=%s", objArr);
        } else {
            o.a("%s, store() fail eventId=%s", objArr);
        }
        return i >= 0;
    }
}
