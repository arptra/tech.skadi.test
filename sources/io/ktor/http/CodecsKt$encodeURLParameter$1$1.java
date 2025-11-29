package io.ktor.http;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class CodecsKt$encodeURLParameter$1$1 extends Lambda implements Function1<Byte, Unit> {
    final /* synthetic */ boolean $spaceToPlus;
    final /* synthetic */ StringBuilder $this_buildString;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CodecsKt$encodeURLParameter$1$1(StringBuilder sb, boolean z) {
        super(1);
        this.$this_buildString = sb;
        this.$spaceToPlus = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).byteValue());
        return Unit.INSTANCE;
    }

    public final void invoke(byte b) {
        if (CodecsKt.f8940a.contains(Byte.valueOf(b)) || CodecsKt.g.contains(Byte.valueOf(b))) {
            this.$this_buildString.append((char) b);
        } else if (!this.$spaceToPlus || b != 32) {
            this.$this_buildString.append(CodecsKt.u(b));
        } else {
            this.$this_buildString.append('+');
        }
    }
}
