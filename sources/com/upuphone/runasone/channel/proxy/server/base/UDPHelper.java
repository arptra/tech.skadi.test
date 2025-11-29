package com.upuphone.runasone.channel.proxy.server.base;

import com.honey.account.constant.AccountConstantKt;
import com.upuphone.runasone.channel.proxy.util.ByteHelper;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.socket.DatagramPacket;
import java.net.InetSocketAddress;

public class UDPHelper {

    public static class DestAddress {
        public String address;
        private InetSocketAddress inetSocketAddress;
        public int port;
        public int type;

        public InetSocketAddress getInetSocketAddress() {
            if (this.inetSocketAddress == null) {
                this.inetSocketAddress = new InetSocketAddress(this.address, this.port);
            }
            return this.inetSocketAddress;
        }

        public String toString() {
            return this.address + AccountConstantKt.CODE_SEPARTOR + this.port;
        }

        public byte[] warpAddress() {
            byte[] bArr;
            int i = this.type;
            if (i == 1) {
                bArr = ByteHelper.intToByteArray(ByteHelper.ipStringToInt(this.address));
            } else if (i != 3) {
                bArr = null;
            } else {
                throw null;
            }
            if (bArr != null) {
                return bArr;
            }
            return null;
        }
    }

    public static DestAddress parseData(ByteBuf byteBuf) {
        String str;
        byte[] bArr;
        byteBuf.readBytes(3);
        byte[] bArr2 = new byte[2];
        byte readByte = byteBuf.readByte();
        if (readByte == 1) {
            bArr = new byte[4];
            byteBuf.readBytes(bArr);
            str = ByteHelper.ipBytesToString(bArr);
        } else if (readByte != 3) {
            bArr = null;
            str = null;
        } else {
            bArr = new byte[(byteBuf.readByte() & 255)];
            byteBuf.readBytes(bArr);
            str = new String(bArr);
        }
        if (bArr == null) {
            return null;
        }
        byteBuf.readBytes(bArr2);
        DestAddress destAddress = new DestAddress();
        destAddress.type = readByte;
        destAddress.address = str;
        destAddress.port = ByteHelper.byteArrayToInt(bArr2, 0, 2);
        return destAddress;
    }

    public static ByteBuf wrapData(byte[] bArr, int i, int i2, DestAddress destAddress) {
        byte[] warpAddress = destAddress.warpAddress();
        ByteBuf wrappedBuffer = Unpooled.wrappedBuffer(new byte[(warpAddress.length + 6 + i2)]);
        wrappedBuffer.clear();
        wrappedBuffer.writeByte(0);
        wrappedBuffer.writeByte(0);
        wrappedBuffer.writeByte(0);
        wrappedBuffer.writeByte((byte) destAddress.type);
        wrappedBuffer.writeBytes(warpAddress);
        wrappedBuffer.writeBytes(ByteHelper.shortToByteArray(destAddress.port));
        wrappedBuffer.writeBytes(bArr, i, i2);
        return wrappedBuffer;
    }

    public static ByteBuf wrapData(DatagramPacket datagramPacket, DestAddress destAddress) {
        datagramPacket.retain();
        return wrapData(((ByteBuf) datagramPacket.content()).array(), ((ByteBuf) datagramPacket.content()).readerIndex(), ((ByteBuf) datagramPacket.content()).readableBytes(), destAddress);
    }
}
