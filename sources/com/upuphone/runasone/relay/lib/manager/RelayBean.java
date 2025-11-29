package com.upuphone.runasone.relay.lib.manager;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class RelayBean {
    boolean isSupportMapping;
    private List<String> metaInfo;
    private ConcurrentHashMap<String, Integer> metaMap;

    public List<String> getMetaInfo() {
        return this.metaInfo;
    }

    public ConcurrentHashMap<String, Integer> getMetaMap() {
        return this.metaMap;
    }

    public boolean isSupportMapping() {
        return this.isSupportMapping;
    }

    public void setMetaInfo(List<String> list) {
        this.metaInfo = list;
    }

    public void setMetaMap(ConcurrentHashMap<String, Integer> concurrentHashMap) {
        this.metaMap = concurrentHashMap;
    }

    public void setSupportMapping(boolean z) {
        this.isSupportMapping = z;
    }
}
