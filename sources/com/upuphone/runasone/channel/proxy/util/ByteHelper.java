package com.upuphone.runasone.channel.proxy.util;

import com.honey.account.constant.AccountConstantKt;

public class ByteHelper {
    public static int byteArrayToInt(byte[] bArr) {
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            i += (bArr[i2] & 255) << ((3 - i2) * 8);
        }
        return i;
    }

    public static byte[] createHostByte(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(AccountConstantKt.CODE_SEPARTOR);
        stringBuffer.append(str2);
        return stringBuffer.toString().getBytes();
    }

    public static String[] hostByteToString(byte[] bArr, int i) {
        return new String[]{ipIntToString(byteArrayToInt(bArr, i, 4)), String.valueOf(byteArrayToInt(bArr, i + 4, 2))};
    }

    public static byte[] intToByteArray(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static String ipBytesToString(byte[] bArr) {
        return String.format("%s.%s.%s.%s", new Object[]{Integer.valueOf(bArr[0] & 255), Integer.valueOf(bArr[1] & 255), Integer.valueOf(bArr[2] & 255), Integer.valueOf(bArr[3] & 255)});
    }

    public static String ipIntToString(int i) {
        return String.format("%s.%s.%s.%s", new Object[]{Integer.valueOf((i >> 24) & 255), Integer.valueOf((i >> 16) & 255), Integer.valueOf((i >> 8) & 255), Integer.valueOf(i & 255)});
    }

    public static int ipStringToInt(String str) {
        String[] split = str.split("\\.");
        return Integer.parseInt(split[3]) | (Integer.parseInt(split[0]) << 24) | (Integer.parseInt(split[1]) << 16) | (Integer.parseInt(split[2]) << 8);
    }

    public static byte[] shortToByteArray(int i) {
        return new byte[]{(byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static int byteArrayToInt(byte[] bArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 += (bArr[i4 + i] & 255) << (((i2 - 1) - i4) * 8);
        }
        return i3;
    }
}
