package org.zeromq;

import com.upuphone.runasone.uupcast.CaptureType;
import com.upuphone.xr.interconnect.api.SappAbilityAction;
import com.upuphone.xr.sapp.common.PermissionType;
import java.io.Closeable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.zeromq.ZActor;
import org.zeromq.ZMQ;
import org.zeromq.ZStar;
import org.zeromq.proto.ZNeedle;

public class ZMonitor implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public final ZAgent f3500a;
    public final ZStar.Exit b;

    public enum Event {
        CONNECTED(1),
        CONNECT_DELAYED(2),
        CONNECT_RETRIED(4),
        LISTENING(8),
        BIND_FAILED(16),
        ACCEPTED(32),
        ACCEPT_FAILED(64),
        CLOSED(128),
        CLOSE_FAILED(256),
        DISCONNECTED(512),
        MONITOR_STOPPED(1024),
        HANDSHAKE_FAILED_NO_DETAIL(2048),
        HANDSHAKE_SUCCEEDED(4096),
        HANDSHAKE_FAILED_PROTOCOL(8192),
        HANDSHAKE_FAILED_AUTH(16384),
        HANDSHAKE_PROTOCOL(32768),
        ALL(65535);
        
        private static final Map<Integer, Event> MAP = null;
        /* access modifiers changed from: private */
        public final int code;

        static {
            int i;
            MAP = new HashMap(values().length);
            for (Event event : values()) {
                MAP.put(Integer.valueOf(event.code), event);
            }
        }

        private Event(int i) {
            this.code = i;
        }

        public static Event findByCode(int i) {
            Map<Integer, Event> map = MAP;
            return map.containsKey(Integer.valueOf(i)) ? map.get(Integer.valueOf(i)) : ALL;
        }
    }

    public static class MonitorActor extends ZActor.SimpleActor {

        /* renamed from: a  reason: collision with root package name */
        public final ZMQ.Socket f3501a;
        public final String b;
        public ZMQ.Socket c;
        public int d;
        public boolean e;

        public boolean d(ZMQ.Socket socket, ZMQ.Socket socket2, ZPoller zPoller, int i) {
            ZMQ.Event d2 = ZMQ.Event.d(socket);
            int b2 = d2.b();
            String a2 = d2.a();
            Event findByCode = Event.findByCode(b2);
            ZMsg zMsg = new ZMsg();
            ZFrame zFrame = new ZFrame(new byte[(a2.length() + 9)]);
            ZNeedle zNeedle = new ZNeedle(zFrame);
            zNeedle.e(findByCode.ordinal());
            zNeedle.f(b2);
            zNeedle.h(a2);
            zMsg.add(zFrame);
            Object c2 = d2.c();
            if (c2 != null) {
                zMsg.a(c2.toString());
            }
            return zMsg.E(socket2, true);
        }

        public boolean e(ZMQ.Socket socket, ZPoller zPoller, int i) {
            String s = socket.s();
            if (s == null) {
                System.out.printf("ZMonitor: Closing monitor %s : No command%n", new Object[]{this.f3501a});
                return false;
            }
            char c2 = 65535;
            switch (s.hashCode()) {
                case -1895397068:
                    if (s.equals("REMOVE_EVENTS")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 64218584:
                    if (s.equals(SappAbilityAction.CLOSE)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 79219778:
                    if (s.equals("START")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 481161879:
                    if (s.equals("ADD_EVENTS")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1069090146:
                    if (s.equals("VERBOSE")) {
                        c2 = 4;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    return n(socket);
                case 1:
                    return l(zPoller, socket);
                case 2:
                    return o(zPoller, socket);
                case 3:
                    return k(socket);
                case 4:
                    this.e = Boolean.parseBoolean(socket.s());
                    return socket.v(PermissionType.OK);
                default:
                    System.out.printf("ZMonitor: Closing monitor %s : Unknown command %s%n", new Object[]{this.f3501a, s});
                    socket.v("ERROR");
                    return false;
            }
        }

        public String f(ZMQ.Socket socket) {
            return "ZMonitor-" + this.f3501a.toString();
        }

        public List g(ZContext zContext, Object... objArr) {
            ZMQ.Socket b2 = zContext.b(SocketType.PAIR);
            this.c = b2;
            return Collections.singletonList(b2);
        }

        public void j(ZMQ.Socket socket, List list, ZPoller zPoller) {
            socket.v(AbstractLifeCycle.STARTED);
        }

        public final boolean k(ZMQ.Socket socket) {
            ZMsg x = ZMsg.x(socket);
            if (x == null) {
                return false;
            }
            Iterator it = x.iterator();
            while (it.hasNext()) {
                Event valueOf = Event.valueOf(((ZFrame) it.next()).d(ZMQ.f));
                if (this.e) {
                    System.out.printf("ZMonitor: Adding event %s%n", new Object[]{valueOf});
                }
                this.d = valueOf.code | this.d;
            }
            return socket.v(PermissionType.OK);
        }

        public final boolean l(ZPoller zPoller, ZMQ.Socket socket) {
            boolean u = zPoller.u(this.c);
            String str = "Unable to unregister monitoring socket " + this.c;
            if (u) {
                str = "Unable to stop monitor socket " + this.f3501a;
                u = this.f3501a.n((String) null, this.d);
            }
            m("top", u, str);
            if (this.e) {
                System.out.printf("ZMonitor: Closing monitor %s%n", new Object[]{this.f3501a});
            }
            socket.v(u ? PermissionType.OK : "ERROR");
            return false;
        }

        public final void m(String str, boolean z, String str2) {
            if (!this.e) {
                return;
            }
            if (z) {
                System.out.printf("ZMonitor: S%s monitor for events %s on %s%n", new Object[]{str, Integer.valueOf(this.d), this.f3501a});
            } else {
                System.out.printf("ZMonitor: Unable to s%s monitor for events %s (%s) on %s%n", new Object[]{str, Integer.valueOf(this.d), str2, this.f3501a});
            }
        }

        public final boolean n(ZMQ.Socket socket) {
            ZMsg x = ZMsg.x(socket);
            if (x == null) {
                return false;
            }
            Iterator it = x.iterator();
            while (it.hasNext()) {
                Event valueOf = Event.valueOf(((ZFrame) it.next()).d(ZMQ.f));
                if (this.e) {
                    System.out.printf("ZMonitor: Removing event %s%n", new Object[]{valueOf});
                }
                this.d = (~valueOf.code) & this.d;
            }
            return socket.v(PermissionType.OK);
        }

        public final boolean o(ZPoller zPoller, ZMQ.Socket socket) {
            boolean n = this.f3501a.n(this.b, this.d);
            String str = "Unable to monitor socket " + this.f3501a;
            if (n) {
                str = "Unable to connect monitoring socket " + this.c;
                n = this.c.d(this.b);
            }
            if (n) {
                str = "Unable to poll monitoring socket " + this.c;
                n = zPoller.o(this.c, 1);
            }
            m("tart", n, str);
            if (n) {
                return socket.v(PermissionType.OK);
            }
            socket.v("ERROR");
            return false;
        }
    }

    public enum ProtocolCode {
        ZMQ_PROTOCOL_ERROR_ZMTP_UNSPECIFIED(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED),
        ZMQ_PROTOCOL_ERROR_ZMTP_UNEXPECTED_COMMAND(268435457),
        ZMQ_PROTOCOL_ERROR_ZMTP_INVALID_SEQUENCE(268435458),
        ZMQ_PROTOCOL_ERROR_ZMTP_KEY_EXCHANGE(268435459),
        ZMQ_PROTOCOL_ERROR_ZMTP_MALFORMED_COMMAND_UNSPECIFIED(268435473),
        ZMQ_PROTOCOL_ERROR_ZMTP_MALFORMED_COMMAND_MESSAGE(268435474),
        ZMQ_PROTOCOL_ERROR_ZMTP_MALFORMED_COMMAND_HELLO(268435475),
        ZMQ_PROTOCOL_ERROR_ZMTP_MALFORMED_COMMAND_INITIATE(268435476),
        ZMQ_PROTOCOL_ERROR_ZMTP_MALFORMED_COMMAND_ERROR(268435477),
        ZMQ_PROTOCOL_ERROR_ZMTP_MALFORMED_COMMAND_READY(268435478),
        ZMQ_PROTOCOL_ERROR_ZMTP_MALFORMED_COMMAND_WELCOME(268435479),
        ZMQ_PROTOCOL_ERROR_ZMTP_INVALID_METADATA(268435480),
        ZMQ_PROTOCOL_ERROR_ZMTP_CRYPTOGRAPHIC(285212673),
        ZMQ_PROTOCOL_ERROR_ZMTP_MECHANISM_MISMATCH(285212674),
        ZMQ_PROTOCOL_ERROR_ZAP_UNSPECIFIED(536870912),
        ZMQ_PROTOCOL_ERROR_ZAP_MALFORMED_REPLY(536870913),
        ZMQ_PROTOCOL_ERROR_ZAP_BAD_REQUEST_ID(536870914),
        ZMQ_PROTOCOL_ERROR_ZAP_BAD_VERSION(536870915),
        ZMQ_PROTOCOL_ERROR_ZAP_INVALID_STATUS_CODE(536870916),
        ZMQ_PROTOCOL_ERROR_ZAP_INVALID_METADATA(536870917),
        ZMQ_PROTOCOL_ERROR_WS_UNSPECIFIED(805306368);
        
        private static final Map<Integer, ProtocolCode> MAP = null;
        private final int code;

        static {
            int i;
            MAP = new HashMap(values().length);
            for (ProtocolCode protocolCode : values()) {
                MAP.put(Integer.valueOf(protocolCode.code), protocolCode);
            }
        }

        private ProtocolCode(int i) {
            this.code = i;
        }

        public static ProtocolCode findByCode(int i) {
            Map<Integer, ProtocolCode> map = MAP;
            if (map.containsKey(Integer.valueOf(i))) {
                return map.get(Integer.valueOf(i));
            }
            throw new IllegalArgumentException("Protocol code unknown: " + i);
        }
    }

    public static final class ZEvent {
        public static final Event[] e = Event.values();

        /* renamed from: a  reason: collision with root package name */
        public final Event f3502a;
        public final int b;
        public final String c;
        public final String d;

        public String toString() {
            return "ZEvent [type=" + this.f3502a + ", code=" + this.b + ", address=" + this.c + ", value=" + this.d + "]";
        }
    }

    public final void a() {
        this.f3500a.send(SappAbilityAction.CLOSE);
        this.b.b();
        this.f3500a.close();
    }

    public final void close() {
        a();
    }
}
