package org.java_websocket.drafts;

import com.honey.account.constant.AccountConstantKt;
import com.upuphone.runasone.channel.linker.websocket.WsUtil;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.enums.CloseHandshakeType;
import org.java_websocket.enums.HandshakeState;
import org.java_websocket.enums.Opcode;
import org.java_websocket.enums.Role;
import org.java_websocket.exceptions.IncompleteHandshakeException;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.framing.Framedata;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.ClientHandshakeBuilder;
import org.java_websocket.handshake.HandshakeBuilder;
import org.java_websocket.handshake.HandshakeImpl1Client;
import org.java_websocket.handshake.HandshakeImpl1Server;
import org.java_websocket.handshake.Handshakedata;
import org.java_websocket.handshake.ServerHandshake;
import org.java_websocket.handshake.ServerHandshakeBuilder;
import org.java_websocket.util.Charsetfunctions;
import sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationUtil;

public abstract class Draft {

    /* renamed from: a  reason: collision with root package name */
    public Role f3395a = null;
    public Opcode b = null;

    public static ByteBuffer p(ByteBuffer byteBuffer) {
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        byte b2 = 48;
        while (byteBuffer.hasRemaining()) {
            byte b3 = byteBuffer.get();
            allocate.put(b3);
            if (b2 == 13 && b3 == 10) {
                allocate.limit(allocate.position() - 2);
                allocate.position(0);
                return allocate;
            }
            b2 = b3;
        }
        byteBuffer.position(byteBuffer.position() - allocate.position());
        return null;
    }

    public static String q(ByteBuffer byteBuffer) {
        ByteBuffer p = p(byteBuffer);
        if (p == null) {
            return null;
        }
        return Charsetfunctions.d(p.array(), 0, p.limit());
    }

    public static HandshakeBuilder w(ByteBuffer byteBuffer, Role role) {
        String q = q(byteBuffer);
        if (q != null) {
            String[] split = q.split(" ", 3);
            if (split.length == 3) {
                HandshakeBuilder x = role == Role.CLIENT ? x(split, q) : y(split, q);
                String q2 = q(byteBuffer);
                while (q2 != null && q2.length() > 0) {
                    String[] split2 = q2.split(AccountConstantKt.CODE_SEPARTOR, 2);
                    if (split2.length == 2) {
                        if (x.g(split2[0])) {
                            String str = split2[0];
                            x.a(str, x.e(split2[0]) + "; " + split2[1].replaceFirst("^ +", ""));
                        } else {
                            x.a(split2[0], split2[1].replaceFirst("^ +", ""));
                        }
                        q2 = q(byteBuffer);
                    } else {
                        throw new InvalidHandshakeException("not an http header");
                    }
                }
                if (q2 != null) {
                    return x;
                }
                throw new IncompleteHandshakeException();
            }
            throw new InvalidHandshakeException();
        }
        throw new IncompleteHandshakeException(byteBuffer.capacity() + 128);
    }

    public static HandshakeBuilder x(String[] strArr, String str) {
        if (!FactorAuthenticationUtil.CODE_ERROR_TOKEN_NULL.equals(strArr[1])) {
            throw new InvalidHandshakeException(String.format("Invalid status code received: %s Status line: %s", new Object[]{strArr[1], str}));
        } else if ("HTTP/1.1".equalsIgnoreCase(strArr[0])) {
            HandshakeImpl1Server handshakeImpl1Server = new HandshakeImpl1Server();
            handshakeImpl1Server.j(Short.parseShort(strArr[1]));
            handshakeImpl1Server.d(strArr[2]);
            return handshakeImpl1Server;
        } else {
            throw new InvalidHandshakeException(String.format("Invalid status line received: %s Status line: %s", new Object[]{strArr[0], str}));
        }
    }

    public static HandshakeBuilder y(String[] strArr, String str) {
        if (!"GET".equalsIgnoreCase(strArr[0])) {
            throw new InvalidHandshakeException(String.format("Invalid request method received: %s Status line: %s", new Object[]{strArr[0], str}));
        } else if ("HTTP/1.1".equalsIgnoreCase(strArr[2])) {
            HandshakeImpl1Client handshakeImpl1Client = new HandshakeImpl1Client();
            handshakeImpl1Client.c(strArr[1]);
            return handshakeImpl1Client;
        } else {
            throw new InvalidHandshakeException(String.format("Invalid status line received: %s Status line: %s", new Object[]{strArr[2], str}));
        }
    }

    public abstract HandshakeState a(ClientHandshake clientHandshake, ServerHandshake serverHandshake);

    public abstract HandshakeState b(ClientHandshake clientHandshake);

    public boolean c(Handshakedata handshakedata) {
        return handshakedata.e("Upgrade").equalsIgnoreCase(WsUtil.WEB_SOCKET_PATH) && handshakedata.e("Connection").toLowerCase(Locale.ENGLISH).contains("upgrade");
    }

    public int d(int i) {
        if (i >= 0) {
            return i;
        }
        throw new InvalidDataException(1002, "Negative count");
    }

    public abstract Draft e();

    public abstract ByteBuffer f(Framedata framedata);

    public abstract List g(String str, boolean z);

    public abstract List h(ByteBuffer byteBuffer, boolean z);

    public List i(Handshakedata handshakedata) {
        return j(handshakedata, true);
    }

    public List j(Handshakedata handshakedata, boolean z) {
        StringBuilder sb = new StringBuilder(100);
        if (handshakedata instanceof ClientHandshake) {
            sb.append("GET ");
            sb.append(((ClientHandshake) handshakedata).h());
            sb.append(" HTTP/1.1");
        } else if (handshakedata instanceof ServerHandshake) {
            sb.append("HTTP/1.1 101 ");
            sb.append(((ServerHandshake) handshakedata).b());
        } else {
            throw new IllegalArgumentException("unknown role");
        }
        sb.append("\r\n");
        Iterator i = handshakedata.i();
        while (i.hasNext()) {
            String str = (String) i.next();
            String e = handshakedata.e(str);
            sb.append(str);
            sb.append(": ");
            sb.append(e);
            sb.append("\r\n");
        }
        sb.append("\r\n");
        byte[] a2 = Charsetfunctions.a(sb.toString());
        byte[] content = z ? handshakedata.getContent() : null;
        ByteBuffer allocate = ByteBuffer.allocate((content == null ? 0 : content.length) + a2.length);
        allocate.put(a2);
        if (content != null) {
            allocate.put(content);
        }
        allocate.flip();
        return Collections.singletonList(allocate);
    }

    public abstract CloseHandshakeType k();

    public Role l() {
        return this.f3395a;
    }

    public abstract ClientHandshakeBuilder m(ClientHandshakeBuilder clientHandshakeBuilder);

    public abstract HandshakeBuilder n(ClientHandshake clientHandshake, ServerHandshakeBuilder serverHandshakeBuilder);

    public abstract void o(WebSocketImpl webSocketImpl, Framedata framedata);

    public int r(Handshakedata handshakedata) {
        String e = handshakedata.e("Sec-WebSocket-Version");
        if (e.length() > 0) {
            try {
                return new Integer(e.trim()).intValue();
            } catch (NumberFormatException unused) {
            }
        }
        return -1;
    }

    public abstract void s();

    public void t(Role role) {
        this.f3395a = role;
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    public abstract List u(ByteBuffer byteBuffer);

    public Handshakedata v(ByteBuffer byteBuffer) {
        return w(byteBuffer, this.f3395a);
    }
}
