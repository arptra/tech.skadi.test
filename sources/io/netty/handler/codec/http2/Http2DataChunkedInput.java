package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.stream.ChunkedInput;
import io.netty.util.internal.ObjectUtil;

public final class Http2DataChunkedInput implements ChunkedInput<Http2DataFrame> {
    private boolean endStreamSent;
    private final ChunkedInput<ByteBuf> input;
    private final Http2FrameStream stream;

    public Http2DataChunkedInput(ChunkedInput<ByteBuf> chunkedInput, Http2FrameStream http2FrameStream) {
        this.input = (ChunkedInput) ObjectUtil.checkNotNull(chunkedInput, "input");
        this.stream = (Http2FrameStream) ObjectUtil.checkNotNull(http2FrameStream, "stream");
    }

    public void close() throws Exception {
        this.input.close();
    }

    public boolean isEndOfInput() throws Exception {
        if (this.input.isEndOfInput()) {
            return this.endStreamSent;
        }
        return false;
    }

    public long length() {
        return this.input.length();
    }

    public long progress() {
        return this.input.progress();
    }

    @Deprecated
    public Http2DataFrame readChunk(ChannelHandlerContext channelHandlerContext) throws Exception {
        return readChunk(channelHandlerContext.alloc());
    }

    public Http2DataFrame readChunk(ByteBufAllocator byteBufAllocator) throws Exception {
        if (this.endStreamSent) {
            return null;
        }
        if (this.input.isEndOfInput()) {
            this.endStreamSent = true;
            return new DefaultHttp2DataFrame(true).stream(this.stream);
        }
        ByteBuf readChunk = this.input.readChunk(byteBufAllocator);
        if (readChunk == null) {
            return null;
        }
        DefaultHttp2DataFrame stream2 = new DefaultHttp2DataFrame(readChunk, this.input.isEndOfInput()).stream(this.stream);
        if (stream2.isEndStream()) {
            this.endStreamSent = true;
        }
        return stream2;
    }
}
