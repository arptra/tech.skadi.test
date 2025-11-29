package androidx.work.impl;

import android.content.Context;
import androidx.work.Configuration;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\n¢\u0006\u0002\b\u000f"}, d2 = {"<anonymous>", "", "Landroidx/work/impl/Scheduler;", "<anonymous parameter 0>", "Landroid/content/Context;", "<anonymous parameter 1>", "Landroidx/work/Configuration;", "<anonymous parameter 2>", "Landroidx/work/impl/utils/taskexecutor/TaskExecutor;", "<anonymous parameter 3>", "Landroidx/work/impl/WorkDatabase;", "<anonymous parameter 4>", "Landroidx/work/impl/constraints/trackers/Trackers;", "<anonymous parameter 5>", "Landroidx/work/impl/Processor;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class WorkManagerImplExtKt$schedulers$1 extends Lambda implements Function6<Context, Configuration, TaskExecutor, WorkDatabase, Trackers, Processor, List<? extends Scheduler>> {
    final /* synthetic */ Scheduler[] $schedulers;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WorkManagerImplExtKt$schedulers$1(Scheduler[] schedulerArr) {
        super(6);
        this.$schedulers = schedulerArr;
    }

    @NotNull
    public final List<Scheduler> invoke(@NotNull Context context, @NotNull Configuration configuration, @NotNull TaskExecutor taskExecutor, @NotNull WorkDatabase workDatabase, @NotNull Trackers trackers, @NotNull Processor processor) {
        Intrinsics.checkNotNullParameter(context, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(configuration, "<anonymous parameter 1>");
        Intrinsics.checkNotNullParameter(taskExecutor, "<anonymous parameter 2>");
        Intrinsics.checkNotNullParameter(workDatabase, "<anonymous parameter 3>");
        Intrinsics.checkNotNullParameter(trackers, "<anonymous parameter 4>");
        Intrinsics.checkNotNullParameter(processor, "<anonymous parameter 5>");
        return ArraysKt.toList((T[]) this.$schedulers);
    }
}
