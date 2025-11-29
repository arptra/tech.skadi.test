package com.xjsd.ai.assistant.protocol.wakeup;

public class WakeupRes {
    private boolean hasNetwork;
    private String message;
    private String sessionId;
    private boolean success;

    public String getMessage() {
        return this.message;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public boolean isHasNetwork() {
        return this.hasNetwork;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setHasNetwork(boolean z) {
        this.hasNetwork = z;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }
}
