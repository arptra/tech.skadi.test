package androidx.work.impl.utils;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.work.ForegroundInfo;
import androidx.work.ForegroundUpdater;
import androidx.work.Logger;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;

@RestrictTo
public class WorkForegroundUpdater implements ForegroundUpdater {
    public static final String d = Logger.i("WMFgUpdater");

    /* renamed from: a  reason: collision with root package name */
    public final TaskExecutor f2247a;
    public final ForegroundProcessor b;
    public final WorkSpecDao c;

    public WorkForegroundUpdater(WorkDatabase workDatabase, ForegroundProcessor foregroundProcessor, TaskExecutor taskExecutor) {
        this.b = foregroundProcessor;
        this.f2247a = taskExecutor;
        this.c = workDatabase.j();
    }

    public ListenableFuture a(Context context, UUID uuid, ForegroundInfo foregroundInfo) {
        SettableFuture s = SettableFuture.s();
        final SettableFuture settableFuture = s;
        final UUID uuid2 = uuid;
        final ForegroundInfo foregroundInfo2 = foregroundInfo;
        final Context context2 = context;
        this.f2247a.b(new Runnable() {
            public void run() {
                try {
                    if (!settableFuture.isCancelled()) {
                        String uuid = uuid2.toString();
                        WorkSpec y = WorkForegroundUpdater.this.c.y(uuid);
                        if (y == null || y.b.isFinished()) {
                            throw new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                        }
                        WorkForegroundUpdater.this.b.a(uuid, foregroundInfo2);
                        context2.startService(SystemForegroundDispatcher.e(context2, WorkSpecKt.a(y), foregroundInfo2));
                    }
                    settableFuture.o((Object) null);
                } catch (Throwable th) {
                    settableFuture.p(th);
                }
            }
        });
        return s;
    }
}
