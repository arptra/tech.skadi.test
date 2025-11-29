package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.Future;
import java.util.Locale;

public abstract class AbstractSniHandler<T> extends SslClientHelloHandler<T> {
    private String hostname;

    private static String extractSniHostname(ByteBuf byteBuf) {
        int readerIndex = byteBuf.readerIndex();
        int writerIndex = byteBuf.writerIndex();
        int i = readerIndex + 34;
        if (writerIndex - i < 6) {
            return null;
        }
        int unsignedByte = i + byteBuf.getUnsignedByte(i) + 1;
        int unsignedShort = unsignedByte + byteBuf.getUnsignedShort(unsignedByte) + 2;
        int unsignedByte2 = unsignedShort + byteBuf.getUnsignedByte(unsignedShort) + 1;
        int unsignedShort2 = byteBuf.getUnsignedShort(unsignedByte2);
        int i2 = unsignedByte2 + 2;
        int i3 = unsignedShort2 + i2;
        if (i3 > writerIndex) {
            return null;
        }
        while (i3 - i2 >= 4) {
            int unsignedShort3 = byteBuf.getUnsignedShort(i2);
            int unsignedShort4 = byteBuf.getUnsignedShort(i2 + 2);
            int i4 = i2 + 4;
            if (i3 - i4 < unsignedShort4) {
                return null;
            }
            if (unsignedShort3 == 0) {
                int i5 = i2 + 6;
                if (i3 - i5 < 3) {
                    return null;
                }
                int i6 = i2 + 7;
                if (byteBuf.getUnsignedByte(i5) != 0) {
                    return null;
                }
                int unsignedShort5 = byteBuf.getUnsignedShort(i6);
                int i7 = i2 + 9;
                if (i3 - i7 < unsignedShort5) {
                    return null;
                }
                return byteBuf.toString(i7, unsignedShort5, CharsetUtil.US_ASCII).toLowerCase(Locale.US);
            }
            i2 = i4 + unsignedShort4;
        }
        return null;
    }

    private static void fireSniCompletionEvent(ChannelHandlerContext channelHandlerContext, String str, Future<?> future) {
        Throwable cause = future.cause();
        if (cause == null) {
            channelHandlerContext.fireUserEventTriggered(new SniCompletionEvent(str));
        } else {
            channelHandlerContext.fireUserEventTriggered(new SniCompletionEvent(str, cause));
        }
    }

    public Future<T> lookup(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        String extractSniHostname = byteBuf == null ? null : extractSniHostname(byteBuf);
        this.hostname = extractSniHostname;
        return lookup(channelHandlerContext, extractSniHostname);
    }

    public abstract Future<T> lookup(ChannelHandlerContext channelHandlerContext, String str) throws Exception;

    public void onLookupComplete(ChannelHandlerContext channelHandlerContext, Future<T> future) throws Exception {
        try {
            onLookupComplete(channelHandlerContext, this.hostname, future);
        } finally {
            fireSniCompletionEvent(channelHandlerContext, this.hostname, future);
        }
    }

    public abstract void onLookupComplete(ChannelHandlerContext channelHandlerContext, String str, Future<T> future) throws Exception;
}
