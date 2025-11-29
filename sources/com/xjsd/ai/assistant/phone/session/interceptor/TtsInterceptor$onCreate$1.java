package com.xjsd.ai.assistant.phone.session.interceptor;

import com.xjsd.ai.assistant.common.SessionHelper;
import com.xjsd.ai.assistant.core.api.tts.TtsData;
import com.xjsd.ai.assistant.log.ILog;
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

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "it", "Lcom/xjsd/ai/assistant/core/api/tts/TtsData;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.phone.session.interceptor.TtsInterceptor$onCreate$1", f = "TtsInterceptor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TtsInterceptor$onCreate$1 extends SuspendLambda implements Function3<CoroutineScope, TtsData, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TtsInterceptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TtsInterceptor$onCreate$1(TtsInterceptor ttsInterceptor, Continuation<? super TtsInterceptor$onCreate$1> continuation) {
        super(3, continuation);
        this.this$0 = ttsInterceptor;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            TtsData ttsData = (TtsData) this.L$0;
            String a2 = SessionHelper.f8413a.a();
            TtsInterceptor ttsInterceptor = this.this$0;
            boolean d = ttsInterceptor.d().d();
            String b = this.this$0.d().b();
            ILog.a("TtsInterceptor", "instance: " + ttsInterceptor + ", sessionActive: " + d + ", sessionID: " + b + ", current sessionId: " + a2);
            StringBuilder sb = new StringBuilder();
            sb.append("collect tts ");
            sb.append(ttsData);
            ILog.a("TtsInterceptor", sb.toString());
            Boolean bool = (Boolean) this.this$0.f.getCacheWithDefault("canPlayTts", Boxing.boxBoolean(true));
            if (!Intrinsics.areEqual((Object) this.this$0.d().b(), (Object) a2) || !bool.booleanValue()) {
                ILog.a("TtsInterceptor", "当前不可播报语音，直接拦截");
            } else {
                this.this$0.m(ttsData);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @NotNull TtsData ttsData, @Nullable Continuation<? super Unit> continuation) {
        TtsInterceptor$onCreate$1 ttsInterceptor$onCreate$1 = new TtsInterceptor$onCreate$1(this.this$0, continuation);
        ttsInterceptor$onCreate$1.L$0 = ttsData;
        return ttsInterceptor$onCreate$1.invokeSuspend(Unit.INSTANCE);
    }
}
