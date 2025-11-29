package io.netty.util.concurrent;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public final class ImmediateEventExecutor extends AbstractEventExecutor {
    private static final FastThreadLocal<Queue<Runnable>> DELAYED_RUNNABLES = new FastThreadLocal<Queue<Runnable>>() {
        public Queue<Runnable> initialValue() throws Exception {
            return new ArrayDeque();
        }
    };
    public static final ImmediateEventExecutor INSTANCE = new ImmediateEventExecutor();
    private static final FastThreadLocal<Boolean> RUNNING = new FastThreadLocal<Boolean>() {
        public Boolean initialValue() throws Exception {
            return Boolean.FALSE;
        }
    };
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) ImmediateEventExecutor.class);
    private final Future<?> terminationFuture = new FailedFuture(GlobalEventExecutor.INSTANCE, new UnsupportedOperationException());

    public static class ImmediateProgressivePromise<V> extends DefaultProgressivePromise<V> {
        public ImmediateProgressivePromise(EventExecutor eventExecutor) {
            super(eventExecutor);
        }

        public void checkDeadLock() {
        }
    }

    public static class ImmediatePromise<V> extends DefaultPromise<V> {
        public ImmediatePromise(EventExecutor eventExecutor) {
            super(eventExecutor);
        }

        public void checkDeadLock() {
        }
    }

    private ImmediateEventExecutor() {
    }

    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        return false;
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public void execute(java.lang.Runnable r5) {
        /*
            r4 = this;
            java.lang.String r4 = "Throwable caught while executing Runnable {}"
            java.lang.String r0 = "command"
            io.netty.util.internal.ObjectUtil.checkNotNull(r5, r0)
            io.netty.util.concurrent.FastThreadLocal<java.lang.Boolean> r0 = RUNNING
            java.lang.Object r1 = r0.get()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x0085
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            r0.set(r1)
            r5.run()     // Catch:{ all -> 0x0040 }
            io.netty.util.concurrent.FastThreadLocal<java.util.Queue<java.lang.Runnable>> r5 = DELAYED_RUNNABLES
            java.lang.Object r5 = r5.get()
            java.util.Queue r5 = (java.util.Queue) r5
        L_0x0025:
            java.lang.Object r0 = r5.poll()
            java.lang.Runnable r0 = (java.lang.Runnable) r0
            if (r0 == 0) goto L_0x0038
            r0.run()     // Catch:{ all -> 0x0031 }
            goto L_0x0025
        L_0x0031:
            r1 = move-exception
            io.netty.util.internal.logging.InternalLogger r2 = logger
            r2.info(r4, r0, r1)
            goto L_0x0025
        L_0x0038:
            io.netty.util.concurrent.FastThreadLocal<java.lang.Boolean> r4 = RUNNING
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            r4.set(r5)
            goto L_0x0090
        L_0x0040:
            r0 = move-exception
            io.netty.util.internal.logging.InternalLogger r1 = logger     // Catch:{ all -> 0x0061 }
            r1.info(r4, r5, r0)     // Catch:{ all -> 0x0061 }
            io.netty.util.concurrent.FastThreadLocal<java.util.Queue<java.lang.Runnable>> r5 = DELAYED_RUNNABLES
            java.lang.Object r5 = r5.get()
            java.util.Queue r5 = (java.util.Queue) r5
        L_0x004e:
            java.lang.Object r0 = r5.poll()
            java.lang.Runnable r0 = (java.lang.Runnable) r0
            if (r0 == 0) goto L_0x0038
            r0.run()     // Catch:{ all -> 0x005a }
            goto L_0x004e
        L_0x005a:
            r1 = move-exception
            io.netty.util.internal.logging.InternalLogger r2 = logger
            r2.info(r4, r0, r1)
            goto L_0x004e
        L_0x0061:
            r5 = move-exception
            io.netty.util.concurrent.FastThreadLocal<java.util.Queue<java.lang.Runnable>> r0 = DELAYED_RUNNABLES
            java.lang.Object r0 = r0.get()
            java.util.Queue r0 = (java.util.Queue) r0
        L_0x006a:
            java.lang.Object r1 = r0.poll()
            java.lang.Runnable r1 = (java.lang.Runnable) r1
            if (r1 == 0) goto L_0x007d
            r1.run()     // Catch:{ all -> 0x0076 }
            goto L_0x006a
        L_0x0076:
            r2 = move-exception
            io.netty.util.internal.logging.InternalLogger r3 = logger
            r3.info(r4, r1, r2)
            goto L_0x006a
        L_0x007d:
            io.netty.util.concurrent.FastThreadLocal<java.lang.Boolean> r4 = RUNNING
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r4.set(r0)
            throw r5
        L_0x0085:
            io.netty.util.concurrent.FastThreadLocal<java.util.Queue<java.lang.Runnable>> r4 = DELAYED_RUNNABLES
            java.lang.Object r4 = r4.get()
            java.util.Queue r4 = (java.util.Queue) r4
            r4.add(r5)
        L_0x0090:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.concurrent.ImmediateEventExecutor.execute(java.lang.Runnable):void");
    }

    public boolean inEventLoop() {
        return true;
    }

    public boolean isShutdown() {
        return false;
    }

    public boolean isShuttingDown() {
        return false;
    }

    public boolean isTerminated() {
        return false;
    }

    public <V> ProgressivePromise<V> newProgressivePromise() {
        return new ImmediateProgressivePromise(this);
    }

    public <V> Promise<V> newPromise() {
        return new ImmediatePromise(this);
    }

    @Deprecated
    public void shutdown() {
    }

    public Future<?> shutdownGracefully(long j, long j2, TimeUnit timeUnit) {
        return terminationFuture();
    }

    public Future<?> terminationFuture() {
        return this.terminationFuture;
    }

    public boolean inEventLoop(Thread thread) {
        return true;
    }
}
