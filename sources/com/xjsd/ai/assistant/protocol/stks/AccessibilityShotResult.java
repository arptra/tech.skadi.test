package com.xjsd.ai.assistant.protocol.stks;

import androidx.annotation.NonNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccessibilityShotResult {
    private String operate;
    private String targetText;

    public String getOperate() {
        return this.operate;
    }

    public String getTargetText() {
        return this.targetText;
    }

    public void setOperate(String str) {
        this.operate = str;
    }

    public void setTargetText(String str) {
        this.targetText = str;
    }

    @NonNull
    public String toString() {
        return "AccessibilityShotResult{operate=\"" + this.operate + "\", targetText=\"" + this.targetText + "\"}";
    }
}
