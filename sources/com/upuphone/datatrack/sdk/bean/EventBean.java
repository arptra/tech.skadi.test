package com.upuphone.datatrack.sdk.bean;

import androidx.annotation.Keep;

@Keep
public class EventBean {
    private boolean active;
    private String name;
    private boolean neartime;
    private boolean realtime;

    public boolean getActive() {
        return this.active;
    }

    public String getName() {
        return this.name;
    }

    public boolean getNeartime() {
        return this.neartime;
    }

    public boolean getRealtime() {
        return this.realtime;
    }

    public void setActive(boolean z) {
        this.active = z;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNeartime(boolean z) {
        this.neartime = z;
    }

    public void setRealtime(boolean z) {
        this.realtime = z;
    }
}
