package com.xjsd.ai.assistant.chatgpt.util;

import com.xjsd.ai.assistant.chatgpt.util.GptUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "", "it", "", "d", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0})
public final class GptUtil$handleMessageStreamSentence$1$1$1$1$2<T> implements FlowCollector {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f8409a;
    public final /* synthetic */ GptUtil.SplitConfig b;
    public final /* synthetic */ ProducerScope c;

    public GptUtil$handleMessageStreamSentence$1$1$1$1$2(Ref.ObjectRef objectRef, GptUtil.SplitConfig splitConfig, ProducerScope producerScope) {
        this.f8409a = objectRef;
        this.b = splitConfig;
        this.c = producerScope;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0123 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object emit(java.lang.String r10, kotlin.coroutines.Continuation r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof com.xjsd.ai.assistant.chatgpt.util.GptUtil$handleMessageStreamSentence$1$1$1$1$2$emit$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            com.xjsd.ai.assistant.chatgpt.util.GptUtil$handleMessageStreamSentence$1$1$1$1$2$emit$1 r0 = (com.xjsd.ai.assistant.chatgpt.util.GptUtil$handleMessageStreamSentence$1$1$1$1$2$emit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.xjsd.ai.assistant.chatgpt.util.GptUtil$handleMessageStreamSentence$1$1$1$1$2$emit$1 r0 = new com.xjsd.ai.assistant.chatgpt.util.GptUtil$handleMessageStreamSentence$1$1$1$1$2$emit$1
            r0.<init>(r9, r11)
        L_0x0018:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 0
            r5 = 1
            r6 = 2
            if (r2 == 0) goto L_0x0047
            if (r2 == r5) goto L_0x003f
            if (r2 != r6) goto L_0x0037
            java.lang.Object r9 = r0.L$1
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r10 = r0.L$0
            com.xjsd.ai.assistant.chatgpt.util.GptUtil$handleMessageStreamSentence$1$1$1$1$2 r10 = (com.xjsd.ai.assistant.chatgpt.util.GptUtil$handleMessageStreamSentence$1$1$1$1$2) r10
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0127
        L_0x0037:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003f:
            java.lang.Object r9 = r0.L$0
            com.xjsd.ai.assistant.chatgpt.util.GptUtil$handleMessageStreamSentence$1$1$1$1$2 r9 = (com.xjsd.ai.assistant.chatgpt.util.GptUtil$handleMessageStreamSentence$1$1$1$1$2) r9
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00bc
        L_0x0047:
            kotlin.ResultKt.throwOnFailure(r11)
            kotlin.jvm.internal.Ref$ObjectRef r11 = r9.f8409a
            T r2 = r11.element
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r2)
            r7.append(r10)
            java.lang.String r10 = r7.toString()
            r11.element = r10
            kotlin.jvm.internal.Ref$ObjectRef r10 = r9.f8409a
            T r10 = r10.element
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            java.lang.String r11 = "["
            boolean r10 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r10, (java.lang.CharSequence) r11, (boolean) r4, (int) r6, (java.lang.Object) r3)
            if (r10 == 0) goto L_0x007e
            kotlin.jvm.internal.Ref$ObjectRef r10 = r9.f8409a
            T r10 = r10.element
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            java.lang.String r11 = "]"
            boolean r10 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r10, (java.lang.CharSequence) r11, (boolean) r4, (int) r6, (java.lang.Object) r3)
            if (r10 != 0) goto L_0x007e
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x007e:
            kotlin.jvm.internal.Ref$ObjectRef r10 = r9.f8409a
            T r10 = r10.element
            java.lang.String r10 = (java.lang.String) r10
            int r10 = r10.length()
            com.xjsd.ai.assistant.chatgpt.util.GptUtil$SplitConfig r11 = r9.b
            int r11 = r11.d()
            if (r10 <= r11) goto L_0x00c2
            kotlin.text.Regex r10 = new kotlin.text.Regex
            com.xjsd.ai.assistant.chatgpt.util.GptUtil$SplitConfig r11 = r9.b
            java.lang.String r11 = r11.a()
            r10.<init>((java.lang.String) r11)
            kotlin.jvm.internal.Ref$ObjectRef r11 = r9.f8409a
            T r11 = r11.element
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            boolean r10 = r10.matches(r11)
            if (r10 == 0) goto L_0x00c2
            com.xjsd.ai.assistant.chatgpt.util.GptUtil r10 = com.xjsd.ai.assistant.chatgpt.util.GptUtil.f8402a
            kotlinx.coroutines.channels.ProducerScope r11 = r9.c
            kotlin.jvm.internal.Ref$ObjectRef r2 = r9.f8409a
            T r2 = r2.element
            java.lang.String r2 = (java.lang.String) r2
            r0.L$0 = r9
            r0.label = r5
            java.lang.Object r10 = r10.i(r11, r2, r5, r0)
            if (r10 != r1) goto L_0x00bc
            return r1
        L_0x00bc:
            kotlin.jvm.internal.Ref$ObjectRef r10 = r9.f8409a
            java.lang.String r11 = ""
            r10.element = r11
        L_0x00c2:
            com.xjsd.ai.assistant.chatgpt.util.GptUtil$SplitConfig r10 = r9.b
            int r10 = r10.b()
            if (r10 <= 0) goto L_0x012b
            kotlin.jvm.internal.Ref$ObjectRef r10 = r9.f8409a
            T r10 = r10.element
            java.lang.String r10 = (java.lang.String) r10
            int r10 = r10.length()
            com.xjsd.ai.assistant.chatgpt.util.GptUtil$SplitConfig r11 = r9.b
            int r11 = r11.b()
            if (r10 <= r11) goto L_0x012b
            kotlin.text.Regex r10 = new kotlin.text.Regex
            com.xjsd.ai.assistant.chatgpt.util.GptUtil$SplitConfig r11 = r9.b
            java.lang.String r11 = r11.c()
            r10.<init>((java.lang.String) r11)
            kotlin.jvm.internal.Ref$ObjectRef r11 = r9.f8409a
            T r11 = r11.element
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            kotlin.text.MatchResult r10 = kotlin.text.Regex.find$default(r10, r11, r4, r6, r3)
            if (r10 == 0) goto L_0x012b
            kotlin.text.MatchResult$Destructured r10 = r10.getDestructured()
            kotlin.text.MatchResult r11 = r10.getMatch()
            java.util.List r11 = r11.getGroupValues()
            java.lang.Object r11 = r11.get(r5)
            java.lang.String r11 = (java.lang.String) r11
            kotlin.text.MatchResult r10 = r10.getMatch()
            java.util.List r10 = r10.getGroupValues()
            java.lang.Object r10 = r10.get(r6)
            java.lang.String r10 = (java.lang.String) r10
            com.xjsd.ai.assistant.chatgpt.util.GptUtil r2 = com.xjsd.ai.assistant.chatgpt.util.GptUtil.f8402a
            kotlinx.coroutines.channels.ProducerScope r3 = r9.c
            r0.L$0 = r9
            r0.L$1 = r10
            r0.label = r6
            java.lang.Object r11 = r2.i(r3, r11, r5, r0)
            if (r11 != r1) goto L_0x0124
            return r1
        L_0x0124:
            r8 = r10
            r10 = r9
            r9 = r8
        L_0x0127:
            kotlin.jvm.internal.Ref$ObjectRef r10 = r10.f8409a
            r10.element = r9
        L_0x012b:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.chatgpt.util.GptUtil$handleMessageStreamSentence$1$1$1$1$2.emit(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
