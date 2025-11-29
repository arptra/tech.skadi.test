package zmq.io;

import java.io.Closeable;
import zmq.Command;
import zmq.Ctx;
import zmq.Mailbox;
import zmq.ZObject;
import zmq.poll.IPollEvents;
import zmq.poll.Poller;

public class IOThread extends ZObject implements IPollEvents, Closeable {
    public final Mailbox c;
    public final Poller.Handle d;
    public final Poller e;
    public final String f;

    public IOThread(Ctx ctx, int i) {
        super(ctx, i);
        String str = "iothread-" + i;
        this.f = str;
        Poller poller = new Poller(ctx, str);
        this.e = poller;
        Mailbox mailbox = new Mailbox(ctx, str, i);
        this.c = mailbox;
        Poller.Handle h = poller.h(mailbox.a(), this);
        this.d = h;
        poller.r(h);
    }

    public void C0() {
        this.e.m(this.d);
        this.e.u();
    }

    public void close() {
        this.e.i();
        this.c.close();
    }

    public int f1() {
        return this.e.g();
    }

    public Mailbox g1() {
        return this.c;
    }

    public Poller h1() {
        return this.e;
    }

    public void i1() {
        this.e.t();
    }

    public void j1() {
        Z0();
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
}
