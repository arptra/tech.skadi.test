package zmq.io.mechanism.plain;

import zmq.Msg;
import zmq.Options;
import zmq.io.SessionBase;
import zmq.io.mechanism.Mechanism;
import zmq.io.mechanism.Mechanisms;
import zmq.io.net.Address;

public class PlainServerMechanism extends Mechanism {
    public State i = State.WAITING_FOR_HELLO;

    /* renamed from: zmq.io.mechanism.plain.PlainServerMechanism$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f3635a;

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
                zmq.io.mechanism.plain.PlainServerMechanism$State[] r0 = zmq.io.mechanism.plain.PlainServerMechanism.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3635a = r0
                zmq.io.mechanism.plain.PlainServerMechanism$State r1 = zmq.io.mechanism.plain.PlainServerMechanism.State.SENDING_WELCOME     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f3635a     // Catch:{ NoSuchFieldError -> 0x001d }
                zmq.io.mechanism.plain.PlainServerMechanism$State r1 = zmq.io.mechanism.plain.PlainServerMechanism.State.SENDING_READY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f3635a     // Catch:{ NoSuchFieldError -> 0x0028 }
                zmq.io.mechanism.plain.PlainServerMechanism$State r1 = zmq.io.mechanism.plain.PlainServerMechanism.State.SENDING_ERROR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f3635a     // Catch:{ NoSuchFieldError -> 0x0033 }
                zmq.io.mechanism.plain.PlainServerMechanism$State r1 = zmq.io.mechanism.plain.PlainServerMechanism.State.WAITING_FOR_HELLO     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f3635a     // Catch:{ NoSuchFieldError -> 0x003e }
                zmq.io.mechanism.plain.PlainServerMechanism$State r1 = zmq.io.mechanism.plain.PlainServerMechanism.State.WAITING_FOR_INITIATE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: zmq.io.mechanism.plain.PlainServerMechanism.AnonymousClass1.<clinit>():void");
        }
    }

    public enum State {
        WAITING_FOR_HELLO,
        SENDING_WELCOME,
        WAITING_FOR_INITIATE,
        SENDING_READY,
        WAITING_FOR_ZAP_REPLY,
        SENDING_ERROR,
        ERROR_COMMAND_SENT,
        READY
    }

    public PlainServerMechanism(SessionBase sessionBase, Address address, Options options) {
        super(sessionBase, address, options);
    }

    private int A(Msg msg) {
        msg.E("ERROR");
        msg.E(this.h);
        return 0;
    }

    private int B(Msg msg) {
        int e;
        int i2;
        int O = msg.O();
        if (O < 6 || !g(msg, "HELLO", true) || O - 6 < 1 || O - 7 < (e = msg.e(6))) {
            return 156384820;
        }
        byte[] bArr = new byte[e];
        msg.f(7, bArr, 0, e);
        int e2 = msg.e(7 + e);
        int i3 = (i2 - e) - 1;
        if (i3 < e2) {
            return 156384820;
        }
        byte[] bArr2 = new byte[e2];
        msg.f(e + 8, bArr2, 0, e2);
        if (i3 - e2 > 0) {
            return 156384820;
        }
        if (this.f.B1() == 0) {
            F(bArr, bArr2);
            int t = t();
            if (t == 0) {
                this.i = "200".equals(this.h) ? State.SENDING_WELCOME : State.SENDING_ERROR;
            } else if (t != 35) {
                return -1;
            } else {
                this.i = State.WAITING_FOR_ZAP_REPLY;
            }
        } else {
            this.i = State.SENDING_WELCOME;
        }
        return 0;
    }

    private int C(Msg msg) {
        if (msg.O() < 9 || !g(msg, "INITIATE", true)) {
            return 156384820;
        }
        int p = p(msg, 9, false);
        if (p == 0) {
            this.i = State.SENDING_READY;
        }
        return p;
    }

    private int D(Msg msg) {
        msg.E("READY");
        d(msg, "Socket-Type", x());
        Options options = this.f3630a;
        int i2 = options.m;
        if (i2 != 3 && i2 != 5 && i2 != 6) {
            return 0;
        }
        e(msg, "Identity", options.e);
        return 0;
    }

    private int E(Msg msg) {
        msg.E("WELCOME");
        return 0;
    }

    public final void F(byte[] bArr, byte[] bArr2) {
        u(Mechanisms.PLAIN, true);
        Msg msg = new Msg(bArr.length);
        msg.J(1);
        msg.C(bArr);
        this.f.A1(msg);
        Msg msg2 = new Msg(bArr2.length);
        msg2.C(bArr2);
        this.f.A1(msg2);
    }

    public int m(Msg msg) {
        int E;
        int i2 = AnonymousClass1.f3635a[this.i.ordinal()];
        if (i2 == 1) {
            E = E(msg);
            if (E == 0) {
                this.i = State.WAITING_FOR_INITIATE;
            }
        } else if (i2 == 2) {
            E = D(msg);
            if (E == 0) {
                this.i = State.READY;
            }
        } else if (i2 != 3) {
            return 35;
        } else {
            E = A(msg);
            if (E == 0) {
                this.i = State.ERROR_COMMAND_SENT;
            }
        }
        return E;
    }

    public int r(Msg msg) {
        int i2 = AnonymousClass1.f3635a[this.i.ordinal()];
        if (i2 == 4) {
            return B(msg);
        }
        if (i2 != 5) {
            return 156384820;
        }
        return C(msg);
    }

    public Mechanism.Status y() {
        State state = this.i;
        return state == State.READY ? Mechanism.Status.READY : state == State.ERROR_COMMAND_SENT ? Mechanism.Status.ERROR : Mechanism.Status.HANDSHAKING;
    }

    public int z() {
        if (this.i != State.WAITING_FOR_ZAP_REPLY) {
            return 156384763;
        }
        int t = t();
        if (t == 0) {
            this.i = "200".equals(this.h) ? State.SENDING_WELCOME : State.SENDING_ERROR;
        }
        return t;
    }
}
