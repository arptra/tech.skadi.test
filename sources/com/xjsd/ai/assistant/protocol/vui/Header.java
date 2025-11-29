package com.xjsd.ai.assistant.protocol.vui;

import java.io.Serializable;

public class Header implements Serializable {
    private String name;
    private String namespace;
    private boolean specialCmdInChatGptScene = false;

    public String getName() {
        return this.name;
    }

    public String getNamespace() {
        return this.namespace;
    }

    public boolean isSpecialCmdInChatGptScene() {
        return this.specialCmdInChatGptScene;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNamespace(String str) {
        this.namespace = str;
    }

    public void setSpecialCmdInChatGptScene(boolean z) {
        this.specialCmdInChatGptScene = z;
    }

    public String toString() {
        return "DomainHeader{namespace='" + this.namespace + '\'' + ", name='" + this.name + '\'' + '}';
    }
}
