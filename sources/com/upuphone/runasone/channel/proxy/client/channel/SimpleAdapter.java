package com.upuphone.runasone.channel.proxy.client.channel;

import com.upuphone.runasone.channel.proxy.client.nat.NatSession;
import java.nio.ByteBuffer;

public class SimpleAdapter implements IDataAdapter {
    public IShakeHandsListener shakeHandsListener;

    public ByteBuffer afterReceived(NatSession natSession, ByteBuffer byteBuffer) {
        return byteBuffer;
    }

    public ByteBuffer beforeSend(NatSession natSession, ByteBuffer byteBuffer) {
        return byteBuffer;
    }

    public void init() {
    }

    public void onStartHands(NatSession natSession) {
    }
}
