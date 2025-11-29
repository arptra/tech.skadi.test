package com.upuphone.runasone.channel.proxy.client.channel;

import java.nio.ByteBuffer;

public interface IShakeHandsListener {
    void onShakeHandFinish(boolean z);

    void send(ByteBuffer byteBuffer);
}
