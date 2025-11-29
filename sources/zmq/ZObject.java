package zmq;

import zmq.Command;
import zmq.Ctx;
import zmq.io.IEngine;
import zmq.io.IOThread;
import zmq.io.SessionBase;
import zmq.pipe.Pipe;
import zmq.pipe.YPipeBase;

public abstract class ZObject {

    /* renamed from: a  reason: collision with root package name */
    public final Ctx f3609a;
    public int b;

    /* renamed from: zmq.ZObject$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f3610a;

        /* JADX WARNING: Can't wrap try/catch for region: R(38:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|(3:37|38|40)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(40:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|40) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00d8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                zmq.Command$Type[] r0 = zmq.Command.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3610a = r0
                zmq.Command$Type r1 = zmq.Command.Type.ACTIVATE_READ     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f3610a     // Catch:{ NoSuchFieldError -> 0x001d }
                zmq.Command$Type r1 = zmq.Command.Type.ACTIVATE_WRITE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f3610a     // Catch:{ NoSuchFieldError -> 0x0028 }
                zmq.Command$Type r1 = zmq.Command.Type.STOP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f3610a     // Catch:{ NoSuchFieldError -> 0x0033 }
                zmq.Command$Type r1 = zmq.Command.Type.PLUG     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f3610a     // Catch:{ NoSuchFieldError -> 0x003e }
                zmq.Command$Type r1 = zmq.Command.Type.OWN     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f3610a     // Catch:{ NoSuchFieldError -> 0x0049 }
                zmq.Command$Type r1 = zmq.Command.Type.ATTACH     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f3610a     // Catch:{ NoSuchFieldError -> 0x0054 }
                zmq.Command$Type r1 = zmq.Command.Type.BIND     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f3610a     // Catch:{ NoSuchFieldError -> 0x0060 }
                zmq.Command$Type r1 = zmq.Command.Type.HICCUP     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f3610a     // Catch:{ NoSuchFieldError -> 0x006c }
                zmq.Command$Type r1 = zmq.Command.Type.PIPE_TERM     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f3610a     // Catch:{ NoSuchFieldError -> 0x0078 }
                zmq.Command$Type r1 = zmq.Command.Type.PIPE_TERM_ACK     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f3610a     // Catch:{ NoSuchFieldError -> 0x0084 }
                zmq.Command$Type r1 = zmq.Command.Type.TERM_REQ     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f3610a     // Catch:{ NoSuchFieldError -> 0x0090 }
                zmq.Command$Type r1 = zmq.Command.Type.TERM     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f3610a     // Catch:{ NoSuchFieldError -> 0x009c }
                zmq.Command$Type r1 = zmq.Command.Type.TERM_ACK     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f3610a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                zmq.Command$Type r1 = zmq.Command.Type.REAP     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f3610a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                zmq.Command$Type r1 = zmq.Command.Type.REAP_ACK     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f3610a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                zmq.Command$Type r1 = zmq.Command.Type.REAPED     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = f3610a     // Catch:{ NoSuchFieldError -> 0x00cc }
                zmq.Command$Type r1 = zmq.Command.Type.INPROC_CONNECTED     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r0 = f3610a     // Catch:{ NoSuchFieldError -> 0x00d8 }
                zmq.Command$Type r1 = zmq.Command.Type.CANCEL     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                int[] r0 = f3610a     // Catch:{ NoSuchFieldError -> 0x00e4 }
                zmq.Command$Type r1 = zmq.Command.Type.DONE     // Catch:{ NoSuchFieldError -> 0x00e4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e4 }
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e4 }
            L_0x00e4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: zmq.ZObject.AnonymousClass1.<clinit>():void");
        }
    }

    public ZObject(Ctx ctx, int i) {
        this.f3609a = ctx;
        this.b = i;
    }

    public void A0() {
        throw new UnsupportedOperationException();
    }

    public void B0() {
        throw new UnsupportedOperationException();
    }

    public void C0() {
        throw new UnsupportedOperationException();
    }

    public void D0(int i) {
        throw new UnsupportedOperationException();
    }

    public void E0() {
        throw new UnsupportedOperationException();
    }

    public void F0(Own own) {
        throw new UnsupportedOperationException();
    }

    public final boolean G0(String str, Ctx.Endpoint endpoint) {
        return this.f3609a.w(str, endpoint);
    }

    public final void H0(Pipe pipe) {
        N0(new Command(pipe, Command.Type.ACTIVATE_READ));
    }

    public final void I0(Pipe pipe, long j) {
        N0(new Command(pipe, Command.Type.ACTIVATE_WRITE, Long.valueOf(j)));
    }

    public final void J(String str, Ctx.Endpoint endpoint, Pipe[] pipeArr) {
        this.f3609a.v(str, endpoint, pipeArr);
    }

    public final void J0(SessionBase sessionBase, IEngine iEngine) {
        K0(sessionBase, iEngine, true);
    }

    public final void K0(SessionBase sessionBase, IEngine iEngine, boolean z) {
        if (z) {
            sessionBase.h1();
        }
        N0(new Command(sessionBase, Command.Type.ATTACH, iEngine));
    }

    public final void L0(Own own, Pipe pipe) {
        M0(own, pipe, true);
    }

    public final void M0(Own own, Pipe pipe, boolean z) {
        if (z) {
            own.h1();
        }
        N0(new Command(own, Command.Type.BIND, pipe));
    }

    public void N() {
        throw new UnsupportedOperationException();
    }

    public final void N0(Command command) {
        this.f3609a.x(command.f3593a.z(), command);
    }

    public final void O0() {
        this.f3609a.x(0, new Command((ZObject) null, Command.Type.DONE));
    }

    public final void P0(Pipe pipe, YPipeBase yPipeBase) {
        N0(new Command(pipe, Command.Type.HICCUP, yPipeBase));
    }

    public final void Q0(SocketBase socketBase) {
        N0(new Command(socketBase, Command.Type.INPROC_CONNECTED));
    }

    public final void R0(Own own, Own own2) {
        own.h1();
        N0(new Command(own, Command.Type.OWN, own2));
    }

    public void S(long j) {
        throw new UnsupportedOperationException();
    }

    public final void S0(Pipe pipe) {
        N0(new Command(pipe, Command.Type.PIPE_TERM));
    }

    public void T(IEngine iEngine) {
        throw new UnsupportedOperationException();
    }

    public final void T0(Pipe pipe) {
        N0(new Command(pipe, Command.Type.PIPE_TERM_ACK));
    }

    public void U(Pipe pipe) {
        throw new UnsupportedOperationException();
    }

    public final void U0(Own own) {
        V0(own, true);
    }

    public final void V0(Own own, boolean z) {
        if (z) {
            own.h1();
        }
        N0(new Command(own, Command.Type.PLUG));
    }

    public final void W0(SocketBase socketBase) {
        N0(new Command(this.f3609a.q(), Command.Type.REAP, socketBase));
    }

    public final void X0() {
        N0(new Command(this, Command.Type.REAP_ACK));
    }

    public final void Y0() {
        N0(new Command(this.f3609a.q(), Command.Type.REAPED));
    }

    public final void Z0() {
        this.f3609a.x(this.b, new Command(this, Command.Type.STOP));
    }

    public final void a1(Own own, int i) {
        N0(new Command(own, Command.Type.TERM, Integer.valueOf(i)));
    }

    public final void b1(Own own) {
        N0(new Command(own, Command.Type.TERM_ACK));
    }

    public void c0() {
    }

    public final void c1(Own own, Own own2) {
        N0(new Command(own, Command.Type.TERM_REQ, own2));
    }

    public final void d0(Command command) {
        switch (AnonymousClass1.f3610a[command.b.ordinal()]) {
            case 1:
                N();
                return;
            case 2:
                S(((Long) command.c).longValue());
                return;
            case 3:
                C0();
                return;
            case 4:
                r0();
                B0();
                return;
            case 5:
                i0((Own) command.c);
                B0();
                return;
            case 6:
                T((IEngine) command.c);
                B0();
                return;
            case 7:
                U((Pipe) command.c);
                B0();
                return;
            case 8:
                f0((YPipeBase) command.c);
                return;
            case 9:
                p0();
                return;
            case 10:
                q0();
                return;
            case 11:
                F0((Own) command.c);
                return;
            case 12:
                D0(((Integer) command.c).intValue());
                return;
            case 13:
                E0();
                return;
            case 14:
                y0((SocketBase) command.c);
                return;
            case 15:
                z0();
                return;
            case 16:
                A0();
                return;
            case 17:
                B0();
                return;
            case 18:
                c0();
                return;
            default:
                throw new IllegalArgumentException();
        }
    }

    public final void d1(int i) {
        this.b = i;
    }

    public final void e1(SocketBase socketBase) {
        this.f3609a.A(socketBase);
    }

    public void f0(YPipeBase yPipeBase) {
        throw new UnsupportedOperationException();
    }

    public void i0(Own own) {
        throw new UnsupportedOperationException();
    }

    public void p0() {
        throw new UnsupportedOperationException();
    }

    public void q0() {
        throw new UnsupportedOperationException();
    }

    public final IOThread r(long j) {
        return this.f3609a.b(j);
    }

    public void r0() {
        throw new UnsupportedOperationException();
    }

    public final void s(String str, SocketBase socketBase) {
        this.f3609a.f(str, socketBase);
    }

    public final void u(SocketBase socketBase) {
        this.f3609a.j(socketBase);
    }

    public final Ctx.Endpoint v(String str) {
        return this.f3609a.l(str);
    }

    public final Ctx w() {
        return this.f3609a;
    }

    public void y0(SocketBase socketBase) {
        throw new UnsupportedOperationException();
    }

    public final int z() {
        return this.b;
    }

    public void z0() {
    }

    public ZObject(ZObject zObject) {
        this(zObject.f3609a, zObject.b);
    }
}
