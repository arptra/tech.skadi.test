package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Utf8;
import com.honey.account.constant.AccountConstantKt;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class CodedOutputStream extends ByteOutput {
    public static final Logger c = Logger.getLogger(CodedOutputStream.class.getName());
    public static final boolean d = UnsafeUtil.H();

    /* renamed from: a  reason: collision with root package name */
    public CodedOutputStreamWriter f1068a;
    public boolean b;

    public static abstract class AbstractBufferedEncoder extends CodedOutputStream {
        public final byte[] e;
        public final int f;
        public int g;
        public int h;

        public AbstractBufferedEncoder(int i) {
            super();
            if (i >= 0) {
                byte[] bArr = new byte[Math.max(i, 20)];
                this.e = bArr;
                this.f = bArr.length;
                return;
            }
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }

        public final void U0(byte b) {
            byte[] bArr = this.e;
            int i = this.g;
            this.g = i + 1;
            bArr[i] = b;
            this.h++;
        }

        public final void V0(int i) {
            byte[] bArr = this.e;
            int i2 = this.g;
            bArr[i2] = (byte) (i & 255);
            bArr[i2 + 1] = (byte) ((i >> 8) & 255);
            bArr[i2 + 2] = (byte) ((i >> 16) & 255);
            this.g = i2 + 4;
            bArr[i2 + 3] = (byte) ((i >> 24) & 255);
            this.h += 4;
        }

        public final void W0(long j) {
            byte[] bArr = this.e;
            int i = this.g;
            bArr[i] = (byte) ((int) (j & 255));
            bArr[i + 1] = (byte) ((int) ((j >> 8) & 255));
            bArr[i + 2] = (byte) ((int) ((j >> 16) & 255));
            bArr[i + 3] = (byte) ((int) (255 & (j >> 24)));
            bArr[i + 4] = (byte) (((int) (j >> 32)) & 255);
            bArr[i + 5] = (byte) (((int) (j >> 40)) & 255);
            bArr[i + 6] = (byte) (((int) (j >> 48)) & 255);
            this.g = i + 8;
            bArr[i + 7] = (byte) (((int) (j >> 56)) & 255);
            this.h += 8;
        }

        public final void X0(int i) {
            if (i >= 0) {
                Z0(i);
            } else {
                a1((long) i);
            }
        }

        public final void Y0(int i, int i2) {
            Z0(WireFormat.c(i, i2));
        }

        public final void Z0(int i) {
            if (CodedOutputStream.d) {
                long j = (long) this.g;
                while ((i & -128) != 0) {
                    byte[] bArr = this.e;
                    int i2 = this.g;
                    this.g = i2 + 1;
                    UnsafeUtil.O(bArr, (long) i2, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
                byte[] bArr2 = this.e;
                int i3 = this.g;
                this.g = i3 + 1;
                UnsafeUtil.O(bArr2, (long) i3, (byte) i);
                this.h += (int) (((long) this.g) - j);
                return;
            }
            while ((i & -128) != 0) {
                byte[] bArr3 = this.e;
                int i4 = this.g;
                this.g = i4 + 1;
                bArr3[i4] = (byte) ((i & 127) | 128);
                this.h++;
                i >>>= 7;
            }
            byte[] bArr4 = this.e;
            int i5 = this.g;
            this.g = i5 + 1;
            bArr4[i5] = (byte) i;
            this.h++;
        }

        public final void a1(long j) {
            if (CodedOutputStream.d) {
                long j2 = (long) this.g;
                while ((j & -128) != 0) {
                    byte[] bArr = this.e;
                    int i = this.g;
                    this.g = i + 1;
                    UnsafeUtil.O(bArr, (long) i, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr2 = this.e;
                int i2 = this.g;
                this.g = i2 + 1;
                UnsafeUtil.O(bArr2, (long) i2, (byte) ((int) j));
                this.h += (int) (((long) this.g) - j2);
                return;
            }
            while ((j & -128) != 0) {
                byte[] bArr3 = this.e;
                int i3 = this.g;
                this.g = i3 + 1;
                bArr3[i3] = (byte) ((((int) j) & 127) | 128);
                this.h++;
                j >>>= 7;
            }
            byte[] bArr4 = this.e;
            int i4 = this.g;
            this.g = i4 + 1;
            bArr4[i4] = (byte) ((int) j);
            this.h++;
        }

        public final int q0() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }
    }

    public static class ArrayEncoder extends CodedOutputStream {
        public final byte[] e;
        public final int f;
        public final int g;
        public int h;

        public ArrayEncoder(byte[] bArr, int i, int i2) {
            super();
            if (bArr != null) {
                int i3 = i + i2;
                if ((i | i2 | (bArr.length - i3)) >= 0) {
                    this.e = bArr;
                    this.f = i;
                    this.h = i;
                    this.g = i3;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
            }
            throw new NullPointerException("buffer");
        }

        public final void F0(int i) {
            if (i >= 0) {
                S0(i);
            } else {
                T0((long) i);
            }
        }

        public final void H0(int i, MessageLite messageLite) {
            R0(i, 2);
            J0(messageLite);
        }

        public final void I0(int i, MessageLite messageLite, Schema schema) {
            R0(i, 2);
            S0(((AbstractMessageLite) messageLite).e(schema));
            schema.a(messageLite, this.f1068a);
        }

        public final void J0(MessageLite messageLite) {
            S0(messageLite.getSerializedSize());
            messageLite.b(this);
        }

        public final void K0(int i, MessageLite messageLite) {
            R0(1, 3);
            writeUInt32(2, i);
            H0(3, messageLite);
            R0(1, 4);
        }

        public final void L0(int i, ByteString byteString) {
            R0(1, 3);
            writeUInt32(2, i);
            a(3, byteString);
            R0(1, 4);
        }

        public final void Q0(String str) {
            int i = this.h;
            try {
                int f0 = CodedOutputStream.f0(str.length() * 3);
                int f02 = CodedOutputStream.f0(str.length());
                if (f02 == f0) {
                    int i2 = i + f02;
                    this.h = i2;
                    int i3 = Utf8.i(str, this.e, i2, q0());
                    this.h = i;
                    S0((i3 - i) - f02);
                    this.h = i3;
                    return;
                }
                S0(Utf8.k(str));
                this.h = Utf8.i(str, this.e, this.h, q0());
            } catch (Utf8.UnpairedSurrogateException e2) {
                this.h = i;
                l0(str, e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new OutOfSpaceException((Throwable) e3);
            }
        }

        public final void R0(int i, int i2) {
            S0(WireFormat.c(i, i2));
        }

        public final void S0(int i) {
            if (!CodedOutputStream.d || Android.c() || q0() < 5) {
                while ((i & -128) != 0) {
                    byte[] bArr = this.e;
                    int i2 = this.h;
                    this.h = i2 + 1;
                    bArr[i2] = (byte) ((i & 127) | 128);
                    i >>>= 7;
                }
                try {
                    byte[] bArr2 = this.e;
                    int i3 = this.h;
                    this.h = i3 + 1;
                    bArr2[i3] = (byte) i;
                } catch (IndexOutOfBoundsException e2) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.h), Integer.valueOf(this.g), 1}), e2);
                }
            } else if ((i & -128) == 0) {
                byte[] bArr3 = this.e;
                int i4 = this.h;
                this.h = i4 + 1;
                UnsafeUtil.O(bArr3, (long) i4, (byte) i);
            } else {
                byte[] bArr4 = this.e;
                int i5 = this.h;
                this.h = i5 + 1;
                UnsafeUtil.O(bArr4, (long) i5, (byte) (i | 128));
                int i6 = i >>> 7;
                if ((i6 & -128) == 0) {
                    byte[] bArr5 = this.e;
                    int i7 = this.h;
                    this.h = i7 + 1;
                    UnsafeUtil.O(bArr5, (long) i7, (byte) i6);
                    return;
                }
                byte[] bArr6 = this.e;
                int i8 = this.h;
                this.h = i8 + 1;
                UnsafeUtil.O(bArr6, (long) i8, (byte) (i6 | 128));
                int i9 = i >>> 14;
                if ((i9 & -128) == 0) {
                    byte[] bArr7 = this.e;
                    int i10 = this.h;
                    this.h = i10 + 1;
                    UnsafeUtil.O(bArr7, (long) i10, (byte) i9);
                    return;
                }
                byte[] bArr8 = this.e;
                int i11 = this.h;
                this.h = i11 + 1;
                UnsafeUtil.O(bArr8, (long) i11, (byte) (i9 | 128));
                int i12 = i >>> 21;
                if ((i12 & -128) == 0) {
                    byte[] bArr9 = this.e;
                    int i13 = this.h;
                    this.h = i13 + 1;
                    UnsafeUtil.O(bArr9, (long) i13, (byte) i12);
                    return;
                }
                byte[] bArr10 = this.e;
                int i14 = this.h;
                this.h = i14 + 1;
                UnsafeUtil.O(bArr10, (long) i14, (byte) (i12 | 128));
                byte[] bArr11 = this.e;
                int i15 = this.h;
                this.h = i15 + 1;
                UnsafeUtil.O(bArr11, (long) i15, (byte) (i >>> 28));
            }
        }

        public final void T0(long j) {
            if (!CodedOutputStream.d || q0() < 10) {
                while ((j & -128) != 0) {
                    byte[] bArr = this.e;
                    int i = this.h;
                    this.h = i + 1;
                    bArr[i] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                }
                try {
                    byte[] bArr2 = this.e;
                    int i2 = this.h;
                    this.h = i2 + 1;
                    bArr2[i2] = (byte) ((int) j);
                } catch (IndexOutOfBoundsException e2) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.h), Integer.valueOf(this.g), 1}), e2);
                }
            } else {
                while ((j & -128) != 0) {
                    byte[] bArr3 = this.e;
                    int i3 = this.h;
                    this.h = i3 + 1;
                    UnsafeUtil.O(bArr3, (long) i3, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr4 = this.e;
                int i4 = this.h;
                this.h = i4 + 1;
                UnsafeUtil.O(bArr4, (long) i4, (byte) ((int) j));
            }
        }

        public final int U0() {
            return this.h - this.f;
        }

        public final void V0(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            try {
                byteBuffer.get(this.e, this.h, remaining);
                this.h += remaining;
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.h), Integer.valueOf(this.g), Integer.valueOf(remaining)}), e2);
            }
        }

        public final void a(int i, ByteString byteString) {
            R0(i, 2);
            v0(byteString);
        }

        public final void g(byte[] bArr, int i, int i2) {
            try {
                System.arraycopy(bArr, i, this.e, this.h, i2);
                this.h += i2;
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.h), Integer.valueOf(this.g), Integer.valueOf(i2)}), e2);
            }
        }

        public final void h(ByteBuffer byteBuffer) {
            V0(byteBuffer);
        }

        public final void i(byte[] bArr, int i, int i2) {
            g(bArr, i, i2);
        }

        public void k0() {
        }

        public final int q0() {
            return this.g - this.h;
        }

        public final void r0(byte b) {
            try {
                byte[] bArr = this.e;
                int i = this.h;
                this.h = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.h), Integer.valueOf(this.g), 1}), e2);
            }
        }

        public final void u0(byte[] bArr, int i, int i2) {
            S0(i2);
            g(bArr, i, i2);
        }

        public final void v0(ByteString byteString) {
            S0(byteString.size());
            byteString.writeTo((ByteOutput) this);
        }

        public final void writeBool(int i, boolean z) {
            R0(i, 0);
            r0(z ? (byte) 1 : 0);
        }

        public final void writeFixed32(int i, int i2) {
            R0(i, 5);
            y0(i2);
        }

        public final void writeFixed64(int i, long j) {
            R0(i, 1);
            z0(j);
        }

        public final void writeInt32(int i, int i2) {
            R0(i, 0);
            F0(i2);
        }

        public final void writeString(int i, String str) {
            R0(i, 2);
            Q0(str);
        }

        public final void writeUInt32(int i, int i2) {
            R0(i, 0);
            S0(i2);
        }

        public final void writeUInt64(int i, long j) {
            R0(i, 0);
            T0(j);
        }

        public final void y0(int i) {
            try {
                byte[] bArr = this.e;
                int i2 = this.h;
                bArr[i2] = (byte) (i & 255);
                bArr[i2 + 1] = (byte) ((i >> 8) & 255);
                bArr[i2 + 2] = (byte) ((i >> 16) & 255);
                this.h = i2 + 4;
                bArr[i2 + 3] = (byte) ((i >> 24) & 255);
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.h), Integer.valueOf(this.g), 1}), e2);
            }
        }

        public final void z0(long j) {
            try {
                byte[] bArr = this.e;
                int i = this.h;
                bArr[i] = (byte) (((int) j) & 255);
                bArr[i + 1] = (byte) (((int) (j >> 8)) & 255);
                bArr[i + 2] = (byte) (((int) (j >> 16)) & 255);
                bArr[i + 3] = (byte) (((int) (j >> 24)) & 255);
                bArr[i + 4] = (byte) (((int) (j >> 32)) & 255);
                bArr[i + 5] = (byte) (((int) (j >> 40)) & 255);
                bArr[i + 6] = (byte) (((int) (j >> 48)) & 255);
                this.h = i + 8;
                bArr[i + 7] = (byte) (((int) (j >> 56)) & 255);
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.h), Integer.valueOf(this.g), 1}), e2);
            }
        }
    }

    public static final class ByteOutputEncoder extends AbstractBufferedEncoder {
        public final ByteOutput i;

        public void F0(int i2) {
            if (i2 >= 0) {
                S0(i2);
            } else {
                T0((long) i2);
            }
        }

        public void H0(int i2, MessageLite messageLite) {
            R0(i2, 2);
            J0(messageLite);
        }

        public void I0(int i2, MessageLite messageLite, Schema schema) {
            R0(i2, 2);
            d1(messageLite, schema);
        }

        public void J0(MessageLite messageLite) {
            S0(messageLite.getSerializedSize());
            messageLite.b(this);
        }

        public void K0(int i2, MessageLite messageLite) {
            R0(1, 3);
            writeUInt32(2, i2);
            H0(3, messageLite);
            R0(1, 4);
        }

        public void L0(int i2, ByteString byteString) {
            R0(1, 3);
            writeUInt32(2, i2);
            a(3, byteString);
            R0(1, 4);
        }

        public void Q0(String str) {
            int length = str.length() * 3;
            int f0 = CodedOutputStream.f0(length);
            int i2 = f0 + length;
            int i3 = this.f;
            if (i2 > i3) {
                byte[] bArr = new byte[length];
                int i4 = Utf8.i(str, bArr, 0, length);
                S0(i4);
                i(bArr, 0, i4);
                return;
            }
            if (i2 > i3 - this.g) {
                b1();
            }
            int i5 = this.g;
            try {
                int f02 = CodedOutputStream.f0(str.length());
                if (f02 == f0) {
                    int i6 = i5 + f02;
                    this.g = i6;
                    int i7 = Utf8.i(str, this.e, i6, this.f - i6);
                    this.g = i5;
                    int i8 = (i7 - i5) - f02;
                    Z0(i8);
                    this.g = i7;
                    this.h += i8;
                    return;
                }
                int k = Utf8.k(str);
                Z0(k);
                this.g = Utf8.i(str, this.e, this.g, k);
                this.h += k;
            } catch (Utf8.UnpairedSurrogateException e) {
                this.h -= this.g - i5;
                this.g = i5;
                l0(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException((Throwable) e2);
            }
        }

        public void R0(int i2, int i3) {
            S0(WireFormat.c(i2, i3));
        }

        public void S0(int i2) {
            c1(5);
            Z0(i2);
        }

        public void T0(long j) {
            c1(10);
            a1(j);
        }

        public void a(int i2, ByteString byteString) {
            R0(i2, 2);
            v0(byteString);
        }

        public final void b1() {
            this.i.g(this.e, 0, this.g);
            this.g = 0;
        }

        public final void c1(int i2) {
            if (this.f - this.g < i2) {
                b1();
            }
        }

        public void d1(MessageLite messageLite, Schema schema) {
            S0(((AbstractMessageLite) messageLite).e(schema));
            schema.a(messageLite, this.f1068a);
        }

        public void g(byte[] bArr, int i2, int i3) {
            k0();
            this.i.g(bArr, i2, i3);
            this.h += i3;
        }

        public void h(ByteBuffer byteBuffer) {
            k0();
            int remaining = byteBuffer.remaining();
            this.i.h(byteBuffer);
            this.h += remaining;
        }

        public void i(byte[] bArr, int i2, int i3) {
            k0();
            this.i.i(bArr, i2, i3);
            this.h += i3;
        }

        public void k0() {
            if (this.g > 0) {
                b1();
            }
        }

        public void r0(byte b) {
            if (this.g == this.f) {
                b1();
            }
            U0(b);
        }

        public void u0(byte[] bArr, int i2, int i3) {
            S0(i3);
            g(bArr, i2, i3);
        }

        public void v0(ByteString byteString) {
            S0(byteString.size());
            byteString.writeTo((ByteOutput) this);
        }

        public void writeBool(int i2, boolean z) {
            c1(11);
            Y0(i2, 0);
            U0(z ? (byte) 1 : 0);
        }

        public void writeFixed32(int i2, int i3) {
            c1(14);
            Y0(i2, 5);
            V0(i3);
        }

        public void writeFixed64(int i2, long j) {
            c1(18);
            Y0(i2, 1);
            W0(j);
        }

        public void writeInt32(int i2, int i3) {
            c1(20);
            Y0(i2, 0);
            X0(i3);
        }

        public void writeString(int i2, String str) {
            R0(i2, 2);
            Q0(str);
        }

        public void writeUInt32(int i2, int i3) {
            c1(20);
            Y0(i2, 0);
            Z0(i3);
        }

        public void writeUInt64(int i2, long j) {
            c1(20);
            Y0(i2, 0);
            a1(j);
        }

        public void y0(int i2) {
            c1(4);
            V0(i2);
        }

        public void z0(long j) {
            c1(8);
            W0(j);
        }
    }

    public static final class HeapNioEncoder extends ArrayEncoder {
        public final ByteBuffer i;
        public int j;

        public void k0() {
            this.i.position(this.j + U0());
        }
    }

    public static class OutOfSpaceException extends IOException {
        private static final String MESSAGE = "CodedOutputStream was writing to a flat byte array and ran out of space.";
        private static final long serialVersionUID = -6947486886997889499L;

        public OutOfSpaceException() {
            super(MESSAGE);
        }

        public OutOfSpaceException(String str) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str);
        }

        public OutOfSpaceException(Throwable th) {
            super(MESSAGE, th);
        }

        public OutOfSpaceException(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }
    }

    public static final class OutputStreamEncoder extends AbstractBufferedEncoder {
        public final OutputStream i;

        public OutputStreamEncoder(OutputStream outputStream, int i2) {
            super(i2);
            if (outputStream != null) {
                this.i = outputStream;
                return;
            }
            throw new NullPointerException("out");
        }

        private void b1() {
            this.i.write(this.e, 0, this.g);
            this.g = 0;
        }

        private void c1(int i2) {
            if (this.f - this.g < i2) {
                b1();
            }
        }

        public void F0(int i2) {
            if (i2 >= 0) {
                S0(i2);
            } else {
                T0((long) i2);
            }
        }

        public void H0(int i2, MessageLite messageLite) {
            R0(i2, 2);
            J0(messageLite);
        }

        public void I0(int i2, MessageLite messageLite, Schema schema) {
            R0(i2, 2);
            e1(messageLite, schema);
        }

        public void J0(MessageLite messageLite) {
            S0(messageLite.getSerializedSize());
            messageLite.b(this);
        }

        public void K0(int i2, MessageLite messageLite) {
            R0(1, 3);
            writeUInt32(2, i2);
            H0(3, messageLite);
            R0(1, 4);
        }

        public void L0(int i2, ByteString byteString) {
            R0(1, 3);
            writeUInt32(2, i2);
            a(3, byteString);
            R0(1, 4);
        }

        public void Q0(String str) {
            int i2;
            int i3;
            try {
                int length = str.length() * 3;
                int f0 = CodedOutputStream.f0(length);
                int i4 = f0 + length;
                int i5 = this.f;
                if (i4 > i5) {
                    byte[] bArr = new byte[length];
                    int i6 = Utf8.i(str, bArr, 0, length);
                    S0(i6);
                    i(bArr, 0, i6);
                    return;
                }
                if (i4 > i5 - this.g) {
                    b1();
                }
                int f02 = CodedOutputStream.f0(str.length());
                i2 = this.g;
                if (f02 == f0) {
                    int i7 = i2 + f02;
                    this.g = i7;
                    int i8 = Utf8.i(str, this.e, i7, this.f - i7);
                    this.g = i2;
                    i3 = (i8 - i2) - f02;
                    Z0(i3);
                    this.g = i8;
                } else {
                    i3 = Utf8.k(str);
                    Z0(i3);
                    this.g = Utf8.i(str, this.e, this.g, i3);
                }
                this.h += i3;
            } catch (Utf8.UnpairedSurrogateException e) {
                this.h -= this.g - i2;
                this.g = i2;
                throw e;
            } catch (ArrayIndexOutOfBoundsException e2) {
                throw new OutOfSpaceException((Throwable) e2);
            } catch (Utf8.UnpairedSurrogateException e3) {
                l0(str, e3);
            }
        }

        public void R0(int i2, int i3) {
            S0(WireFormat.c(i2, i3));
        }

        public void S0(int i2) {
            c1(5);
            Z0(i2);
        }

        public void T0(long j) {
            c1(10);
            a1(j);
        }

        public void a(int i2, ByteString byteString) {
            R0(i2, 2);
            v0(byteString);
        }

        public void d1(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            int i2 = this.f;
            int i3 = this.g;
            if (i2 - i3 >= remaining) {
                byteBuffer.get(this.e, i3, remaining);
                this.g += remaining;
                this.h += remaining;
                return;
            }
            int i4 = i2 - i3;
            byteBuffer.get(this.e, i3, i4);
            int i5 = remaining - i4;
            this.g = this.f;
            this.h += i4;
            b1();
            while (true) {
                int i6 = this.f;
                if (i5 > i6) {
                    byteBuffer.get(this.e, 0, i6);
                    this.i.write(this.e, 0, this.f);
                    int i7 = this.f;
                    i5 -= i7;
                    this.h += i7;
                } else {
                    byteBuffer.get(this.e, 0, i5);
                    this.g = i5;
                    this.h += i5;
                    return;
                }
            }
        }

        public void e1(MessageLite messageLite, Schema schema) {
            S0(((AbstractMessageLite) messageLite).e(schema));
            schema.a(messageLite, this.f1068a);
        }

        public void g(byte[] bArr, int i2, int i3) {
            int i4 = this.f;
            int i5 = this.g;
            if (i4 - i5 >= i3) {
                System.arraycopy(bArr, i2, this.e, i5, i3);
                this.g += i3;
                this.h += i3;
                return;
            }
            int i6 = i4 - i5;
            System.arraycopy(bArr, i2, this.e, i5, i6);
            int i7 = i2 + i6;
            int i8 = i3 - i6;
            this.g = this.f;
            this.h += i6;
            b1();
            if (i8 <= this.f) {
                System.arraycopy(bArr, i7, this.e, 0, i8);
                this.g = i8;
            } else {
                this.i.write(bArr, i7, i8);
            }
            this.h += i8;
        }

        public void h(ByteBuffer byteBuffer) {
            d1(byteBuffer);
        }

        public void i(byte[] bArr, int i2, int i3) {
            g(bArr, i2, i3);
        }

        public void k0() {
            if (this.g > 0) {
                b1();
            }
        }

        public void r0(byte b) {
            if (this.g == this.f) {
                b1();
            }
            U0(b);
        }

        public void u0(byte[] bArr, int i2, int i3) {
            S0(i3);
            g(bArr, i2, i3);
        }

        public void v0(ByteString byteString) {
            S0(byteString.size());
            byteString.writeTo((ByteOutput) this);
        }

        public void writeBool(int i2, boolean z) {
            c1(11);
            Y0(i2, 0);
            U0(z ? (byte) 1 : 0);
        }

        public void writeFixed32(int i2, int i3) {
            c1(14);
            Y0(i2, 5);
            V0(i3);
        }

        public void writeFixed64(int i2, long j) {
            c1(18);
            Y0(i2, 1);
            W0(j);
        }

        public void writeInt32(int i2, int i3) {
            c1(20);
            Y0(i2, 0);
            X0(i3);
        }

        public void writeString(int i2, String str) {
            R0(i2, 2);
            Q0(str);
        }

        public void writeUInt32(int i2, int i3) {
            c1(20);
            Y0(i2, 0);
            Z0(i3);
        }

        public void writeUInt64(int i2, long j) {
            c1(20);
            Y0(i2, 0);
            a1(j);
        }

        public void y0(int i2) {
            c1(4);
            V0(i2);
        }

        public void z0(long j) {
            c1(8);
            W0(j);
        }
    }

    public static final class SafeDirectNioEncoder extends CodedOutputStream {
        public final ByteBuffer e;
        public final ByteBuffer f;

        public void F0(int i) {
            if (i >= 0) {
                S0(i);
            } else {
                T0((long) i);
            }
        }

        public void H0(int i, MessageLite messageLite) {
            R0(i, 2);
            J0(messageLite);
        }

        public void I0(int i, MessageLite messageLite, Schema schema) {
            R0(i, 2);
            W0(messageLite, schema);
        }

        public void J0(MessageLite messageLite) {
            S0(messageLite.getSerializedSize());
            messageLite.b(this);
        }

        public void K0(int i, MessageLite messageLite) {
            R0(1, 3);
            writeUInt32(2, i);
            H0(3, messageLite);
            R0(1, 4);
        }

        public void L0(int i, ByteString byteString) {
            R0(1, 3);
            writeUInt32(2, i);
            a(3, byteString);
            R0(1, 4);
        }

        public void Q0(String str) {
            int position = this.f.position();
            try {
                int f0 = CodedOutputStream.f0(str.length() * 3);
                int f02 = CodedOutputStream.f0(str.length());
                if (f02 == f0) {
                    int position2 = this.f.position() + f02;
                    this.f.position(position2);
                    U0(str);
                    int position3 = this.f.position();
                    this.f.position(position);
                    S0(position3 - position2);
                    this.f.position(position3);
                    return;
                }
                S0(Utf8.k(str));
                U0(str);
            } catch (Utf8.UnpairedSurrogateException e2) {
                this.f.position(position);
                l0(str, e2);
            } catch (IllegalArgumentException e3) {
                throw new OutOfSpaceException((Throwable) e3);
            }
        }

        public void R0(int i, int i2) {
            S0(WireFormat.c(i, i2));
        }

        public void S0(int i) {
            while ((i & -128) != 0) {
                this.f.put((byte) ((i & 127) | 128));
                i >>>= 7;
            }
            try {
                this.f.put((byte) i);
            } catch (BufferOverflowException e2) {
                throw new OutOfSpaceException((Throwable) e2);
            }
        }

        public void T0(long j) {
            while ((-128 & j) != 0) {
                this.f.put((byte) ((((int) j) & 127) | 128));
                j >>>= 7;
            }
            try {
                this.f.put((byte) ((int) j));
            } catch (BufferOverflowException e2) {
                throw new OutOfSpaceException((Throwable) e2);
            }
        }

        public final void U0(String str) {
            try {
                Utf8.j(str, this.f);
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException((Throwable) e2);
            }
        }

        public void V0(ByteBuffer byteBuffer) {
            try {
                this.f.put(byteBuffer);
            } catch (BufferOverflowException e2) {
                throw new OutOfSpaceException((Throwable) e2);
            }
        }

        public void W0(MessageLite messageLite, Schema schema) {
            S0(((AbstractMessageLite) messageLite).e(schema));
            schema.a(messageLite, this.f1068a);
        }

        public void a(int i, ByteString byteString) {
            R0(i, 2);
            v0(byteString);
        }

        public void g(byte[] bArr, int i, int i2) {
            try {
                this.f.put(bArr, i, i2);
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException((Throwable) e2);
            } catch (BufferOverflowException e3) {
                throw new OutOfSpaceException((Throwable) e3);
            }
        }

        public void h(ByteBuffer byteBuffer) {
            V0(byteBuffer);
        }

        public void i(byte[] bArr, int i, int i2) {
            g(bArr, i, i2);
        }

        public void k0() {
            this.e.position(this.f.position());
        }

        public int q0() {
            return this.f.remaining();
        }

        public void r0(byte b) {
            try {
                this.f.put(b);
            } catch (BufferOverflowException e2) {
                throw new OutOfSpaceException((Throwable) e2);
            }
        }

        public void u0(byte[] bArr, int i, int i2) {
            S0(i2);
            g(bArr, i, i2);
        }

        public void v0(ByteString byteString) {
            S0(byteString.size());
            byteString.writeTo((ByteOutput) this);
        }

        public void writeBool(int i, boolean z) {
            R0(i, 0);
            r0(z ? (byte) 1 : 0);
        }

        public void writeFixed32(int i, int i2) {
            R0(i, 5);
            y0(i2);
        }

        public void writeFixed64(int i, long j) {
            R0(i, 1);
            z0(j);
        }

        public void writeInt32(int i, int i2) {
            R0(i, 0);
            F0(i2);
        }

        public void writeString(int i, String str) {
            R0(i, 2);
            Q0(str);
        }

        public void writeUInt32(int i, int i2) {
            R0(i, 0);
            S0(i2);
        }

        public void writeUInt64(int i, long j) {
            R0(i, 0);
            T0(j);
        }

        public void y0(int i) {
            try {
                this.f.putInt(i);
            } catch (BufferOverflowException e2) {
                throw new OutOfSpaceException((Throwable) e2);
            }
        }

        public void z0(long j) {
            try {
                this.f.putLong(j);
            } catch (BufferOverflowException e2) {
                throw new OutOfSpaceException((Throwable) e2);
            }
        }
    }

    public static final class UnsafeDirectNioEncoder extends CodedOutputStream {
        public final ByteBuffer e;
        public final ByteBuffer f;
        public final long g;
        public final long h;
        public final long i;
        public long j;

        public void F0(int i2) {
            if (i2 >= 0) {
                S0(i2);
            } else {
                T0((long) i2);
            }
        }

        public void H0(int i2, MessageLite messageLite) {
            R0(i2, 2);
            J0(messageLite);
        }

        public void I0(int i2, MessageLite messageLite, Schema schema) {
            R0(i2, 2);
            X0(messageLite, schema);
        }

        public void J0(MessageLite messageLite) {
            S0(messageLite.getSerializedSize());
            messageLite.b(this);
        }

        public void K0(int i2, MessageLite messageLite) {
            R0(1, 3);
            writeUInt32(2, i2);
            H0(3, messageLite);
            R0(1, 4);
        }

        public void L0(int i2, ByteString byteString) {
            R0(1, 3);
            writeUInt32(2, i2);
            a(3, byteString);
            R0(1, 4);
        }

        public void Q0(String str) {
            long j2 = this.j;
            try {
                int f0 = CodedOutputStream.f0(str.length() * 3);
                int f02 = CodedOutputStream.f0(str.length());
                if (f02 == f0) {
                    int U0 = U0(this.j) + f02;
                    this.f.position(U0);
                    Utf8.j(str, this.f);
                    int position = this.f.position() - U0;
                    S0(position);
                    this.j += (long) position;
                    return;
                }
                int k = Utf8.k(str);
                S0(k);
                V0(this.j);
                Utf8.j(str, this.f);
                this.j += (long) k;
            } catch (Utf8.UnpairedSurrogateException e2) {
                this.j = j2;
                V0(j2);
                l0(str, e2);
            } catch (IllegalArgumentException e3) {
                throw new OutOfSpaceException((Throwable) e3);
            } catch (IndexOutOfBoundsException e4) {
                throw new OutOfSpaceException((Throwable) e4);
            }
        }

        public void R0(int i2, int i3) {
            S0(WireFormat.c(i2, i3));
        }

        public void S0(int i2) {
            if (this.j <= this.i) {
                while ((i2 & -128) != 0) {
                    long j2 = this.j;
                    this.j = j2 + 1;
                    UnsafeUtil.N(j2, (byte) ((i2 & 127) | 128));
                    i2 >>>= 7;
                }
                long j3 = this.j;
                this.j = 1 + j3;
                UnsafeUtil.N(j3, (byte) i2);
                return;
            }
            while (true) {
                long j4 = this.j;
                if (j4 >= this.h) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.j), Long.valueOf(this.h), 1}));
                } else if ((i2 & -128) == 0) {
                    this.j = 1 + j4;
                    UnsafeUtil.N(j4, (byte) i2);
                    return;
                } else {
                    this.j = j4 + 1;
                    UnsafeUtil.N(j4, (byte) ((i2 & 127) | 128));
                    i2 >>>= 7;
                }
            }
        }

        public void T0(long j2) {
            if (this.j <= this.i) {
                while ((j2 & -128) != 0) {
                    long j3 = this.j;
                    this.j = j3 + 1;
                    UnsafeUtil.N(j3, (byte) ((((int) j2) & 127) | 128));
                    j2 >>>= 7;
                }
                long j4 = this.j;
                this.j = 1 + j4;
                UnsafeUtil.N(j4, (byte) ((int) j2));
                return;
            }
            while (true) {
                long j5 = this.j;
                if (j5 >= this.h) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.j), Long.valueOf(this.h), 1}));
                } else if ((j2 & -128) == 0) {
                    this.j = 1 + j5;
                    UnsafeUtil.N(j5, (byte) ((int) j2));
                    return;
                } else {
                    this.j = j5 + 1;
                    UnsafeUtil.N(j5, (byte) ((((int) j2) & 127) | 128));
                    j2 >>>= 7;
                }
            }
        }

        public final int U0(long j2) {
            return (int) (j2 - this.g);
        }

        public final void V0(long j2) {
            this.f.position(U0(j2));
        }

        public void W0(ByteBuffer byteBuffer) {
            try {
                int remaining = byteBuffer.remaining();
                V0(this.j);
                this.f.put(byteBuffer);
                this.j += (long) remaining;
            } catch (BufferOverflowException e2) {
                throw new OutOfSpaceException((Throwable) e2);
            }
        }

        public void X0(MessageLite messageLite, Schema schema) {
            S0(((AbstractMessageLite) messageLite).e(schema));
            schema.a(messageLite, this.f1068a);
        }

        public void a(int i2, ByteString byteString) {
            R0(i2, 2);
            v0(byteString);
        }

        public void g(byte[] bArr, int i2, int i3) {
            if (bArr != null && i2 >= 0 && i3 >= 0 && bArr.length - i3 >= i2) {
                long j2 = (long) i3;
                long j3 = this.j;
                if (this.h - j2 >= j3) {
                    UnsafeUtil.o(bArr, (long) i2, j3, j2);
                    this.j += j2;
                    return;
                }
            }
            if (bArr == null) {
                throw new NullPointerException(AccountConstantKt.RESPONSE_VALUE);
            }
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.j), Long.valueOf(this.h), Integer.valueOf(i3)}));
        }

        public void h(ByteBuffer byteBuffer) {
            W0(byteBuffer);
        }

        public void i(byte[] bArr, int i2, int i3) {
            g(bArr, i2, i3);
        }

        public void k0() {
            this.e.position(U0(this.j));
        }

        public int q0() {
            return (int) (this.h - this.j);
        }

        public void r0(byte b) {
            long j2 = this.j;
            if (j2 < this.h) {
                this.j = 1 + j2;
                UnsafeUtil.N(j2, b);
                return;
            }
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.j), Long.valueOf(this.h), 1}));
        }

        public void u0(byte[] bArr, int i2, int i3) {
            S0(i3);
            g(bArr, i2, i3);
        }

        public void v0(ByteString byteString) {
            S0(byteString.size());
            byteString.writeTo((ByteOutput) this);
        }

        public void writeBool(int i2, boolean z) {
            R0(i2, 0);
            r0(z ? (byte) 1 : 0);
        }

        public void writeFixed32(int i2, int i3) {
            R0(i2, 5);
            y0(i3);
        }

        public void writeFixed64(int i2, long j2) {
            R0(i2, 1);
            z0(j2);
        }

        public void writeInt32(int i2, int i3) {
            R0(i2, 0);
            F0(i3);
        }

        public void writeString(int i2, String str) {
            R0(i2, 2);
            Q0(str);
        }

        public void writeUInt32(int i2, int i3) {
            R0(i2, 0);
            S0(i3);
        }

        public void writeUInt64(int i2, long j2) {
            R0(i2, 0);
            T0(j2);
        }

        public void y0(int i2) {
            this.f.putInt(U0(this.j), i2);
            this.j += 4;
        }

        public void z0(long j2) {
            this.f.putLong(U0(this.j), j2);
            this.j += 8;
        }
    }

    public static int A(int i, MessageLite messageLite, Schema schema) {
        return (d0(i) * 2) + C(messageLite, schema);
    }

    public static int B(MessageLite messageLite) {
        return messageLite.getSerializedSize();
    }

    public static int C(MessageLite messageLite, Schema schema) {
        return ((AbstractMessageLite) messageLite).e(schema);
    }

    public static int D(int i, int i2) {
        return d0(i) + E(i2);
    }

    public static int E(int i) {
        if (i >= 0) {
            return f0(i);
        }
        return 10;
    }

    public static int F(int i, long j) {
        return d0(i) + G(j);
    }

    public static int G(long j) {
        return h0(j);
    }

    public static int H(int i, LazyFieldLite lazyFieldLite) {
        return (d0(1) * 2) + e0(2, i) + I(3, lazyFieldLite);
    }

    public static int I(int i, LazyFieldLite lazyFieldLite) {
        return d0(i) + J(lazyFieldLite);
    }

    public static int J(LazyFieldLite lazyFieldLite) {
        return K(lazyFieldLite.b());
    }

    public static int K(int i) {
        return f0(i) + i;
    }

    public static int L(int i, MessageLite messageLite) {
        return (d0(1) * 2) + e0(2, i) + M(3, messageLite);
    }

    public static int M(int i, MessageLite messageLite) {
        return d0(i) + O(messageLite);
    }

    public static int N(int i, MessageLite messageLite, Schema schema) {
        return d0(i) + P(messageLite, schema);
    }

    public static int O(MessageLite messageLite) {
        return K(messageLite.getSerializedSize());
    }

    public static int P(MessageLite messageLite, Schema schema) {
        return K(((AbstractMessageLite) messageLite).e(schema));
    }

    public static int Q(int i) {
        if (i > 4096) {
            return 4096;
        }
        return i;
    }

    public static int R(int i, ByteString byteString) {
        return (d0(1) * 2) + e0(2, i) + o(3, byteString);
    }

    public static int S(int i) {
        return f0(i);
    }

    public static int T(int i, int i2) {
        return d0(i) + U(i2);
    }

    public static int U(int i) {
        return 4;
    }

    public static int V(int i, long j) {
        return d0(i) + W(j);
    }

    public static int W(long j) {
        return 8;
    }

    public static int X(int i, int i2) {
        return d0(i) + Y(i2);
    }

    public static int Y(int i) {
        return f0(i0(i));
    }

    public static int Z(int i, long j) {
        return d0(i) + a0(j);
    }

    public static int a0(long j) {
        return h0(j0(j));
    }

    public static int b0(int i, String str) {
        return d0(i) + c0(str);
    }

    public static int c0(String str) {
        int i;
        try {
            i = Utf8.k(str);
        } catch (Utf8.UnpairedSurrogateException unused) {
            i = str.getBytes(Internal.f1098a).length;
        }
        return K(i);
    }

    public static int d0(int i) {
        return f0(WireFormat.c(i, 0));
    }

    public static int e0(int i, int i2) {
        return d0(i) + f0(i2);
    }

    public static int f0(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    public static int g0(int i, long j) {
        return d0(i) + h0(j);
    }

    public static int h0(long j) {
        int i;
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if ((-34359738368L & j) != 0) {
            j >>>= 28;
            i = 6;
        } else {
            i = 2;
        }
        if ((-2097152 & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & -16384) != 0 ? i + 1 : i;
    }

    public static int i0(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static long j0(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int l(int i, boolean z) {
        return d0(i) + m(z);
    }

    public static int m(boolean z) {
        return 1;
    }

    public static int n(byte[] bArr) {
        return K(bArr.length);
    }

    public static CodedOutputStream n0(OutputStream outputStream, int i) {
        return new OutputStreamEncoder(outputStream, i);
    }

    public static int o(int i, ByteString byteString) {
        return d0(i) + p(byteString);
    }

    public static CodedOutputStream o0(byte[] bArr) {
        return p0(bArr, 0, bArr.length);
    }

    public static int p(ByteString byteString) {
        return K(byteString.size());
    }

    public static CodedOutputStream p0(byte[] bArr, int i, int i2) {
        return new ArrayEncoder(bArr, i, i2);
    }

    public static int q(int i, double d2) {
        return d0(i) + r(d2);
    }

    public static int r(double d2) {
        return 8;
    }

    public static int s(int i, int i2) {
        return d0(i) + t(i2);
    }

    public static int t(int i) {
        return E(i);
    }

    public static int u(int i, int i2) {
        return d0(i) + v(i2);
    }

    public static int v(int i) {
        return 4;
    }

    public static int w(int i, long j) {
        return d0(i) + x(j);
    }

    public static int x(long j) {
        return 8;
    }

    public static int y(int i, float f) {
        return d0(i) + z(f);
    }

    public static int z(float f) {
        return 4;
    }

    public final void A0(float f) {
        y0(Float.floatToRawIntBits(f));
    }

    public final void B0(int i, MessageLite messageLite) {
        R0(i, 3);
        D0(messageLite);
        R0(i, 4);
    }

    public final void C0(int i, MessageLite messageLite, Schema schema) {
        R0(i, 3);
        E0(messageLite, schema);
        R0(i, 4);
    }

    public final void D0(MessageLite messageLite) {
        messageLite.b(this);
    }

    public final void E0(MessageLite messageLite, Schema schema) {
        schema.a(messageLite, this.f1068a);
    }

    public abstract void F0(int i);

    public final void G0(long j) {
        T0(j);
    }

    public abstract void H0(int i, MessageLite messageLite);

    public abstract void I0(int i, MessageLite messageLite, Schema schema);

    public abstract void J0(MessageLite messageLite);

    public abstract void K0(int i, MessageLite messageLite);

    public abstract void L0(int i, ByteString byteString);

    public final void M0(int i) {
        y0(i);
    }

    public final void N0(long j) {
        z0(j);
    }

    public final void O0(int i) {
        S0(i0(i));
    }

    public final void P0(long j) {
        T0(j0(j));
    }

    public abstract void Q0(String str);

    public abstract void R0(int i, int i2);

    public abstract void S0(int i);

    public abstract void T0(long j);

    public abstract void a(int i, ByteString byteString);

    public abstract void i(byte[] bArr, int i, int i2);

    public final void k() {
        if (q0() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract void k0();

    public final void l0(String str, Utf8.UnpairedSurrogateException unpairedSurrogateException) {
        c.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", unpairedSurrogateException);
        byte[] bytes = str.getBytes(Internal.f1098a);
        try {
            S0(bytes.length);
            i(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new OutOfSpaceException((Throwable) e);
        } catch (OutOfSpaceException e2) {
            throw e2;
        }
    }

    public boolean m0() {
        return this.b;
    }

    public abstract int q0();

    public abstract void r0(byte b2);

    public final void s0(boolean z) {
        r0(z ? (byte) 1 : 0);
    }

    public final void t0(byte[] bArr) {
        u0(bArr, 0, bArr.length);
    }

    public abstract void u0(byte[] bArr, int i, int i2);

    public abstract void v0(ByteString byteString);

    public final void w0(double d2) {
        z0(Double.doubleToRawLongBits(d2));
    }

    public abstract void writeBool(int i, boolean z);

    public final void writeDouble(int i, double d2) {
        writeFixed64(i, Double.doubleToRawLongBits(d2));
    }

    public final void writeEnum(int i, int i2) {
        writeInt32(i, i2);
    }

    public abstract void writeFixed32(int i, int i2);

    public abstract void writeFixed64(int i, long j);

    public final void writeFloat(int i, float f) {
        writeFixed32(i, Float.floatToRawIntBits(f));
    }

    public abstract void writeInt32(int i, int i2);

    public final void writeInt64(int i, long j) {
        writeUInt64(i, j);
    }

    public final void writeSFixed32(int i, int i2) {
        writeFixed32(i, i2);
    }

    public final void writeSFixed64(int i, long j) {
        writeFixed64(i, j);
    }

    public final void writeSInt32(int i, int i2) {
        writeUInt32(i, i0(i2));
    }

    public final void writeSInt64(int i, long j) {
        writeUInt64(i, j0(j));
    }

    public abstract void writeString(int i, String str);

    public abstract void writeUInt32(int i, int i2);

    public abstract void writeUInt64(int i, long j);

    public final void x0(int i) {
        F0(i);
    }

    public abstract void y0(int i);

    public abstract void z0(long j);

    public CodedOutputStream() {
    }
}
