package com.upuphone.runasone.channel.proxy.client;

import com.upuphone.runasone.channel.proxy.client.channel.IDataHandler;
import com.upuphone.runasone.channel.proxy.client.nat.NatSession;
import java.nio.ByteBuffer;

public class SocksProxyHandler implements IDataHandler {
    public ByteBuffer afterReceived(NatSession natSession, ByteBuffer byteBuffer) {
        return natSession.mAdapter.afterReceived(natSession, byteBuffer);
    }

    public ByteBuffer beforeSend(NatSession natSession, ByteBuffer byteBuffer) {
        return natSession.mAdapter.beforeSend(natSession, byteBuffer);
    }

    public void dispose() {
    }

    public boolean isDispose() {
        return false;
    }

    public boolean isLocalReceiveDataWhenConnected(NatSession natSession) {
        return false;
    }
}
