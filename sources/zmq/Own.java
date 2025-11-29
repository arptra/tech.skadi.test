package zmq;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import zmq.io.IOThread;
import zmq.util.Errno;

public abstract class Own extends ZObject {
    public final Options c;
    public boolean d = false;
    public final AtomicLong e = new AtomicLong(0);
    public long f = 0;
    public Own g = null;
    public final Set h;
    public int i = 0;
    public final Errno j;

    public Own(Ctx ctx, int i2) {
        super(ctx, i2);
        Options options = new Options();
        this.c = options;
        this.j = options.k0;
        this.h = new HashSet();
    }

    public final void B0() {
        this.f++;
        f1();
    }

    public void D0(int i2) {
        for (Own a1 : this.h) {
            a1(a1, i2);
        }
        l1(this.h.size());
        this.h.clear();
        this.d = true;
        f1();
    }

    public final void E0() {
        o1();
    }

    public final void F0(Own own) {
        if (!this.d && this.h.remove(own)) {
            l1(1);
            a1(own, this.c.n);
        }
    }

    public final void f1() {
        if (this.d && this.f == this.e.get() && this.i == 0) {
            Own own = this.g;
            if (own != null) {
                b1(own);
            }
            k1();
        }
    }

    public abstract void g1();

    public void h1() {
        this.e.incrementAndGet();
    }

    public final void i0(Own own) {
        if (this.d) {
            l1(1);
            a1(own, 0);
            return;
        }
        this.h.add(own);
    }

    public final boolean i1() {
        return this.d;
    }

    public final void j1(Own own) {
        own.m1(this);
        U0(own);
        R0(this, own);
    }

    public void k1() {
        g1();
    }

    public final void l1(int i2) {
        this.i += i2;
    }

    public final void m1(Own own) {
        this.g = own;
    }

    public final void n1() {
        if (!this.d) {
            Own own = this.g;
            if (own == null) {
                D0(this.c.n);
            } else {
                c1(own, this);
            }
        }
    }

    public final void o1() {
        this.i--;
        f1();
    }

    public Own(IOThread iOThread, Options options) {
        super(iOThread);
        this.c = options;
        this.j = options.k0;
        this.h = new HashSet();
    }
}
