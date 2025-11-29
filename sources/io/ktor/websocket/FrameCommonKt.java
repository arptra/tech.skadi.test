package io.ktor.websocket;

import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.Input;
import io.ktor.utils.io.core.InputPrimitivesKt;
import io.ktor.utils.io.core.OutputKt;
import io.ktor.utils.io.pool.ObjectPool;
import io.ktor.websocket.Frame;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/ktor/websocket/Frame$Close;", "Lio/ktor/websocket/CloseReason;", "a", "(Lio/ktor/websocket/Frame$Close;)Lio/ktor/websocket/CloseReason;", "ktor-websockets"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nFrameCommon.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FrameCommon.kt\nio/ktor/websocket/FrameCommonKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Builder.kt\nio/ktor/utils/io/core/BuilderKt\n*L\n1#1,173:1\n1#2:174\n12#3,11:175\n12#3,11:186\n*S KotlinDebug\n*F\n+ 1 FrameCommon.kt\nio/ktor/websocket/FrameCommonKt\n*L\n142#1:175,11\n161#1:186,11\n*E\n"})
public final class FrameCommonKt {
    public static final CloseReason a(Frame.Close close) {
        Intrinsics.checkNotNullParameter(close, "<this>");
        if (close.b().length < 2) {
            return null;
        }
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder((ObjectPool) null, 1, (DefaultConstructorMarker) null);
        try {
            OutputKt.d(bytePacketBuilder, close.b(), 0, 0, 6, (Object) null);
            ByteReadPacket F0 = bytePacketBuilder.F0();
            return new CloseReason(InputPrimitivesKt.i(F0), Input.L0(F0, 0, 0, 3, (Object) null));
        } catch (Throwable th) {
            bytePacketBuilder.release();
            throw th;
        }
    }
}
