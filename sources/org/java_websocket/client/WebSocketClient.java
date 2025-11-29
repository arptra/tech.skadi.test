package org.java_websocket.client;

import com.honey.account.constant.AccountConstantKt;
import io.netty.handler.ssl.SslProtocols;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import org.java_websocket.AbstractWebSocket;
import org.java_websocket.WebSocket;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.WebSocketListener;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.framing.Framedata;
import org.java_websocket.handshake.HandshakeImpl1Client;
import org.java_websocket.handshake.Handshakedata;
import org.java_websocket.handshake.ServerHandshake;

public abstract class WebSocketClient extends AbstractWebSocket implements Runnable, WebSocket {
    public URI j;
    public WebSocketImpl k;
    public Socket l;
    public SocketFactory m;
    public OutputStream n;
    public Proxy o;
    public Thread p;
    public Thread q;
    public Draft r;
    public Map s;
    public CountDownLatch t;
    public CountDownLatch u;
    public int v;
    public DnsResolver w;

    public class WebsocketWriteThread implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final WebSocketClient f3394a;

        public WebsocketWriteThread(WebSocketClient webSocketClient) {
            this.f3394a = webSocketClient;
        }

        public final void a() {
            try {
                if (WebSocketClient.this.l != null) {
                    WebSocketClient.this.l.close();
                }
            } catch (IOException e) {
                WebSocketClient.this.f(this.f3394a, e);
            }
        }

