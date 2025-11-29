package com.xjsd.ai.assistant.protocol.stks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StksShotResult {
    private String apkPackageName;
    private String appName;
    private String asr;
    private String extra;
    private String func;
    private String id;
    private String key;
    private Integer micPosition;
    private String sceneId;
    private String screenPosition;
    private String vType;
    private String value;
    private String vrCallback;
    private boolean wakeup;

    public String getApkPackageName() {
        return this.apkPackageName;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getAsr() {
        return this.asr;
    }

    public String getExtra() {
        return this.extra;
    }

    public String getFunc() {
        return this.func;
    }

    public String getId() {
        return this.id;
    }

    public String getKey() {
        return this.key;
    }

    public Integer getMicPosition() {
        return this.micPosition;
    }

    public String getSceneId() {
        return this.sceneId;
    }

    public String getScreenPosition() {
        return this.screenPosition;
    }

    public String getValue() {
        return this.value;
    }

    public String getVrCallback() {
        return this.vrCallback;
    }

    public String getvType() {
        return this.vType;
    }

    @JsonIgnore
    public boolean isWakeup() {
        return this.wakeup;
    }

    public void setApkPackageName(String str) {
        this.apkPackageName = str;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setAsr(String str) {
        this.asr = str;
    }

    public void setExtra(String str) {
        this.extra = str;
    }

    public void setFunc(String str) {
        this.func = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setMicPosition(Integer num) {
        this.micPosition = num;
    }

    public void setSceneId(String str) {
        this.sceneId = str;
    }

    public void setScreenPosition(String str) {
        this.screenPosition = str;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public void setVrCallback(String str) {
        this.vrCallback = str;
    }

    public void setWakeup(boolean z) {
        this.wakeup = z;
    }

    public void setvType(String str) {
        this.vType = str;
    }
}
