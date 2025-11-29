package io.netty.handler.codec.haproxy;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.ProtocolDetectionResult;
import io.netty.util.CharsetUtil;
import java.util.List;

public class HAProxyMessageDecoder extends ByteToMessageDecoder {
    private static final int BINARY_PREFIX_LENGTH = HAProxyConstants.BINARY_PREFIX.length;
    private static final ProtocolDetectionResult<HAProxyProtocolVersion> DETECTION_RESULT_V1 = ProtocolDetectionResult.detected(HAProxyProtocolVersion.V1);
    private static final ProtocolDetectionResult<HAProxyProtocolVersion> DETECTION_RESULT_V2 = ProtocolDetectionResult.detected(HAProxyProtocolVersion.V2);
    private static final int V1_MAX_LENGTH = 108;
    private static final int V2_MAX_LENGTH = 65551;
    private static final int V2_MAX_TLV = 65319;
    private static final int V2_MIN_LENGTH = 232;
    /* access modifiers changed from: private */
    public int discardedBytes;
    /* access modifiers changed from: private */
    public boolean discarding;
    /* access modifiers changed from: private */
    public final boolean failFast;
    private boolean finished;
    private HeaderExtractor headerExtractor;
    private final int v2MaxHeaderSize;
    private int version;

    public abstract class HeaderExtractor {
        private final int maxHeaderSize;

        public HeaderExtractor(int i) {
            this.maxHeaderSize = i;
        }

        public abstract int delimiterLength(ByteBuf byteBuf, int i);

        public ByteBuf extract(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
            int findEndOfHeader = findEndOfHeader(byteBuf);
            if (HAProxyMessageDecoder.this.discarding) {
                if (findEndOfHeader >= 0) {
                    int access$200 = (HAProxyMessageDecoder.this.discardedBytes + findEndOfHeader) - byteBuf.readerIndex();
                    byteBuf.readerIndex(findEndOfHeader + delimiterLength(byteBuf, findEndOfHeader));
                    int unused = HAProxyMessageDecoder.this.discardedBytes = 0;
                    boolean unused2 = HAProxyMessageDecoder.this.discarding = false;
                    if (!HAProxyMessageDecoder.this.failFast) {
                        HAProxyMessageDecoder hAProxyMessageDecoder = HAProxyMessageDecoder.this;
                        hAProxyMessageDecoder.failOverLimit(channelHandlerContext, "over " + access$200);
                    }
                } else {
                    HAProxyMessageDecoder hAProxyMessageDecoder2 = HAProxyMessageDecoder.this;
                    int unused3 = hAProxyMessageDecoder2.discardedBytes = hAProxyMessageDecoder2.discardedBytes + byteBuf.readableBytes();
                    byteBuf.skipBytes(byteBuf.readableBytes());
                }
                return null;
            } else if (findEndOfHeader >= 0) {
                int readerIndex = findEndOfHeader - byteBuf.readerIndex();
                if (readerIndex > this.maxHeaderSize) {
                    byteBuf.readerIndex(findEndOfHeader + delimiterLength(byteBuf, findEndOfHeader));
                    HAProxyMessageDecoder.this.failOverLimit(channelHandlerContext, readerIndex);
                    return null;
                }
                ByteBuf readSlice = byteBuf.readSlice(readerIndex);
                byteBuf.skipBytes(delimiterLength(byteBuf, findEndOfHeader));
                return readSlice;
            } else {
                int readableBytes = byteBuf.readableBytes();
                if (readableBytes > this.maxHeaderSize) {
                    int unused4 = HAProxyMessageDecoder.this.discardedBytes = readableBytes;
                    byteBuf.skipBytes(readableBytes);
                    boolean unused5 = HAProxyMessageDecoder.this.discarding = true;
                    if (HAProxyMessageDecoder.this.failFast) {
                        HAProxyMessageDecoder hAProxyMessageDecoder3 = HAProxyMessageDecoder.this;
                        hAProxyMessageDecoder3.failOverLimit(channelHandlerContext, "over " + HAProxyMessageDecoder.this.discardedBytes);
                    }
                }
                return null;
            }
        }

        public abstract int findEndOfHeader(ByteBuf byteBuf);
    }

    public final class LineHeaderExtractor extends HeaderExtractor {
        public LineHeaderExtractor(int i) {
            super(i);
        }

        public int delimiterLength(ByteBuf byteBuf, int i) {
            return byteBuf.getByte(i) == 13 ? 2 : 1;
        }

        public int findEndOfHeader(ByteBuf byteBuf) {
            return HAProxyMessageDecoder.findEndOfLine(byteBuf);
        }
    }

    public final class StructHeaderExtractor extends HeaderExtractor {
        public StructHeaderExtractor(int i) {
            super(i);
        }

        public int delimiterLength(ByteBuf byteBuf, int i) {
            return 0;
        }

        public int findEndOfHeader(ByteBuf byteBuf) {
            return HAProxyMessageDecoder.findEndOfHeader(byteBuf);
        }
    }

    public HAProxyMessageDecoder() {
        this(true);
    }

