package io.ktor.websocket;

import io.ktor.utils.io.bits.DefaultAllocator;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\u001a\u001b\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a'\u0010\u000b\u001a\u00020\n*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a'\u0010\u0011\u001a\u00020\u0006*\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0001H@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lio/ktor/utils/io/core/ByteReadPacket;", "", "maskKey", "a", "(Lio/ktor/utils/io/core/ByteReadPacket;I)Lio/ktor/utils/io/core/ByteReadPacket;", "Lio/ktor/utils/io/ByteWriteChannel;", "Lio/ktor/websocket/Frame;", "frame", "", "masking", "", "c", "(Lio/ktor/utils/io/ByteWriteChannel;Lio/ktor/websocket/Frame;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteReadChannel;", "", "maxFrameSize", "lastOpcode", "b", "(Lio/ktor/utils/io/ByteReadChannel;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-websockets"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nRawWebSocketCommon.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RawWebSocketCommon.kt\nio/ktor/websocket/RawWebSocketCommonKt\n+ 2 MemoryFactory.kt\nio/ktor/utils/io/bits/MemoryFactoryKt\n+ 3 MemoryPrimitivesJvm.kt\nio/ktor/utils/io/bits/MemoryPrimitivesJvmKt\n+ 4 Builder.kt\nio/ktor/utils/io/core/BuilderKt\n+ 5 Memory.kt\nio/ktor/utils/io/bits/MemoryKt\n+ 6 MemoryJvm.kt\nio/ktor/utils/io/bits/Memory\n+ 7 Utils.kt\nio/ktor/websocket/UtilsKt__UtilsKt\n+ 8 ByteReadPacket.kt\nio/ktor/utils/io/core/ByteReadPacketKt\n+ 9 ByteReadPacketExtensions.kt\nio/ktor/utils/io/core/ByteReadPacketExtensionsKt\n*L\n1#1,264:1\n33#2,5:265\n48#2,8:270\n57#2,2:293\n51#3,2:278\n12#4,7:280\n19#4,4:289\n84#5:287\n26#6:288\n14#7:295\n14#7:296\n14#7:297\n14#7:298\n14#7:299\n59#8,2:300\n15#9:302\n*S KotlinDebug\n*F\n+ 1 RawWebSocketCommon.kt\nio/ktor/websocket/RawWebSocketCommonKt\n*L\n151#1:265,5\n151#1:270,8\n151#1:293,2\n152#1:278,2\n153#1:280,7\n153#1:289,4\n155#1:287\n155#1:288\n168#1:295\n169#1:296\n170#1:297\n171#1:298\n182#1:299\n191#1:300,2\n191#1:302\n*E\n"})
public final class RawWebSocketCommonKt {
    public static final ByteReadPacket a(ByteReadPacket byteReadPacket, int i) {
        BytePacketBuilder bytePacketBuilder;
        DefaultAllocator defaultAllocator = DefaultAllocator.f9084a;
        ByteBuffer c = defaultAllocator.c((long) 4);
        try {
            c.putInt(0, i);
            bytePacketBuilder = new BytePacketBuilder((ObjectPool) null, 1, (DefaultConstructorMarker) null);
            int r0 = (int) byteReadPacket.r0();
            for (int i2 = 0; i2 < r0; i2++) {
                bytePacketBuilder.i0((byte) (byteReadPacket.readByte() ^ c.get(i2 % 4)));
            }
            ByteReadPacket F0 = bytePacketBuilder.F0();
            defaultAllocator.a(c);
            return F0;
        } catch (Throwable th) {
            defaultAllocator.a(c);
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x021b, code lost:
        r19 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x021f, code lost:
        if ((r4 & 32) == 0) goto L_0x0224;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0221, code lost:
        r20 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0224, code lost:
        r20 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0228, code lost:
        if ((r4 & 16) == 0) goto L_0x022d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x022a, code lost:
        r21 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x022d, code lost:
        r21 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0233, code lost:
        return r15.a(r16, r17, r18, r19, r20, r21);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0239, code lost:
        throw new io.ktor.websocket.FrameTooBigException(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x023f, code lost:
        throw new kotlin.NoWhenBranchMatchedException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0256, code lost:
        throw new java.lang.IllegalStateException("Unsupported opcode: " + r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00ba, code lost:
        r4 = ((java.lang.Number) r4).byteValue();
        r2.L$0 = r0;
        r2.J$0 = r9;
        r2.I$0 = r1;
        r2.B$0 = r4;
        r2.label = 2;
        r11 = r0.q(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00cf, code lost:
        if (r11 != r3) goto L_0x00d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00d1, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00d2, code lost:
        r13 = r0;
        r22 = r4;
        r4 = r1;
        r1 = r11;
        r10 = r9;
        r9 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00da, code lost:
        r0 = ((java.lang.Number) r1).byteValue();
        r1 = r9 & 15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00e2, code lost:
        if (r1 != 0) goto L_0x00ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00e4, code lost:
        if (r4 == 0) goto L_0x00e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00ee, code lost:
        throw new io.ktor.websocket.ProtocolViolationException("Can't continue finished frames");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00ef, code lost:
        if (r1 != 0) goto L_0x00f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00f1, code lost:
        r12 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00f3, code lost:
        r12 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00f4, code lost:
        r14 = io.ktor.websocket.FrameType.Companion.a(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00fa, code lost:
        if (r14 == null) goto L_0x0240;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00fc, code lost:
        if (r1 == 0) goto L_0x010f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00fe, code lost:
        if (r4 == 0) goto L_0x010f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0104, code lost:
        if (r14.getControlFrame() == false) goto L_0x0107;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x010e, code lost:
        throw new io.ktor.websocket.ProtocolViolationException("Can't start new data frame before finishing previous one");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0111, code lost:
        if ((r9 & 128) == 0) goto L_0x0115;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0113, code lost:
        r1 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0115, code lost:
        r1 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x011a, code lost:
        if (r14.getControlFrame() == false) goto L_0x0127;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x011c, code lost:
        if (r1 == 0) goto L_0x011f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0126, code lost:
        throw new io.ktor.websocket.ProtocolViolationException("control frames can't be fragmented");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0127, code lost:
        r4 = r0 & Byte.MAX_VALUE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x012b, code lost:
        if (r4 == 126) goto L_0x0166;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x012f, code lost:
        if (r4 == Byte.MAX_VALUE) goto L_0x013b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0131, code lost:
        r6 = (long) r4;
        r4 = r9;
        r11 = r10;
        r9 = r6;
        r22 = r14;
        r14 = r13;
        r13 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x013b, code lost:
        r2.L$0 = r13;
        r2.L$1 = r14;
        r2.J$0 = r10;
        r2.B$0 = r9;
        r2.B$1 = r0;
        r2.I$0 = r1;
        r2.label = 4;
        r4 = r13.E(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x014e, code lost:
        if (r4 != r3) goto L_0x0151;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0150, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0151, code lost:
        r12 = r14;
        r22 = r4;
        r4 = r0;
        r0 = r1;
        r1 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0158, code lost:
        r6 = ((java.lang.Number) r1).longValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x015e, code lost:
        r1 = r0;
        r0 = r4;
        r4 = r9;
        r14 = r13;
        r13 = r12;
        r11 = r10;
        r9 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0166, code lost:
        r2.L$0 = r13;
        r2.L$1 = r14;
        r2.J$0 = r10;
        r2.B$0 = r9;
        r2.B$1 = r0;
        r2.I$0 = r1;
        r2.label = 3;
        r4 = r13.G(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0179, code lost:
        if (r4 != r3) goto L_0x017c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x017b, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x017c, code lost:
        r12 = r14;
        r22 = r4;
        r4 = r0;
        r0 = r1;
        r1 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0183, code lost:
        r6 = ((long) ((java.lang.Number) r1).shortValue()) & okhttp3.internal.ws.WebSocketProtocol.PAYLOAD_SHORT_MAX;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0193, code lost:
        if (r13.getControlFrame() == false) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0199, code lost:
        if (r9 > 125) goto L_0x019c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01a3, code lost:
        throw new io.ktor.websocket.ProtocolViolationException("control frames can't be larger than 125 bytes");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01a6, code lost:
        if ((r0 & 128) == 0) goto L_0x01aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01a8, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01aa, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01ab, code lost:
        if (r0 != true) goto L_0x01d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01ad, code lost:
        r2.L$0 = r14;
        r2.L$1 = r13;
        r2.J$0 = r11;
        r2.B$0 = r4;
        r2.I$0 = r1;
        r2.J$1 = r9;
        r2.label = 5;
        r0 = r14.n(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01c0, code lost:
        if (r0 != r3) goto L_0x01c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01c2, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01c3, code lost:
        r22 = r1;
        r1 = r0;
        r0 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01c8, code lost:
        r22 = ((java.lang.Number) r1).intValue();
        r1 = r0;
        r0 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01d4, code lost:
        if (r0 != false) goto L_0x023a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01d6, code lost:
        r0 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01dc, code lost:
        if (r9 > com.here.posclient.UpdateOptions.SOURCE_ANY) goto L_0x0234;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01e0, code lost:
        if (r9 > r11) goto L_0x0234;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01e2, code lost:
        r2.L$0 = r13;
        r2.L$1 = null;
        r2.B$0 = r4;
        r2.I$0 = r1;
        r2.I$1 = r0;
        r2.label = 6;
        r2 = r14.j((int) r9, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01f4, code lost:
        if (r2 != r3) goto L_0x01f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01f6, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01f7, code lost:
        r3 = r1;
        r1 = r2;
        r17 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01fb, code lost:
        r1 = (io.ktor.utils.io.core.ByteReadPacket) r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01fe, code lost:
        if (r0 != -1) goto L_0x0201;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0201, code lost:
        r1 = a(r1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0205, code lost:
        r15 = io.ktor.websocket.Frame.i;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0207, code lost:
        if (r3 == 0) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0209, code lost:
        r16 = true;
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x020d, code lost:
        r0 = false;
        r16 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0210, code lost:
        r18 = io.ktor.utils.io.core.StringsKt.d(r1, r0 ? 1 : 0, 1, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0216, code lost:
        if ((r4 & com.google.common.primitives.SignedBytes.MAX_POWER_OF_TWO) == 0) goto L_0x021b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0218, code lost:
        r19 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object b(io.ktor.utils.io.ByteReadChannel r23, long r24, int r26, kotlin.coroutines.Continuation r27) {
        /*
            r0 = r23
            r1 = r27
            boolean r2 = r1 instanceof io.ktor.websocket.RawWebSocketCommonKt$readFrame$1
            if (r2 == 0) goto L_0x0017
            r2 = r1
            io.ktor.websocket.RawWebSocketCommonKt$readFrame$1 r2 = (io.ktor.websocket.RawWebSocketCommonKt$readFrame$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.label = r3
            goto L_0x001c
        L_0x0017:
            io.ktor.websocket.RawWebSocketCommonKt$readFrame$1 r2 = new io.ktor.websocket.RawWebSocketCommonKt$readFrame$1
            r2.<init>(r1)
        L_0x001c:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 0
            r8 = 1
            switch(r4) {
                case 0: goto L_0x00a4;
                case 1: goto L_0x0092;
                case 2: goto L_0x0081;
                case 3: goto L_0x006c;
                case 4: goto L_0x0057;
                case 5: goto L_0x0042;
                case 6: goto L_0x0031;
                default: goto L_0x0029;
            }
        L_0x0029:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0031:
            int r0 = r2.I$1
            int r3 = r2.I$0
            byte r4 = r2.B$0
            java.lang.Object r2 = r2.L$0
            io.ktor.websocket.FrameType r2 = (io.ktor.websocket.FrameType) r2
            kotlin.ResultKt.throwOnFailure(r1)
            r17 = r2
            goto L_0x01fb
        L_0x0042:
            long r9 = r2.J$1
            int r0 = r2.I$0
            byte r4 = r2.B$0
            long r11 = r2.J$0
            java.lang.Object r13 = r2.L$1
            io.ktor.websocket.FrameType r13 = (io.ktor.websocket.FrameType) r13
            java.lang.Object r14 = r2.L$0
            io.ktor.utils.io.ByteReadChannel r14 = (io.ktor.utils.io.ByteReadChannel) r14
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x01c8
        L_0x0057:
            int r0 = r2.I$0
            byte r4 = r2.B$1
            byte r9 = r2.B$0
            long r10 = r2.J$0
            java.lang.Object r12 = r2.L$1
            io.ktor.websocket.FrameType r12 = (io.ktor.websocket.FrameType) r12
            java.lang.Object r13 = r2.L$0
            io.ktor.utils.io.ByteReadChannel r13 = (io.ktor.utils.io.ByteReadChannel) r13
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0158
        L_0x006c:
            int r0 = r2.I$0
            byte r4 = r2.B$1
            byte r9 = r2.B$0
            long r10 = r2.J$0
            java.lang.Object r12 = r2.L$1
            io.ktor.websocket.FrameType r12 = (io.ktor.websocket.FrameType) r12
            java.lang.Object r13 = r2.L$0
            io.ktor.utils.io.ByteReadChannel r13 = (io.ktor.utils.io.ByteReadChannel) r13
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0183
        L_0x0081:
            byte r0 = r2.B$0
            int r4 = r2.I$0
            long r9 = r2.J$0
            java.lang.Object r11 = r2.L$0
            io.ktor.utils.io.ByteReadChannel r11 = (io.ktor.utils.io.ByteReadChannel) r11
            kotlin.ResultKt.throwOnFailure(r1)
            r13 = r11
            r10 = r9
            r9 = r0
            goto L_0x00da
        L_0x0092:
            int r0 = r2.I$0
            long r9 = r2.J$0
            java.lang.Object r4 = r2.L$0
            io.ktor.utils.io.ByteReadChannel r4 = (io.ktor.utils.io.ByteReadChannel) r4
            kotlin.ResultKt.throwOnFailure(r1)
            r22 = r1
            r1 = r0
            r0 = r4
            r4 = r22
            goto L_0x00ba
        L_0x00a4:
            kotlin.ResultKt.throwOnFailure(r1)
            r2.L$0 = r0
            r9 = r24
            r2.J$0 = r9
            r1 = r26
            r2.I$0 = r1
            r2.label = r8
            java.lang.Object r4 = r0.q(r2)
            if (r4 != r3) goto L_0x00ba
            return r3
        L_0x00ba:
            java.lang.Number r4 = (java.lang.Number) r4
            byte r4 = r4.byteValue()
            r2.L$0 = r0
            r2.J$0 = r9
            r2.I$0 = r1
            r2.B$0 = r4
            r11 = 2
            r2.label = r11
            java.lang.Object r11 = r0.q(r2)
            if (r11 != r3) goto L_0x00d2
            return r3
        L_0x00d2:
            r13 = r0
            r22 = r4
            r4 = r1
            r1 = r11
            r10 = r9
            r9 = r22
        L_0x00da:
            java.lang.Number r1 = (java.lang.Number) r1
            byte r0 = r1.byteValue()
            r1 = r9 & 15
            if (r1 != 0) goto L_0x00ef
            if (r4 == 0) goto L_0x00e7
            goto L_0x00ef
        L_0x00e7:
            io.ktor.websocket.ProtocolViolationException r0 = new io.ktor.websocket.ProtocolViolationException
            java.lang.String r1 = "Can't continue finished frames"
            r0.<init>(r1)
            throw r0
        L_0x00ef:
            if (r1 != 0) goto L_0x00f3
            r12 = r4
            goto L_0x00f4
        L_0x00f3:
            r12 = r1
        L_0x00f4:
            io.ktor.websocket.FrameType$Companion r14 = io.ktor.websocket.FrameType.Companion
            io.ktor.websocket.FrameType r14 = r14.a(r12)
            if (r14 == 0) goto L_0x0240
            if (r1 == 0) goto L_0x010f
            if (r4 == 0) goto L_0x010f
            boolean r1 = r14.getControlFrame()
            if (r1 == 0) goto L_0x0107
            goto L_0x010f
        L_0x0107:
            io.ktor.websocket.ProtocolViolationException r0 = new io.ktor.websocket.ProtocolViolationException
            java.lang.String r1 = "Can't start new data frame before finishing previous one"
            r0.<init>(r1)
            throw r0
        L_0x010f:
            r1 = r9 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0115
            r1 = r8
            goto L_0x0116
        L_0x0115:
            r1 = 0
        L_0x0116:
            boolean r4 = r14.getControlFrame()
            if (r4 == 0) goto L_0x0127
            if (r1 == 0) goto L_0x011f
            goto L_0x0127
        L_0x011f:
            io.ktor.websocket.ProtocolViolationException r0 = new io.ktor.websocket.ProtocolViolationException
            java.lang.String r1 = "control frames can't be fragmented"
            r0.<init>(r1)
            throw r0
        L_0x0127:
            r4 = r0 & 127(0x7f, float:1.78E-43)
            r12 = 126(0x7e, float:1.77E-43)
            if (r4 == r12) goto L_0x0166
            r12 = 127(0x7f, float:1.78E-43)
            if (r4 == r12) goto L_0x013b
            long r6 = (long) r4
            r4 = r9
            r11 = r10
            r9 = r6
            r22 = r14
            r14 = r13
            r13 = r22
            goto L_0x018f
        L_0x013b:
            r2.L$0 = r13
            r2.L$1 = r14
            r2.J$0 = r10
            r2.B$0 = r9
            r2.B$1 = r0
            r2.I$0 = r1
            r4 = 4
            r2.label = r4
            java.lang.Object r4 = r13.E(r2)
            if (r4 != r3) goto L_0x0151
            return r3
        L_0x0151:
            r12 = r14
            r22 = r4
            r4 = r0
            r0 = r1
            r1 = r22
        L_0x0158:
            java.lang.Number r1 = (java.lang.Number) r1
            long r6 = r1.longValue()
        L_0x015e:
            r1 = r0
            r0 = r4
            r4 = r9
            r14 = r13
            r13 = r12
            r11 = r10
            r9 = r6
            goto L_0x018f
        L_0x0166:
            r2.L$0 = r13
            r2.L$1 = r14
            r2.J$0 = r10
            r2.B$0 = r9
            r2.B$1 = r0
            r2.I$0 = r1
            r4 = 3
            r2.label = r4
            java.lang.Object r4 = r13.G(r2)
            if (r4 != r3) goto L_0x017c
            return r3
        L_0x017c:
            r12 = r14
            r22 = r4
            r4 = r0
            r0 = r1
            r1 = r22
        L_0x0183:
            java.lang.Number r1 = (java.lang.Number) r1
            short r1 = r1.shortValue()
            long r6 = (long) r1
            r15 = 65535(0xffff, double:3.23786E-319)
            long r6 = r6 & r15
            goto L_0x015e
        L_0x018f:
            boolean r6 = r13.getControlFrame()
            if (r6 == 0) goto L_0x01a4
            r6 = 125(0x7d, double:6.2E-322)
            int r6 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r6 > 0) goto L_0x019c
            goto L_0x01a4
        L_0x019c:
            io.ktor.websocket.ProtocolViolationException r0 = new io.ktor.websocket.ProtocolViolationException
            java.lang.String r1 = "control frames can't be larger than 125 bytes"
            r0.<init>(r1)
            throw r0
        L_0x01a4:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x01aa
            r0 = r8
            goto L_0x01ab
        L_0x01aa:
            r0 = 0
        L_0x01ab:
            if (r0 != r8) goto L_0x01d4
            r2.L$0 = r14
            r2.L$1 = r13
            r2.J$0 = r11
            r2.B$0 = r4
            r2.I$0 = r1
            r2.J$1 = r9
            r0 = 5
            r2.label = r0
            java.lang.Object r0 = r14.n(r2)
            if (r0 != r3) goto L_0x01c3
            return r3
        L_0x01c3:
            r22 = r1
            r1 = r0
            r0 = r22
        L_0x01c8:
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            r22 = r1
            r1 = r0
            r0 = r22
            goto L_0x01d7
        L_0x01d4:
            if (r0 != 0) goto L_0x023a
            r0 = -1
        L_0x01d7:
            r6 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r6 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r6 > 0) goto L_0x0234
            int r6 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r6 > 0) goto L_0x0234
            int r6 = (int) r9
            r2.L$0 = r13
            r2.L$1 = r5
            r2.B$0 = r4
            r2.I$0 = r1
            r2.I$1 = r0
            r7 = 6
            r2.label = r7
            java.lang.Object r2 = r14.j(r6, r2)
            if (r2 != r3) goto L_0x01f7
            return r3
        L_0x01f7:
            r3 = r1
            r1 = r2
            r17 = r13
        L_0x01fb:
            io.ktor.utils.io.core.ByteReadPacket r1 = (io.ktor.utils.io.core.ByteReadPacket) r1
            r2 = -1
            if (r0 != r2) goto L_0x0201
            goto L_0x0205
        L_0x0201:
            io.ktor.utils.io.core.ByteReadPacket r1 = a(r1, r0)
        L_0x0205:
            io.ktor.websocket.Frame$Companion r15 = io.ktor.websocket.Frame.i
            if (r3 == 0) goto L_0x020d
            r16 = r8
            r0 = 0
            goto L_0x0210
        L_0x020d:
            r0 = 0
            r16 = 0
        L_0x0210:
            byte[] r18 = io.ktor.utils.io.core.StringsKt.d(r1, r0, r8, r5)
            r1 = r4 & 64
            if (r1 == 0) goto L_0x021b
            r19 = r8
            goto L_0x021d
        L_0x021b:
            r19 = r0
        L_0x021d:
            r1 = r4 & 32
            if (r1 == 0) goto L_0x0224
            r20 = r8
            goto L_0x0226
        L_0x0224:
            r20 = r0
        L_0x0226:
            r1 = r4 & 16
            if (r1 == 0) goto L_0x022d
            r21 = r8
            goto L_0x022f
        L_0x022d:
            r21 = r0
        L_0x022f:
            io.ktor.websocket.Frame r0 = r15.a(r16, r17, r18, r19, r20, r21)
            return r0
        L_0x0234:
            io.ktor.websocket.FrameTooBigException r0 = new io.ktor.websocket.FrameTooBigException
            r0.<init>(r9)
            throw r0
        L_0x023a:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x0240:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unsupported opcode: "
            r1.append(r2)
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.RawWebSocketCommonKt.b(io.ktor.utils.io.ByteReadChannel, long, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ce, code lost:
        if (r11 >= 126) goto L_0x00d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00d0, code lost:
        r2 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00d5, code lost:
        if (r11 > 65535) goto L_0x00d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00d7, code lost:
        r2 = 126;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d9, code lost:
        r2 = 127;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00da, code lost:
        if (r13 == false) goto L_0x00dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00dd, code lost:
        r5 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00de, code lost:
        r0.L$0 = r10;
        r0.L$1 = r12;
        r0.Z$0 = r13;
        r0.I$0 = r11;
        r0.I$1 = r2;
        r0.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00f1, code lost:
        if (r10.C((byte) (r5 | r2), r0) != r1) goto L_0x00f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f3, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00f4, code lost:
        r5 = r10;
        r10 = r2;
        r2 = r12;
        r12 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00f8, code lost:
        if (r10 == 126) goto L_0x0115;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00fa, code lost:
        if (r10 == 127) goto L_0x00fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00fd, code lost:
        r0.L$0 = r5;
        r0.L$1 = r2;
        r0.Z$0 = r12;
        r0.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x010b, code lost:
        if (r5.H((long) r11, r0) != r1) goto L_0x010e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x010d, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x010e, code lost:
        r10 = r12;
        r11 = r2;
        r12 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0111, code lost:
        r2 = r11;
        r5 = r12;
        r12 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0115, code lost:
        r0.L$0 = r5;
        r0.L$1 = r2;
        r0.Z$0 = r12;
        r0.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0123, code lost:
        if (r5.t((short) r11, r0) != r1) goto L_0x010e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0125, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0126, code lost:
        r10 = r2.b();
        r11 = java.nio.ByteBuffer.wrap(r10, 0, r10.length);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, "wrap(array, offset, length)");
        r11 = io.ktor.utils.io.core.ByteReadPacketExtensionsKt.a(r11, new io.ktor.websocket.RawWebSocketCommonKt$writeFrame$$inlined$ByteReadPacket$default$1(r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x013e, code lost:
        if (r12 != true) goto L_0x015d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0140, code lost:
        r10 = kotlin.random.Random.Default.nextInt();
        r0.L$0 = r5;
        r0.L$1 = r11;
        r0.I$0 = r10;
        r0.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0153, code lost:
        if (r5.O(r10, r0) != r1) goto L_0x0156;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0155, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0156, code lost:
        r12 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0157, code lost:
        r11 = a(r11, r10);
        r5 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x015d, code lost:
        if (r12 != false) goto L_0x0171;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x015f, code lost:
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x016b, code lost:
        if (r5.w(r11, r0) != r1) goto L_0x016e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x016d, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0170, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0176, code lost:
        throw new kotlin.NoWhenBranchMatchedException();
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object c(io.ktor.utils.io.ByteWriteChannel r10, io.ktor.websocket.Frame r11, boolean r12, kotlin.coroutines.Continuation r13) {
        /*
            boolean r0 = r13 instanceof io.ktor.websocket.RawWebSocketCommonKt$writeFrame$1
            if (r0 == 0) goto L_0x0013
            r0 = r13
            io.ktor.websocket.RawWebSocketCommonKt$writeFrame$1 r0 = (io.ktor.websocket.RawWebSocketCommonKt$writeFrame$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.websocket.RawWebSocketCommonKt$writeFrame$1 r0 = new io.ktor.websocket.RawWebSocketCommonKt$writeFrame$1
            r0.<init>(r13)
        L_0x0018:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 127(0x7f, float:1.78E-43)
            r4 = 1
            r5 = 128(0x80, float:1.794E-43)
            r6 = 126(0x7e, float:1.77E-43)
            r7 = 0
            switch(r2) {
                case 0: goto L_0x007d;
                case 1: goto L_0x0069;
                case 2: goto L_0x0056;
                case 3: goto L_0x0047;
                case 4: goto L_0x0047;
                case 5: goto L_0x0038;
                case 6: goto L_0x0033;
                default: goto L_0x002b;
            }
        L_0x002b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x016e
        L_0x0038:
            int r10 = r0.I$0
            java.lang.Object r11 = r0.L$1
            io.ktor.utils.io.core.ByteReadPacket r11 = (io.ktor.utils.io.core.ByteReadPacket) r11
            java.lang.Object r12 = r0.L$0
            io.ktor.utils.io.ByteWriteChannel r12 = (io.ktor.utils.io.ByteWriteChannel) r12
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0157
        L_0x0047:
            boolean r10 = r0.Z$0
            java.lang.Object r11 = r0.L$1
            io.ktor.websocket.Frame r11 = (io.ktor.websocket.Frame) r11
            java.lang.Object r12 = r0.L$0
            io.ktor.utils.io.ByteWriteChannel r12 = (io.ktor.utils.io.ByteWriteChannel) r12
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0111
        L_0x0056:
            int r10 = r0.I$1
            int r11 = r0.I$0
            boolean r12 = r0.Z$0
            java.lang.Object r2 = r0.L$1
            io.ktor.websocket.Frame r2 = (io.ktor.websocket.Frame) r2
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteWriteChannel r5 = (io.ktor.utils.io.ByteWriteChannel) r5
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00f8
        L_0x0069:
            int r10 = r0.I$0
            boolean r12 = r0.Z$0
            java.lang.Object r11 = r0.L$1
            io.ktor.websocket.Frame r11 = (io.ktor.websocket.Frame) r11
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteWriteChannel r2 = (io.ktor.utils.io.ByteWriteChannel) r2
            kotlin.ResultKt.throwOnFailure(r13)
            r13 = r12
            r12 = r11
            r11 = r10
            r10 = r2
            goto L_0x00ce
        L_0x007d:
            kotlin.ResultKt.throwOnFailure(r13)
            byte[] r13 = r11.b()
            int r13 = r13.length
            boolean r2 = r11.c()
            if (r2 == 0) goto L_0x008d
            r2 = r5
            goto L_0x008e
        L_0x008d:
            r2 = r7
        L_0x008e:
            boolean r8 = r11.e()
            if (r8 == 0) goto L_0x0097
            r8 = 64
            goto L_0x0098
        L_0x0097:
            r8 = r7
        L_0x0098:
            r2 = r2 | r8
            boolean r8 = r11.f()
            if (r8 == 0) goto L_0x00a2
            r8 = 32
            goto L_0x00a3
        L_0x00a2:
            r8 = r7
        L_0x00a3:
            r2 = r2 | r8
            boolean r8 = r11.g()
            if (r8 == 0) goto L_0x00ad
            r8 = 16
            goto L_0x00ae
        L_0x00ad:
            r8 = r7
        L_0x00ae:
            r2 = r2 | r8
            io.ktor.websocket.FrameType r8 = r11.d()
            int r8 = r8.getOpcode()
            r2 = r2 | r8
            byte r2 = (byte) r2
            r0.L$0 = r10
            r0.L$1 = r11
            r0.Z$0 = r12
            r0.I$0 = r13
            r0.label = r4
            java.lang.Object r2 = r10.C(r2, r0)
            if (r2 != r1) goto L_0x00ca
            return r1
        L_0x00ca:
            r9 = r12
            r12 = r11
            r11 = r13
            r13 = r9
        L_0x00ce:
            if (r11 >= r6) goto L_0x00d2
            r2 = r11
            goto L_0x00da
        L_0x00d2:
            r2 = 65535(0xffff, float:9.1834E-41)
            if (r11 > r2) goto L_0x00d9
            r2 = r6
            goto L_0x00da
        L_0x00d9:
            r2 = r3
        L_0x00da:
            if (r13 == 0) goto L_0x00dd
            goto L_0x00de
        L_0x00dd:
            r5 = r7
        L_0x00de:
            r5 = r5 | r2
            byte r5 = (byte) r5
            r0.L$0 = r10
            r0.L$1 = r12
            r0.Z$0 = r13
            r0.I$0 = r11
            r0.I$1 = r2
            r8 = 2
            r0.label = r8
            java.lang.Object r5 = r10.C(r5, r0)
            if (r5 != r1) goto L_0x00f4
            return r1
        L_0x00f4:
            r5 = r10
            r10 = r2
            r2 = r12
            r12 = r13
        L_0x00f8:
            if (r10 == r6) goto L_0x0115
            if (r10 == r3) goto L_0x00fd
            goto L_0x0126
        L_0x00fd:
            long r10 = (long) r11
            r0.L$0 = r5
            r0.L$1 = r2
            r0.Z$0 = r12
            r13 = 4
            r0.label = r13
            java.lang.Object r10 = r5.H(r10, r0)
            if (r10 != r1) goto L_0x010e
            return r1
        L_0x010e:
            r10 = r12
            r11 = r2
            r12 = r5
        L_0x0111:
            r2 = r11
            r5 = r12
            r12 = r10
            goto L_0x0126
        L_0x0115:
            short r10 = (short) r11
            r0.L$0 = r5
            r0.L$1 = r2
            r0.Z$0 = r12
            r11 = 3
            r0.label = r11
            java.lang.Object r10 = r5.t(r10, r0)
            if (r10 != r1) goto L_0x010e
            return r1
        L_0x0126:
            byte[] r10 = r2.b()
            int r11 = r10.length
            java.nio.ByteBuffer r11 = java.nio.ByteBuffer.wrap(r10, r7, r11)
            java.lang.String r13 = "wrap(array, offset, length)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r13)
            io.ktor.websocket.RawWebSocketCommonKt$writeFrame$$inlined$ByteReadPacket$default$1 r13 = new io.ktor.websocket.RawWebSocketCommonKt$writeFrame$$inlined$ByteReadPacket$default$1
            r13.<init>(r10)
            io.ktor.utils.io.core.ByteReadPacket r11 = io.ktor.utils.io.core.ByteReadPacketExtensionsKt.a(r11, r13)
            if (r12 != r4) goto L_0x015d
            kotlin.random.Random$Default r10 = kotlin.random.Random.Default
            int r10 = r10.nextInt()
            r0.L$0 = r5
            r0.L$1 = r11
            r0.I$0 = r10
            r12 = 5
            r0.label = r12
            java.lang.Object r12 = r5.O(r10, r0)
            if (r12 != r1) goto L_0x0156
            return r1
        L_0x0156:
            r12 = r5
        L_0x0157:
            io.ktor.utils.io.core.ByteReadPacket r11 = a(r11, r10)
            r5 = r12
            goto L_0x015f
        L_0x015d:
            if (r12 != 0) goto L_0x0171
        L_0x015f:
            r10 = 0
            r0.L$0 = r10
            r0.L$1 = r10
            r10 = 6
            r0.label = r10
            java.lang.Object r10 = r5.w(r11, r0)
            if (r10 != r1) goto L_0x016e
            return r1
        L_0x016e:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x0171:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.RawWebSocketCommonKt.c(io.ktor.utils.io.ByteWriteChannel, io.ktor.websocket.Frame, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
