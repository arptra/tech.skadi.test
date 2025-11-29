package zmq;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import zmq.pipe.YPipe;
import zmq.util.Errno;

public class MailboxSafe implements IMailbox {

    /* renamed from: a  reason: collision with root package name */
    public final YPipe f3599a;
    public final ReentrantLock b;
    public final Condition c;
    public final ArrayList d = new ArrayList(10);
    public final String e;
    public final Errno f;

    public MailboxSafe(Ctx ctx, ReentrantLock reentrantLock, String str) {
        this.f = ctx.k();
        YPipe yPipe = new YPipe(Config.COMMAND_PIPE_GRANULARITY.getValue());
        this.f3599a = yPipe;
        this.b = reentrantLock;
        this.c = reentrantLock.newCondition();
        this.e = str;
        Command command = (Command) yPipe.read();
    }

    public void D(Command command) {
        this.b.lock();
        try {
            this.f3599a.a(command, false);
            if (!this.f3599a.flush()) {
                this.c.signalAll();
                for (int i = 0; i < this.d.size(); i++) {
                    ((Signaler) this.d.get(i)).w();
                }
            }
        } finally {
            this.b.unlock();
        }
    }

    public Command M(long j) {
        Command command = (Command) this.f3599a.read();
        if (command != null) {
            return command;
        }
        if (j == 0) {
            this.b.unlock();
            this.b.lock();
        } else if (j == -1) {
            try {
                this.c.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                this.f.c(4);
                return null;
            }
        } else {
            this.c.await(j, TimeUnit.MILLISECONDS);
        }
        Command command2 = (Command) this.f3599a.read();
        if (command2 != null) {
            return command2;
        }
        this.f.c(35);
        return null;
    }

    public void a(Signaler signaler) {
        this.d.add(signaler);
    }

    public void b() {
        this.d.clear();
    }

    public void close() {
        this.b.lock();
        this.b.unlock();
    }

    public String toString() {
        return super.toString() + "[" + this.e + "]";
    }
}
