package com.ucar.protocol.channel.socket;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.g3.b;
import com.honey.account.g3.d;
import com.honey.account.g3.e;
import com.honey.account.g3.f;
import com.honey.account.g3.g;
import com.honey.account.g3.h;
import com.honey.account.g3.i;
import com.honey.account.g3.j;
import com.ucar.protocol.MessageHeader;
import com.ucar.protocol.MessageType;
import com.ucar.protocol.ProtocolConfig;
import com.ucar.protocol.ProtocolException;
import com.ucar.protocol.UCarMessage;
import com.ucar.protocol.channel.ChannelException;
import com.ucar.protocol.channel.ChannelType;
import com.ucar.protocol.channel.FutureCallback;
import com.ucar.protocol.channel.SendFutureCallback;
import com.ucar.protocol.channel.UCarChannel;
import com.ucar.protocol.log.ProtocolLogger;
import com.ucar.protocol.security.SecurityManager;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.LongCompanionObject;

public class SocketChannel extends NetChannel {
    public volatile boolean f = false;
    public ServerSocket g;
    public Socket h;
    public UCarChannel.MessageHandler i;
    public SecurityManager j;
    public ExecutorService k;
    public ExecutorService l;
    public SocketChannelReadTask m;
    public int n = 100;
    public volatile boolean o = false;
    public boolean p = false;
    public final Object q = new Object();

    public SocketChannel(ChannelType channelType, boolean z, boolean z2) {
        super(channelType, z);
        if (z2) {
            this.j = new SecurityManager();
        }
    }

    public static InetSocketAddress G0(String str, int i2) {
        String[] split = str.split("\\.");
        if (split.length == 4) {
            byte[] bArr = new byte[4];
            int i3 = 0;
            while (i3 < 4) {
                if (TextUtils.isDigitsOnly(split[i3])) {
                    bArr[i3] = (byte) (Integer.parseInt(split[i3]) & 255);
                    i3++;
                } else {
                    throw new UnknownHostException("invalid ip address");
                }
            }
            return new InetSocketAddress(InetAddress.getByAddress(bArr), i2);
        }
        throw new UnknownHostException("ip address is of illegal length");
    }

