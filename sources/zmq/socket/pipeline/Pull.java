package zmq.socket.pipeline;

import zmq.Ctx;
import zmq.Msg;
import zmq.SocketBase;
import zmq.pipe.Pipe;
import zmq.socket.FQ;

public class Pull extends SocketBase {
    public final FQ F = new FQ();

    public Pull(Ctx ctx, int i, int i2) {
        super(ctx, i, i2);
        this.c.m = 7;
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
        return this.F.d(this.j);
    }
}
