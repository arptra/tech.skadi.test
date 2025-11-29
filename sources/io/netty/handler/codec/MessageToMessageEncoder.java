package io.netty.handler.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.PromiseCombiner;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.TypeParameterMatcher;
import java.util.List;

public abstract class MessageToMessageEncoder<I> extends ChannelOutboundHandlerAdapter {
    private final TypeParameterMatcher matcher;

    public MessageToMessageEncoder() {
        this.matcher = TypeParameterMatcher.find(this, MessageToMessageEncoder.class, "I");
    }

    private static void writePromiseCombiner(ChannelHandlerContext channelHandlerContext, CodecOutputList codecOutputList, ChannelPromise channelPromise) {
        PromiseCombiner promiseCombiner = new PromiseCombiner(channelHandlerContext.executor());
        for (int i = 0; i < codecOutputList.size(); i++) {
            promiseCombiner.add((Future) channelHandlerContext.write(codecOutputList.getUnsafe(i)));
        }
        promiseCombiner.finish(channelPromise);
    }

    private static void writeVoidPromise(ChannelHandlerContext channelHandlerContext, CodecOutputList codecOutputList) {
        ChannelPromise voidPromise = channelHandlerContext.voidPromise();
        for (int i = 0; i < codecOutputList.size(); i++) {
            channelHandlerContext.write(codecOutputList.getUnsafe(i), voidPromise);
        }
    }

    public boolean acceptOutboundMessage(Object obj) throws Exception {
        return this.matcher.match(obj);
    }

    public abstract void encode(ChannelHandlerContext channelHandlerContext, I i, List<Object> list) throws Exception;

    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        CodecOutputList codecOutputList = null;
        try {
            if (acceptOutboundMessage(obj)) {
                codecOutputList = CodecOutputList.newInstance();
                try {
                    encode(channelHandlerContext, obj, codecOutputList);
                } catch (Throwable th) {
                    ReferenceCountUtil.safeRelease(obj);
                    PlatformDependent.throwException(th);
                }
                ReferenceCountUtil.release(obj);
                if (codecOutputList.isEmpty()) {
                    throw new EncoderException(StringUtil.simpleClassName((Object) this) + " must produce at least one message.");
                }
            } else {
                channelHandlerContext.write(obj, channelPromise);
            }
            if (codecOutputList != null) {
                try {
                    int size = codecOutputList.size() - 1;
                    if (size == 0) {
                        channelHandlerContext.write(codecOutputList.getUnsafe(0), channelPromise);
                    } else if (size > 0) {
                        if (channelPromise == channelHandlerContext.voidPromise()) {
                            writeVoidPromise(channelHandlerContext, codecOutputList);
                        } else {
                            writePromiseCombiner(channelHandlerContext, codecOutputList, channelPromise);
                        }
                    }
                } finally {
                    codecOutputList.recycle();
                }
            }
        } catch (EncoderException e) {
            throw e;
        } catch (Throwable th2) {
            if (codecOutputList != null) {
                try {
                    int size2 = codecOutputList.size() - 1;
                    if (size2 == 0) {
                        channelHandlerContext.write(codecOutputList.getUnsafe(0), channelPromise);
                    } else if (size2 > 0) {
                        if (channelPromise == channelHandlerContext.voidPromise()) {
                            writeVoidPromise(channelHandlerContext, codecOutputList);
                        } else {
                            writePromiseCombiner(channelHandlerContext, codecOutputList, channelPromise);
                        }
                    }
                } finally {
                    codecOutputList.recycle();
                }
            }
            throw th2;
        }
    }

    public MessageToMessageEncoder(Class<? extends I> cls) {
        this.matcher = TypeParameterMatcher.get(cls);
    }
}
