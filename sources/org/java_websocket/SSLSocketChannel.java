package org.java_websocket;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import org.java_websocket.interfaces.ISSLChannel;
import org.java_websocket.util.ByteBufferUtils;
import org.slf4j.Logger;

public class SSLSocketChannel implements WrappedByteChannel, ByteChannel, ISSLChannel {

    /* renamed from: a  reason: collision with root package name */
    public final Logger f3388a;
    public final SocketChannel b;
    public final SSLEngine c;
    public ByteBuffer d;
    public ByteBuffer e;
    public ByteBuffer f;
    public ByteBuffer g;
    public ExecutorService h;

    /* renamed from: org.java_websocket.SSLSocketChannel$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f3389a;
        public static final /* synthetic */ int[] b;

        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|19|20|21|22|23|24|25|26|28) */
        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|19|20|21|22|23|24|25|26|28) */
        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|19|20|21|22|23|24|25|26|28) */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0059 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0063 */
        static {
            /*
                javax.net.ssl.SSLEngineResult$HandshakeStatus[] r0 = javax.net.ssl.SSLEngineResult.HandshakeStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                b = r0
                r1 = 1
                javax.net.ssl.SSLEngineResult$HandshakeStatus r2 = javax.net.ssl.SSLEngineResult.HandshakeStatus.FINISHED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = b     // Catch:{ NoSuchFieldError -> 0x001d }
                javax.net.ssl.SSLEngineResult$HandshakeStatus r3 = javax.net.ssl.SSLEngineResult.HandshakeStatus.NEED_UNWRAP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = b     // Catch:{ NoSuchFieldError -> 0x0028 }
                javax.net.ssl.SSLEngineResult$HandshakeStatus r4 = javax.net.ssl.SSLEngineResult.HandshakeStatus.NEED_WRAP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = b     // Catch:{ NoSuchFieldError -> 0x0033 }
                javax.net.ssl.SSLEngineResult$HandshakeStatus r5 = javax.net.ssl.SSLEngineResult.HandshakeStatus.NEED_TASK     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r4 = b     // Catch:{ NoSuchFieldError -> 0x003e }
                javax.net.ssl.SSLEngineResult$HandshakeStatus r5 = javax.net.ssl.SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING     // Catch:{ NoSuchFieldError -> 0x003e }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r6 = 5
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                javax.net.ssl.SSLEngineResult$Status[] r4 = javax.net.ssl.SSLEngineResult.Status.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f3389a = r4
                javax.net.ssl.SSLEngineResult$Status r5 = javax.net.ssl.SSLEngineResult.Status.OK     // Catch:{ NoSuchFieldError -> 0x004f }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x004f }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x004f }
            L_0x004f:
                int[] r1 = f3389a     // Catch:{ NoSuchFieldError -> 0x0059 }
                javax.net.ssl.SSLEngineResult$Status r4 = javax.net.ssl.SSLEngineResult.Status.BUFFER_UNDERFLOW     // Catch:{ NoSuchFieldError -> 0x0059 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0059 }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                int[] r0 = f3389a     // Catch:{ NoSuchFieldError -> 0x0063 }
                javax.net.ssl.SSLEngineResult$Status r1 = javax.net.ssl.SSLEngineResult.Status.BUFFER_OVERFLOW     // Catch:{ NoSuchFieldError -> 0x0063 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0063 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0063 }
            L_0x0063:
                int[] r0 = f3389a     // Catch:{ NoSuchFieldError -> 0x006d }
                javax.net.ssl.SSLEngineResult$Status r1 = javax.net.ssl.SSLEngineResult.Status.CLOSED     // Catch:{ NoSuchFieldError -> 0x006d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.java_websocket.SSLSocketChannel.AnonymousClass1.<clinit>():void");
        }
    }

    public final void a() {
        this.c.closeOutbound();
        try {
            b();
        } catch (IOException unused) {
        }
        this.b.close();
    }

    public void a0() {
    }

    public final boolean b() {
        SSLEngineResult.HandshakeStatus handshakeStatus;
        int applicationBufferSize = this.c.getSession().getApplicationBufferSize();
        this.d = ByteBuffer.allocate(applicationBufferSize);
        this.f = ByteBuffer.allocate(applicationBufferSize);
        this.e.clear();
        this.g.clear();
        SSLEngineResult.HandshakeStatus handshakeStatus2 = this.c.getHandshakeStatus();
        boolean z = false;
        while (!z) {
            int i = AnonymousClass1.b[handshakeStatus2.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        this.e.clear();
                        try {
                            SSLEngineResult wrap = this.c.wrap(this.d, this.e);
                            handshakeStatus = wrap.getHandshakeStatus();
                            int i2 = AnonymousClass1.f3389a[wrap.getStatus().ordinal()];
                            if (i2 == 1) {
                                this.e.flip();
                                while (this.e.hasRemaining()) {
                                    this.b.write(this.e);
                                }
                            } else if (i2 == 2) {
                                throw new SSLException("Buffer underflow occurred after a wrap. I don't think we should ever get here.");
                            } else if (i2 == 3) {
                                this.e = g(this.e);
                            } else if (i2 == 4) {
                                try {
                                    this.e.flip();
                                    while (this.e.hasRemaining()) {
                                        this.b.write(this.e);
                                    }
                                    this.g.clear();
                                } catch (Exception unused) {
                                    handshakeStatus2 = this.c.getHandshakeStatus();
                                }
                            } else {
                                throw new IllegalStateException("Invalid SSL status: " + wrap.getStatus());
                            }
                        } catch (SSLException unused2) {
                            this.c.closeOutbound();
                            handshakeStatus2 = this.c.getHandshakeStatus();
                        }
                    } else if (i == 4) {
                        while (true) {
                            Runnable delegatedTask = this.c.getDelegatedTask();
                            if (delegatedTask == null) {
                                break;
                            }
                            this.h.execute(delegatedTask);
                        }
                        handshakeStatus2 = this.c.getHandshakeStatus();
                    } else if (i != 5) {
                        throw new IllegalStateException("Invalid SSL status: " + handshakeStatus2);
                    }
                } else if (this.b.read(this.g) >= 0) {
                    this.g.flip();
                    try {
                        SSLEngineResult unwrap = this.c.unwrap(this.g, this.f);
                        this.g.compact();
                        handshakeStatus = unwrap.getHandshakeStatus();
                        int i3 = AnonymousClass1.f3389a[unwrap.getStatus().ordinal()];
                        if (i3 != 1) {
                            if (i3 == 2) {
                                this.g = i(this.g);
                            } else if (i3 == 3) {
                                this.f = c(this.f);
                            } else if (i3 != 4) {
                                throw new IllegalStateException("Invalid SSL status: " + unwrap.getStatus());
                            } else if (this.c.isOutboundDone()) {
                                return false;
                            } else {
                                this.c.closeOutbound();
                                handshakeStatus2 = this.c.getHandshakeStatus();
                            }
                        }
                    } catch (SSLException unused3) {
                        this.c.closeOutbound();
                        handshakeStatus2 = this.c.getHandshakeStatus();
                    }
                } else if (this.c.isInboundDone() && this.c.isOutboundDone()) {
                    return false;
                } else {
                    try {
                        this.c.closeInbound();
                    } catch (SSLException unused4) {
                    }
                    this.c.closeOutbound();
                    handshakeStatus2 = this.c.getHandshakeStatus();
                }
                handshakeStatus2 = handshakeStatus;
            } else {
                z = !this.g.hasRemaining();
                if (z) {
                    return true;
                }
                this.b.write(this.g);
            }
        }
        return true;
    }

    public int b0(ByteBuffer byteBuffer) {
        return read(byteBuffer);
    }

    public final ByteBuffer c(ByteBuffer byteBuffer) {
        return d(byteBuffer, this.c.getSession().getApplicationBufferSize());
    }

    public void close() {
        a();
    }

    public final ByteBuffer d(ByteBuffer byteBuffer, int i) {
        return i > byteBuffer.capacity() ? ByteBuffer.allocate(i) : ByteBuffer.allocate(byteBuffer.capacity() * 2);
    }

    public final ByteBuffer g(ByteBuffer byteBuffer) {
        return d(byteBuffer, this.c.getSession().getPacketBufferSize());
    }

    public final ByteBuffer i(ByteBuffer byteBuffer) {
        if (this.c.getSession().getPacketBufferSize() < byteBuffer.limit()) {
            return byteBuffer;
        }
        ByteBuffer g2 = g(byteBuffer);
        byteBuffer.flip();
        g2.put(byteBuffer);
        return g2;
    }

    public boolean isOpen() {
        return this.b.isOpen();
    }

    public final void j() {
        try {
            this.c.closeInbound();
        } catch (Exception unused) {
            this.f3388a.error("This engine was forced to close inbound, without having received the proper SSL/TLS close notification message from the peer, due to end of stream.");
        }
        a();
    }

    public synchronized int read(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasRemaining()) {
            return 0;
        }
        if (this.f.hasRemaining()) {
            this.f.flip();
            return ByteBufferUtils.b(this.f, byteBuffer);
        }
        this.g.compact();
        int read = this.b.read(this.g);
        if (read <= 0) {
            if (!this.g.hasRemaining()) {
                if (read < 0) {
                    j();
                }
                ByteBufferUtils.b(this.f, byteBuffer);
                return read;
            }
        }
        this.g.flip();
        if (this.g.hasRemaining()) {
            this.f.compact();
            try {
                SSLEngineResult unwrap = this.c.unwrap(this.g, this.f);
                int i = AnonymousClass1.f3389a[unwrap.getStatus().ordinal()];
                if (i == 1) {
                    this.f.flip();
                    return ByteBufferUtils.b(this.f, byteBuffer);
                } else if (i == 2) {
                    this.f.flip();
                    return ByteBufferUtils.b(this.f, byteBuffer);
                } else if (i == 3) {
                    this.f = c(this.f);
                    return read(byteBuffer);
                } else if (i == 4) {
                    a();
                    byteBuffer.clear();
                    return -1;
                } else {
                    throw new IllegalStateException("Invalid SSL status: " + unwrap.getStatus());
                }
            } catch (SSLException e2) {
                this.f3388a.error("SSLException during unwrap", (Throwable) e2);
                throw e2;
            }
        }
        ByteBufferUtils.b(this.f, byteBuffer);
        return read;
    }

    public synchronized int write(ByteBuffer byteBuffer) {
        int i = 0;
        while (byteBuffer.hasRemaining()) {
            this.e.clear();
            SSLEngineResult wrap = this.c.wrap(byteBuffer, this.e);
            int i2 = AnonymousClass1.f3389a[wrap.getStatus().ordinal()];
            if (i2 == 1) {
                this.e.flip();
                while (this.e.hasRemaining()) {
                    i += this.b.write(this.e);
                }
            } else if (i2 == 2) {
                throw new SSLException("Buffer underflow occurred after a wrap. I don't think we should ever get here.");
            } else if (i2 == 3) {
                this.e = g(this.e);
            } else if (i2 == 4) {
                a();
                return 0;
            } else {
                throw new IllegalStateException("Invalid SSL status: " + wrap.getStatus());
            }
        }
        return i;
    }

    public boolean x() {
        return false;
    }

    public boolean y() {
        return this.g.hasRemaining() || this.f.hasRemaining();
    }
}
