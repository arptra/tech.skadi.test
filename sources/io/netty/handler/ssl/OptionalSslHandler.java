package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

public class OptionalSslHandler extends ByteToMessageDecoder {
    private final SslContext sslContext;

    public OptionalSslHandler(SslContext sslContext2) {
        this.sslContext = (SslContext) ObjectUtil.checkNotNull(sslContext2, "sslContext");
    }

    private void handleNonSsl(ChannelHandlerContext channelHandlerContext) {
        ChannelHandler newNonSslHandler = newNonSslHandler(channelHandlerContext);
        if (newNonSslHandler != null) {
            channelHandlerContext.pipeline().replace((ChannelHandler) this, newNonSslHandlerName(), newNonSslHandler);
        } else {
            channelHandlerContext.pipeline().remove((ChannelHandler) this);
        }
    }

    private void handleSsl(ChannelHandlerContext channelHandlerContext) {
        SslHandler sslHandler = null;
        try {
            sslHandler = newSslHandler(channelHandlerContext, this.sslContext);
            channelHandlerContext.pipeline().replace((ChannelHandler) this, newSslHandlerName(), (ChannelHandler) sslHandler);
        } catch (Throwable th) {
            if (sslHandler != null) {
                ReferenceCountUtil.safeRelease(sslHandler.engine());
            }
            throw th;
        }
    }

    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        if (byteBuf.readableBytes() >= 5) {
            if (SslHandler.isEncrypted(byteBuf)) {
                handleSsl(channelHandlerContext);
            } else {
                handleNonSsl(channelHandlerContext);
            }
        }
    }

    public ChannelHandler newNonSslHandler(ChannelHandlerContext channelHandlerContext) {
        return null;
    }

    public String newNonSslHandlerName() {
        return null;
    }

    public SslHandler newSslHandler(ChannelHandlerContext channelHandlerContext, SslContext sslContext2) {
        return sslContext2.newHandler(channelHandlerContext.alloc());
    }

    public String newSslHandlerName() {
        return null;
    }
}
