package com.xjsd.ai.assistant.skill.navigation.process;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.upuphone.xr.interconnect.entity.NaviLocationInfo;
import com.upuphone.xr.interconnect.listener.NaviLocationCallback;
import com.xjsd.ai.assistant.common.UnSupportFeatureManager;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.SuperAppAbilityManager;
import com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder;
import com.xjsd.ai.assistant.template.TtsNaviTemplate;

public class QueryProcessor implements NavCmdProcessor {

    /* renamed from: a  reason: collision with root package name */
    public NaviLocationCallback f8693a = new NaviLocationCallback() {
        public void onLocationChanged(NaviLocationInfo naviLocationInfo) {
            ILog.j("QueryProcessor", "LocationInfo : " + JSON.toJSONString(naviLocationInfo));
            if (naviLocationInfo == null || TextUtils.isEmpty(naviLocationInfo.getAddress())) {
                new PhoneTtsPlayBuilder().f("没有获取到位置信息").a().c();
            } else {
                new PhoneTtsPlayBuilder().e(TtsNaviTemplate.NAVI06_P01).k("currentRoadName", naviLocationInfo.getAddress()).o(naviLocationInfo.getAddress()).a().c();
            }
            SuperAppAbilityManager.e().f().stopLocation(QueryProcessor.this.f8693a);
        }
    };

    public void a(JSONObject jSONObject) {
        if (!jSONObject.containsKey("type")) {
            return;
        }
        if ("current".equals(jSONObject.getString("type"))) {
            SuperAppAbilityManager.e().f().startLocation(this.f8693a);
        } else {
            UnSupportFeatureManager.f8414a.c();
        }
    }

    public String b() {
        return "Query";
    }
}
