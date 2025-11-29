package zmq.socket.reqrep;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import zmq.Ctx;
import zmq.Msg;
import zmq.Options;
import zmq.SocketBase;
import zmq.ZMQ;
import zmq.pipe.Pipe;
import zmq.socket.FQ;
import zmq.util.Blob;
import zmq.util.Utils;
import zmq.util.ValueReference;
import zmq.util.Wire;

public class Router extends SocketBase {
    public final FQ F;
    public boolean G = false;
    public boolean H = false;
    public Msg I;
    public Msg J;
    public boolean K = false;
    public final Set L;
    public final Map M;
    public Pipe N = null;
    public boolean O = false;
    public int P = Utils.g();
    public boolean Q = false;
    public boolean R = false;
    public boolean S;
    public boolean T = false;

    public class Outpipe {

        /* renamed from: a  reason: collision with root package name */
        public Pipe f3668a;
        public boolean b;

        public Outpipe(Pipe pipe, boolean z) {
            this.f3668a = pipe;
            this.b = z;
        }
    }

    public Router(Ctx ctx, int i, int i2) {
        super(ctx, i, i2);
        Options options = this.c;
        options.m = 6;
        options.x = true;
        options.y = false;
        options.d0 = true;
        options.f0 = true;
        this.F = new FQ();
        this.I = new Msg();
        this.J = new Msg();
        this.L = new HashSet();
        this.M = new HashMap();
    }

    public void g1() {
        super.g1();
    }

    public void k2(Pipe pipe, boolean z, boolean z2) {
        if (this.S) {
            pipe.C1(new Msg());
            pipe.flush();
        }
        if (u2(pipe, z2)) {
            this.F.b(pipe);
        } else {
            this.L.add(pipe);
        }
    }

    public boolean l2() {
        if (this.K || this.G) {
            return true;
        }
        ValueReference valueReference = new ValueReference();
        this.J = this.F.e(this.j, valueReference);
        while (true) {
            Msg msg = this.J;
            if (msg != null && msg.u()) {
                this.J = this.F.e(this.j, valueReference);
            }
        }
        if (this.J == null) {
            return false;
        }
        Msg msg2 = new Msg(((Pipe) valueReference.a()).k1().d());
        this.I = msg2;
        msg2.J(1);
        this.G = true;
        this.H = false;
        return true;
    }

    public boolean m2() {
        return true;
    }

    public void o2(Pipe pipe) {
        if (!this.L.remove(pipe)) {
            Outpipe outpipe = (Outpipe) this.M.remove(pipe.k1());
            this.F.f(pipe);
            if (pipe == this.N) {
                this.N = null;
            }
        }
    }

    public void p2(Pipe pipe) {
        if (!this.L.contains(pipe)) {
            this.F.a(pipe);
        } else if (u2(pipe, false)) {
            this.L.remove(pipe);
            this.F.b(pipe);
        }
    }

    public Msg q2() {
        Msg msg;
        if (this.G) {
            if (!this.H) {
                msg = this.I;
                this.I = null;
                this.H = true;
            } else {
                msg = this.J;
                this.J = null;
                this.G = false;
            }
            this.K = msg.n();
            return msg;
        }
        ValueReference valueReference = new ValueReference();
        Msg e = this.F.e(this.j, valueReference);
        while (e != null && e.u()) {
            e = this.F.e(this.j, valueReference);
        }
        if (e == null) {
            return null;
        }
        if (this.K) {
            this.K = e.n();
            return e;
        }
        this.J = e;
        this.G = true;
        Msg msg2 = new Msg(((Pipe) valueReference.a()).k1().d());
        msg2.J(1);
        this.H = true;
        return msg2;
    }

    public boolean r2(Msg msg) {
        if (!this.O) {
            if (msg.n()) {
                this.O = true;
                Outpipe outpipe = (Outpipe) this.M.get(Blob.a(msg));
                if (outpipe != null) {
                    Pipe a2 = outpipe.f3668a;
                    this.N = a2;
                    if (!a2.h1()) {
                        boolean unused = outpipe.b = false;
                        this.N = null;
                        if (this.Q) {
                            this.O = false;
                            this.j.c(35);
                            return false;
                        }
                    }
                } else if (this.Q) {
                    this.O = false;
                    this.j.c(65);
                    return false;
                }
            }
            return true;
        }
        if (this.c.y) {
            msg.F(1);
        }
        this.O = msg.n();
        if (this.N != null) {
            if (this.R && msg.O() == 0) {
                this.N.B1(false);
                this.N = null;
                return true;
            } else if (!this.N.C1(msg)) {
                this.N = null;
            } else if (!this.O) {
                this.N.flush();
                this.N = null;
            }
        }
        return true;
    }

    public boolean s2(int i, Object obj) {
        if (i == 61) {
            this.A = Options.g(i, obj);
            return true;
        } else if (i == 41) {
            boolean e = Options.e(i, obj);
            this.R = e;
            if (e) {
                Options options = this.c;
                options.x = false;
                options.y = true;
            }
            return true;
        } else if (i == 33) {
            this.Q = Options.e(i, obj);
            return true;
        } else if (i == 51) {
            this.S = Options.e(i, obj);
            return true;
        } else if (i == 56) {
            this.T = Options.e(i, obj);
            return true;
        } else {
            this.j.c(22);
            return false;
        }
    }

    public void t2(Pipe pipe) {
        for (Outpipe outpipe : this.M.values()) {
            if (outpipe.f3668a == pipe) {
                boolean unused = outpipe.b = true;
                return;
            }
        }
    }

    public final boolean u2(Pipe pipe, boolean z) {
        Blob blob;
        String str = this.A;
        if (str != null && !str.isEmpty() && z) {
            blob = Blob.b(this.A.getBytes(ZMQ.c));
            this.A = null;
            Outpipe outpipe = (Outpipe) this.M.get(blob);
        } else if (this.c.y) {
            ByteBuffer allocate = ByteBuffer.allocate(5);
            allocate.put((byte) 0);
            int i = this.P;
            this.P = i + 1;
            Wire.i(allocate, i);
            blob = Blob.b(allocate.array());
        } else {
            Msg q1 = pipe.q1();
            if (q1 == null) {
                return false;
            }
            if (q1.O() == 0) {
                ByteBuffer allocate2 = ByteBuffer.allocate(5);
                allocate2.put((byte) 0);
                int i2 = this.P;
                this.P = i2 + 1;
                Wire.i(allocate2, i2);
                blob = Blob.b(allocate2.array());
            } else {
                blob = Blob.a(q1);
                if (this.M.containsKey(blob)) {
                    if (!this.T) {
                        return false;
                    }
                    ByteBuffer allocate3 = ByteBuffer.allocate(5);
                    allocate3.put((byte) 0);
                    int i3 = this.P;
                    this.P = i3 + 1;
                    Wire.i(allocate3, i3);
                    Blob b = Blob.b(allocate3.array());
                    Outpipe outpipe2 = (Outpipe) this.M.remove(blob);
                    outpipe2.f3668a.x1(b);
                    this.M.put(b, outpipe2);
                    outpipe2.f3668a.B1(true);
                }
            }
        }
        pipe.x1(blob);
        this.M.put(blob, new Outpipe(pipe, true));
        return true;
    }

    public boolean v2() {
        Pipe pipe = this.N;
        if (pipe == null) {
            return true;
        }
        pipe.r1();
        this.N = null;
        this.O = false;
        return true;
    }
}
