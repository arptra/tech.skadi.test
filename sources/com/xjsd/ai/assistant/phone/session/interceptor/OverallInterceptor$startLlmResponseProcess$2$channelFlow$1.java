package com.xjsd.ai.assistant.phone.session.interceptor;

import com.xjsd.ai.assistant.chatgpt.model.LlmResponse;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/xjsd/ai/assistant/chatgpt/model/LlmResponse;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor$startLlmResponseProcess$2$channelFlow$1", f = "OverallInterceptor.kt", i = {}, l = {876}, m = "invokeSuspend", n = {}, s = {})
public final class OverallInterceptor$startLlmResponseProcess$2$channelFlow$1 extends SuspendLambda implements Function2<ProducerScope<? super LlmResponse>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ OverallInterceptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OverallInterceptor$startLlmResponseProcess$2$channelFlow$1(OverallInterceptor overallInterceptor, Continuation<? super OverallInterceptor$startLlmResponseProcess$2$channelFlow$1> continuation) {
        super(2, continuation);
        this.this$0 = overallInterceptor;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        OverallInterceptor$startLlmResponseProcess$2$channelFlow$1 overallInterceptor$startLlmResponseProcess$2$channelFlow$1 = new OverallInterceptor$startLlmResponseProcess$2$channelFlow$1(this.this$0, continuation);
        overallInterceptor$startLlmResponseProcess$2$channelFlow$1.L$0 = obj;
        return overallInterceptor$startLlmResponseProcess$2$channelFlow$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final ProducerScope producerScope = (ProducerScope) this.L$0;
            MutableSharedFlow u = this.this$0.w;
            AnonymousClass1 r3 = new FlowCollector() {
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.lang.Object} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: com.xjsd.ai.assistant.chatgpt.model.LlmResponse} */
                /* JADX WARNING: Multi-variable type inference failed */
                /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
                /* JADX WARNING: Removed duplicated region for block: B:17:0x0052  */
                /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
                /* renamed from: d */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final java.lang.Object emit(com.xjsd.ai.assistant.chatgpt.model.LlmResponse r5, kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor$startLlmResponseProcess$2$channelFlow$1$1$emit$1
                        if (r0 == 0) goto L_0x0013
                        r0 = r6
                        com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor$startLlmResponseProcess$2$channelFlow$1$1$emit$1 r0 = (com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor$startLlmResponseProcess$2$channelFlow$1$1$emit$1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L_0x0013
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L_0x0018
                    L_0x0013:
                        com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor$startLlmResponseProcess$2$channelFlow$1$1$emit$1 r0 = new com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor$startLlmResponseProcess$2$channelFlow$1$1$emit$1
                        r0.<init>(r4, r6)
                    L_0x0018:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L_0x003a
                        if (r2 != r3) goto L_0x0032
                        java.lang.Object r4 = r0.L$1
                        r5 = r4
                        com.xjsd.ai.assistant.chatgpt.model.LlmResponse r5 = (com.xjsd.ai.assistant.chatgpt.model.LlmResponse) r5
                        java.lang.Object r4 = r0.L$0
                        com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor$startLlmResponseProcess$2$channelFlow$1$1 r4 = (com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor$startLlmResponseProcess$2$channelFlow$1.AnonymousClass1) r4
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L_0x004c
                    L_0x0032:
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                        r4.<init>(r5)
                        throw r4
                    L_0x003a:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.channels.ProducerScope r6 = r5
                        r0.L$0 = r4
                        r0.L$1 = r5
                        r0.label = r3
                        java.lang.Object r6 = r6.L(r5, r0)
                        if (r6 != r1) goto L_0x004c
                        return r1
                    L_0x004c:
                        int r5 = r5.getBase_status()
                        if (r5 == r3) goto L_0x0058
                        kotlinx.coroutines.channels.ProducerScope r4 = r5
                        r5 = 0
                        kotlinx.coroutines.channels.SendChannel.DefaultImpls.a(r4, r5, r3, r5)
                    L_0x0058:
                        kotlin.Unit r4 = kotlin.Unit.INSTANCE
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor$startLlmResponseProcess$2$channelFlow$1.AnonymousClass1.emit(com.xjsd.ai.assistant.chatgpt.model.LlmResponse, kotlin.coroutines.Continuation):java.lang.Object");
                }
            };
            this.label = 1;
            if (u.collect(r3, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }

    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super LlmResponse> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((OverallInterceptor$startLlmResponseProcess$2$channelFlow$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
