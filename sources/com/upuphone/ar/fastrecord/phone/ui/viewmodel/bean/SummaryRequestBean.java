package com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean;

import java.io.Serializable;

public class SummaryRequestBean implements Serializable {
    private String accountId;
    private String appName;
    private String recognizeId;
    private Long recordId;
    private String requestId;
    private String shortHandTitle;
    private String traceId;

    public String getAccountId() {
        return this.accountId;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getRecognizeId() {
        return this.recognizeId;
    }

    public Long getRecordId() {
        return this.recordId;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public String getShortHandTitle() {
        return this.shortHandTitle;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public void setAccountId(String str) {
        this.accountId = str;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setRecognizeId(String str) {
        this.recognizeId = str;
    }

    public void setRecordId(Long l) {
        this.recordId = l;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public void setShortHandTitle(String str) {
        this.shortHandTitle = str;
    }

    public void setTraceId(String str) {
        this.traceId = str;
    }

    public String toString() {
        return "SummaryRequestBean{appName='" + this.appName + '\'' + ", recognizeId='" + this.recognizeId + '\'' + ", accountId='" + this.accountId + '\'' + ", requestId='" + this.requestId + '\'' + ", traceId='" + this.traceId + '\'' + ", shortHandTitle='" + this.shortHandTitle + '\'' + '}';
    }
}
