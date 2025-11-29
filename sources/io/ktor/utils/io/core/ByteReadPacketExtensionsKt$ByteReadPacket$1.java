package io.ktor.utils.io.core;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Ljava/nio/ByteBuffer;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
@SourceDebugExtension({"SMAP\nByteReadPacketExtensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ByteReadPacketExtensions.kt\nio/ktor/utils/io/core/ByteReadPacketExtensionsKt$ByteReadPacket$1\n*L\n1#1,42:1\n*E\n"})
public final class ByteReadPacketExtensionsKt$ByteReadPacket$1 extends Lambda implements Function1<ByteBuffer, Unit> {
    final /* synthetic */ byte[] $array;
    final /* synthetic */ Function1<byte[], Unit> $block;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ByteReadPacketExtensionsKt$ByteReadPacket$1(Function1<? super byte[], Unit> function1, byte[] bArr) {
        super(1);
        this.$block = function1;
        this.$array = bArr;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ByteBuffer) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "it");
        this.$block.invoke(this.$array);
    }
}
