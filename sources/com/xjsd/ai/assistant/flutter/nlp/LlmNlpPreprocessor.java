package com.xjsd.ai.assistant.flutter.nlp;

import com.xjsd.ai.assistant.flutter.nlp.NlpPreprocessor;
import com.xjsd.ai.assistant.nlu.bean.NluResponse;
import com.xjsd.ai.assistant.template.TtsTemplate;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H@¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/xjsd/ai/assistant/flutter/nlp/LlmNlpPreprocessor;", "Lcom/xjsd/ai/assistant/flutter/nlp/NlpPreprocessor;", "<init>", "()V", "", "b", "()Ljava/lang/String;", "Lcom/xjsd/ai/assistant/nlu/bean/NluResponse;", "nluResponse", "i", "(Lcom/xjsd/ai/assistant/nlu/bean/NluResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "g", "(Lcom/xjsd/ai/assistant/nlu/bean/NluResponse;)Z", "a", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class LlmNlpPreprocessor implements NlpPreprocessor {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f8486a = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjsd/ai/assistant/flutter/nlp/LlmNlpPreprocessor$Companion;", "", "()V", "TAG", "", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public void a(NluResponse nluResponse) {
        NlpPreprocessor.DefaultImpls.i(this, nluResponse);
    }

    public String b() {
        return "llm";
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
        Intrinsics.checkNotNullParameter(nluResponse, "nluResponse");
        return false;
    }

    public void h(NluResponse nluResponse, String str) {
        NlpPreprocessor.DefaultImpls.l(this, nluResponse, str);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: com.xjsd.ai.assistant.nlu.bean.NluResponse} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object i(com.xjsd.ai.assistant.nlu.bean.NluResponse r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.xjsd.ai.assistant.flutter.nlp.LlmNlpPreprocessor$process$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.xjsd.ai.assistant.flutter.nlp.LlmNlpPreprocessor$process$1 r0 = (com.xjsd.ai.assistant.flutter.nlp.LlmNlpPreprocessor$process$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.xjsd.ai.assistant.flutter.nlp.LlmNlpPreprocessor$process$1 r0 = new com.xjsd.ai.assistant.flutter.nlp.LlmNlpPreprocessor$process$1
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
            com.xjsd.ai.assistant.nlu.bean.NluResponse r5 = (com.xjsd.ai.assistant.nlu.bean.NluResponse) r5
            java.lang.Object r4 = r0.L$0
            com.xjsd.ai.assistant.flutter.nlp.LlmNlpPreprocessor r4 = (com.xjsd.ai.assistant.flutter.nlp.LlmNlpPreprocessor) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004a
        L_0x0032:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = com.xjsd.ai.assistant.phone.helper.AssistantProtocolHelper.e(r0)
            if (r6 != r1) goto L_0x004a
            return r1
        L_0x004a:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            java.lang.String r0 = "llm_not_auth"
            if (r6 != 0) goto L_0x005d
            com.xjsd.ai.assistant.nlu.bean.HeaderData r6 = r5.getHeader()
            r6.setNamespace(r0)
            int r6 = com.xjsd.ai.assistant.phone.R.string.tts_generic_error_tip
            r4.d(r5, r6)
            goto L_0x0091
        L_0x005d:
            boolean r6 = r6.booleanValue()
            if (r6 != 0) goto L_0x0091
            com.xjsd.ai.assistant.nlu.bean.HeaderData r6 = r5.getHeader()
            r6.setNamespace(r0)
            com.xjsd.ai.assistant.template.TtsGlobalTemplate r6 = com.xjsd.ai.assistant.template.TtsGlobalTemplate.GLOBAL01_P24
            r4.e(r5, r6)
            com.xjsd.ai.assistant.core.AbilityManager r4 = com.xjsd.ai.assistant.core.AbilityManager.b
            java.lang.Class<com.xjsd.ai.assistant.connect.InterconnectAbility> r6 = com.xjsd.ai.assistant.connect.InterconnectAbility.class
            com.xjsd.ai.assistant.core.Ability r4 = r4.b(r6)
            com.xjsd.ai.assistant.connect.InterconnectAbility r4 = (com.xjsd.ai.assistant.connect.InterconnectAbility) r4
            if (r4 == 0) goto L_0x0091
            com.upuphone.xr.interconnect.api.OperatorManager r4 = r4.getOperatorManager()
            if (r4 == 0) goto L_0x0091
            com.upuphone.xr.interconnect.api.SappAbilityOperator r4 = r4.getSappAbilityOperator()
            if (r4 == 0) goto L_0x0091
            java.lang.String r6 = "permission_ai_model"
            java.util.List r6 = kotlin.collections.CollectionsKt.listOf(r6)
            r0 = 0
            r4.requestPermission(r6, r0)
        L_0x0091:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.flutter.nlp.LlmNlpPreprocessor.i(com.xjsd.ai.assistant.nlu.bean.NluResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
