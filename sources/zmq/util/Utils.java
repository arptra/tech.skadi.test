package zmq.util;

import com.honey.account.ad.a;
import java.lang.reflect.Array;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SocketChannel;
import java.security.SecureRandom;
import zmq.io.net.Address;
import zmq.io.net.tcp.TcpUtils;
import zmq.util.function.Supplier;

public class Utils {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadLocal f3673a = new ThreadLocal<SecureRandom>() {
        /* renamed from: a */
        public SecureRandom initialValue() {
            return new SecureRandom();
        }
    };

    public static void b(boolean z, String str) {
        c(z, new a(str));
    }

    public static void c(boolean z, Supplier supplier) {
        if (!z) {
            throw new IllegalArgumentException((String) supplier.get());
        }
    }

    public static Address d(SocketChannel socketChannel) {
        return new Address(socketChannel.socket().getRemoteSocketAddress());
    }

    public static /* synthetic */ String e(String str) {
        return str;
    }

    public static byte[] f(int i) {
        byte[] bArr = new byte[i];
        ((SecureRandom) f3673a.get()).nextBytes(bArr);
        return bArr;
    }

    public static int g() {
        return ((SecureRandom) f3673a.get()).nextInt();
    }

    public static byte[] h(byte[] bArr, int i) {
        byte[] bArr2 = new byte[i];
        if (bArr != null) {
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        }
        return bArr2;
    }

    public static Object[] i(Class cls, Object[] objArr, int i, boolean z) {
        Object[] objArr2;
        if (i > objArr.length) {
            objArr2 = (Object[]) Array.newInstance(cls, i);
            if (z) {
                System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
            } else {
                System.arraycopy(objArr, 0, objArr2, i - objArr.length, objArr.length);
            }
        } else if (i >= objArr.length) {
            return objArr;
        } else {
            objArr2 = (Object[]) Array.newInstance(cls, i);
            if (z) {
                System.arraycopy(objArr, objArr.length - i, objArr2, 0, i);
            } else {
                System.arraycopy(objArr, 0, objArr2, 0, i);
            }
        }
        return objArr2;
    }

    public static void j(SelectableChannel... selectableChannelArr) {
        TcpUtils.B(selectableChannelArr);
    }

    public static String k(int i) {
        return l(new StringBuilder(), i, 'z').toString();
    }

    public static StringBuilder l(StringBuilder sb, int i, char c) {
        int i2 = i / 31;
        int i3 = i % 31;
        if (i2 > c) {
            l(sb, i2, c);
        } else if (i2 != 0) {
            sb.append((char) i2);
        }
        sb.append((char) i3);
        return sb;
    }
}
