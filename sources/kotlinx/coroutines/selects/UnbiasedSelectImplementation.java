package kotlinx.coroutines.selects;

import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.selects.SelectImplementation;

@SourceDebugExtension({"SMAP\nSelectUnbiased.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SelectUnbiased.kt\nkotlinx/coroutines/selects/UnbiasedSelectImplementation\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,68:1\n1855#2,2:69\n*S KotlinDebug\n*F\n+ 1 SelectUnbiased.kt\nkotlinx/coroutines/selects/UnbiasedSelectImplementation\n*L\n63#1:69,2\n*E\n"})
@PublishedApi
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0011\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002J5\u0010\t\u001a\u00020\b*\u00020\u00032\u001c\u0010\u0007\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJG\u0010\u000e\u001a\u00020\b\"\u0004\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00010\f2\"\u0010\u0007\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\rH\u0002ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0010\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0012\u0010\u0013R$\u0010\u0018\u001a\u0012\u0012\u000e\u0012\f0\u0015R\b\u0012\u0004\u0012\u00028\u00000\u00020\u00148\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/selects/UnbiasedSelectImplementation;", "R", "Lkotlinx/coroutines/selects/SelectImplementation;", "Lkotlinx/coroutines/selects/SelectClause0;", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "block", "", "a", "(Lkotlinx/coroutines/selects/SelectClause0;Lkotlin/jvm/functions/Function1;)V", "Q", "Lkotlinx/coroutines/selects/SelectClause1;", "Lkotlin/Function2;", "f", "(Lkotlinx/coroutines/selects/SelectClause1;Lkotlin/jvm/functions/Function2;)V", "p", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "C", "()V", "", "Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;", "g", "Ljava/util/List;", "clausesToRegister", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
public class UnbiasedSelectImplementation<R> extends SelectImplementation<R> {
    public final List g;

    public final void C() {
        try {
            Collections.shuffle(this.g);
            for (SelectImplementation.ClauseData w : this.g) {
                SelectImplementation.w(this, w, false, 1, (Object) null);
            }
        } finally {
            this.g.clear();
        }
    }

    public void a(SelectClause0 selectClause0, Function1 function1) {
        this.g.add(new SelectImplementation.ClauseData(selectClause0.d(), selectClause0.c(), selectClause0.b(), SelectKt.i(), function1, selectClause0.a()));
    }

    public void f(SelectClause1 selectClause1, Function2 function2) {
        this.g.add(new SelectImplementation.ClauseData(selectClause1.d(), selectClause1.c(), selectClause1.b(), (Object) null, function2, selectClause1.a()));
    }

    public Object p(Continuation continuation) {
        return C();
    }
}
