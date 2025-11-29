package androidx.work.impl.utils;

import android.content.Context;
import android.os.Build;
import androidx.annotation.RestrictTo;
import androidx.work.ForegroundInfo;
import androidx.work.ForegroundUpdater;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import com.honey.account.p0.g;

@RestrictTo
public class WorkForegroundRunnable implements Runnable {
    public static final String g = Logger.i("WorkForegroundRunnable");

    /* renamed from: a  reason: collision with root package name */
    public final SettableFuture f2245a = SettableFuture.s();
    public final Context b;
    public final WorkSpec c;
    public final ListenableWorker d;
    public final ForegroundUpdater e;
    public final TaskExecutor f;

    public WorkForegroundRunnable(Context context, WorkSpec workSpec, ListenableWorker listenableWorker, ForegroundUpdater foregroundUpdater, TaskExecutor taskExecutor) {
        this.b = context;
        this.c = workSpec;
        this.d = listenableWorker;
        this.e = foregroundUpdater;
        this.f = taskExecutor;
    }

    public ListenableFuture b() {
        return this.f2245a;
    }

    public final /* synthetic */ void c(SettableFuture settableFuture) {
        if (!this.f2245a.isCancelled()) {
            settableFuture.q(this.d.c());
        } else {
            settableFuture.cancel(true);
        }
    }

    public void run() {
        if (!this.c.q || Build.VERSION.SDK_INT >= 31) {
            this.f2245a.o((Object) null);
            return;
        }
        final SettableFuture s = SettableFuture.s();
        this.f.c().execute(new g(this, s));
        s.addListener(new Runnable() {
            public void run() {
                if (!WorkForegroundRunnable.this.f2245a.isCancelled()) {
                    try {
                        ForegroundInfo foregroundInfo = (ForegroundInfo) s.get();
                        if (foregroundInfo != null) {
                            Logger e = Logger.e();
                            String str = WorkForegroundRunnable.g;
                            e.a(str, "Updating notification for " + WorkForegroundRunnable.this.c.c);
                            WorkForegroundRunnable workForegroundRunnable = WorkForegroundRunnable.this;
                            workForegroundRunnable.f2245a.q(workForegroundRunnable.e.a(workForegroundRunnable.b, workForegroundRunnable.d.e(), foregroundInfo));
                            return;
                        }
                        throw new IllegalStateException("Worker was marked important (" + WorkForegroundRunnable.this.c.c + ") but did not provide ForegroundInfo");
                    } catch (Throwable th) {
                        WorkForegroundRunnable.this.f2245a.p(th);
                    }
                }
            }
        }, this.f.c());
    }
}
