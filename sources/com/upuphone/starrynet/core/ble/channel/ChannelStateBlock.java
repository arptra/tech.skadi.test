package com.upuphone.starrynet.core.ble.channel;

public class ChannelStateBlock {
    public ChannelEvent event;
    public IChannelStateHandler handler;
    public ChannelState state;

    public ChannelStateBlock(ChannelState channelState, ChannelEvent channelEvent, IChannelStateHandler iChannelStateHandler) {
        this.state = channelState;
        this.event = channelEvent;
        this.handler = iChannelStateHandler;
    }
}
