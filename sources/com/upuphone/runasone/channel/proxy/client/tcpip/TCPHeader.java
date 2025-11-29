package com.upuphone.runasone.channel.proxy.client.tcpip;

import kotlin.UShort;

public class TCPHeader {
    public static final int ACK = 16;
    public static final int FIN = 1;
    public static final int PSH = 8;
    public static final int RST = 4;
    public static final int SYN = 2;
    public static final int URG = 32;
    static final int offset_ack = 8;
    static final short offset_crc = 16;
    static final short offset_dest_port = 2;
    static final byte offset_flag = 13;
    static final byte offset_lenres = 12;
    static final int offset_seq = 4;
    static final short offset_src_port = 0;
    static final short offset_urp = 18;
    static final short offset_win = 14;
    public byte[] mData;
    public int mOffset;

    public TCPHeader(byte[] bArr, int i) {
        this.mData = bArr;
        this.mOffset = i;
    }

    public int getAckID() {
        return CommonMethods.readInt(this.mData, this.mOffset + 8);
    }

    public short getCrc() {
        return CommonMethods.readShort(this.mData, this.mOffset + 16);
    }

    public short getDestinationPort() {
        return CommonMethods.readShort(this.mData, this.mOffset + 2);
    }

    public byte getFlag() {
        return this.mData[this.mOffset + 13];
    }

    public int getHeaderLength() {
        return ((this.mData[this.mOffset + 12] & 255) >> 4) * 4;
    }

    public int getSeqID() {
        return CommonMethods.readInt(this.mData, this.mOffset + 4);
    }

    public short getSourcePort() {
        return CommonMethods.readShort(this.mData, this.mOffset);
    }

    public void setCrc(short s) {
        CommonMethods.writeShort(this.mData, this.mOffset + 16, s);
    }

    public void setDestinationPort(short s) {
        CommonMethods.writeShort(this.mData, this.mOffset + 2, s);
    }

    public void setSourcePort(short s) {
        CommonMethods.writeShort(this.mData, this.mOffset, s);
    }

    public String toString() {
        String str = "";
        String str2 = (getFlag() & 2) == 2 ? "SYN" : str;
        String str3 = (getFlag() & 16) == 16 ? "ACK" : str;
        String str4 = (getFlag() & 8) == 8 ? "PSH" : str;
        String str5 = (getFlag() & 4) == 4 ? "RST" : str;
        String str6 = (getFlag() & 1) == 1 ? "FIN" : str;
        if ((getFlag() & 32) == 32) {
            str = "URG";
        }
        return String.format("%s %s %s %s %s %s %d->%d %s:%s", new Object[]{str2, str3, str4, str5, str6, str, Integer.valueOf(getSourcePort() & UShort.MAX_VALUE), Integer.valueOf(getDestinationPort() & UShort.MAX_VALUE), Integer.valueOf(getSeqID()), Integer.valueOf(getAckID())});
    }
}
