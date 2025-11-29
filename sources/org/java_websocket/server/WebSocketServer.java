package org.java_websocket.server;

import java.io.IOException;
import java.lang.Thread;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.java_websocket.AbstractWebSocket;
import org.java_websocket.SocketChannelIOHelper;
import org.java_websocket.WebSocket;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.WebSocketServerFactory;
import org.java_websocket.WrappedByteChannel;
import org.java_websocket.exceptions.WrappedIOException;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.Handshakedata;
import org.slf4j.Logger;

public abstract class WebSocketServer extends AbstractWebSocket implements Runnable {
    public static final int y = Runtime.getRuntime().availableProcessors();
    public final Logger j;
    public final Collection k;
    public final InetSocketAddress l;
    public ServerSocketChannel m;
    public Selector n;
    public List o;
    public Thread p;
    public final AtomicBoolean q;
    public List r;
    public List s;
    public BlockingQueue t;
    public int u;
    public final AtomicInteger v;
    public WebSocketServerFactory w;
    public int x;

    public class WebSocketWorker extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public BlockingQueue f3404a;
        public final /* synthetic */ WebSocketServer b;

        /* renamed from: org.java_websocket.server.WebSocketServer$WebSocketWorker$1  reason: invalid class name */
        class AnonymousClass1 implements Thread.UncaughtExceptionHandler {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ WebSocketWorker f3405a;

            public void uncaughtException(Thread thread, Throwable th) {
                this.f3405a.b.j.error("Uncaught exception in thread {}: {}", thread.getName(), th);
            }
        }

        public final void a(WebSocketImpl webSocketImpl, ByteBuffer byteBuffer) {
            try {
                webSocketImpl.j(byteBuffer);
            } catch (Exception e) {
                this.b.j.error("Error while reading from remote connection", (Throwable) e);
            } catch (Throwable th) {
                this.b.e0(byteBuffer);
                throw th;
            }
            this.b.e0(byteBuffer);
        }

