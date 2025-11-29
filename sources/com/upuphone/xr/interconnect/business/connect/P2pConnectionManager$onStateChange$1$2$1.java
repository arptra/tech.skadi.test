package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.xr.interconnect.common.IP2pStateListener;
import com.upuphone.xr.interconnect.util.RemoteInterfaceExtKt;
import com.upuphone.xr.interconnect.util.log.ILog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.interconnect.business.connect.P2pConnectionManager$onStateChange$1$2$1", f = "P2pConnectionManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class P2pConnectionManager$onStateChange$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $connected;
    final /* synthetic */ IP2pStateListener $it;
    int label;
    final /* synthetic */ P2pConnectionManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public P2pConnectionManager$onStateChange$1$2$1(IP2pStateListener iP2pStateListener, P2pConnectionManager p2pConnectionManager, boolean z, Continuation<? super P2pConnectionManager$onStateChange$1$2$1> continuation) {
        super(2, continuation);
        this.$it = iP2pStateListener;
        this.this$0 = p2pConnectionManager;
        this.$connected = z;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new P2pConnectionManager$onStateChange$1$2$1(this.$it, this.this$0, this.$connected, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            IP2pStateListener iP2pStateListener = this.$it;
            final P2pConnectionManager p2pConnectionManager = this.this$0;
            AnonymousClass1 r0 = new Function1<String, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((String) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull String str) {
                    Intrinsics.checkNotNullParameter(str, "it");
                    ILog.w(p2pConnectionManager.getTag(), str);
                }
            };
            final boolean z = this.$connected;
            RemoteInterfaceExtKt.safeRemoteCall(iP2pStateListener, (Function1<? super String, Unit>) r0, new Function1<IP2pStateListener, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((IP2pStateListener) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull IP2pStateListener iP2pStateListener) {
                    Intrinsics.checkNotNullParameter(iP2pStateListener, "$this$safeRemoteCall");
                    iP2pStateListener.onP2pStateChanged(z ? 1 : 0);
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((P2pConnectionManager$onStateChange$1$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
