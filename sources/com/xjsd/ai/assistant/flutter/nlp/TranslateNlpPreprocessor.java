package com.xjsd.ai.assistant.flutter.nlp;

import com.xjsd.ai.assistant.core.util.DeviceUtils;
import com.xjsd.ai.assistant.flutter.nlp.NlpPreprocessor;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.nlu.bean.NluResponse;
import com.xjsd.ai.assistant.phone.vui.translate.TranslateManager;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import com.xjsd.ai.assistant.template.TtsGlobalTemplate;
import com.xjsd.ai.assistant.template.TtsTemplate;
import com.xjsd.ai.assistant.template.TtsTranslateTemplate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H@¢\u0006\u0004\b\t\u0010\nJ/\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00118\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R$\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0015j\b\u0012\u0004\u0012\u00020\u0004`\u00168\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0017R$\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0015j\b\u0012\u0004\u0012\u00020\u0004`\u00168\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/xjsd/ai/assistant/flutter/nlp/TranslateNlpPreprocessor;", "Lcom/xjsd/ai/assistant/flutter/nlp/NlpPreprocessor;", "<init>", "()V", "", "b", "()Ljava/lang/String;", "Lcom/xjsd/ai/assistant/nlu/bean/NluResponse;", "nluResponse", "i", "(Lcom/xjsd/ai/assistant/nlu/bean/NluResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "type", "langSrc", "langDst", "", "k", "(Lcom/xjsd/ai/assistant/nlu/bean/NluResponse;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "a", "Ljava/util/List;", "defList", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "mSupportDirective", "c", "mSupportType", "d", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nTranslateNlpPreprocessor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TranslateNlpPreprocessor.kt\ncom/xjsd/ai/assistant/flutter/nlp/TranslateNlpPreprocessor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,164:1\n731#2,9:165\n37#3,2:174\n*S KotlinDebug\n*F\n+ 1 TranslateNlpPreprocessor.kt\ncom/xjsd/ai/assistant/flutter/nlp/TranslateNlpPreprocessor\n*L\n85#1:165,9\n86#1:174,2\n*E\n"})
public final class TranslateNlpPreprocessor implements NlpPreprocessor {
    public static final Companion d = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final List f8492a;
    public final HashSet b;
    public final HashSet c;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/xjsd/ai/assistant/flutter/nlp/TranslateNlpPreprocessor$Companion;", "", "()V", "TAG", "", "TRANSLATION_PAUSE", "TRANSLATION_RESUME", "TRANSLATION_SPECIFY_MODE_START", "TRANSLATION_START", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public TranslateNlpPreprocessor() {
        ArrayList arrayList = new ArrayList();
        this.f8492a = arrayList;
        HashSet hashSet = new HashSet();
        this.b = hashSet;
        HashSet hashSet2 = new HashSet();
        this.c = hashSet2;
        hashSet.add("Translation_Specify_Mode_Start");
        hashSet.add("Translation_Start");
        hashSet.add("Translation_Resume");
        hashSet.add("Translation_Pause");
        hashSet2.add("dt");
        hashSet2.add("pt");
        arrayList.add("default");
        arrayList.add("$session.params.TranslationType");
        arrayList.add("$session.params.language");
        arrayList.add("null");
        arrayList.add("");
    }

    public void a(NluResponse nluResponse) {
        NlpPreprocessor.DefaultImpls.i(this, nluResponse);
    }

    public String b() {
        return VuiModelType.TRANSLATION;
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

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x007c, code lost:
        if (r1.equals("Translation_Resume") == false) goto L_0x016f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0112, code lost:
        if (r1.equals("Translation_Start") == false) goto L_0x016f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0115, code lost:
        r7 = r7.getString("language");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x011d, code lost:
        if (android.text.TextUtils.isEmpty(r7) != false) goto L_0x0132;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0125, code lost:
        if (r5.f8492a.contains(r7) == false) goto L_0x0128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0128, code lost:
        kotlin.jvm.internal.Intrinsics.checkNotNull(r0);
        kotlin.jvm.internal.Intrinsics.checkNotNull(r7);
        k(r6, r0, r7, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0136, code lost:
        if (com.xjsd.ai.assistant.phone.vui.translate.TranslateManager.e(r0) == false) goto L_0x013c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0138, code lost:
        a(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x013c, code lost:
        com.xjsd.ai.assistant.phone.vui.translate.TranslateManager.g(r0);
        e(r6, com.xjsd.ai.assistant.template.TtsGlobalTemplate.GLOBAL06_P01);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object i(com.xjsd.ai.assistant.nlu.bean.NluResponse r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            com.xjsd.ai.assistant.protocol.VuiModel r7 = com.xjsd.ai.assistant.phone.helper.NluDataParser.a(r6)
            com.xjsd.ai.assistant.protocol.vui.Header r0 = r7.getHeader()
            com.alibaba.fastjson.JSONObject r7 = r7.getPayload()
            java.lang.String r1 = "getPayload(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r1)
            java.lang.String r0 = r0.getName()
            java.lang.String r1 = "directive"
            java.lang.String r1 = r7.getString(r1)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "name->"
            r2.append(r3)
            r2.append(r0)
            java.lang.String r3 = ", directive->"
            r2.append(r3)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "TranslatePreProcessor"
            com.xjsd.ai.assistant.log.ILog.a(r3, r2)
            java.lang.String r2 = "TranslationDirective"
            r3 = 1
            boolean r0 = kotlin.text.StringsKt.equals(r2, r0, r3)
            if (r0 == 0) goto L_0x0176
            java.util.HashSet r0 = r5.b
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x0176
            java.lang.String r0 = "type"
            java.lang.String r0 = r7.getString(r0)
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x005f
            java.util.List r2 = r5.f8492a
            boolean r2 = r2.contains(r0)
            if (r2 == 0) goto L_0x0061
        L_0x005f:
            java.lang.String r0 = "dt"
        L_0x0061:
            java.util.HashSet r2 = r5.c
            boolean r2 = r2.contains(r0)
            if (r2 == 0) goto L_0x0173
            if (r1 == 0) goto L_0x016f
            int r2 = r1.hashCode()
            java.lang.String r4 = "language"
            switch(r2) {
                case -1070513496: goto L_0x0145;
                case -1067196140: goto L_0x010c;
                case -524355342: goto L_0x0080;
                case 1234715067: goto L_0x0076;
                default: goto L_0x0074;
            }
        L_0x0074:
            goto L_0x016f
        L_0x0076:
            java.lang.String r2 = "Translation_Resume"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0115
            goto L_0x016f
        L_0x0080:
            java.lang.String r2 = "Translation_Specify_Mode_Start"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x016f
            boolean r1 = com.xjsd.ai.assistant.phone.vui.translate.TranslateManager.f(r0)
            java.lang.String r7 = r7.getString(r4)
            if (r1 == 0) goto L_0x0101
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            java.util.Locale r1 = java.util.Locale.getDefault()
            java.lang.String r2 = "getDefault(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.String r7 = r7.toLowerCase(r1)
            java.lang.String r1 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r1)
            kotlin.text.Regex r1 = new kotlin.text.Regex
            java.lang.String r2 = "to"
            r1.<init>((java.lang.String) r2)
            r2 = 0
            java.util.List r7 = r1.split(r7, r2)
            boolean r1 = r7.isEmpty()
            if (r1 != 0) goto L_0x00e0
            int r1 = r7.size()
            java.util.ListIterator r1 = r7.listIterator(r1)
        L_0x00c3:
            boolean r4 = r1.hasPrevious()
            if (r4 == 0) goto L_0x00e0
            java.lang.Object r4 = r1.previous()
            java.lang.String r4 = (java.lang.String) r4
            int r4 = r4.length()
            if (r4 != 0) goto L_0x00d6
            goto L_0x00c3
        L_0x00d6:
            int r1 = r1.nextIndex()
            int r1 = r1 + r3
            java.util.List r7 = kotlin.collections.CollectionsKt.take(r7, r1)
            goto L_0x00e4
        L_0x00e0:
            java.util.List r7 = kotlin.collections.CollectionsKt.emptyList()
        L_0x00e4:
            java.lang.String[] r1 = new java.lang.String[r2]
            java.lang.Object[] r7 = r7.toArray(r1)
            java.lang.String[] r7 = (java.lang.String[]) r7
            int r1 = r7.length
            r4 = 2
            if (r1 >= r4) goto L_0x00f5
            r5.j(r6)
            goto L_0x0176
        L_0x00f5:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r1 = r7[r2]
            r7 = r7[r3]
            r5.k(r6, r0, r1, r7)
            goto L_0x0176
        L_0x0101:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            r5.k(r6, r0, r7, r7)
            goto L_0x0176
        L_0x010c:
            java.lang.String r2 = "Translation_Start"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0115
            goto L_0x016f
        L_0x0115:
            java.lang.String r7 = r7.getString(r4)
            boolean r1 = android.text.TextUtils.isEmpty(r7)
            if (r1 != 0) goto L_0x0132
            java.util.List r1 = r5.f8492a
            boolean r1 = r1.contains(r7)
            if (r1 == 0) goto L_0x0128
            goto L_0x0132
        L_0x0128:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            r5.k(r6, r0, r7, r7)
            goto L_0x0176
        L_0x0132:
            boolean r7 = com.xjsd.ai.assistant.phone.vui.translate.TranslateManager.e(r0)
            if (r7 == 0) goto L_0x013c
            r5.a(r6)
            goto L_0x0176
        L_0x013c:
            com.xjsd.ai.assistant.phone.vui.translate.TranslateManager.g(r0)
            com.xjsd.ai.assistant.template.TtsGlobalTemplate r7 = com.xjsd.ai.assistant.template.TtsGlobalTemplate.GLOBAL06_P01
            r5.e(r6, r7)
            goto L_0x0176
        L_0x0145:
            java.lang.String r7 = "Translation_Pause"
            boolean r7 = r1.equals(r7)
            if (r7 != 0) goto L_0x014e
            goto L_0x016f
        L_0x014e:
            boolean r7 = com.xjsd.ai.assistant.phone.vui.translate.TranslateManager.e(r0)
            if (r7 == 0) goto L_0x015d
            com.xjsd.ai.assistant.phone.vui.translate.TranslateManager.h(r0)
            com.xjsd.ai.assistant.template.TtsTranslateTemplate r7 = com.xjsd.ai.assistant.template.TtsTranslateTemplate.TRANS06_R01
            r5.e(r6, r7)
            goto L_0x0176
        L_0x015d:
            boolean r7 = com.xjsd.ai.assistant.phone.vui.translate.TranslateManager.f(r0)
            if (r7 == 0) goto L_0x0169
            com.xjsd.ai.assistant.template.TtsTranslateTemplate r7 = com.xjsd.ai.assistant.template.TtsTranslateTemplate.TRANS06_R02
            r5.e(r6, r7)
            goto L_0x0176
        L_0x0169:
            com.xjsd.ai.assistant.template.TtsTranslateTemplate r7 = com.xjsd.ai.assistant.template.TtsTranslateTemplate.TRANS06_R03
            r5.e(r6, r7)
            goto L_0x0176
        L_0x016f:
            r5.j(r6)
            goto L_0x0176
        L_0x0173:
            r5.j(r6)
        L_0x0176:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.flutter.nlp.TranslateNlpPreprocessor.i(com.xjsd.ai.assistant.nlu.bean.NluResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void j(NluResponse nluResponse) {
        NlpPreprocessor.DefaultImpls.h(this, nluResponse);
    }

    public final void k(NluResponse nluResponse, String str, String str2, String str3) {
        if (TranslateManager.d(DeviceUtils.d(), str, str2, str3)) {
            TranslateManager.i(str, str2, str3);
            e(nluResponse, TtsGlobalTemplate.GLOBAL06_P01);
            return;
        }
        int i = TranslateManager.i(str, str2, str3);
        ILog.a("TranslatePreProcessor", "set Transfer Translate result->" + i);
        if (i == -6 || i == -5) {
            e(nluResponse, TtsTranslateTemplate.TRANS05_R04);
        } else if (i == -4 || i == -3) {
            e(nluResponse, TtsTranslateTemplate.TRANS05_R01);
        } else if (i == 0 || i == 1) {
            e(nluResponse, TtsGlobalTemplate.GLOBAL06_P01);
        } else {
            j(nluResponse);
        }
    }
}
