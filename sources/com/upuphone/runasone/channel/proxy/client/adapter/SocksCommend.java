package com.upuphone.runasone.channel.proxy.client.adapter;

import com.upuphone.runasone.channel.proxy.util.ByteHelper;

public class SocksCommend {
    public static byte[] createAccount(int i, String str, String str2) {
        byte[] bytes = str.getBytes();
        byte[] bytes2 = str2.getBytes();
        byte[] bArr = new byte[(bytes.length + 3 + bytes2.length)];
        bArr[0] = (byte) i;
        bArr[1] = (byte) bytes.length;
        System.arraycopy(bytes, 0, bArr, 2, bytes.length);
        bArr[bytes.length + 2] = (byte) bytes2.length;
        System.arraycopy(bytes2, 0, bArr, bytes.length + 3, bytes2.length);
        return bArr;
    }

    public static byte[] createShakeHands() {
        return new byte[]{5, 2, 0, 2};
    }

    public static byte[] createTCPHostConnect(String str, int i) {
        byte[] bytes = str.getBytes();
        byte[] bArr = new byte[(bytes.length + 7)];
        bArr[0] = 5;
        bArr[1] = 1;
        bArr[2] = 0;
        bArr[3] = 3;
        bArr[4] = (byte) (bytes.length & 255);
        System.arraycopy(bytes, 0, bArr, 5, bytes.length);
        System.arraycopy(ByteHelper.shortToByteArray(i), 0, bArr, bytes.length + 5, 2);
        return bArr;
    }

    public static byte[] createTCPIP4Connect(int i, int i2) {
        byte[] bArr = new byte[10];
        bArr[0] = 5;
        bArr[1] = 1;
        bArr[2] = 0;
        bArr[3] = 1;
        System.arraycopy(ByteHelper.intToByteArray(i), 0, bArr, 4, 4);
        System.arraycopy(ByteHelper.shortToByteArray(i2), 0, bArr, 8, 2);
        return bArr;
    }

    public static byte[] createTCPIP6Connect(byte[] bArr, int i) {
        byte[] bArr2 = new byte[10];
        bArr2[0] = 5;
        bArr2[1] = 1;
        bArr2[2] = 0;
        bArr2[3] = 4;
        System.arraycopy(bArr, 0, bArr2, 4, 16);
        System.arraycopy(ByteHelper.shortToByteArray(i), 0, bArr2, 20, 2);
        return bArr2;
    }

    public static byte[] createUDPHostConnect(String str, int i) {
        byte[] bytes = str.getBytes();
        byte[] bArr = new byte[(bytes.length + 7)];
        bArr[0] = 5;
        bArr[1] = 3;
        bArr[2] = 0;
        bArr[3] = 3;
        bArr[4] = (byte) (bytes.length & 255);
        System.arraycopy(bytes, 0, bArr, 5, bytes.length);
        System.arraycopy(ByteHelper.shortToByteArray(i), 0, bArr, bytes.length + 5, 2);
        return bArr;
    }

    public static byte[] createUDPIP4Connect(int i, int i2) {
        byte[] bArr = new byte[10];
        bArr[0] = 5;
        bArr[1] = 3;
        bArr[2] = 0;
        bArr[3] = 1;
        System.arraycopy(ByteHelper.intToByteArray(i), 0, bArr, 4, 4);
        System.arraycopy(ByteHelper.shortToByteArray(i2), 0, bArr, 8, 2);
        return bArr;
    }

    public static byte[] createUDPIP6Connect(byte[] bArr, int i) {
        byte[] bArr2 = new byte[10];
        bArr2[0] = 5;
        bArr2[1] = 3;
        bArr2[2] = 0;
        bArr2[3] = 4;
        System.arraycopy(bArr, 0, bArr2, 4, 16);
        System.arraycopy(ByteHelper.shortToByteArray(i), 0, bArr2, 20, 2);
        return bArr2;
    }
}
