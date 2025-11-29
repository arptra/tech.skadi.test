package com.xjsd.ai.assistant.stks.dto;

import java.util.Set;

public class STKSDto {
    private String apkName;
    private String apkPackageName;
    private Set<HotWord> data;
    private String sceneId;
    private Integer version;

    public String getApkName() {
        return this.apkName;
    }

    public String getApkPackageName() {
        return this.apkPackageName;
    }

    public Set<HotWord> getData() {
        return this.data;
    }

    public String getSceneId() {
        return this.sceneId;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setApkName(String str) {
        this.apkName = str;
    }

    public void setApkPackageName(String str) {
        this.apkPackageName = str;
    }

    public void setData(Set<HotWord> set) {
        this.data = set;
    }

    public void setSceneId(String str) {
        this.sceneId = str;
    }

    public void setVersion(Integer num) {
        this.version = num;
    }
}
