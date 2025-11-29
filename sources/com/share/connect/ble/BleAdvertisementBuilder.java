package com.share.connect.ble;

import android.bluetooth.le.AdvertiseData;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.ParcelUuid;
import com.easy.logger.EasyLog;
import com.google.common.io.BaseEncoding;
import com.google.common.primitives.Bytes;
import com.share.connect.ble.Constants;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Random;

public class BleAdvertisementBuilder {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f9880a;

    static {
        byte[] bArr = new byte[1];
        f9880a = bArr;
        new Random().nextBytes(bArr);
    }

    public static AdvertiseData a(String str, String str2, String str3, String str4, int i, boolean z, String str5, Context context) {
        if (str == null || str2 == null || str3 == null || str4 == null) {
            throw new IllegalArgumentException();
        }
        AdvertiseData.Builder addServiceUuid = new AdvertiseData.Builder().addServiceUuid(Constants.ServiceInfo.b);
        ParcelUuid parcelUuid = Constants.ServiceInfo.c;
        byte[] i2 = i(str);
        byte[] j = j(z, context);
        byte[] c = c(str2);
        byte[] d = d(str3);
        byte[] h = h(str4);
        byte[] g = g(i);
        return addServiceUuid.addServiceData(parcelUuid, Bytes.concat(i2, j, c, d, h, g, f(str5))).build();
    }

    public static AdvertiseData b(String str) {
        if (str != null) {
            return new AdvertiseData.Builder().addServiceData(Constants.ServiceInfo.d, Bytes.concat(e(str))).build();
        }
        throw new IllegalArgumentException();
    }

    public static byte[] c(String str) {
        return Arrays.copyOfRange(BaseEncoding.base16().lowerCase().decode(str.toLowerCase()), 0, 6);
    }

    public static byte[] d(String str) {
        return Arrays.copyOfRange(BaseEncoding.base16().lowerCase().decode(str.toLowerCase()), 0, 4);
    }

    public static byte[] e(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        while (bytes.length > 16 && !str.isEmpty()) {
            str = str.substring(0, str.length() - 1);
            bytes = BleUtils.e(str + "…");
        }
        return bytes.length < 16 ? Arrays.copyOfRange(bytes, 0, 16) : bytes;
    }

    public static byte[] f(String str) {
        if (str == null) {
            return new byte[0];
        }
        int c = BleUtils.c(BleUtils.d(str));
        return new byte[]{(byte) ((65280 & c) >> 8), (byte) (c & 255)};
    }

    public static byte[] g(int i) {
        return new byte[]{(byte) i};
    }

    public static byte[] h(String str) {
        return Arrays.copyOfRange(BaseEncoding.base16().lowerCase().decode(str.toLowerCase()), 0, 2);
    }

    public static byte[] i(String str) {
        String[] split = str.split("\\.");
        if (split.length >= 2) {
            byte[] bArr = new byte[2];
            for (int i = 0; i < 2; i++) {
                bArr[i] = (byte) Integer.parseInt(split[i]);
            }
            return bArr;
        }
        throw new IllegalArgumentException();
    }

    public static byte[] j(boolean z, Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("serial_num_prefs", 0);
        if (!z) {
            int i = sharedPreferences.getInt("last_serial_num", 0);
            EasyLog.e("BleAdvertisementBuilder", "advertising new serial number");
            byte[] bArr = f9880a;
            bArr[0] = (byte) (bArr[0] + 1);
            while (true) {
                byte[] bArr2 = f9880a;
                if (i != bArr2[0]) {
                    break;
                }
                new Random().nextBytes(bArr2);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("advertising serial number is :");
        byte[] bArr3 = f9880a;
        sb.append(bArr3[0]);
        EasyLog.e("BleAdvertisementBuilder", sb.toString());
        sharedPreferences.edit().putInt("last_serial_num", bArr3[0]).apply();
        return bArr3;
    }
}
