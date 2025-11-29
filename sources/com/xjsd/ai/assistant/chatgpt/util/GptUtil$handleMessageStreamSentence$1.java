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

@SourceDebugExtension({"SMAP\nGptUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GptUtil.kt\ncom/xjsd/ai/assistant/chatgpt/util/GptUtil$handleMessageStreamSentence$1\n+ 2 Collect.kt\nkotlinx/coroutines/flow/FlowKt__CollectKt\n*L\n1#1,259:1\n60#2,4:260\n*S KotlinDebug\n*F\n+ 1 GptUtil.kt\ncom/xjsd/ai/assistant/chatgpt/util/GptUtil$handleMessageStreamSentence$1\n*L\n162#1:260,4\n*E\n"})
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00020\u00040\u0003H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/xjsd/ai/assistant/chatgpt/model/LlmResponse;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.chatgpt.util.GptUtil$handleMessageStreamSentence$1", f = "GptUtil.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2}, l = {260, 219, 226, 236}, m = "invokeSuspend", n = {"$this$channelFlow", "$this$invokeSuspend_u24lambda_u245", "messageStr", "streamRole", "streamStatus", "tempString", "$this$channelFlow", "$this$invokeSuspend_u24lambda_u245", "messageStr", "streamRole", "streamStatus", "$this$channelFlow", "messageStr", "streamRole"}, s = {"L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$2", "L$3", "L$4", "L$5", "L$0", "L$2", "L$3"})
public final class GptUtil$handleMessageStreamSentence$1 extends SuspendLambda implements Function2<ProducerScope<? super LlmResponse>, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $finishWithCompleteContent;
    final /* synthetic */ Function1<Object, GptUtil.MessageStreamData> $handleResponse;
    final /* synthetic */ Function2<String, String, Unit> $onSuccessFinish;
    final /* synthetic */ GptUtil.SplitConfig $splitConfig;
    final /* synthetic */ Flow<Object> $this_handleMessageStreamSentence;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    boolean Z$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GptUtil$handleMessageStreamSentence$1(Flow<Object> flow, boolean z, Function2<? super String, ? super String, Unit> function2, Function1<Object, GptUtil.MessageStreamData> function1, GptUtil.SplitConfig splitConfig, Continuation<? super GptUtil$handleMessageStreamSentence$1> continuation) {
        super(2, continuation);
        this.$this_handleMessageStreamSentence = flow;
        this.$finishWithCompleteContent = z;
        this.$onSuccessFinish = function2;
        this.$handleResponse = function1;
        this.$splitConfig = splitConfig;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GptUtil$handleMessageStreamSentence$1 gptUtil$handleMessageStreamSentence$1 = new GptUtil$handleMessageStreamSentence$1(this.$this_handleMessageStreamSentence, this.$finishWithCompleteContent, this.$onSuccessFinish, this.$handleResponse, this.$splitConfig, continuation);
        gptUtil$handleMessageStreamSentence$1.L$0 = obj;
        return gptUtil$handleMessageStreamSentence$1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v25, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: kotlinx.coroutines.channels.ProducerScope} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0128 A[Catch:{ all -> 0x0085 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0129 A[Catch:{ all -> 0x0085 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x012c A[Catch:{ all -> 0x0085 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0132 A[Catch:{ all -> 0x0085 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x013a A[Catch:{ all -> 0x0085 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x013f A[Catch:{ all -> 0x0085 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x017b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x017c  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0180 A[SYNTHETIC, Splitter:B:54:0x0180] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0192 A[Catch:{ all -> 0x003c }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01a9 A[SYNTHETIC, Splitter:B:61:0x01a9] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01c6  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r26) {
        /*
            r25 = this;
            r1 = r25
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r1.label
            java.lang.String r3 = "ChatGptUtil"
            r4 = 4
            r5 = 3
            java.lang.String r7 = ""
            r8 = 2
            r9 = 1
            if (r0 == 0) goto L_0x0089
            if (r0 == r9) goto L_0x0062
            if (r0 == r8) goto L_0x003f
            if (r0 == r5) goto L_0x0027
            if (r0 != r4) goto L_0x001f
            kotlin.ResultKt.throwOnFailure(r26)
            goto L_0x01e7
        L_0x001f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0027:
            java.lang.Object r0 = r1.L$3
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            java.lang.Object r5 = r1.L$2
            java.lang.StringBuilder r5 = (java.lang.StringBuilder) r5
            java.lang.Object r8 = r1.L$1
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            java.lang.Object r9 = r1.L$0
            kotlinx.coroutines.channels.ProducerScope r9 = (kotlinx.coroutines.channels.ProducerScope) r9
            kotlin.ResultKt.throwOnFailure(r26)     // Catch:{ all -> 0x003c }
            goto L_0x017e
        L_0x003c:
            r0 = move-exception
            goto L_0x0198
        L_0x003f:
            boolean r0 = r1.Z$0
            java.lang.Object r11 = r1.L$5
            kotlin.jvm.internal.Ref$IntRef r11 = (kotlin.jvm.internal.Ref.IntRef) r11
            java.lang.Object r12 = r1.L$4
            kotlin.jvm.internal.Ref$ObjectRef r12 = (kotlin.jvm.internal.Ref.ObjectRef) r12
            java.lang.Object r13 = r1.L$3
            java.lang.StringBuilder r13 = (java.lang.StringBuilder) r13
            java.lang.Object r14 = r1.L$2
            kotlinx.coroutines.channels.ProducerScope r14 = (kotlinx.coroutines.channels.ProducerScope) r14
            java.lang.Object r15 = r1.L$1
            kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
            java.lang.Object r6 = r1.L$0
            kotlinx.coroutines.channels.ProducerScope r6 = (kotlinx.coroutines.channels.ProducerScope) r6
            kotlin.ResultKt.throwOnFailure(r26)     // Catch:{ all -> 0x005e }
            goto L_0x0119
        L_0x005e:
            r0 = move-exception
            r9 = r6
            goto L_0x0198
        L_0x0062:
            boolean r0 = r1.Z$0
            java.lang.Object r6 = r1.L$6
            kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref.ObjectRef) r6
            java.lang.Object r11 = r1.L$5
            kotlin.jvm.internal.Ref$IntRef r11 = (kotlin.jvm.internal.Ref.IntRef) r11
            java.lang.Object r12 = r1.L$4
            kotlin.jvm.internal.Ref$ObjectRef r12 = (kotlin.jvm.internal.Ref.ObjectRef) r12
            java.lang.Object r13 = r1.L$3
            java.lang.StringBuilder r13 = (java.lang.StringBuilder) r13
            java.lang.Object r14 = r1.L$2
            kotlinx.coroutines.channels.ProducerScope r14 = (kotlinx.coroutines.channels.ProducerScope) r14
            java.lang.Object r15 = r1.L$1
            kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
            java.lang.Object r4 = r1.L$0
            kotlinx.coroutines.channels.ProducerScope r4 = (kotlinx.coroutines.channels.ProducerScope) r4
            kotlin.ResultKt.throwOnFailure(r26)     // Catch:{ all -> 0x0085 }
            goto L_0x00ec
        L_0x0085:
            r0 = move-exception
            r9 = r4
            goto L_0x0198
        L_0x0089:
            kotlin.ResultKt.throwOnFailure(r26)
            java.lang.Object r0 = r1.L$0
            r4 = r0
            kotlinx.coroutines.channels.ProducerScope r4 = (kotlinx.coroutines.channels.ProducerScope) r4
            kotlinx.coroutines.flow.Flow<java.lang.Object> r0 = r1.$this_handleMessageStreamSentence
            boolean r6 = r1.$finishWithCompleteContent
            kotlin.jvm.functions.Function2<java.lang.String, java.lang.String, kotlin.Unit> r11 = r1.$onSuccessFinish
            kotlin.jvm.functions.Function1<java.lang.Object, com.xjsd.ai.assistant.chatgpt.util.GptUtil$MessageStreamData> r12 = r1.$handleResponse
            com.xjsd.ai.assistant.chatgpt.util.GptUtil$SplitConfig r13 = r1.$splitConfig
            kotlin.Result$Companion r14 = kotlin.Result.Companion     // Catch:{ all -> 0x0085 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x0085 }
            r14.<init>()     // Catch:{ all -> 0x0085 }
            kotlin.jvm.internal.Ref$ObjectRef r15 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ all -> 0x0085 }
            r15.<init>()     // Catch:{ all -> 0x0085 }
            kotlin.jvm.internal.Ref$IntRef r5 = new kotlin.jvm.internal.Ref$IntRef     // Catch:{ all -> 0x0085 }
            r5.<init>()     // Catch:{ all -> 0x0085 }
            r5.element = r8     // Catch:{ all -> 0x0085 }
            kotlin.jvm.internal.Ref$ObjectRef r8 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ all -> 0x0085 }
            r8.<init>()     // Catch:{ all -> 0x0085 }
            r8.element = r7     // Catch:{ all -> 0x0085 }
            com.xjsd.ai.assistant.chatgpt.util.GptUtil$handleMessageStreamSentence$1$invokeSuspend$lambda$5$$inlined$collectIndexed$1 r10 = new com.xjsd.ai.assistant.chatgpt.util.GptUtil$handleMessageStreamSentence$1$invokeSuspend$lambda$5$$inlined$collectIndexed$1     // Catch:{ all -> 0x0085 }
            r16 = r10
            r17 = r12
            r18 = r5
            r19 = r15
            r20 = r6
            r21 = r8
            r22 = r4
            r23 = r14
            r24 = r13
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24)     // Catch:{ all -> 0x0085 }
            r1.L$0 = r4     // Catch:{ all -> 0x0085 }
            r1.L$1 = r11     // Catch:{ all -> 0x0085 }
            r1.L$2 = r4     // Catch:{ all -> 0x0085 }
            r1.L$3 = r14     // Catch:{ all -> 0x0085 }
            r1.L$4 = r15     // Catch:{ all -> 0x0085 }
            r1.L$5 = r5     // Catch:{ all -> 0x0085 }
            r1.L$6 = r8     // Catch:{ all -> 0x0085 }
            r1.Z$0 = r6     // Catch:{ all -> 0x0085 }
            r1.label = r9     // Catch:{ all -> 0x0085 }
            java.lang.Object r0 = r0.collect(r10, r1)     // Catch:{ all -> 0x0085 }
            if (r0 != r2) goto L_0x00e5
            return r2
        L_0x00e5:
            r0 = r6
            r6 = r8
            r13 = r14
            r12 = r15
            r14 = r4
            r15 = r11
            r11 = r5
        L_0x00ec:
            T r5 = r6.element     // Catch:{ all -> 0x0085 }
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ all -> 0x0085 }
            boolean r5 = kotlin.text.StringsKt.isBlank(r5)     // Catch:{ all -> 0x0085 }
            r5 = r5 ^ r9
            if (r5 == 0) goto L_0x011a
            com.xjsd.ai.assistant.chatgpt.util.GptUtil r5 = com.xjsd.ai.assistant.chatgpt.util.GptUtil.f8402a     // Catch:{ all -> 0x0085 }
            T r6 = r6.element     // Catch:{ all -> 0x0085 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0085 }
            r1.L$0 = r4     // Catch:{ all -> 0x0085 }
            r1.L$1 = r15     // Catch:{ all -> 0x0085 }
            r1.L$2 = r14     // Catch:{ all -> 0x0085 }
            r1.L$3 = r13     // Catch:{ all -> 0x0085 }
            r1.L$4 = r12     // Catch:{ all -> 0x0085 }
            r1.L$5 = r11     // Catch:{ all -> 0x0085 }
            r8 = 0
            r1.L$6 = r8     // Catch:{ all -> 0x0085 }
            r1.Z$0 = r0     // Catch:{ all -> 0x0085 }
            r8 = 2
            r1.label = r8     // Catch:{ all -> 0x0085 }
            java.lang.Object r5 = r5.i(r14, r6, r9, r1)     // Catch:{ all -> 0x0085 }
            if (r5 != r2) goto L_0x0118
            return r2
        L_0x0118:
            r6 = r4
        L_0x0119:
            r4 = r6
        L_0x011a:
            r5 = r13
            r8 = r15
            int r6 = r11.element     // Catch:{ all -> 0x0085 }
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)     // Catch:{ all -> 0x0085 }
            int r10 = r6.intValue()     // Catch:{ all -> 0x0085 }
            if (r10 == r9) goto L_0x0129
            goto L_0x012a
        L_0x0129:
            r6 = 0
        L_0x012a:
            if (r6 == 0) goto L_0x0132
            int r0 = r6.intValue()     // Catch:{ all -> 0x0085 }
        L_0x0130:
            r6 = 2
            goto L_0x0138
        L_0x0132:
            if (r0 == 0) goto L_0x0136
            r0 = 0
            goto L_0x0130
        L_0x0136:
            r0 = 2
            goto L_0x0130
        L_0x0138:
            if (r0 != r6) goto L_0x013f
            java.lang.String r6 = r5.toString()     // Catch:{ all -> 0x0085 }
            goto L_0x0140
        L_0x013f:
            r6 = r7
        L_0x0140:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)     // Catch:{ all -> 0x0085 }
            int r9 = r11.element     // Catch:{ all -> 0x0085 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0085 }
            r10.<init>()     // Catch:{ all -> 0x0085 }
            java.lang.String r11 = "handleMessageStreamSentence finish. streamStatus="
            r10.append(r11)     // Catch:{ all -> 0x0085 }
            r10.append(r9)     // Catch:{ all -> 0x0085 }
            java.lang.String r9 = " finalStr="
            r10.append(r9)     // Catch:{ all -> 0x0085 }
            r10.append(r6)     // Catch:{ all -> 0x0085 }
            java.lang.String r9 = r10.toString()     // Catch:{ all -> 0x0085 }
            com.xjsd.ai.assistant.log.ILog.a(r3, r9)     // Catch:{ all -> 0x0085 }
            com.xjsd.ai.assistant.chatgpt.util.GptUtil r9 = com.xjsd.ai.assistant.chatgpt.util.GptUtil.f8402a     // Catch:{ all -> 0x0085 }
            r1.L$0 = r4     // Catch:{ all -> 0x0085 }
            r1.L$1 = r8     // Catch:{ all -> 0x0085 }
            r1.L$2 = r5     // Catch:{ all -> 0x0085 }
            r1.L$3 = r12     // Catch:{ all -> 0x0085 }
            r10 = 0
            r1.L$4 = r10     // Catch:{ all -> 0x0085 }
            r1.L$5 = r10     // Catch:{ all -> 0x0085 }
            r1.L$6 = r10     // Catch:{ all -> 0x0085 }
            r10 = 3
            r1.label = r10     // Catch:{ all -> 0x0085 }
            java.lang.Object r0 = r9.i(r14, r6, r0, r1)     // Catch:{ all -> 0x0085 }
            if (r0 != r2) goto L_0x017c
            return r2
        L_0x017c:
            r9 = r4
            r0 = r12
        L_0x017e:
            if (r8 == 0) goto L_0x0192
            T r0 = r0.element     // Catch:{ all -> 0x003c }
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x003c }
            java.lang.String r5 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)     // Catch:{ all -> 0x003c }
            r8.invoke(r0, r4)     // Catch:{ all -> 0x003c }
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x003c }
            goto L_0x0193
        L_0x0192:
            r8 = 0
        L_0x0193:
            java.lang.Object r0 = kotlin.Result.m20constructorimpl(r8)     // Catch:{ all -> 0x003c }
            goto L_0x01a2
        L_0x0198:
            kotlin.Result$Companion r4 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m20constructorimpl(r0)
        L_0x01a2:
            java.lang.Throwable r4 = kotlin.Result.m23exceptionOrNullimpl(r0)
            if (r4 != 0) goto L_0x01a9
            goto L_0x01c0
        L_0x01a9:
            boolean r0 = r4 instanceof java.util.concurrent.CancellationException     // Catch:{ all -> 0x01b3 }
            if (r0 == 0) goto L_0x01b5
            com.xjsd.ai.assistant.chatgpt.model.UserCancelException r0 = new com.xjsd.ai.assistant.chatgpt.model.UserCancelException     // Catch:{ all -> 0x01b3 }
            r0.<init>(r4)     // Catch:{ all -> 0x01b3 }
            throw r0     // Catch:{ all -> 0x01b3 }
        L_0x01b3:
            r0 = move-exception
            goto L_0x01b6
        L_0x01b5:
            throw r4     // Catch:{ all -> 0x01b3 }
        L_0x01b6:
            kotlin.Result$Companion r4 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m20constructorimpl(r0)
        L_0x01c0:
            java.lang.Throwable r4 = kotlin.Result.m23exceptionOrNullimpl(r0)
            if (r4 == 0) goto L_0x01e7
            java.lang.String r5 = "handleMessageStream error"
            com.xjsd.ai.assistant.log.ILog.h(r3, r5, r4)
            com.xjsd.ai.assistant.chatgpt.util.GptUtil r3 = com.xjsd.ai.assistant.chatgpt.util.GptUtil.f8402a
            r1.L$0 = r0
            r4 = 0
            r1.L$1 = r4
            r1.L$2 = r4
            r1.L$3 = r4
            r1.L$4 = r4
            r1.L$5 = r4
            r1.L$6 = r4
            r4 = 4
            r1.label = r4
            r4 = 0
            java.lang.Object r0 = r3.i(r9, r7, r4, r1)
            if (r0 != r2) goto L_0x01e7
            return r2
        L_0x01e7:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.chatgpt.util.GptUtil$handleMessageStreamSentence$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super LlmResponse> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GptUtil$handleMessageStreamSentence$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
