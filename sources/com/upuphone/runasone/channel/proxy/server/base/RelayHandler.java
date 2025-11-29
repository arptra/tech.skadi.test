package com.upuphone.runasone.channel.proxy.server.base;

import com.upuphone.runasone.channel.proxy.client.util.DebugLog;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import java.util.concurrent.TimeUnit;

public class RelayHandler extends ChannelInboundHandlerAdapter {
    private static final String TAG = "RelayHandler";
    /* access modifiers changed from: private */
    public final Channel relayChannel;

    public class CheckRunnable implements Runnable {
        private Channel channel;

        public void run() {
            Channel channel2;
            DebugLog.v("%s: check isWritable", RelayHandler.TAG);
            try {
                if (!(RelayHandler.this.relayChannel == null || !RelayHandler.this.relayChannel.isActive() || (channel2 = this.channel) == null)) {
                    if (channel2.isActive()) {
                        ChannelConfig config = this.channel.config();
                        if (RelayHandler.this.relayChannel.isWritable() && !config.isAutoRead()) {
                            DebugLog.v("%s: begin isWritable", RelayHandler.TAG);
                            config.setAutoRead(true);
                            this.channel.read();
                            return;
                        } else if (!RelayHandler.this.relayChannel.isWritable()) {
                            DebugLog.v("%s: loop isWritable", RelayHandler.TAG);
                            this.channel.eventLoop().schedule((Runnable) this, 100, TimeUnit.MILLISECONDS);
                            return;
                        } else {
                            return;
                        }
                    }
                }
                DebugLog.d("%s: check isWritable", RelayHandler.TAG);
                ChannelServerUtils.closeOnFlush(RelayHandler.this.relayChannel);
            } catch (Exception e) {
                DebugLog.e("%s: e = %s", RelayHandler.TAG, e);
                ChannelServerUtils.closeOnFlush(this.channel);
                ChannelServerUtils.closeOnFlush(RelayHandler.this.relayChannel);
            }
        }

        private CheckRunnable(Channel channel2) {
            this.channel = channel2;
        }
    }

    public RelayHandler(Channel channel) {
        this.relayChannel = channel;
    }

    public void channelActive(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.writeAndFlush(Unpooled.EMPTY_BUFFER);
    }

    public void channelInactive(ChannelHandlerContext channelHandlerContext) {
        ChannelServerUtils.closeOnFlush(this.relayChannel);
    }

    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) {
        if (this.relayChannel.isActive()) {
            if (!this.relayChannel.isWritable()) {
                DebugLog.v("%s: Not isWritable", TAG);
                ChannelConfig config = channelHandlerContext.channel().config();
                if (config.isAutoRead()) {
                    config.setAutoRead(false);
                    channelHandlerContext.channel().eventLoop().schedule((Runnable) new CheckRunnable(channelHandlerContext.channel()), 100, TimeUnit.MILLISECONDS);
                }
            }
            this.relayChannel.writeAndFlush(obj);
            return;
        }
        ReferenceCountUtil.release(obj);
    }

    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
        th.printStackTrace();
        ChannelServerUtils.closeOnFlush(channelHandlerContext.channel());
        ChannelServerUtils.closeOnFlush(this.relayChannel);
    }
}
