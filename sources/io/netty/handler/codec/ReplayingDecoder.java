package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.Signal;
import io.netty.util.internal.StringUtil;
import java.util.List;

public abstract class ReplayingDecoder<S> extends ByteToMessageDecoder {
    static final Signal REPLAY = Signal.valueOf(ReplayingDecoder.class, "REPLAY");
    private int checkpoint;
    private final ReplayingDecoderByteBuf replayable;
    private S state;

    public ReplayingDecoder() {
        this((Object) null);
    }

    public void callDecode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        this.replayable.setCumulation(byteBuf);
        while (byteBuf.isReadable()) {
            try {
                int readerIndex = byteBuf.readerIndex();
                this.checkpoint = readerIndex;
                int size = list.size();
                if (size > 0) {
                    ByteToMessageDecoder.fireChannelRead(channelHandlerContext, list, size);
                    list.clear();
                    if (!channelHandlerContext.isRemoved()) {
                        size = 0;
                    } else {
                        return;
                    }
                }
                S s = this.state;
                int readableBytes = byteBuf.readableBytes();
                try {
                    decodeRemovalReentryProtection(channelHandlerContext, this.replayable, list);
                    if (!channelHandlerContext.isRemoved()) {
                        if (size != list.size()) {
                            if (readerIndex == byteBuf.readerIndex()) {
                                if (s == this.state) {
                                    throw new DecoderException(StringUtil.simpleClassName(getClass()) + ".decode() method must consume the inbound data or change its state if it decoded something.");
                                }
                            }
                            if (isSingleDecode()) {
                                return;
                            }
                        } else if (readableBytes != byteBuf.readableBytes()) {
                            continue;
                        } else if (s == this.state) {
                            throw new DecoderException(StringUtil.simpleClassName(getClass()) + ".decode() must consume the inbound data or change its state if it did not decode anything.");
                        }
                    } else {
                        return;
                    }
                } catch (Signal e) {
                    e.expect(REPLAY);
                    if (!channelHandlerContext.isRemoved()) {
                        int i = this.checkpoint;
                        if (i >= 0) {
                            byteBuf.readerIndex(i);
                            return;
                        }
                        return;
                    }
                    return;
                }
            } catch (DecoderException e2) {
                throw e2;
            } catch (Exception e3) {
                throw new DecoderException((Throwable) e3);
            }
        }
    }

    public final void channelInputClosed(ChannelHandlerContext channelHandlerContext, List<Object> list) throws Exception {
        try {
            this.replayable.terminate();
            if (this.cumulation != null) {
                callDecode(channelHandlerContext, internalBuffer(), list);
            } else {
                this.replayable.setCumulation(Unpooled.EMPTY_BUFFER);
            }
            decodeLast(channelHandlerContext, this.replayable, list);
        } catch (Signal e) {
            e.expect(REPLAY);
        }
    }

    public void checkpoint() {
        this.checkpoint = internalBuffer().readerIndex();
    }

    public S state() {
        return this.state;
    }

    public ReplayingDecoder(S s) {
        this.replayable = new ReplayingDecoderByteBuf();
        this.checkpoint = -1;
        this.state = s;
    }

    public void checkpoint(S s) {
        checkpoint();
        state(s);
    }

    public S state(S s) {
        S s2 = this.state;
        this.state = s;
        return s2;
    }
}
