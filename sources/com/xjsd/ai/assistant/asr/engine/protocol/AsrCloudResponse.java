package com.xjsd.ai.assistant.asr.engine.protocol;

import androidx.annotation.Keep;

@Keep
public class AsrCloudResponse {
    private String code;
    private AsrData data;
    private String event;
    private Boolean finish;
    private String msg;
    private String requestId;
    private String time;
    private VadInfo vadInfo;

    public String getCode() {
        return this.code;
    }

    public AsrData getData() {
        return this.data;
    }

    public String getEvent() {
        return this.event;
    }

    public Boolean getFinish() {
        return this.finish;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public String getTime() {
        return this.time;
    }

    public VadInfo getVadInfo() {
        return this.vadInfo;
    }

    public AsrCloudResponse setCode(String str) {
        this.code = str;
        return this;
    }

    public AsrCloudResponse setData(AsrData asrData) {
        this.data = asrData;
        return this;
    }

    public AsrCloudResponse setEvent(String str) {
        this.event = str;
        return this;
    }

    public AsrCloudResponse setFinish(Boolean bool) {
        this.finish = bool;
        return this;
    }

    public AsrCloudResponse setMsg(String str) {
        this.msg = str;
        return this;
    }

    public AsrCloudResponse setRequestId(String str) {
        this.requestId = str;
        return this;
    }

    public AsrCloudResponse setTime(String str) {
        this.time = str;
        return this;
    }

    public AsrCloudResponse setVadInfo(VadInfo vadInfo2) {
        this.vadInfo = vadInfo2;
        return this;
    }
}
