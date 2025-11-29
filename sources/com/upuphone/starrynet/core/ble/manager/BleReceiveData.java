package com.upuphone.starrynet.core.ble.manager;

import com.upuphone.starrynet.core.ble.channel.ChannelTag;
import java.util.UUID;

public class BleReceiveData {
    private byte[] data;
    private UUID fromUUID;
    private boolean isClient;
    private String remoteBleMac;
    private ChannelTag tag;

    public BleReceiveData(boolean z, String str, UUID uuid, byte[] bArr) {
        this.isClient = z;
        this.remoteBleMac = str;
        this.fromUUID = uuid;
        this.data = bArr;
        this.tag = new ChannelTag(str, uuid);
    }

    public byte[] getData() {
        return this.data;
    }

    public UUID getFromUUID() {
        return this.fromUUID;
    }

    public String getRemoteBleMac() {
        return this.remoteBleMac;
    }

    public ChannelTag getTag() {
        return this.tag;
    }

    public boolean isClient() {
        return this.isClient;
    }

    public int isCtr() {
        byte[] bArr = this.data;
        if (bArr.length > 2 && bArr[0] == 0 && bArr[1] == 0) {
            return bArr[2];
        }
        return -1;
    }
}
