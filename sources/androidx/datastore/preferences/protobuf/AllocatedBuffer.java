package androidx.datastore.preferences.protobuf;

import java.nio.ByteBuffer;

abstract class AllocatedBuffer {
    public static AllocatedBuffer i(final ByteBuffer byteBuffer) {
        Internal.b(byteBuffer, "buffer");
        return new AllocatedBuffer() {
            public byte[] a() {
                return byteBuffer.array();
            }

            public int b() {
                return byteBuffer.arrayOffset();
            }

            public boolean c() {
                return byteBuffer.hasArray();
            }

            public boolean d() {
                return true;
            }

            public int e() {
                return byteBuffer.limit();
            }

            public ByteBuffer f() {
                return byteBuffer;
            }

            public int g() {
                return byteBuffer.position();
            }

            public AllocatedBuffer h(int i) {
                byteBuffer.position(i);
                return this;
            }
        };
    }

    public static AllocatedBuffer j(byte[] bArr) {
        return l(bArr, 0, bArr.length);
    }

    public static AllocatedBuffer k(byte[] bArr, int i, int i2) {
        if (i >= 0 && i2 >= 0 && i + i2 <= bArr.length) {
            return l(bArr, i, i2);
        }
        throw new IndexOutOfBoundsException(String.format("bytes.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
    }

    public static AllocatedBuffer l(final byte[] bArr, final int i, final int i2) {
        return new AllocatedBuffer() {

            /* renamed from: a  reason: collision with root package name */
            public int f1047a;

            public byte[] a() {
                return bArr;
            }

            public int b() {
                return i;
            }

            public boolean c() {
                return true;
            }

            public boolean d() {
                return false;
            }

            public int e() {
                return i2;
            }

            public ByteBuffer f() {
                throw new UnsupportedOperationException();
            }

            public int g() {
                return this.f1047a;
            }

            public AllocatedBuffer h(int i) {
                if (i < 0 || i > i2) {
                    throw new IllegalArgumentException("Invalid position: " + i);
                }
                this.f1047a = i;
                return this;
            }
        };
    }

    public abstract byte[] a();

    public abstract int b();

    public abstract boolean c();

    public abstract boolean d();

    public abstract int e();

    public abstract ByteBuffer f();

    public abstract int g();

    public abstract AllocatedBuffer h(int i);
}
