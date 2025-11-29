package io.ktor.utils.io;

import io.ktor.utils.io.charsets.TooLongLineException;
import io.ktor.utils.io.charsets.UTFKt;
import io.ktor.utils.io.internal.ObjectPoolKt;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "buffer", "Ljava/nio/ByteBuffer;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class ByteBufferChannel$readUTF8LineToUtf8Suspend$2 extends Lambda implements Function1<ByteBuffer, Unit> {
    final /* synthetic */ Ref.BooleanRef $caret;
    final /* synthetic */ Ref.IntRef $consumed;
    final /* synthetic */ int $limit;
    final /* synthetic */ Ref.BooleanRef $newLine;
    final /* synthetic */ Appendable $out;
    final /* synthetic */ char[] $output;
    final /* synthetic */ Ref.IntRef $required;
    final /* synthetic */ Ref.ObjectRef<ByteBuffer> $transferBuffer;
    final /* synthetic */ Ref.IntRef $transferredRemaining;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$readUTF8LineToUtf8Suspend$2(Ref.ObjectRef<ByteBuffer> objectRef, int i, char[] cArr, Ref.IntRef intRef, Ref.IntRef intRef2, Ref.BooleanRef booleanRef, Ref.BooleanRef booleanRef2, Appendable appendable, Ref.IntRef intRef3) {
        super(1);
        this.$transferBuffer = objectRef;
        this.$limit = i;
        this.$output = cArr;
        this.$consumed = intRef;
        this.$required = intRef2;
        this.$newLine = booleanRef;
        this.$caret = booleanRef2;
        this.$out = appendable;
        this.$transferredRemaining = intRef3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ByteBuffer) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "buffer");
        int position = byteBuffer.position();
        ByteBuffer byteBuffer2 = (ByteBuffer) this.$transferBuffer.element;
        if (byteBuffer2 != null) {
            int limit = byteBuffer.limit();
            byteBuffer.limit(Math.min(byteBuffer.limit(), byteBuffer.position() + byteBuffer2.remaining()));
            byteBuffer2.put(byteBuffer);
            byteBuffer2.flip();
            byteBuffer.limit(limit);
        } else {
            byteBuffer2 = byteBuffer;
        }
        int i = this.$limit;
        long a2 = UTFKt.a(byteBuffer2, this.$output, 0, i == Integer.MAX_VALUE ? this.$output.length : Math.min(this.$output.length, i - this.$consumed.element));
        Ref.ObjectRef<ByteBuffer> objectRef = this.$transferBuffer;
        ByteBuffer byteBuffer3 = (ByteBuffer) objectRef.element;
        if (byteBuffer3 != null) {
            Ref.IntRef intRef = this.$transferredRemaining;
            byteBuffer.position((position + byteBuffer3.position()) - intRef.element);
            ObjectPoolKt.d().recycle(byteBuffer3);
            objectRef.element = null;
            intRef.element = 0;
        }
        int i2 = (int) (a2 >> 32);
        int i3 = (int) (a2 & 4294967295L);
        this.$required.element = Math.max(1, i3);
        if (i3 == -1) {
            this.$newLine.element = true;
        }
        if (i3 != -1 && byteBuffer.hasRemaining() && byteBuffer.get(byteBuffer.position()) == 13) {
            byteBuffer.position(byteBuffer.position() + 1);
            this.$caret.element = true;
        }
        if (i3 != -1 && byteBuffer.hasRemaining() && byteBuffer.get(byteBuffer.position()) == 10) {
            byteBuffer.position(byteBuffer.position() + 1);
            this.$newLine.element = true;
        }
        Appendable appendable = this.$out;
        if (appendable instanceof StringBuilder) {
            ((StringBuilder) appendable).append(this.$output, 0, i2);
        } else {
            this.$out.append(CharBuffer.wrap(this.$output, 0, i2), 0, i2);
        }
        this.$consumed.element += i2;
        if (i2 == 0 && byteBuffer.remaining() < i3) {
            Ref.ObjectRef<ByteBuffer> objectRef2 = this.$transferBuffer;
            T h0 = ObjectPoolKt.d().h0();
            this.$transferredRemaining.element = byteBuffer.remaining();
            ((ByteBuffer) h0).put(byteBuffer);
            objectRef2.element = h0;
        }
        int i4 = this.$limit;
        if (i4 != Integer.MAX_VALUE && this.$consumed.element >= i4 && !this.$newLine.element) {
            throw new TooLongLineException("Line is longer than limit");
        }
    }
}
