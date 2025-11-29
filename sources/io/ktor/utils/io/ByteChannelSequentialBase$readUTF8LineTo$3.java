package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\f\b\u0000\u0010\u0002*\u00060\u0003j\u0002`\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "A", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class ByteChannelSequentialBase$readUTF8LineTo$3 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ ByteChannelSequentialBase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialBase$readUTF8LineTo$3(ByteChannelSequentialBase byteChannelSequentialBase) {
        super(1);
        this.this$0 = byteChannelSequentialBase;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        this.this$0.h0(i);
    }
}