        public void b(WebSocketImpl webSocketImpl) {
            this.f3404a.put(webSocketImpl);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
            r6.b.f(r1, new java.lang.Exception(r0));
            r1.a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x005c, code lost:
            java.lang.Thread.currentThread().interrupt();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0015, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0017, code lost:
            r0 = e;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0034  */
        /* JADX WARNING: Removed duplicated region for block: B:16:? A[ExcHandler: InterruptedException (unused java.lang.InterruptedException), SYNTHETIC, Splitter:B:1:0x0001] */
        /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r6 = this;
            L_0x0000:
                r0 = 0
                java.util.concurrent.BlockingQueue r1 = r6.f3404a     // Catch:{ InterruptedException -> 0x005c, LinkageError | ThreadDeath | VirtualMachineError -> 0x001e, all -> 0x0019 }
                java.lang.Object r1 = r1.take()     // Catch:{ InterruptedException -> 0x005c, LinkageError | ThreadDeath | VirtualMachineError -> 0x001e, all -> 0x0019 }
                org.java_websocket.WebSocketImpl r1 = (org.java_websocket.WebSocketImpl) r1     // Catch:{ InterruptedException -> 0x005c, LinkageError | ThreadDeath | VirtualMachineError -> 0x001e, all -> 0x0019 }
                java.util.concurrent.BlockingQueue r0 = r1.c     // Catch:{ InterruptedException -> 0x005c, LinkageError | ThreadDeath | VirtualMachineError -> 0x0017, all -> 0x0015 }
                java.lang.Object r0 = r0.poll()     // Catch:{ InterruptedException -> 0x005c, LinkageError | ThreadDeath | VirtualMachineError -> 0x0017, all -> 0x0015 }
                java.nio.ByteBuffer r0 = (java.nio.ByteBuffer) r0     // Catch:{ InterruptedException -> 0x005c, LinkageError | ThreadDeath | VirtualMachineError -> 0x0017, all -> 0x0015 }
                r6.a(r1, r0)     // Catch:{ InterruptedException -> 0x005c, LinkageError | ThreadDeath | VirtualMachineError -> 0x0017, all -> 0x0015 }
                goto L_0x0000
            L_0x0015:
                r0 = move-exception
                goto L_0x0023
            L_0x0017:
                r0 = move-exception
                goto L_0x0042
            L_0x0019:
                r1 = move-exception
                r5 = r1
                r1 = r0
                r0 = r5
                goto L_0x0023
            L_0x001e:
                r1 = move-exception
                r5 = r1
                r1 = r0
                r0 = r5
                goto L_0x0042
            L_0x0023:
                org.java_websocket.server.WebSocketServer r2 = r6.b
                org.slf4j.Logger r2 = r2.j
                java.lang.String r3 = "Uncaught exception in thread {}: {}"
                java.lang.String r4 = r6.getName()
                r2.error(r3, r4, r0)
                if (r1 == 0) goto L_0x0063
                java.lang.Exception r2 = new java.lang.Exception
                r2.<init>(r0)
                org.java_websocket.server.WebSocketServer r6 = r6.b
                r6.f(r1, r2)
                r1.a()
                goto L_0x0063
            L_0x0042:
                org.java_websocket.server.WebSocketServer r2 = r6.b
                org.slf4j.Logger r2 = r2.j
                java.lang.String r3 = "Got fatal error in worker thread {}"
                java.lang.String r4 = r6.getName()
                r2.error((java.lang.String) r3, (java.lang.Object) r4)
                java.lang.Exception r2 = new java.lang.Exception
                r2.<init>(r0)
                org.java_websocket.server.WebSocketServer r6 = r6.b
                r6.T(r1, r2)
                goto L_0x0063
            L_0x005c:
                java.lang.Thread r6 = java.lang.Thread.currentThread()
                r6.interrupt()
            L_0x0063:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.java_websocket.server.WebSocketServer.WebSocketWorker.run():void");
        }
    }

    public boolean I(WebSocket webSocket) {
        boolean add;
        if (!this.q.get()) {
            synchronized (this.k) {
                add = this.k.add(webSocket);
            }
            return add;
        }
        webSocket.p(1001);
        return true;
    }

    public void J(WebSocket webSocket) {
        if (this.v.get() < (this.r.size() * 2) + 1) {
            this.v.incrementAndGet();
            this.t.put(K());
        }
    }

    public ByteBuffer K() {
        return ByteBuffer.allocate(16384);
    }

    public final void L(SelectionKey selectionKey, Iterator it) {
        if (!Y(selectionKey)) {
            selectionKey.cancel();
            return;
        }
        SocketChannel accept = this.m.accept();
        if (accept != null) {
            accept.configureBlocking(false);
            Socket socket = accept.socket();
            socket.setTcpNoDelay(y());
            socket.setKeepAlive(true);
            WebSocketImpl a2 = this.w.a(this, this.o);
            a2.J(accept.register(this.n, 1, a2));
            try {
                a2.I(this.w.b(accept, a2.v()));
                it.remove();
                J(a2);
            } catch (IOException e) {
                if (a2.v() != null) {
                    a2.v().cancel();
                }
                U(a2.v(), (WebSocket) null, e);
            }
        }
    }

    public final void M() {
        while (!this.s.isEmpty()) {
            WebSocketImpl webSocketImpl = (WebSocketImpl) this.s.remove(0);
            WrappedByteChannel wrappedByteChannel = (WrappedByteChannel) webSocketImpl.r();
            ByteBuffer j0 = j0();
            try {
                if (SocketChannelIOHelper.c(j0, webSocketImpl, wrappedByteChannel)) {
                    this.s.add(webSocketImpl);
                }
                if (j0.hasRemaining()) {
                    webSocketImpl.c.put(j0);
                    f0(webSocketImpl);
                } else {
                    e0(j0);
                }
            } catch (IOException e) {
                e0(j0);
                throw e;
            }
        }
    }

    public final boolean N() {
        synchronized (this) {
            try {
                if (this.p == null) {
                    this.p = Thread.currentThread();
                    return !this.q.get();
                }
                throw new IllegalStateException(getClass().getName() + " can only be started once.");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean O(SelectionKey selectionKey, Iterator it) {
        WebSocketImpl webSocketImpl = (WebSocketImpl) selectionKey.attachment();
        ByteBuffer j0 = j0();
        if (webSocketImpl.r() == null) {
            selectionKey.cancel();
            U(selectionKey, webSocketImpl, new IOException());
            return false;
        }
        try {
            if (!SocketChannelIOHelper.b(j0, webSocketImpl, webSocketImpl.r())) {
                e0(j0);
                return true;
            } else if (j0.hasRemaining()) {
                webSocketImpl.c.put(j0);
                f0(webSocketImpl);
                it.remove();
                if (!(webSocketImpl.r() instanceof WrappedByteChannel) || !((WrappedByteChannel) webSocketImpl.r()).y()) {
                    return true;
                }
                this.s.add(webSocketImpl);
                return true;
            } else {
                e0(j0);
                return true;
            }
        } catch (IOException e) {
            e0(j0);
            throw new WrappedIOException(webSocketImpl, e);
        }
    }

    public final void P() {
        E();
        List<WebSocketWorker> list = this.r;
        if (list != null) {
            for (WebSocketWorker interrupt : list) {
                interrupt.interrupt();
            }
        }
        Selector selector = this.n;
        if (selector != null) {
            try {
                selector.close();
            } catch (IOException e) {
                this.j.error("IOException during selector.close", (Throwable) e);
                Z((WebSocket) null, e);
            }
        }
        ServerSocketChannel serverSocketChannel = this.m;
        if (serverSocketChannel != null) {
            try {
                serverSocketChannel.close();
            } catch (IOException e2) {
                this.j.error("IOException during server.close", (Throwable) e2);
                Z((WebSocket) null, e2);
            }
        }
    }

    public final boolean Q() {
        Thread thread = this.p;
        thread.setName("WebSocketSelector-" + this.p.getId());
        try {
            ServerSocketChannel open = ServerSocketChannel.open();
            this.m = open;
            open.configureBlocking(false);
            ServerSocket socket = this.m.socket();
            socket.setReceiveBufferSize(16384);
            socket.setReuseAddress(x());
            socket.bind(this.l, S());
            Selector open2 = Selector.open();
            this.n = open2;
            ServerSocketChannel serverSocketChannel = this.m;
            serverSocketChannel.register(open2, serverSocketChannel.validOps());
            D();
            for (WebSocketWorker start : this.r) {
                start.start();
            }
            d0();
            return true;
        } catch (IOException e) {
            T((WebSocket) null, e);
            return false;
        }
    }

    public final void R(SelectionKey selectionKey) {
        WebSocketImpl webSocketImpl = (WebSocketImpl) selectionKey.attachment();
        try {
            if (SocketChannelIOHelper.a(webSocketImpl, webSocketImpl.r()) && selectionKey.isValid()) {
                selectionKey.interestOps(1);
            }
        } catch (IOException e) {
            throw new WrappedIOException(webSocketImpl, e);
        }
    }

    public int S() {
        return this.x;
    }

    public final void T(WebSocket webSocket, Exception exc) {
        String str;
        this.j.error("Shutdown due to fatal error", (Throwable) exc);
        Z(webSocket, exc);
        if (exc.getCause() != null) {
            str = " caused by " + exc.getCause().getClass().getName();
        } else {
            str = "";
        }
        try {
            i0(0, "Got error on server side: " + exc.getClass().getName() + str);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            this.j.error("Interrupt during stop", (Throwable) exc);
            Z((WebSocket) null, e);
        }
        List<WebSocketWorker> list = this.r;
        if (list != null) {
            for (WebSocketWorker interrupt : list) {
                interrupt.interrupt();
            }
        }
        Thread thread = this.p;
        if (thread != null) {
            thread.interrupt();
        }
    }

    public final void U(SelectionKey selectionKey, WebSocket webSocket, IOException iOException) {
        SelectableChannel channel;
        if (selectionKey != null) {
            selectionKey.cancel();
        }
        if (webSocket != null) {
            webSocket.q(1006, iOException.getMessage());
        } else if (selectionKey != null && (channel = selectionKey.channel()) != null && channel.isOpen()) {
            try {
                channel.close();
            } catch (IOException unused) {
            }
            this.j.trace("Connection closed because of exception", (Throwable) iOException);
        }
    }

    public abstract void V(WebSocket webSocket, int i, String str, boolean z);

    public void W(WebSocket webSocket, int i, String str) {
    }

    public void X(WebSocket webSocket, int i, String str, boolean z) {
    }

    public boolean Y(SelectionKey selectionKey) {
        return true;
    }

    public abstract void Z(WebSocket webSocket, Exception exc);

    public void a(WebSocket webSocket, int i, String str, boolean z) {
        X(webSocket, i, str, z);
    }

    public abstract void a0(WebSocket webSocket, String str);

    public void b0(WebSocket webSocket, ByteBuffer byteBuffer) {
    }

    public abstract void c0(WebSocket webSocket, ClientHandshake clientHandshake);

    public final void d(WebSocket webSocket) {
        WebSocketImpl webSocketImpl = (WebSocketImpl) webSocket;
        try {
            webSocketImpl.v().interestOps(5);
        } catch (CancelledKeyException unused) {
            webSocketImpl.b.clear();
        }
        this.n.wakeup();
    }

    public abstract void d0();

    public void e(WebSocket webSocket, int i, String str) {
        W(webSocket, i, str);
    }

    public final void e0(ByteBuffer byteBuffer) {
        if (this.t.size() <= this.v.intValue()) {
            this.t.put(byteBuffer);
        }
    }

    public final void f(WebSocket webSocket, Exception exc) {
        Z(webSocket, exc);
    }

    public void f0(WebSocketImpl webSocketImpl) {
        if (webSocketImpl.x() == null) {
            List list = this.r;
            webSocketImpl.K((WebSocketWorker) list.get(this.u % list.size()));
            this.u++;
        }
        webSocketImpl.x().b(webSocketImpl);
    }

    public final void g(WebSocket webSocket, String str) {
        a0(webSocket, str);
    }

    public void g0(WebSocket webSocket) {
    }

    public final void h(WebSocket webSocket, int i, String str, boolean z) {
        this.n.wakeup();
        try {
            if (h0(webSocket)) {
                V(webSocket, i, str, z);
            }
        } finally {
            try {
                g0(webSocket);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public boolean h0(WebSocket webSocket) {
        boolean z;
        synchronized (this.k) {
            try {
                if (this.k.contains(webSocket)) {
                    z = this.k.remove(webSocket);
                } else {
                    this.j.trace("Removing connection which is not in the connections collection! Possible no handshake received! {}", (Object) webSocket);
                    z = false;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (this.q.get() && this.k.isEmpty()) {
            this.p.interrupt();
        }
        return z;
    }

    public final void i(WebSocket webSocket, ByteBuffer byteBuffer) {
        b0(webSocket, byteBuffer);
    }

    public void i0(int i, String str) {
        ArrayList<WebSocket> arrayList;
        Selector selector;
        if (this.q.compareAndSet(false, true)) {
            synchronized (this.k) {
                arrayList = new ArrayList<>(this.k);
            }
            for (WebSocket close : arrayList) {
                close.close(1001, str);
            }
            this.w.close();
            synchronized (this) {
                try {
                    if (!(this.p == null || (selector = this.n) == null)) {
                        selector.wakeup();
                        this.p.join((long) i);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final ByteBuffer j0() {
        return (ByteBuffer) this.t.take();
    }

    public final void o(WebSocket webSocket, Handshakedata handshakedata) {
        if (I(webSocket)) {
            c0(webSocket, (ClientHandshake) handshakedata);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x003f, code lost:
        r4 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0040, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0043, code lost:
        r4 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0044, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x006f, code lost:
        r4 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0070, code lost:
        r5 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0072, code lost:
        r4 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0073, code lost:
        r5 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00b1, code lost:
        P();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00b4, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:60:0x0096 */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0096 A[EDGE_INSN: B:60:0x0096->B:61:? ?: BREAK  , PHI: r1 r2 
      PHI: (r1v5 int) = (r1v1 int), (r1v1 int), (r1v6 int), (r1v6 int), (r1v6 int), (r1v6 int) binds: [B:9:0x0012, B:13:0x001c, B:32:0x0052, B:58:0x0091, B:59:?, B:36:0x005e] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r2v5 int) = (r2v1 int), (r2v1 int), (r2v6 int), (r2v6 int), (r2v6 int), (r2v6 int) binds: [B:9:0x0012, B:13:0x001c, B:32:0x0052, B:58:0x0091, B:59:?, B:36:0x005e] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC, Splitter:B:60:0x0096] */
    /* JADX WARNING: Removed duplicated region for block: B:65:? A[ExcHandler: ClosedByInterruptException (unused java.nio.channels.ClosedByInterruptException), SYNTHETIC, Splitter:B:13:0x001c] */
    /* JADX WARNING: Removed duplicated region for block: B:8:? A[ExcHandler: CancelledKeyException (unused java.nio.channels.CancelledKeyException), PHI: r1 r2 
      PHI: (r1v8 int) = (r1v1 int), (r1v1 int), (r1v6 int), (r1v6 int), (r1v6 int), (r1v6 int) binds: [B:9:0x0012, B:13:0x001c, B:32:0x0052, B:58:0x0091, B:59:?, B:36:0x005e] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r2v8 int) = (r2v1 int), (r2v1 int), (r2v6 int), (r2v6 int), (r2v6 int), (r2v6 int) binds: [B:9:0x0012, B:13:0x001c, B:32:0x0052, B:58:0x0091, B:59:?, B:36:0x005e] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC, Splitter:B:13:0x001c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r7 = this;
            boolean r0 = r7.N()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            boolean r0 = r7.Q()
            if (r0 != 0) goto L_0x000e
            return
        L_0x000e:
            r0 = 5
            r1 = 0
            r2 = r0
        L_0x0011:
            r3 = 0
            java.lang.Thread r4 = r7.p     // Catch:{ RuntimeException -> 0x003c }
            boolean r4 = r4.isInterrupted()     // Catch:{ RuntimeException -> 0x003c }
            if (r4 != 0) goto L_0x00b5
            if (r2 == 0) goto L_0x00b5
            java.util.concurrent.atomic.AtomicBoolean r4 = r7.q     // Catch:{ CancelledKeyException -> 0x0011, ClosedByInterruptException -> 0x00b1, WrappedIOException -> 0x0043, IOException -> 0x003f, InterruptedException -> 0x0096 }
            boolean r4 = r4.get()     // Catch:{ CancelledKeyException -> 0x0011, ClosedByInterruptException -> 0x00b1, WrappedIOException -> 0x0043, IOException -> 0x003f, InterruptedException -> 0x0096 }
            if (r4 == 0) goto L_0x0025
            r1 = r0
        L_0x0025:
            java.nio.channels.Selector r4 = r7.n     // Catch:{ CancelledKeyException -> 0x0011, ClosedByInterruptException -> 0x00b1, WrappedIOException -> 0x0043, IOException -> 0x003f, InterruptedException -> 0x0096 }
            long r5 = (long) r1     // Catch:{ CancelledKeyException -> 0x0011, ClosedByInterruptException -> 0x00b1, WrappedIOException -> 0x0043, IOException -> 0x003f, InterruptedException -> 0x0096 }
            int r4 = r4.select(r5)     // Catch:{ CancelledKeyException -> 0x0011, ClosedByInterruptException -> 0x00b1, WrappedIOException -> 0x0043, IOException -> 0x003f, InterruptedException -> 0x0096 }
            if (r4 != 0) goto L_0x0047
            java.util.concurrent.atomic.AtomicBoolean r4 = r7.q     // Catch:{ CancelledKeyException -> 0x0011, ClosedByInterruptException -> 0x00b1, WrappedIOException -> 0x0043, IOException -> 0x003f, InterruptedException -> 0x0096 }
            boolean r4 = r4.get()     // Catch:{ CancelledKeyException -> 0x0011, ClosedByInterruptException -> 0x00b1, WrappedIOException -> 0x0043, IOException -> 0x003f, InterruptedException -> 0x0096 }
            if (r4 == 0) goto L_0x0047
            int r2 = r2 + -1
            goto L_0x0047
        L_0x0039:
            r0 = move-exception
            goto L_0x00be
        L_0x003c:
            r0 = move-exception
            goto L_0x00b9
        L_0x003f:
            r4 = move-exception
            r5 = r3
            goto L_0x009f
        L_0x0043:
            r4 = move-exception
            r5 = r3
            goto L_0x00a4
        L_0x0047:
            java.nio.channels.Selector r4 = r7.n     // Catch:{ CancelledKeyException -> 0x0011, ClosedByInterruptException -> 0x00b1, WrappedIOException -> 0x0043, IOException -> 0x003f, InterruptedException -> 0x0096 }
            java.util.Set r4 = r4.selectedKeys()     // Catch:{ CancelledKeyException -> 0x0011, ClosedByInterruptException -> 0x00b1, WrappedIOException -> 0x0043, IOException -> 0x003f, InterruptedException -> 0x0096 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ CancelledKeyException -> 0x0011, ClosedByInterruptException -> 0x00b1, WrappedIOException -> 0x0043, IOException -> 0x003f, InterruptedException -> 0x0096 }
            r5 = r3
        L_0x0052:
            boolean r6 = r4.hasNext()     // Catch:{ CancelledKeyException -> 0x0011, ClosedByInterruptException -> 0x00b1, WrappedIOException -> 0x008f, IOException -> 0x008d, InterruptedException -> 0x0096 }
            if (r6 == 0) goto L_0x0091
            java.lang.Object r6 = r4.next()     // Catch:{ CancelledKeyException -> 0x0011, ClosedByInterruptException -> 0x00b1, WrappedIOException -> 0x008f, IOException -> 0x008d, InterruptedException -> 0x0096 }
            java.nio.channels.SelectionKey r6 = (java.nio.channels.SelectionKey) r6     // Catch:{ CancelledKeyException -> 0x0011, ClosedByInterruptException -> 0x00b1, WrappedIOException -> 0x008f, IOException -> 0x008d, InterruptedException -> 0x0096 }
            boolean r5 = r6.isValid()     // Catch:{ CancelledKeyException -> 0x0011, ClosedByInterruptException -> 0x00b1, WrappedIOException -> 0x0072, IOException -> 0x006f, InterruptedException -> 0x0096 }
            if (r5 != 0) goto L_0x0065
            goto L_0x008b
        L_0x0065:
            boolean r5 = r6.isAcceptable()     // Catch:{ CancelledKeyException -> 0x0011, ClosedByInterruptException -> 0x00b1, WrappedIOException -> 0x0072, IOException -> 0x006f, InterruptedException -> 0x0096 }
            if (r5 == 0) goto L_0x0075
            r7.L(r6, r4)     // Catch:{ CancelledKeyException -> 0x0011, ClosedByInterruptException -> 0x00b1, WrappedIOException -> 0x0072, IOException -> 0x006f, InterruptedException -> 0x0096 }
            goto L_0x008b
        L_0x006f:
            r4 = move-exception
            r5 = r6
            goto L_0x009f
        L_0x0072:
            r4 = move-exception
            r5 = r6
            goto L_0x00a4
        L_0x0075:
            boolean r5 = r6.isReadable()     // Catch:{ CancelledKeyException -> 0x0011, ClosedByInterruptException -> 0x00b1, WrappedIOException -> 0x0072, IOException -> 0x006f, InterruptedException -> 0x0096 }
            if (r5 == 0) goto L_0x0082
            boolean r5 = r7.O(r6, r4)     // Catch:{ CancelledKeyException -> 0x0011, ClosedByInterruptException -> 0x00b1, WrappedIOException -> 0x0072, IOException -> 0x006f, InterruptedException -> 0x0096 }
            if (r5 != 0) goto L_0x0082
            goto L_0x008b
        L_0x0082:
            boolean r5 = r6.isWritable()     // Catch:{ CancelledKeyException -> 0x0011, ClosedByInterruptException -> 0x00b1, WrappedIOException -> 0x0072, IOException -> 0x006f, InterruptedException -> 0x0096 }
            if (r5 == 0) goto L_0x008b
            r7.R(r6)     // Catch:{ CancelledKeyException -> 0x0011, ClosedByInterruptException -> 0x00b1, WrappedIOException -> 0x0072, IOException -> 0x006f, InterruptedException -> 0x0096 }
        L_0x008b:
            r5 = r6
            goto L_0x0052
        L_0x008d:
            r4 = move-exception
            goto L_0x009f
        L_0x008f:
            r4 = move-exception
            goto L_0x00a4
        L_0x0091:
            r7.M()     // Catch:{ CancelledKeyException -> 0x0011, ClosedByInterruptException -> 0x00b1, WrappedIOException -> 0x008f, IOException -> 0x008d, InterruptedException -> 0x0096 }
            goto L_0x0011
        L_0x0096:
            java.lang.Thread r4 = java.lang.Thread.currentThread()     // Catch:{ RuntimeException -> 0x003c }
            r4.interrupt()     // Catch:{ RuntimeException -> 0x003c }
            goto L_0x0011
        L_0x009f:
            r7.U(r5, r3, r4)     // Catch:{ RuntimeException -> 0x003c }
            goto L_0x0011
        L_0x00a4:
            org.java_websocket.WebSocket r6 = r4.getConnection()     // Catch:{ RuntimeException -> 0x003c }
            java.io.IOException r4 = r4.getIOException()     // Catch:{ RuntimeException -> 0x003c }
            r7.U(r5, r6, r4)     // Catch:{ RuntimeException -> 0x003c }
            goto L_0x0011
        L_0x00b1:
            r7.P()
            return
        L_0x00b5:
            r7.P()
            goto L_0x00bd
        L_0x00b9:
            r7.T(r3, r0)     // Catch:{ all -> 0x0039 }
            goto L_0x00b5
        L_0x00bd:
            return
        L_0x00be:
            r7.P()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.java_websocket.server.WebSocketServer.run():void");
    }

    public Collection w() {
        Collection unmodifiableCollection;
        synchronized (this.k) {
            unmodifiableCollection = Collections.unmodifiableCollection(new ArrayList(this.k));
        }
        return unmodifiableCollection;
    }
}
