package com.upuphone.datatrack.base.utils;

import android.os.Handler;
import java.util.Map;

public class PollingUtil {

    /* renamed from: a  reason: collision with root package name */
    public volatile Handler f6400a;
    public Map b;

    /* renamed from: com.upuphone.datatrack.base.utils.PollingUtil$1  reason: invalid class name */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Runnable f6401a;
        public final /* synthetic */ long b;
        public final /* synthetic */ PollingUtil c;

        public void run() {
            this.f6401a.run();
            this.c.b(this.f6401a, this.b);
        }
    }

    public final void b(Runnable runnable, long j) {
        Runnable runnable2 = (Runnable) this.b.get(runnable);
        this.f6400a.removeCallbacks(runnable2);
        this.f6400a.postDelayed(runnable2, j);
    }
}
