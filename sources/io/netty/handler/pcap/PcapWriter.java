package io.netty.handler.pcap;

import io.netty.buffer.ByteBuf;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;

final class PcapWriter implements Closeable {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) PcapWriter.class);
    private boolean isClosed;
    private final OutputStream outputStream;

    public PcapWriter(OutputStream outputStream2) {
        this.outputStream = outputStream2;
    }

    public void close() throws IOException {
        if (this.isClosed) {
            logger.debug("PcapWriter is already closed");
            return;
        }
        this.isClosed = true;
        this.outputStream.flush();
        this.outputStream.close();
        logger.debug("PcapWriter is now closed");
    }

    public void writePacket(ByteBuf byteBuf, ByteBuf byteBuf2) throws IOException {
        if (this.isClosed) {
            logger.debug("Pcap Write attempted on closed PcapWriter");
        }
        long currentTimeMillis = System.currentTimeMillis();
        PcapHeaders.writePacketHeader(byteBuf, (int) (currentTimeMillis / 1000), (int) ((currentTimeMillis % 1000) * 1000), byteBuf2.readableBytes(), byteBuf2.readableBytes());
        byteBuf.readBytes(this.outputStream, byteBuf.readableBytes());
        byteBuf2.readBytes(this.outputStream, byteBuf2.readableBytes());
    }

    public PcapWriter(OutputStream outputStream2, ByteBuf byteBuf) throws IOException {
        this.outputStream = outputStream2;
        PcapHeaders.writeGlobalHeader(byteBuf);
        byteBuf.readBytes(outputStream2, byteBuf.readableBytes());
    }
}
