package com.share.connect.channel;

import com.ucar.connect.ConnectManager;
import com.ucar.protocol.channel.ChannelType;
import com.ucar.protocol.channel.socket.SocketChannel;

public class ConnectChannel extends SocketChannel {
    public ConnectChannel(ChannelType channelType, boolean z, boolean z2) {
        super(channelType, z, z2);
    }

    public void L0() {
        ConnectManager.a().b(b(), true);
    }
}
