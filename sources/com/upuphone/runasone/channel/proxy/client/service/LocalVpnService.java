package com.upuphone.runasone.channel.proxy.client.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.net.VpnService;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.upuphone.runasone.channel.proxy.ProxyManager;
import com.upuphone.runasone.channel.proxy.client.ProxyConfig;
import com.upuphone.runasone.channel.proxy.client.nat.NatSession;
import com.upuphone.runasone.channel.proxy.client.nat.NatSessionManager;
import com.upuphone.runasone.channel.proxy.client.nat.UDPMap;
import com.upuphone.runasone.channel.proxy.client.protocol.TCPProxyServer;
import com.upuphone.runasone.channel.proxy.client.protocol.UDPProxyServer;
import com.upuphone.runasone.channel.proxy.client.tcpip.CommonMethods;
import com.upuphone.runasone.channel.proxy.client.tcpip.IPHeader;
import com.upuphone.runasone.channel.proxy.client.tcpip.TCPHeader;
import com.upuphone.runasone.channel.proxy.client.tcpip.UDPHeader;
import com.upuphone.runasone.channel.proxy.client.util.DebugLog;
import com.upuphone.runasone.channel.proxy.client.util.Global;
import com.upuphone.runasone.channel.proxy.client.util.HttpRequestHeaderParser;
import com.upuphone.runasone.uupcast.CaptureType;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Set;
import kotlin.UShort;
import org.eclipse.jetty.util.StringUtil;

public class LocalVpnService extends VpnService implements Runnable {
    private static final String TAG = "LocalVpnService";
    private static int mAllowMode;
    private static int mLocalIP;
    private static Set<String> mPackages = new HashSet();
    private Context mContext;
    private ByteBuffer mDNSBuffer;
    private IPHeader mIPHeader;
    protected Handler mMainHandler;
    private byte[] mPacket;
    private volatile int mRunningState = 0;
    private TCPHeader mTCPHeader;
    private TCPProxyServer mTCPProxyServer;
    private UDPHeader mUDPHeader;
    private UDPProxyServer mUDPProxyServer;
    private FileInputStream mVPNInputStream;
    private ParcelFileDescriptor mVPNInterface;
    private FileOutputStream mVPNOutputStream;
    private Thread mVPNThread;
    final ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() {
        public void onAvailable(Network network) {
            Log.d(LocalVpnService.TAG, "onAvailable network=" + network);
        }
    };
    final NetworkRequest p2pRequest = new NetworkRequest.Builder().addTransportType(4).addCapability(12).removeCapability(15).build();

    public LocalVpnService() {
        DebugLog.i("%s: new LocalVpnService\n", TAG);
        this.mMainHandler = new Handler(Looper.getMainLooper());
        byte[] bArr = new byte[65536];
        this.mPacket = bArr;
        this.mIPHeader = new IPHeader(bArr, 0);
        this.mTCPHeader = new TCPHeader(this.mPacket, 20);
        this.mUDPHeader = new UDPHeader(this.mPacket, 20);
        this.mDNSBuffer = ((ByteBuffer) ByteBuffer.wrap(this.mPacket).position(28)).slice();
    }

    private synchronized void dispose() {
        try {
            disconnectVPN();
            TCPProxyServer tCPProxyServer = this.mTCPProxyServer;
            if (tCPProxyServer != null) {
                tCPProxyServer.stop();
                this.mTCPProxyServer = null;
                DebugLog.i("TcpProxyServer stopped.\n", new Object[0]);
            }
            UDPProxyServer uDPProxyServer = this.mUDPProxyServer;
            if (uDPProxyServer != null) {
                uDPProxyServer.stop();
                this.mUDPProxyServer = null;
                DebugLog.i("UdpProxyServer stopped.\n", new Object[0]);
            }
            NatSessionManager.clearSession();
            stopSelf();
        } catch (Throwable th) {
            throw th;
        }
    }

