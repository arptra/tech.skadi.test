package com.upuphone.runasone.relay.lib.bean;

import com.upuphone.runasone.relay.StarryTag;

public class CallBackData {
    private StarryTag starryTag;
    private String uniqueKey;
    private boolean using;

    public CallBackData(StarryTag starryTag2, String str) {
        this.starryTag = starryTag2;
        this.uniqueKey = str;
    }

    public StarryTag getStarryTag() {
        return this.starryTag;
    }

    public String getUniqueKey() {
        return this.uniqueKey;
    }

    public boolean isUsing() {
        return this.using;
    }

    public void setStarryTag(StarryTag starryTag2) {
        this.starryTag = starryTag2;
    }

    public void setUniqueKey(String str) {
        this.uniqueKey = str;
    }

    public void setUsing(boolean z) {
        this.using = z;
    }
}
