package io.netty.handler.codec.http.websocketx;

import com.here.posclient.UpdateOptions;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteOrder;

public class WebSocket08FrameDecoder extends ByteToMessageDecoder implements WebSocketFrameDecoder {
    private static final byte OPCODE_BINARY = 2;
    private static final byte OPCODE_CLOSE = 8;
    private static final byte OPCODE_CONT = 0;
    private static final byte OPCODE_PING = 9;
    private static final byte OPCODE_PONG = 10;
    private static final byte OPCODE_TEXT = 1;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) WebSocket08FrameDecoder.class);
    private final WebSocketDecoderConfig config;
    private int fragmentedFramesCount;
    private boolean frameFinalFlag;
    private boolean frameMasked;
    private int frameOpcode;
    private int framePayloadLen1;
    private long framePayloadLength;
    private int frameRsv;
    private byte[] maskingKey;
    private boolean receivedClosingHandshake;
    private State state;

    /* renamed from: io.netty.handler.codec.http.websocketx.WebSocket08FrameDecoder$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http$websocketx$WebSocket08FrameDecoder$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                io.netty.handler.codec.http.websocketx.WebSocket08FrameDecoder$State[] r0 = io.netty.handler.codec.http.websocketx.WebSocket08FrameDecoder.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$netty$handler$codec$http$websocketx$WebSocket08FrameDecoder$State = r0
                io.netty.handler.codec.http.websocketx.WebSocket08FrameDecoder$State r1 = io.netty.handler.codec.http.websocketx.WebSocket08FrameDecoder.State.READING_FIRST     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$netty$handler$codec$http$websocketx$WebSocket08FrameDecoder$State     // Catch:{ NoSuchFieldError -> 0x001d }
                io.netty.handler.codec.http.websocketx.WebSocket08FrameDecoder$State r1 = io.netty.handler.codec.http.websocketx.WebSocket08FrameDecoder.State.READING_SECOND     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$netty$handler$codec$http$websocketx$WebSocket08FrameDecoder$State     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.netty.handler.codec.http.websocketx.WebSocket08FrameDecoder$State r1 = io.netty.handler.codec.http.websocketx.WebSocket08FrameDecoder.State.READING_SIZE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$io$netty$handler$codec$http$websocketx$WebSocket08FrameDecoder$State     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.netty.handler.codec.http.websocketx.WebSocket08FrameDecoder$State r1 = io.netty.handler.codec.http.websocketx.WebSocket08FrameDecoder.State.MASKING_KEY     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$io$netty$handler$codec$http$websocketx$WebSocket08FrameDecoder$State     // Catch:{ NoSuchFieldError -> 0x003e }
                io.netty.handler.codec.http.websocketx.WebSocket08FrameDecoder$State r1 = io.netty.handler.codec.http.websocketx.WebSocket08FrameDecoder.State.PAYLOAD     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$io$netty$handler$codec$http$websocketx$WebSocket08FrameDecoder$State     // Catch:{ NoSuchFieldError -> 0x0049 }
                io.netty.handler.codec.http.websocketx.WebSocket08FrameDecoder$State r1 = io.netty.handler.codec.http.websocketx.WebSocket08FrameDecoder.State.CORRUPT     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http.websocketx.WebSocket08FrameDecoder.AnonymousClass1.<clinit>():void");
        }
    }

    public enum State {
        READING_FIRST,
        READING_SECOND,
        READING_SIZE,
        MASKING_KEY,
        PAYLOAD,
        CORRUPT
    }

    public WebSocket08FrameDecoder(boolean z, boolean z2, int i) {
        this(z, z2, i, false);
    }

    private void protocolViolation(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, String str) {
        protocolViolation(channelHandlerContext, byteBuf, WebSocketCloseStatus.PROTOCOL_ERROR, str);
    }

    private static int toFrameLength(long j) {
        if (j <= UpdateOptions.SOURCE_ANY) {
            return (int) j;
        }
        throw new TooLongFrameException("Length:" + j);
    }

    private void unmask(ByteBuf byteBuf) {
        int readerIndex = byteBuf.readerIndex();
        int writerIndex = byteBuf.writerIndex();
        ByteOrder order = byteBuf.order();
        byte[] bArr = this.maskingKey;
        int i = 0;
        long j = (((long) (bArr[0] & 255)) << 24) | ((long) ((bArr[1] & 255) << 16)) | ((long) ((bArr[2] & 255) << 8)) | ((long) (bArr[3] & 255));
        long j2 = j | (j << 32);
        if (order == ByteOrder.LITTLE_ENDIAN) {
            j2 = Long.reverseBytes(j2);
        }
        int i2 = writerIndex - 7;
        while (readerIndex < i2) {
            byteBuf.setLong(readerIndex, byteBuf.getLong(readerIndex) ^ j2);
            readerIndex += 8;
        }
        if (readerIndex < writerIndex - 3) {
            byteBuf.setInt(readerIndex, byteBuf.getInt(readerIndex) ^ ((int) j2));
            readerIndex += 4;
        }
        while (readerIndex < writerIndex) {
            byteBuf.setByte(readerIndex, byteBuf.getByte(readerIndex) ^ this.maskingKey[i & 3]);
            readerIndex++;
            i++;
        }
    }

    public void checkCloseFrameBody(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) {
        if (byteBuf != null && byteBuf.isReadable()) {
            if (byteBuf.readableBytes() < 2) {
                protocolViolation(channelHandlerContext, byteBuf, WebSocketCloseStatus.INVALID_PAYLOAD_DATA, "Invalid close frame body");
            }
            short s = byteBuf.getShort(byteBuf.readerIndex());
            if (!WebSocketCloseStatus.isValidStatusCode(s)) {
                protocolViolation(channelHandlerContext, byteBuf, "Invalid close frame getStatus code: " + s);
            }
            if (byteBuf.readableBytes() > 2) {
                try {
                    new Utf8Validator().check(byteBuf, byteBuf.readerIndex() + 2, byteBuf.readableBytes() - 2);
                } catch (CorruptedWebSocketFrameException e) {
                    protocolViolation(channelHandlerContext, byteBuf, e);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01b6, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01b7, code lost:
        r4 = logger;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01bd, code lost:
        if (r4.isTraceEnabled() == false) goto L_0x01ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01bf, code lost:
        r4.trace("Decoding WebSocket Frame length={}", (java.lang.Object) java.lang.Long.valueOf(r0.framePayloadLength));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01ca, code lost:
        r0.state = io.netty.handler.codec.http.websocketx.WebSocket08FrameDecoder.State.MASKING_KEY;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01d0, code lost:
        if (r0.frameMasked == false) goto L_0x01e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x01d6, code lost:
        if (r20.readableBytes() >= 4) goto L_0x01d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x01d8, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x01db, code lost:
        if (r0.maskingKey != null) goto L_0x01e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x01dd, code lost:
        r0.maskingKey = new byte[4];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x01e1, code lost:
        r2.readBytes(r0.maskingKey);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x01e6, code lost:
        r0.state = io.netty.handler.codec.http.websocketx.WebSocket08FrameDecoder.State.PAYLOAD;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x01ea, code lost:
        r6 = r0.framePayloadLength;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x01f3, code lost:
        if (((long) r20.readableBytes()) >= r6) goto L_0x01f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x01f5, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x01f6, code lost:
        r4 = io.netty.buffer.Unpooled.EMPTY_BUFFER;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x01fa, code lost:
        if (r6 <= 0) goto L_0x020e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:?, code lost:
        r4 = io.netty.buffer.ByteBufUtil.readBytes(r19.alloc(), r2, toFrameLength(r0.framePayloadLength));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x020b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x020e, code lost:
        r0.state = io.netty.handler.codec.http.websocketx.WebSocket08FrameDecoder.State.READING_FIRST;
        r2 = r0.frameMasked;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0218, code lost:
        if (r0.framePayloadLength <= 0) goto L_0x021c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x021a, code lost:
        r5 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x021c, code lost:
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x021e, code lost:
        if ((r2 & r5) == false) goto L_0x0223;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0220, code lost:
        unmask(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0223, code lost:
        r2 = r0.frameOpcode;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0227, code lost:
        if (r2 != 9) goto L_0x0236;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0229, code lost:
        r3.add(new io.netty.handler.codec.http.websocketx.PingWebSocketFrame(r0.frameFinalFlag, r0.frameRsv, r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0235, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0238, code lost:
        if (r2 != 10) goto L_0x0247;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x023a, code lost:
        r3.add(new io.netty.handler.codec.http.websocketx.PongWebSocketFrame(r0.frameFinalFlag, r0.frameRsv, r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0246, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0247, code lost:
        if (r2 != 8) goto L_0x025b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0249, code lost:
        r0.receivedClosingHandshake = true;
        checkCloseFrameBody(r1, r4);
        r3.add(new io.netty.handler.codec.http.websocketx.CloseWebSocketFrame(r0.frameFinalFlag, r0.frameRsv, r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x025a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x025b, code lost:
        r1 = r0.frameFinalFlag;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x025d, code lost:
        if (r1 == false) goto L_0x0263;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x025f, code lost:
        r0.fragmentedFramesCount = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0263, code lost:
        r0.fragmentedFramesCount++;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0268, code lost:
        if (r2 != 1) goto L_0x0275;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x026a, code lost:
        r3.add(new io.netty.handler.codec.http.websocketx.TextWebSocketFrame(r1, r0.frameRsv, r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0274, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0275, code lost:
        if (r2 != 2) goto L_0x0282;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0277, code lost:
        r3.add(new io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame(r1, r0.frameRsv, r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0281, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0282, code lost:
        if (r2 != 0) goto L_0x028f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0284, code lost:
        r3.add(new io.netty.handler.codec.http.websocketx.ContinuationWebSocketFrame(r1, r0.frameRsv, r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x028e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x02a7, code lost:
        throw new java.lang.UnsupportedOperationException("Cannot decode web socket frame with opcode: " + r0.frameOpcode);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x02a8, code lost:
        if (r4 != null) goto L_0x02aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x02aa, code lost:
        r4.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x02ad, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007a, code lost:
        if (r20.isReadable() != false) goto L_0x007d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007c, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007d, code lost:
        r4 = r20.readByte();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0083, code lost:
        if ((r4 & 128) == 0) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0085, code lost:
        r11 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0087, code lost:
        r11 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0088, code lost:
        r0.frameMasked = r11;
        r0.framePayloadLen1 = r4 & Byte.MAX_VALUE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008f, code lost:
        if (r0.frameRsv == 0) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0097, code lost:
        if (r0.config.allowExtensions() != false) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0099, code lost:
        protocolViolation(r1, r2, "RSV != 0 and no extension negotiated, RSV:" + r0.frameRsv);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00af, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b6, code lost:
        if (r0.config.allowMaskMismatch() != false) goto L_0x00c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c0, code lost:
        if (r0.config.expectMaskedFrames() == r0.frameMasked) goto L_0x00c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c2, code lost:
        protocolViolation(r1, r2, "received a frame that is not masked as expected");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c7, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00c8, code lost:
        r4 = r0.frameOpcode;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00cb, code lost:
        if (r4 <= 7) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00cf, code lost:
        if (r0.frameFinalFlag != false) goto L_0x00d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00d1, code lost:
        protocolViolation(r1, r2, "fragmented control frame");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00d6, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d7, code lost:
        r11 = r0.framePayloadLen1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00db, code lost:
        if (r11 <= 125) goto L_0x00e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00dd, code lost:
        protocolViolation(r1, r2, "control frame with payload length > 125 octets");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00e2, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e3, code lost:
        if (r4 == 8) goto L_0x0100;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e5, code lost:
        if (r4 == 9) goto L_0x0100;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e7, code lost:
        if (r4 == 10) goto L_0x0100;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00e9, code lost:
        protocolViolation(r1, r2, "control frame using reserved opcode " + r0.frameOpcode);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00ff, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0100, code lost:
        if (r4 != 8) goto L_0x013d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0102, code lost:
        if (r11 != 1) goto L_0x013d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0104, code lost:
        protocolViolation(r1, r2, "received close control frame with payload len 1");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0109, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x010a, code lost:
        if (r4 == 0) goto L_0x0127;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x010c, code lost:
        if (r4 == 1) goto L_0x0127;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x010e, code lost:
        if (r4 == 2) goto L_0x0127;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0110, code lost:
        protocolViolation(r1, r2, "data frame using reserved opcode " + r0.frameOpcode);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0126, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0127, code lost:
        r11 = r0.fragmentedFramesCount;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0129, code lost:
        if (r11 != 0) goto L_0x0133;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x012b, code lost:
        if (r4 != 0) goto L_0x0133;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x012d, code lost:
        protocolViolation(r1, r2, "received continuation data frame outside fragmented message");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0132, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0133, code lost:
        if (r11 == 0) goto L_0x013d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0135, code lost:
        if (r4 == 0) goto L_0x013d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0137, code lost:
        protocolViolation(r1, r2, "received non-continuation data frame while inside fragmented message");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x013c, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x013d, code lost:
        r0.state = io.netty.handler.codec.http.websocketx.WebSocket08FrameDecoder.State.READING_SIZE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0141, code lost:
        r4 = r0.framePayloadLen1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0147, code lost:
        if (r4 != 126) goto L_0x0161;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x014d, code lost:
        if (r20.readableBytes() >= 2) goto L_0x0150;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x014f, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0150, code lost:
        r5 = (long) r20.readUnsignedShort();
        r0.framePayloadLength = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x015b, code lost:
        if (r5 >= 126) goto L_0x0188;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x015d, code lost:
        protocolViolation(r1, r2, "invalid data frame length (not using minimal length encoding)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0160, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0161, code lost:
        if (r4 != 127) goto L_0x0185;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0167, code lost:
        if (r20.readableBytes() >= 8) goto L_0x016a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0169, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x016a, code lost:
        r4 = r20.readLong();
        r0.framePayloadLength = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0172, code lost:
        if (r4 >= 0) goto L_0x017a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0174, code lost:
        protocolViolation(r1, r2, "invalid data frame length (negative length)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0179, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x017f, code lost:
        if (r4 >= android.support.v4.media.session.PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) goto L_0x0188;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0181, code lost:
        protocolViolation(r1, r2, "invalid data frame length (not using minimal length encoding)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0184, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0185, code lost:
        r0.framePayloadLength = (long) r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0193, code lost:
        if (r0.framePayloadLength <= ((long) r0.config.maxFramePayloadLength())) goto L_0x01b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0195, code lost:
        protocolViolation(r1, r2, io.netty.handler.codec.http.websocketx.WebSocketCloseStatus.MESSAGE_TOO_BIG, "Max frame length of " + r0.config.maxFramePayloadLength() + " has been exceeded.");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void decode(io.netty.channel.ChannelHandlerContext r19, io.netty.buffer.ByteBuf r20, java.util.List<java.lang.Object> r21) throws java.lang.Exception {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            boolean r4 = r0.receivedClosingHandshake
            if (r4 == 0) goto L_0x0014
            int r0 = r18.actualReadableBytes()
            r2.skipBytes(r0)
            return
        L_0x0014:
            int[] r4 = io.netty.handler.codec.http.websocketx.WebSocket08FrameDecoder.AnonymousClass1.$SwitchMap$io$netty$handler$codec$http$websocketx$WebSocket08FrameDecoder$State
            io.netty.handler.codec.http.websocketx.WebSocket08FrameDecoder$State r5 = r0.state
            int r5 = r5.ordinal()
            r4 = r4[r5]
            r5 = 10
            r6 = 9
            r7 = 127(0x7f, float:1.78E-43)
            r8 = 2
            r9 = 4
            r10 = 8
            r12 = 0
            r14 = 1
            switch(r4) {
                case 1: goto L_0x0040;
                case 2: goto L_0x0076;
                case 3: goto L_0x0141;
                case 4: goto L_0x01ce;
                case 5: goto L_0x01ea;
                case 6: goto L_0x0036;
                default: goto L_0x002e;
            }
        L_0x002e:
            java.lang.Error r0 = new java.lang.Error
            java.lang.String r1 = "Shouldn't reach here."
            r0.<init>(r1)
            throw r0
        L_0x0036:
            boolean r0 = r20.isReadable()
            if (r0 == 0) goto L_0x003f
            r20.readByte()
        L_0x003f:
            return
        L_0x0040:
            boolean r4 = r20.isReadable()
            if (r4 != 0) goto L_0x0047
            return
        L_0x0047:
            r0.framePayloadLength = r12
            byte r4 = r20.readByte()
            r15 = r4 & 128(0x80, float:1.794E-43)
            if (r15 == 0) goto L_0x0053
            r15 = r14
            goto L_0x0054
        L_0x0053:
            r15 = 0
        L_0x0054:
            r0.frameFinalFlag = r15
            r15 = r4 & 112(0x70, float:1.57E-43)
            int r15 = r15 >> r9
            r0.frameRsv = r15
            r4 = r4 & 15
            r0.frameOpcode = r4
            io.netty.util.internal.logging.InternalLogger r4 = logger
            boolean r15 = r4.isTraceEnabled()
            if (r15 == 0) goto L_0x0072
            int r15 = r0.frameOpcode
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            java.lang.String r11 = "Decoding WebSocket Frame opCode={}"
            r4.trace((java.lang.String) r11, (java.lang.Object) r15)
        L_0x0072:
            io.netty.handler.codec.http.websocketx.WebSocket08FrameDecoder$State r4 = io.netty.handler.codec.http.websocketx.WebSocket08FrameDecoder.State.READING_SECOND
            r0.state = r4
        L_0x0076:
            boolean r4 = r20.isReadable()
            if (r4 != 0) goto L_0x007d
            return
        L_0x007d:
            byte r4 = r20.readByte()
            r11 = r4 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x0087
            r11 = r14
            goto L_0x0088
        L_0x0087:
            r11 = 0
        L_0x0088:
            r0.frameMasked = r11
            r4 = r4 & r7
            r0.framePayloadLen1 = r4
            int r4 = r0.frameRsv
            if (r4 == 0) goto L_0x00b0
            io.netty.handler.codec.http.websocketx.WebSocketDecoderConfig r4 = r0.config
            boolean r4 = r4.allowExtensions()
            if (r4 != 0) goto L_0x00b0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "RSV != 0 and no extension negotiated, RSV:"
            r3.append(r4)
            int r4 = r0.frameRsv
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r0.protocolViolation((io.netty.channel.ChannelHandlerContext) r1, (io.netty.buffer.ByteBuf) r2, (java.lang.String) r3)
            return
        L_0x00b0:
            io.netty.handler.codec.http.websocketx.WebSocketDecoderConfig r4 = r0.config
            boolean r4 = r4.allowMaskMismatch()
            if (r4 != 0) goto L_0x00c8
            io.netty.handler.codec.http.websocketx.WebSocketDecoderConfig r4 = r0.config
            boolean r4 = r4.expectMaskedFrames()
            boolean r11 = r0.frameMasked
            if (r4 == r11) goto L_0x00c8
            java.lang.String r3 = "received a frame that is not masked as expected"
            r0.protocolViolation((io.netty.channel.ChannelHandlerContext) r1, (io.netty.buffer.ByteBuf) r2, (java.lang.String) r3)
            return
        L_0x00c8:
            int r4 = r0.frameOpcode
            r11 = 7
            if (r4 <= r11) goto L_0x010a
            boolean r11 = r0.frameFinalFlag
            if (r11 != 0) goto L_0x00d7
            java.lang.String r3 = "fragmented control frame"
            r0.protocolViolation((io.netty.channel.ChannelHandlerContext) r1, (io.netty.buffer.ByteBuf) r2, (java.lang.String) r3)
            return
        L_0x00d7:
            int r11 = r0.framePayloadLen1
            r15 = 125(0x7d, float:1.75E-43)
            if (r11 <= r15) goto L_0x00e3
            java.lang.String r3 = "control frame with payload length > 125 octets"
            r0.protocolViolation((io.netty.channel.ChannelHandlerContext) r1, (io.netty.buffer.ByteBuf) r2, (java.lang.String) r3)
            return
        L_0x00e3:
            if (r4 == r10) goto L_0x0100
            if (r4 == r6) goto L_0x0100
            if (r4 == r5) goto L_0x0100
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "control frame using reserved opcode "
            r3.append(r4)
            int r4 = r0.frameOpcode
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r0.protocolViolation((io.netty.channel.ChannelHandlerContext) r1, (io.netty.buffer.ByteBuf) r2, (java.lang.String) r3)
            return
        L_0x0100:
            if (r4 != r10) goto L_0x013d
            if (r11 != r14) goto L_0x013d
            java.lang.String r3 = "received close control frame with payload len 1"
            r0.protocolViolation((io.netty.channel.ChannelHandlerContext) r1, (io.netty.buffer.ByteBuf) r2, (java.lang.String) r3)
            return
        L_0x010a:
            if (r4 == 0) goto L_0x0127
            if (r4 == r14) goto L_0x0127
            if (r4 == r8) goto L_0x0127
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "data frame using reserved opcode "
            r3.append(r4)
            int r4 = r0.frameOpcode
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r0.protocolViolation((io.netty.channel.ChannelHandlerContext) r1, (io.netty.buffer.ByteBuf) r2, (java.lang.String) r3)
            return
        L_0x0127:
            int r11 = r0.fragmentedFramesCount
            if (r11 != 0) goto L_0x0133
            if (r4 != 0) goto L_0x0133
            java.lang.String r3 = "received continuation data frame outside fragmented message"
            r0.protocolViolation((io.netty.channel.ChannelHandlerContext) r1, (io.netty.buffer.ByteBuf) r2, (java.lang.String) r3)
            return
        L_0x0133:
            if (r11 == 0) goto L_0x013d
            if (r4 == 0) goto L_0x013d
            java.lang.String r3 = "received non-continuation data frame while inside fragmented message"
            r0.protocolViolation((io.netty.channel.ChannelHandlerContext) r1, (io.netty.buffer.ByteBuf) r2, (java.lang.String) r3)
            return
        L_0x013d:
            io.netty.handler.codec.http.websocketx.WebSocket08FrameDecoder$State r4 = io.netty.handler.codec.http.websocketx.WebSocket08FrameDecoder.State.READING_SIZE
            r0.state = r4
        L_0x0141:
            int r4 = r0.framePayloadLen1
            r11 = 126(0x7e, float:1.77E-43)
            java.lang.String r15 = "invalid data frame length (not using minimal length encoding)"
            if (r4 != r11) goto L_0x0161
            int r4 = r20.readableBytes()
            if (r4 >= r8) goto L_0x0150
            return
        L_0x0150:
            int r4 = r20.readUnsignedShort()
            long r5 = (long) r4
            r0.framePayloadLength = r5
            r16 = 126(0x7e, double:6.23E-322)
            int r4 = (r5 > r16 ? 1 : (r5 == r16 ? 0 : -1))
            if (r4 >= 0) goto L_0x0188
            r0.protocolViolation((io.netty.channel.ChannelHandlerContext) r1, (io.netty.buffer.ByteBuf) r2, (java.lang.String) r15)
            return
        L_0x0161:
            if (r4 != r7) goto L_0x0185
            int r4 = r20.readableBytes()
            if (r4 >= r10) goto L_0x016a
            return
        L_0x016a:
            long r4 = r20.readLong()
            r0.framePayloadLength = r4
            int r6 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r6 >= 0) goto L_0x017a
            java.lang.String r3 = "invalid data frame length (negative length)"
            r0.protocolViolation((io.netty.channel.ChannelHandlerContext) r1, (io.netty.buffer.ByteBuf) r2, (java.lang.String) r3)
            return
        L_0x017a:
            r6 = 65536(0x10000, double:3.2379E-319)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 >= 0) goto L_0x0188
            r0.protocolViolation((io.netty.channel.ChannelHandlerContext) r1, (io.netty.buffer.ByteBuf) r2, (java.lang.String) r15)
            return
        L_0x0185:
            long r4 = (long) r4
            r0.framePayloadLength = r4
        L_0x0188:
            long r4 = r0.framePayloadLength
            io.netty.handler.codec.http.websocketx.WebSocketDecoderConfig r6 = r0.config
            int r6 = r6.maxFramePayloadLength()
            long r6 = (long) r6
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 <= 0) goto L_0x01b7
            io.netty.handler.codec.http.websocketx.WebSocketCloseStatus r3 = io.netty.handler.codec.http.websocketx.WebSocketCloseStatus.MESSAGE_TOO_BIG
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Max frame length of "
            r4.append(r5)
            io.netty.handler.codec.http.websocketx.WebSocketDecoderConfig r5 = r0.config
            int r5 = r5.maxFramePayloadLength()
            r4.append(r5)
            java.lang.String r5 = " has been exceeded."
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r0.protocolViolation(r1, r2, r3, r4)
            return
        L_0x01b7:
            io.netty.util.internal.logging.InternalLogger r4 = logger
            boolean r5 = r4.isTraceEnabled()
            if (r5 == 0) goto L_0x01ca
            long r5 = r0.framePayloadLength
            java.lang.Long r5 = java.lang.Long.valueOf(r5)
            java.lang.String r6 = "Decoding WebSocket Frame length={}"
            r4.trace((java.lang.String) r6, (java.lang.Object) r5)
        L_0x01ca:
            io.netty.handler.codec.http.websocketx.WebSocket08FrameDecoder$State r4 = io.netty.handler.codec.http.websocketx.WebSocket08FrameDecoder.State.MASKING_KEY
            r0.state = r4
        L_0x01ce:
            boolean r4 = r0.frameMasked
            if (r4 == 0) goto L_0x01e6
            int r4 = r20.readableBytes()
            if (r4 >= r9) goto L_0x01d9
            return
        L_0x01d9:
            byte[] r4 = r0.maskingKey
            if (r4 != 0) goto L_0x01e1
            byte[] r4 = new byte[r9]
            r0.maskingKey = r4
        L_0x01e1:
            byte[] r4 = r0.maskingKey
            r2.readBytes((byte[]) r4)
        L_0x01e6:
            io.netty.handler.codec.http.websocketx.WebSocket08FrameDecoder$State r4 = io.netty.handler.codec.http.websocketx.WebSocket08FrameDecoder.State.PAYLOAD
            r0.state = r4
        L_0x01ea:
            int r4 = r20.readableBytes()
            long r4 = (long) r4
            long r6 = r0.framePayloadLength
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 >= 0) goto L_0x01f6
            return
        L_0x01f6:
            io.netty.buffer.ByteBuf r4 = io.netty.buffer.Unpooled.EMPTY_BUFFER
            int r5 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r5 <= 0) goto L_0x020e
            io.netty.buffer.ByteBufAllocator r5 = r19.alloc()     // Catch:{ all -> 0x020b }
            long r6 = r0.framePayloadLength     // Catch:{ all -> 0x020b }
            int r6 = toFrameLength(r6)     // Catch:{ all -> 0x020b }
            io.netty.buffer.ByteBuf r4 = io.netty.buffer.ByteBufUtil.readBytes(r5, r2, r6)     // Catch:{ all -> 0x020b }
            goto L_0x020e
        L_0x020b:
            r0 = move-exception
            goto L_0x02a8
        L_0x020e:
            io.netty.handler.codec.http.websocketx.WebSocket08FrameDecoder$State r2 = io.netty.handler.codec.http.websocketx.WebSocket08FrameDecoder.State.READING_FIRST     // Catch:{ all -> 0x020b }
            r0.state = r2     // Catch:{ all -> 0x020b }
            boolean r2 = r0.frameMasked     // Catch:{ all -> 0x020b }
            long r5 = r0.framePayloadLength     // Catch:{ all -> 0x020b }
            int r5 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r5 <= 0) goto L_0x021c
            r5 = r14
            goto L_0x021d
        L_0x021c:
            r5 = 0
        L_0x021d:
            r2 = r2 & r5
            if (r2 == 0) goto L_0x0223
            r0.unmask(r4)     // Catch:{ all -> 0x020b }
        L_0x0223:
            int r2 = r0.frameOpcode     // Catch:{ all -> 0x020b }
            r5 = 9
            if (r2 != r5) goto L_0x0236
            io.netty.handler.codec.http.websocketx.PingWebSocketFrame r1 = new io.netty.handler.codec.http.websocketx.PingWebSocketFrame     // Catch:{ all -> 0x020b }
            boolean r2 = r0.frameFinalFlag     // Catch:{ all -> 0x020b }
            int r0 = r0.frameRsv     // Catch:{ all -> 0x020b }
            r1.<init>(r2, r0, r4)     // Catch:{ all -> 0x020b }
            r3.add(r1)     // Catch:{ all -> 0x020b }
            return
        L_0x0236:
            r5 = 10
            if (r2 != r5) goto L_0x0247
            io.netty.handler.codec.http.websocketx.PongWebSocketFrame r1 = new io.netty.handler.codec.http.websocketx.PongWebSocketFrame     // Catch:{ all -> 0x020b }
            boolean r2 = r0.frameFinalFlag     // Catch:{ all -> 0x020b }
            int r0 = r0.frameRsv     // Catch:{ all -> 0x020b }
            r1.<init>(r2, r0, r4)     // Catch:{ all -> 0x020b }
            r3.add(r1)     // Catch:{ all -> 0x020b }
            return
        L_0x0247:
            if (r2 != r10) goto L_0x025b
            r0.receivedClosingHandshake = r14     // Catch:{ all -> 0x020b }
            r0.checkCloseFrameBody(r1, r4)     // Catch:{ all -> 0x020b }
            io.netty.handler.codec.http.websocketx.CloseWebSocketFrame r1 = new io.netty.handler.codec.http.websocketx.CloseWebSocketFrame     // Catch:{ all -> 0x020b }
            boolean r2 = r0.frameFinalFlag     // Catch:{ all -> 0x020b }
            int r0 = r0.frameRsv     // Catch:{ all -> 0x020b }
            r1.<init>(r2, r0, r4)     // Catch:{ all -> 0x020b }
            r3.add(r1)     // Catch:{ all -> 0x020b }
            return
        L_0x025b:
            boolean r1 = r0.frameFinalFlag     // Catch:{ all -> 0x020b }
            if (r1 == 0) goto L_0x0263
            r5 = 0
            r0.fragmentedFramesCount = r5     // Catch:{ all -> 0x020b }
            goto L_0x0268
        L_0x0263:
            int r5 = r0.fragmentedFramesCount     // Catch:{ all -> 0x020b }
            int r5 = r5 + r14
            r0.fragmentedFramesCount = r5     // Catch:{ all -> 0x020b }
        L_0x0268:
            if (r2 != r14) goto L_0x0275
            io.netty.handler.codec.http.websocketx.TextWebSocketFrame r2 = new io.netty.handler.codec.http.websocketx.TextWebSocketFrame     // Catch:{ all -> 0x020b }
            int r0 = r0.frameRsv     // Catch:{ all -> 0x020b }
            r2.<init>((boolean) r1, (int) r0, (io.netty.buffer.ByteBuf) r4)     // Catch:{ all -> 0x020b }
            r3.add(r2)     // Catch:{ all -> 0x020b }
            return
        L_0x0275:
            if (r2 != r8) goto L_0x0282
            io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame r2 = new io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame     // Catch:{ all -> 0x020b }
            int r0 = r0.frameRsv     // Catch:{ all -> 0x020b }
            r2.<init>(r1, r0, r4)     // Catch:{ all -> 0x020b }
            r3.add(r2)     // Catch:{ all -> 0x020b }
            return
        L_0x0282:
            if (r2 != 0) goto L_0x028f
            io.netty.handler.codec.http.websocketx.ContinuationWebSocketFrame r2 = new io.netty.handler.codec.http.websocketx.ContinuationWebSocketFrame     // Catch:{ all -> 0x020b }
            int r0 = r0.frameRsv     // Catch:{ all -> 0x020b }
            r2.<init>((boolean) r1, (int) r0, (io.netty.buffer.ByteBuf) r4)     // Catch:{ all -> 0x020b }
            r3.add(r2)     // Catch:{ all -> 0x020b }
            return
        L_0x028f:
            java.lang.UnsupportedOperationException r1 = new java.lang.UnsupportedOperationException     // Catch:{ all -> 0x020b }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x020b }
            r2.<init>()     // Catch:{ all -> 0x020b }
            java.lang.String r3 = "Cannot decode web socket frame with opcode: "
            r2.append(r3)     // Catch:{ all -> 0x020b }
            int r0 = r0.frameOpcode     // Catch:{ all -> 0x020b }
            r2.append(r0)     // Catch:{ all -> 0x020b }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x020b }
            r1.<init>(r0)     // Catch:{ all -> 0x020b }
            throw r1     // Catch:{ all -> 0x020b }
        L_0x02a8:
            if (r4 == 0) goto L_0x02ad
            r4.release()
        L_0x02ad:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http.websocketx.WebSocket08FrameDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }

    public WebSocket08FrameDecoder(boolean z, boolean z2, int i, boolean z3) {
        this(WebSocketDecoderConfig.newBuilder().expectMaskedFrames(z).allowExtensions(z2).maxFramePayloadLength(i).allowMaskMismatch(z3).build());
    }

    private void protocolViolation(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, WebSocketCloseStatus webSocketCloseStatus, String str) {
        protocolViolation(channelHandlerContext, byteBuf, new CorruptedWebSocketFrameException(webSocketCloseStatus, str));
    }

    private void protocolViolation(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, CorruptedWebSocketFrameException corruptedWebSocketFrameException) {
        Object obj;
        this.state = State.CORRUPT;
        int readableBytes = byteBuf.readableBytes();
        if (readableBytes > 0) {
            byteBuf.skipBytes(readableBytes);
        }
        if (channelHandlerContext.channel().isActive() && this.config.closeOnProtocolViolation()) {
            if (!this.receivedClosingHandshake) {
                WebSocketCloseStatus closeStatus = corruptedWebSocketFrameException.closeStatus();
                String message = corruptedWebSocketFrameException.getMessage();
                if (message == null) {
                    message = closeStatus.reasonText();
                }
                obj = new CloseWebSocketFrame(closeStatus, message);
            } else {
                obj = Unpooled.EMPTY_BUFFER;
            }
            channelHandlerContext.writeAndFlush(obj).addListener(ChannelFutureListener.CLOSE);
        }
        throw corruptedWebSocketFrameException;
    }

    public WebSocket08FrameDecoder(WebSocketDecoderConfig webSocketDecoderConfig) {
        this.state = State.READING_FIRST;
        this.config = (WebSocketDecoderConfig) ObjectUtil.checkNotNull(webSocketDecoderConfig, "decoderConfig");
    }
}
