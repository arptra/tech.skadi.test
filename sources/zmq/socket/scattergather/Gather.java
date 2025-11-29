package zmq.socket.scattergather;

import zmq.Ctx;
import zmq.Msg;
import zmq.SocketBase;
import zmq.pipe.Pipe;
import zmq.socket.FQ;
import zmq.util.ValueReference;

public class Gather extends SocketBase {
    public final FQ F = new FQ();

    public Gather(Ctx ctx, int i, int i2) {
        super(ctx, i, i2, true);
        this.c.m = 20;
    }

    public void k2(Pipe pipe, boolean z, boolean z2) {
        this.F.b(pipe);
    }

    public boolean l2() {
        return this.F.c();
    }

    public void o2(Pipe pipe) {
        this.F.f(pipe);
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
}
