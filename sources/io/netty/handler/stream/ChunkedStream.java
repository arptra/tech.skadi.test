package io.netty.handler.stream;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;
import java.io.InputStream;
import java.io.PushbackInputStream;

public class ChunkedStream implements ChunkedInput<ByteBuf> {
    static final int DEFAULT_CHUNK_SIZE = 8192;
    private final int chunkSize;
    private boolean closed;
    private final PushbackInputStream in;
    private long offset;

    public ChunkedStream(InputStream inputStream) {
        this(inputStream, 8192);
    }

    public void close() throws Exception {
        this.closed = true;
        this.in.close();
    }

    public boolean isEndOfInput() throws Exception {
        if (this.closed) {
            return true;
        }
        if (this.in.available() > 0) {
            return false;
        }
        int read = this.in.read();
        if (read < 0) {
            return true;
        }
        this.in.unread(read);
        return false;
    }

    public long length() {
        return -1;
    }

    public long progress() {
        return this.offset;
    }

    public long transferredBytes() {
        return this.offset;
    }

    public ChunkedStream(InputStream inputStream, int i) {
        ObjectUtil.checkNotNull(inputStream, "in");
        ObjectUtil.checkPositive(i, "chunkSize");
        if (inputStream instanceof PushbackInputStream) {
            this.in = (PushbackInputStream) inputStream;
        } else {
            this.in = new PushbackInputStream(inputStream);
        }
        this.chunkSize = i;
    }

    @Deprecated
    public ByteBuf readChunk(ChannelHandlerContext channelHandlerContext) throws Exception {
        return readChunk(channelHandlerContext.alloc());
    }

    public ByteBuf readChunk(ByteBufAllocator byteBufAllocator) throws Exception {
        int i;
        if (isEndOfInput()) {
            return null;
        }
        if (this.in.available() <= 0) {
            i = this.chunkSize;
        } else {
            i = Math.min(this.chunkSize, this.in.available());
        }
        ByteBuf buffer = byteBufAllocator.buffer(i);
        try {
            int writeBytes = buffer.writeBytes((InputStream) this.in, i);
            if (writeBytes < 0) {
                return null;
            }
            this.offset += (long) writeBytes;
            return buffer;
        } finally {
            buffer.release();
        }
    }
}
