package com.upuphone.runasone.channel.proxy.client.channel;

import com.upuphone.runasone.channel.proxy.client.nat.NatSession;
import com.upuphone.runasone.channel.proxy.client.nat.NatSessionManager;
import com.upuphone.runasone.channel.proxy.client.util.DebugLog;
import com.upuphone.runasone.channel.proxy.client.util.Global;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import kotlin.UShort;

public class RawTunnel extends Tunnel implements IShakeHandsListener {
    private static final String TAG = "RawTunnel";
    private NatSession mSession;

    public RawTunnel(SocketChannel socketChannel, Selector selector) {
        super(TAG, socketChannel, selector);
    }

    private void createAdapter(NatSession natSession) {
        if (natSession != null) {
            try {
                SimpleAdapter simpleAdapter = (SimpleAdapter) Global.HOLDER.getAdapterClass().newInstance();
                natSession.mAdapter = simpleAdapter;
                simpleAdapter.shakeHandsListener = this;
                this.mSession.mAdapter.init();
            } catch (IllegalAccessException | InstantiationException unused) {
            }
        }
    }

    public ByteBuffer afterReceived(SelectionKey selectionKey, ByteBuffer byteBuffer, short s) throws Exception {
        DebugLog.v("%s session(%d) afterReceived", TAG, Integer.valueOf(65535 & s));
        IDataHandler dataHandler = Global.HOLDER.getDataHandler();
        return (dataHandler == null || dataHandler.isDispose()) ? byteBuffer : dataHandler.afterReceived(getNatSession(), byteBuffer);
    }

    public ByteBuffer beforeSend(SelectionKey selectionKey, ByteBuffer byteBuffer, short s) throws Exception {
        DebugLog.v("%s session(%d) beforeSend", TAG, Integer.valueOf(getNatSession().key & UShort.MAX_VALUE));
        IDataHandler dataHandler = Global.HOLDER.getDataHandler();
        return (dataHandler == null || dataHandler.isDispose()) ? byteBuffer : dataHandler.beforeSend(getNatSession(), byteBuffer);
    }

    public NatSession getNatSession() {
        if (this.mSession == null) {
            this.mSession = NatSessionManager.getSession((short) this.mInnerChannel.socket().getPort());
        }
        return this.mSession;
    }

    public void onConnected(ByteBuffer byteBuffer, short s) throws Exception {
        DebugLog.v("%s session(%d): onConnected", TAG, Integer.valueOf(65535 & s));
    }

    public void onDispose() {
        DebugLog.v("%s session(%d) onDispose", TAG, Integer.valueOf(this.mSession.key & UShort.MAX_VALUE));
    }

    public void onShakeHandFinish(boolean z) {
        DebugLog.v("%s session(%d): onShakeHandFinish %s!", TAG, Integer.valueOf(this.mSession.key & UShort.MAX_VALUE), z ? "success" : "fail");
        if (z) {
            try {
                beginReceived(this.mSession.key);
            } catch (Exception e) {
                DebugLog.e("%s session(%d): onShakeHandFinish error = %s!", TAG, Integer.valueOf(this.mSession.key & UShort.MAX_VALUE), e.toString());
                dispose();
            }
        } else {
            DebugLog.e("%s session(%d): onShakeHandFinish fail dispose()!", TAG, Integer.valueOf(this.mSession.key & UShort.MAX_VALUE));
            dispose();
        }
    }

    public void send(ByteBuffer byteBuffer) {
        DebugLog.v("%s session(%d): send", TAG, Integer.valueOf(this.mSession.key & UShort.MAX_VALUE));
        Tunnel tunnel = this.mBrotherTunnel;
        if (tunnel != null) {
            tunnel.sendCommend(byteBuffer, this.mSession);
        }
    }

    public void setBrotherTunnel(Tunnel tunnel) {
        NatSession natSession = getNatSession();
        IDataHandler dataHandler = Global.HOLDER.getDataHandler();
        if (dataHandler != null) {
            ((RemoteTunnel) tunnel).setLocalReceiveDataWhenConnected(dataHandler.isLocalReceiveDataWhenConnected(natSession));
        }
        createAdapter(natSession);
        super.setBrotherTunnel(tunnel);
    }

    public void startHands() {
        NatSession natSession = getNatSession();
        if (natSession != null && natSession.mAdapter != null) {
            DebugLog.v("%s session(%d): startHands", TAG, Integer.valueOf(natSession.key & UShort.MAX_VALUE));
            natSession.mAdapter.onStartHands(this.mSession);
        }
    }
}
