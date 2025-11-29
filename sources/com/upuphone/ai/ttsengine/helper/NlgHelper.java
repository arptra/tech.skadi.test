package com.upuphone.ai.ttsengine.helper;

import com.upuphone.ai.NlgService;
import com.upuphone.ai.ttsengine.base.utils.AILOG;
import com.upuphone.ai.ttsengine.base.utils.GsonUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J;\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bJE\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0012\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/upuphone/ai/ttsengine/helper/NlgHelper;", "", "<init>", "()V", "", "nlgId", "functionId", "", "slots", "Lcom/upuphone/ai/ttsengine/helper/NlgHelper$NlgTts;", "a", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lcom/upuphone/ai/ttsengine/helper/NlgHelper$NlgTts;", "defStr", "b", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;", "Lcom/upuphone/ai/ttsengine/base/utils/AILOG;", "kotlin.jvm.PlatformType", "Lcom/upuphone/ai/ttsengine/base/utils/AILOG;", "aiLog", "NlgTts", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class NlgHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final NlgHelper f5568a = new NlgHelper();
    public static final AILOG b = AILOG.a("NlgUtil");

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0004\"\u0004\b\u0007\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\u0004\"\u0004\b\f\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/upuphone/ai/ttsengine/helper/NlgHelper$NlgTts;", "", "", "toString", "()Ljava/lang/String;", "a", "Ljava/lang/String;", "setTts", "(Ljava/lang/String;)V", "tts", "b", "getMode", "setMode", "mode", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class NlgTts {

        /* renamed from: a  reason: collision with root package name */
        public String f5569a;
        public String b;

        public final String a() {
            return this.f5569a;
        }

        public String toString() {
            String str = this.f5569a;
            String str2 = this.b;
            return "NlgTts{tts='" + str + "', mode='" + str2 + "'}";
        }
    }

    public static final NlgTts a(String str, String str2, Map map) {
        Object obj;
        AILOG ailog = b;
        ailog.c("nlg_function_id: " + str2 + ", nlgId: " + str + ", slots: " + map, new Object[0]);
        NlgTts nlgTts = null;
        try {
            Result.Companion companion = Result.Companion;
            ailog.c("getTts, nlgId:" + str + ", functionId:" + str2 + ", slots:" + map, new Object[0]);
            String f = NlgService.c.a().f(str, str2, map, (String) null);
            StringBuilder sb = new StringBuilder();
            sb.append("getTts, nlgTts:");
            sb.append(f);
            ailog.c(sb.toString(), new Object[0]);
            obj = Result.m20constructorimpl(f != null ? (NlgTts) GsonUtils.a(f, NlgTts.class) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m20constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m27isSuccessimpl(obj)) {
            nlgTts = (NlgTts) obj;
        }
        Throwable r5 = Result.m23exceptionOrNullimpl(obj);
        if (r5 != null) {
            b.g("getTts exception: ", r5.getMessage());
        }
        return nlgTts;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r1 = r0.a();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String b(java.lang.String r0, java.lang.String r1, java.util.Map r2, java.lang.String r3) {
        /*
            com.upuphone.ai.ttsengine.helper.NlgHelper$NlgTts r0 = a(r0, r1, r2)
            if (r0 == 0) goto L_0x0016
            java.lang.String r1 = r0.a()
            if (r1 == 0) goto L_0x0016
            int r1 = r1.length()
            if (r1 <= 0) goto L_0x0016
            java.lang.String r3 = r0.a()
        L_0x0016:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ai.ttsengine.helper.NlgHelper.b(java.lang.String, java.lang.String, java.util.Map, java.lang.String):java.lang.String");
    }
}
