package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nByteReadChannelJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ByteReadChannelJVM.kt\nio/ktor/utils/io/ByteReadChannel$Companion$Empty$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,362:1\n1#2:363\n*E\n"})
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/ktor/utils/io/ByteChannel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class ByteReadChannel$Companion$Empty$2 extends Lambda implements Function0<ByteChannel> {
    public static final ByteReadChannel$Companion$Empty$2 INSTANCE = new ByteReadChannel$Companion$Empty$2();

    public ByteReadChannel$Companion$Empty$2() {
        super(0);
    }

    @NotNull
    public final ByteChannel invoke() {
        ByteChannel b = ByteChannelKt.b(false, 1, (Object) null);
        ByteWriteChannelKt.a(b);
        return b;
    }
}
