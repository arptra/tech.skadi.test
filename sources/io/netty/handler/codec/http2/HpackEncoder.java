package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http2.HpackUtil;
import io.netty.handler.codec.http2.Http2HeadersEncoder;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.MathUtil;
import java.util.Arrays;
import java.util.Map;

final class HpackEncoder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int HUFF_CODE_THRESHOLD = 512;
    static final int NOT_FOUND = -1;
    private final byte hashMask;
    private final HeaderEntry head;
    private final HeaderEntry[] headerFields;
    private final HpackHuffmanEncoder hpackHuffmanEncoder;
    private final int huffCodeThreshold;
    private final boolean ignoreMaxHeaderListSize;
    private long maxHeaderListSize;
    private long maxHeaderTableSize;
    private long size;

    /* renamed from: io.netty.handler.codec.http2.HpackEncoder$1  reason: invalid class name */
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
                io.netty.handler.codec.http2.HpackUtil$IndexType r1 = io.netty.handler.codec.http2.HpackUtil.IndexType.INCREMENTAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$netty$handler$codec$http2$HpackUtil$IndexType     // Catch:{ NoSuchFieldError -> 0x001d }
                io.netty.handler.codec.http2.HpackUtil$IndexType r1 = io.netty.handler.codec.http2.HpackUtil.IndexType.NONE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$netty$handler$codec$http2$HpackUtil$IndexType     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.netty.handler.codec.http2.HpackUtil$IndexType r1 = io.netty.handler.codec.http2.HpackUtil.IndexType.NEVER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http2.HpackEncoder.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class HeaderEntry extends HpackHeaderField {
        HeaderEntry after;
        HeaderEntry before;
        int hash;
        int index;
        HeaderEntry next;

        public HeaderEntry(int i, CharSequence charSequence, CharSequence charSequence2, int i2, HeaderEntry headerEntry) {
            super(charSequence, charSequence2);
            this.index = i2;
            this.hash = i;
            this.next = headerEntry;
        }

        /* access modifiers changed from: private */
        public void addBefore(HeaderEntry headerEntry) {
            this.after = headerEntry;
            HeaderEntry headerEntry2 = headerEntry.before;
            this.before = headerEntry2;
            headerEntry2.after = this;
            this.after.before = this;
        }

        /* access modifiers changed from: private */
        public void remove() {
            HeaderEntry headerEntry = this.before;
            headerEntry.after = this.after;
            this.after.before = headerEntry;
            this.before = null;
            this.after = null;
            this.next = null;
        }
    }

    public HpackEncoder() {
        this(false);
    }

    private void add(CharSequence charSequence, CharSequence charSequence2, long j) {
        if (j > this.maxHeaderTableSize) {
            clear();
            return;
        }
        while (this.maxHeaderTableSize - this.size < j) {
            remove();
        }
        int hashCode = AsciiString.hashCode(charSequence);
        int index = index(hashCode);
        HeaderEntry headerEntry = new HeaderEntry(hashCode, charSequence, charSequence2, this.head.before.index - 1, this.headerFields[index]);
        this.headerFields[index] = headerEntry;
        headerEntry.addBefore(this.head);
        this.size += j;
    }

    private void clear() {
        Arrays.fill(this.headerFields, (Object) null);
        HeaderEntry headerEntry = this.head;
        headerEntry.after = headerEntry;
        headerEntry.before = headerEntry;
        this.size = 0;
    }

    private void encodeHeader(ByteBuf byteBuf, CharSequence charSequence, CharSequence charSequence2, boolean z, long j) {
        ByteBuf byteBuf2 = byteBuf;
        CharSequence charSequence3 = charSequence;
        CharSequence charSequence4 = charSequence2;
        long j2 = j;
        if (z) {
            ByteBuf byteBuf3 = byteBuf;
            CharSequence charSequence5 = charSequence;
            CharSequence charSequence6 = charSequence2;
            encodeLiteral(byteBuf3, charSequence5, charSequence6, HpackUtil.IndexType.NEVER, getNameIndex(charSequence));
            return;
        }
        long j3 = this.maxHeaderTableSize;
        if (j3 == 0) {
            int indexInsensitive = HpackStaticTable.getIndexInsensitive(charSequence, charSequence2);
            if (indexInsensitive == -1) {
                ByteBuf byteBuf4 = byteBuf;
                CharSequence charSequence7 = charSequence;
                CharSequence charSequence8 = charSequence2;
                encodeLiteral(byteBuf4, charSequence7, charSequence8, HpackUtil.IndexType.NONE, HpackStaticTable.getIndex(charSequence));
                return;
            }
            encodeInteger(byteBuf, 128, 7, indexInsensitive);
        } else if (j2 > j3) {
            ByteBuf byteBuf5 = byteBuf;
            CharSequence charSequence9 = charSequence;
            CharSequence charSequence10 = charSequence2;
            encodeLiteral(byteBuf5, charSequence9, charSequence10, HpackUtil.IndexType.NONE, getNameIndex(charSequence));
        } else {
            HeaderEntry entryInsensitive = getEntryInsensitive(charSequence, charSequence2);
            if (entryInsensitive != null) {
                encodeInteger(byteBuf, 128, 7, getIndex(entryInsensitive.index) + HpackStaticTable.length);
                return;
            }
            int indexInsensitive2 = HpackStaticTable.getIndexInsensitive(charSequence, charSequence2);
            if (indexInsensitive2 != -1) {
                encodeInteger(byteBuf, 128, 7, indexInsensitive2);
                return;
            }
            ensureCapacity(j2);
            encodeLiteral(byteBuf, charSequence, charSequence2, HpackUtil.IndexType.INCREMENTAL, getNameIndex(charSequence));
            add(charSequence, charSequence2, j2);
        }
    }

    private void encodeHeadersEnforceMaxHeaderListSize(int i, ByteBuf byteBuf, Http2Headers http2Headers, Http2HeadersEncoder.SensitivityDetector sensitivityDetector) throws Http2Exception {
        long j = 0;
        for (Map.Entry next : http2Headers) {
            j += HpackHeaderField.sizeOf((CharSequence) next.getKey(), (CharSequence) next.getValue());
            long j2 = this.maxHeaderListSize;
            if (j > j2) {
                Http2CodecUtil.headerListSizeExceeded(i, j2, false);
            }
        }
        encodeHeadersIgnoreMaxHeaderListSize(byteBuf, http2Headers, sensitivityDetector);
    }

    private void encodeHeadersIgnoreMaxHeaderListSize(ByteBuf byteBuf, Http2Headers http2Headers, Http2HeadersEncoder.SensitivityDetector sensitivityDetector) throws Http2Exception {
        for (Map.Entry next : http2Headers) {
            CharSequence charSequence = (CharSequence) next.getKey();
            CharSequence charSequence2 = (CharSequence) next.getValue();
            encodeHeader(byteBuf, charSequence, charSequence2, sensitivityDetector.isSensitive(charSequence, charSequence2), HpackHeaderField.sizeOf(charSequence, charSequence2));
        }
    }

    private static void encodeInteger(ByteBuf byteBuf, int i, int i2, int i3) {
        encodeInteger(byteBuf, i, i2, (long) i3);
    }

    private void encodeLiteral(ByteBuf byteBuf, CharSequence charSequence, CharSequence charSequence2, HpackUtil.IndexType indexType, int i) {
        boolean z = i != -1;
        int i2 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$http2$HpackUtil$IndexType[indexType.ordinal()];
        if (i2 == 1) {
            if (!z) {
                i = 0;
            }
            encodeInteger(byteBuf, 64, 6, i);
        } else if (i2 == 2) {
            if (!z) {
                i = 0;
            }
            encodeInteger(byteBuf, 0, 4, i);
        } else if (i2 == 3) {
            if (!z) {
                i = 0;
            }
            encodeInteger(byteBuf, 16, 4, i);
        } else {
            throw new Error("should not reach here");
        }
        if (!z) {
            encodeStringLiteral(byteBuf, charSequence);
        }
        encodeStringLiteral(byteBuf, charSequence2);
    }

    private void encodeStringLiteral(ByteBuf byteBuf, CharSequence charSequence) {
        int encodedLength;
        if (charSequence.length() < this.huffCodeThreshold || (encodedLength = this.hpackHuffmanEncoder.getEncodedLength(charSequence)) >= charSequence.length()) {
            encodeInteger(byteBuf, 0, 7, charSequence.length());
            if (charSequence instanceof AsciiString) {
                AsciiString asciiString = (AsciiString) charSequence;
                byteBuf.writeBytes(asciiString.array(), asciiString.arrayOffset(), asciiString.length());
                return;
            }
            byteBuf.writeCharSequence(charSequence, CharsetUtil.ISO_8859_1);
            return;
        }
        encodeInteger(byteBuf, 128, 7, encodedLength);
        this.hpackHuffmanEncoder.encode(byteBuf, charSequence);
    }

    private void ensureCapacity(long j) {
        while (this.maxHeaderTableSize - this.size < j && length() != 0) {
            remove();
        }
    }

    private HeaderEntry getEntryInsensitive(CharSequence charSequence, CharSequence charSequence2) {
        if (!(length() == 0 || charSequence == null || charSequence2 == null)) {
            int hashCode = AsciiString.hashCode(charSequence);
            for (HeaderEntry headerEntry = this.headerFields[index(hashCode)]; headerEntry != null; headerEntry = headerEntry.next) {
                if (headerEntry.hash == hashCode && HpackUtil.equalsVariableTime(charSequence2, headerEntry.value) && HpackUtil.equalsVariableTime(charSequence, headerEntry.name)) {
                    return headerEntry;
                }
            }
        }
        return null;
    }

    private int getIndex(CharSequence charSequence) {
        if (!(length() == 0 || charSequence == null)) {
            int hashCode = AsciiString.hashCode(charSequence);
            for (HeaderEntry headerEntry = this.headerFields[index(hashCode)]; headerEntry != null; headerEntry = headerEntry.next) {
                if (headerEntry.hash == hashCode && HpackUtil.equalsConstantTime(charSequence, headerEntry.name) != 0) {
                    return getIndex(headerEntry.index);
                }
            }
        }
        return -1;
    }

    private int getNameIndex(CharSequence charSequence) {
        int index = HpackStaticTable.getIndex(charSequence);
        if (index != -1) {
            return index;
        }
        int index2 = getIndex(charSequence);
        return index2 >= 0 ? index2 + HpackStaticTable.length : index2;
    }

    private int index(int i) {
        return this.hashMask & i;
    }

    private HpackHeaderField remove() {
        if (this.size == 0) {
            return null;
        }
        HeaderEntry headerEntry = this.head.after;
        int index = index(headerEntry.hash);
        HeaderEntry headerEntry2 = this.headerFields[index];
        HeaderEntry headerEntry3 = headerEntry2;
        while (headerEntry2 != null) {
            HeaderEntry headerEntry4 = headerEntry2.next;
            if (headerEntry2 == headerEntry) {
                if (headerEntry3 == headerEntry) {
                    this.headerFields[index] = headerEntry4;
                } else {
                    headerEntry3.next = headerEntry4;
                }
                headerEntry.remove();
                this.size -= (long) headerEntry.size();
                return headerEntry;
            }
            headerEntry3 = headerEntry2;
            headerEntry2 = headerEntry4;
        }
        return null;
    }

    public void encodeHeaders(int i, ByteBuf byteBuf, Http2Headers http2Headers, Http2HeadersEncoder.SensitivityDetector sensitivityDetector) throws Http2Exception {
        if (this.ignoreMaxHeaderListSize) {
            encodeHeadersIgnoreMaxHeaderListSize(byteBuf, http2Headers, sensitivityDetector);
        } else {
            encodeHeadersEnforceMaxHeaderListSize(i, byteBuf, http2Headers, sensitivityDetector);
        }
    }

    public HpackHeaderField getHeaderField(int i) {
        HeaderEntry headerEntry = this.head;
        while (true) {
            int i2 = i - 1;
            if (i < 0) {
                return headerEntry;
            }
            headerEntry = headerEntry.before;
            i = i2;
        }
    }

    public long getMaxHeaderListSize() {
        return this.maxHeaderListSize;
    }

    public long getMaxHeaderTableSize() {
        return this.maxHeaderTableSize;
    }

    public int length() {
        if (this.size == 0) {
            return 0;
        }
        HeaderEntry headerEntry = this.head;
        return (headerEntry.after.index - headerEntry.before.index) + 1;
    }

    public void setMaxHeaderListSize(long j) throws Http2Exception {
        if (j < 0 || j > 4294967295L) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Header List Size must be >= %d and <= %d but was %d", 0L, 4294967295L, Long.valueOf(j));
        }
        this.maxHeaderListSize = j;
    }

    public void setMaxHeaderTableSize(ByteBuf byteBuf, long j) throws Http2Exception {
        if (j < 0 || j > 4294967295L) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Header Table Size must be >= %d and <= %d but was %d", 0L, 4294967295L, Long.valueOf(j));
        } else if (this.maxHeaderTableSize != j) {
            this.maxHeaderTableSize = j;
            ensureCapacity(0);
            encodeInteger(byteBuf, 32, 5, j);
        }
    }

    public long size() {
        return this.size;
    }

    public HpackEncoder(boolean z) {
        this(z, 16, 512);
    }

    private static void encodeInteger(ByteBuf byteBuf, int i, int i2, long j) {
        int i3 = 255 >>> (8 - i2);
        long j2 = (long) i3;
        if (j < j2) {
            byteBuf.writeByte((int) (((long) i) | j));
            return;
        }
        byteBuf.writeByte(i | i3);
        long j3 = j - j2;
        while ((-128 & j3) != 0) {
            byteBuf.writeByte((int) ((127 & j3) | 128));
            j3 >>>= 7;
        }
        byteBuf.writeByte((int) j3);
    }

    public HpackEncoder(boolean z, int i, int i2) {
        AsciiString asciiString = AsciiString.EMPTY_STRING;
        HeaderEntry headerEntry = new HeaderEntry(-1, asciiString, asciiString, Integer.MAX_VALUE, (HeaderEntry) null);
        this.head = headerEntry;
        this.hpackHuffmanEncoder = new HpackHuffmanEncoder();
        this.ignoreMaxHeaderListSize = z;
        this.maxHeaderTableSize = 4096;
        this.maxHeaderListSize = 4294967295L;
        HeaderEntry[] headerEntryArr = new HeaderEntry[MathUtil.findNextPositivePowerOfTwo(Math.max(2, Math.min(i, 128)))];
        this.headerFields = headerEntryArr;
        this.hashMask = (byte) (headerEntryArr.length - 1);
        headerEntry.after = headerEntry;
        headerEntry.before = headerEntry;
        this.huffCodeThreshold = i2;
    }

    private int getIndex(int i) {
        if (i == -1) {
            return -1;
        }
        return (i - this.head.before.index) + 1;
    }
}
