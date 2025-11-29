package io.ktor.utils.io.jvm.nio;

import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "bb", "Ljava/nio/ByteBuffer;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class ReadingKt$copyTo$copy$1 extends Lambda implements Function1<ByteBuffer, Unit> {
    final /* synthetic */ Ref.LongRef $copied;
    final /* synthetic */ Ref.BooleanRef $eof;
    final /* synthetic */ long $limit;
    final /* synthetic */ ReadableByteChannel $this_copyTo;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReadingKt$copyTo$copy$1(long j, Ref.LongRef longRef, ReadableByteChannel readableByteChannel, Ref.BooleanRef booleanRef) {
        super(1);
        this.$limit = j;
        this.$copied = longRef;
        this.$this_copyTo = readableByteChannel;
        this.$eof = booleanRef;
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
            int read = this.$this_copyTo.read(byteBuffer);
            if (read == -1) {
                this.$eof.element = true;
            } else {
                this.$copied.element += (long) read;
            }
            byteBuffer.limit(limit);
            return;
        }
        int read2 = this.$this_copyTo.read(byteBuffer);
        if (read2 == -1) {
            this.$eof.element = true;
            return;
        }
        this.$copied.element += (long) read2;
    }
}
