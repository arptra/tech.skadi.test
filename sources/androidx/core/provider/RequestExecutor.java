package androidx.core.provider;

import android.os.Handler;
import android.os.Process;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class RequestExecutor {

    public static class DefaultThreadFactory implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        public String f798a;
        public int b;

        public static class ProcessPriorityThread extends Thread {

            /* renamed from: a  reason: collision with root package name */
            public final int f799a;

            public ProcessPriorityThread(Runnable runnable, String str, int i) {
                super(runnable, str);
                this.f799a = i;
            }

            public void run() {
                Process.setThreadPriority(this.f799a);
                super.run();
            }
        }

        public DefaultThreadFactory(String str, int i) {
            this.f798a = str;
            this.b = i;
        }

        public Thread newThread(Runnable runnable) {
            return new ProcessPriorityThread(runnable, this.f798a, this.b);
        }
    }

    public static class HandlerExecutor implements Executor {

        /* renamed from: a  reason: collision with root package name */
        public final Handler f800a;

        public void execute(Runnable runnable) {
            if (!this.f800a.post((Runnable) Preconditions.h(runnable))) {
                throw new RejectedExecutionException(this.f800a + " is shutting down");
            }
        }
    }

    public static class ReplyRunnable<T> implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public Callable f801a;
        public Consumer b;
        public Handler c;

        public ReplyRunnable(Handler handler, Callable callable, Consumer consumer) {
            this.f801a = callable;
            this.b = consumer;
            this.c = handler;
        }

        public void run() {
            final Object obj;
            try {
                obj = this.f801a.call();
            } catch (Exception unused) {
                obj = null;
            }
            final Consumer consumer = this.b;
            this.c.post(new Runnable() {
                public void run() {
                    consumer.accept(obj);
                }
            });
        }
    }

    public static ThreadPoolExecutor a(String str, int i, int i2) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, (long) i2, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new DefaultThreadFactory(str, i));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static void b(Executor executor, Callable callable, Consumer consumer) {
        executor.execute(new ReplyRunnable(CalleeHandler.a(), callable, consumer));
    }

    public static Object c(ExecutorService executorService, Callable callable, int i) {
        try {
            return executorService.submit(callable).get((long) i, TimeUnit.MILLISECONDS);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e2) {
            throw e2;
        } catch (TimeoutException unused) {
            throw new InterruptedException(RtspHeaders.Values.TIMEOUT);
        }
    }
}
