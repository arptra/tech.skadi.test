package com.upuphone.starrynet.payload.ring;

public class MessageContent {
    public static final int ERROR_CODE_OK = 0;
    private byte[] data;
    private int msgType;

    public byte[] getData() {
        return this.data;
    }

    public int getMsgType() {
        return this.msgType;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }

    public void setMsgType(int i) {
        this.msgType = i;
    }
}
