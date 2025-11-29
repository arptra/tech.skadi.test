package com.rousetime.android_startup.dispatcher;

import android.content.Context;
import com.rousetime.android_startup.Startup;
import com.rousetime.android_startup.StartupListener;
import com.rousetime.android_startup.executor.ExecutorManager;
import com.rousetime.android_startup.extensions.StartupExtensionsKt;
import com.rousetime.android_startup.manager.StartupCacheManager;
import com.rousetime.android_startup.model.StartupSortStore;
import com.rousetime.android_startup.run.StartupRunnable;
import com.rousetime.android_startup.utils.StartupCostTimesUtils;
import com.rousetime.android_startup.utils.StartupLogUtils;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0015\u001a\u00020\u000e2\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J-\u0010\u001a\u001a\u00020\u000e2\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001cR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u001eR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u001cR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/rousetime/android_startup/dispatcher/StartupManagerDispatcher;", "Lcom/rousetime/android_startup/dispatcher/ManagerDispatcher;", "Landroid/content/Context;", "context", "Ljava/util/concurrent/atomic/AtomicInteger;", "needAwaitCount", "Ljava/util/concurrent/CountDownLatch;", "awaitCountDownLatch", "", "startupSize", "Lcom/rousetime/android_startup/StartupListener;", "listener", "<init>", "(Landroid/content/Context;Ljava/util/concurrent/atomic/AtomicInteger;Ljava/util/concurrent/CountDownLatch;ILcom/rousetime/android_startup/StartupListener;)V", "", "c", "()V", "Lcom/rousetime/android_startup/Startup;", "startup", "Lcom/rousetime/android_startup/model/StartupSortStore;", "sortStore", "b", "(Lcom/rousetime/android_startup/Startup;Lcom/rousetime/android_startup/model/StartupSortStore;)V", "dependencyParent", "", "result", "a", "(Lcom/rousetime/android_startup/Startup;Ljava/lang/Object;Lcom/rousetime/android_startup/model/StartupSortStore;)V", "Ljava/util/concurrent/atomic/AtomicInteger;", "count", "Landroid/content/Context;", "d", "Ljava/util/concurrent/CountDownLatch;", "e", "I", "f", "Lcom/rousetime/android_startup/StartupListener;", "android-startup_release"}, k = 1, mv = {1, 4, 0})
public final class StartupManagerDispatcher implements ManagerDispatcher {

    /* renamed from: a  reason: collision with root package name */
    public AtomicInteger f9821a;
    public final Context b;
    public final AtomicInteger c;
    public final CountDownLatch d;
    public final int e;
    public final StartupListener f;

    public StartupManagerDispatcher(Context context, AtomicInteger atomicInteger, CountDownLatch countDownLatch, int i, StartupListener startupListener) {
        this.b = context;
        this.c = atomicInteger;
        this.d = countDownLatch;
        this.e = i;
        this.f = startupListener;
    }

    public void a(Startup startup, Object obj, StartupSortStore startupSortStore) {
        if (startup.h() && !startup.g()) {
            this.c.decrementAndGet();
            CountDownLatch countDownLatch = this.d;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
        List<String> list = (List) startupSortStore.b().get(StartupExtensionsKt.a(startup.getClass()));
        if (list != null) {
            for (String str : list) {
                Startup startup2 = (Startup) startupSortStore.c().get(str);
                if (startup2 != null) {
                    startup2.b(startup, obj);
                    if (startup.i()) {
                        startup.c(startup2);
                    } else {
                        startup2.d();
                    }
                }
            }
        }
        AtomicInteger atomicInteger = this.f9821a;
        if ((atomicInteger != null ? atomicInteger.incrementAndGet() : 0) == this.e) {
            StartupCostTimesUtils.d.e();
            StartupListener startupListener = this.f;
            if (startupListener != null) {
                ExecutorManager.i.a().c().execute(new StartupManagerDispatcher$notifyChildren$2$1(startupListener));
            }
        }
    }

    public void b(Startup startup, StartupSortStore startupSortStore) {
        StartupLogUtils startupLogUtils = StartupLogUtils.b;
        startupLogUtils.b(new StartupManagerDispatcher$dispatch$1(startup));
        StartupCacheManager.Companion companion = StartupCacheManager.d;
        if (companion.a().c(startup.getClass())) {
            Object d2 = companion.a().d(startup.getClass());
            startupLogUtils.b(new StartupManagerDispatcher$dispatch$2(startup));
            a(startup, d2, startupSortStore);
            return;
        }
        StartupRunnable startupRunnable = new StartupRunnable(this.b, startup, startupSortStore, this);
        if (!startup.g()) {
            startup.e().execute(startupRunnable);
        } else {
            startupRunnable.run();
        }
    }

    public void c() {
        this.f9821a = new AtomicInteger();
        StartupCostTimesUtils.d.b();
    }
}
