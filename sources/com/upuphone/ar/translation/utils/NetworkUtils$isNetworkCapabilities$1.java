package com.upuphone.ar.translation.utils;

import android.content.Context;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.utils.NetworkUtils$isNetworkCapabilities$1", f = "NetworkUtils.kt", i = {}, l = {40, 41}, m = "invokeSuspend", n = {}, s = {})
public final class NetworkUtils$isNetworkCapabilities$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Boolean, Unit> $callback;
    final /* synthetic */ Context $context;
    final /* synthetic */ long $delayTime;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetworkUtils$isNetworkCapabilities$1(long j, Context context, Function1<? super Boolean, Unit> function1, Continuation<? super NetworkUtils$isNetworkCapabilities$1> continuation) {
        super(2, continuation);
        this.$delayTime = j;
        this.$context = context;
        this.$callback = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new NetworkUtils$isNetworkCapabilities$1(this.$delayTime, this.$context, this.$callback, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            long j = this.$delayTime;
            this.label = 1;
            if (DelayKt.b(j, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NetworkUtils networkUtils = NetworkUtils.f6368a;
        Context context = this.$context;
        Function1<Boolean, Unit> function1 = this.$callback;
        this.label = 2;
        if (networkUtils.b(context, function1, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((NetworkUtils$isNetworkCapabilities$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
