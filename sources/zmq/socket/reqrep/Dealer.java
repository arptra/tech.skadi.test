package zmq.socket.reqrep;

import zmq.Ctx;
import zmq.Msg;
import zmq.Options;
import zmq.SocketBase;
import zmq.pipe.Pipe;
import zmq.socket.FQ;
import zmq.socket.LB;
import zmq.util.ValueReference;

public class Dealer extends SocketBase {
    public final FQ F = new FQ();
    public final LB G = new LB();
    public boolean H;

    public Dealer(Ctx ctx, int i, int i2) {
        super(ctx, i, i2);
        Options options = this.c;
        options.m = 5;
        options.d0 = true;
        options.h0 = true;
    }

    public void k2(Pipe pipe, boolean z, boolean z2) {
        if (this.H) {
            pipe.C1(new Msg());
            pipe.flush();
        }
        this.F.b(pipe);
        this.G.b(pipe);
    }

    public boolean l2() {
        return this.F.c();
    }

    public boolean m2() {
        return this.G.c();
    }

    public void o2(Pipe pipe) {
        this.F.f(pipe);
        this.G.e(pipe);
    }

    public void p2(Pipe pipe) {
        this.F.a(pipe);
    }

    public Msg q2() {
        return u2((ValueReference) null);
    }

    public boolean r2(Msg msg) {
        return v2(msg, (ValueReference) null);
    }

    public boolean s2(int i, Object obj) {
        if (i == 51) {
            this.H = Options.e(i, obj);
            return true;
        }
        this.j.c(22);
        return false;
    }

    public void t2(Pipe pipe) {
        this.G.a(pipe);
    }

    public final Msg u2(ValueReference valueReference) {
        return this.F.e(this.j, valueReference);
    }

    public final boolean v2(Msg msg, ValueReference valueReference) {
        return this.G.d(msg, this.j, valueReference);
    }
}
