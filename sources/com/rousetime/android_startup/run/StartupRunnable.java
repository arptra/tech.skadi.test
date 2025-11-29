package com.rousetime.android_startup.run;

import android.content.Context;
import android.os.Process;
import androidx.core.os.TraceCompat;
import com.rousetime.android_startup.Startup;
import com.rousetime.android_startup.annotation.ThreadPriority;
import com.rousetime.android_startup.dispatcher.ManagerDispatcher;
import com.rousetime.android_startup.manager.StartupCacheManager;
import com.rousetime.android_startup.model.ResultModel;
import com.rousetime.android_startup.model.StartupSortStore;
import com.rousetime.android_startup.utils.StartupCostTimesUtils;
import com.rousetime.android_startup.utils.StartupLogUtils;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/rousetime/android_startup/run/StartupRunnable;", "Ljava/lang/Runnable;", "Landroid/content/Context;", "context", "Lcom/rousetime/android_startup/Startup;", "startup", "Lcom/rousetime/android_startup/model/StartupSortStore;", "sortStore", "Lcom/rousetime/android_startup/dispatcher/ManagerDispatcher;", "dispatcher", "<init>", "(Landroid/content/Context;Lcom/rousetime/android_startup/Startup;Lcom/rousetime/android_startup/model/StartupSortStore;Lcom/rousetime/android_startup/dispatcher/ManagerDispatcher;)V", "", "run", "()V", "a", "Landroid/content/Context;", "b", "Lcom/rousetime/android_startup/Startup;", "c", "Lcom/rousetime/android_startup/model/StartupSortStore;", "d", "Lcom/rousetime/android_startup/dispatcher/ManagerDispatcher;", "android-startup_release"}, k = 1, mv = {1, 4, 0})
public final class StartupRunnable implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final Context f9833a;
    public final Startup b;
    public final StartupSortStore c;
    public final ManagerDispatcher d;

    public StartupRunnable(Context context, Startup startup, StartupSortStore startupSortStore, ManagerDispatcher managerDispatcher) {
        this.f9833a = context;
        this.b = startup;
        this.c = startupSortStore;
        this.d = managerDispatcher;
    }

    public void run() {
        ThreadPriority threadPriority = (ThreadPriority) this.b.getClass().getAnnotation(ThreadPriority.class);
        Process.setThreadPriority(threadPriority != null ? threadPriority.priority() : 0);
        this.b.j();
        StartupLogUtils startupLogUtils = StartupLogUtils.b;
        startupLogUtils.b(new StartupRunnable$run$1(this));
        TraceCompat.a(this.b.getClass().getSimpleName());
        StartupCostTimesUtils startupCostTimesUtils = StartupCostTimesUtils.d;
        startupCostTimesUtils.g(new StartupRunnable$run$2(this));
        Object a2 = this.b.a(this.f9833a);
        startupCostTimesUtils.f(new StartupRunnable$run$3(this));
        TraceCompat.b();
        StartupCacheManager.d.a().f(this.b.getClass(), new ResultModel(a2));
        startupLogUtils.b(new StartupRunnable$run$4(this));
        this.d.a(this.b, a2, this.c);
    }
}
