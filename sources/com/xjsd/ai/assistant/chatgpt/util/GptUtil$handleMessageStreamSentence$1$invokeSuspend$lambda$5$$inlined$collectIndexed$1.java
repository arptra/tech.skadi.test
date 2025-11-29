package com.xjsd.ai.assistant.chatgpt.util;

import com.xjsd.ai.assistant.chatgpt.util.GptUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.FlowCollector;

@SourceDebugExtension({"SMAP\nCollect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collect.kt\nkotlinx/coroutines/flow/FlowKt__CollectKt$collectIndexed$2\n+ 2 FlowExceptions.common.kt\nkotlinx/coroutines/flow/internal/FlowExceptions_commonKt\n+ 3 GptUtil.kt\ncom/xjsd/ai/assistant/chatgpt/util/GptUtil$handleMessageStreamSentence$1\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 6 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 7 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,118:1\n32#2,4:119\n163#3,5:123\n168#3,23:129\n191#3:157\n216#3,2:158\n1#4:128\n21#5:152\n23#5:156\n50#6:153\n55#6:155\n106#7:154\n*S KotlinDebug\n*F\n+ 1 Collect.kt\nkotlinx/coroutines/flow/FlowKt__CollectKt$collectIndexed$2\n+ 2 GptUtil.kt\ncom/xjsd/ai/assistant/chatgpt/util/GptUtil$handleMessageStreamSentence$1\n*L\n62#1:119,4\n190#2:152\n190#2:156\n190#2:153\n190#2:155\n190#2:154\n*E\n"})
@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\n¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collectIndexed$2", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "a", "I", "index", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0})
public final class GptUtil$handleMessageStreamSentence$1$invokeSuspend$lambda$5$$inlined$collectIndexed$1 implements FlowCollector<Object> {

    /* renamed from: a  reason: collision with root package name */
    public int f8404a;
    public final /* synthetic */ Function1 b;
    public final /* synthetic */ Ref.IntRef c;
    public final /* synthetic */ Ref.ObjectRef d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ Ref.ObjectRef f;
    public final /* synthetic */ ProducerScope g;
    public final /* synthetic */ StringBuilder h;
    public final /* synthetic */ GptUtil.SplitConfig i;

