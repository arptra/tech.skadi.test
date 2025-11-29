package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "content", "Lio/ktor/utils/io/ByteReadChannel;", "a", "([B)Lio/ktor/utils/io/ByteReadChannel;", "ktor-io"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nByteChannelCtor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ByteChannelCtor.kt\nio/ktor/utils/io/ByteChannelCtorKt\n+ 2 Strings.kt\nio/ktor/utils/io/core/StringsKt\n*L\n1#1,66:1\n8#2,3:67\n*S KotlinDebug\n*F\n+ 1 ByteChannelCtor.kt\nio/ktor/utils/io/ByteChannelCtorKt\n*L\n65#1:67,3\n*E\n"})
public final class ByteChannelCtorKt {
    public static final ByteReadChannel a(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "content");
        return ByteChannelKt.c(bArr, 0, bArr.length);
    }
}
