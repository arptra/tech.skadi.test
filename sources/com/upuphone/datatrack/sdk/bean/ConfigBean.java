package com.upuphone.datatrack.sdk.bean;

import androidx.annotation.Keep;
import java.util.List;

@Keep
public class ConfigBean {
    private boolean active;
    private List<EventBean> events;
    private int heartbeatInterval;
    private String key;
    private int positioningInterval;
    private String primaryPackageName;
    private boolean sampling;
    private List<String> sensitiveFields;
    private int ttl;
    private UploadPolicyBean uploadPolicy;
    private int version;

    public boolean getActive() {
        return this.active;
    }

    public List<EventBean> getEvents() {
        return this.events;
    }

    public int getHeartbeatInterval() {
        return this.heartbeatInterval;
    }

    public String getKey() {
        return this.key;
    }

    public int getPositioningInterval() {
        return this.positioningInterval;
    }

    public String getPrimaryPackageName() {
        return this.primaryPackageName;
    }

    public boolean getSampling() {
        return this.sampling;
    }

    public List<String> getSensitiveFields() {
        return this.sensitiveFields;
    }

    public int getTtl() {
        return this.ttl;
    }

    public UploadPolicyBean getUploadPolicy() {
        return this.uploadPolicy;
    }

    public int getVersion() {
        return this.version;
    }

    public void setActive(boolean z) {
        this.active = z;
    }

    public void setEvents(List<EventBean> list) {
        this.events = list;
    }

    public void setHeartbeatInterval(int i) {
        this.heartbeatInterval = i;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setPositioningInterval(int i) {
        this.positioningInterval = i;
    }

    public void setPrimaryPackageName(String str) {
        this.primaryPackageName = str;
    }

    public void setSampling(boolean z) {
        this.sampling = z;
    }

    public void setSensitiveFields(List<String> list) {
        this.sensitiveFields = list;
    }

    public void setTtl(int i) {
        this.ttl = i;
    }

    public void setUploadPolicy(UploadPolicyBean uploadPolicyBean) {
        this.uploadPolicy = uploadPolicyBean;
    }

    public void setVersion(int i) {
        this.version = i;
    }
}
