package com.upuphone.ai.ttsengine.protocol.bean;

import androidx.annotation.Keep;
import java.util.Objects;

@Keep
public class StatusBean {
    private String caller = null;
    private int errorCode = 0;
    private String id = null;
    private int status = 0;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StatusBean)) {
            return false;
        }
        StatusBean statusBean = (StatusBean) obj;
        return getStatus() == statusBean.getStatus() && getCaller().equals(statusBean.getCaller()) && getId().equals(statusBean.getId());
    }

    public String getCaller() {
        return this.caller;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getId() {
        return this.id;
    }

    public int getStatus() {
        return this.status;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{getCaller(), getId(), Integer.valueOf(getStatus())});
    }

    public void setCaller(String str) {
        this.caller = str;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public String toString() {
        return "StatusBean{caller='" + this.caller + '\'' + ", id='" + this.id + '\'' + ", status=" + this.status + ", errorCode=" + this.errorCode + '}';
    }
}
