package zmq.io.mechanism;

import zmq.Msg;
import zmq.Options;
import zmq.io.SessionBase;
import zmq.io.mechanism.Mechanism;
import zmq.io.net.Address;

class NullMechanism extends Mechanism {
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;

    public NullMechanism(SessionBase sessionBase, Address address, Options options) {
        super(sessionBase, address, options);
        String str = options.I;
        if (str != null && str.length() > 0 && sessionBase.B1() == 0) {
            this.m = true;
        }
    }

    public final int A(Msg msg) {
        this.l = true;
        return n(msg);
    }

    public final int B(Msg msg) {
        this.k = true;
        return p(msg, 6, false);
    }

    public int m(Msg msg) {
        if (this.i || this.j) {
            return 35;
        }
        if (this.m && !this.o) {
            if (this.n) {
                return 35;
            }
            u(Mechanisms.NULL, false);
            this.n = true;
            int t = t();
            if (t != 0) {
                return t;
            }
            this.o = true;
        }
        if (!this.o || "200".equals(this.h)) {
            msg.E("READY");
            d(msg, "Socket-Type", x());
            Options options = this.f3630a;
            int i2 = options.m;
            if (i2 == 3 || i2 == 5 || i2 == 6) {
                e(msg, "Identity", options.e);
            }
            this.i = true;
            return 0;
        }
        msg.E("ERROR");
        msg.E(this.h);
        this.j = true;
        return 0;
    }

    public int r(Msg msg) {
        if (this.k || this.l) {
            this.f.t1().K1(this.f.s1(), 268435457);
            return 156384820;
        }
        int O = msg.O();
        if (O >= 6 && g(msg, "READY", true)) {
            return B(msg);
        }
        if (O >= 6 && g(msg, "ERROR", true)) {
            return A(msg);
        }
        this.f.t1().K1(this.f.s1(), 268435457);
        return 156384820;
    }

    public Mechanism.Status y() {
        boolean z = this.i;
        boolean z2 = true;
        boolean z3 = z || this.j;
        boolean z4 = this.k;
        if (!z4 && !this.l) {
            z2 = false;
        }
        return (!z || !z4) ? (!z3 || !z2) ? Mechanism.Status.HANDSHAKING : Mechanism.Status.ERROR : Mechanism.Status.READY;
    }

    public int z() {
        if (this.o) {
            return 156384763;
        }
        int t = t();
        if (t == 0) {
            this.o = true;
        }
        return t;
    }
}
