package io.ktor.util.cio;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "buffer", "Ljava/nio/ByteBuffer;", "invoke", "(Ljava/nio/ByteBuffer;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class FileChannelsKt$readChannel$1$3$2 extends Lambda implements Function1<ByteBuffer, Boolean> {
    final /* synthetic */ long $endInclusive;
    final /* synthetic */ FileChannel $fileChannel;
    final /* synthetic */ Ref.LongRef $position;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileChannelsKt$readChannel$1$3$2(long j, Ref.LongRef longRef, FileChannel fileChannel) {
        super(1);
        this.$endInclusive = j;
        this.$position = longRef;
        this.$fileChannel = fileChannel;
    }

    @NotNull
    public final Boolean invoke(@NotNull ByteBuffer byteBuffer) {
        int i;
        Intrinsics.checkNotNullParameter(byteBuffer, "buffer");
        long j = (this.$endInclusive - this.$position.element) + 1;
        if (j < ((long) byteBuffer.remaining())) {
            int limit = byteBuffer.limit();
            byteBuffer.limit(byteBuffer.position() + ((int) j));
            i = this.$fileChannel.read(byteBuffer);
            byteBuffer.limit(limit);
        } else {
            i = this.$fileChannel.read(byteBuffer);
        }
        if (i > 0) {
            this.$position.element += (long) i;
        }
        return Boolean.valueOf(i != -1 && this.$position.element <= this.$endInclusive);
    }
}
