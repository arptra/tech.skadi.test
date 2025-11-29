package org.apache.tika.concurrent;

import com.honey.account.gc.a;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SimpleThreadPoolExecutor extends ThreadPoolExecutor implements ConfigurableThreadPoolExecutor {
    public SimpleThreadPoolExecutor() {
        super(1, 2, 0, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a());
    }

    public static /* synthetic */ Thread b(Runnable runnable) {
        return new Thread(runnable, "Tika Executor Thread");
    }
}
