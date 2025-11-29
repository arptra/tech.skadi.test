package io.netty.handler.codec.compression;

import java.lang.reflect.Array;

final class Bzip2HuffmanStageDecoder {
    final int alphabetSize;
    private final int[][] codeBases;
    private final int[][] codeLimits;
    private final int[][] codeSymbols;
    int currentAlpha;
    int currentGroup;
    int currentLength = -1;
    int currentSelector;
    private int currentTable;
    private int groupIndex = -1;
    private int groupPosition = -1;
    private final int[] minimumLengths;
    boolean modifyLength;
    private final Bzip2BitReader reader;
    byte[] selectors;
    final byte[][] tableCodeLengths;
    final Bzip2MoveToFrontTable tableMTF = new Bzip2MoveToFrontTable();
    final int totalTables;

    public Bzip2HuffmanStageDecoder(Bzip2BitReader bzip2BitReader, int i, int i2) {
        this.reader = bzip2BitReader;
        this.totalTables = i;
        this.alphabetSize = i2;
        this.minimumLengths = new int[i];
        int[] iArr = new int[2];
        iArr[1] = 25;
        iArr[0] = i;
        Class cls = Integer.TYPE;
        this.codeBases = (int[][]) Array.newInstance(cls, iArr);
        int[] iArr2 = new int[2];
        iArr2[1] = 24;
        iArr2[0] = i;
        this.codeLimits = (int[][]) Array.newInstance(cls, iArr2);
        int[] iArr3 = new int[2];
        iArr3[1] = 258;
        iArr3[0] = i;
        this.codeSymbols = (int[][]) Array.newInstance(cls, iArr3);
        int[] iArr4 = new int[2];
        iArr4[1] = 258;
        iArr4[0] = i;
        this.tableCodeLengths = (byte[][]) Array.newInstance(Byte.TYPE, iArr4);
    }

    public void createHuffmanDecodingTables() {
        int i = this.alphabetSize;
        int i2 = 0;
        while (true) {
            byte[][] bArr = this.tableCodeLengths;
            if (i2 < bArr.length) {
                int[] iArr = this.codeBases[i2];
                int[] iArr2 = this.codeLimits[i2];
                int[] iArr3 = this.codeSymbols[i2];
                byte[] bArr2 = bArr[i2];
                int i3 = 23;
                int i4 = 0;
                for (int i5 = 0; i5 < i; i5++) {
                    byte b = bArr2[i5];
                    i4 = Math.max(b, i4);
                    i3 = Math.min(b, i3);
                }
                this.minimumLengths[i2] = i3;
                for (int i6 = 0; i6 < i; i6++) {
                    int i7 = bArr2[i6] + 1;
                    iArr[i7] = iArr[i7] + 1;
                }
                int i8 = iArr[0];
                for (int i9 = 1; i9 < 25; i9++) {
                    i8 += iArr[i9];
                    iArr[i9] = i8;
                }
                int i10 = 0;
                int i11 = i3;
                while (i11 <= i4) {
                    int i12 = i11 + 1;
                    int i13 = iArr[i12];
                    int i14 = iArr[i11];
                    int i15 = (i13 - i14) + i10;
                    iArr[i11] = i10 - i14;
                    iArr2[i11] = i15 - 1;
                    i10 = i15 << 1;
                    i11 = i12;
                }
                int i16 = 0;
                while (i3 <= i4) {
                    for (int i17 = 0; i17 < i; i17++) {
                        if (bArr2[i17] == i3) {
                            iArr3[i16] = i17;
                            i16++;
                        }
                    }
                    i3++;
                }
                i2++;
            } else {
                this.currentTable = this.selectors[0];
                return;
            }
        }
    }

    public int nextSymbol() {
        int i = this.groupPosition + 1;
        this.groupPosition = i;
        if (i % 50 == 0) {
            int i2 = this.groupIndex + 1;
            this.groupIndex = i2;
            byte[] bArr = this.selectors;
            if (i2 != bArr.length) {
                this.currentTable = bArr[i2] & 255;
            } else {
                throw new DecompressionException("error decoding block");
            }
        }
        Bzip2BitReader bzip2BitReader = this.reader;
        int i3 = this.currentTable;
        int[] iArr = this.codeLimits[i3];
        int[] iArr2 = this.codeBases[i3];
        int[] iArr3 = this.codeSymbols[i3];
        int i4 = this.minimumLengths[i3];
        int readBits = bzip2BitReader.readBits(i4);
        while (i4 <= 23) {
            if (readBits <= iArr[i4]) {
                return iArr3[readBits - iArr2[i4]];
            }
            readBits = (readBits << 1) | bzip2BitReader.readBits(1);
            i4++;
        }
        throw new DecompressionException("a valid code was not recognised");
    }
}
