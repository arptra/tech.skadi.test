package zmq.pipe;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import zmq.Msg;

class DBuffer<T extends Msg> {

    /* renamed from: a  reason: collision with root package name */
    public Msg f3648a;
    public Msg b;
    public final Lock c = new ReentrantLock();
    public boolean d;

    public boolean a() {
        this.c.lock();
        try {
            return this.d;
        } finally {
            this.c.unlock();
        }
    }

    public Msg b() {
        this.c.lock();
        try {
            return this.b;
        } finally {
            this.c.unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    public Msg c() {
        this.c.lock();
        try {
            if (!this.d) {
                this.c.unlock();
                return null;
            }
            this.d = false;
            Msg msg = this.b;
            this.c.unlock();
            return msg;
        } catch (Throwable th) {
            this.c.unlock();
            throw th;
        }
    }

    public void d(Msg msg) {
        this.c.lock();
        try {
            this.f3648a = this.b;
            this.b = msg;
            this.d = true;
        } finally {
            this.c.unlock();
        }
    }
}
