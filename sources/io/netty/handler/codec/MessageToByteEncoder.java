package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.TypeParameterMatcher;

public abstract class MessageToByteEncoder<I> extends ChannelOutboundHandlerAdapter {
    private final TypeParameterMatcher matcher;
    private final boolean preferDirect;

    public MessageToByteEncoder() {
        this(true);
    }

    public boolean acceptOutboundMessage(Object obj) throws Exception {
        return this.matcher.match(obj);
    }

    public ByteBuf allocateBuffer(ChannelHandlerContext channelHandlerContext, I i, boolean z) throws Exception {
        return z ? channelHandlerContext.alloc().ioBuffer() : channelHandlerContext.alloc().heapBuffer();
    }

    public abstract void encode(ChannelHandlerContext channelHandlerContext, I i, ByteBuf byteBuf) throws Exception;

    public boolean isPreferDirect() {
        return this.preferDirect;
    }

    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        ByteBuf byteBuf = null;
        try {
            if (acceptOutboundMessage(obj)) {
                byteBuf = allocateBuffer(channelHandlerContext, obj, this.preferDirect);
                encode(channelHandlerContext, obj, byteBuf);
                ReferenceCountUtil.release(obj);
                if (byteBuf.isReadable()) {
                    channelHandlerContext.write(byteBuf, channelPromise);
                    return;
                }
                byteBuf.release();
                channelHandlerContext.write(Unpooled.EMPTY_BUFFER, channelPromise);
                return;
            }
            channelHandlerContext.write(obj, channelPromise);
        } catch (EncoderException e) {
            throw e;
        } catch (Throwable th) {
            if (byteBuf != null) {
                byteBuf.release();
            }
            throw th;
        }
    }

    public MessageToByteEncoder(Class<? extends I> cls) {
        this(cls, true);
    }

    public MessageToByteEncoder(boolean z) {
        this.matcher = TypeParameterMatcher.find(this, MessageToByteEncoder.class, "I");
        this.preferDirect = z;
    }

    public MessageToByteEncoder(Class<? extends I> cls, boolean z) {
        this.matcher = TypeParameterMatcher.get(cls);
        this.preferDirect = z;
    }
}
