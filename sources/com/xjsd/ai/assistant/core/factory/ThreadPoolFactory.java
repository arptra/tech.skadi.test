package com.xjsd.ai.assistant.core.factory;

import com.honey.account.constant.AccountConstantKt;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolFactory {

    public static final class NamedThreadFactory implements ThreadFactory {
        public static final AtomicInteger e = new AtomicInteger(1);

        /* renamed from: a  reason: collision with root package name */
        public String f8457a;
        public ThreadGroup b;
        public AtomicInteger c = new AtomicInteger(1);
        public String d;

        public NamedThreadFactory(String str) {
            this.f8457a = str;
            SecurityManager securityManager = System.getSecurityManager();
            this.b = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.d = this.f8457a + AccountConstantKt.CODE_SEPARTOR + e.getAndIncrement() + "#";
        }

        public Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.b;
            Thread thread = new Thread(threadGroup, runnable, this.d + this.c.getAndIncrement(), 0);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    public static ExecutorService a(String str) {
        return Executors.newCachedThreadPool(new NamedThreadFactory(str));
    }

    public static ExecutorService b(String str) {
        return Executors.newSingleThreadExecutor(new NamedThreadFactory(str));
    }
}
