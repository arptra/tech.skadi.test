package com.xjsd.ai.assistant.skill.navigation.process;

import com.alibaba.fastjson.JSONObject;
import com.xjsd.ai.assistant.common.UnSupportFeatureManager;
import com.xjsd.ai.assistant.skill.navigation.NavManager;

public class TurnOffProcessor implements NavCmdProcessor {
    public void a(JSONObject jSONObject) {
        String string = jSONObject.getString("target");
        string.hashCode();
        if (string.equals("map")) {
            NavManager.j().i();
        } else if (!string.equals("realtime_traffic")) {
            UnSupportFeatureManager.f8414a.c();
        } else {
            NavManager.j().n(false);
        }
    }

    public String b() {
        return "TurnOff";
    }
}
