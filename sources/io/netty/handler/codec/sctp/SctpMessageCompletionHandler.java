package io.netty.handler.codec.sctp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.sctp.SctpMessage;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.collection.IntObjectHashMap;
import io.netty.util.collection.IntObjectMap;
import java.util.List;

public class SctpMessageCompletionHandler extends MessageToMessageDecoder<SctpMessage> {
    private final IntObjectMap<ByteBuf> fragments = new IntObjectHashMap();

    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        for (ByteBuf release : this.fragments.values()) {
            release.release();
        }
        this.fragments.clear();
        super.handlerRemoved(channelHandlerContext);
    }

    public void decode(ChannelHandlerContext channelHandlerContext, SctpMessage sctpMessage, List<Object> list) throws Exception {
        ByteBuf content = sctpMessage.content();
        int protocolIdentifier = sctpMessage.protocolIdentifier();
        int streamIdentifier = sctpMessage.streamIdentifier();
        boolean isComplete = sctpMessage.isComplete();
        boolean isUnordered = sctpMessage.isUnordered();
        ByteBuf remove = this.fragments.remove(streamIdentifier);
        if (remove == null) {
            remove = Unpooled.EMPTY_BUFFER;
        }
        if (isComplete && !remove.isReadable()) {
            list.add(sctpMessage);
        } else if (!isComplete && remove.isReadable()) {
            this.fragments.put(streamIdentifier, Unpooled.wrappedBuffer(remove, content));
        } else if (!isComplete || !remove.isReadable()) {
            this.fragments.put(streamIdentifier, content);
        } else {
            list.add(new SctpMessage(protocolIdentifier, streamIdentifier, isUnordered, Unpooled.wrappedBuffer(remove, content)));
        }
        content.retain();
    }
}
