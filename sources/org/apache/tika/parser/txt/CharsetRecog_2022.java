package org.apache.tika.parser.txt;

import com.google.common.primitives.SignedBytes;
import com.upuphone.starrynet.strategy.message.payload.handler.RingDataUtil;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;

abstract class CharsetRecog_2022 extends CharsetRecognizer {

    public static class CharsetRecog_2022CN extends CharsetRecog_2022 {

        /* renamed from: a  reason: collision with root package name */
        public byte[][] f3263a = {new byte[]{27, BinaryMemcacheOpcodes.GATKQ, RingDataUtil.OPCODE_QUERY_ALGO_STATE, 65}, new byte[]{27, BinaryMemcacheOpcodes.GATKQ, RingDataUtil.OPCODE_QUERY_ALGO_STATE, 71}, new byte[]{27, BinaryMemcacheOpcodes.GATKQ, 42, 72}, new byte[]{27, BinaryMemcacheOpcodes.GATKQ, RingDataUtil.OPCODE_QUERY_ALGO_STATE, 69}, new byte[]{27, BinaryMemcacheOpcodes.GATKQ, 43, 73}, new byte[]{27, BinaryMemcacheOpcodes.GATKQ, 43, 74}, new byte[]{27, BinaryMemcacheOpcodes.GATKQ, 43, 75}, new byte[]{27, BinaryMemcacheOpcodes.GATKQ, 43, 76}, new byte[]{27, BinaryMemcacheOpcodes.GATKQ, 43, 77}, new byte[]{27, 78}, new byte[]{27, 79}};

        public String b() {
            return "ISO-2022-CN";
        }

        public CharsetMatch c(CharsetDetector charsetDetector) {
            int d = d(charsetDetector.f3260a, charsetDetector.c, this.f3263a);
            if (d == 0) {
                return null;
            }
            return new CharsetMatch(charsetDetector, this, d);
        }
    }

    public static class CharsetRecog_2022JP extends CharsetRecog_2022 {

        /* renamed from: a  reason: collision with root package name */
        public byte[][] f3264a = {new byte[]{27, BinaryMemcacheOpcodes.GATKQ, RingDataUtil.OPCODE_SET_GET_RING_NAME, 67}, new byte[]{27, BinaryMemcacheOpcodes.GATKQ, RingDataUtil.OPCODE_SET_GET_RING_NAME, 68}, new byte[]{27, BinaryMemcacheOpcodes.GATKQ, SignedBytes.MAX_POWER_OF_TWO}, new byte[]{27, BinaryMemcacheOpcodes.GATKQ, 65}, new byte[]{27, BinaryMemcacheOpcodes.GATKQ, 66}, new byte[]{27, 38, SignedBytes.MAX_POWER_OF_TWO}, new byte[]{27, RingDataUtil.OPCODE_SET_GET_RING_NAME, 66}, new byte[]{27, RingDataUtil.OPCODE_SET_GET_RING_NAME, 72}, new byte[]{27, RingDataUtil.OPCODE_SET_GET_RING_NAME, 73}, new byte[]{27, RingDataUtil.OPCODE_SET_GET_RING_NAME, 74}, new byte[]{27, 46, 65}, new byte[]{27, 46, 70}};

        public String b() {
            return "ISO-2022-JP";
        }

        public CharsetMatch c(CharsetDetector charsetDetector) {
            int d = d(charsetDetector.f3260a, charsetDetector.c, this.f3264a);
            if (d == 0) {
                return null;
            }
            return new CharsetMatch(charsetDetector, this, d);
        }
    }

    public static class CharsetRecog_2022KR extends CharsetRecog_2022 {

        /* renamed from: a  reason: collision with root package name */
        public byte[][] f3265a = {new byte[]{27, BinaryMemcacheOpcodes.GATKQ, RingDataUtil.OPCODE_QUERY_ALGO_STATE, 67}};

        public String b() {
            return "ISO-2022-KR";
        }

        public CharsetMatch c(CharsetDetector charsetDetector) {
            int d = d(charsetDetector.f3260a, charsetDetector.c, this.f3265a);
            if (d == 0) {
                return null;
            }
            return new CharsetMatch(charsetDetector, this, d);
        }
    }

    public int d(byte[] bArr, int i, byte[][] bArr2) {
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i2 < i) {
            if (bArr[i2] == 27) {
                for (byte[] bArr3 : bArr2) {
                    if (i - i2 >= bArr3.length) {
                        int i6 = 1;
                        while (i6 < bArr3.length) {
                            if (bArr3[i6] == bArr[i2 + i6]) {
                                i6++;
                            }
                        }
                        i3++;
                        i2 += bArr3.length - 1;
                        break;
                    }
                }
                i4++;
            }
            byte b = bArr[i2];
            if (b == 14 || b == 15) {
                i5++;
                i2++;
            } else {
                i2++;
            }
        }
        if (i3 == 0) {
            return 0;
        }
        int i7 = ((i3 * 100) - (i4 * 100)) / (i4 + i3);
        int i8 = i3 + i5;
        if (i8 < 5) {
            i7 -= (5 - i8) * 10;
        }
        if (i7 < 0) {
            return 0;
        }
        return i7;
    }
}
