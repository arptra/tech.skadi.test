package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public class JdkZlibDecoder extends ZlibDecoder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int FCOMMENT = 16;
    private static final int FEXTRA = 4;
    private static final int FHCRC = 2;
    private static final int FNAME = 8;
    private static final int FRESERVED = 224;
    private final ByteBufChecksum crc;
    private boolean decideZlibOrNone;
    private final boolean decompressConcatenated;
    private final byte[] dictionary;
    private volatile boolean finished;
    private int flags;
    private GzipState gzipState;
    private Inflater inflater;
    private int xlen;

    /* renamed from: io.netty.handler.codec.compression.JdkZlibDecoder$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper;

        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|(2:19|20)|21|23|24|25|26|27|28|(3:29|30|32)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|(2:19|20)|21|23|24|25|26|27|28|(3:29|30|32)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|21|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0065 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0079 */
        static {
            /*
                io.netty.handler.codec.compression.JdkZlibDecoder$GzipState[] r0 = io.netty.handler.codec.compression.JdkZlibDecoder.GzipState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState = r0
                r1 = 1
                io.netty.handler.codec.compression.JdkZlibDecoder$GzipState r2 = io.netty.handler.codec.compression.JdkZlibDecoder.GzipState.HEADER_START     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState     // Catch:{ NoSuchFieldError -> 0x001d }
                io.netty.handler.codec.compression.JdkZlibDecoder$GzipState r3 = io.netty.handler.codec.compression.JdkZlibDecoder.GzipState.FLG_READ     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.netty.handler.codec.compression.JdkZlibDecoder$GzipState r4 = io.netty.handler.codec.compression.JdkZlibDecoder.GzipState.XLEN_READ     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = $SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.netty.handler.codec.compression.JdkZlibDecoder$GzipState r5 = io.netty.handler.codec.compression.JdkZlibDecoder.GzipState.SKIP_FNAME     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r4 = $SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState     // Catch:{ NoSuchFieldError -> 0x003e }
                io.netty.handler.codec.compression.JdkZlibDecoder$GzipState r5 = io.netty.handler.codec.compression.JdkZlibDecoder.GzipState.SKIP_COMMENT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r6 = 5
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r4 = $SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState     // Catch:{ NoSuchFieldError -> 0x0049 }
                io.netty.handler.codec.compression.JdkZlibDecoder$GzipState r5 = io.netty.handler.codec.compression.JdkZlibDecoder.GzipState.PROCESS_FHCRC     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r6 = 6
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r4 = $SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState     // Catch:{ NoSuchFieldError -> 0x0054 }
                io.netty.handler.codec.compression.JdkZlibDecoder$GzipState r5 = io.netty.handler.codec.compression.JdkZlibDecoder.GzipState.HEADER_END     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r6 = 7
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                io.netty.handler.codec.compression.ZlibWrapper[] r4 = io.netty.handler.codec.compression.ZlibWrapper.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper = r4
                io.netty.handler.codec.compression.ZlibWrapper r5 = io.netty.handler.codec.compression.ZlibWrapper.GZIP     // Catch:{ NoSuchFieldError -> 0x0065 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0065 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0065 }
            L_0x0065:
                int[] r1 = $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper     // Catch:{ NoSuchFieldError -> 0x006f }
                io.netty.handler.codec.compression.ZlibWrapper r4 = io.netty.handler.codec.compression.ZlibWrapper.NONE     // Catch:{ NoSuchFieldError -> 0x006f }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x006f }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x006f }
            L_0x006f:
                int[] r0 = $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper     // Catch:{ NoSuchFieldError -> 0x0079 }
                io.netty.handler.codec.compression.ZlibWrapper r1 = io.netty.handler.codec.compression.ZlibWrapper.ZLIB     // Catch:{ NoSuchFieldError -> 0x0079 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0079 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0079 }
            L_0x0079:
                int[] r0 = $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper     // Catch:{ NoSuchFieldError -> 0x0083 }
                io.netty.handler.codec.compression.ZlibWrapper r1 = io.netty.handler.codec.compression.ZlibWrapper.ZLIB_OR_NONE     // Catch:{ NoSuchFieldError -> 0x0083 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0083 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0083 }
            L_0x0083:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.JdkZlibDecoder.AnonymousClass1.<clinit>():void");
        }
    }

    public enum GzipState {
        HEADER_START,
        HEADER_END,
        FLG_READ,
        XLEN_READ,
        SKIP_FNAME,
        SKIP_COMMENT,
        PROCESS_FHCRC,
        FOOTER_START
    }

    public JdkZlibDecoder() {
        this(ZlibWrapper.ZLIB, (byte[]) null, false, 0);
    }

    private boolean handleGzipFooter(ByteBuf byteBuf) {
        if (!readGZIPFooter(byteBuf)) {
            return false;
        }
        this.finished = !this.decompressConcatenated;
        if (this.finished) {
            return false;
        }
        this.inflater.reset();
        this.crc.reset();
        this.gzipState = GzipState.HEADER_START;
        return true;
    }

    private static boolean looksLikeZlib(short s) {
        return (s & 30720) == 30720 && s % 31 == 0;
    }

    private boolean readGZIPFooter(ByteBuf byteBuf) {
        if (byteBuf.readableBytes() < 8) {
            return false;
        }
        verifyCrc(byteBuf);
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            i |= byteBuf.readUnsignedByte() << (i2 * 8);
        }
        int totalOut = this.inflater.getTotalOut();
        if (i == totalOut) {
            return true;
        }
        throw new DecompressionException("Number of bytes mismatch. Expected: " + i + ", Got: " + totalOut);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0078, code lost:
        if ((r7.flags & 4) == 0) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x007e, code lost:
        if (r8.readableBytes() >= 2) goto L_0x0081;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0080, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0081, code lost:
        r0 = r8.readUnsignedByte();
        r2 = r8.readUnsignedByte();
        r7.crc.update(r0);
        r7.crc.update(r2);
        r7.xlen = ((r0 << 8) | r2) | r7.xlen;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x009a, code lost:
        r7.gzipState = io.netty.handler.codec.compression.JdkZlibDecoder.GzipState.XLEN_READ;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00a1, code lost:
        if (r7.xlen == -1) goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00a9, code lost:
        if (r8.readableBytes() >= r7.xlen) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00ab, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00ac, code lost:
        r7.crc.update(r8, r8.readerIndex(), r7.xlen);
        r8.skipBytes(r7.xlen);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00bc, code lost:
        r7.gzipState = io.netty.handler.codec.compression.JdkZlibDecoder.GzipState.SKIP_FNAME;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00c4, code lost:
        if (skipIfNeeded(r8, 8) != false) goto L_0x00c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00c6, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00c7, code lost:
        r7.gzipState = io.netty.handler.codec.compression.JdkZlibDecoder.GzipState.SKIP_COMMENT;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00d1, code lost:
        if (skipIfNeeded(r8, 16) != false) goto L_0x00d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00d3, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00d4, code lost:
        r7.gzipState = io.netty.handler.codec.compression.JdkZlibDecoder.GzipState.PROCESS_FHCRC;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00db, code lost:
        if ((r7.flags & 2) == 0) goto L_0x00e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00e1, code lost:
        if (verifyCrc16(r8) != false) goto L_0x00e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00e3, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00e4, code lost:
        r7.crc.reset();
        r7.gzipState = io.netty.handler.codec.compression.JdkZlibDecoder.GzipState.HEADER_END;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean readGZIPHeader(io.netty.buffer.ByteBuf r8) {
        /*
            r7 = this;
            int[] r0 = io.netty.handler.codec.compression.JdkZlibDecoder.AnonymousClass1.$SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState
            io.netty.handler.codec.compression.JdkZlibDecoder$GzipState r1 = r7.gzipState
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 2
            r2 = 4
            r3 = 8
            r4 = 0
            switch(r0) {
                case 1: goto L_0x0018;
                case 2: goto L_0x0075;
                case 3: goto L_0x009e;
                case 4: goto L_0x00c0;
                case 5: goto L_0x00cb;
                case 6: goto L_0x00d8;
                case 7: goto L_0x00ed;
                default: goto L_0x0012;
            }
        L_0x0012:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            r7.<init>()
            throw r7
        L_0x0018:
            int r0 = r8.readableBytes()
            r5 = 10
            if (r0 >= r5) goto L_0x0021
            return r4
        L_0x0021:
            byte r0 = r8.readByte()
            byte r5 = r8.readByte()
            r6 = 31
            if (r0 != r6) goto L_0x0113
            io.netty.handler.codec.compression.ByteBufChecksum r6 = r7.crc
            r6.update(r0)
            io.netty.handler.codec.compression.ByteBufChecksum r0 = r7.crc
            r0.update(r5)
            short r0 = r8.readUnsignedByte()
            if (r0 != r3) goto L_0x00f7
            io.netty.handler.codec.compression.ByteBufChecksum r5 = r7.crc
            r5.update(r0)
            short r0 = r8.readUnsignedByte()
            r7.flags = r0
            io.netty.handler.codec.compression.ByteBufChecksum r5 = r7.crc
            r5.update(r0)
            int r0 = r7.flags
            r0 = r0 & 224(0xe0, float:3.14E-43)
            if (r0 != 0) goto L_0x00ef
            io.netty.handler.codec.compression.ByteBufChecksum r0 = r7.crc
            int r5 = r8.readerIndex()
            r0.update(r8, r5, r2)
            r8.skipBytes(r2)
            io.netty.handler.codec.compression.ByteBufChecksum r0 = r7.crc
            short r5 = r8.readUnsignedByte()
            r0.update(r5)
            io.netty.handler.codec.compression.ByteBufChecksum r0 = r7.crc
            short r5 = r8.readUnsignedByte()
            r0.update(r5)
            io.netty.handler.codec.compression.JdkZlibDecoder$GzipState r0 = io.netty.handler.codec.compression.JdkZlibDecoder.GzipState.FLG_READ
            r7.gzipState = r0
        L_0x0075:
            int r0 = r7.flags
            r0 = r0 & r2
            if (r0 == 0) goto L_0x009a
            int r0 = r8.readableBytes()
            if (r0 >= r1) goto L_0x0081
            return r4
        L_0x0081:
            short r0 = r8.readUnsignedByte()
            short r2 = r8.readUnsignedByte()
            io.netty.handler.codec.compression.ByteBufChecksum r5 = r7.crc
            r5.update(r0)
            io.netty.handler.codec.compression.ByteBufChecksum r5 = r7.crc
            r5.update(r2)
            int r5 = r7.xlen
            int r0 = r0 << r3
            r0 = r0 | r2
            r0 = r0 | r5
            r7.xlen = r0
        L_0x009a:
            io.netty.handler.codec.compression.JdkZlibDecoder$GzipState r0 = io.netty.handler.codec.compression.JdkZlibDecoder.GzipState.XLEN_READ
            r7.gzipState = r0
        L_0x009e:
            int r0 = r7.xlen
            r2 = -1
            if (r0 == r2) goto L_0x00bc
            int r0 = r8.readableBytes()
            int r2 = r7.xlen
            if (r0 >= r2) goto L_0x00ac
            return r4
        L_0x00ac:
            io.netty.handler.codec.compression.ByteBufChecksum r0 = r7.crc
            int r2 = r8.readerIndex()
            int r5 = r7.xlen
            r0.update(r8, r2, r5)
            int r0 = r7.xlen
            r8.skipBytes(r0)
        L_0x00bc:
            io.netty.handler.codec.compression.JdkZlibDecoder$GzipState r0 = io.netty.handler.codec.compression.JdkZlibDecoder.GzipState.SKIP_FNAME
            r7.gzipState = r0
        L_0x00c0:
            boolean r0 = r7.skipIfNeeded(r8, r3)
            if (r0 != 0) goto L_0x00c7
            return r4
        L_0x00c7:
            io.netty.handler.codec.compression.JdkZlibDecoder$GzipState r0 = io.netty.handler.codec.compression.JdkZlibDecoder.GzipState.SKIP_COMMENT
            r7.gzipState = r0
        L_0x00cb:
            r0 = 16
            boolean r0 = r7.skipIfNeeded(r8, r0)
            if (r0 != 0) goto L_0x00d4
            return r4
        L_0x00d4:
            io.netty.handler.codec.compression.JdkZlibDecoder$GzipState r0 = io.netty.handler.codec.compression.JdkZlibDecoder.GzipState.PROCESS_FHCRC
            r7.gzipState = r0
        L_0x00d8:
            int r0 = r7.flags
            r0 = r0 & r1
            if (r0 == 0) goto L_0x00e4
            boolean r8 = r7.verifyCrc16(r8)
            if (r8 != 0) goto L_0x00e4
            return r4
        L_0x00e4:
            io.netty.handler.codec.compression.ByteBufChecksum r8 = r7.crc
            r8.reset()
            io.netty.handler.codec.compression.JdkZlibDecoder$GzipState r8 = io.netty.handler.codec.compression.JdkZlibDecoder.GzipState.HEADER_END
            r7.gzipState = r8
        L_0x00ed:
            r7 = 1
            return r7
        L_0x00ef:
            io.netty.handler.codec.compression.DecompressionException r7 = new io.netty.handler.codec.compression.DecompressionException
            java.lang.String r8 = "Reserved flags are set in the GZIP header"
            r7.<init>((java.lang.String) r8)
            throw r7
        L_0x00f7:
            io.netty.handler.codec.compression.DecompressionException r7 = new io.netty.handler.codec.compression.DecompressionException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "Unsupported compression method "
            r8.append(r1)
            r8.append(r0)
            java.lang.String r0 = " in the GZIP header"
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            r7.<init>((java.lang.String) r8)
            throw r7
        L_0x0113:
            io.netty.handler.codec.compression.DecompressionException r7 = new io.netty.handler.codec.compression.DecompressionException
            java.lang.String r8 = "Input is not in the GZIP format"
            r7.<init>((java.lang.String) r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.JdkZlibDecoder.readGZIPHeader(io.netty.buffer.ByteBuf):boolean");
    }

    private boolean skipIfNeeded(ByteBuf byteBuf, int i) {
        if ((i & this.flags) == 0) {
            return true;
        }
        while (byteBuf.isReadable()) {
            short readUnsignedByte = byteBuf.readUnsignedByte();
            this.crc.update(readUnsignedByte);
            if (readUnsignedByte == 0) {
                return true;
            }
        }
        return false;
    }

    private boolean verifyCrc(ByteBuf byteBuf) {
        if (byteBuf.readableBytes() < 4) {
            return false;
        }
        long j = 0;
        for (int i = 0; i < 4; i++) {
            j |= ((long) byteBuf.readUnsignedByte()) << (i * 8);
        }
        long value = this.crc.getValue();
        if (j == value) {
            return true;
        }
        throw new DecompressionException("CRC value mismatch. Expected: " + j + ", Got: " + value);
    }

    private boolean verifyCrc16(ByteBuf byteBuf) {
        if (byteBuf.readableBytes() < 2) {
            return false;
        }
        long value = this.crc.getValue();
        long j = 0;
        long j2 = 0;
        for (int i = 0; i < 2; i++) {
            int i2 = i * 8;
            j |= ((long) byteBuf.readUnsignedByte()) << i2;
            j2 |= ((value >> i2) & 255) << i2;
        }
        if (j == j2) {
            return true;
        }
        throw new DecompressionException("CRC16 value mismatch. Expected: " + j + ", Got: " + j2);
    }

    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        GzipState gzipState2;
        if (this.finished) {
            byteBuf.skipBytes(byteBuf.readableBytes());
            return;
        }
        int readableBytes = byteBuf.readableBytes();
        if (readableBytes != 0) {
            boolean z = false;
            if (this.decideZlibOrNone) {
                if (readableBytes >= 2) {
                    this.inflater = new Inflater(!looksLikeZlib(byteBuf.getShort(byteBuf.readerIndex())));
                    this.decideZlibOrNone = false;
                } else {
                    return;
                }
            }
            if (this.crc == null || (gzipState2 = this.gzipState) == GzipState.HEADER_END || ((gzipState2 != GzipState.FOOTER_START || handleGzipFooter(byteBuf)) && readGZIPHeader(byteBuf) && (readableBytes = byteBuf.readableBytes()) != 0)) {
                if (this.inflater.needsInput()) {
                    if (byteBuf.hasArray()) {
                        this.inflater.setInput(byteBuf.array(), byteBuf.arrayOffset() + byteBuf.readerIndex(), readableBytes);
                    } else {
                        byte[] bArr = new byte[readableBytes];
                        byteBuf.getBytes(byteBuf.readerIndex(), bArr);
                        this.inflater.setInput(bArr);
                    }
                }
                ByteBuf prepareDecompressBuffer = prepareDecompressBuffer(channelHandlerContext, (ByteBuf) null, this.inflater.getRemaining() << 1);
                while (true) {
                    try {
                        if (this.inflater.needsInput()) {
                            break;
                        }
                        byte[] array = prepareDecompressBuffer.array();
                        int writerIndex = prepareDecompressBuffer.writerIndex();
                        int arrayOffset = prepareDecompressBuffer.arrayOffset() + writerIndex;
                        int inflate = this.inflater.inflate(array, arrayOffset, prepareDecompressBuffer.writableBytes());
                        if (inflate > 0) {
                            prepareDecompressBuffer.writerIndex(writerIndex + inflate);
                            ByteBufChecksum byteBufChecksum = this.crc;
                            if (byteBufChecksum != null) {
                                byteBufChecksum.update(array, arrayOffset, inflate);
                            }
                        } else if (this.inflater.needsDictionary()) {
                            byte[] bArr2 = this.dictionary;
                            if (bArr2 != null) {
                                this.inflater.setDictionary(bArr2);
                            } else {
                                throw new DecompressionException("decompression failure, unable to set dictionary as non was specified");
                            }
                        }
                        if (!this.inflater.finished()) {
                            prepareDecompressBuffer = prepareDecompressBuffer(channelHandlerContext, prepareDecompressBuffer, this.inflater.getRemaining() << 1);
                        } else if (this.crc == null) {
                            this.finished = true;
                        } else {
                            z = true;
                        }
                    } catch (DataFormatException e) {
                        throw new DecompressionException("decompression failure", e);
                    } catch (Throwable th) {
                        if (prepareDecompressBuffer.isReadable()) {
                            list.add(prepareDecompressBuffer);
                        } else {
                            prepareDecompressBuffer.release();
                        }
                        throw th;
                    }
                }
                byteBuf.skipBytes(readableBytes - this.inflater.getRemaining());
                if (z) {
                    this.gzipState = GzipState.FOOTER_START;
                    handleGzipFooter(byteBuf);
                }
                if (prepareDecompressBuffer.isReadable()) {
                    list.add(prepareDecompressBuffer);
                } else {
                    prepareDecompressBuffer.release();
                }
            }
        }
    }

    public void decompressionBufferExhausted(ByteBuf byteBuf) {
        this.finished = true;
    }

    public void handlerRemoved0(ChannelHandlerContext channelHandlerContext) throws Exception {
        super.handlerRemoved0(channelHandlerContext);
        Inflater inflater2 = this.inflater;
        if (inflater2 != null) {
            inflater2.end();
        }
    }

    public boolean isClosed() {
        return this.finished;
    }

    public JdkZlibDecoder(int i) {
        this(ZlibWrapper.ZLIB, (byte[]) null, false, i);
    }

    public JdkZlibDecoder(byte[] bArr) {
        this(ZlibWrapper.ZLIB, bArr, false, 0);
    }

    public JdkZlibDecoder(byte[] bArr, int i) {
        this(ZlibWrapper.ZLIB, bArr, false, i);
    }

    public JdkZlibDecoder(ZlibWrapper zlibWrapper) {
        this(zlibWrapper, (byte[]) null, false, 0);
    }

    public JdkZlibDecoder(ZlibWrapper zlibWrapper, int i) {
        this(zlibWrapper, (byte[]) null, false, i);
    }

    public JdkZlibDecoder(ZlibWrapper zlibWrapper, boolean z) {
        this(zlibWrapper, (byte[]) null, z, 0);
    }

    public JdkZlibDecoder(ZlibWrapper zlibWrapper, boolean z, int i) {
        this(zlibWrapper, (byte[]) null, z, i);
    }

    public JdkZlibDecoder(boolean z) {
        this(ZlibWrapper.GZIP, (byte[]) null, z, 0);
    }

    public JdkZlibDecoder(boolean z, int i) {
        this(ZlibWrapper.GZIP, (byte[]) null, z, i);
    }

    private JdkZlibDecoder(ZlibWrapper zlibWrapper, byte[] bArr, boolean z, int i) {
        super(i);
        this.gzipState = GzipState.HEADER_START;
        this.flags = -1;
        this.xlen = -1;
        ObjectUtil.checkNotNull(zlibWrapper, "wrapper");
        this.decompressConcatenated = z;
        int i2 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[zlibWrapper.ordinal()];
        if (i2 == 1) {
            this.inflater = new Inflater(true);
            this.crc = ByteBufChecksum.wrapChecksum(new CRC32());
        } else if (i2 == 2) {
            this.inflater = new Inflater(true);
            this.crc = null;
        } else if (i2 == 3) {
            this.inflater = new Inflater();
            this.crc = null;
        } else if (i2 == 4) {
            this.decideZlibOrNone = true;
            this.crc = null;
        } else {
            throw new IllegalArgumentException("Only GZIP or ZLIB is supported, but you used " + zlibWrapper);
        }
        this.dictionary = bArr;
    }
}
