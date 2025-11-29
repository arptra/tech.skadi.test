package io.netty.handler.codec.protobuf;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.CorruptedFrameException;
import java.util.List;

public class ProtobufVarint32FrameDecoder extends ByteToMessageDecoder {
    private static int readRawVarint32(ByteBuf byteBuf) {
        int i;
        if (!byteBuf.isReadable()) {
            return 0;
        }
        byteBuf.markReaderIndex();
        byte readByte = byteBuf.readByte();
        if (readByte >= 0) {
            return readByte;
        }
        byte b = readByte & Byte.MAX_VALUE;
        if (!byteBuf.isReadable()) {
            byteBuf.resetReaderIndex();
            return 0;
        }
        byte readByte2 = byteBuf.readByte();
        if (readByte2 >= 0) {
            i = readByte2 << 7;
        } else {
            b |= (readByte2 & Byte.MAX_VALUE) << 7;
            if (!byteBuf.isReadable()) {
                byteBuf.resetReaderIndex();
                return 0;
            }
            byte readByte3 = byteBuf.readByte();
            if (readByte3 >= 0) {
                i = readByte3 << 14;
            } else {
                b |= (readByte3 & Byte.MAX_VALUE) << 14;
                if (!byteBuf.isReadable()) {
                    byteBuf.resetReaderIndex();
                    return 0;
                }
                byte readByte4 = byteBuf.readByte();
                if (readByte4 >= 0) {
                    i = readByte4 << 21;
                } else {
                    byte b2 = b | ((readByte4 & Byte.MAX_VALUE) << 21);
                    if (!byteBuf.isReadable()) {
                        byteBuf.resetReaderIndex();
                        return 0;
                    }
                    byte readByte5 = byteBuf.readByte();
                    byte b3 = b2 | (readByte5 << 28);
                    if (readByte5 >= 0) {
                        return b3;
                    }
                    throw new CorruptedFrameException("malformed varint.");
                }
            }
        }
        return i | b;
    }

    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        byteBuf.markReaderIndex();
        int readerIndex = byteBuf.readerIndex();
        int readRawVarint32 = readRawVarint32(byteBuf);
        if (readerIndex != byteBuf.readerIndex()) {
            if (readRawVarint32 < 0) {
                throw new CorruptedFrameException("negative length: " + readRawVarint32);
            } else if (byteBuf.readableBytes() < readRawVarint32) {
                byteBuf.resetReaderIndex();
            } else {
                list.add(byteBuf.readRetainedSlice(readRawVarint32));
            }
        }
    }
}
