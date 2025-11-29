package io.ktor.http.parsing;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/ktor/http/parsing/Grammar;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class ParserDslKt$maybe$1 extends Lambda implements Function0<Grammar> {
    final /* synthetic */ Function1<GrammarBuilder, Unit> $block;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ParserDslKt$maybe$1(Function1<? super GrammarBuilder, Unit> function1) {
        super(0);
        this.$block = function1;
    }

    @NotNull
    public final Grammar invoke() {
        GrammarBuilder grammarBuilder = new GrammarBuilder();
        this.$block.invoke(grammarBuilder);
        return ParserDslKt.b(grammarBuilder.a());
    }
}
