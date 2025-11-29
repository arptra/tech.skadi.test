package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.AddressedEnvelope;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.List;

public class DatagramPacketEncoder<M> extends MessageToMessageEncoder<AddressedEnvelope<M, InetSocketAddress>> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final MessageToMessageEncoder<? super M> encoder;

    public DatagramPacketEncoder(MessageToMessageEncoder<? super M> messageToMessageEncoder) {
        this.encoder = (MessageToMessageEncoder) ObjectUtil.checkNotNull(messageToMessageEncoder, "encoder");
    }

    public boolean acceptOutboundMessage(Object obj) throws Exception {
        if (!super.acceptOutboundMessage(obj)) {
            return false;
        }
        AddressedEnvelope addressedEnvelope = (AddressedEnvelope) obj;
        if (this.encoder.acceptOutboundMessage(addressedEnvelope.content())) {
            return ((addressedEnvelope.sender() instanceof InetSocketAddress) || addressedEnvelope.sender() == null) && (addressedEnvelope.recipient() instanceof InetSocketAddress);
        }
        return false;
    }

    public void bind(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, ChannelPromise channelPromise) throws Exception {
        this.encoder.bind(channelHandlerContext, socketAddress, channelPromise);
    }

    public void close(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        this.encoder.close(channelHandlerContext, channelPromise);
    }

    public void connect(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) throws Exception {
        this.encoder.connect(channelHandlerContext, socketAddress, socketAddress2, channelPromise);
    }

    public void deregister(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        this.encoder.deregister(channelHandlerContext, channelPromise);
    }

    public void disconnect(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        this.encoder.disconnect(channelHandlerContext, channelPromise);
    }

    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
        this.encoder.exceptionCaught(channelHandlerContext, th);
    }

    public void flush(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.encoder.flush(channelHandlerContext);
    }

    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.encoder.handlerAdded(channelHandlerContext);
    }

    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.encoder.handlerRemoved(channelHandlerContext);
    }

    public boolean isSharable() {
        return this.encoder.isSharable();
    }

    public void read(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.encoder.read(channelHandlerContext);
    }

    public void encode(ChannelHandlerContext channelHandlerContext, AddressedEnvelope<M, InetSocketAddress> addressedEnvelope, List<Object> list) throws Exception {
        this.encoder.encode(channelHandlerContext, addressedEnvelope.content(), list);
        if (list.size() == 1) {
            Object obj = list.get(0);
            if (obj instanceof ByteBuf) {
                list.set(0, new DatagramPacket((ByteBuf) obj, addressedEnvelope.recipient(), addressedEnvelope.sender()));
                return;
            }
            throw new EncoderException(StringUtil.simpleClassName((Object) this.encoder) + " must produce only ByteBuf.");
        }
        throw new EncoderException(StringUtil.simpleClassName((Object) this.encoder) + " must produce only one message.");
    }
}
