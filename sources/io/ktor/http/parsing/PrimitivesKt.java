package io.ktor.http.parsing;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u0014\u0010\u0003\u001a\u00020\u00008@X\u0004¢\u0006\u0006\u001a\u0004\b\u0001\u0010\u0002\"\u0014\u0010\u0007\u001a\u00020\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u0014\u0010\t\u001a\u00020\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006\n"}, d2 = {"Lio/ktor/http/parsing/RawGrammar;", "a", "()Lio/ktor/http/parsing/RawGrammar;", "digit", "Lio/ktor/http/parsing/Grammar;", "c", "()Lio/ktor/http/parsing/Grammar;", "hex", "b", "digits", "ktor-http"}, k = 2, mv = {1, 8, 0})
public final class PrimitivesKt {
    public static final RawGrammar a() {
        return new RawGrammar("\\d");
    }

    public static final Grammar b() {
        return ParserDslKt.a(a());
    }

    public static final Grammar c() {
        return ParserDslKt.c(ParserDslKt.c(a(), ParserDslKt.h('A', 'F')), ParserDslKt.h('a', 'f'));
    }
}
