package com.upuphone.runasone.channel.proxy.client.channel;

import com.meizu.net.pedometerprovider.manager.PedoManager;
import com.upuphone.runasone.channel.proxy.client.nat.NatSession;
import com.upuphone.runasone.channel.proxy.client.service.LocalVpnService;
import com.upuphone.runasone.channel.proxy.client.util.DebugLog;
import com.upuphone.runasone.channel.proxy.client.util.Global;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Arrays;
import kotlin.UShort;

public abstract class Tunnel {
    static final ByteBuffer GL_BUFFER = ByteBuffer.allocate(PedoManager.HOUR_MAX_STEP);
    private String TAG = "Tunnel";
    protected Tunnel mBrotherTunnel;
    protected InetSocketAddress mDestAddress;
    private volatile boolean mDisposed;
    protected SocketChannel mInnerChannel;
    private Selector mSelector;
    private ByteBuffer mSendRemainBuffer;

    public Tunnel(String str, SocketChannel socketChannel, Selector selector) {
        this.TAG += "(" + str + ")";
        this.mInnerChannel = socketChannel;
        this.mSelector = selector;
    }

    private boolean write(ByteBuffer byteBuffer) throws Exception {
        DebugLog.v("%s : write", this.TAG);
        if (this.mInnerChannel == null) {
            DebugLog.e("%s session: write : error, dispose()", this.TAG);
            dispose();
            return false;
        }
        loop0:
        while (true) {
            int i = 0;
            while (true) {
                if (byteBuffer.hasRemaining() && i <= 100) {
                    if (this.mInnerChannel.write(byteBuffer) <= 0) {
                        i++;
                    }
                }
            }
        }
        if (!byteBuffer.hasRemaining()) {
            return true;
        }
        if (this.mSendRemainBuffer == null) {
            this.mSendRemainBuffer = ByteBuffer.allocate(byteBuffer.capacity());
        }
        ByteBuffer byteBuffer2 = this.mSendRemainBuffer;
        if (byteBuffer != byteBuffer2) {
            byteBuffer2.clear();
            this.mSendRemainBuffer.put(byteBuffer);
            this.mSendRemainBuffer.flip();
            this.mInnerChannel.register(this.mSelector, 4, this);
        }
        return false;
    }

    public abstract ByteBuffer afterReceived(SelectionKey selectionKey, ByteBuffer byteBuffer, short s) throws Exception;

    public abstract ByteBuffer beforeSend(SelectionKey selectionKey, ByteBuffer byteBuffer, short s) throws Exception;

    public void beginReceived(short s) throws Exception {
        Tunnel tunnel;
        if (!(s != 0 || (tunnel = this.mBrotherTunnel) == null || tunnel.getNatSession() == null)) {
            s = this.mBrotherTunnel.getNatSession().key;
        }
        DebugLog.v("%s session(%d): beginReceived", this.TAG, Integer.valueOf(s & UShort.MAX_VALUE));
        if (this.mInnerChannel.isBlocking()) {
            this.mInnerChannel.configureBlocking(false);
        }
        this.mInnerChannel.register(this.mSelector, 1, this);
    }

