package io.ktor.utils.io;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Ljava/nio/ByteBuffer;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class ByteBufferChannel$readUTF8LineToUtf8Suspend$3 extends Lambda implements Function1<ByteBuffer, Unit> {
    final /* synthetic */ Ref.BooleanRef $newLine;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$readUTF8LineToUtf8Suspend$3(Ref.BooleanRef booleanRef) {
        super(1);
        this.$newLine = booleanRef;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ByteBuffer) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "it");
        if (byteBuffer.get(byteBuffer.position()) == 10) {
            byteBuffer.position(byteBuffer.position() + 1);
            this.$newLine.element = true;
        }
    }
}