    public final /* synthetic */ Boolean A0(UCarMessage uCarMessage, SendFutureCallback sendFutureCallback) {
        try {
            OutputStream outputStream = this.h.getOutputStream();
            if (q0()) {
                UCarMessage s = UCarMessage.s();
                MessageHeader b = s.g().b(uCarMessage.g());
                ByteBuffer e = this.j.e(uCarMessage.c());
                b.t(e.remaining() + 20);
                byte[] q2 = b.q();
                s.u();
                outputStream.write(q2);
                outputStream.write(e.array(), 0, e.remaining());
            } else {
                outputStream.write(uCarMessage.g().q());
                outputStream.write(uCarMessage.l(), uCarMessage.c().arrayOffset(), uCarMessage.e());
            }
            outputStream.flush();
            if (sendFutureCallback != null) {
                sendFutureCallback.a(Boolean.TRUE);
            }
            Boolean bool = Boolean.TRUE;
            uCarMessage.u();
            return bool;
        } catch (Exception e2) {
            ProtocolLogger b2 = ProtocolConfig.b();
            b2.e("SocketChannel", "Send message error: \n" + uCarMessage.a(), e2);
            if (sendFutureCallback != null) {
                sendFutureCallback.c(e2);
            }
            uCarMessage.u();
            return Boolean.FALSE;
        } catch (Throwable th) {
            uCarMessage.u();
            throw th;
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processExcHandler(RegionMaker.java:1043)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:975)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public final /* synthetic */ java.lang.Boolean B0(java.util.Map r8, java.lang.String r9, int r10) {
        /*
            r7 = this;
            com.ucar.protocol.log.ProtocolLogger r0 = com.ucar.protocol.ProtocolConfig.b()
            r1 = 1
            r2 = r1
        L_0x0006:
            int r3 = r7.n
            if (r2 > r3) goto L_0x00e7
            java.net.Socket r3 = new java.net.Socket     // Catch:{ IOException -> 0x005b }
            r3.<init>()     // Catch:{ IOException -> 0x005b }
            r7.h = r3     // Catch:{ IOException -> 0x005b }
            r3.setKeepAlive(r1)     // Catch:{ IOException -> 0x005b }
            r7.T0(r8)     // Catch:{ IOException -> 0x005b }
            java.net.Socket r3 = r7.h     // Catch:{ IOException -> 0x005b }
            java.net.InetSocketAddress r4 = G0(r9, r10)     // Catch:{ IOException -> 0x005b }
            r5 = 100
            r3.connect(r4, r5)     // Catch:{ IOException -> 0x005b }
            java.lang.Object r3 = r7.q     // Catch:{ IOException -> 0x005b }
            monitor-enter(r3)     // Catch:{ IOException -> 0x005b }
            boolean r4 = r7.o     // Catch:{ all -> 0x0053 }
            if (r4 != 0) goto L_0x0055
            r7.a1()     // Catch:{ all -> 0x0053 }
            r7.R0(r1)     // Catch:{ all -> 0x0053 }
            r7.Z0()     // Catch:{ all -> 0x0053 }
            java.lang.String r4 = "SocketChannel"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0053 }
            r5.<init>()     // Catch:{ all -> 0x0053 }
            java.lang.String r6 = r7.g()     // Catch:{ all -> 0x0053 }
            r5.append(r6)     // Catch:{ all -> 0x0053 }
            java.lang.String r6 = " client channel connect success!"
            r5.append(r6)     // Catch:{ all -> 0x0053 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0053 }
            r0.i(r4, r5)     // Catch:{ all -> 0x0053 }
            r7.H0()     // Catch:{ all -> 0x0053 }
            java.lang.Boolean r4 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0053 }
            monitor-exit(r3)     // Catch:{ all -> 0x0053 }
            return r4
        L_0x0053:
            r4 = move-exception
            goto L_0x0059
        L_0x0055:
            java.lang.Boolean r4 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0053 }
            monitor-exit(r3)     // Catch:{ all -> 0x0053 }
            return r4
        L_0x0059:
            monitor-exit(r3)     // Catch:{ all -> 0x0053 }
            throw r4     // Catch:{ IOException -> 0x005b }
        L_0x005b:
            r3 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r7.g()
            r4.append(r5)
            java.lang.String r5 = " channel connect error "
            r4.append(r5)
            java.lang.String r5 = r7.T()
            r4.append(r5)
            java.lang.String r5 = ": "
            r4.append(r5)
            java.lang.String r5 = r3.getMessage()
            r4.append(r5)
            java.lang.String r5 = ", try times: "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            java.lang.Object r5 = r7.q
            monitor-enter(r5)
            boolean r6 = r7.o     // Catch:{ all -> 0x00ad }
            if (r6 == 0) goto L_0x00af
            java.lang.String r7 = "SocketChannel"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ad }
            r8.<init>()     // Catch:{ all -> 0x00ad }
            r8.append(r4)     // Catch:{ all -> 0x00ad }
            java.lang.String r9 = ", socket closed"
            r8.append(r9)     // Catch:{ all -> 0x00ad }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x00ad }
            r0.e(r7, r8, r3)     // Catch:{ all -> 0x00ad }
            java.lang.Boolean r7 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00ad }
            monitor-exit(r5)     // Catch:{ all -> 0x00ad }
            return r7
        L_0x00ad:
            r7 = move-exception
            goto L_0x00e5
        L_0x00af:
            monitor-exit(r5)     // Catch:{ all -> 0x00ad }
            java.net.Socket r5 = r7.h
            r7.d0(r5)
            int r5 = r7.n
            if (r2 >= r5) goto L_0x00d9
            int r3 = r2 % 10
            if (r3 != 0) goto L_0x00d3
            java.lang.String r3 = "SocketChannel"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            java.lang.String r4 = ", will try again."
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            r0.w(r3, r4)
        L_0x00d3:
            r3 = 100
            java.lang.Thread.sleep(r3)
            goto L_0x00e1
        L_0x00d9:
            java.lang.String r5 = "SocketChannel"
            r0.e(r5, r4, r3)
            r7.I0(r3)
        L_0x00e1:
            int r2 = r2 + 1
            goto L_0x0006
        L_0x00e5:
            monitor-exit(r5)     // Catch:{ all -> 0x00ad }
            throw r7
        L_0x00e7:
            com.ucar.protocol.channel.ChannelException r8 = new com.ucar.protocol.channel.ChannelException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = r7.g()
            r9.append(r10)
            java.lang.String r10 = " channel connect fail after "
            r9.append(r10)
            int r7 = r7.n
            r9.append(r7)
            java.lang.String r7 = " times"
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            r8.<init>(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucar.protocol.channel.socket.SocketChannel.B0(java.util.Map, java.lang.String, int):java.lang.Boolean");
    }

    public final /* synthetic */ void C0() {
        this.m.run();
        R0(false);
    }

    public final /* synthetic */ Thread D0(Runnable runnable) {
        Thread thread = new Thread(runnable, c("R"));
        thread.setDaemon(true);
        return thread;
    }

    public final /* synthetic */ Thread E0(Runnable runnable) {
        Thread thread = new Thread(runnable, c(ExifInterface.LONGITUDE_WEST));
        thread.setDaemon(true);
        return thread;
    }

    public final /* synthetic */ Boolean F0(String str, int i2, Map map) {
        ProtocolLogger b = ProtocolConfig.b();
        try {
            ServerSocket serverSocket = new ServerSocket();
            this.g = serverSocket;
            serverSocket.setReuseAddress(true);
            this.g.bind(G0(str, i2));
            L0();
            b.i("SocketChannel", g() + " server channel bind at " + T());
            try {
                Socket accept = this.g.accept();
                this.h = accept;
                accept.setKeepAlive(true);
                T0(map);
                b.i("SocketChannel", g() + " accept an client channel: " + this.h.getRemoteSocketAddress());
                synchronized (this.q) {
                    try {
                        if (!this.o) {
                            a1();
                            R0(true);
                            Z0();
                            b.i("SocketChannel", g() + " server channel connect success!");
                            H0();
                            S();
                            Boolean bool = Boolean.TRUE;
                            return bool;
                        }
                        Boolean bool2 = Boolean.FALSE;
                        return bool2;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (IOException e) {
                M0();
                throw new ChannelException(g() + " server channel accept error.", e);
            }
        } catch (Exception e2) {
            String str2 = g() + " server channel start fail: " + e2.getMessage();
            b.e("SocketChannel", str2, e2);
            close();
            throw new ChannelException(str2, e2);
        }
    }

    public void H0() {
    }

    public void I0(Throwable th) {
    }

    public void J0(boolean z) {
    }

    public void K0(UCarMessage uCarMessage) {
        boolean z;
        ProtocolLogger b = ProtocolConfig.b();
        UCarChannel.MessageHandler messageHandler = this.i;
        if (messageHandler != null) {
            try {
                messageHandler.a(uCarMessage);
            } catch (Exception e) {
                b.e("SocketChannel", g() + ": handle message " + uCarMessage.k() + " error.", e);
                z = false;
            }
        }
        z = true;
        if (UCarMessage.p(uCarMessage) && z) {
            O0(UCarMessage.t(uCarMessage.k()), new f(b, uCarMessage));
        }
    }

    public void L0() {
    }

    public void M0() {
    }

    public final Future N0(UCarMessage uCarMessage, long j2, FutureCallback futureCallback) {
        if (j2 <= 0) {
            j2 = LongCompanionObject.MAX_VALUE;
        }
        long j3 = j2;
        if (uCarMessage == null) {
            RequestFuture requestFuture = new RequestFuture(futureCallback, 0);
            requestFuture.b(new ProtocolException("Can not send a null message"));
            return requestFuture;
        }
        RequestFuture requestFuture2 = new RequestFuture(futureCallback, j3, uCarMessage.k());
        ProtocolConfig.d().submit(new i(this, uCarMessage, requestFuture2, j3));
        return requestFuture2;
    }

    public Future O0(UCarMessage uCarMessage, SendFutureCallback sendFutureCallback) {
        return P0(uCarMessage, sendFutureCallback, false, -1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0037, code lost:
        r1 = g() + " channel not ready";
        com.ucar.protocol.ProtocolConfig.b().e("SocketChannel", r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0055, code lost:
        if (r3 == null) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0057, code lost:
        r3.c(new com.ucar.protocol.channel.ChannelException(r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005f, code lost:
        r5.complete(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0062, code lost:
        return r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.concurrent.Future P0(com.ucar.protocol.UCarMessage r2, com.ucar.protocol.channel.SendFutureCallback r3, boolean r4, long r5) {
        /*
            r1 = this;
            if (r4 == 0) goto L_0x0007
            java.util.concurrent.Future r1 = r1.Q0(r2, r5, r3)
            return r1
        L_0x0007:
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            java.util.concurrent.CompletableFuture r5 = java.util.concurrent.CompletableFuture.completedFuture(r4)
            if (r2 != 0) goto L_0x001a
            com.ucar.protocol.ProtocolException r1 = new com.ucar.protocol.ProtocolException
            java.lang.String r2 = "Can not send a null message"
            r1.<init>(r2)
            r5.completeExceptionally(r1)
            return r5
        L_0x001a:
            java.lang.Object r6 = r1.q
            monitor-enter(r6)
            java.util.concurrent.ExecutorService r0 = r1.k     // Catch:{ all -> 0x0034 }
            if (r0 == 0) goto L_0x0036
            boolean r0 = r0.isShutdown()     // Catch:{ all -> 0x0034 }
            if (r0 != 0) goto L_0x0036
            java.util.concurrent.ExecutorService r4 = r1.k     // Catch:{ all -> 0x0034 }
            com.honey.account.g3.c r5 = new com.honey.account.g3.c     // Catch:{ all -> 0x0034 }
            r5.<init>(r1, r2, r3)     // Catch:{ all -> 0x0034 }
            java.util.concurrent.Future r1 = r4.submit(r5)     // Catch:{ all -> 0x0034 }
            monitor-exit(r6)     // Catch:{ all -> 0x0034 }
            return r1
        L_0x0034:
            r1 = move-exception
            goto L_0x0063
        L_0x0036:
            monitor-exit(r6)     // Catch:{ all -> 0x0034 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r1 = r1.g()
            r2.append(r1)
            java.lang.String r1 = " channel not ready"
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            com.ucar.protocol.log.ProtocolLogger r2 = com.ucar.protocol.ProtocolConfig.b()
            java.lang.String r6 = "SocketChannel"
            r2.e(r6, r1)
            if (r3 == 0) goto L_0x005f
            com.ucar.protocol.channel.ChannelException r2 = new com.ucar.protocol.channel.ChannelException
            r2.<init>(r1)
            r3.c(r2)
        L_0x005f:
            r5.complete(r4)
            return r5
        L_0x0063:
            monitor-exit(r6)     // Catch:{ all -> 0x0034 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucar.protocol.channel.socket.SocketChannel.P0(com.ucar.protocol.UCarMessage, com.ucar.protocol.channel.SendFutureCallback, boolean, long):java.util.concurrent.Future");
    }

    public final Future Q0(UCarMessage uCarMessage, long j2, final SendFutureCallback sendFutureCallback) {
        return N0(uCarMessage.z(MessageType.SEND_SYNC), j2, new FutureCallback<Boolean>() {
            public void c(Exception exc) {
                SendFutureCallback sendFutureCallback = sendFutureCallback;
                if (sendFutureCallback != null) {
                    sendFutureCallback.c(exc);
                }
            }

            /* renamed from: d */
            public void a(Boolean bool) {
                SendFutureCallback sendFutureCallback = sendFutureCallback;
                if (sendFutureCallback != null) {
                    sendFutureCallback.a(Boolean.valueOf(bool != null));
                }
            }

            public Boolean b(UCarMessage uCarMessage) {
                return Boolean.valueOf(uCarMessage != null);
            }
        });
    }

    public final void R0(boolean z) {
        this.f = z;
    }

    public final void S() {
        ProtocolConfig.b().i("SocketChannel", "Wait more client connection.");
        Thread thread = new Thread(new e(this));
        thread.setDaemon(true);
        thread.setName(c("M"));
        thread.start();
    }

    public void S0(UCarChannel.MessageHandler messageHandler) {
        if (p0()) {
            ProtocolConfig.b().w("SocketChannel", "Set message handler after channel connected may loss message!");
        }
        this.i = messageHandler;
    }

    public final String T() {
        return a() + AccountConstantKt.CODE_SEPARTOR + b();
    }

    public final void T0(Map map) {
        if (this.h != null && map != null) {
            ProtocolConfig.b().i("SocketChannel", " set Socket Extra Options!");
            boolean z = false;
            if (map.containsKey("TcpNoDelay")) {
                this.h.setTcpNoDelay(((Integer) map.get("TcpNoDelay")).intValue() != 0);
            }
            if (map.containsKey("ReuseAddress")) {
                this.h.setReuseAddress(((Integer) map.get("ReuseAddress")).intValue() != 0);
            }
            if (map.containsKey("SoLingerMode") && map.containsKey("Linger")) {
                Socket socket = this.h;
                if (((Integer) map.get("SoLingerMode")).intValue() != 0) {
                    z = true;
                }
                socket.setSoLinger(z, ((Integer) map.get("Linger")).intValue());
            }
            if (map.containsKey("TrafficClass")) {
                this.h.setTrafficClass(((Integer) map.get("TrafficClass")).intValue());
            }
        }
    }

    public final void U() {
        synchronized (this.q) {
            try {
                this.o = true;
                ExecutorService executorService = this.l;
                if (executorService != null) {
                    executorService.shutdown();
                    this.l = null;
                }
                ExecutorService executorService2 = this.k;
                if (executorService2 != null) {
                    executorService2.shutdown();
                    this.k = null;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        d0(this.m);
        d0(this.h);
        d0(this.g);
        R0(false);
    }

    public void U0(int i2) {
        this.n = i2;
    }

    public Future V0() {
        if (d()) {
            ProtocolLogger b = ProtocolConfig.b();
            b.i("SocketChannel", g() + " server channel starting: " + T());
            return b1(b(), a(), (Map) null);
        }
        ProtocolLogger b2 = ProtocolConfig.b();
        b2.i("SocketChannel", g() + " client channel starting: " + T());
        return Y0(b(), a(), (Map) null);
    }

    public Future W0(int i2, String str) {
        if (n() == ChannelType.CUSTOM) {
            j(i2);
        }
        i(str);
        return V0();
    }

    public Future X0(int i2, String str, Map map) {
        if (n() == ChannelType.CUSTOM) {
            j(i2);
        }
        i(str);
        if (d()) {
            ProtocolLogger b = ProtocolConfig.b();
            b.i("SocketChannel", g() + " server channel starting: " + T());
            return b1(b(), a(), map);
        }
        ProtocolLogger b2 = ProtocolConfig.b();
        b2.i("SocketChannel", g() + " client channel starting: " + T());
        return Y0(b(), a(), map);
    }

    public final Future Y0(int i2, String str, Map map) {
        synchronized (this.q) {
            c0();
            this.o = false;
        }
        FutureTask futureTask = new FutureTask(new b(this, map, str, i2));
        Thread thread = new Thread(futureTask, c("C"));
        thread.setDaemon(true);
        thread.start();
        return futureTask;
    }

    public final void Z0() {
        d0(this.m);
        this.m = new SocketChannelReadTask(this);
        this.l.submit(new j(this));
    }

    public final void a1() {
        this.l = Executors.newSingleThreadExecutor(new g(this));
        this.k = Executors.newSingleThreadExecutor(new h(this));
    }

    public int b() {
        ServerSocket serverSocket;
        int i2 = this.c;
        if (i2 != 0) {
            return i2;
        }
        if (n() != ChannelType.CUSTOM) {
            this.c = n().getPort();
        } else if (!d() || (serverSocket = this.g) == null || serverSocket.isClosed()) {
            Socket socket = this.h;
            if (socket != null && socket.isConnected()) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) this.h.getRemoteSocketAddress();
                if (inetSocketAddress != null) {
                    this.c = inetSocketAddress.getPort();
                } else {
                    ProtocolConfig.b().e("SocketChannel", "InetSocketAddress is invalid");
                    return -1;
                }
            }
        } else {
            this.c = this.g.getLocalPort();
        }
        return this.c;
    }

    public final Future b1(int i2, String str, Map map) {
        synchronized (this.q) {
            c0();
            this.o = false;
        }
        FutureTask futureTask = new FutureTask(new d(this, str, i2, map));
        Thread thread = new Thread(futureTask, c(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS));
        thread.setDaemon(true);
        thread.start();
        return futureTask;
    }

    public void c0() {
        try {
            U();
        } catch (IOException e) {
            ProtocolLogger b = ProtocolConfig.b();
            b.w("SocketChannel", "Close error: " + e.getMessage(), e);
        }
    }

    public boolean c1() {
        return this.p;
    }

    public final void close() {
        U();
        ProtocolLogger b = ProtocolConfig.b();
        StringBuilder sb = new StringBuilder();
        sb.append(g());
        sb.append(d() ? " server" : " client");
        sb.append(" disconnect.");
        b.i("SocketChannel", sb.toString());
        J0(d());
    }

    public final void d0(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                ProtocolLogger b = ProtocolConfig.b();
                b.d("SocketChannel", "close quietly:" + e.getMessage());
            }
        }
    }

    public Socket f0() {
        return this.h;
    }

    public SecurityManager i0() {
        return this.j;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r1.h;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean p0() {
        /*
            r1 = this;
            boolean r0 = r1.f
            if (r0 == 0) goto L_0x0010
            java.net.Socket r1 = r1.h
            if (r1 == 0) goto L_0x0010
            boolean r1 = r1.isConnected()
            if (r1 == 0) goto L_0x0010
            r1 = 1
            goto L_0x0011
        L_0x0010:
            r1 = 0
        L_0x0011:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucar.protocol.channel.socket.SocketChannel.p0():boolean");
    }

    public boolean q0() {
        return i0() != null;
    }

    public final /* synthetic */ void r0() {
        ProtocolLogger b = ProtocolConfig.b();
        while (!this.g.isClosed()) {
            try {
                Socket accept = this.g.accept();
                if (p0()) {
                    b.e("SocketChannel", "ATTENTION: Found unknown connection from:" + accept.getRemoteSocketAddress());
                    accept.close();
                } else {
                    try {
                        b.i("SocketChannel", g() + " channel accept another client: " + this.h.getRemoteSocketAddress());
                        d0(this.h);
                        this.h = accept;
                        accept.setKeepAlive(true);
                        this.h.setTcpNoDelay(true);
                        synchronized (this.q) {
                            if (!this.o) {
                                R0(true);
                                Z0();
                                b.i("SocketChannel", g() + " server channel reconnect success!");
                                H0();
                            }
                        }
                    } catch (IOException e) {
                        b.e("SocketChannel", "connect more connect error: " + e.getMessage(), e);
                        d0(this.h);
                        R0(false);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Exception e2) {
                b.e("SocketChannel", "accept more connection error: " + e2.getMessage(), e2);
                return;
            }
        }
    }

    public final /* synthetic */ void z0(UCarMessage uCarMessage, RequestFuture requestFuture, long j2) {
        int k2 = uCarMessage.k();
        try {
            FutureRequestManager.e().b(requestFuture);
            if (!((Boolean) O0(uCarMessage, (SendFutureCallback) null).get(j2, TimeUnit.MILLISECONDS)).booleanValue()) {
                FutureRequestManager.e().g(k2);
                requestFuture.b(new ChannelException("Send request fail: " + k2));
            }
        } catch (Exception e) {
            FutureRequestManager.e().g(k2);
            requestFuture.b(e);
        }
    }
}
