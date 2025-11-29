package com.upuphone.starrynetsdk.ability.relay;

import java.util.List;

public class ListenerBean {
    private List<String> list;
    private RelayListener listener;
    private int listenerId;

    public List<String> getList() {
        return this.list;
    }

    public RelayListener getListener() {
        return this.listener;
    }

    public int getListenerId() {
        return this.listenerId;
    }

    public void setList(List<String> list2) {
        this.list = list2;
    }

    public void setListener(RelayListener relayListener) {
        this.listener = relayListener;
    }

    public void setListenerId(int i) {
        this.listenerId = i;
    }
}
