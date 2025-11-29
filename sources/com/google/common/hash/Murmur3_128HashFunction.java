package com.google.common.hash;

import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@Immutable
final class Murmur3_128HashFunction extends AbstractHashFunction implements Serializable {
    static final HashFunction GOOD_FAST_HASH_128 = new Murmur3_128HashFunction(Hashing.GOOD_FAST_HASH_SEED);
    static final HashFunction MURMUR3_128 = new Murmur3_128HashFunction(0);
    private static final long serialVersionUID = 0;
    private final int seed;

    public static final class Murmur3_128Hasher extends AbstractStreamingHasher {
        private static final long C1 = -8663945395140668459L;
        private static final long C2 = 5545529020109919103L;
        private static final int CHUNK_SIZE = 16;
        private long h1;
        private long h2;
        private int length = 0;

        public Murmur3_128Hasher(int i) {
            super(16);
            long j = (long) i;
            this.h1 = j;
            this.h2 = j;
        }

        private void bmix64(long j, long j2) {
            long mixK1 = mixK1(j) ^ this.h1;
            this.h1 = mixK1;
            long rotateLeft = Long.rotateLeft(mixK1, 27);
            long j3 = this.h2;
            this.h1 = ((rotateLeft + j3) * 5) + 1390208809;
            long mixK2 = mixK2(j2) ^ j3;
            this.h2 = mixK2;
            this.h2 = ((Long.rotateLeft(mixK2, 31) + this.h1) * 5) + 944331445;
        }

        private static long fmix64(long j) {
            long j2 = (j ^ (j >>> 33)) * -49064778989728563L;
            long j3 = (j2 ^ (j2 >>> 33)) * -4265267296055464877L;
            return j3 ^ (j3 >>> 33);
        }

        private static long mixK1(long j) {
            return Long.rotateLeft(j * C1, 31) * C2;
        }

        private static long mixK2(long j) {
            return Long.rotateLeft(j * C2, 33) * C1;
        }

        public HashCode makeHash() {
            long j = this.h1;
            int i = this.length;
            long j2 = j ^ ((long) i);
            long j3 = this.h2 ^ ((long) i);
            long j4 = j2 + j3;
            this.h1 = j4;
            this.h2 = j3 + j4;
            this.h1 = fmix64(j4);
            long fmix64 = fmix64(this.h2);
            long j5 = this.h1 + fmix64;
            this.h1 = j5;
            this.h2 = fmix64 + j5;
            return HashCode.fromBytesNoCopy(ByteBuffer.wrap(new byte[16]).order(ByteOrder.LITTLE_ENDIAN).putLong(this.h1).putLong(this.h2).array());
        }

