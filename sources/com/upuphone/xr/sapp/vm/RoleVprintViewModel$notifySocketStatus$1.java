package com.upuphone.xr.sapp.vm;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.vm.RoleVprintViewModel$notifySocketStatus$1", f = "RoleVprintViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RoleVprintViewModel$notifySocketStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $status;
    int label;
    final /* synthetic */ RoleVprintViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RoleVprintViewModel$notifySocketStatus$1(RoleVprintViewModel roleVprintViewModel, int i, Continuation<? super RoleVprintViewModel$notifySocketStatus$1> continuation) {
        super(2, continuation);
        this.this$0 = roleVprintViewModel;
        this.$status = i;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RoleVprintViewModel$notifySocketStatus$1(this.this$0, this.$status, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.j.setValue(Boxing.boxInt(this.$status));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RoleVprintViewModel$notifySocketStatus$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
