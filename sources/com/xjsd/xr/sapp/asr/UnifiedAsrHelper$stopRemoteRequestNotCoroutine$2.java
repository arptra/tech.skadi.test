package com.xjsd.xr.sapp.asr;

import com.xjsd.ai.assistant.net.ws.VirtualWebSocket;
import com.xjsd.xr.sapp.asr.utils.UlogExtKt;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.xr.sapp.asr.UnifiedAsrHelper$stopRemoteRequestNotCoroutine$2", f = "UnifiedAsrHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class UnifiedAsrHelper$stopRemoteRequestNotCoroutine$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ UnifiedAsrHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UnifiedAsrHelper$stopRemoteRequestNotCoroutine$2(UnifiedAsrHelper unifiedAsrHelper, Continuation<? super UnifiedAsrHelper$stopRemoteRequestNotCoroutine$2> continuation) {
        super(2, continuation);
        this.this$0 = unifiedAsrHelper;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        UnifiedAsrHelper$stopRemoteRequestNotCoroutine$2 unifiedAsrHelper$stopRemoteRequestNotCoroutine$2 = new UnifiedAsrHelper$stopRemoteRequestNotCoroutine$2(this.this$0, continuation);
        unifiedAsrHelper$stopRemoteRequestNotCoroutine$2.L$0 = obj;
        return unifiedAsrHelper$stopRemoteRequestNotCoroutine$2;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Unit unit;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            VirtualWebSocket access$getMRemoteWebSocket$p = this.this$0.mRemoteWebSocket;
            if (access$getMRemoteWebSocket$p != null) {
                UnifiedAsrHelper unifiedAsrHelper = this.this$0;
                UlogExtKt.logI("stopRemoteRequest 关闭远端websocket通道", "UnifiedAsrHelper");
                unifiedAsrHelper.mRemoteWebSocket = null;
                unifiedAsrHelper.mRemoteAsrRequest = null;
                unifiedAsrHelper.mRemoteAsrRequestConfig = null;
                CoroutineScopeKt.e(unifiedAsrHelper.mRemoteFeedCoroutine, (CancellationException) null, 1, (Object) null);
                unifiedAsrHelper.mRemoteSendAudioFirstTime = 0;
                unifiedAsrHelper.mIsRemoteResultFirstPrint = false;
                access$getMRemoteWebSocket$p.disconnect();
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                UlogExtKt.logE$default("stopRemoteRequest websocket is null", "UnifiedAsrHelper", (Throwable) null, 2, (Object) null);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((UnifiedAsrHelper$stopRemoteRequestNotCoroutine$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
