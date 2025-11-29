package io.netty.handler.codec.spdy;

import io.netty.util.internal.ObjectUtil;

public class SpdyFrameDecoder {
    private final SpdyFrameDecoderDelegate delegate;
    private byte flags;
    private int length;
    private final int maxChunkSize;
    private int numSettings;
    private final int spdyVersion;
    private State state;
    private int streamId;

    /* renamed from: io.netty.handler.codec.spdy.SpdyFrameDecoder$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|(3:27|28|30)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|30) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                io.netty.handler.codec.spdy.SpdyFrameDecoder$State[] r0 = io.netty.handler.codec.spdy.SpdyFrameDecoder.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State = r0
                io.netty.handler.codec.spdy.SpdyFrameDecoder$State r1 = io.netty.handler.codec.spdy.SpdyFrameDecoder.State.READ_COMMON_HEADER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State     // Catch:{ NoSuchFieldError -> 0x001d }
                io.netty.handler.codec.spdy.SpdyFrameDecoder$State r1 = io.netty.handler.codec.spdy.SpdyFrameDecoder.State.READ_DATA_FRAME     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.netty.handler.codec.spdy.SpdyFrameDecoder$State r1 = io.netty.handler.codec.spdy.SpdyFrameDecoder.State.READ_SYN_STREAM_FRAME     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.netty.handler.codec.spdy.SpdyFrameDecoder$State r1 = io.netty.handler.codec.spdy.SpdyFrameDecoder.State.READ_SYN_REPLY_FRAME     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State     // Catch:{ NoSuchFieldError -> 0x003e }
                io.netty.handler.codec.spdy.SpdyFrameDecoder$State r1 = io.netty.handler.codec.spdy.SpdyFrameDecoder.State.READ_RST_STREAM_FRAME     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State     // Catch:{ NoSuchFieldError -> 0x0049 }
                io.netty.handler.codec.spdy.SpdyFrameDecoder$State r1 = io.netty.handler.codec.spdy.SpdyFrameDecoder.State.READ_SETTINGS_FRAME     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State     // Catch:{ NoSuchFieldError -> 0x0054 }
                io.netty.handler.codec.spdy.SpdyFrameDecoder$State r1 = io.netty.handler.codec.spdy.SpdyFrameDecoder.State.READ_SETTING     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State     // Catch:{ NoSuchFieldError -> 0x0060 }
                io.netty.handler.codec.spdy.SpdyFrameDecoder$State r1 = io.netty.handler.codec.spdy.SpdyFrameDecoder.State.READ_PING_FRAME     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State     // Catch:{ NoSuchFieldError -> 0x006c }
                io.netty.handler.codec.spdy.SpdyFrameDecoder$State r1 = io.netty.handler.codec.spdy.SpdyFrameDecoder.State.READ_GOAWAY_FRAME     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State     // Catch:{ NoSuchFieldError -> 0x0078 }
                io.netty.handler.codec.spdy.SpdyFrameDecoder$State r1 = io.netty.handler.codec.spdy.SpdyFrameDecoder.State.READ_HEADERS_FRAME     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State     // Catch:{ NoSuchFieldError -> 0x0084 }
                io.netty.handler.codec.spdy.SpdyFrameDecoder$State r1 = io.netty.handler.codec.spdy.SpdyFrameDecoder.State.READ_WINDOW_UPDATE_FRAME     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State     // Catch:{ NoSuchFieldError -> 0x0090 }
                io.netty.handler.codec.spdy.SpdyFrameDecoder$State r1 = io.netty.handler.codec.spdy.SpdyFrameDecoder.State.READ_HEADER_BLOCK     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State     // Catch:{ NoSuchFieldError -> 0x009c }
                io.netty.handler.codec.spdy.SpdyFrameDecoder$State r1 = io.netty.handler.codec.spdy.SpdyFrameDecoder.State.DISCARD_FRAME     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State     // Catch:{ NoSuchFieldError -> 0x00a8 }
                io.netty.handler.codec.spdy.SpdyFrameDecoder$State r1 = io.netty.handler.codec.spdy.SpdyFrameDecoder.State.FRAME_ERROR     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.spdy.SpdyFrameDecoder.AnonymousClass1.<clinit>():void");
        }
    }

    public enum State {
        READ_COMMON_HEADER,
        READ_DATA_FRAME,
        READ_SYN_STREAM_FRAME,
        READ_SYN_REPLY_FRAME,
        READ_RST_STREAM_FRAME,
        READ_SETTINGS_FRAME,
        READ_SETTING,
        READ_PING_FRAME,
        READ_GOAWAY_FRAME,
        READ_HEADERS_FRAME,
        READ_WINDOW_UPDATE_FRAME,
        READ_HEADER_BLOCK,
        DISCARD_FRAME,
        FRAME_ERROR
    }

    public SpdyFrameDecoder(SpdyVersion spdyVersion2, SpdyFrameDecoderDelegate spdyFrameDecoderDelegate) {
        this(spdyVersion2, spdyFrameDecoderDelegate, 8192);
    }

    private static State getNextState(int i, int i2) {
        switch (i) {
            case 0:
                return State.READ_DATA_FRAME;
            case 1:
                return State.READ_SYN_STREAM_FRAME;
            case 2:
                return State.READ_SYN_REPLY_FRAME;
            case 3:
                return State.READ_RST_STREAM_FRAME;
            case 4:
                return State.READ_SETTINGS_FRAME;
            case 6:
                return State.READ_PING_FRAME;
            case 7:
                return State.READ_GOAWAY_FRAME;
            case 8:
                return State.READ_HEADERS_FRAME;
            case 9:
                return State.READ_WINDOW_UPDATE_FRAME;
            default:
                return i2 != 0 ? State.DISCARD_FRAME : State.READ_COMMON_HEADER;
        }
    }

    private static boolean hasFlag(byte b, byte b2) {
        return (b & b2) != 0;
    }

    private static boolean isValidFrameHeader(int i, int i2, byte b, int i3) {
        switch (i2) {
            case 0:
                return i != 0;
            case 1:
                return i3 >= 10;
            case 2:
                return i3 >= 4;
            case 3:
                return b == 0 && i3 == 8;
            case 4:
                return i3 >= 4;
            case 6:
                return i3 == 4;
            case 7:
                return i3 == 8;
            case 8:
                return i3 >= 4;
            case 9:
                return i3 == 8;
            default:
                return true;
        }
    }

    /* JADX WARNING: type inference failed for: r0v15, types: [int] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void decode(io.netty.buffer.ByteBuf r13) {
        /*
            r12 = this;
        L_0x0000:
            int[] r0 = io.netty.handler.codec.spdy.SpdyFrameDecoder.AnonymousClass1.$SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State
            io.netty.handler.codec.spdy.SpdyFrameDecoder$State r1 = r12.state
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 2
            r2 = 0
            r3 = 1
            r4 = 8
            r5 = 4
            switch(r0) {
                case 1: goto L_0x02ce;
                case 2: goto L_0x027c;
                case 3: goto L_0x0229;
                case 4: goto L_0x01ee;
                case 5: goto L_0x01b2;
                case 6: goto L_0x0170;
                case 7: goto L_0x0129;
                case 8: goto L_0x010c;
                case 9: goto L_0x00e6;
                case 10: goto L_0x00ab;
                case 11: goto L_0x0072;
                case 12: goto L_0x003d;
                case 13: goto L_0x0023;
                case 14: goto L_0x001b;
                default: goto L_0x0013;
            }
        L_0x0013:
            java.lang.Error r12 = new java.lang.Error
            java.lang.String r13 = "Shouldn't reach here."
            r12.<init>(r13)
            throw r12
        L_0x001b:
            int r12 = r13.readableBytes()
            r13.skipBytes(r12)
            return
        L_0x0023:
            int r0 = r13.readableBytes()
            int r1 = r12.length
            int r0 = java.lang.Math.min(r0, r1)
            r13.skipBytes(r0)
            int r1 = r12.length
            int r1 = r1 - r0
            r12.length = r1
            if (r1 != 0) goto L_0x003c
            io.netty.handler.codec.spdy.SpdyFrameDecoder$State r0 = io.netty.handler.codec.spdy.SpdyFrameDecoder.State.READ_COMMON_HEADER
            r12.state = r0
            goto L_0x0000
        L_0x003c:
            return
        L_0x003d:
            int r0 = r12.length
            if (r0 != 0) goto L_0x004b
            io.netty.handler.codec.spdy.SpdyFrameDecoder$State r0 = io.netty.handler.codec.spdy.SpdyFrameDecoder.State.READ_COMMON_HEADER
            r12.state = r0
            io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate r0 = r12.delegate
            r0.readHeaderBlockEnd()
            goto L_0x0000
        L_0x004b:
            boolean r0 = r13.isReadable()
            if (r0 != 0) goto L_0x0052
            return
        L_0x0052:
            int r0 = r13.readableBytes()
            int r1 = r12.length
            int r0 = java.lang.Math.min(r0, r1)
            io.netty.buffer.ByteBufAllocator r1 = r13.alloc()
            io.netty.buffer.ByteBuf r1 = r1.buffer(r0)
            r1.writeBytes((io.netty.buffer.ByteBuf) r13, (int) r0)
            int r2 = r12.length
            int r2 = r2 - r0
            r12.length = r2
            io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate r0 = r12.delegate
            r0.readHeaderBlock(r1)
            goto L_0x0000
        L_0x0072:
            int r0 = r13.readableBytes()
            if (r0 >= r4) goto L_0x0079
            return
        L_0x0079:
            int r0 = r13.readerIndex()
            int r0 = io.netty.handler.codec.spdy.SpdyCodecUtil.getUnsignedInt(r13, r0)
            r12.streamId = r0
            int r0 = r13.readerIndex()
            int r0 = r0 + r5
            int r0 = io.netty.handler.codec.spdy.SpdyCodecUtil.getUnsignedInt(r13, r0)
            r13.skipBytes(r4)
            if (r0 != 0) goto L_0x009e
            io.netty.handler.codec.spdy.SpdyFrameDecoder$State r0 = io.netty.handler.codec.spdy.SpdyFrameDecoder.State.FRAME_ERROR
            r12.state = r0
            io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate r0 = r12.delegate
            java.lang.String r1 = "Invalid WINDOW_UPDATE Frame"
            r0.readFrameError(r1)
            goto L_0x0000
        L_0x009e:
            io.netty.handler.codec.spdy.SpdyFrameDecoder$State r1 = io.netty.handler.codec.spdy.SpdyFrameDecoder.State.READ_COMMON_HEADER
            r12.state = r1
            io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate r1 = r12.delegate
            int r2 = r12.streamId
            r1.readWindowUpdateFrame(r2, r0)
            goto L_0x0000
        L_0x00ab:
            int r0 = r13.readableBytes()
            if (r0 >= r5) goto L_0x00b2
            return
        L_0x00b2:
            int r0 = r13.readerIndex()
            int r0 = io.netty.handler.codec.spdy.SpdyCodecUtil.getUnsignedInt(r13, r0)
            r12.streamId = r0
            byte r0 = r12.flags
            boolean r0 = hasFlag(r0, r3)
            r13.skipBytes(r5)
            int r1 = r12.length
            int r1 = r1 - r5
            r12.length = r1
            int r1 = r12.streamId
            if (r1 != 0) goto L_0x00db
            io.netty.handler.codec.spdy.SpdyFrameDecoder$State r0 = io.netty.handler.codec.spdy.SpdyFrameDecoder.State.FRAME_ERROR
            r12.state = r0
            io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate r0 = r12.delegate
            java.lang.String r1 = "Invalid HEADERS Frame"
            r0.readFrameError(r1)
            goto L_0x0000
        L_0x00db:
            io.netty.handler.codec.spdy.SpdyFrameDecoder$State r2 = io.netty.handler.codec.spdy.SpdyFrameDecoder.State.READ_HEADER_BLOCK
            r12.state = r2
            io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate r2 = r12.delegate
            r2.readHeadersFrame(r1, r0)
            goto L_0x0000
        L_0x00e6:
            int r0 = r13.readableBytes()
            if (r0 >= r4) goto L_0x00ed
            return
        L_0x00ed:
            int r0 = r13.readerIndex()
            int r0 = io.netty.handler.codec.spdy.SpdyCodecUtil.getUnsignedInt(r13, r0)
            int r1 = r13.readerIndex()
            int r1 = r1 + r5
            int r1 = io.netty.handler.codec.spdy.SpdyCodecUtil.getSignedInt(r13, r1)
            r13.skipBytes(r4)
            io.netty.handler.codec.spdy.SpdyFrameDecoder$State r2 = io.netty.handler.codec.spdy.SpdyFrameDecoder.State.READ_COMMON_HEADER
            r12.state = r2
            io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate r2 = r12.delegate
            r2.readGoAwayFrame(r0, r1)
            goto L_0x0000
        L_0x010c:
            int r0 = r13.readableBytes()
            if (r0 >= r5) goto L_0x0113
            return
        L_0x0113:
            int r0 = r13.readerIndex()
            int r0 = io.netty.handler.codec.spdy.SpdyCodecUtil.getSignedInt(r13, r0)
            r13.skipBytes(r5)
            io.netty.handler.codec.spdy.SpdyFrameDecoder$State r1 = io.netty.handler.codec.spdy.SpdyFrameDecoder.State.READ_COMMON_HEADER
            r12.state = r1
            io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate r1 = r12.delegate
            r1.readPingFrame(r0)
            goto L_0x0000
        L_0x0129:
            int r0 = r12.numSettings
            if (r0 != 0) goto L_0x0138
            io.netty.handler.codec.spdy.SpdyFrameDecoder$State r0 = io.netty.handler.codec.spdy.SpdyFrameDecoder.State.READ_COMMON_HEADER
            r12.state = r0
            io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate r0 = r12.delegate
            r0.readSettingsEnd()
            goto L_0x0000
        L_0x0138:
            int r0 = r13.readableBytes()
            if (r0 >= r4) goto L_0x013f
            return
        L_0x013f:
            int r0 = r13.readerIndex()
            byte r0 = r13.getByte(r0)
            int r2 = r13.readerIndex()
            int r2 = r2 + r3
            int r2 = io.netty.handler.codec.spdy.SpdyCodecUtil.getUnsignedMedium(r13, r2)
            int r6 = r13.readerIndex()
            int r6 = r6 + r5
            int r5 = io.netty.handler.codec.spdy.SpdyCodecUtil.getSignedInt(r13, r6)
            boolean r6 = hasFlag(r0, r3)
            boolean r0 = hasFlag(r0, r1)
            r13.skipBytes(r4)
            int r1 = r12.numSettings
            int r1 = r1 - r3
            r12.numSettings = r1
            io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate r1 = r12.delegate
            r1.readSetting(r2, r5, r6, r0)
            goto L_0x0000
        L_0x0170:
            int r0 = r13.readableBytes()
            if (r0 >= r5) goto L_0x0177
            return
        L_0x0177:
            byte r0 = r12.flags
            boolean r0 = hasFlag(r0, r3)
            int r1 = r13.readerIndex()
            int r1 = io.netty.handler.codec.spdy.SpdyCodecUtil.getUnsignedInt(r13, r1)
            r12.numSettings = r1
            r13.skipBytes(r5)
            int r1 = r12.length
            int r1 = r1 - r5
            r12.length = r1
            r2 = r1 & 7
            if (r2 != 0) goto L_0x01a5
            int r1 = r1 >> 3
            int r2 = r12.numSettings
            if (r1 == r2) goto L_0x019a
            goto L_0x01a5
        L_0x019a:
            io.netty.handler.codec.spdy.SpdyFrameDecoder$State r1 = io.netty.handler.codec.spdy.SpdyFrameDecoder.State.READ_SETTING
            r12.state = r1
            io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate r1 = r12.delegate
            r1.readSettingsFrame(r0)
            goto L_0x0000
        L_0x01a5:
            io.netty.handler.codec.spdy.SpdyFrameDecoder$State r0 = io.netty.handler.codec.spdy.SpdyFrameDecoder.State.FRAME_ERROR
            r12.state = r0
            io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate r0 = r12.delegate
            java.lang.String r1 = "Invalid SETTINGS Frame"
            r0.readFrameError(r1)
            goto L_0x0000
        L_0x01b2:
            int r0 = r13.readableBytes()
            if (r0 >= r4) goto L_0x01b9
            return
        L_0x01b9:
            int r0 = r13.readerIndex()
            int r0 = io.netty.handler.codec.spdy.SpdyCodecUtil.getUnsignedInt(r13, r0)
            r12.streamId = r0
            int r0 = r13.readerIndex()
            int r0 = r0 + r5
            int r0 = io.netty.handler.codec.spdy.SpdyCodecUtil.getSignedInt(r13, r0)
            r13.skipBytes(r4)
            int r1 = r12.streamId
            if (r1 == 0) goto L_0x01e1
            if (r0 != 0) goto L_0x01d6
            goto L_0x01e1
        L_0x01d6:
            io.netty.handler.codec.spdy.SpdyFrameDecoder$State r2 = io.netty.handler.codec.spdy.SpdyFrameDecoder.State.READ_COMMON_HEADER
            r12.state = r2
            io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate r2 = r12.delegate
            r2.readRstStreamFrame(r1, r0)
            goto L_0x0000
        L_0x01e1:
            io.netty.handler.codec.spdy.SpdyFrameDecoder$State r0 = io.netty.handler.codec.spdy.SpdyFrameDecoder.State.FRAME_ERROR
            r12.state = r0
            io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate r0 = r12.delegate
            java.lang.String r1 = "Invalid RST_STREAM Frame"
            r0.readFrameError(r1)
            goto L_0x0000
        L_0x01ee:
            int r0 = r13.readableBytes()
            if (r0 >= r5) goto L_0x01f5
            return
        L_0x01f5:
            int r0 = r13.readerIndex()
            int r0 = io.netty.handler.codec.spdy.SpdyCodecUtil.getUnsignedInt(r13, r0)
            r12.streamId = r0
            byte r0 = r12.flags
            boolean r0 = hasFlag(r0, r3)
            r13.skipBytes(r5)
            int r1 = r12.length
            int r1 = r1 - r5
            r12.length = r1
            int r1 = r12.streamId
            if (r1 != 0) goto L_0x021e
            io.netty.handler.codec.spdy.SpdyFrameDecoder$State r0 = io.netty.handler.codec.spdy.SpdyFrameDecoder.State.FRAME_ERROR
            r12.state = r0
            io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate r0 = r12.delegate
            java.lang.String r1 = "Invalid SYN_REPLY Frame"
            r0.readFrameError(r1)
            goto L_0x0000
        L_0x021e:
            io.netty.handler.codec.spdy.SpdyFrameDecoder$State r2 = io.netty.handler.codec.spdy.SpdyFrameDecoder.State.READ_HEADER_BLOCK
            r12.state = r2
            io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate r2 = r12.delegate
            r2.readSynReplyFrame(r1, r0)
            goto L_0x0000
        L_0x0229:
            int r0 = r13.readableBytes()
            r2 = 10
            if (r0 >= r2) goto L_0x0232
            return
        L_0x0232:
            int r0 = r13.readerIndex()
            int r5 = io.netty.handler.codec.spdy.SpdyCodecUtil.getUnsignedInt(r13, r0)
            r12.streamId = r5
            int r5 = r0 + 4
            int r8 = io.netty.handler.codec.spdy.SpdyCodecUtil.getUnsignedInt(r13, r5)
            int r0 = r0 + r4
            byte r0 = r13.getByte(r0)
            int r0 = r0 >> 5
            r0 = r0 & 7
            byte r9 = (byte) r0
            byte r0 = r12.flags
            boolean r10 = hasFlag(r0, r3)
            byte r0 = r12.flags
            boolean r11 = hasFlag(r0, r1)
            r13.skipBytes(r2)
            int r0 = r12.length
            int r0 = r0 - r2
            r12.length = r0
            int r7 = r12.streamId
            if (r7 != 0) goto L_0x0271
            io.netty.handler.codec.spdy.SpdyFrameDecoder$State r0 = io.netty.handler.codec.spdy.SpdyFrameDecoder.State.FRAME_ERROR
            r12.state = r0
            io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate r0 = r12.delegate
            java.lang.String r1 = "Invalid SYN_STREAM Frame"
            r0.readFrameError(r1)
            goto L_0x0000
        L_0x0271:
            io.netty.handler.codec.spdy.SpdyFrameDecoder$State r0 = io.netty.handler.codec.spdy.SpdyFrameDecoder.State.READ_HEADER_BLOCK
            r12.state = r0
            io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate r6 = r12.delegate
            r6.readSynStreamFrame(r7, r8, r9, r10, r11)
            goto L_0x0000
        L_0x027c:
            int r0 = r12.length
            if (r0 != 0) goto L_0x0297
            io.netty.handler.codec.spdy.SpdyFrameDecoder$State r0 = io.netty.handler.codec.spdy.SpdyFrameDecoder.State.READ_COMMON_HEADER
            r12.state = r0
            io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate r0 = r12.delegate
            int r1 = r12.streamId
            byte r4 = r12.flags
            boolean r3 = hasFlag(r4, r3)
            io.netty.buffer.ByteBuf r2 = io.netty.buffer.Unpooled.buffer(r2)
            r0.readDataFrame(r1, r3, r2)
            goto L_0x0000
        L_0x0297:
            int r1 = r12.maxChunkSize
            int r0 = java.lang.Math.min(r1, r0)
            int r1 = r13.readableBytes()
            if (r1 >= r0) goto L_0x02a4
            return
        L_0x02a4:
            io.netty.buffer.ByteBufAllocator r1 = r13.alloc()
            io.netty.buffer.ByteBuf r1 = r1.buffer(r0)
            r1.writeBytes((io.netty.buffer.ByteBuf) r13, (int) r0)
            int r4 = r12.length
            int r4 = r4 - r0
            r12.length = r4
            if (r4 != 0) goto L_0x02ba
            io.netty.handler.codec.spdy.SpdyFrameDecoder$State r0 = io.netty.handler.codec.spdy.SpdyFrameDecoder.State.READ_COMMON_HEADER
            r12.state = r0
        L_0x02ba:
            if (r4 != 0) goto L_0x02c5
            byte r0 = r12.flags
            boolean r0 = hasFlag(r0, r3)
            if (r0 == 0) goto L_0x02c5
            r2 = r3
        L_0x02c5:
            io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate r0 = r12.delegate
            int r3 = r12.streamId
            r0.readDataFrame(r3, r2, r1)
            goto L_0x0000
        L_0x02ce:
            int r0 = r13.readableBytes()
            if (r0 >= r4) goto L_0x02d5
            return
        L_0x02d5:
            int r0 = r13.readerIndex()
            int r1 = r0 + 4
            int r3 = r0 + 5
            r13.skipBytes(r4)
            byte r4 = r13.getByte(r0)
            r4 = r4 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x02f8
            int r4 = io.netty.handler.codec.spdy.SpdyCodecUtil.getUnsignedShort(r13, r0)
            r4 = r4 & 32767(0x7fff, float:4.5916E-41)
            int r0 = r0 + 2
            int r0 = io.netty.handler.codec.spdy.SpdyCodecUtil.getUnsignedShort(r13, r0)
            r12.streamId = r2
            r2 = r0
            goto L_0x0300
        L_0x02f8:
            int r4 = r12.spdyVersion
            int r0 = io.netty.handler.codec.spdy.SpdyCodecUtil.getUnsignedInt(r13, r0)
            r12.streamId = r0
        L_0x0300:
            byte r0 = r13.getByte(r1)
            r12.flags = r0
            int r0 = io.netty.handler.codec.spdy.SpdyCodecUtil.getUnsignedMedium(r13, r3)
            r12.length = r0
            int r1 = r12.spdyVersion
            if (r4 == r1) goto L_0x031d
            io.netty.handler.codec.spdy.SpdyFrameDecoder$State r0 = io.netty.handler.codec.spdy.SpdyFrameDecoder.State.FRAME_ERROR
            r12.state = r0
            io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate r0 = r12.delegate
            java.lang.String r1 = "Invalid SPDY Version"
            r0.readFrameError(r1)
            goto L_0x0000
        L_0x031d:
            int r1 = r12.streamId
            byte r3 = r12.flags
            boolean r0 = isValidFrameHeader(r1, r2, r3, r0)
            if (r0 != 0) goto L_0x0334
            io.netty.handler.codec.spdy.SpdyFrameDecoder$State r0 = io.netty.handler.codec.spdy.SpdyFrameDecoder.State.FRAME_ERROR
            r12.state = r0
            io.netty.handler.codec.spdy.SpdyFrameDecoderDelegate r0 = r12.delegate
            java.lang.String r1 = "Invalid Frame Error"
            r0.readFrameError(r1)
            goto L_0x0000
        L_0x0334:
            int r0 = r12.length
            io.netty.handler.codec.spdy.SpdyFrameDecoder$State r0 = getNextState(r2, r0)
            r12.state = r0
            goto L_0x0000
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.spdy.SpdyFrameDecoder.decode(io.netty.buffer.ByteBuf):void");
    }

    public SpdyFrameDecoder(SpdyVersion spdyVersion2, SpdyFrameDecoderDelegate spdyFrameDecoderDelegate, int i) {
        this.spdyVersion = ((SpdyVersion) ObjectUtil.checkNotNull(spdyVersion2, "spdyVersion")).getVersion();
        this.delegate = (SpdyFrameDecoderDelegate) ObjectUtil.checkNotNull(spdyFrameDecoderDelegate, "delegate");
        this.maxChunkSize = ObjectUtil.checkPositive(i, "maxChunkSize");
        this.state = State.READ_COMMON_HEADER;
    }
}
