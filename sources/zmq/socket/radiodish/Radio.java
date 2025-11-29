package zmq.socket.radiodish;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import zmq.Ctx;
import zmq.Msg;
import zmq.Options;
import zmq.SocketBase;
import zmq.io.IOThread;
import zmq.io.SessionBase;
import zmq.io.net.Address;
import zmq.pipe.Pipe;
import zmq.socket.pubsub.Dist;

public class Radio extends SocketBase {
    public final Map F = new HashMap();
    public final Dist G = new Dist();

    /* renamed from: zmq.socket.radiodish.Radio$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f3666a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                zmq.socket.radiodish.Radio$RadioSession$State[] r0 = zmq.socket.radiodish.Radio.RadioSession.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3666a = r0
                zmq.socket.radiodish.Radio$RadioSession$State r1 = zmq.socket.radiodish.Radio.RadioSession.State.GROUP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f3666a     // Catch:{ NoSuchFieldError -> 0x001d }
                zmq.socket.radiodish.Radio$RadioSession$State r1 = zmq.socket.radiodish.Radio.RadioSession.State.BODY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: zmq.socket.radiodish.Radio.AnonymousClass1.<clinit>():void");
        }
    }

    public static class RadioSession extends SessionBase {
        public State w = State.GROUP;
        public Msg x;

        public enum State {
            GROUP,
            BODY
        }

        public RadioSession(IOThread iOThread, boolean z, SocketBase socketBase, Options options, Address address) {
            super(iOThread, z, socketBase, options, address);
        }

        public Msg u1() {
            int i = AnonymousClass1.f3666a[this.w.ordinal()];
            if (i == 1) {
                Msg u1 = super.u1();
                this.x = u1;
                if (u1 == null) {
                    return null;
                }
                Msg msg = new Msg(u1.g().getBytes(StandardCharsets.US_ASCII));
                msg.J(1);
                this.w = State.BODY;
                return msg;
            } else if (i == 2) {
                Msg msg2 = this.x;
                this.w = State.GROUP;
                return msg2;
            } else {
                throw new IllegalStateException();
            }
        }

        public boolean v1(Msg msg) {
            String str;
            if (!msg.r()) {
                return super.v1(msg);
            }
            byte e = msg.e(0);
            if (msg.O() < e + 1) {
                return super.v1(msg);
            }
            byte[] c = msg.c();
            Charset charset = StandardCharsets.US_ASCII;
            String str2 = new String(c, 1, e, charset);
            Msg msg2 = new Msg();
            if (str2.equals("JOIN")) {
                str = new String(c, 5, msg.O() - 5, charset);
                msg2.p();
            } else if (!str2.equals("LEAVE")) {
                return super.v1(msg);
            } else {
                str = new String(c, 6, msg.O() - 6, charset);
                msg2.q();
            }
            msg2.K(str);
            return super.v1(msg2);
        }

        public void y1() {
            super.y1();
            this.w = State.GROUP;
        }
    }

    public Radio(Ctx ctx, int i, int i2) {
        super(ctx, i, i2, true);
        this.c.m = 14;
    }

    public void k2(Pipe pipe, boolean z, boolean z2) {
        pipe.y1();
        this.G.b(pipe);
        p2(pipe);
    }

    public boolean l2() {
        return false;
    }

    public boolean m2() {
        return this.G.e();
    }

    public void o2(Pipe pipe) {
        Iterator it = this.F.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            ((List) entry.getValue()).remove(pipe);
            if (((List) entry.getValue()).isEmpty()) {
                it.remove();
            }
        }
        this.G.i(pipe);
    }

    public void p2(Pipe pipe) {
        List list;
        Msg q1 = pipe.q1();
        while (q1 != null) {
            if (q1.v()) {
                if (!this.F.containsKey(q1.g())) {
                    this.F.put(q1.g(), new ArrayList());
                }
                ((List) this.F.get(q1.g())).add(pipe);
            } else if (q1.w() && (list = (List) this.F.get(q1.g())) != null) {
                list.remove(pipe);
                if (list.isEmpty()) {
                    this.F.remove(q1.g());
                }
            }
            q1 = pipe.q1();
        }
    }

    public Msg q2() {
        this.j.c(45);
        throw new UnsupportedOperationException();
    }

    public boolean r2(Msg msg) {
        if (msg.n()) {
            this.j.c(22);
            return false;
        }
        this.G.j();
        List list = (List) this.F.get(msg.g());
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                this.G.f((Pipe) list.get(i));
            }
        }
        this.G.h(msg);
        return true;
    }

    public void t2(Pipe pipe) {
        this.G.a(pipe);
    }
}
