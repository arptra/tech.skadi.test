package com.xjsd.xr.sapp.asr;

import com.xjsd.ai.assistant.net.ws.protocol.EndToEndServiceData;
import com.xjsd.xr.sapp.asr.ShortUnifiedAsrHelper;
import com.xjsd.xr.sapp.asr.constants.AsrConstants;
import com.xjsd.xr.sapp.asr.dao.AsrRequest;
import com.xjsd.xr.sapp.asr.dao.SpeechEndAudio;
import com.xjsd.xr.sapp.asr.utils.GsonHelper;
import com.xjsd.xr.sapp.asr.utils.UlogExtKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.xr.sapp.asr.ShortUnifiedAsrHelper$endAudioMessage$1", f = "ShortUnifiedAsrHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ShortUnifiedAsrHelper$endAudioMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ShortUnifiedAsrHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShortUnifiedAsrHelper$endAudioMessage$1(ShortUnifiedAsrHelper shortUnifiedAsrHelper, Continuation<? super ShortUnifiedAsrHelper$endAudioMessage$1> continuation) {
        super(2, continuation);
        this.this$0 = shortUnifiedAsrHelper;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ShortUnifiedAsrHelper$endAudioMessage$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            UlogExtKt.logI("endAudioMessage asrRequest=" + this.this$0.mAsrRequest, "ShortUnifiedAsrHelper");
            AsrRequest access$getMAsrRequest$p = this.this$0.mAsrRequest;
            if (access$getMAsrRequest$p != null) {
                ShortUnifiedAsrHelper shortUnifiedAsrHelper = this.this$0;
                String json = GsonHelper.toJson(new SpeechEndAudio(access$getMAsrRequest$p.getDeviceId(), AsrConstants.END_AUDIO, access$getMAsrRequest$p.getRequestId()));
                String requestId = access$getMAsrRequest$p.getRequestId();
                UlogExtKt.logI("endAudioMessage traceId=" + requestId + ", json=" + json, "ShortUnifiedAsrHelper");
                ShortUnifiedAsrHelper.AsrWebSocket access$getMWebSocket$p = shortUnifiedAsrHelper.mWebSocket;
                if (access$getMWebSocket$p != null) {
                    EndToEndServiceData endToEndServiceData = new EndToEndServiceData();
                    endToEndServiceData.setType("asr");
                    endToEndServiceData.setPayload(json);
                    Unit unit = Unit.INSTANCE;
                    access$getMWebSocket$p.sendMsg(requestId, endToEndServiceData);
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ShortUnifiedAsrHelper$endAudioMessage$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
