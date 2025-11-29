package com.xjsd.xr.sapp.asr;

import com.meizu.common.util.LunarCalendar;
import com.xjsd.ai.assistant.net.ws.VirtualWebSocket;
import com.xjsd.xr.sapp.asr.UnifiedAsrHelper;
import com.xjsd.xr.sapp.asr.dao.AsrRequestConfig;
import com.xjsd.xr.sapp.asr.utils.UlogExtKt;
import java.net.SocketException;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.xr.sapp.asr.UnifiedAsrHelper$startProximalRequest$1", f = "UnifiedAsrHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class UnifiedAsrHelper$startProximalRequest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AsrRequestConfig $requestConfig;
    int label;
    final /* synthetic */ UnifiedAsrHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UnifiedAsrHelper$startProximalRequest$1(AsrRequestConfig asrRequestConfig, UnifiedAsrHelper unifiedAsrHelper, Continuation<? super UnifiedAsrHelper$startProximalRequest$1> continuation) {
        super(2, continuation);
        this.$requestConfig = asrRequestConfig;
        this.this$0 = unifiedAsrHelper;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new UnifiedAsrHelper$startProximalRequest$1(this.$requestConfig, this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            UlogExtKt.logI("startProximalRequest requestConfig=" + this.$requestConfig, "UnifiedAsrHelper");
            UnifiedAsrHelper unifiedAsrHelper = this.this$0;
            unifiedAsrHelper.mProximalFeedCoroutine = unifiedAsrHelper.createFeedScope();
            this.this$0.mProximalAsrRequestConfig = this.$requestConfig;
            this.this$0.mProximalSendAudioFirstTime = 0;
            this.this$0.mIsProximalResultFirstPrint = false;
            if (this.this$0.mProximalWebSocket != null) {
                UlogExtKt.logI("startProximalRequest websocket is not null", "UnifiedAsrHelper");
                VirtualWebSocket access$getMProximalWebSocket$p = this.this$0.mProximalWebSocket;
                if (access$getMProximalWebSocket$p != null) {
                    access$getMProximalWebSocket$p.disconnect();
                }
                this.this$0.mProximalWebSocket = null;
            }
            UnifiedAsrHelper unifiedAsrHelper2 = this.this$0;
            UnifiedAsrHelper.ProximalWebSocket proximalWebSocket = new UnifiedAsrHelper.ProximalWebSocket();
            UnifiedAsrHelper unifiedAsrHelper3 = this.this$0;
            AsrRequestConfig asrRequestConfig = this.$requestConfig;
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
            String replace$default = StringsKt.replace$default(uuid, LunarCalendar.DATE_SEPARATOR, "", false, 4, (Object) null);
            UlogExtKt.logI("startProximalRequest sessionId=" + replace$default, "UnifiedAsrHelper");
            if (proximalWebSocket.connect(replace$default)) {
                UnifiedAsrHelper.WebSocketState access$getMProximalSocketState$p = unifiedAsrHelper3.mProximalSocketState;
                if (access$getMProximalSocketState$p != null) {
                    access$getMProximalSocketState$p.setOpened(true);
                }
                unifiedAsrHelper3.sendProximalChannelInfo(proximalWebSocket, asrRequestConfig);
            } else {
                UlogExtKt.logI("startProximalRequest connect error [reconnect=" + unifiedAsrHelper3.mIsAutoReconnecting + ']', "UnifiedAsrHelper");
                if (unifiedAsrHelper3.mIsAutoReconnecting) {
                    UnifiedAsrHelper.reconnectRequest$default(unifiedAsrHelper3, 2, false, 2, (Object) null);
                } else {
                    UnifiedAsrHelper.notifyFailed$default(unifiedAsrHelper3, new SocketException("Proximal webSocket request connect error"), (Response) null, 2, (Object) null);
                    UnifiedAsrHelper.WebSocketState access$getMProximalSocketState$p2 = unifiedAsrHelper3.mProximalSocketState;
                    if (access$getMProximalSocketState$p2 != null) {
                        access$getMProximalSocketState$p2.setOpened(false);
                    }
                }
            }
            unifiedAsrHelper2.mProximalWebSocket = proximalWebSocket;
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((UnifiedAsrHelper$startProximalRequest$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
