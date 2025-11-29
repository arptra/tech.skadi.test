package androidx.loader.content;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

abstract class ModernAsyncTask<Params, Progress, Result> {
    public static final ThreadFactory f;
    public static final BlockingQueue g;
    public static final Executor h;
    public static InternalHandler i;
    public static volatile Executor j;

    /* renamed from: a  reason: collision with root package name */
    public final WorkerRunnable f1412a;
    public final FutureTask b;
    public volatile Status c = Status.PENDING;
    public final AtomicBoolean d = new AtomicBoolean();
    public final AtomicBoolean e = new AtomicBoolean();

    /* renamed from: androidx.loader.content.ModernAsyncTask$4  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f1415a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                androidx.loader.content.ModernAsyncTask$Status[] r0 = androidx.loader.content.ModernAsyncTask.Status.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1415a = r0
                androidx.loader.content.ModernAsyncTask$Status r1 = androidx.loader.content.ModernAsyncTask.Status.RUNNING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f1415a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.loader.content.ModernAsyncTask$Status r1 = androidx.loader.content.ModernAsyncTask.Status.FINISHED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.loader.content.ModernAsyncTask.AnonymousClass4.<clinit>():void");
        }
    }

    public static class AsyncTaskResult<Data> {

        /* renamed from: a  reason: collision with root package name */
        public final ModernAsyncTask f1416a;
        public final Object[] b;

        public AsyncTaskResult(ModernAsyncTask modernAsyncTask, Object... objArr) {
            this.f1416a = modernAsyncTask;
            this.b = objArr;
        }
    }

    public static class InternalHandler extends Handler {
        public InternalHandler() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            AsyncTaskResult asyncTaskResult = (AsyncTaskResult) message.obj;
            int i = message.what;
            if (i == 1) {
                asyncTaskResult.f1416a.e(asyncTaskResult.b[0]);
            } else if (i == 2) {
                asyncTaskResult.f1416a.l(asyncTaskResult.b);
            }
        }
    }

    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    public static abstract class WorkerRunnable<Params, Result> implements Callable<Result> {

        /* renamed from: a  reason: collision with root package name */
        public Object[] f1417a;
    }

    static {
        AnonymousClass1 r7 = new ThreadFactory() {

            /* renamed from: a  reason: collision with root package name */
            public final AtomicInteger f1413a = new AtomicInteger(1);

            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "ModernAsyncTask #" + this.f1413a.getAndIncrement());
            }
        };
        f = r7;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(10);
        g = linkedBlockingQueue;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, linkedBlockingQueue, r7);
        h = threadPoolExecutor;
        j = threadPoolExecutor;
    }

    public ModernAsyncTask() {
        AnonymousClass2 r0 = new WorkerRunnable<Params, Result>() {
            public Object call() {
                ModernAsyncTask.this.e.set(true);
                Object obj = null;
                try {
                    Process.setThreadPriority(10);
                    obj = ModernAsyncTask.this.c(this.f1417a);
                    Binder.flushPendingCommands();
                    ModernAsyncTask.this.m(obj);
                    return obj;
                } catch (Throwable th) {
                    ModernAsyncTask.this.m(obj);
                    throw th;
                }
            }
        };
        this.f1412a = r0;
        this.b = new FutureTask<Result>(r0) {
            public void done() {
                try {
                    ModernAsyncTask.this.n(get());
                } catch (InterruptedException e) {
                    Log.w("AsyncTask", e);
                } catch (ExecutionException e2) {
                    throw new RuntimeException("An error occurred while executing doInBackground()", e2.getCause());
                } catch (CancellationException unused) {
                    ModernAsyncTask.this.n((Object) null);
                } catch (Throwable th) {
                    throw new RuntimeException("An error occurred while executing doInBackground()", th);
                }
            }
        };
    }

    public static Handler f() {
        InternalHandler internalHandler;
        synchronized (ModernAsyncTask.class) {
            try {
                if (i == null) {
                    i = new InternalHandler();
                }
                internalHandler = i;
            } catch (Throwable th) {
                throw th;
            }
        }
        return internalHandler;
    }

    public final boolean b(boolean z) {
        this.d.set(true);
        return this.b.cancel(z);
    }

    public abstract Object c(Object... objArr);

    public final ModernAsyncTask d(Executor executor, Object... objArr) {
        if (this.c != Status.PENDING) {
            int i2 = AnonymousClass4.f1415a[this.c.ordinal()];
            if (i2 == 1) {
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            } else if (i2 != 2) {
                throw new IllegalStateException("We should never reach this state");
            } else {
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        } else {
            this.c = Status.RUNNING;
            k();
            this.f1412a.f1417a = objArr;
            executor.execute(this.b);
            return this;
        }
    }

    public void e(Object obj) {
        if (g()) {
            i(obj);
        } else {
            j(obj);
        }
        this.c = Status.FINISHED;
    }

    public final boolean g() {
        return this.d.get();
    }

    public void h() {
    }

    public void i(Object obj) {
        h();
    }

    public void j(Object obj) {
    }

    public void k() {
    }

    public void l(Object... objArr) {
    }

    public Object m(Object obj) {
        f().obtainMessage(1, new AsyncTaskResult(this, obj)).sendToTarget();
        return obj;
    }

    public void n(Object obj) {
        if (!this.e.get()) {
            m(obj);
        }
    }
}
