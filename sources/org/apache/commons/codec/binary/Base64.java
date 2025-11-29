package org.apache.commons.codec.binary;

import com.upuphone.starrynet.strategy.message.payload.handler.RingDataUtil;
import com.upuphone.starrynet.strategy.pair.ble.RingSecurityPair;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.math.BigInteger;
import java.util.Objects;
import okio.Utf8;
import org.apache.commons.codec.CodecPolicy;
import org.apache.commons.codec.binary.BaseNCodec;

public class Base64 extends BaseNCodec {
    private static final int BITS_PER_ENCODED_BYTE = 6;
    private static final int BYTES_PER_ENCODED_BLOCK = 4;
    private static final int BYTES_PER_UNENCODED_BLOCK = 3;
    private static final byte[] DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, HttpConstants.COLON, HttpConstants.SEMICOLON, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, Utf8.REPLACEMENT_BYTE, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, BinaryMemcacheOpcodes.GATKQ, 37, 38, 39, RingDataUtil.OPCODE_SET_GET_RING_NAME, RingDataUtil.OPCODE_QUERY_ALGO_STATE, 42, 43, HttpConstants.COMMA, 45, 46, 47, 48, 49, 50, 51};
    private static final int MASK_2BITS = 3;
    private static final int MASK_4BITS = 15;
    private static final int MASK_6BITS = 63;
    private static final byte[] STANDARD_ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, RingSecurityPair.OPCODE_RING_PAIR, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] URL_SAFE_ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, RingSecurityPair.OPCODE_RING_PAIR, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private final int decodeSize;
    private final byte[] decodeTable;
    private final int encodeSize;
    private final byte[] encodeTable;
    private final byte[] lineSeparator;

    public Base64() {
        this(0);
    }

    public static byte[] decodeBase64(byte[] bArr) {
        return new Base64().decode(bArr);
    }

    public static BigInteger decodeInteger(byte[] bArr) {
        return new BigInteger(1, decodeBase64(bArr));
    }

    public static byte[] encodeBase64(byte[] bArr) {
        return encodeBase64(bArr, false);
    }

    public static byte[] encodeBase64Chunked(byte[] bArr) {
        return encodeBase64(bArr, true);
    }

    public static String encodeBase64String(byte[] bArr) {
        return StringUtils.newStringUsAscii(encodeBase64(bArr, false));
    }

    public static byte[] encodeBase64URLSafe(byte[] bArr) {
        return encodeBase64(bArr, false, true);
    }

    public static String encodeBase64URLSafeString(byte[] bArr) {
        return StringUtils.newStringUsAscii(encodeBase64(bArr, false, true));
    }

    public static byte[] encodeInteger(BigInteger bigInteger) {
        Objects.requireNonNull(bigInteger, "bigInteger");
        return encodeBase64(toIntegerBytes(bigInteger), false);
    }

    @Deprecated
    public static boolean isArrayByteBase64(byte[] bArr) {
        return isBase64(bArr);
    }

    public static boolean isBase64(byte b) {
        if (b != 61) {
            if (b >= 0) {
                byte[] bArr = DECODE_TABLE;
                if (b >= bArr.length || bArr[b] == -1) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public static byte[] toIntegerBytes(BigInteger bigInteger) {
        int bitLength = ((bigInteger.bitLength() + 7) >> 3) << 3;
        byte[] byteArray = bigInteger.toByteArray();
        int i = 1;
        if (bigInteger.bitLength() % 8 != 0 && (bigInteger.bitLength() / 8) + 1 == bitLength / 8) {
            return byteArray;
        }
        int length = byteArray.length;
        if (bigInteger.bitLength() % 8 == 0) {
            length--;
        } else {
            i = 0;
        }
        int i2 = bitLength / 8;
        int i3 = i2 - length;
        byte[] bArr = new byte[i2];
        System.arraycopy(byteArray, i, bArr, i3, length);
        return bArr;
    }

    private void validateCharacter(int i, BaseNCodec.Context context) {
        if (isStrictDecoding() && (context.ibitWorkArea & i) != 0) {
            throw new IllegalArgumentException("Strict decoding: Last encoded character (before the paddings if any) is a valid base 64 alphabet but not a possible encoding. Expected the discarded bits from the character to be zero.");
        }
    }

    private void validateTrailingCharacter() {
        if (isStrictDecoding()) {
            throw new IllegalArgumentException("Strict decoding: Last encoded character (before the paddings if any) is a valid base 64 alphabet but not a possible encoding. Decoding requires at least two trailing 6-bit characters to create bytes.");
        }
    }

    public void decode(byte[] bArr, int i, int i2, BaseNCodec.Context context) {
        byte b;
        if (!context.eof) {
            if (i2 < 0) {
                context.eof = true;
            }
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    break;
                }
                byte[] ensureBufferSize = ensureBufferSize(this.decodeSize, context);
                int i4 = i + 1;
                byte b2 = bArr[i];
                if (b2 == this.pad) {
                    context.eof = true;
                    break;
                }
                if (b2 >= 0) {
                    byte[] bArr2 = DECODE_TABLE;
                    if (b2 < bArr2.length && (b = bArr2[b2]) >= 0) {
                        int i5 = (context.modulus + 1) % 4;
                        context.modulus = i5;
                        int i6 = (context.ibitWorkArea << 6) + b;
                        context.ibitWorkArea = i6;
                        if (i5 == 0) {
                            int i7 = context.pos;
                            ensureBufferSize[i7] = (byte) ((i6 >> 16) & 255);
                            ensureBufferSize[i7 + 1] = (byte) ((i6 >> 8) & 255);
                            context.pos = i7 + 3;
                            ensureBufferSize[i7 + 2] = (byte) (i6 & 255);
                        }
                    }
                }
                i3++;
                i = i4;
            }
            if (context.eof && context.modulus != 0) {
                byte[] ensureBufferSize2 = ensureBufferSize(this.decodeSize, context);
                int i8 = context.modulus;
                if (i8 == 1) {
                    validateTrailingCharacter();
                } else if (i8 == 2) {
                    validateCharacter(15, context);
                    int i9 = context.ibitWorkArea >> 4;
                    context.ibitWorkArea = i9;
                    int i10 = context.pos;
                    context.pos = i10 + 1;
                    ensureBufferSize2[i10] = (byte) (i9 & 255);
                } else if (i8 == 3) {
                    validateCharacter(3, context);
                    int i11 = context.ibitWorkArea;
                    int i12 = i11 >> 2;
                    context.ibitWorkArea = i12;
                    int i13 = context.pos;
                    ensureBufferSize2[i13] = (byte) ((i11 >> 10) & 255);
                    context.pos = i13 + 2;
                    ensureBufferSize2[i13 + 1] = (byte) (i12 & 255);
                } else {
                    throw new IllegalStateException("Impossible modulus " + context.modulus);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v17, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void encode(byte[] r11, int r12, int r13, org.apache.commons.codec.binary.BaseNCodec.Context r14) {
        /*
            r10 = this;
            boolean r0 = r14.eof
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 0
            r1 = 1
            if (r13 >= 0) goto L_0x00b7
            r14.eof = r1
            int r11 = r14.modulus
            if (r11 != 0) goto L_0x0014
            int r11 = r10.lineLength
            if (r11 != 0) goto L_0x0014
            return
        L_0x0014:
            int r11 = r10.encodeSize
            byte[] r11 = r10.ensureBufferSize(r11, r14)
            int r12 = r14.pos
            int r13 = r14.modulus
            if (r13 == 0) goto L_0x0099
            if (r13 == r1) goto L_0x006f
            r1 = 2
            if (r13 != r1) goto L_0x0056
            int r13 = r12 + 1
            byte[] r2 = r10.encodeTable
            int r3 = r14.ibitWorkArea
            int r4 = r3 >> 10
            r4 = r4 & 63
            byte r4 = r2[r4]
            r11[r12] = r4
            int r4 = r12 + 2
            int r5 = r3 >> 4
            r5 = r5 & 63
            byte r5 = r2[r5]
            r11[r13] = r5
            int r13 = r12 + 3
            r14.pos = r13
            int r1 = r3 << 2
            r1 = r1 & 63
            byte r1 = r2[r1]
            r11[r4] = r1
            byte[] r1 = STANDARD_ENCODE_TABLE
            if (r2 != r1) goto L_0x0099
            int r1 = r12 + 4
            r14.pos = r1
            byte r1 = r10.pad
            r11[r13] = r1
            goto L_0x0099
        L_0x0056:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "Impossible modulus "
            r11.append(r12)
            int r12 = r14.modulus
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        L_0x006f:
            int r13 = r12 + 1
            byte[] r1 = r10.encodeTable
            int r2 = r14.ibitWorkArea
            int r3 = r2 >> 2
            r3 = r3 & 63
            byte r3 = r1[r3]
            r11[r12] = r3
            int r3 = r12 + 2
            r14.pos = r3
            int r2 = r2 << 4
            r2 = r2 & 63
            byte r2 = r1[r2]
            r11[r13] = r2
            byte[] r13 = STANDARD_ENCODE_TABLE
            if (r1 != r13) goto L_0x0099
            int r13 = r12 + 3
            byte r1 = r10.pad
            r11[r3] = r1
            int r2 = r12 + 4
            r14.pos = r2
            r11[r13] = r1
        L_0x0099:
            int r13 = r14.currentLinePos
            int r1 = r14.pos
            int r12 = r1 - r12
            int r13 = r13 + r12
            r14.currentLinePos = r13
            int r12 = r10.lineLength
            if (r12 <= 0) goto L_0x0124
            if (r13 <= 0) goto L_0x0124
            byte[] r12 = r10.lineSeparator
            int r13 = r12.length
            java.lang.System.arraycopy(r12, r0, r11, r1, r13)
            int r11 = r14.pos
            byte[] r10 = r10.lineSeparator
            int r10 = r10.length
            int r11 = r11 + r10
            r14.pos = r11
            goto L_0x0124
        L_0x00b7:
            r2 = r0
        L_0x00b8:
            if (r2 >= r13) goto L_0x0124
            int r3 = r10.encodeSize
            byte[] r3 = r10.ensureBufferSize(r3, r14)
            int r4 = r14.modulus
            int r4 = r4 + r1
            int r4 = r4 % 3
            r14.modulus = r4
            int r5 = r12 + 1
            byte r12 = r11[r12]
            if (r12 >= 0) goto L_0x00cf
            int r12 = r12 + 256
        L_0x00cf:
            int r6 = r14.ibitWorkArea
            int r6 = r6 << 8
            int r6 = r6 + r12
            r14.ibitWorkArea = r6
            if (r4 != 0) goto L_0x0120
            int r12 = r14.pos
            int r4 = r12 + 1
            byte[] r7 = r10.encodeTable
            int r8 = r6 >> 18
            r8 = r8 & 63
            byte r8 = r7[r8]
            r3[r12] = r8
            int r8 = r12 + 2
            int r9 = r6 >> 12
            r9 = r9 & 63
            byte r9 = r7[r9]
            r3[r4] = r9
            int r4 = r12 + 3
            int r9 = r6 >> 6
            r9 = r9 & 63
            byte r9 = r7[r9]
            r3[r8] = r9
            int r12 = r12 + 4
            r14.pos = r12
            r6 = r6 & 63
            byte r6 = r7[r6]
            r3[r4] = r6
            int r4 = r14.currentLinePos
            int r4 = r4 + 4
            r14.currentLinePos = r4
            int r6 = r10.lineLength
            if (r6 <= 0) goto L_0x0120
            if (r6 > r4) goto L_0x0120
            byte[] r4 = r10.lineSeparator
            int r6 = r4.length
            java.lang.System.arraycopy(r4, r0, r3, r12, r6)
            int r12 = r14.pos
            byte[] r3 = r10.lineSeparator
            int r3 = r3.length
            int r12 = r12 + r3
            r14.pos = r12
            r14.currentLinePos = r0
        L_0x0120:
            int r2 = r2 + 1
            r12 = r5
            goto L_0x00b8
        L_0x0124:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.binary.Base64.encode(byte[], int, int, org.apache.commons.codec.binary.BaseNCodec$Context):void");
    }

    public boolean isInAlphabet(byte b) {
        if (b >= 0) {
            byte[] bArr = this.decodeTable;
            return b < bArr.length && bArr[b] != -1;
        }
    }

    public boolean isUrlSafe() {
        return this.encodeTable == URL_SAFE_ENCODE_TABLE;
    }

    public Base64(boolean z) {
        this(76, BaseNCodec.CHUNK_SEPARATOR, z);
    }

    public static byte[] decodeBase64(String str) {
        return new Base64().decode(str);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z) {
        return encodeBase64(bArr, z, false);
    }

    public static boolean isBase64(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            if (!isBase64(bArr[i]) && !BaseNCodec.isWhiteSpace(bArr[i])) {
                return false;
            }
        }
        return true;
    }

    public Base64(int i) {
        this(i, BaseNCodec.CHUNK_SEPARATOR);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z, boolean z2) {
        return encodeBase64(bArr, z, z2, Integer.MAX_VALUE);
    }

    public Base64(int i, byte[] bArr) {
        this(i, bArr, false);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z, boolean z2, int i) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        Base64 base64 = z ? new Base64(z2) : new Base64(0, BaseNCodec.CHUNK_SEPARATOR, z2);
        long encodedLength = base64.getEncodedLength(bArr);
        if (encodedLength <= ((long) i)) {
            return base64.encode(bArr);
        }
        throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + encodedLength + ") than the specified maximum size of " + i);
    }

    public static boolean isBase64(String str) {
        return isBase64(StringUtils.getBytesUtf8(str));
    }

    public Base64(int i, byte[] bArr, boolean z) {
        this(i, bArr, z, BaseNCodec.DECODING_POLICY_DEFAULT);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Base64(int i, byte[] bArr, boolean z, CodecPolicy codecPolicy) {
        super(3, 4, i, bArr == null ? 0 : bArr.length, (byte) 61, codecPolicy);
        this.decodeTable = DECODE_TABLE;
        if (bArr == null) {
            this.encodeSize = 4;
            this.lineSeparator = null;
        } else if (containsAlphabetOrPad(bArr)) {
            String newStringUtf8 = StringUtils.newStringUtf8(bArr);
            throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + newStringUtf8 + "]");
        } else if (i > 0) {
            this.encodeSize = bArr.length + 4;
            byte[] bArr2 = new byte[bArr.length];
            this.lineSeparator = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        } else {
            this.encodeSize = 4;
            this.lineSeparator = null;
        }
        this.decodeSize = this.encodeSize - 1;
        this.encodeTable = z ? URL_SAFE_ENCODE_TABLE : STANDARD_ENCODE_TABLE;
    }
}
