package com.upuphone.starrynet.strategy.discovery.fastpair.localfastpair.event;

public class FastPairOperateEvent {
    public static final int ACTION_ACTIVITY_STARTED = 4;
    public static final int ACTION_CANCEL = 1;
    public static final int ACTION_CONNECT = 0;
    public static final int ACTION_INSTALL_SUPER_APP = 3;
    public static final int ACTION_START_SUPER_APP = 2;
    private int action;

    public FastPairOperateEvent(int i) {
        this.action = i;
    }

    public int getAction() {
        return this.action;
    }

    public void setAction(int i) {
        this.action = i;
    }

    public FastPairOperateEvent() {
    }
}
