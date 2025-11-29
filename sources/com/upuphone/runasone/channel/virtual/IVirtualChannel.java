package com.upuphone.runasone.channel.virtual;

import com.upuphone.runasone.channel.IChannel;
import com.upuphone.runasone.channel.linker.EnumLinker;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.message.ChannelMessage;

public interface IVirtualChannel extends IChannel {
    void input(ChannelMessage channelMessage);

    void linkDown(StarryDevice starryDevice, EnumLinker enumLinker);

    void linkUp(StarryDevice starryDevice, EnumLinker enumLinker);
}
