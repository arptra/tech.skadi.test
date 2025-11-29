package zmq.socket.reqrep;

import zmq.Ctx;
import zmq.Msg;
import zmq.Options;

public class Rep extends Router {
    public boolean U = false;
    public boolean V = true;

    public Rep(Ctx ctx, int i, int i2) {
        super(ctx, i, i2);
        Options options = this.c;
        options.m = 4;
        options.d0 = false;
    }

    public boolean l2() {
        return !this.U && super.l2();
    }

    public boolean m2() {
        return this.U && super.m2();
    }

    public Msg q2() {
        if (this.U) {
            this.j.c(156384763);
        }
        if (this.V) {
            while (true) {
                Msg q2 = super.q2();
                if (q2 == null) {
                    return null;
                }
                if (q2.n()) {
                    boolean z = q2.O() == 0;
                    super.r2(q2);
                    if (z) {
                        this.V = false;
                        break;
                    }
                } else {
                    super.v2();
                }
            }
        }
        Msg q22 = super.q2();
        if (q22 == null) {
            return null;
        }
        if (!q22.n()) {
            this.U = true;
            this.V = true;
        }
        return q22;
    }

    public boolean r2(Msg msg) {
        if (!this.U) {
            this.j.c(156384763);
            return false;
        }
        boolean n = msg.n();
        if (!super.r2(msg)) {
            return false;
        }
        if (n) {
            return true;
        }
        this.U = false;
        return true;
    }
}
