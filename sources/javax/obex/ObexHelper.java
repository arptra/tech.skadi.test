package javax.obex;

import androidx.exifinterface.media.ExifInterface;
import com.meizu.common.widget.CircularProgressButton;
import com.upuphone.starrynet.strategy.pair.ble.RingSecurityPair;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

public final class ObexHelper {
    public static byte[] a(byte[] bArr) {
        try {
            return MessageDigest.getInstance(MessageDigestAlgorithms.MD5).digest(bArr);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] b(long j) {
        return new byte[]{(byte) ((int) ((j >> 24) & 255)), (byte) ((int) ((j >> 16) & 255)), (byte) ((int) ((j >> 8) & 255)), (byte) ((int) (j & 255))};
    }

    public static long c(byte[] bArr) {
        long j = 0;
        long j2 = 0;
        for (int length = bArr.length - 1; length >= 0; length--) {
            long j3 = (long) bArr[length];
            if (j3 < 0) {
                j3 += 256;
            }
            j |= j3 << ((int) j2);
            j2 += 8;
        }
        return j;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: byte} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r3v2, types: [byte, int] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String d(byte[] r5, boolean r6) {
        /*
            if (r5 == 0) goto L_0x0048
            int r0 = r5.length
            if (r0 != 0) goto L_0x0006
            goto L_0x0048
        L_0x0006:
            int r0 = r5.length
            int r1 = r0 % 2
            if (r1 != 0) goto L_0x0040
            int r0 = r0 >> 1
            if (r6 == 0) goto L_0x0011
            int r0 = r0 + -1
        L_0x0011:
            char[] r6 = new char[r0]
            r1 = 0
            r2 = r1
        L_0x0015:
            if (r2 >= r0) goto L_0x003a
            int r3 = r2 * 2
            byte r4 = r5[r3]
            int r3 = r3 + 1
            byte r3 = r5[r3]
            if (r4 >= 0) goto L_0x0023
            int r4 = r4 + 256
        L_0x0023:
            if (r3 >= 0) goto L_0x0027
            int r3 = r3 + 256
        L_0x0027:
            if (r4 != 0) goto L_0x0031
            if (r3 != 0) goto L_0x0031
            java.lang.String r5 = new java.lang.String
            r5.<init>(r6, r1, r2)
            return r5
        L_0x0031:
            int r4 = r4 << 8
            r3 = r3 | r4
            char r3 = (char) r3
            r6[r2] = r3
            int r2 = r2 + 1
            goto L_0x0015
        L_0x003a:
            java.lang.String r5 = new java.lang.String
            r5.<init>(r6)
            return r5
        L_0x0040:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "Byte array not of a valid form"
            r5.<init>(r6)
            throw r5
        L_0x0048:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.obex.ObexHelper.d(byte[], boolean):java.lang.String");
    }

    public static byte[] e(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length * 2;
        byte[] bArr = new byte[(length + 2)];
        for (int i = 0; i < charArray.length; i++) {
            int i2 = i * 2;
            char c = charArray[i];
            bArr[i2] = (byte) (c >> 8);
            bArr[i2 + 1] = (byte) c;
        }
        bArr[length] = 0;
        bArr[length + 1] = 0;
        return bArr;
    }

    public static byte[] f(HeaderSet headerSet, boolean z) {
        HeaderSet headerSet2 = headerSet;
        byte[] bArr = new byte[2];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            if (headerSet2.v != null && headerSet2.b(70) == null) {
                byteArrayOutputStream.write(-53);
                byteArrayOutputStream.write(headerSet2.v);
            }
            Long l = (Long) headerSet2.b(192);
            if (l != null) {
                byteArrayOutputStream.write(-64);
                byteArrayOutputStream.write(b(l.longValue()));
                if (z) {
                    headerSet2.e(192, (Object) null);
                }
            }
            String str = (String) headerSet2.b(1);
            if (str != null) {
                byteArrayOutputStream.write(1);
                byte[] e = e(str);
                int length = e.length + 3;
                bArr[0] = (byte) ((length >> 8) & 255);
                bArr[1] = (byte) (length & 255);
                byteArrayOutputStream.write(bArr);
                byteArrayOutputStream.write(e);
                if (z) {
                    headerSet2.e(1, (Object) null);
                }
            } else if (headerSet.a()) {
                byteArrayOutputStream.write(1);
                bArr[0] = 0;
                bArr[1] = 3;
                byteArrayOutputStream.write(bArr);
            }
            String str2 = (String) headerSet2.b(66);
            if (str2 != null) {
                byteArrayOutputStream.write(66);
                byte[] bytes = str2.getBytes("ISO8859_1");
                int length2 = bytes.length + 4;
                bArr[0] = (byte) ((length2 >> 8) & 255);
                bArr[1] = (byte) (length2 & 255);
                byteArrayOutputStream.write(bArr);
                byteArrayOutputStream.write(bytes);
                byteArrayOutputStream.write(0);
                if (z) {
                    headerSet2.e(66, (Object) null);
                }
            }
            Long l2 = (Long) headerSet2.b(195);
            if (l2 != null) {
                byteArrayOutputStream.write(-61);
                byteArrayOutputStream.write(b(l2.longValue()));
                if (z) {
                    headerSet2.e(195, (Object) null);
                }
            }
            Calendar calendar = (Calendar) headerSet2.b(68);
            if (calendar != null) {
                StringBuffer stringBuffer = new StringBuffer();
                int i = calendar.get(1);
                for (int i2 = i; i2 < 1000; i2 *= 10) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(i);
                int i3 = calendar.get(2);
                if (i3 < 10) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(i3);
                int i4 = calendar.get(5);
                if (i4 < 10) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(i4);
                stringBuffer.append(ExifInterface.GPS_DIRECTION_TRUE);
                int i5 = calendar.get(11);
                if (i5 < 10) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(i5);
                int i6 = calendar.get(12);
                if (i6 < 10) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(i6);
                int i7 = calendar.get(13);
                if (i7 < 10) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(i7);
                if (calendar.getTimeZone().getID().equals("UTC")) {
                    stringBuffer.append("Z");
                }
                byte[] bytes2 = stringBuffer.toString().getBytes("ISO8859_1");
                int length3 = bytes2.length + 3;
                bArr[0] = (byte) ((length3 >> 8) & 255);
                bArr[1] = (byte) (length3 & 255);
                byteArrayOutputStream.write(68);
                byteArrayOutputStream.write(bArr);
                byteArrayOutputStream.write(bytes2);
                if (z) {
                    headerSet2.e(68, (Object) null);
                }
            }
            Calendar calendar2 = (Calendar) headerSet2.b(196);
            if (calendar2 != null) {
                byteArrayOutputStream.write(196);
                byteArrayOutputStream.write(b(calendar2.getTime().getTime() / 1000));
                if (z) {
                    headerSet2.e(196, (Object) null);
                }
            }
            String str3 = (String) headerSet2.b(5);
            if (str3 != null) {
                byteArrayOutputStream.write(5);
                byte[] e2 = e(str3);
                int length4 = e2.length + 3;
                bArr[0] = (byte) ((length4 >> 8) & 255);
                bArr[1] = (byte) (length4 & 255);
                byteArrayOutputStream.write(bArr);
                byteArrayOutputStream.write(e2);
                if (z) {
                    headerSet2.e(5, (Object) null);
                }
            }
            byte[] bArr2 = (byte[]) headerSet2.b(70);
            if (bArr2 != null) {
                byteArrayOutputStream.write(70);
                int length5 = bArr2.length + 3;
                bArr[0] = (byte) ((length5 >> 8) & 255);
                bArr[1] = (byte) (length5 & 255);
                byteArrayOutputStream.write(bArr);
                byteArrayOutputStream.write(bArr2);
                if (z) {
                    headerSet2.e(70, (Object) null);
                }
            }
            byte[] bArr3 = (byte[]) headerSet2.b(71);
            if (bArr3 != null) {
                byteArrayOutputStream.write(71);
                int length6 = bArr3.length + 3;
                bArr[0] = (byte) ((length6 >> 8) & 255);
                bArr[1] = (byte) (length6 & 255);
                byteArrayOutputStream.write(bArr);
                byteArrayOutputStream.write(bArr3);
                if (z) {
                    headerSet2.e(71, (Object) null);
                }
            }
            byte[] bArr4 = (byte[]) headerSet2.b(74);
            if (bArr4 != null) {
                byteArrayOutputStream.write(74);
                int length7 = bArr4.length + 3;
                bArr[0] = (byte) ((length7 >> 8) & 255);
                bArr[1] = (byte) (length7 & 255);
                byteArrayOutputStream.write(bArr);
                byteArrayOutputStream.write(bArr4);
                if (z) {
                    headerSet2.e(74, (Object) null);
                }
            }
            byte[] bArr5 = (byte[]) headerSet2.b(76);
            if (bArr5 != null) {
                byteArrayOutputStream.write(76);
                int length8 = bArr5.length + 3;
                bArr[0] = (byte) ((length8 >> 8) & 255);
                bArr[1] = (byte) (length8 & 255);
                byteArrayOutputStream.write(bArr);
                byteArrayOutputStream.write(bArr5);
                if (z) {
                    headerSet2.e(76, (Object) null);
                }
            }
            byte[] bArr6 = (byte[]) headerSet2.b(79);
            if (bArr6 != null) {
                byteArrayOutputStream.write(79);
                int length9 = bArr6.length + 3;
                bArr[0] = (byte) ((length9 >> 8) & 255);
                bArr[1] = (byte) (length9 & 255);
                byteArrayOutputStream.write(bArr);
                byteArrayOutputStream.write(bArr6);
                if (z) {
                    headerSet2.e(79, (Object) null);
                }
            }
            for (int i8 = 0; i8 < 16; i8++) {
                int i9 = i8 + 48;
                String str4 = (String) headerSet2.b(i9);
                if (str4 != null) {
                    byteArrayOutputStream.write(((byte) i8) + 48);
                    byte[] e3 = e(str4);
                    int length10 = e3.length + 3;
                    bArr[0] = (byte) ((length10 >> 8) & 255);
                    bArr[1] = (byte) (length10 & 255);
                    byteArrayOutputStream.write(bArr);
                    byteArrayOutputStream.write(e3);
                    if (z) {
                        headerSet2.e(i9, (Object) null);
                    }
                }
                int i10 = i8 + 112;
                byte[] bArr7 = (byte[]) headerSet2.b(i10);
                if (bArr7 != null) {
                    byteArrayOutputStream.write(((byte) i8) + RingSecurityPair.OPCODE_RING_PAIR);
                    int length11 = bArr7.length + 3;
                    bArr[0] = (byte) ((length11 >> 8) & 255);
                    bArr[1] = (byte) (length11 & 255);
                    byteArrayOutputStream.write(bArr);
                    byteArrayOutputStream.write(bArr7);
                    if (z) {
                        headerSet2.e(i10, (Object) null);
                    }
                }
                int i11 = i8 + 176;
                Byte b = (Byte) headerSet2.b(i11);
                if (b != null) {
                    byteArrayOutputStream.write(((byte) i8) + 176);
                    byteArrayOutputStream.write(b.byteValue());
                    if (z) {
                        headerSet2.e(i11, (Object) null);
                    }
                }
                int i12 = i8 + CircularProgressButton.MorphingAnimation.DURATION_NORMAL;
                Long l3 = (Long) headerSet2.b(i12);
                if (l3 != null) {
                    byteArrayOutputStream.write(((byte) i8) + 240);
                    byteArrayOutputStream.write(b(l3.longValue()));
                    if (z) {
                        headerSet2.e(i12, (Object) null);
                    }
                }
            }
            if (headerSet2.t != null) {
                byteArrayOutputStream.write(77);
                int length12 = headerSet2.t.length + 3;
                bArr[0] = (byte) ((length12 >> 8) & 255);
                bArr[1] = (byte) (length12 & 255);
                byteArrayOutputStream.write(bArr);
                byteArrayOutputStream.write(headerSet2.t);
                if (z) {
                    headerSet2.t = null;
                }
            }
            if (headerSet2.u != null) {
                byteArrayOutputStream.write(78);
                int length13 = headerSet2.u.length + 3;
                bArr[0] = (byte) ((length13 >> 8) & 255);
                bArr[1] = (byte) (length13 & 255);
                byteArrayOutputStream.write(bArr);
                byteArrayOutputStream.write(headerSet2.u);
                if (z) {
                    headerSet2.u = null;
                }
            }
        } catch (UnsupportedEncodingException e4) {
            throw e4;
        } catch (UnsupportedEncodingException e5) {
            throw e5;
        } catch (IOException unused) {
        } catch (Throwable th) {
            byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Exception unused2) {
            }
            throw th;
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (Exception unused3) {
        }
        return byteArray;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v22, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int g(byte[] r7, int r8, int r9) {
        /*
            r0 = 0
            r1 = -1
            r2 = r8
            r3 = r1
        L_0x0004:
            if (r0 >= r9) goto L_0x0047
            int r4 = r7.length
            if (r2 >= r4) goto L_0x0047
            byte r3 = r7[r2]
            if (r3 >= 0) goto L_0x000f
            int r3 = r3 + 256
        L_0x000f:
            r4 = 192(0xc0, float:2.69E-43)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x002a
            r5 = 64
            if (r3 == r5) goto L_0x002a
            r5 = 128(0x80, float:1.794E-43)
            if (r3 == r5) goto L_0x0025
            if (r3 == r4) goto L_0x0020
            r3 = r0
            goto L_0x0043
        L_0x0020:
            int r2 = r2 + 5
            int r3 = r0 + 5
            goto L_0x0043
        L_0x0025:
            int r2 = r2 + 2
            int r3 = r0 + 2
            goto L_0x0043
        L_0x002a:
            int r3 = r2 + 1
            byte r3 = r7[r3]
            if (r3 >= 0) goto L_0x0032
            int r3 = r3 + 256
        L_0x0032:
            int r3 = r3 << 8
            int r4 = r2 + 2
            byte r4 = r7[r4]
            if (r4 >= 0) goto L_0x003c
            int r4 = r4 + 256
        L_0x003c:
            int r3 = r3 + r4
            int r4 = r3 + -3
            int r2 = r2 + 3
            int r2 = r2 + r4
            int r3 = r3 + r0
        L_0x0043:
            r6 = r3
            r3 = r0
            r0 = r6
            goto L_0x0004
        L_0x0047:
            if (r3 != 0) goto L_0x004e
            if (r0 >= r9) goto L_0x004d
            int r7 = r7.length
            return r7
        L_0x004d:
            return r1
        L_0x004e:
            int r3 = r3 + r8
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.obex.ObexHelper.g(byte[], int, int):int");
    }

    public static int h(byte b, byte[] bArr) {
        if (bArr == null) {
            return -1;
        }
        int i = 0;
        while (i < bArr.length && bArr[i] != b) {
            i += (bArr[i + 1] & 255) + 2;
        }
        if (i >= bArr.length) {
            return -1;
        }
        return i;
    }

    public static byte[] i(byte b, byte[] bArr) {
        int h;
        if (bArr == null || (h = h(b, bArr)) == -1) {
            return null;
        }
        int i = bArr[h + 1] & 255;
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, h + 2, bArr2, 0, i);
        return bArr2;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:22|23|24) */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0062, code lost:
        throw new java.io.IOException("Header was not formatted properly");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x005d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] j(javax.obex.HeaderSet r16, byte[] r17) {
        /*
            r0 = r16
            r1 = r17
            java.lang.String r2 = "Header was not formatted properly"
            r3 = 0
            r4 = 0
            r5 = r3
        L_0x0009:
            int r6 = r1.length     // Catch:{ IOException -> 0x0178 }
            if (r5 >= r6) goto L_0x0177
            byte r6 = r1[r5]     // Catch:{ IOException -> 0x0178 }
            r7 = r6 & 255(0xff, float:3.57E-43)
            r8 = 192(0xc0, float:2.69E-43)
            r6 = r6 & r8
            r9 = 4
            if (r6 == 0) goto L_0x0071
            r10 = 64
            if (r6 == r10) goto L_0x0071
            r10 = 128(0x80, float:1.794E-43)
            if (r6 == r10) goto L_0x0063
            if (r6 == r8) goto L_0x0021
            goto L_0x0009
        L_0x0021:
            int r6 = r5 + 1
            byte[] r8 = new byte[r9]     // Catch:{ IOException -> 0x0178 }
            java.lang.System.arraycopy(r1, r6, r8, r3, r9)     // Catch:{ IOException -> 0x0178 }
            r6 = 196(0xc4, float:2.75E-43)
            if (r7 == r6) goto L_0x0044
            r6 = 203(0xcb, float:2.84E-43)
            if (r7 != r6) goto L_0x0038
            byte[] r6 = new byte[r9]     // Catch:{ Exception -> 0x005d }
            r0.v = r6     // Catch:{ Exception -> 0x005d }
            java.lang.System.arraycopy(r8, r3, r6, r3, r9)     // Catch:{ Exception -> 0x005d }
            goto L_0x005a
        L_0x0038:
            long r8 = c(r8)     // Catch:{ Exception -> 0x005d }
            java.lang.Long r6 = java.lang.Long.valueOf(r8)     // Catch:{ Exception -> 0x005d }
            r0.e(r7, r6)     // Catch:{ Exception -> 0x005d }
            goto L_0x005a
        L_0x0044:
            java.util.Calendar r7 = java.util.Calendar.getInstance()     // Catch:{ Exception -> 0x005d }
            java.util.Date r9 = new java.util.Date     // Catch:{ Exception -> 0x005d }
            long r10 = c(r8)     // Catch:{ Exception -> 0x005d }
            r12 = 1000(0x3e8, double:4.94E-321)
            long r10 = r10 * r12
            r9.<init>(r10)     // Catch:{ Exception -> 0x005d }
            r7.setTime(r9)     // Catch:{ Exception -> 0x005d }
            r0.e(r6, r7)     // Catch:{ Exception -> 0x005d }
        L_0x005a:
            int r5 = r5 + 5
            goto L_0x0009
        L_0x005d:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x0178 }
            r0.<init>(r2)     // Catch:{ IOException -> 0x0178 }
            throw r0     // Catch:{ IOException -> 0x0178 }
        L_0x0063:
            int r6 = r5 + 1
            byte r6 = r1[r6]     // Catch:{ Exception -> 0x006e }
            java.lang.Byte r6 = java.lang.Byte.valueOf(r6)     // Catch:{ Exception -> 0x006e }
            r0.e(r7, r6)     // Catch:{ Exception -> 0x006e }
        L_0x006e:
            int r5 = r5 + 2
            goto L_0x0009
        L_0x0071:
            int r8 = r5 + 1
            byte r8 = r1[r8]     // Catch:{ IOException -> 0x0178 }
            r8 = r8 & 255(0xff, float:3.57E-43)
            r10 = 8
            int r8 = r8 << r10
            int r11 = r5 + 2
            byte r11 = r1[r11]     // Catch:{ IOException -> 0x0178 }
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r8 = r8 + r11
            int r11 = r8 + -3
            int r5 = r5 + 3
            byte[] r12 = new byte[r11]     // Catch:{ IOException -> 0x0178 }
            java.lang.System.arraycopy(r1, r5, r12, r3, r11)     // Catch:{ IOException -> 0x0178 }
            r13 = 1
            if (r11 == 0) goto L_0x0098
            if (r11 <= 0) goto L_0x0096
            int r14 = r8 + -4
            byte r14 = r12[r14]     // Catch:{ IOException -> 0x0178 }
            if (r14 == 0) goto L_0x0096
            goto L_0x0098
        L_0x0096:
            r14 = r13
            goto L_0x0099
        L_0x0098:
            r14 = r3
        L_0x0099:
            r15 = 66
            java.lang.String r10 = "ISO8859_1"
            if (r7 == r15) goto L_0x015c
            r14 = 68
            if (r7 == r14) goto L_0x00e1
            r9 = 72
            if (r7 == r9) goto L_0x00d5
            r9 = 73
            if (r7 == r9) goto L_0x00d5
            r8 = 77
            if (r7 == r8) goto L_0x00cc
            r8 = 78
            if (r7 == r8) goto L_0x00c3
            if (r6 != 0) goto L_0x00be
            java.lang.String r6 = d(r12, r13)     // Catch:{ IOException -> 0x0178 }
            r0.e(r7, r6)     // Catch:{ IOException -> 0x0178 }
            goto L_0x0173
        L_0x00be:
            r0.e(r7, r12)     // Catch:{ IOException -> 0x0178 }
            goto L_0x0173
        L_0x00c3:
            byte[] r6 = new byte[r11]     // Catch:{ IOException -> 0x0178 }
            r0.u = r6     // Catch:{ IOException -> 0x0178 }
            java.lang.System.arraycopy(r1, r5, r6, r3, r11)     // Catch:{ IOException -> 0x0178 }
            goto L_0x0173
        L_0x00cc:
            byte[] r6 = new byte[r11]     // Catch:{ IOException -> 0x0178 }
            r0.t = r6     // Catch:{ IOException -> 0x0178 }
            java.lang.System.arraycopy(r1, r5, r6, r3, r11)     // Catch:{ IOException -> 0x0178 }
            goto L_0x0173
        L_0x00d5:
            int r8 = r8 + -2
            byte[] r4 = new byte[r8]     // Catch:{ IOException -> 0x0178 }
            byte r6 = (byte) r7     // Catch:{ IOException -> 0x0178 }
            r4[r3] = r6     // Catch:{ IOException -> 0x0178 }
            java.lang.System.arraycopy(r1, r5, r4, r13, r11)     // Catch:{ IOException -> 0x0178 }
            goto L_0x0173
        L_0x00e1:
            java.lang.String r6 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0106 }
            r6.<init>(r12, r10)     // Catch:{ UnsupportedEncodingException -> 0x0106 }
            java.util.Calendar r7 = java.util.Calendar.getInstance()     // Catch:{ UnsupportedEncodingException -> 0x0106 }
            int r8 = r6.length()     // Catch:{ UnsupportedEncodingException -> 0x0106 }
            r10 = 16
            r12 = 15
            if (r8 != r10) goto L_0x0108
            char r8 = r6.charAt(r12)     // Catch:{ UnsupportedEncodingException -> 0x0106 }
            r10 = 90
            if (r8 != r10) goto L_0x0108
            java.lang.String r8 = "UTC"
            java.util.TimeZone r8 = java.util.TimeZone.getTimeZone(r8)     // Catch:{ UnsupportedEncodingException -> 0x0106 }
            r7.setTimeZone(r8)     // Catch:{ UnsupportedEncodingException -> 0x0106 }
            goto L_0x0108
        L_0x0106:
            r0 = move-exception
            goto L_0x015b
        L_0x0108:
            java.lang.String r8 = r6.substring(r3, r9)     // Catch:{ UnsupportedEncodingException -> 0x0106 }
            int r8 = java.lang.Integer.parseInt(r8)     // Catch:{ UnsupportedEncodingException -> 0x0106 }
            r7.set(r13, r8)     // Catch:{ UnsupportedEncodingException -> 0x0106 }
            r8 = 6
            java.lang.String r9 = r6.substring(r9, r8)     // Catch:{ UnsupportedEncodingException -> 0x0106 }
            int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ UnsupportedEncodingException -> 0x0106 }
            r10 = 2
            r7.set(r10, r9)     // Catch:{ UnsupportedEncodingException -> 0x0106 }
            r9 = 8
            java.lang.String r8 = r6.substring(r8, r9)     // Catch:{ UnsupportedEncodingException -> 0x0106 }
            int r8 = java.lang.Integer.parseInt(r8)     // Catch:{ UnsupportedEncodingException -> 0x0106 }
            r9 = 5
            r7.set(r9, r8)     // Catch:{ UnsupportedEncodingException -> 0x0106 }
            r8 = 9
            r9 = 11
            java.lang.String r8 = r6.substring(r8, r9)     // Catch:{ UnsupportedEncodingException -> 0x0106 }
            int r8 = java.lang.Integer.parseInt(r8)     // Catch:{ UnsupportedEncodingException -> 0x0106 }
            r7.set(r9, r8)     // Catch:{ UnsupportedEncodingException -> 0x0106 }
            r8 = 13
            java.lang.String r9 = r6.substring(r9, r8)     // Catch:{ UnsupportedEncodingException -> 0x0106 }
            int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ UnsupportedEncodingException -> 0x0106 }
            r10 = 12
            r7.set(r10, r9)     // Catch:{ UnsupportedEncodingException -> 0x0106 }
            java.lang.String r6 = r6.substring(r8, r12)     // Catch:{ UnsupportedEncodingException -> 0x0106 }
            int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ UnsupportedEncodingException -> 0x0106 }
            r7.set(r8, r6)     // Catch:{ UnsupportedEncodingException -> 0x0106 }
            r0.e(r14, r7)     // Catch:{ UnsupportedEncodingException -> 0x0106 }
            goto L_0x0173
        L_0x015b:
            throw r0     // Catch:{ IOException -> 0x0178 }
        L_0x015c:
            if (r14 != 0) goto L_0x0169
            java.lang.String r6 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0167 }
            r6.<init>(r12, r3, r11, r10)     // Catch:{ UnsupportedEncodingException -> 0x0167 }
            r0.e(r7, r6)     // Catch:{ UnsupportedEncodingException -> 0x0167 }
            goto L_0x0173
        L_0x0167:
            r0 = move-exception
            goto L_0x0176
        L_0x0169:
            java.lang.String r6 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0167 }
            int r8 = r8 + -4
            r6.<init>(r12, r3, r8, r10)     // Catch:{ UnsupportedEncodingException -> 0x0167 }
            r0.e(r7, r6)     // Catch:{ UnsupportedEncodingException -> 0x0167 }
        L_0x0173:
            int r5 = r5 + r11
            goto L_0x0009
        L_0x0176:
            throw r0     // Catch:{ IOException -> 0x0178 }
        L_0x0177:
            return r4
        L_0x0178:
            java.io.IOException r0 = new java.io.IOException
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.obex.ObexHelper.j(javax.obex.HeaderSet, byte[]):byte[]");
    }
}
