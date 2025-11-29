package com.upuphone.runasone.channel.linker.bt;

import com.upuphone.runasone.channel.bean.auth.AuthParameter;
import com.upuphone.runasone.message.ChannelMessage;

public interface BtServerListener {
    void input(ChannelMessage channelMessage);

    void onAuth(String str, AuthParameter authParameter);

    void onClose();

    void onError(int i);

    void onRetransmission(long j, long j2);
}
