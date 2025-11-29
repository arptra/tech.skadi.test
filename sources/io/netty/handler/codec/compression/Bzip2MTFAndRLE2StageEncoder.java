package io.netty.handler.codec.compression;

final class Bzip2MTFAndRLE2StageEncoder {
    private int alphabetSize;
    private final int[] bwtBlock;
    private final int bwtLength;
    private final boolean[] bwtValuesPresent;
    private final char[] mtfBlock;
    private int mtfLength;
    private final int[] mtfSymbolFrequencies = new int[258];

    public Bzip2MTFAndRLE2StageEncoder(int[] iArr, int i, boolean[] zArr) {
        this.bwtBlock = iArr;
        this.bwtLength = i;
        this.bwtValuesPresent = zArr;
        this.mtfBlock = new char[(i + 1)];
    }

    public void encode() {
        int i;
        int i2;
        int i3;
        int i4 = this.bwtLength;
        boolean[] zArr = this.bwtValuesPresent;
        int[] iArr = this.bwtBlock;
        char[] cArr = this.mtfBlock;
        int[] iArr2 = this.mtfSymbolFrequencies;
        byte[] bArr = new byte[256];
        Bzip2MoveToFrontTable bzip2MoveToFrontTable = new Bzip2MoveToFrontTable();
        char c = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < 256; i6++) {
            if (zArr[i6]) {
                bArr[i6] = (byte) i5;
                i5++;
            }
        }
        int i7 = i5 + 1;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i8 < i4) {
            int valueToFront = bzip2MoveToFrontTable.valueToFront(bArr[iArr[i8] & 255]);
            if (valueToFront == 0) {
                i9++;
            } else {
                if (i9 > 0) {
                    int i13 = i9 - 1;
                    while (true) {
                        if ((i13 & 1) == 0) {
                            cArr[i10] = c;
                            i11++;
                            i10++;
                            i3 = 1;
                        } else {
                            i3 = 1;
                            cArr[i10] = 1;
                            i12++;
                            i10++;
                        }
                        if (i13 <= i3) {
                            break;
                        }
                        i13 = (i13 - 2) >>> i3;
                        c = 0;
                    }
                    i9 = 0;
                }
                int i14 = valueToFront + 1;
                cArr[i10] = (char) i14;
                iArr2[i14] = iArr2[i14] + 1;
                i10++;
            }
            i8++;
            c = 0;
        }
        if (i9 > 0) {
            int i15 = i9 - 1;
            while (true) {
                if ((i15 & 1) == 0) {
                    cArr[i10] = 0;
                    i11++;
                    i2 = i10 + 1;
                    i = 1;
                } else {
                    i = 1;
                    cArr[i10] = 1;
                    i12++;
                    i2 = i10 + 1;
                }
                if (i15 <= i) {
                    break;
                }
                i15 = (i15 - 2) >>> i;
            }
        } else {
            i = 1;
        }
        cArr[i10] = (char) i7;
        iArr2[i7] = iArr2[i7] + i;
        iArr2[0] = iArr2[0] + i11;
        iArr2[i] = iArr2[i] + i12;
        this.mtfLength = i10 + i;
        this.alphabetSize = i5 + 2;
    }

    public int mtfAlphabetSize() {
        return this.alphabetSize;
    }

    public char[] mtfBlock() {
        return this.mtfBlock;
    }

    public int mtfLength() {
        return this.mtfLength;
    }

    public int[] mtfSymbolFrequencies() {
        return this.mtfSymbolFrequencies;
    }
}
