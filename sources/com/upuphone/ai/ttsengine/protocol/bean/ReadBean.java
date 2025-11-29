package com.upuphone.ai.ttsengine.protocol.bean;

import androidx.annotation.Keep;
import java.util.Map;
import java.util.Objects;

@Keep
public class ReadBean {
    private String caller = null;
    private int focusType = 3;
    private String functionId = null;
    private String id = null;
    private int language = -100;
    private String nlgId = null;
    private int priority = 2;
    private int queueMode = 0;
    private String read = null;
    private Map<String, String> slots = null;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ReadBean readBean = (ReadBean) obj;
        return this.priority == readBean.priority && this.queueMode == readBean.queueMode && this.focusType == readBean.focusType && Objects.equals(this.caller, readBean.caller) && Objects.equals(this.read, readBean.read) && Objects.equals(this.id, readBean.id) && Objects.equals(this.functionId, readBean.functionId) && Objects.equals(this.nlgId, readBean.nlgId) && Objects.equals(this.slots, readBean.slots) && Integer.valueOf(this.language).equals(Integer.valueOf(readBean.language));
    }

    public String getCaller() {
        return this.caller;
    }

    public int getFocusType() {
        return this.focusType;
    }

    public String getFunctionId() {
        return this.functionId;
    }

    public String getId() {
        return this.id;
    }

    public int getLanguage() {
        return this.language;
    }

    public String getNlgId() {
        return this.nlgId;
    }

    public int getPriority() {
        return this.priority;
    }

    public int getQueueMode() {
        return this.queueMode;
    }

    public String getRead() {
        return this.read;
    }

    public Map<String, String> getSlots() {
        return this.slots;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.caller, this.read, this.id, Integer.valueOf(this.priority), this.functionId, this.nlgId, this.slots, Integer.valueOf(this.queueMode), Integer.valueOf(this.focusType), Integer.valueOf(this.language)});
    }

    public void setCaller(String str) {
        this.caller = str;
    }

    public void setFocusType(int i) {
        this.focusType = i;
    }

    public void setFunctionId(String str) {
        this.functionId = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setLanguage(int i) {
        this.language = i;
    }

    public void setNlgId(String str) {
        this.nlgId = str;
    }

    public void setPriority(int i) {
        this.priority = i;
    }

    public void setQueueMode(int i) {
        this.queueMode = i;
    }

    public void setRead(String str) {
        this.read = str;
    }

    public void setSlots(Map<String, String> map) {
        this.slots = map;
    }

    public String toString() {
        return "ReadBean{caller='" + this.caller + '\'' + ", read='" + this.read + '\'' + ", id='" + this.id + '\'' + ", priority=" + this.priority + ", functionId='" + this.functionId + '\'' + ", nlgId='" + this.nlgId + '\'' + ", slots=" + this.slots + ", queueMode=" + this.queueMode + ", focusType=" + this.focusType + ", language=" + this.language + '}';
    }
}
