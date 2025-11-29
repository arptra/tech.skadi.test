package io.netty.handler.codec.http2;

import com.here.posclient.UpdateOptions;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http2.HpackUtil;
import io.netty.handler.codec.http2.Http2Exception;
import io.netty.handler.codec.http2.Http2Headers;
import io.netty.util.AsciiString;
import io.netty.util.internal.ObjectUtil;

final class HpackDecoder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Http2Exception DECODE_ILLEGAL_INDEX_VALUE;
    private static final Http2Exception DECODE_ULE_128_DECOMPRESSION_EXCEPTION;
    private static final Http2Exception DECODE_ULE_128_TO_INT_DECOMPRESSION_EXCEPTION;
    private static final Http2Exception DECODE_ULE_128_TO_LONG_DECOMPRESSION_EXCEPTION;
    private static final Http2Exception INDEX_HEADER_ILLEGAL_INDEX_VALUE;
    private static final Http2Exception INVALID_MAX_DYNAMIC_TABLE_SIZE;
    private static final Http2Exception MAX_DYNAMIC_TABLE_SIZE_CHANGE_REQUIRED;
    private static final byte READ_HEADER_REPRESENTATION = 0;
    private static final byte READ_INDEXED_HEADER = 2;
    private static final byte READ_INDEXED_HEADER_NAME = 3;
    private static final byte READ_LITERAL_HEADER_NAME = 6;
    private static final byte READ_LITERAL_HEADER_NAME_LENGTH = 5;
    private static final byte READ_LITERAL_HEADER_NAME_LENGTH_PREFIX = 4;
    private static final byte READ_LITERAL_HEADER_VALUE = 9;
    private static final byte READ_LITERAL_HEADER_VALUE_LENGTH = 8;
    private static final byte READ_LITERAL_HEADER_VALUE_LENGTH_PREFIX = 7;
    private static final byte READ_MAX_DYNAMIC_TABLE_SIZE = 1;
    private static final Http2Exception READ_NAME_ILLEGAL_INDEX_VALUE;
    private long encoderMaxDynamicTableSize;
    private final HpackDynamicTable hpackDynamicTable;
    private final HpackHuffmanDecoder huffmanDecoder;
    private long maxDynamicTableSize;
    private boolean maxDynamicTableSizeChangeRequired;
    private long maxHeaderListSize;

    /* renamed from: io.netty.handler.codec.http2.HpackDecoder$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http2$HpackUtil$IndexType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                io.netty.handler.codec.http2.HpackUtil$IndexType[] r0 = io.netty.handler.codec.http2.HpackUtil.IndexType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$netty$handler$codec$http2$HpackUtil$IndexType = r0
                io.netty.handler.codec.http2.HpackUtil$IndexType r1 = io.netty.handler.codec.http2.HpackUtil.IndexType.NONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$netty$handler$codec$http2$HpackUtil$IndexType     // Catch:{ NoSuchFieldError -> 0x001d }
                io.netty.handler.codec.http2.HpackUtil$IndexType r1 = io.netty.handler.codec.http2.HpackUtil.IndexType.NEVER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$netty$handler$codec$http2$HpackUtil$IndexType     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.netty.handler.codec.http2.HpackUtil$IndexType r1 = io.netty.handler.codec.http2.HpackUtil.IndexType.INCREMENTAL     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http2.HpackDecoder.AnonymousClass1.<clinit>():void");
        }
    }

    public enum HeaderType {
        REGULAR_HEADER,
        REQUEST_PSEUDO_HEADER,
        RESPONSE_PSEUDO_HEADER
    }

    public static final class Http2HeadersSink implements Sink {
        private boolean exceededMaxLength;
        private final Http2Headers headers;
        private long headersLength;
        private final long maxHeaderListSize;
        private HeaderType previousType;
        private final int streamId;
        private final boolean validate;
        private Http2Exception validationException;

        public Http2HeadersSink(int i, Http2Headers http2Headers, long j, boolean z) {
            this.headers = http2Headers;
            this.maxHeaderListSize = j;
            this.streamId = i;
            this.validate = z;
        }

        public void appendToHeaderList(CharSequence charSequence, CharSequence charSequence2) {
            long sizeOf = this.headersLength + HpackHeaderField.sizeOf(charSequence, charSequence2);
            this.headersLength = sizeOf;
            boolean z = (sizeOf > this.maxHeaderListSize) | this.exceededMaxLength;
            this.exceededMaxLength = z;
            if (!z && this.validationException == null) {
                if (this.validate) {
                    try {
                        this.previousType = HpackDecoder.validate(this.streamId, charSequence, this.previousType, this.headers);
                    } catch (Http2Exception e) {
                        this.validationException = e;
                        return;
                    }
                }
                this.headers.add(charSequence, charSequence2);
            }
        }

        public void finish() throws Http2Exception {
            if (this.exceededMaxLength) {
                Http2CodecUtil.headerListSizeExceeded(this.streamId, this.maxHeaderListSize, true);
                return;
            }
            Http2Exception http2Exception = this.validationException;
            if (http2Exception != null) {
                throw http2Exception;
            }
        }
    }

    public interface Sink {
        void appendToHeaderList(CharSequence charSequence, CharSequence charSequence2);

        void finish() throws Http2Exception;
    }

    static {
        Http2Error http2Error = Http2Error.COMPRESSION_ERROR;
        Http2Exception.ShutdownHint shutdownHint = Http2Exception.ShutdownHint.HARD_SHUTDOWN;
        Class<HpackDecoder> cls = HpackDecoder.class;
        DECODE_ULE_128_DECOMPRESSION_EXCEPTION = Http2Exception.newStatic(http2Error, "HPACK - decompression failure", shutdownHint, cls, "decodeULE128(..)");
        DECODE_ULE_128_TO_LONG_DECOMPRESSION_EXCEPTION = Http2Exception.newStatic(http2Error, "HPACK - long overflow", shutdownHint, cls, "decodeULE128(..)");
        DECODE_ULE_128_TO_INT_DECOMPRESSION_EXCEPTION = Http2Exception.newStatic(http2Error, "HPACK - int overflow", shutdownHint, cls, "decodeULE128ToInt(..)");
        DECODE_ILLEGAL_INDEX_VALUE = Http2Exception.newStatic(http2Error, "HPACK - illegal index value", shutdownHint, cls, "decode(..)");
        INDEX_HEADER_ILLEGAL_INDEX_VALUE = Http2Exception.newStatic(http2Error, "HPACK - illegal index value", shutdownHint, cls, "indexHeader(..)");
        READ_NAME_ILLEGAL_INDEX_VALUE = Http2Exception.newStatic(http2Error, "HPACK - illegal index value", shutdownHint, cls, "readName(..)");
        INVALID_MAX_DYNAMIC_TABLE_SIZE = Http2Exception.newStatic(http2Error, "HPACK - invalid max dynamic table size", shutdownHint, cls, "setDynamicTableSize(..)");
        MAX_DYNAMIC_TABLE_SIZE_CHANGE_REQUIRED = Http2Exception.newStatic(http2Error, "HPACK - max dynamic table size change required", shutdownHint, cls, "decode(..)");
    }

    public HpackDecoder(long j) {
        this(j, 4096);
    }

    private static boolean contains(Http2Headers http2Headers, CharSequence charSequence) {
        if (http2Headers == EmptyHttp2Headers.INSTANCE) {
            return false;
        }
        return ((http2Headers instanceof DefaultHttp2Headers) || (http2Headers instanceof ReadOnlyHttp2Headers)) ? http2Headers.contains(charSequence) : Http2Headers.PseudoHeaderName.METHOD.value().equals(charSequence) ? http2Headers.method() != null : Http2Headers.PseudoHeaderName.SCHEME.value().equals(charSequence) ? http2Headers.scheme() != null : Http2Headers.PseudoHeaderName.AUTHORITY.value().equals(charSequence) ? http2Headers.authority() != null : Http2Headers.PseudoHeaderName.PATH.value().equals(charSequence) ? http2Headers.path() != null : Http2Headers.PseudoHeaderName.STATUS.value().equals(charSequence) && http2Headers.status() != null;
    }

    public static int decodeULE128(ByteBuf byteBuf, int i) throws Http2Exception {
        int readerIndex = byteBuf.readerIndex();
        long decodeULE128 = decodeULE128(byteBuf, (long) i);
        if (decodeULE128 <= UpdateOptions.SOURCE_ANY) {
            return (int) decodeULE128;
        }
        byteBuf.readerIndex(readerIndex);
        throw DECODE_ULE_128_TO_INT_DECOMPRESSION_EXCEPTION;
    }

    private HpackHeaderField getIndexedHeader(int i) throws Http2Exception {
        int i2 = HpackStaticTable.length;
        if (i <= i2) {
            return HpackStaticTable.getEntry(i);
        }
        if (i - i2 <= this.hpackDynamicTable.length()) {
            return this.hpackDynamicTable.getEntry(i - i2);
        }
        throw INDEX_HEADER_ILLEGAL_INDEX_VALUE;
    }

    private void insertHeader(Sink sink, CharSequence charSequence, CharSequence charSequence2, HpackUtil.IndexType indexType) {
        sink.appendToHeaderList(charSequence, charSequence2);
        int i = AnonymousClass1.$SwitchMap$io$netty$handler$codec$http2$HpackUtil$IndexType[indexType.ordinal()];
        if (i != 1 && i != 2) {
            if (i == 3) {
                this.hpackDynamicTable.add(new HpackHeaderField(charSequence, charSequence2));
                return;
            }
            throw new Error("should not reach here");
        }
    }

    private static IllegalArgumentException notEnoughDataException(ByteBuf byteBuf) {
        return new IllegalArgumentException("decode only works with an entire header block! " + byteBuf);
    }

    private CharSequence readName(int i) throws Http2Exception {
        int i2 = HpackStaticTable.length;
        if (i <= i2) {
            return HpackStaticTable.getEntry(i).name;
        }
        if (i - i2 <= this.hpackDynamicTable.length()) {
            return this.hpackDynamicTable.getEntry(i - i2).name;
        }
        throw READ_NAME_ILLEGAL_INDEX_VALUE;
    }

    private CharSequence readStringLiteral(ByteBuf byteBuf, int i, boolean z) throws Http2Exception {
        if (z) {
            return this.huffmanDecoder.decode(byteBuf, i);
        }
        byte[] bArr = new byte[i];
        byteBuf.readBytes(bArr);
        return new AsciiString(bArr, false);
    }

    private void setDynamicTableSize(long j) throws Http2Exception {
        if (j <= this.maxDynamicTableSize) {
            this.encoderMaxDynamicTableSize = j;
            this.maxDynamicTableSizeChangeRequired = false;
            this.hpackDynamicTable.setCapacity(j);
            return;
        }
        throw INVALID_MAX_DYNAMIC_TABLE_SIZE;
    }

    /* access modifiers changed from: private */
    public static HeaderType validate(int i, CharSequence charSequence, HeaderType headerType, Http2Headers http2Headers) throws Http2Exception {
        if (!Http2Headers.PseudoHeaderName.hasPseudoHeaderFormat(charSequence)) {
            return HeaderType.REGULAR_HEADER;
        }
        if (headerType != HeaderType.REGULAR_HEADER) {
            Http2Headers.PseudoHeaderName pseudoHeader = Http2Headers.PseudoHeaderName.getPseudoHeader(charSequence);
            if (pseudoHeader != null) {
                HeaderType headerType2 = pseudoHeader.isRequestOnly() ? HeaderType.REQUEST_PSEUDO_HEADER : HeaderType.RESPONSE_PSEUDO_HEADER;
                if (headerType != null && headerType2 != headerType) {
                    throw Http2Exception.streamError(i, Http2Error.PROTOCOL_ERROR, "Mix of request and response pseudo-headers.", new Object[0]);
                } else if (!contains(http2Headers, charSequence)) {
                    return headerType2;
                } else {
                    throw Http2Exception.streamError(i, Http2Error.PROTOCOL_ERROR, "Duplicate HTTP/2 pseudo-header '%s' encountered.", charSequence);
                }
            } else {
                throw Http2Exception.streamError(i, Http2Error.PROTOCOL_ERROR, "Invalid HTTP/2 pseudo-header '%s' encountered.", charSequence);
            }
        } else {
            throw Http2Exception.streamError(i, Http2Error.PROTOCOL_ERROR, "Pseudo-header field '%s' found after regular header.", charSequence);
        }
    }

    public void decode(int i, ByteBuf byteBuf, Http2Headers http2Headers, boolean z) throws Http2Exception {
        Http2HeadersSink http2HeadersSink = new Http2HeadersSink(i, http2Headers, this.maxHeaderListSize, z);
        decode(byteBuf, http2HeadersSink);
        http2HeadersSink.finish();
    }

    public HpackHeaderField getHeaderField(int i) {
        return this.hpackDynamicTable.getEntry(i + 1);
    }

    public long getMaxHeaderListSize() {
        return this.maxHeaderListSize;
    }

    public long getMaxHeaderTableSize() {
        return this.hpackDynamicTable.capacity();
    }

    public int length() {
        return this.hpackDynamicTable.length();
    }

    @Deprecated
    public void setMaxHeaderListSize(long j, long j2) throws Http2Exception {
        setMaxHeaderListSize(j);
    }

    public void setMaxHeaderTableSize(long j) throws Http2Exception {
        if (j < 0 || j > 4294967295L) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Header Table Size must be >= %d and <= %d but was %d", 0L, 4294967295L, Long.valueOf(j));
        }
        this.maxDynamicTableSize = j;
        if (j < this.encoderMaxDynamicTableSize) {
            this.maxDynamicTableSizeChangeRequired = true;
            this.hpackDynamicTable.setCapacity(j);
        }
    }

    public long size() {
        return this.hpackDynamicTable.size();
    }

    public HpackDecoder(long j, int i) {
        this.huffmanDecoder = new HpackHuffmanDecoder();
        this.maxHeaderListSize = ObjectUtil.checkPositive(j, "maxHeaderListSize");
        long j2 = (long) i;
        this.encoderMaxDynamicTableSize = j2;
        this.maxDynamicTableSize = j2;
        this.maxDynamicTableSizeChangeRequired = false;
        this.hpackDynamicTable = new HpackDynamicTable(j2);
    }

    public void setMaxHeaderListSize(long j) throws Http2Exception {
        if (j < 0 || j > 4294967295L) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Header List Size must be >= %d and <= %d but was %d", 0L, 4294967295L, Long.valueOf(j));
        }
        this.maxHeaderListSize = j;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0044, code lost:
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004f, code lost:
        r6 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0077, code lost:
        r6 = 7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void decode(io.netty.buffer.ByteBuf r17, io.netty.handler.codec.http2.HpackDecoder.Sink r18) throws io.netty.handler.codec.http2.Http2Exception {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            io.netty.handler.codec.http2.HpackUtil$IndexType r3 = io.netty.handler.codec.http2.HpackUtil.IndexType.NONE
            r4 = 0
            r5 = 0
            r6 = r4
            r7 = r6
            r8 = r7
            r9 = r8
            r10 = r9
        L_0x000f:
            boolean r11 = r17.isReadable()
            if (r11 == 0) goto L_0x0139
            r12 = 9
            r13 = 1
            r14 = 7
            r15 = 128(0x80, float:1.794E-43)
            r11 = 127(0x7f, float:1.78E-43)
            switch(r6) {
                case 0: goto L_0x00be;
                case 1: goto L_0x00b5;
                case 2: goto L_0x00a5;
                case 3: goto L_0x0098;
                case 4: goto L_0x0084;
                case 5: goto L_0x007e;
                case 6: goto L_0x006d;
                case 7: goto L_0x0051;
                case 8: goto L_0x004b;
                case 9: goto L_0x0037;
                default: goto L_0x0020;
            }
        L_0x0020:
            java.lang.Error r0 = new java.lang.Error
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "should not reach here state: "
            r1.append(r2)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0037:
            int r6 = r17.readableBytes()
            if (r6 < r9) goto L_0x0046
            java.lang.CharSequence r6 = r0.readStringLiteral(r1, r9, r10)
            r0.insertHeader(r2, r5, r6, r3)
        L_0x0044:
            r6 = r4
            goto L_0x000f
        L_0x0046:
            java.lang.IllegalArgumentException r0 = notEnoughDataException(r17)
            throw r0
        L_0x004b:
            int r9 = decodeULE128((io.netty.buffer.ByteBuf) r1, (int) r7)
        L_0x004f:
            r6 = r12
            goto L_0x000f
        L_0x0051:
            byte r6 = r17.readByte()
            r7 = r6 & 128(0x80, float:1.794E-43)
            if (r7 != r15) goto L_0x005b
            r10 = r13
            goto L_0x005c
        L_0x005b:
            r10 = r4
        L_0x005c:
            r7 = r6 & 127(0x7f, float:1.78E-43)
            if (r7 == 0) goto L_0x0067
            if (r7 == r11) goto L_0x0064
            r9 = r7
            goto L_0x004f
        L_0x0064:
            r6 = 8
            goto L_0x000f
        L_0x0067:
            io.netty.util.AsciiString r6 = io.netty.util.AsciiString.EMPTY_STRING
            r0.insertHeader(r2, r5, r6, r3)
            goto L_0x0044
        L_0x006d:
            int r5 = r17.readableBytes()
            if (r5 < r8) goto L_0x0079
            java.lang.CharSequence r5 = r0.readStringLiteral(r1, r8, r10)
        L_0x0077:
            r6 = r14
            goto L_0x000f
        L_0x0079:
            java.lang.IllegalArgumentException r0 = notEnoughDataException(r17)
            throw r0
        L_0x007e:
            int r8 = decodeULE128((io.netty.buffer.ByteBuf) r1, (int) r7)
        L_0x0082:
            r6 = 6
            goto L_0x000f
        L_0x0084:
            byte r6 = r17.readByte()
            r7 = r6 & 128(0x80, float:1.794E-43)
            if (r7 != r15) goto L_0x008e
            r10 = r13
            goto L_0x008f
        L_0x008e:
            r10 = r4
        L_0x008f:
            r7 = r6 & 127(0x7f, float:1.78E-43)
            if (r7 != r11) goto L_0x0096
            r6 = 5
            goto L_0x000f
        L_0x0096:
            r8 = r7
            goto L_0x0082
        L_0x0098:
            int r5 = decodeULE128((io.netty.buffer.ByteBuf) r1, (int) r7)
            java.lang.CharSequence r5 = r0.readName(r5)
            int r8 = r5.length()
            goto L_0x0077
        L_0x00a5:
            int r6 = decodeULE128((io.netty.buffer.ByteBuf) r1, (int) r7)
            io.netty.handler.codec.http2.HpackHeaderField r6 = r0.getIndexedHeader(r6)
            java.lang.CharSequence r11 = r6.name
            java.lang.CharSequence r6 = r6.value
            r2.appendToHeaderList(r11, r6)
            goto L_0x0044
        L_0x00b5:
            long r11 = (long) r7
            long r11 = decodeULE128((io.netty.buffer.ByteBuf) r1, (long) r11)
            r0.setDynamicTableSize(r11)
            goto L_0x0044
        L_0x00be:
            byte r7 = r17.readByte()
            boolean r12 = r0.maxDynamicTableSizeChangeRequired
            r15 = 32
            if (r12 == 0) goto L_0x00d0
            r12 = r7 & 224(0xe0, float:3.14E-43)
            if (r12 != r15) goto L_0x00cd
            goto L_0x00d0
        L_0x00cd:
            io.netty.handler.codec.http2.Http2Exception r0 = MAX_DYNAMIC_TABLE_SIZE_CHANGE_REQUIRED
            throw r0
        L_0x00d0:
            if (r7 >= 0) goto L_0x00eb
            r7 = r7 & 127(0x7f, float:1.78E-43)
            if (r7 == 0) goto L_0x00e8
            if (r7 == r11) goto L_0x00e5
            io.netty.handler.codec.http2.HpackHeaderField r11 = r0.getIndexedHeader(r7)
            java.lang.CharSequence r12 = r11.name
            java.lang.CharSequence r11 = r11.value
            r2.appendToHeaderList(r12, r11)
            goto L_0x000f
        L_0x00e5:
            r6 = 2
            goto L_0x000f
        L_0x00e8:
            io.netty.handler.codec.http2.Http2Exception r0 = DECODE_ILLEGAL_INDEX_VALUE
            throw r0
        L_0x00eb:
            r6 = r7 & 64
            r12 = 3
            r11 = 64
            if (r6 != r11) goto L_0x0109
            io.netty.handler.codec.http2.HpackUtil$IndexType r3 = io.netty.handler.codec.http2.HpackUtil.IndexType.INCREMENTAL
            r7 = r7 & 63
            if (r7 == 0) goto L_0x0106
            r6 = 63
            if (r7 == r6) goto L_0x004f
            java.lang.CharSequence r5 = r0.readName(r7)
            int r8 = r5.length()
            goto L_0x0077
        L_0x0106:
            r6 = 4
            goto L_0x000f
        L_0x0109:
            r6 = r7 & 32
            if (r6 != r15) goto L_0x011c
            r7 = r7 & 31
            r6 = 31
            if (r7 != r6) goto L_0x0116
            r6 = r13
            goto L_0x000f
        L_0x0116:
            long r11 = (long) r7
            r0.setDynamicTableSize(r11)
            goto L_0x0044
        L_0x011c:
            r3 = r7 & 16
            r6 = 16
            if (r3 != r6) goto L_0x0125
            io.netty.handler.codec.http2.HpackUtil$IndexType r3 = io.netty.handler.codec.http2.HpackUtil.IndexType.NEVER
            goto L_0x0127
        L_0x0125:
            io.netty.handler.codec.http2.HpackUtil$IndexType r3 = io.netty.handler.codec.http2.HpackUtil.IndexType.NONE
        L_0x0127:
            r7 = r7 & 15
            if (r7 == 0) goto L_0x0106
            r6 = 15
            if (r7 == r6) goto L_0x004f
            java.lang.CharSequence r5 = r0.readName(r7)
            int r8 = r5.length()
            goto L_0x0077
        L_0x0139:
            if (r6 != 0) goto L_0x013c
            return
        L_0x013c:
            io.netty.handler.codec.http2.Http2Error r0 = io.netty.handler.codec.http2.Http2Error.COMPRESSION_ERROR
            java.lang.String r1 = "Incomplete header block fragment."
            java.lang.Object[] r2 = new java.lang.Object[r4]
            io.netty.handler.codec.http2.Http2Exception r0 = io.netty.handler.codec.http2.Http2Exception.connectionError(r0, r1, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http2.HpackDecoder.decode(io.netty.buffer.ByteBuf, io.netty.handler.codec.http2.HpackDecoder$Sink):void");
    }

    public static long decodeULE128(ByteBuf byteBuf, long j) throws Http2Exception {
        int i = 0;
        boolean z = j == 0;
        int writerIndex = byteBuf.writerIndex();
        int readerIndex = byteBuf.readerIndex();
        while (readerIndex < writerIndex) {
            byte b = byteBuf.getByte(readerIndex);
            if (i == 56 && ((b & 128) != 0 || (b == Byte.MAX_VALUE && !z))) {
                throw DECODE_ULE_128_TO_LONG_DECOMPRESSION_EXCEPTION;
            } else if ((b & 128) == 0) {
                byteBuf.readerIndex(readerIndex + 1);
                return j + ((((long) b) & 127) << i);
            } else {
                j += (((long) b) & 127) << i;
                readerIndex++;
                i += 7;
            }
        }
        throw DECODE_ULE_128_DECOMPRESSION_EXCEPTION;
    }
}
