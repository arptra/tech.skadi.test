package com.upuphone.runasone.utils;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CommonThreadPool {
    private static final int KEEP_ALIVE_TIME = 0;
    private static final int MAX_BLOCK_QUEUE = 10;
    private static final int MAX_CORE_POOL_SIZE = 50;
    private static final int MAX_POOL_SIZE = 60;
    /* access modifiers changed from: private */
    public static BlockingQueue<Runnable> blockQueue = new LinkedBlockingQueue(10);
    private static RejectedExecutionHandler rejectHandler = new RejectedExecutionHandler() {
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            boolean offer = CommonThreadPool.blockQueue.offer(runnable);
            LogUtil.e("线程池已满，执行拒绝策略，rejectedExecution：" + runnable.toString() + "\n hasAddedToQueue:" + offer);
        }
    };
    private static ThreadPoolExecutor threadPool = null;

    public static class ExtendedExecutor extends ThreadPoolExecutor {
        public ExtendedExecutor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue) {
            super(i, i2, j, timeUnit, blockingQueue);
        }

        public void afterExecute(Runnable runnable, Throwable th) {
            super.afterExecute(runnable, th);
            if (th == null && (runnable instanceof Future)) {
                try {
                    ((Future) runnable).get();
                } catch (CancellationException e) {
                    th = e;
                } catch (ExecutionException e2) {
                    th = e2.getCause();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
            if (th != null) {
                LogUtil.e("method 有问题");
            }
        }

        public ExtendedExecutor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
            super(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
        }
    }

    public static synchronized void execute(Runnable runnable) {
        synchronized (CommonThreadPool.class) {
            try {
                LogUtil.d("CommonThreadPool execute:" + runnable.toString());
                if (threadPool == null) {
                    synchronized (CommonThreadPool.class) {
                        if (threadPool == null) {
                            threadPool = new ThreadPoolExecutor(50, 60, 0, TimeUnit.SECONDS, new ArrayBlockingQueue(10), new ThreadFactoryBuilder().setNameFormat("RunAsOne-ThreadPool-%d").build(), rejectHandler);
                            LogUtil.d("创建通用线程池 CommonThreadPool ----> ");
                        }
                    }
                }
                int activeCount = threadPool.getActiveCount();
                int size = threadPool.getQueue().size();
                long completedTaskCount = threadPool.getCompletedTaskCount();
                long taskCount = threadPool.getTaskCount();
                LogUtil.d("当前活动线程数：" + activeCount + " 当前排队线程数：" + size + " 已完成线程数：" + completedTaskCount + " 总线程数：" + taskCount);
                LogUtil.d("启动线程 -----> ");
                threadPool.execute(runnable);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static synchronized void shutdown() {
        synchronized (CommonThreadPool.class) {
            LogUtil.d("终止调度线程池：" + threadPool);
            ThreadPoolExecutor threadPoolExecutor = threadPool;
            if (threadPoolExecutor != null) {
                threadPoolExecutor.shutdown();
                threadPool = null;
            }
        }
    }
}
