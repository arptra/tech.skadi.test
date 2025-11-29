package com.upuphone.runasone.channel.linker.simplified;

import com.upuphone.runasone.message.ChannelMessage;

public interface SimplifiedMessageListener {
    void receivePlayloadMessage(ChannelMessage channelMessage);
}
