package zmq;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.SocketChannel;
import java.util.Arrays;
import zmq.io.Metadata;
import zmq.util.Utils;
import zmq.util.Wire;

public class Msg {

    /* renamed from: a  reason: collision with root package name */
    public Metadata f3600a;
    public int b;
    public Type c;
    public SocketChannel d;
    public final int e;
    public final ByteBuffer f;
    public int g;
    public int h;
    public int i;
    public String j;

    public static final class Builder extends Msg {
        public final ByteArrayOutputStream k = new ByteArrayOutputStream();

        public Msg B(ByteBuffer byteBuffer, int i, int i2) {
            if (byteBuffer == null) {
                return this;
            }
            for (int i3 = i; i3 < i + i2; i3++) {
                this.k.write(byteBuffer.get(i3));
            }
            N(m() + i2);
            return this;
        }

        public Msg D(byte[] bArr, int i, int i2) {
            if (bArr == null) {
                return this;
            }
            this.k.write(bArr, i, i2);
            N(m() + i2);
            return this;
        }

        public Msg E(String str) {
            if (str == null) {
                return this;
            }
            int length = str.length();
            Utils.b(length < 256, "String must be strictly smaller than 256 characters");
            this.k.write((byte) length);
            this.k.write(str.getBytes(ZMQ.c), 0, length);
            N(m() + length + 1);
            return this;
        }

        public void J(int i) {
            Msg.super.J(i);
        }

        public int O() {
            return this.k.size();
        }

        public Msg Q() {
            return new Msg(this.k);
        }

        public Msg z(int i, byte b) {
            this.k.write(b);
            return this;
        }
    }

    public enum Type {
        DATA,
        JOIN,
        LEAVE,
        DELIMITER
    }

    public Msg A(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = this.f.duplicate();
        duplicate.position(this.g);
        this.g += Math.min(duplicate.remaining(), byteBuffer.remaining());
        duplicate.put(byteBuffer);
        return this;
    }

    public Msg B(ByteBuffer byteBuffer, int i2, int i3) {
        if (byteBuffer == null) {
            return this;
        }
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        byteBuffer.limit(i3 + i2).position(i2);
        A(byteBuffer);
        byteBuffer.limit(limit).position(position);
        return this;
    }

    public Msg C(byte[] bArr) {
        return D(bArr, 0, bArr.length);
    }

    public Msg D(byte[] bArr, int i2, int i3) {
        if (bArr == null) {
            return this;
        }
        ByteBuffer duplicate = this.f.duplicate();
        duplicate.position(this.g);
        this.g += i3;
        duplicate.put(bArr, i2, i3);
        return this;
    }

    public Msg E(String str) {
        if (str == null) {
            return this;
        }
        ByteBuffer duplicate = this.f.duplicate();
        duplicate.position(this.g);
        this.g += Wire.f(duplicate, str);
        return this;
    }

    public void F(int i2) {
        this.b = (~i2) & this.b;
    }

    public void G() {
        L((Metadata) null);
    }

    public void H() {
        this.i = 0;
    }

    public void I(SocketChannel socketChannel) {
        this.d = socketChannel;
    }

    public void J(int i2) {
        this.b = i2 | this.b;
    }

    public boolean K(String str) {
        if (str.length() > 255) {
            return false;
        }
        this.j = str;
        return true;
    }

    public Msg L(Metadata metadata) {
        this.f3600a = metadata;
        return this;
    }

    public boolean M(int i2) {
        if (i2 == 0) {
            return false;
        }
        this.i = i2;
        return true;
    }

    public final void N(int i2) {
        this.g = i2;
    }

    public int O() {
        return this.e;
    }

    public void P(ByteBuffer byteBuffer, int i2, int i3) {
        int position = this.f.position();
        int limit = this.f.limit();
        this.f.limit(i3 + i2).position(i2);
        byteBuffer.put(this.f);
        this.f.limit(limit).position(position);
    }

    public ByteBuffer a() {
        return this.f.duplicate();
    }

    public boolean b() {
        return true;
    }

