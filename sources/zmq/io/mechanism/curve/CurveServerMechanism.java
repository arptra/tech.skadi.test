package zmq.io.mechanism.curve;

import com.upuphone.runasone.uupcast.CaptureType;
import com.upuphone.starrynet.strategy.discovery.advertiser.pack.AdvPackConstants;
import com.xjsd.ai.assistant.protocol.CmdCode;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import zmq.Msg;
import zmq.Options;
import zmq.ZMQ;
import zmq.io.SessionBase;
import zmq.io.mechanism.Mechanism;
import zmq.io.mechanism.Mechanisms;
import zmq.io.mechanism.curve.Curve;
import zmq.io.net.Address;
import zmq.util.Errno;
import zmq.util.Wire;

public class CurveServerMechanism extends Mechanism {
    public long i = 1;
    public long j = 1;
    public final byte[] k;
    public final byte[] l;
    public final byte[] m;
    public byte[] n = new byte[Curve.Size.PUBLICKEY.bytes()];
    public byte[] o;
    public final byte[] p = new byte[Curve.Size.BEFORENM.bytes()];
    public State q = State.EXPECT_HELLO;
    public final Curve r;
    public final Errno s;

    /* renamed from: zmq.io.mechanism.curve.CurveServerMechanism$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f3633a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                zmq.io.mechanism.curve.CurveServerMechanism$State[] r0 = zmq.io.mechanism.curve.CurveServerMechanism.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3633a = r0
                zmq.io.mechanism.curve.CurveServerMechanism$State r1 = zmq.io.mechanism.curve.CurveServerMechanism.State.SEND_WELCOME     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f3633a     // Catch:{ NoSuchFieldError -> 0x001d }
                zmq.io.mechanism.curve.CurveServerMechanism$State r1 = zmq.io.mechanism.curve.CurveServerMechanism.State.SEND_READY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f3633a     // Catch:{ NoSuchFieldError -> 0x0028 }
                zmq.io.mechanism.curve.CurveServerMechanism$State r1 = zmq.io.mechanism.curve.CurveServerMechanism.State.SEND_ERROR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f3633a     // Catch:{ NoSuchFieldError -> 0x0033 }
                zmq.io.mechanism.curve.CurveServerMechanism$State r1 = zmq.io.mechanism.curve.CurveServerMechanism.State.EXPECT_HELLO     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f3633a     // Catch:{ NoSuchFieldError -> 0x003e }
                zmq.io.mechanism.curve.CurveServerMechanism$State r1 = zmq.io.mechanism.curve.CurveServerMechanism.State.EXPECT_INITIATE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: zmq.io.mechanism.curve.CurveServerMechanism.AnonymousClass1.<clinit>():void");
        }
    }

    public enum State {
        EXPECT_HELLO,
        SEND_WELCOME,
        EXPECT_INITIATE,
        EXPECT_ZAP_REPLY,
        SEND_READY,
        SEND_ERROR,
        ERROR_SENT,
        CONNECTED
    }

    public CurveServerMechanism(SessionBase sessionBase, Address address, Options options) {
        super(sessionBase, address, options);
        this.k = options.M;
        Curve curve = new Curve();
        this.r = curve;
        byte[][] f = curve.f();
        this.l = f[0];
        this.m = f[1];
        this.s = options.k0;
    }

    public final int A(Msg msg) {
        if (!g(msg, "HELLO", true)) {
            this.f.t1().K1(this.f.s1(), 268435457);
            return 156384820;
        } else if (msg.O() != 200) {
            this.f.t1().K1(this.f.s1(), 268435475);
            return 156384820;
        } else {
            byte e = msg.e(6);
            byte e2 = msg.e(7);
            if (e == 1 && e2 == 0) {
                msg.f(80, this.n, 0, Curve.Size.PUBLICKEY.bytes());
                ByteBuffer allocate = ByteBuffer.allocate(Curve.Size.NONCE.bytes());
                ByteBuffer allocate2 = ByteBuffer.allocate(Curve.Size.ZERO.bytes() + 64);
                Curve.Size size = Curve.Size.BOXZERO;
                ByteBuffer allocate3 = ByteBuffer.allocate(size.bytes() + 80);
                allocate.put("CurveZMQHELLO---".getBytes(ZMQ.c));
                msg.P(allocate, 112, 8);
                this.j = msg.i(112);
                allocate3.position(size.bytes());
                msg.P(allocate3, 120, 80);
                if (this.r.g(allocate2, allocate3, allocate3.capacity(), allocate, this.n, this.k) != 0) {
                    this.f.t1().K1(this.f.s1(), 285212673);
                    this.q = State.SEND_ERROR;
                    this.h = null;
                    return 0;
                }
                this.q = State.SEND_WELCOME;
                return 0;
            }
            this.f.t1().K1(this.f.s1(), 268435475);
            return 156384820;
        }
    }

    public final int B(Msg msg) {
        Msg msg2 = msg;
        if (!g(msg2, "INITIATE", true)) {
            this.f.t1().K1(this.f.s1(), 268435457);
            return 156384820;
        } else if (msg.O() < 257) {
            this.f.t1().K1(this.f.s1(), 268435476);
            return 156384820;
        } else {
            Curve.Size size = Curve.Size.NONCE;
            ByteBuffer allocate = ByteBuffer.allocate(size.bytes());
            Curve.Size size2 = Curve.Size.ZERO;
            ByteBuffer allocate2 = ByteBuffer.allocate(size2.bytes() + 64);
            Curve.Size size3 = Curve.Size.BOXZERO;
            ByteBuffer allocate3 = ByteBuffer.allocate(size3.bytes() + 80);
            allocate3.position(size3.bytes());
            msg2.P(allocate3, 25, 80);
            Charset charset = ZMQ.c;
            allocate.put("COOKIE--".getBytes(charset));
            msg2.P(allocate, 9, 16);
            if (this.r.n(allocate2, allocate3, allocate3.capacity(), allocate, this.o) != 0) {
                this.f.t1().K1(this.f.s1(), 285212673);
                return 156384820;
            } else if (!f(allocate2, this.n, size2.bytes(), 32) || !f(allocate2, this.m, size2.bytes() + 32, 32)) {
                this.f.t1().K1(this.f.s1(), 285212673);
                return 156384820;
            } else {
                int O = (msg.O() - 113) + size3.bytes();
                ByteBuffer allocate4 = ByteBuffer.allocate(size.bytes());
                ByteBuffer allocate5 = ByteBuffer.allocate(size2.bytes() + 384);
                ByteBuffer allocate6 = ByteBuffer.allocate(size3.bytes() + CmdCode.CODE_WAKEUP_RECORDING);
                allocate6.position(size3.bytes());
                msg2.P(allocate6, 113, O - size3.bytes());
                allocate4.put("CurveZMQINITIATE".getBytes(charset));
                msg2.P(allocate4, 105, 8);
                this.j = msg2.i(105);
                if (this.r.g(allocate5, allocate6, O, allocate4, this.n, this.m) != 0) {
                    this.f.t1().K1(this.f.s1(), 285212673);
                    return 156384820;
                }
                byte[] bArr = new byte[384];
                allocate5.position(size2.bytes());
                allocate5.get(bArr);
                ByteBuffer allocate7 = ByteBuffer.allocate(size.bytes());
                ByteBuffer allocate8 = ByteBuffer.allocate(size2.bytes() + 64);
                ByteBuffer allocate9 = ByteBuffer.allocate(size3.bytes() + 80);
                allocate9.position(size3.bytes());
                allocate5.limit(size2.bytes() + 128).position(size2.bytes() + 48);
                allocate9.put(allocate5);
                allocate7.put("VOUCH---".getBytes(charset));
                allocate5.limit(size2.bytes() + 48).position(size2.bytes() + 32);
                allocate7.put(allocate5);
                if (this.r.g(allocate8, allocate9, allocate9.capacity(), allocate7, bArr, this.m) != 0) {
                    this.f.t1().K1(this.f.s1(), 285212673);
                    return 156384820;
                } else if (!f(allocate8, this.n, size2.bytes(), 32)) {
                    this.f.t1().K1(this.f.s1(), 268435459);
                    return 156384820;
                } else {
                    this.r.c(this.p, this.n, this.m);
                    if (this.f.B1() == 0) {
                        F(bArr);
                        int t = t();
                        if (t == 0) {
                            this.q = "200".equals(this.h) ? State.SEND_READY : State.SEND_ERROR;
                        } else if (t != 35) {
                            return -1;
                        } else {
                            this.q = State.EXPECT_ZAP_REPLY;
                        }
                    } else {
                        this.q = State.SEND_READY;
                    }
                    allocate5.position(0);
                    allocate5.limit(O);
                    return o(allocate5, size2.bytes() + 128, false);
                }
            }
        }
    }

    public final int C(Msg msg) {
        msg.E("ERROR");
        String str = this.h;
        if (str != null) {
            msg.E(str);
            return 0;
        }
        msg.E("");
        return 0;
    }

    public final int D(Msg msg) {
        ByteBuffer allocate = ByteBuffer.allocate(Curve.Size.NONCE.bytes());
        Curve.Size size = Curve.Size.ZERO;
        ByteBuffer allocate2 = ByteBuffer.allocate(size.bytes() + 256);
        Curve.Size size2 = Curve.Size.BOXZERO;
        ByteBuffer allocate3 = ByteBuffer.allocate(size2.bytes() + 272);
        allocate2.position(size.bytes());
        b(allocate2, "Socket-Type", x());
        Options options = this.f3630a;
        int i2 = options.m;
        if (i2 == 3 || i2 == 5 || i2 == 6) {
            c(allocate2, "Identity", options.e);
        }
        int position = allocate2.position();
        allocate.put("CurveZMQREADY---".getBytes(ZMQ.c));
        Wire.l(allocate, this.i);
        this.r.a(allocate3, allocate2, position, allocate, this.p);
        msg.E("READY");
        msg.B(allocate, 16, 8);
        msg.B(allocate3, size2.bytes(), position - size2.bytes());
        this.i++;
        return 0;
    }

    public final int E(Msg msg) {
        Msg msg2 = msg;
        Curve.Size size = Curve.Size.NONCE;
        ByteBuffer allocate = ByteBuffer.allocate(size.bytes());
        Curve.Size size2 = Curve.Size.ZERO;
        ByteBuffer allocate2 = ByteBuffer.allocate(size2.bytes() + 64);
        Curve.Size size3 = Curve.Size.BOXZERO;
        ByteBuffer allocate3 = ByteBuffer.allocate(size3.bytes() + 80);
        Charset charset = ZMQ.c;
        allocate.put("COOKIE--".getBytes(charset));
        allocate.put(this.r.k(16));
        allocate2.position(size2.bytes());
        allocate2.put(this.n);
        allocate2.put(this.m);
        this.o = this.r.k(Curve.Size.KEY.bytes());
        this.r.l(allocate3, allocate2, allocate2.capacity(), allocate, this.o);
        ByteBuffer allocate4 = ByteBuffer.allocate(size.bytes());
        ByteBuffer allocate5 = ByteBuffer.allocate(size2.bytes() + 128);
        ByteBuffer allocate6 = ByteBuffer.allocate(size3.bytes() + AdvPackConstants.ADV_MODE_ACTIVE_NO_WINDOW);
        allocate4.put("WELCOME-".getBytes(charset));
        allocate4.put(this.r.k(size.bytes() - 8));
        allocate5.position(size2.bytes());
        allocate5.put(this.l);
        allocate.limit(24).position(8);
        allocate5.put(allocate);
        allocate3.limit(size3.bytes() + 80).position(size3.bytes());
        allocate5.put(allocate3);
        if (this.r.d(allocate6, allocate5, allocate5.capacity(), allocate4, this.n, this.k) == -1) {
            return -1;
        }
        msg2.E("WELCOME");
        msg2.B(allocate4, 8, 16);
        msg2.B(allocate6, size3.bytes(), AdvPackConstants.ADV_MODE_ACTIVE_NO_WINDOW);
        return 0;
    }

    public final void F(byte[] bArr) {
        u(Mechanisms.CURVE, true);
        Curve.Size size = Curve.Size.PUBLICKEY;
        Msg msg = new Msg(size.bytes());
        msg.D(bArr, 0, size.bytes());
        this.f.A1(msg);
    }

    public Msg h(Msg msg) {
        if (!g(msg, "MESSAGE", true)) {
            this.f.t1().K1(this.f.s1(), 268435457);
            this.s.c(156384820);
            return null;
        } else if (msg.O() < 33) {
            this.f.t1().K1(this.f.s1(), 268435474);
            this.s.c(156384820);
            return null;
        } else {
            ByteBuffer allocate = ByteBuffer.allocate(Curve.Size.NONCE.bytes());
            allocate.put("CurveZMQMESSAGEC".getBytes(ZMQ.c));
            msg.P(allocate, 8, 8);
            long i2 = msg.i(8);
            if (i2 <= this.j) {
                this.f.t1().K1(this.f.s1(), 268435458);
                this.s.c(156384820);
                return null;
            }
            this.j = i2;
            Curve.Size size = Curve.Size.BOXZERO;
            int bytes = size.bytes() + msg.O();
            int i3 = bytes - 16;
            ByteBuffer allocate2 = ByteBuffer.allocate(i3);
            ByteBuffer allocate3 = ByteBuffer.allocate(i3);
            allocate3.position(size.bytes());
            msg.P(allocate3, 16, msg.O() - 16);
            if (this.r.i(allocate2, allocate3, i3, allocate, this.p) == 0) {
                Curve.Size size2 = Curve.Size.ZERO;
                Msg msg2 = new Msg((bytes - 17) - size2.bytes());
                byte b = allocate2.get(size2.bytes());
                if ((b & 1) != 0) {
                    msg2.J(1);
                }
                if ((b & 2) != 0) {
                    msg2.J(2);
                }
                allocate2.position(size2.bytes() + 1);
                msg2.A(allocate2);
                return msg2;
            }
            this.f.t1().K1(this.f.s1(), 285212673);
            this.s.c(156384820);
            return null;
        }
    }

    public Msg j(Msg msg) {
        byte b = msg.n() ? (byte) 1 : 0;
        if (msg.r()) {
            b = (byte) (b | 2);
        }
        ByteBuffer allocate = ByteBuffer.allocate(Curve.Size.NONCE.bytes());
        allocate.put("CurveZMQMESSAGES".getBytes(ZMQ.c));
        Wire.l(allocate, this.i);
        Curve.Size size = Curve.Size.ZERO;
        int bytes = size.bytes() + 1 + msg.O();
        ByteBuffer allocate2 = ByteBuffer.allocate(bytes);
        allocate2.put(size.bytes(), b);
        allocate2.position(size.bytes() + 1);
        msg.P(allocate2, 0, msg.O());
        ByteBuffer allocate3 = ByteBuffer.allocate(bytes);
        this.r.a(allocate3, allocate2, bytes, allocate, this.p);
        Curve.Size size2 = Curve.Size.BOXZERO;
        Msg msg2 = new Msg((bytes + 16) - size2.bytes());
        msg2.E("MESSAGE");
        msg2.B(allocate, 16, 8);
        msg2.B(allocate3, size2.bytes(), bytes - size2.bytes());
        this.i++;
        return msg2;
    }

    public int m(Msg msg) {
        int E;
        int i2 = AnonymousClass1.f3633a[this.q.ordinal()];
        if (i2 == 1) {
            E = E(msg);
            if (E == 0) {
                this.q = State.EXPECT_INITIATE;
            }
        } else if (i2 == 2) {
            E = D(msg);
            if (E == 0) {
                this.q = State.CONNECTED;
            }
        } else if (i2 != 3) {
            return 35;
        } else {
            E = C(msg);
            if (E == 0) {
                this.q = State.ERROR_SENT;
            }
        }
        return E;
    }

    public int r(Msg msg) {
        int i2 = AnonymousClass1.f3633a[this.q.ordinal()];
        if (i2 == 4) {
            return A(msg);
        }
        if (i2 == 5) {
            return B(msg);
        }
        this.f.t1().K1(this.f.s1(), CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
        return 156384820;
    }

    public Mechanism.Status y() {
        State state = this.q;
        return state == State.CONNECTED ? Mechanism.Status.READY : state == State.ERROR_SENT ? Mechanism.Status.ERROR : Mechanism.Status.HANDSHAKING;
    }

    public int z() {
        if (this.q != State.EXPECT_ZAP_REPLY) {
            return 156384763;
        }
        int t = t();
        if (t == 0) {
            this.q = "200".equals(this.h) ? State.SEND_READY : State.SEND_ERROR;
        }
        return t;
    }
}
