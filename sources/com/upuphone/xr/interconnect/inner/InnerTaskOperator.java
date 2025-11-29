package com.upuphone.xr.interconnect.inner;

import com.honey.account.view.web.WebJs;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.api.RunningTaskDelegate;
import com.upuphone.xr.interconnect.api.TaskOperator;
import com.upuphone.xr.interconnect.common.ITaskExecutor;
import com.upuphone.xr.interconnect.entity.ResourceDescription;
import com.upuphone.xr.interconnect.entity.RunningTask;
import com.upuphone.xr.interconnect.task.TaskManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J(\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0016R\u001c\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/upuphone/xr/interconnect/inner/InnerTaskOperator;", "Lcom/upuphone/xr/interconnect/api/TaskOperator;", "()V", "manager", "Lcom/upuphone/xr/interconnect/task/TaskManager;", "kotlin.jvm.PlatformType", "getManager", "()Lcom/upuphone/xr/interconnect/task/TaskManager;", "performAction", "", "deviceId", "", "taskId", "", "action", "queryRunning", "Lcom/upuphone/xr/interconnect/entity/RunningTask;", "executorName", "occupiedResource", "Lcom/upuphone/xr/interconnect/entity/ResourceDescription;", "registerExecutor", "name", "executor", "Lcom/upuphone/xr/interconnect/common/ITaskExecutor;", "removeRunning", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class InnerTaskOperator implements TaskOperator {
    /* access modifiers changed from: private */
    public final TaskManager getManager() {
        return InterconnectManager.getInstance().getTaskManager();
    }

    @Nullable
    public RunningTaskDelegate getRunning(@Nullable String str, @Nullable String str2, @Nullable ResourceDescription resourceDescription) {
        return TaskOperator.DefaultImpls.getRunning(this, str, str2, resourceDescription);
    }

    public void performAction(@Nullable String str, int i, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str2, WebJs.ACTION);
        getManager().performAction(str, i, str2);
    }

    @Nullable
    public RunningTask queryRunning(@Nullable String str, @Nullable String str2, @Nullable ResourceDescription resourceDescription) {
        return (RunningTask) BuildersKt__BuildersKt.b((CoroutineContext) null, new InnerTaskOperator$queryRunning$1(this, str, str2, resourceDescription, (Continuation<? super InnerTaskOperator$queryRunning$1>) null), 1, (Object) null);
    }

    public void registerExecutor(@NotNull String str, @NotNull ITaskExecutor iTaskExecutor) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(iTaskExecutor, "executor");
        getManager().registerExecutor(str, iTaskExecutor);
    }

    public void removeRunning(int i) {
        getManager().removeRunning(i);
    }
}
