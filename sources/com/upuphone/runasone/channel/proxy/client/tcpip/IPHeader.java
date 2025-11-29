package com.upuphone.runasone.channel.proxy.client.tcpip;

import com.google.common.primitives.SignedBytes;
import io.netty.handler.codec.rtsp.RtspHeaders;
import kotlin.UShort;

public class IPHeader {
    public static final byte ICMP = 1;
    public static final short IP = 2048;
    public static final byte TCP = 6;
    public static final byte UDP = 17;
    static final short offset_crc = 10;
    public static final int offset_dest_ip = 16;
    static final short offset_flags_fo = 6;
    static final short offset_identification = 4;
    static final int offset_op_pad = 20;
    public static final byte offset_proto = 9;
    public static final int offset_src_ip = 12;
    static final short offset_tlen = 2;
    static final byte offset_tos = 1;
    static final byte offset_ttl = 8;
    static final byte offset_ver_ihl = 0;
    public byte[] mData;
    public int mOffset;

    public IPHeader(byte[] bArr, int i) {
        this.mData = bArr;
        this.mOffset = i;
    }

    private String protocolToString(int i) {
        return i != 6 ? i != 17 ? "UNKNOWN" : RtspHeaders.Values.UDP : RtspHeaders.Values.TCP;
    }

    public void Default() {
        setHeaderLength(20);
        setTos((byte) 0);
        setTotalLength(0);
        setIdentification(0);
        setFlagsAndOffset(0);
        setTTL(SignedBytes.MAX_POWER_OF_TWO);
    }

    public short getCrc() {
        return CommonMethods.readShort(this.mData, this.mOffset + 10);
    }

    public int getDataLength() {
        return getTotalLength() - getHeaderLength();
    }

    public int getDestinationIP() {
        return CommonMethods.readInt(this.mData, this.mOffset + 16);
    }

    public short getFlagsAndOffset() {
        return CommonMethods.readShort(this.mData, this.mOffset + 6);
    }

    public int getHeaderLength() {
        return (this.mData[this.mOffset] & 15) * 4;
    }

    public int getIdentification() {
        return CommonMethods.readShort(this.mData, this.mOffset + 4) & UShort.MAX_VALUE;
    }

    public byte getProtocol() {
        return this.mData[this.mOffset + 9];
    }

    public int getSourceIP() {
        return CommonMethods.readInt(this.mData, this.mOffset + 12);
    }

    public byte getTTL() {
        return this.mData[this.mOffset + 8];
    }

    public byte getTos() {
        return this.mData[this.mOffset + 1];
    }

    public int getTotalLength() {
        return CommonMethods.readShort(this.mData, this.mOffset + 2) & UShort.MAX_VALUE;
    }

    public void setCrc(short s) {
        CommonMethods.writeShort(this.mData, this.mOffset + 10, s);
    }

    public void setDestinationIP(int i) {
        CommonMethods.writeInt(this.mData, this.mOffset + 16, i);
    }

    public void setFlagsAndOffset(short s) {
        CommonMethods.writeShort(this.mData, this.mOffset + 6, s);
    }

    public void setHeaderLength(int i) {
        this.mData[this.mOffset] = (byte) ((i / 4) | 64);
    }

    public void setIdentification(int i) {
        CommonMethods.writeShort(this.mData, this.mOffset + 4, (short) i);
    }

    public void setProtocol(byte b) {
        this.mData[this.mOffset + 9] = b;
    }

    public void setSourceIP(int i) {
        CommonMethods.writeInt(this.mData, this.mOffset + 12, i);
    }

    public void setTTL(byte b) {
        this.mData[this.mOffset + 8] = b;
    }

    public void setTos(byte b) {
        this.mData[this.mOffset + 1] = b;
    }

    public void setTotalLength(int i) {
        CommonMethods.writeShort(this.mData, this.mOffset + 2, (short) i);
    }

    public String toString() {
        return String.format("%s->%s Protocol=%s, HLen=%d", new Object[]{CommonMethods.ipIntToString(getSourceIP()), CommonMethods.ipIntToString(getDestinationIP()), protocolToString(getProtocol()), Integer.valueOf(getHeaderLength())});
    }
}
