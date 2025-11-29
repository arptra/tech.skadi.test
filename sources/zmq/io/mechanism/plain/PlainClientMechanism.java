package zmq.io.mechanism.plain;

import zmq.Msg;
import zmq.Options;
import zmq.io.SessionBase;
import zmq.io.mechanism.Mechanism;
import zmq.io.net.Address;

public class PlainClientMechanism extends Mechanism {
    public State i = State.SENDING_HELLO;

    /* renamed from: zmq.io.mechanism.plain.PlainClientMechanism$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f3634a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                zmq.io.mechanism.plain.PlainClientMechanism$State[] r0 = zmq.io.mechanism.plain.PlainClientMechanism.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3634a = r0
                zmq.io.mechanism.plain.PlainClientMechanism$State r1 = zmq.io.mechanism.plain.PlainClientMechanism.State.SENDING_HELLO     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f3634a     // Catch:{ NoSuchFieldError -> 0x001d }
                zmq.io.mechanism.plain.PlainClientMechanism$State r1 = zmq.io.mechanism.plain.PlainClientMechanism.State.SENDING_INITIATE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: zmq.io.mechanism.plain.PlainClientMechanism.AnonymousClass1.<clinit>():void");
        }
    }

    public enum State {
        SENDING_HELLO,
        WAITING_FOR_WELCOME,
        SENDING_INITIATE,
        WAITING_FOR_READY,
        ERROR_COMMAND_RECEIVED,
        READY
    }

    public PlainClientMechanism(SessionBase sessionBase, Options options) {
        super(sessionBase, (Address) null, options);
    }

    private int A(Msg msg) {
        State state = this.i;
        if (state == State.WAITING_FOR_WELCOME || state == State.WAITING_FOR_READY) {
            this.i = State.ERROR_COMMAND_RECEIVED;
            return n(msg);
        }
        this.f.t1().K1(this.f.s1(), 268435457);
        return 156384820;
    }

    private int B(Msg msg) {
        if (this.i != State.WAITING_FOR_READY) {
            return 156384820;
        }
        int p = p(msg, 6, false);
        if (p == 0) {
            this.i = State.READY;
        }
        return p;
    }

    private int C(Msg msg) {
        if (this.i != State.WAITING_FOR_WELCOME || msg.O() != 8) {
            return 156384820;
        }
        this.i = State.SENDING_INITIATE;
        return 0;
    }

    private int D(Msg msg) {
        Options options = this.f3630a;
        String str = options.J;
        String str2 = options.K;
        msg.E("HELLO");
        msg.E(str);
        msg.E(str2);
        return 0;
    }

    private int E(Msg msg) {
        msg.E("INITIATE");
        d(msg, "Socket-Type", x());
        Options options = this.f3630a;
        int i2 = options.m;
        if (i2 != 3 && i2 != 5 && i2 != 6) {
            return 0;
        }
        e(msg, "Identity", options.e);
        return 0;
    }

    public int m(Msg msg) {
        int D;
        int i2 = AnonymousClass1.f3634a[this.i.ordinal()];
        if (i2 == 1) {
            D = D(msg);
            if (D == 0) {
                this.i = State.WAITING_FOR_WELCOME;
            }
        } else if (i2 != 2) {
            return 35;
        } else {
            D = E(msg);
            if (D == 0) {
                this.i = State.WAITING_FOR_READY;
            }
        }
        return D;
    }

    public int r(Msg msg) {
        int O = msg.O();
        if (O >= 8 && g(msg, "WELCOME", true)) {
            return C(msg);
        }
        if (O >= 6 && g(msg, "READY", true)) {
            return B(msg);
        }
        if (O >= 6 && g(msg, "ERROR", true)) {
            return A(msg);
        }
        System.out.println("PLAIN Client I: invalid handshake command");
        return 156384820;
    }

    public Mechanism.Status y() {
        State state = this.i;
        return state == State.READY ? Mechanism.Status.READY : state == State.ERROR_COMMAND_RECEIVED ? Mechanism.Status.ERROR : Mechanism.Status.HANDSHAKING;
    }

    public int z() {
        return 0;
    }
}
