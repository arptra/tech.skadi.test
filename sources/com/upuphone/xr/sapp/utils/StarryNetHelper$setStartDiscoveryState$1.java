package com.upuphone.xr.sapp.utils;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.utils.StarryNetHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.utils.StarryNetHelper$setStartDiscoveryState$1", f = "StarryNetHelper.kt", i = {}, l = {78}, m = "invokeSuspend", n = {}, s = {})
public final class StarryNetHelper$setStartDiscoveryState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ StarryNetHelper.StartDiscoveryCondition $state;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StarryNetHelper$setStartDiscoveryState$1(StarryNetHelper.StartDiscoveryCondition startDiscoveryCondition, Continuation<? super StarryNetHelper$setStartDiscoveryState$1> continuation) {
        super(2, continuation);
        this.$state = startDiscoveryCondition;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new StarryNetHelper$setStartDiscoveryState$1(this.$state, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ULog.Delegate delegate = ULog.f6446a;
            StarryNetHelper.StartDiscoveryCondition startDiscoveryCondition = this.$state;
            delegate.c("StarryNetHelper", "setStartDiscoveryState state = " + startDiscoveryCondition);
            MutableStateFlow a2 = StarryNetHelper.c;
            StarryNetHelper.StartDiscoveryCondition startDiscoveryCondition2 = this.$state;
            this.label = 1;
            if (a2.emit(startDiscoveryCondition2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((StarryNetHelper$setStartDiscoveryState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
