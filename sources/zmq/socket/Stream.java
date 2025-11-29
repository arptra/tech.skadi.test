package zmq.socket;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import zmq.Ctx;
import zmq.Msg;
import zmq.Options;
import zmq.SocketBase;
import zmq.ZMQ;
import zmq.io.Metadata;
import zmq.pipe.Pipe;
import zmq.util.Blob;
import zmq.util.Utils;
import zmq.util.ValueReference;
import zmq.util.Wire;

public class Stream extends SocketBase {
    public final FQ F;
    public boolean G = false;
    public boolean H = false;
    public Msg I;
    public Msg J;
    public Map K = new HashMap();
    public Pipe L = null;
    public boolean M = false;
    public int N = Utils.g();

    public class Outpipe {

        /* renamed from: a  reason: collision with root package name */
        public Pipe f3659a;
        public boolean b;

        public Outpipe(Pipe pipe, boolean z) {
            this.f3659a = pipe;
            this.b = z;
        }
    }

    public Stream(Ctx ctx, int i, int i2) {
        super(ctx, i, i2);
        Options options = this.c;
        options.m = 11;
        options.y = true;
        this.F = new FQ();
        this.I = new Msg();
        this.J = new Msg();
    }

    public void k2(Pipe pipe, boolean z, boolean z2) {
        u2(pipe, z2);
        this.F.b(pipe);
    }

    public boolean l2() {
        if (this.G) {
            return true;
        }
        ValueReference valueReference = new ValueReference();
        Msg e = this.F.e(this.j, valueReference);
        this.J = e;
        if (e == null) {
            return false;
        }
        this.I = new Msg(((Pipe) valueReference.a()).k1().d());
        Metadata j = this.J.j();
        if (j != null) {
            this.I.L(j);
        }
        this.I.J(1);
        this.G = true;
        this.H = false;
        return true;
    }

    public boolean m2() {
        return true;
    }

    public void o2(Pipe pipe) {
        Outpipe outpipe = (Outpipe) this.K.remove(pipe.k1());
        this.F.f(pipe);
        if (pipe == this.L) {
            this.L = null;
        }
    }

    public void p2(Pipe pipe) {
        this.F.a(pipe);
    }

    public Msg q2() {
        if (!this.G) {
            ValueReference valueReference = new ValueReference();
            Msg e = this.F.e(this.j, valueReference);
            this.J = e;
            if (e == null) {
                this.j.c(35);
                return null;
            }
            Msg msg = new Msg(((Pipe) valueReference.a()).k1().d());
            Metadata j = this.J.j();
            if (j != null) {
                msg.L(j);
            }
            msg.J(1);
            this.G = true;
            this.H = true;
            return msg;
        } else if (!this.H) {
            Msg msg2 = this.I;
            this.I = null;
            this.H = true;
            return msg2;
        } else {
            Msg msg3 = this.J;
            this.J = null;
            this.G = false;
            return msg3;
        }
    }

    public boolean r2(Msg msg) {
        if (!this.M) {
            if (msg.n()) {
                this.M = true;
                Outpipe outpipe = (Outpipe) this.K.get(Blob.a(msg));
                if (outpipe != null) {
                    Pipe a2 = outpipe.f3659a;
                    this.L = a2;
                    if (!a2.h1()) {
                        boolean unused = outpipe.b = false;
                        this.L = null;
                        this.j.c(35);
                        return false;
                    }
                } else {
                    this.j.c(65);
                    return false;
                }
            }
            this.M = true;
            return true;
        }
        msg.F(1);
        this.M = false;
        if (this.L != null) {
            if (msg.O() == 0) {
                this.L.B1(false);
                this.L = null;
                return true;
            }
            if (this.L.C1(msg)) {
                this.L.flush();
            }
            this.L = null;
        }
        return true;
    }

    public boolean s2(int i, Object obj) {
        if (i != 61) {
            this.j.c(22);
            return false;
        }
        this.A = (String) obj;
        return true;
    }

    public void t2(Pipe pipe) {
        Outpipe outpipe;
        Iterator it = this.K.values().iterator();
        while (true) {
            if (!it.hasNext()) {
                outpipe = null;
                break;
            }
            outpipe = (Outpipe) it.next();
            if (outpipe.f3659a == pipe) {
                break;
            }
        }
        boolean unused = outpipe.b = true;
    }

    public final void u2(Pipe pipe, boolean z) {
        Blob blob;
        String str = this.A;
        if (str == null || str.isEmpty() || !z) {
            ByteBuffer allocate = ByteBuffer.allocate(5);
            allocate.put((byte) 0);
            int i = this.N;
            this.N = i + 1;
            Wire.i(allocate, i);
            blob = Blob.b(allocate.array());
        } else {
            blob = Blob.b(this.A.getBytes(ZMQ.c));
            this.A = null;
            Outpipe outpipe = (Outpipe) this.K.get(blob);
        }
        pipe.x1(blob);
        this.K.put(blob, new Outpipe(pipe, true));
    }
}
