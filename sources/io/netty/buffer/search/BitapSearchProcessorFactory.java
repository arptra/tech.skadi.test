package io.netty.buffer.search;

import io.netty.util.internal.PlatformDependent;

public class BitapSearchProcessorFactory extends AbstractSearchProcessorFactory {
    private final long[] bitMasks = new long[256];
    private final long successBit;

    public static class Processor implements SearchProcessor {
        private final long[] bitMasks;
        private long currentMask;
        private final long successBit;

        public Processor(long[] jArr, long j) {
            this.bitMasks = jArr;
            this.successBit = j;
        }

        public boolean process(byte b) {
            long j = ((this.currentMask << 1) | 1) & PlatformDependent.getLong(this.bitMasks, ((long) b) & 255);
            this.currentMask = j;
            return (this.successBit & j) == 0;
        }

        public void reset() {
            this.currentMask = 0;
        }
    }

    public BitapSearchProcessorFactory(byte[] bArr) {
        if (bArr.length <= 64) {
            long j = 1;
            for (byte b : bArr) {
                long[] jArr = this.bitMasks;
                byte b2 = b & 255;
                jArr[b2] = jArr[b2] | j;
                j <<= 1;
            }
            this.successBit = 1 << (bArr.length - 1);
            return;
        }
        throw new IllegalArgumentException("Maximum supported search pattern length is 64, got " + bArr.length);
    }

    public Processor newSearchProcessor() {
        return new Processor(this.bitMasks, this.successBit);
    }
}
