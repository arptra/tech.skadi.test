package com.upuphone.starrynetsdk.ability.relay;

public class HandlerData {
    private RemoteListener listener;
    private RelayBean relayBean;
    private boolean using;

    public HandlerData(RelayBean relayBean2, RemoteListener remoteListener) {
        this.relayBean = relayBean2;
        this.listener = remoteListener;
    }

    public RemoteListener getListener() {
        return this.listener;
    }

    public RelayBean getRelayBean() {
        return this.relayBean;
    }

    public boolean isUsing() {
        return this.using;
    }

    public void setListener(RemoteListener remoteListener) {
        this.listener = remoteListener;
    }

    public void setRelayBean(RelayBean relayBean2) {
        this.relayBean = relayBean2;
    }

    public void setUsing(boolean z) {
        this.using = z;
    }
}
