package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.stream.ChunkedInput;

public class HttpChunkedInput implements ChunkedInput<HttpContent> {
    private final ChunkedInput<ByteBuf> input;
    private final LastHttpContent lastHttpContent;
    private boolean sentLastChunk;

    public HttpChunkedInput(ChunkedInput<ByteBuf> chunkedInput) {
        this.input = chunkedInput;
        this.lastHttpContent = LastHttpContent.EMPTY_LAST_CONTENT;
    }

    public void close() throws Exception {
        this.input.close();
    }

    public boolean isEndOfInput() throws Exception {
        if (this.input.isEndOfInput()) {
            return this.sentLastChunk;
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
    public HttpContent readChunk(ChannelHandlerContext channelHandlerContext) throws Exception {
        return readChunk(channelHandlerContext.alloc());
    }

    public HttpChunkedInput(ChunkedInput<ByteBuf> chunkedInput, LastHttpContent lastHttpContent2) {
        this.input = chunkedInput;
        this.lastHttpContent = lastHttpContent2;
    }

    public HttpContent readChunk(ByteBufAllocator byteBufAllocator) throws Exception {
        if (!this.input.isEndOfInput()) {
            ByteBuf readChunk = this.input.readChunk(byteBufAllocator);
            if (readChunk == null) {
                return null;
            }
            return new DefaultHttpContent(readChunk);
        } else if (this.sentLastChunk) {
            return null;
        } else {
            this.sentLastChunk = true;
            return this.lastHttpContent;
        }
    }
}
