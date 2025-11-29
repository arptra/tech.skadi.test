package com.xjsd.ai.assistant.flutter.nlp;

import com.alibaba.fastjson.JSONObject;
import com.xjsd.ai.assistant.common.Communicator;
import com.xjsd.ai.assistant.core.ContextHelper;
import com.xjsd.ai.assistant.core.util.DeviceUtils;
import com.xjsd.ai.assistant.flutter.NlpCompact;
import com.xjsd.ai.assistant.nlu.bean.NluResponse;
import com.xjsd.ai.assistant.phone.R;
import com.xjsd.ai.assistant.phone.helper.NluDataParser;
import com.xjsd.ai.assistant.protocol.VuiModel;
import com.xjsd.ai.assistant.template.TtsGlobalTemplate;
import com.xjsd.ai.assistant.template.TtsTemplate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\bf\u0018\u00002\u00020\u0001:\u0001\"J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H¦@¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H@¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b!\u0010\f¨\u0006#"}, d2 = {"Lcom/xjsd/ai/assistant/flutter/nlp/NlpPreprocessor;", "", "", "b", "()Ljava/lang/String;", "Lcom/xjsd/ai/assistant/nlu/bean/NluResponse;", "nluResponse", "i", "(Lcom/xjsd/ai/assistant/nlu/bean/NluResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "c", "", "g", "(Lcom/xjsd/ai/assistant/nlu/bean/NluResponse;)Z", "", "a", "(Lcom/xjsd/ai/assistant/nlu/bean/NluResponse;)V", "", "stringRes", "d", "(Lcom/xjsd/ai/assistant/nlu/bean/NluResponse;I)V", "Lcom/xjsd/ai/assistant/template/TtsTemplate;", "template", "e", "(Lcom/xjsd/ai/assistant/nlu/bean/NluResponse;Lcom/xjsd/ai/assistant/template/TtsTemplate;)V", "text", "h", "(Lcom/xjsd/ai/assistant/nlu/bean/NluResponse;Ljava/lang/String;)V", "clean", "()V", "lastDomain", "currentDomain", "f", "(Ljava/lang/String;Ljava/lang/String;)V", "interrupt", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public interface NlpPreprocessor {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/xjsd/ai/assistant/flutter/nlp/NlpPreprocessor$Companion;", "", "<init>", "()V", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f8488a = new Companion();
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void a(NlpPreprocessor nlpPreprocessor) {
        }

        public static boolean b(NlpPreprocessor nlpPreprocessor, NluResponse nluResponse) {
            if (DeviceUtils.g()) {
                return false;
            }
            String b = DeviceUtils.f() ? ContextHelper.b(R.string.tts_connect_glass, new Object[0]) : ContextHelper.b(R.string.tts_bind_glass, new Object[0]);
            JSONObject jSONObject = nluResponse.getPayload().getJSONObject("utterance");
            Intrinsics.checkNotNullExpressionValue(jSONObject, "getJSONObject(...)");
            jSONObject.put("screen", b);
            NlpCompact.a();
            return true;
        }

        public static boolean c(NlpPreprocessor nlpPreprocessor, NluResponse nluResponse) {
            Intrinsics.checkNotNullParameter(nluResponse, "nluResponse");
            return true;
        }

        public static void d(NlpPreprocessor nlpPreprocessor, String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "lastDomain");
            Intrinsics.checkNotNullParameter(str2, "currentDomain");
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: com.xjsd.ai.assistant.nlu.bean.NluResponse} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0072  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static java.lang.Object e(com.xjsd.ai.assistant.flutter.nlp.NlpPreprocessor r4, com.xjsd.ai.assistant.nlu.bean.NluResponse r5, kotlin.coroutines.Continuation r6) {
            /*
                boolean r0 = r6 instanceof com.xjsd.ai.assistant.flutter.nlp.NlpPreprocessor$preProcess$1
                if (r0 == 0) goto L_0x0013
                r0 = r6
                com.xjsd.ai.assistant.flutter.nlp.NlpPreprocessor$preProcess$1 r0 = (com.xjsd.ai.assistant.flutter.nlp.NlpPreprocessor$preProcess$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.label = r1
                goto L_0x0018
            L_0x0013:
                com.xjsd.ai.assistant.flutter.nlp.NlpPreprocessor$preProcess$1 r0 = new com.xjsd.ai.assistant.flutter.nlp.NlpPreprocessor$preProcess$1
                r0.<init>(r6)
            L_0x0018:
                java.lang.Object r6 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L_0x003c
                if (r2 != r3) goto L_0x0034
                java.lang.Object r4 = r0.L$1
                r5 = r4
                com.xjsd.ai.assistant.nlu.bean.NluResponse r5 = (com.xjsd.ai.assistant.nlu.bean.NluResponse) r5
                java.lang.Object r4 = r0.L$0
                com.xjsd.ai.assistant.flutter.nlp.NlpPreprocessor r4 = (com.xjsd.ai.assistant.flutter.nlp.NlpPreprocessor) r4
                kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x0032 }
                goto L_0x005b
            L_0x0032:
                r6 = move-exception
                goto L_0x0062
            L_0x0034:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L_0x003c:
                kotlin.ResultKt.throwOnFailure(r6)
                boolean r6 = r4.g(r5)
                if (r6 == 0) goto L_0x004c
                boolean r6 = b(r4, r5)
                if (r6 == 0) goto L_0x004c
                return r5
            L_0x004c:
                kotlin.Result$Companion r6 = kotlin.Result.Companion     // Catch:{ all -> 0x0032 }
                r0.L$0 = r4     // Catch:{ all -> 0x0032 }
                r0.L$1 = r5     // Catch:{ all -> 0x0032 }
                r0.label = r3     // Catch:{ all -> 0x0032 }
                java.lang.Object r6 = r4.i(r5, r0)     // Catch:{ all -> 0x0032 }
                if (r6 != r1) goto L_0x005b
                return r1
            L_0x005b:
                com.xjsd.ai.assistant.nlu.bean.NluResponse r6 = (com.xjsd.ai.assistant.nlu.bean.NluResponse) r6     // Catch:{ all -> 0x0032 }
                java.lang.Object r6 = kotlin.Result.m20constructorimpl(r6)     // Catch:{ all -> 0x0032 }
                goto L_0x006c
            L_0x0062:
                kotlin.Result$Companion r0 = kotlin.Result.Companion
                java.lang.Object r6 = kotlin.ResultKt.createFailure(r6)
                java.lang.Object r6 = kotlin.Result.m20constructorimpl(r6)
            L_0x006c:
                java.lang.Throwable r6 = kotlin.Result.m23exceptionOrNullimpl(r6)
                if (r6 == 0) goto L_0x0081
                java.lang.String r0 = "NlpPreprocessor"
                java.lang.String r1 = "preProcess: 异常了"
                com.xjsd.ai.assistant.log.ILog.h(r0, r1, r6)
                com.xjsd.ai.assistant.flutter.NlpCompact.a()
                int r6 = com.xjsd.ai.assistant.phone.R.string.tts_generic_error_tip
                r4.d(r5, r6)
            L_0x0081:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.flutter.nlp.NlpPreprocessor.DefaultImpls.e(com.xjsd.ai.assistant.flutter.nlp.NlpPreprocessor, com.xjsd.ai.assistant.nlu.bean.NluResponse, kotlin.coroutines.Continuation):java.lang.Object");
        }

        public static Object f(NlpPreprocessor nlpPreprocessor, NluResponse nluResponse, Continuation continuation) {
            VuiModel a2 = NluDataParser.a(nluResponse);
            a2.setSource(1);
            Communicator.b(102, a2, new NlpPreprocessor$sendToGlassExecute$2());
            new PendingNlpProcessor().k(nluResponse);
            return Unit.INSTANCE;
        }

        public static void g(NlpPreprocessor nlpPreprocessor, NluResponse nluResponse) {
            Intrinsics.checkNotNullParameter(nluResponse, "nluResponse");
            nlpPreprocessor.a(nluResponse);
            nluResponse.getHeader().setName("Handled");
        }

        public static void h(NlpPreprocessor nlpPreprocessor, NluResponse nluResponse) {
            Intrinsics.checkNotNullParameter(nluResponse, "nluResponse");
            nlpPreprocessor.e(nluResponse, TtsGlobalTemplate.GLOBAL03_P06);
        }

        public static void i(NlpPreprocessor nlpPreprocessor, NluResponse nluResponse) {
            Intrinsics.checkNotNullParameter(nluResponse, "nluResponse");
            nlpPreprocessor.e(nluResponse, TtsGlobalTemplate.GLOBAL03_P02);
        }

        public static void j(NlpPreprocessor nlpPreprocessor, NluResponse nluResponse, int i) {
            Intrinsics.checkNotNullParameter(nluResponse, "nluResponse");
            String b = ContextHelper.b(i, new Object[0]);
            Intrinsics.checkNotNullExpressionValue(b, "getString(...)");
            nlpPreprocessor.h(nluResponse, b);
        }

        public static void k(NlpPreprocessor nlpPreprocessor, NluResponse nluResponse, TtsTemplate ttsTemplate) {
            Intrinsics.checkNotNullParameter(nluResponse, "nluResponse");
            Intrinsics.checkNotNullParameter(ttsTemplate, "template");
            String tts = ttsTemplate.getTts(new Object[0]);
            Intrinsics.checkNotNullExpressionValue(tts, "getTts(...)");
            nlpPreprocessor.h(nluResponse, tts);
        }

        public static void l(NlpPreprocessor nlpPreprocessor, NluResponse nluResponse, String str) {
            Intrinsics.checkNotNullParameter(nluResponse, "nluResponse");
            Intrinsics.checkNotNullParameter(str, "text");
            if (StringsKt.contains$default((CharSequence) str, (CharSequence) "MY VIEW", false, 2, (Object) null)) {
                str = StringsKt.replace$default(str, "MY VIEW", "MYVU", false, 4, (Object) null);
            }
            JSONObject jSONObject = nluResponse.getPayload().getJSONObject("utterance");
            Intrinsics.checkNotNullExpressionValue(jSONObject, "getJSONObject(...)");
            jSONObject.put("screen", str);
        }
    }

    void a(NluResponse nluResponse);

    String b();

    Object c(NluResponse nluResponse, Continuation continuation);

    void clean();

    void d(NluResponse nluResponse, int i);

    void e(NluResponse nluResponse, TtsTemplate ttsTemplate);

    void f(String str, String str2);

    boolean g(NluResponse nluResponse);

    void h(NluResponse nluResponse, String str);

    Object i(NluResponse nluResponse, Continuation continuation);
}
