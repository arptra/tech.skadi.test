package com.xjsd.ai.assistant.nlu.bean;

import java.util.List;

public class NluRequest {
    private List<ContextData> context;
    private HeaderData header;
    private MetaData metadata;
    private PayloadData payload;

    public List<ContextData> getContext() {
        return this.context;
    }

    public HeaderData getHeader() {
        return this.header;
    }

    public MetaData getMetadata() {
        return this.metadata;
    }

    public PayloadData getPayload() {
        return this.payload;
    }

    public NluRequest setContext(List<ContextData> list) {
        this.context = list;
        return this;
    }

    public void setHeader(HeaderData headerData) {
        this.header = headerData;
    }

    public void setMetadata(MetaData metaData) {
        this.metadata = metaData;
    }

    public void setPayload(PayloadData payloadData) {
        this.payload = payloadData;
    }
}
