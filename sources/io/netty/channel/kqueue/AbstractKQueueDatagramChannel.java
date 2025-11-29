package io.netty.channel.kqueue;

import io.netty.channel.Channel;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import java.io.IOException;

abstract class AbstractKQueueDatagramChannel extends AbstractKQueueChannel {
    private static final ChannelMetadata METADATA = new ChannelMetadata(true);

    public AbstractKQueueDatagramChannel(Channel channel, BsdSocket bsdSocket, boolean z) {
        super(channel, bsdSocket, z);
    }

    public void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        int maxMessagesPerWrite = maxMessagesPerWrite();
        loop0:
        while (maxMessagesPerWrite > 0) {
            Object current = channelOutboundBuffer.current();
            if (current == null) {
                break;
            }
            try {
                int writeSpinCount = config().getWriteSpinCount();
                while (writeSpinCount > 0) {
                    if (doWriteMessage(current)) {
                        channelOutboundBuffer.remove();
                        maxMessagesPerWrite--;
                    } else {
                        writeSpinCount--;
                    }
                }
                break loop0;
            } catch (IOException e) {
                maxMessagesPerWrite--;
                channelOutboundBuffer.remove(e);
            }
        }
        writeFilter(!channelOutboundBuffer.isEmpty());
    }

    public abstract boolean doWriteMessage(Object obj) throws Exception;

    public ChannelMetadata metadata() {
        return METADATA;
    }
}