    public byte[] c() {
        if (this.f.hasArray()) {
            byte[] array = this.f.array();
            int arrayOffset = this.f.arrayOffset();
            return (arrayOffset == 0 && array.length == this.e) ? array : Arrays.copyOfRange(array, arrayOffset, this.e + arrayOffset);
        }
        byte[] bArr = new byte[this.e];
        ByteBuffer duplicate = this.f.duplicate();
        duplicate.position(0);
        duplicate.get(bArr);
        return bArr;
    }

    public int d() {
        return this.b;
    }

    public byte e(int i2) {
        return this.f.get(i2);
    }

    public int f(int i2, byte[] bArr, int i3, int i4) {
        int min = Math.min(i4, this.e - i2);
        if (this.f.hasArray()) {
            System.arraycopy(this.f.array(), this.f.arrayOffset() + i2, bArr, i3, min);
        } else {
            ByteBuffer duplicate = this.f.duplicate();
            duplicate.position(i2);
            duplicate.get(bArr, i3, min);
        }
        return min;
    }

    public String g() {
        return this.j;
    }

    public int h(int i2) {
        return Wire.b(this.f, i2);
    }

    public long i(int i2) {
        return Wire.c(this.f, i2);
    }

    public Metadata j() {
        return this.f3600a;
    }

    public int k() {
        return this.i;
    }

    public int l(int i2) {
        return Wire.a(this.f, i2);
    }

    public final int m() {
        return this.g;
    }

    public boolean n() {
        return (this.b & 1) > 0;
    }

    public void o() {
        this.c = Type.DELIMITER;
        this.f3600a = null;
        this.b = 0;
    }

    public void p() {
        this.c = Type.JOIN;
        this.f3600a = null;
        this.b = 0;
    }

    public void q() {
        this.c = Type.LEAVE;
        this.f3600a = null;
        this.b = 0;
    }

    public boolean r() {
        return (this.b & 2) == 2;
    }

    public boolean s() {
        return (this.b & 32) == 32;
    }

    public boolean t() {
        return this.c == Type.DELIMITER;
    }

    public String toString() {
        return String.format("#zmq.Msg{type=%s, size=%s, flags=%s}", new Object[]{this.c, Integer.valueOf(this.e), Integer.valueOf(this.b)});
    }

    public boolean u() {
        return (this.b & 64) == 64;
    }

    public boolean v() {
        return this.c == Type.JOIN;
    }

    public boolean w() {
        return this.c == Type.LEAVE;
    }

    public Msg x(byte b2) {
        int i2 = this.g;
        this.g = i2 + 1;
        return z(i2, b2);
    }

    public Msg y(int i2) {
        int i3 = this.g;
        this.g = i3 + 1;
        return z(i3, (byte) i2);
    }

    public Msg z(int i2, byte b2) {
        this.f.put(i2, b2);
        return this;
    }

    public Msg() {
        this(0);
    }

    public Msg(int i2) {
        this.g = 0;
        this.h = 0;
        this.c = Type.DATA;
        this.b = 0;
        this.e = i2;
        this.f = ByteBuffer.wrap(new byte[i2]).order(ByteOrder.BIG_ENDIAN);
    }

    public Msg(byte[] bArr) {
        this.g = 0;
        this.h = 0;
        bArr = bArr == null ? new byte[0] : bArr;
        this.c = Type.DATA;
        this.b = 0;
        this.e = bArr.length;
        this.f = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN);
    }

    public Msg(ByteBuffer byteBuffer) {
        this.g = 0;
        this.h = 0;
        if (byteBuffer != null) {
            this.c = Type.DATA;
            this.b = 0;
            ByteBuffer duplicate = byteBuffer.duplicate();
            this.f = duplicate;
            this.e = duplicate.remaining();
            return;
        }
        throw new IllegalArgumentException("ByteBuffer cannot be null");
    }

    public Msg(Msg msg) {
        this.g = 0;
        this.h = 0;
        if (msg != null) {
            this.c = msg.c;
            this.b = msg.b;
            this.e = msg.e;
            ByteBuffer byteBuffer = msg.f;
            this.f = byteBuffer != null ? byteBuffer.duplicate() : null;
            return;
        }
        throw new IllegalArgumentException("Msg cannot be null");
    }

    public Msg(Msg msg, ByteArrayOutputStream byteArrayOutputStream) {
        this(ByteBuffer.wrap(byteArrayOutputStream.toByteArray()));
        this.c = msg.c;
        this.b = msg.b;
    }
}
