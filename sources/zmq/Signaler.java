package zmq;

import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ClosedSelectorException;
import java.nio.channels.Pipe;
import java.nio.channels.SelectableChannel;
import java.nio.channels.Selector;
import java.util.concurrent.atomic.AtomicLong;
import zmq.ZError;
import zmq.util.Errno;
import zmq.util.Utils;

final class Signaler implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public final Pipe.SinkChannel f3603a;
    public final Pipe.SourceChannel b;
    public final Selector c;
    public final ByteBuffer d = ByteBuffer.allocate(1);
    public final ByteBuffer e = ByteBuffer.allocate(1);
    public final AtomicLong f = new AtomicLong(0);
    public long g = 0;
    public final Errno h;
    public final int i;
    public final Ctx j;

    public interface IoOperation<O> {
        Object call();
    }

    public Signaler(Ctx ctx, int i2, Errno errno) {
        this.j = ctx;
        this.i = i2;
        this.h = errno;
        try {
            Pipe open = Pipe.open();
            Pipe.SourceChannel source = open.source();
            this.b = source;
            Pipe.SinkChannel sink = open.sink();
            this.f3603a = sink;
            Utils.j(sink, source);
            Selector g2 = ctx.g();
            this.c = g2;
            source.register(g2, 1);
        } catch (IOException e2) {
            throw new ZError.IOException(e2);
        }
    }

    public void close() {
        IoOperation[] ioOperationArr = {new a(this), new b(this), new c(this)};
        IOException iOException = null;
        for (int i2 = 0; i2 < 3; i2++) {
            try {
                u(ioOperationArr[i2]);
            } catch (IOException e2) {
                if (iOException != null) {
                    e2.addSuppressed(iOException);
                }
                iOException = e2;
            }
        }
        if (iOException != null) {
            throw iOException;
        }
    }

    public SelectableChannel i() {
        return this.b;
    }

    public final /* synthetic */ Object j() {
        this.b.close();
        return null;
    }

    public final /* synthetic */ Object n() {
        this.f3603a.close();
        return null;
    }

    public final /* synthetic */ Object o() {
        this.j.d(this.c);
        return null;
    }

    public final /* synthetic */ Integer r() {
        return Integer.valueOf(this.b.read(this.e));
    }

    public final /* synthetic */ Integer s() {
        return Integer.valueOf(this.f3603a.write(this.d));
    }

    public String toString() {
        return "Signaler[" + this.i + "]";
    }

    public final Object u(IoOperation ioOperation) {
        Object call;
        boolean interrupted = Thread.interrupted();
        while (true) {
            try {
                call = ioOperation.call();
                break;
            } catch (ClosedByInterruptException unused) {
                Thread.currentThread().interrupt();
                interrupted = true;
            } catch (Throwable th) {
                if (interrupted) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (interrupted) {
            Thread.currentThread().interrupt();
        }
        return call;
    }

    public void v() {
        int i2 = 0;
        while (i2 == 0) {
            try {
                this.e.clear();
                i2 = ((Integer) u(new e(this))).intValue();
            } catch (ClosedChannelException unused) {
                this.h.c(4);
                return;
            } catch (IOException e2) {
                throw new ZError.IOException(e2);
            }
        }
        this.g++;
    }

    public void w() {
        int i2 = 0;
        while (i2 == 0) {
            try {
                this.d.clear();
                i2 = ((Integer) u(new d(this))).intValue();
            } catch (IOException e2) {
                throw new ZError.IOException(e2);
            }
        }
        this.f.incrementAndGet();
    }

    public boolean z(long j2) {
        if (Thread.interrupted()) {
            this.h.c(4);
            return false;
        } else if (this.g < this.f.get()) {
            return true;
        } else {
            int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
            if (i2 == 0) {
                try {
                    this.h.c(35);
                    return false;
                } catch (ClosedSelectorException unused) {
                    this.h.c(4);
                    return false;
                } catch (IOException e2) {
                    this.h.c(ZError.a(e2));
                    return false;
                }
            } else {
                int select = i2 < 0 ? this.c.select(0) : this.c.select(j2);
                if (Thread.interrupted() || (select == 0 && i2 <= 0 && !this.c.keys().isEmpty())) {
                    this.h.c(4);
                    return false;
                } else if (select == 0) {
                    this.h.c(35);
                    return false;
                } else {
                    this.c.selectedKeys().clear();
                    return true;
                }
            }
        }
    }
}
