package com.honey.account.utils.thread;

import com.honey.account.j2.a;
import com.honey.account.j2.b;
import com.honey.account.j2.c;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J(\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fJ0\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fJ0\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/honey/account/utils/thread/ScheduledExecutor;", "Ljava/util/concurrent/Executor;", "()V", "mThreadPool", "Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "execute", "", "command", "Ljava/lang/Runnable;", "schedule", "Ljava/util/concurrent/ScheduledFuture;", "delay", "", "unit", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/Function0;", "scheduleAtFixedRate", "initialDelay", "period", "scheduleWithFixedDelay", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ScheduledExecutor implements Executor {
    @NotNull
    public static final ScheduledExecutor INSTANCE = new ScheduledExecutor();
    @NotNull
    private static final ScheduledThreadPoolExecutor mThreadPool = new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors() + 1, new ThreadFactory() {
        @NotNull
        private final AtomicInteger threadCount = new AtomicInteger(0);

        @NotNull
        public Thread newThread(@Nullable Runnable runnable) {
            if (this.threadCount.get() == Integer.MAX_VALUE) {
                this.threadCount.set(0);
            }
            return new Thread(runnable, "ScheduleTask#" + this.threadCount.incrementAndGet());
        }
    });

    private ScheduledExecutor() {
    }

    /* access modifiers changed from: private */
    public static final void schedule$lambda$0(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$tmp0");
        function0.invoke();
    }

    /* access modifiers changed from: private */
    public static final void scheduleAtFixedRate$lambda$1(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$tmp0");
        function0.invoke();
    }

    /* access modifiers changed from: private */
    public static final void scheduleWithFixedDelay$lambda$2(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$tmp0");
        function0.invoke();
    }

    public void execute(@NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "command");
        mThreadPool.schedule(runnable, 0, TimeUnit.NANOSECONDS);
    }

    @NotNull
    public final ScheduledFuture<?> schedule(long j, @NotNull TimeUnit timeUnit, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(timeUnit, "unit");
        Intrinsics.checkNotNullParameter(function0, "command");
        ScheduledFuture<?> schedule = mThreadPool.schedule(new b(function0), j, timeUnit);
        Intrinsics.checkNotNullExpressionValue(schedule, "schedule(...)");
        return schedule;
    }

    @NotNull
    public final ScheduledFuture<?> scheduleAtFixedRate(long j, long j2, @NotNull TimeUnit timeUnit, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(timeUnit, "unit");
        Intrinsics.checkNotNullParameter(function0, "command");
        ScheduledFuture<?> scheduleAtFixedRate = mThreadPool.scheduleAtFixedRate(new a(function0), j, j2, timeUnit);
        Intrinsics.checkNotNullExpressionValue(scheduleAtFixedRate, "scheduleAtFixedRate(...)");
        return scheduleAtFixedRate;
    }

    @NotNull
    public final ScheduledFuture<?> scheduleWithFixedDelay(long j, long j2, @NotNull TimeUnit timeUnit, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(timeUnit, "unit");
        Intrinsics.checkNotNullParameter(function0, "command");
        ScheduledFuture<?> scheduleWithFixedDelay = mThreadPool.scheduleWithFixedDelay(new c(function0), j, j2, timeUnit);
        Intrinsics.checkNotNullExpressionValue(scheduleWithFixedDelay, "scheduleWithFixedDelay(...)");
        return scheduleWithFixedDelay;
    }
}
