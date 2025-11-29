package com.upuphone.ar.translation.iflytek;

import com.upuphone.ar.translation.ext.LogExt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import okhttp3.WebSocket;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.iflytek.IFlyAsrHelper$stopProximalRequestNotCoroutine$2", f = "IFlyAsrHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class IFlyAsrHelper$stopProximalRequestNotCoroutine$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $voiceEndArg;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ IFlyAsrHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IFlyAsrHelper$stopProximalRequestNotCoroutine$2(IFlyAsrHelper iFlyAsrHelper, int i, Continuation<? super IFlyAsrHelper$stopProximalRequestNotCoroutine$2> continuation) {
        super(2, continuation);
        this.this$0 = iFlyAsrHelper;
        this.$voiceEndArg = i;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IFlyAsrHelper$stopProximalRequestNotCoroutine$2 iFlyAsrHelper$stopProximalRequestNotCoroutine$2 = new IFlyAsrHelper$stopProximalRequestNotCoroutine$2(this.this$0, this.$voiceEndArg, continuation);
        iFlyAsrHelper$stopProximalRequestNotCoroutine$2.L$0 = obj;
        return iFlyAsrHelper$stopProximalRequestNotCoroutine$2;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            WebSocket l = this.this$0.j;
            Unit unit = null;
            if (l != null) {
                int i = this.$voiceEndArg;
                IFlyAsrHelper iFlyAsrHelper = this.this$0;
                if (i == 1 && iFlyAsrHelper.n) {
                    l.send("{\"end\": true}");
                }
                l.close(1001, "Proximal websocket is actively closed");
                iFlyAsrHelper.j = null;
                iFlyAsrHelper.k = null;
                iFlyAsrHelper.l = null;
                iFlyAsrHelper.n = false;
                CoroutineScopeKt.e(iFlyAsrHelper.o, (CancellationException) null, 1, (Object) null);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                LogExt.j("stopProximalRequest websocket is null", "IFlyAsrHelper");
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((IFlyAsrHelper$stopProximalRequestNotCoroutine$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
