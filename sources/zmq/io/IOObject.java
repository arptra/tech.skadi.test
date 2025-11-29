package zmq.io;

import java.nio.channels.SelectableChannel;
import zmq.poll.IPollEvents;
import zmq.poll.Poller;

public class IOObject implements IPollEvents {

    /* renamed from: a  reason: collision with root package name */
    public final Poller f3616a;
    public final IPollEvents b;
    public boolean c;

    public IOObject(IOThread iOThread, IPollEvents iPollEvents) {
        this.b = iPollEvents;
        this.f3616a = iOThread.h1();
    }

    public final void a() {
        this.b.a();
    }

    public final Poller.Handle b(SelectableChannel selectableChannel) {
        return this.f3616a.h(selectableChannel, this);
    }

    public final void c() {
        this.b.c();
    }

    public final void d() {
        this.b.d();
    }

    public final void e(long j, int i) {
        this.f3616a.a(j, this, i);
    }

    public final void f(int i) {
        this.f3616a.c(this, i);
    }

    public final void g(int i) {
        this.b.g(i);
    }

    public final void h() {
        this.c = true;
    }

    public final void i(Poller.Handle handle) {
        this.f3616a.m(handle);
    }

    public final void j(Poller.Handle handle) {
        this.f3616a.n(handle);
    }

    public final void k(Poller.Handle handle) {
        this.f3616a.o(handle);
    }

    public final void l(Poller.Handle handle) {
        this.f3616a.p(handle);
    }

    public final void m(Poller.Handle handle) {
        this.f3616a.q(handle);
    }

    public final void n(Poller.Handle handle) {
        this.f3616a.r(handle);
    }

    public final void o() {
        this.b.o();
    }

    public final void p(Poller.Handle handle) {
        this.f3616a.s(handle);
    }

    public final void q() {
        this.c = false;
    }

    public String toString() {
        return "" + this.b;
    }
}
