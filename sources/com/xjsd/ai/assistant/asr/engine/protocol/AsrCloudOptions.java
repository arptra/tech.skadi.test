package com.xjsd.ai.assistant.asr.engine.protocol;

import androidx.annotation.Keep;
import com.xjsd.ai.assistant.asr.util.InputLanguage;
import java.io.Serializable;

@Keep
public class AsrCloudOptions implements Serializable {
    String accountId;
    AsrAudioInfo data;
    String deviceId;
    String event;
    @InputLanguage
    String inputLanguageCode;
    String iotDeviceId;
    String requestId;
    String targetLanguageCode;

    public String getAccountId() {
        return this.accountId;
    }

    public AsrAudioInfo getData() {
        return this.data;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getEvent() {
        return this.event;
    }

    public String getInputLanguageCode() {
        return this.inputLanguageCode;
    }

    public String getIotDeviceId() {
        return this.iotDeviceId;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public String getTargetLanguageCode() {
        return this.targetLanguageCode;
    }

    public void setAccountId(String str) {
        this.accountId = str;
    }

    public AsrCloudOptions setData(AsrAudioInfo asrAudioInfo) {
        this.data = asrAudioInfo;
        return this;
    }

    public AsrCloudOptions setDeviceId(String str) {
        this.deviceId = str;
        return this;
    }

    public AsrCloudOptions setEvent(String str) {
        this.event = str;
        return this;
    }

    public void setInputLanguageCode(String str) {
        this.inputLanguageCode = str;
    }

    public void setIotDeviceId(String str) {
        this.iotDeviceId = str;
    }

    public AsrCloudOptions setRequestId(String str) {
        this.requestId = str;
        return this;
    }

    public void setTargetLanguageCode(@InputLanguage String str) {
        this.targetLanguageCode = str;
    }
}
