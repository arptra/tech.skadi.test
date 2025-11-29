package zmq.io.net.tcp;

import com.honey.account.constant.AccountConstantKt;
import com.meizu.common.widget.MzContactsContract;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import org.eclipse.jetty.util.StringUtil;
import org.zeromq.ZMQException;
import zmq.io.net.Address;
import zmq.io.net.ProtocolFamily;
import zmq.io.net.StandardProtocolFamily;

public class TcpAddress implements Address.IZAddress {

    /* renamed from: a  reason: collision with root package name */
    public final InetSocketAddress f3639a;
    public final SocketAddress b;

    public static class TcpAddressMask extends TcpAddress {
        public TcpAddressMask(String str, boolean z) {
            super(str, z);
        }

        public boolean e(SocketAddress socketAddress) {
            return address().equals(socketAddress);
        }
    }

    public TcpAddress(String str, boolean z) {
        String[] split = str.split(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_VCARD);
        this.f3639a = d(split[0], z, false);
        if (split.length != 2 || "".equals(split[1])) {
            this.b = null;
        } else {
            this.b = d(split[1], z, false);
        }
    }

    public SocketAddress a() {
        return this.b;
    }

    public SocketAddress address() {
        return this.f3639a;
    }

    public ProtocolFamily b() {
        return this.f3639a.getAddress() instanceof Inet6Address ? StandardProtocolFamily.INET6 : StandardProtocolFamily.INET;
    }

    public String c(int i) {
        InetSocketAddress inetSocketAddress = this.f3639a;
        if (inetSocketAddress == null) {
            return "";
        }
        int port = inetSocketAddress.getPort();
        if (port != 0) {
            i = port;
        }
        if (this.f3639a.getAddress() instanceof Inet6Address) {
            return "tcp://[" + this.f3639a.getAddress().getHostAddress() + "]:" + i;
        }
        return "tcp://" + this.f3639a.getAddress().getHostAddress() + AccountConstantKt.CODE_SEPARTOR + i;
    }

    public InetSocketAddress d(String str, boolean z, boolean z2) {
        int i;
        int lastIndexOf = str.lastIndexOf(58);
        if (lastIndexOf >= 0) {
            int i2 = 0;
            String substring = str.substring(0, lastIndexOf);
            String substring2 = str.substring(lastIndexOf + 1);
            if (substring.length() >= 2 && substring.charAt(0) == '[' && substring.charAt(substring.length() - 1) == ']') {
                substring = substring.substring(1, substring.length() - 1);
            }
            if (substring2.equals("*") || substring2.equals("0")) {
                i = 0;
            } else {
                i = Integer.parseInt(substring2);
                if (i == 0) {
                    throw new IllegalArgumentException(str);
                }
            }
            if (substring.equals("*")) {
                substring = z ? "::" : StringUtil.ALL_INTERFACES;
            }
            try {
                InetAddress[] allByName = InetAddress.getAllByName(substring);
                InetAddress inetAddress = null;
                if (!z) {
                    int length = allByName.length;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        }
                        InetAddress inetAddress2 = allByName[i2];
                        if (inetAddress2 instanceof Inet4Address) {
                            inetAddress = inetAddress2;
                            break;
                        }
                        i2++;
                    }
                } else {
                    int length2 = allByName.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length2) {
                            break;
                        }
                        InetAddress inetAddress3 = allByName[i3];
                        if (inetAddress3 instanceof Inet6Address) {
                            inetAddress = inetAddress3;
                            break;
                        }
                        i3++;
                    }
                    if (inetAddress == null) {
                        inetAddress = allByName[0];
                    }
                }
                if (inetAddress != null) {
                    return new InetSocketAddress(inetAddress, i);
                }
                throw new ZMQException(substring + " not found matching IPv4/IPv6 settings", 49);
            } catch (UnknownHostException e) {
                throw new ZMQException(e.getMessage(), 49, e);
            }
        } else {
            throw new IllegalArgumentException(str);
        }
    }

    public String toString() {
        return c(this.f3639a.getPort());
    }

    public TcpAddress(InetSocketAddress inetSocketAddress) {
        this.f3639a = inetSocketAddress;
        this.b = null;
    }
}
