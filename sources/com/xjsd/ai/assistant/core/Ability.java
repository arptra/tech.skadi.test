package com.xjsd.ai.assistant.core;

public interface Ability {
    boolean isProxyInstance() {
        return getClass().getName().contains("$Proxy");
    }

    void register() {
        AbilityManager.b.c(this);
    }
}
