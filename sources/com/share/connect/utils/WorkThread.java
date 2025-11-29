package com.share.connect.utils;

import android.os.SystemClock;
import com.easy.logger.EasyLog;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class WorkThread {
    public static final TimeUnit b = TimeUnit.SECONDS;
    public static final BlockingQueue c = new SynchronousQueue();

    /* renamed from: a  reason: collision with root package name */
    public ExecutorService f9920a;

    public static class HOLDER {

        /* renamed from: a  reason: collision with root package name */
        public static WorkThread f9922a = new WorkThread();
    }

    public static void a(final Runnable runnable, final String str) {
        EasyLog.e("WorkThread", "Submit task: " + str);
        try {
            HOLDER.f9922a.f9920a.submit(new Runnable() {
                public void run() {
                    long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
                    EasyLog.e("WorkThread", "Executing task: " + str + "[" + currentThreadTimeMillis + "]");
                    runnable.run();
                    EasyLog.e("WorkThread", "Task: " + str + "[" + currentThreadTimeMillis + "] executed.");
                }
            });
        } catch (RejectedExecutionException e) {
            EasyLog.d("WorkThread", "Submit runnable failed with RejectedExecutionException.", e);
        } catch (Exception e2) {
            EasyLog.d("WorkThread", "Submit runnable failed.", e2);
        }
    }

    public WorkThread() {
        this.f9920a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 20, b, c);
    }
}
