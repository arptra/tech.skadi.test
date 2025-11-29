package io.ktor.utils.io.jvm.nio;

import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "bb", "Ljava/nio/ByteBuffer;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class WritingKt$copyTo$copy$1 extends Lambda implements Function1<ByteBuffer, Unit> {
    final /* synthetic */ WritableByteChannel $channel;
    final /* synthetic */ Ref.LongRef $copied;
    final /* synthetic */ long $limit;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WritingKt$copyTo$copy$1(long j, Ref.LongRef longRef, WritableByteChannel writableByteChannel) {
        super(1);
        this.$limit = j;
        this.$copied = longRef;
        this.$channel = writableByteChannel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ByteBuffer) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "bb");
        long j = this.$limit - this.$copied.element;
        if (j < ((long) byteBuffer.remaining())) {
            int limit = byteBuffer.limit();
            byteBuffer.limit(byteBuffer.position() + ((int) j));
            while (byteBuffer.hasRemaining()) {
                this.$channel.write(byteBuffer);
            }
            byteBuffer.limit(limit);
            this.$copied.element += j;
            return;
        }
        long j2 = 0;
        while (byteBuffer.hasRemaining()) {
            j2 += (long) this.$channel.write(byteBuffer);
        }
        this.$copied.element += j2;
    }
}
