package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ByteProcessor;
import java.util.List;

public class LineBasedFrameDecoder extends ByteToMessageDecoder {
    private int discardedBytes;
    private boolean discarding;
    private final boolean failFast;
    private final int maxLength;
    private int offset;
    private final boolean stripDelimiter;

    public LineBasedFrameDecoder(int i) {
        this(i, true, false);
    }

    private void fail(ChannelHandlerContext channelHandlerContext, int i) {
        fail(channelHandlerContext, String.valueOf(i));
    }

    private int findEndOfLine(ByteBuf byteBuf) {
        int readableBytes = byteBuf.readableBytes();
        int readerIndex = byteBuf.readerIndex();
        int i = this.offset;
        int forEachByte = byteBuf.forEachByte(readerIndex + i, readableBytes - i, ByteProcessor.FIND_LF);
        if (forEachByte >= 0) {
            this.offset = 0;
            return (forEachByte <= 0 || byteBuf.getByte(forEachByte + -1) != 13) ? forEachByte : forEachByte - 1;
        }
        this.offset = readableBytes;
        return forEachByte;
    }

    public final void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        Object decode = decode(channelHandlerContext, byteBuf);
        if (decode != null) {
            list.add(decode);
        }
    }

    public LineBasedFrameDecoder(int i, boolean z, boolean z2) {
        this.maxLength = i;
        this.failFast = z2;
        this.stripDelimiter = z;
    }

    private void fail(ChannelHandlerContext channelHandlerContext, String str) {
        channelHandlerContext.fireExceptionCaught(new TooLongFrameException("frame length (" + str + ") exceeds the allowed maximum (" + this.maxLength + ')'));
    }

    public Object decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        int findEndOfLine = findEndOfLine(byteBuf);
        int i = 2;
        if (this.discarding) {
            if (findEndOfLine >= 0) {
                int readerIndex = (this.discardedBytes + findEndOfLine) - byteBuf.readerIndex();
                if (byteBuf.getByte(findEndOfLine) != 13) {
                    i = 1;
                }
                byteBuf.readerIndex(findEndOfLine + i);
                this.discardedBytes = 0;
                this.discarding = false;
                if (!this.failFast) {
                    fail(channelHandlerContext, readerIndex);
                }
            } else {
                this.discardedBytes += byteBuf.readableBytes();
                byteBuf.readerIndex(byteBuf.writerIndex());
                this.offset = 0;
            }
            return null;
        } else if (findEndOfLine >= 0) {
            int readerIndex2 = findEndOfLine - byteBuf.readerIndex();
            if (byteBuf.getByte(findEndOfLine) != 13) {
                i = 1;
            }
            if (readerIndex2 > this.maxLength) {
                byteBuf.readerIndex(findEndOfLine + i);
                fail(channelHandlerContext, readerIndex2);
                return null;
            } else if (!this.stripDelimiter) {
                return byteBuf.readRetainedSlice(readerIndex2 + i);
            } else {
                ByteBuf readRetainedSlice = byteBuf.readRetainedSlice(readerIndex2);
                byteBuf.skipBytes(i);
                return readRetainedSlice;
            }
        } else {
            int readableBytes = byteBuf.readableBytes();
            if (readableBytes > this.maxLength) {
                this.discardedBytes = readableBytes;
                byteBuf.readerIndex(byteBuf.writerIndex());
                this.discarding = true;
                this.offset = 0;
                if (this.failFast) {
                    fail(channelHandlerContext, "over " + this.discardedBytes);
                }
            }
            return null;
        }
    }
}
