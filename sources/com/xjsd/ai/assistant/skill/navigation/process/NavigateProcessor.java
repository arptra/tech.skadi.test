package com.xjsd.ai.assistant.skill.navigation.process;

import com.alibaba.fastjson.JSONObject;
import com.honey.account.pa.a;
import com.honey.account.pa.b;
import com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder;
import com.xjsd.ai.assistant.template.TtsNaviTemplate;
import kotlin.Unit;

public class NavigateProcessor implements NavCmdProcessor {
    public void a(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject.getJSONObject("poi");
        if (jSONObject2 == null || jSONObject2.getString("name") == null) {
            new PhoneTtsPlayBuilder().e(TtsNaviTemplate.NAVI15_P02).g(2).a().c();
            return;
        }
        String string = jSONObject2.getString("name");
        boolean equalsIgnoreCase = "category".equalsIgnoreCase(jSONObject2.getString("type"));
        String string2 = jSONObject.getString("transportation");
        String string3 = jSONObject.getString("route_mode");
        if (e(string2) || e(string3)) {
            String str = string;
            String str2 = string2;
            String str3 = string3;
            boolean z = equalsIgnoreCase;
            new PhoneTtsPlayBuilder().e(TtsNaviTemplate.NAVI03_P01).h(new a(this, str, str2, str3, z)).i(new b(this, str, str2, str3, z)).a().c();
            return;
        }
        h(true, string, string2, string3, equalsIgnoreCase);
    }

    public String b() {
        return "Navigate";
    }

    public final boolean e(String str) {
        return "unsupport".equalsIgnoreCase(str);
    }

    public final /* synthetic */ Unit f(String str, String str2, String str3, boolean z) {
        h(false, str, str2, str3, z);
        return null;
    }

    public final /* synthetic */ Unit g(String str, String str2, String str3, boolean z) {
        h(false, str, str2, str3, z);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void h(boolean r2, java.lang.String r3, java.lang.String r4, java.lang.String r5, boolean r6) {
        /*
            r1 = this;
            r0 = 0
            if (r2 == 0) goto L_0x001a
            if (r4 == 0) goto L_0x000d
            com.xjsd.ai.assistant.skill.navigation.NavManager r1 = com.xjsd.ai.assistant.skill.navigation.NavManager.j()
            r1.z(r4)
            goto L_0x000e
        L_0x000d:
            r4 = r0
        L_0x000e:
            if (r5 == 0) goto L_0x0018
            com.xjsd.ai.assistant.skill.navigation.NavManager r1 = com.xjsd.ai.assistant.skill.navigation.NavManager.j()
            r1.A(r5)
            goto L_0x003e
        L_0x0018:
            r5 = r0
            goto L_0x003e
        L_0x001a:
            boolean r2 = r1.e(r4)
            java.lang.String r4 = "default"
            if (r2 == 0) goto L_0x002b
            com.xjsd.ai.assistant.skill.navigation.NavManager r2 = com.xjsd.ai.assistant.skill.navigation.NavManager.j()
            r2.z(r4)
            r2 = r4
            goto L_0x002c
        L_0x002b:
            r2 = r0
        L_0x002c:
            boolean r1 = r1.e(r5)
            if (r1 == 0) goto L_0x003c
            com.xjsd.ai.assistant.skill.navigation.NavManager r1 = com.xjsd.ai.assistant.skill.navigation.NavManager.j()
            r1.A(r4)
            r5 = r4
            r4 = r2
            goto L_0x003e
        L_0x003c:
            r4 = r2
            goto L_0x0018
        L_0x003e:
            if (r6 != 0) goto L_0x0051
            com.xjsd.ai.assistant.skill.navigation.optimize.NavOptimizer r1 = com.xjsd.ai.assistant.skill.navigation.optimize.NavOptimizer.f8690a
            boolean r1 = r1.i(r3, r4, r5)
            if (r1 == 0) goto L_0x0051
            java.lang.String r1 = "NavigateProcessor"
            java.lang.String r2 = "startNavigate: poi优化策略优先执行"
            com.xjsd.ai.assistant.log.ILog.a(r1, r2)
            return
        L_0x0051:
            com.xjsd.ai.assistant.skill.navigation.NavManager r1 = com.xjsd.ai.assistant.skill.navigation.NavManager.j()
            r2 = 0
            r1.v(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.skill.navigation.process.NavigateProcessor.h(boolean, java.lang.String, java.lang.String, java.lang.String, boolean):void");
    }
}
