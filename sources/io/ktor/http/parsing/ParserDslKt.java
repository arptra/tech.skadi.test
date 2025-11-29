package io.ktor.http.parsing;

import com.honey.account.constant.AccountConstantKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\f\n\u0002\b\u0004\u001a\u0017\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001c\u0010\u0005\u001a\u00020\u0000*\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0000H\u0004¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001c\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a\u001c\u0010\n\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\t\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\n\u0010\u000b\u001a\u001c\u0010\f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0004¢\u0006\u0004\b\f\u0010\b\u001a\u001c\u0010\r\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\t\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\r\u0010\u000b\u001a\u0017\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u000e\u0010\u0003\u001a\u001c\u0010\u0011\u001a\u00020\u0000*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0004¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lio/ktor/http/parsing/Grammar;", "grammar", "b", "(Lio/ktor/http/parsing/Grammar;)Lio/ktor/http/parsing/Grammar;", "", "g", "(Ljava/lang/String;Lio/ktor/http/parsing/Grammar;)Lio/ktor/http/parsing/Grammar;", "e", "(Lio/ktor/http/parsing/Grammar;Lio/ktor/http/parsing/Grammar;)Lio/ktor/http/parsing/Grammar;", "value", "f", "(Lio/ktor/http/parsing/Grammar;Ljava/lang/String;)Lio/ktor/http/parsing/Grammar;", "c", "d", "a", "", "other", "h", "(CC)Lio/ktor/http/parsing/Grammar;", "ktor-http"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nParserDsl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ParserDsl.kt\nio/ktor/http/parsing/ParserDslKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,63:1\n1855#2,2:64\n*S KotlinDebug\n*F\n+ 1 ParserDsl.kt\nio/ktor/http/parsing/ParserDslKt\n*L\n58#1:64,2\n*E\n"})
public final class ParserDslKt {
    public static final Grammar a(Grammar grammar) {
        Intrinsics.checkNotNullParameter(grammar, "grammar");
        return new AtLeastOne(grammar);
    }

    public static final Grammar b(Grammar grammar) {
        Intrinsics.checkNotNullParameter(grammar, "grammar");
        return new MaybeGrammar(grammar);
    }

    public static final Grammar c(Grammar grammar, Grammar grammar2) {
        Intrinsics.checkNotNullParameter(grammar, "<this>");
        Intrinsics.checkNotNullParameter(grammar2, "grammar");
        return new OrGrammar(CollectionsKt.listOf(grammar, grammar2));
    }

    public static final Grammar d(Grammar grammar, String str) {
        Intrinsics.checkNotNullParameter(grammar, "<this>");
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.RESPONSE_VALUE);
        return c(grammar, new StringGrammar(str));
    }

    public static final Grammar e(Grammar grammar, Grammar grammar2) {
        Intrinsics.checkNotNullParameter(grammar, "<this>");
        Intrinsics.checkNotNullParameter(grammar2, "grammar");
        return new SequenceGrammar(CollectionsKt.listOf(grammar, grammar2));
    }

    public static final Grammar f(Grammar grammar, String str) {
        Intrinsics.checkNotNullParameter(grammar, "<this>");
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.RESPONSE_VALUE);
        return e(grammar, new StringGrammar(str));
    }

    public static final Grammar g(String str, Grammar grammar) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(grammar, "grammar");
        return e(new StringGrammar(str), grammar);
    }

    public static final Grammar h(char c, char c2) {
        return new RangeGrammar(c, c2);
    }
}
