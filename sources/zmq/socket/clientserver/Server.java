package zmq.socket.clientserver;

import java.util.HashMap;
import java.util.Map;
import zmq.Ctx;
import zmq.Msg;
import zmq.Options;
import zmq.SocketBase;
import zmq.pipe.Pipe;
import zmq.socket.FQ;
import zmq.util.Utils;
import zmq.util.ValueReference;

public class Server extends SocketBase {
    public final FQ F;
    public final Map G;
    public int H = Utils.g();

    public class Outpipe {

        /* renamed from: a  reason: collision with root package name */
        public Pipe f3660a;
        public boolean b;

        public Outpipe(Pipe pipe, boolean z) {
            this.f3660a = pipe;
            this.b = z;
        }
    }

    public Server(Ctx ctx, int i, int i2) {
        super(ctx, i, i2, true);
        Options options = this.c;
        options.m = 12;
        options.d0 = true;
        options.f0 = true;
        this.F = new FQ();
        this.G = new HashMap();
    }

    public void g1() {
        super.g1();
    }

    public void k2(Pipe pipe, boolean z, boolean z2) {
        int i = this.H;
        int i2 = i + 1;
        this.H = i2;
        if (i == 0) {
            this.H = i + 2;
            i = i2;
        }
        pipe.A1(i);
        Outpipe outpipe = (Outpipe) this.G.put(Integer.valueOf(i), new Outpipe(pipe, true));
        this.F.b(pipe);
    }

    public boolean l2() {
        return this.F.c();
    }

    public boolean m2() {
        return true;
    }

    public void o2(Pipe pipe) {
        Outpipe outpipe = (Outpipe) this.G.remove(Integer.valueOf(pipe.l1()));
        this.F.f(pipe);
    }

    public void p2(Pipe pipe) {
        this.F.a(pipe);
    }

    public Msg q2() {
        ValueReference valueReference = new ValueReference();
        Msg e = this.F.e(this.j, valueReference);
        while (e != null && e.n()) {
            e = this.F.e(this.j, (ValueReference) null);
            while (e != null && e.n()) {
                e = this.F.e(this.j, (ValueReference) null);
            }
            if (e != null) {
                e = this.F.e(this.j, valueReference);
            }
        }
        if (e == null) {
            return e;
        }
        e.M(((Pipe) valueReference.a()).l1());
        return e;
    }

    public boolean r2(Msg msg) {
        if (msg.n()) {
            this.j.c(22);
            return false;
        }
        Outpipe outpipe = (Outpipe) this.G.get(Integer.valueOf(msg.k()));
        if (outpipe == null) {
            this.j.c(65);
            return false;
        } else if (!outpipe.f3660a.h1()) {
            boolean unused = outpipe.b = false;
            this.j.c(35);
            return false;
        } else {
            msg.H();
            if (!outpipe.f3660a.C1(msg)) {
                return true;
            }
            outpipe.f3660a.flush();
            return true;
        }
    }

    public void t2(Pipe pipe) {
        boolean unused = ((Outpipe) this.G.get(Integer.valueOf(pipe.l1()))).b = true;
    }
}
