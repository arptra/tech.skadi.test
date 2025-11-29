package io.netty.channel.pool;

import io.netty.channel.Channel;

public abstract class AbstractChannelPoolHandler implements ChannelPoolHandler {
    public void channelAcquired(Channel channel) throws Exception {
    }

    public void channelReleased(Channel channel) throws Exception {
    }
}