        public final void b() {
            while (!Thread.interrupted()) {
                try {
                    ByteBuffer byteBuffer = (ByteBuffer) WebSocketClient.this.k.b.take();
                    WebSocketClient.this.n.write(byteBuffer.array(), 0, byteBuffer.limit());
                    WebSocketClient.this.n.flush();
                } catch (InterruptedException unused) {
                    for (ByteBuffer byteBuffer2 : WebSocketClient.this.k.b) {
                        WebSocketClient.this.n.write(byteBuffer2.array(), 0, byteBuffer2.limit());
                        WebSocketClient.this.n.flush();
                    }
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }

        public void run() {
            Thread currentThread = Thread.currentThread();
            currentThread.setName("WebSocketWriteThread-" + Thread.currentThread().getId());
            try {
                b();
            } catch (IOException e) {
                WebSocketClient.this.S(e);
            } catch (Throwable th) {
                a();
                Thread unused = WebSocketClient.this.p = null;
                throw th;
            }
            a();
            Thread unused2 = WebSocketClient.this.p = null;
        }
    }

    public WebSocketClient(URI uri) {
        this(uri, new Draft_6455());
    }

    public void K(String str, String str2) {
        if (this.s == null) {
            this.s = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        }
        this.s.put(str, str2);
    }

    public void L() {
        if (this.p != null) {
            this.k.p(1000);
        }
    }

    public void M() {
        L();
        this.u.await();
    }

    public void N() {
        if (this.q == null) {
            Thread thread = new Thread(this);
            this.q = thread;
            thread.setName("WebSocketConnectReadThread-" + this.q.getId());
            this.q.start();
            return;
        }
        throw new IllegalStateException("WebSocketClient objects are not reuseable");
    }

    public boolean O() {
        N();
        this.t.await();
        return this.k.B();
    }

    public boolean P(long j2, TimeUnit timeUnit) {
        N();
        return this.t.await(j2, timeUnit) && this.k.B();
    }

    public WebSocket Q() {
        return this.k;
    }

    public final int R() {
        int port = this.j.getPort();
        String scheme = this.j.getScheme();
        if ("wss".equals(scheme)) {
            if (port == -1) {
                return 443;
            }
            return port;
        } else if (!"ws".equals(scheme)) {
            throw new IllegalArgumentException("unknown scheme: " + scheme);
        } else if (port == -1) {
            return 80;
        } else {
            return port;
        }
    }

    public final void S(IOException iOException) {
        if (iOException instanceof SSLException) {
            Z(iOException);
        }
        this.k.m();
    }

    public boolean T() {
        return this.k.y();
    }

    public boolean U() {
        return this.k.z();
    }

    public boolean V() {
        return this.k.B();
    }

    public abstract void W(int i, String str, boolean z);

    public void X(int i, String str) {
    }

    public void Y(int i, String str, boolean z) {
    }

    public abstract void Z(Exception exc);

    public void a(WebSocket webSocket, int i, String str, boolean z) {
        Y(i, str, z);
    }

    public abstract void a0(String str);

    public void b0(ByteBuffer byteBuffer) {
    }

    public void c(Framedata framedata) {
        this.k.c(framedata);
    }

    public abstract void c0(ServerHandshake serverHandshake);

    public void close(int i, String str) {
        this.k.close(i, str);
    }

    public final void d(WebSocket webSocket) {
    }

    public void d0(SSLParameters sSLParameters) {
        sSLParameters.setEndpointIdentificationAlgorithm("HTTPS");
    }

    public void e(WebSocket webSocket, int i, String str) {
        X(i, str);
    }

    public final boolean e0() {
        if (this.o != Proxy.NO_PROXY) {
            this.l = new Socket(this.o);
            return true;
        }
        SocketFactory socketFactory = this.m;
        if (socketFactory != null) {
            this.l = socketFactory.createSocket();
        } else {
            Socket socket = this.l;
            if (socket == null) {
                this.l = new Socket(this.o);
                return true;
            } else if (socket.isClosed()) {
                throw new IOException();
            }
        }
        return false;
    }

    public final void f(WebSocket webSocket, Exception exc) {
        Z(exc);
    }

    public boolean f0() {
        g0();
        return O();
    }

    public final void g(WebSocket webSocket, String str) {
        a0(str);
    }

    public final void g0() {
        Thread currentThread = Thread.currentThread();
        if (currentThread == this.p || currentThread == this.q) {
            throw new IllegalStateException("You cannot initialize a reconnect out of the websocket thread. Use reconnect in another thread to ensure a successful cleanup.");
        }
        try {
            M();
            Thread thread = this.p;
            if (thread != null) {
                thread.interrupt();
                this.p = null;
            }
            Thread thread2 = this.q;
            if (thread2 != null) {
                thread2.interrupt();
                this.q = null;
            }
            this.r.s();
            Socket socket = this.l;
            if (socket != null) {
                socket.close();
                this.l = null;
            }
            this.t = new CountDownLatch(1);
            this.u = new CountDownLatch(1);
            this.k = new WebSocketImpl((WebSocketListener) this, this.r);
        } catch (Exception e) {
            Z(e);
            this.k.q(1006, e.getMessage());
        }
    }

    public final void h(WebSocket webSocket, int i, String str, boolean z) {
        E();
        Thread thread = this.p;
        if (thread != null) {
            thread.interrupt();
        }
        W(i, str, z);
        this.t.countDown();
        this.u.countDown();
    }

    public void h0(String str) {
        this.k.D(str);
    }

    public final void i(WebSocket webSocket, ByteBuffer byteBuffer) {
        b0(byteBuffer);
    }

    public void i0(byte[] bArr) {
        this.k.G(bArr);
    }

    public final void j0() {
        String str;
        String rawPath = this.j.getRawPath();
        String rawQuery = this.j.getRawQuery();
        if (rawPath == null || rawPath.length() == 0) {
            rawPath = "/";
        }
        if (rawQuery != null) {
            rawPath = rawPath + '?' + rawQuery;
        }
        int R = R();
        StringBuilder sb = new StringBuilder();
        sb.append(this.j.getHost());
        if (R == 80 || R == 443) {
            str = "";
        } else {
            str = AccountConstantKt.CODE_SEPARTOR + R;
        }
        sb.append(str);
        String sb2 = sb.toString();
        HandshakeImpl1Client handshakeImpl1Client = new HandshakeImpl1Client();
        handshakeImpl1Client.c(rawPath);
        handshakeImpl1Client.a("Host", sb2);
        Map map = this.s;
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                handshakeImpl1Client.a((String) entry.getKey(), (String) entry.getValue());
            }
        }
        this.k.L(handshakeImpl1Client);
    }

    public final void k0() {
        SSLSocketFactory sSLSocketFactory;
        SocketFactory socketFactory = this.m;
        if (socketFactory instanceof SSLSocketFactory) {
            sSLSocketFactory = (SSLSocketFactory) socketFactory;
        } else {
            SSLContext instance = SSLContext.getInstance(SslProtocols.TLS_v1_2);
            instance.init((KeyManager[]) null, (TrustManager[]) null, (SecureRandom) null);
            sSLSocketFactory = instance.getSocketFactory();
        }
        this.l = sSLSocketFactory.createSocket(this.l, this.j.getHost(), R(), true);
    }

    public final void o(WebSocket webSocket, Handshakedata handshakedata) {
        D();
        c0((ServerHandshake) handshakedata);
        this.t.countDown();
    }

    public void p(int i) {
        this.k.p(i);
    }

    public void q(int i, String str) {
        this.k.q(i, str);
    }

    public void run() {
        int read;
        try {
            boolean e0 = e0();
            this.l.setTcpNoDelay(y());
            this.l.setReuseAddress(x());
            if (!this.l.isConnected()) {
                this.l.connect(this.w == null ? InetSocketAddress.createUnresolved(this.j.getHost(), R()) : new InetSocketAddress(this.w.a(this.j), R()), this.v);
            }
            if (e0 && "wss".equals(this.j.getScheme())) {
                k0();
            }
            Socket socket = this.l;
            if (socket instanceof SSLSocket) {
                SSLSocket sSLSocket = (SSLSocket) socket;
                SSLParameters sSLParameters = sSLSocket.getSSLParameters();
                d0(sSLParameters);
                sSLSocket.setSSLParameters(sSLParameters);
            }
            InputStream inputStream = this.l.getInputStream();
            this.n = this.l.getOutputStream();
            j0();
            Thread thread = new Thread(new WebsocketWriteThread(this));
            this.p = thread;
            thread.start();
            byte[] bArr = new byte[16384];
            while (!U() && !T() && (read = inputStream.read(bArr)) != -1) {
                try {
                    this.k.j(ByteBuffer.wrap(bArr, 0, read));
                } catch (IOException e) {
                    S(e);
                } catch (RuntimeException e2) {
                    Z(e2);
                    this.k.q(1006, e2.getMessage());
                }
            }
            this.k.m();
            this.q = null;
        } catch (Exception e3) {
            f(this.k, e3);
            this.k.q(-1, e3.getMessage());
        } catch (InternalError e4) {
            if (!(e4.getCause() instanceof InvocationTargetException) || !(e4.getCause().getCause() instanceof IOException)) {
                throw e4;
            }
            IOException iOException = (IOException) e4.getCause().getCause();
            f(this.k, iOException);
            this.k.q(-1, iOException.getMessage());
        }
    }

    public Collection w() {
        return Collections.singletonList(this.k);
    }

    public WebSocketClient(URI uri, Draft draft) {
        this(uri, draft, (Map) null, 0);
    }

    public WebSocketClient(URI uri, Draft draft, Map map, int i) {
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.o = Proxy.NO_PROXY;
        this.t = new CountDownLatch(1);
        this.u = new CountDownLatch(1);
        this.v = 0;
        this.w = null;
        if (uri == null) {
            throw new IllegalArgumentException();
        } else if (draft != null) {
            this.j = uri;
            this.r = draft;
            this.w = new DnsResolver() {
                public InetAddress a(URI uri) {
                    return InetAddress.getByName(uri.getHost());
                }
            };
            if (map != null) {
                TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                this.s = treeMap;
                treeMap.putAll(map);
            }
            this.v = i;
            C(false);
            B(false);
            this.k = new WebSocketImpl((WebSocketListener) this, draft);
        } else {
            throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
        }
    }
}
