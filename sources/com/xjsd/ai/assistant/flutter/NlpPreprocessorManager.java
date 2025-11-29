package com.xjsd.ai.assistant.flutter;

import com.xjsd.ai.assistant.flutter.nlp.NlpPreprocessor;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u0003J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH@¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J(\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000fH@¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001b\u0010\u001cR0\u0010 \u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00040\u001dj\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0004`\u001e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001fR$\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u000f0!j\b\u0012\u0004\u0012\u00020\u000f`\"8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010#R\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010%¨\u0006&"}, d2 = {"Lcom/xjsd/ai/assistant/flutter/NlpPreprocessorManager;", "", "<init>", "()V", "Lcom/xjsd/ai/assistant/flutter/nlp/NlpPreprocessor;", "preprocessor", "", "b", "(Lcom/xjsd/ai/assistant/flutter/nlp/NlpPreprocessor;)V", "e", "Lcom/xjsd/ai/assistant/net/ws/protocol/EndToEndResponse;", "response", "Lcom/xjsd/ai/assistant/flutter/AndroidAssistantApi$CloudResponse;", "g", "(Lcom/xjsd/ai/assistant/net/ws/protocol/EndToEndResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "lastDomain", "currentDomain", "f", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/xjsd/ai/assistant/nlu/bean/NluResponse;", "nluResponse", "vuiType", "c", "(Lcom/xjsd/ai/assistant/net/ws/protocol/EndToEndResponse;Lcom/xjsd/ai/assistant/nlu/bean/NluResponse;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "compareDomain", "", "d", "(Ljava/lang/String;)Z", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "preprocessorMap", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "mGenericSupportNlu", "Ljava/lang/String;", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class NlpPreprocessorManager {

    /* renamed from: a  reason: collision with root package name */
    public static final NlpPreprocessorManager f8482a = new NlpPreprocessorManager();
    public static final HashMap b = new HashMap();
    public static final HashSet c = SetsKt.hashSetOf("llm", "error", VuiModelType.FREE_CHAT, VuiModelType.WEATHER);
    public static String d = "";

    public final void b(NlpPreprocessor nlpPreprocessor) {
        Intrinsics.checkNotNullParameter(nlpPreprocessor, "preprocessor");
        b.put(nlpPreprocessor.b(), nlpPreprocessor);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object c(com.xjsd.ai.assistant.net.ws.protocol.EndToEndResponse r5, com.xjsd.ai.assistant.nlu.bean.NluResponse r6, java.lang.String r7, kotlin.coroutines.Continuation r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.xjsd.ai.assistant.flutter.NlpPreprocessorManager$dispatchToNluProcessor$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.xjsd.ai.assistant.flutter.NlpPreprocessorManager$dispatchToNluProcessor$1 r0 = (com.xjsd.ai.assistant.flutter.NlpPreprocessorManager$dispatchToNluProcessor$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.xjsd.ai.assistant.flutter.NlpPreprocessorManager$dispatchToNluProcessor$1 r0 = new com.xjsd.ai.assistant.flutter.NlpPreprocessorManager$dispatchToNluProcessor$1
            r0.<init>(r4, r8)
        L_0x0018:
            java.lang.Object r4 = r0.result
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L_0x0035
            if (r1 != r2) goto L_0x002d
            java.lang.Object r5 = r0.L$0
            com.xjsd.ai.assistant.net.ws.protocol.EndToEndResponse r5 = (com.xjsd.ai.assistant.net.ws.protocol.EndToEndResponse) r5
            kotlin.ResultKt.throwOnFailure(r4)
            goto L_0x0068
        L_0x002d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r4)
            java.util.HashMap r4 = b
            java.lang.Object r4 = r4.get(r7)
            com.xjsd.ai.assistant.flutter.nlp.NlpPreprocessor r4 = (com.xjsd.ai.assistant.flutter.nlp.NlpPreprocessor) r4
            if (r4 == 0) goto L_0x006c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "process: "
            r1.append(r3)
            r1.append(r7)
            java.lang.String r7 = "--预处理器处理nlp数据"
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            java.lang.String r1 = "NlpPreprocessorManager"
            com.xjsd.ai.assistant.log.ILog.a(r1, r7)
            r0.L$0 = r5
            r0.label = r2
            java.lang.Object r4 = r4.c(r6, r0)
            if (r4 != r8) goto L_0x0068
            return r8
        L_0x0068:
            r5.setPayload(r4)
            goto L_0x007c
        L_0x006c:
            com.xjsd.ai.assistant.nlu.bean.HeaderData r4 = r6.getHeader()
            java.lang.String r7 = "unsupported"
            r4.setNamespace(r7)
            r5.setPayload(r6)
            com.xjsd.ai.assistant.flutter.NlpCompact.a()
        L_0x007c:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.flutter.NlpPreprocessorManager.c(com.xjsd.ai.assistant.net.ws.protocol.EndToEndResponse, com.xjsd.ai.assistant.nlu.bean.NluResponse, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean d(String str) {
        if (d.length() == 0) {
            return false;
        }
        return !Intrinsics.areEqual((Object) d, (Object) str);
    }

    public final void e() {
        d = "";
        for (NlpPreprocessor clean : b.values()) {
            clean.clean();
        }
    }

    public final void f(String str, String str2) {
        for (NlpPreprocessor f : b.values()) {
            f.f(str, str2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object g(com.xjsd.ai.assistant.net.ws.protocol.EndToEndResponse r8, kotlin.coroutines.Continuation r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.xjsd.ai.assistant.flutter.NlpPreprocessorManager$process$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.xjsd.ai.assistant.flutter.NlpPreprocessorManager$process$1 r0 = (com.xjsd.ai.assistant.flutter.NlpPreprocessorManager$process$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.xjsd.ai.assistant.flutter.NlpPreprocessorManager$process$1 r0 = new com.xjsd.ai.assistant.flutter.NlpPreprocessorManager$process$1
            r0.<init>(r7, r9)
        L_0x0018:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            boolean r7 = r0.Z$0
            java.lang.Object r8 = r0.L$1
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r0 = r0.L$0
            com.xjsd.ai.assistant.net.ws.protocol.EndToEndResponse r0 = (com.xjsd.ai.assistant.net.ws.protocol.EndToEndResponse) r0
            kotlin.ResultKt.throwOnFailure(r9)
            r9 = r8
            r8 = r0
            goto L_0x00c2
        L_0x0036:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.String r9 = r8.getType()
            java.lang.String r2 = "nlp_result"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x00c3
            java.lang.Class<com.xjsd.ai.assistant.nlu.bean.NluResponse> r4 = com.xjsd.ai.assistant.nlu.bean.NluResponse.class
            java.lang.Object r4 = r8.parsePayload(r4)
            com.xjsd.ai.assistant.nlu.bean.NluResponse r4 = (com.xjsd.ai.assistant.nlu.bean.NluResponse) r4
            com.xjsd.ai.assistant.nlu.bean.HeaderData r5 = r4.getHeader()
            java.lang.String r5 = r5.getNamespace()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            boolean r6 = r7.d(r5)
            if (r6 == 0) goto L_0x006b
            java.lang.String r6 = d
            r7.f(r6, r5)
        L_0x006b:
            d = r5
            java.util.HashSet r6 = c
            boolean r6 = r6.contains(r5)
            if (r6 != 0) goto L_0x00af
            boolean r6 = com.xjsd.ai.assistant.core.util.DeviceUtils.g()
            if (r6 == 0) goto L_0x00af
            boolean r6 = com.xjsd.ai.assistant.phone.NewFunctionCompact.a()
            if (r6 == 0) goto L_0x0082
            goto L_0x00af
        L_0x0082:
            java.lang.String r7 = "navigation"
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r7)
            if (r7 == 0) goto L_0x009e
            com.xjsd.ai.assistant.nlu.bean.HeaderData r7 = r4.getHeader()
            java.lang.String r7 = r7.getName()
            java.lang.String r0 = "TrafficRestrictionSearch"
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r0)
            if (r7 == 0) goto L_0x009e
            r8.setPayload(r4)
            goto L_0x00c3
        L_0x009e:
            com.xjsd.ai.assistant.nlu.bean.HeaderData r7 = r4.getHeader()
            java.lang.String r0 = "unsupported"
            r7.setNamespace(r0)
            r8.setPayload(r4)
            com.xjsd.ai.assistant.flutter.NlpCompact.a()
            goto L_0x00c3
        L_0x00af:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            r0.L$0 = r8
            r0.L$1 = r9
            r0.Z$0 = r2
            r0.label = r3
            java.lang.Object r7 = r7.c(r8, r4, r5, r0)
            if (r7 != r1) goto L_0x00c1
            return r1
        L_0x00c1:
            r7 = r2
        L_0x00c2:
            r2 = r7
        L_0x00c3:
            java.lang.Object r7 = r8.getPayload()
            java.lang.String r7 = com.xjsd.ai.assistant.json.GsonUtils.e(r7)
            if (r2 == 0) goto L_0x00e3
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "process: 处理后垂域数据->"
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "NlpPreprocessorManager"
            com.xjsd.ai.assistant.log.ILog.a(r1, r0)
        L_0x00e3:
            com.xjsd.ai.assistant.flutter.AndroidAssistantApi$CloudResponse$Builder r0 = new com.xjsd.ai.assistant.flutter.AndroidAssistantApi$CloudResponse$Builder
            r0.<init>()
            java.lang.String r8 = r8.getRequestId()
            com.xjsd.ai.assistant.flutter.AndroidAssistantApi$CloudResponse$Builder r8 = r0.c(r8)
            com.xjsd.ai.assistant.flutter.AndroidAssistantApi$CloudResponse$Builder r8 = r8.d(r9)
            com.xjsd.ai.assistant.flutter.AndroidAssistantApi$CloudResponse$Builder r7 = r8.b(r7)
            com.xjsd.ai.assistant.flutter.AndroidAssistantApi$CloudResponse r7 = r7.a()
            java.lang.String r8 = "build(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.flutter.NlpPreprocessorManager.g(com.xjsd.ai.assistant.net.ws.protocol.EndToEndResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
