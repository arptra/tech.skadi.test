package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;
import java.nio.ByteOrder;
import java.util.List;

@ChannelHandler.Sharable
public class LengthFieldPrepender extends MessageToMessageEncoder<ByteBuf> {
    private final ByteOrder byteOrder;
    private final int lengthAdjustment;
    private final int lengthFieldLength;
    private final boolean lengthIncludesLengthFieldLength;

    public LengthFieldPrepender(int i) {
        this(i, false);
    }

    public LengthFieldPrepender(int i, boolean z) {
        this(i, 0, z);
    }

    public void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        int readableBytes = byteBuf.readableBytes() + this.lengthAdjustment;
        if (this.lengthIncludesLengthFieldLength) {
            readableBytes += this.lengthFieldLength;
        }
        ObjectUtil.checkPositiveOrZero(readableBytes, "length");
        int i = this.lengthFieldLength;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        list.add(channelHandlerContext.alloc().buffer(4).order(this.byteOrder).writeInt(readableBytes));
                    } else if (i == 8) {
                        list.add(channelHandlerContext.alloc().buffer(8).order(this.byteOrder).writeLong((long) readableBytes));
                    } else {
                        throw new Error("should not reach here");
                    }
                } else if (readableBytes < 16777216) {
                    list.add(channelHandlerContext.alloc().buffer(3).order(this.byteOrder).writeMedium(readableBytes));
                } else {
                    throw new IllegalArgumentException("length does not fit into a medium integer: " + readableBytes);
                }
            } else if (readableBytes < 65536) {
                list.add(channelHandlerContext.alloc().buffer(2).order(this.byteOrder).writeShort((short) readableBytes));
            } else {
                throw new IllegalArgumentException("length does not fit into a short integer: " + readableBytes);
            }
        } else if (readableBytes < 256) {
            list.add(channelHandlerContext.alloc().buffer(1).order(this.byteOrder).writeByte((byte) readableBytes));
        } else {
            throw new IllegalArgumentException("length does not fit into a byte: " + readableBytes);
        }
        list.add(byteBuf.retain());
    }

    public LengthFieldPrepender(int i, int i2) {
        this(i, i2, false);
    }

    public LengthFieldPrepender(int i, int i2, boolean z) {
        this(ByteOrder.BIG_ENDIAN, i, i2, z);
    }

    public LengthFieldPrepender(ByteOrder byteOrder2, int i, int i2, boolean z) {
        if (i == 1 || i == 2 || i == 3 || i == 4 || i == 8) {
            this.byteOrder = (ByteOrder) ObjectUtil.checkNotNull(byteOrder2, "byteOrder");
            this.lengthFieldLength = i;
            this.lengthIncludesLengthFieldLength = z;
            this.lengthAdjustment = i2;
            return;
        }
        throw new IllegalArgumentException("lengthFieldLength must be either 1, 2, 3, 4, or 8: " + i);
    }
}
