package com.upuphone.runasone.channel;

import com.upuphone.runasone.channel.virtual.IVirtualChannel;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.host.core.api.EnumLinkStrategy;

public interface IChannelManager {

    public interface ChannelObserver {
        void onChannelError(StarryDevice starryDevice, EnumLinkStrategy enumLinkStrategy, int i);

        void onChannelLinkDown(StarryDevice starryDevice, EnumLinkStrategy enumLinkStrategy);

        void onChannelLinkUp(StarryDevice starryDevice, EnumLinkStrategy enumLinkStrategy);
    }

    IChannel allocChannel(StarryDevice starryDevice, EnumLinkStrategy enumLinkStrategy);

    IVirtualChannel allocVirtualChannel(StarryDevice starryDevice, EnumLinkStrategy enumLinkStrategy, IChannel iChannel);

    IChannel findChannelById(String str);

    void initServer(int i);

    void install();

    boolean isAuthTransition(String str);

    void releaseChannel(String str);

    void setChannelObserver(ChannelObserver channelObserver);

    void uninstall();
}
