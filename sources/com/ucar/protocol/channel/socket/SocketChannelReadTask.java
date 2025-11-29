package com.ucar.protocol.channel.socket;

import com.ucar.protocol.MessageHeader;
import com.ucar.protocol.MessageType;
import com.ucar.protocol.ProtocolConfig;
import com.ucar.protocol.ProtocolException;
import com.ucar.protocol.UCarMessage;
import com.ucar.protocol.log.ProtocolLogger;
import com.ucar.protocol.security.SecurityManager;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

class SocketChannelReadTask implements Runnable, Closeable {

    /* renamed from: a  reason: collision with root package name */
    public final SocketChannel f9648a;
    public final SecurityManager b;
    public volatile boolean c = true;
    public InputStream d = null;

    public SocketChannelReadTask(SocketChannel socketChannel) {
        if (socketChannel != null) {
            this.f9648a = socketChannel;
            this.b = socketChannel.i0();
            return;
        }
        throw new NullPointerException("SocketChannel is null");
    }

    public final ByteBuffer b(int i, ByteBuffer byteBuffer) {
        if (i >= byteBuffer.capacity() || !this.f9648a.c1()) {
            return ByteBuffer.allocate(i);
        }
        byteBuffer.clear();
        byteBuffer.limit(i);
        return byteBuffer;
    }

    public final int c(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer, int i) {
        if (byteBuffer == null || i == 0) {
            return 0;
        }
        ProtocolLogger b2 = ProtocolConfig.b();
        byteBuffer.limit(i);
        int read = readableByteChannel.read(byteBuffer);
        if (read == -1) {
            b2.i("SocketChannelReadTask", this.f9648a.g() + " read channel closed.");
            return -1;
        } else if (read < 0 || read > i) {
            throw new ProtocolException("Read bytes too long or too short: " + read + ", expect: " + i);
        } else {
            while (read < i) {
                int read2 = readableByteChannel.read(byteBuffer);
                if (read2 == -1) {
                    b2.i("SocketChannelReadTask", this.f9648a.g() + " channel read channel closed.");
                    return -1;
                }
                read += read2;
            }
            if (read == i) {
                return read;
            }
            throw new ProtocolException("Read bytes length less than buff length: " + read);
        }
    }

    public synchronized void close() {
        try {
            if (this.c) {
                InputStream inputStream = this.d;
                if (inputStream != null) {
                    inputStream.close();
                }
                this.c = false;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final InputStream d() {
        ProtocolLogger b2 = ProtocolConfig.b();
        if (!this.f9648a.p0()) {
            b2.e("SocketChannelReadTask", "Start read thread error: socket channel is not connected");
            return null;
        }
        try {
            Socket f0 = this.f9648a.f0();
            if (f0 != null) {
                return f0.getInputStream();
            }
            b2.e("SocketChannelReadTask", "Start read thread error: socket is null");
            return null;
        } catch (IOException e) {
            b2.e("SocketChannelReadTask", "Start read thread error: " + e.getMessage(), e);
            return null;
        }
    }

    public boolean g() {
        return this.b != null;
    }

    public final /* synthetic */ void i(ProtocolLogger protocolLogger, UCarMessage uCarMessage) {
        if (protocolLogger.a()) {
            protocolLogger.i("SocketChannelReadTask", uCarMessage.a());
        }
        if (uCarMessage.h() == MessageType.RES) {
            FutureRequestManager.e().d(uCarMessage);
            return;
        }
        this.f9648a.K0(uCarMessage);
        uCarMessage.u();
    }

    public final void j() {
        if (this.d != null) {
            ProtocolLogger b2 = ProtocolConfig.b();
            try {
                int available = this.d.available();
                if (available > 0) {
                    long skip = this.d.skip((long) available);
                    b2.w("SocketChannelReadTask", "Skip data len: " + skip);
                }
            } catch (IOException e) {
                b2.e("SocketChannelReadTask", "Skip data len error: " + e.getMessage(), e);
            }
        }
    }

    public void run() {
        UCarMessage uCarMessage;
        UCarMessage uCarMessage2;
        ProtocolLogger b2 = ProtocolConfig.b();
        InputStream d2 = d();
        this.d = d2;
        if (d2 != null) {
            ReadableByteChannel newChannel = Channels.newChannel(d2);
            ByteBuffer allocate = ByteBuffer.allocate(20);
            MessageHeader j = MessageHeader.j();
            ByteBuffer allocate2 = ByteBuffer.allocate(131072);
            while (true) {
                if (!this.c) {
                    break;
                }
                boolean c1 = this.f9648a.c1();
                try {
                    allocate.clear();
                    if (c(newChannel, allocate, 20) == -1) {
                        break;
                    }
                    allocate.flip();
                    j.c(allocate.array());
                    int f = j.f() - 20;
                    if (f < 0) {
                        b2.e("SocketChannelReadTask", "Read data parse not normal, find body len < 0");
                        j();
                    } else {
                        ByteBuffer b3 = b(f, allocate2);
                        if (c(newChannel, b3, f) == -1) {
                            break;
                        }
                        b3.flip();
                        if (c1) {
                            uCarMessage = UCarMessage.s();
                            MessageHeader b4 = uCarMessage.g().b(j);
                            if (!g() || b4.h()) {
                                uCarMessage.w(b3, f);
                            } else {
                                ByteBuffer c2 = this.b.c(b3, false);
                                b4.r(c2.remaining());
                                uCarMessage.w(c2, c2.remaining());
                            }
                        } else {
                            MessageHeader b5 = MessageHeader.j().b(j);
                            if (!g() || b5.h()) {
                                uCarMessage2 = new UCarMessage(b5, b3, f);
                            } else {
                                ByteBuffer b6 = this.b.b(b3);
                                uCarMessage2 = new UCarMessage(b5, b6, b6.remaining());
                                b5.r(b6.remaining());
                            }
                            uCarMessage = uCarMessage2;
                        }
                        ProtocolConfig.c(this.f9648a.n()).submit(new a(this, b2, uCarMessage));
                    }
                } catch (IOException e) {
                    if (this.c) {
                        b2.e("SocketChannelReadTask", "Read data in channel: " + this.f9648a.g() + " Error.", e);
                    }
                } catch (ProtocolException e2) {
                    b2.e("SocketChannelReadTask", "parse message error: " + e2.getMessage(), e2);
                    j();
                }
            }
            if (this.c) {
                try {
                    this.f9648a.close();
                } catch (IOException e3) {
                    b2.e("SocketChannelReadTask", this.f9648a.g() + "read channel close failed.", e3);
                }
            }
        }
    }
}
