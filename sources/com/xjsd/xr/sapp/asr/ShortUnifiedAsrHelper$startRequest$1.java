package com.xjsd.xr.sapp.asr;

import com.meizu.common.util.LunarCalendar;
import com.xjsd.xr.sapp.asr.ShortUnifiedAsrHelper;
import com.xjsd.xr.sapp.asr.dao.SpeechRequestConfig;
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
@DebugMetadata(c = "com.xjsd.xr.sapp.asr.ShortUnifiedAsrHelper$startRequest$1", f = "ShortUnifiedAsrHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ShortUnifiedAsrHelper$startRequest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SpeechRequestConfig $requestConfig;
    int label;
    final /* synthetic */ ShortUnifiedAsrHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShortUnifiedAsrHelper$startRequest$1(SpeechRequestConfig speechRequestConfig, ShortUnifiedAsrHelper shortUnifiedAsrHelper, Continuation<? super ShortUnifiedAsrHelper$startRequest$1> continuation) {
        super(2, continuation);
        this.$requestConfig = speechRequestConfig;
        this.this$0 = shortUnifiedAsrHelper;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ShortUnifiedAsrHelper$startRequest$1(this.$requestConfig, this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            UlogExtKt.logI("startRequest requestConfig=" + this.$requestConfig, "ShortUnifiedAsrHelper");
            ShortUnifiedAsrHelper shortUnifiedAsrHelper = this.this$0;
            shortUnifiedAsrHelper.mFeedCoroutine = shortUnifiedAsrHelper.createFeedScope();
            if (this.this$0.mWebSocket != null) {
                UlogExtKt.logI("startRequest websocket is not null", "ShortUnifiedAsrHelper");
                ShortUnifiedAsrHelper.AsrWebSocket access$getMWebSocket$p = this.this$0.mWebSocket;
                if (access$getMWebSocket$p != null) {
                    access$getMWebSocket$p.disconnect();
                }
                this.this$0.mWebSocket = null;
            }
            ShortUnifiedAsrHelper shortUnifiedAsrHelper2 = this.this$0;
            ShortUnifiedAsrHelper.AsrWebSocket asrWebSocket = new ShortUnifiedAsrHelper.AsrWebSocket();
            ShortUnifiedAsrHelper shortUnifiedAsrHelper3 = this.this$0;
            SpeechRequestConfig speechRequestConfig = this.$requestConfig;
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
            String replace$default = StringsKt.replace$default(uuid, LunarCalendar.DATE_SEPARATOR, "", false, 4, (Object) null);
            UlogExtKt.logI("startRequest sessionId=" + replace$default, "ShortUnifiedAsrHelper");
            if (asrWebSocket.connect(replace$default)) {
                shortUnifiedAsrHelper3.sendChannelInfo(asrWebSocket, speechRequestConfig);
            } else {
                UlogExtKt.logI("startRequest connect error", "ShortUnifiedAsrHelper");
                ShortUnifiedAsrHelper.notifyFailed$default(shortUnifiedAsrHelper3, new SocketException("WebSocket connect error"), (Response) null, 2, (Object) null);
            }
            shortUnifiedAsrHelper2.mWebSocket = asrWebSocket;
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ShortUnifiedAsrHelper$startRequest$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
