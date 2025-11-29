package com.upuphone.runasone.channel.proxy.client.tcpip;

import kotlin.UShort;

public class UDPHeader {
    static final short offset_crc = 6;
    static final short offset_dest_port = 2;
    static final short offset_src_port = 0;
    static final short offset_tlen = 4;
    public byte[] mData;
    public int mOffset;

    public UDPHeader(byte[] bArr, int i) {
        this.mData = bArr;
        this.mOffset = i;
    }

    public short getCrc() {
        return CommonMethods.readShort(this.mData, this.mOffset + 6);
    }

    public short getDestinationPort() {
        return CommonMethods.readShort(this.mData, this.mOffset + 2);
    }

    public short getSourcePort() {
        return CommonMethods.readShort(this.mData, this.mOffset);
    }

    public int getTotalLength() {
        return CommonMethods.readShort(this.mData, this.mOffset + 4) & UShort.MAX_VALUE;
    }

    public void setCrc(short s) {
        CommonMethods.writeShort(this.mData, this.mOffset + 6, s);
    }

    public void setDestinationPort(short s) {
        CommonMethods.writeShort(this.mData, this.mOffset + 2, s);
    }

    public void setSourcePort(short s) {
        CommonMethods.writeShort(this.mData, this.mOffset, s);
    }

    public void setTotalLength(int i) {
        CommonMethods.writeShort(this.mData, this.mOffset + 4, (short) i);
    }

    public String toString() {
        return String.format("%d->%d", new Object[]{Integer.valueOf(getSourcePort() & UShort.MAX_VALUE), Integer.valueOf(getDestinationPort() & UShort.MAX_VALUE)});
    }
}
