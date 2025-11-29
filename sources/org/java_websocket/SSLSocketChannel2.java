package org.java_websocket;

import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLSession;
import org.java_websocket.interfaces.ISSLChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SSLSocketChannel2 implements ByteChannel, WrappedByteChannel, ISSLChannel {
    public static ByteBuffer n = ByteBuffer.allocate(0);

    /* renamed from: a  reason: collision with root package name */
    public final Logger f3390a = LoggerFactory.k(SSLSocketChannel2.class);
    public ExecutorService b;
    public List c;
    public ByteBuffer d;
    public ByteBuffer e;
    public ByteBuffer f;
    public SocketChannel g;
    public SelectionKey h;
    public SSLEngine i;
    public SSLEngineResult j;
    public SSLEngineResult k;
    public int l = 0;
    public byte[] m = null;

    public SSLSocketChannel2(SocketChannel socketChannel, SSLEngine sSLEngine, ExecutorService executorService, SelectionKey selectionKey) {
        if (socketChannel == null || sSLEngine == null || executorService == null) {
            throw new IllegalArgumentException("parameter must not be null");
        }
        this.g = socketChannel;
        this.i = sSLEngine;
        this.b = executorService;
        SSLEngineResult sSLEngineResult = new SSLEngineResult(SSLEngineResult.Status.BUFFER_UNDERFLOW, sSLEngine.getHandshakeStatus(), 0, 0);
        this.k = sSLEngineResult;
        this.j = sSLEngineResult;
        this.c = new ArrayList(3);
        if (selectionKey != null) {
            selectionKey.interestOps(selectionKey.interestOps() | 4);
            this.h = selectionKey;
        }
        c(sSLEngine.getSession());
        this.g.write(u(n));
        i();
    }

    public void a() {
        while (true) {
            Runnable delegatedTask = this.i.getDelegatedTask();
            if (delegatedTask != null) {
                this.c.add(this.b.submit(delegatedTask));
            } else {
                return;
            }
        }
    }

    public void a0() {
        write(this.e);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0006 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(java.util.concurrent.Future r1) {
        /*
            r0 = this;
        L_0x0000:
            r1.get()     // Catch:{ InterruptedException -> 0x0006 }
            return
        L_0x0004:
            r0 = move-exception
            goto L_0x000e
        L_0x0006:
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ ExecutionException -> 0x0004 }
            r0.interrupt()     // Catch:{ ExecutionException -> 0x0004 }
            goto L_0x0000
        L_0x000e:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.java_websocket.SSLSocketChannel2.b(java.util.concurrent.Future):void");
    }

    public int b0(ByteBuffer byteBuffer) {
        return j(byteBuffer);
    }

    public void c(SSLSession sSLSession) {
        n();
        int packetBufferSize = sSLSession.getPacketBufferSize();
        int max = Math.max(sSLSession.getApplicationBufferSize(), packetBufferSize);
        ByteBuffer byteBuffer = this.d;
        if (byteBuffer == null) {
            this.d = ByteBuffer.allocate(max);
            this.e = ByteBuffer.allocate(packetBufferSize);
            this.f = ByteBuffer.allocate(packetBufferSize);
        } else {
            if (byteBuffer.capacity() != max) {
                this.d = ByteBuffer.allocate(max);
            }
            if (this.e.capacity() != packetBufferSize) {
                this.e = ByteBuffer.allocate(packetBufferSize);
            }
            if (this.f.capacity() != packetBufferSize) {
                this.f = ByteBuffer.allocate(packetBufferSize);
            }
        }
        if (this.d.remaining() != 0 && this.f3390a.isTraceEnabled()) {
            this.f3390a.trace(new String(this.d.array(), this.d.position(), this.d.remaining()));
        }
        this.d.rewind();
        this.d.flip();
        if (this.f.remaining() != 0 && this.f3390a.isTraceEnabled()) {
            this.f3390a.trace(new String(this.f.array(), this.f.position(), this.f.remaining()));
        }
        this.f.rewind();
        this.f.flip();
        this.e.rewind();
        this.e.flip();
        this.l++;
    }

    public void close() {
        this.i.closeOutbound();
        this.i.getSession().invalidate();
        try {
            if (this.g.isOpen()) {
                this.g.write(u(n));
            }
        } finally {
            this.g.close();
        }
    }

    public boolean d() {
        return this.g.isBlocking();
    }

    public final boolean g() {
        SSLEngineResult.HandshakeStatus handshakeStatus = this.i.getHandshakeStatus();
        return handshakeStatus == SSLEngineResult.HandshakeStatus.FINISHED || handshakeStatus == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void i() {
        /*
            r3 = this;
            monitor-enter(r3)
            javax.net.ssl.SSLEngine r0 = r3.i     // Catch:{ all -> 0x0031 }
            javax.net.ssl.SSLEngineResult$HandshakeStatus r0 = r0.getHandshakeStatus()     // Catch:{ all -> 0x0031 }
            javax.net.ssl.SSLEngineResult$HandshakeStatus r1 = javax.net.ssl.SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING     // Catch:{ all -> 0x0031 }
            if (r0 != r1) goto L_0x000d
            monitor-exit(r3)
            return
        L_0x000d:
            java.util.List r0 = r3.c     // Catch:{ all -> 0x0031 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0031 }
            if (r0 != 0) goto L_0x003f
            java.util.List r0 = r3.c     // Catch:{ all -> 0x0031 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0031 }
        L_0x001b:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0031 }
            if (r1 == 0) goto L_0x003f
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0031 }
            java.util.concurrent.Future r1 = (java.util.concurrent.Future) r1     // Catch:{ all -> 0x0031 }
            boolean r2 = r1.isDone()     // Catch:{ all -> 0x0031 }
            if (r2 == 0) goto L_0x0034
            r0.remove()     // Catch:{ all -> 0x0031 }
            goto L_0x001b
        L_0x0031:
            r0 = move-exception
            goto L_0x00cd
        L_0x0034:
            boolean r0 = r3.d()     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x003d
            r3.b(r1)     // Catch:{ all -> 0x0031 }
        L_0x003d:
            monitor-exit(r3)
            return
        L_0x003f:
            javax.net.ssl.SSLEngine r0 = r3.i     // Catch:{ all -> 0x0031 }
            javax.net.ssl.SSLEngineResult$HandshakeStatus r0 = r0.getHandshakeStatus()     // Catch:{ all -> 0x0031 }
            javax.net.ssl.SSLEngineResult$HandshakeStatus r1 = javax.net.ssl.SSLEngineResult.HandshakeStatus.NEED_UNWRAP     // Catch:{ all -> 0x0031 }
            if (r0 != r1) goto L_0x0093
            boolean r0 = r3.d()     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x0059
            javax.net.ssl.SSLEngineResult r0 = r3.j     // Catch:{ all -> 0x0031 }
            javax.net.ssl.SSLEngineResult$Status r0 = r0.getStatus()     // Catch:{ all -> 0x0031 }
            javax.net.ssl.SSLEngineResult$Status r1 = javax.net.ssl.SSLEngineResult.Status.BUFFER_UNDERFLOW     // Catch:{ all -> 0x0031 }
            if (r0 != r1) goto L_0x006e
        L_0x0059:
            java.nio.ByteBuffer r0 = r3.f     // Catch:{ all -> 0x0031 }
            r0.compact()     // Catch:{ all -> 0x0031 }
            java.nio.channels.SocketChannel r0 = r3.g     // Catch:{ all -> 0x0031 }
            java.nio.ByteBuffer r1 = r3.f     // Catch:{ all -> 0x0031 }
            int r0 = r0.read(r1)     // Catch:{ all -> 0x0031 }
            r1 = -1
            if (r0 == r1) goto L_0x008b
            java.nio.ByteBuffer r0 = r3.f     // Catch:{ all -> 0x0031 }
            r0.flip()     // Catch:{ all -> 0x0031 }
        L_0x006e:
            java.nio.ByteBuffer r0 = r3.d     // Catch:{ all -> 0x0031 }
            r0.compact()     // Catch:{ all -> 0x0031 }
            r3.s()     // Catch:{ all -> 0x0031 }
            javax.net.ssl.SSLEngineResult r0 = r3.j     // Catch:{ all -> 0x0031 }
            javax.net.ssl.SSLEngineResult$HandshakeStatus r0 = r0.getHandshakeStatus()     // Catch:{ all -> 0x0031 }
            javax.net.ssl.SSLEngineResult$HandshakeStatus r1 = javax.net.ssl.SSLEngineResult.HandshakeStatus.FINISHED     // Catch:{ all -> 0x0031 }
            if (r0 != r1) goto L_0x0093
            javax.net.ssl.SSLEngine r0 = r3.i     // Catch:{ all -> 0x0031 }
            javax.net.ssl.SSLSession r0 = r0.getSession()     // Catch:{ all -> 0x0031 }
            r3.c(r0)     // Catch:{ all -> 0x0031 }
            monitor-exit(r3)
            return
        L_0x008b:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0031 }
            java.lang.String r1 = "connection closed unexpectedly by peer"
            r0.<init>(r1)     // Catch:{ all -> 0x0031 }
            throw r0     // Catch:{ all -> 0x0031 }
        L_0x0093:
            r3.a()     // Catch:{ all -> 0x0031 }
            java.util.List r0 = r3.c     // Catch:{ all -> 0x0031 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0031 }
            if (r0 != 0) goto L_0x00a8
            javax.net.ssl.SSLEngine r0 = r3.i     // Catch:{ all -> 0x0031 }
            javax.net.ssl.SSLEngineResult$HandshakeStatus r0 = r0.getHandshakeStatus()     // Catch:{ all -> 0x0031 }
            javax.net.ssl.SSLEngineResult$HandshakeStatus r1 = javax.net.ssl.SSLEngineResult.HandshakeStatus.NEED_WRAP     // Catch:{ all -> 0x0031 }
            if (r0 != r1) goto L_0x00c8
        L_0x00a8:
            java.nio.channels.SocketChannel r0 = r3.g     // Catch:{ all -> 0x0031 }
            java.nio.ByteBuffer r1 = n     // Catch:{ all -> 0x0031 }
            java.nio.ByteBuffer r1 = r3.u(r1)     // Catch:{ all -> 0x0031 }
            r0.write(r1)     // Catch:{ all -> 0x0031 }
            javax.net.ssl.SSLEngineResult r0 = r3.k     // Catch:{ all -> 0x0031 }
            javax.net.ssl.SSLEngineResult$HandshakeStatus r0 = r0.getHandshakeStatus()     // Catch:{ all -> 0x0031 }
            javax.net.ssl.SSLEngineResult$HandshakeStatus r1 = javax.net.ssl.SSLEngineResult.HandshakeStatus.FINISHED     // Catch:{ all -> 0x0031 }
            if (r0 != r1) goto L_0x00c8
            javax.net.ssl.SSLEngine r0 = r3.i     // Catch:{ all -> 0x0031 }
            javax.net.ssl.SSLSession r0 = r0.getSession()     // Catch:{ all -> 0x0031 }
            r3.c(r0)     // Catch:{ all -> 0x0031 }
            monitor-exit(r3)
            return
        L_0x00c8:
            r0 = 1
            r3.l = r0     // Catch:{ all -> 0x0031 }
            monitor-exit(r3)
            return
        L_0x00cd:
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.java_websocket.SSLSocketChannel2.i():void");
    }

    public boolean isOpen() {
        return this.g.isOpen();
    }

    public final int j(ByteBuffer byteBuffer) {
        if (this.d.hasRemaining()) {
            return o(this.d, byteBuffer);
        }
        if (!this.d.hasRemaining()) {
            this.d.clear();
        }
        r();
        if (!this.f.hasRemaining()) {
            return 0;
        }
        s();
        int o = o(this.d, byteBuffer);
        if (this.j.getStatus() == SSLEngineResult.Status.CLOSED) {
            return -1;
        }
        if (o > 0) {
            return o;
        }
        return 0;
    }

    public final void n() {
        ByteBuffer byteBuffer = this.f;
        if (byteBuffer != null && byteBuffer.remaining() > 0) {
            byte[] bArr = new byte[this.f.remaining()];
            this.m = bArr;
            this.f.get(bArr);
        }
    }

    public final int o(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        int remaining = byteBuffer.remaining();
        int remaining2 = byteBuffer2.remaining();
        if (remaining > remaining2) {
            int min = Math.min(remaining, remaining2);
            for (int i2 = 0; i2 < min; i2++) {
                byteBuffer2.put(byteBuffer.get());
            }
            return min;
        }
        byteBuffer2.put(byteBuffer);
        return remaining;
    }

    public final void r() {
        if (this.m != null) {
            this.f.clear();
            this.f.put(this.m);
            this.f.flip();
            this.m = null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x000b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int read(java.nio.ByteBuffer r3) {
        /*
            r2 = this;
            r2.r()
        L_0x0003:
            boolean r0 = r3.hasRemaining()
            r1 = 0
            if (r0 != 0) goto L_0x000b
            return r1
        L_0x000b:
            boolean r0 = r2.g()
            if (r0 != 0) goto L_0x002b
            boolean r0 = r2.d()
            if (r0 == 0) goto L_0x0021
        L_0x0017:
            boolean r0 = r2.g()
            if (r0 != 0) goto L_0x002b
            r2.i()
            goto L_0x0017
        L_0x0021:
            r2.i()
            boolean r0 = r2.g()
            if (r0 != 0) goto L_0x002b
            return r1
        L_0x002b:
            int r0 = r2.j(r3)
            if (r0 == 0) goto L_0x0032
            return r0
        L_0x0032:
            java.nio.ByteBuffer r0 = r2.d
            r0.clear()
            java.nio.ByteBuffer r0 = r2.f
            boolean r0 = r0.hasRemaining()
            if (r0 != 0) goto L_0x0045
            java.nio.ByteBuffer r0 = r2.f
            r0.clear()
            goto L_0x004a
        L_0x0045:
            java.nio.ByteBuffer r0 = r2.f
            r0.compact()
        L_0x004a:
            boolean r0 = r2.d()
            if (r0 != 0) goto L_0x005a
            javax.net.ssl.SSLEngineResult r0 = r2.j
            javax.net.ssl.SSLEngineResult$Status r0 = r0.getStatus()
            javax.net.ssl.SSLEngineResult$Status r1 = javax.net.ssl.SSLEngineResult.Status.BUFFER_UNDERFLOW
            if (r0 != r1) goto L_0x0066
        L_0x005a:
            java.nio.channels.SocketChannel r0 = r2.g
            java.nio.ByteBuffer r1 = r2.f
            int r0 = r0.read(r1)
            r1 = -1
            if (r0 != r1) goto L_0x0066
            return r1
        L_0x0066:
            java.nio.ByteBuffer r0 = r2.f
            r0.flip()
            r2.s()
            java.nio.ByteBuffer r0 = r2.d
            int r0 = r2.o(r0, r3)
            if (r0 != 0) goto L_0x007d
            boolean r1 = r2.d()
            if (r1 == 0) goto L_0x007d
            goto L_0x0003
        L_0x007d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.java_websocket.SSLSocketChannel2.read(java.nio.ByteBuffer):int");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:9|10|(1:16)(1:21)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001b */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001b A[LOOP:0: B:9:0x001b->B:21:0x001b, LOOP_START, SYNTHETIC, Splitter:B:9:0x001b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.nio.ByteBuffer s() {
        /*
            r4 = this;
            monitor-enter(r4)
            javax.net.ssl.SSLEngineResult r0 = r4.j     // Catch:{ all -> 0x0019 }
            javax.net.ssl.SSLEngineResult$Status r0 = r0.getStatus()     // Catch:{ all -> 0x0019 }
            javax.net.ssl.SSLEngineResult$Status r1 = javax.net.ssl.SSLEngineResult.Status.CLOSED     // Catch:{ all -> 0x0019 }
            if (r0 != r1) goto L_0x001b
            javax.net.ssl.SSLEngine r0 = r4.i     // Catch:{ all -> 0x0019 }
            javax.net.ssl.SSLEngineResult$HandshakeStatus r0 = r0.getHandshakeStatus()     // Catch:{ all -> 0x0019 }
            javax.net.ssl.SSLEngineResult$HandshakeStatus r1 = javax.net.ssl.SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING     // Catch:{ all -> 0x0019 }
            if (r0 != r1) goto L_0x001b
            r4.close()     // Catch:{ IOException -> 0x001b }
            goto L_0x001b
        L_0x0019:
            r0 = move-exception
            goto L_0x0050
        L_0x001b:
            java.nio.ByteBuffer r0 = r4.d     // Catch:{ all -> 0x0019 }
            int r0 = r0.remaining()     // Catch:{ all -> 0x0019 }
            javax.net.ssl.SSLEngine r1 = r4.i     // Catch:{ all -> 0x0019 }
            java.nio.ByteBuffer r2 = r4.f     // Catch:{ all -> 0x0019 }
            java.nio.ByteBuffer r3 = r4.d     // Catch:{ all -> 0x0019 }
            javax.net.ssl.SSLEngineResult r1 = r1.unwrap(r2, r3)     // Catch:{ all -> 0x0019 }
            r4.j = r1     // Catch:{ all -> 0x0019 }
            javax.net.ssl.SSLEngineResult$Status r1 = r1.getStatus()     // Catch:{ all -> 0x0019 }
            javax.net.ssl.SSLEngineResult$Status r2 = javax.net.ssl.SSLEngineResult.Status.OK     // Catch:{ all -> 0x0019 }
            if (r1 != r2) goto L_0x0047
            java.nio.ByteBuffer r1 = r4.d     // Catch:{ all -> 0x0019 }
            int r1 = r1.remaining()     // Catch:{ all -> 0x0019 }
            if (r0 != r1) goto L_0x001b
            javax.net.ssl.SSLEngine r0 = r4.i     // Catch:{ all -> 0x0019 }
            javax.net.ssl.SSLEngineResult$HandshakeStatus r0 = r0.getHandshakeStatus()     // Catch:{ all -> 0x0019 }
            javax.net.ssl.SSLEngineResult$HandshakeStatus r1 = javax.net.ssl.SSLEngineResult.HandshakeStatus.NEED_UNWRAP     // Catch:{ all -> 0x0019 }
            if (r0 == r1) goto L_0x001b
        L_0x0047:
            java.nio.ByteBuffer r0 = r4.d     // Catch:{ all -> 0x0019 }
            r0.flip()     // Catch:{ all -> 0x0019 }
            java.nio.ByteBuffer r0 = r4.d     // Catch:{ all -> 0x0019 }
            monitor-exit(r4)
            return r0
        L_0x0050:
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.java_websocket.SSLSocketChannel2.s():java.nio.ByteBuffer");
    }

    public final synchronized ByteBuffer u(ByteBuffer byteBuffer) {
        this.e.compact();
        this.k = this.i.wrap(byteBuffer, this.e);
        this.e.flip();
        return this.e;
    }

    public int write(ByteBuffer byteBuffer) {
        if (!g()) {
            i();
            return 0;
        }
        int write = this.g.write(u(byteBuffer));
        if (this.k.getStatus() != SSLEngineResult.Status.CLOSED) {
            return write;
        }
        throw new EOFException("Connection is closed");
    }

    public boolean x() {
        return this.e.hasRemaining() || !g();
    }

    public boolean y() {
        return (this.m == null && !this.d.hasRemaining() && (!this.f.hasRemaining() || this.j.getStatus() == SSLEngineResult.Status.BUFFER_UNDERFLOW || this.j.getStatus() == SSLEngineResult.Status.CLOSED)) ? false : true;
    }
}
