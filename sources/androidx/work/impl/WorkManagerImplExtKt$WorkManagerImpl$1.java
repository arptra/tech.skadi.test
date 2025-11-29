package androidx.work.impl;

import android.content.Context;
import androidx.work.Configuration;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public /* synthetic */ class WorkManagerImplExtKt$WorkManagerImpl$1 extends FunctionReferenceImpl implements Function6<Context, Configuration, TaskExecutor, WorkDatabase, Trackers, Processor, List<? extends Scheduler>> {
    public static final WorkManagerImplExtKt$WorkManagerImpl$1 INSTANCE = new WorkManagerImplExtKt$WorkManagerImpl$1();

    public WorkManagerImplExtKt$WorkManagerImpl$1() {
        super(6, WorkManagerImplExtKt.class, "createSchedulers", "createSchedulers(Landroid/content/Context;Landroidx/work/Configuration;Landroidx/work/impl/utils/taskexecutor/TaskExecutor;Landroidx/work/impl/WorkDatabase;Landroidx/work/impl/constraints/trackers/Trackers;Landroidx/work/impl/Processor;)Ljava/util/List;", 1);
    }

    @NotNull
    public final List<Scheduler> invoke(@NotNull Context context, @NotNull Configuration configuration, @NotNull TaskExecutor taskExecutor, @NotNull WorkDatabase workDatabase, @NotNull Trackers trackers, @NotNull Processor processor) {
        Intrinsics.checkNotNullParameter(context, "p0");
        Intrinsics.checkNotNullParameter(configuration, "p1");
        Intrinsics.checkNotNullParameter(taskExecutor, "p2");
        Intrinsics.checkNotNullParameter(workDatabase, "p3");
        Intrinsics.checkNotNullParameter(trackers, "p4");
        Intrinsics.checkNotNullParameter(processor, "p5");
        return WorkManagerImplExtKt.b(context, configuration, taskExecutor, workDatabase, trackers, processor);
    }
}
