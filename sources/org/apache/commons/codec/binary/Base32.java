package org.apache.commons.codec.binary;

import com.xjsd.ai.assistant.protocol.CmdCode;
import org.apache.commons.codec.CodecPolicy;
import org.apache.commons.codec.binary.BaseNCodec;

public class Base32 extends BaseNCodec {
    private static final int BITS_PER_ENCODED_BYTE = 5;
    private static final int BYTES_PER_ENCODED_BLOCK = 8;
    private static final int BYTES_PER_UNENCODED_BLOCK = 5;
    private static final byte[] DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
    private static final byte[] ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 50, 51, 52, 53, 54, 55};
    private static final byte[] HEX_DECODE_TABLE;
    private static final byte[] HEX_ENCODE_TABLE = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86};
    private static final long MASK_1BITS = 1;
    private static final long MASK_2BITS = 3;
    private static final long MASK_3BITS = 7;
    private static final long MASK_4BITS = 15;
    private static final int MASK_5BITS = 31;
    private final int decodeSize;
    private final byte[] decodeTable;
    private final int encodeSize;
    private final byte[] encodeTable;
    private final byte[] lineSeparator;

    static {
        byte[] bArr = new byte[CmdCode.CODE_RESET_VAD_STATUS];
        // fill-array-data instruction
        bArr[0] = -1;
        bArr[1] = -1;
        bArr[2] = -1;
        bArr[3] = -1;
        bArr[4] = -1;
        bArr[5] = -1;
        bArr[6] = -1;
        bArr[7] = -1;
        bArr[8] = -1;
        bArr[9] = -1;
        bArr[10] = -1;
        bArr[11] = -1;
        bArr[12] = -1;
        bArr[13] = -1;
        bArr[14] = -1;
        bArr[15] = -1;
        bArr[16] = -1;
        bArr[17] = -1;
        bArr[18] = -1;
        bArr[19] = -1;
        bArr[20] = -1;
        bArr[21] = -1;
        bArr[22] = -1;
        bArr[23] = -1;
        bArr[24] = -1;
        bArr[25] = -1;
        bArr[26] = -1;
        bArr[27] = -1;
        bArr[28] = -1;
        bArr[29] = -1;
        bArr[30] = -1;
        bArr[31] = -1;
        bArr[32] = -1;
        bArr[33] = -1;
        bArr[34] = -1;
        bArr[35] = -1;
        bArr[36] = -1;
        bArr[37] = -1;
        bArr[38] = -1;
        bArr[39] = -1;
        bArr[40] = -1;
        bArr[41] = -1;
        bArr[42] = -1;
        bArr[43] = -1;
        bArr[44] = -1;
        bArr[45] = -1;
        bArr[46] = -1;
        bArr[47] = -1;
        bArr[48] = 0;
        bArr[49] = 1;
        bArr[50] = 2;
        bArr[51] = 3;
        bArr[52] = 4;
        bArr[53] = 5;
        bArr[54] = 6;
        bArr[55] = 7;
        bArr[56] = 8;
        bArr[57] = 9;
        bArr[58] = -1;
        bArr[59] = -1;
        bArr[60] = -1;
        bArr[61] = -1;
        bArr[62] = -1;
        bArr[63] = -1;
        bArr[64] = -1;
        bArr[65] = 10;
        bArr[66] = 11;
        bArr[67] = 12;
        bArr[68] = 13;
        bArr[69] = 14;
        bArr[70] = 15;
        bArr[71] = 16;
        bArr[72] = 17;
        bArr[73] = 18;
        bArr[74] = 19;
        bArr[75] = 20;
        bArr[76] = 21;
        bArr[77] = 22;
        bArr[78] = 23;
        bArr[79] = 24;
        bArr[80] = 25;
        bArr[81] = 26;
        bArr[82] = 27;
        bArr[83] = 28;
        bArr[84] = 29;
        bArr[85] = 30;
        bArr[86] = 31;
        bArr[87] = -1;
        bArr[88] = -1;
        bArr[89] = -1;
        bArr[90] = -1;
        bArr[91] = -1;
        bArr[92] = -1;
        bArr[93] = -1;
        bArr[94] = -1;
        bArr[95] = -1;
        bArr[96] = -1;
        bArr[97] = 10;
        bArr[98] = 11;
        bArr[99] = 12;
        bArr[100] = 13;
        bArr[101] = 14;
        bArr[102] = 15;
        bArr[103] = 16;
        bArr[104] = 17;
        bArr[105] = 18;
        bArr[106] = 19;
        bArr[107] = 20;
        bArr[108] = 21;
        bArr[109] = 22;
        bArr[110] = 23;
        bArr[111] = 24;
        bArr[112] = 25;
        bArr[113] = 26;
        bArr[114] = 27;
        bArr[115] = 28;
        bArr[116] = 29;
        bArr[117] = 30;
        bArr[118] = 31;
        HEX_DECODE_TABLE = bArr;
    }

    public Base32() {
        this(false);
    }

    private void validateCharacter(long j, BaseNCodec.Context context) {
        if (isStrictDecoding() && (context.lbitWorkArea & j) != 0) {
            throw new IllegalArgumentException("Strict decoding: Last encoded character (before the paddings if any) is a valid base 32 alphabet but not a possible encoding. Expected the discarded bits from the character to be zero.");
        }
    }

    private void validateTrailingCharacters() {
        if (isStrictDecoding()) {
            throw new IllegalArgumentException("Strict decoding: Last encoded character(s) (before the paddings if any) are valid base 32 alphabet but not a possible encoding. Decoding requires either 2, 4, 5, or 7 trailing 5-bit characters to create bytes.");
        }
    }

    public void decode(byte[] bArr, int i, int i2, BaseNCodec.Context context) {
        byte b;
        int i3 = i2;
        BaseNCodec.Context context2 = context;
        if (!context2.eof) {
            boolean z = true;
            if (i3 < 0) {
                context2.eof = true;
            }
            int i4 = 0;
            int i5 = i;
            while (true) {
                if (i4 >= i3) {
                    break;
                }
                int i6 = i5 + 1;
                byte b2 = bArr[i5];
                if (b2 == this.pad) {
                    context2.eof = z;
                    break;
                }
                byte[] ensureBufferSize = ensureBufferSize(this.decodeSize, context2);
                if (b2 >= 0) {
                    byte[] bArr2 = this.decodeTable;
                    if (b2 < bArr2.length && (b = bArr2[b2]) >= 0) {
                        int i7 = (context2.modulus + (z ? 1 : 0)) % 8;
                        context2.modulus = i7;
                        long j = (context2.lbitWorkArea << 5) + ((long) b);
                        context2.lbitWorkArea = j;
                        if (i7 == 0) {
                            int i8 = context2.pos;
                            ensureBufferSize[i8] = (byte) ((int) ((j >> 32) & 255));
                            ensureBufferSize[i8 + 1] = (byte) ((int) ((j >> 24) & 255));
                            ensureBufferSize[i8 + 2] = (byte) ((int) ((j >> 16) & 255));
                            ensureBufferSize[i8 + 3] = (byte) ((int) ((j >> 8) & 255));
                            context2.pos = i8 + 5;
                            ensureBufferSize[i8 + 4] = (byte) ((int) (j & 255));
                        }
                    }
                }
                i4++;
                i5 = i6;
                z = true;
            }
            if (context2.eof && context2.modulus > 0) {
                byte[] ensureBufferSize2 = ensureBufferSize(this.decodeSize, context2);
                switch (context2.modulus) {
                    case 1:
                        validateTrailingCharacters();
                        break;
                    case 2:
                        break;
                    case 3:
                        validateTrailingCharacters();
                        int i9 = context2.pos;
                        context2.pos = i9 + 1;
                        ensureBufferSize2[i9] = (byte) ((int) ((context2.lbitWorkArea >> MASK_3BITS) & 255));
                        return;
                    case 4:
                        validateCharacter(15, context2);
                        long j2 = context2.lbitWorkArea;
                        long j3 = j2 >> 4;
                        context2.lbitWorkArea = j3;
                        int i10 = context2.pos;
                        ensureBufferSize2[i10] = (byte) ((int) ((j2 >> 12) & 255));
                        context2.pos = i10 + 2;
                        ensureBufferSize2[i10 + 1] = (byte) ((int) (j3 & 255));
                        return;
                    case 5:
                        validateCharacter(1, context2);
                        long j4 = context2.lbitWorkArea;
                        long j5 = j4 >> 1;
                        context2.lbitWorkArea = j5;
                        int i11 = context2.pos;
                        ensureBufferSize2[i11] = (byte) ((int) ((j4 >> 17) & 255));
                        ensureBufferSize2[i11 + 1] = (byte) ((int) ((j4 >> 9) & 255));
                        context2.pos = i11 + 3;
                        ensureBufferSize2[i11 + 2] = (byte) ((int) (j5 & 255));
                        return;
                    case 6:
                        validateTrailingCharacters();
                        long j6 = context2.lbitWorkArea;
                        long j7 = j6 >> 6;
                        context2.lbitWorkArea = j7;
                        int i12 = context2.pos;
                        ensureBufferSize2[i12] = (byte) ((int) ((j6 >> 22) & 255));
                        ensureBufferSize2[i12 + 1] = (byte) ((int) ((j6 >> 14) & 255));
                        context2.pos = i12 + 3;
                        ensureBufferSize2[i12 + 2] = (byte) ((int) (j7 & 255));
                        return;
                    case 7:
                        validateCharacter(MASK_3BITS, context2);
                        long j8 = context2.lbitWorkArea;
                        long j9 = j8 >> 3;
                        context2.lbitWorkArea = j9;
                        int i13 = context2.pos;
                        ensureBufferSize2[i13] = (byte) ((int) ((j8 >> 27) & 255));
                        ensureBufferSize2[i13 + 1] = (byte) ((int) ((j8 >> 19) & 255));
                        ensureBufferSize2[i13 + 2] = (byte) ((int) ((j8 >> 11) & 255));
                        context2.pos = i13 + 4;
                        ensureBufferSize2[i13 + 3] = (byte) ((int) (j9 & 255));
                        return;
                    default:
                        throw new IllegalStateException("Impossible modulus " + context2.modulus);
                }
                validateCharacter(3, context2);
                int i14 = context2.pos;
                context2.pos = i14 + 1;
                ensureBufferSize2[i14] = (byte) ((int) ((context2.lbitWorkArea >> 2) & 255));
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void encode(byte[] r17, int r18, int r19, org.apache.commons.codec.binary.BaseNCodec.Context r20) {
        /*
            r16 = this;
            r0 = r16
            r1 = r19
            r2 = r20
            boolean r3 = r2.eof
            if (r3 == 0) goto L_0x000b
            return
        L_0x000b:
            r3 = 0
            r4 = 1
            if (r1 >= 0) goto L_0x019e
            r2.eof = r4
            int r1 = r2.modulus
            if (r1 != 0) goto L_0x001a
            int r1 = r0.lineLength
            if (r1 != 0) goto L_0x001a
            return
        L_0x001a:
            int r1 = r0.encodeSize
            byte[] r1 = r0.ensureBufferSize(r1, r2)
            int r5 = r2.pos
            int r6 = r2.modulus
            if (r6 == 0) goto L_0x017f
            r7 = 3
            r8 = 2
            if (r6 == r4) goto L_0x0149
            r9 = 4
            if (r6 == r8) goto L_0x0101
            if (r6 == r7) goto L_0x00ae
            if (r6 != r9) goto L_0x0095
            int r4 = r5 + 1
            byte[] r6 = r0.encodeTable
            long r9 = r2.lbitWorkArea
            r11 = 27
            long r11 = r9 >> r11
            int r11 = (int) r11
            r11 = r11 & 31
            byte r11 = r6[r11]
            r1[r5] = r11
            int r11 = r5 + 2
            r12 = 22
            long r12 = r9 >> r12
            int r12 = (int) r12
            r12 = r12 & 31
            byte r12 = r6[r12]
            r1[r4] = r12
            int r4 = r5 + 3
            r12 = 17
            long r12 = r9 >> r12
            int r12 = (int) r12
            r12 = r12 & 31
            byte r12 = r6[r12]
            r1[r11] = r12
            int r11 = r5 + 4
            r12 = 12
            long r12 = r9 >> r12
            int r12 = (int) r12
            r12 = r12 & 31
            byte r12 = r6[r12]
            r1[r4] = r12
            int r4 = r5 + 5
            r12 = 7
            long r12 = r9 >> r12
            int r12 = (int) r12
            r12 = r12 & 31
            byte r12 = r6[r12]
            r1[r11] = r12
            int r11 = r5 + 6
            long r12 = r9 >> r8
            int r8 = (int) r12
            r8 = r8 & 31
            byte r8 = r6[r8]
            r1[r4] = r8
            int r4 = r5 + 7
            long r7 = r9 << r7
            int r7 = (int) r7
            r7 = r7 & 31
            byte r6 = r6[r7]
            r1[r11] = r6
            int r6 = r5 + 8
            r2.pos = r6
            byte r6 = r0.pad
            r1[r4] = r6
            goto L_0x017f
        L_0x0095:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Impossible modulus "
            r1.append(r3)
            int r2 = r2.modulus
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00ae:
            int r6 = r5 + 1
            byte[] r7 = r0.encodeTable
            long r10 = r2.lbitWorkArea
            r8 = 19
            long r12 = r10 >> r8
            int r8 = (int) r12
            r8 = r8 & 31
            byte r8 = r7[r8]
            r1[r5] = r8
            int r8 = r5 + 2
            r12 = 14
            long r12 = r10 >> r12
            int r12 = (int) r12
            r12 = r12 & 31
            byte r12 = r7[r12]
            r1[r6] = r12
            int r6 = r5 + 3
            r12 = 9
            long r12 = r10 >> r12
            int r12 = (int) r12
            r12 = r12 & 31
            byte r12 = r7[r12]
            r1[r8] = r12
            int r8 = r5 + 4
            long r12 = r10 >> r9
            int r9 = (int) r12
            r9 = r9 & 31
            byte r9 = r7[r9]
            r1[r6] = r9
            int r6 = r5 + 5
            long r9 = r10 << r4
            int r4 = (int) r9
            r4 = r4 & 31
            byte r4 = r7[r4]
            r1[r8] = r4
            int r4 = r5 + 6
            byte r7 = r0.pad
            r1[r6] = r7
            int r6 = r5 + 7
            r1[r4] = r7
            int r4 = r5 + 8
            r2.pos = r4
            r1[r6] = r7
            goto L_0x017f
        L_0x0101:
            int r6 = r5 + 1
            byte[] r7 = r0.encodeTable
            long r10 = r2.lbitWorkArea
            r8 = 11
            long r12 = r10 >> r8
            int r8 = (int) r12
            r8 = r8 & 31
            byte r8 = r7[r8]
            r1[r5] = r8
            int r8 = r5 + 2
            r12 = 6
            long r12 = r10 >> r12
            int r12 = (int) r12
            r12 = r12 & 31
            byte r12 = r7[r12]
            r1[r6] = r12
            int r6 = r5 + 3
            long r12 = r10 >> r4
            int r4 = (int) r12
            r4 = r4 & 31
            byte r4 = r7[r4]
            r1[r8] = r4
            int r4 = r5 + 4
            long r8 = r10 << r9
            int r8 = (int) r8
            r8 = r8 & 31
            byte r7 = r7[r8]
            r1[r6] = r7
            int r6 = r5 + 5
            byte r7 = r0.pad
            r1[r4] = r7
            int r4 = r5 + 6
            r1[r6] = r7
            int r6 = r5 + 7
            r1[r4] = r7
            int r4 = r5 + 8
            r2.pos = r4
            r1[r6] = r7
            goto L_0x017f
        L_0x0149:
            int r4 = r5 + 1
            byte[] r6 = r0.encodeTable
            long r9 = r2.lbitWorkArea
            long r11 = r9 >> r7
            int r7 = (int) r11
            r7 = r7 & 31
            byte r7 = r6[r7]
            r1[r5] = r7
            int r7 = r5 + 2
            long r8 = r9 << r8
            int r8 = (int) r8
            r8 = r8 & 31
            byte r6 = r6[r8]
            r1[r4] = r6
            int r4 = r5 + 3
            byte r6 = r0.pad
            r1[r7] = r6
            int r7 = r5 + 4
            r1[r4] = r6
            int r4 = r5 + 5
            r1[r7] = r6
            int r7 = r5 + 6
            r1[r4] = r6
            int r4 = r5 + 7
            r1[r7] = r6
            int r7 = r5 + 8
            r2.pos = r7
            r1[r4] = r6
        L_0x017f:
            int r4 = r2.currentLinePos
            int r6 = r2.pos
            int r5 = r6 - r5
            int r4 = r4 + r5
            r2.currentLinePos = r4
            int r5 = r0.lineLength
            if (r5 <= 0) goto L_0x0254
            if (r4 <= 0) goto L_0x0254
            byte[] r4 = r0.lineSeparator
            int r5 = r4.length
            java.lang.System.arraycopy(r4, r3, r1, r6, r5)
            int r1 = r2.pos
            byte[] r0 = r0.lineSeparator
            int r0 = r0.length
            int r1 = r1 + r0
            r2.pos = r1
            goto L_0x0254
        L_0x019e:
            r5 = r18
            r6 = r3
        L_0x01a1:
            if (r6 >= r1) goto L_0x0254
            int r7 = r0.encodeSize
            byte[] r7 = r0.ensureBufferSize(r7, r2)
            int r8 = r2.modulus
            int r8 = r8 + r4
            r9 = 5
            int r8 = r8 % r9
            r2.modulus = r8
            int r10 = r5 + 1
            byte r5 = r17[r5]
            if (r5 >= 0) goto L_0x01b8
            int r5 = r5 + 256
        L_0x01b8:
            long r11 = r2.lbitWorkArea
            r13 = 8
            long r11 = r11 << r13
            long r14 = (long) r5
            long r11 = r11 + r14
            r2.lbitWorkArea = r11
            if (r8 != 0) goto L_0x024b
            int r5 = r2.pos
            int r8 = r5 + 1
            byte[] r14 = r0.encodeTable
            r15 = 35
            long r3 = r11 >> r15
            int r3 = (int) r3
            r3 = r3 & 31
            byte r3 = r14[r3]
            r7[r5] = r3
            int r3 = r5 + 2
            r4 = 30
            r15 = r10
            long r9 = r11 >> r4
            int r4 = (int) r9
            r4 = r4 & 31
            byte r4 = r14[r4]
            r7[r8] = r4
            int r4 = r5 + 3
            r8 = 25
            long r8 = r11 >> r8
            int r8 = (int) r8
            r8 = r8 & 31
            byte r8 = r14[r8]
            r7[r3] = r8
            int r3 = r5 + 4
            r8 = 20
            long r8 = r11 >> r8
            int r8 = (int) r8
            r8 = r8 & 31
            byte r8 = r14[r8]
            r7[r4] = r8
            int r4 = r5 + 5
            r8 = 15
            long r8 = r11 >> r8
            int r8 = (int) r8
            r8 = r8 & 31
            byte r8 = r14[r8]
            r7[r3] = r8
            int r3 = r5 + 6
            r8 = 10
            long r8 = r11 >> r8
            int r8 = (int) r8
            r8 = r8 & 31
            byte r8 = r14[r8]
            r7[r4] = r8
            int r4 = r5 + 7
            r8 = 5
            long r8 = r11 >> r8
            int r8 = (int) r8
            r8 = r8 & 31
            byte r8 = r14[r8]
            r7[r3] = r8
            int r5 = r5 + r13
            r2.pos = r5
            int r3 = (int) r11
            r3 = r3 & 31
            byte r3 = r14[r3]
            r7[r4] = r3
            int r3 = r2.currentLinePos
            int r3 = r3 + r13
            r2.currentLinePos = r3
            int r4 = r0.lineLength
            if (r4 <= 0) goto L_0x0249
            if (r4 > r3) goto L_0x0249
            byte[] r3 = r0.lineSeparator
            int r4 = r3.length
            r8 = 0
            java.lang.System.arraycopy(r3, r8, r7, r5, r4)
            int r3 = r2.pos
            byte[] r4 = r0.lineSeparator
            int r4 = r4.length
            int r3 = r3 + r4
            r2.pos = r3
            r2.currentLinePos = r8
            goto L_0x024d
        L_0x0249:
            r8 = 0
            goto L_0x024d
        L_0x024b:
            r8 = r3
            r15 = r10
        L_0x024d:
            int r6 = r6 + 1
            r3 = r8
            r5 = r15
            r4 = 1
            goto L_0x01a1
        L_0x0254:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.binary.Base32.encode(byte[], int, int, org.apache.commons.codec.binary.BaseNCodec$Context):void");
    }

    public boolean isInAlphabet(byte b) {
        if (b >= 0) {
            byte[] bArr = this.decodeTable;
            return b < bArr.length && bArr[b] != -1;
        }
    }

    public Base32(boolean z) {
        this(0, (byte[]) null, z, (byte) 61);
    }

    public Base32(boolean z, byte b) {
        this(0, (byte[]) null, z, b);
    }

    public Base32(byte b) {
        this(false, b);
    }

    public Base32(int i) {
        this(i, BaseNCodec.CHUNK_SEPARATOR);
    }

    public Base32(int i, byte[] bArr) {
        this(i, bArr, false, (byte) 61);
    }

    public Base32(int i, byte[] bArr, boolean z) {
        this(i, bArr, z, (byte) 61);
    }

    public Base32(int i, byte[] bArr, boolean z, byte b) {
        this(i, bArr, z, b, BaseNCodec.DECODING_POLICY_DEFAULT);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Base32(int i, byte[] bArr, boolean z, byte b, CodecPolicy codecPolicy) {
        super(5, 8, i, bArr == null ? 0 : bArr.length, b, codecPolicy);
        if (z) {
            this.encodeTable = HEX_ENCODE_TABLE;
            this.decodeTable = HEX_DECODE_TABLE;
        } else {
            this.encodeTable = ENCODE_TABLE;
            this.decodeTable = DECODE_TABLE;
        }
        if (i <= 0) {
            this.encodeSize = 8;
            this.lineSeparator = null;
        } else if (bArr == null) {
            throw new IllegalArgumentException("lineLength " + i + " > 0, but lineSeparator is null");
        } else if (!containsAlphabetOrPad(bArr)) {
            this.encodeSize = bArr.length + 8;
            byte[] bArr2 = new byte[bArr.length];
            this.lineSeparator = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        } else {
            String newStringUtf8 = StringUtils.newStringUtf8(bArr);
            throw new IllegalArgumentException("lineSeparator must not contain Base32 characters: [" + newStringUtf8 + "]");
        }
        this.decodeSize = this.encodeSize - 1;
        if (isInAlphabet(b) || BaseNCodec.isWhiteSpace(b)) {
            throw new IllegalArgumentException("pad must not be in alphabet or whitespace");
        }
    }
}
