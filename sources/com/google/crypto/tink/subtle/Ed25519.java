package com.google.crypto.tink.subtle;

import com.google.common.primitives.SignedBytes;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

final class Ed25519 {
    private static final CachedXYT CACHED_NEUTRAL = new CachedXYT(new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    static final byte[] GROUP_ORDER = {-19, -45, -11, 92, 26, 99, 18, 88, -42, -100, -9, -94, -34, -7, -34, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16};
    private static final PartialXYZT NEUTRAL = new PartialXYZT(new XYZ(new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}), new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    public static final int PUBLIC_KEY_LEN = 32;
    public static final int SECRET_KEY_LEN = 32;
    public static final int SIGNATURE_LEN = 64;

    public static class CachedXYT {
        final long[] t2d;
        final long[] yMinusX;
        final long[] yPlusX;

        public CachedXYT() {
            this(new long[10], new long[10], new long[10]);
        }

        public void copyConditional(CachedXYT cachedXYT, int i) {
            Curve25519.copyConditional(this.yPlusX, cachedXYT.yPlusX, i);
            Curve25519.copyConditional(this.yMinusX, cachedXYT.yMinusX, i);
            Curve25519.copyConditional(this.t2d, cachedXYT.t2d, i);
        }

        public void multByZ(long[] jArr, long[] jArr2) {
            System.arraycopy(jArr2, 0, jArr, 0, 10);
        }

        public CachedXYT(long[] jArr, long[] jArr2, long[] jArr3) {
            this.yPlusX = jArr;
            this.yMinusX = jArr2;
            this.t2d = jArr3;
        }

        public CachedXYT(CachedXYT cachedXYT) {
            this.yPlusX = Arrays.copyOf(cachedXYT.yPlusX, 10);
            this.yMinusX = Arrays.copyOf(cachedXYT.yMinusX, 10);
            this.t2d = Arrays.copyOf(cachedXYT.t2d, 10);
        }
    }

    public static class CachedXYZT extends CachedXYT {
        private final long[] z;

        public CachedXYZT() {
            this(new long[10], new long[10], new long[10], new long[10]);
        }

        public void multByZ(long[] jArr, long[] jArr2) {
            Field25519.mult(jArr, jArr2, this.z);
        }

        public CachedXYZT(XYZT xyzt) {
            this();
            long[] jArr = this.yPlusX;
            XYZ xyz = xyzt.xyz;
            Field25519.sum(jArr, xyz.y, xyz.x);
            long[] jArr2 = this.yMinusX;
            XYZ xyz2 = xyzt.xyz;
            Field25519.sub(jArr2, xyz2.y, xyz2.x);
            System.arraycopy(xyzt.xyz.z, 0, this.z, 0, 10);
            Field25519.mult(this.t2d, xyzt.t, Ed25519Constants.D2);
        }

        public CachedXYZT(long[] jArr, long[] jArr2, long[] jArr3, long[] jArr4) {
            super(jArr, jArr2, jArr4);
            this.z = jArr3;
        }
    }

    public static class PartialXYZT {
        final long[] t;
        final XYZ xyz;

        public PartialXYZT() {
            this(new XYZ(), new long[10]);
        }

        public PartialXYZT(XYZ xyz2, long[] jArr) {
            this.xyz = xyz2;
            this.t = jArr;
        }

        public PartialXYZT(PartialXYZT partialXYZT) {
            this.xyz = new XYZ(partialXYZT.xyz);
            this.t = Arrays.copyOf(partialXYZT.t, 10);
        }
    }

    public static class XYZ {
        final long[] x;
        final long[] y;
        final long[] z;

        public XYZ() {
            this(new long[10], new long[10], new long[10]);
        }

        public static XYZ fromPartialXYZT(XYZ xyz, PartialXYZT partialXYZT) {
            Field25519.mult(xyz.x, partialXYZT.xyz.x, partialXYZT.t);
            long[] jArr = xyz.y;
            XYZ xyz2 = partialXYZT.xyz;
            Field25519.mult(jArr, xyz2.y, xyz2.z);
            Field25519.mult(xyz.z, partialXYZT.xyz.z, partialXYZT.t);
            return xyz;
        }

        public boolean isOnCurve() {
            long[] jArr = new long[10];
            Field25519.square(jArr, this.x);
            long[] jArr2 = new long[10];
            Field25519.square(jArr2, this.y);
            long[] jArr3 = new long[10];
            Field25519.square(jArr3, this.z);
            long[] jArr4 = new long[10];
            Field25519.square(jArr4, jArr3);
            long[] jArr5 = new long[10];
            Field25519.sub(jArr5, jArr2, jArr);
            Field25519.mult(jArr5, jArr5, jArr3);
            long[] jArr6 = new long[10];
            Field25519.mult(jArr6, jArr, jArr2);
            Field25519.mult(jArr6, jArr6, Ed25519Constants.D);
            Field25519.sum(jArr6, jArr4);
            Field25519.reduce(jArr6, jArr6);
            return Bytes.equal(Field25519.contract(jArr5), Field25519.contract(jArr6));
        }

        public byte[] toBytes() {
            long[] jArr = new long[10];
            long[] jArr2 = new long[10];
            long[] jArr3 = new long[10];
            Field25519.inverse(jArr, this.z);
            Field25519.mult(jArr2, this.x, jArr);
            Field25519.mult(jArr3, this.y, jArr);
            byte[] contract = Field25519.contract(jArr3);
            contract[31] = (byte) (contract[31] ^ (Ed25519.getLsb(jArr2) << 7));
            return contract;
        }

        public XYZ(long[] jArr, long[] jArr2, long[] jArr3) {
            this.x = jArr;
            this.y = jArr2;
            this.z = jArr3;
        }

        public XYZ(XYZ xyz) {
            this.x = Arrays.copyOf(xyz.x, 10);
            this.y = Arrays.copyOf(xyz.y, 10);
            this.z = Arrays.copyOf(xyz.z, 10);
        }

        public XYZ(PartialXYZT partialXYZT) {
            this();
            fromPartialXYZT(this, partialXYZT);
        }
    }

    public static class XYZT {
        final long[] t;
        final XYZ xyz;

        public XYZT() {
            this(new XYZ(), new long[10]);
        }

        /* access modifiers changed from: private */
        public static XYZT fromBytesNegateVarTime(byte[] bArr) throws GeneralSecurityException {
            long[] jArr = new long[10];
            long[] expand = Field25519.expand(bArr);
            long[] jArr2 = new long[10];
            jArr2[0] = 1;
            long[] jArr3 = new long[10];
            long[] jArr4 = new long[10];
            long[] jArr5 = new long[10];
            long[] jArr6 = new long[10];
            long[] jArr7 = new long[10];
            Field25519.square(jArr4, expand);
            Field25519.mult(jArr5, jArr4, Ed25519Constants.D);
            Field25519.sub(jArr4, jArr4, jArr2);
            Field25519.sum(jArr5, jArr5, jArr2);
            long[] jArr8 = new long[10];
            Field25519.square(jArr8, jArr5);
            Field25519.mult(jArr8, jArr8, jArr5);
            Field25519.square(jArr, jArr8);
            Field25519.mult(jArr, jArr, jArr5);
            Field25519.mult(jArr, jArr, jArr4);
            Ed25519.pow2252m3(jArr, jArr);
            Field25519.mult(jArr, jArr, jArr8);
            Field25519.mult(jArr, jArr, jArr4);
            Field25519.square(jArr6, jArr);
            Field25519.mult(jArr6, jArr6, jArr5);
            Field25519.sub(jArr7, jArr6, jArr4);
            if (Ed25519.isNonZeroVarTime(jArr7)) {
                Field25519.sum(jArr7, jArr6, jArr4);
                if (!Ed25519.isNonZeroVarTime(jArr7)) {
                    Field25519.mult(jArr, jArr, Ed25519Constants.SQRTM1);
                } else {
                    throw new GeneralSecurityException("Cannot convert given bytes to extended projective coordinates. No square root exists for modulo 2^255-19");
                }
            }
            if (Ed25519.isNonZeroVarTime(jArr) || ((bArr[31] & 255) >> 7) == 0) {
                if (Ed25519.getLsb(jArr) == ((bArr[31] & 255) >> 7)) {
                    Ed25519.neg(jArr, jArr);
                }
                Field25519.mult(jArr3, jArr, expand);
                return new XYZT(new XYZ(jArr, expand, jArr2), jArr3);
            }
            throw new GeneralSecurityException("Cannot convert given bytes to extended projective coordinates. Computed x is zero and encoded x's least significant bit is not zero");
        }

        /* access modifiers changed from: private */
        public static XYZT fromPartialXYZT(XYZT xyzt, PartialXYZT partialXYZT) {
            Field25519.mult(xyzt.xyz.x, partialXYZT.xyz.x, partialXYZT.t);
            long[] jArr = xyzt.xyz.y;
            XYZ xyz2 = partialXYZT.xyz;
            Field25519.mult(jArr, xyz2.y, xyz2.z);
            Field25519.mult(xyzt.xyz.z, partialXYZT.xyz.z, partialXYZT.t);
            long[] jArr2 = xyzt.t;
            XYZ xyz3 = partialXYZT.xyz;
            Field25519.mult(jArr2, xyz3.x, xyz3.y);
            return xyzt;
        }

        public XYZT(XYZ xyz2, long[] jArr) {
            this.xyz = xyz2;
            this.t = jArr;
        }

        public XYZT(PartialXYZT partialXYZT) {
            this();
            fromPartialXYZT(this, partialXYZT);
        }
    }

    private static void add(PartialXYZT partialXYZT, XYZT xyzt, CachedXYT cachedXYT) {
        long[] jArr = new long[10];
        long[] jArr2 = partialXYZT.xyz.x;
        XYZ xyz = xyzt.xyz;
        Field25519.sum(jArr2, xyz.y, xyz.x);
        long[] jArr3 = partialXYZT.xyz.y;
        XYZ xyz2 = xyzt.xyz;
        Field25519.sub(jArr3, xyz2.y, xyz2.x);
        long[] jArr4 = partialXYZT.xyz.y;
        Field25519.mult(jArr4, jArr4, cachedXYT.yMinusX);
        XYZ xyz3 = partialXYZT.xyz;
        Field25519.mult(xyz3.z, xyz3.x, cachedXYT.yPlusX);
        Field25519.mult(partialXYZT.t, xyzt.t, cachedXYT.t2d);
        cachedXYT.multByZ(partialXYZT.xyz.x, xyzt.xyz.z);
        long[] jArr5 = partialXYZT.xyz.x;
        Field25519.sum(jArr, jArr5, jArr5);
        XYZ xyz4 = partialXYZT.xyz;
        Field25519.sub(xyz4.x, xyz4.z, xyz4.y);
        XYZ xyz5 = partialXYZT.xyz;
        long[] jArr6 = xyz5.y;
        Field25519.sum(jArr6, xyz5.z, jArr6);
        Field25519.sum(partialXYZT.xyz.z, jArr, partialXYZT.t);
        long[] jArr7 = partialXYZT.t;
        Field25519.sub(jArr7, jArr, jArr7);
    }

    private static XYZ doubleScalarMultVarTime(byte[] bArr, XYZT xyzt, byte[] bArr2) {
        CachedXYZT[] cachedXYZTArr = new CachedXYZT[8];
        cachedXYZTArr[0] = new CachedXYZT(xyzt);
        PartialXYZT partialXYZT = new PartialXYZT();
        doubleXYZT(partialXYZT, xyzt);
        XYZT xyzt2 = new XYZT(partialXYZT);
        for (int i = 1; i < 8; i++) {
            add(partialXYZT, xyzt2, cachedXYZTArr[i - 1]);
            cachedXYZTArr[i] = new CachedXYZT(new XYZT(partialXYZT));
        }
        byte[] slide = slide(bArr);
        byte[] slide2 = slide(bArr2);
        PartialXYZT partialXYZT2 = new PartialXYZT(NEUTRAL);
        XYZT xyzt3 = new XYZT();
        int i2 = 255;
        while (i2 >= 0 && slide[i2] == 0 && slide2[i2] == 0) {
            i2--;
        }
        while (i2 >= 0) {
            doubleXYZ(partialXYZT2, new XYZ(partialXYZT2));
            byte b = slide[i2];
            if (b > 0) {
                add(partialXYZT2, XYZT.fromPartialXYZT(xyzt3, partialXYZT2), cachedXYZTArr[slide[i2] / 2]);
            } else if (b < 0) {
                sub(partialXYZT2, XYZT.fromPartialXYZT(xyzt3, partialXYZT2), cachedXYZTArr[(-slide[i2]) / 2]);
            }
            byte b2 = slide2[i2];
            if (b2 > 0) {
                add(partialXYZT2, XYZT.fromPartialXYZT(xyzt3, partialXYZT2), Ed25519Constants.B2[slide2[i2] / 2]);
            } else if (b2 < 0) {
                sub(partialXYZT2, XYZT.fromPartialXYZT(xyzt3, partialXYZT2), Ed25519Constants.B2[(-slide2[i2]) / 2]);
            }
            i2--;
        }
        return new XYZ(partialXYZT2);
    }

    private static void doubleXYZ(PartialXYZT partialXYZT, XYZ xyz) {
        long[] jArr = new long[10];
        Field25519.square(partialXYZT.xyz.x, xyz.x);
        Field25519.square(partialXYZT.xyz.z, xyz.y);
        Field25519.square(partialXYZT.t, xyz.z);
        long[] jArr2 = partialXYZT.t;
        Field25519.sum(jArr2, jArr2, jArr2);
        Field25519.sum(partialXYZT.xyz.y, xyz.x, xyz.y);
        Field25519.square(jArr, partialXYZT.xyz.y);
        XYZ xyz2 = partialXYZT.xyz;
        Field25519.sum(xyz2.y, xyz2.z, xyz2.x);
        XYZ xyz3 = partialXYZT.xyz;
        long[] jArr3 = xyz3.z;
        Field25519.sub(jArr3, jArr3, xyz3.x);
        XYZ xyz4 = partialXYZT.xyz;
        Field25519.sub(xyz4.x, jArr, xyz4.y);
        long[] jArr4 = partialXYZT.t;
        Field25519.sub(jArr4, jArr4, partialXYZT.xyz.z);
    }

    private static void doubleXYZT(PartialXYZT partialXYZT, XYZT xyzt) {
        doubleXYZ(partialXYZT, xyzt.xyz);
    }

    private static int eq(int i, int i2) {
        int i3 = (~(i ^ i2)) & 255;
        int i4 = i3 & (i3 << 4);
        int i5 = i4 & (i4 << 2);
        return ((i5 & (i5 << 1)) >> 7) & 1;
    }

    public static byte[] getHashedScalar(byte[] bArr) throws GeneralSecurityException {
        MessageDigest instance = EngineFactory.MESSAGE_DIGEST.getInstance(MessageDigestAlgorithms.SHA_512);
        instance.update(bArr, 0, 32);
        byte[] digest = instance.digest();
        digest[0] = (byte) (digest[0] & 248);
        byte b = (byte) (digest[31] & Byte.MAX_VALUE);
        digest[31] = b;
        digest[31] = (byte) (b | SignedBytes.MAX_POWER_OF_TWO);
        return digest;
    }

    /* access modifiers changed from: private */
    public static int getLsb(long[] jArr) {
        return Field25519.contract(jArr)[0] & 1;
    }

    /* access modifiers changed from: private */
    public static boolean isNonZeroVarTime(long[] jArr) {
        long[] jArr2 = new long[(jArr.length + 1)];
        System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
        Field25519.reduceCoefficients(jArr2);
        for (byte b : Field25519.contract(jArr2)) {
            if (b != 0) {
                return true;
            }
        }
        return false;
    }

    private static boolean isSmallerThanGroupOrder(byte[] bArr) {
        for (int i = 31; i >= 0; i--) {
            byte b = bArr[i] & 255;
            byte b2 = GROUP_ORDER[i] & 255;
            if (b != b2) {
                return b < b2;
            }
        }
        return false;
    }

    private static long load3(byte[] bArr, int i) {
        return (((long) (bArr[i + 2] & 255)) << 16) | (((long) bArr[i]) & 255) | (((long) (bArr[i + 1] & 255)) << 8);
    }

    private static long load4(byte[] bArr, int i) {
        return (((long) (bArr[i + 3] & 255)) << 24) | load3(bArr, i);
    }

    private static void mulAdd(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        byte[] bArr5 = bArr2;
        byte[] bArr6 = bArr3;
        byte[] bArr7 = bArr4;
        long load3 = load3(bArr5, 0) & 2097151;
        long load4 = (load4(bArr5, 2) >> 5) & 2097151;
        long load32 = (load3(bArr5, 5) >> 2) & 2097151;
        long load42 = (load4(bArr5, 7) >> 7) & 2097151;
        long load43 = (load4(bArr5, 10) >> 4) & 2097151;
        long load33 = (load3(bArr5, 13) >> 1) & 2097151;
        long load44 = (load4(bArr5, 15) >> 6) & 2097151;
        long load34 = (load3(bArr5, 18) >> 3) & 2097151;
        long load35 = load3(bArr5, 21) & 2097151;
        long load45 = (load4(bArr5, 23) >> 5) & 2097151;
        long load36 = (load3(bArr5, 26) >> 2) & 2097151;
        long load46 = load4(bArr5, 28) >> 7;
        long load37 = load3(bArr6, 0) & 2097151;
        long load47 = (load4(bArr6, 2) >> 5) & 2097151;
        long load38 = (load3(bArr6, 5) >> 2) & 2097151;
        long load48 = (load4(bArr6, 7) >> 7) & 2097151;
        long load49 = (load4(bArr6, 10) >> 4) & 2097151;
        long load39 = (load3(bArr6, 13) >> 1) & 2097151;
        long load410 = (load4(bArr6, 15) >> 6) & 2097151;
        long load310 = (load3(bArr6, 18) >> 3) & 2097151;
        long load311 = load3(bArr6, 21) & 2097151;
        long load411 = (load4(bArr6, 23) >> 5) & 2097151;
        long load312 = (load3(bArr6, 26) >> 2) & 2097151;
        long load412 = load4(bArr6, 28) >> 7;
        long load313 = (load3(bArr7, 26) >> 2) & 2097151;
        long load314 = (load3(bArr7, 0) & 2097151) + (load3 * load37);
        long load413 = ((load4(bArr7, 2) >> 5) & 2097151) + (load3 * load47) + (load4 * load37);
        long load315 = ((load3(bArr7, 5) >> 2) & 2097151) + (load3 * load38) + (load4 * load47) + (load32 * load37);
        long load414 = ((load4(bArr7, 7) >> 7) & 2097151) + (load3 * load48) + (load4 * load38) + (load32 * load47) + (load42 * load37);
        long load415 = ((load4(bArr7, 10) >> 4) & 2097151) + (load3 * load49) + (load4 * load48) + (load32 * load38) + (load42 * load47) + (load43 * load37);
        long load316 = ((load3(bArr7, 13) >> 1) & 2097151) + (load3 * load39) + (load4 * load49) + (load32 * load48) + (load42 * load38) + (load43 * load47) + (load33 * load37);
        long load416 = ((load4(bArr7, 15) >> 6) & 2097151) + (load3 * load410) + (load4 * load39) + (load32 * load49) + (load42 * load48) + (load43 * load38) + (load33 * load47) + (load44 * load37);
        long load317 = ((load3(bArr7, 18) >> 3) & 2097151) + (load3 * load310) + (load4 * load410) + (load32 * load39) + (load42 * load49) + (load43 * load48) + (load33 * load38) + (load44 * load47) + (load34 * load37);
        long load318 = (load3(bArr7, 21) & 2097151) + (load3 * load311) + (load4 * load310) + (load32 * load410) + (load42 * load39) + (load43 * load49) + (load33 * load48) + (load44 * load38) + (load34 * load47) + (load35 * load37);
        long load417 = ((load4(bArr7, 23) >> 5) & 2097151) + (load3 * load411) + (load4 * load311) + (load32 * load310) + (load42 * load410) + (load43 * load39) + (load33 * load49) + (load44 * load48) + (load34 * load38) + (load35 * load47) + (load45 * load37);
        long j = load313 + (load3 * load312) + (load4 * load411) + (load32 * load311) + (load42 * load310) + (load43 * load410) + (load33 * load39) + (load44 * load49) + (load34 * load48) + (load35 * load38) + (load45 * load47) + (load36 * load37);
        long j2 = (load4 * load412) + (load32 * load312) + (load42 * load411) + (load43 * load311) + (load33 * load310) + (load44 * load410) + (load34 * load39) + (load35 * load49) + (load45 * load48) + (load36 * load38) + (load47 * load46);
        long j3 = (load42 * load412) + (load43 * load312) + (load33 * load411) + (load44 * load311) + (load34 * load310) + (load35 * load410) + (load45 * load39) + (load36 * load49) + (load48 * load46);
        long j4 = (load33 * load412) + (load44 * load312) + (load34 * load411) + (load35 * load311) + (load45 * load310) + (load36 * load410) + (load39 * load46);
        long j5 = (load34 * load412) + (load35 * load312) + (load45 * load411) + (load36 * load311) + (load310 * load46);
        long j6 = (load45 * load412) + (load36 * load312) + (load411 * load46);
        long j7 = load46 * load412;
        long j8 = (load314 + 1048576) >> 21;
        long j9 = load413 + j8;
        long j10 = load314 - (j8 << 21);
        long j11 = (load315 + 1048576) >> 21;
        long j12 = load414 + j11;
        long j13 = load315 - (j11 << 21);
        long j14 = (load415 + 1048576) >> 21;
        long j15 = load316 + j14;
        long j16 = load415 - (j14 << 21);
        long j17 = (load416 + 1048576) >> 21;
        long j18 = load317 + j17;
        long j19 = load416 - (j17 << 21);
        long j20 = (load318 + 1048576) >> 21;
        long j21 = load417 + j20;
        long j22 = load318 - (j20 << 21);
        long j23 = (j + 1048576) >> 21;
        long load418 = (load4(bArr7, 28) >> 7) + (load3 * load412) + (load4 * load312) + (load32 * load411) + (load42 * load311) + (load43 * load310) + (load33 * load410) + (load44 * load39) + (load34 * load49) + (load35 * load48) + (load45 * load38) + (load36 * load47) + (load37 * load46) + j23;
        long j24 = j - (j23 << 21);
        long j25 = (j2 + 1048576) >> 21;
        long j26 = (load32 * load412) + (load42 * load312) + (load43 * load411) + (load33 * load311) + (load44 * load310) + (load34 * load410) + (load35 * load39) + (load45 * load49) + (load36 * load48) + (load38 * load46) + j25;
        long j27 = j2 - (j25 << 21);
        long j28 = (j3 + 1048576) >> 21;
        long j29 = (load43 * load412) + (load33 * load312) + (load44 * load411) + (load34 * load311) + (load35 * load310) + (load45 * load410) + (load36 * load39) + (load49 * load46) + j28;
        long j30 = j3 - (j28 << 21);
        long j31 = (j4 + 1048576) >> 21;
        long j32 = (load44 * load412) + (load34 * load312) + (load35 * load411) + (load45 * load311) + (load36 * load310) + (load410 * load46) + j31;
        long j33 = j4 - (j31 << 21);
        long j34 = (j5 + 1048576) >> 21;
        long j35 = (load35 * load412) + (load45 * load312) + (load36 * load411) + (load311 * load46) + j34;
        long j36 = j5 - (j34 << 21);
        long j37 = (j6 + 1048576) >> 21;
        long j38 = (load36 * load412) + (load312 * load46) + j37;
        long j39 = j6 - (j37 << 21);
        long j40 = (j7 + 1048576) >> 21;
        long j41 = (j9 + 1048576) >> 21;
        long j42 = j13 + j41;
        long j43 = j9 - (j41 << 21);
        long j44 = (j12 + 1048576) >> 21;
        long j45 = j16 + j44;
        long j46 = j12 - (j44 << 21);
        long j47 = (j15 + 1048576) >> 21;
        long j48 = j19 + j47;
        long j49 = j15 - (j47 << 21);
        long j50 = (j18 + 1048576) >> 21;
        long j51 = j22 + j50;
        long j52 = j18 - (j50 << 21);
        long j53 = (j21 + 1048576) >> 21;
        long j54 = j24 + j53;
        long j55 = j21 - (j53 << 21);
        long j56 = (load418 + 1048576) >> 21;
        long j57 = j27 + j56;
        long j58 = load418 - (j56 << 21);
        long j59 = (j26 + 1048576) >> 21;
        long j60 = j30 + j59;
        long j61 = j26 - (j59 << 21);
        long j62 = (j29 + 1048576) >> 21;
        long j63 = j33 + j62;
        long j64 = j29 - (j62 << 21);
        long j65 = (j32 + 1048576) >> 21;
        long j66 = j36 + j65;
        long j67 = j32 - (j65 << 21);
        long j68 = (j35 + 1048576) >> 21;
        long j69 = j39 + j68;
        long j70 = j35 - (j68 << 21);
        long j71 = (j38 + 1048576) >> 21;
        long j72 = (j7 - (j40 << 21)) + j71;
        long j73 = j38 - (j71 << 21);
        long j74 = j63 - (j40 * 683901);
        long j75 = ((j60 - (j40 * 997805)) + (j72 * 136657)) - (j73 * 683901);
        long j76 = ((((j57 + (j40 * 470296)) + (j72 * 654183)) - (j73 * 997805)) + (j69 * 136657)) - (j70 * 683901);
        long j77 = j48 + (j66 * 666643);
        long j78 = j51 + (j69 * 666643) + (j70 * 470296) + (j66 * 654183);
        long j79 = ((((j54 + (j72 * 666643)) + (j73 * 470296)) + (j69 * 654183)) - (j70 * 997805)) + (j66 * 136657);
        long j80 = (j77 + 1048576) >> 21;
        long j81 = j52 + (j70 * 666643) + (j66 * 470296) + j80;
        long j82 = j77 - (j80 << 21);
        long j83 = (j78 + 1048576) >> 21;
        long j84 = ((((j55 + (j73 * 666643)) + (j69 * 470296)) + (j70 * 654183)) - (j66 * 997805)) + j83;
        long j85 = j78 - (j83 << 21);
        long j86 = (j79 + 1048576) >> 21;
        long j87 = ((((((j58 + (j40 * 666643)) + (j72 * 470296)) + (j73 * 654183)) - (j69 * 997805)) + (j70 * 136657)) - (j66 * 683901)) + j86;
        long j88 = j79 - (j86 << 21);
        long j89 = (j76 + 1048576) >> 21;
        long j90 = ((((j61 + (j40 * 654183)) - (j72 * 997805)) + (j73 * 136657)) - (j69 * 683901)) + j89;
        long j91 = j76 - (j89 << 21);
        long j92 = (j75 + 1048576) >> 21;
        long j93 = ((j64 + (j40 * 136657)) - (j72 * 683901)) + j92;
        long j94 = j75 - (j92 << 21);
        long j95 = (j74 + 1048576) >> 21;
        long j96 = j67 + j95;
        long j97 = j74 - (j95 << 21);
        long j98 = (j81 + 1048576) >> 21;
        long j99 = j85 + j98;
        long j100 = j81 - (j98 << 21);
        long j101 = (j84 + 1048576) >> 21;
        long j102 = j88 + j101;
        long j103 = j84 - (j101 << 21);
        long j104 = (j87 + 1048576) >> 21;
        long j105 = j91 + j104;
        long j106 = j87 - (j104 << 21);
        long j107 = (j90 + 1048576) >> 21;
        long j108 = j94 + j107;
        long j109 = j90 - (j107 << 21);
        long j110 = (j93 + 1048576) >> 21;
        long j111 = j97 + j110;
        long j112 = j93 - (j110 << 21);
        long j113 = j102 - (j96 * 683901);
        long j114 = ((j99 - (j96 * 997805)) + (j111 * 136657)) - (j112 * 683901);
        long j115 = ((((j82 + (j96 * 470296)) + (j111 * 654183)) - (j112 * 997805)) + (j108 * 136657)) - (j109 * 683901);
        long j116 = j10 + (j105 * 666643);
        long j117 = j42 + (j108 * 666643) + (j109 * 470296) + (j105 * 654183);
        long j118 = ((((j45 + (j111 * 666643)) + (j112 * 470296)) + (j108 * 654183)) - (j109 * 997805)) + (j105 * 136657);
        long j119 = (j116 + 1048576) >> 21;
        long j120 = j43 + (j109 * 666643) + (j105 * 470296) + j119;
        long j121 = j116 - (j119 << 21);
        long j122 = (j117 + 1048576) >> 21;
        long j123 = ((((j46 + (j112 * 666643)) + (j108 * 470296)) + (j109 * 654183)) - (j105 * 997805)) + j122;
        long j124 = j117 - (j122 << 21);
        long j125 = (j118 + 1048576) >> 21;
        long j126 = ((((((j49 + (j96 * 666643)) + (j111 * 470296)) + (j112 * 654183)) - (j108 * 997805)) + (j109 * 136657)) - (j105 * 683901)) + j125;
        long j127 = j118 - (j125 << 21);
        long j128 = (j115 + 1048576) >> 21;
        long j129 = ((((j100 + (j96 * 654183)) - (j111 * 997805)) + (j112 * 136657)) - (j108 * 683901)) + j128;
        long j130 = j115 - (j128 << 21);
        long j131 = (j114 + 1048576) >> 21;
        long j132 = ((j103 + (j96 * 136657)) - (j111 * 683901)) + j131;
        long j133 = j114 - (j131 << 21);
        long j134 = (j113 + 1048576) >> 21;
        long j135 = j106 + j134;
        long j136 = j113 - (j134 << 21);
        long j137 = (j120 + 1048576) >> 21;
        long j138 = j124 + j137;
        long j139 = j120 - (j137 << 21);
        long j140 = (j123 + 1048576) >> 21;
        long j141 = j127 + j140;
        long j142 = j123 - (j140 << 21);
        long j143 = (j126 + 1048576) >> 21;
        long j144 = j130 + j143;
        long j145 = j126 - (j143 << 21);
        long j146 = (j129 + 1048576) >> 21;
        long j147 = j133 + j146;
        long j148 = j129 - (j146 << 21);
        long j149 = (j132 + 1048576) >> 21;
        long j150 = j136 + j149;
        long j151 = j132 - (j149 << 21);
        long j152 = (1048576 + j135) >> 21;
        long j153 = j121 + (j152 * 666643);
        long j154 = j153 >> 21;
        long j155 = j139 + (j152 * 470296) + j154;
        long j156 = j153 - (j154 << 21);
        long j157 = j155 >> 21;
        long j158 = j138 + (j152 * 654183) + j157;
        long j159 = j155 - (j157 << 21);
        long j160 = j158 >> 21;
        long j161 = (j142 - (j152 * 997805)) + j160;
        long j162 = j158 - (j160 << 21);
        long j163 = j161 >> 21;
        long j164 = j141 + (j152 * 136657) + j163;
        long j165 = j161 - (j163 << 21);
        long j166 = j164 >> 21;
        long j167 = (j145 - (j152 * 683901)) + j166;
        long j168 = j164 - (j166 << 21);
        long j169 = j167 >> 21;
        long j170 = j144 + j169;
        long j171 = j167 - (j169 << 21);
        long j172 = j170 >> 21;
        long j173 = j148 + j172;
        long j174 = j170 - (j172 << 21);
        long j175 = j173 >> 21;
        long j176 = j147 + j175;
        long j177 = j173 - (j175 << 21);
        long j178 = j176 >> 21;
        long j179 = j151 + j178;
        long j180 = j176 - (j178 << 21);
        long j181 = j179 >> 21;
        long j182 = j150 + j181;
        long j183 = j179 - (j181 << 21);
        long j184 = j182 >> 21;
        long j185 = (j135 - (j152 << 21)) + j184;
        long j186 = j182 - (j184 << 21);
        long j187 = j185 >> 21;
        long j188 = j185 - (j187 << 21);
        long j189 = j156 + (666643 * j187);
        long j190 = j171 - (j187 * 683901);
        long j191 = j189 >> 21;
        long j192 = j159 + (470296 * j187) + j191;
        long j193 = j189 - (j191 << 21);
        long j194 = j192 >> 21;
        long j195 = j162 + (654183 * j187) + j194;
        long j196 = j192 - (j194 << 21);
        long j197 = j195 >> 21;
        long j198 = (j165 - (997805 * j187)) + j197;
        long j199 = j195 - (j197 << 21);
        long j200 = j198 >> 21;
        long j201 = j168 + (136657 * j187) + j200;
        long j202 = j198 - (j200 << 21);
        long j203 = j201 >> 21;
        long j204 = j190 + j203;
        long j205 = j201 - (j203 << 21);
        long j206 = j204 >> 21;
        long j207 = j174 + j206;
        long j208 = j204 - (j206 << 21);
        long j209 = j207 >> 21;
        long j210 = j177 + j209;
        long j211 = j207 - (j209 << 21);
        long j212 = j210 >> 21;
        long j213 = j180 + j212;
        long j214 = j210 - (j212 << 21);
        long j215 = j213 >> 21;
        long j216 = j183 + j215;
        long j217 = j213 - (j215 << 21);
        long j218 = j216 >> 21;
        long j219 = j186 + j218;
        long j220 = j216 - (j218 << 21);
        long j221 = j219 >> 21;
        long j222 = j188 + j221;
        long j223 = j219 - (j221 << 21);
        bArr[0] = (byte) ((int) j193);
        bArr[1] = (byte) ((int) (j193 >> 8));
        bArr[2] = (byte) ((int) ((j193 >> 16) | (j196 << 5)));
        bArr[3] = (byte) ((int) (j196 >> 3));
        bArr[4] = (byte) ((int) (j196 >> 11));
        bArr[5] = (byte) ((int) ((j196 >> 19) | (j199 << 2)));
        bArr[6] = (byte) ((int) (j199 >> 6));
        bArr[7] = (byte) ((int) ((j199 >> 14) | (j202 << 7)));
        bArr[8] = (byte) ((int) (j202 >> 1));
        bArr[9] = (byte) ((int) (j202 >> 9));
        bArr[10] = (byte) ((int) ((j202 >> 17) | (j205 << 4)));
        bArr[11] = (byte) ((int) (j205 >> 4));
        bArr[12] = (byte) ((int) (j205 >> 12));
        bArr[13] = (byte) ((int) ((j205 >> 20) | (j208 << 1)));
        bArr[14] = (byte) ((int) (j208 >> 7));
        bArr[15] = (byte) ((int) ((j208 >> 15) | (j211 << 6)));
        bArr[16] = (byte) ((int) (j211 >> 2));
        bArr[17] = (byte) ((int) (j211 >> 10));
        bArr[18] = (byte) ((int) ((j211 >> 18) | (j214 << 3)));
        bArr[19] = (byte) ((int) (j214 >> 5));
        bArr[20] = (byte) ((int) (j214 >> 13));
        bArr[21] = (byte) ((int) j217);
        bArr[22] = (byte) ((int) (j217 >> 8));
        bArr[23] = (byte) ((int) ((j217 >> 16) | (j220 << 5)));
        bArr[24] = (byte) ((int) (j220 >> 3));
        bArr[25] = (byte) ((int) (j220 >> 11));
        bArr[26] = (byte) ((int) ((j220 >> 19) | (j223 << 2)));
        bArr[27] = (byte) ((int) (j223 >> 6));
        bArr[28] = (byte) ((int) ((j223 >> 14) | (j222 << 7)));
        bArr[29] = (byte) ((int) (j222 >> 1));
        bArr[30] = (byte) ((int) (j222 >> 9));
        bArr[31] = (byte) ((int) (j222 >> 17));
    }

    /* access modifiers changed from: private */
    public static void neg(long[] jArr, long[] jArr2) {
        for (int i = 0; i < jArr2.length; i++) {
            jArr[i] = -jArr2[i];
        }
    }

    /* access modifiers changed from: private */
    public static void pow2252m3(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[10];
        long[] jArr4 = new long[10];
        long[] jArr5 = new long[10];
        Field25519.square(jArr3, jArr2);
        Field25519.square(jArr4, jArr3);
        Field25519.square(jArr4, jArr4);
        Field25519.mult(jArr4, jArr2, jArr4);
        Field25519.mult(jArr3, jArr3, jArr4);
        Field25519.square(jArr3, jArr3);
        Field25519.mult(jArr3, jArr4, jArr3);
        Field25519.square(jArr4, jArr3);
        for (int i = 1; i < 5; i++) {
            Field25519.square(jArr4, jArr4);
        }
        Field25519.mult(jArr3, jArr4, jArr3);
        Field25519.square(jArr4, jArr3);
        for (int i2 = 1; i2 < 10; i2++) {
            Field25519.square(jArr4, jArr4);
        }
        Field25519.mult(jArr4, jArr4, jArr3);
        Field25519.square(jArr5, jArr4);
        for (int i3 = 1; i3 < 20; i3++) {
            Field25519.square(jArr5, jArr5);
        }
        Field25519.mult(jArr4, jArr5, jArr4);
        Field25519.square(jArr4, jArr4);
        for (int i4 = 1; i4 < 10; i4++) {
            Field25519.square(jArr4, jArr4);
        }
        Field25519.mult(jArr3, jArr4, jArr3);
        Field25519.square(jArr4, jArr3);
        for (int i5 = 1; i5 < 50; i5++) {
            Field25519.square(jArr4, jArr4);
        }
        Field25519.mult(jArr4, jArr4, jArr3);
        Field25519.square(jArr5, jArr4);
        for (int i6 = 1; i6 < 100; i6++) {
            Field25519.square(jArr5, jArr5);
        }
        Field25519.mult(jArr4, jArr5, jArr4);
        Field25519.square(jArr4, jArr4);
        for (int i7 = 1; i7 < 50; i7++) {
            Field25519.square(jArr4, jArr4);
        }
        Field25519.mult(jArr3, jArr4, jArr3);
        Field25519.square(jArr3, jArr3);
        Field25519.square(jArr3, jArr3);
        Field25519.mult(jArr, jArr3, jArr2);
    }

    private static void reduce(byte[] bArr) {
        byte[] bArr2 = bArr;
        long load3 = (load3(bArr2, 47) >> 2) & 2097151;
        long load4 = (load4(bArr2, 49) >> 7) & 2097151;
        long load42 = (load4(bArr2, 52) >> 4) & 2097151;
        long load32 = (load3(bArr2, 55) >> 1) & 2097151;
        long load43 = (load4(bArr2, 57) >> 6) & 2097151;
        long load44 = load4(bArr2, 60) >> 3;
        long load33 = (load3(bArr2, 42) & 2097151) - (load44 * 683901);
        long load34 = ((load3(bArr2, 26) >> 2) & 2097151) + (load43 * 666643);
        long load45 = ((load4(bArr2, 28) >> 7) & 2097151) + (load44 * 666643) + (load43 * 470296);
        long load46 = ((load4(bArr2, 31) >> 4) & 2097151) + (load44 * 470296) + (load43 * 654183);
        long load35 = (((load3(bArr2, 34) >> 1) & 2097151) + (load44 * 654183)) - (load43 * 997805);
        long load36 = (((load3(bArr2, 39) >> 3) & 2097151) + (load44 * 136657)) - (load43 * 683901);
        long load47 = ((load4(bArr2, 23) >> 5) & 2097151) + (load32 * 666643);
        long load48 = ((((load4(bArr2, 36) >> 6) & 2097151) - (load44 * 997805)) + (load43 * 136657)) - (load32 * 683901);
        long load37 = (load3(bArr2, 21) & 2097151) + (load42 * 666643);
        long load38 = ((load3(bArr2, 18) >> 3) & 2097151) + (load4 * 666643);
        long j = ((load46 - (load32 * 997805)) + (load42 * 136657)) - (load4 * 683901);
        long load49 = ((load4(bArr2, 15) >> 6) & 2097151) + (load3 * 666643);
        long j2 = load38 + (load3 * 470296);
        long j3 = load37 + (load4 * 470296) + (load3 * 654183);
        long j4 = ((load47 + (load42 * 470296)) + (load4 * 654183)) - (load3 * 997805);
        long j5 = (((load34 + (load32 * 470296)) + (load42 * 654183)) - (load4 * 997805)) + (load3 * 136657);
        long j6 = (((load45 + (load32 * 654183)) - (load42 * 997805)) + (load4 * 136657)) - (load3 * 683901);
        long j7 = (load49 + 1048576) >> 21;
        long j8 = j2 + j7;
        long j9 = load49 - (j7 << 21);
        long j10 = (j3 + 1048576) >> 21;
        long j11 = j4 + j10;
        long j12 = j3 - (j10 << 21);
        long j13 = (j5 + 1048576) >> 21;
        long j14 = j6 + j13;
        long j15 = j5 - (j13 << 21);
        long j16 = (j + 1048576) >> 21;
        long j17 = ((load35 + (load32 * 136657)) - (load42 * 683901)) + j16;
        long j18 = j - (j16 << 21);
        long j19 = (load48 + 1048576) >> 21;
        long j20 = load36 + j19;
        long j21 = load48 - (j19 << 21);
        long j22 = (load33 + 1048576) >> 21;
        long load410 = ((load4(bArr2, 44) >> 5) & 2097151) + j22;
        long j23 = load33 - (j22 << 21);
        long j24 = (j8 + 1048576) >> 21;
        long j25 = j12 + j24;
        long j26 = j8 - (j24 << 21);
        long j27 = (j11 + 1048576) >> 21;
        long j28 = j15 + j27;
        long j29 = j11 - (j27 << 21);
        long j30 = (j14 + 1048576) >> 21;
        long j31 = j18 + j30;
        long j32 = j14 - (j30 << 21);
        long j33 = (j17 + 1048576) >> 21;
        long j34 = j21 + j33;
        long j35 = j17 - (j33 << 21);
        long j36 = (j20 + 1048576) >> 21;
        long j37 = j23 + j36;
        long j38 = j20 - (j36 << 21);
        long load39 = ((load3(bArr2, 13) >> 1) & 2097151) + (load410 * 666643);
        long j39 = j28 - (load410 * 683901);
        long load411 = ((load4(bArr2, 10) >> 4) & 2097151) + (j37 * 666643);
        long load412 = ((load4(bArr2, 7) >> 7) & 2097151) + (j38 * 666643);
        long j40 = ((j25 - (load410 * 997805)) + (j37 * 136657)) - (j38 * 683901);
        long load310 = ((load3(bArr2, 5) >> 2) & 2097151) + (j34 * 666643);
        long load413 = ((load4(bArr2, 2) >> 5) & 2097151) + (j35 * 666643);
        long j41 = ((((j9 + (load410 * 470296)) + (j37 * 654183)) - (j38 * 997805)) + (j34 * 136657)) - (j35 * 683901);
        long load311 = (load3(bArr2, 0) & 2097151) + (j31 * 666643);
        long j42 = load413 + (j31 * 470296);
        long j43 = load310 + (j35 * 470296) + (j31 * 654183);
        long j44 = ((load412 + (j34 * 470296)) + (j35 * 654183)) - (j31 * 997805);
        long j45 = (((load411 + (j38 * 470296)) + (j34 * 654183)) - (j35 * 997805)) + (j31 * 136657);
        long j46 = ((((load39 + (j37 * 470296)) + (j38 * 654183)) - (j34 * 997805)) + (j35 * 136657)) - (j31 * 683901);
        long j47 = (load311 + 1048576) >> 21;
        long j48 = j42 + j47;
        long j49 = load311 - (j47 << 21);
        long j50 = (j43 + 1048576) >> 21;
        long j51 = j44 + j50;
        long j52 = j43 - (j50 << 21);
        long j53 = (j45 + 1048576) >> 21;
        long j54 = j46 + j53;
        long j55 = j45 - (j53 << 21);
        long j56 = (j41 + 1048576) >> 21;
        long j57 = ((((j26 + (load410 * 654183)) - (j37 * 997805)) + (j38 * 136657)) - (j34 * 683901)) + j56;
        long j58 = j41 - (j56 << 21);
        long j59 = (j40 + 1048576) >> 21;
        long j60 = ((j29 + (load410 * 136657)) - (j37 * 683901)) + j59;
        long j61 = j40 - (j59 << 21);
        long j62 = (j39 + 1048576) >> 21;
        long j63 = j32 + j62;
        long j64 = j39 - (j62 << 21);
        long j65 = (j48 + 1048576) >> 21;
        long j66 = j52 + j65;
        long j67 = j48 - (j65 << 21);
        long j68 = (j51 + 1048576) >> 21;
        long j69 = j55 + j68;
        long j70 = j51 - (j68 << 21);
        long j71 = (j54 + 1048576) >> 21;
        long j72 = j58 + j71;
        long j73 = j54 - (j71 << 21);
        long j74 = (j57 + 1048576) >> 21;
        long j75 = j61 + j74;
        long j76 = j57 - (j74 << 21);
        long j77 = (j60 + 1048576) >> 21;
        long j78 = j64 + j77;
        long j79 = j60 - (j77 << 21);
        long j80 = (j63 + 1048576) >> 21;
        long j81 = j49 + (j80 * 666643);
        long j82 = j81 >> 21;
        long j83 = j67 + (j80 * 470296) + j82;
        long j84 = j81 - (j82 << 21);
        long j85 = j83 >> 21;
        long j86 = j66 + (j80 * 654183) + j85;
        long j87 = j83 - (j85 << 21);
        long j88 = j86 >> 21;
        long j89 = (j70 - (j80 * 997805)) + j88;
        long j90 = j86 - (j88 << 21);
        long j91 = j89 >> 21;
        long j92 = j69 + (j80 * 136657) + j91;
        long j93 = j89 - (j91 << 21);
        long j94 = j92 >> 21;
        long j95 = (j73 - (j80 * 683901)) + j94;
        long j96 = j92 - (j94 << 21);
        long j97 = j95 >> 21;
        long j98 = j72 + j97;
        long j99 = j95 - (j97 << 21);
        long j100 = j98 >> 21;
        long j101 = j76 + j100;
        long j102 = j98 - (j100 << 21);
        long j103 = j101 >> 21;
        long j104 = j75 + j103;
        long j105 = j101 - (j103 << 21);
        long j106 = j104 >> 21;
        long j107 = j79 + j106;
        long j108 = j104 - (j106 << 21);
        long j109 = j107 >> 21;
        long j110 = j78 + j109;
        long j111 = j107 - (j109 << 21);
        long j112 = j110 >> 21;
        long j113 = (j63 - (j80 << 21)) + j112;
        long j114 = j110 - (j112 << 21);
        long j115 = j113 >> 21;
        long j116 = j113 - (j115 << 21);
        long j117 = j84 + (666643 * j115);
        long j118 = j99 - (j115 * 683901);
        long j119 = j117 >> 21;
        long j120 = j87 + (470296 * j115) + j119;
        long j121 = j117 - (j119 << 21);
        long j122 = j120 >> 21;
        long j123 = j90 + (654183 * j115) + j122;
        long j124 = j120 - (j122 << 21);
        long j125 = j123 >> 21;
        long j126 = (j93 - (997805 * j115)) + j125;
        long j127 = j123 - (j125 << 21);
        long j128 = j126 >> 21;
        long j129 = j96 + (136657 * j115) + j128;
        long j130 = j126 - (j128 << 21);
        long j131 = j129 >> 21;
        long j132 = j118 + j131;
        long j133 = j129 - (j131 << 21);
        long j134 = j132 >> 21;
        long j135 = j102 + j134;
        long j136 = j132 - (j134 << 21);
        long j137 = j135 >> 21;
        long j138 = j105 + j137;
        long j139 = j135 - (j137 << 21);
        long j140 = j138 >> 21;
        long j141 = j108 + j140;
        long j142 = j138 - (j140 << 21);
        long j143 = j141 >> 21;
        long j144 = j111 + j143;
        long j145 = j130;
        long j146 = j141 - (j143 << 21);
        long j147 = j144 >> 21;
        long j148 = j114 + j147;
        long j149 = j144 - (j147 << 21);
        long j150 = j148 >> 21;
        long j151 = j116 + j150;
        long j152 = j148 - (j150 << 21);
        bArr2[0] = (byte) ((int) j121);
        bArr2[1] = (byte) ((int) (j121 >> 8));
        bArr2[2] = (byte) ((int) ((j121 >> 16) | (j124 << 5)));
        bArr2[3] = (byte) ((int) (j124 >> 3));
        bArr2[4] = (byte) ((int) (j124 >> 11));
        bArr2[5] = (byte) ((int) ((j124 >> 19) | (j127 << 2)));
        bArr2[6] = (byte) ((int) (j127 >> 6));
        bArr2[7] = (byte) ((int) ((j127 >> 14) | (j145 << 7)));
        bArr2[8] = (byte) ((int) (j145 >> 1));
        bArr2[9] = (byte) ((int) (j145 >> 9));
        bArr2[10] = (byte) ((int) ((j145 >> 17) | (j133 << 4)));
        bArr2[11] = (byte) ((int) (j133 >> 4));
        bArr2[12] = (byte) ((int) (j133 >> 12));
        bArr2[13] = (byte) ((int) ((j133 >> 20) | (j136 << 1)));
        bArr2[14] = (byte) ((int) (j136 >> 7));
        bArr2[15] = (byte) ((int) ((j136 >> 15) | (j139 << 6)));
        bArr2[16] = (byte) ((int) (j139 >> 2));
        bArr2[17] = (byte) ((int) (j139 >> 10));
        bArr2[18] = (byte) ((int) ((j139 >> 18) | (j142 << 3)));
        bArr2[19] = (byte) ((int) (j142 >> 5));
        bArr2[20] = (byte) ((int) (j142 >> 13));
        bArr2[21] = (byte) ((int) j146);
        bArr2[22] = (byte) ((int) (j146 >> 8));
        bArr2[23] = (byte) ((int) ((j146 >> 16) | (j149 << 5)));
        bArr2[24] = (byte) ((int) (j149 >> 3));
        bArr2[25] = (byte) ((int) (j149 >> 11));
        bArr2[26] = (byte) ((int) ((j149 >> 19) | (j152 << 2)));
        bArr2[27] = (byte) ((int) (j152 >> 6));
        bArr2[28] = (byte) ((int) ((j152 >> 14) | (j151 << 7)));
        bArr2[29] = (byte) ((int) (j151 >> 1));
        bArr2[30] = (byte) ((int) (j151 >> 9));
        bArr2[31] = (byte) ((int) (j151 >> 17));
    }

    private static XYZ scalarMultWithBase(byte[] bArr) {
        int i;
        byte[] bArr2 = new byte[64];
        int i2 = 0;
        while (true) {
            if (i2 >= 32) {
                break;
            }
            int i3 = i2 * 2;
            bArr2[i3] = (byte) (bArr[i2] & 15);
            bArr2[i3 + 1] = (byte) (((bArr[i2] & 255) >> 4) & 15);
            i2++;
        }
        int i4 = 0;
        byte b = 0;
        while (i4 < 63) {
            byte b2 = (byte) (bArr2[i4] + b);
            bArr2[i4] = b2;
            int i5 = (b2 + 8) >> 4;
            bArr2[i4] = (byte) (b2 - (i5 << 4));
            i4++;
            b = i5;
        }
        bArr2[63] = (byte) (bArr2[63] + b);
        PartialXYZT partialXYZT = new PartialXYZT(NEUTRAL);
        XYZT xyzt = new XYZT();
        for (i = 1; i < 64; i += 2) {
            CachedXYT cachedXYT = new CachedXYT(CACHED_NEUTRAL);
            select(cachedXYT, i / 2, bArr2[i]);
            add(partialXYZT, XYZT.fromPartialXYZT(xyzt, partialXYZT), cachedXYT);
        }
        XYZ xyz = new XYZ();
        doubleXYZ(partialXYZT, XYZ.fromPartialXYZT(xyz, partialXYZT));
        doubleXYZ(partialXYZT, XYZ.fromPartialXYZT(xyz, partialXYZT));
        doubleXYZ(partialXYZT, XYZ.fromPartialXYZT(xyz, partialXYZT));
        doubleXYZ(partialXYZT, XYZ.fromPartialXYZT(xyz, partialXYZT));
        for (int i6 = 0; i6 < 64; i6 += 2) {
            CachedXYT cachedXYT2 = new CachedXYT(CACHED_NEUTRAL);
            select(cachedXYT2, i6 / 2, bArr2[i6]);
            add(partialXYZT, XYZT.fromPartialXYZT(xyzt, partialXYZT), cachedXYT2);
        }
        XYZ xyz2 = new XYZ(partialXYZT);
        if (xyz2.isOnCurve()) {
            return xyz2;
        }
        throw new IllegalStateException("arithmetic error in scalar multiplication");
    }

    public static byte[] scalarMultWithBaseToBytes(byte[] bArr) {
        return scalarMultWithBase(bArr).toBytes();
    }

    private static void select(CachedXYT cachedXYT, int i, byte b) {
        int i2 = (b & 255) >> 7;
        int i3 = b - (((-i2) & b) << 1);
        CachedXYT[][] cachedXYTArr = Ed25519Constants.B_TABLE;
        cachedXYT.copyConditional(cachedXYTArr[i][0], eq(i3, 1));
        cachedXYT.copyConditional(cachedXYTArr[i][1], eq(i3, 2));
        cachedXYT.copyConditional(cachedXYTArr[i][2], eq(i3, 3));
        cachedXYT.copyConditional(cachedXYTArr[i][3], eq(i3, 4));
        cachedXYT.copyConditional(cachedXYTArr[i][4], eq(i3, 5));
        cachedXYT.copyConditional(cachedXYTArr[i][5], eq(i3, 6));
        cachedXYT.copyConditional(cachedXYTArr[i][6], eq(i3, 7));
        cachedXYT.copyConditional(cachedXYTArr[i][7], eq(i3, 8));
        long[] copyOf = Arrays.copyOf(cachedXYT.yMinusX, 10);
        long[] copyOf2 = Arrays.copyOf(cachedXYT.yPlusX, 10);
        long[] copyOf3 = Arrays.copyOf(cachedXYT.t2d, 10);
        neg(copyOf3, copyOf3);
        cachedXYT.copyConditional(new CachedXYT(copyOf, copyOf2, copyOf3), i2);
    }

    public static byte[] sign(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, bArr.length);
        MessageDigest instance = EngineFactory.MESSAGE_DIGEST.getInstance(MessageDigestAlgorithms.SHA_512);
        instance.update(bArr3, 32, 32);
        instance.update(copyOfRange);
        byte[] digest = instance.digest();
        reduce(digest);
        byte[] copyOfRange2 = Arrays.copyOfRange(scalarMultWithBase(digest).toBytes(), 0, 32);
        instance.reset();
        instance.update(copyOfRange2);
        instance.update(bArr2);
        instance.update(copyOfRange);
        byte[] digest2 = instance.digest();
        reduce(digest2);
        byte[] bArr4 = new byte[32];
        mulAdd(bArr4, digest2, bArr3, digest);
        return Bytes.concat(copyOfRange2, bArr4);
    }

