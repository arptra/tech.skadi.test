package com.xjsd.ai.assistant.phone.helper;

import com.alibaba.fastjson.JSONObject;
import com.xjsd.ai.assistant.nlu.bean.HeaderData;
import com.xjsd.ai.assistant.nlu.bean.NluResponse;
import com.xjsd.ai.assistant.protocol.VuiModel;
import com.xjsd.ai.assistant.protocol.vui.Header;
import com.xjsd.ai.assistant.protocol.vui.MetaData;
import com.xjsd.ai.assistant.protocol.vui.Utterance;

public final class NluDataParser {
    public static VuiModel a(NluResponse nluResponse) {
        if (nluResponse == null) {
            return null;
        }
        HeaderData header = nluResponse.getHeader();
        JSONObject payload = nluResponse.getPayload();
        if (header == null || payload == null) {
            return null;
        }
        Header header2 = new Header();
        header2.setNamespace(header.getNamespace());
        header2.setName(header.getName());
        MetaData metaData = new MetaData();
        if (nluResponse.getMetadata() != null) {
            metaData.setMsgId(nluResponse.getMetadata().getMsgId());
        }
        Utterance utterance = new Utterance();
        if (payload.containsKey("utterance")) {
            JSONObject jSONObject = payload.getJSONObject("utterance");
            utterance.setScreen(jSONObject.getString("screen"));
            utterance.setSpeech(jSONObject.getString("speech"));
            utterance.setId(jSONObject.getString("id"));
        }
        VuiModel vuiModel = new VuiModel();
        vuiModel.setPayload(payload);
        vuiModel.setHeader(header2);
        vuiModel.setMetadata(metaData);
        vuiModel.setUtterance(utterance);
        return vuiModel;
    }
}
