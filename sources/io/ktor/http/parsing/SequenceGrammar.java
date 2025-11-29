package io.ktor.http.parsing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u00038\u0016X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t¨\u0006\u000b"}, d2 = {"Lio/ktor/http/parsing/SequenceGrammar;", "Lio/ktor/http/parsing/Grammar;", "Lio/ktor/http/parsing/ComplexGrammar;", "", "sourceGrammars", "<init>", "(Ljava/util/List;)V", "a", "Ljava/util/List;", "()Ljava/util/List;", "grammars", "ktor-http"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nParserDsl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ParserDsl.kt\nio/ktor/http/parsing/SequenceGrammar\n+ 2 ParserDsl.kt\nio/ktor/http/parsing/ParserDslKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,63:1\n57#2,2:64\n59#2,2:67\n61#2:70\n1855#3:66\n1856#3:69\n*S KotlinDebug\n*F\n+ 1 ParserDsl.kt\nio/ktor/http/parsing/SequenceGrammar\n*L\n29#1:64,2\n29#1:67,2\n29#1:70\n29#1:66\n29#1:69\n*E\n"})
public final class SequenceGrammar extends Grammar implements ComplexGrammar {

    /* renamed from: a  reason: collision with root package name */
    public final List f9010a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SequenceGrammar(List list) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(list, "sourceGrammars");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Grammar grammar = (Grammar) it.next();
            if (grammar instanceof SequenceGrammar) {
                CollectionsKt.addAll(arrayList, ((ComplexGrammar) grammar).a());
            } else {
                arrayList.add(grammar);
            }
        }
        this.f9010a = arrayList;
    }

    public List a() {
        return this.f9010a;
    }
}
