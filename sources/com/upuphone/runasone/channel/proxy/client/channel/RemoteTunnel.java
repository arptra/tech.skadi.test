package com.upuphone.runasone.channel.proxy.client.channel;

import com.upuphone.runasone.channel.proxy.client.util.DebugLog;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

public class RemoteTunnel extends Tunnel {
    private static final String TAG = "RemoteTunnel";
    private boolean isLocalReceiveDataWhenConnected = false;

    public RemoteTunnel(InetSocketAddress inetSocketAddress, Selector selector) throws IOException {
        super(TAG, inetSocketAddress, selector);
    }

    public ByteBuffer afterReceived(SelectionKey selectionKey, ByteBuffer byteBuffer, short s) {
        return byteBuffer;
    }

    public ByteBuffer beforeSend(SelectionKey selectionKey, ByteBuffer byteBuffer, short s) {
        return byteBuffer;
    }

    public void onConnected(ByteBuffer byteBuffer, short s) throws Exception {
        Tunnel tunnel;
        if (!(s != 0 || (tunnel = this.mBrotherTunnel) == null || tunnel.getNatSession() == null)) {
            s = this.mBrotherTunnel.getNatSession().key;
        }
        DebugLog.v("%s session(%d): onConnected", TAG, Integer.valueOf(65535 & s));
        if (this.isLocalReceiveDataWhenConnected) {
            onTunnelEstablished(s);
            return;
        }
        beginReceived(s);
        Tunnel tunnel2 = this.mBrotherTunnel;
        if (tunnel2 instanceof RawTunnel) {
            ((RawTunnel) tunnel2).startHands();
        }
    }

    public void onDispose() {
    }

    public void setLocalReceiveDataWhenConnected(boolean z) {
        this.isLocalReceiveDataWhenConnected = z;
    }
}
