package io.ktor.websocket;

import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.StringsKt;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.DisposableHandle;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 '2\u00020\u0001:\u0006()*+,-BI\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u001a\u001a\u0004\b\u0016\u0010\u001bR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0013\u001a\u0004\b\u001f\u0010\u0015R\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b \u0010\u0013\u001a\u0004\b \u0010\u0015R\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b!\u0010\u0013\u001a\u0004\b!\u0010\u0015R\u0017\u0010&\u001a\u00020\"8\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b\u0012\u0010%\u0001\u0005./012¨\u00063"}, d2 = {"Lio/ktor/websocket/Frame;", "", "", "fin", "Lio/ktor/websocket/FrameType;", "frameType", "", "data", "Lkotlinx/coroutines/DisposableHandle;", "disposableHandle", "rsv1", "rsv2", "rsv3", "<init>", "(ZLio/ktor/websocket/FrameType;[BLkotlinx/coroutines/DisposableHandle;ZZZ)V", "", "toString", "()Ljava/lang/String;", "a", "Z", "c", "()Z", "b", "Lio/ktor/websocket/FrameType;", "d", "()Lio/ktor/websocket/FrameType;", "[B", "()[B", "Lkotlinx/coroutines/DisposableHandle;", "getDisposableHandle", "()Lkotlinx/coroutines/DisposableHandle;", "e", "f", "g", "Ljava/nio/ByteBuffer;", "h", "Ljava/nio/ByteBuffer;", "()Ljava/nio/ByteBuffer;", "buffer", "i", "Binary", "Close", "Companion", "Ping", "Pong", "Text", "Lio/ktor/websocket/Frame$Binary;", "Lio/ktor/websocket/Frame$Close;", "Lio/ktor/websocket/Frame$Ping;", "Lio/ktor/websocket/Frame$Pong;", "Lio/ktor/websocket/Frame$Text;", "ktor-websockets"}, k = 1, mv = {1, 8, 0})
public abstract class Frame {
    public static final Companion i = new Companion((DefaultConstructorMarker) null);
    public static final byte[] j = new byte[0];