    private ByteBuf decodeLine(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        if (this.headerExtractor == null) {
            this.headerExtractor = new LineHeaderExtractor(108);
        }
        return this.headerExtractor.extract(channelHandlerContext, byteBuf);
    }

    private ByteBuf decodeStruct(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        if (this.headerExtractor == null) {
            this.headerExtractor = new StructHeaderExtractor(this.v2MaxHeaderSize);
        }
        return this.headerExtractor.extract(channelHandlerContext, byteBuf);
    }

    public static ProtocolDetectionResult<HAProxyProtocolVersion> detectProtocol(ByteBuf byteBuf) {
        if (byteBuf.readableBytes() < 12) {
            return ProtocolDetectionResult.needsMoreData();
        }
        int readerIndex = byteBuf.readerIndex();
        return match(HAProxyConstants.BINARY_PREFIX, byteBuf, readerIndex) ? DETECTION_RESULT_V2 : match(HAProxyConstants.TEXT_PREFIX, byteBuf, readerIndex) ? DETECTION_RESULT_V1 : ProtocolDetectionResult.invalid();
    }

    private void fail(ChannelHandlerContext channelHandlerContext, String str, Exception exc) {
        this.finished = true;
        channelHandlerContext.close();
        throw ((str == null || exc == null) ? str == null ? exc != null ? new HAProxyProtocolException((Throwable) exc) : new HAProxyProtocolException() : new HAProxyProtocolException(str) : new HAProxyProtocolException(str, exc));
    }

    /* access modifiers changed from: private */
    public void failOverLimit(ChannelHandlerContext channelHandlerContext, int i) {
        failOverLimit(channelHandlerContext, String.valueOf(i));
    }

    /* access modifiers changed from: private */
    public static int findEndOfHeader(ByteBuf byteBuf) {
        int unsignedShort;
        int readableBytes = byteBuf.readableBytes();
        if (readableBytes >= 16 && readableBytes >= (unsignedShort = byteBuf.getUnsignedShort(byteBuf.readerIndex() + 14) + 16)) {
            return unsignedShort;
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public static int findEndOfLine(ByteBuf byteBuf) {
        int writerIndex = byteBuf.writerIndex();
        for (int readerIndex = byteBuf.readerIndex(); readerIndex < writerIndex; readerIndex++) {
            if (byteBuf.getByte(readerIndex) == 13 && readerIndex < writerIndex - 1 && byteBuf.getByte(readerIndex + 1) == 10) {
                return readerIndex;
            }
        }
        return -1;
    }

    private static int findVersion(ByteBuf byteBuf) {
        if (byteBuf.readableBytes() < 13) {
            return -1;
        }
        int readerIndex = byteBuf.readerIndex();
        if (match(HAProxyConstants.BINARY_PREFIX, byteBuf, readerIndex)) {
            return byteBuf.getByte(readerIndex + BINARY_PREFIX_LENGTH);
        }
        return 1;
    }

    private static boolean match(byte[] bArr, ByteBuf byteBuf, int i) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (byteBuf.getByte(i + i2) != bArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        super.channelRead(channelHandlerContext, obj);
        if (this.finished) {
            channelHandlerContext.pipeline().remove((ChannelHandler) this);
        }
    }

    public final void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        if (this.version == -1) {
            int findVersion = findVersion(byteBuf);
            this.version = findVersion;
            if (findVersion == -1) {
                return;
            }
        }
        ByteBuf decodeLine = this.version == 1 ? decodeLine(channelHandlerContext, byteBuf) : decodeStruct(channelHandlerContext, byteBuf);
        if (decodeLine != null) {
            this.finished = true;
            try {
                if (this.version == 1) {
                    list.add(HAProxyMessage.decodeHeader(decodeLine.toString(CharsetUtil.US_ASCII)));
                } else {
                    list.add(HAProxyMessage.decodeHeader(decodeLine));
                }
            } catch (HAProxyProtocolException e) {
                fail(channelHandlerContext, (String) null, e);
            }
        }
    }

    public boolean isSingleDecode() {
        return true;
    }

    public HAProxyMessageDecoder(boolean z) {
        this.version = -1;
        this.v2MaxHeaderSize = V2_MAX_LENGTH;
        this.failFast = z;
    }

    /* access modifiers changed from: private */
    public void failOverLimit(ChannelHandlerContext channelHandlerContext, String str) {
        int i = this.version == 1 ? 108 : this.v2MaxHeaderSize;
        fail(channelHandlerContext, "header length (" + str + ") exceeds the allowed maximum (" + i + ')', (Exception) null);
    }

    public HAProxyMessageDecoder(int i) {
        this(i, true);
    }

    public HAProxyMessageDecoder(int i, boolean z) {
        this.version = -1;
        if (i < 1) {
            this.v2MaxHeaderSize = V2_MIN_LENGTH;
        } else if (i > V2_MAX_TLV) {
            this.v2MaxHeaderSize = V2_MAX_LENGTH;
        } else {
            int i2 = i + V2_MIN_LENGTH;
            if (i2 > V2_MAX_LENGTH) {
                this.v2MaxHeaderSize = V2_MAX_LENGTH;
            } else {
                this.v2MaxHeaderSize = i2;
            }
        }
        this.failFast = z;
    }
}