    public GptUtil$handleMessageStreamSentence$1$invokeSuspend$lambda$5$$inlined$collectIndexed$1(Function1 function1, Ref.IntRef intRef, Ref.ObjectRef objectRef, boolean z, Ref.ObjectRef objectRef2, ProducerScope producerScope, StringBuilder sb, GptUtil.SplitConfig splitConfig) {
        this.b = function1;
        this.c = intRef;
        this.d = objectRef;
        this.e = z;
        this.f = objectRef2;
        this.g = producerScope;
        this.h = sb;
        this.i = splitConfig;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0136 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object emit(java.lang.Object r10, kotlin.coroutines.Continuation r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof com.xjsd.ai.assistant.chatgpt.util.GptUtil$handleMessageStreamSentence$1$invokeSuspend$lambda$5$$inlined$collectIndexed$1.AnonymousClass1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            com.xjsd.ai.assistant.chatgpt.util.GptUtil$handleMessageStreamSentence$1$invokeSuspend$lambda$5$$inlined$collectIndexed$1$1 r0 = (com.xjsd.ai.assistant.chatgpt.util.GptUtil$handleMessageStreamSentence$1$invokeSuspend$lambda$5$$inlined$collectIndexed$1.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.xjsd.ai.assistant.chatgpt.util.GptUtil$handleMessageStreamSentence$1$invokeSuspend$lambda$5$$inlined$collectIndexed$1$1 r0 = new com.xjsd.ai.assistant.chatgpt.util.GptUtil$handleMessageStreamSentence$1$invokeSuspend$lambda$5$$inlined$collectIndexed$1$1
            r0.<init>(r9, r11)
        L_0x0018:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = ""
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0047
            if (r2 == r5) goto L_0x0037
            if (r2 != r4) goto L_0x002f
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0137
        L_0x002f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0037:
            java.lang.Object r9 = r0.L$1
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r10 = r0.L$0
            com.xjsd.ai.assistant.chatgpt.util.GptUtil$handleMessageStreamSentence$1$invokeSuspend$lambda$5$$inlined$collectIndexed$1 r10 = (com.xjsd.ai.assistant.chatgpt.util.GptUtil$handleMessageStreamSentence$1$invokeSuspend$lambda$5$$inlined$collectIndexed$1) r10
            kotlin.ResultKt.throwOnFailure(r11)
            r8 = r10
            r10 = r9
            r9 = r8
            goto L_0x00d9
        L_0x0047:
            kotlin.ResultKt.throwOnFailure(r11)
            int r11 = r9.f8404a
            int r2 = r11 + 1
            r9.f8404a = r2
            if (r11 < 0) goto L_0x013a
            kotlin.jvm.functions.Function1 r2 = r9.b
            java.lang.Object r10 = r2.invoke(r10)
            com.xjsd.ai.assistant.chatgpt.util.GptUtil$MessageStreamData r10 = (com.xjsd.ai.assistant.chatgpt.util.GptUtil.MessageStreamData) r10
            kotlin.jvm.internal.Ref$IntRef r2 = r9.c
            int r6 = r10.c()
            r2.element = r6
            kotlin.jvm.internal.Ref$ObjectRef r2 = r9.d
            java.lang.String r6 = r10.b()
            r2.element = r6
            java.lang.String r10 = r10.a()
            if (r11 != 0) goto L_0x0078
            java.lang.CharSequence r10 = kotlin.text.StringsKt.trimStart((java.lang.CharSequence) r10)
            java.lang.String r10 = r10.toString()
        L_0x0078:
            kotlin.jvm.internal.Ref$IntRef r11 = r9.c
            int r11 = r11.element
            kotlin.jvm.internal.Ref$ObjectRef r2 = r9.d
            T r2 = r2.element
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "handleMessageStreamSentence streamStatus="
            r6.append(r7)
            r6.append(r11)
            java.lang.String r11 = " streamRole="
            r6.append(r11)
            r6.append(r2)
            java.lang.String r11 = " formatContent="
            r6.append(r11)
            r6.append(r10)
            java.lang.String r11 = r6.toString()
            java.lang.String r2 = "ChatGptUtil"
            com.xjsd.ai.assistant.log.ILog.a(r2, r11)
            boolean r11 = r9.e
            if (r11 == 0) goto L_0x00dd
            kotlin.jvm.internal.Ref$IntRef r11 = r9.c
            int r11 = r11.element
            if (r11 == 0) goto L_0x0137
            if (r11 == r4) goto L_0x0137
            r2 = 3
            if (r11 == r2) goto L_0x00b6
            goto L_0x00dd
        L_0x00b6:
            kotlin.jvm.internal.Ref$ObjectRef r11 = r9.f
            T r11 = r11.element
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            int r11 = r11.length()
            if (r11 <= 0) goto L_0x00dd
            com.xjsd.ai.assistant.chatgpt.util.GptUtil r11 = com.xjsd.ai.assistant.chatgpt.util.GptUtil.f8402a
            kotlinx.coroutines.channels.ProducerScope r2 = r9.g
            kotlin.jvm.internal.Ref$ObjectRef r6 = r9.f
            T r6 = r6.element
            java.lang.String r6 = (java.lang.String) r6
            r0.L$0 = r9
            r0.L$1 = r10
            r0.label = r5
            java.lang.Object r11 = r11.i(r2, r6, r5, r0)
            if (r11 != r1) goto L_0x00d9
            return r1
        L_0x00d9:
            kotlin.jvm.internal.Ref$ObjectRef r11 = r9.f
            r11.element = r3
        L_0x00dd:
            java.lang.StringBuilder r11 = r9.h
            r11.append(r10)
            kotlin.jvm.internal.Ref$IntRef r11 = r9.c
            int r11 = r11.element
            if (r11 == r5) goto L_0x00ee
            int r11 = r10.length()
            if (r11 <= 0) goto L_0x0137
        L_0x00ee:
            kotlin.jvm.internal.Ref$ObjectRef r11 = r9.f
            T r11 = r11.element
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r11)
            r2.append(r10)
            java.lang.String r10 = r2.toString()
            kotlin.jvm.internal.Ref$ObjectRef r11 = r9.f
            r11.element = r3
            kotlin.text.Regex r11 = new kotlin.text.Regex
            com.xjsd.ai.assistant.chatgpt.util.GptUtil$SplitConfig r2 = r9.i
            java.lang.String r2 = r2.e()
            r11.<init>((java.lang.String) r2)
            r2 = 0
            java.util.List r10 = r11.split(r10, r2)
            kotlinx.coroutines.flow.Flow r10 = kotlinx.coroutines.flow.FlowKt.a(r10)
            com.xjsd.ai.assistant.chatgpt.util.GptUtil$handleMessageStreamSentence$1$invokeSuspend$lambda$5$lambda$3$lambda$2$$inlined$filter$1 r11 = new com.xjsd.ai.assistant.chatgpt.util.GptUtil$handleMessageStreamSentence$1$invokeSuspend$lambda$5$lambda$3$lambda$2$$inlined$filter$1
            r11.<init>(r10)
            com.xjsd.ai.assistant.chatgpt.util.GptUtil$handleMessageStreamSentence$1$1$1$1$2 r10 = new com.xjsd.ai.assistant.chatgpt.util.GptUtil$handleMessageStreamSentence$1$1$1$1$2
            kotlin.jvm.internal.Ref$ObjectRef r2 = r9.f
            com.xjsd.ai.assistant.chatgpt.util.GptUtil$SplitConfig r3 = r9.i
            kotlinx.coroutines.channels.ProducerScope r9 = r9.g
            r10.<init>(r2, r3, r9)
            r9 = 0
            r0.L$0 = r9
            r0.L$1 = r9
            r0.label = r4
            java.lang.Object r9 = r11.collect(r10, r0)
            if (r9 != r1) goto L_0x0137
            return r1
        L_0x0137:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x013a:
            java.lang.ArithmeticException r9 = new java.lang.ArithmeticException
            java.lang.String r10 = "Index overflow has happened"
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.chatgpt.util.GptUtil$handleMessageStreamSentence$1$invokeSuspend$lambda$5$$inlined$collectIndexed$1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
