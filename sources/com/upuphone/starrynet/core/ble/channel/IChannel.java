package com.upuphone.starrynet.core.ble.channel;

import com.upuphone.starrynet.core.ble.channel.packet.Packet;
import java.util.List;

public interface IChannel {
    public static final int SENSE_BLE_DISCONNECT = 1;
    public static final int SENSE_NORMAL = 0;

    void onRead(byte[] bArr);

    void onReadPacket(Packet packet, IChannelPacketReadResult iChannelPacketReadResult);

    void onRecv(byte[] bArr, int i);

    void reset(int i);

    void send(int i, byte[] bArr, int i2, ChannelCallback channelCallback);

    void send(byte[] bArr, int i, ChannelCallback channelCallback);

    void write(byte[] bArr, ChannelCallback channelCallback, boolean z);

    void writeBatchData(List<byte[]> list, ChannelCallback channelCallback);
}
