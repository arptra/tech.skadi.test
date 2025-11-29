package com.upuphone.runasone.channel.proxy.client.protocol;

import com.upuphone.runasone.channel.proxy.client.channel.Tunnel;
import com.upuphone.runasone.channel.proxy.client.channel.TunnelFactory;
import com.upuphone.runasone.channel.proxy.client.nat.NatSession;
import com.upuphone.runasone.channel.proxy.client.nat.NatSessionManager;
import com.upuphone.runasone.channel.proxy.client.tcpip.CommonMethods;
import com.upuphone.runasone.channel.proxy.client.util.DebugLog;
import com.upuphone.runasone.channel.proxy.client.util.Global;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.UShort;

public class TCPProxyServer implements Runnable {
    private static final String TAG = "TCPProxyServer";
    private volatile boolean isStopped;
    public ReentrantLock lock = new ReentrantLock(true);
    private short mPort;
    private Selector mSelector = Selector.open();
    private ServerSocketChannel mServerSocketChannel;
    private Thread mServerThread;

    public TCPProxyServer(int i) throws IOException {
        ServerSocketChannel open = ServerSocketChannel.open();
        this.mServerSocketChannel = open;
        open.configureBlocking(false);
        this.mServerSocketChannel.socket().bind(new InetSocketAddress(i));
        this.mServerSocketChannel.register(this.mSelector, 16);
        this.mPort = (short) this.mServerSocketChannel.socket().getLocalPort();
        DebugLog.i("TcpProxy listen on %s:%d success.\n", this.mServerSocketChannel.socket().getInetAddress().toString(), Integer.valueOf(this.mPort & UShort.MAX_VALUE));
    }

    private InetSocketAddress getDestAddress(SocketChannel socketChannel) {
        if (Global.HOLDER.getInetSocketAddress() != null) {
            return Global.HOLDER.getInetSocketAddress();
        }
        NatSession session = NatSessionManager.getSession((short) socketChannel.socket().getPort());
        session.isDirectConnect = true;
        return new InetSocketAddress(CommonMethods.ipIntToInet4Address(session.remoteIP), session.remotePort & UShort.MAX_VALUE);
    }

    private short updateSessionLastTime(SelectionKey selectionKey) {
        Object attachment = selectionKey.attachment();
        short s = 0;
        if (attachment instanceof Tunnel) {
            Tunnel tunnel = (Tunnel) attachment;
            NatSession natSession = tunnel.getNatSession();
            if (tunnel.getNatSession() != null) {
                tunnel.getNatSession().lastActivityTime = Long.valueOf(System.currentTimeMillis());
                DebugLog.v("%s: TCP session(%d)-TcpProxy rx: %s:%d --> %s:%d", TAG, Integer.valueOf(natSession.key & UShort.MAX_VALUE), this.mServerSocketChannel.socket().getInetAddress().toString(), Integer.valueOf(this.mPort & UShort.MAX_VALUE), CommonMethods.ipIntToString(natSession.remoteIP), Integer.valueOf(natSession.remotePort & UShort.MAX_VALUE));
                s = natSession.key;
            }
            Tunnel brotherTunnel = tunnel.getBrotherTunnel();
            if (!(brotherTunnel == null || brotherTunnel.getNatSession() == null)) {
                brotherTunnel.getNatSession().lastActivityTime = Long.valueOf(System.currentTimeMillis());
            }
        }
        return s;
    }

    public short getPort() {
        return this.mPort;
    }

    public boolean isStopped() {
        return this.isStopped;
    }

