package zmq.pipe;

import zmq.Config;
import zmq.Msg;
import zmq.ZObject;
import zmq.util.Blob;

public class Pipe extends ZObject {
    public YPipeBase c;
    public YPipeBase d;
    public boolean e = true;
    public boolean f = true;
    public int g;
    public int h;
    public long i;
    public long j;
    public long k;
    public Pipe l;
    public IPipeEvents m;
    public State n;
    public boolean o;
    public Blob p;
    public int q;
    public Blob r;
    public final boolean s;
    public Msg t;
    public final ZObject u;

    public interface IPipeEvents {
        void b(Pipe pipe);

        void i(Pipe pipe);

        void j(Pipe pipe);

        void n(Pipe pipe);
    }

    public enum State {
        ACTIVE,
        DELIMITER_RECEIVED,
        WAITING_FOR_DELIMITER,
        TERM_ACK_SENT,
        TERM_REQ_SENT_1,
        TERM_REQ_SENT_2
    }

    public Pipe(ZObject zObject, YPipeBase yPipeBase, YPipeBase yPipeBase2, int i2, int i3, boolean z) {
        super(zObject);
        this.c = yPipeBase;
        this.d = yPipeBase2;
        this.g = i3;
        this.h = i1(i2);
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = null;
        this.m = null;
        this.n = State.ACTIVE;
        this.o = true;
        this.s = z;
        this.t = null;
        this.u = zObject;
    }

    public static int i1(int i2) {
        return (i2 + 1) / 2;
    }

    public static boolean n1(Msg msg) {
        return msg.t();
    }

    public static Pipe[] o1(ZObject[] zObjectArr, int[] iArr, boolean[] zArr) {
        YPipeBase yPipeConflate = zArr[0] ? new YPipeConflate() : new YPipe(Config.MESSAGE_PIPE_GRANULARITY.getValue());
        YPipeBase yPipeConflate2 = zArr[1] ? new YPipeConflate() : new YPipe(Config.MESSAGE_PIPE_GRANULARITY.getValue());
        Pipe[] pipeArr = {new Pipe(zObjectArr[0], yPipeConflate, yPipeConflate2, iArr[1], iArr[0], zArr[0]), new Pipe(zObjectArr[1], yPipeConflate2, yPipeConflate, iArr[0], iArr[1], zArr[1])};
        pipeArr[0].z1(pipeArr[1]);
        pipeArr[1].z1(pipeArr[0]);
        return pipeArr;
    }

    public void A1(int i2) {
        this.q = i2;
    }

    public void B1(boolean z) {
        State state;
        this.o = z;
        State state2 = this.n;
        State state3 = State.TERM_REQ_SENT_1;
        if (state2 != state3 && state2 != State.TERM_REQ_SENT_2 && state2 != (state = State.TERM_ACK_SENT)) {
            if (state2 == State.ACTIVE) {
                S0(this.l);
                this.n = state3;
            } else {
                State state4 = State.WAITING_FOR_DELIMITER;
                if (state2 == state4 && !z) {
                    this.d = null;
                    T0(this.l);
                    this.n = state;
                } else if (state2 != state4 && state2 == State.DELIMITER_RECEIVED) {
                    S0(this.l);
                    this.n = state3;
                }
            }
            this.f = false;
            if (this.d != null) {
                r1();
                Msg msg = new Msg();
                msg.o();
                this.d.a(msg, false);
                flush();
            }
        }
    }

    public boolean C1(Msg msg) {
        if (!h1()) {
            return false;
        }
        boolean n2 = msg.n();
        boolean u2 = msg.u();
        this.d.a(msg, n2);
        if (n2 || u2) {
            return true;
        }
        this.j++;
        return true;
    }

    public void N() {
        if (!this.e) {
            State state = this.n;
            if (state == State.ACTIVE || state == State.WAITING_FOR_DELIMITER) {
                this.e = true;
                this.m.j(this);
            }
        }
    }

    public void S(long j2) {
        this.k = j2;
        if (!this.f && this.n == State.ACTIVE) {
            this.f = true;
            this.m.b(this);
        }
    }

    public void f0(YPipeBase yPipeBase) {
        this.d.flush();
        while (true) {
            Msg msg = (Msg) this.d.read();
            if (msg == null) {
                break;
            } else if (!msg.n()) {
                this.j--;
            }
        }
        this.d = yPipeBase;
        this.f = true;
        if (this.n == State.ACTIVE) {
            this.m.n(this);
        }
    }

