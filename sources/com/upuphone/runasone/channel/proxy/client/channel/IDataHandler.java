package com.upuphone.runasone.channel.proxy.client.channel;

import com.upuphone.runasone.channel.proxy.client.nat.NatSession;
import java.nio.ByteBuffer;

public interface IDataHandler {
    ByteBuffer afterReceived(NatSession natSession, ByteBuffer byteBuffer);

    ByteBuffer beforeSend(NatSession natSession, ByteBuffer byteBuffer);

    void dispose();

    boolean isDispose();

    boolean isLocalReceiveDataWhenConnected(NatSession natSession);
}
