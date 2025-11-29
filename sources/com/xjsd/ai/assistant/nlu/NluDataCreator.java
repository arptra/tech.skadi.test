package com.xjsd.ai.assistant.nlu;

import com.alibaba.fastjson.JSONObject;
import com.xjsd.ai.assistant.nlu.bean.HeaderData;
import com.xjsd.ai.assistant.nlu.bean.NluResponse;
import com.xjsd.ai.assistant.protocol.VuiModelType;

public class NluDataCreator {
    public static NluResponse a(String str) {
        HeaderData headerData = new HeaderData();
        headerData.setNamespace(VuiModelType.VSP_ERROR);
        headerData.setName(VuiModelType.VSP_ERROR);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", (Object) str);
        NluResponse nluResponse = new NluResponse();
        nluResponse.setHeader(headerData);
        nluResponse.setPayload(jSONObject);
        return nluResponse;
    }
}
