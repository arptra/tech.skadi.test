package io.ktor.websocket;

import com.google.common.primitives.SignedBytes;
import com.honey.account.x.c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.internal.ws.WebSocketProtocol;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u00015J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\r\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\u000bR\"\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u00100\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012R$\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t8\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R$\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t8\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u0017R$\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t8\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0016\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017R$\u0010 \u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t8\u0006@BX\u000e¢\u0006\f\n\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001f\u0010\u0017R$\u0010#\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t8\u0006@BX\u000e¢\u0006\f\n\u0004\b!\u0010\u0015\u001a\u0004\b\"\u0010\u0017R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010(\u001a\u00020$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010&R\u0016\u0010)\u001a\u00020$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010&R$\u0010-\u001a\u00020*2\u0006\u0010\u0014\u001a\u00020*8\u0006@BX\u000e¢\u0006\f\n\u0004\b\u001f\u0010+\u001a\u0004\b!\u0010,R(\u00100\u001a\u0004\u0018\u00010$2\b\u0010\u0014\u001a\u0004\u0018\u00010$8\u0006@BX\u000e¢\u0006\f\n\u0004\b\n\u0010.\u001a\u0004\b%\u0010/R\u0011\u00103\u001a\u0002018F¢\u0006\u0006\u001a\u0004\b\u001e\u00102R\u0011\u00104\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017¨\u00066"}, d2 = {"Lio/ktor/websocket/FrameParser;", "", "", "a", "()V", "Ljava/nio/ByteBuffer;", "bb", "b", "(Ljava/nio/ByteBuffer;)V", "", "k", "(Ljava/nio/ByteBuffer;)Z", "l", "m", "n", "Ljava/util/concurrent/atomic/AtomicReference;", "Lio/ktor/websocket/FrameParser$State;", "kotlin.jvm.PlatformType", "Ljava/util/concurrent/atomic/AtomicReference;", "state", "<set-?>", "Z", "d", "()Z", "fin", "c", "h", "rsv1", "i", "rsv2", "e", "j", "rsv3", "f", "getMask", "mask", "", "g", "I", "opcode", "lastOpcode", "lengthLength", "", "J", "()J", "length", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "maskKey", "Lio/ktor/websocket/FrameType;", "()Lio/ktor/websocket/FrameType;", "frameType", "bodyReady", "State", "ktor-websockets"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nFrameParser.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FrameParser.kt\nio/ktor/websocket/FrameParser\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,155:1\n1#2:156\n*E\n"})
public final class FrameParser {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicReference f9130a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public int g;
    public int h;
    public int i;
    public long j;
    public Integer k;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/websocket/FrameParser$State;", "", "(Ljava/lang/String;I)V", "HEADER0", "LENGTH", "MASK_KEY", "BODY", "ktor-websockets"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum State {
        HEADER0,
        LENGTH,
        MASK_KEY,
        BODY
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                io.ktor.websocket.FrameParser$State[] r0 = io.ktor.websocket.FrameParser.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                io.ktor.websocket.FrameParser$State r1 = io.ktor.websocket.FrameParser.State.HEADER0     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                io.ktor.websocket.FrameParser$State r1 = io.ktor.websocket.FrameParser.State.LENGTH     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                io.ktor.websocket.FrameParser$State r1 = io.ktor.websocket.FrameParser.State.MASK_KEY     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                io.ktor.websocket.FrameParser$State r1 = io.ktor.websocket.FrameParser.State.BODY     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.FrameParser.WhenMappings.<clinit>():void");
        }
    }

    public final void a() {
        if (c.a(this.f9130a, State.BODY, State.HEADER0)) {
            this.g = 0;
            this.j = 0;
            this.i = 0;
            this.k = null;
            return;
        }
        throw new IllegalStateException("It should be state BODY but it is " + this.f9130a.get());
    }

    public final void b(ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "bb");
        if (Intrinsics.areEqual((Object) byteBuffer.order(), (Object) ByteOrder.BIG_ENDIAN)) {
            do {
            } while (k(byteBuffer));
            return;
        }
        throw new IllegalArgumentException(("Buffer order should be BIG_ENDIAN but it is " + byteBuffer.order()).toString());
    }

    public final boolean c() {
        return this.f9130a.get() == State.BODY;
    }

    public final boolean d() {
        return this.b;
    }

    public final FrameType e() {
        FrameType a2 = FrameType.Companion.a(this.g);
        if (a2 != null) {
            return a2;
        }
        throw new IllegalStateException("Unsupported opcode " + Integer.toHexString(this.g));
    }

    public final long f() {
        return this.j;
    }

    public final Integer g() {
        return this.k;
    }

    public final boolean h() {
        return this.c;
    }

    public final boolean i() {
        return this.d;
    }

    public final boolean j() {
        return this.e;
    }

    public final boolean k(ByteBuffer byteBuffer) {
        Object obj = this.f9130a.get();
        Intrinsics.checkNotNull(obj);
        int i2 = WhenMappings.$EnumSwitchMapping$0[((State) obj).ordinal()];
        if (i2 == 1) {
            return l(byteBuffer);
        }
        if (i2 == 2) {
            return m(byteBuffer);
        }
        if (i2 == 3) {
            return n(byteBuffer);
        }
        if (i2 == 4) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean l(ByteBuffer byteBuffer) {
        int i2 = 0;
        if (byteBuffer.remaining() < 2) {
            return false;
        }
        byte b2 = byteBuffer.get();
        byte b3 = byteBuffer.get();
        this.b = (b2 & 128) != 0;
        this.c = (b2 & SignedBytes.MAX_POWER_OF_TWO) != 0;
        this.d = (b2 & 32) != 0;
        this.e = (b2 & 16) != 0;
        byte b4 = b2 & 15;
        this.g = b4;
        if (b4 == 0 && this.h == 0) {
            throw new ProtocolViolationException("Can't continue finished frames");
        }
        if (b4 == 0) {
            this.g = this.h;
        } else if (this.h != 0 && !e().getControlFrame()) {
            throw new ProtocolViolationException("Can't start new data frame before finishing previous one");
        }
        if (!e().getControlFrame()) {
            this.h = this.b ? 0 : this.g;
        } else if (!this.b) {
            throw new ProtocolViolationException("control frames can't be fragmented");
        }
        this.f = (b3 & 128) != 0;
        byte b5 = b3 & Byte.MAX_VALUE;
        if (!e().getControlFrame() || b5 <= 125) {
            if (b5 == 126) {
                i2 = 2;
            } else if (b5 == Byte.MAX_VALUE) {
                i2 = 8;
            }
            this.i = i2;
            this.j = i2 == 0 ? (long) b5 : 0;
            if (i2 > 0) {
                this.f9130a.set(State.LENGTH);
            } else if (this.f) {
                this.f9130a.set(State.MASK_KEY);
            } else {
                this.f9130a.set(State.BODY);
            }
            return true;
        }
        throw new ProtocolViolationException("control frames can't be larger than 125 bytes");
    }

    public final boolean m(ByteBuffer byteBuffer) {
        long j2;
        int remaining = byteBuffer.remaining();
        int i2 = this.i;
        if (remaining < i2) {
            return false;
        }
        if (i2 == 2) {
            j2 = ((long) byteBuffer.getShort()) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        } else if (i2 == 8) {
            j2 = byteBuffer.getLong();
        } else {
            throw new IllegalStateException();
        }
        this.j = j2;
        this.f9130a.set(this.f ? State.MASK_KEY : State.BODY);
        return true;
    }

    public final boolean n(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() < 4) {
            return false;
        }
        this.k = Integer.valueOf(byteBuffer.getInt());
        this.f9130a.set(State.BODY);
        return true;
    }
}
