package zmq.io.net.ipc;

import com.google.android.gms.common.internal.ImagesContract;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.starrynet.strategy.SysActionManager;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.Enumeration;
import zmq.ZMQ;
import zmq.io.net.Address;
import zmq.io.net.ProtocolFamily;
import zmq.io.net.StandardProtocolFamily;
import zmq.io.net.tcp.TcpAddress;
import zmq.util.Utils;

public class IpcAddress implements Address.IZAddress {

    /* renamed from: a  reason: collision with root package name */
    public String f3637a;
    public final InetSocketAddress b;
    public final SocketAddress c;

    public static class IpcAddressMask extends TcpAddress {
    }

    public IpcAddress(String str) {
        String[] split = str.split(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_VCARD);
        String str2 = split[0];
        boolean z = ZMQ.g;
        this.b = e(str2, z, true);
        if (split.length != 2 || "".equals(split[1])) {
            this.c = null;
        } else {
            this.c = e(split[1], z, true);
        }
    }

    public SocketAddress a() {
        return this.c;
    }

    public SocketAddress address() {
        return this.b;
    }

    public ProtocolFamily b() {
        return StandardProtocolFamily.INET;
    }

    public String c(int i) {
        if (!"*".equals(this.f3637a)) {
            return toString();
        }
        String k = Utils.k(i + SysActionManager.USER_NULL);
        return "ipc://" + k;
    }

    public final InetAddress d(boolean z, boolean z2) {
        Class cls = z ? Inet6Address.class : Inet4Address.class;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (nextElement.isLoopbackAddress() == z2 && cls.isInstance(nextElement)) {
                            return nextElement;
                        }
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("no address found ");
            sb.append(z ? "IPV6" : "IPV4");
            sb.append(z2 ? ImagesContract.LOCAL : "");
            throw new IllegalArgumentException(sb.toString());
        } catch (SocketException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public InetSocketAddress e(String str, boolean z, boolean z2) {
        int i;
        this.f3637a = str;
        int hashCode = str.hashCode();
        if ("*".equals(str)) {
            i = 0;
        } else {
            if (hashCode < 0) {
                hashCode = -hashCode;
            }
            i = (hashCode % 55536) + 10000;
        }
        return new InetSocketAddress(d(z, z2), i);
    }

    public String toString() {
        if (this.f3637a == null) {
            return "";
        }
        return "ipc://" + this.f3637a;
    }
}
