package com.upuphone.xr.interconnect.business.databinder;

import com.upuphone.xr.interconnect.business.databinder.DataBinderDeviceEvent;
import com.upuphone.xr.interconnect.common.IDataBinderItemUpdateListener;
import com.upuphone.xr.interconnect.util.statemachine.FlowExtKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Semaphore;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nDataBinderManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DataBinderManager.kt\ncom/upuphone/xr/interconnect/business/databinder/DataBinderManager$unsubscribe$2\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n*L\n1#1,252:1\n81#2,9:253\n*S KotlinDebug\n*F\n+ 1 DataBinderManager.kt\ncom/upuphone/xr/interconnect/business/databinder/DataBinderManager$unsubscribe$2\n*L\n209#1:253,9\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.interconnect.business.databinder.DataBinderManager$unsubscribe$2", f = "DataBinderManager.kt", i = {0}, l = {257}, m = "invokeSuspend", n = {"$this$withPermit$iv"}, s = {"L$0"})
public final class DataBinderManager$unsubscribe$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $deviceId;
    final /* synthetic */ IDataBinderItemUpdateListener $listener;
    final /* synthetic */ String $name;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ DataBinderManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataBinderManager$unsubscribe$2(DataBinderManager dataBinderManager, String str, String str2, IDataBinderItemUpdateListener iDataBinderItemUpdateListener, Continuation<? super DataBinderManager$unsubscribe$2> continuation) {
        super(2, continuation);
        this.this$0 = dataBinderManager;
        this.$deviceId = str;
        this.$name = str2;
        this.$listener = iDataBinderItemUpdateListener;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DataBinderManager$unsubscribe$2(this.this$0, this.$deviceId, this.$name, this.$listener, continuation);
    }

    /* JADX INFO: finally extract failed */
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Semaphore semaphore;
        DataBinderManager dataBinderManager;
        String str;
        String str2;
        IDataBinderItemUpdateListener iDataBinderItemUpdateListener;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Semaphore access$getEventFlowLock$p = this.this$0.eventFlowLock;
            dataBinderManager = this.this$0;
            String str3 = this.$deviceId;
            String str4 = this.$name;
            IDataBinderItemUpdateListener iDataBinderItemUpdateListener2 = this.$listener;
            this.L$0 = access$getEventFlowLock$p;
            this.L$1 = dataBinderManager;
            this.L$2 = str3;
            this.L$3 = str4;
            this.L$4 = iDataBinderItemUpdateListener2;
            this.label = 1;
            if (access$getEventFlowLock$p.b(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            semaphore = access$getEventFlowLock$p;
            str = str3;
            str2 = str4;
            iDataBinderItemUpdateListener = iDataBinderItemUpdateListener2;
        } else if (i == 1) {
            iDataBinderItemUpdateListener = (IDataBinderItemUpdateListener) this.L$4;
            str2 = (String) this.L$3;
            str = (String) this.L$2;
            dataBinderManager = (DataBinderManager) this.L$1;
            semaphore = (Semaphore) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        try {
            FlowExtKt.emitOrErr(dataBinderManager.eventFlow, new DataBinderDeviceEvent.UnsubscribeInner(str, str2, iDataBinderItemUpdateListener));
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
        return ((DataBinderManager$unsubscribe$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