    /* renamed from: a  reason: collision with root package name */
    public final boolean f9129a;
    public final FrameType b;
    public final byte[] c;
    public final DisposableHandle d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final ByteBuffer h;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lio/ktor/websocket/Frame$Binary;", "Lio/ktor/websocket/Frame;", "", "fin", "", "data", "rsv1", "rsv2", "rsv3", "<init>", "(Z[BZZZ)V", "ktor-websockets"}, k = 1, mv = {1, 8, 0})
    public static final class Binary extends Frame {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Binary(boolean z, byte[] bArr, boolean z2, boolean z3, boolean z4) {
            super(z, FrameType.BINARY, bArr, NonDisposableHandle.f9131a, z2, z3, z4, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(bArr, "data");
        }
    }

    @SourceDebugExtension({"SMAP\nFrame.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Frame.kt\nio/ktor/websocket/Frame$Close\n+ 2 Builder.kt\nio/ktor/utils/io/core/BuilderKt\n*L\n1#1,156:1\n12#2,11:157\n*S KotlinDebug\n*F\n+ 1 Frame.kt\nio/ktor/websocket/Frame$Close\n*L\n87#1:157,11\n*E\n"})
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/websocket/Frame$Close;", "Lio/ktor/websocket/Frame;", "", "data", "<init>", "([B)V", "Lio/ktor/websocket/CloseReason;", "reason", "(Lio/ktor/websocket/CloseReason;)V", "Lio/ktor/utils/io/core/ByteReadPacket;", "packet", "(Lio/ktor/utils/io/core/ByteReadPacket;)V", "ktor-websockets"}, k = 1, mv = {1, 8, 0})
    public static final class Close extends Frame {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Close(byte[] bArr) {
            super(true, FrameType.CLOSE, bArr, NonDisposableHandle.f9131a, false, false, false, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(bArr, "data");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Close(ByteReadPacket byteReadPacket) {
            this(StringsKt.d(byteReadPacket, 0, 1, (Object) null));
            Intrinsics.checkNotNullParameter(byteReadPacket, "packet");
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Close(io.ktor.websocket.CloseReason r9) {
            /*
                r8 = this;
                java.lang.String r0 = "reason"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
                io.ktor.utils.io.core.BytePacketBuilder r0 = new io.ktor.utils.io.core.BytePacketBuilder
                r1 = 0
                r2 = 1
                r0.<init>(r1, r2, r1)
                short r1 = r9.a()     // Catch:{ all -> 0x0029 }
                io.ktor.utils.io.core.OutputPrimitivesKt.g(r0, r1)     // Catch:{ all -> 0x0029 }
                java.lang.String r2 = r9.c()     // Catch:{ all -> 0x0029 }
                r6 = 14
                r7 = 0
                r3 = 0
                r4 = 0
                r5 = 0
                r1 = r0
                io.ktor.utils.io.core.StringsKt.m(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0029 }
                io.ktor.utils.io.core.ByteReadPacket r9 = r0.F0()     // Catch:{ all -> 0x0029 }
                r8.<init>((io.ktor.utils.io.core.ByteReadPacket) r9)
                return
            L_0x0029:
                r8 = move-exception
                r0.release()
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.Frame.Close.<init>(io.ktor.websocket.CloseReason):void");
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J=\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lio/ktor/websocket/Frame$Companion;", "", "<init>", "()V", "", "fin", "Lio/ktor/websocket/FrameType;", "frameType", "", "data", "rsv1", "rsv2", "rsv3", "Lio/ktor/websocket/Frame;", "a", "(ZLio/ktor/websocket/FrameType;[BZZZ)Lio/ktor/websocket/Frame;", "Empty", "[B", "ktor-websockets"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|6|7|8|9|10|11|13) */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
            static {
                /*
                    io.ktor.websocket.FrameType[] r0 = io.ktor.websocket.FrameType.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    io.ktor.websocket.FrameType r1 = io.ktor.websocket.FrameType.BINARY     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    io.ktor.websocket.FrameType r1 = io.ktor.websocket.FrameType.TEXT     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    io.ktor.websocket.FrameType r1 = io.ktor.websocket.FrameType.CLOSE     // Catch:{ NoSuchFieldError -> 0x0022 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                    r2 = 3
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
                L_0x0022:
                    io.ktor.websocket.FrameType r1 = io.ktor.websocket.FrameType.PING     // Catch:{ NoSuchFieldError -> 0x002b }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                    r2 = 4
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
                L_0x002b:
                    io.ktor.websocket.FrameType r1 = io.ktor.websocket.FrameType.PONG     // Catch:{ NoSuchFieldError -> 0x0034 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                    r2 = 5
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
                L_0x0034:
                    $EnumSwitchMapping$0 = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.Frame.Companion.WhenMappings.<clinit>():void");
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Frame a(boolean z, FrameType frameType, byte[] bArr, boolean z2, boolean z3, boolean z4) {
            Intrinsics.checkNotNullParameter(frameType, "frameType");
            Intrinsics.checkNotNullParameter(bArr, "data");
            int i = WhenMappings.$EnumSwitchMapping$0[frameType.ordinal()];
            if (i == 1) {
                return new Binary(z, bArr, z2, z3, z4);
            }
            if (i == 2) {
                return new Text(z, bArr, z2, z3, z4);
            }
            if (i == 3) {
                return new Close(bArr);
            }
            if (i == 4) {
                return new Ping(bArr);
            }
            if (i == 5) {
                return new Pong(bArr, NonDisposableHandle.f9131a);
            }
            throw new NoWhenBranchMatchedException();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lio/ktor/websocket/Frame$Ping;", "Lio/ktor/websocket/Frame;", "", "data", "<init>", "([B)V", "ktor-websockets"}, k = 1, mv = {1, 8, 0})
    public static final class Ping extends Frame {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Ping(byte[] bArr) {
            super(true, FrameType.PING, bArr, NonDisposableHandle.f9131a, false, false, false, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(bArr, "data");
        }
    }

    @SourceDebugExtension({"SMAP\nFrame.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Frame.kt\nio/ktor/websocket/Frame$Text\n+ 2 Strings.kt\nio/ktor/utils/io/core/StringsKt\n*L\n1#1,156:1\n7#2,4:157\n*S KotlinDebug\n*F\n+ 1 Frame.kt\nio/ktor/websocket/Frame$Text\n*L\n71#1:157,4\n*E\n"})
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lio/ktor/websocket/Frame$Text;", "Lio/ktor/websocket/Frame;", "", "fin", "", "data", "rsv1", "rsv2", "rsv3", "<init>", "(Z[BZZZ)V", "ktor-websockets"}, k = 1, mv = {1, 8, 0})
    public static final class Text extends Frame {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Text(boolean z, byte[] bArr, boolean z2, boolean z3, boolean z4) {
            super(z, FrameType.TEXT, bArr, NonDisposableHandle.f9131a, z2, z3, z4, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(bArr, "data");
        }
    }

    public /* synthetic */ Frame(boolean z, FrameType frameType, byte[] bArr, DisposableHandle disposableHandle, boolean z2, boolean z3, boolean z4, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, frameType, bArr, disposableHandle, z2, z3, z4);
    }

    public final ByteBuffer a() {
        return this.h;
    }

    public final byte[] b() {
        return this.c;
    }

    public final boolean c() {
        return this.f9129a;
    }

    public final FrameType d() {
        return this.b;
    }

    public final boolean e() {
        return this.e;
    }

    public final boolean f() {
        return this.f;
    }

    public final boolean g() {
        return this.g;
    }

    public String toString() {
        return "Frame " + this.b + " (fin=" + this.f9129a + ", buffer len = " + this.c.length + ')';
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/ktor/websocket/Frame$Pong;", "Lio/ktor/websocket/Frame;", "", "data", "Lkotlinx/coroutines/DisposableHandle;", "disposableHandle", "<init>", "([BLkotlinx/coroutines/DisposableHandle;)V", "ktor-websockets"}, k = 1, mv = {1, 8, 0})
    public static final class Pong extends Frame {
        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Pong(byte[] bArr, DisposableHandle disposableHandle, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(bArr, (i & 2) != 0 ? NonDisposableHandle.f9131a : disposableHandle);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Pong(byte[] bArr, DisposableHandle disposableHandle) {
            super(true, FrameType.PONG, bArr, disposableHandle, false, false, false, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(bArr, "data");
            Intrinsics.checkNotNullParameter(disposableHandle, "disposableHandle");
        }
    }

    public Frame(boolean z, FrameType frameType, byte[] bArr, DisposableHandle disposableHandle, boolean z2, boolean z3, boolean z4) {
        this.f9129a = z;
        this.b = frameType;
        this.c = bArr;
        this.d = disposableHandle;
        this.e = z2;
        this.f = z3;
        this.g = z4;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        Intrinsics.checkNotNullExpressionValue(wrap, "wrap(data)");
        this.h = wrap;
    }
}
