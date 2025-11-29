package io.netty.handler.codec.http2;

import com.here.posclient.UpdateOptions;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http2.Http2FrameReader;
import io.netty.handler.codec.http2.Http2HeadersDecoder;

public class DefaultHttp2FrameReader implements Http2FrameReader, Http2FrameSizePolicy, Http2FrameReader.Configuration {
    private Http2Flags flags;
    private byte frameType;
    /* access modifiers changed from: private */
    public HeadersContinuation headersContinuation;
    /* access modifiers changed from: private */
    public final Http2HeadersDecoder headersDecoder;
    private int maxFrameSize;
    private int payloadLength;
    private boolean readError;
    private boolean readingHeaders;
    /* access modifiers changed from: private */
    public int streamId;

    public class HeadersBlockBuilder {
        private ByteBuf headerBlock;

        public HeadersBlockBuilder() {
        }

        private void headerSizeExceeded() throws Http2Exception {
            close();
            Http2CodecUtil.headerListSizeExceeded(DefaultHttp2FrameReader.this.headersDecoder.configuration().maxHeaderListSizeGoAway());
        }

        public final void addFragment(ByteBuf byteBuf, int i, ByteBufAllocator byteBufAllocator, boolean z) throws Http2Exception {
            if (this.headerBlock == null) {
                if (((long) i) > DefaultHttp2FrameReader.this.headersDecoder.configuration().maxHeaderListSizeGoAway()) {
                    headerSizeExceeded();
                }
                if (z) {
                    this.headerBlock = byteBuf.readRetainedSlice(i);
                } else {
                    this.headerBlock = byteBufAllocator.buffer(i).writeBytes(byteBuf, i);
                }
            } else {
                if (DefaultHttp2FrameReader.this.headersDecoder.configuration().maxHeaderListSizeGoAway() - ((long) i) < ((long) this.headerBlock.readableBytes())) {
                    headerSizeExceeded();
                }
                if (this.headerBlock.isWritable(i)) {
                    this.headerBlock.writeBytes(byteBuf, i);
                    return;
                }
                ByteBuf buffer = byteBufAllocator.buffer(this.headerBlock.readableBytes() + i);
                buffer.writeBytes(this.headerBlock).writeBytes(byteBuf, i);
                this.headerBlock.release();
                this.headerBlock = buffer;
            }
        }

        public void close() {
            ByteBuf byteBuf = this.headerBlock;
            if (byteBuf != null) {
                byteBuf.release();
                this.headerBlock = null;
            }
            HeadersContinuation unused = DefaultHttp2FrameReader.this.headersContinuation = null;
        }

        public Http2Headers headers() throws Http2Exception {
            try {
                return DefaultHttp2FrameReader.this.headersDecoder.decodeHeaders(DefaultHttp2FrameReader.this.streamId, this.headerBlock);
            } finally {
                close();
            }
        }
    }

    public abstract class HeadersContinuation {
        private final HeadersBlockBuilder builder;

        private HeadersContinuation() {
            this.builder = new HeadersBlockBuilder();
        }

        public final void close() {
            this.builder.close();
        }

        public abstract int getStreamId();

        public final HeadersBlockBuilder headersBlockBuilder() {
            return this.builder;
        }

        public abstract void processFragment(boolean z, ByteBuf byteBuf, int i, Http2FrameListener http2FrameListener) throws Http2Exception;
    }

    public DefaultHttp2FrameReader() {
        this(true);
    }

    private void closeHeadersContinuation() {
        HeadersContinuation headersContinuation2 = this.headersContinuation;
        if (headersContinuation2 != null) {
            headersContinuation2.close();
            this.headersContinuation = null;
        }
    }

    private static int lengthWithoutTrailingPadding(int i, int i2) {
        return i2 == 0 ? i : i - (i2 - 1);
    }

