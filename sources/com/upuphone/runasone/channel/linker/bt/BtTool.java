package com.upuphone.runasone.channel.linker.bt;

import java.nio.ByteBuffer;

public class BtTool {
    private static final int LENGTH_HEAD = 2;

    private static int bytesToShort(byte[] bArr) {
        byte b = 0;
        for (int i = 0; i < 2; i++) {
            b = (b << 8) | (bArr[1 - i] & 255);
        }
        return b;
    }

    public static byte[] compose(byte[] bArr, byte[] bArr2) {
        byte[] shortToBytes = shortToBytes(bArr.length);
        return ByteBuffer.allocate(shortToBytes.length + bArr.length + bArr2.length).put(shortToBytes).put(bArr).put(bArr2).array();
    }

    public static BtPayload decompose(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        byte[] bArr2 = new byte[2];
        wrap.get(bArr2, 0, 2);
        int bytesToShort = bytesToShort(bArr2);
        int length = (bArr.length - 2) - bytesToShort;
        byte[] bArr3 = new byte[bytesToShort];
        byte[] bArr4 = new byte[length];
        wrap.get(bArr3, 0, bytesToShort);
        wrap.get(bArr4, 0, length);
        return new BtPayload(bArr3, bArr4);
    }

    private static byte[] shortToBytes(int i) {
        byte[] bArr = new byte[2];
        for (int i2 = 0; i2 < 2; i2++) {
            bArr[i2] = (byte) (i >> (i2 * 8));
        }
        return bArr;
    }
}
