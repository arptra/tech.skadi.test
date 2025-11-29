package com.upuphone.runasone.channel.proxy.client;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.honey.account.v5.a;
import com.meizu.net.pedometerprovider.manager.PedoManager;
import com.upuphone.runasone.channel.proxy.client.channel.IPackHandler;
import com.upuphone.runasone.channel.proxy.client.tcpip.CommonMethods;
import com.upuphone.runasone.channel.proxy.client.util.DebugLog;
import com.upuphone.runasone.channel.proxy.client.util.Global;
import com.upuphone.runasone.channel.proxy.util.ByteHelper;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.ArrayList;
import java.util.List;

public class UDPHandler implements IPackHandler {
    private static final String TAG = "UDPHandler";
    private volatile boolean isFirstLoad = true;
    /* access modifiers changed from: private */
    public boolean[] isRunning;
    private volatile boolean isTimeOutCheckProcess = false;
    private List<Runnable> mCachePacks = new ArrayList();
    private Runnable mCheckSupportRunnable = new Runnable() {
        public void run() {
            if (UDPHandler.this.isProxyAddressNull()) {
                try {
                    DebugLog.i("%s : mThread interrupt()", UDPHandler.TAG);
                    UDPHandler.this.mThread.interrupt();
                    Thread unused = UDPHandler.this.mThread = null;
                } catch (Exception unused2) {
                }
                try {
                    DebugLog.i("%s : socket close() ", UDPHandler.TAG);
                    UDPHandler.this.socket.close();
                    Socket unused3 = UDPHandler.this.socket = null;
                } catch (Exception unused4) {
                }
                synchronized (UDPHandler.this) {
                    try {
                        if (UDPHandler.this.isRunning != null) {
                            UDPHandler.this.isRunning[0] = false;
                            boolean[] unused5 = UDPHandler.this.isRunning = null;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    };
    private ByteBuffer mDataPack = ByteBuffer.wrap(new byte[PedoManager.HOUR_MAX_STEP]);
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Runnable mResponseTimeOutRunnable = new Runnable() {
        public void run() {
        }
    };
    /* access modifiers changed from: private */
    public Thread mThread;
    private volatile InetSocketAddress proxyAddress;
    /* access modifiers changed from: private */
    public Socket socket;
    /* access modifiers changed from: private */
    public volatile String sourceAddress;
    /* access modifiers changed from: private */
    public volatile int sourcePort;

    private void connectProxyServer() {
        synchronized (this) {
            try {
                boolean[] zArr = this.isRunning;
                if (zArr == null || !zArr[0]) {
                    this.mHandler.postDelayed(this.mCheckSupportRunnable, 15000);
                    boolean[] zArr2 = new boolean[1];
                    this.isRunning = zArr2;
                    zArr2[0] = true;
                    DebugLog.v("%s : connectProxyServer", TAG);
                    final boolean[] zArr3 = this.isRunning;
                    final InetSocketAddress inetSocketAddress = Global.HOLDER.getInetSocketAddress();
                    Global.HOLDER.getPackHandler().setProxyAddress(new InetSocketAddress(inetSocketAddress.getAddress(), Global.HOLDER.getUdpServerPort()));
                    Thread thread = new Thread(new Runnable() {
                        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public void run() {
                            /*
                                r5 = this;
                                r0 = 0
                                com.upuphone.runasone.channel.proxy.client.UDPHandler r1 = com.upuphone.runasone.channel.proxy.client.UDPHandler.this     // Catch:{ Exception -> 0x0082 }
                                java.net.Socket r2 = new java.net.Socket     // Catch:{ Exception -> 0x0082 }
                                r2.<init>()     // Catch:{ Exception -> 0x0082 }
                                java.net.Socket unused = r1.socket = r2     // Catch:{ Exception -> 0x0082 }
                                com.upuphone.runasone.channel.proxy.client.UDPHandler r1 = com.upuphone.runasone.channel.proxy.client.UDPHandler.this     // Catch:{ Exception -> 0x0082 }
                                java.net.Socket r1 = r1.socket     // Catch:{ Exception -> 0x0082 }
                                java.net.InetSocketAddress r2 = new java.net.InetSocketAddress     // Catch:{ Exception -> 0x0082 }
                                java.lang.String r3 = "10.8.0.2"
                                r2.<init>(r3, r0)     // Catch:{ Exception -> 0x0082 }
                                r1.bind(r2)     // Catch:{ Exception -> 0x0082 }
                                com.upuphone.runasone.channel.proxy.client.UDPHandler r1 = com.upuphone.runasone.channel.proxy.client.UDPHandler.this     // Catch:{ Exception -> 0x0082 }
                                monitor-enter(r1)     // Catch:{ Exception -> 0x0082 }
                                com.upuphone.runasone.channel.proxy.client.UDPHandler r2 = com.upuphone.runasone.channel.proxy.client.UDPHandler.this     // Catch:{ all -> 0x0094 }
                                java.net.Socket r3 = r2.socket     // Catch:{ all -> 0x0094 }
                                java.net.InetAddress r3 = r3.getLocalAddress()     // Catch:{ all -> 0x0094 }
                                java.lang.String r3 = r3.getHostAddress()     // Catch:{ all -> 0x0094 }
                                java.lang.String unused = r2.sourceAddress = r3     // Catch:{ all -> 0x0094 }
                                com.upuphone.runasone.channel.proxy.client.UDPHandler r2 = com.upuphone.runasone.channel.proxy.client.UDPHandler.this     // Catch:{ all -> 0x0094 }
                                java.net.Socket r3 = r2.socket     // Catch:{ all -> 0x0094 }
                                int r3 = r3.getLocalPort()     // Catch:{ all -> 0x0094 }
                                int unused = r2.sourcePort = r3     // Catch:{ all -> 0x0094 }
                                monitor-exit(r1)     // Catch:{ all -> 0x0094 }
                                java.lang.String r1 = "%s sourceAddress=%s, sourcePort=%d"
                                java.lang.String r2 = "UDPHandler"
                                com.upuphone.runasone.channel.proxy.client.UDPHandler r3 = com.upuphone.runasone.channel.proxy.client.UDPHandler.this     // Catch:{ Exception -> 0x0082 }
                                java.lang.String r3 = r3.sourceAddress     // Catch:{ Exception -> 0x0082 }
                                com.upuphone.runasone.channel.proxy.client.UDPHandler r4 = com.upuphone.runasone.channel.proxy.client.UDPHandler.this     // Catch:{ Exception -> 0x0082 }
                                int r4 = r4.sourcePort     // Catch:{ Exception -> 0x0082 }
                                java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0082 }
                                java.lang.Object[] r2 = new java.lang.Object[]{r2, r3, r4}     // Catch:{ Exception -> 0x0082 }
                                com.upuphone.runasone.channel.proxy.client.util.DebugLog.v(r1, r2)     // Catch:{ Exception -> 0x0082 }
                                com.upuphone.runasone.channel.proxy.client.UDPHandler r1 = com.upuphone.runasone.channel.proxy.client.UDPHandler.this     // Catch:{ Exception -> 0x0082 }
                                java.net.Socket r1 = r1.socket     // Catch:{ Exception -> 0x0082 }
                                java.net.InetSocketAddress r2 = r1     // Catch:{ Exception -> 0x0082 }
                                r1.connect(r2)     // Catch:{ Exception -> 0x0082 }
                                com.upuphone.runasone.channel.proxy.client.UDPHandler r1 = com.upuphone.runasone.channel.proxy.client.UDPHandler.this     // Catch:{ Exception -> 0x0082 }
                                java.net.Socket r1 = r1.socket     // Catch:{ Exception -> 0x0082 }
                                java.io.InputStream r1 = r1.getInputStream()     // Catch:{ Exception -> 0x0082 }
                            L_0x006d:
                                int r2 = r1.read()     // Catch:{ Exception -> 0x0082 }
                                r3 = -1
                                if (r2 == r3) goto L_0x0084
                                java.lang.String r2 = "%s: continue"
                                java.lang.String r3 = "UDPHandler"
                                java.lang.Object[] r3 = new java.lang.Object[]{r3}     // Catch:{ Exception -> 0x0082 }
                                com.upuphone.runasone.channel.proxy.client.util.DebugLog.i(r2, r3)     // Catch:{ Exception -> 0x0082 }
                                goto L_0x006d
                            L_0x0080:
                                r1 = move-exception
                                goto L_0x00c0
                            L_0x0082:
                                r1 = move-exception
                                goto L_0x0097
                            L_0x0084:
                                com.upuphone.runasone.channel.proxy.client.UDPHandler r1 = com.upuphone.runasone.channel.proxy.client.UDPHandler.this
                                monitor-enter(r1)
                                boolean[] r5 = r0     // Catch:{ all -> 0x008e }
                                if (r5 == 0) goto L_0x0090
                                r5[r0] = r0     // Catch:{ all -> 0x008e }
                                goto L_0x0090
                            L_0x008e:
                                r5 = move-exception
                                goto L_0x0092
                            L_0x0090:
                                monitor-exit(r1)     // Catch:{ all -> 0x008e }
                                goto L_0x00bd
                            L_0x0092:
                                monitor-exit(r1)     // Catch:{ all -> 0x008e }
                                throw r5
                            L_0x0094:
                                r2 = move-exception
                                monitor-exit(r1)     // Catch:{ all -> 0x0094 }
                                throw r2     // Catch:{ Exception -> 0x0082 }
                            L_0x0097:
                                java.lang.String r2 = "%s: e(%d) = %s "
                                java.lang.String r3 = "UDPHandler"
                                com.upuphone.runasone.channel.proxy.client.UDPHandler r4 = com.upuphone.runasone.channel.proxy.client.UDPHandler.this     // Catch:{ all -> 0x0080 }
                                int r4 = r4.sourcePort     // Catch:{ all -> 0x0080 }
                                java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0080 }
                                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0080 }
                                java.lang.Object[] r1 = new java.lang.Object[]{r3, r4, r1}     // Catch:{ all -> 0x0080 }
                                com.upuphone.runasone.channel.proxy.client.util.DebugLog.e(r2, r1)     // Catch:{ all -> 0x0080 }
                                com.upuphone.runasone.channel.proxy.client.UDPHandler r1 = com.upuphone.runasone.channel.proxy.client.UDPHandler.this
                                monitor-enter(r1)
                                boolean[] r5 = r0     // Catch:{ all -> 0x00ba }
                                if (r5 == 0) goto L_0x00bc
                                r5[r0] = r0     // Catch:{ all -> 0x00ba }
                                goto L_0x00bc
                            L_0x00ba:
                                r5 = move-exception
                                goto L_0x00be
                            L_0x00bc:
                                monitor-exit(r1)     // Catch:{ all -> 0x00ba }
                            L_0x00bd:
                                return
                            L_0x00be:
                                monitor-exit(r1)     // Catch:{ all -> 0x00ba }
                                throw r5
                            L_0x00c0:
                                com.upuphone.runasone.channel.proxy.client.UDPHandler r2 = com.upuphone.runasone.channel.proxy.client.UDPHandler.this
                                monitor-enter(r2)
                                boolean[] r5 = r0     // Catch:{ all -> 0x00ca }
                                if (r5 == 0) goto L_0x00cc
                                r5[r0] = r0     // Catch:{ all -> 0x00ca }
                                goto L_0x00cc
                            L_0x00ca:
                                r5 = move-exception
                                goto L_0x00ce
                            L_0x00cc:
                                monitor-exit(r2)     // Catch:{ all -> 0x00ca }
                                throw r1
                            L_0x00ce:
                                monitor-exit(r2)     // Catch:{ all -> 0x00ca }
                                throw r5
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.runasone.channel.proxy.client.UDPHandler.AnonymousClass3.run():void");
                        }
                    });
                    this.mThread = thread;
                    thread.start();
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    private synchronized InetSocketAddress getProxyAddress() {
        return this.proxyAddress;
    }

    /* access modifiers changed from: private */
    public synchronized boolean isProxyAddressNull() {
        return this.proxyAddress == null;
    }

    private InetSocketAddress parseAndSendPackageToLocal(ByteBuffer byteBuffer) {
        String str;
        DebugLog.v("%s : parseAndSendPackageToLocal", TAG);
        if (this.isTimeOutCheckProcess) {
            this.mHandler.removeCallbacks(this.mResponseTimeOutRunnable);
            this.isTimeOutCheckProcess = false;
        }
        byteBuffer.get();
        byteBuffer.get();
        byteBuffer.get();
        byte b = byteBuffer.get();
        if (b == 1) {
            byte[] bArr = new byte[4];
            byteBuffer.get(bArr);
            str = CommonMethods.ipBytesToString(bArr);
        } else if (b == 3) {
            byte[] bArr2 = new byte[(byteBuffer.get() & 65535)];
            byteBuffer.get(bArr2);
            str = new String(bArr2);
        } else {
            str = "";
        }
        byte[] bArr3 = new byte[2];
        byteBuffer.get(bArr3, 0, 2);
        return new InetSocketAddress(str, ByteHelper.byteArrayToInt(bArr3, 0, 2));
    }

    private synchronized void runCache() {
        try {
            for (Runnable run : this.mCachePacks) {
                run.run();
            }
            this.mCachePacks.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: warpAndSendPackageToRemote */
    public void lambda$sendToRemote$0(DatagramChannel datagramChannel, ByteBuffer byteBuffer, InetSocketAddress inetSocketAddress) throws Exception {
        DebugLog.v("%s : warpAndSendPackageToRemote", TAG);
        if (!this.isTimeOutCheckProcess && this.isFirstLoad) {
            this.mHandler.postDelayed(this.mResponseTimeOutRunnable, 15000);
            this.isTimeOutCheckProcess = true;
            this.isFirstLoad = false;
        }
        this.mDataPack.clear();
        this.mDataPack.put((byte) 0).put((byte) 0);
        this.mDataPack.put((byte) 0);
        byte[] address = inetSocketAddress.getAddress().getAddress();
        if (address == null || address.length != 4) {
            this.mDataPack.put((byte) 3);
            byte[] bytes = inetSocketAddress.getAddress().getHostAddress().getBytes();
            this.mDataPack.put((byte) bytes.length);
            this.mDataPack.put(bytes, 0, bytes.length);
        } else {
            this.mDataPack.put((byte) 1);
            this.mDataPack.put(address, 0, 4);
        }
        this.mDataPack.putShort((short) inetSocketAddress.getPort());
        this.mDataPack.put(byteBuffer);
        this.mDataPack.flip();
        datagramChannel.send(this.mDataPack, getProxyAddress());
    }

    public synchronized int getPort() {
        return this.sourcePort;
    }

    public InetSocketAddress parseRemoteData(ByteBuffer byteBuffer, InetSocketAddress inetSocketAddress) {
        DebugLog.v("%s : parseRemoteData", TAG);
        return (isProxyAddressNull() || inetSocketAddress.getPort() != this.proxyAddress.getPort() || !TextUtils.equals(inetSocketAddress.getAddress().getHostAddress(), this.proxyAddress.getAddress().getHostAddress())) ? inetSocketAddress : parseAndSendPackageToLocal(byteBuffer);
    }

    public void sendToRemote(DatagramChannel datagramChannel, ByteBuffer byteBuffer, InetSocketAddress inetSocketAddress) {
        if (isProxyAddressNull()) {
            synchronized (this) {
                try {
                    if (this.mCachePacks.size() >= 200) {
                        this.mCachePacks.remove(0);
                    }
                    this.mCachePacks.add(new a(this, datagramChannel, byteBuffer, inetSocketAddress));
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            connectProxyServer();
            return;
        }
        try {
            lambda$sendToRemote$0(datagramChannel, byteBuffer, inetSocketAddress);
        } catch (Exception unused) {
        }
    }

    public synchronized void setProxyAddress(InetSocketAddress inetSocketAddress) {
        this.proxyAddress = inetSocketAddress;
        runCache();
    }
}
