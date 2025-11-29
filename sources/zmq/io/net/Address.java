package zmq.io.net;

import com.honey.account.constant.AccountConstantKt;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

public class Address {

    /* renamed from: a  reason: collision with root package name */
    public final NetProtocol f3636a;
    public final String b;
    public IZAddress c;

    public interface IZAddress {
        SocketAddress a();

        SocketAddress address();

        ProtocolFamily b();

        String c(int i);
    }

    public Address(NetProtocol netProtocol, String str) {
        this.f3636a = netProtocol;
        this.b = str;
        this.c = null;
    }

    public String a() {
        return this.b;
    }

    public String b() {
        int lastIndexOf = this.b.lastIndexOf(58);
        return lastIndexOf > 0 ? this.b.substring(0, lastIndexOf) : this.b;
    }

    public boolean c() {
        return this.c != null;
    }

    public NetProtocol d() {
        return this.f3636a;
    }

    public IZAddress e(boolean z) {
        IZAddress zresolve = this.f3636a.zresolve(this.b, z);
        this.c = zresolve;
        return zresolve;
    }

    public IZAddress f() {
        return this.c;
    }

    public String toString() {
        if (c()) {
            return this.c.toString();
        }
        if (this.f3636a == null || this.b.isEmpty()) {
            return "";
        }
        return this.f3636a.name() + "://" + this.b;
    }

    public Address(SocketAddress socketAddress) {
        InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
        this.b = inetSocketAddress.getAddress().getHostAddress() + AccountConstantKt.CODE_SEPARTOR + inetSocketAddress.getPort();
        this.f3636a = NetProtocol.tcp;
        this.c = null;
    }
}
