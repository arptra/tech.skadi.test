package zmq.socket.pubsub;

import com.honey.account.zc.a;
import java.util.ArrayDeque;
import java.util.Deque;
import zmq.Ctx;
import zmq.Msg;
import zmq.Options;
import zmq.SocketBase;
import zmq.pipe.Pipe;
import zmq.socket.pubsub.Mtrie;
import zmq.util.Blob;

public class XPub extends SocketBase {
    public static final Mtrie.IMtrieHandler R = new MarkAsMatching();
    public static final Mtrie.IMtrieHandler S = new SendUnsubscription();
    public final Mtrie F = new Mtrie();
    public final Mtrie G = new Mtrie();
    public final Dist H = new Dist();
    public boolean I = false;
    public boolean J = false;
    public boolean K = false;
    public boolean L = true;
    public boolean M = false;
    public Pipe N = null;
    public final Deque O = new ArrayDeque();
    public final Deque P = new ArrayDeque();
    public final Deque Q = new ArrayDeque();

    public static final class MarkAsMatching implements Mtrie.IMtrieHandler {
        public MarkAsMatching() {
        }

        public void a(Pipe pipe, byte[] bArr, int i, XPub xPub) {
            xPub.y2(pipe);
        }
    }

    public static final class SendUnsubscription implements Mtrie.IMtrieHandler {
        public SendUnsubscription() {
        }

        public void a(Pipe pipe, byte[] bArr, int i, XPub xPub) {
            xPub.z2(bArr, i);
        }
    }

    public XPub(Ctx ctx, int i, int i2) {
        super(ctx, i, i2);
        this.c.m = 9;
    }

    public static /* synthetic */ void x2(Pipe pipe, byte[] bArr, int i, XPub xPub) {
    }

    public void k2(Pipe pipe, boolean z, boolean z2) {
        this.H.b(pipe);
        if (z) {
            this.F.c(pipe);
        }
        p2(pipe);
    }

    public boolean l2() {
        return !this.P.isEmpty();
    }

    public boolean m2() {
        return this.H.e();
    }

    public void o2(Pipe pipe) {
        if (this.M) {
            this.G.h(pipe, S, this);
            this.F.h(pipe, new a(), this);
        } else {
            this.F.h(pipe, S, this);
        }
        this.H.i(pipe);
    }

    public void p2(Pipe pipe) {
        while (true) {
            Msg q1 = pipe.q1();
            if (q1 != null) {
                if (q1.O() > 0) {
                    boolean z = true;
                    if (q1.e(0) == 0 || q1.e(0) == 1) {
                        boolean z2 = q1.e(0) == 1;
                        if (this.M) {
                            if (!z2) {
                                this.G.g(q1, pipe);
                            } else {
                                this.G.a(q1, pipe);
                            }
                            this.O.add(pipe);
                            this.P.add(Blob.a(q1));
                            this.Q.add(0);
                        } else {
                            if (z2 ? !(this.F.a(q1, pipe) || this.I) : !(this.F.g(q1, pipe) || this.J)) {
                                z = false;
                            }
                            if (this.c.m == 9 && z) {
                                this.P.add(Blob.a(q1));
                                this.Q.add(0);
                            }
                        }
                    }
                }
                this.P.add(Blob.a(q1));
                this.Q.add(Integer.valueOf(q1.d()));
            } else {
                return;
            }
        }
    }

    public Msg q2() {
        if (this.P.isEmpty()) {
            this.j.c(35);
            return null;
        }
        if (this.M && !this.O.isEmpty()) {
            this.N = (Pipe) this.O.pollFirst();
        }
        Msg msg = new Msg(((Blob) this.P.pollFirst()).d());
        msg.J(((Integer) this.Q.pollFirst()).intValue());
        return msg;
    }

    public boolean r2(Msg msg) {
        boolean n = msg.n();
        if (!this.K) {
            this.F.e(msg.a(), msg.O(), R, this);
        }
        if (!this.L && !this.H.c()) {
            this.j.c(35);
            return false;
        } else if (!this.H.h(msg)) {
            return false;
        } else {
            if (!n) {
                this.H.j();
            }
            this.K = n;
            return true;
        }
    }

    public boolean s2(int i, Object obj) {
        if (i == 40 || i == 78 || i == 69 || i == 71) {
            if (i == 40) {
                this.I = Options.e(i, obj);
                this.J = false;
            } else if (i == 78) {
                boolean e = Options.e(i, obj);
                this.I = e;
                this.J = e;
            } else if (i == 69) {
                this.L = !Options.e(i, obj);
            } else if (i == 71) {
                this.M = Options.e(i, obj);
            }
        } else if (i != 6 || !this.M) {
            if (i != 7 || !this.M) {
                this.j.c(22);
                return false;
            } else if (this.N != null) {
                this.F.g(new Msg(Options.g(i, obj).getBytes()), this.N);
            }
        } else if (this.N != null) {
            this.F.a(new Msg(Options.g(i, obj).getBytes()), this.N);
        }
        return true;
    }

    public void t2(Pipe pipe) {
        this.H.a(pipe);
    }

    public final void y2(Pipe pipe) {
        this.H.f(pipe);
    }

    public final void z2(byte[] bArr, int i) {
        if (this.c.m != 1) {
            byte[] bArr2 = new byte[(i + 1)];
            bArr2[0] = 0;
            System.arraycopy(bArr, 0, bArr2, 1, i);
            this.P.add(Blob.b(bArr2));
            this.Q.add(0);
            if (this.M) {
                this.N = null;
                this.O.clear();
            }
        }
    }
}
