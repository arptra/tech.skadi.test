package kotlin.comparisons;

import java.util.Comparator;

public final /* synthetic */ class b implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Comparator f3700a;
    public final /* synthetic */ Comparator b;

    public /* synthetic */ b(Comparator comparator, Comparator comparator2) {
        this.f3700a = comparator;
        this.b = comparator2;
    }

    public final int compare(Object obj, Object obj2) {
        return ComparisonsKt__ComparisonsKt.thenDescending$lambda$2$ComparisonsKt__ComparisonsKt(this.f3700a, this.b, obj, obj2);
    }
}
