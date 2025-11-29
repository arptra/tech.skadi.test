package zmq.io.net.tcp;

import zmq.Options;
import zmq.io.IOThread;
import zmq.io.SessionBase;
import zmq.io.net.Address;

public class SocksConnecter extends TcpConnecter {
    public Address t;
    public Status u = Status.UNPLUGGED;
    public String v;

    /* renamed from: zmq.io.net.tcp.SocksConnecter$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f3638a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                zmq.io.net.tcp.SocksConnecter$Status[] r0 = zmq.io.net.tcp.SocksConnecter.Status.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3638a = r0
                zmq.io.net.tcp.SocksConnecter$Status r1 = zmq.io.net.tcp.SocksConnecter.Status.UNPLUGGED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f3638a     // Catch:{ NoSuchFieldError -> 0x001d }
                zmq.io.net.tcp.SocksConnecter$Status r1 = zmq.io.net.tcp.SocksConnecter.Status.WAITING_FOR_RECONNECT_TIME     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f3638a     // Catch:{ NoSuchFieldError -> 0x0028 }
                zmq.io.net.tcp.SocksConnecter$Status r1 = zmq.io.net.tcp.SocksConnecter.Status.WAITING_FOR_PROXY_CONNECTION     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f3638a     // Catch:{ NoSuchFieldError -> 0x0033 }
                zmq.io.net.tcp.SocksConnecter$Status r1 = zmq.io.net.tcp.SocksConnecter.Status.SENDING_GREETING     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f3638a     // Catch:{ NoSuchFieldError -> 0x003e }
                zmq.io.net.tcp.SocksConnecter$Status r1 = zmq.io.net.tcp.SocksConnecter.Status.WAITING_FOR_CHOICE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f3638a     // Catch:{ NoSuchFieldError -> 0x0049 }
                zmq.io.net.tcp.SocksConnecter$Status r1 = zmq.io.net.tcp.SocksConnecter.Status.SENDING_REQUEST     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f3638a     // Catch:{ NoSuchFieldError -> 0x0054 }
                zmq.io.net.tcp.SocksConnecter$Status r1 = zmq.io.net.tcp.SocksConnecter.Status.WAITING_FOR_RESPONSE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: zmq.io.net.tcp.SocksConnecter.AnonymousClass1.<clinit>():void");
        }
    }

    public enum Status {
        UNPLUGGED,
        WAITING_FOR_RECONNECT_TIME,
        WAITING_FOR_PROXY_CONNECTION,
        SENDING_GREETING,
        WAITING_FOR_CHOICE,
        SENDING_REQUEST,
        WAITING_FOR_RESPONSE
    }

    public SocksConnecter(IOThread iOThread, SessionBase sessionBase, Options options, Address address, Address address2, boolean z) {
        super(iOThread, sessionBase, options, address, z);
        this.t = address2;
        this.v = address2.toString();
        throw new UnsupportedOperationException("Socks connecter is not implemented");
    }

    public void D0(int i) {
        switch (AnonymousClass1.f3638a[this.u.ordinal()]) {
            case 2:
                this.k.f(1);
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                close();
                break;
        }
        super.D0(i);
    }

    public void d() {
        super.d();
    }

    public void g(int i) {
        super.g(i);
    }

    public void o() {
        super.o();
    }

    public void r0() {
        if (this.o) {
            v1();
        } else {
            u1();
        }
    }

    public void u1() {
    }

    public void v1() {
    }
}
