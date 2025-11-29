package zmq.socket.reqrep;

import zmq.Ctx;
import zmq.Msg;
import zmq.Options;
import zmq.SocketBase;
import zmq.io.IOThread;
import zmq.io.SessionBase;
import zmq.io.net.Address;
import zmq.pipe.Pipe;
import zmq.util.Utils;
import zmq.util.ValueReference;
import zmq.util.Wire;

public class Req extends Dealer {
    public boolean I = false;
    public boolean J = true;
    public final ValueReference K = new ValueReference();
    public boolean L;
    public int M;
    public boolean N;

    /* renamed from: zmq.socket.reqrep.Req$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f3667a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                zmq.socket.reqrep.Req$ReqSession$State[] r0 = zmq.socket.reqrep.Req.ReqSession.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3667a = r0
                zmq.socket.reqrep.Req$ReqSession$State r1 = zmq.socket.reqrep.Req.ReqSession.State.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f3667a     // Catch:{ NoSuchFieldError -> 0x001d }
                zmq.socket.reqrep.Req$ReqSession$State r1 = zmq.socket.reqrep.Req.ReqSession.State.REQUEST_ID     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f3667a     // Catch:{ NoSuchFieldError -> 0x0028 }
                zmq.socket.reqrep.Req$ReqSession$State r1 = zmq.socket.reqrep.Req.ReqSession.State.BODY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: zmq.socket.reqrep.Req.AnonymousClass1.<clinit>():void");
        }
    }

    public static class ReqSession extends SessionBase {
        public State w = State.BOTTOM;

        public enum State {
            BOTTOM,
            REQUEST_ID,
            BODY
        }

        public ReqSession(IOThread iOThread, boolean z, SocketBase socketBase, Options options, Address address) {
            super(iOThread, z, socketBase, options, address);
        }

        public boolean v1(Msg msg) {
            if (msg.r()) {
                return true;
            }
            int i = AnonymousClass1.f3667a[this.w.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        if (msg.n()) {
                            return super.v1(msg);
                        }
                        if (msg.d() == 0) {
                            this.w = State.BOTTOM;
                            return super.v1(msg);
                        }
                    }
                } else if (msg.n() && msg.O() == 0) {
                    this.w = State.BODY;
                    return super.v1(msg);
                }
            } else if (msg.n()) {
                if (msg.O() == 4) {
                    this.w = State.REQUEST_ID;
                    return super.v1(msg);
                } else if (msg.O() == 0) {
                    this.w = State.BODY;
                    return super.v1(msg);
                }
            }
            this.j.c(14);
            return false;
        }

        public void y1() {
            super.y1();
            this.w = State.BOTTOM;
        }
    }

    public Req(Ctx ctx, int i, int i2) {
        super(ctx, i, i2);
        Options options = this.c;
        options.m = 3;
        options.d0 = false;
        this.L = false;
        this.M = Utils.g();
        this.N = true;
    }

    public boolean l2() {
        return this.I && super.l2();
    }

    public boolean m2() {
        return !this.I && super.m2();
    }

    public void o2(Pipe pipe) {
        if (this.K.a() == pipe) {
            this.K.b((Object) null);
        }
        super.o2(pipe);
    }

    public Msg q2() {
        if (!this.I) {
            this.j.c(156384763);
            return null;
        }
        while (this.J) {
            if (this.L) {
                Msg w2 = w2();
                if (w2 == null) {
                    return null;
                }
                if (!(w2.n() && w2.O() == 4 && w2.h(0) == this.M)) {
                    while (w2.n()) {
                        w2 = w2();
                    }
                }
            }
            Msg w22 = w2();
            if (w22 == null) {
                return null;
            }
            if (!w22.n() || w22.O() != 0) {
                while (w22.n()) {
                    w22 = w2();
                }
            } else {
                this.J = false;
            }
        }
        Msg w23 = w2();
        if (w23 == null) {
            return null;
        }
        if (!w23.n()) {
            this.I = false;
            this.J = true;
        }
        return w23;
    }

    public boolean r2(Msg msg) {
        if (this.I) {
            if (this.N) {
                this.j.c(156384763);
                return false;
            }
            this.I = false;
            this.J = true;
        }
        if (this.J) {
            this.K.b((Object) null);
            if (this.L) {
                this.M++;
                Msg msg2 = new Msg(4);
                Wire.i(msg2.a(), this.M);
                msg2.J(1);
                if (!super.v2(msg2, this.K)) {
                    return false;
                }
            }
            Msg msg3 = new Msg();
            msg3.J(1);
            if (!super.v2(msg3, this.K)) {
                return false;
            }
            this.J = false;
            do {
            } while (super.q2() != null);
        }
        boolean n = msg.n();
        if (!super.r2(msg)) {
            return false;
        }
        if (!n) {
            this.I = true;
            this.J = true;
        }
        return true;
    }

    public boolean s2(int i, Object obj) {
        if (i == 52) {
            this.L = Options.e(i, obj);
            return true;
        } else if (i != 53) {
            return super.s2(i, obj);
        } else {
            this.N = !Options.e(i, obj);
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final zmq.Msg w2() {
        /*
            r3 = this;
        L_0x0000:
            zmq.util.ValueReference r0 = new zmq.util.ValueReference
            r0.<init>()
            zmq.Msg r1 = super.u2(r0)
            if (r1 != 0) goto L_0x000d
            r3 = 0
            return r3
        L_0x000d:
            zmq.util.ValueReference r2 = r3.K
            java.lang.Object r2 = r2.a()
            if (r2 == 0) goto L_0x0021
            zmq.util.ValueReference r2 = r3.K
            java.lang.Object r2 = r2.a()
            java.lang.Object r0 = r0.a()
            if (r2 != r0) goto L_0x0000
        L_0x0021:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: zmq.socket.reqrep.Req.w2():zmq.Msg");
    }
}
