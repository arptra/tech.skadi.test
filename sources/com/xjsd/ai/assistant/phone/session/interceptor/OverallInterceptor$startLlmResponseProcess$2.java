package com.xjsd.ai.assistant.phone.session.interceptor;

import com.xjsd.ai.assistant.chatgpt.model.LlmResponse;
import com.xjsd.ai.assistant.chatgpt.util.GptUtil;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.vui.llm.LlmAnswerSynchronizer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor$startLlmResponseProcess$2", f = "OverallInterceptor.kt", i = {}, l = {892}, m = "invokeSuspend", n = {}, s = {})
public final class OverallInterceptor$startLlmResponseProcess$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ OverallInterceptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OverallInterceptor$startLlmResponseProcess$2(OverallInterceptor overallInterceptor, Continuation<? super OverallInterceptor$startLlmResponseProcess$2> continuation) {
        super(2, continuation);
        this.this$0 = overallInterceptor;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        OverallInterceptor$startLlmResponseProcess$2 overallInterceptor$startLlmResponseProcess$2 = new OverallInterceptor$startLlmResponseProcess$2(this.this$0, continuation);
        overallInterceptor$startLlmResponseProcess$2.L$0 = obj;
        return overallInterceptor$startLlmResponseProcess$2;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ILog.a("OverallInterceptor", "runWhenResume: 协程体" + ((CoroutineScope) this.L$0) + ", 被调度执行了");
            Flow g = GptUtil.g(GptUtil.f8402a, FlowKt.i(new OverallInterceptor$startLlmResponseProcess$2$channelFlow$1(this.this$0, (Continuation<? super OverallInterceptor$startLlmResponseProcess$2$channelFlow$1>) null)), (GptUtil.SplitConfig) null, (Function2) null, AnonymousClass1.INSTANCE, 3, (Object) null);
            final OverallInterceptor overallInterceptor = this.this$0;
            AnonymousClass2 r1 = new FlowCollector() {
                /* renamed from: d */
                public final Object emit(LlmResponse llmResponse, Continuation continuation) {
                    llmResponse.setSessionId(overallInterceptor.d().b());
                    LlmAnswerSynchronizer.f8634a.f(llmResponse);
                    return Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (g.collect(r1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((OverallInterceptor$startLlmResponseProcess$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
