package com.upuphone.runasone.channel.bean.stream;

public class QosBean {
    private int qos;
    private String timeStamp;

    public int getQos() {
        return this.qos;
    }

    public String getTimeStamp() {
        return this.timeStamp;
    }

    public void setQos(int i) {
        this.qos = i;
    }

    public void setTimeStamp(String str) {
        this.timeStamp = str;
    }
}
