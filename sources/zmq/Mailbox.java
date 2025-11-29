package zmq;

import java.nio.channels.SelectableChannel;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import zmq.pipe.YPipe;
import zmq.util.Errno;

public final class Mailbox implements IMailbox {

    /* renamed from: a  reason: collision with root package name */
    public final YPipe f3598a;
    public final Signaler b;
    public final Lock c = new ReentrantLock();
    public boolean d;
    public final String e;
    public final Errno f;

    public Mailbox(Ctx ctx, String str, int i) {
        Errno k = ctx.k();
        this.f = k;
        YPipe yPipe = new YPipe(Config.COMMAND_PIPE_GRANULARITY.getValue());
        this.f3598a = yPipe;
        this.b = new Signaler(ctx, i, k);
        Command command = (Command) yPipe.read();
        this.d = false;
        this.e = str;
    }

    public void D(Command command) {
        this.c.lock();
        try {
            this.f3598a.a(command, false);
            if (!this.f3598a.flush()) {
                this.b.w();
            }
        } finally {
            this.c.unlock();
        }
    }

    public Command M(long j) {
        if (this.d) {
            Command command = (Command) this.f3598a.read();
            if (command != null) {
                return command;
            }
            this.d = false;
        }
        if (!this.b.z(j)) {
            return null;
        }
        this.b.v();
        if (this.f.a() == 4) {
            return null;
        }
        this.d = true;
        return (Command) this.f3598a.read();
    }

    public SelectableChannel a() {
        return this.b.i();
    }

    public void close() {
        this.c.lock();
        this.c.unlock();
        this.b.close();
    }

    public String toString() {
        return super.toString() + "[" + this.e + "]";
    }
}
