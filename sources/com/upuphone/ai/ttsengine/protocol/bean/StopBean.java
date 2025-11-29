package com.upuphone.ai.ttsengine.protocol.bean;

import androidx.annotation.Keep;
import java.util.Objects;

@Keep
public class StopBean {
    private String caller = null;
    private String id = null;
    private int priority = 2;
    private int type = 3;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        StopBean stopBean = (StopBean) obj;
        return this.priority == stopBean.priority && this.type == stopBean.type && Objects.equals(this.caller, stopBean.caller) && Objects.equals(this.id, stopBean.id);
    }

    public String getCaller() {
        return this.caller;
    }

    public String getId() {
        return this.id;
    }

    public int getPriority() {
        return this.priority;
    }

    public int getType() {
        return this.type;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.caller, Integer.valueOf(this.priority), Integer.valueOf(this.type), this.id});
    }

    public void setCaller(String str) {
        this.caller = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setPriority(int i) {
        this.priority = i;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String toString() {
        return "StopBean{caller='" + this.caller + '\'' + ", priority=" + this.priority + ", type=" + this.type + ", id='" + this.id + '\'' + '}';
    }
}
