package kotlin.comparisons;

import java.util.Comparator;

public final /* synthetic */ class e implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Comparator f3703a;

    public /* synthetic */ e(Comparator comparator) {
        this.f3703a = comparator;
    }

    public final int compare(Object obj, Object obj2) {
        return ComparisonsKt__ComparisonsKt.nullsFirst$lambda$3$ComparisonsKt__ComparisonsKt(this.f3703a, obj, obj2);
    }
}
