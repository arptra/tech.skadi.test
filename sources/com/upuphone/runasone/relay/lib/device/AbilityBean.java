package com.upuphone.runasone.relay.lib.device;

import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.host.core.api.IAbilitySlot;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AbilityBean {
    private Map<Integer, String> codeMap = new ConcurrentHashMap();
    private StarryDevice device;
    private boolean isRemoved = false;
    private List<String> keyList;
    private Map<String, Integer> metaMap = new ConcurrentHashMap();
    private IAbilitySlot.SlotObserver observer;
    private String uuid;

    public Map<Integer, String> getCodeMap() {
        return this.codeMap;
    }

    public StarryDevice getDevice() {
        return this.device;
    }

    public List<String> getKeyList() {
        return this.keyList;
    }

    public Map<String, Integer> getMetaMap() {
        return this.metaMap;
    }

    public IAbilitySlot.SlotObserver getObserver() {
        return this.observer;
    }

    public String getUuid() {
        return this.uuid;
    }

    public boolean isRemoved() {
        return this.isRemoved;
    }

    public void setCodeMap(Map<Integer, String> map) {
        this.codeMap = map;
    }

    public void setDevice(StarryDevice starryDevice) {
        this.device = starryDevice;
    }

    public void setKeyList(List<String> list) {
        this.keyList = list;
    }

    public void setMetaMap(Map<String, Integer> map) {
        this.metaMap = map;
    }

    public void setObserver(IAbilitySlot.SlotObserver slotObserver) {
        this.observer = slotObserver;
    }

    public void setRemoved(boolean z) {
        this.isRemoved = z;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }
}