    private static byte[] slide(byte[] bArr) {
        int i;
        byte[] bArr2 = new byte[256];
        for (int i2 = 0; i2 < 256; i2++) {
            bArr2[i2] = (byte) (1 & ((bArr[i2 >> 3] & 255) >> (i2 & 7)));
        }
        int i3 = 0;
        while (i3 < 256) {
            if (bArr2[i3] != 0) {
                int i4 = 1;
                while (i4 <= 6 && (i = i3 + i4) < 256) {
                    byte b = bArr2[i];
                    if (b != 0) {
                        byte b2 = bArr2[i3];
                        if ((b << i4) + b2 > 15) {
                            if (b2 - (b << i4) < -15) {
                                break;
                            }
                            bArr2[i3] = (byte) (b2 - (b << i4));
                            while (true) {
                                if (i >= 256) {
                                    break;
                                } else if (bArr2[i] == 0) {
                                    bArr2[i] = 1;
                                    break;
                                } else {
                                    bArr2[i] = 0;
                                    i++;
                                }
                            }
                        } else {
                            bArr2[i3] = (byte) (b2 + (b << i4));
                            bArr2[i] = 0;
                        }
                    }
                    i4++;
                }
            }
            i3++;
        }
        return bArr2;
    }

    private static void sub(PartialXYZT partialXYZT, XYZT xyzt, CachedXYT cachedXYT) {
        long[] jArr = new long[10];
        long[] jArr2 = partialXYZT.xyz.x;
        XYZ xyz = xyzt.xyz;
        Field25519.sum(jArr2, xyz.y, xyz.x);
        long[] jArr3 = partialXYZT.xyz.y;
        XYZ xyz2 = xyzt.xyz;
        Field25519.sub(jArr3, xyz2.y, xyz2.x);
        long[] jArr4 = partialXYZT.xyz.y;
        Field25519.mult(jArr4, jArr4, cachedXYT.yPlusX);
        XYZ xyz3 = partialXYZT.xyz;
        Field25519.mult(xyz3.z, xyz3.x, cachedXYT.yMinusX);
        Field25519.mult(partialXYZT.t, xyzt.t, cachedXYT.t2d);
        cachedXYT.multByZ(partialXYZT.xyz.x, xyzt.xyz.z);
        long[] jArr5 = partialXYZT.xyz.x;
        Field25519.sum(jArr, jArr5, jArr5);
        XYZ xyz4 = partialXYZT.xyz;
        Field25519.sub(xyz4.x, xyz4.z, xyz4.y);
        XYZ xyz5 = partialXYZT.xyz;
        long[] jArr6 = xyz5.y;
        Field25519.sum(jArr6, xyz5.z, jArr6);
        Field25519.sub(partialXYZT.xyz.z, jArr, partialXYZT.t);
        long[] jArr7 = partialXYZT.t;
        Field25519.sum(jArr7, jArr, jArr7);
    }

    public static boolean verify(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        if (bArr2.length != 64) {
            return false;
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr2, 32, 64);
        if (!isSmallerThanGroupOrder(copyOfRange)) {
            return false;
        }
        MessageDigest instance = EngineFactory.MESSAGE_DIGEST.getInstance(MessageDigestAlgorithms.SHA_512);
        instance.update(bArr2, 0, 32);
        instance.update(bArr3);
        instance.update(bArr);
        byte[] digest = instance.digest();
        reduce(digest);
        byte[] bytes = doubleScalarMultVarTime(digest, XYZT.fromBytesNegateVarTime(bArr3), copyOfRange).toBytes();
        for (int i = 0; i < 32; i++) {
            if (bytes[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }
}
