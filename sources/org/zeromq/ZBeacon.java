package org.zeromq;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.DatagramChannel;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.eclipse.jetty.util.StringUtil;

public class ZBeacon {
    public static final InetAddress d;
    public static final InetAddress e;

    /* renamed from: a  reason: collision with root package name */
    public final AtomicReference f3483a;
    public final AtomicReference b;
    public final AtomicReference c;

    public class BroadcastClient implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final InetSocketAddress f3484a;
        public final InetAddress b;
        public final AtomicLong c;
        public boolean d;
        public Thread e;
        public final /* synthetic */ ZBeacon f;

        public void run() {
            DatagramChannel open;
            try {
                open = DatagramChannel.open();
                open.socket().setBroadcast(true);
                open.socket().setReuseAddress(true);
                open.socket().bind(new InetSocketAddress(this.b, 0));
                open.connect(this.f3484a);
                this.d = true;
                while (!Thread.interrupted() && this.d) {
                    open.send(ByteBuffer.wrap((byte[]) this.f.b.get()), this.f3484a);
                    Thread.sleep(this.c.get());
                }
            } catch (InterruptedException | ClosedByInterruptException unused) {
                Thread.currentThread().interrupt();
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            } catch (IOException e3) {
                try {
                    throw new RuntimeException(e3);
                } catch (Throwable th) {
                    this.d = false;
                    this.e = null;
                    throw th;
                }
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            open.close();
            this.d = false;
            this.e = null;
            return;
            throw th;
        }
    }

    public class BroadcastServer implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final DatagramChannel f3485a;
        public final boolean b;
        public Thread c;
        public boolean d;
        public final /* synthetic */ ZBeacon e;

        public final void a(ByteBuffer byteBuffer, InetAddress inetAddress) {
            byte[] bArr = (byte[]) this.e.f3483a.get();
            if (byteBuffer.remaining() >= bArr.length) {
                byteBuffer.flip();
                byteBuffer.mark();
                byte[] bArr2 = new byte[bArr.length];
                byteBuffer.get(bArr2);
                if (Arrays.equals(bArr, bArr2)) {
                    byteBuffer.reset();
                    byte[] bArr3 = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bArr3);
                    ((Listener) this.e.c.get()).a(inetAddress, bArr3);
                }
            }
        }

        public void run() {
            ByteBuffer allocate = ByteBuffer.allocate(65535);
            this.d = true;
            while (!Thread.interrupted() && this.d) {
                try {
                    allocate.clear();
                    InetAddress address = ((InetSocketAddress) this.f3485a.receive(allocate)).getAddress();
                    if (this.b) {
                        if (!InetAddress.getLocalHost().getHostAddress().equals(address.getHostAddress()) && !address.isAnyLocalAddress()) {
                            if (address.isLoopbackAddress()) {
                            }
                        }
                    }
                    a(allocate, address);
                } catch (ClosedChannelException unused) {
                } catch (IOException e2) {
                    this.d = false;
                    throw new RuntimeException(e2);
                } catch (Throwable th) {
                    this.f3485a.socket().close();
                    this.d = false;
                    this.c = null;
                    throw th;
                }
            }
            this.f3485a.socket().close();
            this.d = false;
            this.c = null;
        }
    }

    public static class Builder {
    }

    public interface Listener {
        void a(InetAddress inetAddress, byte[] bArr);
    }

    static {
        try {
            d = InetAddress.getByName("255.255.255.255");
            e = InetAddress.getByName(StringUtil.ALL_INTERFACES);
        } catch (UnknownHostException e2) {
            throw new IllegalArgumentException("Invalid default broadcast address", e2);
        }
    }
}
