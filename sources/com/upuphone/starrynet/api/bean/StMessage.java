package com.upuphone.starrynet.api.bean;

public class StMessage {
    private String bleMac;
    private int characterCategory;
    private byte[] content;
    private String deviceId;
    private byte[] identifier;
    private boolean isUrgentMessage;
    private int targetChannel;

    private StMessage() {
        this.isUrgentMessage = false;
        this.targetChannel = 1;
    }

    public static StMessage buildReceiveStMessage(String str, byte[] bArr, boolean z, int i) {
        StMessage stMessage = new StMessage();
        stMessage.bleMac = str;
        stMessage.content = bArr;
        stMessage.isUrgentMessage = z;
        stMessage.characterCategory = i;
        return stMessage;
    }

    public String getBleMac() {
        return this.bleMac;
    }

    public int getCharacterCategory() {
        return this.characterCategory;
    }

    public byte[] getContent() {
        return this.content;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public byte[] getIdentifier() {
        return this.identifier;
    }

    public int getTargetChannel() {
        return this.targetChannel;
    }

    public boolean isUrgentMessage() {
        return this.isUrgentMessage;
    }

    public void setBleMac(String str) {
        this.bleMac = str;
    }

    public void setCharacterCategory(int i) {
        this.characterCategory = i;
    }

    public void setContent(byte[] bArr) {
        this.content = bArr;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setIdentifier(byte[] bArr) {
        this.identifier = bArr;
    }

    public void setTargetChannel(int i) {
        this.targetChannel = i;
    }

    public StMessage(byte[] bArr, String str, byte[] bArr2, boolean z) {
        this.targetChannel = 1;
        this.identifier = bArr;
        this.bleMac = str;
        this.content = bArr2;
        this.isUrgentMessage = z;
    }
}
