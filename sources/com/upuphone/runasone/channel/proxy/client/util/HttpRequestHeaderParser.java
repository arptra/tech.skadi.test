package com.upuphone.runasone.channel.proxy.client.util;

import android.text.TextUtils;
import com.honey.account.constant.AccountConstantKt;
import com.upuphone.runasone.api.ApiConstant;
import com.upuphone.runasone.channel.proxy.client.nat.NatSession;
import com.upuphone.runasone.channel.proxy.client.tcpip.CommonMethods;
import java.util.Locale;
import kotlin.UShort;

public class HttpRequestHeaderParser {
    public static String getSNI(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        int readShort;
        int i5;
        int i6 = i + i2;
        if (i2 <= 43 || bArr[i] != 22) {
            DebugLog.e("Bad TLS Client Hello packet.", new Object[0]);
            return null;
        }
        int i7 = i + 43;
        int i8 = i + 44;
        if (i8 > i6 || (i4 = i3 + 2) > i6 || (i5 = readShort + 1) > i6) {
            return null;
        }
        int i9 = i5 + (bArr[(readShort = i4 + (CommonMethods.readShort(bArr, (i3 = i8 + (bArr[i7] & 255))) & UShort.MAX_VALUE))] & 255);
        if (i9 == i6) {
            DebugLog.w("TLS Client Hello packet doesn't contains SNI info.(offset == limit)", new Object[0]);
            return null;
        }
        int i10 = i9 + 2;
        if (i10 > i6) {
            return null;
        }
        if ((CommonMethods.readShort(bArr, i9) & UShort.MAX_VALUE) + i10 > i6) {
            DebugLog.w("TLS Client Hello packet is incomplete.", new Object[0]);
            return null;
        }
        while (i10 + 4 <= i6) {
            byte b = bArr[i10] & 255;
            byte b2 = bArr[i10 + 1] & 255;
            short readShort2 = CommonMethods.readShort(bArr, i10 + 2) & UShort.MAX_VALUE;
            int i11 = i10 + 4;
            if (b == 0 && b2 == 0 && readShort2 > 5) {
                int i12 = i10 + 9;
                int i13 = readShort2 - 5;
                if (i12 + i13 > i6) {
                    return null;
                }
                String str = new String(bArr, i12, i13);
                DebugLog.i("SNI: %s\n", str);
                return str;
            }
            i10 = i11 + readShort2;
        }
        DebugLog.e("TLS Client Hello packet doesn't contains Host field info.", new Object[0]);
        return null;
    }

    private static boolean isHttpRequest(byte[] bArr, int i, char... cArr) {
        int length = cArr.length;
        if (length + i > bArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (cArr[i2] != bArr[i2 + i]) {
                return false;
            }
        }
        return true;
    }

    private static String parseHttpHost(String[] strArr) {
        String str = strArr[0];
        if (!str.startsWith("GET") && !str.startsWith("POST") && !str.startsWith("HEAD") && !str.startsWith("OPTIONS") && !str.startsWith("CONNECT") && !str.startsWith("PUT") && !str.startsWith("DELETE") && !str.startsWith("TRACE")) {
            return null;
        }
        for (int i = 1; i < strArr.length; i++) {
            String[] split = strArr[i].split(": ");
            if (split.length == 2) {
                String trim = split[0].toLowerCase(Locale.ENGLISH).trim();
                String trim2 = split[1].trim();
                if (ApiConstant.VALUE_HOST.equals(trim)) {
                    return trim2;
                }
            }
        }
        return null;
    }

    private static void parseHttpHostAndRequestUrl(NatSession natSession, byte[] bArr, int i, int i2) {
        String parseHttpHost = parseHttpHost(new String(bArr, i, i2).split("\\r\\n"));
        if (!TextUtils.isEmpty(parseHttpHost)) {
            String[] split = parseHttpHost.split(AccountConstantKt.CODE_SEPARTOR);
            if (split.length == 2) {
                if (natSession.remotePort == 0) {
                    natSession.remotePort = (short) Integer.parseInt(split[1]);
                }
            } else if (natSession.remotePort == 0) {
                natSession.remotePort = 80;
            }
        }
    }

    public static void parseHttpRequestHeader(NatSession natSession, byte[] bArr, int i, int i2) {
        if (natSession != null) {
            try {
                if (!isHttpRequest(bArr, i, 'G', 'E', 'T') && !isHttpRequest(bArr, i, 'H', 'E', 'A', 'D') && !isHttpRequest(bArr, i, 'P', 'O', 'S', 'T') && !isHttpRequest(bArr, i, 'P', 'U', 'T') && !isHttpRequest(bArr, i, 'D', 'E', 'L', 'E', 'T', 'E') && !isHttpRequest(bArr, i, 'O', 'P', 'T', 'I', 'O', 'N', 'S') && !isHttpRequest(bArr, i, 'T', 'R', 'A', 'C', 'E')) {
                    if (!isHttpRequest(bArr, i, 'C', 'O', 'N', 'N', 'E', 'C', 'T')) {
                        if (bArr[i] == 22 && !TextUtils.isEmpty(HttpHelper.getSNI(bArr, i, i2 + i)) && natSession.remotePort == 0) {
                            natSession.remotePort = 443;
                            return;
                        }
                        return;
                    }
                }
                parseHttpHostAndRequestUrl(natSession, bArr, i, i2);
            } catch (Exception e) {
                e.printStackTrace(System.err);
                DebugLog.e("Error: parseHost: %s", e);
            }
        }
    }
}
