package com.xjsd.ai.assistant.chatgpt.util;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.FlowCollector;

@SourceDebugExtension({"SMAP\nCollect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collect.kt\nkotlinx/coroutines/flow/FlowKt__CollectKt$collectIndexed$2\n+ 2 FlowExceptions.common.kt\nkotlinx/coroutines/flow/internal/FlowExceptions_commonKt\n+ 3 GptUtil.kt\ncom/xjsd/ai/assistant/chatgpt/util/GptUtil$handleMessageStream$1\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,118:1\n32#2,4:119\n111#3,5:123\n116#3,7:129\n1#4:128\n*S KotlinDebug\n*F\n+ 1 Collect.kt\nkotlinx/coroutines/flow/FlowKt__CollectKt$collectIndexed$2\n*L\n62#1:119,4\n*E\n"})
@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\n¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collectIndexed$2", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "a", "I", "index", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0})
public final class GptUtil$handleMessageStream$1$invokeSuspend$lambda$4$$inlined$collectIndexed$1 implements FlowCollector<Object> {

    /* renamed from: a  reason: collision with root package name */
    public int f8403a;
    public final /* synthetic */ Function1 b;
    public final /* synthetic */ Ref.IntRef c;
    public final /* synthetic */ Ref.ObjectRef d;
    public final /* synthetic */ StringBuilder e;
    public final /* synthetic */ ProducerScope f;

    public GptUtil$handleMessageStream$1$invokeSuspend$lambda$4$$inlined$collectIndexed$1(Function1 function1, Ref.IntRef intRef, Ref.ObjectRef objectRef, StringBuilder sb, ProducerScope producerScope) {
        this.b = function1;
        this.c = intRef;
        this.d = objectRef;
        this.e = sb;
        this.f = producerScope;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x006e, code lost:
        r4 = com.xjsd.ai.assistant.chatgpt.util.GptUtil.c(com.xjsd.ai.assistant.chatgpt.util.GptUtil.f8402a, r4.f, r5, 1, r6);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            int r0 = r4.f8403a
            int r1 = r0 + 1
            r4.f8403a = r1
            if (r0 < 0) goto L_0x0080
            kotlin.jvm.functions.Function1 r1 = r4.b
            java.lang.Object r5 = r1.invoke(r5)
            com.xjsd.ai.assistant.chatgpt.util.GptUtil$MessageStreamData r5 = (com.xjsd.ai.assistant.chatgpt.util.GptUtil.MessageStreamData) r5
            kotlin.jvm.internal.Ref$IntRef r1 = r4.c
            int r2 = r5.c()
            r1.element = r2
            kotlin.jvm.internal.Ref$ObjectRef r1 = r4.d
            java.lang.String r2 = r5.b()
            r1.element = r2
            java.lang.String r5 = r5.a()
            if (r0 != 0) goto L_0x002e
            java.lang.CharSequence r5 = kotlin.text.StringsKt.trimStart((java.lang.CharSequence) r5)
            java.lang.String r5 = r5.toString()
        L_0x002e:
            kotlin.jvm.internal.Ref$IntRef r0 = r4.c
            int r0 = r0.element
            kotlin.jvm.internal.Ref$ObjectRef r1 = r4.d
            T r1 = r1.element
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "handleMessageStream streamStatus="
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = " streamRole="
            r2.append(r0)
            r2.append(r1)
            java.lang.String r0 = " formatContent="
            r2.append(r0)
            r2.append(r5)
            java.lang.String r0 = r2.toString()
            java.lang.String r1 = "ChatGptUtil"
            com.xjsd.ai.assistant.log.ILog.a(r1, r0)
            java.lang.StringBuilder r0 = r4.e
            r0.append(r5)
            kotlin.jvm.internal.Ref$IntRef r0 = r4.c
            int r0 = r0.element
            r1 = 1
            if (r0 == r1) goto L_0x006e
            int r0 = r5.length()
            if (r0 <= 0) goto L_0x007d
        L_0x006e:
            com.xjsd.ai.assistant.chatgpt.util.GptUtil r0 = com.xjsd.ai.assistant.chatgpt.util.GptUtil.f8402a
            kotlinx.coroutines.channels.ProducerScope r4 = r4.f
            java.lang.Object r4 = r0.i(r4, r5, r1, r6)
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r4 != r5) goto L_0x007d
            return r4
        L_0x007d:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L_0x0080:
            java.lang.ArithmeticException r4 = new java.lang.ArithmeticException
            java.lang.String r5 = "Index overflow has happened"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.chatgpt.util.GptUtil$handleMessageStream$1$invokeSuspend$lambda$4$$inlined$collectIndexed$1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
