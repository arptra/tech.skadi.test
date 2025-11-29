package androidx.work.impl.utils;

import androidx.work.impl.utils.taskexecutor.SerialExecutor;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

public class SerialExecutorImpl implements SerialExecutor {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayDeque f2238a = new ArrayDeque();
    public final Executor b;
    public Runnable c;
    public final Object d = new Object();

    public static class Task implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final SerialExecutorImpl f2239a;
        public final Runnable b;

        public Task(SerialExecutorImpl serialExecutorImpl, Runnable runnable) {
            this.f2239a = serialExecutorImpl;
            this.b = runnable;
        }

        public void run() {
            try {
                this.b.run();
                synchronized (this.f2239a.d) {
                    this.f2239a.a();
                }
            } catch (Throwable th) {
                synchronized (this.f2239a.d) {
                    this.f2239a.a();
                    throw th;
                }
            }
        }
    }

    public SerialExecutorImpl(Executor executor) {
        this.b = executor;
    }

    public void a() {
        Runnable runnable = (Runnable) this.f2238a.poll();
        this.c = runnable;
        if (runnable != null) {
            this.b.execute(runnable);
        }
    }

    public void execute(Runnable runnable) {
        synchronized (this.d) {
            try {
                this.f2238a.add(new Task(this, runnable));
                if (this.c == null) {
                    a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean z() {
        boolean z;
        synchronized (this.d) {
            z = !this.f2238a.isEmpty();
        }
        return z;
    }
}
