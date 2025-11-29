package androidx.work.impl.workers;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/work/impl/workers/DiagnosticsWorker;", "Landroidx/work/Worker;", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "parameters", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Landroidx/work/ListenableWorker$Result;", "p", "()Landroidx/work/ListenableWorker$Result;", "work-runtime_release"}, k = 1, mv = {1, 8, 0})
public final class DiagnosticsWorker extends Worker {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DiagnosticsWorker(@NotNull Context context, @NotNull WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerParameters, "parameters");
    }

    public ListenableWorker.Result p() {
        WorkManagerImpl k = WorkManagerImpl.k(a());
        Intrinsics.checkNotNullExpressionValue(k, "getInstance(applicationContext)");
        WorkDatabase p = k.p();
        Intrinsics.checkNotNullExpressionValue(p, "workManager.workDatabase");
        WorkSpecDao j = p.j();
        WorkNameDao h = p.h();
        WorkTagDao k2 = p.k();
        SystemIdInfoDao g = p.g();
        List v = j.v(k.i().a().currentTimeMillis() - TimeUnit.DAYS.toMillis(1));
        List E = j.E();
        List k3 = j.k(200);
        if (!v.isEmpty()) {
            Logger.e().f(DiagnosticsWorkerKt.f2263a, "Recently completed work:\n\n");
            Logger.e().f(DiagnosticsWorkerKt.f2263a, DiagnosticsWorkerKt.d(h, k2, g, v));
        }
        if (!E.isEmpty()) {
            Logger.e().f(DiagnosticsWorkerKt.f2263a, "Running work:\n\n");
            Logger.e().f(DiagnosticsWorkerKt.f2263a, DiagnosticsWorkerKt.d(h, k2, g, E));
        }
        if (!k3.isEmpty()) {
            Logger.e().f(DiagnosticsWorkerKt.f2263a, "Enqueued work:\n\n");
            Logger.e().f(DiagnosticsWorkerKt.f2263a, DiagnosticsWorkerKt.d(h, k2, g, k3));
        }
        ListenableWorker.Result c = ListenableWorker.Result.c();
        Intrinsics.checkNotNullExpressionValue(c, "success()");
        return c;
    }
}
