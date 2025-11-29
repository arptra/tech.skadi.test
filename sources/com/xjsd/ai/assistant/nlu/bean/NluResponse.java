package com.xjsd.ai.assistant.nlu.bean;

import com.alibaba.fastjson.JSONObject;

public class NluResponse {
    HeaderData header;
    MetaData metadata;
    private JSONObject payload;
    private String sessionId;
    private String source = "kongming";

    public HeaderData getHeader() {
        return this.header;
    }

    public MetaData getMetadata() {
        return this.metadata;
    }

    public JSONObject getPayload() {
        return this.payload;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String getSource() {
        return this.source;
    }

    public void setHeader(HeaderData headerData) {
        this.header = headerData;
    }

    public void setMetadata(MetaData metaData) {
        this.metadata = metaData;
    }

    public void setPayload(JSONObject jSONObject) {
        this.payload = jSONObject;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public void setSource(String str) {
        this.source = str;
    }
}
