package com.xjsd.ai.assistant.flutter.nlp;

import com.xjsd.ai.assistant.flutter.nlp.NlpPreprocessor;
import com.xjsd.ai.assistant.nlu.bean.NluResponse;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import com.xjsd.ai.assistant.template.TtsSettingTemplate;
import com.xjsd.ai.assistant.template.TtsTemplate;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H@¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/xjsd/ai/assistant/flutter/nlp/SettingsNlpPreprocessor;", "Lcom/xjsd/ai/assistant/flutter/nlp/NlpPreprocessor;", "<init>", "()V", "", "b", "()Ljava/lang/String;", "Lcom/xjsd/ai/assistant/nlu/bean/NluResponse;", "nluResponse", "i", "(Lcom/xjsd/ai/assistant/nlu/bean/NluResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "slot", "", "turnOn", "", "k", "(Lcom/xjsd/ai/assistant/nlu/bean/NluResponse;Ljava/lang/String;Z)V", "j", "(Lcom/xjsd/ai/assistant/nlu/bean/NluResponse;)V", "", "a", "Ljava/util/Set;", "mSupportTarget", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class SettingsNlpPreprocessor implements NlpPreprocessor {

    /* renamed from: a  reason: collision with root package name */
    public final Set f8491a;

    public SettingsNlpPreprocessor() {
        HashSet hashSet = new HashSet();
        this.f8491a = hashSet;
        hashSet.add("no_disturb");
        hashSet.add("keep_dialog");
        hashSet.add("delay_listening");
        hashSet.add("wake_up");
        hashSet.add("navi_mute");
    }

    public void a(NluResponse nluResponse) {
        NlpPreprocessor.DefaultImpls.i(this, nluResponse);
    }

    public String b() {
        return VuiModelType.SYSTEM_SETTING;
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
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007e, code lost:
        if (r2.equals("delay_listening") == false) goto L_0x0161;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0086, code lost:
        if (r2.equals("wake_up") == false) goto L_0x0161;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x010f, code lost:
        if (r2.equals("keep_dialog") == false) goto L_0x0161;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0112, code lost:
        r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) "wake_up");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0116, code lost:
        if (r0 == false) goto L_0x011b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0118, code lost:
        r1 = com.xjsd.ai.assistant.phone.R.string.tts_setting_wake_up;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x011b, code lost:
        r1 = com.xjsd.ai.assistant.phone.R.string.tts_setting_delay_listening;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x011d, code lost:
        if (r0 == false) goto L_0x0122;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x011f, code lost:
        r0 = "low_power_wakeup";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0122, code lost:
        r0 = "continuous_dialogue";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0124, code lost:
        r1 = com.xjsd.ai.assistant.core.ContextHelper.b(r1, new java.lang.Object[0]);
        r2 = com.xjsd.ai.assistant.core.ContextHelper.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x012e, code lost:
        if (r8 == false) goto L_0x0149;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0130, code lost:
        r8 = com.xjsd.ai.assistant.phone.helper.AssistantSettingUtils.b;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0139, code lost:
        if (r8.e(r2, r0) == false) goto L_0x0142;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x013b, code lost:
        kotlin.jvm.internal.Intrinsics.checkNotNull(r1);
        k(r7, r1, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0142, code lost:
        r8.c(r2, r0, true);
        j(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0149, code lost:
        r8 = com.xjsd.ai.assistant.phone.helper.AssistantSettingUtils.b;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0152, code lost:
        if (r8.e(r2, r0) == false) goto L_0x015b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0154, code lost:
        r8.c(r2, r0, false);
        j(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x015b, code lost:
        kotlin.jvm.internal.Intrinsics.checkNotNull(r1);
        k(r7, r1, false);
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object i(com.xjsd.ai.assistant.nlu.bean.NluResponse r7, kotlin.coroutines.Continuation r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.xjsd.ai.assistant.flutter.nlp.SettingsNlpPreprocessor$process$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.xjsd.ai.assistant.flutter.nlp.SettingsNlpPreprocessor$process$1 r0 = (com.xjsd.ai.assistant.flutter.nlp.SettingsNlpPreprocessor$process$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.xjsd.ai.assistant.flutter.nlp.SettingsNlpPreprocessor$process$1 r0 = new com.xjsd.ai.assistant.flutter.nlp.SettingsNlpPreprocessor$process$1
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r6 = r0.L$0
            r7 = r6
            com.xjsd.ai.assistant.nlu.bean.NluResponse r7 = (com.xjsd.ai.assistant.nlu.bean.NluResponse) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x016d
        L_0x002f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r8)
            com.xjsd.ai.assistant.nlu.bean.HeaderData r8 = r7.getHeader()
            java.lang.String r8 = r8.getName()
            com.alibaba.fastjson.JSONObject r2 = r7.getPayload()
            java.lang.String r4 = "target"
            java.lang.String r2 = r2.getString(r4)
            java.util.Set r4 = r6.f8491a
            boolean r4 = r4.contains(r2)
            if (r4 == 0) goto L_0x0162
            java.lang.String r4 = "TurnOff"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r8)
            java.lang.String r5 = "TurnOn"
            if (r4 != 0) goto L_0x0065
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r8)
            if (r4 == 0) goto L_0x0162
        L_0x0065:
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r8)
            if (r2 == 0) goto L_0x0161
            int r0 = r2.hashCode()
            java.lang.String r1 = "wake_up"
            r4 = 0
            switch(r0) {
                case -534921406: goto L_0x0109;
                case 745793298: goto L_0x00dc;
                case 829518209: goto L_0x008a;
                case 1117703958: goto L_0x0082;
                case 2122435839: goto L_0x0078;
                default: goto L_0x0076;
            }
        L_0x0076:
            goto L_0x0161
        L_0x0078:
            java.lang.String r0 = "delay_listening"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0112
            goto L_0x0161
        L_0x0082:
            boolean r0 = r2.equals(r1)
            if (r0 != 0) goto L_0x0112
            goto L_0x0161
        L_0x008a:
            java.lang.String r0 = "no_disturb"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0094
            goto L_0x0161
        L_0x0094:
            int r0 = com.xjsd.ai.assistant.phone.R.string.tts_setting_no_disturb
            java.lang.Object[] r1 = new java.lang.Object[r4]
            java.lang.String r0 = com.xjsd.ai.assistant.core.ContextHelper.b(r0, r1)
            com.xjsd.ai.assistant.phone.SuperAppAbilityManager$SAppAbilityEnum r1 = com.xjsd.ai.assistant.phone.SuperAppAbilityManager.SAppAbilityEnum.NOT_DISTURB
            if (r8 == 0) goto L_0x00be
            com.xjsd.ai.assistant.phone.SuperAppAbilityManager r8 = com.xjsd.ai.assistant.phone.SuperAppAbilityManager.e()
            boolean r8 = r8.h(r1)
            if (r8 == 0) goto L_0x00b2
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r6.k(r7, r0, r3)
            goto L_0x0161
        L_0x00b2:
            com.xjsd.ai.assistant.phone.SuperAppAbilityManager r8 = com.xjsd.ai.assistant.phone.SuperAppAbilityManager.e()
            r8.j(r1)
            r6.j(r7)
            goto L_0x0161
        L_0x00be:
            com.xjsd.ai.assistant.phone.SuperAppAbilityManager r8 = com.xjsd.ai.assistant.phone.SuperAppAbilityManager.e()
            boolean r8 = r8.h(r1)
            if (r8 == 0) goto L_0x00d4
            com.xjsd.ai.assistant.phone.SuperAppAbilityManager r8 = com.xjsd.ai.assistant.phone.SuperAppAbilityManager.e()
            r8.d(r1)
            r6.j(r7)
            goto L_0x0161
        L_0x00d4:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r6.k(r7, r0, r4)
            goto L_0x0161
        L_0x00dc:
            java.lang.String r0 = "navi_mute"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x00e6
            goto L_0x0161
        L_0x00e6:
            com.xjsd.ai.assistant.phone.SuperAppAbilityManager r0 = com.xjsd.ai.assistant.phone.SuperAppAbilityManager.e()
            com.upuphone.xr.interconnect.api.NaviAbilityOperator r0 = r0.f()
            boolean r1 = r0.isNaving()
            if (r1 == 0) goto L_0x0103
            if (r8 == 0) goto L_0x00fa
            r0.setNaviSpeak(r4)
            goto L_0x00fd
        L_0x00fa:
            r0.setNaviSpeak(r3)
        L_0x00fd:
            com.xjsd.ai.assistant.template.TtsNaviTemplate r8 = com.xjsd.ai.assistant.template.TtsNaviTemplate.NAVI17_P01
            r6.e(r7, r8)
            goto L_0x0161
        L_0x0103:
            com.xjsd.ai.assistant.template.TtsNaviTemplate r8 = com.xjsd.ai.assistant.template.TtsNaviTemplate.NAVI17_P03
            r6.e(r7, r8)
            goto L_0x0161
        L_0x0109:
            java.lang.String r0 = "keep_dialog"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0112
            goto L_0x0161
        L_0x0112:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x011b
            int r1 = com.xjsd.ai.assistant.phone.R.string.tts_setting_wake_up
            goto L_0x011d
        L_0x011b:
            int r1 = com.xjsd.ai.assistant.phone.R.string.tts_setting_delay_listening
        L_0x011d:
            if (r0 == 0) goto L_0x0122
            java.lang.String r0 = "low_power_wakeup"
            goto L_0x0124
        L_0x0122:
            java.lang.String r0 = "continuous_dialogue"
        L_0x0124:
            java.lang.Object[] r2 = new java.lang.Object[r4]
            java.lang.String r1 = com.xjsd.ai.assistant.core.ContextHelper.b(r1, r2)
            android.content.Context r2 = com.xjsd.ai.assistant.core.ContextHelper.a()
            if (r8 == 0) goto L_0x0149
            com.xjsd.ai.assistant.phone.helper.AssistantSettingUtils r8 = com.xjsd.ai.assistant.phone.helper.AssistantSettingUtils.b
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            boolean r4 = r8.e(r2, r0)
            if (r4 == 0) goto L_0x0142
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r6.k(r7, r1, r3)
            goto L_0x0161
        L_0x0142:
            r8.c(r2, r0, r3)
            r6.j(r7)
            goto L_0x0161
        L_0x0149:
            com.xjsd.ai.assistant.phone.helper.AssistantSettingUtils r8 = com.xjsd.ai.assistant.phone.helper.AssistantSettingUtils.b
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            boolean r3 = r8.e(r2, r0)
            if (r3 == 0) goto L_0x015b
            r8.c(r2, r0, r4)
            r6.j(r7)
            goto L_0x0161
        L_0x015b:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r6.k(r7, r1, r4)
        L_0x0161:
            return r7
        L_0x0162:
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r6 = r6.l(r7, r0)
            if (r6 != r1) goto L_0x016d
            return r1
        L_0x016d:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.flutter.nlp.SettingsNlpPreprocessor.i(com.xjsd.ai.assistant.nlu.bean.NluResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void j(NluResponse nluResponse) {
        e(nluResponse, TtsSettingTemplate.SET05_P01);
    }

    public final void k(NluResponse nluResponse, String str, boolean z) {
        if (z) {
            String tts = TtsSettingTemplate.SET05_P03.getTts(str);
            Intrinsics.checkNotNullExpressionValue(tts, "getTts(...)");
            h(nluResponse, tts);
            return;
        }
        String tts2 = TtsSettingTemplate.SET05_P04.getTts(str);
        Intrinsics.checkNotNullExpressionValue(tts2, "getTts(...)");
        h(nluResponse, tts2);
    }

    public Object l(NluResponse nluResponse, Continuation continuation) {
        return NlpPreprocessor.DefaultImpls.f(this, nluResponse, continuation);
    }
}
