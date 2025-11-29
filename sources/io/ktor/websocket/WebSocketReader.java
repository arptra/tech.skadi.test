package io.ktor.websocket;

import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ReceiveChannel;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001/J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u0006J\u0013\u0010\b\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\u0013\u001a\u00020\u000e8\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010&\u001a\u00020$8\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010%R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020(0'8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010)R\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020(0+8F¢\u0006\u0006\u001a\u0004\b,\u0010-\u0002\u0004\n\u0002\b\u0019¨\u00060"}, d2 = {"Lio/ktor/websocket/WebSocketReader;", "Lkotlinx/coroutines/CoroutineScope;", "Ljava/nio/ByteBuffer;", "buffer", "", "h", "(Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "g", "f", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteReadChannel;", "a", "Lio/ktor/utils/io/ByteReadChannel;", "byteChannel", "Lkotlin/coroutines/CoroutineContext;", "b", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "", "c", "J", "getMaxFrameSize", "()J", "d0", "(J)V", "maxFrameSize", "Lio/ktor/websocket/WebSocketReader$State;", "d", "Lio/ktor/websocket/WebSocketReader$State;", "state", "Lio/ktor/websocket/FrameParser;", "e", "Lio/ktor/websocket/FrameParser;", "frameParser", "Lio/ktor/websocket/SimpleFrameCollector;", "Lio/ktor/websocket/SimpleFrameCollector;", "collector", "Lkotlinx/coroutines/channels/Channel;", "Lio/ktor/websocket/Frame;", "Lkotlinx/coroutines/channels/Channel;", "queue", "Lkotlinx/coroutines/channels/ReceiveChannel;", "i", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "incoming", "State", "ktor-websockets"}, k = 1, mv = {1, 8, 0})
public final class WebSocketReader implements CoroutineScope {

    /* renamed from: a  reason: collision with root package name */
    public final ByteReadChannel f9144a;
    public final CoroutineContext b;
    public long c;
    public State d;
    public final FrameParser e;
    public final SimpleFrameCollector f;
    public final Channel g;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lio/ktor/websocket/WebSocketReader$State;", "", "(Ljava/lang/String;I)V", "HEADER", "BODY", "CLOSED", "ktor-websockets"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum State {
        HEADER,
        BODY,
        CLOSED
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                io.ktor.websocket.WebSocketReader$State[] r0 = io.ktor.websocket.WebSocketReader.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                io.ktor.websocket.WebSocketReader$State r1 = io.ktor.websocket.WebSocketReader.State.HEADER     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                io.ktor.websocket.WebSocketReader$State r1 = io.ktor.websocket.WebSocketReader.State.BODY     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                io.ktor.websocket.WebSocketReader$State r1 = io.ktor.websocket.WebSocketReader.State.CLOSED     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.WebSocketReader.WhenMappings.<clinit>():void");
        }
    }

    public final void d0(long j) {
        this.c = j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object f(kotlin.coroutines.Continuation r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof io.ktor.websocket.WebSocketReader$handleFrameIfProduced$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            io.ktor.websocket.WebSocketReader$handleFrameIfProduced$1 r0 = (io.ktor.websocket.WebSocketReader$handleFrameIfProduced$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.websocket.WebSocketReader$handleFrameIfProduced$1 r0 = new io.ktor.websocket.WebSocketReader$handleFrameIfProduced$1
            r0.<init>(r11, r12)
        L_0x0018:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r11 = r0.L$0
            io.ktor.websocket.WebSocketReader r11 = (io.ktor.websocket.WebSocketReader) r11
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0088
        L_0x002d:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r12)
            io.ktor.websocket.SimpleFrameCollector r12 = r11.f
            boolean r12 = r12.a()
            if (r12 != 0) goto L_0x008d
            io.ktor.websocket.FrameParser r12 = r11.e
            io.ktor.websocket.FrameType r12 = r12.e()
            io.ktor.websocket.FrameType r2 = io.ktor.websocket.FrameType.CLOSE
            if (r12 != r2) goto L_0x004d
            io.ktor.websocket.WebSocketReader$State r12 = io.ktor.websocket.WebSocketReader.State.CLOSED
            goto L_0x004f
        L_0x004d:
            io.ktor.websocket.WebSocketReader$State r12 = io.ktor.websocket.WebSocketReader.State.HEADER
        L_0x004f:
            r11.d = r12
            io.ktor.websocket.FrameParser r12 = r11.e
            io.ktor.websocket.Frame$Companion r4 = io.ktor.websocket.Frame.i
            boolean r5 = r12.d()
            io.ktor.websocket.FrameType r6 = r12.e()
            io.ktor.websocket.SimpleFrameCollector r2 = r11.f
            java.lang.Integer r7 = r12.g()
            java.nio.ByteBuffer r2 = r2.d(r7)
            byte[] r7 = io.ktor.util.NIOKt.e(r2)
            boolean r8 = r12.h()
            boolean r9 = r12.i()
            boolean r10 = r12.j()
            io.ktor.websocket.Frame r12 = r4.a(r5, r6, r7, r8, r9, r10)
            kotlinx.coroutines.channels.Channel r2 = r11.g
            r0.L$0 = r11
            r0.label = r3
            java.lang.Object r12 = r2.L(r12, r0)
            if (r12 != r1) goto L_0x0088
            return r1
        L_0x0088:
            io.ktor.websocket.FrameParser r11 = r11.e
            r11.a()
        L_0x008d:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.WebSocketReader.f(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object g(java.nio.ByteBuffer r11, kotlin.coroutines.Continuation r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof io.ktor.websocket.WebSocketReader$parseLoop$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            io.ktor.websocket.WebSocketReader$parseLoop$1 r0 = (io.ktor.websocket.WebSocketReader$parseLoop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.websocket.WebSocketReader$parseLoop$1 r0 = new io.ktor.websocket.WebSocketReader$parseLoop$1
            r0.<init>(r10, r12)
        L_0x0018:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003f
            if (r2 == r4) goto L_0x0028
            if (r2 != r3) goto L_0x0037
        L_0x0028:
            java.lang.Object r10 = r0.L$1
            java.nio.ByteBuffer r10 = (java.nio.ByteBuffer) r10
            java.lang.Object r11 = r0.L$0
            io.ktor.websocket.WebSocketReader r11 = (io.ktor.websocket.WebSocketReader) r11
            kotlin.ResultKt.throwOnFailure(r12)
            r9 = r11
            r11 = r10
            r10 = r9
            goto L_0x0042
        L_0x0037:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x003f:
            kotlin.ResultKt.throwOnFailure(r12)
        L_0x0042:
            boolean r12 = r11.hasRemaining()
            if (r12 == 0) goto L_0x00c1
            io.ktor.websocket.WebSocketReader$State r12 = r10.d
            int[] r2 = io.ktor.websocket.WebSocketReader.WhenMappings.$EnumSwitchMapping$0
            int r12 = r12.ordinal()
            r12 = r2[r12]
            if (r12 == r4) goto L_0x006f
            if (r12 == r3) goto L_0x005d
            r2 = 3
            if (r12 == r2) goto L_0x005a
            goto L_0x0042
        L_0x005a:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x005d:
            io.ktor.websocket.SimpleFrameCollector r12 = r10.f
            r12.b(r11)
            r0.L$0 = r10
            r0.L$1 = r11
            r0.label = r3
            java.lang.Object r12 = r10.f(r0)
            if (r12 != r1) goto L_0x0042
            return r1
        L_0x006f:
            io.ktor.websocket.FrameParser r12 = r10.e
            r12.b(r11)
            io.ktor.websocket.FrameParser r12 = r10.e
            boolean r12 = r12.c()
            if (r12 == 0) goto L_0x00be
            io.ktor.websocket.WebSocketReader$State r12 = io.ktor.websocket.WebSocketReader.State.BODY
            r10.d = r12
            io.ktor.websocket.FrameParser r12 = r10.e
            long r5 = r12.f()
            r7 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r12 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r12 > 0) goto L_0x00b2
            io.ktor.websocket.FrameParser r12 = r10.e
            long r5 = r12.f()
            long r7 = r10.c
            int r12 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r12 > 0) goto L_0x00b2
            io.ktor.websocket.SimpleFrameCollector r12 = r10.f
            io.ktor.websocket.FrameParser r2 = r10.e
            long r5 = r2.f()
            int r2 = (int) r5
            r12.c(r2, r11)
            r0.L$0 = r10
            r0.L$1 = r11
            r0.label = r4
            java.lang.Object r12 = r10.f(r0)
            if (r12 != r1) goto L_0x0042
            return r1
        L_0x00b2:
            io.ktor.websocket.FrameTooBigException r11 = new io.ktor.websocket.FrameTooBigException
            io.ktor.websocket.FrameParser r10 = r10.e
            long r0 = r10.f()
            r11.<init>(r0)
            throw r11
        L_0x00be:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x00c1:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.WebSocketReader.g(java.nio.ByteBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public CoroutineContext getCoroutineContext() {
        return this.b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object h(java.nio.ByteBuffer r7, kotlin.coroutines.Continuation r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof io.ktor.websocket.WebSocketReader$readLoop$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            io.ktor.websocket.WebSocketReader$readLoop$1 r0 = (io.ktor.websocket.WebSocketReader$readLoop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.websocket.WebSocketReader$readLoop$1 r0 = new io.ktor.websocket.WebSocketReader$readLoop$1
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x004b
            if (r2 == r4) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            java.lang.Object r6 = r0.L$1
            java.nio.ByteBuffer r6 = (java.nio.ByteBuffer) r6
            java.lang.Object r7 = r0.L$0
            io.ktor.websocket.WebSocketReader r7 = (io.ktor.websocket.WebSocketReader) r7
            kotlin.ResultKt.throwOnFailure(r8)
        L_0x0033:
            r5 = r7
            r7 = r6
            r6 = r5
            goto L_0x0087
        L_0x0037:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003f:
            java.lang.Object r6 = r0.L$1
            java.nio.ByteBuffer r6 = (java.nio.ByteBuffer) r6
            java.lang.Object r7 = r0.L$0
            io.ktor.websocket.WebSocketReader r7 = (io.ktor.websocket.WebSocketReader) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0069
        L_0x004b:
            kotlin.ResultKt.throwOnFailure(r8)
            r7.clear()
        L_0x0051:
            io.ktor.websocket.WebSocketReader$State r8 = r6.d
            io.ktor.websocket.WebSocketReader$State r2 = io.ktor.websocket.WebSocketReader.State.CLOSED
            if (r8 == r2) goto L_0x008b
            io.ktor.utils.io.ByteReadChannel r8 = r6.f9144a
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r8 = r8.u(r7, r0)
            if (r8 != r1) goto L_0x0066
            return r1
        L_0x0066:
            r5 = r7
            r7 = r6
            r6 = r5
        L_0x0069:
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            r2 = -1
            if (r8 != r2) goto L_0x0077
            io.ktor.websocket.WebSocketReader$State r6 = io.ktor.websocket.WebSocketReader.State.CLOSED
            r7.d = r6
            goto L_0x008b
        L_0x0077:
            r6.flip()
            r0.L$0 = r7
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r8 = r7.g(r6, r0)
            if (r8 != r1) goto L_0x0033
            return r1
        L_0x0087:
            r7.compact()
            goto L_0x0051
        L_0x008b:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.WebSocketReader.h(java.nio.ByteBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final ReceiveChannel i() {
        return this.g;
    }
}