    private void processHeaderState(ByteBuf byteBuf) throws Http2Exception {
        if (byteBuf.readableBytes() >= 9) {
            int readUnsignedMedium = byteBuf.readUnsignedMedium();
            this.payloadLength = readUnsignedMedium;
            if (readUnsignedMedium <= this.maxFrameSize) {
                this.frameType = byteBuf.readByte();
                this.flags = new Http2Flags(byteBuf.readUnsignedByte());
                this.streamId = Http2CodecUtil.readUnsignedInt(byteBuf);
                this.readingHeaders = false;
                switch (this.frameType) {
                    case 0:
                        verifyDataFrame();
                        return;
                    case 1:
                        verifyHeadersFrame();
                        return;
                    case 2:
                        verifyPriorityFrame();
                        return;
                    case 3:
                        verifyRstStreamFrame();
                        return;
                    case 4:
                        verifySettingsFrame();
                        return;
                    case 5:
                        verifyPushPromiseFrame();
                        return;
                    case 6:
                        verifyPingFrame();
                        return;
                    case 7:
                        verifyGoAwayFrame();
                        return;
                    case 8:
                        verifyWindowUpdateFrame();
                        return;
                    case 9:
                        verifyContinuationFrame();
                        return;
                    default:
                        verifyUnknownFrame();
                        return;
                }
            } else {
                throw Http2Exception.connectionError(Http2Error.FRAME_SIZE_ERROR, "Frame length: %d exceeds maximum: %d", Integer.valueOf(readUnsignedMedium), Integer.valueOf(this.maxFrameSize));
            }
        }
    }

    private void processPayloadState(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, Http2FrameListener http2FrameListener) throws Http2Exception {
        if (byteBuf.readableBytes() >= this.payloadLength) {
            int readerIndex = byteBuf.readerIndex() + this.payloadLength;
            this.readingHeaders = true;
            switch (this.frameType) {
                case 0:
                    readDataFrame(channelHandlerContext, byteBuf, readerIndex, http2FrameListener);
                    break;
                case 1:
                    readHeadersFrame(channelHandlerContext, byteBuf, readerIndex, http2FrameListener);
                    break;
                case 2:
                    readPriorityFrame(channelHandlerContext, byteBuf, http2FrameListener);
                    break;
                case 3:
                    readRstStreamFrame(channelHandlerContext, byteBuf, http2FrameListener);
                    break;
                case 4:
                    readSettingsFrame(channelHandlerContext, byteBuf, http2FrameListener);
                    break;
                case 5:
                    readPushPromiseFrame(channelHandlerContext, byteBuf, readerIndex, http2FrameListener);
                    break;
                case 6:
                    readPingFrame(channelHandlerContext, byteBuf.readLong(), http2FrameListener);
                    break;
                case 7:
                    readGoAwayFrame(channelHandlerContext, byteBuf, readerIndex, http2FrameListener);
                    break;
                case 8:
                    readWindowUpdateFrame(channelHandlerContext, byteBuf, http2FrameListener);
                    break;
                case 9:
                    readContinuationFrame(byteBuf, readerIndex, http2FrameListener);
                    break;
                default:
                    readUnknownFrame(channelHandlerContext, byteBuf, readerIndex, http2FrameListener);
                    break;
            }
            byteBuf.readerIndex(readerIndex);
        }
    }

    private void readContinuationFrame(ByteBuf byteBuf, int i, Http2FrameListener http2FrameListener) throws Http2Exception {
        this.headersContinuation.processFragment(this.flags.endOfHeaders(), byteBuf, i - byteBuf.readerIndex(), http2FrameListener);
        resetHeadersContinuationIfEnd(this.flags.endOfHeaders());
    }

