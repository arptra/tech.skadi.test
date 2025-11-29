package zmq.pipe;

import java.util.concurrent.atomic.AtomicInteger;

public class YPipe<T> implements YPipeBase<T> {

    /* renamed from: a  reason: collision with root package name */
    public final YQueue f3649a;
    public int b;
    public int c;
    public int d;
    public final AtomicInteger e;

    public YPipe(int i) {
        YQueue yQueue = new YQueue(i);
        this.f3649a = yQueue;
        int b2 = yQueue.b();
        this.d = b2;
        this.c = b2;
        this.b = b2;
        this.e = new AtomicInteger(b2);
    }

    public void a(Object obj, boolean z) {
        this.f3649a.f(obj);
        if (!z) {
            this.d = this.f3649a.b();
        }
    }

    public Object b() {
        c();
        return this.f3649a.c();
    }

    public boolean c() {
        int d2 = this.f3649a.d();
        int i = this.c;
        if (d2 != i && i != -1) {
            return true;
        }
        if (!this.e.compareAndSet(d2, -1)) {
            this.c = this.e.get();
        }
        int i2 = this.c;
        return (d2 == i2 || i2 == -1) ? false : true;
    }

    public Object d() {
        if (this.d == this.f3649a.b()) {
            return null;
        }
        this.f3649a.g();
        return this.f3649a.a();
    }

    public boolean flush() {
        int i = this.b;
        int i2 = this.d;
        if (i == i2) {
            return true;
        }
        if (!this.e.compareAndSet(i, i2)) {
            this.e.set(this.d);
            this.b = this.d;
            return false;
        }
        this.b = this.d;
        return true;
    }

    public Object read() {
        if (!c()) {
            return null;
        }
        return this.f3649a.e();
    }
}
