package com.upuphone.starrynet.core.ble.channel;

import com.upuphone.starrynet.core.ble.channel.packet.Packet;

public interface IChannelPacketReadResult {
    void onResult(Packet packet, boolean z);
}
