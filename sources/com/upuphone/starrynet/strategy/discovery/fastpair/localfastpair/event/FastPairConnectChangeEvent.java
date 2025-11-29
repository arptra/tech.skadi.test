package com.upuphone.starrynet.strategy.discovery.fastpair.localfastpair.event;

public class FastPairConnectChangeEvent {
    private int errorCode;
    private final int status;

    public FastPairConnectChangeEvent(int i) {
        this.status = i;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public int getStatus() {
        return this.status;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }
}
