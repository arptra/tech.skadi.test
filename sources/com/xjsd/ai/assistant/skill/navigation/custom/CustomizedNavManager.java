package com.xjsd.ai.assistant.skill.navigation.custom;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.xr.interconnect.entity.PoiResult;
import com.xjsd.ai.assistant.core.ContextHelper;
import com.xjsd.ai.assistant.core.api.tts.TtsData;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.nlu.NluContextDataMaintainer;
import com.xjsd.ai.assistant.nlu.bean.ContextData;
import com.xjsd.ai.assistant.phone.SuperAppAbilityManager;
import com.xjsd.ai.assistant.phone.VoiceAssistantApi;
import com.xjsd.ai.assistant.phone.event.UserAbortEvent;
import com.xjsd.ai.assistant.phone.tts.TtsManager;
import com.xjsd.ai.assistant.protocol.VuiModel;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import com.xjsd.ai.assistant.protocol.nav.TypedPoiResult;
import com.xjsd.ai.assistant.skill.navigation.NavHelper;
import com.xjsd.ai.assistant.skill.navigation.NavManager;
import com.xjsd.ai.assistant.skill.navigation.custom.NavCommonPoiInfo;
import com.xjsd.ai.assistant.template.TtsGlobalTemplate;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class CustomizedNavManager {

    /* renamed from: a  reason: collision with root package name */
    public List f8687a;

    public static class SingleHolder {

        /* renamed from: a  reason: collision with root package name */
        public static final CustomizedNavManager f8688a = new CustomizedNavManager();
    }

    public CustomizedNavManager() {
        EventBus.c().o(this);
    }

    public static CustomizedNavManager c() {
        return SingleHolder.f8688a;
    }

    public void a() {
        ILog.a("CustomizedNavManager", "清除定制导航管理器数据");
        this.f8687a = null;
        NavHelper.b();
    }

    public final void b() {
        ILog.a("CustomizedNavManager", "clear navi Data");
        NavManager.j().y("");
        a();
    }

    public final void d(int i, int i2) {
        ILog.a("CustomizedNavManager", "定制的导航管理器处理Select->" + i);
        if (i > this.f8687a.size()) {
            TtsData ttsData = new TtsData();
            TtsGlobalTemplate ttsGlobalTemplate = TtsGlobalTemplate.GLOBAL03_P01;
            ttsData.setFunctionId(ttsGlobalTemplate.getFunctionId());
            ttsData.setText(ContextHelper.b(ttsGlobalTemplate.getResId(), new Object[0]));
            ttsData.setNextStep(2);
            TtsManager.g.f(ttsData);
            return;
        }
        if (i == 1) {
            NavManager.j().m();
        } else if (i == 2) {
            NavManager.j().o();
        } else {
            NavManager.j().p(new TypedPoiResult((PoiResult) this.f8687a.get(i - 1), i2));
        }
        a();
    }

    public void e() {
        if (VoiceAssistantApi.isOversea) {
            List<PoiResult> freqVisitedAddress = SuperAppAbilityManager.e().f().getFreqVisitedAddress();
            if (freqVisitedAddress == null || freqVisitedAddress.isEmpty()) {
                ILog.a("CustomizedNavManager", "getFreqVisitedAddress ... 返回为空");
                NluContextDataMaintainer.f8512a.d("commonPoiData");
                return;
            }
            ContextData contextData = new ContextData(VuiModelType.NAVIGATION, MzContactsContract.MzContactColumns.ADDRESS);
            boolean z = false;
            for (int i = 0; i < freqVisitedAddress.size(); i++) {
                PoiResult poiResult = freqVisitedAddress.get(i);
                if (i != 0 || TextUtils.isEmpty(poiResult.getName())) {
                    if (i == 1 && !TextUtils.isEmpty(poiResult.getName())) {
                        NavCommonPoiInfo.CommonAddr commonAddr = new NavCommonPoiInfo.CommonAddr();
                        commonAddr.setName(poiResult.getName());
                        commonAddr.setLatitude(poiResult.getLatitude());
                        commonAddr.setLongitude(poiResult.getLongitude());
                        contextData.appendPayload("company", commonAddr);
                    }
                } else {
                    NavCommonPoiInfo.CommonAddr commonAddr2 = new NavCommonPoiInfo.CommonAddr();
                    commonAddr2.setName(poiResult.getName());
                    commonAddr2.setLatitude(poiResult.getLatitude());
                    commonAddr2.setLongitude(poiResult.getLongitude());
                    contextData.appendPayload("home", commonAddr2);
                }
                z = true;
            }
            if (z) {
                NluContextDataMaintainer.f8512a.a("commonPoiData", contextData);
            } else {
                NluContextDataMaintainer.f8512a.d("commonPoiData");
            }
        }
    }

    public void f(String str) {
        List<PoiResult> freqVisitedAddress = SuperAppAbilityManager.e().f().getFreqVisitedAddress();
        this.f8687a = freqVisitedAddress;
        NavHelper.a(freqVisitedAddress, 1);
        NavManager.j().y(str);
    }

    public boolean g(VuiModel vuiModel) {
        int i = 0;
        if (this.f8687a == null) {
            ILog.a("CustomizedNavManager", "定制唤醒导航POI列表为空，不拦截");
            return false;
        }
        JSONObject payload = vuiModel.getPayload();
        String string = payload.getString("directive");
        int intValue = payload.getIntValue("index");
        if (!TextUtils.isEmpty(string)) {
            ILog.j("CustomizedNavManager", "select address for " + string);
            if (string.equals("navigation_home")) {
                i = 1;
            } else if (string.equals("navigation_office")) {
                i = 2;
            }
        }
        d(intValue, i);
        return true;
    }

    public void h(String str, String str2) {
        if (VuiModelType.NAVIGATION.equalsIgnoreCase(str2) && !VuiModelType.NAVIGATION.equalsIgnoreCase(str)) {
            ILog.a("CustomizedNavManager", "enter navi domain, cur domain = " + str2 + ", last domain = " + str);
            NavManager.j().y("");
        } else if (VuiModelType.NAVIGATION.equalsIgnoreCase(str) && !VuiModelType.NAVIGATION.equalsIgnoreCase(str2)) {
            ILog.a("CustomizedNavManager", "exit navi domain, cur domain = " + str2 + ", last domain = " + str);
            b();
        }
    }

    @Subscribe
    public void onReceiveUserAbortEvent(UserAbortEvent userAbortEvent) {
        ILog.a("CustomizedNavManager", "onReceiveUserAbortEvent and reset navi data");
        b();
    }
}
