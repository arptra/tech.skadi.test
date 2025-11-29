package com.xjsd.ai.assistant.phone.vui;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.xjsd.ai.assistant.common.handler.VuiHandler;
import com.xjsd.ai.assistant.core.ContextHelper;
import com.xjsd.ai.assistant.core.api.tts.TtsData;
import com.xjsd.ai.assistant.phone.R;
import com.xjsd.ai.assistant.phone.SuperAppAbilityManager;
import com.xjsd.ai.assistant.phone.tts.TtsManager;
import com.xjsd.ai.assistant.protocol.VuiModel;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import java.util.HashMap;
import java.util.Map;

public class ApplicationVuiHandler implements VuiHandler {

    /* renamed from: a  reason: collision with root package name */
    public final Map f8622a;

    public ApplicationVuiHandler() {
        HashMap hashMap = new HashMap();
        this.f8622a = hashMap;
        hashMap.put("生活圈", SuperAppAbilityManager.SAppAbilityEnum.AR_LIFE);
        hashMap.put("同传互译", SuperAppAbilityManager.SAppAbilityEnum.TRANSLATION);
        hashMap.put("AR名片", SuperAppAbilityManager.SAppAbilityEnum.AR_CARD);
    }

    public boolean a(VuiModel vuiModel) {
        String str;
        String str2;
        JSONObject payload = vuiModel.getPayload();
        String string = payload.getString("app_name");
        if (!this.f8622a.containsKey(string)) {
            return false;
        }
        String string2 = payload.getString("app_operation");
        String id = vuiModel.getUtterance().getId();
        SuperAppAbilityManager e = SuperAppAbilityManager.e();
        SuperAppAbilityManager.SAppAbilityEnum sAppAbilityEnum = (SuperAppAbilityManager.SAppAbilityEnum) this.f8622a.get(string);
        if (TextUtils.equals(string2, "close")) {
            if (!e.h(sAppAbilityEnum)) {
                e.d(sAppAbilityEnum);
            }
            str = ContextHelper.b(R.string.tts_common_is_close, new Object[0]);
            str2 = "APP02_P02";
        } else if (TextUtils.equals(string2, "open")) {
            if (!e.h(sAppAbilityEnum)) {
                e.j(sAppAbilityEnum);
            }
            str = ContextHelper.b(R.string.tts_common_is_open, new Object[0]);
            str2 = "APP02_P01";
        } else {
            str = "";
            str2 = str;
        }
        TtsData ttsData = new TtsData();
        ttsData.setText(str);
        ttsData.setNlgId(id);
        ttsData.setFunctionId(str2);
        TtsManager.g.f(ttsData);
        return true;
    }

    public String getHandleType() {
        return VuiModelType.APPLICATION;
    }
}
