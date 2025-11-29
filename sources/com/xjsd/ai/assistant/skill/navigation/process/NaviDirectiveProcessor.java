package com.xjsd.ai.assistant.skill.navigation.process;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.upuphone.xr.interconnect.api.NaviAbilityOperator;
import com.xjsd.ai.assistant.common.UnSupportFeatureManager;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.R;
import com.xjsd.ai.assistant.phone.SuperAppAbilityManager;
import com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder;
import com.xjsd.ai.assistant.skill.navigation.NavManager;
import com.xjsd.ai.assistant.skill.navigation.optimize.NavOptimizer;
import com.xjsd.ai.assistant.template.TtsNaviTemplate;

public class NaviDirectiveProcessor implements NavCmdProcessor {
    public void a(JSONObject jSONObject) {
        NaviAbilityOperator f = SuperAppAbilityManager.e().f();
        String string = jSONObject.getString("directive");
        string.hashCode();
        char c = 65535;
        switch (string.hashCode()) {
            case -1433872411:
                if (string.equals("refresh_route")) {
                    c = 0;
                    break;
                }
                break;
            case -864998525:
                if (string.equals("switch_destination")) {
                    c = 1;
                    break;
                }
                break;
            case -401021203:
                if (string.equals("navigate_home")) {
                    c = 2;
                    break;
                }
                break;
            case 1357571402:
                if (string.equals("navigate_office")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                if (f.isNaving()) {
                    ILog.a("NaviDirectiveProcessor", "refresh navi line");
                    if (f.refreshNavi()) {
                        new PhoneTtsPlayBuilder().e(TtsNaviTemplate.NAVI07_P01).a().c();
                        return;
                    } else {
                        new PhoneTtsPlayBuilder().d(R.string.tts_navi_rf_route_fail).a().c();
                        return;
                    }
                } else {
                    new PhoneTtsPlayBuilder().e(TtsNaviTemplate.NAVI01_P08).a().c();
                    return;
                }
            case 1:
                if (f.isNaving()) {
                    String string2 = jSONObject.getString("poi");
                    if (TextUtils.isEmpty(string2)) {
                        new PhoneTtsPlayBuilder().e(TtsNaviTemplate.NAVI02_P01).g(2).a().c();
                        return;
                    } else if (jSONObject.containsKey("poi_category") || !NavOptimizer.f8690a.i(string2, (String) null, (String) null)) {
                        NavManager.j().z("default");
                        NavManager.j().v(0, string2);
                        return;
                    } else {
                        ILog.a("NaviDirectiveProcessor", "startNavigate: poi优化策略优先执行");
                        return;
                    }
                } else {
                    new PhoneTtsPlayBuilder().e(TtsNaviTemplate.NAVI14_P01).a().c();
                    return;
                }
            case 2:
                String string3 = jSONObject.getString("poi");
                if (string3 != null) {
                    ILog.g("NaviDirectiveProcessor", "handle navigate_home poi->" + string3);
                    NavManager.j().v(1, string3);
                    return;
                }
                NavManager.j().m();
                return;
            case 3:
                String string4 = jSONObject.getString("poi");
                if (string4 != null) {
                    ILog.g("NaviDirectiveProcessor", "handle navigate_office poi->" + string4);
                    NavManager.j().v(2, string4);
                    return;
                }
                NavManager.j().o();
                return;
            default:
                UnSupportFeatureManager.f8414a.c();
                return;
        }
    }

    public String b() {
        return "NaviDirective";
    }
}
