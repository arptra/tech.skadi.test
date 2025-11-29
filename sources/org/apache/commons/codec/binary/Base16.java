package org.apache.commons.codec.binary;

import org.apache.commons.codec.CodecPolicy;
import org.apache.commons.codec.binary.BaseNCodec;

public class Base16 extends BaseNCodec {
    private static final int BITS_PER_ENCODED_BYTE = 4;
    private static final int BYTES_PER_ENCODED_BLOCK = 2;
    private static final int BYTES_PER_UNENCODED_BLOCK = 1;
    private static final byte[] LOWER_CASE_DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15};
    private static final byte[] LOWER_CASE_ENCODE_TABLE = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    private static final int MASK_4BITS = 15;
    private static final byte[] UPPER_CASE_DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15};
    private static final byte[] UPPER_CASE_ENCODE_TABLE = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};
    private final byte[] decodeTable;
    private final byte[] encodeTable;

    public Base16() {
        this(false);
    }

    private int decodeOctet(byte b) {
        byte b2 = b & 255;
        byte[] bArr = this.decodeTable;
        byte b3 = b2 < bArr.length ? bArr[b] : -1;
        if (b3 != -1) {
            return b3;
        }
        throw new IllegalArgumentException("Invalid octet in encoded value: " + b);
    }

    private void validateTrailingCharacter() {
        if (isStrictDecoding()) {
            throw new IllegalArgumentException("Strict decoding: Last encoded character is a valid base 16 alphabetcharacter but not a possible encoding. Decoding requires at least two characters to create one byte.");
        }
    }

    public void decode(byte[] bArr, int i, int i2, BaseNCodec.Context context) {
        if (context.eof || i2 < 0) {
            context.eof = true;
            if (context.ibitWorkArea != 0) {
                validateTrailingCharacter();
                return;
            }
            return;
        }
        int min = Math.min(bArr.length - i, i2);
        int i3 = 0;
        int i4 = (context.ibitWorkArea != 0 ? 1 : 0) + min;
        if (i4 == 1 && i4 == min) {
            context.ibitWorkArea = decodeOctet(bArr[i]) + 1;
            return;
        }
        int i5 = i4 % 2 == 0 ? i4 : i4 - 1;
        byte[] ensureBufferSize = ensureBufferSize(i5 / 2, context);
        if (min < i4) {
            int i6 = i + 1;
            int decodeOctet = decodeOctet(bArr[i]) | ((context.ibitWorkArea - 1) << 4);
            int i7 = context.pos;
            context.pos = i7 + 1;
            ensureBufferSize[i7] = (byte) decodeOctet;
            context.ibitWorkArea = 0;
            i3 = 2;
            i = i6;
        }
        while (i3 < i5) {
            int i8 = i + 1;
            i += 2;
            int decodeOctet2 = decodeOctet(bArr[i8]) | (decodeOctet(bArr[i]) << 4);
            i3 += 2;
            int i9 = context.pos;
            context.pos = i9 + 1;
            ensureBufferSize[i9] = (byte) decodeOctet2;
        }
        if (i3 < min) {
            context.ibitWorkArea = decodeOctet(bArr[i3]) + 1;
        }
    }

    public void encode(byte[] bArr, int i, int i2, BaseNCodec.Context context) {
        if (!context.eof) {
            if (i2 < 0) {
                context.eof = true;
                return;
            }
            int i3 = i2 * 2;
            if (i3 >= 0) {
                byte[] ensureBufferSize = ensureBufferSize(i3, context);
                int i4 = i2 + i;
                while (i < i4) {
                    byte b = bArr[i];
                    int i5 = context.pos;
                    byte[] bArr2 = this.encodeTable;
                    ensureBufferSize[i5] = bArr2[(b >> 4) & 15];
                    context.pos = i5 + 2;
                    ensureBufferSize[i5 + 1] = bArr2[b & 15];
                    i++;
                }
                return;
            }
            throw new IllegalArgumentException("Input length exceeds maximum size for encoded data: " + i2);
        }
    }

    public boolean isInAlphabet(byte b) {
        byte b2 = b & 255;
        byte[] bArr = this.decodeTable;
        return b2 < bArr.length && bArr[b] != -1;
    }

    public Base16(boolean z) {
        this(z, BaseNCodec.DECODING_POLICY_DEFAULT);
    }

    public Base16(boolean z, CodecPolicy codecPolicy) {
        super(1, 2, 0, 0, (byte) 61, codecPolicy);
        if (z) {
            this.encodeTable = LOWER_CASE_ENCODE_TABLE;
            this.decodeTable = LOWER_CASE_DECODE_TABLE;
            return;
        }
        this.encodeTable = UPPER_CASE_ENCODE_TABLE;
        this.decodeTable = UPPER_CASE_DECODE_TABLE;
    }
}
