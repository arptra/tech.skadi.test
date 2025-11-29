package com.xjsd.ai.assistant.flutter.nlp;

import com.xjsd.ai.assistant.core.api.tts.TtsData;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.nlu.bean.NluResponse;
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
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.channels.SendChannel;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.flutter.nlp.PendingNlpProcessor$await$1", f = "PendingNlpProcessor.kt", i = {0}, l = {34}, m = "invokeSuspend", n = {"$this$runBlocking"}, s = {"L$0"})
public final class PendingNlpProcessor$await$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ NluResponse $nluResponse;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PendingNlpProcessor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PendingNlpProcessor$await$1(PendingNlpProcessor pendingNlpProcessor, NluResponse nluResponse, Continuation<? super PendingNlpProcessor$await$1> continuation) {
        super(2, continuation);
        this.this$0 = pendingNlpProcessor;
        this.$nluResponse = nluResponse;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        PendingNlpProcessor$await$1 pendingNlpProcessor$await$1 = new PendingNlpProcessor$await$1(this.this$0, this.$nluResponse, continuation);
        pendingNlpProcessor$await$1.L$0 = obj;
        return pendingNlpProcessor$await$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        CoroutineScope coroutineScope;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            PendingNlpProcessor$await$1$result$1 pendingNlpProcessor$await$1$result$1 = new PendingNlpProcessor$await$1$result$1(this.this$0, (Continuation<? super PendingNlpProcessor$await$1$result$1>) null);
            this.L$0 = coroutineScope2;
            this.label = 1;
            Object d = TimeoutKt.d(3000, pendingNlpProcessor$await$1$result$1, this);
            if (d == coroutine_suspended) {
                return coroutine_suspended;
            }
            coroutineScope = coroutineScope2;
            obj = d;
        } else if (i == 1) {
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        TtsData ttsData = (TtsData) obj;
        SendChannel.DefaultImpls.a(this.this$0.f8489a, (Throwable) null, 1, (Object) null);
        if (ttsData == null) {
            ILog.a("PendingNlpProcessor", "await: 未收到眼镜回复，返回默认OK");
            this.this$0.a(this.$nluResponse);
        } else {
            String text = ttsData.getText();
            ILog.a("PendingNlpProcessor", "await: 已收到眼镜回复->" + text);
            PendingNlpProcessor pendingNlpProcessor = this.this$0;
            NluResponse nluResponse = this.$nluResponse;
            String text2 = ttsData.getText();
            Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
            pendingNlpProcessor.h(nluResponse, text2);
        }
        EventBus.c().q(coroutineScope);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((PendingNlpProcessor$await$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
