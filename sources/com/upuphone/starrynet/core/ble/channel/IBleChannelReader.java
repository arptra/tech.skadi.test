package com.upuphone.starrynet.core.ble.channel;

public interface IBleChannelReader {
    void onRead(ChannelTag channelTag, byte[] bArr, int i);
}
