package com.xjsd.ai.assistant.phone.vui.settings;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/xjsd/ai/assistant/phone/vui/settings/SettingsHelper;", "", "<init>", "()V", "", "target", "", "isTurnOn", "", "a", "(Ljava/lang/String;Z)V", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class SettingsHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final SettingsHelper f8635a = new SettingsHelper();

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x016e, code lost:
        if (r5.equals("keep_dialog") == false) goto L_0x0170;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0170, code lost:
        com.xjsd.ai.assistant.log.ILog.a("SettingsHelper", "updateSettings: 不支持修改该设置项->" + r5);
        com.xjsd.ai.assistant.common.UnSupportFeatureManager.f8414a.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x018e, code lost:
        r5 = com.xjsd.ai.assistant.core.ContextHelper.b(com.xjsd.ai.assistant.phone.R.string.tts_setting_delay_listening, new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0198, code lost:
        if (r6 == false) goto L_0x01dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x019a, code lost:
        r6 = com.xjsd.ai.assistant.phone.helper.AssistantSettingUtils.b;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x01a3, code lost:
        if (r6.e(r0, "continuous_dialogue") == false) goto L_0x01c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x01a5, code lost:
        r6 = new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder().e(com.xjsd.ai.assistant.template.TtsSettingTemplate.SET05_P03).o(r5);
        kotlin.jvm.internal.Intrinsics.checkNotNull(r5);
        r6.k("Sys_Setting", r5).a().c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x01c7, code lost:
        r6.c(r0, "continuous_dialogue", true);
        new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder().e(com.xjsd.ai.assistant.template.TtsSettingTemplate.SET05_P01).a().c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x01dd, code lost:
        r6 = com.xjsd.ai.assistant.phone.helper.AssistantSettingUtils.b;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x01e6, code lost:
        if (r6.e(r0, "continuous_dialogue") == false) goto L_0x01fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x01e8, code lost:
        r6.c(r0, "continuous_dialogue", false);
        new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder().e(com.xjsd.ai.assistant.template.TtsSettingTemplate.SET05_P02).a().c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x001d, code lost:
        if (r5.equals("delay_listening") == false) goto L_0x0170;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x01fe, code lost:
        r6 = new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder().e(com.xjsd.ai.assistant.template.TtsSettingTemplate.SET05_P04).o(r5);
        kotlin.jvm.internal.Intrinsics.checkNotNull(r5);
        r6.k("Sys_Setting", r5).a().c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void a(java.lang.String r5, boolean r6) {
        /*
            java.lang.String r0 = "target"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            android.content.Context r0 = com.xjsd.ai.assistant.core.ContextHelper.a()
            int r1 = r5.hashCode()
            r2 = 1
            r3 = 0
            java.lang.String r4 = "Sys_Setting"
            switch(r1) {
                case -534921406: goto L_0x0168;
                case 829518209: goto L_0x00c2;
                case 1117703958: goto L_0x0021;
                case 2122435839: goto L_0x0017;
                default: goto L_0x0015;
            }
        L_0x0015:
            goto L_0x0170
        L_0x0017:
            java.lang.String r1 = "delay_listening"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L_0x018e
            goto L_0x0170
        L_0x0021:
            java.lang.String r1 = "wake_up"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L_0x002c
            goto L_0x0170
        L_0x002c:
            int r5 = com.xjsd.ai.assistant.phone.R.string.tts_setting_wake_up
            java.lang.Object[] r1 = new java.lang.Object[r3]
            java.lang.String r5 = com.xjsd.ai.assistant.core.ContextHelper.b(r5, r1)
            java.lang.String r1 = "low_power_wakeup"
            if (r6 == 0) goto L_0x007d
            com.xjsd.ai.assistant.phone.helper.AssistantSettingUtils r6 = com.xjsd.ai.assistant.phone.helper.AssistantSettingUtils.b
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            boolean r3 = r6.e(r0, r1)
            if (r3 == 0) goto L_0x0066
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r6 = new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder
            r6.<init>()
            com.xjsd.ai.assistant.template.TtsSettingTemplate r0 = com.xjsd.ai.assistant.template.TtsSettingTemplate.SET05_P03
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r6 = r6.e(r0)
            java.lang.String[] r0 = new java.lang.String[]{r5}
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r6 = r6.o(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r5 = r6.k(r4, r5)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r5 = r5.a()
            r5.c()
            goto L_0x021f
        L_0x0066:
            r6.c(r0, r1, r2)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r5 = new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder
            r5.<init>()
            com.xjsd.ai.assistant.template.TtsSettingTemplate r6 = com.xjsd.ai.assistant.template.TtsSettingTemplate.SET05_P01
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r5 = r5.e(r6)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r5 = r5.a()
            r5.c()
            goto L_0x021f
        L_0x007d:
            com.xjsd.ai.assistant.phone.helper.AssistantSettingUtils r6 = com.xjsd.ai.assistant.phone.helper.AssistantSettingUtils.b
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            boolean r2 = r6.e(r0, r1)
            if (r2 == 0) goto L_0x009f
            r6.c(r0, r1, r3)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r5 = new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder
            r5.<init>()
            com.xjsd.ai.assistant.template.TtsSettingTemplate r6 = com.xjsd.ai.assistant.template.TtsSettingTemplate.SET05_P02
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r5 = r5.e(r6)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r5 = r5.a()
            r5.c()
            goto L_0x021f
        L_0x009f:
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r6 = new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder
            r6.<init>()
            com.xjsd.ai.assistant.template.TtsSettingTemplate r0 = com.xjsd.ai.assistant.template.TtsSettingTemplate.SET05_P04
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r6 = r6.e(r0)
            java.lang.String[] r0 = new java.lang.String[]{r5}
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r6 = r6.o(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r5 = r6.k(r4, r5)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r5 = r5.a()
            r5.c()
            goto L_0x021f
        L_0x00c2:
            java.lang.String r0 = "no_disturb"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x00cc
            goto L_0x0170
        L_0x00cc:
            int r5 = com.xjsd.ai.assistant.phone.R.string.tts_setting_no_disturb
            java.lang.Object[] r0 = new java.lang.Object[r3]
            java.lang.String r5 = com.xjsd.ai.assistant.core.ContextHelper.b(r5, r0)
            com.xjsd.ai.assistant.phone.SuperAppAbilityManager$SAppAbilityEnum r0 = com.xjsd.ai.assistant.phone.SuperAppAbilityManager.SAppAbilityEnum.NOT_DISTURB
            if (r6 == 0) goto L_0x0120
            com.xjsd.ai.assistant.phone.SuperAppAbilityManager r6 = com.xjsd.ai.assistant.phone.SuperAppAbilityManager.e()
            boolean r6 = r6.h(r0)
            if (r6 != 0) goto L_0x00fd
            com.xjsd.ai.assistant.phone.SuperAppAbilityManager r5 = com.xjsd.ai.assistant.phone.SuperAppAbilityManager.e()
            r5.j(r0)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r5 = new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder
            r5.<init>()
            com.xjsd.ai.assistant.template.TtsSettingTemplate r6 = com.xjsd.ai.assistant.template.TtsSettingTemplate.SET05_P01
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r5 = r5.e(r6)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r5 = r5.a()
            r5.c()
            goto L_0x021f
        L_0x00fd:
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r6 = new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder
            r6.<init>()
            com.xjsd.ai.assistant.template.TtsSettingTemplate r0 = com.xjsd.ai.assistant.template.TtsSettingTemplate.SET05_P03
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r6 = r6.e(r0)
            java.lang.String[] r0 = new java.lang.String[]{r5}
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r6 = r6.o(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r5 = r6.k(r4, r5)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r5 = r5.a()
            r5.c()
            goto L_0x021f
        L_0x0120:
            com.xjsd.ai.assistant.phone.SuperAppAbilityManager r6 = com.xjsd.ai.assistant.phone.SuperAppAbilityManager.e()
            boolean r6 = r6.h(r0)
            if (r6 == 0) goto L_0x0145
            com.xjsd.ai.assistant.phone.SuperAppAbilityManager r5 = com.xjsd.ai.assistant.phone.SuperAppAbilityManager.e()
            r5.d(r0)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r5 = new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder
            r5.<init>()
            com.xjsd.ai.assistant.template.TtsSettingTemplate r6 = com.xjsd.ai.assistant.template.TtsSettingTemplate.SET05_P02
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r5 = r5.e(r6)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r5 = r5.a()
            r5.c()
            goto L_0x021f
        L_0x0145:
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r6 = new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder
            r6.<init>()
            com.xjsd.ai.assistant.template.TtsSettingTemplate r0 = com.xjsd.ai.assistant.template.TtsSettingTemplate.SET05_P04
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r6 = r6.e(r0)
            java.lang.String[] r0 = new java.lang.String[]{r5}
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r6 = r6.o(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r5 = r6.k(r4, r5)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r5 = r5.a()
            r5.c()
            goto L_0x021f
        L_0x0168:
            java.lang.String r1 = "keep_dialog"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L_0x018e
        L_0x0170:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "updateSettings: 不支持修改该设置项->"
            r6.append(r0)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            java.lang.String r6 = "SettingsHelper"
            com.xjsd.ai.assistant.log.ILog.a(r6, r5)
            com.xjsd.ai.assistant.common.UnSupportFeatureManager r5 = com.xjsd.ai.assistant.common.UnSupportFeatureManager.f8414a
            r5.c()
            goto L_0x021f
        L_0x018e:
            int r5 = com.xjsd.ai.assistant.phone.R.string.tts_setting_delay_listening
            java.lang.Object[] r1 = new java.lang.Object[r3]
            java.lang.String r5 = com.xjsd.ai.assistant.core.ContextHelper.b(r5, r1)
            java.lang.String r1 = "continuous_dialogue"
            if (r6 == 0) goto L_0x01dd
            com.xjsd.ai.assistant.phone.helper.AssistantSettingUtils r6 = com.xjsd.ai.assistant.phone.helper.AssistantSettingUtils.b
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            boolean r3 = r6.e(r0, r1)
            if (r3 == 0) goto L_0x01c7
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r6 = new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder
            r6.<init>()
            com.xjsd.ai.assistant.template.TtsSettingTemplate r0 = com.xjsd.ai.assistant.template.TtsSettingTemplate.SET05_P03
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r6 = r6.e(r0)
            java.lang.String[] r0 = new java.lang.String[]{r5}
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r6 = r6.o(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r5 = r6.k(r4, r5)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r5 = r5.a()
            r5.c()
            goto L_0x021f
        L_0x01c7:
            r6.c(r0, r1, r2)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r5 = new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder
            r5.<init>()
            com.xjsd.ai.assistant.template.TtsSettingTemplate r6 = com.xjsd.ai.assistant.template.TtsSettingTemplate.SET05_P01
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r5 = r5.e(r6)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r5 = r5.a()
            r5.c()
            goto L_0x021f
        L_0x01dd:
            com.xjsd.ai.assistant.phone.helper.AssistantSettingUtils r6 = com.xjsd.ai.assistant.phone.helper.AssistantSettingUtils.b
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            boolean r2 = r6.e(r0, r1)
            if (r2 == 0) goto L_0x01fe
            r6.c(r0, r1, r3)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r5 = new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder
            r5.<init>()
            com.xjsd.ai.assistant.template.TtsSettingTemplate r6 = com.xjsd.ai.assistant.template.TtsSettingTemplate.SET05_P02
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r5 = r5.e(r6)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r5 = r5.a()
            r5.c()
            goto L_0x021f
        L_0x01fe:
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r6 = new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder
            r6.<init>()
            com.xjsd.ai.assistant.template.TtsSettingTemplate r0 = com.xjsd.ai.assistant.template.TtsSettingTemplate.SET05_P04
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r6 = r6.e(r0)
            java.lang.String[] r0 = new java.lang.String[]{r5}
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r6 = r6.o(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r5 = r6.k(r4, r5)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r5 = r5.a()
            r5.c()
        L_0x021f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.phone.vui.settings.SettingsHelper.a(java.lang.String, boolean):void");
    }
}
