package zmq.socket;

import zmq.Ctx;
import zmq.Msg;
import zmq.SocketBase;
import zmq.pipe.Pipe;
import zmq.util.Blob;

public class Channel extends SocketBase {
    public Pipe F;
    public Pipe G;
    public Blob H;

    public Channel(Ctx ctx, int i, int i2) {
        super(ctx, i, i2, true);
        this.c.m = 16;
    }

    public void g1() {
        super.g1();
    }

    public void k2(Pipe pipe, boolean z, boolean z2) {
        if (this.F == null) {
            this.F = pipe;
        } else {
            pipe.B1(false);
        }
    }

    public boolean l2() {
        Pipe pipe = this.F;
        return pipe != null && pipe.g1();
    }

    public boolean m2() {
        Pipe pipe = this.F;
        return pipe != null && pipe.h1();
    }

    public void o2(Pipe pipe) {
        if (this.F == pipe) {
            Pipe pipe2 = this.G;
            if (pipe2 == pipe) {
                this.H = pipe2.j1();
                this.G = null;
            }
            this.F = null;
        }
    }

    public void p2(Pipe pipe) {
    }

    public Msg q2() {
        Pipe pipe = this.F;
        if (pipe == null) {
            this.j.c(35);
            return null;
        }
        Msg q1 = pipe.q1();
        while (q1 != null && q1.n()) {
            q1 = this.F.q1();
            while (q1 != null && q1.n()) {
                q1 = this.F.q1();
            }
            if (q1 != null) {
                q1 = this.F.q1();
            }
        }
        if (q1 == null) {
            this.j.c(35);
            return null;
        }
        this.G = this.F;
        return q1;
    }

    public boolean r2(Msg msg) {
        if (msg.n()) {
            this.j.c(22);
            return false;
        }
        Pipe pipe = this.F;
        if (pipe == null || !pipe.C1(msg)) {
            this.j.c(35);
            return false;
        }
        this.F.flush();
        return true;
    }

    public void t2(Pipe pipe) {
    }
}
