package com.geetest.sdk;

import android.os.Looper;
import com.geetest.sdk.utils.l;
import com.geetest.sdk.utils.n;
import com.geetest.sdk.utils.p;
import com.geetest.sdk.utils.u;
import java.util.ArrayList;
import java.util.List;

public class ad {
    public static final String b = "ad";
    public static List c = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    public boolean f2903a = false;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ac f2904a;
        public final /* synthetic */ ae b;

        public a(ac acVar, ae aeVar) {
            this.f2904a = acVar;
            this.b = aeVar;
        }

        public void run() {
            ad.this.d(this.f2904a, this.b);
        }
    }

    public static void c() {
        List list = c;
        if (list != null && list.size() > 0) {
            for (ad a2 : c) {
                a2.a();
            }
            c.clear();
        }
    }

    public static ad e() {
        ad adVar = new ad();
        c.add(adVar);
        return adVar;
    }

    public void a() {
        this.f2903a = true;
    }

    public void b(ac acVar, ae aeVar) {
        u.a().b(new a(acVar, aeVar));
    }

    public void d(ac acVar, ae aeVar) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            String str = b;
            l.c(str, acVar.a() + " REQUEST START");
            l.c(str, acVar.a() + " REQUEST URL: " + acVar.p());
            System.currentTimeMillis();
            if (!p.a(acVar.j())) {
                acVar.e(-1, acVar.k("Network Not Avaliable", new Object[0]));
                acVar.g(aeVar);
                return;
            }
            byte[] r = acVar.r();
            if (this.f2903a) {
                acVar.l(aeVar);
                return;
            }
            String a2 = n.a(acVar.p(), acVar.q(), acVar.n(), r, acVar.a());
            l.c(str, acVar.a() + "REQUEST END");
            if (this.f2903a) {
                acVar.l(aeVar);
                return;
            }
            acVar.m(a2);
            acVar.g(aeVar);
            return;
        }
        throw new RuntimeException("This thread(ui) forbids invoke.");
    }
}
