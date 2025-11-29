package zmq.socket.clientserver;

import zmq.Ctx;
import zmq.Msg;
import zmq.Options;
import zmq.SocketBase;
import zmq.pipe.Pipe;
import zmq.socket.FQ;
import zmq.socket.LB;
import zmq.util.ValueReference;

public class Client extends SocketBase {
    public final FQ F = new FQ();
    public final LB G = new LB();

    public Client(Ctx ctx, int i, int i2) {
        super(ctx, i, i2, true);
        Options options = this.c;
        options.m = 13;
        options.d0 = true;
        options.h0 = true;
    }

    public void k2(Pipe pipe, boolean z, boolean z2) {
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
        Msg e = this.F.e(this.j, (ValueReference) null);
        while (e != null && e.n()) {
            e = this.F.e(this.j, (ValueReference) null);
            while (e != null && e.n()) {
                this.F.e(this.j, (ValueReference) null);
            }
            if (e != null) {
                this.F.e(this.j, (ValueReference) null);
            }
        }
        return e;
    }

    public boolean r2(Msg msg) {
        if (!msg.n()) {
            return this.G.d(msg, this.j, (ValueReference) null);
        }
        this.j.c(22);
        return false;
    }

    public void t2(Pipe pipe) {
        this.G.a(pipe);
    }
}
