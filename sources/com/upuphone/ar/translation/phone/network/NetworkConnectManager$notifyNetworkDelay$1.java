package com.upuphone.ar.translation.phone.network;

import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.utils.NetworkUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.network.NetworkConnectManager$notifyNetworkDelay$1", f = "NetworkConnectManager.kt", i = {}, l = {322}, m = "invokeSuspend", n = {}, s = {})
public final class NetworkConnectManager$notifyNetworkDelay$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ NetworkConnectManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetworkConnectManager$notifyNetworkDelay$1(NetworkConnectManager networkConnectManager, Continuation<? super NetworkConnectManager$notifyNetworkDelay$1> continuation) {
        super(2, continuation);
        this.this$0 = networkConnectManager;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new NetworkConnectManager$notifyNetworkDelay$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0 || i == 1) {
            ResultKt.throwOnFailure(obj);
            do {
                long g = NetworkUtils.g(NetworkUtils.f6368a, (String) null, 1, (Object) null);
                boolean e = this.this$0.e;
                boolean d = this.this$0.f;
                LogExt.j("checkNetworkDelay delayTime=" + g + ", poorNet=" + e + ", goodNet=" + d, "NetworkConnectManager");
                if (g > 200 && !this.this$0.e) {
                    this.this$0.e = true;
                    this.this$0.f = false;
                    INetworkConnectListener h = this.this$0.b;
                    if (h != null) {
                        h.b();
                    }
                } else if (1 <= g && g < 201 && !this.this$0.f) {
                    this.this$0.f = true;
                    this.this$0.e = false;
                    INetworkConnectListener h2 = this.this$0.b;
                    if (h2 != null) {
                        h2.d();
                    }
                }
                this.label = 1;
            } while (DelayKt.b(5000, this) != coroutine_suspended);
            return coroutine_suspended;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((NetworkConnectManager$notifyNetworkDelay$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
