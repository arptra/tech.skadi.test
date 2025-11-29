package androidx.emoji2.text.flatbuffer;

import com.upuphone.starrynet.strategy.pair.ble.RingSecurityPair;

public abstract class Utf8 {

    /* renamed from: a  reason: collision with root package name */
    public static Utf8 f1233a;

    public static class DecodeUtil {
        public static void a(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) {
            if (f(b2) || (((b << 28) + (b2 + RingSecurityPair.OPCODE_RING_PAIR)) >> 30) != 0 || f(b3) || f(b4)) {
                throw new IllegalArgumentException("Invalid UTF-8");
            }
            int k = ((b & 7) << 18) | (k(b2) << 12) | (k(b3) << 6) | k(b4);
            cArr[i] = e(k);
            cArr[i + 1] = j(k);
        }

        public static void b(byte b, char[] cArr, int i) {
            cArr[i] = (char) b;
        }

        public static void c(byte b, byte b2, byte b3, char[] cArr, int i) {
            if (f(b2) || ((b == -32 && b2 < -96) || ((b == -19 && b2 >= -96) || f(b3)))) {
                throw new IllegalArgumentException("Invalid UTF-8");
            }
            cArr[i] = (char) (((b & 15) << 12) | (k(b2) << 6) | k(b3));
        }

        public static void d(byte b, byte b2, char[] cArr, int i) {
            if (b < -62) {
                throw new IllegalArgumentException("Invalid UTF-8: Illegal leading byte in 2 bytes utf");
            } else if (!f(b2)) {
                cArr[i] = (char) (((b & 31) << 6) | k(b2));
            } else {
                throw new IllegalArgumentException("Invalid UTF-8: Illegal trailing byte in 2 bytes utf");
            }
        }

        public static char e(int i) {
            return (char) ((i >>> 10) + okio.Utf8.HIGH_SURROGATE_HEADER);
        }

        public static boolean f(byte b) {
            return b > -65;
        }

        public static boolean g(byte b) {
            return b >= 0;
        }

        public static boolean h(byte b) {
            return b < -16;
        }

        public static boolean i(byte b) {
            return b < -32;
        }

        public static char j(int i) {
            return (char) ((i & 1023) + 56320);
        }

        public static int k(byte b) {
            return b & okio.Utf8.REPLACEMENT_BYTE;
        }
    }

    public static class UnpairedSurrogateException extends IllegalArgumentException {
        public UnpairedSurrogateException(int i, int i2) {
            super("Unpaired surrogate at index " + i + " of " + i2);
        }
    }

    public static Utf8 a() {
        if (f1233a == null) {
            f1233a = new Utf8Safe();
        }
        return f1233a;
    }
}
