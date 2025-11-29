package com.xjsd.ai.assistant.protocol.wechat;

import java.io.Serializable;

public class WechatLinkManSingleInfo implements Serializable {
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }
}
