package androidx.work.impl;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.RestrictTo;
import androidx.core.os.HandlerCompat;
import androidx.work.RunnableScheduler;

@RestrictTo
public class DefaultRunnableScheduler implements RunnableScheduler {

    /* renamed from: a  reason: collision with root package name */
    public final Handler f2079a = HandlerCompat.a(Looper.getMainLooper());

    public void a(Runnable runnable) {
        this.f2079a.removeCallbacks(runnable);
    }

    public void b(long j, Runnable runnable) {
        this.f2079a.postDelayed(runnable, j);
    }
}
