package com.upuphone.xr.interconnect.business.databinder;

import com.upuphone.xr.interconnect.business.databinder.DataBinderDeviceEvent;
import com.upuphone.xr.interconnect.util.statemachine.FlowExtKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Semaphore;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nDataBinderManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DataBinderManager.kt\ncom/upuphone/xr/interconnect/business/databinder/DataBinderManager$handle$1\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,252:1\n81#2,7:253\n89#2:262\n88#2:263\n13309#3,2:260\n*S KotlinDebug\n*F\n+ 1 DataBinderManager.kt\ncom/upuphone/xr/interconnect/business/databinder/DataBinderManager$handle$1\n*L\n239#1:253,7\n239#1:262\n239#1:263\n240#1:260,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.interconnect.business.databinder.DataBinderManager$handle$1", f = "DataBinderManager.kt", i = {0}, l = {257}, m = "invokeSuspend", n = {"$this$withPermit$iv"}, s = {"L$0"})
public final class DataBinderManager$handle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $deviceId;
    final /* synthetic */ DataBinderOperation[] $operationList;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ DataBinderManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataBinderManager$handle$1(DataBinderManager dataBinderManager, DataBinderOperation[] dataBinderOperationArr, String str, Continuation<? super DataBinderManager$handle$1> continuation) {
        super(2, continuation);
        this.this$0 = dataBinderManager;
        this.$operationList = dataBinderOperationArr;
        this.$deviceId = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DataBinderManager$handle$1(this.this$0, this.$operationList, this.$deviceId, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Semaphore semaphore;
        DataBinderOperation[] dataBinderOperationArr;
        DataBinderManager dataBinderManager;
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Semaphore access$getEventFlowLock$p = this.this$0.eventFlowLock;
            dataBinderOperationArr = this.$operationList;
            dataBinderManager = this.this$0;
            String str2 = this.$deviceId;
            this.L$0 = access$getEventFlowLock$p;
            this.L$1 = dataBinderOperationArr;
            this.L$2 = dataBinderManager;
            this.L$3 = str2;
            this.label = 1;
            if (access$getEventFlowLock$p.b(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            semaphore = access$getEventFlowLock$p;
            str = str2;
        } else if (i == 1) {
            str = (String) this.L$3;
            dataBinderManager = (DataBinderManager) this.L$2;
            dataBinderOperationArr = (DataBinderOperation[]) this.L$1;
            semaphore = (Semaphore) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        try {
            Intrinsics.checkNotNull(dataBinderOperationArr);
            for (DataBinderOperation handleOperation : dataBinderOperationArr) {
                FlowExtKt.emitOrErr(dataBinderManager.eventFlow, new DataBinderDeviceEvent.HandleOperation(str, handleOperation));
            }
            Unit unit = Unit.INSTANCE;
            semaphore.release();
            return Unit.INSTANCE;
        } catch (Throwable th) {
            semaphore.release();
            throw th;
        }
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DataBinderManager$handle$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
