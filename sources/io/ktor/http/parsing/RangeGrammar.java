package io.ktor.http.parsing;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"Lio/ktor/http/parsing/RangeGrammar;", "Lio/ktor/http/parsing/Grammar;", "", "from", "to", "<init>", "(CC)V", "a", "C", "c", "()C", "b", "d", "ktor-http"}, k = 1, mv = {1, 8, 0})
public final class RangeGrammar extends Grammar {

    /* renamed from: a  reason: collision with root package name */
    public final char f9008a;
    public final char b;

    public RangeGrammar(char c, char c2) {
        super((DefaultConstructorMarker) null);
        this.f9008a = c;
        this.b = c2;
    }

    public final char c() {
        return this.f9008a;
    }

    public final char d() {
        return this.b;
    }
}