        public void process(ByteBuffer byteBuffer) {
            bmix64(byteBuffer.getLong(), byteBuffer.getLong());
            this.length += 16;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0077, code lost:
            r7 = r7 ^ ((long) com.google.common.primitives.UnsignedBytes.toInt(r14.get(8)));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0081, code lost:
            r0 = r14.getLong();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0093, code lost:
            r4 = (((long) com.google.common.primitives.UnsignedBytes.toInt(r14.get(5))) << 40) ^ r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x00a2, code lost:
            r3 = r4 ^ (((long) com.google.common.primitives.UnsignedBytes.toInt(r14.get(4))) << 32);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x00b1, code lost:
            r2 = r3 ^ (((long) com.google.common.primitives.UnsignedBytes.toInt(r14.get(3))) << 24);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x00c0, code lost:
            r0 = (((long) com.google.common.primitives.UnsignedBytes.toInt(r14.get(2))) << 16) ^ r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x00cf, code lost:
            r0 = r0 ^ (((long) com.google.common.primitives.UnsignedBytes.toInt(r14.get(1))) << 8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00dd, code lost:
            r0 = r0 ^ ((long) com.google.common.primitives.UnsignedBytes.toInt(r14.get(0)));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x00e8, code lost:
            r13.h1 = mixK1(r0) ^ r13.h1;
            r13.h2 ^= mixK2(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x00fa, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0032, code lost:
            r7 = r7 ^ (((long) com.google.common.primitives.UnsignedBytes.toInt(r14.get(13))) << 40);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0040, code lost:
            r7 = r7 ^ (((long) com.google.common.primitives.UnsignedBytes.toInt(r14.get(12))) << 32);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x004e, code lost:
            r7 = r7 ^ (((long) com.google.common.primitives.UnsignedBytes.toInt(r14.get(11))) << 24);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x005c, code lost:
            r7 = r7 ^ (((long) com.google.common.primitives.UnsignedBytes.toInt(r14.get(10))) << 16);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x006a, code lost:
            r7 = r7 ^ (((long) com.google.common.primitives.UnsignedBytes.toInt(r14.get(9))) << 8);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void processRemaining(java.nio.ByteBuffer r14) {
            /*
                r13 = this;
                int r0 = r13.length
                int r1 = r14.remaining()
                int r0 = r0 + r1
                r13.length = r0
                int r0 = r14.remaining()
                r1 = 16
                r2 = 24
                r3 = 32
                r4 = 40
                r5 = 48
                r6 = 8
                r7 = 0
                switch(r0) {
                    case 1: goto L_0x00dc;
                    case 2: goto L_0x00ce;
                    case 3: goto L_0x00bf;
                    case 4: goto L_0x00b0;
                    case 5: goto L_0x00a1;
                    case 6: goto L_0x0092;
                    case 7: goto L_0x0086;
                    case 8: goto L_0x0081;
                    case 9: goto L_0x0077;
                    case 10: goto L_0x006a;
                    case 11: goto L_0x005c;
                    case 12: goto L_0x004e;
                    case 13: goto L_0x0040;
                    case 14: goto L_0x0032;
                    case 15: goto L_0x0026;
                    default: goto L_0x001e;
                }
            L_0x001e:
                java.lang.AssertionError r13 = new java.lang.AssertionError
                java.lang.String r14 = "Should never get here."
                r13.<init>(r14)
                throw r13
            L_0x0026:
                r0 = 14
                byte r0 = r14.get(r0)
                int r0 = com.google.common.primitives.UnsignedBytes.toInt(r0)
                long r7 = (long) r0
                long r7 = r7 << r5
            L_0x0032:
                r0 = 13
                byte r0 = r14.get(r0)
                int r0 = com.google.common.primitives.UnsignedBytes.toInt(r0)
                long r9 = (long) r0
                long r4 = r9 << r4
                long r7 = r7 ^ r4
            L_0x0040:
                r0 = 12
                byte r0 = r14.get(r0)
                int r0 = com.google.common.primitives.UnsignedBytes.toInt(r0)
                long r4 = (long) r0
                long r3 = r4 << r3
                long r7 = r7 ^ r3
            L_0x004e:
                r0 = 11
                byte r0 = r14.get(r0)
                int r0 = com.google.common.primitives.UnsignedBytes.toInt(r0)
                long r3 = (long) r0
                long r2 = r3 << r2
                long r7 = r7 ^ r2
            L_0x005c:
                r0 = 10
                byte r0 = r14.get(r0)
                int r0 = com.google.common.primitives.UnsignedBytes.toInt(r0)
                long r2 = (long) r0
                long r0 = r2 << r1
                long r7 = r7 ^ r0
            L_0x006a:
                r0 = 9
                byte r0 = r14.get(r0)
                int r0 = com.google.common.primitives.UnsignedBytes.toInt(r0)
                long r0 = (long) r0
                long r0 = r0 << r6
                long r7 = r7 ^ r0
            L_0x0077:
                byte r0 = r14.get(r6)
                int r0 = com.google.common.primitives.UnsignedBytes.toInt(r0)
                long r0 = (long) r0
                long r7 = r7 ^ r0
            L_0x0081:
                long r0 = r14.getLong()
                goto L_0x00e8
            L_0x0086:
                r0 = 6
                byte r0 = r14.get(r0)
                int r0 = com.google.common.primitives.UnsignedBytes.toInt(r0)
                long r9 = (long) r0
                long r9 = r9 << r5
                goto L_0x0093
            L_0x0092:
                r9 = r7
            L_0x0093:
                r0 = 5
                byte r0 = r14.get(r0)
                int r0 = com.google.common.primitives.UnsignedBytes.toInt(r0)
                long r11 = (long) r0
                long r4 = r11 << r4
                long r4 = r4 ^ r9
                goto L_0x00a2
            L_0x00a1:
                r4 = r7
            L_0x00a2:
                r0 = 4
                byte r0 = r14.get(r0)
                int r0 = com.google.common.primitives.UnsignedBytes.toInt(r0)
                long r9 = (long) r0
                long r9 = r9 << r3
                long r3 = r4 ^ r9
                goto L_0x00b1
            L_0x00b0:
                r3 = r7
            L_0x00b1:
                r0 = 3
                byte r0 = r14.get(r0)
                int r0 = com.google.common.primitives.UnsignedBytes.toInt(r0)
                long r9 = (long) r0
                long r9 = r9 << r2
                long r2 = r3 ^ r9
                goto L_0x00c0
            L_0x00bf:
                r2 = r7
            L_0x00c0:
                r0 = 2
                byte r0 = r14.get(r0)
                int r0 = com.google.common.primitives.UnsignedBytes.toInt(r0)
                long r4 = (long) r0
                long r0 = r4 << r1
                long r0 = r0 ^ r2
                goto L_0x00cf
            L_0x00ce:
                r0 = r7
            L_0x00cf:
                r2 = 1
                byte r2 = r14.get(r2)
                int r2 = com.google.common.primitives.UnsignedBytes.toInt(r2)
                long r2 = (long) r2
                long r2 = r2 << r6
                long r0 = r0 ^ r2
                goto L_0x00dd
            L_0x00dc:
                r0 = r7
            L_0x00dd:
                r2 = 0
                byte r14 = r14.get(r2)
                int r14 = com.google.common.primitives.UnsignedBytes.toInt(r14)
                long r2 = (long) r14
                long r0 = r0 ^ r2
            L_0x00e8:
                long r2 = r13.h1
                long r0 = mixK1(r0)
                long r0 = r0 ^ r2
                r13.h1 = r0
                long r0 = r13.h2
                long r2 = mixK2(r7)
                long r0 = r0 ^ r2
                r13.h2 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.hash.Murmur3_128HashFunction.Murmur3_128Hasher.processRemaining(java.nio.ByteBuffer):void");
        }
    }

    public Murmur3_128HashFunction(int i) {
        this.seed = i;
    }

    public int bits() {
        return 128;
    }

    public boolean equals(@NullableDecl Object obj) {
        return (obj instanceof Murmur3_128HashFunction) && this.seed == ((Murmur3_128HashFunction) obj).seed;
    }

    public int hashCode() {
        return this.seed ^ Murmur3_128HashFunction.class.hashCode();
    }

    public Hasher newHasher() {
        return new Murmur3_128Hasher(this.seed);
    }

    public String toString() {
        int i = this.seed;
        StringBuilder sb = new StringBuilder(32);
        sb.append("Hashing.murmur3_128(");
        sb.append(i);
        sb.append(")");
        return sb.toString();
    }
}
