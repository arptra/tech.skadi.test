package zmq.io.mechanism.curve;

import com.neilalexander.jnacl.crypto.curve25519xsalsa20poly1305;
import com.neilalexander.jnacl.crypto.xsalsa20poly1305;
import java.nio.ByteBuffer;
import zmq.util.Utils;
import zmq.util.Z85;

public class Curve {

    public enum Size {
        NONCE {
            public int bytes() {
                return 24;
            }
        },
        ZERO {
            public int bytes() {
                return 32;
            }
        },
        BOXZERO {
            public int bytes() {
                return 16;
            }
        },
        PUBLICKEY {
            public int bytes() {
                return 32;
            }
        },
        SECRETKEY {
            public int bytes() {
                return 32;
            }
        },
        KEY {
            public int bytes() {
                return 32;
            }
        },
        BEFORENM {
            public int bytes() {
                return 32;
            }
        };

        public abstract int bytes();
    }

    public static String p(byte[] bArr) {
        return Z85.b(bArr, Size.PUBLICKEY.bytes());
    }

    public int a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i, ByteBuffer byteBuffer3, byte[] bArr) {
        return b(byteBuffer.array(), byteBuffer2.array(), i, byteBuffer3.array(), bArr);
    }

    public int b(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4) {
        return curve25519xsalsa20poly1305.crypto_box_afternm(bArr, bArr2, (long) i, bArr3, bArr4);
    }

    public int c(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return curve25519xsalsa20poly1305.crypto_box_beforenm(bArr, bArr2, bArr3);
    }

    public int d(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i, ByteBuffer byteBuffer3, byte[] bArr, byte[] bArr2) {
        return e(byteBuffer.array(), byteBuffer2.array(), i, byteBuffer3.array(), bArr, bArr2);
    }

    public int e(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        return curve25519xsalsa20poly1305.crypto_box(bArr, bArr2, (long) i, bArr3, bArr4, bArr5);
    }

    public byte[][] f() {
        byte[] bArr = new byte[Size.PUBLICKEY.bytes()];
        byte[] bArr2 = new byte[Size.SECRETKEY.bytes()];
        curve25519xsalsa20poly1305.crypto_box_keypair(bArr, bArr2);
        return new byte[][]{bArr, bArr2};
    }

    public int g(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i, ByteBuffer byteBuffer3, byte[] bArr, byte[] bArr2) {
        return h(byteBuffer.array(), byteBuffer2.array(), i, byteBuffer3.array(), bArr, bArr2);
    }

    public int h(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        return curve25519xsalsa20poly1305.crypto_box_open(bArr, bArr2, (long) i, bArr3, bArr4, bArr5);
    }

    public int i(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i, ByteBuffer byteBuffer3, byte[] bArr) {
        return j(byteBuffer.array(), byteBuffer2.array(), i, byteBuffer3.array(), bArr);
    }

    public int j(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4) {
        return curve25519xsalsa20poly1305.crypto_box_open_afternm(bArr, bArr2, (long) i, bArr3, bArr4);
    }

    public byte[] k(int i) {
        return Utils.f(i);
    }

    public int l(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i, ByteBuffer byteBuffer3, byte[] bArr) {
        return m(byteBuffer.array(), byteBuffer2.array(), i, byteBuffer3.array(), bArr);
    }

    public int m(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4) {
        return xsalsa20poly1305.crypto_secretbox(bArr, bArr2, (long) i, bArr3, bArr4);
    }

    public int n(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i, ByteBuffer byteBuffer3, byte[] bArr) {
        return o(byteBuffer.array(), byteBuffer2.array(), i, byteBuffer3.array(), bArr);
    }

    public int o(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4) {
        return xsalsa20poly1305.crypto_secretbox_open(bArr, bArr2, (long) i, bArr3, bArr4);
    }
}
