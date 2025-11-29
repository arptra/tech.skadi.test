package com.upuphone.runasone.channel.proxy.client.util;

import com.upuphone.runasone.channel.proxy.client.tcpip.CommonMethods;
import java.nio.ByteBuffer;
import kotlin.UShort;

public class HttpHelper {
    public static String getSNI(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        int readShort;
        int i5;
        if (i2 - i <= 43 || bArr[i] != 22) {
            DebugLog.e("Bad TLS Client Hello packet.", new Object[0]);
        } else {
            int i6 = i + 43;
            int i7 = i + 44;
            if (i7 > i2 || (i4 = i3 + 2) > i2 || (i5 = readShort + 1) > i2) {
                return null;
            }
            int i8 = i5 + (bArr[(readShort = i4 + (CommonMethods.readShort(bArr, (i3 = i7 + (bArr[i6] & 255))) & UShort.MAX_VALUE))] & 255);
            if (i8 == i2) {
                DebugLog.w("TLS Client Hello packet doesn't contains SNI info.(offset == limit)", new Object[0]);
                return null;
            }
            int i9 = i8 + 2;
            if (i9 > i2) {
                return null;
            }
            if ((CommonMethods.readShort(bArr, i8) & UShort.MAX_VALUE) + i9 > i2) {
                DebugLog.w("TLS Client Hello packet is incomplete.", new Object[0]);
                return null;
            }
            while (i9 + 4 <= i2) {
                byte b = bArr[i9] & 255;
                byte b2 = bArr[i9 + 1] & 255;
                short readShort2 = CommonMethods.readShort(bArr, i9 + 2) & UShort.MAX_VALUE;
                int i10 = i9 + 4;
                if (b == 0 && b2 == 0 && readShort2 > 5) {
                    int i11 = i9 + 9;
                    int i12 = readShort2 - 5;
                    if (i11 + i12 > i2) {
                        return null;
                    }
                    String str = new String(bArr, i11, i12);
                    DebugLog.i("SNI: %s\n", str);
                    return str;
                }
                i9 = i10 + readShort2;
            }
            DebugLog.e("TLS Client Hello packet doesn't contains Host field info.", new Object[0]);
        }
        return null;
    }

    public static boolean isHttpAction(ByteBuffer byteBuffer, char... cArr) {
        int limit = byteBuffer.limit() - byteBuffer.position();
        boolean z = false;
        if (cArr != null && limit >= cArr.length) {
            byteBuffer.mark();
            int length = cArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = true;
                    break;
                } else if (cArr[i] != byteBuffer.get()) {
                    break;
                } else {
                    i++;
                }
            }
            byteBuffer.reset();
        }
        return z;
    }

    public static boolean isHttpRequest(ByteBuffer byteBuffer) {
        return isHttpAction(byteBuffer, 'G', 'E', 'T') || isHttpAction(byteBuffer, 'H', 'E', 'A', 'D') || isHttpAction(byteBuffer, 'P', 'O', 'S', 'T') || isHttpAction(byteBuffer, 'P', 'U', 'T') || isHttpAction(byteBuffer, 'D', 'E', 'L', 'E', 'T', 'E') || isHttpAction(byteBuffer, 'O', 'P', 'T', 'I', 'O', 'N', 'S') || isHttpAction(byteBuffer, 'T', 'R', 'A', 'C', 'E') || isHttpAction(byteBuffer, 'C', 'O', 'N', 'N', 'E', 'C', 'T');
    }

    public static boolean parseHeader(ByteBuffer byteBuffer, StringBuilder sb, boolean z) {
        boolean z2;
        if (z) {
            byteBuffer.mark();
        }
        while (true) {
            if (!byteBuffer.hasRemaining()) {
                z2 = false;
                break;
            }
            sb.append((char) byteBuffer.get());
            if (sb.lastIndexOf("\r\n\r\n") != -1) {
                z2 = true;
                break;
            }
        }
        if (z) {
            byteBuffer.reset();
        }
        return z2;
    }

    public static boolean parseHeader(ByteBuffer byteBuffer, StringBuilder sb) {
        return parseHeader(byteBuffer, sb, true);
    }
}
