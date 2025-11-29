package com.upuphone.xr.interconnect.outer;

import com.honey.account.view.web.WebJs;
import com.upuphone.xr.interconnect.api.RunningTaskDelegate;
import com.upuphone.xr.interconnect.api.TaskOperator;
import com.upuphone.xr.interconnect.common.ITaskExecutor;
import com.upuphone.xr.interconnect.entity.ResourceDescription;
import com.upuphone.xr.interconnect.entity.RunningTask;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0016J(\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0004JM\u0010\u0018\u001a\u0004\u0018\u0001H\u0019\"\u0004\b\u0000\u0010\u001a\"\u0004\b\u0001\u0010\u00192\u0017\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u001a0\u001c¢\u0006\u0002\b\u001d2\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u0002H\u00190\u001c¢\u0006\u0002\b\u001dH\u0002¢\u0006\u0002\u0010\u001fR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/upuphone/xr/interconnect/outer/TaskOperatorImpl;", "Lcom/upuphone/xr/interconnect/api/TaskOperator;", "()V", "provider", "Lcom/upuphone/xr/interconnect/outer/SuperServiceProvider;", "performAction", "", "deviceId", "", "taskId", "", "action", "queryRunning", "Lcom/upuphone/xr/interconnect/entity/RunningTask;", "executorName", "occupiedResource", "Lcom/upuphone/xr/interconnect/entity/ResourceDescription;", "registerExecutor", "name", "executor", "Lcom/upuphone/xr/interconnect/common/ITaskExecutor;", "removeRunning", "setProvider", "superServiceProvider", "withService", "T", "S", "getService", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "block", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TaskOperatorImpl implements TaskOperator {
    @Nullable
    private SuperServiceProvider provider;

    private final <S, T> T withService(Function1<? super SuperServiceProvider, ? extends S> function1, Function1<? super S, ? extends T> function12) {
        Object invoke;
        SuperServiceProvider superServiceProvider = this.provider;
        if (superServiceProvider == null || (invoke = function1.invoke(superServiceProvider)) == null) {
            return null;
        }
        try {
            return function12.invoke(invoke);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Nullable
    public RunningTaskDelegate getRunning(@Nullable String str, @Nullable String str2, @Nullable ResourceDescription resourceDescription) {
        return TaskOperator.DefaultImpls.getRunning(this, str, str2, resourceDescription);
    }

    public void performAction(@Nullable String str, int i, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str2, WebJs.ACTION);
        withService(TaskOperatorImpl$performAction$1.INSTANCE, new TaskOperatorImpl$performAction$2(str, i, str2));
    }

    @Nullable
    public RunningTask queryRunning(@Nullable String str, @Nullable String str2, @Nullable ResourceDescription resourceDescription) {
        return (RunningTask) withService(TaskOperatorImpl$queryRunning$1.INSTANCE, new TaskOperatorImpl$queryRunning$2(str, str2, resourceDescription));
    }

    public void registerExecutor(@NotNull String str, @NotNull ITaskExecutor iTaskExecutor) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(iTaskExecutor, "executor");
        withService(TaskOperatorImpl$registerExecutor$1.INSTANCE, new TaskOperatorImpl$registerExecutor$2(str, iTaskExecutor));
    }

    public void removeRunning(int i) {
        withService(TaskOperatorImpl$removeRunning$1.INSTANCE, new TaskOperatorImpl$removeRunning$2(i));
    }

    public final void setProvider(@NotNull SuperServiceProvider superServiceProvider) {
        Intrinsics.checkNotNullParameter(superServiceProvider, "superServiceProvider");
        this.provider = superServiceProvider;
    }
}
