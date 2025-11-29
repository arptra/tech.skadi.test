package io.netty.handler.codec.compression;

import com.aayushatharva.brotli4j.encoder.Encoder;
import com.aayushatharva.brotli4j.encoder.Encoders;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.ObjectUtil;

@ChannelHandler.Sharable
public final class BrotliEncoder extends MessageToByteEncoder<ByteBuf> {
    private final Encoder.Parameters parameters;

    public BrotliEncoder() {
        this(BrotliOptions.DEFAULT);
    }

    public void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, ByteBuf byteBuf2) throws Exception {
    }

    public BrotliEncoder(Encoder.Parameters parameters2) {
        this.parameters = (Encoder.Parameters) ObjectUtil.checkNotNull(parameters2, "Parameters");
    }

    public ByteBuf allocateBuffer(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, boolean z) throws Exception {
        ByteBuf byteBuf2;
        if (!byteBuf.isReadable()) {
            return Unpooled.EMPTY_BUFFER;
        }
        if (z) {
            try {
                byteBuf2 = channelHandlerContext.alloc().ioBuffer();
            } catch (Exception e) {
                ReferenceCountUtil.release(byteBuf);
                throw e;
            }
        } else {
            byteBuf2 = channelHandlerContext.alloc().buffer();
        }
        Encoders.compress(byteBuf, byteBuf2, this.parameters);
        return byteBuf2;
    }

    public BrotliEncoder(BrotliOptions brotliOptions) {
        this(brotliOptions.parameters());
    }
}