    public void onAccepted(short s) {
        short s2 = 65535 & s;
        DebugLog.v("%s session(%d): onAccepted", TAG, Integer.valueOf(s2));
        Tunnel tunnel = null;
        try {
            SocketChannel accept = this.mServerSocketChannel.accept();
            Tunnel wrap = TunnelFactory.wrap(accept, this.mSelector);
            InetSocketAddress destAddress = getDestAddress(accept);
            if (destAddress != null) {
                DebugLog.v("%s session(%d): onAccepted destAddress=%s", TAG, Integer.valueOf(s2), destAddress.toString());
                Tunnel createTunnelByConfig = TunnelFactory.createTunnelByConfig(destAddress, this.mSelector);
                createTunnelByConfig.setBrotherTunnel(wrap);
                wrap.setBrotherTunnel(createTunnelByConfig);
                if (s == 0) {
                    s = wrap.getNatSession().key;
                }
                createTunnelByConfig.connect(s);
                return;
            }
            throw new IllegalArgumentException("没设置目的地");
        } catch (Exception e) {
            e.printStackTrace(System.err);
            DebugLog.e("%s: onAccepted catch an exception: %s", TAG, e);
            if (tunnel != null) {
                tunnel.dispose();
            }
        }
    }

    public void run() {
        Set<SelectionKey> selectedKeys;
        this.isStopped = false;
        while (true) {
            try {
                this.mSelector.select();
                this.lock.lock();
                Selector selector = this.mSelector;
                if (!(selector == null || (selectedKeys = selector.selectedKeys()) == null)) {
                    Iterator<SelectionKey> it = selectedKeys.iterator();
                    while (it.hasNext() && !this.isStopped) {
                        SelectionKey next = it.next();
                        if (next.isValid()) {
                            short updateSessionLastTime = updateSessionLastTime(next);
                            if (next.isReadable()) {
                                DebugLog.v(" %s session(%d): onReadable", TAG, Integer.valueOf(updateSessionLastTime & UShort.MAX_VALUE));
                                ((Tunnel) next.attachment()).onReadable(next, updateSessionLastTime);
                            } else if (next.isWritable()) {
                                DebugLog.v(" %s session(%d): onWritable", TAG, Integer.valueOf(updateSessionLastTime & UShort.MAX_VALUE));
                                ((Tunnel) next.attachment()).onWritable(next, updateSessionLastTime);
                            } else if (next.isConnectable()) {
                                DebugLog.v(" %s session(%d): onConnectable", TAG, Integer.valueOf(updateSessionLastTime & UShort.MAX_VALUE));
                                ((Tunnel) next.attachment()).onConnectable(updateSessionLastTime);
                            } else if (next.isAcceptable()) {
                                DebugLog.v(" %s session(%d): onAccepted", TAG, Integer.valueOf(updateSessionLastTime & UShort.MAX_VALUE));
                                onAccepted(updateSessionLastTime);
                            }
                        } else {
                            DebugLog.w("%s: %s is not valid", TAG, next);
                        }
                        it.remove();
                    }
                }
                this.lock.unlock();
            } catch (Exception unused) {
                stop();
                DebugLog.i("%s: TcpServer thread exited.", TAG);
                return;
            }
        }
    }

    public void start() {
        DebugLog.i("%s : start TcpProxyServerThread", TAG);
        Thread thread = new Thread(this, "TcpProxyServerThread");
        this.mServerThread = thread;
        thread.start();
    }

    public void stop() {
        this.isStopped = true;
        this.lock.lock();
        Selector selector = this.mSelector;
        if (selector != null) {
            try {
                selector.close();
                this.mSelector = null;
            } catch (Exception e) {
                DebugLog.e("%s: mSelector.close() catch an exception: %s", TAG, e);
            }
        }
        ServerSocketChannel serverSocketChannel = this.mServerSocketChannel;
        if (serverSocketChannel != null) {
            try {
                serverSocketChannel.close();
                this.mServerSocketChannel = null;
            } catch (Exception e2) {
                DebugLog.e("%s: mServerSocketChannel.close() catch an exception: %s", TAG, e2);
            }
        }
        this.lock.unlock();
        NatSessionManager.clearSession();
        this.mServerThread.interrupt();
    }
}
