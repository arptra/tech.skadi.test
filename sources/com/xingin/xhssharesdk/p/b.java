package com.xingin.xhssharesdk.p;

import android.os.Handler;
import android.os.Looper;
import java.lang.ref.SoftReference;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f8199a;

    public static class a extends Handler {
        public a() {
            super(Looper.getMainLooper());
        }
    }

    /* renamed from: com.xingin.xhssharesdk.p.b$b  reason: collision with other inner class name */
    public static class C0033b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final SoftReference f8200a;

        public C0033b(Runnable runnable) {
            this.f8200a = new SoftReference(runnable);
        }

        public final void run() {
            Runnable runnable = (Runnable) this.f8200a.get();
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public static void a(Runnable runnable) {
        if (f8199a == null) {
            f8199a = new a();
        }
        f8199a.post(new C0033b(runnable));
    }
}
