package io.ktor.client.request.forms;

import io.ktor.utils.io.core.ByteReadPacketExtensionsKt;
import io.ktor.utils.io.core.Input;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/ktor/utils/io/core/Input;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nformDsl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 formDsl.kt\nio/ktor/client/request/forms/FormDslKt$formData$1$part$4\n+ 2 ByteReadPacket.kt\nio/ktor/utils/io/core/ByteReadPacketKt\n+ 3 ByteReadPacketExtensions.kt\nio/ktor/utils/io/core/ByteReadPacketExtensionsKt\n*L\n1#1,234:1\n59#2,2:235\n15#3:237\n*S KotlinDebug\n*F\n+ 1 formDsl.kt\nio/ktor/client/request/forms/FormDslKt$formData$1$part$4\n*L\n44#1:235,2\n44#1:237\n*E\n"})
final class FormDslKt$formData$1$part$4 extends Lambda implements Function0<Input> {
    final /* synthetic */ Object $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FormDslKt$formData$1$part$4(Object obj) {
        super(0);
        this.$value = obj;
    }

    @NotNull
    public final Input invoke() {
        byte[] bArr = (byte[]) this.$value;
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, bArr.length);
        Intrinsics.checkNotNullExpressionValue(wrap, "wrap(array, offset, length)");
        return ByteReadPacketExtensionsKt.a(wrap, new FormDslKt$formData$1$part$4$invoke$$inlined$ByteReadPacket$default$1(bArr));
    }
}
