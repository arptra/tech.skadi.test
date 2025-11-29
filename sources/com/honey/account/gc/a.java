package com.honey.account.gc;

import java.util.concurrent.ThreadFactory;
import org.apache.tika.concurrent.SimpleThreadPoolExecutor;

public final /* synthetic */ class a implements ThreadFactory {
    public final Thread newThread(Runnable runnable) {
        return SimpleThreadPoolExecutor.b(runnable);
    }
}