    public void connect(short s) throws Exception {
        String str = this.TAG;
        short s2 = s & UShort.MAX_VALUE;
        DebugLog.v("%s session(%d): connect", str, Integer.valueOf(s2));
        LocalVpnService vpnService = Global.HOLDER.getVpnService();
        if (vpnService == null || !vpnService.isRunning()) {
            DebugLog.e("%s session(%d): connect --LocalVpnService is stopped!", this.TAG, Integer.valueOf(s2));
            dispose();
        } else if (vpnService.protect(this.mInnerChannel.socket())) {
            this.mInnerChannel.register(this.mSelector, 8, this);
            DebugLog.v("%s session(%d): source(%s) Connecting to %s", this.TAG, Integer.valueOf(s2), this.mInnerChannel.getLocalAddress(), this.mDestAddress);
            this.mInnerChannel.connect(this.mDestAddress);
        } else {
            DebugLog.e("%s session(%d): connect --LocalVpnService protect failed, dispose it!", this.TAG, Integer.valueOf(s2));
            dispose();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r3.mInnerChannel.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0021, code lost:
        r0.printStackTrace(java.lang.System.err);
        com.upuphone.runasone.channel.proxy.client.util.DebugLog.e("%s: InnerChannel close catch an exception: %s", r3.TAG, r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dispose() {
        /*
            r3 = this;
            java.lang.String r0 = "%s : dispose"
            java.lang.String r1 = r3.TAG
            java.lang.Object[] r1 = new java.lang.Object[]{r1}
            com.upuphone.runasone.channel.proxy.client.util.DebugLog.v(r0, r1)
            java.lang.Class<com.upuphone.runasone.channel.proxy.client.nat.NatSessionManager> r0 = com.upuphone.runasone.channel.proxy.client.nat.NatSessionManager.class
            monitor-enter(r0)
            boolean r1 = r3.mDisposed     // Catch:{ all -> 0x0014 }
            if (r1 == 0) goto L_0x0016
            monitor-exit(r0)     // Catch:{ all -> 0x0014 }
            return
        L_0x0014:
            r3 = move-exception
            goto L_0x0045
        L_0x0016:
            r1 = 1
            r3.mDisposed = r1     // Catch:{ all -> 0x0014 }
            monitor-exit(r0)     // Catch:{ all -> 0x0014 }
            java.nio.channels.SocketChannel r0 = r3.mInnerChannel     // Catch:{ Exception -> 0x0020 }
            r0.close()     // Catch:{ Exception -> 0x0020 }
            goto L_0x0031
        L_0x0020:
            r0 = move-exception
            java.io.PrintStream r1 = java.lang.System.err
            r0.printStackTrace(r1)
            java.lang.String r1 = "%s: InnerChannel close catch an exception: %s"
            java.lang.String r2 = r3.TAG
            java.lang.Object[] r0 = new java.lang.Object[]{r2, r0}
            com.upuphone.runasone.channel.proxy.client.util.DebugLog.e(r1, r0)
        L_0x0031:
            com.upuphone.runasone.channel.proxy.client.channel.Tunnel r0 = r3.mBrotherTunnel
            if (r0 == 0) goto L_0x0038
            r0.dispose()
        L_0x0038:
            r3.onDispose()
            r0 = 0
            r3.mInnerChannel = r0
            r3.mSendRemainBuffer = r0
            r3.mSelector = r0
            r3.mBrotherTunnel = r0
            return
        L_0x0045:
            monitor-exit(r0)     // Catch:{ all -> 0x0014 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.runasone.channel.proxy.client.channel.Tunnel.dispose():void");
    }

    public Tunnel getBrotherTunnel() {
        return this.mBrotherTunnel;
    }

    public NatSession getNatSession() {
        return null;
    }

    public void onConnectable(short s) {
        Tunnel tunnel;
        if (!(s != 0 || (tunnel = this.mBrotherTunnel) == null || tunnel.getNatSession() == null)) {
            s = this.mBrotherTunnel.getNatSession().key;
        }
        short s2 = 65535 & s;
        DebugLog.v("%s session(%d): onConnectable", this.TAG, Integer.valueOf(s2));
        try {
            if (this.mInnerChannel.finishConnect()) {
                onConnected(GL_BUFFER, s);
                DebugLog.v("%s session(%d)-source(%s): Connected to %s", this.TAG, Integer.valueOf(s2), this.mInnerChannel.getLocalAddress(), this.mDestAddress);
                return;
            }
            DebugLog.e("%s: Connect to %s failed.", this.TAG, this.mDestAddress);
            dispose();
        } catch (Exception e) {
            e.printStackTrace();
            DebugLog.e("%s session(%d): Connect to %s failed: %s", this.TAG, Integer.valueOf(s2), this.mDestAddress, e);
            dispose();
        }
    }

    public abstract void onConnected(ByteBuffer byteBuffer, short s) throws Exception;

    public abstract void onDispose();

    public void onReadable(SelectionKey selectionKey, short s) {
        Tunnel tunnel;
        if (!(s != 0 || (tunnel = this.mBrotherTunnel) == null || tunnel.getNatSession() == null)) {
            s = this.mBrotherTunnel.getNatSession().key;
        }
        short s2 = 65535 & s;
        DebugLog.v("%s session(%d): onReadable", this.TAG, Integer.valueOf(s2));
        if (this.mInnerChannel == null) {
            DebugLog.e("%s session(%d): onReadable error: mInnerChannel is null, dispose()", this.TAG, Integer.valueOf(s2));
            dispose();
            return;
        }
        try {
            ByteBuffer byteBuffer = GL_BUFFER;
            byteBuffer.clear();
            if (this.mInnerChannel.read(byteBuffer) != -1) {
                byteBuffer.flip();
                ByteBuffer afterReceived = afterReceived(selectionKey, byteBuffer, s);
                if (afterReceived != null) {
                    sendToBrother(selectionKey, afterReceived, s);
                    return;
                }
                return;
            }
            DebugLog.v("%s session(%d)-source(%s): onReadable error: mInnerChannel bytesRead=-1, dispose()", this.TAG, Integer.valueOf(s2), this.mInnerChannel.getLocalAddress());
            dispose();
        } catch (Exception e) {
            e.printStackTrace(System.err);
            String str = this.TAG;
            Class<?> cls = getClass();
            InetSocketAddress inetSocketAddress = this.mDestAddress;
            DebugLog.e("%s: onReadable catch an exception: %s %s  %s %s, dispose()", str, e, cls, inetSocketAddress, inetSocketAddress);
            dispose();
        }
    }

    public void onTunnelEstablished(short s) throws Exception {
        DebugLog.i("%s : onTunnelEstablished", this.TAG);
        beginReceived(s);
        this.mBrotherTunnel.beginReceived(s);
    }

    public void onWritable(SelectionKey selectionKey, short s) {
        Tunnel tunnel;
        if (!(s != 0 || (tunnel = this.mBrotherTunnel) == null || tunnel.getNatSession() == null)) {
            s = this.mBrotherTunnel.getNatSession().key;
        }
        DebugLog.v("%s session(%d): onWritable", this.TAG, Integer.valueOf(65535 & s));
        if (this.mBrotherTunnel == null) {
            dispose();
            return;
        }
        try {
            if (write(this.mSendRemainBuffer)) {
                beginReceived(s);
                this.mBrotherTunnel.beginReceived(s);
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
            DebugLog.e("%s: onWritable catch an exception: %s", this.TAG, e);
            dispose();
        }
    }

    public void sendCommend(ByteBuffer byteBuffer, NatSession natSession) {
        try {
            DebugLog.v("%s session(%d): sendCommend : [%s]", this.TAG, Integer.valueOf(natSession.key & UShort.MAX_VALUE), Arrays.toString(byteBuffer.array()));
            write(byteBuffer);
        } catch (Exception e) {
            e.printStackTrace();
            DebugLog.e("%s session(%d): sendCommend : error, dispose()", this.TAG, Integer.valueOf(natSession.key & UShort.MAX_VALUE));
            dispose();
        }
    }

    public void sendToBrother(SelectionKey selectionKey, ByteBuffer byteBuffer, short s) throws Exception {
        ByteBuffer beforeSend;
        Tunnel tunnel;
        if (!(s != 0 || (tunnel = this.mBrotherTunnel) == null || tunnel.getNatSession() == null)) {
            s = this.mBrotherTunnel.getNatSession().key;
        }
        short s2 = 65535 & s;
        DebugLog.v("%s session(%d): sendToBrother", this.TAG, Integer.valueOf(s2));
        if (this.mBrotherTunnel == null) {
            DebugLog.i("%s session(%d): sendToBrother: mBrotherTunnel=null, dispose()", this.TAG, Integer.valueOf(s2));
            dispose();
        } else if (byteBuffer.hasRemaining() && (beforeSend = this.mBrotherTunnel.beforeSend(selectionKey, byteBuffer, s)) != null && !this.mBrotherTunnel.write(beforeSend)) {
            selectionKey.cancel();
            DebugLog.w("%s: %s can not read more.\n", this.TAG, this.mDestAddress);
        }
    }

    public void setBrotherTunnel(Tunnel tunnel) {
        this.mBrotherTunnel = tunnel;
    }

    public Tunnel(String str, InetSocketAddress inetSocketAddress, Selector selector) throws IOException {
        this.TAG += "(" + str + ")";
        SocketChannel open = SocketChannel.open();
        open.configureBlocking(false);
        this.mInnerChannel = open;
        this.mSelector = selector;
        this.mDestAddress = inetSocketAddress;
    }
}
