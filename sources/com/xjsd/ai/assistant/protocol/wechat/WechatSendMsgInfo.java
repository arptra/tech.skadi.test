package com.xjsd.ai.assistant.protocol.wechat;

import java.io.Serializable;

public class WechatSendMsgInfo implements Serializable {
    private String action;
    private String content;
    private String target;

    public String getAction() {
        return this.action;
    }

    public String getContent() {
        return this.content;
    }

    public String getTarget() {
        return this.target;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setTarget(String str) {
        this.target = str;
    }
}
