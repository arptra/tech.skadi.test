package com.upuphone.ar.translation.interconnect;

import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.xr.interconnect.entity.PermissionResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.interconnect.TransInterConnectManager$requestAiModelPermission$1$permissonResult$1", f = "TransInterConnectManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TransInterConnectManager$requestAiModelPermission$1$permissonResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Boolean, Unit> $callBack;
    final /* synthetic */ PermissionResult $result;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TransInterConnectManager$requestAiModelPermission$1$permissonResult$1(PermissionResult permissionResult, Function1<? super Boolean, Unit> function1, Continuation<? super TransInterConnectManager$requestAiModelPermission$1$permissonResult$1> continuation) {
        super(2, continuation);
        this.$result = permissionResult;
        this.$callBack = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TransInterConnectManager$requestAiModelPermission$1$permissonResult$1 transInterConnectManager$requestAiModelPermission$1$permissonResult$1 = new TransInterConnectManager$requestAiModelPermission$1$permissonResult$1(this.$result, this.$callBack, continuation);
        transInterConnectManager$requestAiModelPermission$1$permissonResult$1.L$0 = obj;
        return transInterConnectManager$requestAiModelPermission$1$permissonResult$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Unit unit;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            PermissionResult permissionResult = this.$result;
            if (permissionResult != null) {
                Function1<Boolean, Unit> function1 = this.$callBack;
                boolean isResult = permissionResult.isResult();
                LogExt.j("requestAiModelPermission result=" + isResult, "TransInterConnectManager");
                function1.invoke(Boxing.boxBoolean(isResult));
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                this.$callBack.invoke(Boxing.boxBoolean(false));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TransInterConnectManager$requestAiModelPermission$1$permissonResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
