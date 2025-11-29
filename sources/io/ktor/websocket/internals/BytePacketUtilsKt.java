package io.ktor.websocket.internals;

import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.StringsKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lio/ktor/utils/io/core/ByteReadPacket;", "", "data", "", "a", "(Lio/ktor/utils/io/core/ByteReadPacket;[B)Z", "ktor-websockets"}, k = 2, mv = {1, 8, 0})
public final class BytePacketUtilsKt {
    public static final boolean a(ByteReadPacket byteReadPacket, byte[] bArr) {
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "data");
        ByteReadPacket V0 = byteReadPacket.V0();
        V0.n(V0.r0() - ((long) bArr.length));
        return Arrays.equals(StringsKt.d(V0, 0, 1, (Object) null), bArr);
    }
}
