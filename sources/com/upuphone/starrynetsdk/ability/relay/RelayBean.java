package com.upuphone.starrynetsdk.ability.relay;

import java.util.List;

public class RelayBean {
    private byte[] data;
    private String host;
    private int listenerId;
    private int qos;
    private String targetDeviceId;
    private String targetUniteCode;
    private List<String> targetUniteCodeList;
    private int type;

    public static RelayBean obtain() {
        return new RelayBean();
    }

    public byte[] getData() {
        return this.data;
    }

    public String getHost() {
        return this.host;
    }

    public int getListenerId() {
        return this.listenerId;
    }

    public int getQos() {
        return this.qos;
    }

    public String getTargetDeviceId() {
        return this.targetDeviceId;
    }

    public String getTargetUniteCode() {
        return this.targetUniteCode;
    }

    public List<String> getTargetUniteCodeList() {
        return this.targetUniteCodeList;
    }

    public int getType() {
        return this.type;
    }

    public RelayBean setData(byte[] bArr) {
        this.data = bArr;
        return this;
    }

    public RelayBean setHost(String str) {
        this.host = str;
        return this;
    }

    public void setListenerId(int i) {
        this.listenerId = i;
    }

    public RelayBean setQos(int i) {
        this.qos = i;
        return this;
    }

    public RelayBean setTargetDeviceId(String str) {
        this.targetDeviceId = str;
        return this;
    }

    public RelayBean setTargetUniteCode(String str) {
        this.targetUniteCode = str;
        return this;
    }

    public void setTargetUniteCodeList(List<String> list) {
        this.targetUniteCodeList = list;
    }

    public void setType(int i) {
        this.type = i;
    }
}
