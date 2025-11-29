package com.upuphone.runasone.channel.proxy.client.tcpip;

import java.net.InetAddress;
import java.net.UnknownHostException;
import kotlin.UShort;
import okhttp3.internal.ws.WebSocketProtocol;

public class CommonMethods {
    public static boolean ComputeIPChecksum(IPHeader iPHeader) {
        short crc = iPHeader.getCrc();
        iPHeader.setCrc(0);
        short checksum = checksum(0, iPHeader.mData, iPHeader.mOffset, iPHeader.getHeaderLength());
        iPHeader.setCrc(checksum);
        return crc == checksum;
    }

    public static boolean ComputeTCPChecksum(IPHeader iPHeader, TCPHeader tCPHeader) {
        ComputeIPChecksum(iPHeader);
        int dataLength = iPHeader.getDataLength();
        if (dataLength < 0) {
            return false;
        }
        short crc = tCPHeader.getCrc();
        tCPHeader.setCrc(0);
        short checksum = checksum(getsum(iPHeader.mData, iPHeader.mOffset + 12, 8) + ((long) (iPHeader.getProtocol() & 255)) + ((long) dataLength), tCPHeader.mData, tCPHeader.mOffset, dataLength);
        tCPHeader.setCrc(checksum);
        return crc == checksum;
    }

    public static boolean ComputeUDPChecksum(IPHeader iPHeader, UDPHeader uDPHeader) {
        ComputeIPChecksum(iPHeader);
        int dataLength = iPHeader.getDataLength();
        if (dataLength < 0) {
            return false;
        }
        short crc = uDPHeader.getCrc();
        uDPHeader.setCrc(0);
        short checksum = checksum(getsum(iPHeader.mData, iPHeader.mOffset + 12, 8) + ((long) (iPHeader.getProtocol() & 255)) + ((long) dataLength), uDPHeader.mData, uDPHeader.mOffset, dataLength);
        uDPHeader.setCrc(checksum);
        return crc == checksum;
    }

    public static short checksum(long j, byte[] bArr, int i, int i2) {
        long j2 = getsum(bArr, i, i2);
        while (true) {
            long j3 = j + j2;
            j2 = j3 >> 16;
            if (j2 <= 0) {
                return (short) ((int) (~j3));
            }
            j = j3 & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        }
    }

    public static long getsum(byte[] bArr, int i, int i2) {
        long j = 0;
        while (i2 > 1) {
            j += (long) (readShort(bArr, i) & UShort.MAX_VALUE);
            i += 2;
            i2 -= 2;
        }
        return i2 > 0 ? j + ((long) ((bArr[i] & 255) << 8)) : j;
    }

    public static String ipBytesToString(byte[] bArr) {
        return String.format("%s.%s.%s.%s", new Object[]{Integer.valueOf(bArr[0] & 255), Integer.valueOf(bArr[1] & 255), Integer.valueOf(bArr[2] & 255), Integer.valueOf(bArr[3] & 255)});
    }

    public static InetAddress ipIntToInet4Address(int i) {
        byte[] bArr = new byte[4];
        writeInt(bArr, 0, i);
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String ipIntToString(int i) {
        return String.format("%s.%s.%s.%s", new Object[]{Integer.valueOf((i >> 24) & 255), Integer.valueOf((i >> 16) & 255), Integer.valueOf((i >> 8) & 255), Integer.valueOf(i & 255)});
    }

    public static int ipStringToInt(String str) {
        String[] split = str.split("\\.");
        return Integer.parseInt(split[3]) | (Integer.parseInt(split[0]) << 24) | (Integer.parseInt(split[1]) << 16) | (Integer.parseInt(split[2]) << 8);
    }

    public static int readInt(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    public static short readShort(byte[] bArr, int i) {
        return (short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    public static void writeInt(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >> 24);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }

    public static void writeShort(byte[] bArr, int i, short s) {
        bArr[i] = (byte) (s >> 8);
        bArr[i + 1] = (byte) s;
    }
}
