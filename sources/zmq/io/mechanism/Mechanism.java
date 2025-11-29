package zmq.io.mechanism;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import zmq.Msg;
import zmq.Options;
import zmq.ZMQ;
import zmq.io.Metadata;
import zmq.io.Msgs;
import zmq.io.SessionBase;
import zmq.io.net.Address;
import zmq.socket.Sockets;
import zmq.util.Blob;
import zmq.util.Wire;

public abstract class Mechanism {

    /* renamed from: a  reason: collision with root package name */
    public final Options f3630a;
    public Blob b;
    public Blob c;
    public final Metadata d = new Metadata();
    public final Metadata e = new Metadata();
    public final SessionBase f;
    public final Address g;
    public String h;

    public enum Status {
        HANDSHAKING,
        READY,
        ERROR
    }

    public Mechanism(SessionBase sessionBase, Address address, Options options) {
        this.f = sessionBase;
        this.f3630a = options;
        this.g = address;
    }

    public final void b(ByteBuffer byteBuffer, String str, String str2) {
        c(byteBuffer, str, str2.getBytes(ZMQ.c));
    }

    public final void c(ByteBuffer byteBuffer, String str, byte[] bArr) {
        byte[] bytes = str.getBytes(ZMQ.c);
        int length = bytes.length;
        int length2 = bArr == null ? 0 : bArr.length;
        byteBuffer.put((byte) length);
        byteBuffer.put(bytes);
        Wire.i(byteBuffer, length2);
        if (bArr != null) {
            byteBuffer.put(bArr);
        }
    }

    public final void d(Msg msg, String str, String str2) {
        e(msg, str, str2.getBytes(ZMQ.c));
    }

    public final void e(Msg msg, String str, byte[] bArr) {
        byte[] bytes = str.getBytes(ZMQ.c);
        int length = bytes.length;
        int length2 = bArr == null ? 0 : bArr.length;
        msg.x((byte) length);
        msg.C(bytes);
        Wire.j(msg, length2);
        if (bArr != null) {
            msg.C(bArr);
        }
    }

    public boolean f(ByteBuffer byteBuffer, byte[] bArr, int i, int i2) {
        if (i2 > bArr.length) {
            return false;
        }
        boolean z = true;
        for (int i3 = 0; i3 < i2; i3++) {
            z = byteBuffer.get(i3 + i) == bArr[i3];
            if (!z) {
                break;
            }
        }
        return z;
    }

    public boolean g(Msg msg, String str, boolean z) {
        return Msgs.a(msg, str, z);
    }

    public Msg h(Msg msg) {
        return msg;
    }

    public void i() {
    }

    public Msg j(Msg msg) {
        return msg;
    }

    public final Blob k() {
        return this.c;
    }

    public int l(String str) {
        if (str.length() == 3 && str.charAt(1) == '0' && str.charAt(2) == '0' && str.charAt(0) >= '3' && str.charAt(0) <= '5') {
            try {
                this.f.t1().J1(this.f.s1(), Integer.parseInt(str));
                return 0;
            } catch (NumberFormatException unused) {
                this.f.t1().K1(this.f.s1(), 536870913);
            }
        } else {
            this.f.t1().K1(this.f.s1(), 536870913);
        }
        return -1;
    }

    public abstract int m(Msg msg);

    public int n(Msg msg) {
        if (msg.O() < 7 && msg.O() != 6) {
            this.f.t1().K1(this.f.s1(), 268435477);
            return 156384820;
        } else if (msg.O() < 7) {
            return 0;
        } else {
            if (msg.e(6) <= msg.O() - 7) {
                return (msg.O() != 10 || l(new String(Arrays.copyOfRange(msg.c(), 7, 10), ZMQ.c)) >= 0) ? 0 : 156384820;
            }
            this.f.t1().K1(this.f.s1(), 268435477);
            return 156384820;
        }
    }

