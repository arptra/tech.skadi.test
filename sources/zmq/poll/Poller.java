package zmq.poll;

import java.io.IOException;
import java.lang.Thread;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ClosedSelectorException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import zmq.Ctx;
import zmq.ZError;

public final class Poller extends PollerBase implements Runnable {
    public final Ctx e;
    public final Set f;
    public boolean g = false;
    public final AtomicBoolean h = new AtomicBoolean();
    public final CountDownLatch i = new CountDownLatch(1);
    public final Thread.UncaughtExceptionHandler j;
    public Selector k;

    public static final class Handle {

        /* renamed from: a  reason: collision with root package name */
        public final SelectableChannel f3654a;
        public final IPollEvents b;
        public int c;
        public boolean d;

        public Handle(SelectableChannel selectableChannel, IPollEvents iPollEvents) {
            this.f3654a = selectableChannel;
            this.b = iPollEvents;
        }

        public static /* synthetic */ int d(Handle handle, int i) {
            int i2 = i & handle.c;
            handle.c = i2;
            return i2;
        }

        public static /* synthetic */ int e(Handle handle, int i) {
            int i2 = i | handle.c;
            handle.c = i2;
            return i2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof Handle)) {
                return false;
            }
            Handle handle = (Handle) obj;
            return this.f3654a.equals(handle.f3654a) && this.b.equals(handle.b);
        }

        public int hashCode() {
            return ((this.f3654a.hashCode() + 31) * 31) + this.b.hashCode();
        }

        public String toString() {
            return "Handle-" + this.f3654a;
        }
    }

    public Poller(Ctx ctx, String str) {
        super(str);
        this.e = ctx;
        this.c.setUncaughtExceptionHandler(ctx.r());
        this.j = ctx.p();
        this.f = new HashSet();
        this.k = ctx.g();
    }

    public /* bridge */ /* synthetic */ void a(long j2, IPollEvents iPollEvents, int i2) {
        super.a(j2, iPollEvents, i2);
    }

    public /* bridge */ /* synthetic */ void c(IPollEvents iPollEvents, int i2) {
        super.c(iPollEvents, i2);
    }

    public Handle h(SelectableChannel selectableChannel, IPollEvents iPollEvents) {
        Handle handle = new Handle(selectableChannel, iPollEvents);
        this.f.add(handle);
        b(1);
        return handle;
    }

    public void i() {
        try {
            u();
            this.i.await();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
            Thread.currentThread().interrupt();
        } catch (Throwable th) {
            this.e.d(this.k);
            throw th;
        }
        this.e.d(this.k);
    }

    public final int j(int i2, long j2, long j3) {
        int i3 = (j2 == 0 || System.currentTimeMillis() - j3 < j2 / 2) ? i2 + 1 : 0;
        if (i3 <= 10) {
            return i3;
        }
        k();
        return 0;
    }

    public final void k() {
        Selector selector = this.k;
        this.k = this.e.g();
        this.g = true;
        this.e.d(selector);
    }

    public final void l(Handle handle, int i2, boolean z) {
        if (z) {
            Handle.e(handle, i2);
        } else {
            Handle.d(handle, ~i2);
        }
        this.g = true;
    }

    public void m(Handle handle) {
        boolean unused = handle.d = true;
        this.g = true;
        b(-1);
    }

    public void n(Handle handle) {
        l(handle, 1, false);
    }

    public void o(Handle handle) {
        l(handle, 4, false);
    }

    public void p(Handle handle) {
        l(handle, 16, true);
    }

    public void q(Handle handle) {
        l(handle, 8, true);
    }

    public void r(Handle handle) {
        l(handle, 1, true);
    }

    public void run() {
        int i2 = 0;
        while (!this.h.get()) {
            long f2 = f();
            if (this.g) {
                this.g = false;
                Iterator it = this.f.iterator();
                while (it.hasNext()) {
                    Handle handle = (Handle) it.next();
                    SelectionKey keyFor = handle.f3654a.keyFor(this.k);
                    if (handle.d || !handle.f3654a.isOpen()) {
                        if (keyFor != null) {
                            keyFor.cancel();
                        }
                        it.remove();
                    } else if (keyFor == null) {
                        if (handle.f3654a.isOpen()) {
                            try {
                                handle.f3654a.register(this.k, handle.c, handle);
                            } catch (CancelledKeyException | ClosedChannelException | ClosedSelectorException e2) {
                                this.j.uncaughtException(this.c, e2);
                            }
                        }
                    } else if (keyFor.isValid()) {
                        keyFor.interestOps(handle.c);
                    }
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            try {
                if (this.k.select(f2) == 0) {
                    i2 = j(i2, f2, currentTimeMillis);
                } else {
                    Iterator<SelectionKey> it2 = this.k.selectedKeys().iterator();
                    while (it2.hasNext()) {
                        SelectionKey next = it2.next();
                        Handle handle2 = (Handle) next.attachment();
                        it2.remove();
                        if (!handle2.d) {
                            try {
                                if (next.isValid() && next.isAcceptable()) {
                                    handle2.b.a();
                                }
                                if (next.isValid() && next.isConnectable()) {
                                    handle2.b.c();
                                }
                                if (next.isValid() && next.isWritable()) {
                                    handle2.b.d();
                                }
                                if (next.isValid() && next.isReadable()) {
                                    handle2.b.o();
                                }
                            } catch (RuntimeException e3) {
                                this.j.uncaughtException(this.c, e3);
                            }
                        }
                    }
                }
            } catch (ClosedSelectorException e4) {
                k();
                this.j.uncaughtException(this.c, e4);
                this.e.k().c(4);
            } catch (IOException e5) {
                throw new ZError.IOException(e5);
            }
        }
        this.i.countDown();
    }

    public void s(Handle handle) {
        l(handle, 4, true);
    }

    public void t() {
        this.c.start();
    }

    public void u() {
        this.h.set(true);
        this.g = false;
        this.k.wakeup();
    }
}
