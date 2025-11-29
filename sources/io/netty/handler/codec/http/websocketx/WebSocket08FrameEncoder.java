package io.netty.handler.codec.http.websocketx;

import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

public class WebSocket08FrameEncoder extends MessageToMessageEncoder<WebSocketFrame> implements WebSocketFrameEncoder {
    private static final int GATHERING_WRITE_THRESHOLD = 1024;
    private static final byte OPCODE_BINARY = 2;
    private static final byte OPCODE_CLOSE = 8;
    private static final byte OPCODE_CONT = 0;
    private static final byte OPCODE_PING = 9;
    private static final byte OPCODE_PONG = 10;
    private static final byte OPCODE_TEXT = 1;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) WebSocket08FrameEncoder.class);
    private final boolean maskPayload;

    public WebSocket08FrameEncoder(boolean z) {
        this.maskPayload = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:98:0x01b2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void encode(io.netty.channel.ChannelHandlerContext r17, io.netty.handler.codec.http.websocketx.WebSocketFrame r18, java.util.List<java.lang.Object> r19) throws java.lang.Exception {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            r2 = r19
            io.netty.buffer.ByteBuf r3 = r18.content()
            boolean r4 = r1 instanceof io.netty.handler.codec.http.websocketx.TextWebSocketFrame
            r5 = 10
            r6 = 9
            r7 = 2
            r8 = 1
            r9 = 0
            r10 = 8
            if (r4 == 0) goto L_0x0019
            r4 = r8
            goto L_0x0036
        L_0x0019:
            boolean r4 = r1 instanceof io.netty.handler.codec.http.websocketx.PingWebSocketFrame
            if (r4 == 0) goto L_0x001f
            r4 = r6
            goto L_0x0036
        L_0x001f:
            boolean r4 = r1 instanceof io.netty.handler.codec.http.websocketx.PongWebSocketFrame
            if (r4 == 0) goto L_0x0025
            r4 = r5
            goto L_0x0036
        L_0x0025:
            boolean r4 = r1 instanceof io.netty.handler.codec.http.websocketx.CloseWebSocketFrame
            if (r4 == 0) goto L_0x002b
            r4 = r10
            goto L_0x0036
        L_0x002b:
            boolean r4 = r1 instanceof io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame
            if (r4 == 0) goto L_0x0031
            r4 = r7
            goto L_0x0036
        L_0x0031:
            boolean r4 = r1 instanceof io.netty.handler.codec.http.websocketx.ContinuationWebSocketFrame
            if (r4 == 0) goto L_0x01b6
            r4 = r9
        L_0x0036:
            int r11 = r3.readableBytes()
            io.netty.util.internal.logging.InternalLogger r12 = logger
            boolean r13 = r12.isTraceEnabled()
            if (r13 == 0) goto L_0x004f
            java.lang.Byte r13 = java.lang.Byte.valueOf(r4)
            java.lang.Integer r14 = java.lang.Integer.valueOf(r11)
            java.lang.String r15 = "Encoding WebSocket Frame opCode={} length={}"
            r12.trace(r15, r13, r14)
        L_0x004f:
            boolean r12 = r18.isFinalFragment()
            r13 = 128(0x80, float:1.794E-43)
            if (r12 == 0) goto L_0x0059
            r12 = r13
            goto L_0x005a
        L_0x0059:
            r12 = r9
        L_0x005a:
            int r1 = r18.rsv()
            int r1 = r1 % r10
            r14 = 4
            int r1 = r1 << r14
            r1 = r1 | r12
            int r12 = r4 % 128
            r1 = r1 | r12
            r12 = 125(0x7d, float:1.75E-43)
            if (r4 != r6) goto L_0x0083
            if (r11 > r12) goto L_0x006c
            goto L_0x0083
        L_0x006c:
            io.netty.handler.codec.TooLongFrameException r0 = new io.netty.handler.codec.TooLongFrameException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "invalid payload for PING (payload length must be <= 125, was "
            r1.append(r2)
            r1.append(r11)
            java.lang.String r1 = r1.toString()
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0083:
            boolean r6 = r0.maskPayload     // Catch:{ all -> 0x00ac }
            if (r6 == 0) goto L_0x0089
            r15 = r14
            goto L_0x008a
        L_0x0089:
            r15 = r9
        L_0x008a:
            r4 = 255(0xff, float:3.57E-43)
            if (r11 > r12) goto L_0x00b0
            int r15 = r15 + r7
            int r15 = r15 + r11
            io.netty.buffer.ByteBufAllocator r5 = r17.alloc()     // Catch:{ all -> 0x00ac }
            io.netty.buffer.ByteBuf r5 = r5.buffer(r15)     // Catch:{ all -> 0x00ac }
            r5.writeByte(r1)     // Catch:{ all -> 0x00a8 }
            boolean r1 = r0.maskPayload     // Catch:{ all -> 0x00a8 }
            if (r1 == 0) goto L_0x00a2
            byte r1 = (byte) r11     // Catch:{ all -> 0x00a8 }
            r1 = r1 | r13
            goto L_0x00a3
        L_0x00a2:
            byte r1 = (byte) r11     // Catch:{ all -> 0x00a8 }
        L_0x00a3:
            byte r1 = (byte) r1     // Catch:{ all -> 0x00a8 }
            r5.writeByte(r1)     // Catch:{ all -> 0x00a8 }
            goto L_0x00fe
        L_0x00a8:
            r0 = move-exception
            r4 = r5
            goto L_0x01b0
        L_0x00ac:
            r0 = move-exception
            r4 = 0
            goto L_0x01b0
        L_0x00b0:
            r12 = 65535(0xffff, float:9.1834E-41)
            if (r11 > r12) goto L_0x00e0
            int r15 = r15 + r14
            if (r6 != 0) goto L_0x00bc
            r5 = 1024(0x400, float:1.435E-42)
            if (r11 > r5) goto L_0x00bd
        L_0x00bc:
            int r15 = r15 + r11
        L_0x00bd:
            io.netty.buffer.ByteBufAllocator r5 = r17.alloc()     // Catch:{ all -> 0x00ac }
            io.netty.buffer.ByteBuf r5 = r5.buffer(r15)     // Catch:{ all -> 0x00ac }
            r5.writeByte(r1)     // Catch:{ all -> 0x00a8 }
            boolean r1 = r0.maskPayload     // Catch:{ all -> 0x00a8 }
            if (r1 == 0) goto L_0x00cf
            r1 = 254(0xfe, float:3.56E-43)
            goto L_0x00d1
        L_0x00cf:
            r1 = 126(0x7e, float:1.77E-43)
        L_0x00d1:
            r5.writeByte(r1)     // Catch:{ all -> 0x00a8 }
            int r1 = r11 >>> 8
            r1 = r1 & r4
            r5.writeByte(r1)     // Catch:{ all -> 0x00a8 }
            r1 = r11 & 255(0xff, float:3.57E-43)
            r5.writeByte(r1)     // Catch:{ all -> 0x00a8 }
            goto L_0x00fe
        L_0x00e0:
            int r15 = r15 + r5
            if (r6 == 0) goto L_0x00e4
            int r15 = r15 + r11
        L_0x00e4:
            io.netty.buffer.ByteBufAllocator r5 = r17.alloc()     // Catch:{ all -> 0x00ac }
            io.netty.buffer.ByteBuf r5 = r5.buffer(r15)     // Catch:{ all -> 0x00ac }
            r5.writeByte(r1)     // Catch:{ all -> 0x00a8 }
            boolean r1 = r0.maskPayload     // Catch:{ all -> 0x00a8 }
            if (r1 == 0) goto L_0x00f5
            r1 = r4
            goto L_0x00f7
        L_0x00f5:
            r1 = 127(0x7f, float:1.78E-43)
        L_0x00f7:
            r5.writeByte(r1)     // Catch:{ all -> 0x00a8 }
            long r11 = (long) r11     // Catch:{ all -> 0x00a8 }
            r5.writeLong(r11)     // Catch:{ all -> 0x00a8 }
        L_0x00fe:
            boolean r0 = r0.maskPayload     // Catch:{ all -> 0x00a8 }
            if (r0 == 0) goto L_0x0194
            java.util.Random r0 = io.netty.util.internal.PlatformDependent.threadLocalRandom()     // Catch:{ all -> 0x00a8 }
            r1 = 2147483647(0x7fffffff, float:NaN)
            int r0 = r0.nextInt(r1)     // Catch:{ all -> 0x00a8 }
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocate(r14)     // Catch:{ all -> 0x00a8 }
            java.nio.ByteBuffer r0 = r1.putInt(r0)     // Catch:{ all -> 0x00a8 }
            byte[] r0 = r0.array()     // Catch:{ all -> 0x00a8 }
            r5.writeBytes((byte[]) r0)     // Catch:{ all -> 0x00a8 }
            boolean r1 = r3.isReadable()     // Catch:{ all -> 0x00a8 }
            if (r1 == 0) goto L_0x0190
            java.nio.ByteOrder r1 = r3.order()     // Catch:{ all -> 0x00a8 }
            java.nio.ByteOrder r6 = r5.order()     // Catch:{ all -> 0x00a8 }
            int r11 = r3.readerIndex()     // Catch:{ all -> 0x00a8 }
            int r12 = r3.writerIndex()     // Catch:{ all -> 0x00a8 }
            r13 = 3
            if (r1 != r6) goto L_0x017b
            byte r6 = r0[r9]     // Catch:{ all -> 0x00a8 }
            r6 = r6 & r4
            long r14 = (long) r6     // Catch:{ all -> 0x00a8 }
            r6 = 24
            long r14 = r14 << r6
            byte r6 = r0[r8]     // Catch:{ all -> 0x00a8 }
            r6 = r6 & r4
            int r6 = r6 << 16
            long r9 = (long) r6     // Catch:{ all -> 0x00a8 }
            long r9 = r9 | r14
            byte r6 = r0[r7]     // Catch:{ all -> 0x00a8 }
            r6 = r6 & r4
            r7 = 8
            int r6 = r6 << r7
            long r6 = (long) r6     // Catch:{ all -> 0x00a8 }
            long r6 = r6 | r9
            byte r9 = r0[r13]     // Catch:{ all -> 0x00a8 }
            r4 = r4 & r9
            long r9 = (long) r4     // Catch:{ all -> 0x00a8 }
            long r6 = r6 | r9
            r4 = 32
            long r9 = r6 << r4
            long r6 = r6 | r9
            java.nio.ByteOrder r4 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ all -> 0x00a8 }
            if (r1 != r4) goto L_0x015d
            long r6 = java.lang.Long.reverseBytes(r6)     // Catch:{ all -> 0x00a8 }
        L_0x015d:
            int r1 = r12 + -7
        L_0x015f:
            if (r11 >= r1) goto L_0x016c
            long r9 = r3.getLong(r11)     // Catch:{ all -> 0x00a8 }
            long r9 = r9 ^ r6
            r5.writeLong(r9)     // Catch:{ all -> 0x00a8 }
            int r11 = r11 + 8
            goto L_0x015f
        L_0x016c:
            int r1 = r12 + -3
            if (r11 >= r1) goto L_0x017b
            int r1 = r3.getInt(r11)     // Catch:{ all -> 0x00a8 }
            int r4 = (int) r6     // Catch:{ all -> 0x00a8 }
            r1 = r1 ^ r4
            r5.writeInt(r1)     // Catch:{ all -> 0x00a8 }
            int r11 = r11 + 4
        L_0x017b:
            r9 = 0
        L_0x017c:
            if (r11 >= r12) goto L_0x0190
            byte r1 = r3.getByte(r11)     // Catch:{ all -> 0x00a8 }
            int r4 = r9 + 1
            r6 = r9 & 3
            byte r6 = r0[r6]     // Catch:{ all -> 0x00a8 }
            r1 = r1 ^ r6
            r5.writeByte(r1)     // Catch:{ all -> 0x00a8 }
            int r11 = r11 + 1
            r9 = r4
            goto L_0x017c
        L_0x0190:
            r2.add(r5)     // Catch:{ all -> 0x00a8 }
            goto L_0x01af
        L_0x0194:
            int r0 = r5.writableBytes()     // Catch:{ all -> 0x00a8 }
            int r1 = r3.readableBytes()     // Catch:{ all -> 0x00a8 }
            if (r0 < r1) goto L_0x01a5
            r5.writeBytes((io.netty.buffer.ByteBuf) r3)     // Catch:{ all -> 0x00a8 }
            r2.add(r5)     // Catch:{ all -> 0x00a8 }
            goto L_0x01af
        L_0x01a5:
            r2.add(r5)     // Catch:{ all -> 0x00a8 }
            io.netty.buffer.ByteBuf r0 = r3.retain()     // Catch:{ all -> 0x00a8 }
            r2.add(r0)     // Catch:{ all -> 0x00a8 }
        L_0x01af:
            return
        L_0x01b0:
            if (r4 == 0) goto L_0x01b5
            r4.release()
        L_0x01b5:
            throw r0
        L_0x01b6:
            java.lang.UnsupportedOperationException r0 = new java.lang.UnsupportedOperationException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Cannot encode frame of type: "
            r2.append(r3)
            java.lang.Class r1 = r18.getClass()
            java.lang.String r1 = r1.getName()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http.websocketx.WebSocket08FrameEncoder.encode(io.netty.channel.ChannelHandlerContext, io.netty.handler.codec.http.websocketx.WebSocketFrame, java.util.List):void");
    }
}