    public final int o(ByteBuffer byteBuffer, int i, boolean z) {
        return (z ? this.d : this.e).d(byteBuffer, i, new Metadata.ParseListener() {
            public int a(String str, byte[] bArr, String str2) {
                Options options = Mechanism.this.f3630a;
                int i = options.i0;
                if (i == -1) {
                    i = options.m;
                }
                if ("Identity".equals(str)) {
                    Mechanism mechanism = Mechanism.this;
                    if (mechanism.f3630a.x) {
                        mechanism.v(bArr);
                        return 0;
                    }
                }
                return "Socket-Type".equals(str) ? !Sockets.compatible(i, str2) ? 22 : 0 : Mechanism.this.s(str, bArr) == -1 ? -1 : 0;
            }
        });
    }

    public final int p(Msg msg, int i, boolean z) {
        return o(msg.a(), i, z);
    }

    public final Msg q() {
        int i;
        byte[] bArr = new byte[0];
        Blob blob = this.b;
        if (blob != null) {
            bArr = blob.d();
            i = this.b.e();
        } else {
            i = 0;
        }
        Msg msg = new Msg(i);
        msg.D(bArr, 0, i);
        msg.J(64);
        return msg;
    }

    public abstract int r(Msg msg);

    public int s(String str, byte[] bArr) {
        return 0;
    }

    public final int t() {
        ArrayList arrayList = new ArrayList(7);
        int i = 0;
        while (true) {
            int i2 = 1;
            if (i < 7) {
                Msg w1 = this.f.w1();
                if (w1 == null) {
                    return this.f.j.a();
                }
                int d2 = w1.d() & 1;
                if (i < 6) {
                    i2 = 0;
                }
                if (d2 == i2) {
                    this.f.t1().K1(this.f.s1(), 536870913);
                    return 156384820;
                }
                arrayList.add(w1);
                i++;
            } else if (((Msg) arrayList.get(0)).O() > 0) {
                this.f.t1().K1(this.f.s1(), 536870912);
                return 156384820;
            } else if (((Msg) arrayList.get(1)).O() != 3 || !g((Msg) arrayList.get(1), "1.0", false)) {
                this.f.t1().K1(this.f.s1(), 536870915);
                return 156384820;
            } else if (((Msg) arrayList.get(2)).O() != 1 || !g((Msg) arrayList.get(2), "1", false)) {
                this.f.t1().K1(this.f.s1(), 536870914);
                return 156384820;
            } else if (((Msg) arrayList.get(3)).O() != 3) {
                this.f.t1().K1(this.f.s1(), 536870916);
                return 156384820;
            } else {
                this.h = new String(((Msg) arrayList.get(3)).c(), ZMQ.c);
                w(((Msg) arrayList.get(5)).c());
                return p((Msg) arrayList.get(6), 0, true);
            }
        }
    }

    public final void u(Mechanisms mechanisms, boolean z) {
        Msg msg = new Msg();
        msg.J(1);
        this.f.A1(msg);
        Msg msg2 = new Msg(3);
        msg2.J(1);
        Charset charset = ZMQ.c;
        msg2.C("1.0".getBytes(charset));
        this.f.A1(msg2);
        Msg msg3 = new Msg(1);
        msg3.J(1);
        msg3.C("1".getBytes(charset));
        this.f.A1(msg3);
        Msg msg4 = new Msg(this.f3630a.I.length());
        msg4.J(1);
        msg4.C(this.f3630a.I.getBytes(charset));
        this.f.A1(msg4);
        byte[] bytes = this.g.b().getBytes(charset);
        Msg msg5 = new Msg(bytes.length);
        msg5.J(1);
        msg5.C(bytes);
        this.f.A1(msg5);
        Msg msg6 = new Msg((int) this.f3630a.d);
        msg6.J(1);
        Options options = this.f3630a;
        msg6.D(options.e, 0, options.d);
        this.f.A1(msg6);
        Msg msg7 = new Msg(mechanisms.name().length());
        msg7.C(mechanisms.name().getBytes(charset));
        if (z) {
            msg7.J(1);
        }
        this.f.A1(msg7);
    }

    public final void v(byte[] bArr) {
        this.b = Blob.b(bArr);
    }

    public final void w(byte[] bArr) {
        this.c = Blob.b(bArr);
        this.d.e("User-Id", new String(bArr, ZMQ.c));
    }

    public final String x() {
        Options options = this.f3630a;
        int i = options.i0;
        return i != -1 ? Sockets.name(i) : Sockets.name(options.m);
    }

    public abstract Status y();

    public abstract int z();
}
