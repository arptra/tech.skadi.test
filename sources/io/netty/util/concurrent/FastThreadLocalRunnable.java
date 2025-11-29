package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;

final class FastThreadLocalRunnable implements Runnable {
    private final Runnable runnable;

    private FastThreadLocalRunnable(Runnable runnable2) {
        this.runnable = (Runnable) ObjectUtil.checkNotNull(runnable2, "runnable");
    }

    public static Runnable wrap(Runnable runnable2) {
        return runnable2 instanceof FastThreadLocalRunnable ? runnable2 : new FastThreadLocalRunnable(runnable2);
    }

    public void run() {
        try {
            this.runnable.run();
        } finally {
            FastThreadLocal.removeAll();
        }
    }
}
