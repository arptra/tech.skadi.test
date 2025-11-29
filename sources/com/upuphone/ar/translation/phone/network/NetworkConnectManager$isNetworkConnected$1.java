package com.upuphone.ar.translation.phone.network;

import android.net.NetworkCapabilities;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.utils.NetworkUtils;
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
@DebugMetadata(c = "com.upuphone.ar.translation.phone.network.NetworkConnectManager$isNetworkConnected$1", f = "NetworkConnectManager.kt", i = {}, l = {286}, m = "invokeSuspend", n = {}, s = {})
public final class NetworkConnectManager$isNetworkConnected$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Boolean, Unit> $callback;
    final /* synthetic */ NetworkCapabilities $networkCapabilities;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetworkConnectManager$isNetworkConnected$1(NetworkCapabilities networkCapabilities, Function1<? super Boolean, Unit> function1, Continuation<? super NetworkConnectManager$isNetworkConnected$1> continuation) {
        super(2, continuation);
        this.$networkCapabilities = networkCapabilities;
        this.$callback = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new NetworkConnectManager$isNetworkConnected$1(this.$networkCapabilities, this.$callback, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            boolean hasCapability = this.$networkCapabilities.hasCapability(12);
            boolean hasCapability2 = this.$networkCapabilities.hasCapability(16);
            LogExt.j("isNetworkConnected 网络连接=" + hasCapability + ", 网络可用=" + hasCapability2, "NetworkConnectManager");
            if (!hasCapability) {
                z = false;
            } else if (!hasCapability2) {
                NetworkUtils networkUtils = NetworkUtils.f6368a;
                this.label = 1;
                obj = networkUtils.c(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            LogExt.j("isNetworkConnected isAccessible=" + z, "NetworkConnectManager");
            this.$callback.invoke(Boxing.boxBoolean(z));
            return Unit.INSTANCE;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        z = ((Boolean) obj).booleanValue();
        LogExt.j("isNetworkConnected 互联网联网=" + z, "NetworkConnectManager");
        LogExt.j("isNetworkConnected isAccessible=" + z, "NetworkConnectManager");
        this.$callback.invoke(Boxing.boxBoolean(z));
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((NetworkConnectManager$isNetworkConnected$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
