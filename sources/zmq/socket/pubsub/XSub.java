package zmq.socket.pubsub;

import zmq.Ctx;
import zmq.Msg;
import zmq.Options;
import zmq.SocketBase;
import zmq.pipe.Pipe;
import zmq.socket.FQ;
import zmq.socket.pubsub.Trie;

public class XSub extends SocketBase {
    public final FQ F;
    public final Dist G;
    public final Trie H;
    public boolean I;
    public Msg J;
    public boolean K;
    public final Trie.ITrieHandler L = new SendSubscription();

    public final class SendSubscription implements Trie.ITrieHandler {
        public SendSubscription() {
        }

        public void a(byte[] bArr, int i, Pipe pipe) {
            boolean unused = XSub.this.w2(bArr, i, pipe);
        }
    }

    public XSub(Ctx ctx, int i, int i2) {
        super(ctx, i, i2);
        Options options = this.c;
        options.m = 10;
        this.I = false;
        this.K = false;
        options.n = 0;
        this.F = new FQ();
        this.G = new Dist();
        this.H = new Trie();
        this.J = new Msg();
    }

    public void k2(Pipe pipe, boolean z, boolean z2) {
        this.F.b(pipe);
        this.G.b(pipe);
        this.H.b(this.L, pipe);
        pipe.flush();
    }

    public boolean l2() {
        if (this.K || this.I) {
            return true;
        }
        while (true) {
            Msg d = this.F.d(this.j);
            this.J = d;
            if (d == null) {
                return false;
            }
            if (!this.c.w || v2(d)) {
                this.I = true;
            } else {
                while (this.J.n()) {
                    this.J = this.F.d(this.j);
                }
            }
        }
        this.I = true;
        return true;
    }

    public boolean m2() {
        return true;
    }

    public void n2(Pipe pipe) {
        this.H.b(this.L, pipe);
        pipe.flush();
    }

    public void o2(Pipe pipe) {
        this.F.f(pipe);
        this.G.i(pipe);
    }

    public void p2(Pipe pipe) {
        this.F.a(pipe);
    }

    public Msg q2() {
        Msg d;
        if (this.I) {
            Msg msg = this.J;
            this.I = false;
            this.K = msg.n();
            return msg;
        }
        while (true) {
            d = this.F.d(this.j);
            if (d == null) {
                return null;
            }
            if (this.K || !this.c.w || v2(d)) {
                this.K = d.n();
            } else {
                while (d.n()) {
                    d = this.F.d(this.j);
                }
            }
        }
        this.K = d.n();
        return d;
    }

    public boolean r2(Msg msg) {
        int O = msg.O();
        if (O > 0 && msg.e(0) == 1) {
            this.H.a(msg, 1, O - 1);
            return this.G.g(msg);
        } else if (O <= 0 || msg.e(0) != 0) {
            return this.G.g(msg);
        } else {
            if (this.H.g(msg, 1, O - 1)) {
                return this.G.g(msg);
            }
            return true;
        }
    }

    public void t2(Pipe pipe) {
        this.G.a(pipe);
    }

    public final boolean v2(Msg msg) {
        return this.H.d(msg.a());
    }

    public final boolean w2(byte[] bArr, int i, Pipe pipe) {
        Msg msg = new Msg(i + 1);
        msg.x((byte) 1).D(bArr, 0, i);
        return pipe.C1(msg);
    }
}
