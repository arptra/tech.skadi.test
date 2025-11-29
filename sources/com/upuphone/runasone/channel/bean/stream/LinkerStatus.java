package com.upuphone.runasone.channel.bean.stream;

public class LinkerStatus {
    private long inputSize;
    private boolean isRemoteServer = false;
    private String linkerName;
    private long outputSize;
    private int qos;
    private String startTime;
    private String type;

    public long getInputSize() {
        return this.inputSize;
    }

    public String getLinkerName() {
        return this.linkerName;
    }

    public long getOutputSize() {
        return this.outputSize;
    }

    public int getQos() {
        return this.qos;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public String getType() {
        return this.type;
    }

    public boolean isRemoteServer() {
        return this.isRemoteServer;
    }

    public void setInputSize(long j) {
        this.inputSize = j;
    }

    public void setLinkerName(String str) {
        this.linkerName = str;
    }

    public void setOutputSize(long j) {
        this.outputSize = j;
    }

    public void setQos(int i) {
        this.qos = i;
    }

    public void setRemoteServer(boolean z) {
        this.isRemoteServer = z;
    }

    public void setStartTime(String str) {
        this.startTime = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
