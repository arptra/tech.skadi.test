package com.xjsd.ai.assistant.phone.vui;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.honey.account.na.a;
import com.honey.account.na.b;
import com.honey.account.na.c;
import com.xjsd.ai.assistant.common.UnSupportFeatureManager;
import com.xjsd.ai.assistant.common.handler.VuiHandler;
import com.xjsd.ai.assistant.core.util.DeviceUtils;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.WakeupControlDelegate;
import com.xjsd.ai.assistant.phone.helper.VrStateSynchronizer;
import com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder;
import com.xjsd.ai.assistant.phone.vui.translate.TranslateManager;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import com.xjsd.ai.assistant.protocol.wakeup.WakeupControl;
import com.xjsd.ai.assistant.template.TtsGlobalTemplate;
import com.xjsd.ai.assistant.template.TtsTemplate;
import com.xjsd.ai.assistant.template.TtsTranslateTemplate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TranslateVuiHandler implements VuiHandler {
    public static final List c = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    public final Set f8627a;
    public final Set b;

    public TranslateVuiHandler() {
        HashSet hashSet = new HashSet();
        this.f8627a = hashSet;
        HashSet hashSet2 = new HashSet();
        this.b = hashSet2;
        hashSet.add("Translation_Specify_Mode_Start");
        hashSet.add("Translation_Start");
        hashSet.add("Translation_Resume");
        hashSet.add("Translation_Pause");
        hashSet2.add("dt");
        hashSet2.add("pt");
        List list = c;
        list.add("default");
        list.add("$session.params.TranslationType");
        list.add("$session.params.language");
        list.add("null");
        list.add("");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0095, code lost:
        if (r3.equals("Translation_Pause") == false) goto L_0x006c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.xjsd.ai.assistant.protocol.VuiModel r7) {
        /*
            r6 = this;
            r0 = 1
            r1 = 0
            com.alibaba.fastjson.JSONObject r2 = r7.getPayload()
            com.xjsd.ai.assistant.protocol.vui.Header r7 = r7.getHeader()
            java.lang.String r7 = r7.getName()
            java.lang.String r3 = "directive"
            java.lang.String r3 = r2.getString(r3)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "directive..."
            r4.append(r5)
            r4.append(r3)
            java.lang.String r5 = ", name = "
            r4.append(r5)
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "TranslateVuiHandler"
            com.xjsd.ai.assistant.log.ILog.a(r5, r4)
            java.lang.String r4 = "TranslationDirective"
            boolean r7 = r4.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x00ad
            java.util.Set r7 = r6.f8627a
            boolean r7 = r7.contains(r3)
            if (r7 == 0) goto L_0x00ad
            java.lang.String r7 = "type"
            java.lang.String r7 = r2.getString(r7)
            boolean r4 = android.text.TextUtils.isEmpty(r7)
            if (r4 != 0) goto L_0x0057
            java.util.List r4 = c
            boolean r4 = r4.contains(r7)
            if (r4 == 0) goto L_0x0059
        L_0x0057:
            java.lang.String r7 = "dt"
        L_0x0059:
            java.util.Set r4 = r6.b
            boolean r4 = r4.contains(r7)
            if (r4 == 0) goto L_0x00a8
            r3.hashCode()
            r4 = -1
            int r5 = r3.hashCode()
            switch(r5) {
                case -1070513496: goto L_0x008f;
                case -1067196140: goto L_0x0084;
                case -524355342: goto L_0x0079;
                case 1234715067: goto L_0x006e;
                default: goto L_0x006c;
            }
        L_0x006c:
            r1 = r4
            goto L_0x0098
        L_0x006e:
            java.lang.String r1 = "Translation_Resume"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0077
            goto L_0x006c
        L_0x0077:
            r1 = 3
            goto L_0x0098
        L_0x0079:
            java.lang.String r1 = "Translation_Specify_Mode_Start"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0082
            goto L_0x006c
        L_0x0082:
            r1 = 2
            goto L_0x0098
        L_0x0084:
            java.lang.String r1 = "Translation_Start"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x008d
            goto L_0x006c
        L_0x008d:
            r1 = r0
            goto L_0x0098
        L_0x008f:
            java.lang.String r5 = "Translation_Pause"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x0098
            goto L_0x006c
        L_0x0098:
            switch(r1) {
                case 0: goto L_0x00a4;
                case 1: goto L_0x00a0;
                case 2: goto L_0x009c;
                case 3: goto L_0x00a0;
                default: goto L_0x009b;
            }
        L_0x009b:
            goto L_0x00ac
        L_0x009c:
            r6.e(r2, r7)
            goto L_0x00ac
        L_0x00a0:
            r6.k(r2, r7)
            goto L_0x00ac
        L_0x00a4:
            r6.i(r7)
            goto L_0x00ac
        L_0x00a8:
            r7 = 0
            r6.j(r7)
        L_0x00ac:
            return r0
        L_0x00ad:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.phone.vui.TranslateVuiHandler.a(com.xjsd.ai.assistant.protocol.VuiModel):boolean");
    }

    public final void e(JSONObject jSONObject, String str) {
        String str2;
        boolean f = TranslateManager.f(str);
        String string = jSONObject.getString("language");
        if (f) {
            String[] split = string.toLowerCase().split("to");
            if (split.length < 2) {
                j((TtsTemplate) null);
                return;
            }
            String str3 = split[0];
            str2 = split[1];
            string = str3;
        } else {
            str2 = string;
        }
        l(str, string, str2);
    }

    public String getHandleType() {
        return VuiModelType.TRANSLATION;
    }

    public final void i(String str) {
        if (TranslateManager.e(str)) {
            new PhoneTtsPlayBuilder().e(TtsTranslateTemplate.TRANS06_R01).i(new a(str)).a().c();
        } else if (TranslateManager.f(str)) {
            j(TtsTranslateTemplate.TRANS06_R02);
        } else {
            j(TtsTranslateTemplate.TRANS06_R03);
        }
    }

    public final void j(TtsTemplate ttsTemplate) {
        if (ttsTemplate == null) {
            UnSupportFeatureManager.f8414a.c();
        } else {
            new PhoneTtsPlayBuilder().e(ttsTemplate).g(1).a().c();
        }
    }

    public final void k(JSONObject jSONObject, String str) {
        String string = jSONObject.getString("language");
        if (!TextUtils.isEmpty(string) && !c.contains(string)) {
            l(str, string, string);
        } else if (TranslateManager.e(str)) {
            VrStateSynchronizer.b(0);
            WakeupControlDelegate.g.i(new WakeupControl(0));
        } else {
            new PhoneTtsPlayBuilder().e(TtsGlobalTemplate.GLOBAL06_P01).i(new c(str)).a().c();
        }
    }

    public final void l(String str, String str2, String str3) {
        if (TranslateManager.d(DeviceUtils.d(), str, str2, str3)) {
            new PhoneTtsPlayBuilder().e(TtsGlobalTemplate.GLOBAL06_P01).i(new b(str, str2, str3)).a().c();
            return;
        }
        int i = TranslateManager.i(str, str2, str3);
        ILog.a("TranslateVuiHandler", "set Transfer Translate....result == " + i);
        if (i == -6 || i == -5) {
            j(TtsTranslateTemplate.TRANS05_R04);
        } else if (i == -4 || i == -3) {
            j(TtsTranslateTemplate.TRANS05_R01);
        } else if (i == 0 || i == 1) {
            j(TtsGlobalTemplate.GLOBAL06_P01);
        } else {
            j((TtsTemplate) null);
        }
    }
}
