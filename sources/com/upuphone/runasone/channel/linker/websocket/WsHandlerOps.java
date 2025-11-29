package com.upuphone.runasone.channel.linker.websocket;

import com.upuphone.runasone.channel.bean.auth.AuthParameter;
import com.upuphone.runasone.message.ChannelMessage;
import io.netty.channel.SimpleChannelInboundHandler;

public interface WsHandlerOps {

    public interface OnEvent {
        AuthParameter getAuthParameter();

        String getSelfId();

        void onAck(String str, long j);

        boolean onAuth(String str, AuthParameter authParameter, SimpleChannelInboundHandler simpleChannelInboundHandler);

        void onClose(String str);

        void onConnected(String str, String str2);

        void onError(String str, int i);

        void onMessageArrived(String str, ChannelMessage channelMessage);

        void onRetransmission(String str, long j, long j2);

        void onTearDown(String str);

        void onTearDownAck(String str);

        boolean onUpdateQos(String str, int i);
    }

    void setOnEventListener(OnEvent onEvent);
}
