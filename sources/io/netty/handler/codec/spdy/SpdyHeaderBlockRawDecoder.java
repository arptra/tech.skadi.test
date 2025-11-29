package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.util.internal.ObjectUtil;

public class SpdyHeaderBlockRawDecoder extends SpdyHeaderBlockDecoder {
    private static final int LENGTH_FIELD_SIZE = 4;
    private ByteBuf cumulation;
    private int headerSize;
    private int length;
    private final int maxHeaderSize;
    private String name;
    private int numHeaders;
    private State state = State.READ_NUM_HEADERS;

    /* renamed from: io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$spdy$SpdyHeaderBlockRawDecoder$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|(3:17|18|20)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder$State[] r0 = io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$netty$handler$codec$spdy$SpdyHeaderBlockRawDecoder$State = r0
                io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder$State r1 = io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder.State.READ_NUM_HEADERS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$netty$handler$codec$spdy$SpdyHeaderBlockRawDecoder$State     // Catch:{ NoSuchFieldError -> 0x001d }
                io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder$State r1 = io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder.State.READ_NAME_LENGTH     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$netty$handler$codec$spdy$SpdyHeaderBlockRawDecoder$State     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder$State r1 = io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder.State.READ_NAME     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$io$netty$handler$codec$spdy$SpdyHeaderBlockRawDecoder$State     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder$State r1 = io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder.State.SKIP_NAME     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$io$netty$handler$codec$spdy$SpdyHeaderBlockRawDecoder$State     // Catch:{ NoSuchFieldError -> 0x003e }
                io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder$State r1 = io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder.State.READ_VALUE_LENGTH     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$io$netty$handler$codec$spdy$SpdyHeaderBlockRawDecoder$State     // Catch:{ NoSuchFieldError -> 0x0049 }
                io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder$State r1 = io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder.State.READ_VALUE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$io$netty$handler$codec$spdy$SpdyHeaderBlockRawDecoder$State     // Catch:{ NoSuchFieldError -> 0x0054 }
                io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder$State r1 = io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder.State.SKIP_VALUE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$io$netty$handler$codec$spdy$SpdyHeaderBlockRawDecoder$State     // Catch:{ NoSuchFieldError -> 0x0060 }
                io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder$State r1 = io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder.State.END_HEADER_BLOCK     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$io$netty$handler$codec$spdy$SpdyHeaderBlockRawDecoder$State     // Catch:{ NoSuchFieldError -> 0x006c }
                io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder$State r1 = io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder.State.ERROR     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder.AnonymousClass1.<clinit>():void");
        }
    }

    public enum State {
        READ_NUM_HEADERS,
        READ_NAME_LENGTH,
        READ_NAME,
        SKIP_NAME,
        READ_VALUE_LENGTH,
        READ_VALUE,
        SKIP_VALUE,
        END_HEADER_BLOCK,
        ERROR
    }

    public SpdyHeaderBlockRawDecoder(SpdyVersion spdyVersion, int i) {
        ObjectUtil.checkNotNull(spdyVersion, "spdyVersion");
        this.maxHeaderSize = i;
    }

    private static int readLengthField(ByteBuf byteBuf) {
        int signedInt = SpdyCodecUtil.getSignedInt(byteBuf, byteBuf.readerIndex());
        byteBuf.skipBytes(4);
        return signedInt;
    }

    private void releaseBuffer() {
        ByteBuf byteBuf = this.cumulation;
        if (byteBuf != null) {
            byteBuf.release();
            this.cumulation = null;
        }
    }

    public void decode(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, SpdyHeadersFrame spdyHeadersFrame) throws Exception {
        ObjectUtil.checkNotNull(byteBuf, "headerBlock");
        ObjectUtil.checkNotNull(spdyHeadersFrame, "frame");
        ByteBuf byteBuf2 = this.cumulation;
        if (byteBuf2 == null) {
            decodeHeaderBlock(byteBuf, spdyHeadersFrame);
            if (byteBuf.isReadable()) {
                ByteBuf buffer = byteBufAllocator.buffer(byteBuf.readableBytes());
                this.cumulation = buffer;
                buffer.writeBytes(byteBuf);
                return;
            }
            return;
        }
        byteBuf2.writeBytes(byteBuf);
        decodeHeaderBlock(this.cumulation, spdyHeadersFrame);
        if (this.cumulation.isReadable()) {
            this.cumulation.discardReadBytes();
        } else {
            releaseBuffer();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0088, code lost:
        r8.state = io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder.State.ERROR;
        r10.setInvalid();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void decodeHeaderBlock(io.netty.buffer.ByteBuf r9, io.netty.handler.codec.spdy.SpdyHeadersFrame r10) throws java.lang.Exception {
        /*
            r8 = this;
        L_0x0000:
            boolean r0 = r9.isReadable()
            if (r0 == 0) goto L_0x01d6
            int[] r0 = io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder.AnonymousClass1.$SwitchMap$io$netty$handler$codec$spdy$SpdyHeaderBlockRawDecoder$State
            io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder$State r1 = r8.state
            int r1 = r1.ordinal()
            r0 = r0[r1]
            java.lang.String r1 = "UTF-8"
            r2 = 4
            r3 = 0
            switch(r0) {
                case 1: goto L_0x01b0;
                case 2: goto L_0x0177;
                case 3: goto L_0x0147;
                case 4: goto L_0x012d;
                case 5: goto L_0x00c9;
                case 6: goto L_0x0055;
                case 7: goto L_0x002f;
                case 8: goto L_0x0027;
                case 9: goto L_0x001f;
                default: goto L_0x0017;
            }
        L_0x0017:
            java.lang.Error r8 = new java.lang.Error
            java.lang.String r9 = "Shouldn't reach here."
            r8.<init>(r9)
            throw r8
        L_0x001f:
            int r8 = r9.readableBytes()
            r9.skipBytes(r8)
            return
        L_0x0027:
            io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder$State r0 = io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder.State.ERROR
            r8.state = r0
            r10.setInvalid()
            goto L_0x0000
        L_0x002f:
            int r0 = r9.readableBytes()
            int r1 = r8.length
            int r0 = java.lang.Math.min(r0, r1)
            r9.skipBytes(r0)
            int r1 = r8.length
            int r1 = r1 - r0
            r8.length = r1
            if (r1 != 0) goto L_0x0000
            int r0 = r8.numHeaders
            int r0 = r0 + -1
            r8.numHeaders = r0
            if (r0 != 0) goto L_0x0050
            io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder$State r0 = io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder.State.END_HEADER_BLOCK
            r8.state = r0
            goto L_0x0000
        L_0x0050:
            io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder$State r0 = io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder.State.READ_NAME_LENGTH
            r8.state = r0
            goto L_0x0000
        L_0x0055:
            int r0 = r9.readableBytes()
            int r2 = r8.length
            if (r0 >= r2) goto L_0x005e
            return
        L_0x005e:
            byte[] r0 = new byte[r2]
            r9.readBytes((byte[]) r0)
            r4 = 0
            byte r5 = r0[r4]
            if (r5 != 0) goto L_0x0070
            io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder$State r0 = io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder.State.ERROR
            r8.state = r0
            r10.setInvalid()
            goto L_0x0000
        L_0x0070:
            r5 = r4
        L_0x0071:
            int r6 = r8.length
            if (r4 >= r6) goto L_0x00ab
        L_0x0075:
            if (r4 >= r2) goto L_0x007e
            byte r6 = r0[r4]
            if (r6 == 0) goto L_0x007e
            int r4 = r4 + 1
            goto L_0x0075
        L_0x007e:
            if (r4 >= r2) goto L_0x0090
            int r6 = r4 + 1
            if (r6 == r2) goto L_0x0088
            byte r6 = r0[r6]
            if (r6 != 0) goto L_0x0090
        L_0x0088:
            io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder$State r0 = io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder.State.ERROR
            r8.state = r0
            r10.setInvalid()
            goto L_0x00ab
        L_0x0090:
            java.lang.String r6 = new java.lang.String
            int r7 = r4 - r5
            r6.<init>(r0, r5, r7, r1)
            io.netty.handler.codec.spdy.SpdyHeaders r5 = r10.headers()     // Catch:{ IllegalArgumentException -> 0x00a4 }
            java.lang.String r7 = r8.name     // Catch:{ IllegalArgumentException -> 0x00a4 }
            r5.add(r7, r6)     // Catch:{ IllegalArgumentException -> 0x00a4 }
            int r5 = r4 + 1
            r4 = r5
            goto L_0x0071
        L_0x00a4:
            io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder$State r0 = io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder.State.ERROR
            r8.state = r0
            r10.setInvalid()
        L_0x00ab:
            r8.name = r3
            io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder$State r0 = r8.state
            io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder$State r1 = io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder.State.ERROR
            if (r0 != r1) goto L_0x00b5
            goto L_0x0000
        L_0x00b5:
            int r0 = r8.numHeaders
            int r0 = r0 + -1
            r8.numHeaders = r0
            if (r0 != 0) goto L_0x00c3
            io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder$State r0 = io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder.State.END_HEADER_BLOCK
            r8.state = r0
            goto L_0x0000
        L_0x00c3:
            io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder$State r0 = io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder.State.READ_NAME_LENGTH
            r8.state = r0
            goto L_0x0000
        L_0x00c9:
            int r0 = r9.readableBytes()
            if (r0 >= r2) goto L_0x00d0
            return
        L_0x00d0:
            int r0 = readLengthField(r9)
            r8.length = r0
            if (r0 >= 0) goto L_0x00e1
            io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder$State r0 = io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder.State.ERROR
            r8.state = r0
            r10.setInvalid()
            goto L_0x0000
        L_0x00e1:
            if (r0 != 0) goto L_0x010a
            boolean r0 = r10.isTruncated()
            if (r0 != 0) goto L_0x00f4
            io.netty.handler.codec.spdy.SpdyHeaders r0 = r10.headers()
            java.lang.String r1 = r8.name
            java.lang.String r2 = ""
            r0.add(r1, r2)
        L_0x00f4:
            r8.name = r3
            int r0 = r8.numHeaders
            int r0 = r0 + -1
            r8.numHeaders = r0
            if (r0 != 0) goto L_0x0104
            io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder$State r0 = io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder.State.END_HEADER_BLOCK
            r8.state = r0
            goto L_0x0000
        L_0x0104:
            io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder$State r0 = io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder.State.READ_NAME_LENGTH
            r8.state = r0
            goto L_0x0000
        L_0x010a:
            int r1 = r8.maxHeaderSize
            if (r0 > r1) goto L_0x011e
            int r2 = r8.headerSize
            int r4 = r1 - r0
            if (r2 <= r4) goto L_0x0115
            goto L_0x011e
        L_0x0115:
            int r2 = r2 + r0
            r8.headerSize = r2
            io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder$State r0 = io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder.State.READ_VALUE
            r8.state = r0
            goto L_0x0000
        L_0x011e:
            int r1 = r1 + 1
            r8.headerSize = r1
            r8.name = r3
            io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder$State r0 = io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder.State.SKIP_VALUE
            r8.state = r0
            r10.setTruncated()
            goto L_0x0000
        L_0x012d:
            int r0 = r9.readableBytes()
            int r1 = r8.length
            int r0 = java.lang.Math.min(r0, r1)
            r9.skipBytes(r0)
            int r1 = r8.length
            int r1 = r1 - r0
            r8.length = r1
            if (r1 != 0) goto L_0x0000
            io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder$State r0 = io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder.State.READ_VALUE_LENGTH
            r8.state = r0
            goto L_0x0000
        L_0x0147:
            int r0 = r9.readableBytes()
            int r2 = r8.length
            if (r0 >= r2) goto L_0x0150
            return
        L_0x0150:
            byte[] r0 = new byte[r2]
            r9.readBytes((byte[]) r0)
            java.lang.String r2 = new java.lang.String
            r2.<init>(r0, r1)
            r8.name = r2
            io.netty.handler.codec.spdy.SpdyHeaders r0 = r10.headers()
            java.lang.String r1 = r8.name
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x0171
            io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder$State r0 = io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder.State.ERROR
            r8.state = r0
            r10.setInvalid()
            goto L_0x0000
        L_0x0171:
            io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder$State r0 = io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder.State.READ_VALUE_LENGTH
            r8.state = r0
            goto L_0x0000
        L_0x0177:
            int r0 = r9.readableBytes()
            if (r0 >= r2) goto L_0x017e
            return
        L_0x017e:
            int r0 = readLengthField(r9)
            r8.length = r0
            if (r0 > 0) goto L_0x018f
            io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder$State r0 = io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder.State.ERROR
            r8.state = r0
            r10.setInvalid()
            goto L_0x0000
        L_0x018f:
            int r1 = r8.maxHeaderSize
            if (r0 > r1) goto L_0x01a3
            int r2 = r8.headerSize
            int r3 = r1 - r0
            if (r2 <= r3) goto L_0x019a
            goto L_0x01a3
        L_0x019a:
            int r2 = r2 + r0
            r8.headerSize = r2
            io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder$State r0 = io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder.State.READ_NAME
            r8.state = r0
            goto L_0x0000
        L_0x01a3:
            int r1 = r1 + 1
            r8.headerSize = r1
            io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder$State r0 = io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder.State.SKIP_NAME
            r8.state = r0
            r10.setTruncated()
            goto L_0x0000
        L_0x01b0:
            int r0 = r9.readableBytes()
            if (r0 >= r2) goto L_0x01b7
            return
        L_0x01b7:
            int r0 = readLengthField(r9)
            r8.numHeaders = r0
            if (r0 >= 0) goto L_0x01c8
            io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder$State r0 = io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder.State.ERROR
            r8.state = r0
            r10.setInvalid()
            goto L_0x0000
        L_0x01c8:
            if (r0 != 0) goto L_0x01d0
            io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder$State r0 = io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder.State.END_HEADER_BLOCK
            r8.state = r0
            goto L_0x0000
        L_0x01d0:
            io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder$State r0 = io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder.State.READ_NAME_LENGTH
            r8.state = r0
            goto L_0x0000
        L_0x01d6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder.decodeHeaderBlock(io.netty.buffer.ByteBuf, io.netty.handler.codec.spdy.SpdyHeadersFrame):void");
    }

    public void end() {
        releaseBuffer();
    }

    public void endHeaderBlock(SpdyHeadersFrame spdyHeadersFrame) throws Exception {
        if (this.state != State.END_HEADER_BLOCK) {
            spdyHeadersFrame.setInvalid();
        }
        releaseBuffer();
        this.headerSize = 0;
        this.name = null;
        this.state = State.READ_NUM_HEADERS;
    }
}
