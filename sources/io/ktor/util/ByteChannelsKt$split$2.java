package io.ktor.util;

import io.ktor.utils.io.ByteChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class ByteChannelsKt$split$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ ByteChannel $first;
    final /* synthetic */ ByteChannel $second;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ByteChannelsKt$split$2(ByteChannel byteChannel, ByteChannel byteChannel2) {
        super(1);
        this.$first = byteChannel;
        this.$second = byteChannel2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Throwable th) {
        if (th != null) {
            this.$first.e(th);
            this.$second.e(th);
        }
    }
}
