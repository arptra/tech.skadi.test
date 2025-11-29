package kotlin.comparisons;

import java.util.Comparator;

public final /* synthetic */ class c implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Comparator f3701a;
    public final /* synthetic */ Comparator b;

    public /* synthetic */ c(Comparator comparator, Comparator comparator2) {
        this.f3701a = comparator;
        this.b = comparator2;
    }

    public final int compare(Object obj, Object obj2) {
        return ComparisonsKt__ComparisonsKt.then$lambda$1$ComparisonsKt__ComparisonsKt(this.f3701a, this.b, obj, obj2);
    }
}
