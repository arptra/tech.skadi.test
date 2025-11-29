package io.ktor.client.request.forms;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nByteReadPacketExtensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ByteReadPacketExtensions.kt\nio/ktor/utils/io/core/ByteReadPacketExtensionsKt$ByteReadPacket$1\n+ 2 ByteReadPacket.kt\nio/ktor/utils/io/core/ByteReadPacketKt\n*L\n1#1,42:1\n60#2:43\n*E\n"})
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Ljava/nio/ByteBuffer;", "invoke", "io/ktor/utils/io/core/ByteReadPacketExtensionsKt$ByteReadPacket$1", "io/ktor/utils/io/core/ByteReadPacketKt$ByteReadPacket$$inlined$ByteReadPacket$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class FormDslKt$formData$1$part$4$invoke$$inlined$ByteReadPacket$default$1 extends Lambda implements Function1<ByteBuffer, Unit> {
    final /* synthetic */ byte[] $array;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FormDslKt$formData$1$part$4$invoke$$inlined$ByteReadPacket$default$1(byte[] bArr) {
        super(1);
        this.$array = bArr;
    }

    public final void invoke(@NotNull ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "it");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ByteBuffer) obj);
        return Unit.INSTANCE;
    }
}
