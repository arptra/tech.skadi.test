package zmq.socket.scattergather;

import zmq.Ctx;
import zmq.Msg;
import zmq.SocketBase;
import zmq.pipe.Pipe;
import zmq.socket.LB;
import zmq.util.ValueReference;

public class Scatter extends SocketBase {
    public final LB F = new LB();

    public Scatter(Ctx ctx, int i, int i2) {
        super(ctx, i, i2, true);
        this.c.m = 19;
    }

    public void k2(Pipe pipe, boolean z, boolean z2) {
        pipe.y1();
        this.F.b(pipe);
    }

    public boolean m2() {
        return this.F.c();
    }

    public void o2(Pipe pipe) {
        this.F.e(pipe);
    }

    public boolean r2(Msg msg) {
        if (!msg.n()) {
            return this.F.d(msg, this.j, (ValueReference) null);
        }
        this.j.c(22);
        return false;
    }

    public void t2(Pipe pipe) {
        this.F.a(pipe);
    }
}
