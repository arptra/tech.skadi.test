package com.upuphone.xr.interconnect.remote;

import com.upuphone.xr.interconnect.entity.ResourceDescription;
import com.upuphone.xr.interconnect.entity.RunningTask;
import com.upuphone.xr.interconnect.task.TaskManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/upuphone/xr/interconnect/entity/RunningTask;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.interconnect.remote.TaskManagerImpl$queryRunning$1", f = "TaskManagerImpl.kt", i = {}, l = {18}, m = "invokeSuspend", n = {}, s = {})
public final class TaskManagerImpl$queryRunning$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super RunningTask>, Object> {
    final /* synthetic */ String $deviceId;
    final /* synthetic */ String $executorName;
    final /* synthetic */ ResourceDescription $occupiedResource;
    int label;
    final /* synthetic */ TaskManagerImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TaskManagerImpl$queryRunning$1(TaskManagerImpl taskManagerImpl, String str, String str2, ResourceDescription resourceDescription, Continuation<? super TaskManagerImpl$queryRunning$1> continuation) {
        super(2, continuation);
        this.this$0 = taskManagerImpl;
        this.$deviceId = str;
        this.$executorName = str2;
        this.$occupiedResource = resourceDescription;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TaskManagerImpl$queryRunning$1(this.this$0, this.$deviceId, this.$executorName, this.$occupiedResource, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            TaskManager access$getManager = this.this$0.getManager();
            String str = this.$deviceId;
            String str2 = this.$executorName;
            ResourceDescription resourceDescription = this.$occupiedResource;
            this.label = 1;
            obj = access$getManager.queryRunning(str, str2, resourceDescription, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super RunningTask> continuation) {
        return ((TaskManagerImpl$queryRunning$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
