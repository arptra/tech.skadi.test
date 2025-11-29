package com.geetest.sdk;

import android.os.Handler;
import android.os.Looper;

public class ag<T> implements ae<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Handler f2906a = new Handler(Looper.getMainLooper());
    public ae b;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f2907a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Object c;

        public a(int i, String str, Object obj) {
            this.f2907a = i;
            this.b = str;
            this.c = obj;
        }

        public void run() {
            try {
                ag.this.b.a(this.f2907a, this.b, this.c);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f2908a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Object c;

        public b(int i, String str, Object obj) {
            this.f2908a = i;
            this.b = str;
            this.c = obj;
        }

        public void run() {
            try {
                ag.this.b.a(this.f2908a, this.b, this.c);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ag(ae aeVar) {
        this.b = aeVar;
    }

    public static ag c(ae aeVar) {
        return new ag(aeVar);
    }

    public void a(int i, String str, Object obj) {
        if (this.b != null) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                d(i, str, obj);
                return;
            }
            try {
                this.b.a(i, str, obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void d(int i, String str, Object obj) {
        Handler handler = this.f2906a;
        if (handler != null) {
            handler.post(new a(i, str, obj));
        } else {
            new Handler(Looper.getMainLooper()).post(new b(i, str, obj));
        }
    }
}
