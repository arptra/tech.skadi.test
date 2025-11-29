package zmq.pipe;

import zmq.Msg;

public class YPipeConflate<T extends Msg> implements YPipeBase<T> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f3650a;
    public final DBuffer b = new DBuffer();

    public boolean c() {
        boolean a2 = this.b.a();
        if (!a2) {
            this.f3650a = false;
        }
        return a2;
    }

    /* renamed from: e */
    public Msg b() {
        return this.b.b();
    }

    /* renamed from: f */
    public Msg read() {
        if (!c()) {
            return null;
        }
        return this.b.c();
    }

    public boolean flush() {
        return this.f3650a;
    }

    /* renamed from: g */
    public Msg d() {
        return null;
    }

    /* renamed from: h */
    public void a(Msg msg, boolean z) {
        this.b.d(msg);
    }
}
