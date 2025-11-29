package com.upuphone.ar.transcribe.phone.network;

import com.upuphone.ar.transcribe.eventtrack.EventTrackingHelper;
import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.utils.NetworkUtils;
import com.upuphone.star.core.log.ULog;
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
@DebugMetadata(c = "com.upuphone.ar.transcribe.phone.network.NetworkConnectManager$notifyNetworkDelay$1", f = "NetworkConnectManager.kt", i = {}, l = {330}, m = "invokeSuspend", n = {}, s = {})
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
                long d = NetworkUtils.d(NetworkUtils.f6189a, (String) null, 1, (Object) null);
                boolean e = this.this$0.e;
                boolean d2 = this.this$0.f;
                LogExt.g("checkNetworkDelay delayTime=" + d + ", poorNet=" + e + ", goodNet=" + d2, "NetworkConnectManager");
                if (d == -1) {
                    ULog.f6446a.c("NetworkConnectManager", "network disconnect!");
                } else {
                    int i2 = (d > 200 ? 1 : (d == 200 ? 0 : -1));
                    if (i2 > 0 && !this.this$0.e) {
                        this.this$0.e = true;
                        this.this$0.f = false;
                        INetworkConnectListener h = this.this$0.b;
                        if (h != null) {
                            h.b();
                        }
                        EventTrackingHelper.f6058a.f(0, d);
                    } else if (i2 <= 0 && !this.this$0.f) {
                        this.this$0.f = true;
                        this.this$0.e = false;
                        INetworkConnectListener h2 = this.this$0.b;
                        if (h2 != null) {
                            h2.d();
                        }
                        EventTrackingHelper.f6058a.f(1, d);
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
