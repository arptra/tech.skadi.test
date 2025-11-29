package com.upuphone.runasone.host.core.api;

import com.google.protobuf.Message;

public class AbilityMessage<T extends Message> {
    private byte[] bypassBytes;
    private String characterUuid;
    private MessageType messageType;
    private int msgType;
    private Qos qos;
    private String serviceUuid;

    public enum MessageType {
        NORMAL(0),
        SIMPLIFIED(1),
        AIR(2);
        
        private int type;

        private MessageType(int i) {
            this.type = i;
        }
    }

    public enum Qos {
        AM_QOS_0,
        AM_QOS_1,
        AM_QOS_2,
        AM_QOS_3
    }

    public AbilityMessage(byte[] bArr) {
        this.bypassBytes = bArr;
        this.qos = Qos.AM_QOS_0;
        this.messageType = MessageType.NORMAL;
    }

    public byte[] getBypass() {
        return this.bypassBytes;
    }

    public String getCharacterUuid() {
        return this.characterUuid;
    }

    public MessageType getMessageType() {
        return this.messageType;
    }

    public int getMsgType() {
        return this.msgType;
    }

    public Qos getQos() {
        return this.qos;
    }

    public String getServiceUuid() {
        return this.serviceUuid;
    }

    public boolean isBypass() {
        return true;
    }

    public AbilityMessage(byte[] bArr, MessageType messageType2) {
        this.bypassBytes = bArr;
        this.messageType = messageType2;
        this.qos = Qos.AM_QOS_0;
    }

    public AbilityMessage(byte[] bArr, MessageType messageType2, Qos qos2) {
        this.bypassBytes = bArr;
        this.messageType = messageType2;
        this.qos = qos2;
    }

    public AbilityMessage(byte[] bArr, Qos qos2) {
        this.bypassBytes = bArr;
        this.qos = qos2;
        this.messageType = MessageType.NORMAL;
    }

    public AbilityMessage(String str, String str2, int i, byte[] bArr) {
        this.serviceUuid = str;
        this.characterUuid = str2;
        this.bypassBytes = bArr;
        this.msgType = i;
        this.messageType = MessageType.SIMPLIFIED;
        this.qos = Qos.AM_QOS_0;
    }
}