    private void readDataFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, int i, Http2FrameListener http2FrameListener) throws Http2Exception {
        int readPadding = readPadding(byteBuf);
        verifyPadding(readPadding);
        Http2FrameListener http2FrameListener2 = http2FrameListener;
        ChannelHandlerContext channelHandlerContext2 = channelHandlerContext;
        http2FrameListener2.onDataRead(channelHandlerContext2, this.streamId, byteBuf.readSlice(lengthWithoutTrailingPadding(i - byteBuf.readerIndex(), readPadding)), readPadding, this.flags.endOfStream());
    }

    private static void readGoAwayFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, int i, Http2FrameListener http2FrameListener) throws Http2Exception {
        http2FrameListener.onGoAwayRead(channelHandlerContext, Http2CodecUtil.readUnsignedInt(byteBuf), byteBuf.readUnsignedInt(), byteBuf.readSlice(i - byteBuf.readerIndex()));
    }

    private void readHeadersFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, int i, Http2FrameListener http2FrameListener) throws Http2Exception {
        final int i2 = this.streamId;
        final Http2Flags http2Flags = this.flags;
        final int readPadding = readPadding(byteBuf);
        verifyPadding(readPadding);
        if (this.flags.priorityPresent()) {
            long readUnsignedInt = byteBuf.readUnsignedInt();
            final boolean z = (2147483648L & readUnsignedInt) != 0;
            int i3 = (int) (readUnsignedInt & UpdateOptions.SOURCE_ANY);
            int i4 = this.streamId;
            if (i3 != i4) {
                final short readUnsignedByte = (short) (byteBuf.readUnsignedByte() + 1);
                int lengthWithoutTrailingPadding = lengthWithoutTrailingPadding(i - byteBuf.readerIndex(), readPadding);
                final ChannelHandlerContext channelHandlerContext2 = channelHandlerContext;
                final int i5 = i3;
                AnonymousClass1 r0 = new HeadersContinuation() {
                    public int getStreamId() {
                        return i2;
                    }

                    public void processFragment(boolean z, ByteBuf byteBuf, int i, Http2FrameListener http2FrameListener) throws Http2Exception {
                        HeadersBlockBuilder headersBlockBuilder = headersBlockBuilder();
                        headersBlockBuilder.addFragment(byteBuf, i, channelHandlerContext2.alloc(), z);
                        if (z) {
                            http2FrameListener.onHeadersRead(channelHandlerContext2, i2, headersBlockBuilder.headers(), i5, readUnsignedByte, z, readPadding, http2Flags.endOfStream());
                        }
                    }
                };
                this.headersContinuation = r0;
                r0.processFragment(this.flags.endOfHeaders(), byteBuf, lengthWithoutTrailingPadding, http2FrameListener);
                resetHeadersContinuationIfEnd(this.flags.endOfHeaders());
                return;
            }
            throw Http2Exception.streamError(i4, Http2Error.PROTOCOL_ERROR, "A stream cannot depend on itself.", new Object[0]);
        }
        final ChannelHandlerContext channelHandlerContext3 = channelHandlerContext;
        final int i6 = readPadding;
        final Http2Flags http2Flags2 = http2Flags;
        this.headersContinuation = new HeadersContinuation() {
            public int getStreamId() {
                return i2;
            }

            public void processFragment(boolean z, ByteBuf byteBuf, int i, Http2FrameListener http2FrameListener) throws Http2Exception {
                HeadersBlockBuilder headersBlockBuilder = headersBlockBuilder();
                headersBlockBuilder.addFragment(byteBuf, i, channelHandlerContext3.alloc(), z);
                if (z) {
                    http2FrameListener.onHeadersRead(channelHandlerContext3, i2, headersBlockBuilder.headers(), i6, http2Flags2.endOfStream());
                }
            }
        };
        this.headersContinuation.processFragment(this.flags.endOfHeaders(), byteBuf, lengthWithoutTrailingPadding(i - byteBuf.readerIndex(), readPadding), http2FrameListener);
        resetHeadersContinuationIfEnd(this.flags.endOfHeaders());
    }

    private int readPadding(ByteBuf byteBuf) {
        if (!this.flags.paddingPresent()) {
            return 0;
        }
        return byteBuf.readUnsignedByte() + 1;
    }

    private void readPingFrame(ChannelHandlerContext channelHandlerContext, long j, Http2FrameListener http2FrameListener) throws Http2Exception {
        if (this.flags.ack()) {
            http2FrameListener.onPingAckRead(channelHandlerContext, j);
        } else {
            http2FrameListener.onPingRead(channelHandlerContext, j);
        }
    }

    private void readPriorityFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, Http2FrameListener http2FrameListener) throws Http2Exception {
        long readUnsignedInt = byteBuf.readUnsignedInt();
        boolean z = (2147483648L & readUnsignedInt) != 0;
        int i = (int) (readUnsignedInt & UpdateOptions.SOURCE_ANY);
        int i2 = this.streamId;
        if (i != i2) {
            http2FrameListener.onPriorityRead(channelHandlerContext, this.streamId, i, (short) (byteBuf.readUnsignedByte() + 1), z);
            return;
        }
        throw Http2Exception.streamError(i2, Http2Error.PROTOCOL_ERROR, "A stream cannot depend on itself.", new Object[0]);
    }

    private void readPushPromiseFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, int i, Http2FrameListener http2FrameListener) throws Http2Exception {
        final int i2 = this.streamId;
        int readPadding = readPadding(byteBuf);
        verifyPadding(readPadding);
        final int readUnsignedInt = Http2CodecUtil.readUnsignedInt(byteBuf);
        final ChannelHandlerContext channelHandlerContext2 = channelHandlerContext;
        final int i3 = readPadding;
        this.headersContinuation = new HeadersContinuation() {
            public int getStreamId() {
                return i2;
            }

            public void processFragment(boolean z, ByteBuf byteBuf, int i, Http2FrameListener http2FrameListener) throws Http2Exception {
                headersBlockBuilder().addFragment(byteBuf, i, channelHandlerContext2.alloc(), z);
                if (z) {
                    http2FrameListener.onPushPromiseRead(channelHandlerContext2, i2, readUnsignedInt, headersBlockBuilder().headers(), i3);
                }
            }
        };
        this.headersContinuation.processFragment(this.flags.endOfHeaders(), byteBuf, lengthWithoutTrailingPadding(i - byteBuf.readerIndex(), readPadding), http2FrameListener);
        resetHeadersContinuationIfEnd(this.flags.endOfHeaders());
    }

    private void readRstStreamFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, Http2FrameListener http2FrameListener) throws Http2Exception {
        http2FrameListener.onRstStreamRead(channelHandlerContext, this.streamId, byteBuf.readUnsignedInt());
    }

    private void readSettingsFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, Http2FrameListener http2FrameListener) throws Http2Exception {
        if (this.flags.ack()) {
            http2FrameListener.onSettingsAckRead(channelHandlerContext);
            return;
        }
        int i = this.payloadLength / 6;
        Http2Settings http2Settings = new Http2Settings();
        int i2 = 0;
        while (i2 < i) {
            char readUnsignedShort = (char) byteBuf.readUnsignedShort();
            try {
                http2Settings.put(readUnsignedShort, Long.valueOf(byteBuf.readUnsignedInt()));
                i2++;
            } catch (IllegalArgumentException e) {
                if (readUnsignedShort == 4) {
                    throw Http2Exception.connectionError(Http2Error.FLOW_CONTROL_ERROR, e, "Failed setting initial window size: %s", e.getMessage());
                }
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, e, "Protocol error: %s", e.getMessage());
            }
        }
        http2FrameListener.onSettingsRead(channelHandlerContext, http2Settings);
    }

    private void readUnknownFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, int i, Http2FrameListener http2FrameListener) throws Http2Exception {
        Http2FrameListener http2FrameListener2 = http2FrameListener;
        ChannelHandlerContext channelHandlerContext2 = channelHandlerContext;
        http2FrameListener2.onUnknownFrame(channelHandlerContext2, this.frameType, this.streamId, this.flags, byteBuf.readSlice(i - byteBuf.readerIndex()));
    }

    private void readWindowUpdateFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, Http2FrameListener http2FrameListener) throws Http2Exception {
        int readUnsignedInt = Http2CodecUtil.readUnsignedInt(byteBuf);
        if (readUnsignedInt != 0) {
            http2FrameListener.onWindowUpdateRead(channelHandlerContext, this.streamId, readUnsignedInt);
        } else {
            int i = this.streamId;
            throw Http2Exception.streamError(i, Http2Error.PROTOCOL_ERROR, "Received WINDOW_UPDATE with delta 0 for stream: %d", Integer.valueOf(i));
        }
    }

    private void resetHeadersContinuationIfEnd(boolean z) {
        if (z) {
            closeHeadersContinuation();
        }
    }

    private void verifyAssociatedWithAStream() throws Http2Exception {
        if (this.streamId == 0) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Frame of type %s must be associated with a stream.", Byte.valueOf(this.frameType));
        }
    }

    private void verifyContinuationFrame() throws Http2Exception {
        verifyAssociatedWithAStream();
        HeadersContinuation headersContinuation2 = this.headersContinuation;
        if (headersContinuation2 == null) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Received %s frame but not currently processing headers.", Byte.valueOf(this.frameType));
        } else if (this.streamId != headersContinuation2.getStreamId()) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Continuation stream ID does not match pending headers. Expected %d, but received %d.", Integer.valueOf(this.headersContinuation.getStreamId()), Integer.valueOf(this.streamId));
        } else if (this.payloadLength < this.flags.getPaddingPresenceFieldLength()) {
            throw Http2Exception.streamError(this.streamId, Http2Error.FRAME_SIZE_ERROR, "Frame length %d too small for padding.", Integer.valueOf(this.payloadLength));
        }
    }

    private void verifyDataFrame() throws Http2Exception {
        verifyAssociatedWithAStream();
        verifyNotProcessingHeaders();
        if (this.payloadLength < this.flags.getPaddingPresenceFieldLength()) {
            throw Http2Exception.streamError(this.streamId, Http2Error.FRAME_SIZE_ERROR, "Frame length %d too small.", Integer.valueOf(this.payloadLength));
        }
    }

    private void verifyGoAwayFrame() throws Http2Exception {
        verifyNotProcessingHeaders();
        if (this.streamId == 0) {
            int i = this.payloadLength;
            if (i < 8) {
                throw Http2Exception.connectionError(Http2Error.FRAME_SIZE_ERROR, "Frame length %d too small.", Integer.valueOf(i));
            }
            return;
        }
        throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "A stream ID must be zero.", new Object[0]);
    }

    private void verifyHeadersFrame() throws Http2Exception {
        verifyAssociatedWithAStream();
        verifyNotProcessingHeaders();
        if (this.payloadLength < this.flags.getPaddingPresenceFieldLength() + this.flags.getNumPriorityBytes()) {
            int i = this.streamId;
            Http2Error http2Error = Http2Error.FRAME_SIZE_ERROR;
            throw Http2Exception.streamError(i, http2Error, "Frame length too small." + this.payloadLength, new Object[0]);
        }
    }

    private void verifyNotProcessingHeaders() throws Http2Exception {
        if (this.headersContinuation != null) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Received frame of type %s while processing headers on stream %d.", Byte.valueOf(this.frameType), Integer.valueOf(this.headersContinuation.getStreamId()));
        }
    }

    private void verifyPadding(int i) throws Http2Exception {
        if (lengthWithoutTrailingPadding(this.payloadLength, i) < 0) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Frame payload too small for padding.", new Object[0]);
        }
    }

    private void verifyPingFrame() throws Http2Exception {
        verifyNotProcessingHeaders();
        if (this.streamId == 0) {
            int i = this.payloadLength;
            if (i != 8) {
                throw Http2Exception.connectionError(Http2Error.FRAME_SIZE_ERROR, "Frame length %d incorrect size for ping.", Integer.valueOf(i));
            }
            return;
        }
        throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "A stream ID must be zero.", new Object[0]);
    }

    private void verifyPriorityFrame() throws Http2Exception {
        verifyAssociatedWithAStream();
        verifyNotProcessingHeaders();
        int i = this.payloadLength;
        if (i != 5) {
            throw Http2Exception.streamError(this.streamId, Http2Error.FRAME_SIZE_ERROR, "Invalid frame length %d.", Integer.valueOf(i));
        }
    }

    private void verifyPushPromiseFrame() throws Http2Exception {
        verifyNotProcessingHeaders();
        int paddingPresenceFieldLength = this.flags.getPaddingPresenceFieldLength() + 4;
        int i = this.payloadLength;
        if (i < paddingPresenceFieldLength) {
            throw Http2Exception.streamError(this.streamId, Http2Error.FRAME_SIZE_ERROR, "Frame length %d too small.", Integer.valueOf(i));
        }
    }

    private void verifyRstStreamFrame() throws Http2Exception {
        verifyAssociatedWithAStream();
        verifyNotProcessingHeaders();
        int i = this.payloadLength;
        if (i != 4) {
            throw Http2Exception.connectionError(Http2Error.FRAME_SIZE_ERROR, "Invalid frame length %d.", Integer.valueOf(i));
        }
    }

    private void verifySettingsFrame() throws Http2Exception {
        verifyNotProcessingHeaders();
        if (this.streamId != 0) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "A stream ID must be zero.", new Object[0]);
        } else if (!this.flags.ack() || this.payloadLength <= 0) {
            int i = this.payloadLength;
            if (i % 6 > 0) {
                throw Http2Exception.connectionError(Http2Error.FRAME_SIZE_ERROR, "Frame length %d invalid.", Integer.valueOf(i));
            }
        } else {
            throw Http2Exception.connectionError(Http2Error.FRAME_SIZE_ERROR, "Ack settings frame must have an empty payload.", new Object[0]);
        }
    }

    private static void verifyStreamOrConnectionId(int i, String str) throws Http2Exception {
        if (i < 0) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "%s must be >= 0", str);
        }
    }

    private void verifyUnknownFrame() throws Http2Exception {
        verifyNotProcessingHeaders();
    }

    private void verifyWindowUpdateFrame() throws Http2Exception {
        verifyNotProcessingHeaders();
        verifyStreamOrConnectionId(this.streamId, "Stream ID");
        int i = this.payloadLength;
        if (i != 4) {
            throw Http2Exception.connectionError(Http2Error.FRAME_SIZE_ERROR, "Invalid frame length %d.", Integer.valueOf(i));
        }
    }

    public void close() {
        closeHeadersContinuation();
    }

    public Http2FrameReader.Configuration configuration() {
        return this;
    }

    public Http2FrameSizePolicy frameSizePolicy() {
        return this;
    }

    public Http2HeadersDecoder.Configuration headersConfiguration() {
        return this.headersDecoder.configuration();
    }

    public void maxFrameSize(int i) throws Http2Exception {
        if (Http2CodecUtil.isMaxFrameSizeValid(i)) {
            this.maxFrameSize = i;
            return;
        }
        throw Http2Exception.streamError(this.streamId, Http2Error.FRAME_SIZE_ERROR, "Invalid MAX_FRAME_SIZE specified in sent settings: %d", Integer.valueOf(i));
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0011 A[Catch:{ Http2Exception -> 0x001d, RuntimeException -> 0x001b, all -> 0x0019 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void readFrame(io.netty.channel.ChannelHandlerContext r3, io.netty.buffer.ByteBuf r4, io.netty.handler.codec.http2.Http2FrameListener r5) throws io.netty.handler.codec.http2.Http2Exception {
        /*
            r2 = this;
            boolean r0 = r2.readError
            if (r0 == 0) goto L_0x000c
            int r2 = r4.readableBytes()
            r4.skipBytes(r2)
            return
        L_0x000c:
            r0 = 1
            boolean r1 = r2.readingHeaders     // Catch:{ Http2Exception -> 0x001d, RuntimeException -> 0x001b, all -> 0x0019 }
            if (r1 == 0) goto L_0x001f
            r2.processHeaderState(r4)     // Catch:{ Http2Exception -> 0x001d, RuntimeException -> 0x001b, all -> 0x0019 }
            boolean r1 = r2.readingHeaders     // Catch:{ Http2Exception -> 0x001d, RuntimeException -> 0x001b, all -> 0x0019 }
            if (r1 == 0) goto L_0x001f
            return
        L_0x0019:
            r3 = move-exception
            goto L_0x002e
        L_0x001b:
            r3 = move-exception
            goto L_0x0034
        L_0x001d:
            r3 = move-exception
            goto L_0x0037
        L_0x001f:
            r2.processPayloadState(r3, r4, r5)     // Catch:{ Http2Exception -> 0x001d, RuntimeException -> 0x001b, all -> 0x0019 }
            boolean r1 = r2.readingHeaders     // Catch:{ Http2Exception -> 0x001d, RuntimeException -> 0x001b, all -> 0x0019 }
            if (r1 != 0) goto L_0x0027
            return
        L_0x0027:
            boolean r0 = r4.isReadable()     // Catch:{ Http2Exception -> 0x001d, RuntimeException -> 0x001b, all -> 0x0019 }
            if (r0 != 0) goto L_0x000c
            goto L_0x0033
        L_0x002e:
            r2.readError = r0
            io.netty.util.internal.PlatformDependent.throwException(r3)
        L_0x0033:
            return
        L_0x0034:
            r2.readError = r0
            throw r3
        L_0x0037:
            boolean r4 = io.netty.handler.codec.http2.Http2Exception.isStreamError(r3)
            r4 = r4 ^ r0
            r2.readError = r4
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http2.DefaultHttp2FrameReader.readFrame(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, io.netty.handler.codec.http2.Http2FrameListener):void");
    }

    public DefaultHttp2FrameReader(boolean z) {
        this((Http2HeadersDecoder) new DefaultHttp2HeadersDecoder(z));
    }

    public DefaultHttp2FrameReader(Http2HeadersDecoder http2HeadersDecoder) {
        this.readingHeaders = true;
        this.headersDecoder = http2HeadersDecoder;
        this.maxFrameSize = 16384;
    }

    public int maxFrameSize() {
        return this.maxFrameSize;
    }
}
