package io.ktor.websocket;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nFrameType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FrameType.kt\nio/ktor/websocket/FrameType\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,50:1\n14166#2,14:51\n3133#2,11:65\n*S KotlinDebug\n*F\n+ 1 FrameType.kt\nio/ktor/websocket/FrameType\n*L\n39#1:51,14\n41#1:65,11\n*E\n"})
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0001\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lio/ktor/websocket/FrameType;", "", "controlFrame", "", "opcode", "", "(Ljava/lang/String;IZI)V", "getControlFrame", "()Z", "getOpcode", "()I", "TEXT", "BINARY", "CLOSE", "PING", "PONG", "Companion", "ktor-websockets"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum FrameType {
    TEXT(false, 1),
    BINARY(false, 2),
    CLOSE(true, 8),
    PING(true, 9),
    PONG(true, 10);
    
    @NotNull
    public static final Companion Companion = null;
    /* access modifiers changed from: private */
    @NotNull
    public static final FrameType[] byOpcodeArray = null;
    /* access modifiers changed from: private */
    public static final int maxOpcode = 0;
    private final boolean controlFrame;
    private final int opcode;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lio/ktor/websocket/FrameType$Companion;", "", "<init>", "()V", "", "opcode", "Lio/ktor/websocket/FrameType;", "a", "(I)Lio/ktor/websocket/FrameType;", "", "byOpcodeArray", "[Lio/ktor/websocket/FrameType;", "maxOpcode", "I", "ktor-websockets"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FrameType a(int i) {
            if (i < 0 || i > FrameType.maxOpcode) {
                return null;
            }
            return FrameType.byOpcodeArray[i];
        }

        public Companion() {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0095, code lost:
        r10 = null;
     */
    static {
        /*
            io.ktor.websocket.FrameType r0 = new io.ktor.websocket.FrameType
            java.lang.String r1 = "TEXT"
            r2 = 0
            r3 = 1
            r0.<init>(r1, r2, r2, r3)
            TEXT = r0
            io.ktor.websocket.FrameType r0 = new io.ktor.websocket.FrameType
            java.lang.String r1 = "BINARY"
            r4 = 2
            r0.<init>(r1, r3, r2, r4)
            BINARY = r0
            io.ktor.websocket.FrameType r0 = new io.ktor.websocket.FrameType
            java.lang.String r1 = "CLOSE"
            r5 = 8
            r0.<init>(r1, r4, r3, r5)
            CLOSE = r0
            io.ktor.websocket.FrameType r0 = new io.ktor.websocket.FrameType
            r1 = 3
            r4 = 9
            java.lang.String r5 = "PING"
            r0.<init>(r5, r1, r3, r4)
            PING = r0
            io.ktor.websocket.FrameType r0 = new io.ktor.websocket.FrameType
            r1 = 4
            r4 = 10
            java.lang.String r5 = "PONG"
            r0.<init>(r5, r1, r3, r4)
            PONG = r0
            io.ktor.websocket.FrameType[] r0 = $values()
            $VALUES = r0
            io.ktor.websocket.FrameType$Companion r0 = new io.ktor.websocket.FrameType$Companion
            r1 = 0
            r0.<init>(r1)
            Companion = r0
            io.ktor.websocket.FrameType[] r0 = values()
            int r4 = r0.length
            if (r4 != 0) goto L_0x004f
            r4 = r1
            goto L_0x0076
        L_0x004f:
            r4 = r0[r2]
            int r5 = kotlin.collections.ArraysKt.getLastIndex((T[]) r0)
            if (r5 != 0) goto L_0x0058
            goto L_0x0076
        L_0x0058:
            int r6 = r4.opcode
            kotlin.ranges.IntRange r7 = new kotlin.ranges.IntRange
            r7.<init>(r3, r5)
            kotlin.collections.IntIterator r5 = r7.iterator()
        L_0x0063:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x0076
            int r7 = r5.nextInt()
            r7 = r0[r7]
            int r8 = r7.opcode
            if (r6 >= r8) goto L_0x0063
            r4 = r7
            r6 = r8
            goto L_0x0063
        L_0x0076:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            int r0 = r4.opcode
            maxOpcode = r0
            int r0 = r0 + r3
            io.ktor.websocket.FrameType[] r4 = new io.ktor.websocket.FrameType[r0]
            r5 = r2
        L_0x0081:
            if (r5 >= r0) goto L_0x00a4
            io.ktor.websocket.FrameType[] r6 = values()
            int r7 = r6.length
            r10 = r1
            r8 = r2
            r9 = r8
        L_0x008b:
            if (r8 >= r7) goto L_0x009c
            r11 = r6[r8]
            int r12 = r11.opcode
            if (r12 != r5) goto L_0x0099
            if (r9 == 0) goto L_0x0097
        L_0x0095:
            r10 = r1
            goto L_0x009f
        L_0x0097:
            r9 = r3
            r10 = r11
        L_0x0099:
            int r8 = r8 + 1
            goto L_0x008b
        L_0x009c:
            if (r9 != 0) goto L_0x009f
            goto L_0x0095
        L_0x009f:
            r4[r5] = r10
            int r5 = r5 + 1
            goto L_0x0081
        L_0x00a4:
            byOpcodeArray = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.FrameType.<clinit>():void");
    }

    private FrameType(boolean z, int i) {
        this.controlFrame = z;
        this.opcode = i;
    }

    public final boolean getControlFrame() {
        return this.controlFrame;
    }

    public final int getOpcode() {
        return this.opcode;
    }
}
