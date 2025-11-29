package com.xjsd.ai.assistant.chatgpt.util;

import com.xjsd.ai.assistant.chatgpt.model.LlmResponse;
import com.xjsd.ai.assistant.chatgpt.util.GptUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nGptUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GptUtil.kt\ncom/xjsd/ai/assistant/chatgpt/util/GptUtil$handleMessageStream$1\n+ 2 Collect.kt\nkotlinx/coroutines/flow/FlowKt__CollectKt\n*L\n1#1,259:1\n60#2,4:260\n*S KotlinDebug\n*F\n+ 1 GptUtil.kt\ncom/xjsd/ai/assistant/chatgpt/util/GptUtil$handleMessageStream$1\n*L\n110#1:260,4\n*E\n"})
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00020\u00040\u0003H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/xjsd/ai/assistant/chatgpt/model/LlmResponse;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.chatgpt.util.GptUtil$handleMessageStream$1", f = "GptUtil.kt", i = {0, 0, 0, 0, 0, 1, 1, 1}, l = {260, 128, 138}, m = "invokeSuspend", n = {"$this$channelFlow", "$this$invokeSuspend_u24lambda_u244", "messageStr", "streamRole", "streamStatus", "$this$channelFlow", "messageStr", "streamRole"}, s = {"L$0", "L$2", "L$3", "L$4", "L$5", "L$0", "L$2", "L$3"})
public final class GptUtil$handleMessageStream$1 extends SuspendLambda implements Function2<ProducerScope<? super LlmResponse>, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $finishWithCompleteContent;
    final /* synthetic */ Function1<Object, GptUtil.MessageStreamData> $handleResponse;
    final /* synthetic */ Function2<String, String, Unit> $onSuccessFinish;
    final /* synthetic */ Flow<Object> $this_handleMessageStream;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    boolean Z$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GptUtil$handleMessageStream$1(Flow<Object> flow, boolean z, Function2<? super String, ? super String, Unit> function2, Function1<Object, GptUtil.MessageStreamData> function1, Continuation<? super GptUtil$handleMessageStream$1> continuation) {
        super(2, continuation);
        this.$this_handleMessageStream = flow;
        this.$finishWithCompleteContent = z;
        this.$onSuccessFinish = function2;
        this.$handleResponse = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GptUtil$handleMessageStream$1 gptUtil$handleMessageStream$1 = new GptUtil$handleMessageStream$1(this.$this_handleMessageStream, this.$finishWithCompleteContent, this.$onSuccessFinish, this.$handleResponse, continuation);
        gptUtil$handleMessageStream$1.L$0 = obj;
        return gptUtil$handleMessageStream$1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v23, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v1, resolved type: kotlinx.coroutines.channels.ProducerScope} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0120 A[SYNTHETIC, Splitter:B:49:0x0120] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0132 A[Catch:{ all -> 0x0039 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x014c A[SYNTHETIC, Splitter:B:58:0x014c] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0169  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r20) {
        /*
            r19 = this;
            r1 = r19
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r1.label
            java.lang.String r3 = "ChatGptUtil"
            java.lang.String r4 = ""
            r6 = 3
            r7 = 1
            r8 = 2
            if (r0 == 0) goto L_0x0060
            if (r0 == r7) goto L_0x003c
            if (r0 == r8) goto L_0x0024
            if (r0 != r6) goto L_0x001c
            kotlin.ResultKt.throwOnFailure(r20)
            goto L_0x0188
        L_0x001c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0024:
            java.lang.Object r0 = r1.L$3
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            java.lang.Object r7 = r1.L$2
            java.lang.StringBuilder r7 = (java.lang.StringBuilder) r7
            java.lang.Object r8 = r1.L$1
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            java.lang.Object r10 = r1.L$0
            kotlinx.coroutines.channels.ProducerScope r10 = (kotlinx.coroutines.channels.ProducerScope) r10
            kotlin.ResultKt.throwOnFailure(r20)     // Catch:{ all -> 0x0039 }
            goto L_0x011e
        L_0x0039:
            r0 = move-exception
            goto L_0x013b
        L_0x003c:
            boolean r0 = r1.Z$0
            java.lang.Object r10 = r1.L$5
            kotlin.jvm.internal.Ref$IntRef r10 = (kotlin.jvm.internal.Ref.IntRef) r10
            java.lang.Object r11 = r1.L$4
            kotlin.jvm.internal.Ref$ObjectRef r11 = (kotlin.jvm.internal.Ref.ObjectRef) r11
            java.lang.Object r12 = r1.L$3
            java.lang.StringBuilder r12 = (java.lang.StringBuilder) r12
            java.lang.Object r13 = r1.L$2
            kotlinx.coroutines.channels.ProducerScope r13 = (kotlinx.coroutines.channels.ProducerScope) r13
            java.lang.Object r14 = r1.L$1
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            java.lang.Object r15 = r1.L$0
            kotlinx.coroutines.channels.ProducerScope r15 = (kotlinx.coroutines.channels.ProducerScope) r15
            kotlin.ResultKt.throwOnFailure(r20)     // Catch:{ all -> 0x005c }
            r8 = r14
            goto L_0x00bd
        L_0x005c:
            r0 = move-exception
            r10 = r15
            goto L_0x013b
        L_0x0060:
            kotlin.ResultKt.throwOnFailure(r20)
            java.lang.Object r0 = r1.L$0
            r15 = r0
            kotlinx.coroutines.channels.ProducerScope r15 = (kotlinx.coroutines.channels.ProducerScope) r15
            kotlinx.coroutines.flow.Flow<java.lang.Object> r0 = r1.$this_handleMessageStream
            boolean r14 = r1.$finishWithCompleteContent
            kotlin.jvm.functions.Function2<java.lang.String, java.lang.String, kotlin.Unit> r13 = r1.$onSuccessFinish
            kotlin.jvm.functions.Function1<java.lang.Object, com.xjsd.ai.assistant.chatgpt.util.GptUtil$MessageStreamData> r11 = r1.$handleResponse
            kotlin.Result$Companion r10 = kotlin.Result.Companion     // Catch:{ all -> 0x005c }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x005c }
            r12.<init>()     // Catch:{ all -> 0x005c }
            kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ all -> 0x005c }
            r10.<init>()     // Catch:{ all -> 0x005c }
            kotlin.jvm.internal.Ref$IntRef r5 = new kotlin.jvm.internal.Ref$IntRef     // Catch:{ all -> 0x005c }
            r5.<init>()     // Catch:{ all -> 0x005c }
            r5.element = r8     // Catch:{ all -> 0x005c }
            com.xjsd.ai.assistant.chatgpt.util.GptUtil$handleMessageStream$1$invokeSuspend$lambda$4$$inlined$collectIndexed$1 r6 = new com.xjsd.ai.assistant.chatgpt.util.GptUtil$handleMessageStream$1$invokeSuspend$lambda$4$$inlined$collectIndexed$1     // Catch:{ all -> 0x005c }
            r20 = r10
            r10 = r6
            r16 = r12
            r12 = r5
            r9 = r13
            r13 = r20
            r8 = r14
            r14 = r16
            r17 = r15
            r10.<init>(r11, r12, r13, r14, r15)     // Catch:{ all -> 0x0138 }
            r10 = r17
            r1.L$0 = r10     // Catch:{ all -> 0x0039 }
            r1.L$1 = r9     // Catch:{ all -> 0x0039 }
            r1.L$2 = r10     // Catch:{ all -> 0x0039 }
            r11 = r16
            r1.L$3 = r11     // Catch:{ all -> 0x0039 }
            r12 = r20
            r1.L$4 = r12     // Catch:{ all -> 0x0039 }
            r1.L$5 = r5     // Catch:{ all -> 0x0039 }
            r1.Z$0 = r8     // Catch:{ all -> 0x0039 }
            r1.label = r7     // Catch:{ all -> 0x0039 }
            java.lang.Object r0 = r0.collect(r6, r1)     // Catch:{ all -> 0x0039 }
            if (r0 != r2) goto L_0x00b3
            return r2
        L_0x00b3:
            r0 = r8
            r8 = r9
            r13 = r10
            r15 = r13
            r10 = r5
            r18 = r12
            r12 = r11
            r11 = r18
        L_0x00bd:
            int r5 = r10.element     // Catch:{ all -> 0x005c }
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r5)     // Catch:{ all -> 0x005c }
            int r6 = r5.intValue()     // Catch:{ all -> 0x005c }
            if (r6 == r7) goto L_0x00ca
            goto L_0x00cb
        L_0x00ca:
            r5 = 0
        L_0x00cb:
            if (r5 == 0) goto L_0x00d3
            int r0 = r5.intValue()     // Catch:{ all -> 0x005c }
        L_0x00d1:
            r5 = 2
            goto L_0x00d9
        L_0x00d3:
            if (r0 == 0) goto L_0x00d7
            r0 = 0
            goto L_0x00d1
        L_0x00d7:
            r0 = 2
            goto L_0x00d1
        L_0x00d9:
            if (r0 != r5) goto L_0x00e0
            java.lang.String r5 = r12.toString()     // Catch:{ all -> 0x005c }
            goto L_0x00e1
        L_0x00e0:
            r5 = r4
        L_0x00e1:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)     // Catch:{ all -> 0x005c }
            int r6 = r10.element     // Catch:{ all -> 0x005c }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x005c }
            r7.<init>()     // Catch:{ all -> 0x005c }
            java.lang.String r9 = "handleMessageStream finish. streamStatus="
            r7.append(r9)     // Catch:{ all -> 0x005c }
            r7.append(r6)     // Catch:{ all -> 0x005c }
            java.lang.String r6 = " finalStr="
            r7.append(r6)     // Catch:{ all -> 0x005c }
            r7.append(r5)     // Catch:{ all -> 0x005c }
            java.lang.String r6 = r7.toString()     // Catch:{ all -> 0x005c }
            com.xjsd.ai.assistant.log.ILog.a(r3, r6)     // Catch:{ all -> 0x005c }
            com.xjsd.ai.assistant.chatgpt.util.GptUtil r6 = com.xjsd.ai.assistant.chatgpt.util.GptUtil.f8402a     // Catch:{ all -> 0x005c }
            r1.L$0 = r15     // Catch:{ all -> 0x005c }
            r1.L$1 = r8     // Catch:{ all -> 0x005c }
            r1.L$2 = r12     // Catch:{ all -> 0x005c }
            r1.L$3 = r11     // Catch:{ all -> 0x005c }
            r7 = 0
            r1.L$4 = r7     // Catch:{ all -> 0x005c }
            r1.L$5 = r7     // Catch:{ all -> 0x005c }
            r7 = 2
            r1.label = r7     // Catch:{ all -> 0x005c }
            java.lang.Object r0 = r6.i(r13, r5, r0, r1)     // Catch:{ all -> 0x005c }
            if (r0 != r2) goto L_0x011b
            return r2
        L_0x011b:
            r0 = r11
            r7 = r12
            r10 = r15
        L_0x011e:
            if (r8 == 0) goto L_0x0132
            T r0 = r0.element     // Catch:{ all -> 0x0039 }
            java.lang.String r5 = r7.toString()     // Catch:{ all -> 0x0039 }
            java.lang.String r6 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)     // Catch:{ all -> 0x0039 }
            r8.invoke(r0, r5)     // Catch:{ all -> 0x0039 }
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0039 }
            goto L_0x0133
        L_0x0132:
            r7 = 0
        L_0x0133:
            java.lang.Object r0 = kotlin.Result.m20constructorimpl(r7)     // Catch:{ all -> 0x0039 }
            goto L_0x0145
        L_0x0138:
            r0 = move-exception
            r10 = r17
        L_0x013b:
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m20constructorimpl(r0)
        L_0x0145:
            java.lang.Throwable r5 = kotlin.Result.m23exceptionOrNullimpl(r0)
            if (r5 != 0) goto L_0x014c
            goto L_0x0163
        L_0x014c:
            boolean r0 = r5 instanceof java.util.concurrent.CancellationException     // Catch:{ all -> 0x0156 }
            if (r0 == 0) goto L_0x0158
            com.xjsd.ai.assistant.chatgpt.model.UserCancelException r0 = new com.xjsd.ai.assistant.chatgpt.model.UserCancelException     // Catch:{ all -> 0x0156 }
            r0.<init>(r5)     // Catch:{ all -> 0x0156 }
            throw r0     // Catch:{ all -> 0x0156 }
        L_0x0156:
            r0 = move-exception
            goto L_0x0159
        L_0x0158:
            throw r5     // Catch:{ all -> 0x0156 }
        L_0x0159:
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m20constructorimpl(r0)
        L_0x0163:
            java.lang.Throwable r5 = kotlin.Result.m23exceptionOrNullimpl(r0)
            if (r5 == 0) goto L_0x0188
            java.lang.String r6 = "handleMessageStream error"
            com.xjsd.ai.assistant.log.ILog.h(r3, r6, r5)
            com.xjsd.ai.assistant.chatgpt.util.GptUtil r3 = com.xjsd.ai.assistant.chatgpt.util.GptUtil.f8402a
            r1.L$0 = r0
            r5 = 0
            r1.L$1 = r5
            r1.L$2 = r5
            r1.L$3 = r5
            r1.L$4 = r5
            r1.L$5 = r5
            r5 = 3
            r1.label = r5
            r5 = 0
            java.lang.Object r0 = r3.i(r10, r4, r5, r1)
            if (r0 != r2) goto L_0x0188
            return r2
        L_0x0188:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.chatgpt.util.GptUtil$handleMessageStream$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super LlmResponse> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GptUtil$handleMessageStream$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
