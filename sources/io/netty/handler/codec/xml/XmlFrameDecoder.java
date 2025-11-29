package io.netty.handler.codec.xml;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.CorruptedFrameException;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

public class XmlFrameDecoder extends ByteToMessageDecoder {
    private final int maxFrameLength;

    public XmlFrameDecoder(int i) {
        this.maxFrameLength = ObjectUtil.checkPositive(i, "maxFrameLength");
    }

    private static ByteBuf extractFrame(ByteBuf byteBuf, int i, int i2) {
        return byteBuf.copy(i, i2);
    }

    private void fail(long j) {
        if (j > 0) {
            throw new TooLongFrameException("frame length exceeds " + this.maxFrameLength + ": " + j + " - discarded");
        }
        throw new TooLongFrameException("frame length exceeds " + this.maxFrameLength + " - discarding");
    }

    private static boolean isCDATABlockStart(ByteBuf byteBuf, int i) {
        return i < byteBuf.writerIndex() + -8 && byteBuf.getByte(i + 2) == 91 && byteBuf.getByte(i + 3) == 67 && byteBuf.getByte(i + 4) == 68 && byteBuf.getByte(i + 5) == 65 && byteBuf.getByte(i + 6) == 84 && byteBuf.getByte(i + 7) == 65 && byteBuf.getByte(i + 8) == 91;
    }

    private static boolean isCommentBlockStart(ByteBuf byteBuf, int i) {
        return i < byteBuf.writerIndex() + -3 && byteBuf.getByte(i + 2) == 45 && byteBuf.getByte(i + 3) == 45;
    }

    private static boolean isValidStartCharForXmlElement(byte b) {
        return (b >= 97 && b <= 122) || (b >= 65 && b <= 90) || b == 58 || b == 95;
    }

    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        int i;
        int i2;
        ByteBuf byteBuf2 = byteBuf;
        int writerIndex = byteBuf.writerIndex();
        if (writerIndex > this.maxFrameLength) {
            byteBuf2.skipBytes(byteBuf.readableBytes());
            fail((long) writerIndex);
            return;
        }
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        long j = 0;
        int i4 = 0;
        boolean z3 = false;
        for (int readerIndex = byteBuf.readerIndex(); readerIndex < writerIndex; readerIndex++) {
            byte b = byteBuf2.getByte(readerIndex);
            if (!z && Character.isWhitespace(b)) {
                i3++;
            } else if (z || b == 60) {
                if (!z2 && b == 60) {
                    int i5 = writerIndex - 1;
                    z = true;
                    if (readerIndex < i5) {
                        byte b2 = byteBuf2.getByte(readerIndex + 1);
                        if (b2 == 47) {
                            int i6 = readerIndex + 2;
                            while (true) {
                                if (i6 > i5) {
                                    break;
                                } else if (byteBuf2.getByte(i6) == 62) {
                                    break;
                                } else {
                                    i6++;
                                }
                            }
                        } else if (isValidStartCharForXmlElement(b2)) {
                            j++;
                            z3 = true;
                        } else {
                            if (b2 == 33) {
                                if (!isCommentBlockStart(byteBuf2, readerIndex)) {
                                    if (isCDATABlockStart(byteBuf2, readerIndex)) {
                                        j++;
                                        z2 = true;
                                    }
                                }
                            } else if (b2 != 63) {
                            }
                            j++;
                        }
                    }
                } else if (z2 || b != 47) {
                    if (b == 62) {
                        i4 = readerIndex + 1;
                        int i7 = readerIndex - 1;
                        if (i7 > -1) {
                            byte b3 = byteBuf2.getByte(i7);
                            if (!z2) {
                                if (b3 == 63 || (b3 == 45 && readerIndex - 2 > -1 && byteBuf2.getByte(i2) == 45)) {
                                    j--;
                                }
                            } else if (b3 == 93 && readerIndex - 2 > -1 && byteBuf2.getByte(i) == 93) {
                                j--;
                                z2 = false;
                            }
                        }
                        if (z3 && j == 0) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else if (readerIndex < writerIndex - 1) {
                    if (byteBuf2.getByte(readerIndex + 1) != 62) {
                    }
                }
                j--;
            } else {
                fail(channelHandlerContext);
                byteBuf2.skipBytes(byteBuf.readableBytes());
                return;
            }
        }
        int readerIndex2 = byteBuf.readerIndex();
        int i8 = i4 - readerIndex2;
        if (j == 0 && i8 > 0) {
            if (readerIndex2 + i8 >= writerIndex) {
                i8 = byteBuf.readableBytes();
            }
            ByteBuf extractFrame = extractFrame(byteBuf2, readerIndex2 + i3, i8 - i3);
            byteBuf2.skipBytes(i8);
            list.add(extractFrame);
        }
    }

    private static void fail(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.fireExceptionCaught(new CorruptedFrameException("frame contains content before the xml starts"));
    }
}
