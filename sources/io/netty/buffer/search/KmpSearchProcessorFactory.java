package io.netty.buffer.search;

import io.netty.util.internal.PlatformDependent;

public class KmpSearchProcessorFactory extends AbstractSearchProcessorFactory {
    private final int[] jumpTable;
    private final byte[] needle;

    public static class Processor implements SearchProcessor {
        private long currentPosition;
        private final int[] jumpTable;
        private final byte[] needle;

        public Processor(byte[] bArr, int[] iArr) {
            this.needle = bArr;
            this.jumpTable = iArr;
        }

        public boolean process(byte b) {
            while (true) {
                long j = this.currentPosition;
                if (j > 0 && PlatformDependent.getByte(this.needle, j) != b) {
                    this.currentPosition = (long) PlatformDependent.getInt(this.jumpTable, this.currentPosition);
                }
            }
            if (PlatformDependent.getByte(this.needle, this.currentPosition) == b) {
                this.currentPosition++;
            }
            long j2 = this.currentPosition;
            if (j2 != ((long) this.needle.length)) {
                return true;
            }
            this.currentPosition = (long) PlatformDependent.getInt(this.jumpTable, j2);
            return false;
        }

        public void reset() {
            this.currentPosition = 0;
        }
    }

    public KmpSearchProcessorFactory(byte[] bArr) {
        this.needle = (byte[]) bArr.clone();
        int i = 1;
        this.jumpTable = new int[(bArr.length + 1)];
        int i2 = 0;
        while (i < bArr.length) {
            while (i2 > 0 && bArr[i2] != bArr[i]) {
                i2 = this.jumpTable[i2];
            }
            if (bArr[i2] == bArr[i]) {
                i2++;
            }
            i++;
            this.jumpTable[i] = i2;
        }
    }

    public Processor newSearchProcessor() {
        return new Processor(this.needle, this.jumpTable);
    }
}
