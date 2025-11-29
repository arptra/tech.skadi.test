package zmq.socket.pipeline;

import zmq.Ctx;
import zmq.Msg;
import zmq.SocketBase;
import zmq.pipe.Pipe;
import zmq.socket.LB;
import zmq.util.ValueReference;

public class Push extends SocketBase {
    public final LB F = new LB();

    public Push(Ctx ctx, int i, int i2) {
        super(ctx, i, i2);
        this.c.m = 8;
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
        return this.F.d(msg, this.j, (ValueReference) null);
    }

    public void t2(Pipe pipe) {
        this.F.a(pipe);
    }
}