    private ParcelFileDescriptor establishVPN() {
        ((ConnectivityManager) getBaseContext().getSystemService("connectivity")).requestNetwork(this.p2pRequest, this.networkCallback);
        VpnService.Builder builder = new VpnService.Builder(this);
        mLocalIP = onBuildEstablish(builder);
        return builder.establish();
    }

    private boolean isLocalIp(int i) {
        return ((i >> 16) & 65535) == 49320;
    }

    private boolean isNeedSkipProxy(IPHeader iPHeader) {
        isLocalIp(iPHeader.getDestinationIP());
        return false;
    }

    private void onIPPacketReceived(IPHeader iPHeader, int i) throws IOException {
        byte protocol = iPHeader.getProtocol();
        if (protocol == 6) {
            TCPHeader tCPHeader = this.mTCPHeader;
            tCPHeader.mOffset = iPHeader.getHeaderLength();
            if (tCPHeader.getSourcePort() == this.mTCPProxyServer.getPort()) {
                NatSession session = NatSessionManager.getSession(tCPHeader.getDestinationPort());
                if (session != null) {
                    iPHeader.setSourceIP(iPHeader.getDestinationIP());
                    tCPHeader.setSourcePort(session.remotePort);
                    iPHeader.setDestinationIP(mLocalIP);
                    CommonMethods.ComputeTCPChecksum(iPHeader, tCPHeader);
                    this.mVPNOutputStream.write(iPHeader.mData, iPHeader.mOffset, i);
                    return;
                }
                DebugLog.v("%s: Session: %s %s\n", TAG, iPHeader.toString(), tCPHeader.toString());
                return;
            }
            short sourcePort = tCPHeader.getSourcePort();
            NatSession session2 = NatSessionManager.getSession(sourcePort);
            if (!(session2 != null && session2.remoteIP == iPHeader.getDestinationIP() && session2.remotePort == tCPHeader.getDestinationPort())) {
                if ((tCPHeader.getFlag() & 1) != 1) {
                    session2 = NatSessionManager.createSession(sourcePort, iPHeader.getDestinationIP(), tCPHeader.getDestinationPort());
                    DebugLog.v("%s: New TCP session: %s %s\n", TAG, iPHeader.toString(), tCPHeader.toString());
                    if (session2 != null) {
                        DebugLog.v("%s: session(%d) tun0 rx from user app %s:%d --> %s:%d", TAG, Integer.valueOf(session2.key & UShort.MAX_VALUE), CommonMethods.ipIntToString(iPHeader.getSourceIP()), Integer.valueOf(tCPHeader.getSourcePort() & UShort.MAX_VALUE), CommonMethods.ipIntToString(iPHeader.getDestinationIP()), Integer.valueOf(tCPHeader.getDestinationPort() & UShort.MAX_VALUE));
                    }
                } else {
                    DebugLog.v("%s: TCP Session: %s %s\n", TAG, iPHeader.toString(), tCPHeader.toString());
                }
            }
            if (session2 != null) {
                session2.lastNanoTime = System.nanoTime();
                session2.packetSent++;
                int dataLength = iPHeader.getDataLength() - tCPHeader.getHeaderLength();
                if (session2.packetSent >= 3 && session2.bytesSent == 0 && dataLength > 10) {
                    HttpRequestHeaderParser.parseHttpRequestHeader(session2, tCPHeader.mData, tCPHeader.mOffset + tCPHeader.getHeaderLength(), dataLength);
                }
                iPHeader.setSourceIP(iPHeader.getDestinationIP());
                iPHeader.setDestinationIP(mLocalIP);
                tCPHeader.setDestinationPort(this.mTCPProxyServer.getPort());
                CommonMethods.ComputeTCPChecksum(iPHeader, tCPHeader);
                this.mVPNOutputStream.write(iPHeader.mData, iPHeader.mOffset, i);
                session2.bytesSent += dataLength;
            }
        } else if (protocol == 17) {
            UDPHeader uDPHeader = this.mUDPHeader;
            uDPHeader.mOffset = iPHeader.getHeaderLength();
            if (uDPHeader.getSourcePort() == this.mUDPProxyServer.getPort()) {
                uDPHeader.getDestinationPort();
                UDPMap.Address find = UDPMap._FROM.find(uDPHeader.getDestinationPort());
                if (find != null) {
                    iPHeader.setSourceIP(find.ip);
                    uDPHeader.setSourcePort(find.port);
                    iPHeader.setDestinationIP(mLocalIP);
                    CommonMethods.ComputeUDPChecksum(iPHeader, uDPHeader);
                    this.mVPNOutputStream.write(iPHeader.mData, iPHeader.mOffset, i);
                    return;
                }
                DebugLog.i("%s: 无法判断流向的UDP %s %s\n", TAG, iPHeader.toString(), uDPHeader.toString());
                return;
            }
            short sourcePort2 = uDPHeader.getSourcePort();
            UDPMap._TO.map(uDPHeader.getSourcePort(), iPHeader.getDestinationIP(), uDPHeader.getDestinationPort());
            DebugLog.v("%s: New UDP session(%d)-tun0 rx from user app(%s:%d) --> to remote server(%s:%d)", TAG, Integer.valueOf(sourcePort2 & UShort.MAX_VALUE), CommonMethods.ipIntToString(iPHeader.getSourceIP()), Integer.valueOf(uDPHeader.getSourcePort() & UShort.MAX_VALUE), CommonMethods.ipIntToString(iPHeader.getDestinationIP()), Integer.valueOf(uDPHeader.getDestinationPort() & UShort.MAX_VALUE));
            iPHeader.setSourceIP(iPHeader.getDestinationIP());
            iPHeader.setDestinationIP(mLocalIP);
            uDPHeader.setDestinationPort(this.mUDPProxyServer.getPort());
            CommonMethods.ComputeUDPChecksum(iPHeader, uDPHeader);
            this.mVPNOutputStream.write(iPHeader.mData, iPHeader.mOffset, i);
        }
    }

