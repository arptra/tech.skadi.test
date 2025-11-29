package androidx.arch.core.executor;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@RestrictTo
public class DefaultTaskExecutor extends TaskExecutor {

    /* renamed from: a  reason: collision with root package name */
    public final Object f379a = new Object();
    public final ExecutorService b = Executors.newFixedThreadPool(4, new ThreadFactory() {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f380a = new AtomicInteger(0);

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("arch_disk_io_" + this.f380a.getAndIncrement());
            return thread;
        }
    });
    public volatile Handler c;

    @RequiresApi
    public static class Api28Impl {
        public static Handler a(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    public static Handler e(Looper looper) {
        return Api28Impl.a(looper);
    }

    public void a(Runnable runnable) {
        this.b.execute(runnable);
    }

    public boolean c() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public void d(Runnable runnable) {
        if (this.c == null) {
            synchronized (this.f379a) {
                try {
                    if (this.c == null) {
                        this.c = e(Looper.getMainLooper());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        this.c.post(runnable);
    }
}
