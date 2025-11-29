package com.upuphone.runasone.channel.linker;

import com.upuphone.runasone.channel.bean.auth.AuthParameter;
import com.upuphone.runasone.message.ChannelMessage;

public interface ILinker {

    public interface LinkerStreamObserver {
        void input(EnumLinker enumLinker, ChannelMessage channelMessage);

        void onRetransmission(EnumLinker enumLinker, long j, long j2);

        void onStreamClose(EnumLinker enumLinker);

        void onStreamError(EnumLinker enumLinker, int i);

        void onStreamOpen(EnumLinker enumLinker, AuthParameter authParameter);

        void onStreamTearDown(EnumLinker enumLinker);

        void onUpdateQos(EnumLinker enumLinker, int i);
    }

    void close();

    boolean isAuthTransition();

    void notifyTearDownSync();

    boolean open(boolean z, AuthParameter authParameter);

    boolean output(ChannelMessage channelMessage);

    void setSession(String str);

    void shutdown();

    void startup(String str, LinkerStreamObserver linkerStreamObserver);

    void triggerAck(long j);

    boolean triggerRetransmission(long j, long j2);
}
