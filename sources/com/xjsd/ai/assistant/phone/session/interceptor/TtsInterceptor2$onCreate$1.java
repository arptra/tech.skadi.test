package com.xjsd.ai.assistant.phone.session.interceptor;

import com.xjsd.ai.assistant.common.SessionHelper;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.helper.VrStateHelper;
import com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "it", "Lcom/xjsd/ai/assistant/phone/tts/PhoneTtsPlayBuilder$PhoneTts;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.phone.session.interceptor.TtsInterceptor2$onCreate$1", f = "TtsInterceptor2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TtsInterceptor2$onCreate$1 extends SuspendLambda implements Function3<CoroutineScope, PhoneTtsPlayBuilder.PhoneTts, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TtsInterceptor2 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TtsInterceptor2$onCreate$1(TtsInterceptor2 ttsInterceptor2, Continuation<? super TtsInterceptor2$onCreate$1> continuation) {
        super(3, continuation);
        this.this$0 = ttsInterceptor2;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            PhoneTtsPlayBuilder.PhoneTts phoneTts = (PhoneTtsPlayBuilder.PhoneTts) this.L$0;
            ILog.a("TtsInterceptor2", "collect tts " + phoneTts);
            String a2 = SessionHelper.f8413a.a();
            Boolean bool = (Boolean) this.this$0.f.getCacheWithDefault("canPlayTts", Boxing.boxBoolean(true));
            if (!Intrinsics.areEqual((Object) this.this$0.d().b(), (Object) a2) || !bool.booleanValue()) {
                ILog.a("TtsInterceptor2", "session已变更，拦截语音播报");
                return Unit.INSTANCE;
            } else if (!VrStateHelper.f8567a.a()) {
                ILog.a("TtsInterceptor2", "语音助理已经退出，不再播报TTS");
                return Unit.INSTANCE;
            } else {
                this.this$0.m(phoneTts);
                return Unit.INSTANCE;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @NotNull PhoneTtsPlayBuilder.PhoneTts phoneTts, @Nullable Continuation<? super Unit> continuation) {
        TtsInterceptor2$onCreate$1 ttsInterceptor2$onCreate$1 = new TtsInterceptor2$onCreate$1(this.this$0, continuation);
        ttsInterceptor2$onCreate$1.L$0 = phoneTts;
        return ttsInterceptor2$onCreate$1.invokeSuspend(Unit.INSTANCE);
    }
}
