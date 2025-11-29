package com.xjsd.ai.assistant.core.bean;

import androidx.annotation.Keep;
import java.io.Serializable;

@Keep
public class SessionData implements Serializable {
    private String sessionId;

    public String getSessionId() {
        return this.sessionId;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }
}
