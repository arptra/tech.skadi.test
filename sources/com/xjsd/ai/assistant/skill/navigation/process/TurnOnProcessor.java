package com.xjsd.ai.assistant.skill.navigation.process;

import com.alibaba.fastjson.JSONObject;
import com.xjsd.ai.assistant.common.UnSupportFeatureManager;
import com.xjsd.ai.assistant.phone.SuperAppAbilityManager;
import com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder;
import com.xjsd.ai.assistant.skill.navigation.NavManager;
import com.xjsd.ai.assistant.skill.navigation.custom.CustomizedNavManager;
import com.xjsd.ai.assistant.template.TtsNaviTemplate;

public class TurnOnProcessor implements NavCmdProcessor {
    public void a(JSONObject jSONObject) {
        String string = jSONObject.getString("target");
        string.hashCode();
        if (string.equals("map")) {
            String string2 = jSONObject.getString("transportation");
            boolean isNaving = SuperAppAbilityManager.e().f().isNaving();
            if (!isNaving || string2 == null) {
                new PhoneTtsPlayBuilder().e(TtsNaviTemplate.NAVI02_P01).g(2).a().c();
                if (!isNaving) {
                    CustomizedNavManager.c().f("");
                    return;
                }
                return;
            }
            NavManager.j().z(string2);
            NavManager.j().g();
        } else if (!string.equals("realtime_traffic")) {
            UnSupportFeatureManager.f8414a.c();
        } else {
            NavManager.j().n(true);
        }
    }

    public String b() {
        return "TurnOn";
    }
}
