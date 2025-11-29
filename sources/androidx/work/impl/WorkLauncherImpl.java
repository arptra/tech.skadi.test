package androidx.work.impl;

import androidx.work.WorkerParameters;
import androidx.work.impl.utils.StartWorkRunnable;
import androidx.work.impl.utils.StopWorkRunnable;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Landroidx/work/impl/WorkLauncherImpl;", "Landroidx/work/impl/WorkLauncher;", "Landroidx/work/impl/Processor;", "processor", "Landroidx/work/impl/utils/taskexecutor/TaskExecutor;", "workTaskExecutor", "<init>", "(Landroidx/work/impl/Processor;Landroidx/work/impl/utils/taskexecutor/TaskExecutor;)V", "Landroidx/work/impl/StartStopToken;", "workSpecId", "Landroidx/work/WorkerParameters$RuntimeExtras;", "runtimeExtras", "", "c", "(Landroidx/work/impl/StartStopToken;Landroidx/work/WorkerParameters$RuntimeExtras;)V", "", "reason", "d", "(Landroidx/work/impl/StartStopToken;I)V", "a", "Landroidx/work/impl/Processor;", "getProcessor", "()Landroidx/work/impl/Processor;", "b", "Landroidx/work/impl/utils/taskexecutor/TaskExecutor;", "getWorkTaskExecutor", "()Landroidx/work/impl/utils/taskexecutor/TaskExecutor;", "work-runtime_release"}, k = 1, mv = {1, 8, 0})
public final class WorkLauncherImpl implements WorkLauncher {

    /* renamed from: a  reason: collision with root package name */
    public final Processor f2104a;
    public final TaskExecutor b;

    public WorkLauncherImpl(Processor processor, TaskExecutor taskExecutor) {
        Intrinsics.checkNotNullParameter(processor, "processor");
        Intrinsics.checkNotNullParameter(taskExecutor, "workTaskExecutor");
        this.f2104a = processor;
        this.b = taskExecutor;
    }

    public void c(StartStopToken startStopToken, WorkerParameters.RuntimeExtras runtimeExtras) {
        Intrinsics.checkNotNullParameter(startStopToken, "workSpecId");
        this.b.b(new StartWorkRunnable(this.f2104a, startStopToken, runtimeExtras));
    }

    public void d(StartStopToken startStopToken, int i) {
        Intrinsics.checkNotNullParameter(startStopToken, "workSpecId");
        this.b.b(new StopWorkRunnable(this.f2104a, startStopToken, false, i));
    }
}
