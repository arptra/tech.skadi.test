package org.java_websocket.util;

import com.upuphone.starrynet.strategy.message.payload.handler.RingDataUtil;
import com.upuphone.starrynet.strategy.pair.ble.RingSecurityPair;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import okio.Utf8;

public class Base64 {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f3406a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, RingSecurityPair.OPCODE_RING_PAIR, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    public static final byte[] b = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, HttpConstants.COLON, HttpConstants.SEMICOLON, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, BinaryMemcacheOpcodes.GATKQ, 37, 38, 39, RingDataUtil.OPCODE_SET_GET_RING_NAME, RingDataUtil.OPCODE_QUERY_ALGO_STATE, 42, 43, HttpConstants.COMMA, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    public static final byte[] c = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, RingSecurityPair.OPCODE_RING_PAIR, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    public static final byte[] d = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, HttpConstants.COLON, HttpConstants.SEMICOLON, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, Utf8.REPLACEMENT_BYTE, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, BinaryMemcacheOpcodes.GATKQ, 37, 38, 39, RingDataUtil.OPCODE_SET_GET_RING_NAME, RingDataUtil.OPCODE_QUERY_ALGO_STATE, 42, 43, HttpConstants.COMMA, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    public static final byte[] e = {45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, RingSecurityPair.OPCODE_RING_PAIR, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
    public static final byte[] f = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, BinaryMemcacheOpcodes.GATKQ, -9, -9, -9, -9, 37, -9, 38, 39, RingDataUtil.OPCODE_SET_GET_RING_NAME, RingDataUtil.OPCODE_QUERY_ALGO_STATE, 42, 43, HttpConstants.COMMA, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, HttpConstants.COLON, HttpConstants.SEMICOLON, 60, 61, 62, Utf8.REPLACEMENT_BYTE, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    public static int d(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        int i4;
        int i5;
        if (bArr == null) {
            throw new IllegalArgumentException("Source array was null.");
        } else if (bArr2 == null) {
            throw new IllegalArgumentException("Destination array was null.");
        } else if (i < 0 || (i4 = i + 3) >= bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i)}));
        } else if (i2 < 0 || (i5 = i2 + 2) >= bArr2.length) {
            throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", new Object[]{Integer.valueOf(bArr2.length), Integer.valueOf(i2)}));
        } else {
            byte[] k = k(i3);
            byte b2 = bArr[i + 2];
            if (b2 == 61) {
                bArr2[i2] = (byte) ((((k[bArr[i + 1]] & 255) << 12) | ((k[bArr[i]] & 255) << 18)) >>> 16);
                return 1;
            }
            byte b3 = bArr[i4];
            if (b3 == 61) {
                int i6 = ((k[bArr[i + 1]] & 255) << 12) | ((k[bArr[i]] & 255) << 18) | ((k[b2] & 255) << 6);
                bArr2[i2] = (byte) (i6 >>> 16);
                bArr2[i2 + 1] = (byte) (i6 >>> 8);
                return 2;
            }
            byte b4 = ((k[bArr[i + 1]] & 255) << 12) | ((k[bArr[i]] & 255) << 18) | ((k[b2] & 255) << 6) | (k[b3] & 255);
            bArr2[i2] = (byte) (b4 >> 16);
            bArr2[i2 + 1] = (byte) (b4 >> 8);
            bArr2[i5] = (byte) b4;
            return 3;
        }
    }

    public static byte[] e(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        byte[] j = j(i4);
        int i5 = 0;
        int i6 = (i2 > 0 ? (bArr[i] << 24) >>> 8 : 0) | (i2 > 1 ? (bArr[i + 1] << 24) >>> 16 : 0);
        if (i2 > 2) {
            i5 = (bArr[i + 2] << 24) >>> 24;
        }
        int i7 = i6 | i5;
        if (i2 == 1) {
            bArr2[i3] = j[i7 >>> 18];
            bArr2[i3 + 1] = j[(i7 >>> 12) & 63];
            bArr2[i3 + 2] = 61;
            bArr2[i3 + 3] = 61;
            return bArr2;
        } else if (i2 == 2) {
            bArr2[i3] = j[i7 >>> 18];
            bArr2[i3 + 1] = j[(i7 >>> 12) & 63];
            bArr2[i3 + 2] = j[(i7 >>> 6) & 63];
            bArr2[i3 + 3] = 61;
            return bArr2;
        } else if (i2 != 3) {
            return bArr2;
        } else {
            bArr2[i3] = j[i7 >>> 18];
            bArr2[i3 + 1] = j[(i7 >>> 12) & 63];
            bArr2[i3 + 2] = j[(i7 >>> 6) & 63];
            bArr2[i3 + 3] = j[i7 & 63];
            return bArr2;
        }
    }

    public static byte[] f(byte[] bArr, byte[] bArr2, int i, int i2) {
        e(bArr2, 0, i, bArr, 0, i2);
        return bArr;
    }

    public static String g(byte[] bArr) {
        try {
            return h(bArr, 0, bArr.length, 0);
        } catch (IOException unused) {
            return null;
        }
    }

    public static String h(byte[] bArr, int i, int i2, int i3) {
        byte[] i4 = i(bArr, i, i2, i3);
        try {
            return new String(i4, "US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            return new String(i4);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v13, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX WARNING: Can't wrap try/catch for region: R(12:13|14|15|16|17|18|19|20|21|22|23|25) */
    /* JADX WARNING: Can't wrap try/catch for region: R(17:8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|25) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0031 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0034 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x005b A[SYNTHETIC, Splitter:B:46:0x005b] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0060 A[SYNTHETIC, Splitter:B:50:0x0060] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0065 A[SYNTHETIC, Splitter:B:54:0x0065] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] i(byte[] r18, int r19, int r20, int r21) {
        /*
            r0 = r18
            r7 = r19
            r8 = r20
            if (r0 == 0) goto L_0x0120
            if (r7 < 0) goto L_0x0109
            if (r8 < 0) goto L_0x00f2
            int r1 = r7 + r8
            int r2 = r0.length
            if (r1 > r2) goto L_0x00d5
            r1 = r21 & 2
            r9 = 1
            if (r1 == 0) goto L_0x0069
            r1 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0052, all -> 0x004e }
            r2.<init>()     // Catch:{ IOException -> 0x0052, all -> 0x004e }
            org.java_websocket.util.Base64$OutputStream r3 = new org.java_websocket.util.Base64$OutputStream     // Catch:{ IOException -> 0x004a, all -> 0x0047 }
            r4 = r21 | 1
            r3.<init>(r2, r4)     // Catch:{ IOException -> 0x004a, all -> 0x0047 }
            java.util.zip.GZIPOutputStream r4 = new java.util.zip.GZIPOutputStream     // Catch:{ IOException -> 0x0044, all -> 0x0042 }
            r4.<init>(r3)     // Catch:{ IOException -> 0x0044, all -> 0x0042 }
            r4.write(r0, r7, r8)     // Catch:{ IOException -> 0x003f, all -> 0x003c }
            r4.close()     // Catch:{ IOException -> 0x003f, all -> 0x003c }
            r4.close()     // Catch:{ Exception -> 0x0031 }
        L_0x0031:
            r3.close()     // Catch:{ Exception -> 0x0034 }
        L_0x0034:
            r2.close()     // Catch:{ Exception -> 0x0037 }
        L_0x0037:
            byte[] r0 = r2.toByteArray()
            return r0
        L_0x003c:
            r0 = move-exception
        L_0x003d:
            r1 = r4
            goto L_0x0059
        L_0x003f:
            r0 = move-exception
        L_0x0040:
            r1 = r2
            goto L_0x0055
        L_0x0042:
            r0 = move-exception
            goto L_0x0059
        L_0x0044:
            r0 = move-exception
            r4 = r1
            goto L_0x0040
        L_0x0047:
            r0 = move-exception
            r3 = r1
            goto L_0x0059
        L_0x004a:
            r0 = move-exception
            r3 = r1
            r4 = r3
            goto L_0x0040
        L_0x004e:
            r0 = move-exception
            r2 = r1
            r3 = r2
            goto L_0x0059
        L_0x0052:
            r0 = move-exception
            r3 = r1
            r4 = r3
        L_0x0055:
            throw r0     // Catch:{ all -> 0x0056 }
        L_0x0056:
            r0 = move-exception
            r2 = r1
            goto L_0x003d
        L_0x0059:
            if (r1 == 0) goto L_0x005e
            r1.close()     // Catch:{ Exception -> 0x005e }
        L_0x005e:
            if (r3 == 0) goto L_0x0063
            r3.close()     // Catch:{ Exception -> 0x0063 }
        L_0x0063:
            if (r2 == 0) goto L_0x0068
            r2.close()     // Catch:{ Exception -> 0x0068 }
        L_0x0068:
            throw r0
        L_0x0069:
            r1 = r21 & 8
            if (r1 == 0) goto L_0x006f
            r11 = r9
            goto L_0x0070
        L_0x006f:
            r11 = 0
        L_0x0070:
            int r1 = r8 / 3
            r12 = 4
            int r1 = r1 * r12
            int r2 = r8 % 3
            if (r2 <= 0) goto L_0x007a
            r2 = r12
            goto L_0x007b
        L_0x007a:
            r2 = 0
        L_0x007b:
            int r1 = r1 + r2
            if (r11 == 0) goto L_0x0081
            int r2 = r1 / 76
            int r1 = r1 + r2
        L_0x0081:
            r13 = r1
            byte[] r14 = new byte[r13]
            int r15 = r8 + -2
            r6 = 0
            r16 = 0
            r17 = 0
        L_0x008b:
            if (r6 >= r15) goto L_0x00b5
            int r2 = r6 + r7
            r3 = 3
            r1 = r18
            r4 = r14
            r5 = r16
            r10 = r6
            r6 = r21
            e(r1, r2, r3, r4, r5, r6)
            int r1 = r17 + 4
            if (r11 == 0) goto L_0x00ae
            r2 = 76
            if (r1 < r2) goto L_0x00ae
            int r1 = r16 + 4
            r2 = 10
            r14[r1] = r2
            int r16 = r16 + 1
            r17 = 0
            goto L_0x00b0
        L_0x00ae:
            r17 = r1
        L_0x00b0:
            int r6 = r10 + 3
            int r16 = r16 + 4
            goto L_0x008b
        L_0x00b5:
            r10 = r6
            if (r10 >= r8) goto L_0x00c8
            int r2 = r10 + r7
            int r3 = r8 - r10
            r1 = r18
            r4 = r14
            r5 = r16
            r6 = r21
            e(r1, r2, r3, r4, r5, r6)
            int r16 = r16 + 4
        L_0x00c8:
            r0 = r16
            int r13 = r13 - r9
            if (r0 > r13) goto L_0x00d4
            byte[] r1 = new byte[r0]
            r2 = 0
            java.lang.System.arraycopy(r14, r2, r1, r2, r0)
            return r1
        L_0x00d4:
            return r14
        L_0x00d5:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.Integer r2 = java.lang.Integer.valueOf(r19)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r20)
            int r0 = r0.length
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.Object[] r0 = new java.lang.Object[]{r2, r3, r0}
            java.lang.String r2 = "Cannot have offset of %d and length of %d with array of length %d"
            java.lang.String r0 = java.lang.String.format(r2, r0)
            r1.<init>(r0)
            throw r1
        L_0x00f2:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Cannot have length offset: "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0109:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Cannot have negative offset: "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0120:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Cannot serialize a null array."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.java_websocket.util.Base64.i(byte[], int, int, int):byte[]");
    }

    public static final byte[] j(int i) {
        return (i & 16) == 16 ? c : (i & 32) == 32 ? e : f3406a;
    }

    public static final byte[] k(int i) {
        return (i & 16) == 16 ? d : (i & 32) == 32 ? f : b;
    }

    public static class OutputStream extends FilterOutputStream {

        /* renamed from: a  reason: collision with root package name */
        public boolean f3407a;
        public int b;
        public byte[] c;
        public int d;
        public int e;
        public boolean f;
        public byte[] g;
        public boolean h;
        public int i;
        public byte[] j;

        public OutputStream(java.io.OutputStream outputStream, int i2) {
            super(outputStream);
            boolean z = true;
            this.f = (i2 & 8) != 0;
            z = (i2 & 1) == 0 ? false : z;
            this.f3407a = z;
            int i3 = z ? 3 : 4;
            this.d = i3;
            this.c = new byte[i3];
            this.b = 0;
            this.e = 0;
            this.h = false;
            this.g = new byte[4];
            this.i = i2;
            this.j = Base64.k(i2);
        }

        public void a() {
            int i2 = this.b;
            if (i2 <= 0) {
                return;
            }
            if (this.f3407a) {
                this.out.write(Base64.f(this.g, this.c, i2, this.i));
                this.b = 0;
                return;
            }
            throw new IOException("Base64 input not properly padded.");
        }

        public void close() {
            a();
            super.close();
            this.c = null;
            this.out = null;
        }

        public void write(int i2) {
            if (this.h) {
                this.out.write(i2);
            } else if (this.f3407a) {
                byte[] bArr = this.c;
                int i3 = this.b;
                int i4 = i3 + 1;
                this.b = i4;
                bArr[i3] = (byte) i2;
                int i5 = this.d;
                if (i4 >= i5) {
                    this.out.write(Base64.f(this.g, bArr, i5, this.i));
                    int i6 = this.e + 4;
                    this.e = i6;
                    if (this.f && i6 >= 76) {
                        this.out.write(10);
                        this.e = 0;
                    }
                    this.b = 0;
                }
            } else {
                byte b2 = this.j[i2 & 127];
                if (b2 > -5) {
                    byte[] bArr2 = this.c;
                    int i7 = this.b;
                    int i8 = i7 + 1;
                    this.b = i8;
                    bArr2[i7] = (byte) i2;
                    if (i8 >= this.d) {
                        this.out.write(this.g, 0, Base64.d(bArr2, 0, this.g, 0, this.i));
                        this.b = 0;
                    }
                } else if (b2 != -5) {
                    throw new IOException("Invalid character in Base64 data.");
                }
            }
        }

        public void write(byte[] bArr, int i2, int i3) {
            if (this.h) {
                this.out.write(bArr, i2, i3);
                return;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                write(bArr[i2 + i4]);
            }
        }
    }
}
