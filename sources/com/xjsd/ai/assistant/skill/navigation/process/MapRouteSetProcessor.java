package com.xjsd.ai.assistant.skill.navigation.process;

import com.alibaba.fastjson.JSONObject;
import com.upuphone.xr.interconnect.api.NaviAbilityOperator;
import com.xjsd.ai.assistant.phone.SuperAppAbilityManager;
import com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder;
import com.xjsd.ai.assistant.skill.navigation.NavManager;
import com.xjsd.ai.assistant.skill.navigation.enums.NavTravelMode;
import com.xjsd.ai.assistant.template.TtsNaviTemplate;

public class MapRouteSetProcessor implements NavCmdProcessor {
    public void a(JSONObject jSONObject) {
        String string = jSONObject.getString("route_mode");
        NavTravelMode matchMode = NavTravelMode.matchMode(string);
        NaviAbilityOperator f = SuperAppAbilityManager.e().f();
        if (matchMode != NavTravelMode.DEFAULT) {
            if (!f.isNaving()) {
                new PhoneTtsPlayBuilder().e(TtsNaviTemplate.NAVI08_P04).a().c();
                return;
            }
            NavManager.j().A(string);
            NavManager.j().g();
        } else if (!f.isNaving()) {
            new PhoneTtsPlayBuilder().e(TtsNaviTemplate.NAVI09_P02).a().c();
        } else {
            NavManager.j().A(string);
            NavManager.j().h();
        }
    }

    public String b() {
        return "MapRouteSet";
    }
}
