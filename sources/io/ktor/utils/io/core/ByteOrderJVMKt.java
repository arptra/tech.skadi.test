package io.ktor.utils.io.core;

import java.nio.ByteOrder;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Ljava/nio/ByteOrder;", "nioOrder", "Lio/ktor/utils/io/core/ByteOrder;", "b", "(Ljava/nio/ByteOrder;)Lio/ktor/utils/io/core/ByteOrder;", "ktor-io"}, k = 2, mv = {1, 8, 0})
public final class ByteOrderJVMKt {
    public static final ByteOrder b(ByteOrder byteOrder) {
        return byteOrder == ByteOrder.BIG_ENDIAN ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN;
    }
}
