package io.netty.handler.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.TypeParameterMatcher;
import java.util.List;

public abstract class MessageToMessageDecoder<I> extends ChannelInboundHandlerAdapter {
    private final TypeParameterMatcher matcher;

    public MessageToMessageDecoder() {
        this.matcher = TypeParameterMatcher.find(this, MessageToMessageDecoder.class, "I");
    }

    public boolean acceptInboundMessage(Object obj) throws Exception {
        return this.matcher.match(obj);
    }

    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        CodecOutputList newInstance = CodecOutputList.newInstance();
        int i = 0;
        try {
            if (acceptInboundMessage(obj)) {
                decode(channelHandlerContext, obj, newInstance);
                ReferenceCountUtil.release(obj);
            } else {
                newInstance.add(obj);
            }
            try {
                int size = newInstance.size();
                while (i < size) {
                    channelHandlerContext.fireChannelRead(newInstance.getUnsafe(i));
                    i++;
                }
            } finally {
                newInstance.recycle();
            }
        } catch (DecoderException e) {
            throw e;
        } catch (Exception e2) {
            throw new DecoderException((Throwable) e2);
        } catch (Throwable th) {
            newInstance.recycle();
            throw th;
        }
    }

    public abstract void decode(ChannelHandlerContext channelHandlerContext, I i, List<Object> list) throws Exception;

    public MessageToMessageDecoder(Class<? extends I> cls) {
        this.matcher = TypeParameterMatcher.get(cls);
    }
}
