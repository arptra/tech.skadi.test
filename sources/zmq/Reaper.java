package zmq;

import java.io.Closeable;
import java.util.concurrent.atomic.AtomicBoolean;
import zmq.poll.IPollEvents;
import zmq.poll.Poller;

final class Reaper extends ZObject implements IPollEvents, Closeable {
    public final Mailbox c;
    public final Poller.Handle d;
    public final Poller e;
    public int f = 0;
    public final AtomicBoolean g = new AtomicBoolean();
    public final String h;

    public Reaper(Ctx ctx, int i) {
        super(ctx, i);
        String str = "reaper-" + i;
        this.h = str;
        Poller poller = new Poller(ctx, str);
        this.e = poller;
        Mailbox mailbox = new Mailbox(ctx, str, i);
        this.c = mailbox;
        Poller.Handle h2 = poller.h(mailbox.a(), this);
        this.d = h2;
        poller.r(h2);
    }

    public void A0() {
        int i = this.f - 1;
        this.f = i;
        if (i == 0 && this.g.get()) {
            f1();
        }
    }

    public void C0() {
        this.g.set(true);
        if (this.f == 0) {
            f1();
        }
    }

    public void close() {
        this.e.i();
        this.c.close();
    }

    public final void f1() {
        O0();
        this.e.m(this.d);
        this.e.u();
    }

    public Mailbox g1() {
        return this.c;
    }

    public void h1() {
        this.e.t();
    }

    public void i1() {
        if (!this.g.get()) {
            Z0();
        }
    }

    public void o() {
        while (true) {
            Command M = this.c.M(0);
            if (M != null) {
                M.a();
            } else {
                return;
            }
        }
    }

    public void y0(SocketBase socketBase) {
        this.f++;
        socketBase.g2(this.e);
    }
}
