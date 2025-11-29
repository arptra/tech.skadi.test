package com.xjsd.ai.assistant.stks.dto;

public class STKSResponse {
    private String apkName;
    private String apkPackageName;
    private String asr;
    private String extra;
    private String func;
    private String id;
    private String sceneId;
    private Object value;

    public String getApkName() {
        return this.apkName;
    }

    public String getApkPackageName() {
        return this.apkPackageName;
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

    public String getSceneId() {
        return this.sceneId;
    }

    public Object getValue() {
        return this.value;
    }

    public void setApkName(String str) {
        this.apkName = str;
    }

    public void setApkPackageName(String str) {
        this.apkPackageName = str;
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

    public void setSceneId(String str) {
        this.sceneId = str;
    }

    public void setValue(Object obj) {
        this.value = obj;
    }

    public String toString() {
        return "STKSResponse{appName='" + this.apkName + '\'' + ", apkPackageName='" + this.apkPackageName + '\'' + ", asr='" + this.asr + '\'' + ", sceneId='" + this.sceneId + '\'' + ", id='" + this.id + '\'' + ", func='" + this.func + '\'' + ", value=" + this.value + ", extra='" + this.extra + '\'' + '}';
    }
}
