package com.xjsd.ai.assistant.nlu.bean;

import java.util.List;

public class HeaderData {
    private List<String> associatedConfigId;
    private String id;
    private String msgId;
    private String name;
    private String namespace;
    private String terminalTraceId;

    public List<String> getAssociatedConfigId() {
        return this.associatedConfigId;
    }

    public String getId() {
        return this.id;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public String getName() {
        return this.name;
    }

    public String getNamespace() {
        return this.namespace;
    }

    public String getTerminalTraceId() {
        return this.terminalTraceId;
    }

    public void setAssociatedConfigId(List<String> list) {
        this.associatedConfigId = list;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setMsgId(String str) {
        this.msgId = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNamespace(String str) {
        this.namespace = str;
    }

    public void setTerminalTraceId(String str) {
        this.terminalTraceId = str;
    }
}
