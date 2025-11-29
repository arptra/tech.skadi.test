package com.xjsd.ai.assistant.flutter.nlp;

import com.xjsd.ai.assistant.flutter.nlp.NlpPreprocessor;
import com.xjsd.ai.assistant.nlu.bean.NluResponse;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import com.xjsd.ai.assistant.template.TtsTemplate;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H@¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/xjsd/ai/assistant/flutter/nlp/MediaNlpPreprocessor;", "Lcom/xjsd/ai/assistant/flutter/nlp/NlpPreprocessor;", "<init>", "()V", "", "b", "()Ljava/lang/String;", "Lcom/xjsd/ai/assistant/nlu/bean/NluResponse;", "nluResponse", "i", "(Lcom/xjsd/ai/assistant/nlu/bean/NluResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class MediaNlpPreprocessor implements NlpPreprocessor {
    public void a(NluResponse nluResponse) {
        NlpPreprocessor.DefaultImpls.i(this, nluResponse);
    }

    public String b() {
        return VuiModelType.MEDIA;
    }

    public Object c(NluResponse nluResponse, Continuation continuation) {
        return NlpPreprocessor.DefaultImpls.e(this, nluResponse, continuation);
    }

    public void clean() {
        NlpPreprocessor.DefaultImpls.a(this);
    }

    public void d(NluResponse nluResponse, int i) {
        NlpPreprocessor.DefaultImpls.j(this, nluResponse, i);
    }

    public void e(NluResponse nluResponse, TtsTemplate ttsTemplate) {
        NlpPreprocessor.DefaultImpls.k(this, nluResponse, ttsTemplate);
    }

    public void f(String str, String str2) {
        NlpPreprocessor.DefaultImpls.d(this, str, str2);
    }

    public boolean g(NluResponse nluResponse) {
        return NlpPreprocessor.DefaultImpls.c(this, nluResponse);
    }

    public void h(NluResponse nluResponse, String str) {
        NlpPreprocessor.DefaultImpls.l(this, nluResponse, str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object i(com.xjsd.ai.assistant.nlu.bean.NluResponse r7, kotlin.coroutines.Continuation r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.xjsd.ai.assistant.flutter.nlp.MediaNlpPreprocessor$process$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.xjsd.ai.assistant.flutter.nlp.MediaNlpPreprocessor$process$1 r0 = (com.xjsd.ai.assistant.flutter.nlp.MediaNlpPreprocessor$process$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.xjsd.ai.assistant.flutter.nlp.MediaNlpPreprocessor$process$1 r0 = new com.xjsd.ai.assistant.flutter.nlp.MediaNlpPreprocessor$process$1
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r6 = r0.L$0
            r7 = r6
            com.xjsd.ai.assistant.nlu.bean.NluResponse r7 = (com.xjsd.ai.assistant.nlu.bean.NluResponse) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0083
        L_0x002e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r8)
            com.xjsd.ai.assistant.protocol.VuiModel r8 = com.xjsd.ai.assistant.phone.helper.NluDataParser.a(r7)
            com.xjsd.ai.assistant.protocol.vui.Header r2 = r8.getHeader()
            java.lang.String r2 = r2.getName()
            java.lang.String r4 = "getName(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            com.xjsd.ai.assistant.protocol.vui.Utterance r4 = r8.getUtterance()
            java.lang.String r4 = r4.getId()
            java.lang.String r5 = "getId(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            com.alibaba.fastjson.JSONObject r8 = r8.getPayload()
            java.lang.String r5 = "getPayload(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r5)
            com.xjsd.ai.assistant.core.api.music.MediaModel r8 = com.xjsd.ai.assistant.phone.media.MediaHelper.b(r2, r4, r8)
            java.lang.String r2 = r8.getCmdType()
            if (r2 == 0) goto L_0x0078
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0071
            goto L_0x0078
        L_0x0071:
            com.xjsd.ai.assistant.phone.media.MediaHelper.e(r8, r3)
            r6.a(r7)
            goto L_0x0083
        L_0x0078:
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r6 = r6.j(r7, r0)
            if (r6 != r1) goto L_0x0083
            return r1
        L_0x0083:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.flutter.nlp.MediaNlpPreprocessor.i(com.xjsd.ai.assistant.nlu.bean.NluResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object j(NluResponse nluResponse, Continuation continuation) {
        return NlpPreprocessor.DefaultImpls.f(this, nluResponse, continuation);
    }
}
