package com.share.connect.ble;

import com.easy.logger.EasyLog;
import java.nio.charset.Charset;
import java.util.zip.CRC32;

public class BleUtils {
    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr != null) {
            for (byte valueOf : bArr) {
                sb.append(String.format("%02X ", new Object[]{Byte.valueOf(valueOf)}));
            }
        }
        return sb.toString();
    }

    public static String b(byte[] bArr) {
        if (bArr != null) {
            return new String(bArr, Charset.forName("UTF-8"));
        }
        EasyLog.i("BleAssist", "Can't convert a null byte[] to string.");
        return "";
    }

    public static int c(byte[] bArr) {
        CRC32 crc32 = new CRC32();
        crc32.update(bArr);
        return (int) crc32.getValue();
    }

    public static byte[] d(String str) {
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }

    public static byte[] e(String str) {
        return str == null ? new byte[0] : str.getBytes(Charset.forName("UTF-8"));
    }

    public static byte[] f(byte[] bArr) {
        int length = bArr.length - 1;
        while (length >= 0 && bArr[length] == 0) {
            length--;
        }
        int i = length + 1;
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, i);
        return bArr2;
    }
}
