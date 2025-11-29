package io.ktor.http.parsing;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0003\u001a\u00020\u00018\u0016X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lio/ktor/http/parsing/AtLeastOne;", "Lio/ktor/http/parsing/Grammar;", "Lio/ktor/http/parsing/SimpleGrammar;", "grammar", "<init>", "(Lio/ktor/http/parsing/Grammar;)V", "a", "Lio/ktor/http/parsing/Grammar;", "b", "()Lio/ktor/http/parsing/Grammar;", "ktor-http"}, k = 1, mv = {1, 8, 0})
public final class AtLeastOne extends Grammar implements SimpleGrammar {

    /* renamed from: a  reason: collision with root package name */
    public final Grammar f9002a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AtLeastOne(Grammar grammar) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(grammar, "grammar");
        this.f9002a = grammar;
    }

    public Grammar b() {
        return this.f9002a;
    }
}
