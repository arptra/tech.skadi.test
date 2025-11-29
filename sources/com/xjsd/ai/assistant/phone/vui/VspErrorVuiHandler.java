package com.xjsd.ai.assistant.phone.vui;

import com.xjsd.ai.assistant.common.handler.VuiHandler;
import com.xjsd.ai.assistant.protocol.VuiModelType;

public class VspErrorVuiHandler implements VuiHandler {
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.xjsd.ai.assistant.protocol.VuiModel r9) {
        /*
            r8 = this;
            r8 = 2
            r0 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "处理VSP Error->"
            r1.append(r2)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "VspErrorVuiHandler"
            com.xjsd.ai.assistant.log.ILog.a(r2, r1)
            com.alibaba.fastjson.JSONObject r9 = r9.getPayload()
            java.lang.String r1 = "type"
            java.lang.String r1 = r9.getString(r1)
            java.lang.String r2 = "NLU_INPUT_ERROR"
            boolean r2 = r2.equals(r1)
            r3 = 1
            if (r2 == 0) goto L_0x005f
            java.lang.String r8 = "tts"
            java.lang.String r8 = r9.getString(r8)
            boolean r9 = android.text.TextUtils.isEmpty(r8)
            if (r9 == 0) goto L_0x004e
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r8 = new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder
            r8.<init>()
            java.lang.String r9 = "您已涉及敏感词，小溪无法回复你哦"
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TextTts r8 = r8.f(r9)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r8 = r8.a()
            r8.c()
            goto L_0x005e
        L_0x004e:
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r9 = new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder
            r9.<init>()
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TextTts r8 = r9.f(r8)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r8 = r8.a()
            r8.c()
        L_0x005e:
            return r3
        L_0x005f:
            com.xjsd.ai.assistant.core.AbilityManager r9 = com.xjsd.ai.assistant.core.AbilityManager.b
            java.lang.Class<com.xjsd.ai.assistant.core.api.cache.CacheAbility> r2 = com.xjsd.ai.assistant.core.api.cache.CacheAbility.class
            com.xjsd.ai.assistant.core.Ability r9 = r9.b(r2)
            com.xjsd.ai.assistant.core.api.cache.CacheAbility r9 = (com.xjsd.ai.assistant.core.api.cache.CacheAbility) r9
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            java.lang.String r4 = "continuous_dialogue"
            java.lang.Object r4 = r9.getCacheWithDefault(r4, r2)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r3)
            java.lang.String r6 = "lastWakeupType"
            java.lang.Object r5 = r9.getCacheWithDefault(r6, r5)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            java.lang.String r6 = "isNetworkAvailable"
            java.lang.Object r9 = r9.getCacheWithDefault(r6, r2)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            com.xjsd.ai.assistant.template.TtsGlobalTemplate r2 = com.xjsd.ai.assistant.template.TtsGlobalTemplate.GLOBAL01_P06
            r1.hashCode()
            r6 = -1
            int r7 = r1.hashCode()
            switch(r7) {
                case -672445477: goto L_0x00b7;
                case -349179063: goto L_0x00ac;
                case 976489984: goto L_0x00a1;
                default: goto L_0x00a0;
            }
        L_0x00a0:
            goto L_0x00c1
        L_0x00a1:
            java.lang.String r7 = "NLU_ERROR"
            boolean r1 = r1.equals(r7)
            if (r1 != 0) goto L_0x00aa
            goto L_0x00c1
        L_0x00aa:
            r6 = r8
            goto L_0x00c1
        L_0x00ac:
            java.lang.String r7 = "ASR_ERROR"
            boolean r1 = r1.equals(r7)
            if (r1 != 0) goto L_0x00b5
            goto L_0x00c1
        L_0x00b5:
            r6 = r3
            goto L_0x00c1
        L_0x00b7:
            java.lang.String r7 = "ASR_RESULT_IS_EMPTY"
            boolean r1 = r1.equals(r7)
            if (r1 != 0) goto L_0x00c0
            goto L_0x00c1
        L_0x00c0:
            r6 = r0
        L_0x00c1:
            switch(r6) {
                case 0: goto L_0x00c9;
                case 1: goto L_0x00c4;
                case 2: goto L_0x00c6;
                default: goto L_0x00c4;
            }
        L_0x00c4:
            r8 = r3
            goto L_0x00e6
        L_0x00c6:
            com.xjsd.ai.assistant.template.TtsGlobalTemplate r2 = com.xjsd.ai.assistant.template.TtsGlobalTemplate.GLOBAL01_P02
            goto L_0x00c4
        L_0x00c9:
            if (r9 == 0) goto L_0x00e3
            if (r5 != r8) goto L_0x00cf
            r9 = r3
            goto L_0x00d0
        L_0x00cf:
            r9 = r0
        L_0x00d0:
            if (r9 != 0) goto L_0x00d9
            if (r4 == 0) goto L_0x00d5
            goto L_0x00d9
        L_0x00d5:
            com.xjsd.ai.assistant.template.TtsGlobalTemplate r1 = com.xjsd.ai.assistant.template.TtsGlobalTemplate.GLOBAL01_P22
        L_0x00d7:
            r2 = r1
            goto L_0x00dc
        L_0x00d9:
            com.xjsd.ai.assistant.template.TtsGlobalTemplate r1 = com.xjsd.ai.assistant.template.TtsGlobalTemplate.GLOBAL01_P03
            goto L_0x00d7
        L_0x00dc:
            if (r9 == 0) goto L_0x00df
            goto L_0x00e6
        L_0x00df:
            if (r4 == 0) goto L_0x00c4
            r8 = r0
            goto L_0x00e6
        L_0x00e3:
            com.xjsd.ai.assistant.template.TtsGlobalTemplate r2 = com.xjsd.ai.assistant.template.TtsGlobalTemplate.GLOBAL01_P01
            goto L_0x00c4
        L_0x00e6:
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r9 = new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder
            r9.<init>()
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r9 = r9.e(r2)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$PhoneTts r8 = r9.g(r8)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r8 = r8.a()
            r8.c()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.phone.vui.VspErrorVuiHandler.a(com.xjsd.ai.assistant.protocol.VuiModel):boolean");
    }

    public String getHandleType() {
        return VuiModelType.VSP_ERROR;
    }
}
