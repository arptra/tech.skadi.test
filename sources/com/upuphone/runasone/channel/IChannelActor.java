package com.upuphone.runasone.channel;

import com.upuphone.runasone.message.ChannelMessage;

public interface IChannelActor {
    boolean output(ChannelMessage channelMessage);
}
