package io.netty.channel.unix;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

public abstract class SocketWritableByteChannel implements WritableByteChannel {
    protected final FileDescriptor fd;

    public SocketWritableByteChannel(FileDescriptor fileDescriptor) {
        this.fd = (FileDescriptor) ObjectUtil.checkNotNull(fileDescriptor, "fd");
    }

    public abstract ByteBufAllocator alloc();

    public final void close() throws IOException {
        this.fd.close();
    }

    public final boolean isOpen() {
        return this.fd.isOpen();
    }

    public int write(ByteBuffer byteBuffer, int i, int i2) throws IOException {
        return this.fd.write(byteBuffer, i, i2);
    }

    public final int write(ByteBuffer byteBuffer) throws IOException {
        int i;
        ByteBuf byteBuf;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        if (byteBuffer.isDirect()) {
            i = write(byteBuffer, position, byteBuffer.limit());
        } else {
            int i2 = limit - position;
            ReferenceCounted referenceCounted = null;
            if (i2 == 0) {
                try {
                    byteBuf = Unpooled.EMPTY_BUFFER;
                } catch (Throwable th) {
                    if (referenceCounted != null) {
                        referenceCounted.release();
                    }
                    throw th;
                }
            } else {
                ByteBufAllocator alloc = alloc();
                if (alloc.isDirectBufferPooled()) {
                    byteBuf = alloc.directBuffer(i2);
                } else {
                    byteBuf = ByteBufUtil.threadLocalDirectBuffer();
                    if (byteBuf == null) {
                        byteBuf = Unpooled.directBuffer(i2);
                    }
                }
            }
            byteBuf.writeBytes(byteBuffer.duplicate());
            ByteBuffer internalNioBuffer = byteBuf.internalNioBuffer(byteBuf.readerIndex(), i2);
            i = write(internalNioBuffer, internalNioBuffer.position(), internalNioBuffer.limit());
            byteBuf.release();
        }
        if (i > 0) {
            byteBuffer.position(position + i);
        }
        return i;
    }
}
