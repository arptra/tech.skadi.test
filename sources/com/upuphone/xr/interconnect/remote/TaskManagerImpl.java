package com.upuphone.xr.interconnect.remote;

import com.honey.account.view.web.WebJs;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.common.ITaskExecutor;
import com.upuphone.xr.interconnect.common.ITaskManager;
import com.upuphone.xr.interconnect.entity.ResourceDescription;
import com.upuphone.xr.interconnect.entity.RunningTask;
import com.upuphone.xr.interconnect.task.TaskManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016J(\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/upuphone/xr/interconnect/remote/TaskManagerImpl;", "Lcom/upuphone/xr/interconnect/common/ITaskManager$Stub;", "()V", "manager", "Lcom/upuphone/xr/interconnect/task/TaskManager;", "getManager", "()Lcom/upuphone/xr/interconnect/task/TaskManager;", "performAction", "", "deviceId", "", "taskId", "", "action", "queryRunning", "Lcom/upuphone/xr/interconnect/entity/RunningTask;", "executorName", "occupiedResource", "Lcom/upuphone/xr/interconnect/entity/ResourceDescription;", "registerExecutor", "name", "executor", "Lcom/upuphone/xr/interconnect/common/ITaskExecutor;", "removeRunning", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TaskManagerImpl extends ITaskManager.Stub {
    /* access modifiers changed from: private */
    public final TaskManager getManager() {
        TaskManager taskManager = InterconnectManager.getInstance().getTaskManager();
        Intrinsics.checkNotNullExpressionValue(taskManager, "getTaskManager(...)");
        return taskManager;
    }

    public void performAction(@Nullable String str, int i, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str2, WebJs.ACTION);
        getManager().performAction(str, i, str2);
    }

    @Nullable
    public RunningTask queryRunning(@Nullable String str, @Nullable String str2, @Nullable ResourceDescription resourceDescription) {
        return (RunningTask) BuildersKt__BuildersKt.b((CoroutineContext) null, new TaskManagerImpl$queryRunning$1(this, str, str2, resourceDescription, (Continuation<? super TaskManagerImpl$queryRunning$1>) null), 1, (Object) null);
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
