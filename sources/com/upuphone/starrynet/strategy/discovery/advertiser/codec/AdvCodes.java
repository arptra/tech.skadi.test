package com.upuphone.starrynet.strategy.discovery.advertiser.codec;

public class AdvCodes {
    public static final byte[] BASE_CODES;
    private static final int BASE_ITEM_SIZE;
    public static final byte ITEM_DYNAMIC_LENGTH = -1;
    public static final int ITEM_ELEMENT_SiZE = 3;
    public static final byte ITEM_TYPE_NOT_SUPPORT = -2;
    public static final byte[] V2_CODES;
    private static final int V2_ITEM_SIZE;
    public static final byte VALUE_TYPE_BYTE = 3;
    public static final byte VALUE_TYPE_BYTE_ARR = 4;
    public static final byte VALUE_TYPE_INT = 2;
    public static final byte VALUE_TYPE_STRING = 1;

    static {
        byte[] bArr = {1, 6, 4, 2, 6, 4, 3, 1, 3, 4, 1, 3, 5, 1, 3, 6, 1, 3, 8, 6, 4, 9, 1, 3, 10, 16, 4, 11, 6, 4, 12, 1, 3, 15, 7, 4, -1, 0, 4, 19, -1, 1, 20, -1, 1};
        BASE_CODES = bArr;
        BASE_ITEM_SIZE = bArr.length / 3;
        byte[] bArr2 = {1, 1, 3, 2, 1, 3, 16, 2, 4, 3, 7, 4, 17, 6, 4, 4, 1, 3, 5, 1, 3, 6, 16, 1, 18, 12, 1, 21, 1, 3, 7, 6, 4, 8, 7, 4, 9, 6, 4, 10, 6, 4, 11, 1, 3, 12, 1, 3, 13, 1, 3, 14, 2, 4, 15, 1, 3, 22, 1, 3, -1, 0, 4, 19, -1, 1, 20, -1, 1};
        V2_CODES = bArr2;
        V2_ITEM_SIZE = bArr2.length / 3;
    }

    public static int getBaseIndex(byte b) {
        for (int i = 0; i < BASE_ITEM_SIZE; i++) {
            int i2 = i * 3;
            if (BASE_CODES[i2] == b) {
                return i2;
            }
        }
        return -2;
    }

    public static byte getBaseTypeLength(byte b) {
        int baseIndex = getBaseIndex(b);
        if (baseIndex == -2) {
            return -2;
        }
        return BASE_CODES[baseIndex + 1];
    }

    public static int getV2Index(byte b) {
        for (int i = 0; i < V2_ITEM_SIZE; i++) {
            int i2 = i * 3;
            if (V2_CODES[i2] == b) {
                return i2;
            }
        }
        return -2;
    }

    public static byte getV2TypeLength(byte b) {
        int v2Index = getV2Index(b);
        if (v2Index == -2) {
            return -2;
        }
        return V2_CODES[v2Index + 1];
    }
}