    public boolean f1() {
        int i2 = this.g;
        return !(i2 > 0 && this.j - this.k >= ((long) i2));
    }

    public void flush() {
        YPipeBase yPipeBase;
        if (this.n != State.TERM_ACK_SENT && (yPipeBase = this.d) != null && !yPipeBase.flush()) {
            H0(this.l);
        }
    }

    public boolean g1() {
        if (!this.e) {
            return false;
        }
        State state = this.n;
        if (state != State.ACTIVE && state != State.WAITING_FOR_DELIMITER) {
            return false;
        }
        if (!this.c.c()) {
            this.e = false;
            return false;
        } else if (!n1((Msg) this.c.b())) {
            return true;
        } else {
            Msg msg = (Msg) this.c.read();
            p1();
            return false;
        }
    }

    public boolean h1() {
        if (!this.f || this.n != State.ACTIVE) {
            return false;
        }
        if (!(!f1())) {
            return true;
        }
        this.f = false;
        return false;
    }

    public Blob j1() {
        return this.r;
    }

    public Blob k1() {
        return this.p;
    }

    public int l1() {
        return this.q;
    }

    public void m1() {
        if (this.n == State.ACTIVE) {
            this.c = null;
            if (this.s) {
                this.c = new YPipeConflate();
            } else {
                this.c = new YPipe(Config.MESSAGE_PIPE_GRANULARITY.getValue());
            }
            this.e = true;
            P0(this.l, this.c);
        }
    }

    public void p0() {
        State state = this.n;
        if (state == State.ACTIVE) {
            if (this.o) {
                this.n = State.WAITING_FOR_DELIMITER;
                return;
            }
            this.n = State.TERM_ACK_SENT;
            this.d = null;
            T0(this.l);
        } else if (state == State.DELIMITER_RECEIVED) {
            this.n = State.TERM_ACK_SENT;
            this.d = null;
            T0(this.l);
        } else if (state == State.TERM_REQ_SENT_1) {
            this.n = State.TERM_REQ_SENT_2;
            this.d = null;
            T0(this.l);
        }
    }

    public final void p1() {
        if (this.n == State.ACTIVE) {
            this.n = State.DELIMITER_RECEIVED;
            return;
        }
        this.d = null;
        T0(this.l);
        this.n = State.TERM_ACK_SENT;
    }

    public void q0() {
        this.m.i(this);
        if (this.n == State.TERM_REQ_SENT_1) {
            this.d = null;
            T0(this.l);
        }
        if (this.c != null) {
            if (!this.s) {
                do {
                } while (this.c.read() != null);
            }
            this.c = null;
        }
    }

    public Msg q1() {
        if (!this.e) {
            return null;
        }
        State state = this.n;
        if (state != State.ACTIVE && state != State.WAITING_FOR_DELIMITER) {
            return null;
        }
        while (true) {
            Msg msg = (Msg) this.c.read();
            if (msg == null) {
                this.e = false;
                return null;
            } else if (msg.s()) {
                this.r = Blob.a(msg);
            } else if (msg.t()) {
                p1();
                return null;
            } else {
                if (!msg.n() && !msg.u()) {
                    this.i++;
                }
                int i2 = this.h;
                if (i2 > 0) {
                    long j2 = this.i;
                    if (j2 % ((long) i2) == 0) {
                        I0(this.l, j2);
                    }
                }
                return msg;
            }
        }
    }

    public void r1() {
        if (this.d != null) {
            do {
            } while (((Msg) this.d.d()) != null);
        }
    }

    public void s1() {
        if (this.t != null && this.d != null) {
            r1();
            this.d.a(this.t, false);
            flush();
            this.t = null;
        }
    }

    public void t1(Msg msg) {
        if (msg != null && this.d != null) {
            r1();
            this.d.a(msg, false);
            flush();
        }
    }

    public String toString() {
        return super.toString() + "(" + this.u.getClass().getSimpleName() + "[" + this.u.z() + "]->" + this.l.u.getClass().getSimpleName() + "[" + this.l.u.z() + "])";
    }

    public void u1(Msg msg) {
        this.t = msg;
    }

    public void v1(IPipeEvents iPipeEvents) {
        this.m = iPipeEvents;
    }

    public void w1(int i2, int i3) {
        this.h = i1(i2);
        this.g = i3;
    }

    public void x1(Blob blob) {
        this.p = blob;
    }

    public void y1() {
        this.o = false;
    }

    public final void z1(Pipe pipe) {
        this.l = pipe;
    }
}
