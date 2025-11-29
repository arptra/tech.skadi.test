package com.xjsd.xr.sapp.asr;

import android.os.SystemClock;
import com.xjsd.ai.assistant.net.ws.VirtualWebSocket;
import com.xjsd.xr.sapp.asr.UnifiedAsrHelper;
import com.xjsd.xr.sapp.asr.utils.UlogExtKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.xr.sapp.asr.UnifiedAsrHelper$sendProximalAudioData$1", f = "UnifiedAsrHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class UnifiedAsrHelper$sendProximalAudioData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ byte[] $data;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ UnifiedAsrHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UnifiedAsrHelper$sendProximalAudioData$1(UnifiedAsrHelper unifiedAsrHelper, byte[] bArr, Continuation<? super UnifiedAsrHelper$sendProximalAudioData$1> continuation) {
        super(2, continuation);
        this.this$0 = unifiedAsrHelper;
        this.$data = bArr;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        UnifiedAsrHelper$sendProximalAudioData$1 unifiedAsrHelper$sendProximalAudioData$1 = new UnifiedAsrHelper$sendProximalAudioData$1(this.this$0, this.$data, continuation);
        unifiedAsrHelper$sendProximalAudioData$1.L$0 = obj;
        return unifiedAsrHelper$sendProximalAudioData$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Unit unit;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            if (this.this$0.mAsrChannelType == 1 || this.this$0.mAsrChannelType == 3) {
                VirtualWebSocket access$getMProximalWebSocket$p = this.this$0.mProximalWebSocket;
                if (access$getMProximalWebSocket$p != null) {
                    UnifiedAsrHelper unifiedAsrHelper = this.this$0;
                    byte[] bArr = this.$data;
                    UnifiedAsrHelper.WebSocketState access$getMProximalSocketState$p = unifiedAsrHelper.mProximalSocketState;
                    if (access$getMProximalSocketState$p == null || !access$getMProximalSocketState$p.isMsgStarted()) {
                        UlogExtKt.logReachCount("sendProximalData 当前WebSocket传输数据通道未连接无法发送数据", "UnifiedAsrHelper", "sendProximalDataNotStarted", 50);
                    } else {
                        if (unifiedAsrHelper.mProximalSendAudioFirstTime == 0) {
                            unifiedAsrHelper.mProximalSendAudioFirstTime = SystemClock.elapsedRealtime();
                            UlogExtKt.logI("sendRemoteAudioData mProximalSendAudioFirstTime=" + unifiedAsrHelper.mProximalSendAudioFirstTime, "UnifiedAsrHelper");
                        }
                        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
                        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
                        unifiedAsrHelper.mProximalSendAudioLen = unifiedAsrHelper.mProximalSendAudioLen + ((long) copyOf.length);
                        access$getMProximalWebSocket$p.sendData(copyOf);
                    }
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    UlogExtKt.logReachCount("sendProximalData websocket is null", "UnifiedAsrHelper", "sendProximalDataNullSocket", 50);
                }
                return Unit.INSTANCE;
            }
            UlogExtKt.logI("sendProximalAudioData 发送近端音频消息异常", "UnifiedAsrHelper");
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((UnifiedAsrHelper$sendProximalAudioData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
