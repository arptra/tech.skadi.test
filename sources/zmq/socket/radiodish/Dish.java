package zmq.socket.radiodish;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;
import zmq.Ctx;
import zmq.Msg;
import zmq.Options;
import zmq.SocketBase;
import zmq.io.IOThread;
import zmq.io.SessionBase;
import zmq.io.net.Address;
import zmq.pipe.Pipe;
import zmq.socket.FQ;
import zmq.socket.pubsub.Dist;

public class Dish extends SocketBase {
    public final FQ F = new FQ();
    public final Dist G = new Dist();
    public final Set H = new HashSet();
    public Msg I;

    /* renamed from: zmq.socket.radiodish.Dish$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f3665a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                zmq.socket.radiodish.Dish$DishSession$State[] r0 = zmq.socket.radiodish.Dish.DishSession.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3665a = r0
                zmq.socket.radiodish.Dish$DishSession$State r1 = zmq.socket.radiodish.Dish.DishSession.State.GROUP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f3665a     // Catch:{ NoSuchFieldError -> 0x001d }
                zmq.socket.radiodish.Dish$DishSession$State r1 = zmq.socket.radiodish.Dish.DishSession.State.BODY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: zmq.socket.radiodish.Dish.AnonymousClass1.<clinit>():void");
        }
    }

    public static class DishSession extends SessionBase {
        public static final byte[] y;
        public static final byte[] z;
        public State w = State.GROUP;
        public String x = "";

        public enum State {
            GROUP,
            BODY
        }

        static {
            Charset charset = StandardCharsets.US_ASCII;
            y = "\u0004JOIN".getBytes(charset);
            z = "\u0005LEAVE".getBytes(charset);
        }

        public DishSession(IOThread iOThread, boolean z2, SocketBase socketBase, Options options, Address address) {
            super(iOThread, z2, socketBase, options, address);
        }

        public Msg u1() {
            Msg msg;
            Msg u1 = super.u1();
            if (u1 == null) {
                return null;
            }
            if (!u1.v() && !u1.w()) {
                return u1;
            }
            byte[] bytes = u1.g().getBytes(StandardCharsets.US_ASCII);
            if (u1.v()) {
                msg = new Msg(bytes.length + 5);
                msg.C(y);
            } else {
                msg = new Msg(bytes.length + 6);
                msg.C(z);
            }
            msg.J(2);
            msg.C(bytes);
            return msg;
        }

        public boolean v1(Msg msg) {
            int i = AnonymousClass1.f3665a[this.w.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    msg.K(this.x);
                    if (msg.n()) {
                        this.j.c(14);
                        return false;
                    }
                    boolean v1 = super.v1(msg);
                    if (v1) {
                        this.w = State.GROUP;
                    }
                    return v1;
                }
                throw new IllegalStateException();
            } else if (!msg.n()) {
                this.j.c(14);
                return false;
            } else if (msg.O() > 255) {
                this.j.c(14);
                return false;
            } else {
                this.x = new String(msg.c(), StandardCharsets.US_ASCII);
                this.w = State.BODY;
                return true;
            }
        }

        public void y1() {
            super.y1();
            this.w = State.GROUP;
        }
    }

    public Dish(Ctx ctx, int i, int i2) {
        super(ctx, i, i2, true);
        Options options = this.c;
        options.m = 15;
        options.n = 0;
    }

    public void k2(Pipe pipe, boolean z, boolean z2) {
        this.F.b(pipe);
        this.G.b(pipe);
        u2(pipe);
    }

    public boolean l2() {
        if (this.I != null) {
            return true;
        }
        Msg v2 = v2();
        if (v2 == null) {
            return false;
        }
        this.I = v2;
        return true;
    }

    public boolean m2() {
        return true;
    }

    public void n2(Pipe pipe) {
        u2(pipe);
    }

    public void o2(Pipe pipe) {
        this.F.f(pipe);
        this.G.i(pipe);
    }

    public void p2(Pipe pipe) {
        this.F.a(pipe);
    }

    public Msg q2() {
        Msg msg = this.I;
        if (msg == null) {
            return v2();
        }
        this.I = null;
        return msg;
    }

    public boolean r2(Msg msg) {
        this.j.c(45);
        throw new UnsupportedOperationException();
    }

    public void t2(Pipe pipe) {
        this.G.a(pipe);
    }

    public final void u2(Pipe pipe) {
        for (String K : this.H) {
            Msg msg = new Msg();
            msg.p();
            msg.K(K);
            pipe.C1(msg);
        }
        pipe.flush();
    }

    public final Msg v2() {
        Msg d = this.F.d(this.j);
        if (d == null) {
            return null;
        }
        while (!this.H.contains(d.g())) {
            d = this.F.d(this.j);
            if (d == null) {
                return null;
            }
        }
        return d;
    }
}
