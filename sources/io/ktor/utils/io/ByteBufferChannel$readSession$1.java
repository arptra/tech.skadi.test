package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/LookAheadSession;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class ByteBufferChannel$readSession$1 extends Lambda implements Function1<LookAheadSession, Unit> {
    final /* synthetic */ Function1<ReadSession, Unit> $consumer;
    final /* synthetic */ ByteBufferChannel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$readSession$1(Function1<? super ReadSession, Unit> function1, ByteBufferChannel byteBufferChannel) {
        super(1);
        this.$consumer = function1;
        this.this$0 = byteBufferChannel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LookAheadSession) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull LookAheadSession lookAheadSession) {
        Intrinsics.checkNotNullParameter(lookAheadSession, "$this$lookAhead");
        try {
            this.$consumer.invoke(this.this$0.g);
        } finally {
            this.this$0.g.c();
        }
    }
}
