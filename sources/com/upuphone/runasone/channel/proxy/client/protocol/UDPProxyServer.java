package com.upuphone.runasone.channel.proxy.client.protocol;

import com.upuphone.runasone.channel.proxy.client.nat.UDPMap;
import com.upuphone.runasone.channel.proxy.client.service.LocalVpnService;
import com.upuphone.runasone.channel.proxy.client.util.DebugLog;
import com.upuphone.runasone.channel.proxy.client.util.Global;
import com.upuphone.runasone.channel.proxy.client.util.LRU;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.UShort;

public class UDPProxyServer implements Runnable {
    private static final String TAG = "UDPProxyServer";
    private LRU.RemoveListener<Short, DatagramChannel> listener = new LRU.RemoveListener<Short, DatagramChannel>() {
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x000f, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0010, code lost:
            r1.printStackTrace();
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onRemove(java.util.Map.Entry<java.lang.Short, java.nio.channels.DatagramChannel> r4) {
            /*
                r3 = this;
                if (r4 != 0) goto L_0x0003
                return
            L_0x0003:
                java.lang.Object r0 = r4.getValue()
                java.nio.channels.DatagramChannel r0 = (java.nio.channels.DatagramChannel) r0
                r0.close()     // Catch:{ Exception -> 0x000f, all -> 0x000d }
                goto L_0x0013
            L_0x000d:
                r3 = move-exception
                throw r3
            L_0x000f:
                r1 = move-exception
                r1.printStackTrace()
            L_0x0013:
                com.upuphone.runasone.channel.proxy.client.nat.UDPMap$MapEntity r1 = com.upuphone.runasone.channel.proxy.client.nat.UDPMap._TO
                java.lang.Object r2 = r4.getKey()
                java.lang.Short r2 = (java.lang.Short) r2
                short r2 = r2.shortValue()
                r1.remove(r2)
                com.upuphone.runasone.channel.proxy.client.nat.UDPMap$MapEntity r1 = com.upuphone.runasone.channel.proxy.client.nat.UDPMap._FROM
                java.lang.Object r4 = r4.getKey()
                java.lang.Short r4 = (java.lang.Short) r4
                short r4 = r4.shortValue()
                r1.remove(r4)
                com.upuphone.runasone.channel.proxy.client.protocol.UDPProxyServer r3 = com.upuphone.runasone.channel.proxy.client.protocol.UDPProxyServer.this
                java.util.HashMap r3 = r3.localPorts
                r3.remove(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.runasone.channel.proxy.client.protocol.UDPProxyServer.AnonymousClass1.onRemove(java.util.Map$Entry):void");
        }
    };
    private DatagramChannel localChannel;
    /* access modifiers changed from: private */
    public HashMap<DatagramChannel, Short> localPorts = new HashMap<>(16);
    public ReentrantLock lock = new ReentrantLock(true);
    public ByteBuffer mByteBuffer = ByteBuffer.allocate(65536);
    private short mPort;
    private Selector mSelector;
    public volatile boolean mStopped;
    private Thread mWorkThread;
    private LRU<Short, DatagramChannel> remoteChannels = new LRU<>(16, 0.8f, true, 256);

    public UDPProxyServer() throws IOException {
        DebugLog.i("%s: new UDPProxyServer()", TAG);
        DatagramChannel open = DatagramChannel.open();
        this.localChannel = open;
        open.configureBlocking(false);
        DatagramSocket socket = this.localChannel.socket();
        socket.setReceiveBufferSize(65536);
        socket.bind(new InetSocketAddress(0));
        Selector open2 = Selector.open();
        this.mSelector = open2;
        DatagramChannel datagramChannel = this.localChannel;
        datagramChannel.register(open2, 1, datagramChannel);
        this.mPort = (short) this.localChannel.socket().getLocalPort();
        this.remoteChannels.setRemoveListener(this.listener);
        UDPMap._FROM.clear();
        UDPMap._TO.clear();
        DebugLog.i("%s: UDPProxy listen on port:%d success.\n", TAG, Integer.valueOf(this.mPort & UShort.MAX_VALUE));
    }

    private void protect(DatagramSocket datagramSocket) {
        LocalVpnService vpnService = Global.HOLDER.getVpnService();
        if (vpnService != null) {
            vpnService.protect(datagramSocket);
        }
    }

    public synchronized void clear() {
        Iterator<Map.Entry<Short, DatagramChannel>> it = this.remoteChannels.entrySet().iterator();
        while (it.hasNext()) {
            try {
                ((DatagramChannel) it.next().getValue()).close();
            } catch (Exception e) {
                try {
                    e.printStackTrace();
                } catch (Throwable th) {
                    it.remove();
                    throw th;
                }
            }
            it.remove();
        }
        this.localPorts.clear();
    }

    public short getPort() {
        return this.mPort;
    }

    public boolean isStopped() {
        return this.mStopped;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0080 A[Catch:{ Exception -> 0x004f }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void read(java.nio.channels.DatagramChannel r6) {
        /*
            r5 = this;
            if (r6 != 0) goto L_0x0003
            return
        L_0x0003:
            java.nio.channels.DatagramChannel r0 = r5.localChannel     // Catch:{ Exception -> 0x004f }
            r1 = 65535(0xffff, float:9.1834E-41)
            r2 = 0
            if (r6 != r0) goto L_0x00a2
            java.nio.ByteBuffer r6 = r5.mByteBuffer     // Catch:{ Exception -> 0x004f }
            r6.clear()     // Catch:{ Exception -> 0x004f }
            java.nio.channels.DatagramChannel r6 = r5.localChannel     // Catch:{ Exception -> 0x004f }
            java.nio.ByteBuffer r0 = r5.mByteBuffer     // Catch:{ Exception -> 0x004f }
            java.net.SocketAddress r6 = r6.receive(r0)     // Catch:{ Exception -> 0x004f }
            java.nio.ByteBuffer r0 = r5.mByteBuffer     // Catch:{ Exception -> 0x004f }
            r0.flip()     // Catch:{ Exception -> 0x004f }
            if (r6 == 0) goto L_0x00fe
            boolean r0 = r6 instanceof java.net.InetSocketAddress     // Catch:{ Exception -> 0x004f }
            if (r0 == 0) goto L_0x00fe
            java.net.InetSocketAddress r6 = (java.net.InetSocketAddress) r6     // Catch:{ Exception -> 0x004f }
            int r6 = r6.getPort()     // Catch:{ Exception -> 0x004f }
            short r6 = (short) r6     // Catch:{ Exception -> 0x004f }
            com.upuphone.runasone.channel.proxy.client.util.LRU<java.lang.Short, java.nio.channels.DatagramChannel> r0 = r5.remoteChannels     // Catch:{ Exception -> 0x004f }
            java.lang.Short r3 = java.lang.Short.valueOf(r6)     // Catch:{ Exception -> 0x004f }
            java.lang.Object r0 = r0.get(r3)     // Catch:{ Exception -> 0x004f }
            java.nio.channels.DatagramChannel r0 = (java.nio.channels.DatagramChannel) r0     // Catch:{ Exception -> 0x004f }
            if (r0 == 0) goto L_0x0052
            boolean r3 = r0.isOpen()     // Catch:{ Exception -> 0x004f }
            if (r3 == 0) goto L_0x0052
            java.net.DatagramSocket r3 = r0.socket()     // Catch:{ Exception -> 0x004f }
            if (r3 == 0) goto L_0x0052
            java.net.DatagramSocket r3 = r0.socket()     // Catch:{ Exception -> 0x004f }
            boolean r3 = r3.isClosed()     // Catch:{ Exception -> 0x004f }
            if (r3 == 0) goto L_0x0078
            goto L_0x0052
        L_0x004f:
            r5 = move-exception
            goto L_0x00fb
        L_0x0052:
            java.nio.channels.DatagramChannel r0 = java.nio.channels.DatagramChannel.open()     // Catch:{ Exception -> 0x004f }
            r0.configureBlocking(r2)     // Catch:{ Exception -> 0x004f }
            java.net.DatagramSocket r2 = r0.socket()     // Catch:{ Exception -> 0x004f }
            r5.protect(r2)     // Catch:{ Exception -> 0x004f }
            com.upuphone.runasone.channel.proxy.client.util.LRU<java.lang.Short, java.nio.channels.DatagramChannel> r2 = r5.remoteChannels     // Catch:{ Exception -> 0x004f }
            java.lang.Short r3 = java.lang.Short.valueOf(r6)     // Catch:{ Exception -> 0x004f }
            r2.put(r3, r0)     // Catch:{ Exception -> 0x004f }
            java.util.HashMap<java.nio.channels.DatagramChannel, java.lang.Short> r2 = r5.localPorts     // Catch:{ Exception -> 0x004f }
            java.lang.Short r3 = java.lang.Short.valueOf(r6)     // Catch:{ Exception -> 0x004f }
            r2.put(r0, r3)     // Catch:{ Exception -> 0x004f }
            java.nio.channels.Selector r2 = r5.mSelector     // Catch:{ Exception -> 0x004f }
            r3 = 1
            r0.register(r2, r3, r0)     // Catch:{ Exception -> 0x004f }
        L_0x0078:
            com.upuphone.runasone.channel.proxy.client.nat.UDPMap$MapEntity r2 = com.upuphone.runasone.channel.proxy.client.nat.UDPMap._TO     // Catch:{ Exception -> 0x004f }
            com.upuphone.runasone.channel.proxy.client.nat.UDPMap$Address r6 = r2.find(r6)     // Catch:{ Exception -> 0x004f }
            if (r6 == 0) goto L_0x00fe
            java.net.InetSocketAddress r2 = new java.net.InetSocketAddress     // Catch:{ Exception -> 0x004f }
            int r3 = r6.ip     // Catch:{ Exception -> 0x004f }
            java.lang.String r3 = com.upuphone.runasone.channel.proxy.client.tcpip.CommonMethods.ipIntToString(r3)     // Catch:{ Exception -> 0x004f }
            short r6 = r6.port     // Catch:{ Exception -> 0x004f }
            r6 = r6 & r1
            r2.<init>(r3, r6)     // Catch:{ Exception -> 0x004f }
            com.upuphone.runasone.channel.proxy.client.util.Global r6 = com.upuphone.runasone.channel.proxy.client.util.Global.HOLDER     // Catch:{ Exception -> 0x004f }
            com.upuphone.runasone.channel.proxy.client.channel.IPackHandler r6 = r6.getPackHandler()     // Catch:{ Exception -> 0x004f }
            if (r6 == 0) goto L_0x009c
            java.nio.ByteBuffer r5 = r5.mByteBuffer     // Catch:{ Exception -> 0x004f }
            r6.sendToRemote(r0, r5, r2)     // Catch:{ Exception -> 0x004f }
            goto L_0x00fe
        L_0x009c:
            java.nio.ByteBuffer r5 = r5.mByteBuffer     // Catch:{ Exception -> 0x004f }
            r0.send(r5, r2)     // Catch:{ Exception -> 0x004f }
            goto L_0x00fe
        L_0x00a2:
            java.util.HashMap<java.nio.channels.DatagramChannel, java.lang.Short> r0 = r5.localPorts     // Catch:{ Exception -> 0x004f }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ Exception -> 0x004f }
            java.lang.Short r0 = (java.lang.Short) r0     // Catch:{ Exception -> 0x004f }
            short r0 = r0.shortValue()     // Catch:{ Exception -> 0x004f }
            r6.configureBlocking(r2)     // Catch:{ Exception -> 0x004f }
            java.nio.ByteBuffer r2 = r5.mByteBuffer     // Catch:{ Exception -> 0x004f }
            r2.clear()     // Catch:{ Exception -> 0x004f }
            java.nio.ByteBuffer r2 = r5.mByteBuffer     // Catch:{ Exception -> 0x004f }
            java.net.SocketAddress r6 = r6.receive(r2)     // Catch:{ Exception -> 0x004f }
            java.net.InetSocketAddress r6 = (java.net.InetSocketAddress) r6     // Catch:{ Exception -> 0x004f }
            java.nio.ByteBuffer r2 = r5.mByteBuffer     // Catch:{ Exception -> 0x004f }
            r2.flip()     // Catch:{ Exception -> 0x004f }
            com.upuphone.runasone.channel.proxy.client.util.Global r2 = com.upuphone.runasone.channel.proxy.client.util.Global.HOLDER     // Catch:{ Exception -> 0x004f }
            com.upuphone.runasone.channel.proxy.client.channel.IPackHandler r2 = r2.getPackHandler()     // Catch:{ Exception -> 0x004f }
            if (r2 == 0) goto L_0x00d1
            java.nio.ByteBuffer r3 = r5.mByteBuffer     // Catch:{ Exception -> 0x004f }
            java.net.InetSocketAddress r6 = r2.parseRemoteData(r3, r6)     // Catch:{ Exception -> 0x004f }
        L_0x00d1:
            java.net.InetAddress r2 = r6.getAddress()     // Catch:{ Exception -> 0x004f }
            java.net.Inet4Address r2 = (java.net.Inet4Address) r2     // Catch:{ Exception -> 0x004f }
            java.net.InetSocketAddress r3 = new java.net.InetSocketAddress     // Catch:{ Exception -> 0x004f }
            java.lang.String r4 = r2.getHostAddress()     // Catch:{ Exception -> 0x004f }
            r1 = r1 & r0
            r3.<init>(r4, r1)     // Catch:{ Exception -> 0x004f }
            com.upuphone.runasone.channel.proxy.client.nat.UDPMap$MapEntity r1 = com.upuphone.runasone.channel.proxy.client.nat.UDPMap._FROM     // Catch:{ Exception -> 0x004f }
            java.lang.String r2 = r2.getHostAddress()     // Catch:{ Exception -> 0x004f }
            int r2 = com.upuphone.runasone.channel.proxy.client.tcpip.CommonMethods.ipStringToInt(r2)     // Catch:{ Exception -> 0x004f }
            int r6 = r6.getPort()     // Catch:{ Exception -> 0x004f }
            short r6 = (short) r6     // Catch:{ Exception -> 0x004f }
            r1.map(r0, r2, r6)     // Catch:{ Exception -> 0x004f }
            java.nio.channels.DatagramChannel r6 = r5.localChannel     // Catch:{ Exception -> 0x004f }
            java.nio.ByteBuffer r5 = r5.mByteBuffer     // Catch:{ Exception -> 0x004f }
            r6.send(r5, r3)     // Catch:{ Exception -> 0x004f }
            goto L_0x00fe
        L_0x00fb:
            r5.printStackTrace()
        L_0x00fe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.runasone.channel.proxy.client.protocol.UDPProxyServer.read(java.nio.channels.DatagramChannel):void");
    }

    public void run() {
        Set<SelectionKey> selectedKeys;
        while (true) {
            try {
                if (this.mStopped) {
                    break;
                }
                this.mSelector.select();
                if (this.mStopped) {
                    break;
                }
                this.lock.lock();
                Selector selector = this.mSelector;
                if (!(selector == null || (selectedKeys = selector.selectedKeys()) == null)) {
                    Iterator<SelectionKey> it = selectedKeys.iterator();
                    while (it.hasNext() && !this.mStopped) {
                        SelectionKey next = it.next();
                        if (next.isValid()) {
                            DatagramChannel datagramChannel = (DatagramChannel) next.channel();
                            if (next.isReadable() && !this.mStopped) {
                                read(datagramChannel);
                            }
                        }
                        it.remove();
                    }
                }
                this.lock.unlock();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        stop();
    }

    public void start() {
        Thread thread = new Thread(this, "UDPWorkThread");
        this.mWorkThread = thread;
        thread.start();
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void stop() {
        /*
            r1 = this;
            r0 = 1
            r1.mStopped = r0
            r0 = 0
            r1.mPort = r0
            java.util.concurrent.locks.ReentrantLock r0 = r1.lock
            r0.lock()
            java.nio.channels.Selector r0 = r1.mSelector
            if (r0 == 0) goto L_0x0017
            r0.close()     // Catch:{ Exception -> 0x0012 }
        L_0x0012:
            java.nio.channels.DatagramChannel r0 = r1.localChannel     // Catch:{ Exception -> 0x0017 }
            r0.close()     // Catch:{ Exception -> 0x0017 }
        L_0x0017:
            java.util.concurrent.locks.ReentrantLock r0 = r1.lock
            r0.unlock()
            java.lang.Thread r0 = r1.mWorkThread
            r0.interrupt()
            r1.clear()
            com.upuphone.runasone.channel.proxy.client.nat.UDPMap$MapEntity r1 = com.upuphone.runasone.channel.proxy.client.nat.UDPMap._FROM
            r1.clear()
            com.upuphone.runasone.channel.proxy.client.nat.UDPMap$MapEntity r1 = com.upuphone.runasone.channel.proxy.client.nat.UDPMap._TO
            r1.clear()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.runasone.channel.proxy.client.protocol.UDPProxyServer.stop():void");
    }
}