    private void processVPN() {
        try {
            runVPN();
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            disconnectVPN();
            throw th;
        }
        disconnectVPN();
    }

    private void runVPN() throws Exception {
        TCPProxyServer tCPProxyServer;
        UDPProxyServer uDPProxyServer;
        this.mVPNInterface = establishVPN();
        this.mVPNOutputStream = new FileOutputStream(this.mVPNInterface.getFileDescriptor());
        this.mVPNInputStream = new FileInputStream(this.mVPNInterface.getFileDescriptor());
        while (true) {
            int read = this.mVPNInputStream.read(this.mPacket);
            if (read != -1 && this.mRunningState == 2 && (tCPProxyServer = this.mTCPProxyServer) != null && !tCPProxyServer.isStopped() && (uDPProxyServer = this.mUDPProxyServer) != null && !uDPProxyServer.isStopped()) {
                if (read <= 0) {
                    try {
                        Thread.sleep(10);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    onIPPacketReceived(this.mIPHeader, read);
                }
            } else {
                return;
            }
        }
    }

    public static void setAllowMode(int i, String[] strArr) {
        DebugLog.i("%s: setAllowMode=%d\n", TAG, Integer.valueOf(i));
        mAllowMode = i;
        for (String add : strArr) {
            mPackages.add(add);
        }
    }

    private void sleep(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException unused) {
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x000c */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0020  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void startTCPProxy() {
        /*
            r2 = this;
            com.upuphone.runasone.channel.proxy.client.protocol.TCPProxyServer r0 = r2.mTCPProxyServer
            if (r0 == 0) goto L_0x000c
            r0.stop()
            r0 = 100
            java.lang.Thread.sleep(r0)     // Catch:{ Exception -> 0x000c }
        L_0x000c:
            com.upuphone.runasone.channel.proxy.client.protocol.TCPProxyServer r0 = new com.upuphone.runasone.channel.proxy.client.protocol.TCPProxyServer     // Catch:{ Exception -> 0x0015 }
            r1 = 0
            r0.<init>(r1)     // Catch:{ Exception -> 0x0015 }
            r2.mTCPProxyServer = r0     // Catch:{ Exception -> 0x0015 }
            goto L_0x001c
        L_0x0015:
            r0 = move-exception
            r1 = 0
            r2.mTCPProxyServer = r1
            r0.printStackTrace()
        L_0x001c:
            com.upuphone.runasone.channel.proxy.client.protocol.TCPProxyServer r2 = r2.mTCPProxyServer
            if (r2 == 0) goto L_0x0023
            r2.start()
        L_0x0023:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.runasone.channel.proxy.client.service.LocalVpnService.startTCPProxy():void");
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x000c */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001f  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void startUDPProxy() {
        /*
            r2 = this;
            com.upuphone.runasone.channel.proxy.client.protocol.UDPProxyServer r0 = r2.mUDPProxyServer
            if (r0 == 0) goto L_0x000c
            r0.stop()
            r0 = 100
            java.lang.Thread.sleep(r0)     // Catch:{ Exception -> 0x000c }
        L_0x000c:
            com.upuphone.runasone.channel.proxy.client.protocol.UDPProxyServer r0 = new com.upuphone.runasone.channel.proxy.client.protocol.UDPProxyServer     // Catch:{ Exception -> 0x0014 }
            r0.<init>()     // Catch:{ Exception -> 0x0014 }
            r2.mUDPProxyServer = r0     // Catch:{ Exception -> 0x0014 }
            goto L_0x001b
        L_0x0014:
            r0 = move-exception
            r1 = 0
            r2.mUDPProxyServer = r1
            r0.printStackTrace()
        L_0x001b:
            com.upuphone.runasone.channel.proxy.client.protocol.UDPProxyServer r2 = r2.mUDPProxyServer
            if (r2 == 0) goto L_0x0022
            r2.start()
        L_0x0022:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.runasone.channel.proxy.client.service.LocalVpnService.startUDPProxy():void");
    }

    private void stopFrontServer() {
        try {
            stopForeground(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:1:0x0001 */
    /* JADX WARNING: Removed duplicated region for block: B:1:0x0001 A[LOOP:0: B:1:0x0001->B:15:0x0001, LOOP_START, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void waitUntilFinishInit() {
        /*
            r2 = this;
            monitor-enter(r2)
        L_0x0001:
            boolean r0 = r2.isFinishInit()     // Catch:{ all -> 0x0010 }
            if (r0 != 0) goto L_0x0012
            int r0 = r2.mRunningState     // Catch:{ all -> 0x0010 }
            r1 = 1
            if (r0 != r1) goto L_0x0012
            r2.wait()     // Catch:{ InterruptedException -> 0x0001 }
            goto L_0x0001
        L_0x0010:
            r0 = move-exception
            goto L_0x0014
        L_0x0012:
            monitor-exit(r2)     // Catch:{ all -> 0x0010 }
            return
        L_0x0014:
            monitor-exit(r2)     // Catch:{ all -> 0x0010 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.runasone.channel.proxy.client.service.LocalVpnService.waitUntilFinishInit():void");
    }

    private void waitUntilPrepared() {
        while (VpnService.prepare(this.mContext) != null && this.mRunningState == 1) {
            try {
                DebugLog.e("%s: sleep 100ms\n", TAG);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                DebugLog.e("%s: waitUntilPrepared catch an exception %s\n", TAG, e);
            }
        }
    }

    public Notification createNotification() {
        return null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|(1:4)|5|6|(1:8)|9|10|(2:12|14)(1:16)) */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x000a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0013 */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0017 A[Catch:{ Exception -> 0x001c }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x000e A[Catch:{ Exception -> 0x0013 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void disconnectVPN() {
        /*
            r2 = this;
            r0 = 0
            java.io.FileInputStream r1 = r2.mVPNInputStream     // Catch:{ Exception -> 0x000a }
            if (r1 == 0) goto L_0x000a
            r1.close()     // Catch:{ Exception -> 0x000a }
            r2.mVPNInputStream = r0     // Catch:{ Exception -> 0x000a }
        L_0x000a:
            java.io.FileOutputStream r1 = r2.mVPNOutputStream     // Catch:{ Exception -> 0x0013 }
            if (r1 == 0) goto L_0x0013
            r1.close()     // Catch:{ Exception -> 0x0013 }
            r2.mVPNOutputStream = r0     // Catch:{ Exception -> 0x0013 }
        L_0x0013:
            android.os.ParcelFileDescriptor r1 = r2.mVPNInterface     // Catch:{ Exception -> 0x001c }
            if (r1 == 0) goto L_0x001c
            r1.close()     // Catch:{ Exception -> 0x001c }
            r2.mVPNInterface = r0     // Catch:{ Exception -> 0x001c }
        L_0x001c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.runasone.channel.proxy.client.service.LocalVpnService.disconnectVPN():void");
    }

    public synchronized void finishInit() {
        notify();
    }

    public int getProtocolType() {
        return 1;
    }

    public boolean isFinishInit() {
        return true;
    }

    public boolean isRunProcess() {
        return this.mRunningState == 1;
    }

    public boolean isRunning() {
        return this.mRunningState == 2;
    }

    public boolean isStopProcess() {
        return this.mRunningState == 3;
    }

    public boolean isStopped() {
        return this.mRunningState == 4;
    }

    public int onBuildEstablish(VpnService.Builder builder) {
        for (String next : mPackages) {
            try {
                if (mAllowMode == 1) {
                    DebugLog.i("%s: allow vpn , packageName = %s\n", TAG, next);
                    builder.addAllowedApplication(next);
                } else {
                    DebugLog.i("%s: disallow vpn, packageName = %s\n", TAG, next);
                    builder.addDisallowedApplication(next);
                }
            } catch (PackageManager.NameNotFoundException e) {
                DebugLog.e("%s: Package not available: %s, e = %s\n", TAG, next, e);
            }
        }
        ProxyConfig.IPAddress defaultLocalIP = ProxyConfig.getInstance().getDefaultLocalIP();
        int ipStringToInt = CommonMethods.ipStringToInt(defaultLocalIP.Address);
        builder.addAddress(defaultLocalIP.Address, defaultLocalIP.PrefixLength);
        DebugLog.i("%s: addAddress: %s/%d\n", TAG, defaultLocalIP.Address, Integer.valueOf(defaultLocalIP.PrefixLength));
        builder.addDnsServer("119.29.29.29");
        builder.addDnsServer("223.5.5.5");
        builder.addDnsServer("8.8.8.8");
        builder.addRoute(StringUtil.ALL_INTERFACES, 0);
        builder.setConfigureIntent(PendingIntent.getActivity(this, 0, new Intent(this, ProxyManager.getInstance().getActivityClazz()), CaptureType.CAPTURE_TYPE_ICCOA));
        builder.setSession("StarryNet-Proxy");
        return ipStringToInt;
    }

    public void onCreate() {
        DebugLog.i(" %s: onCreate\n", TAG);
        Context applicationContext = getApplicationContext();
        this.mContext = applicationContext;
        DebugLog.i(" %s: mContext = %s\n", TAG, applicationContext.toString());
        Thread thread = new Thread(this, "VPNServiceThread");
        this.mVPNThread = thread;
        thread.start();
        Global.HOLDER.setVpnService(this);
        super.onCreate();
    }

    public void onDestroy() {
        Thread thread = this.mVPNThread;
        if (thread != null) {
            thread.interrupt();
        }
        stopFrontServer();
        this.mRunningState = 4;
        Global.HOLDER.setVpnService((LocalVpnService) null);
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }

    public void run() {
        DebugLog.i("%s: run", TAG);
        this.mRunningState = 1;
        waitUntilFinishInit();
        waitUntilPrepared();
        startUDPProxy();
        startTCPProxy();
        sleep(200);
        this.mRunningState = 2;
        processVPN();
        stopFrontServer();
        dispose();
    }

    public void stop() {
        this.mRunningState = 3;
        this.mVPNThread.interrupt();
    }
}
