package io.ktor.http.parsing;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\b¨\u0006\n"}, d2 = {"Lio/ktor/http/parsing/GrammarBuilder;", "", "<init>", "()V", "Lio/ktor/http/parsing/Grammar;", "a", "()Lio/ktor/http/parsing/Grammar;", "", "Ljava/util/List;", "grammars", "ktor-http"}, k = 1, mv = {1, 8, 0})
public final class GrammarBuilder {

    /* renamed from: a  reason: collision with root package name */
    public final List f9003a = new ArrayList();

    public final Grammar a() {
        return this.f9003a.size() == 1 ? (Grammar) CollectionsKt.first(this.f9003a) : new SequenceGrammar(this.f9003a);
    }
}
