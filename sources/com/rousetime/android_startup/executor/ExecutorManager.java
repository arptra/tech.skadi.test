package com.rousetime.android_startup.executor;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00048\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR$\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000b8\u0006@BX\u000e¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000eR$\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00108\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/rousetime/android_startup/executor/ExecutorManager;", "", "<init>", "()V", "Ljava/util/concurrent/ThreadPoolExecutor;", "<set-?>", "a", "Ljava/util/concurrent/ThreadPoolExecutor;", "getCpuExecutor", "()Ljava/util/concurrent/ThreadPoolExecutor;", "cpuExecutor", "Ljava/util/concurrent/ExecutorService;", "b", "Ljava/util/concurrent/ExecutorService;", "()Ljava/util/concurrent/ExecutorService;", "ioExecutor", "Ljava/util/concurrent/Executor;", "c", "Ljava/util/concurrent/Executor;", "()Ljava/util/concurrent/Executor;", "mainExecutor", "Ljava/util/concurrent/RejectedExecutionHandler;", "d", "Ljava/util/concurrent/RejectedExecutionHandler;", "handler", "i", "Companion", "android-startup_release"}, k = 1, mv = {1, 4, 0})
public final class ExecutorManager {
    public static final Lazy e = LazyKt.lazy(ExecutorManager$Companion$instance$2.INSTANCE);
    public static final int f;
    public static final int g;
    public static final int h;
    public static final Companion i = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public ThreadPoolExecutor f9823a;
    public ExecutorService b;
    public Executor c = new Executor() {

        /* renamed from: a  reason: collision with root package name */
        public final Handler f9824a = new Handler(Looper.getMainLooper());

        public void execute(Runnable runnable) {
            this.f9824a.post(runnable);
        }
    };
    public final RejectedExecutionHandler d;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R!\u0010\n\u001a\u00020\u00048FX\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/rousetime/android_startup/executor/ExecutorManager$Companion;", "", "<init>", "()V", "Lcom/rousetime/android_startup/executor/ExecutorManager;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/rousetime/android_startup/executor/ExecutorManager;", "instance$annotations", "instance", "", "CORE_POOL_SIZE", "I", "CPU_COUNT", "", "KEEP_ALIVE_TIME", "J", "MAX_POOL_SIZE", "android-startup_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        public final ExecutorManager a() {
            return (ExecutorManager) ExecutorManager.e.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f = availableProcessors;
        int max = Math.max(2, Math.min(availableProcessors - 1, 5));
        g = max;
        h = max;
    }

    public ExecutorManager() {
        ExecutorManager$handler$1 executorManager$handler$1 = ExecutorManager$handler$1.f9825a;
        this.d = executorManager$handler$1;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(g, h, 5, TimeUnit.SECONDS, new LinkedBlockingDeque(), Executors.defaultThreadFactory(), executorManager$handler$1);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f9823a = threadPoolExecutor;
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool(Executors.defaultThreadFactory());
        Intrinsics.checkExpressionValueIsNotNull(newCachedThreadPool, "Executors.newCachedThrea…s.defaultThreadFactory())");
        this.b = newCachedThreadPool;
    }

    public final ExecutorService b() {
        return this.b;
    }

    public final Executor c() {
        return this.c;
    }
}
