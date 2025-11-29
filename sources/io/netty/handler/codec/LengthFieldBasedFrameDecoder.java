package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;
import java.nio.ByteOrder;
import java.util.List;

public class LengthFieldBasedFrameDecoder extends ByteToMessageDecoder {
    private final ByteOrder byteOrder;
    private long bytesToDiscard;
    private boolean discardingTooLongFrame;
    private final boolean failFast;
    private int frameLengthInt;
    private final int initialBytesToStrip;
    private final int lengthAdjustment;
    private final int lengthFieldEndOffset;
    private final int lengthFieldLength;
    private final int lengthFieldOffset;
    private final int maxFrameLength;
    private long tooLongFrameLength;

    public LengthFieldBasedFrameDecoder(int i, int i2, int i3) {
        this(i, i2, i3, 0, 0);
    }

    private void discardingTooLongFrame(ByteBuf byteBuf) {
        long j = this.bytesToDiscard;
        int min = (int) Math.min(j, (long) byteBuf.readableBytes());
        byteBuf.skipBytes(min);
        this.bytesToDiscard = j - ((long) min);
        failIfNecessary(false);
    }

    private void exceededFrameLength(ByteBuf byteBuf, long j) {
        long readableBytes = j - ((long) byteBuf.readableBytes());
        this.tooLongFrameLength = j;
        if (readableBytes < 0) {
            byteBuf.skipBytes((int) j);
        } else {
            this.discardingTooLongFrame = true;
            this.bytesToDiscard = readableBytes;
            byteBuf.skipBytes(byteBuf.readableBytes());
        }
        failIfNecessary(true);
    }

    private void fail(long j) {
        if (j > 0) {
            throw new TooLongFrameException("Adjusted frame length exceeds " + this.maxFrameLength + ": " + j + " - discarded");
        }
        throw new TooLongFrameException("Adjusted frame length exceeds " + this.maxFrameLength + " - discarding");
    }

    private void failIfNecessary(boolean z) {
        if (this.bytesToDiscard == 0) {
            long j = this.tooLongFrameLength;
            this.tooLongFrameLength = 0;
            this.discardingTooLongFrame = false;
            if (!this.failFast || z) {
                fail(j);
            }
        } else if (this.failFast && z) {
            fail(this.tooLongFrameLength);
        }
    }

    private static void failOnFrameLengthLessThanInitialBytesToStrip(ByteBuf byteBuf, long j, int i) {
        byteBuf.skipBytes((int) j);
        throw new CorruptedFrameException("Adjusted frame length (" + j + ") is less than initialBytesToStrip: " + i);
    }

    private static void failOnFrameLengthLessThanLengthFieldEndOffset(ByteBuf byteBuf, long j, int i) {
        byteBuf.skipBytes(i);
        throw new CorruptedFrameException("Adjusted frame length (" + j + ") is less than lengthFieldEndOffset: " + i);
    }

    private static void failOnNegativeLengthField(ByteBuf byteBuf, long j, int i) {
        byteBuf.skipBytes(i);
        throw new CorruptedFrameException("negative pre-adjustment length field: " + j);
    }

    public final void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        Object decode = decode(channelHandlerContext, byteBuf);
        if (decode != null) {
            list.add(decode);
        }
    }

    public ByteBuf extractFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, int i, int i2) {
        return byteBuf.retainedSlice(i, i2);
    }

    public long getUnadjustedFrameLength(ByteBuf byteBuf, int i, int i2, ByteOrder byteOrder2) {
        int unsignedByte;
        ByteBuf order = byteBuf.order(byteOrder2);
        if (i2 == 1) {
            unsignedByte = order.getUnsignedByte(i);
        } else if (i2 == 2) {
            unsignedByte = order.getUnsignedShort(i);
        } else if (i2 == 3) {
            unsignedByte = order.getUnsignedMedium(i);
        } else if (i2 == 4) {
            return order.getUnsignedInt(i);
        } else {
            if (i2 == 8) {
                return order.getLong(i);
            }
            throw new DecoderException("unsupported lengthFieldLength: " + this.lengthFieldLength + " (expected: 1, 2, 3, 4, or 8)");
        }
        return (long) unsignedByte;
    }

    public LengthFieldBasedFrameDecoder(int i, int i2, int i3, int i4, int i5) {
        this(i, i2, i3, i4, i5, true);
    }

    public LengthFieldBasedFrameDecoder(int i, int i2, int i3, int i4, int i5, boolean z) {
        this(ByteOrder.BIG_ENDIAN, i, i2, i3, i4, i5, z);
    }

    public Object decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        long j = 0;
        if (this.frameLengthInt == -1) {
            if (this.discardingTooLongFrame) {
                discardingTooLongFrame(byteBuf);
            }
            if (byteBuf.readableBytes() < this.lengthFieldEndOffset) {
                return null;
            }
            long unadjustedFrameLength = getUnadjustedFrameLength(byteBuf, byteBuf.readerIndex() + this.lengthFieldOffset, this.lengthFieldLength, this.byteOrder);
            if (unadjustedFrameLength < 0) {
                failOnNegativeLengthField(byteBuf, unadjustedFrameLength, this.lengthFieldEndOffset);
            }
            int i = this.lengthAdjustment;
            int i2 = this.lengthFieldEndOffset;
            long j2 = unadjustedFrameLength + ((long) (i + i2));
            if (j2 < ((long) i2)) {
                failOnFrameLengthLessThanLengthFieldEndOffset(byteBuf, j2, i2);
            }
            if (j2 > ((long) this.maxFrameLength)) {
                exceededFrameLength(byteBuf, j2);
                return null;
            }
            this.frameLengthInt = (int) j2;
            j = j2;
        }
        int readableBytes = byteBuf.readableBytes();
        int i3 = this.frameLengthInt;
        if (readableBytes < i3) {
            return null;
        }
        int i4 = this.initialBytesToStrip;
        if (i4 > i3) {
            failOnFrameLengthLessThanInitialBytesToStrip(byteBuf, j, i4);
        }
        byteBuf.skipBytes(this.initialBytesToStrip);
        int readerIndex = byteBuf.readerIndex();
        int i5 = this.frameLengthInt - this.initialBytesToStrip;
        ByteBuf extractFrame = extractFrame(channelHandlerContext, byteBuf, readerIndex, i5);
        byteBuf.readerIndex(readerIndex + i5);
        this.frameLengthInt = -1;
        return extractFrame;
    }

    public LengthFieldBasedFrameDecoder(ByteOrder byteOrder2, int i, int i2, int i3, int i4, int i5, boolean z) {
        this.frameLengthInt = -1;
        this.byteOrder = (ByteOrder) ObjectUtil.checkNotNull(byteOrder2, "byteOrder");
        ObjectUtil.checkPositive(i, "maxFrameLength");
        ObjectUtil.checkPositiveOrZero(i2, "lengthFieldOffset");
        ObjectUtil.checkPositiveOrZero(i5, "initialBytesToStrip");
        if (i2 <= i - i3) {
            this.maxFrameLength = i;
            this.lengthFieldOffset = i2;
            this.lengthFieldLength = i3;
            this.lengthAdjustment = i4;
            this.lengthFieldEndOffset = i2 + i3;
            this.initialBytesToStrip = i5;
            this.failFast = z;
            return;
        }
        throw new IllegalArgumentException("maxFrameLength (" + i + ") must be equal to or greater than lengthFieldOffset (" + i2 + ") + lengthFieldLength (" + i3 + ").");
    }
}
