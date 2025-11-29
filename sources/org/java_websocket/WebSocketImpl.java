package org.java_websocket;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.enums.CloseHandshakeType;
import org.java_websocket.enums.HandshakeState;
import org.java_websocket.enums.ReadyState;
import org.java_websocket.enums.Role;
import org.java_websocket.exceptions.IncompleteHandshakeException;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.exceptions.LimitExceededException;
import org.java_websocket.exceptions.WebsocketNotConnectedException;
import org.java_websocket.framing.Framedata;
import org.java_websocket.framing.PingFrame;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.ClientHandshakeBuilder;
import org.java_websocket.handshake.Handshakedata;
import org.java_websocket.handshake.ServerHandshake;
import org.java_websocket.server.WebSocketServer;
import org.java_websocket.util.Charsetfunctions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebSocketImpl implements WebSocket {

    /* renamed from: a  reason: collision with root package name */
    public final Logger f3392a;
    public final BlockingQueue b;
    public final BlockingQueue c;
    public final WebSocketListener d;
    public SelectionKey e;
    public ByteChannel f;
    public WebSocketServer.WebSocketWorker g;
    public boolean h;
    public volatile ReadyState i;
    public List j;
    public Draft k;
    public Role l;
    public ByteBuffer m;
    public ClientHandshake n;
    public String o;
    public Integer p;
    public Boolean q;
    public String r;
    public long s;
    public final Object t;

    public WebSocketImpl(WebSocketListener webSocketListener, List list) {
        this(webSocketListener, (Draft) null);
        this.l = Role.SERVER;
        if (list == null || list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            this.j = arrayList;
            arrayList.add(new Draft_6455());
            return;
        }
        this.j = list;
    }

    public boolean A() {
        return this.h;
    }

    public boolean B() {
        return this.i == ReadyState.OPEN;
    }

    public final void C(Handshakedata handshakedata) {
        this.f3392a.trace("open using draft: {}", (Object) this.k);
        this.i = ReadyState.OPEN;
        M();
        try {
            this.d.o(this, handshakedata);
        } catch (RuntimeException e2) {
            this.d.f(this, e2);
        }
    }

    public void D(String str) {
        if (str != null) {
            F(this.k.g(str, this.l == Role.CLIENT));
            return;
        }
        throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
    }

    public void E(ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            F(this.k.h(byteBuffer, this.l == Role.CLIENT));
            return;
        }
        throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
    }

    public final void F(Collection collection) {
        if (!B()) {
            throw new WebsocketNotConnectedException();
        } else if (collection != null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                Framedata framedata = (Framedata) it.next();
                this.f3392a.trace("send frame: {}", (Object) framedata);
                arrayList.add(this.k.f(framedata));
            }
            O(arrayList);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void G(byte[] bArr) {
        E(ByteBuffer.wrap(bArr));
    }

    public void H() {
        PingFrame j2 = this.d.j(this);
        if (j2 != null) {
            c(j2);
            return;
        }
        throw new NullPointerException("onPreparePing(WebSocket) returned null. PingFrame to sent can't be null.");
    }

    public void I(ByteChannel byteChannel) {
        this.f = byteChannel;
    }

    public void J(SelectionKey selectionKey) {
        this.e = selectionKey;
    }

    public void K(WebSocketServer.WebSocketWorker webSocketWorker) {
        this.g = webSocketWorker;
    }

    public void L(ClientHandshakeBuilder clientHandshakeBuilder) {
        this.n = this.k.m(clientHandshakeBuilder);
        this.r = clientHandshakeBuilder.h();
        try {
            this.d.b(this, this.n);
            O(this.k.i(this.n));
        } catch (InvalidDataException unused) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        } catch (RuntimeException e2) {
            this.f3392a.error("Exception in startHandshake", (Throwable) e2);
            this.d.f(this, e2);
            throw new InvalidHandshakeException("rejected because of " + e2);
        }
    }

    public void M() {
        this.s = System.nanoTime();
    }

    public final void N(ByteBuffer byteBuffer) {
        this.f3392a.trace("write({}): {}", Integer.valueOf(byteBuffer.remaining()), byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array()));
        this.b.add(byteBuffer);
        this.d.d(this);
    }

    public final void O(List list) {
        synchronized (this.t) {
            try {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    N((ByteBuffer) it.next());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a() {
        p(1000);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0086, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void b(int r6, java.lang.String r7, boolean r8) {
        /*
            r5 = this;
            monitor-enter(r5)
            org.java_websocket.enums.ReadyState r0 = r5.i     // Catch:{ all -> 0x001f }
            org.java_websocket.enums.ReadyState r1 = org.java_websocket.enums.ReadyState.CLOSING     // Catch:{ all -> 0x001f }
            if (r0 == r1) goto L_0x0085
            org.java_websocket.enums.ReadyState r0 = r5.i     // Catch:{ all -> 0x001f }
            org.java_websocket.enums.ReadyState r2 = org.java_websocket.enums.ReadyState.CLOSED     // Catch:{ all -> 0x001f }
            if (r0 == r2) goto L_0x0085
            org.java_websocket.enums.ReadyState r0 = r5.i     // Catch:{ all -> 0x001f }
            org.java_websocket.enums.ReadyState r2 = org.java_websocket.enums.ReadyState.OPEN     // Catch:{ all -> 0x001f }
            r3 = 0
            if (r0 != r2) goto L_0x0068
            r0 = 1006(0x3ee, float:1.41E-42)
            if (r6 != r0) goto L_0x0021
            r5.i = r1     // Catch:{ all -> 0x001f }
            r5.n(r6, r7, r3)     // Catch:{ all -> 0x001f }
            monitor-exit(r5)
            return
        L_0x001f:
            r6 = move-exception
            goto L_0x0087
        L_0x0021:
            org.java_websocket.drafts.Draft r1 = r5.k     // Catch:{ all -> 0x001f }
            org.java_websocket.enums.CloseHandshakeType r1 = r1.k()     // Catch:{ all -> 0x001f }
            org.java_websocket.enums.CloseHandshakeType r2 = org.java_websocket.enums.CloseHandshakeType.NONE     // Catch:{ all -> 0x001f }
            if (r1 == r2) goto L_0x0064
            if (r8 != 0) goto L_0x003b
            org.java_websocket.WebSocketListener r1 = r5.d     // Catch:{ RuntimeException -> 0x0035 }
            r1.e(r5, r6, r7)     // Catch:{ RuntimeException -> 0x0035 }
            goto L_0x003b
        L_0x0033:
            r1 = move-exception
            goto L_0x0053
        L_0x0035:
            r1 = move-exception
            org.java_websocket.WebSocketListener r2 = r5.d     // Catch:{ InvalidDataException -> 0x0033 }
            r2.f(r5, r1)     // Catch:{ InvalidDataException -> 0x0033 }
        L_0x003b:
            boolean r1 = r5.B()     // Catch:{ InvalidDataException -> 0x0033 }
            if (r1 == 0) goto L_0x0064
            org.java_websocket.framing.CloseFrame r1 = new org.java_websocket.framing.CloseFrame     // Catch:{ InvalidDataException -> 0x0033 }
            r1.<init>()     // Catch:{ InvalidDataException -> 0x0033 }
            r1.r(r7)     // Catch:{ InvalidDataException -> 0x0033 }
            r1.q(r6)     // Catch:{ InvalidDataException -> 0x0033 }
            r1.h()     // Catch:{ InvalidDataException -> 0x0033 }
            r5.c(r1)     // Catch:{ InvalidDataException -> 0x0033 }
            goto L_0x0064
        L_0x0053:
            org.slf4j.Logger r2 = r5.f3392a     // Catch:{ all -> 0x001f }
            java.lang.String r4 = "generated frame is invalid"
            r2.error((java.lang.String) r4, (java.lang.Throwable) r1)     // Catch:{ all -> 0x001f }
            org.java_websocket.WebSocketListener r2 = r5.d     // Catch:{ all -> 0x001f }
            r2.f(r5, r1)     // Catch:{ all -> 0x001f }
            java.lang.String r1 = "generated frame is invalid"
            r5.n(r0, r1, r3)     // Catch:{ all -> 0x001f }
        L_0x0064:
            r5.n(r6, r7, r8)     // Catch:{ all -> 0x001f }
            goto L_0x007c
        L_0x0068:
            r0 = -3
            if (r6 != r0) goto L_0x0070
            r6 = 1
            r5.n(r0, r7, r6)     // Catch:{ all -> 0x001f }
            goto L_0x007c
        L_0x0070:
            r0 = 1002(0x3ea, float:1.404E-42)
            if (r6 != r0) goto L_0x0078
            r5.n(r6, r7, r8)     // Catch:{ all -> 0x001f }
            goto L_0x007c
        L_0x0078:
            r6 = -1
            r5.n(r6, r7, r3)     // Catch:{ all -> 0x001f }
        L_0x007c:
            org.java_websocket.enums.ReadyState r6 = org.java_websocket.enums.ReadyState.CLOSING     // Catch:{ all -> 0x001f }
            r5.i = r6     // Catch:{ all -> 0x001f }
            r6 = 0
            r5.m = r6     // Catch:{ all -> 0x001f }
            monitor-exit(r5)
            return
        L_0x0085:
            monitor-exit(r5)
            return
        L_0x0087:
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.java_websocket.WebSocketImpl.b(int, java.lang.String, boolean):void");
    }

    public void c(Framedata framedata) {
        F(Collections.singletonList(framedata));
    }

    public void close(int i2, String str) {
        b(i2, str, false);
    }

    public void d(InvalidDataException invalidDataException) {
        b(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    public void e() {
        if (this.q != null) {
            f(this.p.intValue(), this.o, this.q.booleanValue());
            return;
        }
        throw new IllegalStateException("this method must be used in conjunction with flushAndClose");
    }

    public synchronized void f(int i2, String str, boolean z) {
        try {
            if (this.i != ReadyState.CLOSED) {
                if (this.i == ReadyState.OPEN && i2 == 1006) {
                    this.i = ReadyState.CLOSING;
                }
                SelectionKey selectionKey = this.e;
                if (selectionKey != null) {
                    selectionKey.cancel();
                }
                ByteChannel byteChannel = this.f;
                if (byteChannel != null) {
                    byteChannel.close();
                }
                try {
                    this.d.h(this, i2, str, z);
                } catch (RuntimeException e2) {
                    this.d.f(this, e2);
                }
                Draft draft = this.k;
                if (draft != null) {
                    draft.s();
                }
                this.n = null;
                this.i = ReadyState.CLOSED;
            }
        } catch (IOException e3) {
            if (e3.getMessage() == null || !e3.getMessage().equals("Broken pipe")) {
                this.f3392a.error("Exception during channel.close()", (Throwable) e3);
                this.d.f(this, e3);
            } else {
                this.f3392a.trace("Caught IOException: Broken pipe during closeConnection()", (Throwable) e3);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void g(int i2, boolean z) {
        f(i2, "", z);
    }

    public final void h(RuntimeException runtimeException) {
        N(o(500));
        n(-1, runtimeException.getMessage(), false);
    }

    public final void i(InvalidDataException invalidDataException) {
        N(o(404));
        n(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    public void j(ByteBuffer byteBuffer) {
        this.f3392a.trace("process({}): ({})", Integer.valueOf(byteBuffer.remaining()), byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining()));
        if (this.i != ReadyState.NOT_YET_CONNECTED) {
            if (this.i == ReadyState.OPEN) {
                k(byteBuffer);
            }
        } else if (l(byteBuffer) && !z() && !y()) {
            if (byteBuffer.hasRemaining()) {
                k(byteBuffer);
            } else if (this.m.hasRemaining()) {
                k(this.m);
            }
        }
    }

    public final void k(ByteBuffer byteBuffer) {
        try {
            for (Framedata framedata : this.k.u(byteBuffer)) {
                this.f3392a.trace("matched frame: {}", (Object) framedata);
                this.k.o(this, framedata);
            }
        } catch (LimitExceededException e2) {
            if (e2.getLimit() == Integer.MAX_VALUE) {
                this.f3392a.error("Closing due to invalid size of frame", (Throwable) e2);
                this.d.f(this, e2);
            }
            d(e2);
        } catch (InvalidDataException e3) {
            this.f3392a.error("Closing due to invalid data in frame", (Throwable) e3);
            this.d.f(this, e3);
            d(e3);
        } catch (LinkageError | ThreadDeath | VirtualMachineError e4) {
            this.f3392a.error("Got fatal error during frame processing");
            throw e4;
        } catch (Error e5) {
            this.f3392a.error("Closing web socket due to an error during frame processing");
            this.d.f(this, new Exception(e5));
            close(1011, "Got error " + e5.getClass().getName());
        }
    }

    public final boolean l(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        if (this.m.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.m.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.m.capacity() + byteBuffer.remaining());
                this.m.flip();
                allocate.put(this.m);
                this.m = allocate;
            }
            this.m.put(byteBuffer);
            this.m.flip();
            byteBuffer2 = this.m;
        }
        byteBuffer2.mark();
        try {
            Role role = this.l;
            if (role == Role.SERVER) {
                Draft draft = this.k;
                if (draft == null) {
                    for (Draft e2 : this.j) {
                        Draft e3 = e2.e();
                        try {
                            e3.t(this.l);
                            byteBuffer2.reset();
                            Handshakedata v = e3.v(byteBuffer2);
                            if (!(v instanceof ClientHandshake)) {
                                this.f3392a.trace("Closing due to wrong handshake");
                                i(new InvalidDataException(1002, "wrong http function"));
                                return false;
                            }
                            ClientHandshake clientHandshake = (ClientHandshake) v;
                            if (e3.b(clientHandshake) == HandshakeState.MATCHED) {
                                this.r = clientHandshake.h();
                                try {
                                    O(e3.i(e3.n(clientHandshake, this.d.k(this, e3, clientHandshake))));
                                    this.k = e3;
                                    C(clientHandshake);
                                    return true;
                                } catch (InvalidDataException e4) {
                                    this.f3392a.trace("Closing due to wrong handshake. Possible handshake rejection", (Throwable) e4);
                                    i(e4);
                                    return false;
                                } catch (RuntimeException e5) {
                                    this.f3392a.error("Closing due to internal server error", (Throwable) e5);
                                    this.d.f(this, e5);
                                    h(e5);
                                    return false;
                                }
                            } else {
                                continue;
                            }
                        } catch (InvalidHandshakeException unused) {
                        }
                    }
                    if (this.k == null) {
                        this.f3392a.trace("Closing due to protocol error: no draft matches");
                        i(new InvalidDataException(1002, "no draft matches"));
                    }
                    return false;
                }
                Handshakedata v2 = draft.v(byteBuffer2);
                if (!(v2 instanceof ClientHandshake)) {
                    this.f3392a.trace("Closing due to protocol error: wrong http function");
                    n(1002, "wrong http function", false);
                    return false;
                }
                ClientHandshake clientHandshake2 = (ClientHandshake) v2;
                if (this.k.b(clientHandshake2) == HandshakeState.MATCHED) {
                    C(clientHandshake2);
                    return true;
                }
                this.f3392a.trace("Closing due to protocol error: the handshake did finally not match");
                close(1002, "the handshake did finally not match");
                return false;
            }
            if (role == Role.CLIENT) {
                this.k.t(role);
                Handshakedata v3 = this.k.v(byteBuffer2);
                if (!(v3 instanceof ServerHandshake)) {
                    this.f3392a.trace("Closing due to protocol error: wrong http function");
                    n(1002, "wrong http function", false);
                    return false;
                }
                ServerHandshake serverHandshake = (ServerHandshake) v3;
                if (this.k.a(this.n, serverHandshake) == HandshakeState.MATCHED) {
                    try {
                        this.d.l(this, this.n, serverHandshake);
                        C(serverHandshake);
                        return true;
                    } catch (InvalidDataException e6) {
                        this.f3392a.trace("Closing due to invalid data exception. Possible handshake rejection", (Throwable) e6);
                        n(e6.getCloseCode(), e6.getMessage(), false);
                        return false;
                    } catch (RuntimeException e7) {
                        this.f3392a.error("Closing since client was never connected", (Throwable) e7);
                        this.d.f(this, e7);
                        n(-1, e7.getMessage(), false);
                        return false;
                    }
                } else {
                    this.f3392a.trace("Closing due to protocol error: draft {} refuses handshake", (Object) this.k);
                    close(1002, "draft " + this.k + " refuses handshake");
                }
            }
            return false;
        } catch (InvalidHandshakeException e8) {
            try {
                this.f3392a.trace("Closing due to invalid handshake", (Throwable) e8);
                d(e8);
            } catch (IncompleteHandshakeException e9) {
                if (this.m.capacity() == 0) {
                    byteBuffer2.reset();
                    int preferredSize = e9.getPreferredSize();
                    if (preferredSize == 0) {
                        preferredSize = byteBuffer2.capacity() + 16;
                    }
                    ByteBuffer allocate2 = ByteBuffer.allocate(preferredSize);
                    this.m = allocate2;
                    allocate2.put(byteBuffer);
                } else {
                    ByteBuffer byteBuffer3 = this.m;
                    byteBuffer3.position(byteBuffer3.limit());
                    ByteBuffer byteBuffer4 = this.m;
                    byteBuffer4.limit(byteBuffer4.capacity());
                }
            }
        }
    }

    public void m() {
        if (this.i == ReadyState.NOT_YET_CONNECTED) {
            g(-1, true);
        } else if (this.h) {
            f(this.p.intValue(), this.o, this.q.booleanValue());
        } else if (this.k.k() == CloseHandshakeType.NONE) {
            g(1000, true);
        } else if (this.k.k() != CloseHandshakeType.ONEWAY) {
            g(1006, true);
        } else if (this.l == Role.SERVER) {
            g(1006, true);
        } else {
            g(1000, true);
        }
    }

    public synchronized void n(int i2, String str, boolean z) {
        if (!this.h) {
            this.p = Integer.valueOf(i2);
            this.o = str;
            this.q = Boolean.valueOf(z);
            this.h = true;
            this.d.d(this);
            try {
                this.d.a(this, i2, str, z);
            } catch (RuntimeException e2) {
                this.f3392a.error("Exception in onWebsocketClosing", (Throwable) e2);
                this.d.f(this, e2);
            }
            Draft draft = this.k;
            if (draft != null) {
                draft.s();
            }
            this.n = null;
        }
    }

    public final ByteBuffer o(int i2) {
        String str = i2 != 404 ? "500 Internal Server Error" : "404 WebSocket Upgrade Failure";
        return ByteBuffer.wrap(Charsetfunctions.a("HTTP/1.1 " + str + "\r\nContent-Type: text/html\r\nServer: TooTallNate Java-WebSocket\r\nContent-Length: " + (str.length() + 48) + "\r\n\r\n<html><head></head><body><h1>" + str + "</h1></body></html>"));
    }

    public void p(int i2) {
        b(i2, "", false);
    }

    public void q(int i2, String str) {
        f(i2, str, false);
    }

    public ByteChannel r() {
        return this.f;
    }

    public Draft s() {
        return this.k;
    }

    public long t() {
        return this.s;
    }

    public String toString() {
        return super.toString();
    }

    public ReadyState u() {
        return this.i;
    }

    public SelectionKey v() {
        return this.e;
    }

    public WebSocketListener w() {
        return this.d;
    }

    public WebSocketServer.WebSocketWorker x() {
        return this.g;
    }

    public boolean y() {
        return this.i == ReadyState.CLOSED;
    }

    public boolean z() {
        return this.i == ReadyState.CLOSING;
    }

    public WebSocketImpl(WebSocketListener webSocketListener, Draft draft) {
        this.f3392a = LoggerFactory.k(WebSocketImpl.class);
        this.h = false;
        this.i = ReadyState.NOT_YET_CONNECTED;
        this.k = null;
        this.m = ByteBuffer.allocate(0);
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = System.nanoTime();
        this.t = new Object();
        if (webSocketListener == null || (draft == null && this.l == Role.SERVER)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.b = new LinkedBlockingQueue();
        this.c = new LinkedBlockingQueue();
        this.d = webSocketListener;
        this.l = Role.CLIENT;
        if (draft != null) {
            this.k = draft.e();
        }
    }
}
