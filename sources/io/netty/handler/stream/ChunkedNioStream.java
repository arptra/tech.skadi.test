package io.netty.handler.stream;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;

public class ChunkedNioStream implements ChunkedInput<ByteBuf> {
    private final ByteBuffer byteBuffer;
    private final int chunkSize;
    private final ReadableByteChannel in;
    private long offset;

    public ChunkedNioStream(ReadableByteChannel readableByteChannel) {
        this(readableByteChannel, 8192);
    }

    public void close() throws Exception {
        this.in.close();
    }

    public boolean isEndOfInput() throws Exception {
        int read;
        if (this.byteBuffer.position() > 0) {
            return false;
        }
        if (!this.in.isOpen() || (read = this.in.read(this.byteBuffer)) < 0) {
            return true;
        }
        this.offset += (long) read;
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

    public ChunkedNioStream(ReadableByteChannel readableByteChannel, int i) {
        this.in = (ReadableByteChannel) ObjectUtil.checkNotNull(readableByteChannel, "in");
        this.chunkSize = ObjectUtil.checkPositive(i, "chunkSize");
        this.byteBuffer = ByteBuffer.allocate(i);
    }

    @Deprecated
    public ByteBuf readChunk(ChannelHandlerContext channelHandlerContext) throws Exception {
        return readChunk(channelHandlerContext.alloc());
    }

    public ByteBuf readChunk(ByteBufAllocator byteBufAllocator) throws Exception {
        if (isEndOfInput()) {
            return null;
        }
        int position = this.byteBuffer.position();
        do {
            int read = this.in.read(this.byteBuffer);
            if (read < 0) {
                break;
            }
            position += read;
            this.offset += (long) read;
        } while (position != this.chunkSize);
        this.byteBuffer.flip();
        ByteBuf buffer = byteBufAllocator.buffer(this.byteBuffer.remaining());
        try {
            buffer.writeBytes(this.byteBuffer);
            this.byteBuffer.clear();
            return buffer;
        } catch (Throwable th) {
            buffer.release();
            throw th;
        }
    }
}
