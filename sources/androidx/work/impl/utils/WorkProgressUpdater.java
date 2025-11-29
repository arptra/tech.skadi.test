package androidx.work.impl.utils;

import androidx.annotation.RestrictTo;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.ProgressUpdater;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.WorkProgress;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.UUID;

@RestrictTo
public class WorkProgressUpdater implements ProgressUpdater {
    public static final String c = Logger.i("WorkProgressUpdater");

    /* renamed from: a  reason: collision with root package name */
    public final WorkDatabase f2249a;
    public final TaskExecutor b;

    /* renamed from: androidx.work.impl.utils.WorkProgressUpdater$1  reason: invalid class name */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UUID f2250a;
        public final /* synthetic */ Data b;
        public final /* synthetic */ SettableFuture c;
        public final /* synthetic */ WorkProgressUpdater d;

        public void run() {
            String uuid = this.f2250a.toString();
            Logger e = Logger.e();
            String str = WorkProgressUpdater.c;
            e.a(str, "Updating progress for " + this.f2250a + " (" + this.b + ")");
            this.d.f2249a.beginTransaction();
            try {
                WorkSpec y = this.d.f2249a.j().y(uuid);
                if (y != null) {
                    if (y.b == WorkInfo.State.RUNNING) {
                        this.d.f2249a.i().c(new WorkProgress(uuid, this.b));
                    } else {
                        Logger e2 = Logger.e();
                        e2.k(str, "Ignoring setProgressAsync(...). WorkSpec (" + uuid + ") is not in a RUNNING state.");
                    }
                    this.c.o((Object) null);
                    this.d.f2249a.setTransactionSuccessful();
                    this.d.f2249a.endTransaction();
                    return;
                }
                throw new IllegalStateException("Calls to setProgressAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
            } catch (Throwable th) {
                this.d.f2249a.endTransaction();
                throw th;
            }
        }
    }

    public WorkProgressUpdater(WorkDatabase workDatabase, TaskExecutor taskExecutor) {
        this.f2249a = workDatabase;
        this.b = taskExecutor;
    }
}
